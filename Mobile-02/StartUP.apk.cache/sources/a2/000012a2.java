package com.coinbase.wallet.authentication;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AppLockType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/authentication/AppLockType;", "", "", "isCancellable", "Z", "()Z", "<init>", "()V", "AppAccess", "RequireAuthentication", "Transactions", "UnlockIfNeeded", "Lcom/coinbase/wallet/authentication/AppLockType$AppAccess;", "Lcom/coinbase/wallet/authentication/AppLockType$Transactions;", "Lcom/coinbase/wallet/authentication/AppLockType$UnlockIfNeeded;", "Lcom/coinbase/wallet/authentication/AppLockType$RequireAuthentication;", "authentication_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AppLockType {
    private final boolean isCancellable;

    /* compiled from: AppLockType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/authentication/AppLockType$AppAccess;", "Lcom/coinbase/wallet/authentication/AppLockType;", "<init>", "()V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class AppAccess extends AppLockType {
        public static final AppAccess INSTANCE = new AppAccess();

        private AppAccess() {
            super(null);
        }
    }

    /* compiled from: AppLockType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/authentication/AppLockType$RequireAuthentication;", "Lcom/coinbase/wallet/authentication/AppLockType;", "<init>", "()V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequireAuthentication extends AppLockType {
        public static final RequireAuthentication INSTANCE = new RequireAuthentication();

        private RequireAuthentication() {
            super(null);
        }
    }

    /* compiled from: AppLockType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/authentication/AppLockType$Transactions;", "Lcom/coinbase/wallet/authentication/AppLockType;", "<init>", "()V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Transactions extends AppLockType {
        public static final Transactions INSTANCE = new Transactions();

        private Transactions() {
            super(null);
        }
    }

    /* compiled from: AppLockType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/authentication/AppLockType$UnlockIfNeeded;", "Lcom/coinbase/wallet/authentication/AppLockType;", "", "canCancel", "Z", "getCanCancel", "()Z", "<init>", "(Z)V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnlockIfNeeded extends AppLockType {
        private final boolean canCancel;

        public UnlockIfNeeded(boolean z) {
            super(null);
            this.canCancel = z;
        }

        public final boolean getCanCancel() {
            return this.canCancel;
        }
    }

    private AppLockType() {
        boolean z = true;
        if (this instanceof AppAccess) {
            z = false;
        } else {
            if (!(this instanceof Transactions ? true : this instanceof RequireAuthentication)) {
                if (!(this instanceof UnlockIfNeeded)) {
                    throw new NoWhenBranchMatchedException();
                }
                z = ((UnlockIfNeeded) this).getCanCancel();
            }
        }
        this.isCancellable = z;
    }

    public /* synthetic */ AppLockType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final boolean isCancellable() {
        return this.isCancellable;
    }
}