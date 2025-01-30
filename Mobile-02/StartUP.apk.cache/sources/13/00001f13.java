package com.coinbase.wallet.features.networking.extensions;

import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.toshi.model.local.DerivationPath;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CipherCore+EthereumExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "index", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "getEthereumWalletKeyPair", "(Lcom/coinbase/ciphercore/CipherCoreInterface;ILjava/lang/String;)Lh/c/b0;", "derivationPath", "keyPair", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherCore_EthereumExtensionsKt {
    public static /* synthetic */ h0 a(CipherCoreInterface cipherCoreInterface, String str, byte[] bArr) {
        return m1296keyPair$lambda0(cipherCoreInterface, str, bArr);
    }

    public static final b0<KeyPair> getEthereumWalletKeyPair(CipherCoreInterface cipherCoreInterface, int i2, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(mnemonic, "mnemonic");
        return keyPair(cipherCoreInterface, DerivationPath.PAYMENT_KEY_PATH.getWithIndex(i2), mnemonic);
    }

    public static final b0<KeyPair> keyPair(final CipherCoreInterface cipherCoreInterface, final String derivationPath, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(derivationPath, "derivationPath");
        m.g(mnemonic, "mnemonic");
        b0<KeyPair> flatMap = CipherCoreInterface.DefaultImpls.seedFromRecoveryPhrase$default(cipherCoreInterface, mnemonic, null, 2, null).flatMap(new n() { // from class: com.coinbase.wallet.features.networking.extensions.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore_EthereumExtensionsKt.a(CipherCoreInterface.this, derivationPath, (byte[]) obj);
            }
        });
        m.f(flatMap, "seedFromRecoveryPhrase(mnemonic)\n                .flatMap { deriveKeyPair(it, derivationPath) }");
        return flatMap;
    }

    /* renamed from: keyPair$lambda-0 */
    public static final h0 m1296keyPair$lambda0(CipherCoreInterface this_keyPair, String derivationPath, byte[] it) {
        m.g(this_keyPair, "$this_keyPair");
        m.g(derivationPath, "$derivationPath");
        m.g(it, "it");
        return this_keyPair.deriveKeyPair(it, derivationPath);
    }
}