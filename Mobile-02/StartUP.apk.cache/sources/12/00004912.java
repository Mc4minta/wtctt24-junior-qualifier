package e.i.a;

import android.view.MotionEvent;

/* compiled from: RotationGestureDetector.java */
/* loaded from: classes2.dex */
public class m {
    private long a;

    /* renamed from: b  reason: collision with root package name */
    private long f13500b;

    /* renamed from: c  reason: collision with root package name */
    private double f13501c;

    /* renamed from: d  reason: collision with root package name */
    private double f13502d;

    /* renamed from: e  reason: collision with root package name */
    private float f13503e;

    /* renamed from: f  reason: collision with root package name */
    private float f13504f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f13505g;

    /* renamed from: h  reason: collision with root package name */
    private int[] f13506h = new int[2];

    /* renamed from: i  reason: collision with root package name */
    private a f13507i;

    /* compiled from: RotationGestureDetector.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(m mVar);

        boolean b(m mVar);

        boolean c(m mVar);
    }

    public m(a aVar) {
        this.f13507i = aVar;
    }

    private void a() {
        if (this.f13505g) {
            this.f13505g = false;
            a aVar = this.f13507i;
            if (aVar != null) {
                aVar.a(this);
            }
        }
    }

    private void g(MotionEvent motionEvent) {
        this.f13500b = this.a;
        this.a = motionEvent.getEventTime();
        int findPointerIndex = motionEvent.findPointerIndex(this.f13506h[0]);
        int findPointerIndex2 = motionEvent.findPointerIndex(this.f13506h[1]);
        float x = motionEvent.getX(findPointerIndex);
        float y = motionEvent.getY(findPointerIndex);
        float x2 = motionEvent.getX(findPointerIndex2);
        float y2 = motionEvent.getY(findPointerIndex2);
        float f2 = y2 - y;
        this.f13503e = (x + x2) * 0.5f;
        this.f13504f = (y + y2) * 0.5f;
        double d2 = -Math.atan2(f2, x2 - x);
        if (Double.isNaN(this.f13501c)) {
            this.f13502d = 0.0d;
        } else {
            this.f13502d = this.f13501c - d2;
        }
        this.f13501c = d2;
        double d3 = this.f13502d;
        if (d3 > 3.141592653589793d) {
            this.f13502d = d3 - 3.141592653589793d;
        } else if (d3 < -3.141592653589793d) {
            this.f13502d = d3 + 3.141592653589793d;
        }
        double d4 = this.f13502d;
        if (d4 > 1.5707963267948966d) {
            this.f13502d = d4 - 3.141592653589793d;
        } else if (d4 < -1.5707963267948966d) {
            this.f13502d = d4 + 3.141592653589793d;
        }
    }

    public float b() {
        return this.f13503e;
    }

    public float c() {
        return this.f13504f;
    }

    public double d() {
        return this.f13502d;
    }

    public long e() {
        return this.a - this.f13500b;
    }

    public boolean f(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f13505g = false;
            this.f13506h[0] = motionEvent.getPointerId(motionEvent.getActionIndex());
            this.f13506h[1] = -1;
        } else if (actionMasked == 1) {
            a();
        } else if (actionMasked != 2) {
            if (actionMasked != 5) {
                if (actionMasked == 6 && this.f13505g) {
                    int pointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    int[] iArr = this.f13506h;
                    if (pointerId == iArr[0] || pointerId == iArr[1]) {
                        a();
                    }
                }
            } else if (!this.f13505g) {
                this.f13506h[1] = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f13505g = true;
                this.f13500b = motionEvent.getEventTime();
                this.f13501c = Double.NaN;
                g(motionEvent);
                a aVar = this.f13507i;
                if (aVar != null) {
                    aVar.c(this);
                }
            }
        } else if (this.f13505g) {
            g(motionEvent);
            a aVar2 = this.f13507i;
            if (aVar2 != null) {
                aVar2.b(this);
            }
        }
        return true;
    }
}