package org.spongycastle.crypto.generators;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFDoublePipelineIterationParameters;
import org.spongycastle.crypto.params.KeyParameter;

/* loaded from: classes3.dex */
public class KDFDoublePipelineIterationBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] a;
    private byte[] fixedInputData;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f17800h;
    private byte[] ios;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f17801k;
    private int maxSizeExcl;
    private final Mac prf;
    private boolean useCounter;

    public KDFDoublePipelineIterationBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f17800h = macSize;
        this.a = new byte[macSize];
        this.f17801k = new byte[macSize];
    }

    private void generateNext() {
        if (this.generatedBytes == 0) {
            Mac mac = this.prf;
            byte[] bArr = this.fixedInputData;
            mac.update(bArr, 0, bArr.length);
            this.prf.doFinal(this.a, 0);
        } else {
            Mac mac2 = this.prf;
            byte[] bArr2 = this.a;
            mac2.update(bArr2, 0, bArr2.length);
            this.prf.doFinal(this.a, 0);
        }
        Mac mac3 = this.prf;
        byte[] bArr3 = this.a;
        mac3.update(bArr3, 0, bArr3.length);
        if (this.useCounter) {
            int i2 = (this.generatedBytes / this.f17800h) + 1;
            byte[] bArr4 = this.ios;
            int length = bArr4.length;
            if (length != 1) {
                if (length != 2) {
                    if (length != 3) {
                        if (length == 4) {
                            bArr4[0] = (byte) (i2 >>> 24);
                        } else {
                            throw new IllegalStateException("Unsupported size of counter i");
                        }
                    }
                    bArr4[bArr4.length - 3] = (byte) (i2 >>> 16);
                }
                bArr4[bArr4.length - 2] = (byte) (i2 >>> 8);
            }
            bArr4[bArr4.length - 1] = (byte) i2;
            this.prf.update(bArr4, 0, bArr4.length);
        }
        Mac mac4 = this.prf;
        byte[] bArr5 = this.fixedInputData;
        mac4.update(bArr5, 0, bArr5.length);
        this.prf.doFinal(this.f17801k, 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = this.generatedBytes;
        int i5 = i4 + i3;
        if (i5 >= 0 && i5 < this.maxSizeExcl) {
            if (i4 % this.f17800h == 0) {
                generateNext();
            }
            int i6 = this.generatedBytes;
            int i7 = this.f17800h;
            int i8 = i6 % i7;
            int min = Math.min(i7 - (i6 % i7), i3);
            System.arraycopy(this.f17801k, i8, bArr, i2, min);
            this.generatedBytes += min;
            int i9 = i3 - min;
            while (true) {
                i2 += min;
                if (i9 <= 0) {
                    return i3;
                }
                generateNext();
                min = Math.min(this.f17800h, i9);
                System.arraycopy(this.f17801k, 0, bArr, i2, min);
                this.generatedBytes += min;
                i9 -= min;
            }
        } else {
            throw new DataLengthException("Current KDFCTR may only be used for " + this.maxSizeExcl + " bytes");
        }
    }

    @Override // org.spongycastle.crypto.MacDerivationFunction
    public Mac getMac() {
        return this.prf;
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public void init(DerivationParameters derivationParameters) {
        if (derivationParameters instanceof KDFDoublePipelineIterationParameters) {
            KDFDoublePipelineIterationParameters kDFDoublePipelineIterationParameters = (KDFDoublePipelineIterationParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFDoublePipelineIterationParameters.getKI()));
            this.fixedInputData = kDFDoublePipelineIterationParameters.getFixedInputData();
            int r = kDFDoublePipelineIterationParameters.getR();
            this.ios = new byte[r / 8];
            boolean useCounter = kDFDoublePipelineIterationParameters.useCounter();
            int i2 = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            if (useCounter) {
                BigInteger multiply = TWO.pow(r).multiply(BigInteger.valueOf(this.f17800h));
                if (multiply.compareTo(INTEGER_MAX) != 1) {
                    i2 = multiply.intValue();
                }
                this.maxSizeExcl = i2;
            } else {
                this.maxSizeExcl = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
            }
            this.useCounter = kDFDoublePipelineIterationParameters.useCounter();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}