package com.coinbase.wallet.features.cloudbackup.extensions;

import com.coinbase.wallet.store.models.MemoryStoreKey;
import com.coinbase.wallet.store.models.StoreKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: StoreKeys+CloudBackup.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\"\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/store/models/StoreKeys;", "Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "", "getHasSeenFirstBackupPrompt", "(Lcom/coinbase/wallet/store/models/StoreKeys;)Lcom/coinbase/wallet/store/models/MemoryStoreKey;", "hasSeenFirstBackupPrompt", "getHasSeenBackupPrompt", "hasSeenBackupPrompt", "getHasSeenOnboardingBackupPrompt", "hasSeenOnboardingBackupPrompt", "app_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class StoreKeys_CloudBackupKt {
    public static final MemoryStoreKey<Boolean> getHasSeenBackupPrompt(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return new MemoryStoreKey<>("hasSeenBackupPrompt", null, false, Boolean.TYPE, 6, null);
    }

    public static final MemoryStoreKey<Boolean> getHasSeenFirstBackupPrompt(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return new MemoryStoreKey<>("hasSeenFirstBackupPrompt", null, false, Boolean.TYPE, 6, null);
    }

    public static final MemoryStoreKey<Boolean> getHasSeenOnboardingBackupPrompt(StoreKeys storeKeys) {
        m.g(storeKeys, "<this>");
        return new MemoryStoreKey<>("hasSeenOnboardingBackupPrompt", null, false, Boolean.TYPE, 6, null);
    }
}