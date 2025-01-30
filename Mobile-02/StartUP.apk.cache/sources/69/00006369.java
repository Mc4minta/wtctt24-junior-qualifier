package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsClientProtocol extends TlsProtocol {
    protected TlsAuthentication authentication;
    protected CertificateRequest certificateRequest;
    protected CertificateStatus certificateStatus;
    protected TlsKeyExchange keyExchange;
    protected byte[] selectedSessionID;
    protected TlsClient tlsClient;
    TlsClientContextImpl tlsClientContext;

    public TlsClientProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
        this.tlsClient = null;
        this.tlsClientContext = null;
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }

    public void connect(TlsClient tlsClient) throws IOException {
        SessionParameters exportSessionParameters;
        if (tlsClient != null) {
            if (this.tlsClient == null) {
                this.tlsClient = tlsClient;
                SecurityParameters securityParameters = new SecurityParameters();
                this.securityParameters = securityParameters;
                securityParameters.entity = 1;
                this.tlsClientContext = new TlsClientContextImpl(this.secureRandom, this.securityParameters);
                this.securityParameters.clientRandom = TlsProtocol.createRandomBlock(tlsClient.shouldUseGMTUnixTime(), this.tlsClientContext.getNonceRandomGenerator());
                this.tlsClient.init(this.tlsClientContext);
                this.recordStream.init(this.tlsClientContext);
                TlsSession sessionToResume = tlsClient.getSessionToResume();
                if (sessionToResume != null && sessionToResume.isResumable() && (exportSessionParameters = sessionToResume.exportSessionParameters()) != null) {
                    this.tlsSession = sessionToResume;
                    this.sessionParameters = exportSessionParameters;
                }
                sendClientHelloMessage();
                this.connection_state = (short) 1;
                blockForHandshake();
                return;
            }
            throw new IllegalStateException("'connect' can only be called once");
        }
        throw new IllegalArgumentException("'tlsClient' cannot be null");
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    protected TlsContext getContext() {
        return this.tlsClientContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    AbstractTlsContext getContextAdmin() {
        return this.tlsClientContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    protected TlsPeer getPeer() {
        return this.tlsClient;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    protected void handleHandshakeMessage(short s, byte[] bArr) throws IOException {
        TlsCredentials clientCredentials;
        byte[] finalHash;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        if (this.resumedSession) {
            if (s == 20 && this.connection_state == 2) {
                processFinishedMessage(byteArrayInputStream);
                this.connection_state = (short) 15;
                sendFinishedMessage();
                this.connection_state = (short) 13;
                this.connection_state = (short) 16;
                completeHandshake();
                return;
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s == 0) {
            TlsProtocol.assertEmpty(byteArrayInputStream);
            if (this.connection_state == 16) {
                refuseRenegotiation();
            }
        } else if (s == 2) {
            if (this.connection_state == 1) {
                receiveServerHelloMessage(byteArrayInputStream);
                this.connection_state = (short) 2;
                this.recordStream.notifyHelloComplete();
                applyMaxFragmentLengthExtension();
                if (this.resumedSession) {
                    this.securityParameters.masterSecret = Arrays.clone(this.sessionParameters.getMasterSecret());
                    this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
                    sendChangeCipherSpecMessage();
                    return;
                }
                invalidateSession();
                byte[] bArr2 = this.selectedSessionID;
                if (bArr2.length > 0) {
                    this.tlsSession = new TlsSessionImpl(bArr2, null);
                    return;
                }
                return;
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s == 4) {
            if (this.connection_state == 13) {
                if (this.expectSessionTicket) {
                    invalidateSession();
                    receiveNewSessionTicketMessage(byteArrayInputStream);
                    this.connection_state = (short) 14;
                    return;
                }
                throw new TlsFatalAlert((short) 10);
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s == 20) {
            short s2 = this.connection_state;
            if (s2 != 13) {
                if (s2 != 14) {
                    throw new TlsFatalAlert((short) 10);
                }
            } else if (this.expectSessionTicket) {
                throw new TlsFatalAlert((short) 10);
            }
            processFinishedMessage(byteArrayInputStream);
            this.connection_state = (short) 15;
            this.connection_state = (short) 16;
            completeHandshake();
        } else if (s == 22) {
            if (this.connection_state == 4) {
                if (this.allowCertificateStatus) {
                    this.certificateStatus = CertificateStatus.parse(byteArrayInputStream);
                    TlsProtocol.assertEmpty(byteArrayInputStream);
                    this.connection_state = (short) 5;
                    return;
                }
                throw new TlsFatalAlert((short) 10);
            }
            throw new TlsFatalAlert((short) 10);
        } else if (s != 23) {
            switch (s) {
                case 11:
                    short s3 = this.connection_state;
                    if (s3 == 2) {
                        handleSupplementalData(null);
                    } else if (s3 != 3) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    this.peerCertificate = Certificate.parse(byteArrayInputStream);
                    TlsProtocol.assertEmpty(byteArrayInputStream);
                    Certificate certificate = this.peerCertificate;
                    if (certificate == null || certificate.isEmpty()) {
                        this.allowCertificateStatus = false;
                    }
                    this.keyExchange.processServerCertificate(this.peerCertificate);
                    TlsAuthentication authentication = this.tlsClient.getAuthentication();
                    this.authentication = authentication;
                    authentication.notifyServerCertificate(this.peerCertificate);
                    this.connection_state = (short) 4;
                    return;
                case 12:
                    short s4 = this.connection_state;
                    if (s4 == 2) {
                        handleSupplementalData(null);
                    } else if (s4 != 3) {
                        if (s4 != 4 && s4 != 5) {
                            throw new TlsFatalAlert((short) 10);
                        }
                        this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                        TlsProtocol.assertEmpty(byteArrayInputStream);
                        this.connection_state = (short) 6;
                        return;
                    }
                    this.keyExchange.skipServerCredentials();
                    this.authentication = null;
                    this.keyExchange.processServerKeyExchange(byteArrayInputStream);
                    TlsProtocol.assertEmpty(byteArrayInputStream);
                    this.connection_state = (short) 6;
                    return;
                case 13:
                    short s5 = this.connection_state;
                    if (s5 == 4 || s5 == 5) {
                        this.keyExchange.skipServerKeyExchange();
                    } else if (s5 != 6) {
                        throw new TlsFatalAlert((short) 10);
                    }
                    if (this.authentication != null) {
                        this.certificateRequest = CertificateRequest.parse(getContext(), byteArrayInputStream);
                        TlsProtocol.assertEmpty(byteArrayInputStream);
                        this.keyExchange.validateCertificateRequest(this.certificateRequest);
                        TlsUtils.trackHashAlgorithms(this.recordStream.getHandshakeHash(), this.certificateRequest.getSupportedSignatureAlgorithms());
                        this.connection_state = (short) 7;
                        return;
                    }
                    throw new TlsFatalAlert((short) 40);
                case 14:
                    switch (this.connection_state) {
                        case 2:
                            handleSupplementalData(null);
                        case 3:
                            this.keyExchange.skipServerCredentials();
                            this.authentication = null;
                        case 4:
                        case 5:
                            this.keyExchange.skipServerKeyExchange();
                            break;
                        case 6:
                        case 7:
                            break;
                        default:
                            throw new TlsFatalAlert((short) 40);
                    }
                    TlsProtocol.assertEmpty(byteArrayInputStream);
                    this.connection_state = (short) 8;
                    this.recordStream.getHandshakeHash().sealHashAlgorithms();
                    Vector clientSupplementalData = this.tlsClient.getClientSupplementalData();
                    if (clientSupplementalData != null) {
                        sendSupplementalDataMessage(clientSupplementalData);
                    }
                    this.connection_state = (short) 9;
                    CertificateRequest certificateRequest = this.certificateRequest;
                    if (certificateRequest == null) {
                        this.keyExchange.skipClientCredentials();
                        clientCredentials = null;
                    } else {
                        clientCredentials = this.authentication.getClientCredentials(certificateRequest);
                        if (clientCredentials == null) {
                            this.keyExchange.skipClientCredentials();
                            sendCertificateMessage(Certificate.EMPTY_CHAIN);
                        } else {
                            this.keyExchange.processClientCredentials(clientCredentials);
                            sendCertificateMessage(clientCredentials.getCertificate());
                        }
                    }
                    this.connection_state = (short) 10;
                    sendClientKeyExchangeMessage();
                    this.connection_state = (short) 11;
                    TlsHandshakeHash prepareToFinish = this.recordStream.prepareToFinish();
                    this.securityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(getContext(), prepareToFinish, null);
                    TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
                    this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
                    if (clientCredentials != null && (clientCredentials instanceof TlsSignerCredentials)) {
                        TlsSignerCredentials tlsSignerCredentials = (TlsSignerCredentials) clientCredentials;
                        SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(getContext(), tlsSignerCredentials);
                        if (signatureAndHashAlgorithm == null) {
                            finalHash = this.securityParameters.getSessionHash();
                        } else {
                            finalHash = prepareToFinish.getFinalHash(signatureAndHashAlgorithm.getHash());
                        }
                        sendCertificateVerifyMessage(new DigitallySigned(signatureAndHashAlgorithm, tlsSignerCredentials.generateCertificateSignature(finalHash)));
                        this.connection_state = (short) 12;
                    }
                    sendChangeCipherSpecMessage();
                    sendFinishedMessage();
                    this.connection_state = (short) 13;
                    return;
                default:
                    throw new TlsFatalAlert((short) 10);
            }
        } else if (this.connection_state == 2) {
            handleSupplementalData(TlsProtocol.readSupplementalDataMessage(byteArrayInputStream));
        } else {
            throw new TlsFatalAlert((short) 10);
        }
    }

    protected void handleSupplementalData(Vector vector) throws IOException {
        this.tlsClient.processServerSupplementalData(vector);
        this.connection_state = (short) 3;
        TlsKeyExchange keyExchange = this.tlsClient.getKeyExchange();
        this.keyExchange = keyExchange;
        keyExchange.init(getContext());
    }

    protected void receiveNewSessionTicketMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        this.tlsClient.notifyNewSessionTicket(parse);
    }

    protected void receiveServerHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        TlsSession tlsSession;
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (!readVersion.isDTLS()) {
            if (readVersion.equals(this.recordStream.getReadVersion())) {
                if (readVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
                    this.recordStream.setWriteVersion(readVersion);
                    getContextAdmin().setServerVersion(readVersion);
                    this.tlsClient.notifyServerVersion(readVersion);
                    this.securityParameters.serverRandom = TlsUtils.readFully(32, byteArrayInputStream);
                    byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
                    this.selectedSessionID = readOpaque8;
                    if (readOpaque8.length <= 32) {
                        this.tlsClient.notifySessionID(readOpaque8);
                        byte[] bArr = this.selectedSessionID;
                        boolean z = false;
                        this.resumedSession = bArr.length > 0 && (tlsSession = this.tlsSession) != null && Arrays.areEqual(bArr, tlsSession.getSessionID());
                        int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                        if (Arrays.contains(this.offeredCipherSuites, readUint16) && readUint16 != 0 && !CipherSuite.isSCSV(readUint16) && TlsUtils.isValidCipherSuiteForVersion(readUint16, getContext().getServerVersion())) {
                            this.tlsClient.notifySelectedCipherSuite(readUint16);
                            short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                            if (Arrays.contains(this.offeredCompressionMethods, readUint8)) {
                                this.tlsClient.notifySelectedCompressionMethod(readUint8);
                                Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                                this.serverExtensions = readExtensions;
                                if (readExtensions != null) {
                                    Enumeration keys = readExtensions.keys();
                                    while (keys.hasMoreElements()) {
                                        Integer num = (Integer) keys.nextElement();
                                        if (!num.equals(TlsProtocol.EXT_RenegotiationInfo) && TlsUtils.getExtensionData(this.clientExtensions, num) == null) {
                                            throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                                        }
                                    }
                                }
                                byte[] extensionData = TlsUtils.getExtensionData(this.serverExtensions, TlsProtocol.EXT_RenegotiationInfo);
                                if (extensionData != null) {
                                    this.secure_renegotiation = true;
                                    if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                                        throw new TlsFatalAlert((short) 40);
                                    }
                                }
                                this.tlsClient.notifySecureRenegotiation(this.secure_renegotiation);
                                Hashtable hashtable = this.clientExtensions;
                                Hashtable hashtable2 = this.serverExtensions;
                                if (this.resumedSession) {
                                    if (readUint16 == this.sessionParameters.getCipherSuite() && readUint8 == this.sessionParameters.getCompressionAlgorithm()) {
                                        hashtable = null;
                                        hashtable2 = this.sessionParameters.readServerExtensions();
                                    } else {
                                        throw new TlsFatalAlert((short) 47);
                                    }
                                }
                                SecurityParameters securityParameters = this.securityParameters;
                                securityParameters.cipherSuite = readUint16;
                                securityParameters.compressionAlgorithm = readUint8;
                                if (hashtable2 != null) {
                                    boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                                    if (hasEncryptThenMACExtension && !TlsUtils.isBlockCipherSuite(readUint16)) {
                                        throw new TlsFatalAlert((short) 47);
                                    }
                                    SecurityParameters securityParameters2 = this.securityParameters;
                                    securityParameters2.encryptThenMAC = hasEncryptThenMACExtension;
                                    securityParameters2.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(hashtable2);
                                    this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(hashtable, hashtable2, (short) 47);
                                    this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                                    this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, (short) 47);
                                    if (!this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, (short) 47)) {
                                        z = true;
                                    }
                                    this.expectSessionTicket = z;
                                }
                                if (hashtable != null) {
                                    this.tlsClient.processServerExtensions(hashtable2);
                                }
                                this.securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                                this.securityParameters.verifyDataLength = 12;
                                return;
                            }
                            throw new TlsFatalAlert((short) 47);
                        }
                        throw new TlsFatalAlert((short) 47);
                    }
                    throw new TlsFatalAlert((short) 47);
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new TlsFatalAlert((short) 47);
    }

    protected void sendCertificateVerifyMessage(DigitallySigned digitallySigned) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 15);
        digitallySigned.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    protected void sendClientHelloMessage() throws IOException {
        byte[] bArr;
        SessionParameters sessionParameters;
        this.recordStream.setWriteVersion(this.tlsClient.getClientHelloRecordLayerVersion());
        ProtocolVersion clientVersion = this.tlsClient.getClientVersion();
        if (!clientVersion.isDTLS()) {
            getContextAdmin().setClientVersion(clientVersion);
            byte[] bArr2 = TlsUtils.EMPTY_BYTES;
            TlsSession tlsSession = this.tlsSession;
            if (tlsSession == null || (bArr = tlsSession.getSessionID()) == null || bArr.length > 32) {
                bArr = bArr2;
            }
            boolean isFallback = this.tlsClient.isFallback();
            this.offeredCipherSuites = this.tlsClient.getCipherSuites();
            this.offeredCompressionMethods = this.tlsClient.getCompressionMethods();
            if (bArr.length <= 0 || (sessionParameters = this.sessionParameters) == null || (Arrays.contains(this.offeredCipherSuites, sessionParameters.getCipherSuite()) && Arrays.contains(this.offeredCompressionMethods, this.sessionParameters.getCompressionAlgorithm()))) {
                bArr2 = bArr;
            }
            this.clientExtensions = this.tlsClient.getClientExtensions();
            TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 1);
            TlsUtils.writeVersion(clientVersion, handshakeMessage);
            handshakeMessage.write(this.securityParameters.getClientRandom());
            TlsUtils.writeOpaque8(bArr2, handshakeMessage);
            boolean z = TlsUtils.getExtensionData(this.clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(this.offeredCipherSuites, 255);
            if (z && z2) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, 255);
            }
            if (isFallback && !Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV)) {
                this.offeredCipherSuites = Arrays.append(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(this.offeredCipherSuites, handshakeMessage);
            TlsUtils.writeUint8ArrayWithUint8Length(this.offeredCompressionMethods, handshakeMessage);
            Hashtable hashtable = this.clientExtensions;
            if (hashtable != null) {
                TlsProtocol.writeExtensions(handshakeMessage, hashtable);
            }
            handshakeMessage.writeToRecordStream();
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected void sendClientKeyExchangeMessage() throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 16);
        this.keyExchange.generateClientKeyExchange(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    public TlsClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
        this.tlsClient = null;
        this.tlsClientContext = null;
        this.selectedSessionID = null;
        this.keyExchange = null;
        this.authentication = null;
        this.certificateStatus = null;
        this.certificateRequest = null;
    }
}