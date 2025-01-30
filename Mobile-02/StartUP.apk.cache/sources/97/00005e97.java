package org.reactnative.camera;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.l0;
import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* loaded from: classes3.dex */
public class CameraModule extends ReactContextBaseJavaModule {
    static final int GOOGLE_VISION_BARCODE_MODE_ALTERNATE = 1;
    static final int GOOGLE_VISION_BARCODE_MODE_INVERTED = 2;
    static final int GOOGLE_VISION_BARCODE_MODE_NORMAL = 0;
    private static final String TAG = "CameraModule";
    public static final Map<String, Object> VALID_BARCODE_TYPES = Collections.unmodifiableMap(new e());
    static final int VIDEO_1080P = 1;
    static final int VIDEO_2160P = 0;
    static final int VIDEO_480P = 3;
    static final int VIDEO_4x3 = 4;
    static final int VIDEO_720P = 2;
    private org.reactnative.camera.h.d mScopedContext;

    /* loaded from: classes3.dex */
    class a implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f17592b;

        a(int i2, Promise promise) {
            this.a = i2;
            this.f17592b = promise;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                WritableArray createArray = Arguments.createArray();
                if (dVar.p()) {
                    for (e.g.a.b.a aVar : dVar.getSupportedAspectRatios()) {
                        createArray.pushString(aVar.toString());
                    }
                    this.f17592b.resolve(createArray);
                    return;
                }
                this.f17592b.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class b implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f17594b;

        b(int i2, Promise promise) {
            this.a = i2;
            this.f17594b = promise;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                WritableArray createArray = Arguments.createArray();
                for (Properties properties : ((org.reactnative.camera.d) lVar.w(this.a)).getCameraIds()) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putString("id", properties.getProperty("id"));
                    writableNativeMap.putInt("type", Integer.valueOf(properties.getProperty("type")).intValue());
                    createArray.pushMap(writableNativeMap);
                }
                this.f17594b.resolve(createArray);
            } catch (Exception e2) {
                e2.printStackTrace();
                this.f17594b.reject("E_CAMERA_FAILED", e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    class c implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17596b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f17597c;

        c(int i2, String str, Promise promise) {
            this.a = i2;
            this.f17596b = str;
            this.f17597c = promise;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                WritableArray createArray = Arguments.createArray();
                if (dVar.p()) {
                    for (e.g.a.b.j jVar : dVar.o(e.g.a.b.a.C(this.f17596b))) {
                        createArray.pushString(jVar.toString());
                    }
                    this.f17597c.resolve(createArray);
                    return;
                }
                this.f17597c.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
            } catch (Exception unused) {
                this.f17597c.reject("E_CAMERA_BAD_VIEWTAG", "getAvailablePictureSizesAsync: Expected a Camera component");
            }
        }
    }

    /* loaded from: classes3.dex */
    class d implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Promise f17599b;

