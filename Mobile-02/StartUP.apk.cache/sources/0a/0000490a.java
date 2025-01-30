package e.i.a;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

/* compiled from: LongPressGestureHandler.java */
/* loaded from: classes2.dex */
public class g extends b<g> {
    private static float B = 10.0f;
    private long C = 500;
    private float D;
    private float E;
    private float F;
    private Handler G;

    /* compiled from: LongPressGestureHandler.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a();
        }
    }

    public g(Context context) {
        L(true);
        this.D = B * context.getResources().getDisplayMetrics().density;
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        if (p() == 0) {
            c();
            this.E = motionEvent.getRawX();
            this.F = motionEvent.getRawY();
            Handler handler = new Handler();
            this.G = handler;
            handler.postDelayed(new a(), this.C);
        }
        if (motionEvent.getActionMasked() == 1) {
            Handler handler2 = this.G;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
                this.G = null;
            }
            if (p() == 4) {
                g();
                return;
            } else {
                h();
                return;
            }
        }
        float rawX = motionEvent.getRawX() - this.E;
        float rawY = motionEvent.getRawY() - this.F;
        if ((rawX * rawX) + (rawY * rawY) > this.D) {
            if (p() == 4) {
                d();
            } else {
                h();
            }
        }
    }

    @Override // e.i.a.b
    protected void E(int i2, int i3) {
        Handler handler = this.G;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.G = null;
        }
    }

    public g U(float f2) {
        this.D = f2 * f2;
        return this;
    }

    public void V(long j2) {
        this.C = j2;
    }
}