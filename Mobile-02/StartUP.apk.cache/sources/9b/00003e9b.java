package com.rd.c.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.rd.c.d.b.b;
import com.rd.c.d.b.c;
import com.rd.c.d.b.d;
import com.rd.c.d.b.e;
import com.rd.c.d.b.f;
import com.rd.c.d.b.g;
import com.rd.c.d.b.h;
import com.rd.c.d.b.i;
import com.rd.c.d.b.j;
import com.rd.c.d.b.k;

/* compiled from: Drawer.java */
/* loaded from: classes2.dex */
public class a {
    private b a;

    /* renamed from: b  reason: collision with root package name */
    private c f10659b;

    /* renamed from: c  reason: collision with root package name */
    private g f10660c;

    /* renamed from: d  reason: collision with root package name */
    private k f10661d;

    /* renamed from: e  reason: collision with root package name */
    private h f10662e;

    /* renamed from: f  reason: collision with root package name */
    private e f10663f;

    /* renamed from: g  reason: collision with root package name */
    private j f10664g;

    /* renamed from: h  reason: collision with root package name */
    private d f10665h;

    /* renamed from: i  reason: collision with root package name */
    private i f10666i;

    /* renamed from: j  reason: collision with root package name */
    private f f10667j;

    /* renamed from: k  reason: collision with root package name */
    private int f10668k;

    /* renamed from: l  reason: collision with root package name */
    private int f10669l;
    private int m;

    public a(com.rd.c.c.a aVar) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.a = new b(paint, aVar);
        this.f10659b = new c(paint, aVar);
        this.f10660c = new g(paint, aVar);
        this.f10661d = new k(paint, aVar);
        this.f10662e = new h(paint, aVar);
        this.f10663f = new e(paint, aVar);
        this.f10664g = new j(paint, aVar);
        this.f10665h = new d(paint, aVar);
        this.f10666i = new i(paint, aVar);
        this.f10667j = new f(paint, aVar);
    }

    public void a(Canvas canvas, boolean z) {
        if (this.f10659b != null) {
            this.a.a(canvas, this.f10668k, z, this.f10669l, this.m);
        }
    }

    public void b(Canvas canvas, com.rd.b.c.a aVar) {
        c cVar = this.f10659b;
        if (cVar != null) {
            cVar.a(canvas, aVar, this.f10668k, this.f10669l, this.m);
        }
    }

    public void c(Canvas canvas, com.rd.b.c.a aVar) {
        d dVar = this.f10665h;
        if (dVar != null) {
            dVar.a(canvas, aVar, this.f10669l, this.m);
        }
    }

    public void d(Canvas canvas, com.rd.b.c.a aVar) {
        e eVar = this.f10663f;
        if (eVar != null) {
            eVar.a(canvas, aVar, this.f10668k, this.f10669l, this.m);
        }
    }

    public void e(Canvas canvas, com.rd.b.c.a aVar) {
        g gVar = this.f10660c;
        if (gVar != null) {
            gVar.a(canvas, aVar, this.f10668k, this.f10669l, this.m);
        }
    }

    public void f(Canvas canvas, com.rd.b.c.a aVar) {
        f fVar = this.f10667j;
        if (fVar != null) {
            fVar.a(canvas, aVar, this.f10668k, this.f10669l, this.m);
        }
    }

    public void g(Canvas canvas, com.rd.b.c.a aVar) {
        h hVar = this.f10662e;
        if (hVar != null) {
            hVar.a(canvas, aVar, this.f10669l, this.m);
        }
    }

    public void h(Canvas canvas, com.rd.b.c.a aVar) {
        i iVar = this.f10666i;
        if (iVar != null) {
            iVar.a(canvas, aVar, this.f10668k, this.f10669l, this.m);
        }
    }

    public void i(Canvas canvas, com.rd.b.c.a aVar) {
        j jVar = this.f10664g;
        if (jVar != null) {
            jVar.a(canvas, aVar, this.f10669l, this.m);
        }
    }

    public void j(Canvas canvas, com.rd.b.c.a aVar) {
        k kVar = this.f10661d;
        if (kVar != null) {
            kVar.a(canvas, aVar, this.f10669l, this.m);
        }
    }

    public void k(int i2, int i3, int i4) {
        this.f10668k = i2;
        this.f10669l = i3;
        this.m = i4;
    }
}