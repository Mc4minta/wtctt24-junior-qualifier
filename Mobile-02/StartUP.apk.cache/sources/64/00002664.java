package com.coinbase.wallet.store.interfaces;

import com.coinbase.wallet.store.models.StoreKey;
import kotlin.Metadata;

/* compiled from: Storage.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b`\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/store/interfaces/Storage;", "", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "value", "Lkotlin/x;", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "destroy", "()V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface Storage {
    void destroy();

    <T> T get(StoreKey<T> storeKey);

    <T> void set(StoreKey<T> storeKey, T t);
}