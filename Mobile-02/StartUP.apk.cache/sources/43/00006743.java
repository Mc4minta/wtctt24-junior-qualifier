package org.spongycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.spongycastle.jce.provider.BouncyCastleProvider;

/* loaded from: classes3.dex */
public class BCJcaJceHelper extends ProviderJcaJceHelper {
    public BCJcaJceHelper() {
        super(getBouncyCastleProvider());
    }

    private static Provider getBouncyCastleProvider() {
        if (Security.getProvider(BouncyCastleProvider.PROVIDER_NAME) != null) {
            return Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        }
        return new BouncyCastleProvider();
    }
}