package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public class l extends a {
    private static final com.google.firebase.g.a<Set<Object>> a = k.a();

    /* renamed from: b  reason: collision with root package name */
    private final Map<d<?>, q<?>> f8619b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class<?>, q<?>> f8620c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<?>, q<Set<?>>> f8621d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final p f8622e;

    public l(Executor executor, Iterable<h> iterable, d<?>... dVarArr) {
        p pVar = new p(executor);
        this.f8622e = pVar;
        ArrayList<d<?>> arrayList = new ArrayList();
        arrayList.add(d.n(pVar, p.class, com.google.firebase.e.d.class, com.google.firebase.e.c.class));
        for (h hVar : iterable) {
            arrayList.addAll(hVar.getComponents());
        }
        for (d<?> dVar : dVarArr) {
            if (dVar != null) {
                arrayList.add(dVar);
            }
        }
        m.a(arrayList);
        for (d<?> dVar2 : arrayList) {
            this.f8619b.put(dVar2, new q<>(i.a(this, dVar2)));
        }
        h();
        i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Set g(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((q) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void h() {
        for (Map.Entry<d<?>, q<?>> entry : this.f8619b.entrySet()) {
            d<?> key = entry.getKey();
            if (key.k()) {
                q<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    this.f8620c.put(cls, value);
                }
            }
        }
        j();
    }

    private void i() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<d<?>, q<?>> entry : this.f8619b.entrySet()) {
            d<?> key = entry.getKey();
            if (!key.k()) {
                q<?> value = entry.getValue();
                for (Class<? super Object> cls : key.e()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            this.f8621d.put((Class) entry2.getKey(), new q<>(j.a((Set) entry2.getValue())));
        }
    }

    private void j() {
        for (d<?> dVar : this.f8619b.keySet()) {
            for (n nVar : dVar.c()) {
                if (nVar.c() && !this.f8620c.containsKey(nVar.a())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", dVar, nVar.a()));
                }
            }
        }
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.g.a<T> b(Class<T> cls) {
        r.c(cls, "Null interface requested.");
        return this.f8620c.get(cls);
    }

    @Override // com.google.firebase.components.e
    public <T> com.google.firebase.g.a<Set<T>> c(Class<T> cls) {
        q<Set<?>> qVar = this.f8621d.get(cls);
        return qVar != null ? qVar : (com.google.firebase.g.a<Set<T>>) a;
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.e
    public /* bridge */ /* synthetic */ Set d(Class cls) {
        return super.d(cls);
    }

    public void e(boolean z) {
        for (Map.Entry<d<?>, q<?>> entry : this.f8619b.entrySet()) {
            d<?> key = entry.getKey();
            q<?> value = entry.getValue();
            if (key.i() || (key.j() && z)) {
                value.get();
            }
        }
        this.f8622e.c();
    }
}