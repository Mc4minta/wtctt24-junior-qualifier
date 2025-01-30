package com.coinbase.wallet.user.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AccessTokenException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0006\u0007\b\t\n\u000b\fB\u0013\b\u0004\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "AccessTokenManagerNotConfigured", "UnableToCreateAccessToken", "UnableToCreateNonce", "UnableToCreateUser", "UnableToRefreshAccessToken", "UnlockFailed", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateNonce;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateUser;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateAccessToken;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToRefreshAccessToken;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnlockFailed;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException$AccessTokenManagerNotConfigured;", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class AccessTokenException extends Exception {

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$AccessTokenManagerNotConfigured;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class AccessTokenManagerNotConfigured extends AccessTokenException {
        public static final AccessTokenManagerNotConfigured INSTANCE = new AccessTokenManagerNotConfigured();

        private AccessTokenManagerNotConfigured() {
            super("No authentication repository configured", null);
        }
    }

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateAccessToken;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCreateAccessToken extends AccessTokenException {
        public static final UnableToCreateAccessToken INSTANCE = new UnableToCreateAccessToken();

        private UnableToCreateAccessToken() {
            super("Unable to sign in", null);
        }
    }

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateNonce;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCreateNonce extends AccessTokenException {
        public static final UnableToCreateNonce INSTANCE = new UnableToCreateNonce();

        private UnableToCreateNonce() {
            super("Unable to create nonce", null);
        }
    }

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToCreateUser;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToCreateUser extends AccessTokenException {
        public static final UnableToCreateUser INSTANCE = new UnableToCreateUser();

        private UnableToCreateUser() {
            super("Unable to create user", null);
        }
    }

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnableToRefreshAccessToken;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnableToRefreshAccessToken extends AccessTokenException {
        public static final UnableToRefreshAccessToken INSTANCE = new UnableToRefreshAccessToken();

        private UnableToRefreshAccessToken() {
            super("Unable to refresh access token", null);
        }
    }

    /* compiled from: AccessTokenException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/AccessTokenException$UnlockFailed;", "Lcom/coinbase/wallet/user/exceptions/AccessTokenException;", "<init>", "()V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UnlockFailed extends AccessTokenException {
        public static final UnlockFailed INSTANCE = new UnlockFailed();

        private UnlockFailed() {
            super("Unlock failed", null);
        }
    }

    private AccessTokenException(String str) {
        super(str);
    }

    public /* synthetic */ AccessTokenException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public /* synthetic */ AccessTokenException(String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, null);
    }
}