package com.coinbase.wallet.http.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: WebSocketException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\u0007B\u0011\b\u0004\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0082\u0001\u0001\b¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/http/exceptions/WebSocketException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "msg", "<init>", "(Ljava/lang/String;)V", "UnableToSendData", "Lcom/coinbase/wallet/http/exceptions/WebSocketException$UnableToSendData;", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WebSocketException extends RuntimeException {

    /* compiled from: WebSocketException.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/http/exceptions/WebSocketException$UnableToSendData;", "Lcom/coinbase/wallet/http/exceptions/WebSocketException;", "<init>", "()V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UnableToSendData extends WebSocketException {
        public static final UnableToSendData INSTANCE = new UnableToSendData();

        private UnableToSendData() {
            super("Unable to send data/text on live websocket", null);
        }
    }

    private WebSocketException(String str) {
        super(str);
    }

    public /* synthetic */ WebSocketException(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}