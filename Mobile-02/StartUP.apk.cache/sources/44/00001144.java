package com.coinbase.wallet.analytics.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PreserveStackTraceException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/analytics/exceptions/PreserveStackTraceException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "cause", "", "Ljava/lang/StackTraceElement;", "stackTrace", "<init>", "(Ljava/lang/Throwable;[Ljava/lang/StackTraceElement;)V", "analytics_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class PreserveStackTraceException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PreserveStackTraceException(Throwable cause, StackTraceElement[] stackTrace) {
        super(cause);
        m.g(cause, "cause");
        m.g(stackTrace, "stackTrace");
        setStackTrace(stackTrace);
    }
}