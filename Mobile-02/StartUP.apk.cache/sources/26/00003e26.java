package com.journeyapps.barcodescanner.q;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* compiled from: CameraSurface.java */
/* loaded from: classes2.dex */
public class e {
    private SurfaceHolder a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f10440b;

    public e(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != null) {
            this.a = surfaceHolder;
            return;
        }
        throw new IllegalArgumentException("surfaceHolder may not be null");
    }

    public void a(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.f10440b);
        }
    }

    public e(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.f10440b = surfaceTexture;
            return;
        }
        throw new IllegalArgumentException("surfaceTexture may not be null");
    }
}