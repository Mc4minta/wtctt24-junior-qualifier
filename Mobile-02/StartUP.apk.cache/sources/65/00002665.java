package com.coinbase.wallet.store.interfaces;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.store.models.StoreKey;
import com.coinbase.wallet.store.models.StoreKind;
import h.c.s;
import kotlin.Metadata;

/* compiled from: StoreInterface.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J1\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0010\u0005\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\t\u0010\nJ'\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000e\"\b\b\u0000\u0010\u0002*\u00020\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H&¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "", "T", "Lcom/coinbase/wallet/store/models/StoreKey;", "key", "value", "Lkotlin/x;", "set", "(Lcom/coinbase/wallet/store/models/StoreKey;Ljava/lang/Object;)V", "get", "(Lcom/coinbase/wallet/store/models/StoreKey;)Ljava/lang/Object;", "", "has", "(Lcom/coinbase/wallet/store/models/StoreKey;)Z", "Lh/c/s;", "Lcom/coinbase/wallet/core/util/Optional;", "observe", "(Lcom/coinbase/wallet/store/models/StoreKey;)Lh/c/s;", "destroy", "()V", "", "Lcom/coinbase/wallet/store/models/StoreKind;", "kinds", "removeAll", "([Lcom/coinbase/wallet/store/models/StoreKind;)V", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface StoreInterface {
    void destroy();

    <T> T get(StoreKey<T> storeKey);

    <T> boolean has(StoreKey<T> storeKey);

    <T> s<Optional<T>> observe(StoreKey<T> storeKey);

    void removeAll(StoreKind[] storeKindArr);

    <T> void set(StoreKey<T> storeKey, T t);
}