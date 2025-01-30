package com.toshi.exception;

import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: PinException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/toshi/exception/PinException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "<init>", "(Ljava/lang/Exception;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class PinException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PinException(Exception exception) {
        super(exception);
        m.g(exception, "exception");
    }
}