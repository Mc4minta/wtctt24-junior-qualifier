package com.coinbase.wallet.routing.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RouteActionKey.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\t\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteActionKey;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Factory", "RouteActionKeys", "DAPP", "SHOW_QR_CODE", "CONSUMER_CONNECT", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum RouteActionKey {
    DAPP("dapp"),
    SHOW_QR_CODE("showQRCode"),
    CONSUMER_CONNECT("consumerConnect");
    
    public static final Factory Factory = new Factory(null);
    private final String action;

    /* compiled from: RouteActionKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteActionKey$Factory;", "", "", "action", "Lcom/coinbase/wallet/routing/models/RouteActionKey;", "create", "(Ljava/lang/String;)Lcom/coinbase/wallet/routing/models/RouteActionKey;", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouteActionKey create(String action) {
            RouteActionKey[] values;
            m.g(action, "action");
            for (RouteActionKey routeActionKey : RouteActionKey.values()) {
                if (m.c(routeActionKey.getAction(), action)) {
                    return routeActionKey;
                }
            }
            return null;
        }
    }

    /* compiled from: RouteActionKey.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteActionKey$RouteActionKeys;", "", "", "BLOCKCHAIN", "Ljava/lang/String;", "CHAIN_ID", "URL", "CONTRACT_ADDRESS", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class RouteActionKeys {
        public static final String BLOCKCHAIN = "blockchain";
        public static final String CHAIN_ID = "chainId";
        public static final String CONTRACT_ADDRESS = "contractAddress";
        public static final RouteActionKeys INSTANCE = new RouteActionKeys();
        public static final String URL = "url";

        private RouteActionKeys() {
        }
    }

    RouteActionKey(String str) {
        this.action = str;
    }

    public final String getAction() {
        return this.action;
    }
}