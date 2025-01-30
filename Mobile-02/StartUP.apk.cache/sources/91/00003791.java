package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import c.h.k.v;
import com.google.android.material.internal.j;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FloatingActionButtonImpl.java */
/* loaded from: classes2.dex */
public class a {
    static final TimeInterpolator a = e.g.a.f.l.a.f13293c;

    /* renamed from: b  reason: collision with root package name */
    static final int[] f8153b = {16842919, 16842910};

    /* renamed from: c  reason: collision with root package name */
    static final int[] f8154c = {16843623, 16842908, 16842910};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f8155d = {16842908, 16842910};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f8156e = {16843623, 16842910};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f8157f = {16842910};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f8158g = new int[0];
    private ArrayList<Animator.AnimatorListener> A;
    final j B;
    final e.g.a.f.s.b C;
    private ViewTreeObserver.OnPreDrawListener H;

    /* renamed from: i  reason: collision with root package name */
    Animator f8160i;

    /* renamed from: j  reason: collision with root package name */
    e.g.a.f.l.h f8161j;

    /* renamed from: k  reason: collision with root package name */
    e.g.a.f.l.h f8162k;

    /* renamed from: l  reason: collision with root package name */
    private e.g.a.f.l.h f8163l;
    private e.g.a.f.l.h m;
    private final com.google.android.material.internal.f n;
    e.g.a.f.s.a o;
    private float p;
    Drawable q;
    Drawable r;
    com.google.android.material.internal.a s;
    Drawable t;
    float u;
    float v;
    float w;
    int x;
    private ArrayList<Animator.AnimatorListener> z;

    /* renamed from: h  reason: collision with root package name */
    int f8159h = 0;
    float y = 1.0f;
    private final Rect D = new Rect();
    private final RectF E = new RectF();
    private final RectF F = new RectF();
    private final Matrix G = new Matrix();

    /* compiled from: FloatingActionButtonImpl.java */
    /* renamed from: com.google.android.material.floatingactionbutton.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0150a extends AnimatorListenerAdapter {
        private boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f8164b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ g f8165c;

        C0150a(boolean z, g gVar) {
            this.f8164b = z;
            this.f8165c = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f8159h = 0;
            aVar.f8160i = null;
            if (this.a) {
                return;
            }
            j jVar = aVar.B;
            boolean z = this.f8164b;
            jVar.b(z ? 8 : 4, z);
            g gVar = this.f8165c;
            if (gVar != null) {
                gVar.b();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.B.b(0, this.f8164b);
            a aVar = a.this;
            aVar.f8159h = 1;
            aVar.f8160i = animator;
            this.a = false;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    class b extends AnimatorListenerAdapter {
        final /* synthetic */ boolean a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f8167b;

