package com.google.firebase.components;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
class m {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    public static class b {
        private final d<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<b> f8623b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        private final Set<b> f8624c = new HashSet();

        b(d<?> dVar) {
            this.a = dVar;
        }

        void a(b bVar) {
            this.f8623b.add(bVar);
        }

        void b(b bVar) {
            this.f8624c.add(bVar);
        }

        d<?> c() {
            return this.a;
        }

        Set<b> d() {
            return this.f8623b;
        }

        boolean e() {
            return this.f8623b.isEmpty();
        }

        boolean f() {
            return this.f8624c.isEmpty();
        }

        void g(b bVar) {
            this.f8624c.remove(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    public static class c {
        private final Class<?> a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f8625b;

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                return cVar.a.equals(this.a) && cVar.f8625b == this.f8625b;
            }
            return false;
        }

        public int hashCode() {
            return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.f8625b).hashCode();
        }

        private c(Class<?> cls, boolean z) {
            this.a = cls;
            this.f8625b = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(List<d<?>> list) {
        Set<b> c2 = c(list);
        Set<b> b2 = b(c2);
        int i2 = 0;
        while (!b2.isEmpty()) {
            b next = b2.iterator().next();
            b2.remove(next);
            i2++;
            for (b bVar : next.d()) {
                bVar.g(next);
                if (bVar.f()) {
                    b2.add(bVar);
                }
            }
        }
        if (i2 == list.size()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (b bVar2 : c2) {
            if (!bVar2.f() && !bVar2.e()) {
                arrayList.add(bVar2.c());
            }
        }
        throw new DependencyCycleException(arrayList);
    }

    private static Set<b> b(Set<b> set) {
        HashSet hashSet = new HashSet();
        for (b bVar : set) {
            if (bVar.f()) {
                hashSet.add(bVar);
            }
        }
        return hashSet;
    }

    private static Set<b> c(List<d<?>> list) {
        Set<b> set;
        HashMap hashMap = new HashMap(list.size());
        for (d<?> dVar : list) {
            b bVar = new b(dVar);
            for (Class<? super Object> cls : dVar.e()) {
                c cVar = new c(cls, !dVar.k());
                if (!hashMap.containsKey(cVar)) {
                    hashMap.put(cVar, new HashSet());
                }
                Set set2 = (Set) hashMap.get(cVar);
                if (!set2.isEmpty() && !cVar.f8625b) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
                set2.add(bVar);
            }
        }
        for (Set<b> set3 : hashMap.values()) {
            for (b bVar2 : set3) {
                for (n nVar : bVar2.c().c()) {
                    if (nVar.b() && (set = (Set) hashMap.get(new c(nVar.a(), nVar.d()))) != null) {
                        for (b bVar3 : set) {
                            bVar2.a(bVar3);
                            bVar3.b(bVar2);
                        }
                    }
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Set set4 : hashMap.values()) {
            hashSet.addAll(set4);
        }
        return hashSet;
    }
}