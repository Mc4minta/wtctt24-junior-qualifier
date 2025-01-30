package com.toshi.exception;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: TransactionExceptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/toshi/exception/UnableToGenerateUnsignedTransactionException;", "Lcom/toshi/exception/TransactionException;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UnableToGenerateUnsignedTransactionException extends TransactionException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnableToGenerateUnsignedTransactionException(String message) {
        super(message);
        m.g(message, "message");
    }
}