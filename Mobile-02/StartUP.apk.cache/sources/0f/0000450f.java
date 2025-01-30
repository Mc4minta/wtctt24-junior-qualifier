package e.a.a.z;

import android.view.Choreographer;

/* compiled from: LottieValueAnimator.java */
/* loaded from: classes.dex */
public class e extends a implements Choreographer.FrameCallback {

    /* renamed from: k  reason: collision with root package name */
    private e.a.a.e f11963k;

    /* renamed from: c  reason: collision with root package name */
    private float f11956c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11957d = false;

    /* renamed from: e  reason: collision with root package name */
    private long f11958e = 0;

    /* renamed from: f  reason: collision with root package name */
    private float f11959f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    private int f11960g = 0;

    /* renamed from: h  reason: collision with root package name */
    private float f11961h = -2.1474836E9f;

    /* renamed from: j  reason: collision with root package name */
    private float f11962j = 2.1474836E9f;

    /* renamed from: l  reason: collision with root package name */
    protected boolean f11964l = false;

    private void G() {
        if (this.f11963k == null) {
            return;
        }
        float f2 = this.f11959f;
        if (f2 < this.f11961h || f2 > this.f11962j) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f11961h), Float.valueOf(this.f11962j), Float.valueOf(this.f11959f)));
        }
    }

    private float n() {
        e.a.a.e eVar = this.f11963k;
        if (eVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / eVar.h()) / Math.abs(this.f11956c);
    }

    private boolean r() {
        return q() < 0.0f;
    }

    public void A(e.a.a.e eVar) {
        boolean z = this.f11963k == null;
        this.f11963k = eVar;
        if (z) {
            D((int) Math.max(this.f11961h, eVar.o()), (int) Math.min(this.f11962j, eVar.f()));
        } else {
            D((int) eVar.o(), (int) eVar.f());
        }
        float f2 = this.f11959f;
        this.f11959f = 0.0f;
        B((int) f2);
        f();
    }

    public void B(float f2) {
        if (this.f11959f == f2) {
            return;
        }
        this.f11959f = g.c(f2, p(), o());
        this.f11958e = 0L;
        f();
    }

    public void C(float f2) {
        D(this.f11961h, f2);
    }

    public void D(float f2, float f3) {
        if (f2 <= f3) {
            e.a.a.e eVar = this.f11963k;
            float o = eVar == null ? -3.4028235E38f : eVar.o();
            e.a.a.e eVar2 = this.f11963k;
            float f4 = eVar2 == null ? Float.MAX_VALUE : eVar2.f();
            this.f11961h = g.c(f2, o, f4);
            this.f11962j = g.c(f3, o, f4);
            B((int) g.c(this.f11959f, f2, f3));
            return;
        }
        throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f2), Float.valueOf(f3)));
    }

    public void E(int i2) {
        D(i2, (int) this.f11962j);
    }

    public void F(float f2) {
        this.f11956c = f2;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        b();
        v();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j2) {
        u();
        if (this.f11963k == null || !isRunning()) {
            return;
        }
        e.a.a.c.a("LottieValueAnimator#doFrame");
        long j3 = this.f11958e;
        float n = ((float) (j3 != 0 ? j2 - j3 : 0L)) / n();
        float f2 = this.f11959f;
        if (r()) {
            n = -n;
        }
        float f3 = f2 + n;
        this.f11959f = f3;
        boolean z = !g.e(f3, p(), o());
        this.f11959f = g.c(this.f11959f, p(), o());
        this.f11958e = j2;
        f();
        if (z) {
            if (getRepeatCount() != -1 && this.f11960g >= getRepeatCount()) {
                this.f11959f = this.f11956c < 0.0f ? p() : o();
                v();
                c(r());
            } else {
                d();
                this.f11960g++;
                if (getRepeatMode() == 2) {
                    this.f11957d = !this.f11957d;
                    y();
                } else {
                    this.f11959f = r() ? o() : p();
                }
                this.f11958e = j2;
            }
        }
        G();
        e.a.a.c.b("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float p;
        float o;
        float p2;
        if (this.f11963k == null) {
            return 0.0f;
        }
        if (r()) {
            p = o() - this.f11959f;
            o = o();
            p2 = p();
        } else {
            p = this.f11959f - p();
            o = o();
            p2 = p();
        }
        return p / (o - p2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(k());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        e.a.a.e eVar = this.f11963k;
        if (eVar == null) {
            return 0L;
        }
        return eVar.d();
    }

    public void h() {
        this.f11963k = null;
        this.f11961h = -2.1474836E9f;
        this.f11962j = 2.1474836E9f;
    }

    public void i() {
        v();
        c(r());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f11964l;
    }

    public float k() {
        e.a.a.e eVar = this.f11963k;
        if (eVar == null) {
            return 0.0f;
        }
        return (this.f11959f - eVar.o()) / (this.f11963k.f() - this.f11963k.o());
    }

    public float l() {
        return this.f11959f;
    }

    public float o() {
        e.a.a.e eVar = this.f11963k;
        if (eVar == null) {
            return 0.0f;
        }
        float f2 = this.f11962j;
        return f2 == 2.1474836E9f ? eVar.f() : f2;
    }

    public float p() {
        e.a.a.e eVar = this.f11963k;
        if (eVar == null) {
            return 0.0f;
        }
        float f2 = this.f11961h;
        return f2 == -2.1474836E9f ? eVar.o() : f2;
    }

    public float q() {
        return this.f11956c;
    }

    public void s() {
        v();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i2) {
        super.setRepeatMode(i2);
        if (i2 == 2 || !this.f11957d) {
            return;
        }
        this.f11957d = false;
        y();
    }

    public void t() {
        this.f11964l = true;
        e(r());
        B((int) (r() ? o() : p()));
        this.f11958e = 0L;
        this.f11960g = 0;
        u();
    }

    protected void u() {
        if (isRunning()) {
            w(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void v() {
        w(true);
    }

    protected void w(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.f11964l = false;
        }
    }

    public void x() {
        this.f11964l = true;
        u();
        this.f11958e = 0L;
        if (r() && l() == p()) {
            this.f11959f = o();
        } else if (r() || l() != o()) {
        } else {
            this.f11959f = p();
        }
    }

    public void y() {
        F(-q());
    }
}