package org.spongycastle.pqc.crypto.ntru;

import java.security.SecureRandom;
import org.spongycastle.crypto.AsymmetricBlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.Digest;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.params.ParametersWithRandom;
import org.spongycastle.pqc.math.ntru.polynomial.DenseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.IntegerPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.Polynomial;
import org.spongycastle.pqc.math.ntru.polynomial.ProductFormPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.SparseTernaryPolynomial;
import org.spongycastle.pqc.math.ntru.polynomial.TernaryPolynomial;
import org.spongycastle.util.Arrays;

/* loaded from: classes3.dex */
public class NTRUEngine implements AsymmetricBlockCipher {
    private boolean forEncryption;
    private NTRUEncryptionParameters params;
    private NTRUEncryptionPrivateKeyParameters privKey;
    private NTRUEncryptionPublicKeyParameters pubKey;
    private SecureRandom random;

    private IntegerPolynomial MGF(byte[] bArr, int i2, int i3, boolean z) {
        Digest digest = this.params.hashAlg;
        int digestSize = digest.getDigestSize();
        byte[] bArr2 = new byte[i3 * digestSize];
        if (z) {
            bArr = calcHash(digest, bArr);
        }
        int i4 = 0;
        while (i4 < i3) {
            digest.update(bArr, 0, bArr.length);
            putInt(digest, i4);
            System.arraycopy(calcHash(digest), 0, bArr2, i4 * digestSize, digestSize);
            i4++;
        }
        IntegerPolynomial integerPolynomial = new IntegerPolynomial(i2);
        while (true) {
            int i5 = 0;
            for (int i6 = 0; i6 != bArr2.length; i6++) {
                int i7 = bArr2[i6] & 255;
                if (i7 < 243) {
                    for (int i8 = 0; i8 < 4; i8++) {
                        int i9 = i7 % 3;
                        integerPolynomial.coeffs[i5] = i9 - 1;
                        i5++;
                        if (i5 == i2) {
                            return integerPolynomial;
                        }
                        i7 = (i7 - i9) / 3;
                    }
                    integerPolynomial.coeffs[i5] = i7 - 1;
                    i5++;
                    if (i5 == i2) {
                        return integerPolynomial;
                    }
                }
            }
            if (i5 >= i2) {
                return integerPolynomial;
            }
            digest.update(bArr, 0, bArr.length);
            putInt(digest, i4);
            bArr2 = calcHash(digest);
            i4++;
        }
    }

    private byte[] buildSData(byte[] bArr, byte[] bArr2, int i2, byte[] bArr3, byte[] bArr4) {
        byte[] bArr5 = new byte[bArr.length + i2 + bArr3.length + bArr4.length];
        System.arraycopy(bArr, 0, bArr5, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr5, bArr.length, bArr2.length);
        System.arraycopy(bArr3, 0, bArr5, bArr.length + bArr2.length, bArr3.length);
        System.arraycopy(bArr4, 0, bArr5, bArr.length + bArr2.length + bArr3.length, bArr4.length);
        return bArr5;
    }

    private byte[] calcHash(Digest digest) {
        byte[] bArr = new byte[digest.getDigestSize()];
        digest.doFinal(bArr, 0);
        return bArr;
    }

    private byte[] copyOf(byte[] bArr, int i2) {
        byte[] bArr2 = new byte[i2];
        if (i2 >= bArr.length) {
            i2 = bArr.length;
        }
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        return bArr2;
    }

