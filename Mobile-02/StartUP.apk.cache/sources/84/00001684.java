package com.coinbase.wallet.consumer.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerSecure3DEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent;", "", "<init>", "()V", "UrlEvent", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent$UrlEvent;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerSecure3DEvent {

    /* compiled from: ConsumerSecure3DEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent$UrlEvent;", "Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DEvent;", "", "postBody", "[B", "getPostBody", "()[B", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;[B)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class UrlEvent extends ConsumerSecure3DEvent {
        private final byte[] postBody;
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UrlEvent(String url, byte[] postBody) {
            super(null);
            m.g(url, "url");
            m.g(postBody, "postBody");
            this.url = url;
            this.postBody = postBody;
        }

        public final byte[] getPostBody() {
            return this.postBody;
        }

        public final String getUrl() {
            return this.url;
        }
    }

    private ConsumerSecure3DEvent() {
    }

    public /* synthetic */ ConsumerSecure3DEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}