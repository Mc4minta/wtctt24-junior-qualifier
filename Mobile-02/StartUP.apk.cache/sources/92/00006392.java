package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.tls.TlsProtocol;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class TlsServerProtocol extends TlsProtocol {
    protected CertificateRequest certificateRequest;
    protected short clientCertificateType;
    protected TlsKeyExchange keyExchange;
    protected TlsHandshakeHash prepareFinishHash;
    protected TlsCredentials serverCredentials;
    protected TlsServer tlsServer;
    TlsServerContextImpl tlsServerContext;

    public TlsServerProtocol(InputStream inputStream, OutputStream outputStream, SecureRandom secureRandom) {
        super(inputStream, outputStream, secureRandom);
        this.tlsServer = null;
        this.tlsServerContext = null;
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.clientCertificateType = (short) -1;
        this.prepareFinishHash = null;
    }

    public void accept(TlsServer tlsServer) throws IOException {
        if (tlsServer != null) {
            if (this.tlsServer == null) {
                this.tlsServer = tlsServer;
                SecurityParameters securityParameters = new SecurityParameters();
                this.securityParameters = securityParameters;
                securityParameters.entity = 0;
                this.tlsServerContext = new TlsServerContextImpl(this.secureRandom, this.securityParameters);
                this.securityParameters.serverRandom = TlsProtocol.createRandomBlock(tlsServer.shouldUseGMTUnixTime(), this.tlsServerContext.getNonceRandomGenerator());
                this.tlsServer.init(this.tlsServerContext);
                this.recordStream.init(this.tlsServerContext);
                this.recordStream.setRestrictReadVersion(false);
                blockForHandshake();
                return;
            }
            throw new IllegalStateException("'accept' can only be called once");
        }
        throw new IllegalArgumentException("'tlsServer' cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void cleanupHandshake() {
        super.cleanupHandshake();
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.prepareFinishHash = null;
    }

    protected boolean expectCertificateVerifyMessage() {
        short s = this.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    protected TlsContext getContext() {
        return this.tlsServerContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    AbstractTlsContext getContextAdmin() {
        return this.tlsServerContext;
    }

    @Override // org.spongycastle.crypto.tls.TlsProtocol
    protected TlsPeer getPeer() {
        return this.tlsServer;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void handleHandshakeMessage(short r10, byte[] r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.crypto.tls.TlsServerProtocol.handleHandshakeMessage(short, byte[]):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.tls.TlsProtocol
    public void handleWarningMessage(short s) throws IOException {
        if (s != 41) {
            super.handleWarningMessage(s);
        } else if (!TlsUtils.isSSL(getContext()) || this.certificateRequest == null) {
        } else {
            notifyClientCertificate(Certificate.EMPTY_CHAIN);
        }
    }

    protected void notifyClientCertificate(Certificate certificate) throws IOException {
        if (this.certificateRequest != null) {
            if (this.peerCertificate == null) {
                this.peerCertificate = certificate;
                if (certificate.isEmpty()) {
                    this.keyExchange.skipClientCredentials();
                } else {
                    this.clientCertificateType = TlsUtils.getClientCertificateType(certificate, this.serverCredentials.getCertificate());
                    this.keyExchange.processClientCertificate(certificate);
                }
                this.tlsServer.notifyClientCertificate(certificate);
                return;
            }
            throw new TlsFatalAlert((short) 10);
        }
        throw new IllegalStateException();
    }

    protected void receiveCertificateMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(parse);
    }

    protected void receiveCertificateVerifyMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        byte[] sessionHash;
        if (this.certificateRequest != null) {
            DigitallySigned parse = DigitallySigned.parse(getContext(), byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            try {
                SignatureAndHashAlgorithm algorithm = parse.getAlgorithm();
                if (TlsUtils.isTLSv12(getContext())) {
                    TlsUtils.verifySupportedSignatureAlgorithm(this.certificateRequest.getSupportedSignatureAlgorithms(), algorithm);
                    sessionHash = this.prepareFinishHash.getFinalHash(algorithm.getHash());
                } else {
                    sessionHash = this.securityParameters.getSessionHash();
                }
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(this.peerCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
                TlsSigner createTlsSigner = TlsUtils.createTlsSigner(this.clientCertificateType);
                createTlsSigner.init(getContext());
                if (createTlsSigner.verifyRawSignature(algorithm, parse.getSignature(), createKey, sessionHash)) {
                    return;
                }
                throw new TlsFatalAlert((short) 51);
            } catch (TlsFatalAlert e2) {
                throw e2;
            } catch (Exception e3) {
                throw new TlsFatalAlert((short) 51, e3);
            }
        }
        throw new IllegalStateException();
    }

    protected void receiveClientHelloMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        this.recordStream.setWriteVersion(readVersion);
        if (!readVersion.isDTLS()) {
            byte[] readFully = TlsUtils.readFully(32, byteArrayInputStream);
            if (TlsUtils.readOpaque8(byteArrayInputStream).length <= 32) {
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (readUint16 >= 2 && (readUint16 & 1) == 0) {
                    this.offeredCipherSuites = TlsUtils.readUint16Array(readUint16 / 2, byteArrayInputStream);
                    short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                    if (readUint8 >= 1) {
                        this.offeredCompressionMethods = TlsUtils.readUint8Array(readUint8, byteArrayInputStream);
                        Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                        this.clientExtensions = readExtensions;
                        this.securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(readExtensions);
                        getContextAdmin().setClientVersion(readVersion);
                        this.tlsServer.notifyClientVersion(readVersion);
                        this.tlsServer.notifyFallback(Arrays.contains(this.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV));
                        this.securityParameters.clientRandom = readFully;
                        this.tlsServer.notifyOfferedCipherSuites(this.offeredCipherSuites);
                        this.tlsServer.notifyOfferedCompressionMethods(this.offeredCompressionMethods);
                        if (Arrays.contains(this.offeredCipherSuites, 255)) {
                            this.secure_renegotiation = true;
                        }
                        byte[] extensionData = TlsUtils.getExtensionData(this.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
                        if (extensionData != null) {
                            this.secure_renegotiation = true;
                            if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                                throw new TlsFatalAlert((short) 40);
                            }
                        }
                        this.tlsServer.notifySecureRenegotiation(this.secure_renegotiation);
                        Hashtable hashtable = this.clientExtensions;
                        if (hashtable != null) {
                            this.tlsServer.processClientExtensions(hashtable);
                            return;
                        }
                        return;
                    }
                    throw new TlsFatalAlert((short) 47);
                }
                throw new TlsFatalAlert((short) 50);
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new TlsFatalAlert((short) 47);
    }

    protected void receiveClientKeyExchangeMessage(ByteArrayInputStream byteArrayInputStream) throws IOException {
        this.keyExchange.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        this.prepareFinishHash = this.recordStream.prepareToFinish();
        this.securityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(getContext(), this.prepareFinishHash, null);
        TlsProtocol.establishMasterSecret(getContext(), this.keyExchange);
        this.recordStream.setPendingConnectionState(getPeer().getCompression(), getPeer().getCipher());
        if (this.expectSessionTicket) {
            return;
        }
        sendChangeCipherSpecMessage();
    }

    protected void sendCertificateRequestMessage(CertificateRequest certificateRequest) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 13);
        certificateRequest.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    protected void sendCertificateStatusMessage(CertificateStatus certificateStatus) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 22);
        certificateStatus.encode(handshakeMessage);
        handshakeMessage.writeToRecordStream();
    }

    protected void sendNewSessionTicketMessage(NewSessionTicket newSessionTicket) throws IOException {
        if (newSessionTicket != null) {
            TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 4);
            newSessionTicket.encode(handshakeMessage);
            handshakeMessage.writeToRecordStream();
            return;
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected void sendServerHelloDoneMessage() throws IOException {
        byte[] bArr = new byte[4];
        TlsUtils.writeUint8((short) 14, bArr, 0);
        TlsUtils.writeUint24(0, bArr, 1);
        writeHandshakeMessage(bArr, 0, 4);
    }

    protected void sendServerHelloMessage() throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage(this, (short) 2);
        ProtocolVersion serverVersion = this.tlsServer.getServerVersion();
        if (serverVersion.isEqualOrEarlierVersionOf(getContext().getClientVersion())) {
            this.recordStream.setReadVersion(serverVersion);
            this.recordStream.setWriteVersion(serverVersion);
            boolean z = true;
            this.recordStream.setRestrictReadVersion(true);
            getContextAdmin().setServerVersion(serverVersion);
            TlsUtils.writeVersion(serverVersion, handshakeMessage);
            handshakeMessage.write(this.securityParameters.serverRandom);
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            TlsUtils.writeOpaque8(bArr, handshakeMessage);
            int selectedCipherSuite = this.tlsServer.getSelectedCipherSuite();
            if (Arrays.contains(this.offeredCipherSuites, selectedCipherSuite) && selectedCipherSuite != 0 && !CipherSuite.isSCSV(selectedCipherSuite) && TlsUtils.isValidCipherSuiteForVersion(selectedCipherSuite, getContext().getServerVersion())) {
                this.securityParameters.cipherSuite = selectedCipherSuite;
                short selectedCompressionMethod = this.tlsServer.getSelectedCompressionMethod();
                if (Arrays.contains(this.offeredCompressionMethods, selectedCompressionMethod)) {
                    this.securityParameters.compressionAlgorithm = selectedCompressionMethod;
                    TlsUtils.writeUint16(selectedCipherSuite, handshakeMessage);
                    TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) handshakeMessage);
                    Hashtable serverExtensions = this.tlsServer.getServerExtensions();
                    this.serverExtensions = serverExtensions;
                    if (this.secure_renegotiation) {
                        Integer num = TlsProtocol.EXT_RenegotiationInfo;
                        if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                            Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                            this.serverExtensions = ensureExtensionsInitialised;
                            ensureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(bArr));
                        }
                    }
                    if (this.securityParameters.extendedMasterSecret) {
                        Hashtable ensureExtensionsInitialised2 = TlsExtensionsUtils.ensureExtensionsInitialised(this.serverExtensions);
                        this.serverExtensions = ensureExtensionsInitialised2;
                        TlsExtensionsUtils.addExtendedMasterSecretExtension(ensureExtensionsInitialised2);
                    }
                    Hashtable hashtable = this.serverExtensions;
                    if (hashtable != null) {
                        this.securityParameters.encryptThenMAC = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable);
                        this.securityParameters.maxFragmentLength = processMaxFragmentLengthExtension(this.clientExtensions, this.serverExtensions, (short) 80);
                        this.securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(this.serverExtensions);
                        this.allowCertificateStatus = !this.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short) 80);
                        if (this.resumedSession || !TlsUtils.hasExpectedEmptyExtensionData(this.serverExtensions, TlsProtocol.EXT_SessionTicket, (short) 80)) {
                            z = false;
                        }
                        this.expectSessionTicket = z;
                        TlsProtocol.writeExtensions(handshakeMessage, this.serverExtensions);
                    }
                    this.securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(getContext(), this.securityParameters.getCipherSuite());
                    this.securityParameters.verifyDataLength = 12;
                    applyMaxFragmentLengthExtension();
                    handshakeMessage.writeToRecordStream();
                    return;
                }
                throw new TlsFatalAlert((short) 80);
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected void sendServerKeyExchangeMessage(byte[] bArr) throws IOException {
        TlsProtocol.HandshakeMessage handshakeMessage = new TlsProtocol.HandshakeMessage((short) 12, bArr.length);
        handshakeMessage.write(bArr);
        handshakeMessage.writeToRecordStream();
    }

    public TlsServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
        this.tlsServer = null;
        this.tlsServerContext = null;
        this.keyExchange = null;
        this.serverCredentials = null;
        this.certificateRequest = null;
        this.clientCertificateType = (short) -1;
        this.prepareFinishHash = null;
    }
}