package e.i.a;

import android.view.MotionEvent;

/* compiled from: GestureUtils.java */
/* loaded from: classes2.dex */
public class f {
    public static float a(MotionEvent motionEvent, boolean z) {
        float rawX = motionEvent.getRawX() - motionEvent.getX();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f2 = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i2 = 0;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != actionIndex) {
                    f2 += motionEvent.getX(i3) + rawX;
                    i2++;
                }
            }
            return f2 / i2;
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getX(pointerCount2) + rawX;
    }

    public static float b(MotionEvent motionEvent, boolean z) {
        float rawY = motionEvent.getRawY() - motionEvent.getY();
        int actionIndex = motionEvent.getActionMasked() == 6 ? motionEvent.getActionIndex() : -1;
        if (z) {
            float f2 = 0.0f;
            int pointerCount = motionEvent.getPointerCount();
            int i2 = 0;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (i3 != actionIndex) {
                    f2 += motionEvent.getY(i3) + rawY;
                    i2++;
                }
            }
            return f2 / i2;
        }
        int pointerCount2 = motionEvent.getPointerCount() - 1;
        if (pointerCount2 == actionIndex) {
            pointerCount2--;
        }
        return motionEvent.getY(pointerCount2) + rawY;
    }
}