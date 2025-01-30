package org.reactnative.camera;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.media.CamcorderProfile;
import android.os.AsyncTask;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.i0;
import com.google.zxing.h;
import com.google.zxing.k;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.b.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.apache.http.cookie.ClientCookie;
import org.reactnative.camera.g.i;
import org.reactnative.camera.g.j;

/* compiled from: RNCameraView.java */
/* loaded from: classes3.dex */
public class d extends e.g.a.b.e implements LifecycleEventListener, org.reactnative.camera.g.b, org.reactnative.camera.g.f, org.reactnative.camera.g.d, j, org.reactnative.camera.g.g {
    public volatile boolean A;
    public volatile boolean B;
    public volatile boolean C;
    public volatile boolean D;
    private h E;
    private org.reactnative.facedetector.b F;
    private k.b.a.b G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private int S;
    private int T;
    private boolean U;
    private float V;
    private float W;
    private float a0;
    private float b0;
    private int c0;
    private int d0;
    private GestureDetector.SimpleOnGestureListener e0;
    private ScaleGestureDetector.OnScaleGestureListener f0;

    /* renamed from: h  reason: collision with root package name */
    private i0 f17626h;

    /* renamed from: j  reason: collision with root package name */
    private Queue<Promise> f17627j;

    /* renamed from: k  reason: collision with root package name */
    private Map<Promise, ReadableMap> f17628k;

