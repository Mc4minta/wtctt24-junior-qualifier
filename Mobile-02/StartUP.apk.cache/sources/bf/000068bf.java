package org.spongycastle.pqc.crypto.ntru;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;

/* loaded from: classes3.dex */
public class NTRUSigningPublicKeyParameters extends AsymmetricKeyParameter {

    /* renamed from: h  reason: collision with root package name */
    public IntegerPolynomial f17866h;
    private NTRUSigningParameters params;

    public NTRUSigningPublicKeyParameters(IntegerPolynomial integerPolynomial, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f17866h = integerPolynomial;
        this.params = nTRUSigningParameters;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters = (NTRUSigningPublicKeyParameters) obj;
            IntegerPolynomial integerPolynomial = this.f17866h;
            if (integerPolynomial == null) {
                if (nTRUSigningPublicKeyParameters.f17866h != null) {
                    return false;
                }
            } else if (!integerPolynomial.equals(nTRUSigningPublicKeyParameters.f17866h)) {
                return false;
            }
            NTRUSigningParameters nTRUSigningParameters = this.params;
            if (nTRUSigningParameters == null) {
                if (nTRUSigningPublicKeyParameters.params != null) {
                    return false;
                }
            } else if (!nTRUSigningParameters.equals(nTRUSigningPublicKeyParameters.params)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public byte[] getEncoded() {
        return this.f17866h.toBinary(this.params.q);
    }

    public int hashCode() {
        IntegerPolynomial integerPolynomial = this.f17866h;
        int hashCode = ((integerPolynomial == null ? 0 : integerPolynomial.hashCode()) + 31) * 31;
        NTRUSigningParameters nTRUSigningParameters = this.params;
        return hashCode + (nTRUSigningParameters != null ? nTRUSigningParameters.hashCode() : 0);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPublicKeyParameters(byte[] bArr, NTRUSigningParameters nTRUSigningParameters) {
        super(false);
        this.f17866h = IntegerPolynomial.fromBinary(bArr, nTRUSigningParameters.N, nTRUSigningParameters.q);
        this.params = nTRUSigningParameters;
    }

    public NTRUSigningPublicKeyParameters(InputStream inputStream, NTRUSigningParameters nTRUSigningParameters) throws IOException {
        super(false);
        this.f17866h = IntegerPolynomial.fromBinary(inputStream, nTRUSigningParameters.N, nTRUSigningParameters.q);
        this.params = nTRUSigningParameters;
    }
}