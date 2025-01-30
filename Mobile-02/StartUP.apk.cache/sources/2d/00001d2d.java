package com.coinbase.wallet.features.applock.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AppLockException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0006\u0007\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0004\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/features/applock/exceptions/AppLockException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "InvalidLockMethod", "LockedOutException", "NoBiometricFoundException", "UserCancelledException", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$InvalidLockMethod;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$LockedOutException;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$UserCancelledException;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$NoBiometricFoundException;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AppLockException extends Exception {

    /* compiled from: AppLockException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$InvalidLockMethod;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class InvalidLockMethod extends AppLockException {
        public static final InvalidLockMethod INSTANCE = new InvalidLockMethod();

        private InvalidLockMethod() {
            super("Invalid lock method", null);
        }
    }

    /* compiled from: AppLockException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$LockedOutException;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException;", "", "isPermanent", "<init>", "(Z)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LockedOutException extends AppLockException {
        public LockedOutException(boolean z) {
            super(m.o("User is locked out ", Boolean.valueOf(z)), null);
        }
    }

    /* compiled from: AppLockException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$NoBiometricFoundException;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NoBiometricFoundException extends AppLockException {
        public static final NoBiometricFoundException INSTANCE = new NoBiometricFoundException();

        private NoBiometricFoundException() {
            super("User has no biometrics on device", null);
        }
    }

    /* compiled from: AppLockException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/applock/exceptions/AppLockException$UserCancelledException;", "Lcom/coinbase/wallet/features/applock/exceptions/AppLockException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UserCancelledException extends AppLockException {
        public static final UserCancelledException INSTANCE = new UserCancelledException();

        private UserCancelledException() {
            super("User cancelled unlocking app", null);
        }
    }

    private AppLockException(String str) {
        super(str);
    }

    public /* synthetic */ AppLockException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}