        d(int i2, Promise promise) {
            this.a = i2;
            this.f17599b = promise;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                WritableArray createArray = Arguments.createArray();
                Iterator<int[]> it = ((org.reactnative.camera.d) lVar.w(this.a)).getSupportedPreviewFpsRange().iterator();
                while (it.hasNext()) {
                    int[] next = it.next();
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.putInt("MAXIMUM_FPS", next[0]);
                    writableNativeMap.putInt("MINIMUM_FPS", next[1]);
                    createArray.pushMap(writableNativeMap);
                }
                this.f17599b.resolve(createArray);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    static class e extends HashMap<String, Object> {
        e() {
            put("aztec", com.google.zxing.a.AZTEC.toString());
            put("ean13", com.google.zxing.a.EAN_13.toString());
            put("ean8", com.google.zxing.a.EAN_8.toString());
            put("qr", com.google.zxing.a.QR_CODE.toString());
            put("pdf417", com.google.zxing.a.PDF_417.toString());
            put("upc_e", com.google.zxing.a.UPC_E.toString());
            put("datamatrix", com.google.zxing.a.DATA_MATRIX.toString());
            put("code39", com.google.zxing.a.CODE_39.toString());
            put("code93", com.google.zxing.a.CODE_93.toString());
            put("interleaved2of5", com.google.zxing.a.ITF.toString());
            put("codabar", com.google.zxing.a.CODABAR.toString());
            put("code128", com.google.zxing.a.CODE_128.toString());
            put("maxicode", com.google.zxing.a.MAXICODE.toString());
            put("rss14", com.google.zxing.a.RSS_14.toString());
            put("rssexpanded", com.google.zxing.a.RSS_EXPANDED.toString());
            put("upc_a", com.google.zxing.a.UPC_A.toString());
            put("upc_ean", com.google.zxing.a.UPC_EAN_EXTENSION.toString());
        }
    }

    /* loaded from: classes3.dex */
    class f extends HashMap<String, Object> {

        /* loaded from: classes3.dex */
        class a extends HashMap<String, Object> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* renamed from: org.reactnative.camera.CameraModule$f$a$a  reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public class C0426a extends HashMap<String, Object> {
                C0426a() {
                    put("fast", Integer.valueOf(org.reactnative.facedetector.b.f17749f));
                    put("accurate", Integer.valueOf(org.reactnative.facedetector.b.f17748e));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes3.dex */
            public class b extends HashMap<String, Object> {
                b() {
                    put("all", Integer.valueOf(org.reactnative.facedetector.b.a));
                    put("none", Integer.valueOf(org.reactnative.facedetector.b.f17745b));
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* loaded from: classes3.dex */
            public class c extends HashMap<String, Object> {
                c() {
                    put("all", Integer.valueOf(org.reactnative.facedetector.b.f17746c));
                    put("none", Integer.valueOf(org.reactnative.facedetector.b.f17747d));
                }
            }

            a() {
                put("Mode", d());
                put("Landmarks", c());
                put("Classifications", b());
            }

            private Map<String, Object> b() {
                return Collections.unmodifiableMap(new b());
            }

            private Map<String, Object> c() {
                return Collections.unmodifiableMap(new c());
            }

            private Map<String, Object> d() {
                return Collections.unmodifiableMap(new C0426a());
            }
        }

        /* loaded from: classes3.dex */
        class b extends HashMap<String, Object> {
            b() {
                put("BarcodeType", k.b.a.a.f17194b);
                put("BarcodeMode", f.this.f());
            }
        }

        /* loaded from: classes3.dex */
        class c extends HashMap<String, Object> {
            c() {
                put("auto", 0);
                put("portrait", 1);
                put("portraitUpsideDown", 2);
                put("landscapeLeft", 3);
                put("landscapeRight", 4);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class d extends HashMap<String, Object> {
            d() {
                put("front", 1);
                put("back", 0);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class e extends HashMap<String, Object> {
            e() {
                put("off", 0);
                put("on", 1);
                put("auto", 3);
                put("torch", 2);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: org.reactnative.camera.CameraModule$f$f  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C0427f extends HashMap<String, Object> {
            C0427f() {
                put("on", Boolean.TRUE);
                put("off", Boolean.FALSE);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class g extends HashMap<String, Object> {
            g() {
                put("auto", 0);
                put("cloudy", 1);
                put("sunny", 2);
                put("shadow", 3);
                put("fluorescent", 4);
                put("incandescent", 5);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class h extends HashMap<String, Object> {
            h() {
                put("2160p", 0);
                put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_1080P, 1);
                put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_720P, 2);
                put(RCTCameraModule.RCT_CAMERA_CAPTURE_QUALITY_480P, 3);
                put("4:3", 4);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public class i extends HashMap<String, Object> {
            i() {
                put("NORMAL", 0);
                put("ALTERNATE", 1);
                put("INVERTED", 2);
            }
        }

        f() {
            put("Type", i());
            put("FlashMode", e());
            put("AutoFocus", c());
            put("WhiteBalance", l());
            put("VideoQuality", k());
            put("BarCodeType", d());
            put("FaceDetection", Collections.unmodifiableMap(new a()));
            put("GoogleVisionBarcodeDetection", Collections.unmodifiableMap(new b()));
            put("Orientation", Collections.unmodifiableMap(new c()));
        }

        private Map<String, Object> c() {
            return Collections.unmodifiableMap(new C0427f());
        }

        private Map<String, Object> d() {
            return CameraModule.VALID_BARCODE_TYPES;
        }

        private Map<String, Object> e() {
            return Collections.unmodifiableMap(new e());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Object> f() {
            return Collections.unmodifiableMap(new i());
        }

        private Map<String, Object> i() {
            return Collections.unmodifiableMap(new d());
        }

        private Map<String, Object> k() {
            return Collections.unmodifiableMap(new h());
        }

        private Map<String, Object> l() {
            return Collections.unmodifiableMap(new g());
        }
    }

    /* loaded from: classes3.dex */
    class g implements l0 {
        final /* synthetic */ int a;

        g(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.q();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class h implements l0 {
        final /* synthetic */ int a;

        h(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.t();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class i implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f17603b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f17604c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f17605d;

        i(int i2, ReadableMap readableMap, Promise promise, File file) {
            this.a = i2;
            this.f17603b = readableMap;
            this.f17604c = promise;
            this.f17605d = file;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
            try {
                if (dVar.p()) {
                    dVar.t0(this.f17603b, this.f17604c, this.f17605d);
                } else {
                    this.f17604c.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                }
            } catch (Exception e2) {
                this.f17604c.reject("E_TAKE_PICTURE_FAILED", e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    class j implements l0 {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f17607b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f17608c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ File f17609d;

        j(int i2, ReadableMap readableMap, Promise promise, File file) {
            this.a = i2;
            this.f17607b = readableMap;
            this.f17608c = promise;
            this.f17609d = file;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.n0(this.f17607b, this.f17608c, this.f17609d);
                } else {
                    this.f17608c.reject("E_CAMERA_UNAVAILABLE", "Camera is not running");
                }
            } catch (Exception e2) {
                this.f17608c.reject("E_CAPTURE_FAILED", e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    class k implements l0 {
        final /* synthetic */ int a;

        k(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.y();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class l implements l0 {
        final /* synthetic */ int a;

        l(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.r();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* loaded from: classes3.dex */
    class m implements l0 {
        final /* synthetic */ int a;

        m(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            try {
                org.reactnative.camera.d dVar = (org.reactnative.camera.d) lVar.w(this.a);
                if (dVar.p()) {
                    dVar.u();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public CameraModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mScopedContext = new org.reactnative.camera.h.d(reactApplicationContext);
    }

    @ReactMethod
    public void checkIfRecordAudioPermissionsAreDefined(Promise promise) {
        try {
            String[] strArr = getCurrentActivity().getPackageManager().getPackageInfo(getReactApplicationContext().getPackageName(), 4096).requestedPermissions;
            if (strArr != null) {
                for (String str : strArr) {
                    if (str.equals("android.permission.RECORD_AUDIO")) {
                        promise.resolve(Boolean.TRUE);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        promise.resolve(Boolean.FALSE);
    }

    @ReactMethod
    public void getAvailablePictureSizes(String str, int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new c(i2, str, promise));
    }

    @ReactMethod
    public void getCameraIds(int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new b(i2, promise));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return Collections.unmodifiableMap(new f());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "RNCameraModule";
    }

    public org.reactnative.camera.h.d getScopedContext() {
        return this.mScopedContext;
    }

    @ReactMethod
    public void getSupportedPreviewFpsRange(int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new d(i2, promise));
    }

    @ReactMethod
    public void getSupportedRatios(int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new a(i2, promise));
    }

    @ReactMethod
    public void pausePreview(int i2) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new g(i2));
    }

    @ReactMethod
    public void pauseRecording(int i2) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new l(i2));
    }

    @ReactMethod
    public void record(ReadableMap readableMap, int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new j(i2, readableMap, promise, this.mScopedContext.b()));
    }

    @ReactMethod
    public void resumePreview(int i2) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new h(i2));
    }

    @ReactMethod
    public void resumeRecording(int i2) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new m(i2));
    }

    @ReactMethod
    public void stopRecording(int i2) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new k(i2));
    }

    @ReactMethod
    public void takePicture(ReadableMap readableMap, int i2, Promise promise) {
        ((UIManagerModule) getReactApplicationContext().getNativeModule(UIManagerModule.class)).addUIBlock(new i(i2, readableMap, promise, this.mScopedContext.b()));
    }
}