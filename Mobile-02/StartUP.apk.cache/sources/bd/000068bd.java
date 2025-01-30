package org.spongycastle.pqc.crypto.ntru;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;

/* loaded from: classes3.dex */
public class NTRUSigningPrivateKeyParameters extends AsymmetricKeyParameter {
    private List<Basis> bases;
    private NTRUSigningPublicKeyParameters publicKey;

    public NTRUSigningPrivateKeyParameters(byte[] bArr, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        this(new ByteArrayInputStream(bArr), nTRUSigningKeyGenerationParameters);
    }

    private void add(Basis basis) {
        this.bases.add(basis);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            NTRUSigningPrivateKeyParameters nTRUSigningPrivateKeyParameters = (NTRUSigningPrivateKeyParameters) obj;
            List<Basis> list = this.bases;
            if ((list == null) != (nTRUSigningPrivateKeyParameters.bases == null)) {
                return false;
            }
            if (list == null) {
                return true;
            }
            if (list.size() != nTRUSigningPrivateKeyParameters.bases.size()) {
                return false;
            }
            for (int i2 = 0; i2 < this.bases.size(); i2++) {
                Basis basis = this.bases.get(i2);
                Basis basis2 = nTRUSigningPrivateKeyParameters.bases.get(i2);
                if (!basis.f17864f.equals(basis2.f17864f) || !basis.fPrime.equals(basis2.fPrime)) {
                    return false;
                }
                if ((i2 != 0 && !basis.f17865h.equals(basis2.f17865h)) || !basis.params.equals(basis2.params)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public Basis getBasis(int i2) {
        return this.bases.get(i2);
    }

    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < this.bases.size()) {
            this.bases.get(i2).encode(byteArrayOutputStream, i2 != 0);
            i2++;
        }
        byteArrayOutputStream.write(this.publicKey.getEncoded());
        return byteArrayOutputStream.toByteArray();
    }

    public NTRUSigningPublicKeyParameters getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        List<Basis> list = this.bases;
        if (list == null) {
            return 31;
        }
        int hashCode = 31 + list.hashCode();
        for (Basis basis : this.bases) {
            hashCode += basis.hashCode();
        }
        return hashCode;
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(getEncoded());
    }

    public NTRUSigningPrivateKeyParameters(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) throws IOException {
        super(true);
        this.bases = new ArrayList();
        int i2 = 0;
        while (i2 <= nTRUSigningKeyGenerationParameters.B) {
            add(new Basis(inputStream, nTRUSigningKeyGenerationParameters, i2 != 0));
            i2++;
        }
        this.publicKey = new NTRUSigningPublicKeyParameters(inputStream, nTRUSigningKeyGenerationParameters.getSigningParameters());
    }

    /* loaded from: classes3.dex */
    public static class Basis {

        /* renamed from: f  reason: collision with root package name */
        public Polynomial f17864f;
        public Polynomial fPrime;

        /* renamed from: h  reason: collision with root package name */
        public IntegerPolynomial f17865h;
        NTRUSigningKeyGenerationParameters params;

        /* JADX INFO: Access modifiers changed from: protected */
        public Basis(Polynomial polynomial, Polynomial polynomial2, IntegerPolynomial integerPolynomial, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters) {
            this.f17864f = polynomial;
            this.fPrime = polynomial2;
            this.f17865h = integerPolynomial;
            this.params = nTRUSigningKeyGenerationParameters;
        }

        private byte[] getEncoded(Polynomial polynomial) {
            if (polynomial instanceof ProductFormPolynomial) {
                return ((ProductFormPolynomial) polynomial).toBinary();
            }
            return polynomial.toIntegerPolynomial().toBinary3Tight();
        }