        b(boolean z, g gVar) {
            this.a = z;
            this.f8167b = gVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a aVar = a.this;
            aVar.f8159h = 0;
            aVar.f8160i = null;
            g gVar = this.f8167b;
            if (gVar != null) {
                gVar.a();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            a.this.B.b(0, this.a);
            a aVar = a.this;
            aVar.f8159h = 2;
            aVar.f8160i = animator;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    public class c implements ViewTreeObserver.OnPreDrawListener {
        c() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a.this.z();
            return true;
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class d extends i {
        d() {
            super(a.this, null);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class e extends i {
        e() {
            super(a.this, null);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class f extends i {
        f() {
            super(a.this, null);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    interface g {
        void a();

        void b();
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private class h extends i {
        h() {
            super(a.this, null);
        }
    }

    /* compiled from: FloatingActionButtonImpl.java */
    /* loaded from: classes2.dex */
    private abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        private boolean a;

        private i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            e.g.a.f.s.a aVar = a.this.o;
            throw null;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                e.g.a.f.s.a aVar = a.this.o;
                throw null;
            }
            e.g.a.f.s.a aVar2 = a.this.o;
            valueAnimator.getAnimatedFraction();
            throw null;
        }

        /* synthetic */ i(a aVar, C0150a c0150a) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(j jVar, e.g.a.f.s.b bVar) {
        this.B = jVar;
        this.C = bVar;
        com.google.android.material.internal.f fVar = new com.google.android.material.internal.f();
        this.n = fVar;
        fVar.a(f8153b, e(new f()));
        fVar.a(f8154c, e(new e()));
        fVar.a(f8155d, e(new e()));
        fVar.a(f8156e, e(new e()));
        fVar.a(f8157f, e(new h()));
        fVar.a(f8158g, e(new d()));
        this.p = jVar.getRotation();
    }

    private boolean M() {
        return v.S(this.B) && !this.B.isInEditMode();
    }

    private void O() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.p % 90.0f != 0.0f) {
                if (this.B.getLayerType() != 1) {
                    this.B.setLayerType(1, null);
                }
            } else if (this.B.getLayerType() != 0) {
                this.B.setLayerType(0, null);
            }
        }
        if (this.o == null) {
            if (this.s != null) {
                throw null;
            }
            return;
        }
        throw null;
    }

    private void c(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.B.getDrawable();
        if (drawable == null || this.x == 0) {
            return;
        }
        RectF rectF = this.E;
        RectF rectF2 = this.F;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i2 = this.x;
        rectF2.set(0.0f, 0.0f, i2, i2);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i3 = this.x;
        matrix.postScale(f2, f2, i3 / 2.0f, i3 / 2.0f);
    }

    private AnimatorSet d(e.g.a.f.l.h hVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.B, View.ALPHA, f2);
        hVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.B, View.SCALE_X, f3);
        hVar.d("scale").a(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.B, View.SCALE_Y, f3);
        hVar.d("scale").a(ofFloat3);
        arrayList.add(ofFloat3);
        c(f4, this.G);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.B, new e.g.a.f.l.f(), new e.g.a.f.l.g(), new Matrix(this.G));
        hVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        e.g.a.f.l.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    private ValueAnimator e(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    private void f() {
        if (this.H == null) {
            this.H = new c();
        }
    }

    private e.g.a.f.l.h h() {
        if (this.m == null) {
            this.m = e.g.a.f.l.h.b(this.B.getContext(), e.g.a.f.a.a);
        }
        return this.m;
    }

    private e.g.a.f.l.h i() {
        if (this.f8163l == null) {
            this.f8163l = e.g.a.f.l.h.b(this.B.getContext(), e.g.a.f.a.f13224b);
        }
        return this.f8163l;
    }

    public void A(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.A;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.z;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    boolean C() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(ColorStateList colorStateList) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        }
        if (this.s != null) {
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E(PorterDuff.Mode mode) {
        Drawable drawable = this.q;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void F(float f2) {
        if (this.u != f2) {
            this.u = f2;
            x(f2, this.v, this.w);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G(e.g.a.f.l.h hVar) {
        this.f8162k = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(float f2) {
        if (this.v != f2) {
            this.v = f2;
            x(this.u, f2, this.w);
        }
    }

    final void I(float f2) {
        this.y = f2;
        Matrix matrix = this.G;
        c(f2, matrix);
        this.B.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void J(float f2) {
        if (this.w != f2) {
            this.w = f2;
            x(this.u, this.v, f2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K(ColorStateList colorStateList) {
        Drawable drawable = this.r;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, e.g.a.f.r.a.a(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void L(e.g.a.f.l.h hVar) {
        this.f8161j = hVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void N(g gVar, boolean z) {
        if (r()) {
            return;
        }
        Animator animator = this.f8160i;
        if (animator != null) {
            animator.cancel();
        }
        if (M()) {
            if (this.B.getVisibility() != 0) {
                this.B.setAlpha(0.0f);
                this.B.setScaleY(0.0f);
                this.B.setScaleX(0.0f);
                I(0.0f);
            }
            e.g.a.f.l.h hVar = this.f8161j;
            if (hVar == null) {
                hVar = i();
            }
            AnimatorSet d2 = d(hVar, 1.0f, 1.0f, 1.0f);
            d2.addListener(new b(z, gVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.z;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    d2.addListener(it.next());
                }
            }
            d2.start();
            return;
        }
        this.B.b(0, z);
        this.B.setAlpha(1.0f);
        this.B.setScaleY(1.0f);
        this.B.setScaleX(1.0f);
        I(1.0f);
        if (gVar != null) {
            gVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void P() {
        I(this.y);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void Q() {
        Rect rect = this.D;
        m(rect);
        y(rect);
        this.C.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void a(Animator.AnimatorListener animatorListener) {
        if (this.A == null) {
            this.A = new ArrayList<>();
        }
        this.A.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Animator.AnimatorListener animatorListener) {
        if (this.z == null) {
            this.z = new ArrayList<>();
        }
        this.z.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable g() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float j() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.g.a.f.l.h k() {
        return this.f8162k;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float l() {
        return this.v;
    }

    void m(Rect rect) {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float n() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.g.a.f.l.h o() {
        return this.f8161j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(g gVar, boolean z) {
        if (q()) {
            return;
        }
        Animator animator = this.f8160i;
        if (animator != null) {
            animator.cancel();
        }
        if (M()) {
            e.g.a.f.l.h hVar = this.f8162k;
            if (hVar == null) {
                hVar = h();
            }
            AnimatorSet d2 = d(hVar, 0.0f, 0.0f, 0.0f);
            d2.addListener(new C0150a(z, gVar));
            ArrayList<Animator.AnimatorListener> arrayList = this.A;
            if (arrayList != null) {
                Iterator<Animator.AnimatorListener> it = arrayList.iterator();
                while (it.hasNext()) {
                    d2.addListener(it.next());
                }
            }
            d2.start();
            return;
        }
        this.B.b(z ? 8 : 4, z);
        if (gVar != null) {
            gVar.b();
        }
    }

    boolean q() {
        return this.B.getVisibility() == 0 ? this.f8159h == 1 : this.f8159h != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.B.getVisibility() != 0 ? this.f8159h == 2 : this.f8159h != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s() {
        this.n.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        if (C()) {
            f();
            this.B.getViewTreeObserver().addOnPreDrawListener(this.H);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        if (this.H != null) {
            this.B.getViewTreeObserver().removeOnPreDrawListener(this.H);
            this.H = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(int[] iArr) {
        this.n.d(iArr);
    }

    void x(float f2, float f3, float f4) {
        if (this.o != null) {
            throw null;
        }
    }

    void y(Rect rect) {
    }

    void z() {
        float rotation = this.B.getRotation();
        if (this.p != rotation) {
            this.p = rotation;
            O();
        }
    }
}