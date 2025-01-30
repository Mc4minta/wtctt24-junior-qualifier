package com.coinbase.wallet.stellar.extensions;

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

/* compiled from: CipherCoreInterface+Stellar.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "index", "", "stellarDerivationPath", "(Lcom/coinbase/ciphercore/CipherCoreInterface;I)Ljava/lang/String;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "getStellarWalletKeyPair", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Ljava/lang/String;)Lh/c/b0;", "stellar_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class CipherCoreInterface_StellarKt {
    public static /* synthetic */ h0 a(CipherCoreInterface cipherCoreInterface, byte[] bArr) {
        return m1694getStellarWalletKeyPair$lambda0(cipherCoreInterface, bArr);
    }

    public static final b0<KeyPair> getStellarWalletKeyPair(final CipherCoreInterface cipherCoreInterface, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(mnemonic, "mnemonic");
        b0 flatMap = cipherCoreInterface.seedFromRecoveryPhrase(mnemonic, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion)).flatMap(new n() { // from class: com.coinbase.wallet.stellar.extensions.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCoreInterface_StellarKt.a(CipherCoreInterface.this, (byte[]) obj);
            }
        });
        m.f(flatMap, "seedFromRecoveryPhrase(mnemonic, wordList = CipherCore.wordListEnglish)\n    .flatMap { deriveEd25519KeyPair(seed = it, derivationPath = stellarDerivationPath(0)) }");
        return flatMap;
    }

    /* renamed from: getStellarWalletKeyPair$lambda-0 */
    public static final h0 m1694getStellarWalletKeyPair$lambda0(CipherCoreInterface this_getStellarWalletKeyPair, byte[] it) {
        m.g(this_getStellarWalletKeyPair, "$this_getStellarWalletKeyPair");
        m.g(it, "it");
        return this_getStellarWalletKeyPair.deriveEd25519KeyPair(it, stellarDerivationPath(this_getStellarWalletKeyPair, 0));
    }

    public static final String stellarDerivationPath(CipherCoreInterface cipherCoreInterface, int i2) {
        m.g(cipherCoreInterface, "<this>");
        return "m/44'/148'/" + i2 + '\'';
    }
}