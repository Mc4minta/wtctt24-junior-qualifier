package org.spongycastle.crypto.generators;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.math.BigInteger;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.DerivationParameters;
import org.spongycastle.crypto.Mac;
import org.spongycastle.crypto.MacDerivationFunction;
import org.spongycastle.crypto.params.KDFCounterParameters;
import org.spongycastle.crypto.params.KeyParameter;

/* loaded from: classes3.dex */
public class KDFCounterBytesGenerator implements MacDerivationFunction {
    private static final BigInteger INTEGER_MAX = BigInteger.valueOf(2147483647L);
    private static final BigInteger TWO = BigInteger.valueOf(2);
    private byte[] fixedInputDataCtrPrefix;
    private byte[] fixedInputData_afterCtr;
    private int generatedBytes;

    /* renamed from: h  reason: collision with root package name */
    private final int f17798h;
    private byte[] ios;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f17799k;
    private int maxSizeExcl;
    private final Mac prf;

    public KDFCounterBytesGenerator(Mac mac) {
        this.prf = mac;
        int macSize = mac.getMacSize();
        this.f17798h = macSize;
        this.f17799k = new byte[macSize];
    }

    private void generateNext() {
        int i2 = (this.generatedBytes / this.f17798h) + 1;
        byte[] bArr = this.ios;
        int length = bArr.length;
        if (length != 1) {
            if (length != 2) {
                if (length != 3) {
                    if (length == 4) {
                        bArr[0] = (byte) (i2 >>> 24);
                    } else {
                        throw new IllegalStateException("Unsupported size of counter i");
                    }
                }
                bArr[bArr.length - 3] = (byte) (i2 >>> 16);
            }
            bArr[bArr.length - 2] = (byte) (i2 >>> 8);
        }
        bArr[bArr.length - 1] = (byte) i2;
        Mac mac = this.prf;
        byte[] bArr2 = this.fixedInputDataCtrPrefix;
        mac.update(bArr2, 0, bArr2.length);
        Mac mac2 = this.prf;
        byte[] bArr3 = this.ios;
        mac2.update(bArr3, 0, bArr3.length);
        Mac mac3 = this.prf;
        byte[] bArr4 = this.fixedInputData_afterCtr;
        mac3.update(bArr4, 0, bArr4.length);
        this.prf.doFinal(this.f17799k, 0);
    }

    @Override // org.spongycastle.crypto.DerivationFunction
    public int generateBytes(byte[] bArr, int i2, int i3) throws DataLengthException, IllegalArgumentException {
        int i4 = this.generatedBytes;
        int i5 = i4 + i3;
        if (i5 >= 0 && i5 < this.maxSizeExcl) {
            if (i4 % this.f17798h == 0) {
                generateNext();
            }
            int i6 = this.generatedBytes;
            int i7 = this.f17798h;
            int i8 = i6 % i7;
            int min = Math.min(i7 - (i6 % i7), i3);
            System.arraycopy(this.f17799k, i8, bArr, i2, min);
            this.generatedBytes += min;
            int i9 = i3 - min;
            while (true) {
                i2 += min;
                if (i9 <= 0) {
                    return i3;
                }
                generateNext();
                min = Math.min(this.f17798h, i9);
                System.arraycopy(this.f17799k, 0, bArr, i2, min);
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
        if (derivationParameters instanceof KDFCounterParameters) {
            KDFCounterParameters kDFCounterParameters = (KDFCounterParameters) derivationParameters;
            this.prf.init(new KeyParameter(kDFCounterParameters.getKI()));
            this.fixedInputDataCtrPrefix = kDFCounterParameters.getFixedInputDataCounterPrefix();
            this.fixedInputData_afterCtr = kDFCounterParameters.getFixedInputDataCounterSuffix();
            int r = kDFCounterParameters.getR();
            this.ios = new byte[r / 8];
            BigInteger multiply = TWO.pow(r).multiply(BigInteger.valueOf(this.f17798h));
            this.maxSizeExcl = multiply.compareTo(INTEGER_MAX) == 1 ? RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO : multiply.intValue();
            this.generatedBytes = 0;
            return;
        }
        throw new IllegalArgumentException("Wrong type of arguments given");
    }
}