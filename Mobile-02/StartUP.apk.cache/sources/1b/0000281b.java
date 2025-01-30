package com.coinbase.wallet.user.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: UserException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/UserException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "UsernameAlreadyTakenException", "Lcom/coinbase/wallet/user/exceptions/UserException$UsernameAlreadyTakenException;", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class UserException extends Exception {

    /* compiled from: UserException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/user/exceptions/UserException$UsernameAlreadyTakenException;", "Lcom/coinbase/wallet/user/exceptions/UserException;", "", "cause", "<init>", "(Ljava/lang/String;)V", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class UsernameAlreadyTakenException extends UserException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UsernameAlreadyTakenException(String cause) {
            super(cause, null);
            m.g(cause, "cause");
        }
    }

    private UserException(String str) {
        super(str);
    }

    public /* synthetic */ UserException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}