package org.spongycastle.crypto.tls;

import java.io.IOException;

/* loaded from: classes3.dex */
public class DTLSTransport implements DatagramTransport {
    private final DTLSRecordLayer recordLayer;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DTLSTransport(DTLSRecordLayer dTLSRecordLayer) {
        this.recordLayer = dTLSRecordLayer;
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void close() throws IOException {
        this.recordLayer.close();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getReceiveLimit() throws IOException {
        return this.recordLayer.getReceiveLimit();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int getSendLimit() throws IOException {
        return this.recordLayer.getSendLimit();
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public int receive(byte[] bArr, int i2, int i3, int i4) throws IOException {
        try {
            return this.recordLayer.receive(bArr, i2, i3, i4);
        } catch (IOException e2) {
            this.recordLayer.fail((short) 80);
            throw e2;
        } catch (RuntimeException e3) {
            this.recordLayer.fail((short) 80);
            throw new TlsFatalAlert((short) 80, e3);
        } catch (TlsFatalAlert e4) {
            this.recordLayer.fail(e4.getAlertDescription());
            throw e4;
        }
    }

    @Override // org.spongycastle.crypto.tls.DatagramTransport
    public void send(byte[] bArr, int i2, int i3) throws IOException {
        try {
            this.recordLayer.send(bArr, i2, i3);
        } catch (RuntimeException e2) {
            this.recordLayer.fail((short) 80);
            throw new TlsFatalAlert((short) 80, e2);
        } catch (TlsFatalAlert e3) {
            this.recordLayer.fail(e3.getAlertDescription());
            throw e3;
        } catch (IOException e4) {
            this.recordLayer.fail((short) 80);
            throw e4;
        }
    }
}