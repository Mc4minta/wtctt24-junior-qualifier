package e.i.a;

import android.os.Handler;
import android.view.MotionEvent;

/* compiled from: TapGestureHandler.java */
/* loaded from: classes2.dex */
public class o extends b<o> {
    private static float B = Float.MIN_VALUE;
    private float C;
    private float D;
    private float E;
    private long F;
    private long G;
    private int H;
    private int I;
    private int J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private Handler Q;
    private int R;
    private final Runnable S;

    /* compiled from: TapGestureHandler.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            o.this.h();
        }
    }

    public o() {
        float f2 = B;
        this.C = f2;
        this.D = f2;
        this.E = f2;
        this.F = 500L;
        this.G = 500L;
        this.H = 1;
        this.I = 1;
        this.J = 1;
        this.S = new a();
        L(true);
    }

    private void U() {
        Handler handler = this.Q;
        if (handler == null) {
            this.Q = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        int i2 = this.R + 1;
        this.R = i2;
        if (i2 == this.H && this.J >= this.I) {
            a();
            g();
            return;
        }
        this.Q.postDelayed(this.S, this.G);
    }

    private boolean c0() {
        float f2 = (this.O - this.K) + this.M;
        if (this.C == B || Math.abs(f2) <= this.C) {
            float f3 = (this.P - this.L) + this.N;
            if (this.D == B || Math.abs(f3) <= this.D) {
                float f4 = (f3 * f3) + (f2 * f2);
                float f5 = this.E;
                return f5 != B && f4 > f5;
            }
            return true;
        }
        return true;
    }

    private void d0() {
        Handler handler = this.Q;
        if (handler == null) {
            this.Q = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.Q.postDelayed(this.S, this.F);
    }

    @Override // e.i.a.b
    protected void B() {
        Handler handler = this.Q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        int p = p();
        int actionMasked = motionEvent.getActionMasked();
        if (p == 0) {
            this.M = 0.0f;
            this.N = 0.0f;
            this.K = motionEvent.getRawX();
            this.L = motionEvent.getRawY();
        }
        if (actionMasked != 6 && actionMasked != 5) {
            this.O = f.a(motionEvent, true);
            this.P = f.b(motionEvent, true);
        } else {
            this.M += this.O - this.K;
            this.N += this.P - this.L;
            this.O = f.a(motionEvent, true);
            float b2 = f.b(motionEvent, true);
            this.P = b2;
            this.K = this.O;
            this.L = b2;
        }
        if (this.J < motionEvent.getPointerCount()) {
            this.J = motionEvent.getPointerCount();
        }
        if (c0()) {
            h();
        } else if (p == 0) {
            if (actionMasked == 0) {
                c();
            }
            d0();
        } else if (p == 2) {
            if (actionMasked == 1) {
                U();
            } else if (actionMasked == 0) {
                d0();
            }
        }
    }

    @Override // e.i.a.b
    protected void D() {
        this.R = 0;
        this.J = 0;
        Handler handler = this.Q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public o V(long j2) {
        this.G = j2;
        return this;
    }

    public o W(float f2) {
        this.E = f2 * f2;
        return this;
    }

    public o X(long j2) {
        this.F = j2;
        return this;
    }

    public o Y(float f2) {
        this.C = f2;
        return this;
    }

    public o Z(float f2) {
        this.D = f2;
        return this;
    }

    public o a0(int i2) {
        this.I = i2;
        return this;
    }

    public o b0(int i2) {
        this.H = i2;
        return this;
    }
}