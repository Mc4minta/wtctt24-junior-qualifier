package e.i.a;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: NativeViewGestureHandler.java */
/* loaded from: classes2.dex */
public class h extends b<h> {
    private boolean B;
    private boolean C;

    public h() {
        L(true);
    }

    private static boolean W(View view, MotionEvent motionEvent) {
        return (view instanceof ViewGroup) && ((ViewGroup) view).onInterceptTouchEvent(motionEvent);
    }

    @Override // e.i.a.b
    protected void B() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        obtain.setAction(3);
        r().onTouchEvent(obtain);
    }

    @Override // e.i.a.b
    protected void C(MotionEvent motionEvent) {
        View r = r();
        int p = p();
        if (motionEvent.getActionMasked() == 1) {
            r.onTouchEvent(motionEvent);
            if ((p == 0 || p == 2) && r.isPressed()) {
                a();
            }
            g();
        } else if (p != 0 && p != 2) {
            if (p == 4) {
                r.onTouchEvent(motionEvent);
            }
        } else if (this.B) {
            W(r, motionEvent);
            r.onTouchEvent(motionEvent);
            a();
        } else if (W(r, motionEvent)) {
            r.onTouchEvent(motionEvent);
            a();
        } else if (p != 2) {
            c();
        }
    }

    @Override // e.i.a.b
    public boolean N(b bVar) {
        return !this.C;
    }

    @Override // e.i.a.b
    public boolean O(b bVar) {
        if (bVar instanceof h) {
            h hVar = (h) bVar;
            if (hVar.p() == 4 && hVar.C) {
                return false;
            }
        }
        boolean z = !this.C;
        int p = p();
        return !(p == 4 && bVar.p() == 4 && z) && p == 4 && z;
    }

    @Override // e.i.a.b
    public boolean P(b bVar) {
        return super.P(bVar);
    }

    public h U(boolean z) {
        this.C = z;
        return this;
    }

    public h V(boolean z) {
        this.B = z;
        return this;
    }
}