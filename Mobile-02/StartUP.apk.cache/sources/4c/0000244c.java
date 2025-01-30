package com.coinbase.wallet.lending.extensions;

import com.coinbase.wallet.store.models.SharedPrefsStoreKey;
import java.util.Set;
import kotlin.Metadata;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;

/* compiled from: StoreKeys+Lend.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0002\u0010\u0002\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "", "<anonymous>", "()Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class StoreKeys_LendKt$lendProviderIDs$2 extends o implements a<SharedPrefsStoreKey<Set<?>>> {
    public static final StoreKeys_LendKt$lendProviderIDs$2 INSTANCE = new StoreKeys_LendKt$lendProviderIDs$2();

    StoreKeys_LendKt$lendProviderIDs$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.e0.c.a
    public final SharedPrefsStoreKey<Set<?>> invoke() {
        return new SharedPrefsStoreKey<>("lendProviderIDs", null, false, Set.class, 6, null);
    }
}