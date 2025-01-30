package e.i.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;

/* compiled from: PinchGestureHandler.java */
/* loaded from: classes2.dex */
public class k extends b<k> {
    private ScaleGestureDetector B;
    private double C;
    private double D;
    private float E;
    private float F;
    private ScaleGestureDetector.OnScaleGestureListener G = new a();

    /* compiled from: PinchGestureHandler.java */
    /* loaded from: classes2.dex */
    class a implements ScaleGestureDetector.OnScaleGestureListener {
        a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            double d2 = k.this.C;
            k.this.C *= scaleGestureDetector.getScaleFactor();
            long timeDelta = scaleGestureDetector.getTimeDelta();
            if (timeDelta > 0) {
                k kVar = k.this;
                kVar.D = (kVar.C - d2) / timeDelta;
            }
            if (Math.abs(k.this.E - scaleGestureDetector.getCurrentSpan()) < k.this.F || k.this.p() != 2) {
                return true;
            }
            k.this.a();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            k.this.E = scaleGestureDetector.getCurrentSpan();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public k() {
        L(false);
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        if (p() == 0) {
            Context context = r().getContext();
            this.D = 0.0d;
            this.C = 1.0d;
            this.B = new ScaleGestureDetector(context, this.G);
            this.F = ViewConfiguration.get(context).getScaledTouchSlop();
            c();
        }
        ScaleGestureDetector scaleGestureDetector = this.B;
        if (scaleGestureDetector != null) {
            scaleGestureDetector.onTouchEvent(motionEvent);
        }
        int pointerCount = motionEvent.getPointerCount();
        if (motionEvent.getActionMasked() == 6) {
            pointerCount--;
        }
        if (p() == 4 && pointerCount < 2) {
            g();
        } else if (motionEvent.getActionMasked() == 1) {
            h();
        }
    }

    @Override // e.i.a.b
    protected void D() {
        this.B = null;
        this.D = 0.0d;
        this.C = 1.0d;
    }

    public float a0() {
        ScaleGestureDetector scaleGestureDetector = this.B;
        if (scaleGestureDetector == null) {
            return Float.NaN;
        }
        return scaleGestureDetector.getFocusX();
    }

    public float b0() {
        ScaleGestureDetector scaleGestureDetector = this.B;
        if (scaleGestureDetector == null) {
            return Float.NaN;
        }
        return scaleGestureDetector.getFocusY();
    }

    public double c0() {
        return this.C;
    }

    public double d0() {
        return this.D;
    }
}