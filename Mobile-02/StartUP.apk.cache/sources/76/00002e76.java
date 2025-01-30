package com.facebook.react.modules.fresco;

import android.util.Pair;
import com.facebook.systrace.a;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SystraceRequestListener.java */
/* loaded from: classes2.dex */
public class c extends e.f.j.j.a {
    int a = 0;

    /* renamed from: b  reason: collision with root package name */
    Map<String, Pair<Integer, String>> f4948b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    Map<String, Pair<Integer, String>> f4949c = new HashMap();

    @Override // e.f.j.j.a, e.f.j.j.c
    public void a(com.facebook.imagepipeline.request.b bVar, Object obj, String str, boolean z) {
        if (com.facebook.systrace.a.h(0L)) {
            Pair<Integer, String> create = Pair.create(Integer.valueOf(this.a), "FRESCO_REQUEST_" + bVar.q().toString().replace(':', '_'));
            com.facebook.systrace.a.a(0L, (String) create.second, this.a);
            this.f4949c.put(str, create);
            this.a = this.a + 1;
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void b(String str, String str2) {
        if (com.facebook.systrace.a.h(0L)) {
            Pair<Integer, String> create = Pair.create(Integer.valueOf(this.a), "FRESCO_PRODUCER_" + str2.replace(':', '_'));
            com.facebook.systrace.a.a(0L, (String) create.second, this.a);
            this.f4948b.put(str, create);
            this.a = this.a + 1;
        }
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void c(com.facebook.imagepipeline.request.b bVar, String str, boolean z) {
        if (com.facebook.systrace.a.h(0L) && this.f4949c.containsKey(str)) {
            Pair<Integer, String> pair = this.f4949c.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4949c.remove(str);
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void d(String str, String str2, Map<String, String> map) {
        if (com.facebook.systrace.a.h(0L) && this.f4948b.containsKey(str)) {
            Pair<Integer, String> pair = this.f4948b.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4948b.remove(str);
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public boolean f(String str) {
        return false;
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void g(com.facebook.imagepipeline.request.b bVar, String str, Throwable th, boolean z) {
        if (com.facebook.systrace.a.h(0L) && this.f4949c.containsKey(str)) {
            Pair<Integer, String> pair = this.f4949c.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4949c.remove(str);
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void h(String str, String str2, String str3) {
        if (com.facebook.systrace.a.h(0L)) {
            com.facebook.systrace.a.l(0L, "FRESCO_PRODUCER_EVENT_" + str.replace(':', '_') + "_" + str2.replace(':', '_') + "_" + str3.replace(':', '_'), a.EnumC0129a.THREAD);
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void i(String str, String str2, Map<String, String> map) {
        if (com.facebook.systrace.a.h(0L) && this.f4948b.containsKey(str)) {
            Pair<Integer, String> pair = this.f4948b.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4948b.remove(str);
        }
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void j(String str, String str2, Throwable th, Map<String, String> map) {
        if (com.facebook.systrace.a.h(0L) && this.f4948b.containsKey(str)) {
            Pair<Integer, String> pair = this.f4948b.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4948b.remove(str);
        }
    }

    @Override // e.f.j.j.a, e.f.j.j.c
    public void k(String str) {
        if (com.facebook.systrace.a.h(0L) && this.f4949c.containsKey(str)) {
            Pair<Integer, String> pair = this.f4949c.get(str);
            com.facebook.systrace.a.e(0L, (String) pair.second, ((Integer) pair.first).intValue());
            this.f4949c.remove(str);
        }
    }
}