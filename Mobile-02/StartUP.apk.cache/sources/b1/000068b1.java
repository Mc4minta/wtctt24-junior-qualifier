package org.spongycastle.pqc.crypto.ntru;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;

/* loaded from: classes3.dex */
public class NTRUEncryptionPrivateKeyParameters extends NTRUEncryptionKeyParameters {
    public IntegerPolynomial fp;

    /* renamed from: h  reason: collision with root package name */
    public IntegerPolynomial f17860h;
    public Polynomial t;

    public NTRUEncryptionPrivateKeyParameters(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(true, nTRUEncryptionParameters);
        this.f17860h = integerPolynomial;
        this.t = polynomial;
        this.fp = integerPolynomial2;
    }

    private void init() {
        if (this.params.fastFp) {
            IntegerPolynomial integerPolynomial = new IntegerPolynomial(this.params.N);
            this.fp = integerPolynomial;
            integerPolynomial.coeffs[0] = 1;
            return;
        }
        this.fp = this.t.toIntegerPolynomial().invertF3();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUEncryptionPrivateKeyParameters)) {
            NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) obj;
            NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
            if (nTRUEncryptionParameters == null) {
                if (nTRUEncryptionPrivateKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPrivateKeyParameters.params)) {
                return false;
            }
            Polynomial polynomial = this.t;
            if (polynomial == null) {
                if (nTRUEncryptionPrivateKeyParameters.t != null) {
                    return false;
                }
            } else if (!polynomial.equals(nTRUEncryptionPrivateKeyParameters.t)) {
                return false;
            }
            return this.f17860h.equals(nTRUEncryptionPrivateKeyParameters.f17860h);
        }
        return false;
    }

    public byte[] getEncoded() {
        byte[] binary3Tight;
        byte[] binary = this.f17860h.toBinary(this.params.q);
        Polynomial polynomial = this.t;
        if (polynomial instanceof ProductFormPolynomial) {
            binary3Tight = ((ProductFormPolynomial) polynomial).toBinary();
        } else {
            binary3Tight = polynomial.toIntegerPolynomial().toBinary3Tight();
        }
        byte[] bArr = new byte[binary.length + binary3Tight.length];
        System.arraycopy(binary, 0, bArr, 0, binary.length);
        System.arraycopy(binary3Tight, 0, bArr, binary.length, binary3Tight.length);
        return bArr;
    }

    public int hashCode() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int hashCode = ((nTRUEncryptionParameters == null ? 0 : nTRUEncryptionParameters.hashCode()) + 31) * 31;
        Polynomial polynomial = this.t;
        int hashCode2 = (hashCode + (polynomial == null ? 0 : polynomial.hashCode())) * 31;
        IntegerPolynomial integerPolynomial = this.f17860h;
        return hashCode2 + (integerPolynomial != null ? integerPolynomial.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPrivateKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        this(new ByteArrayInputStream(bArr), nTRUEncryptionParameters);
    }

    public NTRUEncryptionPrivateKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        super(true, nTRUEncryptionParameters);
        if (nTRUEncryptionParameters.polyType == 1) {
            int i2 = nTRUEncryptionParameters.N;
            int i3 = nTRUEncryptionParameters.df1;
            int i4 = nTRUEncryptionParameters.df2;
            int i5 = nTRUEncryptionParameters.df3;
            int i6 = nTRUEncryptionParameters.fastFp ? i5 : i5 - 1;
            this.f17860h = IntegerPolynomial.fromBinary(inputStream, i2, nTRUEncryptionParameters.q);
            this.t = ProductFormPolynomial.fromBinary(inputStream, i2, i3, i4, i5, i6);
        } else {
            this.f17860h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
            IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, nTRUEncryptionParameters.N);
            this.t = nTRUEncryptionParameters.sparse ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
        }
        init();
    }
}