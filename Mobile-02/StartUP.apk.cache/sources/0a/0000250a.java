package com.coinbase.wallet.qr.exceptions;

import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: QrException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/qr/exceptions/QrException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", ApiConstants.MESSAGE, "<init>", "(Ljava/lang/String;)V", "InvalidQrCode", "Lcom/coinbase/wallet/qr/exceptions/QrException$InvalidQrCode;", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public abstract class QrException extends Exception {

    /* compiled from: QrException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/qr/exceptions/QrException$InvalidQrCode;", "Lcom/coinbase/wallet/qr/exceptions/QrException;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class InvalidQrCode extends QrException {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public InvalidQrCode(String message) {
            super(message, null);
            m.g(message, "message");
            this.message = message;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.message;
        }
    }

    private QrException(String str) {
        super(str);
    }

    public /* synthetic */ QrException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}