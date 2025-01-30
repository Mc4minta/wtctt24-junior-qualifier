package okhttp3.internal.connection;

import java.net.Proxy;
import java.net.URI;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.q;
import kotlin.e0.c.a;
import kotlin.jvm.internal.o;
import okhttp3.Address;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RouteSelector.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "Ljava/net/Proxy;", "invoke", "()Ljava/util/List;", "selectProxies"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class RouteSelector$resetNextProxy$1 extends o implements a<List<? extends Proxy>> {
    final /* synthetic */ Proxy $proxy;
    final /* synthetic */ HttpUrl $url;
    final /* synthetic */ RouteSelector this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RouteSelector$resetNextProxy$1(RouteSelector routeSelector, Proxy proxy, HttpUrl httpUrl) {
        super(0);
        this.this$0 = routeSelector;
        this.$proxy = proxy;
        this.$url = httpUrl;
    }

    @Override // kotlin.e0.c.a
    public final List<? extends Proxy> invoke() {
        Address address;
        List<? extends Proxy> b2;
        Proxy proxy = this.$proxy;
        if (proxy != null) {
            b2 = q.b(proxy);
            return b2;
        }
        URI uri = this.$url.uri();
        if (uri.getHost() == null) {
            return Util.immutableListOf(Proxy.NO_PROXY);
        }
        address = this.this$0.address;
        List<Proxy> select = address.proxySelector().select(uri);
        return select == null || select.isEmpty() ? Util.immutableListOf(Proxy.NO_PROXY) : Util.toImmutableList(select);
    }
}