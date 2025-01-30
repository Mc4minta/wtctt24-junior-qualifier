package com.coinbase.wallet.store.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: EncryptedSharedPrefsStoreKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/store/models/EncryptedSharedPrefsStoreKey;", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "", "id", "uuid", "Ljava/lang/Class;", "clazz", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Class;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EncryptedSharedPrefsStoreKey<T> extends StoreKey<T> {
    public /* synthetic */ EncryptedSharedPrefsStoreKey(String str, String str2, Class cls, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, cls);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EncryptedSharedPrefsStoreKey(String id, String str, Class<T> clazz) {
        super(id, str, true, StoreKind.ENCRYPTED_SHARED_PREFERENCES, clazz);
        m.g(id, "id");
        m.g(clazz, "clazz");
    }
}