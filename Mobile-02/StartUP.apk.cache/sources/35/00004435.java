package e.a.a.a0;

/* compiled from: ScaleXY.java */
/* loaded from: classes.dex */
public class d {
    private float a;

    /* renamed from: b  reason: collision with root package name */
    private float f11492b;

    public d(float f2, float f3) {
        this.a = f2;
        this.f11492b = f3;
    }

    public boolean a(float f2, float f3) {
        return this.a == f2 && this.f11492b == f3;
    }

    public float b() {
        return this.a;
    }

    public float c() {
        return this.f11492b;
    }

    public void d(float f2, float f3) {
        this.a = f2;
        this.f11492b = f3;
    }

    public String toString() {
        return b() + "x" + c();
    }

    public d() {
        this(1.0f, 1.0f);
    }
}