    /* renamed from: l  reason: collision with root package name */
    private Map<Promise, File> f17629l;
    private Promise m;
    private List<String> n;
    private boolean p;
    private ScaleGestureDetector q;
    private GestureDetector t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Boolean x;
    private Boolean y;
    private boolean z;

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class a extends e.b {
        a() {
        }

        @Override // e.g.a.b.e.b
        public void b(e.g.a.b.e eVar) {
            org.reactnative.camera.e.e(eVar);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.g.a.b.e.b
        public void c(e.g.a.b.e eVar, byte[] bArr, int i2, int i3, int i4) {
            boolean z;
            d dVar;
            int q = org.reactnative.camera.e.q(i4, d.this.getFacing(), d.this.getCameraOrientation());
            boolean z2 = d.this.J && !d.this.A && (eVar instanceof org.reactnative.camera.g.b);
            boolean z3 = d.this.H && !d.this.B && (eVar instanceof org.reactnative.camera.g.f);
            boolean z4 = d.this.I && !d.this.C && (eVar instanceof org.reactnative.camera.g.d);
            boolean z5 = d.this.K && !d.this.D && (eVar instanceof j);
            if ((z2 || z3 || z4 || z5) && bArr.length >= i2 * 1.5d * i3) {
                if (z2) {
                    d.this.A = true;
                    z = false;
                    new org.reactnative.camera.g.a((org.reactnative.camera.g.b) eVar, d.this.E, bArr, i2, i3, d.this.U, d.this.V, d.this.W, d.this.a0, d.this.b0, d.this.c0, d.this.d0, d.this.getAspectRatio().D()).execute(new Void[0]);
                } else {
                    z = false;
                }
                int i5 = z;
                if (z3) {
                    d.this.B = true;
                    new org.reactnative.camera.g.e((org.reactnative.camera.g.f) eVar, d.this.F, bArr, i2, i3, q, d.this.getResources().getDisplayMetrics().density, d.this.getFacing(), d.this.getWidth(), d.this.getHeight(), d.this.S, d.this.T).execute(new Void[i5]);
                }
                if (z4) {
                    d.this.C = true;
                    if (d.this.Q == k.b.a.b.a) {
                        d.this.w = i5;
                    } else if (d.this.Q != k.b.a.b.f17195b) {
                        if (d.this.Q == k.b.a.b.f17196c) {
                            d.this.w = true;
                        }
                    } else {
                        d.this.w = !dVar.w;
                    }
                    if (d.this.w) {
                        for (int i6 = i5; i6 < bArr.length; i6++) {
                            bArr[i6] = (byte) (~bArr[i6]);
                        }
                    }
                    new org.reactnative.camera.g.c((org.reactnative.camera.g.d) eVar, d.this.G, bArr, i2, i3, q, d.this.getResources().getDisplayMetrics().density, d.this.getFacing(), d.this.getWidth(), d.this.getHeight(), d.this.S, d.this.T).execute(new Void[i5]);
                }
                if (z5) {
                    d.this.D = true;
                    new i((j) eVar, d.this.f17626h, bArr, i2, i3, q, d.this.getResources().getDisplayMetrics().density, d.this.getFacing(), d.this.getWidth(), d.this.getHeight(), d.this.S, d.this.T).execute(new Void[i5]);
                }
            }
        }

        @Override // e.g.a.b.e.b
        public void d(e.g.a.b.e eVar) {
            org.reactnative.camera.e.h(eVar, "Camera view threw an error - component could not be rendered.");
        }

        @Override // e.g.a.b.e.b
        public void e(e.g.a.b.e eVar, byte[] bArr, int i2) {
            Promise promise = (Promise) d.this.f17627j.poll();
            ReadableMap readableMap = (ReadableMap) d.this.f17628k.remove(promise);
            if (readableMap.hasKey("fastMode") && readableMap.getBoolean("fastMode")) {
                promise.resolve(null);
            }
            File file = (File) d.this.f17629l.remove(promise);
            if (Build.VERSION.SDK_INT >= 11) {
                new org.reactnative.camera.g.h(bArr, promise, readableMap, file, i2, d.this).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            } else {
                new org.reactnative.camera.g.h(bArr, promise, readableMap, file, i2, d.this).execute(new Void[0]);
            }
            org.reactnative.camera.e.j(eVar);
        }

        @Override // e.g.a.b.e.b
        public void f(e.g.a.b.e eVar) {
            org.reactnative.camera.e.k(eVar);
        }

        @Override // e.g.a.b.e.b
        public void g(e.g.a.b.e eVar, String str, int i2, int i3) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("videoOrientation", i2);
            createMap.putInt("deviceOrientation", i3);
            createMap.putString("uri", org.reactnative.camera.h.c.c(new File(str)).toString());
            org.reactnative.camera.e.l(eVar, createMap);
        }

        @Override // e.g.a.b.e.b
        public void h(e.g.a.b.e eVar, String str, int i2, int i3) {
            if (d.this.m != null) {
                if (str == null) {
                    d.this.m.reject("E_RECORDING", "Couldn't stop recording - there is none in progress");
                } else {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putBoolean("isRecordingInterrupted", d.this.y.booleanValue());
                    createMap.putInt("videoOrientation", i2);
                    createMap.putInt("deviceOrientation", i3);
                    createMap.putString("uri", org.reactnative.camera.h.c.c(new File(str)).toString());
                    d.this.m.resolve(createMap);
                }
                d dVar = d.this;
                Boolean bool = Boolean.FALSE;
                dVar.x = bool;
                d.this.y = bool;
                d.this.m = null;
            }
        }
    }

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class b implements Runnable {
        final /* synthetic */ Promise a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f17630b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f17631c;

        b(Promise promise, ReadableMap readableMap, File file) {
            this.a = promise;
            this.f17630b = readableMap;
            this.f17631c = file;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f17627j.add(this.a);
            d.this.f17628k.put(this.a, this.f17630b);
            d.this.f17629l.put(this.a, this.f17631c);
            try {
                d.super.z(this.f17630b);
            } catch (Exception e2) {
                d.this.f17627j.remove(this.a);
                d.this.f17628k.remove(this.a);
                d.this.f17629l.remove(this.a);
                this.a.reject("E_TAKE_PICTURE_FAILED", e2.getMessage());
            }
        }
    }

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class c implements Runnable {
        final /* synthetic */ ReadableMap a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f17633b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f17634c;

        c(ReadableMap readableMap, File file, Promise promise) {
            this.a = readableMap;
            this.f17633b = file;
            this.f17634c = promise;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                String string = this.a.hasKey(ClientCookie.PATH_ATTR) ? this.a.getString(ClientCookie.PATH_ATTR) : org.reactnative.camera.h.c.b(this.f17633b, ".mp4");
                int i2 = this.a.hasKey("maxDuration") ? this.a.getInt("maxDuration") : -1;
                int i3 = this.a.hasKey("maxFileSize") ? this.a.getInt("maxFileSize") : -1;
                int i4 = this.a.hasKey("fps") ? this.a.getInt("fps") : -1;
                CamcorderProfile o = this.a.hasKey("quality") ? org.reactnative.camera.e.o(this.a.getInt("quality")) : CamcorderProfile.get(1);
                if (this.a.hasKey("videoBitrate")) {
                    o.videoBitRate = this.a.getInt("videoBitrate");
                }
                if (d.super.s(string, i2 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA, i3, this.a.hasKey("mute") ? !this.a.getBoolean("mute") : true, o, this.a.hasKey("orientation") ? this.a.getInt("orientation") : 0, i4)) {
                    d.this.x = Boolean.TRUE;
                    d.this.m = this.f17634c;
                    return;
                }
                this.f17634c.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.");
            } catch (IOException unused) {
                this.f17634c.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.");
            }
        }
    }

    /* compiled from: RNCameraView.java */
    /* renamed from: org.reactnative.camera.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    class RunnableC0428d implements Runnable {
        RunnableC0428d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((!d.this.u || d.this.p()) && !d.this.v) {
                return;
            }
            d.this.u = false;
            d.this.v = false;
            d.this.w();
        }
    }

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.x();
            d.this.m();
        }
    }

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class f extends GestureDetector.SimpleOnGestureListener {
        f() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            d dVar = d.this;
            org.reactnative.camera.e.n(dVar, true, dVar.o0(motionEvent.getX()), d.this.o0(motionEvent.getY()));
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            d dVar = d.this;
            org.reactnative.camera.e.n(dVar, false, dVar.o0(motionEvent.getX()), d.this.o0(motionEvent.getY()));
            return true;
        }
    }

    /* compiled from: RNCameraView.java */
    /* loaded from: classes3.dex */
    class g implements ScaleGestureDetector.OnScaleGestureListener {
        g() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            d.this.m0(scaleGestureDetector.getScaleFactor());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            d.this.m0(scaleGestureDetector.getScaleFactor());
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public d(i0 i0Var) {
        super(i0Var, true);
        this.f17627j = new ConcurrentLinkedQueue();
        this.f17628k = new ConcurrentHashMap();
        this.f17629l = new ConcurrentHashMap();
        this.n = null;
        this.p = false;
        this.u = false;
        this.v = true;
        this.w = false;
        Boolean bool = Boolean.FALSE;
        this.x = bool;
        this.y = bool;
        this.z = false;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = false;
        this.H = false;
        this.I = false;
        this.J = false;
        this.K = false;
        this.L = false;
        this.M = org.reactnative.facedetector.b.f17749f;
        this.N = org.reactnative.facedetector.b.f17747d;
        this.O = org.reactnative.facedetector.b.f17745b;
        this.P = k.b.a.b.f17197d;
        this.Q = k.b.a.b.a;
        this.R = true;
        this.U = false;
        this.V = 0.0f;
        this.W = 0.0f;
        this.a0 = 0.0f;
        this.b0 = 0.0f;
        this.c0 = 0;
        this.d0 = 0;
        this.e0 = new f();
        this.f0 = new g();
        this.f17626h = i0Var;
        i0Var.addLifecycleEventListener(this);
        l(new a());
    }

    private boolean k0() {
        return Build.VERSION.SDK_INT < 23 || androidx.core.content.a.a(getContext(), "android.permission.CAMERA") == 0;
    }

    private void l0() {
        this.E = new h();
        EnumMap enumMap = new EnumMap(com.google.zxing.d.class);
        EnumSet noneOf = EnumSet.noneOf(com.google.zxing.a.class);
        List<String> list = this.n;
        if (list != null) {
            for (String str : list) {
                String str2 = (String) CameraModule.VALID_BARCODE_TYPES.get(str);
                if (str2 != null) {
                    noneOf.add(com.google.zxing.a.valueOf(str2));
                }
            }
        }
        enumMap.put((EnumMap) com.google.zxing.d.POSSIBLE_FORMATS, (com.google.zxing.d) noneOf);
        this.E.e(enumMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(float f2) {
        float zoom = getZoom();
        float f3 = (f2 - 1.0f) + zoom;
        if (f3 > zoom) {
            setZoom(Math.min(f3, 1.0f));
        } else {
            setZoom(Math.max(f3, 0.0f));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int o0(float f2) {
        Resources resources = getResources();
        resources.getConfiguration();
        return (int) (f2 / resources.getDisplayMetrics().density);
    }

    private void r0() {
        k.b.a.b bVar = new k.b.a.b(this.f17626h);
        this.G = bVar;
        bVar.f(this.P);
    }

    private void s0() {
        org.reactnative.facedetector.b bVar = new org.reactnative.facedetector.b(this.f17626h);
        this.F = bVar;
        bVar.h(this.M);
        this.F.g(this.N);
        this.F.f(this.O);
        this.F.i(this.R);
    }

    @Override // org.reactnative.camera.g.d
    public void a(WritableArray writableArray, int i2, int i3, byte[] bArr) {
        byte[] bArr2;
        if (this.I) {
            if (this.p) {
                try {
                    YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (Exception e2) {
                    throw new RuntimeException(String.format("Error decoding imageData from NV21 format (%d bytes)", Integer.valueOf(bArr.length)), e2);
                }
            } else {
                bArr2 = null;
            }
            org.reactnative.camera.e.d(this, writableArray, bArr2);
        }
    }

    @Override // org.reactnative.camera.g.f
    public void b(org.reactnative.facedetector.b bVar) {
        if (this.H) {
            org.reactnative.camera.e.f(this, bVar);
        }
    }

    @Override // org.reactnative.camera.g.f
    public void c(WritableArray writableArray) {
        if (this.H) {
            org.reactnative.camera.e.g(this, writableArray);
        }
    }

    @Override // org.reactnative.camera.g.b
    public void d(k kVar, int i2, int i3, byte[] bArr) {
        byte[] bArr2;
        String str = kVar.b().toString();
        if (this.J && this.n.contains(str)) {
            if (this.p) {
                try {
                    YuvImage yuvImage = new YuvImage(bArr, 17, i2, i3, null);
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    yuvImage.compressToJpeg(new Rect(0, 0, i2, i3), 100, byteArrayOutputStream);
                    bArr2 = byteArrayOutputStream.toByteArray();
                } catch (Exception e2) {
                    throw new RuntimeException(String.format("Error decoding imageData from NV21 format (%d bytes)", Integer.valueOf(bArr.length)), e2);
                }
            } else {
                bArr2 = null;
            }
            org.reactnative.camera.e.b(this, kVar, i2, i3, bArr2);
        }
    }

    @Override // org.reactnative.camera.g.d
    public void e(k.b.a.b bVar) {
        if (this.I) {
            org.reactnative.camera.e.c(this, bVar);
        }
    }

    @Override // org.reactnative.camera.g.j
    public void f() {
        this.D = false;
    }

    @Override // org.reactnative.camera.g.b
    public void g() {
        this.A = false;
        h hVar = this.E;
        if (hVar != null) {
            hVar.reset();
        }
    }

    @Override // org.reactnative.camera.g.g
    public void h(WritableMap writableMap) {
        org.reactnative.camera.e.i(this, writableMap);
    }

    @Override // org.reactnative.camera.g.f
    public void i() {
        this.B = false;
    }

    @Override // org.reactnative.camera.g.j
    public void j(WritableArray writableArray) {
        if (this.K) {
            org.reactnative.camera.e.m(this, writableArray);
        }
    }

    @Override // org.reactnative.camera.g.d
    public void k() {
        this.C = false;
    }

    public void n0(ReadableMap readableMap, Promise promise, File file) {
        this.f12942g.post(new c(readableMap, file, promise));
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        org.reactnative.facedetector.b bVar = this.F;
        if (bVar != null) {
            bVar.d();
        }
        k.b.a.b bVar2 = this.G;
        if (bVar2 != null) {
            bVar2.d();
        }
        this.E = null;
        this.f17626h.removeLifecycleEventListener(this);
        this.f12942g.post(new e());
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        if (this.x.booleanValue()) {
            this.y = Boolean.TRUE;
        }
        if (this.u || !p()) {
            return;
        }
        this.u = true;
        x();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        if (k0()) {
            this.f12942g.post(new RunnableC0428d());
        } else {
            org.reactnative.camera.e.h(this, "Camera permissions not granted - component could not be rendered.");
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        View view = getView();
        if (view == null) {
            return;
        }
        float f2 = i4 - i2;
        float f3 = i5 - i3;
        float D = getAspectRatio().D();
        int i8 = getResources().getConfiguration().orientation;
        setBackgroundColor(-16777216);
        if (i8 == 2) {
            float f4 = D * f3;
            if (f4 < f2) {
                i7 = (int) (f2 / D);
                i6 = (int) f2;
            } else {
                i6 = (int) f4;
                i7 = (int) f3;
            }
        } else {
            float f5 = D * f2;
            if (f5 > f3) {
                i7 = (int) f5;
                i6 = (int) f2;
            } else {
                i6 = (int) (f3 / D);
                i7 = (int) f3;
            }
        }
        int i9 = (int) ((f2 - i6) / 2.0f);
        int i10 = (int) ((f3 - i7) / 2.0f);
        this.S = i9;
        this.T = i10;
        view.layout(i9, i10, i6 + i9, i7 + i10);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.z) {
            this.q.onTouchEvent(motionEvent);
        }
        if (this.L) {
            this.t.onTouchEvent(motionEvent);
            return true;
        }
        return true;
    }

    public void p0(int i2, int i3) {
        this.c0 = i2;
        this.d0 = i3;
    }

    public void q0(float f2, float f3, float f4, float f5) {
        this.U = true;
        this.V = f2;
        this.W = f3;
        this.a0 = f4;
        this.b0 = f5;
    }

    @Override // android.view.View, android.view.ViewParent
    @SuppressLint({"all"})
    public void requestLayout() {
    }

    public void setBarCodeTypes(List<String> list) {
        this.n = list;
        l0();
    }

    public void setDetectedImageInEvent(boolean z) {
        this.p = z;
    }

    public void setFaceDetectionClassifications(int i2) {
        this.O = i2;
        org.reactnative.facedetector.b bVar = this.F;
        if (bVar != null) {
            bVar.f(i2);
        }
    }

    public void setFaceDetectionLandmarks(int i2) {
        this.N = i2;
        org.reactnative.facedetector.b bVar = this.F;
        if (bVar != null) {
            bVar.g(i2);
        }
    }

    public void setFaceDetectionMode(int i2) {
        this.M = i2;
        org.reactnative.facedetector.b bVar = this.F;
        if (bVar != null) {
            bVar.h(i2);
        }
    }

    public void setGoogleVisionBarcodeMode(int i2) {
        this.Q = i2;
    }

    public void setGoogleVisionBarcodeType(int i2) {
        this.P = i2;
        k.b.a.b bVar = this.G;
        if (bVar != null) {
            bVar.f(i2);
        }
    }

    public void setShouldDetectFaces(boolean z) {
        if (z && this.F == null) {
            s0();
        }
        this.H = z;
        setScanning(z || this.I || this.J || this.K);
    }

    public void setShouldDetectTouches(boolean z) {
        if (!this.L && z) {
            this.t = new GestureDetector(this.f17626h, this.e0);
        } else {
            this.t = null;
        }
        this.L = z;
    }

    public void setShouldGoogleDetectBarcodes(boolean z) {
        if (z && this.G == null) {
            r0();
        }
        this.I = z;
        setScanning(this.H || z || this.J || this.K);
    }

    public void setShouldRecognizeText(boolean z) {
        this.K = z;
        setScanning(this.H || this.I || this.J || z);
    }

    public void setShouldScanBarCodes(boolean z) {
        if (z && this.E == null) {
            l0();
        }
        this.J = z;
        setScanning(this.H || this.I || z || this.K);
    }

    public void setTracking(boolean z) {
        this.R = z;
        org.reactnative.facedetector.b bVar = this.F;
        if (bVar != null) {
            bVar.i(z);
        }
    }

    public void setUseNativeZoom(boolean z) {
        if (!this.z && z) {
            this.q = new ScaleGestureDetector(this.f17626h, this.f0);
        } else {
            this.q = null;
        }
        this.z = z;
    }

    public void t0(ReadableMap readableMap, Promise promise, File file) {
        this.f12942g.post(new b(promise, readableMap, file));
    }
}