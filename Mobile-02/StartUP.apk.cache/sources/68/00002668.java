package com.coinbase.wallet.store.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SharedPrefsStoreKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B3\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/store/models/SharedPrefsStoreKey;", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "", "id", "uuid", "", "syncNow", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Class;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SharedPrefsStoreKey<T> extends StoreKey<T> {
    public /* synthetic */ SharedPrefsStoreKey(String str, String str2, boolean z, Class cls, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? false : z, cls);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SharedPrefsStoreKey(String id, String str, boolean z, Class<T> clazz) {
        super(id, str, z, StoreKind.SHARED_PREFERENCES, clazz);
        m.g(id, "id");
        m.g(clazz, "clazz");
    }
}