package org.spongycastle.asn1;

import java.io.IOException;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public class ASN1OutputStream {
    private OutputStream os;

    /* loaded from: classes3.dex */
    private class ImplicitOutputStream extends ASN1OutputStream {
        private boolean first;

        public ImplicitOutputStream(OutputStream outputStream) {
            super(outputStream);
            this.first = true;
        }

        @Override // org.spongycastle.asn1.ASN1OutputStream
        public void write(int i2) throws IOException {
            if (this.first) {
                this.first = false;
            } else {
                super.write(i2);
            }
        }
    }

    public ASN1OutputStream(OutputStream outputStream) {
        this.os = outputStream;
    }

    public void close() throws IOException {
        this.os.close();
    }

    public void flush() throws IOException {
        this.os.flush();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1OutputStream getDERSubStream() {
        return new DEROutputStream(this.os);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ASN1OutputStream getDLSubStream() {
        return new DLOutputStream(this.os);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(int i2) throws IOException {
        this.os.write(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeEncoded(int i2, byte[] bArr) throws IOException {
        write(i2);
        writeLength(bArr.length);
        write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeImplicitObject(ASN1Primitive aSN1Primitive) throws IOException {
        if (aSN1Primitive != null) {
            aSN1Primitive.encode(new ImplicitOutputStream(this.os));
            return;
        }
        throw new IOException("null object detected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeLength(int i2) throws IOException {
        if (i2 > 127) {
            int i3 = i2;
            int i4 = 1;
            while (true) {
                i3 >>>= 8;
                if (i3 == 0) {
                    break;
                }
                i4++;
            }
            write((byte) (i4 | 128));
            for (int i5 = (i4 - 1) * 8; i5 >= 0; i5 -= 8) {
                write((byte) (i2 >> i5));
            }
            return;
        }
        write((byte) i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeNull() throws IOException {
        this.os.write(5);
        this.os.write(0);
    }

    public void writeObject(ASN1Encodable aSN1Encodable) throws IOException {
        if (aSN1Encodable != null) {
            aSN1Encodable.toASN1Primitive().encode(this);
            return;
        }
        throw new IOException("null object detected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTag(int i2, int i3) throws IOException {
        if (i3 < 31) {
            write(i2 | i3);
            return;
        }
        write(i2 | 31);
        if (i3 < 128) {
            write(i3);
            return;
        }
        byte[] bArr = new byte[5];
        int i4 = 4;
        bArr[4] = (byte) (i3 & 127);
        do {
            i3 >>= 7;
            i4--;
            bArr[i4] = (byte) ((i3 & 127) | 128);
        } while (i3 > 127);
        write(bArr, i4, 5 - i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void write(byte[] bArr) throws IOException {
        this.os.write(bArr);
    }

    void write(byte[] bArr, int i2, int i3) throws IOException {
        this.os.write(bArr, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeEncoded(int i2, int i3, byte[] bArr) throws IOException {
        writeTag(i2, i3);
        writeLength(bArr.length);
        write(bArr);
    }
}