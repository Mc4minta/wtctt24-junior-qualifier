package com.coinbase.wallet.routing.models;

import android.net.Uri;
import h.c.b0;
import kotlin.Metadata;

/* compiled from: RouteAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/routing/models/RouteAction;", "", "Lh/c/b0;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "execute", "()Lh/c/b0;", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface RouteAction {
    b0<DeeplinkDestination> execute();

    Uri getUri();
}