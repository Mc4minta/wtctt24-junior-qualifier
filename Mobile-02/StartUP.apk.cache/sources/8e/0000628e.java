package org.spongycastle.crypto.params;

import java.security.SecureRandom;

/* loaded from: classes3.dex */
public class DSAParameterGenerationParameters {
    public static final int DIGITAL_SIGNATURE_USAGE = 1;
    public static final int KEY_ESTABLISHMENT_USAGE = 2;
    private final int certainty;

    /* renamed from: l  reason: collision with root package name */
    private final int f17813l;
    private final int n;
    private final SecureRandom random;
    private final int usageIndex;

    public DSAParameterGenerationParameters(int i2, int i3, int i4, SecureRandom secureRandom) {
        this(i2, i3, i4, secureRandom, -1);
    }

    public int getCertainty() {
        return this.certainty;
    }

    public int getL() {
        return this.f17813l;
    }

    public int getN() {
        return this.n;
    }

    public SecureRandom getRandom() {
        return this.random;
    }

    public int getUsageIndex() {
        return this.usageIndex;
    }

    public DSAParameterGenerationParameters(int i2, int i3, int i4, SecureRandom secureRandom, int i5) {
        this.f17813l = i2;
        this.n = i3;
        this.certainty = i4;
        this.usageIndex = i5;
        this.random = secureRandom;
    }
}