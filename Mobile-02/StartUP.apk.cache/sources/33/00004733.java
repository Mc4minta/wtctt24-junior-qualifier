package e.g.a.b;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.facebook.react.bridge.ReadableMap;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.g.a.b.f;
import e.g.a.b.i;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.spongycastle.crypto.tls.CipherSuite;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Camera1.java */
/* loaded from: classes2.dex */
public class b extends e.g.a.b.f implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener, Camera.PreviewCallback {

    /* renamed from: d  reason: collision with root package name */
    private static final c.e.h<String> f12915d;

    /* renamed from: e  reason: collision with root package name */
    private static final c.e.h<String> f12916e;
    private boolean A;
    private int B;
    private int C;
    private float D;
    private int E;
    private int F;
    private int G;
    private float H;
    private int I;
    private boolean J;
    private Boolean K;
    private boolean L;
    private boolean M;
    private SurfaceTexture N;

    /* renamed from: f  reason: collision with root package name */
    private Handler f12917f;

    /* renamed from: g  reason: collision with root package name */
    private int f12918g;

    /* renamed from: h  reason: collision with root package name */
    private String f12919h;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f12920j;

    /* renamed from: k  reason: collision with root package name */
    Camera f12921k;

    /* renamed from: l  reason: collision with root package name */
    MediaActionSound f12922l;
    private Camera.Parameters m;
    private final Camera.CameraInfo n;
    private MediaRecorder p;
    private String q;
    private final AtomicBoolean t;
    private final k u;
    private boolean v;
    private boolean w;
    private final k x;
    private e.g.a.b.j y;
    private e.g.a.b.a z;

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class a implements i.a {

        /* compiled from: Camera1.java */
        /* renamed from: e.g.a.b.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0289a implements Runnable {
            RunnableC0289a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.P();
            }
        }

        /* compiled from: Camera1.java */
        /* renamed from: e.g.a.b.b$a$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class RunnableC0290b implements Runnable {
            RunnableC0290b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.Q();
            }
        }

        a() {
        }

        @Override // e.g.a.b.i.a
        public void a() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.f12921k != null) {
                    bVar.M = true;
                    try {
                        b.this.f12921k.setPreviewCallback(null);
                        b.this.f12921k.setPreviewDisplay(null);
                    } catch (Exception e2) {
                        Log.e("CAMERA_1::", "onSurfaceDestroyed preview cleanup failed", e2);
                    }
                }
            }
            b.this.f12957c.post(new RunnableC0290b());
        }

        @Override // e.g.a.b.i.a
        public void b() {
            synchronized (b.this) {
                if (!b.this.M) {
                    b.this.N0();
                } else {
                    b.this.f12957c.post(new RunnableC0289a());
                }
            }
        }
    }

    /* compiled from: Camera1.java */
    /* renamed from: e.g.a.b.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class RunnableC0291b implements Runnable {
        final /* synthetic */ float a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ float f12923b;

        /* compiled from: Camera1.java */
        /* renamed from: e.g.a.b.b$b$a */
        /* loaded from: classes2.dex */
        class a implements Camera.AutoFocusCallback {
            a() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        }

        /* compiled from: Camera1.java */
        /* renamed from: e.g.a.b.b$b$b  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0292b implements Camera.AutoFocusCallback {
            C0292b() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        }

        /* compiled from: Camera1.java */
        /* renamed from: e.g.a.b.b$b$c */
        /* loaded from: classes2.dex */
        class c implements Camera.AutoFocusCallback {
            c() {
            }

            @Override // android.hardware.Camera.AutoFocusCallback
            public void onAutoFocus(boolean z, Camera camera) {
            }
        }

        RunnableC0291b(float f2, float f3) {
            this.a = f2;
            this.f12923b = f3;
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.f12921k != null) {
                    Camera.Parameters parameters = bVar.m;
                    if (parameters == null) {
                        return;
                    }
                    String focusMode = parameters.getFocusMode();
                    Rect n0 = b.this.n0(this.a, this.f12923b);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new Camera.Area(n0, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA));
                    if (parameters.getMaxNumFocusAreas() != 0 && focusMode != null && (focusMode.equals("auto") || focusMode.equals("macro") || focusMode.equals("continuous-picture") || focusMode.equals("continuous-video"))) {
                        parameters.setFocusMode("auto");
                        parameters.setFocusAreas(arrayList);
                        if (parameters.getMaxNumMeteringAreas() > 0) {
                            parameters.setMeteringAreas(arrayList);
                        }
                        if (!parameters.getSupportedFocusModes().contains("auto")) {
                            return;
                        }
                        try {
                            b.this.f12921k.setParameters(parameters);
                        } catch (RuntimeException e2) {
                            Log.e("CAMERA_1::", "setParameters failed", e2);
                        }
                        try {
                            b.this.f12921k.autoFocus(new a());
                        } catch (RuntimeException e3) {
                            Log.e("CAMERA_1::", "autoFocus failed", e3);
                        }
                    } else if (parameters.getMaxNumMeteringAreas() > 0) {
                        if (!parameters.getSupportedFocusModes().contains("auto")) {
                            return;
                        }
                        parameters.setFocusMode("auto");
                        parameters.setFocusAreas(arrayList);
                        parameters.setMeteringAreas(arrayList);
                        try {
                            b.this.f12921k.setParameters(parameters);
                        } catch (RuntimeException e4) {
                            Log.e("CAMERA_1::", "setParameters failed", e4);
                        }
                        try {
                            b.this.f12921k.autoFocus(new C0292b());
                        } catch (RuntimeException e5) {
                            Log.e("CAMERA_1::", "autoFocus failed", e5);
                        }
                    } else {
                        try {
                            b.this.f12921k.autoFocus(new c());
                        } catch (RuntimeException e6) {
                            Log.e("CAMERA_1::", "autoFocus failed", e6);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.f12921k != null) {
                    bVar.L = false;
                    b.this.H0();
                    b.this.k0();
                    if (b.this.w) {
                        b.this.K0();
                    }
                }
            }
        }
    }

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                b.this.w = true;
                b.this.K0();
            }
        }
    }

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.t()) {
                b.this.Q();
                b.this.P();
            }
        }
    }

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.t()) {
                b.this.Q();
                b.this.P();
            }
        }
    }

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.f12921k != null) {
                    bVar.k0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (b.this) {
                b bVar = b.this;
                if (bVar.f12921k != null) {
                    bVar.k0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    public class i implements Camera.PictureCallback {
        final /* synthetic */ ReadableMap a;

        i(ReadableMap readableMap) {
            this.a = readableMap;
        }

        @Override // android.hardware.Camera.PictureCallback
        public void onPictureTaken(byte[] bArr, Camera camera) {
            if (b.this.K.booleanValue()) {
                b.this.f12922l.play(0);
            }
            synchronized (b.this) {
                if (b.this.f12921k != null) {
                    if (this.a.hasKey("pauseAfterCapture") && !this.a.getBoolean("pauseAfterCapture")) {
                        b.this.f12921k.startPreview();
                        b.this.v = true;
                        if (b.this.J) {
                            b bVar = b.this;
                            bVar.f12921k.setPreviewCallback(bVar);
                        }
                    } else {
                        b.this.f12921k.stopPreview();
                        b.this.v = false;
                        b.this.f12921k.setPreviewCallback(null);
                    }
                }
            }
            b.this.f12920j.set(false);
            b.this.G = 0;
            b bVar2 = b.this;
            bVar2.a.g(bArr, bVar2.r0(bVar2.F));
            if (b.this.L) {
                b.this.N0();
            }
        }
    }

    /* compiled from: Camera1.java */
    /* loaded from: classes2.dex */
    class j implements Runnable {
        final /* synthetic */ SurfaceTexture a;

        j(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b bVar = b.this;
                Camera camera = bVar.f12921k;
                if (camera == null) {
                    bVar.N = this.a;
                    return;
                }
                camera.stopPreview();
                b.this.v = false;
                SurfaceTexture surfaceTexture = this.a;
                if (surfaceTexture == null) {
                    b bVar2 = b.this;
                    bVar2.f12921k.setPreviewTexture((SurfaceTexture) bVar2.f12956b.g());
                } else {
                    b.this.f12921k.setPreviewTexture(surfaceTexture);
                }
                b.this.N = this.a;
                b.this.K0();
            } catch (IOException e2) {
                Log.e("CAMERA_1::", "setPreviewTexture failed", e2);
            }
        }
    }

    static {
        c.e.h<String> hVar = new c.e.h<>();
        f12915d = hVar;
        hVar.l(0, "off");
        hVar.l(1, "on");
        hVar.l(2, "torch");
        hVar.l(3, "auto");
        hVar.l(4, "red-eye");
        c.e.h<String> hVar2 = new c.e.h<>();
        f12916e = hVar2;
        hVar2.l(0, "auto");
        hVar2.l(1, "cloudy-daylight");
        hVar2.l(2, "daylight");
        hVar2.l(3, "shade");
        hVar2.l(4, "fluorescent");
        hVar2.l(5, "incandescent");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(f.a aVar, e.g.a.b.i iVar, Handler handler) {
        super(aVar, iVar, handler);
        this.f12917f = new Handler();
        this.f12920j = new AtomicBoolean(false);
        this.f12922l = new MediaActionSound();
        this.n = new Camera.CameraInfo();
        this.t = new AtomicBoolean(false);
        this.u = new k();
        this.v = false;
        this.w = true;
        this.x = new k();
        this.G = 0;
        this.K = Boolean.FALSE;
        iVar.l(new a());
    }

    private boolean A0(boolean z) {
        this.A = z;
        if (t()) {
            List<String> supportedFocusModes = this.m.getSupportedFocusModes();
            if (z && supportedFocusModes.contains("continuous-picture")) {
                this.m.setFocusMode("continuous-picture");
                return true;
            } else if (this.J && supportedFocusModes.contains("macro")) {
                this.m.setFocusMode("macro");
                return true;
            } else if (supportedFocusModes.contains("fixed")) {
                this.m.setFocusMode("fixed");
                return true;
            } else if (supportedFocusModes.contains("infinity")) {
                this.m.setFocusMode("infinity");
                return true;
            } else {
                this.m.setFocusMode(supportedFocusModes.get(0));
                return true;
            }
        }
        return false;
    }

    private void B0(CamcorderProfile camcorderProfile, boolean z, int i2) {
        if (!t0(i2)) {
            i2 = camcorderProfile.videoFrameRate;
        }
        this.p.setOutputFormat(camcorderProfile.fileFormat);
        this.p.setVideoFrameRate(i2);
        this.p.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.p.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.p.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.p.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.p.setAudioChannels(camcorderProfile.audioChannels);
            this.p.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.p.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    private boolean C0(float f2) {
        int minExposureCompensation;
        int maxExposureCompensation;
        this.D = f2;
        int i2 = 0;
        if (!t() || (minExposureCompensation = this.m.getMinExposureCompensation()) == (maxExposureCompensation = this.m.getMaxExposureCompensation())) {
            return false;
        }
        float f3 = this.D;
        if (f3 >= 0.0f && f3 <= 1.0f) {
            i2 = ((int) (f3 * (maxExposureCompensation - minExposureCompensation))) + minExposureCompensation;
        }
        this.m.setExposureCompensation(i2);
        return true;
    }

    private boolean D0(int i2) {
        if (t()) {
            List<String> supportedFlashModes = this.m.getSupportedFlashModes();
            c.e.h<String> hVar = f12915d;
            String f2 = hVar.f(i2);
            if (supportedFlashModes == null) {
                return false;
            }
            if (supportedFlashModes.contains(f2)) {
                this.m.setFlashMode(f2);
                this.C = i2;
                return true;
            } else if (supportedFlashModes.contains(hVar.f(this.C))) {
                return false;
            } else {
                this.m.setFlashMode("off");
                return true;
            }
        }
        this.C = i2;
        return false;
    }

    private void E0(boolean z) {
        this.K = Boolean.valueOf(z);
        Camera camera = this.f12921k;
        if (camera != null) {
            try {
                if (camera.enableShutterSound(false)) {
                    return;
                }
                this.K = Boolean.FALSE;
            } catch (Exception e2) {
                Log.e("CAMERA_1::", "setPlaySoundInternal failed", e2);
                this.K = Boolean.FALSE;
            }
        }
    }

    private void F0(boolean z) {
        this.J = z;
        if (t()) {
            if (this.J) {
                this.f12921k.setPreviewCallback(this);
            } else {
                this.f12921k.setPreviewCallback(null);
            }
        }
    }

    private void G0(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile, int i4) {
        CamcorderProfile camcorderProfile2;
        this.p = new MediaRecorder();
        this.f12921k.unlock();
        this.p.setCamera(this.f12921k);
        this.p.setVideoSource(1);
        if (z) {
            this.p.setAudioSource(5);
        }
        this.p.setOutputFile(str);
        this.q = str;
        if (CamcorderProfile.hasProfile(this.f12918g, camcorderProfile.quality)) {
            camcorderProfile2 = CamcorderProfile.get(this.f12918g, camcorderProfile.quality);
        } else {
            camcorderProfile2 = CamcorderProfile.get(this.f12918g, 1);
        }
        camcorderProfile2.videoBitRate = camcorderProfile.videoBitRate;
        B0(camcorderProfile2, z, i4);
        MediaRecorder mediaRecorder = this.p;
        int i5 = this.G;
        mediaRecorder.setOrientationHint(l0(i5 != 0 ? w0(i5) : this.F));
        if (i2 != -1) {
            this.p.setMaxDuration(i2);
        }
        if (i3 != -1) {
            this.p.setMaxFileSize(i3);
        }
        this.p.setOnInfoListener(this);
        this.p.setOnErrorListener(this);
    }

    private boolean I0(int i2) {
        this.I = i2;
        if (t()) {
            List<String> supportedWhiteBalance = this.m.getSupportedWhiteBalance();
            c.e.h<String> hVar = f12916e;
            String f2 = hVar.f(i2);
            if (supportedWhiteBalance != null && supportedWhiteBalance.contains(f2)) {
                this.m.setWhiteBalance(f2);
                return true;
            }
            String f3 = hVar.f(this.I);
            if (supportedWhiteBalance == null || !supportedWhiteBalance.contains(f3)) {
                this.m.setWhiteBalance("auto");
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean J0(float f2) {
        if (t() && this.m.isZoomSupported()) {
            this.m.setZoom((int) (this.m.getMaxZoom() * f2));
            this.H = f2;
            return true;
        }
        this.H = f2;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        Camera camera;
        if (this.v || (camera = this.f12921k) == null) {
            return;
        }
        try {
            this.v = true;
            camera.startPreview();
            if (this.J) {
                this.f12921k.setPreviewCallback(this);
            }
        } catch (Exception e2) {
            this.v = false;
            Log.e("CAMERA_1::", "startCameraPreview failed", e2);
        }
    }

    private void L0() {
        synchronized (this) {
            MediaRecorder mediaRecorder = this.p;
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.stop();
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "stopMediaRecorder stop failed", e2);
                }
                try {
                    this.p.reset();
                    this.p.release();
                } catch (RuntimeException e3) {
                    Log.e("CAMERA_1::", "stopMediaRecorder reset failed", e3);
                }
                this.p = null;
            }
            this.a.b();
            int r0 = r0(this.F);
            if (this.q != null && new File(this.q).exists()) {
                f.a aVar = this.a;
                String str = this.q;
                int i2 = this.G;
                if (i2 == 0) {
                    i2 = r0;
                }
                aVar.h(str, i2, r0);
                this.q = null;
                return;
            }
            f.a aVar2 = this.a;
            int i3 = this.G;
            if (i3 == 0) {
                i3 = r0;
            }
            aVar2.h(null, i3, r0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        if (this.f12921k != null) {
            if (!this.f12920j.get() && !this.t.get()) {
                this.f12957c.post(new c());
            } else {
                this.L = true;
            }
        }
    }

    private int l0(int i2) {
        Camera.CameraInfo cameraInfo = this.n;
        if (cameraInfo.facing == 0) {
            return (cameraInfo.orientation + i2) % 360;
        }
        return ((this.n.orientation + i2) + (u0(i2) ? CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 : 0)) % 360;
    }

    private int m0(int i2) {
        Camera.CameraInfo cameraInfo = this.n;
        if (cameraInfo.facing == 1) {
            return (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
        }
        return ((cameraInfo.orientation - i2) + 360) % 360;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect n0(float f2, float f3) {
        int i2 = (int) (f2 * 2000.0f);
        int i3 = (int) (f3 * 2000.0f);
        int i4 = i2 - 150;
        int i5 = i3 - 150;
        int i6 = i2 + CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA;
        int i7 = i3 + CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA;
        if (i4 < 0) {
            i4 = 0;
        }
        if (i6 > 2000) {
            i6 = 2000;
        }
        if (i5 < 0) {
            i5 = 0;
        }
        if (i7 > 2000) {
            i7 = 2000;
        }
        return new Rect(i4 - 1000, i5 - 1000, i6 - 1000, i7 - 1000);
    }

    private e.g.a.b.a o0() {
        Iterator<e.g.a.b.a> it = this.u.d().iterator();
        e.g.a.b.a aVar = null;
        while (it.hasNext()) {
            aVar = it.next();
            if (aVar.equals(e.g.a.b.g.a)) {
                break;
            }
        }
        return aVar;
    }

    private void p0() {
        String str = this.f12919h;
        if (str == null) {
            try {
                int numberOfCameras = Camera.getNumberOfCameras();
                if (numberOfCameras == 0) {
                    this.f12918g = -1;
                    Log.w("CAMERA_1::", "getNumberOfCameras returned 0. No camera available.");
                    return;
                }
                for (int i2 = 0; i2 < numberOfCameras; i2++) {
                    Camera.getCameraInfo(i2, this.n);
                    if (this.n.facing == this.B) {
                        this.f12918g = i2;
                        return;
                    }
                }
                this.f12918g = 0;
                Camera.getCameraInfo(0, this.n);
                return;
            } catch (Exception e2) {
                Log.e("CAMERA_1::", "chooseCamera failed.", e2);
                this.f12918g = -1;
                return;
            }
        }
        try {
            int parseInt = Integer.parseInt(str);
            this.f12918g = parseInt;
            Camera.getCameraInfo(parseInt, this.n);
        } catch (Exception unused) {
            this.f12918g = -1;
        }
    }

    private e.g.a.b.j q0(SortedSet<e.g.a.b.j> sortedSet) {
        if (!this.f12956b.j()) {
            return sortedSet.first();
        }
        int i2 = this.f12956b.i();
        int c2 = this.f12956b.c();
        if (u0(this.E)) {
            c2 = i2;
            i2 = c2;
        }
        e.g.a.b.j jVar = null;
        Iterator<e.g.a.b.j> it = sortedSet.iterator();
        while (it.hasNext()) {
            jVar = it.next();
            if (i2 <= jVar.getWidth() && c2 <= jVar.getHeight()) {
                break;
            }
        }
        return jVar;
    }

    private e.g.a.b.j s0(int i2, int i3, SortedSet<e.g.a.b.j> sortedSet) {
        if (sortedSet == null || sortedSet.isEmpty()) {
            return null;
        }
        e.g.a.b.j last = sortedSet.last();
        if (i2 == 0 || i3 == 0) {
            return last;
        }
        for (e.g.a.b.j jVar : sortedSet) {
            if (i2 <= jVar.getWidth() && i3 <= jVar.getHeight()) {
                return jVar;
            }
        }
        return last;
    }

    private boolean t0(int i2) {
        boolean z;
        ArrayList<int[]> p = p();
        int i3 = i2 * RNCWebViewManager.COMMAND_CLEAR_FORM_DATA;
        Iterator<int[]> it = p.iterator();
        do {
            z = false;
            if (it.hasNext()) {
                int[] next = it.next();
                boolean z2 = i3 >= next[0] && i3 <= next[1];
                boolean z3 = i3 > 0;
                if (z2 && z3) {
                    z = true;
                    continue;
                }
            } else {
                Log.w("CAMERA_1::", "fps (framePerSecond) received an unsupported value and will be ignored.");
                return false;
            }
        } while (!z);
        return true;
    }

    private boolean u0(int i2) {
        return i2 == 90 || i2 == 270;
    }

    private boolean v0() {
        if (this.f12921k != null) {
            y0();
        }
        int i2 = this.f12918g;
        if (i2 == -1) {
            return false;
        }
        try {
            Camera open = Camera.open(i2);
            this.f12921k = open;
            this.m = open.getParameters();
            this.u.b();
            for (Camera.Size size : this.m.getSupportedPreviewSizes()) {
                this.u.a(new e.g.a.b.j(size.width, size.height));
            }
            this.x.b();
            for (Camera.Size size2 : this.m.getSupportedPictureSizes()) {
                this.x.a(new e.g.a.b.j(size2.width, size2.height));
            }
            for (e.g.a.b.a aVar : this.u.d()) {
                if (this.x.f(aVar) == null) {
                    this.u.e(aVar);
                }
            }
            if (this.z == null) {
                this.z = e.g.a.b.g.a;
            }
            k0();
            this.f12921k.setDisplayOrientation(m0(this.E));
            this.a.d();
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    private void x0() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.p.pause();
        }
    }

    private void y0() {
        Camera camera = this.f12921k;
        if (camera != null) {
            camera.release();
            this.f12921k = null;
            this.a.a();
            this.f12920j.set(false);
            this.t.set(false);
        }
    }

    private void z0() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.p.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void A(boolean z) {
        if (this.A == z) {
            return;
        }
        synchronized (this) {
            if (A0(z)) {
                try {
                    Camera camera = this.f12921k;
                    if (camera != null) {
                        camera.setParameters(this.m);
                    }
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "setParameters failed", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void B(String str) {
        if (org.reactnative.camera.h.b.a(this.f12919h, str)) {
            return;
        }
        this.f12919h = str;
        if (org.reactnative.camera.h.b.a(str, String.valueOf(this.f12918g))) {
            return;
        }
        this.f12957c.post(new f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void C(int i2) {
        synchronized (this) {
            if (this.F == i2) {
                return;
            }
            this.F = i2;
            if (t() && this.G == 0 && !this.t.get() && !this.f12920j.get()) {
                this.m.setRotation(l0(i2));
                try {
                    this.f12921k.setParameters(this.m);
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "setParameters failed", e2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void D(int i2) {
        synchronized (this) {
            if (this.E == i2) {
                return;
            }
            this.E = i2;
            if (t()) {
                boolean z = this.v && Build.VERSION.SDK_INT < 14;
                if (z) {
                    this.f12921k.stopPreview();
                    this.v = false;
                }
                try {
                    this.f12921k.setDisplayOrientation(m0(i2));
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "setDisplayOrientation failed", e2);
                }
                if (z) {
                    K0();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void E(float f2) {
        if (f2 != this.D && C0(f2)) {
            try {
                Camera camera = this.f12921k;
                if (camera != null) {
                    camera.setParameters(this.m);
                }
            } catch (RuntimeException e2) {
                Log.e("CAMERA_1::", "setParameters failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void F(int i2) {
        if (this.B == i2) {
            return;
        }
        this.B = i2;
        this.f12957c.post(new e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void G(int i2) {
        if (i2 != this.C && D0(i2)) {
            try {
                Camera camera = this.f12921k;
                if (camera != null) {
                    camera.setParameters(this.m);
                }
            } catch (RuntimeException e2) {
                Log.e("CAMERA_1::", "setParameters failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void H(float f2, float f3) {
        this.f12957c.post(new RunnableC0291b(f2, f3));
    }

    @SuppressLint({"NewApi"})
    void H0() {
        try {
            this.M = false;
            Camera camera = this.f12921k;
            if (camera != null) {
                SurfaceTexture surfaceTexture = this.N;
                if (surfaceTexture != null) {
                    camera.setPreviewTexture(surfaceTexture);
                } else if (this.f12956b.d() == SurfaceHolder.class) {
                    boolean z = this.v && Build.VERSION.SDK_INT < 14;
                    if (z) {
                        this.f12921k.stopPreview();
                        this.v = false;
                    }
                    this.f12921k.setPreviewDisplay(this.f12956b.f());
                    if (z) {
                        K0();
                    }
                } else {
                    this.f12921k.setPreviewTexture((SurfaceTexture) this.f12956b.g());
                }
            }
        } catch (Exception e2) {
            Log.e("CAMERA_1::", "setUpPreview failed", e2);
        }
    }

    @Override // e.g.a.b.f
    public void I(float f2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void J(e.g.a.b.j jVar) {
        if (jVar == null && this.y == null) {
            return;
        }
        if (jVar == null || !jVar.equals(this.y)) {
            this.y = jVar;
            if (t()) {
                this.f12957c.post(new g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void K(boolean z) {
        if (z == this.K.booleanValue()) {
            return;
        }
        E0(z);
    }

    @Override // e.g.a.b.f
    public void L(SurfaceTexture surfaceTexture) {
        this.f12957c.post(new j(surfaceTexture));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void M(boolean z) {
        if (z == this.J) {
            return;
        }
        F0(z);
    }

    void M0(ReadableMap readableMap) {
        if (!this.t.get() && this.f12920j.compareAndSet(false, true)) {
            try {
                if (readableMap.hasKey("orientation") && readableMap.getInt("orientation") != 0) {
                    int i2 = readableMap.getInt("orientation");
                    this.G = i2;
                    this.m.setRotation(l0(w0(i2)));
                    try {
                        this.f12921k.setParameters(this.m);
                    } catch (RuntimeException e2) {
                        Log.e("CAMERA_1::", "setParameters rotation failed", e2);
                    }
                }
                if (readableMap.hasKey("quality")) {
                    this.m.setJpegQuality((int) (readableMap.getDouble("quality") * 100.0d));
                    try {
                        this.f12921k.setParameters(this.m);
                    } catch (RuntimeException e3) {
                        Log.e("CAMERA_1::", "setParameters quality failed", e3);
                    }
                }
                this.f12921k.takePicture(null, null, null, new i(readableMap));
                return;
            } catch (Exception e4) {
                this.f12920j.set(false);
                throw e4;
            }
        }
        throw new IllegalStateException("Camera capture failed. Camera is already capturing.");
    }

    @Override // e.g.a.b.f
    public void N(int i2) {
        if (i2 != this.I && I0(i2)) {
            try {
                Camera camera = this.f12921k;
                if (camera != null) {
                    camera.setParameters(this.m);
                }
            } catch (RuntimeException e2) {
                Log.e("CAMERA_1::", "setParameters failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void O(float f2) {
        if (f2 != this.H && J0(f2)) {
            try {
                Camera camera = this.f12921k;
                if (camera != null) {
                    camera.setParameters(this.m);
                }
            } catch (RuntimeException e2) {
                Log.e("CAMERA_1::", "setParameters failed", e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean P() {
        synchronized (this) {
            p0();
            if (!v0()) {
                this.a.e();
                return true;
            }
            if (this.f12956b.j()) {
                H0();
                if (this.w) {
                    K0();
                }
            }
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void Q() {
        synchronized (this) {
            MediaRecorder mediaRecorder = this.p;
            if (mediaRecorder != null) {
                try {
                    mediaRecorder.stop();
                } catch (RuntimeException e2) {
                    Log.e("CAMERA_1::", "mMediaRecorder.stop() failed", e2);
                }
                try {
                    this.p.reset();
                    this.p.release();
                } catch (RuntimeException e3) {
                    Log.e("CAMERA_1::", "mMediaRecorder.release() failed", e3);
                }
                this.p = null;
                if (this.t.get()) {
                    this.a.b();
                    int r0 = r0(this.F);
                    f.a aVar = this.a;
                    String str = this.q;
                    int i2 = this.G;
                    if (i2 == 0) {
                        i2 = r0;
                    }
                    aVar.h(str, i2, r0);
                }
            }
            Camera camera = this.f12921k;
            if (camera != null) {
                this.v = false;
                try {
                    camera.stopPreview();
                    this.f12921k.setPreviewCallback(null);
                } catch (Exception e4) {
                    Log.e("CAMERA_1::", "stop preview cleanup failed", e4);
                }
            }
            y0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void R() {
        if (this.t.compareAndSet(true, false)) {
            L0();
            Camera camera = this.f12921k;
            if (camera != null) {
                camera.lock();
            }
            if (this.L) {
                N0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void S(ReadableMap readableMap) {
        if (t()) {
            if (this.v) {
                M0(readableMap);
                return;
            }
            throw new IllegalStateException("Preview is paused - resume it before taking a picture.");
        }
        throw new IllegalStateException("Camera is not ready. Call start() before takePicture().");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public e.g.a.b.a a() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean b() {
        if (!t()) {
            return this.A;
        }
        String focusMode = this.m.getFocusMode();
        return focusMode != null && focusMode.contains("continuous");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public SortedSet<e.g.a.b.j> c(e.g.a.b.a aVar) {
        return this.x.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public String d() {
        return this.f12919h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public List<Properties> e() {
        ArrayList arrayList = new ArrayList();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Properties properties = new Properties();
            Camera.getCameraInfo(i2, cameraInfo);
            properties.put("id", String.valueOf(i2));
            properties.put("type", String.valueOf(cameraInfo.facing));
            arrayList.add(properties);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int f() {
        return this.n.orientation;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float g() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int h() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int i() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float j() {
        return 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public e.g.a.b.j k() {
        return this.y;
    }

    void k0() {
        e.g.a.b.j s0;
        SortedSet<e.g.a.b.j> f2 = this.u.f(this.z);
        if (f2 == null) {
            Log.w("CAMERA_1::", "adjustCameraParameters received an unsupported aspect ratio value and will be ignored.");
            e.g.a.b.a o0 = o0();
            this.z = o0;
            f2 = this.u.f(o0);
        }
        e.g.a.b.j q0 = q0(f2);
        e.g.a.b.j jVar = this.y;
        if (jVar != null) {
            s0 = s0(jVar.getWidth(), this.y.getHeight(), this.x.f(this.z));
        } else {
            s0 = s0(0, 0, this.x.f(this.z));
        }
        boolean z = this.v;
        if (z) {
            this.f12921k.stopPreview();
            this.v = false;
        }
        this.m.setPreviewSize(q0.getWidth(), q0.getHeight());
        this.m.setPictureSize(s0.getWidth(), s0.getHeight());
        int i2 = this.G;
        if (i2 != 0) {
            this.m.setRotation(l0(w0(i2)));
        } else {
            this.m.setRotation(l0(this.F));
        }
        A0(this.A);
        D0(this.C);
        C0(this.D);
        z(this.z);
        J0(this.H);
        I0(this.I);
        F0(this.J);
        E0(this.K.booleanValue());
        try {
            this.f12921k.setParameters(this.m);
        } catch (RuntimeException e2) {
            Log.e("CAMERA_1::", "setParameters failed", e2);
        }
        if (z) {
            K0();
        }
    }

    @Override // e.g.a.b.f
    public boolean l() {
        return this.K.booleanValue();
    }

    @Override // e.g.a.b.f
    public e.g.a.b.j m() {
        Camera.Size previewSize = this.m.getPreviewSize();
        return new e.g.a.b.j(previewSize.width, previewSize.height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean n() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public Set<e.g.a.b.a> o() {
        k kVar = this.u;
        for (e.g.a.b.a aVar : kVar.d()) {
            if (this.x.f(aVar) == null) {
                kVar.e(aVar);
            }
        }
        return kVar.d();
    }

    @Override // android.media.MediaRecorder.OnErrorListener
    public void onError(MediaRecorder mediaRecorder, int i2, int i3) {
        R();
    }

    @Override // android.media.MediaRecorder.OnInfoListener
    public void onInfo(MediaRecorder mediaRecorder, int i2, int i3) {
        if (i2 == 800 || i2 == 801) {
            R();
        }
    }

    @Override // android.hardware.Camera.PreviewCallback
    public void onPreviewFrame(byte[] bArr, Camera camera) {
        Camera.Size previewSize = this.m.getPreviewSize();
        this.a.c(bArr, previewSize.width, previewSize.height, this.F);
    }

    @Override // e.g.a.b.f
    public ArrayList<int[]> p() {
        return (ArrayList) this.m.getSupportedPreviewFpsRange();
    }

    @Override // e.g.a.b.f
    public int r() {
        return this.I;
    }

    int r0(int i2) {
        if (i2 != 90) {
            if (i2 != 180) {
                return i2 != 270 ? 1 : 3;
            }
            return 2;
        }
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float s() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean t() {
        return this.f12921k != null;
    }

    @Override // e.g.a.b.f
    public void u() {
        synchronized (this) {
            this.v = false;
            this.w = false;
            Camera camera = this.f12921k;
            if (camera != null) {
                camera.stopPreview();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void v() {
        x0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean w(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile, int i4, int i5) {
        if (!this.f12920j.get() && this.t.compareAndSet(false, true)) {
            if (i4 != 0) {
                this.G = i4;
            }
            try {
                G0(str, i2, i3, z, camcorderProfile, i5);
                this.p.prepare();
                this.p.start();
                try {
                    this.f12921k.setParameters(this.m);
                } catch (Exception e2) {
                    Log.e("CAMERA_1::", "Record setParameters failed", e2);
                }
                int r0 = r0(this.F);
                f.a aVar = this.a;
                int i6 = this.G;
                if (i6 == 0) {
                    i6 = r0;
                }
                aVar.f(str, i6, r0);
                return true;
            } catch (Exception e3) {
                this.t.set(false);
                Log.e("CAMERA_1::", "Record start failed", e3);
            }
        }
        return false;
    }

    int w0(int i2) {
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? 1 : 90;
                }
                return 270;
            }
            return CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
        }
        return 0;
    }

    @Override // e.g.a.b.f
    public void x() {
        this.f12957c.post(new d());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void y() {
        z0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean z(e.g.a.b.a aVar) {
        if (this.z != null && t()) {
            if (this.z.equals(aVar)) {
                return false;
            }
            if (this.u.f(aVar) == null) {
                Log.w("CAMERA_1::", "setAspectRatio received an unsupported value and will be ignored.");
                return false;
            }
            this.z = aVar;
            this.f12957c.post(new h());
            return true;
        }
        this.z = aVar;
        return true;
    }
}