package com.lwansbrough.RCTCamera;

import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.util.Log;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RCTCamera.java */
/* loaded from: classes2.dex */
public class a {
    private static a a;

    /* renamed from: b  reason: collision with root package name */
    private static final b f10469b = new b(853, 480);

    /* renamed from: c  reason: collision with root package name */
    private static final b f10470c = new b(1280, 720);

    /* renamed from: d  reason: collision with root package name */
    private static final b f10471d = new b(1920, 1080);

    /* renamed from: k  reason: collision with root package name */
    private int f10478k;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10475h = false;

    /* renamed from: i  reason: collision with root package name */
    private List<String> f10476i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f10477j = -1;

    /* renamed from: l  reason: collision with root package name */
    private int f10479l = 0;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Number, Camera> f10474g = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final HashMap<Integer, C0222a> f10472e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private final HashMap<Integer, Integer> f10473f = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: RCTCamera.java */
    /* renamed from: com.lwansbrough.RCTCamera.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0222a {
        public final Camera.CameraInfo a;

        /* renamed from: b  reason: collision with root package name */
        public int f10480b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f10481c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f10482d = -1;

        /* renamed from: e  reason: collision with root package name */
        public int f10483e = -1;

        /* renamed from: f  reason: collision with root package name */
        public int f10484f = -1;

