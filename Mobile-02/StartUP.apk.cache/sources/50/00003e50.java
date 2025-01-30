package com.lwansbrough.RCTCamera;

import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.Camera;
import android.view.MotionEvent;
import com.reactnativecommunity.webview.RNCWebViewManager;

/* compiled from: RCTCameraUtils.java */
/* loaded from: classes2.dex */
public class b {
    /* JADX INFO: Access modifiers changed from: protected */
    public static Camera.Area a(MotionEvent motionEvent, int i2, int i3) {
        int findPointerIndex = motionEvent.findPointerIndex(motionEvent.getPointerId(0));
        float x = motionEvent.getX(findPointerIndex);
        float y = motionEvent.getY(findPointerIndex);
        RectF rectF = new RectF(x - 100.0f, y - 100.0f, x + 100.0f, y + 100.0f);
        float f2 = i2;
        float f3 = i3;
        if (rectF.intersect(new RectF(0.0f, 0.0f, f2, f3))) {
            RectF rectF2 = new RectF(((rectF.left / f2) * 2000.0f) - 1000.0f, ((rectF.top / f3) * 2000.0f) - 1000.0f, ((rectF.right / f2) * 2000.0f) - 1000.0f, ((rectF.bottom / f3) * 2000.0f) - 1000.0f);
            Rect rect = new Rect();
            rectF2.round(rect);
            return new Camera.Area(rect, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
        }
        throw new RuntimeException("MotionEvent rect does not intersect with SurfaceTexture rect; unable to compute focus area");
    }
}