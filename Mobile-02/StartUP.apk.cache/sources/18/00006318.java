package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.tls.DTLSReliableHandshake;
import org.spongycastle.crypto.tls.SessionParameters;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class DTLSClientProtocol extends DTLSProtocol {

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class ClientHandshakeState {
        TlsClient client = null;
        TlsClientContextImpl clientContext = null;
        TlsSession tlsSession = null;
        SessionParameters sessionParameters = null;
        SessionParameters.Builder sessionParametersBuilder = null;
        int[] offeredCipherSuites = null;
        short[] offeredCompressionMethods = null;
        Hashtable clientExtensions = null;
        Hashtable serverExtensions = null;
        byte[] selectedSessionID = null;
        boolean resumedSession = false;
        boolean secure_renegotiation = false;
        boolean allowCertificateStatus = false;
        boolean expectSessionTicket = false;
        TlsKeyExchange keyExchange = null;
        TlsAuthentication authentication = null;
        CertificateStatus certificateStatus = null;
        CertificateRequest certificateRequest = null;
        TlsCredentials clientCredentials = null;

        protected ClientHandshakeState() {
        }
    }

    public DTLSClientProtocol(SecureRandom secureRandom) {
        super(secureRandom);
    }

    protected static byte[] patchClientHelloWithCookie(byte[] bArr, byte[] bArr2) throws IOException {
        int readUint8 = 35 + TlsUtils.readUint8(bArr, 34);
        int i2 = readUint8 + 1;
        byte[] bArr3 = new byte[bArr.length + bArr2.length];
        System.arraycopy(bArr, 0, bArr3, 0, readUint8);
        TlsUtils.checkUint8(bArr2.length);
        TlsUtils.writeUint8(bArr2.length, bArr3, readUint8);
        System.arraycopy(bArr2, 0, bArr3, i2, bArr2.length);
        System.arraycopy(bArr, i2, bArr3, bArr2.length + i2, bArr.length - i2);
        return bArr3;
    }

    protected DTLSTransport clientHandshake(ClientHandshakeState clientHandshakeState, DTLSRecordLayer dTLSRecordLayer) throws IOException {
        DTLSReliableHandshake.Message message;
        Certificate certificate;
        byte[] finalHash;
        SecurityParameters securityParameters = clientHandshakeState.clientContext.getSecurityParameters();
        DTLSReliableHandshake dTLSReliableHandshake = new DTLSReliableHandshake(clientHandshakeState.clientContext, dTLSRecordLayer);
        byte[] generateClientHello = generateClientHello(clientHandshakeState, clientHandshakeState.client);
        dTLSRecordLayer.setWriteVersion(ProtocolVersion.DTLSv10);
        dTLSReliableHandshake.sendMessage((short) 1, generateClientHello);
        DTLSReliableHandshake.Message receiveMessage = dTLSReliableHandshake.receiveMessage();
        while (receiveMessage.getType() == 3) {
            if (dTLSRecordLayer.getReadVersion().isEqualOrEarlierVersionOf(clientHandshakeState.clientContext.getClientVersion())) {
                dTLSRecordLayer.setReadVersion(null);
                byte[] patchClientHelloWithCookie = patchClientHelloWithCookie(generateClientHello, processHelloVerifyRequest(clientHandshakeState, receiveMessage.getBody()));
                dTLSReliableHandshake.resetHandshakeMessagesDigest();
                dTLSReliableHandshake.sendMessage((short) 1, patchClientHelloWithCookie);
                receiveMessage = dTLSReliableHandshake.receiveMessage();
            } else {
                throw new TlsFatalAlert((short) 47);
            }
        }
        if (receiveMessage.getType() == 2) {
            ProtocolVersion readVersion = dTLSRecordLayer.getReadVersion();
            reportServerVersion(clientHandshakeState, readVersion);
            dTLSRecordLayer.setWriteVersion(readVersion);
            processServerHello(clientHandshakeState, receiveMessage.getBody());
            dTLSReliableHandshake.notifyHelloComplete();
            DTLSProtocol.applyMaxFragmentLengthExtension(dTLSRecordLayer, securityParameters.maxFragmentLength);
            if (clientHandshakeState.resumedSession) {
                securityParameters.masterSecret = Arrays.clone(clientHandshakeState.sessionParameters.getMasterSecret());
                dTLSRecordLayer.initPendingEpoch(clientHandshakeState.client.getCipher());
                TlsClientContextImpl tlsClientContextImpl = clientHandshakeState.clientContext;
                processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsClientContextImpl, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl, dTLSReliableHandshake.getHandshakeHash(), null)));
                TlsClientContextImpl tlsClientContextImpl2 = clientHandshakeState.clientContext;
                dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsClientContextImpl2, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl2, dTLSReliableHandshake.getHandshakeHash(), null)));
                dTLSReliableHandshake.finish();
                clientHandshakeState.clientContext.setResumableSession(clientHandshakeState.tlsSession);
                clientHandshakeState.client.notifyHandshakeComplete();
                return new DTLSTransport(dTLSRecordLayer);
            }
            invalidateSession(clientHandshakeState);
            byte[] bArr = clientHandshakeState.selectedSessionID;
            if (bArr.length > 0) {
                clientHandshakeState.tlsSession = new TlsSessionImpl(bArr, null);
            }
            DTLSReliableHandshake.Message receiveMessage2 = dTLSReliableHandshake.receiveMessage();
            if (receiveMessage2.getType() == 23) {
                processServerSupplementalData(clientHandshakeState, receiveMessage2.getBody());
                receiveMessage2 = dTLSReliableHandshake.receiveMessage();
            } else {
                clientHandshakeState.client.processServerSupplementalData(null);
            }
            TlsKeyExchange keyExchange = clientHandshakeState.client.getKeyExchange();
            clientHandshakeState.keyExchange = keyExchange;
            keyExchange.init(clientHandshakeState.clientContext);
            if (receiveMessage2.getType() == 11) {
                certificate = processServerCertificate(clientHandshakeState, receiveMessage2.getBody());
                message = dTLSReliableHandshake.receiveMessage();
            } else {
                clientHandshakeState.keyExchange.skipServerCredentials();
                message = receiveMessage2;
                certificate = null;
            }
            if (certificate == null || certificate.isEmpty()) {
                clientHandshakeState.allowCertificateStatus = false;
            }
            if (message.getType() == 22) {
                processCertificateStatus(clientHandshakeState, message.getBody());
                message = dTLSReliableHandshake.receiveMessage();
            }
            if (message.getType() == 12) {
                processServerKeyExchange(clientHandshakeState, message.getBody());
                message = dTLSReliableHandshake.receiveMessage();
            } else {
                clientHandshakeState.keyExchange.skipServerKeyExchange();
            }
            if (message.getType() == 13) {
                processCertificateRequest(clientHandshakeState, message.getBody());
                TlsUtils.trackHashAlgorithms(dTLSReliableHandshake.getHandshakeHash(), clientHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
                message = dTLSReliableHandshake.receiveMessage();
            }
            if (message.getType() == 14) {
                if (message.getBody().length == 0) {
                    dTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
                    Vector clientSupplementalData = clientHandshakeState.client.getClientSupplementalData();
                    if (clientSupplementalData != null) {
                        dTLSReliableHandshake.sendMessage((short) 23, DTLSProtocol.generateSupplementalData(clientSupplementalData));
                    }
                    CertificateRequest certificateRequest = clientHandshakeState.certificateRequest;
                    if (certificateRequest != null) {
                        TlsCredentials clientCredentials = clientHandshakeState.authentication.getClientCredentials(certificateRequest);
                        clientHandshakeState.clientCredentials = clientCredentials;
                        Certificate certificate2 = clientCredentials != null ? clientCredentials.getCertificate() : null;
                        if (certificate2 == null) {
                            certificate2 = Certificate.EMPTY_CHAIN;
                        }
                        dTLSReliableHandshake.sendMessage((short) 11, DTLSProtocol.generateCertificate(certificate2));
                    }
                    TlsCredentials tlsCredentials = clientHandshakeState.clientCredentials;
                    if (tlsCredentials != null) {
                        clientHandshakeState.keyExchange.processClientCredentials(tlsCredentials);
                    } else {
                        clientHandshakeState.keyExchange.skipClientCredentials();
                    }
                    dTLSReliableHandshake.sendMessage((short) 16, generateClientKeyExchange(clientHandshakeState));
                    TlsHandshakeHash prepareToFinish = dTLSReliableHandshake.prepareToFinish();
                    securityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(clientHandshakeState.clientContext, prepareToFinish, null);
                    TlsProtocol.establishMasterSecret(clientHandshakeState.clientContext, clientHandshakeState.keyExchange);
                    dTLSRecordLayer.initPendingEpoch(clientHandshakeState.client.getCipher());
                    TlsCredentials tlsCredentials2 = clientHandshakeState.clientCredentials;
                    if (tlsCredentials2 != null && (tlsCredentials2 instanceof TlsSignerCredentials)) {
                        TlsSignerCredentials tlsSignerCredentials = (TlsSignerCredentials) tlsCredentials2;
                        SignatureAndHashAlgorithm signatureAndHashAlgorithm = TlsUtils.getSignatureAndHashAlgorithm(clientHandshakeState.clientContext, tlsSignerCredentials);
                        if (signatureAndHashAlgorithm == null) {
                            finalHash = securityParameters.getSessionHash();
                        } else {
                            finalHash = prepareToFinish.getFinalHash(signatureAndHashAlgorithm.getHash());
                        }
                        dTLSReliableHandshake.sendMessage((short) 15, generateCertificateVerify(clientHandshakeState, new DigitallySigned(signatureAndHashAlgorithm, tlsSignerCredentials.generateCertificateSignature(finalHash))));
                    }
                    TlsClientContextImpl tlsClientContextImpl3 = clientHandshakeState.clientContext;
                    dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsClientContextImpl3, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl3, dTLSReliableHandshake.getHandshakeHash(), null)));
                    if (clientHandshakeState.expectSessionTicket) {
                        DTLSReliableHandshake.Message receiveMessage3 = dTLSReliableHandshake.receiveMessage();
                        if (receiveMessage3.getType() == 4) {
                            processNewSessionTicket(clientHandshakeState, receiveMessage3.getBody());
                        } else {
                            throw new TlsFatalAlert((short) 10);
                        }
                    }
                    TlsClientContextImpl tlsClientContextImpl4 = clientHandshakeState.clientContext;
                    processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsClientContextImpl4, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsClientContextImpl4, dTLSReliableHandshake.getHandshakeHash(), null)));
                    dTLSReliableHandshake.finish();
                    if (clientHandshakeState.tlsSession != null) {
                        clientHandshakeState.sessionParameters = new SessionParameters.Builder().setCipherSuite(securityParameters.getCipherSuite()).setCompressionAlgorithm(securityParameters.getCompressionAlgorithm()).setMasterSecret(securityParameters.getMasterSecret()).setPeerCertificate(certificate).setPSKIdentity(securityParameters.getPSKIdentity()).setSRPIdentity(securityParameters.getSRPIdentity()).setServerExtensions(clientHandshakeState.serverExtensions).build();
                        TlsSession importSession = TlsUtils.importSession(clientHandshakeState.tlsSession.getSessionID(), clientHandshakeState.sessionParameters);
                        clientHandshakeState.tlsSession = importSession;
                        clientHandshakeState.clientContext.setResumableSession(importSession);
                    }
                    clientHandshakeState.client.notifyHandshakeComplete();
                    return new DTLSTransport(dTLSRecordLayer);
                }
                throw new TlsFatalAlert((short) 50);
            }
            throw new TlsFatalAlert((short) 10);
        }
        throw new TlsFatalAlert((short) 10);
    }

    public DTLSTransport connect(TlsClient tlsClient, DatagramTransport datagramTransport) throws IOException {
        SessionParameters exportSessionParameters;
        if (tlsClient != null) {
            if (datagramTransport != null) {
                SecurityParameters securityParameters = new SecurityParameters();
                securityParameters.entity = 1;
                ClientHandshakeState clientHandshakeState = new ClientHandshakeState();
                clientHandshakeState.client = tlsClient;
                clientHandshakeState.clientContext = new TlsClientContextImpl(this.secureRandom, securityParameters);
                securityParameters.clientRandom = TlsProtocol.createRandomBlock(tlsClient.shouldUseGMTUnixTime(), clientHandshakeState.clientContext.getNonceRandomGenerator());
                tlsClient.init(clientHandshakeState.clientContext);
                DTLSRecordLayer dTLSRecordLayer = new DTLSRecordLayer(datagramTransport, clientHandshakeState.clientContext, tlsClient, (short) 22);
                TlsSession sessionToResume = clientHandshakeState.client.getSessionToResume();
                if (sessionToResume != null && sessionToResume.isResumable() && (exportSessionParameters = sessionToResume.exportSessionParameters()) != null) {
                    clientHandshakeState.tlsSession = sessionToResume;
                    clientHandshakeState.sessionParameters = exportSessionParameters;
                }
                try {
                    return clientHandshake(clientHandshakeState, dTLSRecordLayer);
                } catch (TlsFatalAlert e2) {
                    dTLSRecordLayer.fail(e2.getAlertDescription());
                    throw e2;
                } catch (IOException e3) {
                    dTLSRecordLayer.fail((short) 80);
                    throw e3;
                } catch (RuntimeException e4) {
                    dTLSRecordLayer.fail((short) 80);
                    throw new TlsFatalAlert((short) 80, e4);
                }
            }
            throw new IllegalArgumentException("'transport' cannot be null");
        }
        throw new IllegalArgumentException("'client' cannot be null");
    }

    protected byte[] generateCertificateVerify(ClientHandshakeState clientHandshakeState, DigitallySigned digitallySigned) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        digitallySigned.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected byte[] generateClientHello(ClientHandshakeState clientHandshakeState, TlsClient tlsClient) throws IOException {
        byte[] bArr;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion clientVersion = tlsClient.getClientVersion();
        if (clientVersion.isDTLS()) {
            TlsClientContextImpl tlsClientContextImpl = clientHandshakeState.clientContext;
            tlsClientContextImpl.setClientVersion(clientVersion);
            TlsUtils.writeVersion(clientVersion, byteArrayOutputStream);
            byteArrayOutputStream.write(tlsClientContextImpl.getSecurityParameters().getClientRandom());
            byte[] bArr2 = TlsUtils.EMPTY_BYTES;
            TlsSession tlsSession = clientHandshakeState.tlsSession;
            if (tlsSession == null || (bArr = tlsSession.getSessionID()) == null || bArr.length > 32) {
                bArr = bArr2;
            }
            TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
            TlsUtils.writeOpaque8(bArr2, byteArrayOutputStream);
            boolean isFallback = tlsClient.isFallback();
            clientHandshakeState.offeredCipherSuites = tlsClient.getCipherSuites();
            Hashtable clientExtensions = tlsClient.getClientExtensions();
            clientHandshakeState.clientExtensions = clientExtensions;
            boolean z = TlsUtils.getExtensionData(clientExtensions, TlsProtocol.EXT_RenegotiationInfo) == null;
            boolean z2 = !Arrays.contains(clientHandshakeState.offeredCipherSuites, 255);
            if (z && z2) {
                clientHandshakeState.offeredCipherSuites = Arrays.append(clientHandshakeState.offeredCipherSuites, 255);
            }
            if (isFallback && !Arrays.contains(clientHandshakeState.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV)) {
                clientHandshakeState.offeredCipherSuites = Arrays.append(clientHandshakeState.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV);
            }
            TlsUtils.writeUint16ArrayWithUint16Length(clientHandshakeState.offeredCipherSuites, byteArrayOutputStream);
            short[] sArr = {0};
            clientHandshakeState.offeredCompressionMethods = sArr;
            TlsUtils.writeUint8ArrayWithUint8Length(sArr, byteArrayOutputStream);
            Hashtable hashtable = clientHandshakeState.clientExtensions;
            if (hashtable != null) {
                TlsProtocol.writeExtensions(byteArrayOutputStream, hashtable);
            }
            return byteArrayOutputStream.toByteArray();
        }
        throw new TlsFatalAlert((short) 80);
    }

    protected byte[] generateClientKeyExchange(ClientHandshakeState clientHandshakeState) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        clientHandshakeState.keyExchange.generateClientKeyExchange(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected void invalidateSession(ClientHandshakeState clientHandshakeState) {
        SessionParameters sessionParameters = clientHandshakeState.sessionParameters;
        if (sessionParameters != null) {
            sessionParameters.clear();
            clientHandshakeState.sessionParameters = null;
        }
        TlsSession tlsSession = clientHandshakeState.tlsSession;
        if (tlsSession != null) {
            tlsSession.invalidate();
            clientHandshakeState.tlsSession = null;
        }
    }

    protected void processCertificateRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (clientHandshakeState.authentication != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            clientHandshakeState.certificateRequest = CertificateRequest.parse(clientHandshakeState.clientContext, byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            clientHandshakeState.keyExchange.validateCertificateRequest(clientHandshakeState.certificateRequest);
            return;
        }
        throw new TlsFatalAlert((short) 40);
    }

    protected void processCertificateStatus(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        if (clientHandshakeState.allowCertificateStatus) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            clientHandshakeState.certificateStatus = CertificateStatus.parse(byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            return;
        }
        throw new TlsFatalAlert((short) 10);
    }

    protected byte[] processHelloVerifyRequest(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        if (readVersion.isEqualOrEarlierVersionOf(clientHandshakeState.clientContext.getClientVersion())) {
            if (ProtocolVersion.DTLSv12.isEqualOrEarlierVersionOf(readVersion) || readOpaque8.length <= 32) {
                return readOpaque8;
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new TlsFatalAlert((short) 47);
    }

    protected void processNewSessionTicket(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        NewSessionTicket parse = NewSessionTicket.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.client.notifyNewSessionTicket(parse);
    }

    protected Certificate processServerCertificate(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        clientHandshakeState.keyExchange.processServerCertificate(parse);
        TlsAuthentication authentication = clientHandshakeState.client.getAuthentication();
        clientHandshakeState.authentication = authentication;
        authentication.notifyServerCertificate(parse);
        return parse;
    }

    protected void processServerHello(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        TlsSession tlsSession;
        SecurityParameters securityParameters = clientHandshakeState.clientContext.getSecurityParameters();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        reportServerVersion(clientHandshakeState, TlsUtils.readVersion(byteArrayInputStream));
        securityParameters.serverRandom = TlsUtils.readFully(32, byteArrayInputStream);
        byte[] readOpaque8 = TlsUtils.readOpaque8(byteArrayInputStream);
        clientHandshakeState.selectedSessionID = readOpaque8;
        if (readOpaque8.length <= 32) {
            clientHandshakeState.client.notifySessionID(readOpaque8);
            byte[] bArr2 = clientHandshakeState.selectedSessionID;
            boolean z = false;
            clientHandshakeState.resumedSession = bArr2.length > 0 && (tlsSession = clientHandshakeState.tlsSession) != null && Arrays.areEqual(bArr2, tlsSession.getSessionID());
            int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
            if (Arrays.contains(clientHandshakeState.offeredCipherSuites, readUint16) && readUint16 != 0 && !CipherSuite.isSCSV(readUint16) && TlsUtils.isValidCipherSuiteForVersion(readUint16, clientHandshakeState.clientContext.getServerVersion())) {
                DTLSProtocol.validateSelectedCipherSuite(readUint16, (short) 47);
                clientHandshakeState.client.notifySelectedCipherSuite(readUint16);
                short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                if (Arrays.contains(clientHandshakeState.offeredCompressionMethods, readUint8)) {
                    clientHandshakeState.client.notifySelectedCompressionMethod(readUint8);
                    Hashtable readExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                    clientHandshakeState.serverExtensions = readExtensions;
                    if (readExtensions != null) {
                        Enumeration keys = readExtensions.keys();
                        while (keys.hasMoreElements()) {
                            Integer num = (Integer) keys.nextElement();
                            if (!num.equals(TlsProtocol.EXT_RenegotiationInfo) && TlsUtils.getExtensionData(clientHandshakeState.clientExtensions, num) == null) {
                                throw new TlsFatalAlert(AlertDescription.unsupported_extension);
                            }
                        }
                    }
                    byte[] extensionData = TlsUtils.getExtensionData(clientHandshakeState.serverExtensions, TlsProtocol.EXT_RenegotiationInfo);
                    if (extensionData != null) {
                        clientHandshakeState.secure_renegotiation = true;
                        if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                            throw new TlsFatalAlert((short) 40);
                        }
                    }
                    clientHandshakeState.client.notifySecureRenegotiation(clientHandshakeState.secure_renegotiation);
                    Hashtable hashtable = clientHandshakeState.clientExtensions;
                    Hashtable hashtable2 = clientHandshakeState.serverExtensions;
                    if (clientHandshakeState.resumedSession) {
                        if (readUint16 == clientHandshakeState.sessionParameters.getCipherSuite() && readUint8 == clientHandshakeState.sessionParameters.getCompressionAlgorithm()) {
                            hashtable = null;
                            hashtable2 = clientHandshakeState.sessionParameters.readServerExtensions();
                        } else {
                            throw new TlsFatalAlert((short) 47);
                        }
                    }
                    securityParameters.cipherSuite = readUint16;
                    securityParameters.compressionAlgorithm = readUint8;
                    if (hashtable2 != null) {
                        boolean hasEncryptThenMACExtension = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable2);
                        if (hasEncryptThenMACExtension && !TlsUtils.isBlockCipherSuite(securityParameters.getCipherSuite())) {
                            throw new TlsFatalAlert((short) 47);
                        }
                        securityParameters.encryptThenMAC = hasEncryptThenMACExtension;
                        securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(hashtable2);
                        securityParameters.maxFragmentLength = DTLSProtocol.evaluateMaxFragmentLengthExtension(clientHandshakeState.resumedSession, hashtable, hashtable2, (short) 47);
                        securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(hashtable2);
                        clientHandshakeState.allowCertificateStatus = !clientHandshakeState.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsExtensionsUtils.EXT_status_request, (short) 47);
                        if (!clientHandshakeState.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(hashtable2, TlsProtocol.EXT_SessionTicket, (short) 47)) {
                            z = true;
                        }
                        clientHandshakeState.expectSessionTicket = z;
                    }
                    if (hashtable != null) {
                        clientHandshakeState.client.processServerExtensions(hashtable2);
                    }
                    securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(clientHandshakeState.clientContext, securityParameters.getCipherSuite());
                    securityParameters.verifyDataLength = 12;
                    return;
                }
                throw new TlsFatalAlert((short) 47);
            }
            throw new TlsFatalAlert((short) 47);
        }
        throw new TlsFatalAlert((short) 47);
    }

    protected void processServerKeyExchange(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        clientHandshakeState.keyExchange.processServerKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    protected void processServerSupplementalData(ClientHandshakeState clientHandshakeState, byte[] bArr) throws IOException {
        clientHandshakeState.client.processServerSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    protected void reportServerVersion(ClientHandshakeState clientHandshakeState, ProtocolVersion protocolVersion) throws IOException {
        TlsClientContextImpl tlsClientContextImpl = clientHandshakeState.clientContext;
        ProtocolVersion serverVersion = tlsClientContextImpl.getServerVersion();
        if (serverVersion == null) {
            tlsClientContextImpl.setServerVersion(protocolVersion);
            clientHandshakeState.client.notifyServerVersion(protocolVersion);
        } else if (!serverVersion.equals(protocolVersion)) {
            throw new TlsFatalAlert((short) 47);
        }
    }
}