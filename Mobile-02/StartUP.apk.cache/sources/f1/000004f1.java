package c.f.a.a;

import androidx.constraintlayout.motion.widget.s;

/* compiled from: VelocityMatrix.java */
/* loaded from: classes.dex */
public class h {
    float a;

    /* renamed from: b  reason: collision with root package name */
    float f2703b;

    /* renamed from: c  reason: collision with root package name */
    float f2704c;

    /* renamed from: d  reason: collision with root package name */
    float f2705d;

    /* renamed from: e  reason: collision with root package name */
    float f2706e;

    /* renamed from: f  reason: collision with root package name */
    float f2707f;

    public void a(float f2, float f3, int i2, int i3, float[] fArr) {
        float f4;
        float f5 = fArr[0];
        float f6 = fArr[1];
        float f7 = (f3 - 0.5f) * 2.0f;
        float f8 = f5 + this.f2704c;
        float f9 = f6 + this.f2705d;
        float f10 = f8 + (this.a * (f2 - 0.5f) * 2.0f);
        float f11 = f9 + (this.f2703b * f7);
        float radians = (float) Math.toRadians(this.f2706e);
        double radians2 = (float) Math.toRadians(this.f2707f);
        double d2 = i3 * f7;
        fArr[0] = f10 + (((float) ((((-i2) * f4) * Math.sin(radians2)) - (Math.cos(radians2) * d2))) * radians);
        fArr[1] = f11 + (radians * ((float) (((i2 * f4) * Math.cos(radians2)) - (d2 * Math.sin(radians2)))));
    }

    public void b() {
        this.f2706e = 0.0f;
        this.f2705d = 0.0f;
        this.f2704c = 0.0f;
        this.f2703b = 0.0f;
        this.a = 0.0f;
    }

    public void c(androidx.constraintlayout.motion.widget.g gVar, float f2) {
        if (gVar != null) {
            this.f2706e = gVar.b(f2);
        }
    }

    public void d(s sVar, float f2) {
        if (sVar != null) {
            this.f2706e = sVar.b(f2);
            this.f2707f = sVar.a(f2);
        }
    }

    public void e(androidx.constraintlayout.motion.widget.g gVar, androidx.constraintlayout.motion.widget.g gVar2, float f2) {
        if (gVar == null && gVar2 == null) {
            return;
        }
        if (gVar == null) {
            this.a = gVar.b(f2);
        }
        if (gVar2 == null) {
            this.f2703b = gVar2.b(f2);
        }
    }

    public void f(s sVar, s sVar2, float f2) {
        if (sVar != null) {
            this.a = sVar.b(f2);
        }
        if (sVar2 != null) {
            this.f2703b = sVar2.b(f2);
        }
    }

    public void g(androidx.constraintlayout.motion.widget.g gVar, androidx.constraintlayout.motion.widget.g gVar2, float f2) {
        if (gVar != null) {
            this.f2704c = gVar.b(f2);
        }
        if (gVar2 != null) {
            this.f2705d = gVar2.b(f2);
        }
    }

    public void h(s sVar, s sVar2, float f2) {
        if (sVar != null) {
            this.f2704c = sVar.b(f2);
        }
        if (sVar2 != null) {
            this.f2705d = sVar2.b(f2);
        }
    }
}