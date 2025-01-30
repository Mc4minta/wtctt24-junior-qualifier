package org.spongycastle.pqc.crypto.ntru;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

/* loaded from: classes3.dex */
public class NTRUEncryptionPublicKeyParameters extends NTRUEncryptionKeyParameters {

    /* renamed from: h  reason: collision with root package name */
    public IntegerPolynomial f17861h;

    public NTRUEncryptionPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f17861h = integerPolynomial;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof NTRUEncryptionPublicKeyParameters)) {
            NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters = (NTRUEncryptionPublicKeyParameters) obj;
            IntegerPolynomial integerPolynomial = this.f17861h;
            if (integerPolynomial == null) {
                if (nTRUEncryptionPublicKeyParameters.f17861h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(nTRUEncryptionPublicKeyParameters.f17861h)) {
                return false;
            }
            NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
            if (nTRUEncryptionParameters == null) {
                if (nTRUEncryptionPublicKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUEncryptionParameters.equals(nTRUEncryptionPublicKeyParameters.params)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.f17861h.toBinary(this.params.q);
    }

    public int hashCode() {
        IntegerPolynomial integerPolynomial = this.f17861h;
        int hashCode = ((integerPolynomial == null ? 0 : integerPolynomial.hashCode()) + 31) * 31;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        return hashCode + (nTRUEncryptionParameters != null ? nTRUEncryptionParameters.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUEncryptionPublicKeyParameters(byte[] bArr, NTRUEncryptionParameters nTRUEncryptionParameters) {
        super(false, nTRUEncryptionParameters);
        this.f17861h = IntegerPolynomial.fromBinary(bArr, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
    }

    public NTRUEncryptionPublicKeyParameters(InputStream inputStream, NTRUEncryptionParameters nTRUEncryptionParameters) throws IOException {
        super(false, nTRUEncryptionParameters);
        this.f17861h = IntegerPolynomial.fromBinary(inputStream, nTRUEncryptionParameters.N, nTRUEncryptionParameters.q);
    }
}