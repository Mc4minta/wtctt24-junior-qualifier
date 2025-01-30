package org.spongycastle.asn1;

import com.reactnativecommunity.webview.RNCWebViewManager;
import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class BEROctetStringGenerator extends BERGenerator {
    public BEROctetStringGenerator(OutputStream outputStream) throws IOException {
        super(outputStream);
        writeBERHeader(36);
    }

    public OutputStream getOctetOutputStream() {
        return getOctetOutputStream(new byte[RNCWebViewManager.COMMAND_CLEAR_FORM_DATA]);
    }

    public OutputStream getOctetOutputStream(byte[] bArr) {
        return new BufferedBEROctetStream(bArr);
    }

    public BEROctetStringGenerator(OutputStream outputStream, int i2, boolean z) throws IOException {
        super(outputStream, i2, z);
        writeBERHeader(36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BufferedBEROctetStream extends OutputStream {
        private byte[] _buf;
        private DEROutputStream _derOut;
        private int _off = 0;

        BufferedBEROctetStream(byte[] bArr) {
            this._buf = bArr;
            this._derOut = new DEROutputStream(BEROctetStringGenerator.this._out);
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            int i2 = this._off;
            if (i2 != 0) {
                byte[] bArr = new byte[i2];
                System.arraycopy(this._buf, 0, bArr, 0, i2);
                DEROctetString.encode(this._derOut, bArr);
            }
            BEROctetStringGenerator.this.writeBEREnd();
        }

        @Override // java.io.OutputStream
        public void write(int i2) throws IOException {
            byte[] bArr = this._buf;
            int i3 = this._off;
            int i4 = i3 + 1;
            this._off = i4;
            bArr[i3] = (byte) i2;
            if (i4 == bArr.length) {
                DEROctetString.encode(this._derOut, bArr);
                this._off = 0;
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) throws IOException {
            while (i3 > 0) {
                int min = Math.min(i3, this._buf.length - this._off);
                System.arraycopy(bArr, i2, this._buf, this._off, min);
                int i4 = this._off + min;
                this._off = i4;
                byte[] bArr2 = this._buf;
                if (i4 < bArr2.length) {
                    return;
                }
                DEROctetString.encode(this._derOut, bArr2);
                this._off = 0;
                i2 += min;
                i3 -= min;
            }
        }
    }
}