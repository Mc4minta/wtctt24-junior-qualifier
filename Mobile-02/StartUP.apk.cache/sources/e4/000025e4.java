package com.coinbase.wallet.routing.models;

import com.coinbase.wallet.qr.models.WalletConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: RouteScheme.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteScheme;", "", "", "scheme", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Factory", "BITCOIN", "LITECOIN", "BITCOINCASH", "DOGECOIN", "ETHEREUM", "RIPPLE", "XRP", "WEBSTELLAR", "STELLAR", "SWAP", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public enum RouteScheme {
    BITCOIN("bitcoin"),
    LITECOIN("litecoin"),
    BITCOINCASH(WalletConstants.URIPrefixes.BCH),
    DOGECOIN("dogecoin"),
    ETHEREUM(WalletConstants.URIPrefixes.ETH),
    RIPPLE(WalletConstants.URIPrefixes.XRP),
    XRP(WalletConstants.URIPrefixes.XRP_ALT),
    WEBSTELLAR(WalletConstants.URIPrefixes.XLM),
    STELLAR(WalletConstants.URIPrefixes.XLM_ALT),
    SWAP("walletswap");
    
    public static final Factory Factory = new Factory(null);
    private final String scheme;

    /* compiled from: RouteScheme.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteScheme$Factory;", "", "", "scheme", "Lcom/coinbase/wallet/routing/models/RouteScheme;", "create", "(Ljava/lang/String;)Lcom/coinbase/wallet/routing/models/RouteScheme;", "<init>", "()V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Factory {
        private Factory() {
        }

        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouteScheme create(String scheme) {
            RouteScheme[] values;
            m.g(scheme, "scheme");
            for (RouteScheme routeScheme : RouteScheme.values()) {
                if (m.c(routeScheme.scheme, scheme)) {
                    return routeScheme;
                }
            }
            return null;
        }
    }

    RouteScheme(String str) {
        this.scheme = str;
    }
}