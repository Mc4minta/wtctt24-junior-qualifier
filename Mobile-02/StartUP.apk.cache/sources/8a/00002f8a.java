package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.uimanager.h;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.t0;
import com.facebook.react.uimanager.y;

/* compiled from: ARTSurfaceViewShadowNode.java */
/* loaded from: classes2.dex */
public class d extends h implements TextureView.SurfaceTextureListener, LifecycleEventListener {
    private Surface E;
    private Integer F;

    private void o1(boolean z) {
        Surface surface = this.E;
        if (surface != null && surface.isValid()) {
            try {
                Canvas lockCanvas = this.E.lockCanvas(null);
                lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                Integer num = this.F;
                if (num != null) {
                    lockCanvas.drawColor(num.intValue());
                }
                Paint paint = new Paint();
                for (int i2 = 0; i2 < b(); i2++) {
                    f fVar = (f) a(i2);
                    fVar.n1(lockCanvas, paint, 1.0f);
                    if (z) {
                        fVar.w0();
                    } else {
                        fVar.d();
                    }
                }
                Surface surface2 = this.E;
                if (surface2 == null) {
                    return;
                }
                surface2.unlockCanvasAndPost(lockCanvas);
                return;
            } catch (IllegalArgumentException | IllegalStateException e2) {
                e.f.d.d.a.i("ReactNative", e2.getClass().getSimpleName() + " in Surface.unlockCanvasAndPost");
                return;
            }
        }
        p1(this);
    }

    private void p1(y yVar) {
        for (int i2 = 0; i2 < yVar.b(); i2++) {
            y a = yVar.a(i2);
            a.d();
            p1(a);
        }
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void dispose() {
        super.dispose();
        if (Build.VERSION.SDK_INT > 24) {
            F().removeLifecycleEventListener(this);
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        o1(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.E = new Surface(surfaceTexture);
        o1(false);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.E.release();
        this.E = null;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void q1(c cVar) {
        SurfaceTexture surfaceTexture = cVar.getSurfaceTexture();
        cVar.setSurfaceTextureListener(this);
        if (surfaceTexture == null || this.E != null) {
            return;
        }
        this.E = new Surface(surfaceTexture);
        o1(true);
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        this.F = num;
        w0();
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public boolean t() {
        return false;
    }

    @Override // com.facebook.react.uimanager.z
    public boolean t0() {
        return true;
    }

    @Override // com.facebook.react.uimanager.z
    public void y0(t0 t0Var) {
        super.y0(t0Var);
        o1(false);
        t0Var.R(q(), this);
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void z(i0 i0Var) {
        super.z(i0Var);
        if (Build.VERSION.SDK_INT > 24) {
            i0Var.addLifecycleEventListener(this);
        }
    }
}