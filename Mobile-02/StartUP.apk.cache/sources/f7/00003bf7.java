package com.google.gson;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: GsonBuilder.java */
/* loaded from: classes2.dex */
public final class g {

    /* renamed from: h  reason: collision with root package name */
    private String f9539h;
    private com.google.gson.u.d a = com.google.gson.u.d.a;

    /* renamed from: b  reason: collision with root package name */
    private r f9533b = r.a;

    /* renamed from: c  reason: collision with root package name */
    private e f9534c = d.a;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Type, h<?>> f9535d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final List<t> f9536e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private final List<t> f9537f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private boolean f9538g = false;

    /* renamed from: i  reason: collision with root package name */
    private int f9540i = 2;

    /* renamed from: j  reason: collision with root package name */
    private int f9541j = 2;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9542k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9543l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    private void a(String str, int i2, int i3, List<t> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            aVar = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
        } else if (i2 == 2 || i3 == 2) {
            return;
        } else {
            a aVar4 = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar = aVar4;
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(com.google.gson.u.n.n.b(Date.class, aVar));
        list.add(com.google.gson.u.n.n.b(Timestamp.class, aVar2));
        list.add(com.google.gson.u.n.n.b(java.sql.Date.class, aVar3));
    }

    public f b() {
        List<t> arrayList = new ArrayList<>(this.f9536e.size() + this.f9537f.size() + 3);
        arrayList.addAll(this.f9536e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f9537f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f9539h, this.f9540i, this.f9541j, arrayList);
        return new f(this.a, this.f9534c, this.f9535d, this.f9538g, this.f9542k, this.o, this.m, this.n, this.p, this.f9543l, this.f9533b, this.f9539h, this.f9540i, this.f9541j, this.f9536e, this.f9537f, arrayList);
    }

    public g c(Type type, Object obj) {
        boolean z = obj instanceof q;
        com.google.gson.u.a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof s));
        if (obj instanceof h) {
            this.f9535d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.f9536e.add(com.google.gson.u.n.l.b(com.google.gson.v.a.get(type), obj));
        }
        if (obj instanceof s) {
            this.f9536e.add(com.google.gson.u.n.n.a(com.google.gson.v.a.get(type), (s) obj));
        }
        return this;
    }

    public g d(t tVar) {
        this.f9536e.add(tVar);
        return this;
    }

    public g e(String str) {
        this.f9539h = str;
        return this;
    }

    public g f(d dVar) {
        this.f9534c = dVar;
        return this;
    }
}