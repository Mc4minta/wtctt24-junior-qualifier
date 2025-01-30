package com.coinbase.wallet.authentication;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: AuthenticationResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult;", "", "<init>", "()V", "Cancelled", "Error", "LockedOut", "NoBiometricFound", "RecoveryPhrase", "Lcom/coinbase/wallet/authentication/AuthenticationResult$RecoveryPhrase;", "Lcom/coinbase/wallet/authentication/AuthenticationResult$Error;", "Lcom/coinbase/wallet/authentication/AuthenticationResult$LockedOut;", "Lcom/coinbase/wallet/authentication/AuthenticationResult$Cancelled;", "Lcom/coinbase/wallet/authentication/AuthenticationResult$NoBiometricFound;", "authentication_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AuthenticationResult {

    /* compiled from: AuthenticationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult$Cancelled;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "<init>", "()V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Cancelled extends AuthenticationResult {
        public static final Cancelled INSTANCE = new Cancelled();

        private Cancelled() {
            super(null);
        }
    }

    /* compiled from: AuthenticationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult$Error;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "", "throwable", "Ljava/lang/Throwable;", "getThrowable", "()Ljava/lang/Throwable;", "<init>", "(Ljava/lang/Throwable;)V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends AuthenticationResult {
        private final Throwable throwable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Error(Throwable throwable) {
            super(null);
            m.g(throwable, "throwable");
            this.throwable = throwable;
        }

        public final Throwable getThrowable() {
            return this.throwable;
        }
    }

    /* compiled from: AuthenticationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult$LockedOut;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "", "permanent", "Z", "getPermanent", "()Z", "<init>", "(Z)V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LockedOut extends AuthenticationResult {
        private final boolean permanent;

        public LockedOut(boolean z) {
            super(null);
            this.permanent = z;
        }

        public final boolean getPermanent() {
            return this.permanent;
        }
    }

    /* compiled from: AuthenticationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult$NoBiometricFound;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "", "isBiometricProtectionEnabled", "Z", "()Z", "<init>", "(Z)V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class NoBiometricFound extends AuthenticationResult {
        private final boolean isBiometricProtectionEnabled;

        public NoBiometricFound(boolean z) {
            super(null);
            this.isBiometricProtectionEnabled = z;
        }

        public final boolean isBiometricProtectionEnabled() {
            return this.isBiometricProtectionEnabled;
        }
    }

    /* compiled from: AuthenticationResult.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/authentication/AuthenticationResult$RecoveryPhrase;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "", "recoveryPhrase", "Ljava/lang/String;", "getRecoveryPhrase", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "authentication_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RecoveryPhrase extends AuthenticationResult {
        private final String recoveryPhrase;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RecoveryPhrase(String recoveryPhrase) {
            super(null);
            m.g(recoveryPhrase, "recoveryPhrase");
            this.recoveryPhrase = recoveryPhrase;
        }

        public final String getRecoveryPhrase() {
            return this.recoveryPhrase;
        }
    }

    private AuthenticationResult() {
    }

    public /* synthetic */ AuthenticationResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}