package com.coinbase.wallet.routing.viewmodels;

import android.net.Uri;
import androidx.lifecycle.b0;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.core.util.OptionalKt;
import com.coinbase.wallet.routing.models.DeeplinkDestination;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.models.RouteScheme;
import h.c.m0.n;
import java.util.Map;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;

/* compiled from: DeepLinkViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BI\b\u0007\u0012\u001e\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\t\u0012\u001e\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\t¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR.\u0010\r\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR.\u0010\u0010\u001a\u001a\u0012\u0004\u0012\u00020\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\f0\u000b0\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/coinbase/wallet/routing/viewmodels/DeepLinkViewModel;", "Landroidx/lifecycle/b0;", "Landroid/net/Uri;", "uri", "Lh/c/b0;", "Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "route", "(Landroid/net/Uri;)Lh/c/b0;", "", "Lcom/coinbase/wallet/routing/models/RouteScheme;", "Lkotlin/Function1;", "Lcom/coinbase/wallet/routing/models/RouteAction;", "schemeRoutes", "Ljava/util/Map;", "Lcom/coinbase/wallet/routing/models/RouteActionKey;", "actionRoutes", "<init>", "(Ljava/util/Map;Ljava/util/Map;)V", "routing_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class DeepLinkViewModel extends b0 {
    private final Map<RouteActionKey, l<Uri, RouteAction>> actionRoutes;
    private final Map<RouteScheme, l<Uri, RouteAction>> schemeRoutes;

    public DeepLinkViewModel(Map<RouteScheme, l<Uri, RouteAction>> schemeRoutes, Map<RouteActionKey, l<Uri, RouteAction>> actionRoutes) {
        m.g(schemeRoutes, "schemeRoutes");
        m.g(actionRoutes, "actionRoutes");
        this.schemeRoutes = schemeRoutes;
        this.actionRoutes = actionRoutes;
    }

    public static /* synthetic */ Optional a(Throwable th) {
        return m1692route$lambda5(th);
    }

    public static /* synthetic */ Optional b(DeeplinkDestination deeplinkDestination) {
        return m1691route$lambda4(deeplinkDestination);
    }

    /* renamed from: route$lambda-4 */
    public static final Optional m1691route$lambda4(DeeplinkDestination it) {
        m.g(it, "it");
        return OptionalKt.toOptional(it);
    }

    /* renamed from: route$lambda-5 */
    public static final Optional m1692route$lambda5(Throwable it) {
        m.g(it, "it");
        return OptionalKt.toOptional(null);
    }

    public final h.c.b0<Optional<DeeplinkDestination>> route(Uri uri) {
        RouteActionKey create;
        RouteScheme create2;
        m.g(uri, "uri");
        String authority = uri.getAuthority();
        l<Uri, RouteAction> lVar = (authority == null || (create = RouteActionKey.Factory.create(authority)) == null) ? null : this.actionRoutes.get(create);
        if (lVar == null) {
            String scheme = uri.getScheme();
            lVar = (scheme == null || (create2 = RouteScheme.Factory.create(scheme)) == null) ? null : this.schemeRoutes.get(create2);
            if (lVar == null) {
                h.c.b0<Optional<DeeplinkDestination>> just = h.c.b0.just(OptionalKt.toOptional(null));
                m.f(just, "just(null.toOptional())");
                return just;
            }
        }
        h.c.b0<Optional<DeeplinkDestination>> onErrorReturn = Single_AnalyticsKt.logError$default(lVar.invoke(uri).execute(), null, null, 3, null).map(new n() { // from class: com.coinbase.wallet.routing.viewmodels.b
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DeepLinkViewModel.b((DeeplinkDestination) obj);
            }
        }).onErrorReturn(new n() { // from class: com.coinbase.wallet.routing.viewmodels.a
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return DeepLinkViewModel.a((Throwable) obj);
            }
        });
        m.f(onErrorReturn, "route.invoke(uri)\n            .execute()\n            .logError()\n            .map { it.toOptional() }\n            .onErrorReturn { null.toOptional() }");
        return onErrorReturn;
    }
}