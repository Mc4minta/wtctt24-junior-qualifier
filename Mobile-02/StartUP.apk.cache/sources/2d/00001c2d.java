package com.coinbase.wallet.ethereum.extensions;

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

/* compiled from: CipherCore+Ethereum.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a'\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a)\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\f\u0010\b\u001a)\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00002\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/coinbase/ciphercore/CipherCoreInterface;", "", "index", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lh/c/b0;", "Lcom/coinbase/ciphercore/KeyPair;", "getEthereumWalletKeyPair", "(Lcom/coinbase/ciphercore/CipherCoreInterface;ILjava/lang/String;)Lh/c/b0;", "Lcom/coinbase/ciphercore/CipherCore$Companion;", "ethereumAddressDerivationPath", "(Lcom/coinbase/ciphercore/CipherCore$Companion;I)Ljava/lang/String;", "ethereumAddress", "derivationPath", "address", "(Lcom/coinbase/ciphercore/CipherCoreInterface;Ljava/lang/String;Ljava/lang/String;)Lh/c/b0;", "keyPair", "ethereum_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class CipherCore_EthereumKt {
    public static /* synthetic */ h0 a(CipherCoreInterface cipherCoreInterface, String str, byte[] bArr) {
        return m1097keyPair$lambda1(cipherCoreInterface, str, bArr);
    }

    public static final b0<String> address(final CipherCoreInterface cipherCoreInterface, String derivationPath, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(derivationPath, "derivationPath");
        m.g(mnemonic, "mnemonic");
        b0 flatMap = keyPair(cipherCoreInterface, derivationPath, mnemonic).flatMap(new n() { // from class: com.coinbase.wallet.ethereum.extensions.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore_EthereumKt.b(CipherCoreInterface.this, (KeyPair) obj);
            }
        });
        m.f(flatMap, "keyPair(derivationPath, mnemonic).flatMap { ethereumAddressFromPublicKey(it.publicKey) }");
        return flatMap;
    }

    /* renamed from: address$lambda-0 */
    public static final h0 m1096address$lambda0(CipherCoreInterface this_address, KeyPair it) {
        m.g(this_address, "$this_address");
        m.g(it, "it");
        return this_address.ethereumAddressFromPublicKey(it.getPublicKey());
    }

    public static /* synthetic */ h0 b(CipherCoreInterface cipherCoreInterface, KeyPair keyPair) {
        return m1096address$lambda0(cipherCoreInterface, keyPair);
    }

    public static final b0<String> ethereumAddress(CipherCoreInterface cipherCoreInterface, int i2, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(mnemonic, "mnemonic");
        return address(cipherCoreInterface, ethereumAddressDerivationPath(CipherCore.Companion, i2), mnemonic);
    }

    public static final String ethereumAddressDerivationPath(CipherCore.Companion companion, int i2) {
        m.g(companion, "<this>");
        return m.o("m/44'/60'/0'/0/", Integer.valueOf(i2));
    }

    public static final b0<KeyPair> getEthereumWalletKeyPair(CipherCoreInterface cipherCoreInterface, int i2, String mnemonic) {
        m.g(cipherCoreInterface, "<this>");
        m.g(mnemonic, "mnemonic");
        return keyPair(cipherCoreInterface, ethereumAddressDerivationPath(CipherCore.Companion, i2), mnemonic);
    }

    private static final b0<KeyPair> keyPair(final CipherCoreInterface cipherCoreInterface, final String str, String str2) {
        b0 flatMap = cipherCoreInterface.seedFromRecoveryPhrase(str2, CipherCore_wordListEnglishKt.getWordListEnglish(CipherCore.Companion)).flatMap(new n() { // from class: com.coinbase.wallet.ethereum.extensions.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return CipherCore_EthereumKt.a(CipherCoreInterface.this, str, (byte[]) obj);
            }
        });
        m.f(flatMap, "this\n    .seedFromRecoveryPhrase(\n        mnemonic,\n        wordList = CipherCore.wordListEnglish\n    )\n    .flatMap { deriveKeyPair(seed = it, derivationPath = derivationPath) }");
        return flatMap;
    }

    /* renamed from: keyPair$lambda-1 */
    public static final h0 m1097keyPair$lambda1(CipherCoreInterface this_keyPair, String derivationPath, byte[] it) {
        m.g(this_keyPair, "$this_keyPair");
        m.g(derivationPath, "$derivationPath");
        m.g(it, "it");
        return this_keyPair.deriveKeyPair(it, derivationPath);
    }
}