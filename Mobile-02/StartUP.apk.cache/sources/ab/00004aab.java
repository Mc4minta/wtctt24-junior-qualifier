package e.j.n;

import com.coinbase.wallet.core.interfaces.RefreshInterval;
import com.toshi.model.local.room.CollectibleType;
import java.util.Comparator;
import java.util.List;

/* compiled from: CollectibleTypesTabViewModel.kt */
/* loaded from: classes2.dex */
public final class d2 extends androidx.lifecycle.b0 {
    private final e.j.i.w1 a;

    /* renamed from: b */
    private final h.c.s<List<CollectibleType>> f13820b;

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class a<T> implements Comparator<T> {
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int c2;
            c2 = kotlin.b0.b.c(((CollectibleType) t).getName(), ((CollectibleType) t2).getName());
            return c2;
        }
    }

    public d2(e.j.i.w1 collectibleTypesRepository) {
        kotlin.jvm.internal.m.g(collectibleTypesRepository, "collectibleTypesRepository");
        this.a = collectibleTypesRepository;
        h.c.s map = collectibleTypesRepository.a().map(new h.c.m0.n() { // from class: e.j.n.i
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return d2.c((List) obj);
            }
        });
        kotlin.jvm.internal.m.f(map, "collectibleTypesRepository.collectibleTypesObservable.map { it.sortedBy { it.name } }");
        this.f13820b = map;
    }

    public static final List a(List it) {
        List B0;
        kotlin.jvm.internal.m.g(it, "it");
        B0 = kotlin.a0.z.B0(it, new a());
        return B0;
    }

    public static /* synthetic */ List c(List list) {
        return a(list);
    }

    public final h.c.s<List<CollectibleType>> b() {
        return this.f13820b;
    }

    public final void d() {
        this.a.updateRefreshInterval(RefreshInterval.DEFAULT);
    }

    public final void e() {
        this.a.updateRefreshInterval(RefreshInterval.HOUR);
    }
}