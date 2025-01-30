package c.a.o;

import android.view.View;
import android.view.animation.Interpolator;
import c.h.k.a0;
import c.h.k.b0;
import c.h.k.z;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f2581c;

    /* renamed from: d  reason: collision with root package name */
    a0 f2582d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2583e;

    /* renamed from: b  reason: collision with root package name */
    private long f2580b = -1;

    /* renamed from: f  reason: collision with root package name */
    private final b0 f2584f = new a();
    final ArrayList<z> a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* loaded from: classes.dex */
    class a extends b0 {
        private boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f2585b = 0;

        a() {
        }

        @Override // c.h.k.a0
        public void b(View view) {
            int i2 = this.f2585b + 1;
            this.f2585b = i2;
            if (i2 == h.this.a.size()) {
                a0 a0Var = h.this.f2582d;
                if (a0Var != null) {
                    a0Var.b(null);
                }
                d();
            }
        }

        @Override // c.h.k.b0, c.h.k.a0
        public void c(View view) {
            if (this.a) {
                return;
            }
            this.a = true;
            a0 a0Var = h.this.f2582d;
            if (a0Var != null) {
                a0Var.c(null);
            }
        }

        void d() {
            this.f2585b = 0;
            this.a = false;
            h.this.b();
        }
    }

    public void a() {
        if (this.f2583e) {
            Iterator<z> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
            this.f2583e = false;
        }
    }

    void b() {
        this.f2583e = false;
    }

    public h c(z zVar) {
        if (!this.f2583e) {
            this.a.add(zVar);
        }
        return this;
    }

    public h d(z zVar, z zVar2) {
        this.a.add(zVar);
        zVar2.h(zVar.c());
        this.a.add(zVar2);
        return this;
    }

    public h e(long j2) {
        if (!this.f2583e) {
            this.f2580b = j2;
        }
        return this;
    }

    public h f(Interpolator interpolator) {
        if (!this.f2583e) {
            this.f2581c = interpolator;
        }
        return this;
    }

    public h g(a0 a0Var) {
        if (!this.f2583e) {
            this.f2582d = a0Var;
        }
        return this;
    }

    public void h() {
        if (this.f2583e) {
            return;
        }
        Iterator<z> it = this.a.iterator();
        while (it.hasNext()) {
            z next = it.next();
            long j2 = this.f2580b;
            if (j2 >= 0) {
                next.d(j2);
            }
            Interpolator interpolator = this.f2581c;
            if (interpolator != null) {
                next.e(interpolator);
            }
            if (this.f2582d != null) {
                next.f(this.f2584f);
            }
            next.j();
        }
        this.f2583e = true;
    }
}