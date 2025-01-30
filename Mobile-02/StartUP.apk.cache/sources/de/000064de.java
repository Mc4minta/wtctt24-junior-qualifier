package org.spongycastle.jcajce.provider.config;

import javax.crypto.spec.DHParameterSpec;
import org.spongycastle.jce.spec.ECParameterSpec;

/* loaded from: classes3.dex */
public interface ProviderConfiguration {
    DHParameterSpec getDHDefaultParameters(int i2);

    ECParameterSpec getEcImplicitlyCa();
}