package f.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Provider;

/* compiled from: SetFactory.java */
/* loaded from: classes2.dex */
public final class i<T> implements d<Set<T>> {
    private static final d<Set<Object>> a = e.a(Collections.emptySet());

    /* renamed from: b  reason: collision with root package name */
    private final List<Provider<T>> f14013b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Provider<Collection<T>>> f14014c;

    /* compiled from: SetFactory.java */
    /* loaded from: classes2.dex */
    public static final class b<T> {
        private final List<Provider<T>> a;

        /* renamed from: b  reason: collision with root package name */
        private final List<Provider<Collection<T>>> f14015b;

        public b<T> a(Provider<? extends T> provider) {
            this.a.add(provider);
            return this;
        }

        public i<T> b() {
            return new i<>(this.a, this.f14015b);
        }

        private b(int i2, int i3) {
            this.a = f.c.b.d(i2);
            this.f14015b = f.c.b.d(i3);
        }
    }

    public static <T> b<T> a(int i2, int i3) {
        return new b<>(i2, i3);
    }

    @Override // javax.inject.Provider
    /* renamed from: b */
    public Set<T> get() {
        int size = this.f14013b.size();
        ArrayList arrayList = new ArrayList(this.f14014c.size());
        int size2 = this.f14014c.size();
        for (int i2 = 0; i2 < size2; i2++) {
            Collection<T> collection = this.f14014c.get(i2).get();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet b2 = f.c.b.b(size);
        int size3 = this.f14013b.size();
        for (int i3 = 0; i3 < size3; i3++) {
            b2.add(h.b(this.f14013b.get(i3).get()));
        }
        int size4 = arrayList.size();
        for (int i4 = 0; i4 < size4; i4++) {
            for (Object obj : (Collection) arrayList.get(i4)) {
                b2.add(h.b(obj));
            }
        }
        return Collections.unmodifiableSet(b2);
    }

    private i(List<Provider<T>> list, List<Provider<Collection<T>>> list2) {
        this.f14013b = list;
        this.f14014c = list2;
    }
}