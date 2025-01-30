package com.coinbase.wallet.core.util;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Assertion.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/core/util/AssertionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "core_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AssertionException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AssertionException(String message) {
        super(message);
        m.g(message, "message");
    }
}