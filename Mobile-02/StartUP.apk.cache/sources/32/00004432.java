package e.a.a.a0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import e.a.a.e;

/* compiled from: Keyframe.java */
/* loaded from: classes.dex */
public class a<T> {
    private final e a;

    /* renamed from: b  reason: collision with root package name */
    public final T f11473b;

    /* renamed from: c  reason: collision with root package name */
    public T f11474c;

    /* renamed from: d  reason: collision with root package name */
    public final Interpolator f11475d;

    /* renamed from: e  reason: collision with root package name */
    public final float f11476e;

    /* renamed from: f  reason: collision with root package name */
    public Float f11477f;

    /* renamed from: g  reason: collision with root package name */
    private float f11478g;

    /* renamed from: h  reason: collision with root package name */
    private float f11479h;

    /* renamed from: i  reason: collision with root package name */
    private int f11480i;

    /* renamed from: j  reason: collision with root package name */
    private int f11481j;

    /* renamed from: k  reason: collision with root package name */
    private float f11482k;

    /* renamed from: l  reason: collision with root package name */
    private float f11483l;
    public PointF m;
    public PointF n;

    public a(e eVar, T t, T t2, Interpolator interpolator, float f2, Float f3) {
        this.f11478g = -3987645.8f;
        this.f11479h = -3987645.8f;
        this.f11480i = 784923401;
        this.f11481j = 784923401;
        this.f11482k = Float.MIN_VALUE;
        this.f11483l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = eVar;
        this.f11473b = t;
        this.f11474c = t2;
        this.f11475d = interpolator;
        this.f11476e = f2;
        this.f11477f = f3;
    }

    public boolean a(float f2) {
        return f2 >= e() && f2 < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.f11483l == Float.MIN_VALUE) {
            if (this.f11477f == null) {
                this.f11483l = 1.0f;
            } else {
                this.f11483l = e() + ((this.f11477f.floatValue() - this.f11476e) / this.a.e());
            }
        }
        return this.f11483l;
    }

    public float c() {
        if (this.f11479h == -3987645.8f) {
            this.f11479h = ((Float) this.f11474c).floatValue();
        }
        return this.f11479h;
    }

    public int d() {
        if (this.f11481j == 784923401) {
            this.f11481j = ((Integer) this.f11474c).intValue();
        }
        return this.f11481j;
    }

    public float e() {
        e eVar = this.a;
        if (eVar == null) {
            return 0.0f;
        }
        if (this.f11482k == Float.MIN_VALUE) {
            this.f11482k = (this.f11476e - eVar.o()) / this.a.e();
        }
        return this.f11482k;
    }

    public float f() {
        if (this.f11478g == -3987645.8f) {
            this.f11478g = ((Float) this.f11473b).floatValue();
        }
        return this.f11478g;
    }

    public int g() {
        if (this.f11480i == 784923401) {
            this.f11480i = ((Integer) this.f11473b).intValue();
        }
        return this.f11480i;
    }

    public boolean h() {
        return this.f11475d == null;
    }

    public String toString() {
        return "Keyframe{startValue=" + this.f11473b + ", endValue=" + this.f11474c + ", startFrame=" + this.f11476e + ", endFrame=" + this.f11477f + ", interpolator=" + this.f11475d + '}';
    }

    public a(T t) {
        this.f11478g = -3987645.8f;
        this.f11479h = -3987645.8f;
        this.f11480i = 784923401;
        this.f11481j = 784923401;
        this.f11482k = Float.MIN_VALUE;
        this.f11483l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = null;
        this.f11473b = t;
        this.f11474c = t;
        this.f11475d = null;
        this.f11476e = Float.MIN_VALUE;
        this.f11477f = Float.valueOf(Float.MAX_VALUE);
    }
}