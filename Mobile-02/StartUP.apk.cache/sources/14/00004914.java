package e.i.a;

import android.view.MotionEvent;
import e.i.a.m;

/* compiled from: RotationGestureHandler.java */
/* loaded from: classes2.dex */
public class n extends b<n> {
    private m B;
    private double C;
    private double D;
    private m.a E = new a();

    /* compiled from: RotationGestureHandler.java */
    /* loaded from: classes2.dex */
    class a implements m.a {
        a() {
        }

        @Override // e.i.a.m.a
        public void a(m mVar) {
            n.this.g();
        }

        @Override // e.i.a.m.a
        public boolean b(m mVar) {
            double d2 = n.this.C;
            n.this.C += mVar.d();
            long e2 = mVar.e();
            if (e2 > 0) {
                n nVar = n.this;
                nVar.D = (nVar.C - d2) / e2;
            }
            if (Math.abs(n.this.C) < 0.08726646259971647d || n.this.p() != 2) {
                return true;
            }
            n.this.a();
            return true;
        }

        @Override // e.i.a.m.a
        public boolean c(m mVar) {
            return true;
        }
    }

    public n() {
        L(false);
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        int p = p();
        if (p == 0) {
            this.D = 0.0d;
            this.C = 0.0d;
            this.B = new m(this.E);
            c();
        }
        m mVar = this.B;
        if (mVar != null) {
            mVar.f(motionEvent);
        }
        if (motionEvent.getActionMasked() == 1) {
            if (p == 4) {
                g();
            } else {
                h();
            }
        }
    }

    @Override // e.i.a.b
    protected void D() {
        this.B = null;
        this.D = 0.0d;
        this.C = 0.0d;
    }

    public float X() {
        m mVar = this.B;
        if (mVar == null) {
            return Float.NaN;
        }
        return mVar.b();
    }

    public float Y() {
        m mVar = this.B;
        if (mVar == null) {
            return Float.NaN;
        }
        return mVar.c();
    }

    public double Z() {
        return this.C;
    }

    public double a0() {
        return this.D;
    }
}