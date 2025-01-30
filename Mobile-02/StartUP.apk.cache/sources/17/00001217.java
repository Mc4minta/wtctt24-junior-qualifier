package com.coinbase.wallet.application.repository.interfaces;

import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import h.c.b0;
import kotlin.Metadata;
import kotlin.e0.c.l;

/* compiled from: MnemonicRepositoryInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0005H&¢\u0006\u0004\b\f\u0010\u0007J3\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\rj\u0002`\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J;\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00022\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\rj\u0002`\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\nJ\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0005H&¢\u0006\u0004\b\u001b\u0010\u0007R\u001c\u0010!\u001a\u00020\u001c8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/application/repository/interfaces/MnemonicRepositoryInterface;", "", "", "getActiveMnemonic", "()Ljava/lang/String;", "Lh/c/b0;", "createMnemonic", "()Lh/c/b0;", "Lkotlin/x;", "clearActiveMnemonic", "()V", "", "hasStoredMnemonic", "Lkotlin/Function1;", "Lcom/toshi/crypto/keyhandler/DecryptRequest;", "decryptRequest", "getMnemonicFromStorage", "(Lkotlin/e0/c/l;)Lh/c/b0;", "decryptedMnemonic", "Lcom/toshi/crypto/keyhandler/EncryptRequest;", "encryptRequest", "saveMnemonicToStorage", "(Ljava/lang/String;Lkotlin/e0/c/l;)Lh/c/b0;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "validateMnemonic", "(Ljava/lang/String;)Lh/c/b0;", "deleteMnemonic", "getEncryptedMnemonic", "Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "getBiometricsProtectionType", "()Lcom/coinbase/wallet/application/model/BiometricsProtectionType;", "setBiometricsProtectionType", "(Lcom/coinbase/wallet/application/model/BiometricsProtectionType;)V", "biometricsProtectionType", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public interface MnemonicRepositoryInterface {
    void clearActiveMnemonic();

    b0<String> createMnemonic();

    void deleteMnemonic();

    String getActiveMnemonic();

    BiometricsProtectionType getBiometricsProtectionType();

    b0<String> getEncryptedMnemonic();

    b0<String> getMnemonicFromStorage(l<? super String, ? extends b0<String>> lVar);

    b0<Boolean> hasStoredMnemonic();

    b0<String> saveMnemonicToStorage(String str, l<? super String, ? extends b0<String>> lVar);

    void setBiometricsProtectionType(BiometricsProtectionType biometricsProtectionType);

    b0<String> validateMnemonic(String str);
}