        void encode(OutputStream outputStream, boolean z) throws IOException {
            int i2 = this.params.q;
            outputStream.write(getEncoded(this.f17864f));
            if (this.params.basisType == 0) {
                IntegerPolynomial integerPolynomial = this.fPrime.toIntegerPolynomial();
                int i3 = 0;
                while (true) {
                    int[] iArr = integerPolynomial.coeffs;
                    if (i3 >= iArr.length) {
                        break;
                    }
                    iArr[i3] = iArr[i3] + (i2 / 2);
                    i3++;
                }
                outputStream.write(integerPolynomial.toBinary(i2));
            } else {
                outputStream.write(getEncoded(this.fPrime));
            }
            if (z) {
                outputStream.write(this.f17865h.toBinary(i2));
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Basis)) {
                Basis basis = (Basis) obj;
                Polynomial polynomial = this.f17864f;
                if (polynomial == null) {
                    if (basis.f17864f != null) {
                        return false;
                    }
                } else if (!polynomial.equals(basis.f17864f)) {
                    return false;
                }
                Polynomial polynomial2 = this.fPrime;
                if (polynomial2 == null) {
                    if (basis.fPrime != null) {
                        return false;
                    }
                } else if (!polynomial2.equals(basis.fPrime)) {
                    return false;
                }
                IntegerPolynomial integerPolynomial = this.f17865h;
                if (integerPolynomial == null) {
                    if (basis.f17865h != null) {
                        return false;
                    }
                } else if (!integerPolynomial.equals(basis.f17865h)) {
                    return false;
                }
                NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
                if (nTRUSigningKeyGenerationParameters == null) {
                    if (basis.params != null) {
                        return false;
                    }
                } else if (!nTRUSigningKeyGenerationParameters.equals(basis.params)) {
                    return false;
                }
                return true;
            }
            return false;
        }

        public int hashCode() {
            Polynomial polynomial = this.f17864f;
            int hashCode = ((polynomial == null ? 0 : polynomial.hashCode()) + 31) * 31;
            Polynomial polynomial2 = this.fPrime;
            int hashCode2 = (hashCode + (polynomial2 == null ? 0 : polynomial2.hashCode())) * 31;
            IntegerPolynomial integerPolynomial = this.f17865h;
            int hashCode3 = (hashCode2 + (integerPolynomial == null ? 0 : integerPolynomial.hashCode())) * 31;
            NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters = this.params;
            return hashCode3 + (nTRUSigningKeyGenerationParameters != null ? nTRUSigningKeyGenerationParameters.hashCode() : 0);
        }

        Basis(InputStream inputStream, NTRUSigningKeyGenerationParameters nTRUSigningKeyGenerationParameters, boolean z) throws IOException {
            int i2 = nTRUSigningKeyGenerationParameters.N;
            int i3 = nTRUSigningKeyGenerationParameters.q;
            int i4 = nTRUSigningKeyGenerationParameters.d1;
            int i5 = nTRUSigningKeyGenerationParameters.d2;
            int i6 = nTRUSigningKeyGenerationParameters.d3;
            boolean z2 = nTRUSigningKeyGenerationParameters.sparse;
            this.params = nTRUSigningKeyGenerationParameters;
            if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.f17864f = ProductFormPolynomial.fromBinary(inputStream, i2, i4, i5, i6 + 1, i6);
            } else {
                IntegerPolynomial fromBinary3Tight = IntegerPolynomial.fromBinary3Tight(inputStream, i2);
                this.f17864f = z2 ? new SparseTernaryPolynomial(fromBinary3Tight) : new DenseTernaryPolynomial(fromBinary3Tight);
            }
            if (nTRUSigningKeyGenerationParameters.basisType == 0) {
                IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(inputStream, i2, i3);
                int i7 = 0;
                while (true) {
                    int[] iArr = fromBinary.coeffs;
                    if (i7 >= iArr.length) {
                        break;
                    }
                    iArr[i7] = iArr[i7] - (i3 / 2);
                    i7++;
                }
                this.fPrime = fromBinary;
            } else if (nTRUSigningKeyGenerationParameters.polyType == 1) {
                this.fPrime = ProductFormPolynomial.fromBinary(inputStream, i2, i4, i5, i6 + 1, i6);
            } else {
                this.fPrime = IntegerPolynomial.fromBinary3Tight(inputStream, i2);
            }
            if (z) {
                this.f17865h = IntegerPolynomial.fromBinary(inputStream, i2, i3);
            }
        }
    }

    public NTRUSigningPrivateKeyParameters(List<Basis> list, NTRUSigningPublicKeyParameters nTRUSigningPublicKeyParameters) {
        super(true);
        this.bases = new ArrayList(list);
        this.publicKey = nTRUSigningPublicKeyParameters;
    }
}