package com.coinbase.wallet.store.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: StoreException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0002\u0007\bB\u0013\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/store/exceptions/StoreException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "StoreDestroyed", "UnableToCreateObserver", "store_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public class StoreException extends RuntimeException {

    /* compiled from: StoreException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/store/exceptions/StoreException$StoreDestroyed;", "Lcom/coinbase/wallet/store/exceptions/StoreException;", "<init>", "()V", "store_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class StoreDestroyed extends StoreException {
        public StoreDestroyed() {
            super("Store destroyed");
        }
    }

    /* compiled from: StoreException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/store/exceptions/StoreException$UnableToCreateObserver;", "Lcom/coinbase/wallet/store/exceptions/StoreException;", "<init>", "()V", "store_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCreateObserver extends StoreException {
        public UnableToCreateObserver() {
            super("Unable to create a store value observer");
        }
    }

    public StoreException() {
        this(null, 1, null);
    }

    public StoreException(String str) {
        super(str == null ? "" : str);
    }

    public /* synthetic */ StoreException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str);
    }
}