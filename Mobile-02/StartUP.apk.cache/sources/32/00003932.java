package com.google.firebase.abt;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.analytics.a.a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-abt@@19.0.0 */
/* loaded from: classes2.dex */
public class b {
    private final com.google.firebase.analytics.a.a a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8562b;

    /* renamed from: c  reason: collision with root package name */
    private Integer f8563c = null;

    public b(Context context, com.google.firebase.analytics.a.a aVar, String str) {
        this.a = aVar;
        this.f8562b = str;
    }

    private void a(a.c cVar) {
        this.a.b(cVar);
    }

    private void b(List<a> list) {
        ArrayDeque arrayDeque = new ArrayDeque(e());
        int h2 = h();
        for (a aVar : list) {
            while (arrayDeque.size() >= h2) {
                j(((a.c) arrayDeque.pollFirst()).f8570b);
            }
            a.c d2 = d(aVar);
            a(d2);
            arrayDeque.offer(d2);
        }
    }

    private static List<a> c(List<Map<String, String>> list) throws AbtException {
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : list) {
            arrayList.add(a.a(map));
        }
        return arrayList;
    }

    private a.c d(a aVar) {
        a.c cVar = new a.c();
        cVar.a = this.f8562b;
        cVar.m = aVar.c();
        cVar.f8570b = aVar.b();
        cVar.f8571c = aVar.g();
        cVar.f8572d = TextUtils.isEmpty(aVar.e()) ? null : aVar.e();
        cVar.f8573e = aVar.f();
        cVar.f8578j = aVar.d();
        return cVar;
    }

    private List<a.c> e() {
        return this.a.e(this.f8562b, "");
    }

    private ArrayList<a> f(List<a> list, Set<String> set) {
        ArrayList<a> arrayList = new ArrayList<>();
        for (a aVar : list) {
            if (!set.contains(aVar.b())) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private ArrayList<a.c> g(List<a.c> list, Set<String> set) {
        ArrayList<a.c> arrayList = new ArrayList<>();
        for (a.c cVar : list) {
            if (!set.contains(cVar.f8570b)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    private int h() {
        if (this.f8563c == null) {
            this.f8563c = Integer.valueOf(this.a.d(this.f8562b));
        }
        return this.f8563c.intValue();
    }

    private void k(Collection<a.c> collection) {
        for (a.c cVar : collection) {
            j(cVar.f8570b);
        }
    }

    private void m(List<a> list) throws AbtException {
        if (list.isEmpty()) {
            i();
            return;
        }
        HashSet hashSet = new HashSet();
        for (a aVar : list) {
            hashSet.add(aVar.b());
        }
        List<a.c> e2 = e();
        HashSet hashSet2 = new HashSet();
        for (a.c cVar : e2) {
            hashSet2.add(cVar.f8570b);
        }
        k(g(e2, hashSet));
        b(f(list, hashSet2));
    }

    private void n() throws AbtException {
        if (this.a == null) {
            throw new AbtException("The Analytics SDK is not available. Please check that the Analytics SDK is included in your app dependencies.");
        }
    }

    public void i() throws AbtException {
        n();
        k(e());
    }

    void j(String str) {
        this.a.clearConditionalUserProperty(str, null, null);
    }

    public void l(List<Map<String, String>> list) throws AbtException {
        n();
        if (list != null) {
            m(c(list));
            return;
        }
        throw new IllegalArgumentException("The replacementExperiments list is null.");
    }
}