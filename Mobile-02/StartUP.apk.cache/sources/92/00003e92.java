package com.rd.c.b;

import android.graphics.Canvas;
import android.view.MotionEvent;

/* compiled from: DrawController.java */
/* loaded from: classes2.dex */
public class b {
    private com.rd.b.c.a a;

    /* renamed from: b  reason: collision with root package name */
    private com.rd.c.d.a f10638b;

    /* renamed from: c  reason: collision with root package name */
    private com.rd.c.c.a f10639c;

    /* renamed from: d  reason: collision with root package name */
    private InterfaceC0225b f10640d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DrawController.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.rd.b.d.a.values().length];
            a = iArr;
            try {
                iArr[com.rd.b.d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.rd.b.d.a.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.rd.b.d.a.SCALE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.rd.b.d.a.WORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[com.rd.b.d.a.SLIDE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[com.rd.b.d.a.FILL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[com.rd.b.d.a.THIN_WORM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[com.rd.b.d.a.DROP.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[com.rd.b.d.a.SWAP.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[com.rd.b.d.a.SCALE_DOWN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* compiled from: DrawController.java */
    /* renamed from: com.rd.c.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0225b {
        void a(int i2);
    }

    public b(com.rd.c.c.a aVar) {
        this.f10639c = aVar;
        this.f10638b = new com.rd.c.d.a(aVar);
    }

    private void b(Canvas canvas, int i2, int i3, int i4) {
        boolean z = this.f10639c.z();
        int q = this.f10639c.q();
        int r = this.f10639c.r();
        boolean z2 = true;
        boolean z3 = !z && (i2 == q || i2 == this.f10639c.f());
        if (!z || (i2 != q && i2 != r)) {
            z2 = false;
        }
        boolean z4 = z3 | z2;
        this.f10638b.k(i2, i3, i4);
        if (this.a != null && z4) {
            c(canvas);
        } else {
            this.f10638b.a(canvas, z4);
        }
    }

    private void c(Canvas canvas) {
        switch (a.a[this.f10639c.b().ordinal()]) {
            case 1:
                this.f10638b.a(canvas, true);
                return;
            case 2:
                this.f10638b.b(canvas, this.a);
                return;
            case 3:
                this.f10638b.e(canvas, this.a);
                return;
            case 4:
                this.f10638b.j(canvas, this.a);
                return;
            case 5:
                this.f10638b.g(canvas, this.a);
                return;
            case 6:
                this.f10638b.d(canvas, this.a);
                return;
            case 7:
                this.f10638b.i(canvas, this.a);
                return;
            case 8:
                this.f10638b.c(canvas, this.a);
                return;
            case 9:
                this.f10638b.h(canvas, this.a);
                return;
            case 10:
                this.f10638b.f(canvas, this.a);
                return;
            default:
                return;
        }
    }

    private void d(float f2, float f3) {
        int d2;
        if (this.f10640d == null || (d2 = com.rd.e.a.d(this.f10639c, f2, f3)) < 0) {
            return;
        }
        this.f10640d.a(d2);
    }

    public void a(Canvas canvas) {
        int c2 = this.f10639c.c();
        for (int i2 = 0; i2 < c2; i2++) {
            b(canvas, i2, com.rd.e.a.g(this.f10639c, i2), com.rd.e.a.h(this.f10639c, i2));
        }
    }

    public void e(InterfaceC0225b interfaceC0225b) {
        this.f10640d = interfaceC0225b;
    }

    public void f(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 1) {
            d(motionEvent.getX(), motionEvent.getY());
        }
    }

    public void g(com.rd.b.c.a aVar) {
        this.a = aVar;
    }
}