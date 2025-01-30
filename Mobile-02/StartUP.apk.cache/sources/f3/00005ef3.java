package org.spongycastle.asn1;

import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.io.Streams;

/* loaded from: classes3.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1String {
    private static final char[] table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    protected final byte[] data;
    protected final int padBits;

    public ASN1BitString(byte[] bArr, int i2) {
        Objects.requireNonNull(bArr, "data cannot be null");
        if (bArr.length == 0 && i2 != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        if (i2 <= 7 && i2 >= 0) {
            this.data = Arrays.clone(bArr);
            this.padBits = i2;
            return;
        }
        throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] derForm(byte[] bArr, int i2) {
        byte[] clone = Arrays.clone(bArr);
        if (i2 > 0) {
            int length = bArr.length - 1;
            clone[length] = (byte) ((255 << i2) & clone[length]);
        }
        return clone;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ASN1BitString fromInputStream(int i2, InputStream inputStream) throws IOException {
        if (i2 >= 1) {
            int read = inputStream.read();
            int i3 = i2 - 1;
            byte[] bArr = new byte[i3];
            if (i3 != 0) {
                if (Streams.readFully(inputStream, bArr) != i3) {
                    throw new EOFException("EOF encountered in middle of BIT STRING");
                }
                if (read > 0 && read < 8) {
                    int i4 = i3 - 1;
                    if (bArr[i4] != ((byte) (bArr[i4] & (255 << read)))) {
                        return new DLBitString(bArr, read);
                    }
                }
            }
            return new DERBitString(bArr, read);
        }
        throw new IllegalArgumentException("truncated BIT STRING detected");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] getBytes(int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        int i3 = 4;
        for (int i4 = 3; i4 >= 1 && ((255 << (i4 * 8)) & i2) == 0; i4--) {
            i3--;
        }
        byte[] bArr = new byte[i3];
        for (int i5 = 0; i5 < i3; i5++) {
            bArr[i5] = (byte) ((i2 >> (i5 * 8)) & 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int getPadBits(int i2) {
        int i3;
        int i4 = 3;
        while (true) {
            if (i4 < 0) {
                i3 = 0;
                break;
            } else if (i4 != 0) {
                int i5 = i2 >> (i4 * 8);
                if (i5 != 0) {
                    i3 = i5 & 255;
                    break;
                }
                i4--;
            } else if (i2 != 0) {
                i3 = i2 & 255;
                break;
            } else {
                i4--;
            }
        }
        if (i3 == 0) {
            return 0;
        }
        int i6 = 1;
        while (true) {
            i3 <<= 1;
            if ((i3 & 255) == 0) {
                return 8 - i6;
            }
            i6++;
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive
    protected boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1BitString) {
            ASN1BitString aSN1BitString = (ASN1BitString) aSN1Primitive;
            return this.padBits == aSN1BitString.padBits && Arrays.areEqual(getBytes(), aSN1BitString.getBytes());
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public abstract void encode(ASN1OutputStream aSN1OutputStream) throws IOException;

    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    public byte[] getOctets() {
        if (this.padBits == 0) {
            return Arrays.clone(this.data);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    public int getPadBits() {
        return this.padBits;
    }

    @Override // org.spongycastle.asn1.ASN1String
    public String getString() {
        StringBuffer stringBuffer = new StringBuffer("#");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ASN1OutputStream(byteArrayOutputStream).writeObject(this);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            for (int i2 = 0; i2 != byteArray.length; i2++) {
                char[] cArr = table;
                stringBuffer.append(cArr[(byteArray[i2] >>> 4) & 15]);
                stringBuffer.append(cArr[byteArray[i2] & 15]);
            }
            return stringBuffer.toString();
        } catch (IOException e2) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e2.getMessage(), e2);
        }
    }

    @Override // org.spongycastle.asn1.ASN1Primitive, org.spongycastle.asn1.ASN1Object
    public int hashCode() {
        return this.padBits ^ Arrays.hashCode(getBytes());
    }

    public int intValue() {
        byte[] bArr = this.data;
        int i2 = this.padBits;
        if (i2 > 0 && bArr.length <= 4) {
            bArr = derForm(bArr, i2);
        }
        int i3 = 0;
        for (int i4 = 0; i4 != bArr.length && i4 != 4; i4++) {
            i3 |= (bArr[i4] & 255) << (i4 * 8);
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.data, this.padBits);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // org.spongycastle.asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.data, this.padBits);
    }

    public String toString() {
        return getString();
    }

    public byte[] getBytes() {
        return derForm(this.data, this.padBits);
    }
}