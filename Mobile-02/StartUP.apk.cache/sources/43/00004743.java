package e.g.a.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.CamcorderProfile;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaActionSound;
import android.media.MediaRecorder;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.Size;
import android.util.SparseIntArray;
import android.view.Surface;
import com.facebook.react.bridge.ReadableMap;
import e.g.a.b.f;
import e.g.a.b.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import org.apache.http.HttpStatus;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: Camera2.java */
@TargetApi(21)
/* loaded from: classes2.dex */
class c extends e.g.a.b.f implements MediaRecorder.OnInfoListener, MediaRecorder.OnErrorListener {

    /* renamed from: d  reason: collision with root package name */
    private static final SparseIntArray f12927d;
    private boolean A;
    private final k B;
    private final k C;
    private e.g.a.b.j D;
    private int E;
    private e.g.a.b.a F;
    private e.g.a.b.a G;
    private boolean H;
    private int I;
    private float J;
    private int K;
    private int L;
    private int M;
    private float N;
    private float O;
    private int P;
    private boolean Q;
    private Boolean R;
    private Surface S;
    private Rect T;

    /* renamed from: e  reason: collision with root package name */
    private final CameraManager f12928e;

    /* renamed from: f  reason: collision with root package name */
    private final CameraDevice.StateCallback f12929f;

    /* renamed from: g  reason: collision with root package name */
    private final CameraCaptureSession.StateCallback f12930g;

    /* renamed from: h  reason: collision with root package name */
    j f12931h;

    /* renamed from: j  reason: collision with root package name */
    private final ImageReader.OnImageAvailableListener f12932j;

    /* renamed from: k  reason: collision with root package name */
    private String f12933k;

