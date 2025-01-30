package com.coinbase.wallet.http.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: HTTPException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0006\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/http/exceptions/HTTPException;", "Ljava/lang/Exception;", "", "msg", "<init>", "(Ljava/lang/String;)V", "RequestFailed", "UnableToDeserialize", "Lcom/coinbase/wallet/http/exceptions/HTTPException$UnableToDeserialize;", "Lcom/coinbase/wallet/http/exceptions/HTTPException$RequestFailed;", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class HTTPException extends Exception {

    /* compiled from: HTTPException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/http/exceptions/HTTPException$RequestFailed;", "Lcom/coinbase/wallet/http/exceptions/HTTPException;", "", "body", "Ljava/lang/String;", "getBody", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class RequestFailed extends HTTPException {
        private final String body;

        public RequestFailed(String str) {
            super("Request failed", null);
            this.body = str;
        }

        public final String getBody() {
            return this.body;
        }
    }

    /* compiled from: HTTPException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/exceptions/HTTPException$UnableToDeserialize;", "Lcom/coinbase/wallet/http/exceptions/HTTPException;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToDeserialize extends HTTPException {
        public static final UnableToDeserialize INSTANCE = new UnableToDeserialize();

        private UnableToDeserialize() {
            super("Unable to deserialize response", null);
        }
    }

    private HTTPException(String str) {
        super(str);
    }

    public /* synthetic */ HTTPException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}