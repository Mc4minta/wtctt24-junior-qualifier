package e.i.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.reactnativecommunity.webview.RNCWebViewManager;

/* compiled from: PanGestureHandler.java */
/* loaded from: classes2.dex */
public class j extends b<j> {
    private static float B = Float.MAX_VALUE;
    private static float C = Float.MIN_VALUE;
    private static int D = 1;
    private static int E = 10;
    private float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private float K;
    private float L;
    private float M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private int R;
    private int S;
    private float T;
    private float U;
    private float V;
    private float W;
    private float X;
    private float Y;
    private float Z;
    private float a0;
    private VelocityTracker b0;
    private boolean c0;

    public j(Context context) {
        float f2 = C;
        this.F = f2;
        float f3 = B;
        this.G = f3;
        this.H = f2;
        this.I = f2;
        this.J = f3;
        this.K = f3;
        this.L = f2;
        this.M = f2;
        this.N = f3;
        this.O = f3;
        this.P = f3;
        this.Q = f3;
        this.R = D;
        this.S = E;
        int scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.F = scaledTouchSlop * scaledTouchSlop;
    }

    private static void U(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        motionEvent.offsetLocation(rawX, rawY);
        velocityTracker.addMovement(motionEvent);
        motionEvent.offsetLocation(-rawX, -rawY);
    }

    private boolean o0() {
        float f2 = (this.X - this.T) + this.V;
        float f3 = this.G;
        float f4 = B;
        if (f3 == f4 || f2 >= f3) {
            float f5 = this.H;
            float f6 = C;
            if (f5 == f6 || f2 <= f5) {
                float f7 = (this.Y - this.U) + this.W;
                float f8 = this.K;
                if (f8 == f4 || f7 >= f8) {
                    float f9 = this.L;
                    if (f9 == f6 || f7 <= f9) {
                        float f10 = (f2 * f2) + (f7 * f7);
                        float f11 = this.F;
                        if (f11 == f4 || f10 < f11) {
                            float f12 = this.Z;
                            float f13 = this.O;
                            if (f13 == f4 || ((f13 >= 0.0f || f12 > f13) && (f13 < 0.0f || f12 < f13))) {
                                float f14 = this.a0;
                                float f15 = this.P;
                                if (f15 == f4 || ((f15 >= 0.0f || f12 > f15) && (f15 < 0.0f || f12 < f15))) {
                                    float f16 = (f12 * f12) + (f14 * f14);
                                    float f17 = this.Q;
                                    return f17 != f4 && f16 >= f17;
                                }
                                return true;
                            }
                            return true;
                        }
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private boolean p0() {
        float f2 = (this.X - this.T) + this.V;
        float f3 = this.I;
        float f4 = C;
        if (f3 == f4 || f2 >= f3) {
            float f5 = this.J;
            float f6 = B;
            if (f5 == f6 || f2 <= f5) {
                float f7 = (this.Y - this.U) + this.W;
                float f8 = this.M;
                if (f8 == f4 || f7 >= f8) {
                    float f9 = this.N;
                    return f9 != f6 && f7 > f9;
                }
                return true;
            }
            return true;
        }
        return true;
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        int p = p();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 6 && actionMasked != 5) {
            this.X = f.a(motionEvent, this.c0);
            this.Y = f.b(motionEvent, this.c0);
        } else {
            this.V += this.X - this.T;
            this.W += this.Y - this.U;
            this.X = f.a(motionEvent, this.c0);
            float b2 = f.b(motionEvent, this.c0);
            this.Y = b2;
            this.T = this.X;
            this.U = b2;
        }
        if (p == 0 && motionEvent.getPointerCount() >= this.R) {
            this.T = this.X;
            this.U = this.Y;
            this.V = 0.0f;
            this.W = 0.0f;
            VelocityTracker obtain = VelocityTracker.obtain();
            this.b0 = obtain;
            U(obtain, motionEvent);
            c();
        } else {
            VelocityTracker velocityTracker = this.b0;
            if (velocityTracker != null) {
                U(velocityTracker, motionEvent);
                this.b0.computeCurrentVelocity(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
                this.Z = this.b0.getXVelocity();
                this.a0 = this.b0.getYVelocity();
            }
        }
        if (actionMasked == 1) {
            if (p != 4 && p != 2) {
                h();
            } else {
                g();
            }
        } else if (actionMasked == 5 && motionEvent.getPointerCount() > this.S) {
            if (p == 4) {
                d();
            } else {
                h();
            }
        } else if (actionMasked == 6 && p == 4 && motionEvent.getPointerCount() < this.R) {
            h();
        } else if (p == 2) {
            if (p0()) {
                h();
            } else if (o0()) {
                this.T = this.X;
                this.U = this.Y;
                a();
            }
        }
    }

    @Override // e.i.a.b
    protected void D() {
        VelocityTracker velocityTracker = this.b0;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.b0 = null;
        }
    }

    public float V() {
        return (this.X - this.T) + this.V;
    }

    public float W() {
        return (this.Y - this.U) + this.W;
    }

    public float X() {
        return this.Z;
    }

    public float Y() {
        return this.a0;
    }

    public j Z(float f2) {
        this.H = f2;
        return this;
    }

    public j a0(float f2) {
        this.G = f2;
        return this;
    }

    public j b0(float f2) {
        this.L = f2;
        return this;
    }

    public j c0(float f2) {
        this.K = f2;
        return this;
    }

    public j d0(boolean z) {
        this.c0 = z;
        return this;
    }

    public j e0(float f2) {
        this.J = f2;
        return this;
    }

    public j f0(float f2) {
        this.I = f2;
        return this;
    }

    public j g0(float f2) {
        this.N = f2;
        return this;
    }

    public j h0(float f2) {
        this.M = f2;
        return this;
    }

    public j i0(int i2) {
        this.S = i2;
        return this;
    }

    public j j0(float f2) {
        this.F = f2 * f2;
        return this;
    }

    public j k0(int i2) {
        this.R = i2;
        return this;
    }

    public j l0(float f2) {
        this.Q = f2 * f2;
        return this;
    }

    public j m0(float f2) {
        this.O = f2;
        return this;
    }

    public j n0(float f2) {
        this.P = f2;
        return this;
    }
}