    /* renamed from: l  reason: collision with root package name */
    private String f12934l;
    private CameraCharacteristics m;
    CameraDevice n;
    MediaActionSound p;
    CameraCaptureSession q;
    CaptureRequest.Builder t;
    Set<String> u;
    private ImageReader v;
    private ImageReader w;
    private int x;
    private MediaRecorder y;
    private String z;

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class a extends CameraDevice.StateCallback {
        a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onClosed(CameraDevice cameraDevice) {
            c.this.a.a();
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            c.this.n = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i2) {
            Log.e("Camera2", "onError: " + cameraDevice.getId() + " (" + i2 + ")");
            c.this.n = null;
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            c cVar = c.this;
            cVar.n = cameraDevice;
            cVar.a.d();
            c.this.o0();
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class b extends CameraCaptureSession.StateCallback {
        b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onClosed(CameraCaptureSession cameraCaptureSession) {
            CameraCaptureSession cameraCaptureSession2 = c.this.q;
            if (cameraCaptureSession2 == null || !cameraCaptureSession2.equals(cameraCaptureSession)) {
                return;
            }
            c.this.q = null;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            Log.e("Camera2", "Failed to configure capture session.");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            c cVar = c.this;
            if (cVar.n == null) {
                return;
            }
            cVar.q = cameraCaptureSession;
            cVar.T = (Rect) cVar.t.get(CaptureRequest.SCALER_CROP_REGION);
            c.this.s0();
            c.this.t0();
            c.this.u0();
            c.this.v0();
            c.this.w0();
            try {
                c cVar2 = c.this;
                cVar2.q.setRepeatingRequest(cVar2.t.build(), c.this.f12931h, null);
            } catch (CameraAccessException e2) {
                Log.e("Camera2", "Failed to start camera preview because it couldn't access camera", e2);
            } catch (IllegalStateException e3) {
                Log.e("Camera2", "Failed to start camera preview.", e3);
            }
        }
    }

    /* compiled from: Camera2.java */
    /* renamed from: e.g.a.b.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0293c extends j {
        C0293c() {
        }

        @Override // e.g.a.b.c.j
        public void b() {
            c.this.t.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 1);
            f(3);
            try {
                c cVar = c.this;
                cVar.q.capture(cVar.t.build(), this, null);
                c.this.t.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, 0);
            } catch (CameraAccessException e2) {
                Log.e("Camera2", "Failed to run precapture sequence.", e2);
            }
        }

        @Override // e.g.a.b.c.j
        public void c() {
            c.this.X();
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class d implements ImageReader.OnImageAvailableListener {
        d() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image acquireNextImage = imageReader.acquireNextImage();
            try {
                Image.Plane[] planes = acquireNextImage.getPlanes();
                if (planes.length > 0) {
                    ByteBuffer buffer = planes[0].getBuffer();
                    byte[] bArr = new byte[buffer.remaining()];
                    buffer.get(bArr);
                    if (acquireNextImage.getFormat() != 256) {
                        c.this.a.c(bArr, acquireNextImage.getWidth(), acquireNextImage.getHeight(), c.this.L);
                    } else {
                        c.this.a.g(bArr, 0);
                    }
                    acquireNextImage.close();
                }
                acquireNextImage.close();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    if (acquireNextImage != null) {
                        try {
                            acquireNextImage.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class e extends CameraManager.AvailabilityCallback {
        e() {
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraAvailable(String str) {
            super.onCameraAvailable(str);
            c.this.u.add(str);
        }

        @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
        public void onCameraUnavailable(String str) {
            super.onCameraUnavailable(str);
            c.this.u.remove(str);
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class f implements i.a {
        f() {
        }

        @Override // e.g.a.b.i.a
        public void a() {
            c.this.Q();
        }

        @Override // e.g.a.b.i.a
        public void b() {
            c.this.o0();
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            CameraCaptureSession cameraCaptureSession = c.this.q;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                c.this.q = null;
            }
            c.this.o0();
        }
    }

    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    class h extends CameraCaptureSession.CaptureCallback {
        h() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
            if (captureRequest.getTag() == "FOCUS_TAG") {
                c.this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, null);
                try {
                    c cVar = c.this;
                    cVar.q.setRepeatingRequest(cVar.t.build(), null, null);
                } catch (CameraAccessException e2) {
                    Log.e("Camera2", "Failed to manual focus.", e2);
                }
            }
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
            super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
            Log.e("Camera2", "Manual AF failure: " + captureFailure);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    public class i extends CameraCaptureSession.CaptureCallback {
        i() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            if (c.this.f12931h.a().hasKey("pauseAfterCapture") && !c.this.f12931h.a().getBoolean("pauseAfterCapture")) {
                c.this.r0();
            }
            if (c.this.R.booleanValue()) {
                c.this.p.play(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Camera2.java */
    /* loaded from: classes2.dex */
    public static abstract class j extends CameraCaptureSession.CaptureCallback {
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private ReadableMap f12936b = null;

        j() {
        }

        private void d(CaptureResult captureResult) {
            int i2 = this.a;
            if (i2 == 1) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num == null) {
                    return;
                }
                if (num.intValue() == 4 || num.intValue() == 5) {
                    Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                    if (num2 != null && num2.intValue() != 2) {
                        f(2);
                        b();
                        return;
                    }
                    f(5);
                    c();
                }
            } else if (i2 == 3) {
                Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num3 == null || num3.intValue() == 5 || num3.intValue() == 4 || num3.intValue() == 2) {
                    f(4);
                }
            } else if (i2 != 4) {
            } else {
                Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num4 == null || num4.intValue() != 5) {
                    f(5);
                    c();
                }
            }
        }

        ReadableMap a() {
            return this.f12936b;
        }

        public abstract void b();

        public abstract void c();

        void e(ReadableMap readableMap) {
            this.f12936b = readableMap;
        }

        void f(int i2) {
            this.a = i2;
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            d(totalCaptureResult);
        }

        @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
        public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
            d(captureResult);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12927d = sparseIntArray;
        sparseIntArray.put(0, 1);
        sparseIntArray.put(1, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f.a aVar, e.g.a.b.i iVar, Context context, Handler handler) {
        super(aVar, iVar, handler);
        this.f12929f = new a();
        this.f12930g = new b();
        this.f12931h = new C0293c();
        this.f12932j = new d();
        this.p = new MediaActionSound();
        this.u = new HashSet();
        this.B = new k();
        this.C = new k();
        this.F = e.g.a.b.g.a;
        this.R = Boolean.FALSE;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        this.f12928e = cameraManager;
        cameraManager.registerAvailabilityCallback(new e(), (Handler) null);
        this.x = this.Q ? 35 : 256;
        this.f12956b.l(new f());
    }

    private MeteringRectangle W(float f2, float f3) {
        Rect rect = (Rect) this.m.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        return new MeteringRectangle(Math.max(((int) (f2 * rect.width())) - 150, 0), Math.max(((int) (f3 * rect.height())) - 150, 0), HttpStatus.SC_MULTIPLE_CHOICES, HttpStatus.SC_MULTIPLE_CHOICES, androidx.room.j.MAX_BIND_PARAMETER_CNT);
    }

    private boolean Y() {
        String str = this.f12934l;
        if (str == null) {
            try {
                int i2 = f12927d.get(this.E);
                String[] cameraIdList = this.f12928e.getCameraIdList();
                if (cameraIdList.length == 0) {
                    Log.e("Camera2", "No cameras available.");
                    return false;
                }
                for (String str2 : cameraIdList) {
                    CameraCharacteristics cameraCharacteristics = this.f12928e.getCameraCharacteristics(str2);
                    Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (num == null) {
                        Log.e("Camera2", "Unexpected state: LENS_FACING null");
                    } else if (num.intValue() == i2) {
                        this.f12933k = str2;
                        this.m = cameraCharacteristics;
                        return true;
                    }
                }
                String str3 = cameraIdList[0];
                this.f12933k = str3;
                CameraCharacteristics cameraCharacteristics2 = this.f12928e.getCameraCharacteristics(str3);
                this.m = cameraCharacteristics2;
                Integer num2 = (Integer) cameraCharacteristics2.get(CameraCharacteristics.LENS_FACING);
                if (num2 == null) {
                    Log.e("Camera2", "Unexpected state: LENS_FACING null");
                    return false;
                }
                int size = f12927d.size();
                for (int i3 = 0; i3 < size; i3++) {
                    SparseIntArray sparseIntArray = f12927d;
                    if (sparseIntArray.valueAt(i3) == num2.intValue()) {
                        this.E = sparseIntArray.keyAt(i3);
                        return true;
                    }
                }
                this.E = 0;
                return true;
            } catch (CameraAccessException e2) {
                Log.e("Camera2", "Failed to get a list of camera devices", e2);
                return false;
            }
        }
        try {
            CameraCharacteristics cameraCharacteristics3 = this.f12928e.getCameraCharacteristics(str);
            this.m = cameraCharacteristics3;
            Integer num3 = (Integer) cameraCharacteristics3.get(CameraCharacteristics.LENS_FACING);
            if (num3 == null) {
                Log.e("Camera2", "Unexpected state: LENS_FACING null");
                return false;
            }
            int size2 = f12927d.size();
            int i4 = 0;
            while (true) {
                if (i4 >= size2) {
                    break;
                }
                SparseIntArray sparseIntArray2 = f12927d;
                if (sparseIntArray2.valueAt(i4) == num3.intValue()) {
                    this.E = sparseIntArray2.keyAt(i4);
                    break;
                }
                i4++;
            }
            this.f12933k = this.f12934l;
            return true;
        } catch (Exception e3) {
            Log.e("Camera2", "Failed to get camera characteristics", e3);
            return false;
        }
    }

    private e.g.a.b.j Z() {
        int i2 = this.f12956b.i();
        int c2 = this.f12956b.c();
        if (i2 < c2) {
            c2 = i2;
            i2 = c2;
        }
        SortedSet<e.g.a.b.j> f2 = this.B.f(this.F);
        for (e.g.a.b.j jVar : f2) {
            if (jVar.getWidth() >= i2 && jVar.getHeight() >= c2) {
                return jVar;
            }
        }
        return f2.last();
    }

    private void a0() {
        Size[] outputSizes;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.m.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            this.B.b();
            for (Size size : streamConfigurationMap.getOutputSizes(this.f12956b.d())) {
                int width = size.getWidth();
                int height = size.getHeight();
                if (width <= 1920 && height <= 1080) {
                    this.B.a(new e.g.a.b.j(width, height));
                }
            }
            this.C.b();
            b0(this.C, streamConfigurationMap);
            if (this.D == null) {
                this.D = this.C.f(this.F).last();
            }
            for (e.g.a.b.a aVar : this.B.d()) {
                if (!this.C.d().contains(aVar)) {
                    this.B.e(aVar);
                }
            }
            if (!this.B.d().contains(this.F)) {
                this.F = this.B.d().iterator().next();
            }
            this.K = ((Integer) this.m.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
            return;
        }
        throw new IllegalStateException("Failed to get configuration map: " + this.f12933k);
    }

    private int c0() {
        int intValue = ((Integer) this.m.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        if (this.E == 0) {
            return (intValue + this.M) % 360;
        }
        return ((intValue + this.M) + (e0(this.M) ? CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 : 0)) % 360;
    }

    private boolean e0(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static boolean f0(Context context) {
        try {
            CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
            for (String str : cameraManager.getCameraIdList()) {
                Integer num = (Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
                int i2 = (num == null || num.intValue() == 2) ? 0 : i2 + 1;
                Log.w("Camera2", "Camera2 can only run in legacy mode and should not be used.");
                return true;
            }
            return false;
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Failed to check camera legacy status, returning true.", e2);
            return true;
        }
    }

    private boolean g0() {
        return ((Integer) this.m.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF)).intValue() >= 1;
    }

    private void h0() {
        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        try {
            this.f12931h.f(1);
            this.q.capture(this.t.build(), this.f12931h, null);
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Failed to lock focus.", e2);
        }
    }

    private void i0() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.y.pause();
        }
    }

    private void j0() {
        ImageReader imageReader = this.w;
        if (imageReader != null) {
            imageReader.close();
        }
        e.g.a.b.j last = this.B.f(this.F).last();
        ImageReader newInstance = ImageReader.newInstance(last.getWidth(), last.getHeight(), 35, 1);
        this.w = newInstance;
        newInstance.setOnImageAvailableListener(this.f12932j, null);
    }

    private void k0() {
        ImageReader imageReader = this.v;
        if (imageReader != null) {
            imageReader.close();
        }
        ImageReader newInstance = ImageReader.newInstance(this.D.getWidth(), this.D.getHeight(), 256, 1);
        this.v = newInstance;
        newInstance.setOnImageAvailableListener(this.f12932j, null);
    }

    private void l0() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.y.resume();
        }
    }

    private void m0(CamcorderProfile camcorderProfile, boolean z) {
        this.y.setOutputFormat(camcorderProfile.fileFormat);
        this.y.setVideoFrameRate(camcorderProfile.videoFrameRate);
        this.y.setVideoSize(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight);
        this.y.setVideoEncodingBitRate(camcorderProfile.videoBitRate);
        this.y.setVideoEncoder(camcorderProfile.videoCodec);
        if (z) {
            this.y.setAudioEncodingBitRate(camcorderProfile.audioBitRate);
            this.y.setAudioChannels(camcorderProfile.audioChannels);
            this.y.setAudioSamplingRate(camcorderProfile.audioSampleRate);
            this.y.setAudioEncoder(camcorderProfile.audioCodec);
        }
    }

    private void n0(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile) {
        MediaRecorder mediaRecorder = new MediaRecorder();
        this.y = mediaRecorder;
        mediaRecorder.setVideoSource(2);
        if (z) {
            this.y.setAudioSource(1);
        }
        this.y.setOutputFile(str);
        this.z = str;
        CamcorderProfile camcorderProfile2 = !CamcorderProfile.hasProfile(Integer.parseInt(this.f12933k), camcorderProfile.quality) ? CamcorderProfile.get(1) : camcorderProfile;
        camcorderProfile2.videoBitRate = camcorderProfile.videoBitRate;
        m0(camcorderProfile2, z);
        this.y.setOrientationHint(c0());
        if (i2 != -1) {
            this.y.setMaxDuration(i2);
        }
        if (i3 != -1) {
            this.y.setMaxFileSize(i3);
        }
        this.y.setOnInfoListener(this);
        this.y.setOnErrorListener(this);
    }

    private void p0() {
        try {
            this.f12928e.openCamera(this.f12933k, this.f12929f, (Handler) null);
        } catch (CameraAccessException e2) {
            throw new RuntimeException("Failed to open camera: " + this.f12933k, e2);
        }
    }

    private void q0() {
        this.A = false;
        try {
            this.q.stopRepeating();
            this.q.abortCaptures();
            this.y.stop();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.y.reset();
        this.y.release();
        this.y = null;
        this.a.b();
        if (this.z != null && new File(this.z).exists()) {
            this.a.h(this.z, 0, 0);
            this.z = null;
            return;
        }
        this.a.h(null, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void A(boolean z) {
        if (this.H == z) {
            return;
        }
        this.H = z;
        if (this.t != null) {
            s0();
            CameraCaptureSession cameraCaptureSession = this.q;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.t.build(), this.f12931h, null);
                } catch (CameraAccessException unused) {
                    this.H = !this.H;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void B(String str) {
        if (org.reactnative.camera.h.b.a(this.f12934l, str)) {
            return;
        }
        this.f12934l = str;
        if (org.reactnative.camera.h.b.a(str, this.f12933k) || !t()) {
            return;
        }
        Q();
        P();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void C(int i2) {
        this.M = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void D(int i2) {
        this.L = i2;
        this.f12956b.m(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void E(float f2) {
        Log.e("CAMERA_2:: ", "Adjusting exposure is not currently supported for Camera2");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void F(int i2) {
        if (this.E == i2) {
            return;
        }
        this.E = i2;
        if (t()) {
            Q();
            P();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void G(int i2) {
        int i3 = this.I;
        if (i3 == i2) {
            return;
        }
        this.I = i2;
        if (this.t != null) {
            t0();
            CameraCaptureSession cameraCaptureSession = this.q;
            if (cameraCaptureSession != null) {
                try {
                    cameraCaptureSession.setRepeatingRequest(this.t.build(), this.f12931h, null);
                } catch (CameraAccessException unused) {
                    this.I = i3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void H(float f2, float f3) {
        if (this.q == null) {
            return;
        }
        h hVar = new h();
        try {
            this.q.stopRepeating();
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Failed to manual focus.", e2);
        }
        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        this.t.set(CaptureRequest.CONTROL_AF_MODE, 0);
        try {
            this.q.capture(this.t.build(), hVar, null);
        } catch (CameraAccessException e3) {
            Log.e("Camera2", "Failed to manual focus.", e3);
        }
        if (g0()) {
            this.t.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{W(f2, f3)});
        }
        this.t.set(CaptureRequest.CONTROL_MODE, 1);
        this.t.set(CaptureRequest.CONTROL_AF_MODE, 1);
        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
        this.t.setTag("FOCUS_TAG");
        try {
            this.q.capture(this.t.build(), hVar, null);
        } catch (CameraAccessException e4) {
            Log.e("Camera2", "Failed to manual focus.", e4);
        }
    }

    @Override // e.g.a.b.f
    public void I(float f2) {
        float f3 = this.N;
        if (f3 == f2) {
            return;
        }
        this.N = f2;
        if (this.q != null) {
            u0();
            try {
                this.q.setRepeatingRequest(this.t.build(), this.f12931h, null);
            } catch (CameraAccessException unused) {
                this.N = f3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void J(e.g.a.b.j jVar) {
        CameraCaptureSession cameraCaptureSession = this.q;
        if (cameraCaptureSession != null) {
            try {
                cameraCaptureSession.stopRepeating();
            } catch (CameraAccessException e2) {
                e2.printStackTrace();
            }
            this.q.close();
            this.q = null;
        }
        ImageReader imageReader = this.v;
        if (imageReader != null) {
            imageReader.close();
        }
        if (jVar == null) {
            e.g.a.b.a aVar = this.F;
            if (aVar == null || this.D == null) {
                return;
            }
            this.C.f(aVar).last();
        } else {
            this.D = jVar;
        }
        k0();
        o0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void K(boolean z) {
        this.R = Boolean.valueOf(z);
    }

    @Override // e.g.a.b.f
    public void L(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.S = new Surface(surfaceTexture);
        } else {
            this.S = null;
        }
        new Handler(Looper.getMainLooper()).post(new g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void M(boolean z) {
        if (this.Q == z) {
            return;
        }
        this.Q = z;
        if (!z) {
            this.x = 256;
        } else {
            this.x = 35;
        }
        CameraCaptureSession cameraCaptureSession = this.q;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.q = null;
        }
        o0();
    }

    @Override // e.g.a.b.f
    public void N(int i2) {
        int i3 = this.P;
        if (i3 == i2) {
            return;
        }
        this.P = i2;
        if (this.q != null) {
            v0();
            try {
                this.q.setRepeatingRequest(this.t.build(), this.f12931h, null);
            } catch (CameraAccessException unused) {
                this.P = i3;
            }
        }
    }

    @Override // e.g.a.b.f
    public void O(float f2) {
        float f3 = this.O;
        if (f3 == f2) {
            return;
        }
        this.O = f2;
        if (this.q != null) {
            w0();
            try {
                this.q.setRepeatingRequest(this.t.build(), this.f12931h, null);
            } catch (CameraAccessException unused) {
                this.O = f3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean P() {
        if (!Y()) {
            this.F = this.G;
            this.a.e();
            return false;
        }
        a0();
        z(this.G);
        this.G = null;
        k0();
        j0();
        p0();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void Q() {
        CameraCaptureSession cameraCaptureSession = this.q;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.q = null;
        }
        CameraDevice cameraDevice = this.n;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.n = null;
        }
        ImageReader imageReader = this.v;
        if (imageReader != null) {
            imageReader.close();
            this.v = null;
        }
        ImageReader imageReader2 = this.w;
        if (imageReader2 != null) {
            imageReader2.close();
            this.w = null;
        }
        MediaRecorder mediaRecorder = this.y;
        if (mediaRecorder != null) {
            mediaRecorder.stop();
            this.y.reset();
            this.y.release();
            this.y = null;
            if (this.A) {
                this.a.b();
                this.a.h(this.z, 0, 0);
                this.A = false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void R() {
        if (this.A) {
            q0();
            CameraCaptureSession cameraCaptureSession = this.q;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.q = null;
            }
            o0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void S(ReadableMap readableMap) {
        this.f12931h.e(readableMap);
        if (this.H) {
            h0();
        } else {
            X();
        }
    }

    void X() {
        try {
            CaptureRequest.Builder createCaptureRequest = this.n.createCaptureRequest(2);
            if (this.Q) {
                this.x = 256;
                createCaptureRequest.removeTarget(this.w.getSurface());
            }
            createCaptureRequest.addTarget(this.v.getSurface());
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_MODE;
            createCaptureRequest.set(key, this.t.get(key));
            int i2 = this.I;
            if (i2 == 0) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, 0);
            } else if (i2 == 1) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 3);
            } else if (i2 == 2) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 1);
                createCaptureRequest.set(CaptureRequest.FLASH_MODE, 2);
            } else if (i2 == 3) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 2);
            } else if (i2 == 4) {
                createCaptureRequest.set(CaptureRequest.CONTROL_AE_MODE, 2);
            }
            createCaptureRequest.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(c0()));
            if (this.f12931h.a().hasKey("quality")) {
                createCaptureRequest.set(CaptureRequest.JPEG_QUALITY, Byte.valueOf((byte) (this.f12931h.a().getDouble("quality") * 100.0d)));
            }
            CaptureRequest.Key key2 = CaptureRequest.SCALER_CROP_REGION;
            createCaptureRequest.set(key2, this.t.get(key2));
            this.q.stopRepeating();
            this.q.capture(createCaptureRequest.build(), new i(), null);
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Cannot capture a still picture.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public e.g.a.b.a a() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean b() {
        return this.H;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b0(k kVar, StreamConfigurationMap streamConfigurationMap) {
        Size[] outputSizes;
        for (Size size : streamConfigurationMap.getOutputSizes(this.x)) {
            this.C.a(new e.g.a.b.j(size.getWidth(), size.getHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public SortedSet<e.g.a.b.j> c(e.g.a.b.a aVar) {
        return this.C.f(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public String d() {
        return this.f12934l;
    }

    public Surface d0() {
        Surface surface = this.S;
        return surface != null ? surface : this.f12956b.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public List<Properties> e() {
        String[] cameraIdList;
        try {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f12928e.getCameraIdList()) {
                Properties properties = new Properties();
                properties.put("id", str);
                properties.put("type", String.valueOf(((Integer) this.f12928e.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue() == 0 ? 1 : 0));
                arrayList.add(properties);
            }
            return arrayList;
        } catch (CameraAccessException e2) {
            throw new RuntimeException("Failed to get a list of camera ids", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int f() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float g() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int h() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public int i() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float j() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public e.g.a.b.j k() {
        return this.D;
    }

    @Override // e.g.a.b.f
    public boolean l() {
        return this.R.booleanValue();
    }

    @Override // e.g.a.b.f
    public e.g.a.b.j m() {
        return new e.g.a.b.j(this.f12956b.i(), this.f12956b.c());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean n() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public Set<e.g.a.b.a> o() {
        return this.B.d();
    }

    void o0() {
        if (!t() || !this.f12956b.j() || this.v == null || this.w == null) {
            return;
        }
        e.g.a.b.j Z = Z();
        this.f12956b.k(Z.getWidth(), Z.getHeight());
        Surface d0 = d0();
        try {
            CaptureRequest.Builder createCaptureRequest = this.n.createCaptureRequest(1);
            this.t = createCaptureRequest;
            createCaptureRequest.addTarget(d0);
            if (this.Q) {
                this.t.addTarget(this.w.getSurface());
            }
            this.n.createCaptureSession(Arrays.asList(d0, this.v.getSurface(), this.w.getSurface()), this.f12930g, null);
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Failed to start capture session", e2);
            this.a.e();
        }
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

    @Override // e.g.a.b.f
    public ArrayList<int[]> p() {
        Log.e("CAMERA_2:: ", "getSupportedPreviewFpsRange is not currently supported for Camera2");
        return new ArrayList<>();
    }

    @Override // e.g.a.b.f
    public int r() {
        return this.P;
    }

    void r0() {
        this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 2);
        try {
            this.q.capture(this.t.build(), this.f12931h, null);
            s0();
            t0();
            if (this.Q) {
                this.x = 35;
                o0();
            } else {
                this.t.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
                this.q.setRepeatingRequest(this.t.build(), this.f12931h, null);
                this.f12931h.f(0);
            }
        } catch (CameraAccessException e2) {
            Log.e("Camera2", "Failed to restart camera preview.", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public float s() {
        return this.O;
    }

    void s0() {
        if (!this.H) {
            this.t.set(CaptureRequest.CONTROL_AF_MODE, 0);
            return;
        }
        int[] iArr = (int[]) this.m.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr != null && iArr.length != 0 && (iArr.length != 1 || iArr[0] != 0)) {
            this.t.set(CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        this.H = false;
        this.t.set(CaptureRequest.CONTROL_AF_MODE, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean t() {
        return this.n != null;
    }

    void t0() {
        int i2 = this.I;
        if (i2 == 0) {
            this.t.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.t.set(CaptureRequest.FLASH_MODE, 0);
        } else if (i2 == 1) {
            this.t.set(CaptureRequest.CONTROL_AE_MODE, 3);
            this.t.set(CaptureRequest.FLASH_MODE, 0);
        } else if (i2 == 2) {
            this.t.set(CaptureRequest.CONTROL_AE_MODE, 1);
            this.t.set(CaptureRequest.FLASH_MODE, 2);
        } else if (i2 == 3) {
            this.t.set(CaptureRequest.CONTROL_AE_MODE, 2);
            this.t.set(CaptureRequest.FLASH_MODE, 0);
        } else if (i2 != 4) {
        } else {
            this.t.set(CaptureRequest.CONTROL_AE_MODE, 4);
            this.t.set(CaptureRequest.FLASH_MODE, 0);
        }
    }

    @Override // e.g.a.b.f
    public void u() {
        try {
            this.q.stopRepeating();
        } catch (CameraAccessException e2) {
            e2.printStackTrace();
        }
    }

    void u0() {
        if (this.H) {
            return;
        }
        Float f2 = (Float) this.m.get(CameraCharacteristics.LENS_INFO_MINIMUM_FOCUS_DISTANCE);
        Objects.requireNonNull(f2, "Unexpected state: LENS_INFO_MINIMUM_FOCUS_DISTANCE null");
        this.t.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(this.N * f2.floatValue()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void v() {
        i0();
    }

    void v0() {
        int i2 = this.P;
        if (i2 == 0) {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        } else if (i2 == 1) {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 6);
        } else if (i2 == 2) {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 5);
        } else if (i2 == 3) {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 8);
        } else if (i2 == 4) {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 3);
        } else if (i2 != 5) {
        } else {
            this.t.set(CaptureRequest.CONTROL_AWB_MODE, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean w(String str, int i2, int i3, boolean z, CamcorderProfile camcorderProfile, int i4, int i5) {
        if (!this.A) {
            n0(str, i2, i3, z, camcorderProfile);
            try {
                this.y.prepare();
                CameraCaptureSession cameraCaptureSession = this.q;
                if (cameraCaptureSession != null) {
                    cameraCaptureSession.close();
                    this.q = null;
                }
                e.g.a.b.j Z = Z();
                this.f12956b.k(Z.getWidth(), Z.getHeight());
                Surface d0 = d0();
                Surface surface = this.y.getSurface();
                CaptureRequest.Builder createCaptureRequest = this.n.createCaptureRequest(3);
                this.t = createCaptureRequest;
                createCaptureRequest.addTarget(d0);
                this.t.addTarget(surface);
                this.n.createCaptureSession(Arrays.asList(d0, surface), this.f12930g, null);
                this.y.start();
                this.A = true;
                this.a.f(this.z, 0, 0);
                return true;
            } catch (CameraAccessException | IOException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    void w0() {
        float floatValue = (this.O * (((Float) this.m.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM)).floatValue() - 1.0f)) + 1.0f;
        Rect rect = (Rect) this.m.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (rect != null) {
            int width = rect.width();
            int height = rect.height();
            int i2 = (width - ((int) (width / floatValue))) / 2;
            int i3 = (height - ((int) (height / floatValue))) / 2;
            Rect rect2 = new Rect(rect.left + i2, rect.top + i3, rect.right - i2, rect.bottom - i3);
            if (floatValue != 1.0f) {
                this.t.set(CaptureRequest.SCALER_CROP_REGION, rect2);
            } else {
                this.t.set(CaptureRequest.SCALER_CROP_REGION, this.T);
            }
        }
    }

    @Override // e.g.a.b.f
    public void x() {
        r0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public void y() {
        l0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // e.g.a.b.f
    public boolean z(e.g.a.b.a aVar) {
        if (aVar != null && this.B.c()) {
            this.G = aVar;
            return false;
        } else if (aVar == null || aVar.equals(this.F) || !this.B.d().contains(aVar)) {
            return false;
        } else {
            this.F = aVar;
            k0();
            j0();
            CameraCaptureSession cameraCaptureSession = this.q;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.q = null;
                o0();
                return true;
            }
            return true;
        }
    }
}