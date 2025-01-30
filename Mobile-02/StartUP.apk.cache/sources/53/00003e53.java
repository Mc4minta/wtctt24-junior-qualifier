package com.lwansbrough.RCTCamera;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.AsyncTask;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TextureView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.zxing.h;
import com.google.zxing.i;
import com.google.zxing.k;
import com.google.zxing.m;
import com.google.zxing.q.j;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RCTCameraViewFinder.java */
/* loaded from: classes2.dex */
public class d extends TextureView implements TextureView.SurfaceTextureListener, Camera.PreviewCallback {
    public static volatile boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f10497b;

    /* renamed from: c  reason: collision with root package name */
    private int f10498c;

    /* renamed from: d  reason: collision with root package name */
    private SurfaceTexture f10499d;

    /* renamed from: e  reason: collision with root package name */
    private int f10500e;

    /* renamed from: f  reason: collision with root package name */
    private int f10501f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10502g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10503h;

    /* renamed from: j  reason: collision with root package name */
    private Camera f10504j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10505k;

    /* renamed from: l  reason: collision with root package name */
    private float f10506l;
    private final h m;

    /* compiled from: RCTCameraViewFinder.java */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ int a;

        a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.u();
            d.this.f10497b = this.a;
            d.this.s();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RCTCameraViewFinder.java */
    /* loaded from: classes2.dex */
    public class b implements Camera.AutoFocusCallback {
        b() {
        }

        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
            if (z) {
                camera.cancelAutoFocus();
            }
        }
    }

    /* compiled from: RCTCameraViewFinder.java */
    /* loaded from: classes2.dex */
    private class c extends AsyncTask<Void, Void, Void> {
        private byte[] a;

        /* renamed from: b  reason: collision with root package name */
        private final Camera f10508b;

        c(Camera camera, byte[] bArr) {
            this.f10508b = camera;
            this.a = bArr;
        }

        private k b(int i2, int i3, boolean z) {
            com.google.zxing.c cVar;
            try {
                i iVar = new i(this.a, i2, i3, 0, 0, i2, i3, false);
                if (z) {
                    cVar = new com.google.zxing.c(new j(iVar.e()));
                } else {
                    cVar = new com.google.zxing.c(new j(iVar));
                }
                k d2 = d.this.m.d(cVar);
                d.this.m.reset();
                return d2;
            } catch (Throwable unused) {
                d.this.m.reset();
                return null;
            }
        }

        private k c() {
            Camera.Size previewSize = this.f10508b.getParameters().getPreviewSize();
            int i2 = previewSize.width;
            int i3 = previewSize.height;
            k b2 = b(i2, i3, false);
            if (b2 != null) {
                return b2;
            }
            k b3 = b(i2, i3, true);
            if (b3 != null) {
                return b3;
            }
            d(i2, i3);
            int i4 = previewSize.height;
            int i5 = previewSize.width;
            k b4 = b(i4, i5, false);
            return b4 != null ? b4 : b(i4, i5, true);
        }

        private void d(int i2, int i3) {
            byte[] bArr = new byte[this.a.length];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i3; i5++) {
                    int i6 = (i4 * i3) + i5;
                    int i7 = (((i5 * i2) + i2) - i4) - 1;
                    if (i6 >= 0) {
                        byte[] bArr2 = this.a;
                        if (i6 < bArr2.length && i7 >= 0 && i7 < bArr2.length) {
                            bArr[i7] = bArr2[i6];
                        }
                    }
                }
            }
            this.a = bArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Void doInBackground(Void... voidArr) {
            k c2;
            if (isCancelled()) {
                return null;
            }
            try {
                c2 = c();
            } catch (Throwable unused) {
            }
            if (c2 != null) {
                ReactApplicationContext reactContextSingleton = RCTCameraModule.getReactContextSingleton();
                WritableMap createMap = Arguments.createMap();
                WritableArray createArray = Arguments.createArray();
                m[] e2 = c2.e();
                if (e2 != null) {
                    for (m mVar : e2) {
                        WritableMap createMap2 = Arguments.createMap();
                        createMap2.putString("x", String.valueOf(mVar.c()));
                        createMap2.putString("y", String.valueOf(mVar.d()));
                        createArray.pushMap(createMap2);
                    }
                }
                createMap.putArray("bounds", createArray);
                createMap.putString("data", c2.f());
                createMap.putString("type", c2.b().toString());
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContextSingleton.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CameraBarCodeReadAndroid", createMap);
                d.this.m.reset();
                d.a = false;
                return null;
            }
            throw new Exception();
        }
    }

    public d(Context context, int i2) {
        super(context);
        this.f10505k = false;
        this.m = new h();
        setSurfaceTextureListener(this);
        this.f10497b = i2;
        i(com.lwansbrough.RCTCamera.a.h().e());
    }

    private Activity c() {
        for (Context context = getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
        }
        return null;
    }

    private float e(MotionEvent motionEvent) {
        float x = motionEvent.getX(0) - motionEvent.getX(1);
        float y = motionEvent.getY(0) - motionEvent.getY(1);
        return (float) Math.sqrt((x * x) + (y * y));
    }

    private void h(MotionEvent motionEvent, Camera.Parameters parameters) {
        int maxZoom = parameters.getMaxZoom();
        int zoom = parameters.getZoom();
        float e2 = e(motionEvent);
        float f2 = this.f10506l;
        if (e2 > f2) {
            if (zoom < maxZoom) {
                zoom++;
            }
        } else if (e2 < f2 && zoom > 0) {
            zoom--;
        }
        this.f10506l = e2;
        parameters.setZoom(zoom);
        try {
            this.f10504j.setParameters(parameters);
        } catch (RuntimeException e3) {
            Log.e("RCTCameraViewFinder", "setParameters failed", e3);
        }
    }

    private void i(List<String> list) {
        EnumMap enumMap = new EnumMap(com.google.zxing.d.class);
        EnumSet noneOf = EnumSet.noneOf(com.google.zxing.a.class);
        if (list != null) {
            for (String str : list) {
                com.google.zxing.a j2 = j(str);
                if (j2 != null) {
                    noneOf.add(j2);
                }
            }
        }
        enumMap.put((EnumMap) com.google.zxing.d.POSSIBLE_FORMATS, (com.google.zxing.d) noneOf);
        this.m.e(enumMap);
    }

    private com.google.zxing.a j(String str) {
        if ("aztec".equals(str)) {
            return com.google.zxing.a.AZTEC;
        }
        if ("ean13".equals(str)) {
            return com.google.zxing.a.EAN_13;
        }
        if ("ean8".equals(str)) {
            return com.google.zxing.a.EAN_8;
        }
        if ("qr".equals(str)) {
            return com.google.zxing.a.QR_CODE;
        }
        if ("pdf417".equals(str)) {
            return com.google.zxing.a.PDF_417;
        }
        if ("upce".equals(str)) {
            return com.google.zxing.a.UPC_E;
        }
        if ("datamatrix".equals(str)) {
            return com.google.zxing.a.DATA_MATRIX;
        }
        if ("code39".equals(str)) {
            return com.google.zxing.a.CODE_39;
        }
        if ("code93".equals(str)) {
            return com.google.zxing.a.CODE_93;
        }
        if ("interleaved2of5".equals(str)) {
            return com.google.zxing.a.ITF;
        }
        if ("codabar".equals(str)) {
            return com.google.zxing.a.CODABAR;
        }
        if ("code128".equals(str)) {
            return com.google.zxing.a.CODE_128;
        }
        if ("maxicode".equals(str)) {
            return com.google.zxing.a.MAXICODE;
        }
        if ("rss14".equals(str)) {
            return com.google.zxing.a.RSS_14;
        }
        if ("rssexpanded".equals(str)) {
            return com.google.zxing.a.RSS_EXPANDED;
        }
        if ("upca".equals(str)) {
            return com.google.zxing.a.UPC_A;
        }
        if ("upceanextension".equals(str)) {
            return com.google.zxing.a.UPC_EAN_EXTENSION;
        }
        Log.v("RCTCamera", "Unsupported code.. [" + str + "]");
        return null;
    }

    private synchronized void r() {
        List<Camera.Size> o;
        Activity c2;
        if (!this.f10502g) {
            boolean z = true;
            this.f10502g = true;
            try {
                try {
                    Camera a2 = com.lwansbrough.RCTCamera.a.h().a(this.f10497b);
                    this.f10504j = a2;
                    Camera.Parameters parameters = a2.getParameters();
                    int i2 = this.f10498c;
                    boolean z2 = i2 == 0;
                    if (i2 != 1) {
                        z = false;
                    }
                    if (!z2 && !z) {
                        throw new RuntimeException("Unsupported capture mode:" + this.f10498c);
                    }
                    List<String> supportedFocusModes = parameters.getSupportedFocusModes();
                    if (z2 && supportedFocusModes.contains("continuous-picture")) {
                        parameters.setFocusMode("continuous-picture");
                    } else if (z && supportedFocusModes.contains("continuous-video")) {
                        parameters.setFocusMode("continuous-video");
                    } else if (supportedFocusModes.contains("auto")) {
                        parameters.setFocusMode("auto");
                    }
                    if (z2) {
                        o = parameters.getSupportedPictureSizes();
                    } else if (z) {
                        o = com.lwansbrough.RCTCamera.a.h().o(this.f10504j);
                    } else {
                        throw new RuntimeException("Unsupported capture mode:" + this.f10498c);
                    }
                    Camera.Size f2 = com.lwansbrough.RCTCamera.a.h().f(o, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
                    parameters.setPictureSize(f2.width, f2.height);
                    try {
                        this.f10504j.setParameters(parameters);
                    } catch (RuntimeException e2) {
                        Log.e("RCTCameraViewFinder", "setParameters failed", e2);
                    }
                    this.f10504j.setPreviewTexture(this.f10499d);
                    this.f10504j.startPreview();
                    if (this.f10505k && (c2 = c()) != null) {
                        c2.getWindow().setBackgroundDrawable(null);
                    }
                    this.f10504j.setPreviewCallback(this);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    t();
                }
            } catch (NullPointerException e4) {
                e4.printStackTrace();
            }
            this.f10502g = false;
        }
    }

    private synchronized void t() {
        if (!this.f10503h) {
            this.f10503h = true;
            try {
                Camera camera = this.f10504j;
                if (camera != null) {
                    camera.stopPreview();
                    this.f10504j.setPreviewCallback(null);
                    com.lwansbrough.RCTCamera.a.h().q(this.f10497b);
                    this.f10504j = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f10503h = false;
        }
    }

    public int d() {
        return this.f10497b;
    }

    public double f() {
        return com.lwansbrough.RCTCamera.a.h().m(this.f10497b) / com.lwansbrough.RCTCamera.a.h().j(this.f10497b);
    }

    public void g(MotionEvent motionEvent, Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (supportedFocusModes == null || !supportedFocusModes.contains("auto") || parameters.getMaxNumFocusAreas() == 0) {
            return;
        }
        this.f10504j.cancelAutoFocus();
        try {
            Camera.Area a2 = com.lwansbrough.RCTCamera.b.a(motionEvent, this.f10500e, this.f10501f);
            parameters.setFocusMode("auto");
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            parameters.setFocusAreas(arrayList);
            if (parameters.getMaxNumMeteringAreas() > 0) {
                parameters.setMeteringAreas(arrayList);
            }
            try {
                this.f10504j.setParameters(parameters);
            } catch (RuntimeException e2) {
                Log.e("RCTCameraViewFinder", "setParameters failed", e2);
            }
            try {
                this.f10504j.autoFocus(new b());
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (RuntimeException e4) {
            e4.printStackTrace();
        }
    }

    public void k(int i2) {
        if (this.f10497b == i2) {
            return;
        }
        new Thread(new a(i2)).start();
    }

    public void l(int i2) {
        com.lwansbrough.RCTCamera.a.h().v(this.f10497b, i2);
        this.f10498c = i2;
    }

    public void m(String str) {
        com.lwansbrough.RCTCamera.a.h().w(this.f10497b, str);
    }

    public void n(boolean z) {
        this.f10505k = z;
    }

    public void o(int i2) {
        com.lwansbrough.RCTCamera.a.h().y(this.f10497b, i2);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (!com.lwansbrough.RCTCamera.a.h().p() || a) {
            return;
        }
        a = true;
        new c(camera, bArr).execute(new Void[0]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f10499d = surfaceTexture;
        this.f10500e = i2;
        this.f10501f = i3;
        r();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f10499d = null;
        this.f10500e = 0;
        this.f10501f = 0;
        t();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.f10500e = i2;
        this.f10501f = i3;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Camera camera = this.f10504j;
        if (camera == null) {
            return false;
        }
        Camera.Parameters parameters = camera.getParameters();
        int action = motionEvent.getAction();
        if (motionEvent.getPointerCount() > 1) {
            if (action == 5) {
                this.f10506l = e(motionEvent);
            } else if (action == 2 && parameters.isZoomSupported()) {
                this.f10504j.cancelAutoFocus();
                h(motionEvent, parameters);
            }
        } else if (action == 1) {
            g(motionEvent, parameters);
        }
        return true;
    }

    public void p(int i2) {
        com.lwansbrough.RCTCamera.a.h().B(this.f10497b, i2);
    }

    public void q(int i2) {
        com.lwansbrough.RCTCamera.a.h().C(this.f10497b, i2);
    }

    public void s() {
        if (this.f10499d != null) {
            r();
        }
    }

    public void u() {
        if (this.f10504j != null) {
            t();
        }
    }
}