package com.coinbase.wallet.routing.models;

import android.net.Uri;
import h.c.b0;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: DappRouteAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/routing/models/DappRouteAction;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "execute", "()Lh/c/b0;", "Landroid/net/Uri;", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DappRouteAction implements RouteAction {
    private final Uri uri;

    public DappRouteAction(Uri uri) {
        m.g(uri, "uri");
        this.uri = uri;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public b0<DeeplinkDestination> execute() {
        String queryParameter = getUri().getQueryParameter("url");
        if (queryParameter == null) {
            b0<DeeplinkDestination> error = b0.error(new IllegalStateException("url is not present."));
            m.f(error, "error(IllegalStateException(\"url is not present.\"))");
            return error;
        }
        b0<DeeplinkDestination> just = b0.just(new DappDeepLinkDestination(queryParameter));
        m.f(just, "just(DappDeepLinkDestination(url))");
        return just;
    }

    @Override // com.coinbase.wallet.routing.models.RouteAction
    public Uri getUri() {
        return this.uri;
    }
}