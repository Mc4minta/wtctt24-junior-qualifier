package com.coinbase.wallet.routing.models;

import android.net.Uri;
import h.c.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerConnectRouteAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/routing/models/ConsumerConnectRouteAction;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "execute", "()Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/NavDeepLinkDestination;", "dest", "Lcom/coinbase/wallet/routing/models/NavDeepLinkDestination;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;Lcom/coinbase/wallet/routing/models/NavDeepLinkDestination;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ConsumerConnectRouteAction implements RouteAction {
    private final NavDeepLinkDestination dest;
    private final Uri uri;

    public ConsumerConnectRouteAction(Uri uri, NavDeepLinkDestination dest) {
        m.g(uri, "uri");
        m.g(dest, "dest");
        this.uri = uri;
        this.dest = dest;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public b0<DeeplinkDestination> execute() {
        b0<DeeplinkDestination> just = b0.just(this.dest);
        m.f(just, "just(dest)");
        return just;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public Uri getUri() {
        return this.uri;
    }
}