    private byte[] decrypt(byte[] bArr, NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters) throws InvalidCipherTextException {
        Polynomial polynomial = nTRUEncryptionPrivateKeyParameters.t;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPrivateKeyParameters.fp;
        IntegerPolynomial integerPolynomial2 = nTRUEncryptionPrivateKeyParameters.f17860h;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int i2 = nTRUEncryptionParameters.N;
        int i3 = nTRUEncryptionParameters.q;
        int i4 = nTRUEncryptionParameters.db;
        int i5 = nTRUEncryptionParameters.maxMsgLenBytes;
        int i6 = nTRUEncryptionParameters.dm0;
        int i7 = nTRUEncryptionParameters.pkLen;
        int i8 = nTRUEncryptionParameters.minCallsMask;
        boolean z = nTRUEncryptionParameters.hashSeed;
        byte[] bArr2 = nTRUEncryptionParameters.oid;
        if (i5 <= 255) {
            int i9 = i4 / 8;
            IntegerPolynomial fromBinary = IntegerPolynomial.fromBinary(bArr, i2, i3);
            IntegerPolynomial decrypt = decrypt(fromBinary, polynomial, integerPolynomial);
            if (decrypt.count(-1) >= i6) {
                if (decrypt.count(0) >= i6) {
                    if (decrypt.count(1) >= i6) {
                        IntegerPolynomial integerPolynomial3 = (IntegerPolynomial) fromBinary.clone();
                        integerPolynomial3.sub(decrypt);
                        integerPolynomial3.modPositive(i3);
                        IntegerPolynomial integerPolynomial4 = (IntegerPolynomial) integerPolynomial3.clone();
                        integerPolynomial4.modPositive(4);
                        decrypt.sub(MGF(integerPolynomial4.toBinary(4), i2, i8, z));
                        decrypt.mod3();
                        byte[] binary3Sves = decrypt.toBinary3Sves();
                        byte[] bArr3 = new byte[i9];
                        System.arraycopy(binary3Sves, 0, bArr3, 0, i9);
                        int i10 = 255 & binary3Sves[i9];
                        if (i10 <= i5) {
                            byte[] bArr4 = new byte[i10];
                            int i11 = i9 + 1;
                            System.arraycopy(binary3Sves, i11, bArr4, 0, i10);
                            int i12 = i11 + i10;
                            int length = binary3Sves.length - i12;
                            byte[] bArr5 = new byte[length];
                            System.arraycopy(binary3Sves, i12, bArr5, 0, length);
                            if (Arrays.constantTimeAreEqual(bArr5, new byte[length])) {
                                IntegerPolynomial mult = generateBlindingPoly(buildSData(bArr2, bArr4, i10, bArr3, copyOf(integerPolynomial2.toBinary(i3), i7 / 8)), bArr4).mult(integerPolynomial2);
                                mult.modPositive(i3);
                                if (mult.equals(integerPolynomial3)) {
                                    return bArr4;
                                }
                                throw new InvalidCipherTextException("Invalid message encoding");
                            }
                            throw new InvalidCipherTextException("The message is not followed by zeroes");
                        }
                        throw new InvalidCipherTextException("Message too long: " + i10 + ">" + i5);
                    }
                    throw new InvalidCipherTextException("Less than dm0 coefficients equal 1");
                }
                throw new InvalidCipherTextException("Less than dm0 coefficients equal 0");
            }
            throw new InvalidCipherTextException("Less than dm0 coefficients equal -1");
        }
        throw new DataLengthException("maxMsgLenBytes values bigger than 255 are not supported");
    }

    private byte[] encrypt(byte[] bArr, NTRUEncryptionPublicKeyParameters nTRUEncryptionPublicKeyParameters) {
        byte[] bArr2 = bArr;
        IntegerPolynomial integerPolynomial = nTRUEncryptionPublicKeyParameters.f17861h;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        int i2 = nTRUEncryptionParameters.N;
        int i3 = nTRUEncryptionParameters.q;
        int i4 = nTRUEncryptionParameters.maxMsgLenBytes;
        int i5 = nTRUEncryptionParameters.db;
        int i6 = nTRUEncryptionParameters.bufferLenBits;
        int i7 = nTRUEncryptionParameters.dm0;
        int i8 = nTRUEncryptionParameters.pkLen;
        int i9 = nTRUEncryptionParameters.minCallsMask;
        boolean z = nTRUEncryptionParameters.hashSeed;
        byte[] bArr3 = nTRUEncryptionParameters.oid;
        int length = bArr2.length;
        if (i4 > 255) {
            throw new IllegalArgumentException("llen values bigger than 1 are not supported");
        }
        if (length > i4) {
            throw new DataLengthException("Message too long: " + length + ">" + i4);
        }
        while (true) {
            int i10 = i5 / 8;
            byte[] bArr4 = new byte[i10];
            boolean z2 = z;
            this.random.nextBytes(bArr4);
            int i11 = (i4 + 1) - length;
            int i12 = i9;
            int i13 = i5;
            byte[] bArr5 = new byte[i6 / 8];
            int i14 = i6;
            System.arraycopy(bArr4, 0, bArr5, 0, i10);
            bArr5[i10] = (byte) length;
            int i15 = i10 + 1;
            System.arraycopy(bArr2, 0, bArr5, i15, bArr2.length);
            System.arraycopy(new byte[i11], 0, bArr5, i15 + bArr2.length, i11);
            IntegerPolynomial fromBinary3Sves = IntegerPolynomial.fromBinary3Sves(bArr5, i2);
            int i16 = length;
            byte[] bArr6 = bArr3;
            int i17 = i8;
            IntegerPolynomial mult = generateBlindingPoly(buildSData(bArr3, bArr, i16, bArr4, copyOf(integerPolynomial.toBinary(i3), i8 / 8)), bArr5).mult(integerPolynomial, i3);
            IntegerPolynomial integerPolynomial2 = (IntegerPolynomial) mult.clone();
            integerPolynomial2.modPositive(4);
            fromBinary3Sves.add(MGF(integerPolynomial2.toBinary(4), i2, i12, z2));
            fromBinary3Sves.mod3();
            if (fromBinary3Sves.count(-1) >= i7 && fromBinary3Sves.count(0) >= i7 && fromBinary3Sves.count(1) >= i7) {
                mult.add(fromBinary3Sves, i3);
                mult.ensurePositive(i3);
                return mult.toBinary(i3);
            }
            z = z2;
            i9 = i12;
            i8 = i17;
            i5 = i13;
            i6 = i14;
            length = i16;
            bArr3 = bArr6;
            bArr2 = bArr;
        }
    }

