package e.a.a;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: LottieDrawable.java */
/* loaded from: classes.dex */
public class g extends Drawable implements Drawable.Callback, Animatable {
    private static final String a = g.class.getSimpleName();
    private boolean A;
    private boolean B;

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f11535b = new Matrix();

    /* renamed from: c  reason: collision with root package name */
    private e.a.a.e f11536c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.z.e f11537d;

    /* renamed from: e  reason: collision with root package name */
    private float f11538e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11539f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11540g;

    /* renamed from: h  reason: collision with root package name */
    private final Set<?> f11541h;

    /* renamed from: j  reason: collision with root package name */
    private final ArrayList<o> f11542j;

    /* renamed from: k  reason: collision with root package name */
    private final ValueAnimator.AnimatorUpdateListener f11543k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView.ScaleType f11544l;
    private e.a.a.v.b m;
    private String n;
    private e.a.a.b p;
    private e.a.a.v.a q;
    e.a.a.a t;
    t u;
    private boolean v;
    private e.a.a.w.l.b w;
    private int x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class a implements o {
        final /* synthetic */ String a;

        a(String str) {
            this.a = str;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.W(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class b implements o {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f11546b;

        b(int i2, int i3) {
            this.a = i2;
            this.f11546b = i3;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.V(this.a, this.f11546b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class c implements o {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.P(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class d implements o {
        final /* synthetic */ float a;

        d(float f2) {
            this.a = f2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.b0(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class e implements o {
        final /* synthetic */ e.a.a.w.e a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f11550b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e.a.a.a0.c f11551c;

        e(e.a.a.w.e eVar, Object obj, e.a.a.a0.c cVar) {
            this.a = eVar;
            this.f11550b = obj;
            this.f11551c = cVar;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.d(this.a, this.f11550b, this.f11551c);
        }
    }

    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    class f implements ValueAnimator.AnimatorUpdateListener {
        f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (g.this.w != null) {
                g.this.w.G(g.this.f11537d.k());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* renamed from: e.a.a.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0254g implements o {
        C0254g() {
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.I();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class h implements o {
        h() {
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class i implements o {
        final /* synthetic */ int a;

        i(int i2) {
            this.a = i2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.X(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class j implements o {
        final /* synthetic */ float a;

        j(float f2) {
            this.a = f2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.Z(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class k implements o {
        final /* synthetic */ int a;

        k(int i2) {
            this.a = i2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.S(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class l implements o {
        final /* synthetic */ float a;

        l(float f2) {
            this.a = f2;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.U(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class m implements o {
        final /* synthetic */ String a;

        m(String str) {
            this.a = str;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.Y(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public class n implements o {
        final /* synthetic */ String a;

        n(String str) {
            this.a = str;
        }

        @Override // e.a.a.g.o
        public void a(e.a.a.e eVar) {
            g.this.T(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LottieDrawable.java */
    /* loaded from: classes.dex */
    public interface o {
        void a(e.a.a.e eVar);
    }

    public g() {
        e.a.a.z.e eVar = new e.a.a.z.e();
        this.f11537d = eVar;
        this.f11538e = 1.0f;
        this.f11539f = true;
        this.f11540g = false;
        this.f11541h = new HashSet();
        this.f11542j = new ArrayList<>();
        f fVar = new f();
        this.f11543k = fVar;
        this.x = 255;
        this.A = true;
        this.B = false;
        eVar.addUpdateListener(fVar);
    }

    private void e() {
        this.w = new e.a.a.w.l.b(this, e.a.a.y.s.a(this.f11536c), this.f11536c.j(), this.f11536c);
    }

    private void h(Canvas canvas) {
        if (ImageView.ScaleType.FIT_XY == this.f11544l) {
            i(canvas);
        } else {
            j(canvas);
        }
    }

    private void i(Canvas canvas) {
        float f2;
        if (this.w == null) {
            return;
        }
        int i2 = -1;
        Rect bounds = getBounds();
        float width = bounds.width() / this.f11536c.b().width();
        float height = bounds.height() / this.f11536c.b().height();
        if (this.A) {
            float min = Math.min(width, height);
            if (min < 1.0f) {
                f2 = 1.0f / min;
                width /= f2;
                height /= f2;
            } else {
                f2 = 1.0f;
            }
            if (f2 > 1.0f) {
                i2 = canvas.save();
                float width2 = bounds.width() / 2.0f;
                float height2 = bounds.height() / 2.0f;
                float f3 = width2 * min;
                float f4 = min * height2;
                canvas.translate(width2 - f3, height2 - f4);
                canvas.scale(f2, f2, f3, f4);
            }
        }
        this.f11535b.reset();
        this.f11535b.preScale(width, height);
        this.w.f(canvas, this.f11535b, this.x);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void j(Canvas canvas) {
        float f2;
        if (this.w == null) {
            return;
        }
        float f3 = this.f11538e;
        float v = v(canvas);
        if (f3 > v) {
            f2 = this.f11538e / v;
        } else {
            v = f3;
            f2 = 1.0f;
        }
        int i2 = -1;
        if (f2 > 1.0f) {
            i2 = canvas.save();
            float width = this.f11536c.b().width() / 2.0f;
            float height = this.f11536c.b().height() / 2.0f;
            float f4 = width * v;
            float f5 = height * v;
            canvas.translate((B() * width) - f4, (B() * height) - f5);
            canvas.scale(f2, f2, f4, f5);
        }
        this.f11535b.reset();
        this.f11535b.preScale(v, v);
        this.w.f(canvas, this.f11535b, this.x);
        if (i2 > 0) {
            canvas.restoreToCount(i2);
        }
    }

    private void k0() {
        if (this.f11536c == null) {
            return;
        }
        float B = B();
        setBounds(0, 0, (int) (this.f11536c.b().width() * B), (int) (this.f11536c.b().height() * B));
    }

    private Context o() {
        Drawable.Callback callback = getCallback();
        if (callback != null && (callback instanceof View)) {
            return ((View) callback).getContext();
        }
        return null;
    }

    private e.a.a.v.a p() {
        if (getCallback() == null) {
            return null;
        }
        if (this.q == null) {
            this.q = new e.a.a.v.a(getCallback(), this.t);
        }
        return this.q;
    }

    private e.a.a.v.b s() {
        if (getCallback() == null) {
            return null;
        }
        e.a.a.v.b bVar = this.m;
        if (bVar != null && !bVar.b(o())) {
            this.m = null;
        }
        if (this.m == null) {
            this.m = new e.a.a.v.b(getCallback(), this.n, this.p, this.f11536c.i());
        }
        return this.m;
    }

    private float v(Canvas canvas) {
        return Math.min(canvas.getWidth() / this.f11536c.b().width(), canvas.getHeight() / this.f11536c.b().height());
    }

    public int A() {
        return this.f11537d.getRepeatMode();
    }

    public float B() {
        return this.f11538e;
    }

    public float C() {
        return this.f11537d.q();
    }

    public t D() {
        return this.u;
    }

    public Typeface E(String str, String str2) {
        e.a.a.v.a p = p();
        if (p != null) {
            return p.b(str, str2);
        }
        return null;
    }

    public boolean F() {
        e.a.a.z.e eVar = this.f11537d;
        if (eVar == null) {
            return false;
        }
        return eVar.isRunning();
    }

    public boolean G() {
        return this.z;
    }

    public void H() {
        this.f11542j.clear();
        this.f11537d.s();
    }

    public void I() {
        if (this.w == null) {
            this.f11542j.add(new C0254g());
            return;
        }
        if (this.f11539f || z() == 0) {
            this.f11537d.t();
        }
        if (this.f11539f) {
            return;
        }
        P((int) (C() < 0.0f ? w() : u()));
        this.f11537d.i();
    }

    public List<e.a.a.w.e> J(e.a.a.w.e eVar) {
        if (this.w == null) {
            e.a.a.z.d.c("Cannot resolve KeyPath. Composition is not set yet.");
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        this.w.c(eVar, 0, arrayList, new e.a.a.w.e(new String[0]));
        return arrayList;
    }

    public void K() {
        if (this.w == null) {
            this.f11542j.add(new h());
            return;
        }
        if (this.f11539f || z() == 0) {
            this.f11537d.x();
        }
        if (this.f11539f) {
            return;
        }
        P((int) (C() < 0.0f ? w() : u()));
        this.f11537d.i();
    }

    public void L() {
        this.f11537d.y();
    }

    public void M(boolean z) {
        this.z = z;
    }

    public boolean N(e.a.a.e eVar) {
        if (this.f11536c == eVar) {
            return false;
        }
        this.B = false;
        g();
        this.f11536c = eVar;
        e();
        this.f11537d.A(eVar);
        b0(this.f11537d.getAnimatedFraction());
        f0(this.f11538e);
        k0();
        Iterator it = new ArrayList(this.f11542j).iterator();
        while (it.hasNext()) {
            ((o) it.next()).a(eVar);
            it.remove();
        }
        this.f11542j.clear();
        eVar.u(this.y);
        Drawable.Callback callback = getCallback();
        if (callback instanceof ImageView) {
            ImageView imageView = (ImageView) callback;
            imageView.setImageDrawable(null);
            imageView.setImageDrawable(this);
            return true;
        }
        return true;
    }

    public void O(e.a.a.a aVar) {
        e.a.a.v.a aVar2 = this.q;
        if (aVar2 != null) {
            aVar2.c(aVar);
        }
    }

    public void P(int i2) {
        if (this.f11536c == null) {
            this.f11542j.add(new c(i2));
        } else {
            this.f11537d.B(i2);
        }
    }

    public void Q(e.a.a.b bVar) {
        this.p = bVar;
        e.a.a.v.b bVar2 = this.m;
        if (bVar2 != null) {
            bVar2.d(bVar);
        }
    }

    public void R(String str) {
        this.n = str;
    }

    public void S(int i2) {
        if (this.f11536c == null) {
            this.f11542j.add(new k(i2));
        } else {
            this.f11537d.C(i2 + 0.99f);
        }
    }

    public void T(String str) {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            this.f11542j.add(new n(str));
            return;
        }
        e.a.a.w.h k2 = eVar.k(str);
        if (k2 != null) {
            S((int) (k2.f11766c + k2.f11767d));
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void U(float f2) {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            this.f11542j.add(new l(f2));
        } else {
            S((int) e.a.a.z.g.k(eVar.o(), this.f11536c.f(), f2));
        }
    }

    public void V(int i2, int i3) {
        if (this.f11536c == null) {
            this.f11542j.add(new b(i2, i3));
        } else {
            this.f11537d.D(i2, i3 + 0.99f);
        }
    }

    public void W(String str) {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            this.f11542j.add(new a(str));
            return;
        }
        e.a.a.w.h k2 = eVar.k(str);
        if (k2 != null) {
            int i2 = (int) k2.f11766c;
            V(i2, ((int) k2.f11767d) + i2);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void X(int i2) {
        if (this.f11536c == null) {
            this.f11542j.add(new i(i2));
        } else {
            this.f11537d.E(i2);
        }
    }

    public void Y(String str) {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            this.f11542j.add(new m(str));
            return;
        }
        e.a.a.w.h k2 = eVar.k(str);
        if (k2 != null) {
            X((int) k2.f11766c);
            return;
        }
        throw new IllegalArgumentException("Cannot find marker with name " + str + ".");
    }

    public void Z(float f2) {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            this.f11542j.add(new j(f2));
        } else {
            X((int) e.a.a.z.g.k(eVar.o(), this.f11536c.f(), f2));
        }
    }

    public void a0(boolean z) {
        this.y = z;
        e.a.a.e eVar = this.f11536c;
        if (eVar != null) {
            eVar.u(z);
        }
    }

    public void b0(float f2) {
        if (this.f11536c == null) {
            this.f11542j.add(new d(f2));
            return;
        }
        e.a.a.c.a("Drawable#setProgress");
        this.f11537d.B(e.a.a.z.g.k(this.f11536c.o(), this.f11536c.f(), f2));
        e.a.a.c.b("Drawable#setProgress");
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.f11537d.addListener(animatorListener);
    }

    public void c0(int i2) {
        this.f11537d.setRepeatCount(i2);
    }

    public <T> void d(e.a.a.w.e eVar, T t, e.a.a.a0.c<T> cVar) {
        e.a.a.w.l.b bVar = this.w;
        if (bVar == null) {
            this.f11542j.add(new e(eVar, t, cVar));
            return;
        }
        boolean z = true;
        if (eVar == e.a.a.w.e.a) {
            bVar.g(t, cVar);
        } else if (eVar.d() != null) {
            eVar.d().g(t, cVar);
        } else {
            List<e.a.a.w.e> J = J(eVar);
            for (int i2 = 0; i2 < J.size(); i2++) {
                J.get(i2).d().g(t, cVar);
            }
            z = true ^ J.isEmpty();
        }
        if (z) {
            invalidateSelf();
            if (t == e.a.a.l.A) {
                b0(y());
            }
        }
    }

    public void d0(int i2) {
        this.f11537d.setRepeatMode(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.B = false;
        e.a.a.c.a("Drawable#draw");
        if (this.f11540g) {
            try {
                h(canvas);
            } catch (Throwable th) {
                e.a.a.z.d.b("Lottie crashed in draw!", th);
            }
        } else {
            h(canvas);
        }
        e.a.a.c.b("Drawable#draw");
    }

    public void e0(boolean z) {
        this.f11540g = z;
    }

    public void f() {
        this.f11542j.clear();
        this.f11537d.cancel();
    }

    public void f0(float f2) {
        this.f11538e = f2;
        k0();
    }

    public void g() {
        if (this.f11537d.isRunning()) {
            this.f11537d.cancel();
        }
        this.f11536c = null;
        this.w = null;
        this.m = null;
        this.f11537d.h();
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(ImageView.ScaleType scaleType) {
        this.f11544l = scaleType;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.x;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            return -1;
        }
        return (int) (eVar.b().height() * B());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        e.a.a.e eVar = this.f11536c;
        if (eVar == null) {
            return -1;
        }
        return (int) (eVar.b().width() * B());
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public void h0(float f2) {
        this.f11537d.F(f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i0(Boolean bool) {
        this.f11539f = bool.booleanValue();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.B) {
            return;
        }
        this.B = true;
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return F();
    }

    public void j0(t tVar) {
    }

    public void k(boolean z) {
        if (this.v == z) {
            return;
        }
        if (Build.VERSION.SDK_INT < 19) {
            e.a.a.z.d.c("Merge paths are not supported pre-Kit Kat.");
            return;
        }
        this.v = z;
        if (this.f11536c != null) {
            e();
        }
    }

    public boolean l() {
        return this.v;
    }

    public boolean l0() {
        return this.u == null && this.f11536c.c().p() > 0;
    }

    public void m() {
        this.f11542j.clear();
        this.f11537d.i();
    }

    public e.a.a.e n() {
        return this.f11536c;
    }

    public int q() {
        return (int) this.f11537d.l();
    }

    public Bitmap r(String str) {
        e.a.a.v.b s = s();
        if (s != null) {
            return s.a(str);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.x = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        e.a.a.z.d.c("Use addColorFilter instead.");
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable.Callback callback = getCallback();
        if (!(callback instanceof View) || ((View) callback).isInEditMode()) {
            return;
        }
        I();
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        m();
    }

    public String t() {
        return this.n;
    }

    public float u() {
        return this.f11537d.o();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback == null) {
            return;
        }
        callback.unscheduleDrawable(this, runnable);
    }

    public float w() {
        return this.f11537d.p();
    }

    public e.a.a.o x() {
        e.a.a.e eVar = this.f11536c;
        if (eVar != null) {
            return eVar.m();
        }
        return null;
    }

    public float y() {
        return this.f11537d.k();
    }

    public int z() {
        return this.f11537d.getRepeatCount();
    }
}