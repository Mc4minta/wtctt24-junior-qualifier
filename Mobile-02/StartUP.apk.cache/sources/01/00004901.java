package e.i.a;

import android.os.Handler;
import android.view.MotionEvent;

/* compiled from: FlingGestureHandler.java */
/* loaded from: classes2.dex */
public class a extends b<a> {
    private float F;
    private float G;
    private Handler H;
    private int I;
    private long B = 800;
    private long C = 160;
    private int D = 1;
    private int E = 1;
    private final Runnable J = new RunnableC0315a();

    /* compiled from: FlingGestureHandler.java */
    /* renamed from: e.i.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0315a implements Runnable {
        RunnableC0315a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.h();
        }
    }

    private void U(MotionEvent motionEvent) {
        if (Y(motionEvent)) {
            return;
        }
        h();
    }

    private void X(MotionEvent motionEvent) {
        this.F = motionEvent.getRawX();
        this.G = motionEvent.getRawY();
        c();
        this.I = 1;
        Handler handler = this.H;
        if (handler == null) {
            this.H = new Handler();
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.H.postDelayed(this.J, this.B);
    }

    private boolean Y(MotionEvent motionEvent) {
        if (this.I == this.E) {
            if (((this.D & 1) == 0 || motionEvent.getRawX() - this.F <= ((float) this.C)) && (((this.D & 2) == 0 || this.F - motionEvent.getRawX() <= ((float) this.C)) && (((this.D & 4) == 0 || this.G - motionEvent.getRawY() <= ((float) this.C)) && ((this.D & 8) == 0 || motionEvent.getRawY() - this.G <= ((float) this.C))))) {
                return false;
            }
            this.H.removeCallbacksAndMessages(null);
            a();
            g();
            return true;
        }
        return false;
    }

    @Override // e.i.a.b
    protected void B() {
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        int p = p();
        if (p == 0) {
            X(motionEvent);
        }
        if (p == 2) {
            Y(motionEvent);
            if (motionEvent.getPointerCount() > this.I) {
                this.I = motionEvent.getPointerCount();
            }
            if (motionEvent.getActionMasked() == 1) {
                U(motionEvent);
            }
        }
    }

    @Override // e.i.a.b
    protected void D() {
        Handler handler = this.H;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void V(int i2) {
        this.D = i2;
    }

    public void W(int i2) {
        this.E = i2;
    }
}