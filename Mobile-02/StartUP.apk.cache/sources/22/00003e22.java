package com.journeyapps.barcodescanner.q;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.journeyapps.barcodescanner.n;
import com.journeyapps.barcodescanner.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: CameraManager.java */
/* loaded from: classes2.dex */
public final class c {
    private static final String a = "c";

    /* renamed from: b  reason: collision with root package name */
    private Camera f10415b;

    /* renamed from: c  reason: collision with root package name */
    private Camera.CameraInfo f10416c;

    /* renamed from: d  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.a f10417d;

    /* renamed from: e  reason: collision with root package name */
    private com.google.zxing.p.a.a f10418e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10419f;

    /* renamed from: g  reason: collision with root package name */
    private String f10420g;

    /* renamed from: i  reason: collision with root package name */
    private h f10422i;

    /* renamed from: j  reason: collision with root package name */
    private n f10423j;

    /* renamed from: k  reason: collision with root package name */
    private n f10424k;
    private Context m;

    /* renamed from: h  reason: collision with root package name */
    private d f10421h = new d();

    /* renamed from: l  reason: collision with root package name */
    private int f10425l = -1;
    private final a n = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CameraManager.java */
    /* loaded from: classes2.dex */
    public final class a implements Camera.PreviewCallback {
        private k a;

        /* renamed from: b  reason: collision with root package name */
        private n f10426b;

        public a() {
        }

        public void a(k kVar) {
            this.a = kVar;
        }