        public C0222a(Camera.CameraInfo cameraInfo) {
            this.a = cameraInfo;
        }
    }

    /* compiled from: RCTCamera.java */
    /* loaded from: classes2.dex */
    private static class b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f10486b;

        public b(int i2, int i3) {
            this.a = i2;
            this.f10486b = i3;
        }
    }

    private a(int i2) {
        this.f10478k = 0;
        this.f10478k = i2;
        for (int i3 = 0; i3 < Camera.getNumberOfCameras(); i3++) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == 1 && this.f10472e.get(1) == null) {
                this.f10472e.put(1, new C0222a(cameraInfo));
                this.f10473f.put(1, Integer.valueOf(i3));
                a(1);
                q(1);
            } else if (cameraInfo.facing == 0 && this.f10472e.get(2) == null) {
                this.f10472e.put(2, new C0222a(cameraInfo));
                this.f10473f.put(2, Integer.valueOf(i3));
                a(2);
                q(2);
            }
        }
    }

    public static void d(int i2) {
        a = new a(i2);
    }

    private Camera.Size g(List<Camera.Size> list, int i2, int i3) {
        Camera.Size size = null;
        for (Camera.Size size2 : list) {
            if (size != null) {
                if (Math.sqrt(Math.pow(size2.width - i2, 2.0d) + Math.pow(size2.height - i3, 2.0d)) < Math.sqrt(Math.pow(size.width - i2, 2.0d) + Math.pow(size.height - i3, 2.0d))) {
                }
            }
            size = size2;
        }
        return size;
    }

    public static a h() {
        return a;
    }

    private Camera.Size n(List<Camera.Size> list) {
        Camera.Size size = null;
        for (Camera.Size size2 : list) {
            if (size != null) {
                if (size2.width * size2.height < size.width * size.height) {
                }
            }
            size = size2;
        }
        return size;
    }

    public void A(int i2, int i3, int i4) {
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        if (c0222a == null) {
            return;
        }
        c0222a.f10483e = i3;
        c0222a.f10484f = i4;
    }

    public void B(int i2, int i3) {
        Camera a2 = a(i2);
        if (a2 == null) {
            return;
        }
        Camera.Parameters parameters = a2.getParameters();
        String flashMode = parameters.getFlashMode();
        if (i3 == 0) {
            flashMode = "off";
        } else if (i3 == 1) {
            flashMode = "torch";
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains(flashMode)) {
            return;
        }
        parameters.setFlashMode(flashMode);
        try {
            a2.setParameters(parameters);
        } catch (RuntimeException e2) {
            Log.e("RCTCamera", "setParameters failed", e2);
        }
    }

    public void C(int i2, int i3) {
        Camera a2 = a(i2);
        if (a2 == null) {
            return;
        }
        Camera.Parameters parameters = a2.getParameters();
        int maxZoom = parameters.getMaxZoom();
        if (!parameters.isZoomSupported() || i3 < 0 || i3 >= maxZoom) {
            return;
        }
        parameters.setZoom(i3);
        try {
            a2.setParameters(parameters);
        } catch (RuntimeException e2) {
            Log.e("RCTCamera", "setParameters failed", e2);
        }
    }

    public synchronized Camera a(int i2) {
        if (this.f10474g.get(Integer.valueOf(i2)) == null && this.f10473f.get(Integer.valueOf(i2)) != null) {
            try {
                this.f10474g.put(Integer.valueOf(i2), Camera.open(this.f10473f.get(Integer.valueOf(i2)).intValue()));
                c(i2);
            } catch (Exception e2) {
                Log.e("RCTCamera", "acquireCameraInstance failed", e2);
            }
        }
        return this.f10474g.get(Integer.valueOf(i2));
    }

    public void b(int i2, int i3) {
        int i4;
        Camera camera = this.f10474g.get(Integer.valueOf(i2));
        if (camera == null) {
            return;
        }
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        Camera.CameraInfo cameraInfo = c0222a.a;
        int i5 = cameraInfo.orientation;
        if (cameraInfo.facing == 1) {
            i4 = (i5 + (i3 * 90)) % 360;
        } else {
            i4 = ((i5 - (i3 * 90)) + 360) % 360;
        }
        c0222a.f10480b = i4;
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(c0222a.f10480b);
        try {
            camera.setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(int i2) {
        int i3;
        int i4;
        Camera camera = this.f10474g.get(Integer.valueOf(i2));
        if (camera == null) {
            return;
        }
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        Camera.CameraInfo cameraInfo = c0222a.a;
        int i5 = cameraInfo.orientation;
        if (cameraInfo.facing == 1) {
            int i6 = this.f10478k;
            i3 = ((i6 * 90) + i5) % 360;
            i4 = ((720 - i5) - (i6 * 90)) % 360;
        } else {
            i3 = ((i5 - (this.f10478k * 90)) + 360) % 360;
            i4 = i3;
        }
        c0222a.f10480b = i3;
        s(i3);
        camera.setDisplayOrientation(i4);
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRotation(c0222a.f10480b);
        Camera.Size f2 = f(parameters.getSupportedPreviewSizes(), RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
        int i7 = f2.width;
        int i8 = f2.height;
        parameters.setPreviewSize(i7, i8);
        try {
            camera.setParameters(parameters);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i9 = c0222a.f10480b;
        if (i9 != 0 && i9 != 180) {
            c0222a.f10481c = i8;
            c0222a.f10482d = i7;
            return;
        }
        c0222a.f10481c = i7;
        c0222a.f10482d = i8;
    }

    public List<String> e() {
        return this.f10476i;
    }

    public Camera.Size f(List<Camera.Size> list, int i2, int i3) {
        int i4;
        Camera.Size size = null;
        for (Camera.Size size2 : list) {
            int i5 = size2.width;
            if (i5 <= i2 && (i4 = size2.height) <= i3 && (size == null || i5 * i4 > size.width * size.height)) {
                size = size2;
            }
        }
        return size;
    }

    public int i() {
        return this.f10477j;
    }

    public int j(int i2) {
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        if (c0222a == null) {
            return 0;
        }
        return c0222a.f10482d;
    }

    public int k(int i2) {
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        if (c0222a == null) {
            return 0;
        }
        return c0222a.f10484f;
    }

    public int l(int i2) {
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        if (c0222a == null) {
            return 0;
        }
        return c0222a.f10483e;
    }

    public int m(int i2) {
        C0222a c0222a = this.f10472e.get(Integer.valueOf(i2));
        if (c0222a == null) {
            return 0;
        }
        return c0222a.f10481c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Camera.Size> o(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        List<Camera.Size> supportedVideoSizes = parameters.getSupportedVideoSizes();
        return supportedVideoSizes != null ? supportedVideoSizes : parameters.getSupportedPreviewSizes();
    }

    public boolean p() {
        return this.f10475h;
    }

    public void q(int i2) {
        Camera camera = this.f10474g.get(Integer.valueOf(i2));
        if (camera != null) {
            this.f10474g.remove(Integer.valueOf(i2));
            camera.release();
        }
    }

    public void r(int i2) {
        this.f10478k = i2;
        c(1);
        c(2);
    }

    public void s(int i2) {
        this.f10479l = i2;
    }

    public void t(List<String> list) {
        this.f10476i = list;
    }

    public void u(boolean z) {
        this.f10475h = z;
    }

    public void v(int i2, int i3) {
        Camera camera = this.f10474g.get(Integer.valueOf(i2));
        if (camera == null) {
            return;
        }
        Camera.Parameters parameters = camera.getParameters();
        parameters.setRecordingHint(i3 == 1);
        try {
            camera.setParameters(parameters);
        } catch (RuntimeException e2) {
            Log.e("RCTCamera", "setParameters failed", e2);
        }
    }

    public void w(int i2, String str) {
        Camera a2 = a(i2);
        if (a2 == null) {
            return;
        }
        Camera.Parameters parameters = a2.getParameters();
        Camera.Size size = null;
        List<Camera.Size> supportedPictureSizes = parameters.getSupportedPictureSizes();
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM)) {
                    c2 = 0;
                    break;
                }
                break;
            case -318184504:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_PREVIEW)) {
                    c2 = 1;
                    break;
                }
                break;
            case 107348:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1604548:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P)) {
                    c2 = 3;
                    break;
                }
                break;
            case 1688155:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P)) {
                    c2 = 4;
                    break;
                }
                break;
            case 3202466:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH)) {
                    c2 = 5;
                    break;
                }
                break;
            case 46737913:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P)) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                size = supportedPictureSizes.get(supportedPictureSizes.size() / 2);
                break;
            case 1:
                Camera.Size f2 = f(parameters.getSupportedPreviewSizes(), RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
                size = g(parameters.getSupportedPictureSizes(), f2.width, f2.height);
                break;
            case 2:
                size = n(supportedPictureSizes);
                break;
            case 3:
                b bVar = f10469b;
                size = f(supportedPictureSizes, bVar.a, bVar.f10486b);
                break;
            case 4:
                b bVar2 = f10470c;
                size = f(supportedPictureSizes, bVar2.a, bVar2.f10486b);
                break;
            case 5:
                size = f(parameters.getSupportedPictureSizes(), RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
                break;
            case 6:
                b bVar3 = f10471d;
                size = f(supportedPictureSizes, bVar3.a, bVar3.f10486b);
                break;
        }
        if (size != null) {
            parameters.setPictureSize(size.width, size.height);
            try {
                a2.setParameters(parameters);
            } catch (RuntimeException e2) {
                Log.e("RCTCamera", "setParameters failed", e2);
            }
        }
    }

    public CamcorderProfile x(int i2, String str) {
        Camera.Size size;
        CamcorderProfile camcorderProfile;
        Camera a2 = a(i2);
        if (a2 == null) {
            return null;
        }
        List<Camera.Size> o = o(a2);
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1078030475:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_MEDIUM)) {
                    c2 = 0;
                    break;
                }
                break;
            case 107348:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_LOW)) {
                    c2 = 1;
                    break;
                }
                break;
            case 1604548:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P)) {
                    c2 = 2;
                    break;
                }
                break;
            case 1688155:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P)) {
                    c2 = 3;
                    break;
                }
                break;
            case 3202466:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_HIGH)) {
                    c2 = 4;
                    break;
                }
                break;
            case 46737913:
                if (str.equals(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P)) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                size = o.get(o.size() / 2);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 5);
                break;
            case 1:
                size = n(o);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 4);
                break;
            case 2:
                b bVar = f10469b;
                size = f(o, bVar.a, bVar.f10486b);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 4);
                break;
            case 3:
                b bVar2 = f10470c;
                size = f(o, bVar2.a, bVar2.f10486b);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 5);
                break;
            case 4:
                size = f(o, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 1);
                break;
            case 5:
                b bVar3 = f10471d;
                size = f(o, bVar3.a, bVar3.f10486b);
                camcorderProfile = CamcorderProfile.get(this.f10473f.get(Integer.valueOf(i2)).intValue(), 6);
                break;
            default:
                camcorderProfile = null;
                size = null;
                break;
        }
        if (camcorderProfile == null) {
            return null;
        }
        if (size != null) {
            camcorderProfile.videoFrameHeight = size.height;
            camcorderProfile.videoFrameWidth = size.width;
        }
        return camcorderProfile;
    }

    public void y(int i2, int i3) {
        Camera a2 = a(i2);
        if (a2 == null) {
            return;
        }
        Camera.Parameters parameters = a2.getParameters();
        String flashMode = parameters.getFlashMode();
        if (i3 == 0) {
            flashMode = "off";
        } else if (i3 == 1) {
            flashMode = "on";
        } else if (i3 == 2) {
            flashMode = "auto";
        }
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (supportedFlashModes == null || !supportedFlashModes.contains(flashMode)) {
            return;
        }
        parameters.setFlashMode(flashMode);
        try {
            a2.setParameters(parameters);
        } catch (RuntimeException e2) {
            Log.e("RCTCamera", "setParameters failed", e2);
        }
    }

    public void z(int i2) {
        if (this.f10477j == i2) {
            return;
        }
        this.f10477j = i2;
        c(1);
        c(2);
    }
}