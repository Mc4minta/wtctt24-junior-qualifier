package com.coinbase.wallet.ripple.extensions;

import com.coinbase.ciphercore.CipherCore;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.ciphercore.CipherCore_wordListEnglishKt;
import com.coinbase.ciphercore.KeyPair;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import h.c.b0;
import h.c.h0;
import h.c.m0.n;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: CipherCoreInterface+Ripple.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "index", "", "xrpDerivationPath", "(Lcom/coinbase/ciphercore/CipherCoreInterface;I)Ljava/lang/String;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "getXrpWalletKeyPair", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Ljava/lang/String;)Lh/c/b0;", "ripple_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CipherCoreInterface_RippleKt {
    public static /* synthetic */ h0 a(CipherCoreInterface cipherCoreInterface, byte[] bArr) {
        return m1645getXrpWalletKeyPair$lambda0(cipherCoreInterface, bArr);
    }

    public static final b0<KeyPair> getXrpWalletKeyPair(final CipherCoreInterface cipherCoreInterface, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(mnemonic, "mnemonic");
        b0 flatMap = cipherCoreInterface.seedFromRecoveryPhrase(mnemonic, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion)).flatMap(new n() { // from class: com.coinbase.wallet.ripple.extensions.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCoreInterface_RippleKt.a(CipherCoreInterface.this, (byte[]) obj);
            }
        });
        m.f(flatMap, "seedFromRecoveryPhrase(mnemonic, CipherCore.wordListEnglish)\n    .flatMap { deriveKeyPair(it, xrpDerivationPath(0)) }");
        return flatMap;
    }

    /* renamed from: getXrpWalletKeyPair$lambda-0 */
    public static final h0 m1645getXrpWalletKeyPair$lambda0(CipherCoreInterface this_getXrpWalletKeyPair, byte[] it) {
        m.g(this_getXrpWalletKeyPair, "$this_getXrpWalletKeyPair");
        m.g(it, "it");
        return this_getXrpWalletKeyPair.deriveKeyPair(it, xrpDerivationPath(this_getXrpWalletKeyPair, 0));
    }

    public static final String xrpDerivationPath(CipherCoreInterface cipherCoreInterface, int i2) {
        m.g(cipherCoreInterface, "<this>");
        return m.o("m/44'/144'/0'/0/", Integer.valueOf(i2));
    }
}