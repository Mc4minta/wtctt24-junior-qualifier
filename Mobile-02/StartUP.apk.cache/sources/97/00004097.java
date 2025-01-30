package com.toshi.exception;

import kotlin.Metadata;

/* compiled from: TransactionExceptions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/toshi/exception/SignatureOnlyNotSupported;", "Lcom/toshi/exception/TransactionException;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SignatureOnlyNotSupported extends TransactionException {
    public static final SignatureOnlyNotSupported a = new SignatureOnlyNotSupported();

    private SignatureOnlyNotSupported() {
        super("Signing without submitting is not supported for this currency");
    }
}