        public void b(n nVar) {
            this.f10426b = nVar;
        }

        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            n nVar = this.f10426b;
            k kVar = this.a;
            if (nVar == null || kVar == null) {
                Log.d(c.a, "Got preview callback, but no handler or resolution available");
                if (kVar != null) {
                    kVar.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr != null) {
                    kVar.b(new o(bArr, nVar.a, nVar.f10387b, camera.getParameters().getPreviewFormat(), c.this.e()));
                    return;
                }
                throw new NullPointerException("No preview data received");
            } catch (RuntimeException e2) {
                Log.e(c.a, "Camera preview failed", e2);
                kVar.a(e2);
            }
        }
    }

    public c(Context context) {
        this.m = context;
    }

    private int b() {
        int i2;
        int c2 = this.f10422i.c();
        int i3 = 0;
        if (c2 != 0) {
            if (c2 == 1) {
                i3 = 90;
            } else if (c2 == 2) {
                i3 = CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256;
            } else if (c2 == 3) {
                i3 = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f10416c;
        if (cameraInfo.facing == 1) {
            i2 = (360 - ((cameraInfo.orientation + i3) % 360)) % 360;
        } else {
            i2 = ((cameraInfo.orientation - i3) + 360) % 360;
        }
        String str = a;
        Log.i(str, "Camera Display Orientation: " + i2);
        return i2;
    }

    private Camera.Parameters f() {
        Camera.Parameters parameters = this.f10415b.getParameters();
        String str = this.f10420g;
        if (str == null) {
            this.f10420g = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    private static List<n> h(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                arrayList.add(new n(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new n(size.width, size.height));
        }
        return arrayList;
    }

    private void m(int i2) {
        this.f10415b.setDisplayOrientation(i2);
    }

    private void o(boolean z) {
        Camera.Parameters f2 = f();
        if (f2 == null) {
            Log.w(a, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = a;
        Log.i(str, "Initial camera parameters: " + f2.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        com.google.zxing.p.a.l.a.g(f2, this.f10421h.a(), z);
        if (!z) {
            com.google.zxing.p.a.l.a.k(f2, false);
            if (this.f10421h.h()) {
                com.google.zxing.p.a.l.a.i(f2);
            }
            if (this.f10421h.e()) {
                com.google.zxing.p.a.l.a.c(f2);
            }
            if (this.f10421h.g() && Build.VERSION.SDK_INT >= 15) {
                com.google.zxing.p.a.l.a.l(f2);
                com.google.zxing.p.a.l.a.h(f2);
                com.google.zxing.p.a.l.a.j(f2);
            }
        }
        List<n> h2 = h(f2);
        if (h2.size() == 0) {
            this.f10423j = null;
        } else {
            n a2 = this.f10422i.a(h2, i());
            this.f10423j = a2;
            f2.setPreviewSize(a2.a, a2.f10387b);
        }
        if (Build.DEVICE.equals("glass-1")) {
            com.google.zxing.p.a.l.a.e(f2);
        }
        Log.i(str, "Final camera parameters: " + f2.flatten());
        this.f10415b.setParameters(f2);
    }

    private void q() {
        try {
            int b2 = b();
            this.f10425l = b2;
            m(b2);
        } catch (Exception unused) {
            Log.w(a, "Failed to set rotation.");
        }
        try {
            o(false);
        } catch (Exception unused2) {
            try {
                o(true);
            } catch (Exception unused3) {
                Log.w(a, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f10415b.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f10424k = this.f10423j;
        } else {
            this.f10424k = new n(previewSize.width, previewSize.height);
        }
        this.n.b(this.f10424k);
    }

    public void c() {
        Camera camera = this.f10415b;
        if (camera != null) {
            camera.release();
            this.f10415b = null;
        }
    }

    public void d() {
        if (this.f10415b != null) {
            q();
            return;
        }
        throw new RuntimeException("Camera not open");
    }

    public int e() {
        return this.f10425l;
    }

    public n g() {
        if (this.f10424k == null) {
            return null;
        }
        if (i()) {
            return this.f10424k.n();
        }
        return this.f10424k;
    }

    public boolean i() {
        int i2 = this.f10425l;
        if (i2 != -1) {
            return i2 % CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean j() {
        String flashMode;
        Camera.Parameters parameters = this.f10415b.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void k() {
        Camera b2 = com.google.zxing.p.a.l.b.a.b(this.f10421h.b());
        this.f10415b = b2;
        if (b2 != null) {
            int a2 = com.google.zxing.p.a.l.b.a.a(this.f10421h.b());
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            this.f10416c = cameraInfo;
            Camera.getCameraInfo(a2, cameraInfo);
            return;
        }
        throw new RuntimeException("Failed to open camera");
    }

    public void l(k kVar) {
        Camera camera = this.f10415b;
        if (camera == null || !this.f10419f) {
            return;
        }
        this.n.a(kVar);
        camera.setOneShotPreviewCallback(this.n);
    }

    public void n(d dVar) {
        this.f10421h = dVar;
    }

    public void p(h hVar) {
        this.f10422i = hVar;
    }

    public void r(e eVar) throws IOException {
        eVar.a(this.f10415b);
    }

    public void s(boolean z) {
        if (this.f10415b != null) {
            try {
                if (z != j()) {
                    com.journeyapps.barcodescanner.q.a aVar = this.f10417d;
                    if (aVar != null) {
                        aVar.j();
                    }
                    Camera.Parameters parameters = this.f10415b.getParameters();
                    com.google.zxing.p.a.l.a.k(parameters, z);
                    if (this.f10421h.f()) {
                        com.google.zxing.p.a.l.a.d(parameters, z);
                    }
                    this.f10415b.setParameters(parameters);
                    com.journeyapps.barcodescanner.q.a aVar2 = this.f10417d;
                    if (aVar2 != null) {
                        aVar2.i();
                    }
                }
            } catch (RuntimeException e2) {
                Log.e(a, "Failed to set torch", e2);
            }
        }
    }

    public void t() {
        Camera camera = this.f10415b;
        if (camera == null || this.f10419f) {
            return;
        }
        camera.startPreview();
        this.f10419f = true;
        this.f10417d = new com.journeyapps.barcodescanner.q.a(this.f10415b, this.f10421h);
        com.google.zxing.p.a.a aVar = new com.google.zxing.p.a.a(this.m, this, this.f10421h);
        this.f10418e = aVar;
        aVar.c();
    }

    public void u() {
        com.journeyapps.barcodescanner.q.a aVar = this.f10417d;
        if (aVar != null) {
            aVar.j();
            this.f10417d = null;
        }
        com.google.zxing.p.a.a aVar2 = this.f10418e;
        if (aVar2 != null) {
            aVar2.d();
            this.f10418e = null;
        }
        Camera camera = this.f10415b;
        if (camera == null || !this.f10419f) {
            return;
        }
        camera.stopPreview();
        this.n.a(null);
        this.f10419f = false;
    }
}