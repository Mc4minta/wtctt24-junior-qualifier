package e.f.j.e;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBuffer;
import e.f.j.d.p;
import e.f.j.l.a0;
import e.f.j.l.b0;
import e.f.j.l.c0;
import e.f.j.l.e0;
import e.f.j.l.f0;
import e.f.j.l.g0;
import e.f.j.l.h0;
import e.f.j.l.i0;
import e.f.j.l.j0;
import e.f.j.l.n0;
import e.f.j.l.o;
import e.f.j.l.o0;
import e.f.j.l.q;
import e.f.j.l.r;
import e.f.j.l.r0;
import e.f.j.l.s0;
import e.f.j.l.t0;
import e.f.j.l.u0;
import e.f.j.l.v;
import e.f.j.l.v0;
import e.f.j.l.w;
import e.f.j.l.w0;
import e.f.j.l.x;
import e.f.j.l.y;
import e.f.j.l.y0;

/* compiled from: ProducerFactory.java */
/* loaded from: classes2.dex */
public class m {
    private ContentResolver a;

    /* renamed from: b  reason: collision with root package name */
    private Resources f12539b;

    /* renamed from: c  reason: collision with root package name */
    private AssetManager f12540c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.common.memory.a f12541d;

    /* renamed from: e  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.b f12542e;

    /* renamed from: f  reason: collision with root package name */
    private final com.facebook.imagepipeline.decoder.d f12543f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12544g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f12545h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f12546i;

    /* renamed from: j  reason: collision with root package name */
    private final f f12547j;

    /* renamed from: k  reason: collision with root package name */
    private final com.facebook.common.memory.g f12548k;

    /* renamed from: l  reason: collision with root package name */
    private final e.f.j.d.e f12549l;
    private final e.f.j.d.e m;
    private final p<e.f.b.a.d, PooledByteBuffer> n;
    private final p<e.f.b.a.d, e.f.j.i.b> o;
    private final e.f.j.d.f p;
    private final e.f.j.c.f q;
    private final int r;
    private final int s;
    private boolean t;
    private final a u;
    private final int v;

    public m(Context context, com.facebook.common.memory.a aVar, com.facebook.imagepipeline.decoder.b bVar, com.facebook.imagepipeline.decoder.d dVar, boolean z, boolean z2, boolean z3, f fVar, com.facebook.common.memory.g gVar, p<e.f.b.a.d, e.f.j.i.b> pVar, p<e.f.b.a.d, PooledByteBuffer> pVar2, e.f.j.d.e eVar, e.f.j.d.e eVar2, e.f.j.d.f fVar2, e.f.j.c.f fVar3, int i2, int i3, boolean z4, int i4, a aVar2) {
        this.a = context.getApplicationContext().getContentResolver();
        this.f12539b = context.getApplicationContext().getResources();
        this.f12540c = context.getApplicationContext().getAssets();
        this.f12541d = aVar;
        this.f12542e = bVar;
        this.f12543f = dVar;
        this.f12544g = z;
        this.f12545h = z2;
        this.f12546i = z3;
        this.f12547j = fVar;
        this.f12548k = gVar;
        this.o = pVar;
        this.n = pVar2;
        this.f12549l = eVar;
        this.m = eVar2;
        this.p = fVar2;
        this.q = fVar3;
        this.r = i2;
        this.s = i3;
        this.t = z4;
        this.v = i4;
        this.u = aVar2;
    }

    public static <T> r0<T> A(j0<T> j0Var) {
        return new r0<>(j0Var);
    }

    public static e.f.j.l.a a(j0<e.f.j.i.d> j0Var) {
        return new e.f.j.l.a(j0Var);
    }

    public static e.f.j.l.j g(j0<e.f.j.i.d> j0Var, j0<e.f.j.i.d> j0Var2) {
        return new e.f.j.l.j(j0Var, j0Var2);
    }

    public <T> u0<T> B(j0<T> j0Var) {
        return new u0<>(5, this.f12547j.b(), j0Var);
    }

    public v0 C(w0<e.f.j.i.d>[] w0VarArr) {
        return new v0(w0VarArr);
    }

    public y0 D(j0<e.f.j.i.d> j0Var) {
        return new y0(this.f12547j.c(), this.f12548k, j0Var);
    }

    public <T> s0<T> b(j0<T> j0Var, t0 t0Var) {
        return new s0<>(j0Var, t0Var);
    }

    public e.f.j.l.f c(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new e.f.j.l.f(this.o, this.p, j0Var);
    }

    public e.f.j.l.g d(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new e.f.j.l.g(this.p, j0Var);
    }

    public e.f.j.l.h e(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new e.f.j.l.h(this.o, this.p, j0Var);
    }

    public e.f.j.l.i f(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new e.f.j.l.i(j0Var, this.r, this.s, this.t);
    }

    public e.f.j.l.l h() {
        return new e.f.j.l.l(this.f12548k);
    }

    public e.f.j.l.m i(j0<e.f.j.i.d> j0Var) {
        return new e.f.j.l.m(this.f12541d, this.f12547j.a(), this.f12542e, this.f12543f, this.f12544g, this.f12545h, this.f12546i, j0Var, this.v, this.u);
    }

    public o j(j0<e.f.j.i.d> j0Var) {
        return new o(this.f12549l, this.m, this.p, j0Var);
    }

    public e.f.j.l.p k(j0<e.f.j.i.d> j0Var) {
        return new e.f.j.l.p(this.f12549l, this.m, this.p, j0Var);
    }

    public q l(j0<e.f.j.i.d> j0Var) {
        return new q(this.p, j0Var);
    }

    public r m(j0<e.f.j.i.d> j0Var) {
        return new r(this.n, this.p, j0Var);
    }

    public v n() {
        return new v(this.f12547j.e(), this.f12548k, this.f12540c);
    }

    public w o() {
        return new w(this.f12547j.e(), this.f12548k, this.a);
    }

    public x p() {
        return new x(this.f12547j.e(), this.f12548k, this.a);
    }

    public y q() {
        return new y(this.f12547j.e(), this.f12548k, this.a);
    }

    public a0 r() {
        return new a0(this.f12547j.e(), this.f12548k);
    }

    public b0 s() {
        return new b0(this.f12547j.e(), this.f12548k, this.f12539b);
    }

    public c0 t() {
        return new c0(this.f12547j.e(), this.a);
    }

    public e0 u(f0 f0Var) {
        return new e0(this.f12548k, this.f12541d, f0Var);
    }

    public g0 v(j0<e.f.j.i.d> j0Var) {
        return new g0(this.f12549l, this.p, this.f12548k, this.f12541d, j0Var);
    }

    public h0 w(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new h0(this.o, this.p, j0Var);
    }

    public i0 x(j0<com.facebook.common.references.a<e.f.j.i.b>> j0Var) {
        return new i0(j0Var, this.q, this.f12547j.c());
    }

    public n0 y() {
        return new n0(this.f12547j.e(), this.f12548k, this.a);
    }

    public o0 z(j0<e.f.j.i.d> j0Var, boolean z, e.f.j.n.d dVar) {
        return new o0(this.f12547j.c(), this.f12548k, j0Var, z, dVar);
    }
}