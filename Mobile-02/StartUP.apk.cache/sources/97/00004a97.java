package e.j.n;

import com.coinbase.wallet.features.ofac.repositories.OFACRepository;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.http.connectivity.Internet;

/* compiled from: BannedLocationViewModel.kt */
/* loaded from: classes2.dex */
public final class a2 extends androidx.lifecycle.b0 {
    private final OFACRepository a;

    /* renamed from: b */
    private final h.c.s<Boolean> f13802b;

    public a2(OFACRepository ofacRepository) {
        kotlin.jvm.internal.m.g(ofacRepository, "ofacRepository");
        this.a = ofacRepository;
        h.c.s flatMapSingle = Internet.INSTANCE.getStatusChanges().filter(new h.c.m0.p() { // from class: e.j.n.h
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return a2.e((ConnectionStatus) obj);
            }
        }).flatMapSingle(new h.c.m0.n() { // from class: e.j.n.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return a2.d(a2.this, (ConnectionStatus) obj);
            }
        });
        kotlin.jvm.internal.m.f(flatMapSingle, "Internet.statusChanges\n        .filter { it is ConnectionStatus.Connected }\n        .flatMapSingle { ofacRepository.isBannedLocation() }");
        this.f13802b = flatMapSingle;
    }

    public static final boolean b(ConnectionStatus it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it instanceof ConnectionStatus.Connected;
    }

    public static final h.c.h0 c(a2 this$0, ConnectionStatus it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.a.isBannedLocation();
    }

    public static /* synthetic */ h.c.h0 d(a2 a2Var, ConnectionStatus connectionStatus) {
        return c(a2Var, connectionStatus);
    }

    public static /* synthetic */ boolean e(ConnectionStatus connectionStatus) {
        return b(connectionStatus);
    }

    public final h.c.s<Boolean> a() {
        return this.f13802b;
    }
}