    private int[] generateBlindingCoeffs(IndexGenerator indexGenerator, int i2) {
        int[] iArr = new int[this.params.N];
        for (int i3 = -1; i3 <= 1; i3 += 2) {
            int i4 = 0;
            while (i4 < i2) {
                int nextIndex = indexGenerator.nextIndex();
                if (iArr[nextIndex] == 0) {
                    iArr[nextIndex] = i3;
                    i4++;
                }
            }
        }
        return iArr;
    }

    private Polynomial generateBlindingPoly(byte[] bArr, byte[] bArr2) {
        IndexGenerator indexGenerator = new IndexGenerator(bArr, this.params);
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters.polyType == 1) {
            return new ProductFormPolynomial(new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, nTRUEncryptionParameters.dr1)), new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, this.params.dr2)), new SparseTernaryPolynomial(generateBlindingCoeffs(indexGenerator, this.params.dr3)));
        }
        int i2 = nTRUEncryptionParameters.dr;
        boolean z = nTRUEncryptionParameters.sparse;
        int[] generateBlindingCoeffs = generateBlindingCoeffs(indexGenerator, i2);
        if (z) {
            return new SparseTernaryPolynomial(generateBlindingCoeffs);
        }
        return new DenseTernaryPolynomial(generateBlindingCoeffs);
    }

    private int log2(int i2) {
        if (i2 == 2048) {
            return 11;
        }
        throw new IllegalStateException("log2 not fully implemented");
    }

    private void putInt(Digest digest, int i2) {
        digest.update((byte) (i2 >> 24));
        digest.update((byte) (i2 >> 16));
        digest.update((byte) (i2 >> 8));
        digest.update((byte) i2);
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getInputBlockSize() {
        return this.params.maxMsgLenBytes;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public int getOutputBlockSize() {
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        return ((nTRUEncryptionParameters.N * log2(nTRUEncryptionParameters.q)) + 7) / 8;
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public void init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.random = parametersWithRandom.getRandom();
                this.pubKey = (NTRUEncryptionPublicKeyParameters) parametersWithRandom.getParameters();
            } else {
                this.random = new SecureRandom();
                this.pubKey = (NTRUEncryptionPublicKeyParameters) cipherParameters;
            }
            this.params = this.pubKey.getParameters();
            return;
        }
        NTRUEncryptionPrivateKeyParameters nTRUEncryptionPrivateKeyParameters = (NTRUEncryptionPrivateKeyParameters) cipherParameters;
        this.privKey = nTRUEncryptionPrivateKeyParameters;
        this.params = nTRUEncryptionPrivateKeyParameters.getParameters();
    }

    @Override // org.spongycastle.crypto.AsymmetricBlockCipher
    public byte[] processBlock(byte[] bArr, int i2, int i3) throws InvalidCipherTextException {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        if (this.forEncryption) {
            return encrypt(bArr2, this.pubKey);
        }
        return decrypt(bArr2, this.privKey);
    }

    private byte[] calcHash(Digest digest, byte[] bArr) {
        byte[] bArr2 = new byte[digest.getDigestSize()];
        digest.update(bArr, 0, bArr.length);
        digest.doFinal(bArr2, 0);
        return bArr2;
    }

    protected IntegerPolynomial encrypt(IntegerPolynomial integerPolynomial, TernaryPolynomial ternaryPolynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial mult = ternaryPolynomial.mult(integerPolynomial2, this.params.q);
        mult.add(integerPolynomial, this.params.q);
        mult.ensurePositive(this.params.q);
        return mult;
    }

    protected IntegerPolynomial decrypt(IntegerPolynomial integerPolynomial, Polynomial polynomial, IntegerPolynomial integerPolynomial2) {
        IntegerPolynomial mult;
        NTRUEncryptionParameters nTRUEncryptionParameters = this.params;
        if (nTRUEncryptionParameters.fastFp) {
            mult = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
            mult.mult(3);
            mult.add(integerPolynomial);
        } else {
            mult = polynomial.mult(integerPolynomial, nTRUEncryptionParameters.q);
        }
        mult.center0(this.params.q);
        mult.mod3();
        if (!this.params.fastFp) {
            mult = new DenseTernaryPolynomial(mult).mult(integerPolynomial2, 3);
        }
        mult.center0(3);
        return mult;
    }
}