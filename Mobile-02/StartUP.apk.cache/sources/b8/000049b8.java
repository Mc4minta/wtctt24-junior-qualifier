package e.j.i;

import android.annotation.SuppressLint;
import com.coinbase.wallet.common.annotations.ApplicationScoped;
import com.toshi.model.network.MinimumSupportBuild;
import com.toshi.network.VersioningInterface;

/* compiled from: VersioningRepository.kt */
@ApplicationScoped
/* loaded from: classes2.dex */
public final class g2 {
    private final VersioningInterface a;

    /* renamed from: b */
    private final h.c.v0.a<MinimumSupportBuild> f13632b;

    public g2(VersioningInterface versioningApi) {
        kotlin.jvm.internal.m.g(versioningApi, "versioningApi");
        this.a = versioningApi;
        h.c.v0.a<MinimumSupportBuild> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<MinimumSupportBuild>()");
        this.f13632b = d2;
    }

    public static /* synthetic */ void b(g2 g2Var, Throwable th) {
        f(g2Var, th);
    }

    public static /* synthetic */ void c(g2 g2Var, MinimumSupportBuild minimumSupportBuild) {
        e(g2Var, minimumSupportBuild);
    }

    public static final void e(g2 this$0, MinimumSupportBuild minimumSupportBuild) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.f13632b.onNext(minimumSupportBuild);
    }

    public static final void f(g2 this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        l.a.a.f(th, "Error while fetching minimum version", new Object[0]);
        this$0.f13632b.onError(th);
    }

    public final h.c.s<MinimumSupportBuild> a() {
        h.c.s<MinimumSupportBuild> hide = this.f13632b.hide();
        kotlin.jvm.internal.m.f(hide, "minVersionSubject.hide()");
        return hide;
    }

    @SuppressLint({"CheckResult"})
    public final void d() {
        this.a.getGetMinSupportedVersion().subscribeOn(h.c.u0.a.c()).subscribe(new h.c.m0.f() { // from class: e.j.i.t1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                g2.c(g2.this, (MinimumSupportBuild) obj);
            }
        }, new h.c.m0.f() { // from class: e.j.i.s1
            @Override // h.c.m0.f
            public final void accept(Object obj) {
                g2.b(g2.this, (Throwable) obj);
            }
        });
    }
}