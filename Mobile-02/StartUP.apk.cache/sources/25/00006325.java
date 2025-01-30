package org.spongycastle.crypto.tls;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.Hashtable;
import java.util.Vector;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.tls.DTLSReliableHandshake;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class DTLSServerProtocol extends DTLSProtocol {
    protected boolean verifyRequests;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class ServerHandshakeState {
        TlsServer server = null;
        TlsServerContextImpl serverContext = null;
        int[] offeredCipherSuites = null;
        short[] offeredCompressionMethods = null;
        Hashtable clientExtensions = null;
        Hashtable serverExtensions = null;
        boolean resumedSession = false;
        boolean secure_renegotiation = false;
        boolean allowCertificateStatus = false;
        boolean expectSessionTicket = false;
        TlsKeyExchange keyExchange = null;
        TlsCredentials serverCredentials = null;
        CertificateRequest certificateRequest = null;
        short clientCertificateType = -1;
        Certificate clientCertificate = null;

        protected ServerHandshakeState() {
        }
    }

    public DTLSServerProtocol(SecureRandom secureRandom) {
        super(secureRandom);
        this.verifyRequests = true;
    }

    public DTLSTransport accept(TlsServer tlsServer, DatagramTransport datagramTransport) throws IOException {
        if (tlsServer != null) {
            if (datagramTransport != null) {
                SecurityParameters securityParameters = new SecurityParameters();
                securityParameters.entity = 0;
                ServerHandshakeState serverHandshakeState = new ServerHandshakeState();
                serverHandshakeState.server = tlsServer;
                serverHandshakeState.serverContext = new TlsServerContextImpl(this.secureRandom, securityParameters);
                securityParameters.serverRandom = TlsProtocol.createRandomBlock(tlsServer.shouldUseGMTUnixTime(), serverHandshakeState.serverContext.getNonceRandomGenerator());
                tlsServer.init(serverHandshakeState.serverContext);
                DTLSRecordLayer dTLSRecordLayer = new DTLSRecordLayer(datagramTransport, serverHandshakeState.serverContext, tlsServer, (short) 22);
                try {
                    return serverHandshake(serverHandshakeState, dTLSRecordLayer);
                } catch (IOException e2) {
                    dTLSRecordLayer.fail((short) 80);
                    throw e2;
                } catch (RuntimeException e3) {
                    dTLSRecordLayer.fail((short) 80);
                    throw new TlsFatalAlert((short) 80, e3);
                } catch (TlsFatalAlert e4) {
                    dTLSRecordLayer.fail(e4.getAlertDescription());
                    throw e4;
                }
            }
            throw new IllegalArgumentException("'transport' cannot be null");
        }
        throw new IllegalArgumentException("'server' cannot be null");
    }

    protected boolean expectCertificateVerifyMessage(ServerHandshakeState serverHandshakeState) {
        short s = serverHandshakeState.clientCertificateType;
        return s >= 0 && TlsUtils.hasSigningCapability(s);
    }

    protected byte[] generateCertificateRequest(ServerHandshakeState serverHandshakeState, CertificateRequest certificateRequest) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateRequest.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected byte[] generateCertificateStatus(ServerHandshakeState serverHandshakeState, CertificateStatus certificateStatus) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        certificateStatus.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected byte[] generateNewSessionTicket(ServerHandshakeState serverHandshakeState, NewSessionTicket newSessionTicket) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        newSessionTicket.encode(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    protected byte[] generateServerHello(ServerHandshakeState serverHandshakeState) throws IOException {
        SecurityParameters securityParameters = serverHandshakeState.serverContext.getSecurityParameters();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ProtocolVersion serverVersion = serverHandshakeState.server.getServerVersion();
        if (serverVersion.isEqualOrEarlierVersionOf(serverHandshakeState.serverContext.getClientVersion())) {
            serverHandshakeState.serverContext.setServerVersion(serverVersion);
            TlsUtils.writeVersion(serverHandshakeState.serverContext.getServerVersion(), byteArrayOutputStream);
            byteArrayOutputStream.write(securityParameters.getServerRandom());
            byte[] bArr = TlsUtils.EMPTY_BYTES;
            TlsUtils.writeOpaque8(bArr, byteArrayOutputStream);
            int selectedCipherSuite = serverHandshakeState.server.getSelectedCipherSuite();
            if (Arrays.contains(serverHandshakeState.offeredCipherSuites, selectedCipherSuite) && selectedCipherSuite != 0 && !CipherSuite.isSCSV(selectedCipherSuite) && TlsUtils.isValidCipherSuiteForVersion(selectedCipherSuite, serverHandshakeState.serverContext.getServerVersion())) {
                DTLSProtocol.validateSelectedCipherSuite(selectedCipherSuite, (short) 80);
                securityParameters.cipherSuite = selectedCipherSuite;
                short selectedCompressionMethod = serverHandshakeState.server.getSelectedCompressionMethod();
                if (Arrays.contains(serverHandshakeState.offeredCompressionMethods, selectedCompressionMethod)) {
                    securityParameters.compressionAlgorithm = selectedCompressionMethod;
                    TlsUtils.writeUint16(selectedCipherSuite, byteArrayOutputStream);
                    TlsUtils.writeUint8(selectedCompressionMethod, (OutputStream) byteArrayOutputStream);
                    Hashtable serverExtensions = serverHandshakeState.server.getServerExtensions();
                    serverHandshakeState.serverExtensions = serverExtensions;
                    boolean z = true;
                    if (serverHandshakeState.secure_renegotiation) {
                        Integer num = TlsProtocol.EXT_RenegotiationInfo;
                        if (TlsUtils.getExtensionData(serverExtensions, num) == null) {
                            Hashtable ensureExtensionsInitialised = TlsExtensionsUtils.ensureExtensionsInitialised(serverHandshakeState.serverExtensions);
                            serverHandshakeState.serverExtensions = ensureExtensionsInitialised;
                            ensureExtensionsInitialised.put(num, TlsProtocol.createRenegotiationInfo(bArr));
                        }
                    }
                    if (securityParameters.extendedMasterSecret) {
                        Hashtable ensureExtensionsInitialised2 = TlsExtensionsUtils.ensureExtensionsInitialised(serverHandshakeState.serverExtensions);
                        serverHandshakeState.serverExtensions = ensureExtensionsInitialised2;
                        TlsExtensionsUtils.addExtendedMasterSecretExtension(ensureExtensionsInitialised2);
                    }
                    Hashtable hashtable = serverHandshakeState.serverExtensions;
                    if (hashtable != null) {
                        securityParameters.encryptThenMAC = TlsExtensionsUtils.hasEncryptThenMACExtension(hashtable);
                        securityParameters.maxFragmentLength = DTLSProtocol.evaluateMaxFragmentLengthExtension(serverHandshakeState.resumedSession, serverHandshakeState.clientExtensions, serverHandshakeState.serverExtensions, (short) 80);
                        securityParameters.truncatedHMac = TlsExtensionsUtils.hasTruncatedHMacExtension(serverHandshakeState.serverExtensions);
                        serverHandshakeState.allowCertificateStatus = !serverHandshakeState.resumedSession && TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.serverExtensions, TlsExtensionsUtils.EXT_status_request, (short) 80);
                        if (serverHandshakeState.resumedSession || !TlsUtils.hasExpectedEmptyExtensionData(serverHandshakeState.serverExtensions, TlsProtocol.EXT_SessionTicket, (short) 80)) {
                            z = false;
                        }
                        serverHandshakeState.expectSessionTicket = z;
                        TlsProtocol.writeExtensions(byteArrayOutputStream, serverHandshakeState.serverExtensions);
                    }
                    securityParameters.prfAlgorithm = TlsProtocol.getPRFAlgorithm(serverHandshakeState.serverContext, securityParameters.getCipherSuite());
                    securityParameters.verifyDataLength = 12;
                    return byteArrayOutputStream.toByteArray();
                }
                throw new TlsFatalAlert((short) 80);
            }
            throw new TlsFatalAlert((short) 80);
        }
        throw new TlsFatalAlert((short) 80);
    }

    public boolean getVerifyRequests() {
        return this.verifyRequests;
    }

    protected void notifyClientCertificate(ServerHandshakeState serverHandshakeState, Certificate certificate) throws IOException {
        if (serverHandshakeState.certificateRequest != null) {
            if (serverHandshakeState.clientCertificate == null) {
                serverHandshakeState.clientCertificate = certificate;
                if (certificate.isEmpty()) {
                    serverHandshakeState.keyExchange.skipClientCredentials();
                } else {
                    serverHandshakeState.clientCertificateType = TlsUtils.getClientCertificateType(certificate, serverHandshakeState.serverCredentials.getCertificate());
                    serverHandshakeState.keyExchange.processClientCertificate(certificate);
                }
                serverHandshakeState.server.notifyClientCertificate(certificate);
                return;
            }
            throw new TlsFatalAlert((short) 10);
        }
        throw new IllegalStateException();
    }

    protected void processCertificateVerify(ServerHandshakeState serverHandshakeState, byte[] bArr, TlsHandshakeHash tlsHandshakeHash) throws IOException {
        byte[] sessionHash;
        if (serverHandshakeState.certificateRequest != null) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            TlsServerContextImpl tlsServerContextImpl = serverHandshakeState.serverContext;
            DigitallySigned parse = DigitallySigned.parse(tlsServerContextImpl, byteArrayInputStream);
            TlsProtocol.assertEmpty(byteArrayInputStream);
            try {
                SignatureAndHashAlgorithm algorithm = parse.getAlgorithm();
                if (TlsUtils.isTLSv12(tlsServerContextImpl)) {
                    TlsUtils.verifySupportedSignatureAlgorithm(serverHandshakeState.certificateRequest.getSupportedSignatureAlgorithms(), algorithm);
                    sessionHash = tlsHandshakeHash.getFinalHash(algorithm.getHash());
                } else {
                    sessionHash = tlsServerContextImpl.getSecurityParameters().getSessionHash();
                }
                AsymmetricKeyParameter createKey = PublicKeyFactory.createKey(serverHandshakeState.clientCertificate.getCertificateAt(0).getSubjectPublicKeyInfo());
                TlsSigner createTlsSigner = TlsUtils.createTlsSigner(serverHandshakeState.clientCertificateType);
                createTlsSigner.init(tlsServerContextImpl);
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

    protected void processClientCertificate(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        Certificate parse = Certificate.parse(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
        notifyClientCertificate(serverHandshakeState, parse);
    }

    protected void processClientHello(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ProtocolVersion readVersion = TlsUtils.readVersion(byteArrayInputStream);
        if (readVersion.isDTLS()) {
            byte[] readFully = TlsUtils.readFully(32, byteArrayInputStream);
            if (TlsUtils.readOpaque8(byteArrayInputStream).length <= 32) {
                TlsUtils.readOpaque8(byteArrayInputStream);
                int readUint16 = TlsUtils.readUint16(byteArrayInputStream);
                if (readUint16 >= 2 && (readUint16 & 1) == 0) {
                    serverHandshakeState.offeredCipherSuites = TlsUtils.readUint16Array(readUint16 / 2, byteArrayInputStream);
                    short readUint8 = TlsUtils.readUint8(byteArrayInputStream);
                    if (readUint8 >= 1) {
                        serverHandshakeState.offeredCompressionMethods = TlsUtils.readUint8Array(readUint8, byteArrayInputStream);
                        serverHandshakeState.clientExtensions = TlsProtocol.readExtensions(byteArrayInputStream);
                        TlsServerContextImpl tlsServerContextImpl = serverHandshakeState.serverContext;
                        SecurityParameters securityParameters = tlsServerContextImpl.getSecurityParameters();
                        securityParameters.extendedMasterSecret = TlsExtensionsUtils.hasExtendedMasterSecretExtension(serverHandshakeState.clientExtensions);
                        tlsServerContextImpl.setClientVersion(readVersion);
                        serverHandshakeState.server.notifyClientVersion(readVersion);
                        serverHandshakeState.server.notifyFallback(Arrays.contains(serverHandshakeState.offeredCipherSuites, (int) CipherSuite.TLS_FALLBACK_SCSV));
                        securityParameters.clientRandom = readFully;
                        serverHandshakeState.server.notifyOfferedCipherSuites(serverHandshakeState.offeredCipherSuites);
                        serverHandshakeState.server.notifyOfferedCompressionMethods(serverHandshakeState.offeredCompressionMethods);
                        if (Arrays.contains(serverHandshakeState.offeredCipherSuites, 255)) {
                            serverHandshakeState.secure_renegotiation = true;
                        }
                        byte[] extensionData = TlsUtils.getExtensionData(serverHandshakeState.clientExtensions, TlsProtocol.EXT_RenegotiationInfo);
                        if (extensionData != null) {
                            serverHandshakeState.secure_renegotiation = true;
                            if (!Arrays.constantTimeAreEqual(extensionData, TlsProtocol.createRenegotiationInfo(TlsUtils.EMPTY_BYTES))) {
                                throw new TlsFatalAlert((short) 40);
                            }
                        }
                        serverHandshakeState.server.notifySecureRenegotiation(serverHandshakeState.secure_renegotiation);
                        Hashtable hashtable = serverHandshakeState.clientExtensions;
                        if (hashtable != null) {
                            serverHandshakeState.server.processClientExtensions(hashtable);
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

    protected void processClientKeyExchange(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        serverHandshakeState.keyExchange.processClientKeyExchange(byteArrayInputStream);
        TlsProtocol.assertEmpty(byteArrayInputStream);
    }

    protected void processClientSupplementalData(ServerHandshakeState serverHandshakeState, byte[] bArr) throws IOException {
        serverHandshakeState.server.processClientSupplementalData(TlsProtocol.readSupplementalDataMessage(new ByteArrayInputStream(bArr)));
    }

    protected DTLSTransport serverHandshake(ServerHandshakeState serverHandshakeState, DTLSRecordLayer dTLSRecordLayer) throws IOException {
        Certificate certificate;
        CertificateStatus certificateStatus;
        SecurityParameters securityParameters = serverHandshakeState.serverContext.getSecurityParameters();
        DTLSReliableHandshake dTLSReliableHandshake = new DTLSReliableHandshake(serverHandshakeState.serverContext, dTLSRecordLayer);
        DTLSReliableHandshake.Message receiveMessage = dTLSReliableHandshake.receiveMessage();
        if (receiveMessage.getType() == 1) {
            processClientHello(serverHandshakeState, receiveMessage.getBody());
            byte[] generateServerHello = generateServerHello(serverHandshakeState);
            DTLSProtocol.applyMaxFragmentLengthExtension(dTLSRecordLayer, securityParameters.maxFragmentLength);
            ProtocolVersion serverVersion = serverHandshakeState.serverContext.getServerVersion();
            dTLSRecordLayer.setReadVersion(serverVersion);
            dTLSRecordLayer.setWriteVersion(serverVersion);
            dTLSReliableHandshake.sendMessage((short) 2, generateServerHello);
            dTLSReliableHandshake.notifyHelloComplete();
            Vector serverSupplementalData = serverHandshakeState.server.getServerSupplementalData();
            if (serverSupplementalData != null) {
                dTLSReliableHandshake.sendMessage((short) 23, DTLSProtocol.generateSupplementalData(serverSupplementalData));
            }
            TlsKeyExchange keyExchange = serverHandshakeState.server.getKeyExchange();
            serverHandshakeState.keyExchange = keyExchange;
            keyExchange.init(serverHandshakeState.serverContext);
            TlsCredentials credentials = serverHandshakeState.server.getCredentials();
            serverHandshakeState.serverCredentials = credentials;
            if (credentials == null) {
                serverHandshakeState.keyExchange.skipServerCredentials();
                certificate = null;
            } else {
                serverHandshakeState.keyExchange.processServerCredentials(credentials);
                certificate = serverHandshakeState.serverCredentials.getCertificate();
                dTLSReliableHandshake.sendMessage((short) 11, DTLSProtocol.generateCertificate(certificate));
            }
            if (certificate == null || certificate.isEmpty()) {
                serverHandshakeState.allowCertificateStatus = false;
            }
            if (serverHandshakeState.allowCertificateStatus && (certificateStatus = serverHandshakeState.server.getCertificateStatus()) != null) {
                dTLSReliableHandshake.sendMessage((short) 22, generateCertificateStatus(serverHandshakeState, certificateStatus));
            }
            byte[] generateServerKeyExchange = serverHandshakeState.keyExchange.generateServerKeyExchange();
            if (generateServerKeyExchange != null) {
                dTLSReliableHandshake.sendMessage((short) 12, generateServerKeyExchange);
            }
            if (serverHandshakeState.serverCredentials != null) {
                CertificateRequest certificateRequest = serverHandshakeState.server.getCertificateRequest();
                serverHandshakeState.certificateRequest = certificateRequest;
                if (certificateRequest != null) {
                    if (TlsUtils.isTLSv12(serverHandshakeState.serverContext) == (serverHandshakeState.certificateRequest.getSupportedSignatureAlgorithms() != null)) {
                        serverHandshakeState.keyExchange.validateCertificateRequest(serverHandshakeState.certificateRequest);
                        dTLSReliableHandshake.sendMessage((short) 13, generateCertificateRequest(serverHandshakeState, serverHandshakeState.certificateRequest));
                        TlsUtils.trackHashAlgorithms(dTLSReliableHandshake.getHandshakeHash(), serverHandshakeState.certificateRequest.getSupportedSignatureAlgorithms());
                    } else {
                        throw new TlsFatalAlert((short) 80);
                    }
                }
            }
            dTLSReliableHandshake.sendMessage((short) 14, TlsUtils.EMPTY_BYTES);
            dTLSReliableHandshake.getHandshakeHash().sealHashAlgorithms();
            DTLSReliableHandshake.Message receiveMessage2 = dTLSReliableHandshake.receiveMessage();
            if (receiveMessage2.getType() == 23) {
                processClientSupplementalData(serverHandshakeState, receiveMessage2.getBody());
                receiveMessage2 = dTLSReliableHandshake.receiveMessage();
            } else {
                serverHandshakeState.server.processClientSupplementalData(null);
            }
            if (serverHandshakeState.certificateRequest == null) {
                serverHandshakeState.keyExchange.skipClientCredentials();
            } else if (receiveMessage2.getType() == 11) {
                processClientCertificate(serverHandshakeState, receiveMessage2.getBody());
                receiveMessage2 = dTLSReliableHandshake.receiveMessage();
            } else if (!TlsUtils.isTLSv12(serverHandshakeState.serverContext)) {
                notifyClientCertificate(serverHandshakeState, Certificate.EMPTY_CHAIN);
            } else {
                throw new TlsFatalAlert((short) 10);
            }
            if (receiveMessage2.getType() == 16) {
                processClientKeyExchange(serverHandshakeState, receiveMessage2.getBody());
                TlsHandshakeHash prepareToFinish = dTLSReliableHandshake.prepareToFinish();
                securityParameters.sessionHash = TlsProtocol.getCurrentPRFHash(serverHandshakeState.serverContext, prepareToFinish, null);
                TlsProtocol.establishMasterSecret(serverHandshakeState.serverContext, serverHandshakeState.keyExchange);
                dTLSRecordLayer.initPendingEpoch(serverHandshakeState.server.getCipher());
                if (expectCertificateVerifyMessage(serverHandshakeState)) {
                    processCertificateVerify(serverHandshakeState, dTLSReliableHandshake.receiveMessageBody((short) 15), prepareToFinish);
                }
                TlsServerContextImpl tlsServerContextImpl = serverHandshakeState.serverContext;
                processFinished(dTLSReliableHandshake.receiveMessageBody((short) 20), TlsUtils.calculateVerifyData(tlsServerContextImpl, ExporterLabel.client_finished, TlsProtocol.getCurrentPRFHash(tlsServerContextImpl, dTLSReliableHandshake.getHandshakeHash(), null)));
                if (serverHandshakeState.expectSessionTicket) {
                    dTLSReliableHandshake.sendMessage((short) 4, generateNewSessionTicket(serverHandshakeState, serverHandshakeState.server.getNewSessionTicket()));
                }
                TlsServerContextImpl tlsServerContextImpl2 = serverHandshakeState.serverContext;
                dTLSReliableHandshake.sendMessage((short) 20, TlsUtils.calculateVerifyData(tlsServerContextImpl2, ExporterLabel.server_finished, TlsProtocol.getCurrentPRFHash(tlsServerContextImpl2, dTLSReliableHandshake.getHandshakeHash(), null)));
                dTLSReliableHandshake.finish();
                serverHandshakeState.server.notifyHandshakeComplete();
                return new DTLSTransport(dTLSRecordLayer);
            }
            throw new TlsFatalAlert((short) 10);
        }
        throw new TlsFatalAlert((short) 10);
    }

    public void setVerifyRequests(boolean z) {
        this.verifyRequests = z;
    }
}