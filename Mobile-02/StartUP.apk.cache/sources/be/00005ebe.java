package org.reactnative.camera;

import android.media.CamcorderProfile;
import android.os.Build;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerModule;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: RNCameraViewHelper.java */
/* loaded from: classes3.dex */
public class e {
    public static final String[][] a = {new String[]{"string", "Artist"}, new String[]{"int", "BitsPerSample"}, new String[]{"int", "Compression"}, new String[]{"string", "Copyright"}, new String[]{"string", "DateTime"}, new String[]{"string", "ImageDescription"}, new String[]{"int", "ImageLength"}, new String[]{"int", "ImageWidth"}, new String[]{"int", "JPEGInterchangeFormat"}, new String[]{"int", "JPEGInterchangeFormatLength"}, new String[]{"string", "Make"}, new String[]{"string", "Model"}, new String[]{"int", "Orientation"}, new String[]{"int", "PhotometricInterpretation"}, new String[]{"int", "PlanarConfiguration"}, new String[]{"double", "PrimaryChromaticities"}, new String[]{"double", "ReferenceBlackWhite"}, new String[]{"int", "ResolutionUnit"}, new String[]{"int", "RowsPerStrip"}, new String[]{"int", "SamplesPerPixel"}, new String[]{"string", "Software"}, new String[]{"int", "StripByteCounts"}, new String[]{"int", "StripOffsets"}, new String[]{"int", "TransferFunction"}, new String[]{"double", "WhitePoint"}, new String[]{"double", "XResolution"}, new String[]{"double", "YCbCrCoefficients"}, new String[]{"int", "YCbCrPositioning"}, new String[]{"int", "YCbCrSubSampling"}, new String[]{"double", "YResolution"}, new String[]{"double", "ApertureValue"}, new String[]{"double", "BrightnessValue"}, new String[]{"string", "CFAPattern"}, new String[]{"int", "ColorSpace"}, new String[]{"string", "ComponentsConfiguration"}, new String[]{"double", "CompressedBitsPerPixel"}, new String[]{"int", "Contrast"}, new String[]{"int", "CustomRendered"}, new String[]{"string", "DateTimeDigitized"}, new String[]{"string", "DateTimeOriginal"}, new String[]{"string", "DeviceSettingDescription"}, new String[]{"double", "DigitalZoomRatio"}, new String[]{"string", "ExifVersion"}, new String[]{"double", "ExposureBiasValue"}, new String[]{"double", "ExposureIndex"}, new String[]{"int", "ExposureMode"}, new String[]{"int", "ExposureProgram"}, new String[]{"double", "ExposureTime"}, new String[]{"double", "FNumber"}, new String[]{"string", "FileSource"}, new String[]{"int", "Flash"}, new String[]{"double", "FlashEnergy"}, new String[]{"string", "FlashpixVersion"}, new String[]{"double", "FocalLength"}, new String[]{"int", "FocalLengthIn35mmFilm"}, new String[]{"int", "FocalPlaneResolutionUnit"}, new String[]{"double", "FocalPlaneXResolution"}, new String[]{"double", "FocalPlaneYResolution"}, new String[]{"int", "GainControl"}, new String[]{"int", "ISOSpeedRatings"}, new String[]{"string", "ImageUniqueID"}, new String[]{"int", "LightSource"}, new String[]{"string", "MakerNote"}, new String[]{"double", "MaxApertureValue"}, new String[]{"int", "MeteringMode"}, new String[]{"int", "NewSubfileType"}, new String[]{"string", "OECF"}, new String[]{"int", "PixelXDimension"}, new String[]{"int", "PixelYDimension"}, new String[]{"string", "RelatedSoundFile"}, new String[]{"int", "Saturation"}, new String[]{"int", "SceneCaptureType"}, new String[]{"string", "SceneType"}, new String[]{"int", "SensingMethod"}, new String[]{"int", "Sharpness"}, new String[]{"double", "ShutterSpeedValue"}, new String[]{"string", "SpatialFrequencyResponse"}, new String[]{"string", "SpectralSensitivity"}, new String[]{"int", "SubfileType"}, new String[]{"string", "SubSecTime"}, new String[]{"string", "SubSecTimeDigitized"}, new String[]{"string", "SubSecTimeOriginal"}, new String[]{"int", "SubjectArea"}, new String[]{"double", "SubjectDistance"}, new String[]{"int", "SubjectDistanceRange"}, new String[]{"int", "SubjectLocation"}, new String[]{"string", "UserComment"}, new String[]{"int", "WhiteBalance"}, new String[]{"int", "GPSAltitudeRef"}, new String[]{"string", "GPSAreaInformation"}, new String[]{"double", "GPSDOP"}, new String[]{"string", "GPSDateStamp"}, new String[]{"double", "GPSDestBearing"}, new String[]{"string", "GPSDestBearingRef"}, new String[]{"double", "GPSDestDistance"}, new String[]{"string", "GPSDestDistanceRef"}, new String[]{"double", "GPSDestLatitude"}, new String[]{"string", "GPSDestLatitudeRef"}, new String[]{"double", "GPSDestLongitude"}, new String[]{"string", "GPSDestLongitudeRef"}, new String[]{"int", "GPSDifferential"}, new String[]{"double", "GPSImgDirection"}, new String[]{"string", "GPSImgDirectionRef"}, new String[]{"string", "GPSLatitudeRef"}, new String[]{"string", "GPSLongitudeRef"}, new String[]{"string", "GPSMapDatum"}, new String[]{"string", "GPSMeasureMode"}, new String[]{"string", "GPSProcessingMethod"}, new String[]{"string", "GPSSatellites"}, new String[]{"double", "GPSSpeed"}, new String[]{"string", "GPSSpeedRef"}, new String[]{"string", "GPSStatus"}, new String[]{"string", "GPSTimeStamp"}, new String[]{"double", "GPSTrack"}, new String[]{"string", "GPSTrackRef"}, new String[]{"string", "GPSVersionID"}, new String[]{"string", "InteroperabilityIndex"}, new String[]{"int", "ThumbnailImageLength"}, new String[]{"int", "ThumbnailImageWidth"}, new String[]{"int", "DNGVersion"}, new String[]{"int", "DefaultCropSize"}, new String[]{"int", "PreviewImageStart"}, new String[]{"int", "PreviewImageLength"}, new String[]{"int", "AspectFrame"}, new String[]{"int", "SensorBottomBorder"}, new String[]{"int", "SensorLeftBorder"}, new String[]{"int", "SensorRightBorder"}, new String[]{"int", "SensorTopBorder"}, new String[]{"int", "ISO"}};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableArray f17636b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ byte[] f17637c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ReactContext f17638d;

        a(ViewGroup viewGroup, WritableArray writableArray, byte[] bArr, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17636b = writableArray;
            this.f17637c = bArr;
            this.f17638d = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17638d.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.c.n(this.a.getId(), this.f17636b, this.f17637c));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k.b.a.b f17639b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17640c;

        b(ViewGroup viewGroup, k.b.a.b bVar, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17639b = bVar;
            this.f17640c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17640c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.b.n(this.a.getId(), this.f17639b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class c implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.google.zxing.k f17641b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17642c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f17643d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ byte[] f17644e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ ReactContext f17645f;

        c(ViewGroup viewGroup, com.google.zxing.k kVar, int i2, int i3, byte[] bArr, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17641b = kVar;
            this.f17642c = i2;
            this.f17643d = i3;
            this.f17644e = bArr;
            this.f17645f = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17645f.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.a.n(this.a.getId(), this.f17641b, this.f17642c, this.f17643d, this.f17644e));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class d implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableArray f17646b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17647c;

        d(ViewGroup viewGroup, WritableArray writableArray, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17646b = writableArray;
            this.f17647c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17647c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.l.o(this.a.getId(), this.f17646b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* renamed from: org.reactnative.camera.e$e  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0429e implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f17648b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17649c;

        RunnableC0429e(ViewGroup viewGroup, String str, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17648b = str;
            this.f17649c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17649c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.d.n(this.a.getId(), this.f17648b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class f implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactContext f17650b;

        f(ViewGroup viewGroup, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17650b = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17650b.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.e.m(this.a.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class g implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableMap f17651b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17652c;

        g(ViewGroup viewGroup, WritableMap writableMap, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17651b = writableMap;
            this.f17652c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17652c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.h.n(this.a.getId(), this.f17651b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class h implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactContext f17653b;

        h(ViewGroup viewGroup, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17653b = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17653b.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.i.m(this.a.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class i implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableMap f17654b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17655c;

        i(ViewGroup viewGroup, WritableMap writableMap, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17654b = writableMap;
            this.f17655c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17655c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.k.n(this.a.getId(), this.f17654b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class j implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactContext f17656b;

        j(ViewGroup viewGroup, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17656b = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17656b.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.j.m(this.a.getId()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class k implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f17657b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f17658c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f17659d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ ReactContext f17660e;

        k(ViewGroup viewGroup, boolean z, int i2, int i3, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17657b = z;
            this.f17658c = i2;
            this.f17659d = i3;
            this.f17660e = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17660e.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.m.n(this.a.getId(), this.f17657b, this.f17658c, this.f17659d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class l implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableArray f17661b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17662c;

        l(ViewGroup viewGroup, WritableArray writableArray, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17661b = writableArray;
            this.f17662c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17662c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.g.n(this.a.getId(), this.f17661b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RNCameraViewHelper.java */
    /* loaded from: classes3.dex */
    public static class m implements Runnable {
        final /* synthetic */ ViewGroup a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ org.reactnative.facedetector.b f17663b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReactContext f17664c;

        m(ViewGroup viewGroup, org.reactnative.facedetector.b bVar, ReactContext reactContext) {
            this.a = viewGroup;
            this.f17663b = bVar;
            this.f17664c = reactContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((UIManagerModule) this.f17664c.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(org.reactnative.camera.f.f.n(this.a.getId(), this.f17663b));
        }
    }

    public static void a(ExifInterface exifInterface) {
        for (String[] strArr : a) {
            exifInterface.setAttribute(strArr[1], (String) null);
        }
        exifInterface.setAttribute("GPSLatitude", (String) null);
        exifInterface.setAttribute("GPSLongitude", (String) null);
        exifInterface.setAttribute("GPSAltitude", (String) null);
    }

    public static void b(ViewGroup viewGroup, com.google.zxing.k kVar, int i2, int i3, byte[] bArr) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new c(viewGroup, kVar, i2, i3, bArr, reactContext));
    }

    public static void c(ViewGroup viewGroup, k.b.a.b bVar) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new b(viewGroup, bVar, reactContext));
    }

    public static void d(ViewGroup viewGroup, WritableArray writableArray, byte[] bArr) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new a(viewGroup, writableArray, bArr, reactContext));
    }

    public static void e(ViewGroup viewGroup) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new f(viewGroup, reactContext));
    }

    public static void f(ViewGroup viewGroup, org.reactnative.facedetector.b bVar) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new m(viewGroup, bVar, reactContext));
    }

    public static void g(ViewGroup viewGroup, WritableArray writableArray) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new l(viewGroup, writableArray, reactContext));
    }

    public static void h(ViewGroup viewGroup, String str) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new RunnableC0429e(viewGroup, str, reactContext));
    }

    public static void i(ViewGroup viewGroup, WritableMap writableMap) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new g(viewGroup, writableMap, reactContext));
    }

    public static void j(ViewGroup viewGroup) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new h(viewGroup, reactContext));
    }

    public static void k(ViewGroup viewGroup) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new j(viewGroup, reactContext));
    }

    public static void l(ViewGroup viewGroup, WritableMap writableMap) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new i(viewGroup, writableMap, reactContext));
    }

    public static void m(ViewGroup viewGroup, WritableArray writableArray) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new d(viewGroup, writableArray, reactContext));
    }

    public static void n(ViewGroup viewGroup, boolean z, int i2, int i3) {
        ReactContext reactContext = (ReactContext) viewGroup.getContext();
        reactContext.runOnNativeModulesQueueThread(new k(viewGroup, z, i2, i3, reactContext));
    }

    public static CamcorderProfile o(int i2) {
        CamcorderProfile camcorderProfile = CamcorderProfile.get(1);
        int p = p(i2);
        if (CamcorderProfile.hasProfile(p)) {
            camcorderProfile = CamcorderProfile.get(p);
            if (i2 == 4) {
                camcorderProfile.videoFrameWidth = 640;
            }
        }
        return camcorderProfile;
    }

    private static int p(int i2) {
        if (i2 == 0) {
            return Build.VERSION.SDK_INT >= 21 ? 8 : 6;
        } else if (i2 != 1) {
            if (i2 != 2) {
                return (i2 == 3 || i2 == 4) ? 4 : 1;
            }
            return 5;
        } else {
            return 6;
        }
    }

    public static int q(int i2, int i3, int i4) {
        if (i3 == 1) {
            return (i4 + i2) % 360;
        }
        return ((i4 - i2) + (s(i2) ? CipherSuite.TLS_DHE_PSK_WITH_NULL_SHA256 : 0)) % 360;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (r8.equals("string") == false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.react.bridge.WritableMap r(androidx.exifinterface.media.ExifInterface r12) {
        /*
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String[][] r1 = org.reactnative.camera.e.a
            int r2 = r1.length
            r3 = 0
            r4 = r3
        L9:
            r5 = 0
            r7 = 1
            if (r4 >= r2) goto L63
            r8 = r1[r4]
            r9 = r8[r7]
            java.lang.String r10 = r12.getAttribute(r9)
            if (r10 == 0) goto L60
            r8 = r8[r3]
            r8.hashCode()
            r10 = -1
            int r11 = r8.hashCode()
            switch(r11) {
                case -1325958191: goto L3b;
                case -891985903: goto L32;
                case 104431: goto L27;
                default: goto L25;
            }
        L25:
            r7 = r10
            goto L45
        L27:
            java.lang.String r7 = "int"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L30
            goto L25
        L30:
            r7 = 2
            goto L45
        L32:
            java.lang.String r11 = "string"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L45
            goto L25
        L3b:
            java.lang.String r7 = "double"
            boolean r7 = r8.equals(r7)
            if (r7 != 0) goto L44
            goto L25
        L44:
            r7 = r3
        L45:
            switch(r7) {
                case 0: goto L59;
                case 1: goto L51;
                case 2: goto L49;
                default: goto L48;
            }
        L48:
            goto L60
        L49:
            int r5 = r12.getAttributeInt(r9, r3)
            r0.putInt(r9, r5)
            goto L60
        L51:
            java.lang.String r5 = r12.getAttribute(r9)
            r0.putString(r9, r5)
            goto L60
        L59:
            double r5 = r12.getAttributeDouble(r9, r5)
            r0.putDouble(r9, r5)
        L60:
            int r4 = r4 + 1
            goto L9
        L63:
            double[] r1 = r12.getLatLong()
            if (r1 == 0) goto L80
            r2 = r1[r3]
            java.lang.String r4 = "GPSLatitude"
            r0.putDouble(r4, r2)
            r2 = r1[r7]
            java.lang.String r1 = "GPSLongitude"
            r0.putDouble(r1, r2)
            double r1 = r12.getAltitude(r5)
            java.lang.String r12 = "GPSAltitude"
            r0.putDouble(r12, r1)
        L80:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.e.r(androidx.exifinterface.media.ExifInterface):com.facebook.react.bridge.WritableMap");
    }

    private static boolean s(int i2) {
        return i2 == 90 || i2 == 270;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0032, code lost:
        if (r4.equals("string") == false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void t(androidx.exifinterface.media.ExifInterface r9, com.facebook.react.bridge.ReadableMap r10) {
        /*
            java.lang.String[][] r0 = org.reactnative.camera.e.a
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L5:
            if (r3 >= r1) goto L6b
            r4 = r0[r3]
            r5 = 1
            r6 = r4[r5]
            boolean r7 = r10.hasKey(r6)
            if (r7 == 0) goto L68
            r4 = r4[r2]
            r4.hashCode()
            r7 = -1
            int r8 = r4.hashCode()
            switch(r8) {
                case -1325958191: goto L35;
                case -891985903: goto L2c;
                case 104431: goto L21;
                default: goto L1f;
            }
        L1f:
            r5 = r7
            goto L3f
        L21:
            java.lang.String r5 = "int"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L2a
            goto L1f
        L2a:
            r5 = 2
            goto L3f
        L2c:
            java.lang.String r8 = "string"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L3f
            goto L1f
        L35:
            java.lang.String r5 = "double"
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L3e
            goto L1f
        L3e:
            r5 = r2
        L3f:
            switch(r5) {
                case 0: goto L5a;
                case 1: goto L52;
                case 2: goto L43;
                default: goto L42;
            }
        L42:
            goto L68
        L43:
            int r4 = r10.getInt(r6)
            java.lang.String r4 = java.lang.Integer.toString(r4)
            r9.setAttribute(r6, r4)
            r10.getInt(r6)
            goto L68
        L52:
            java.lang.String r4 = r10.getString(r6)
            r9.setAttribute(r6, r4)
            goto L68
        L5a:
            double r4 = r10.getDouble(r6)
            java.lang.String r4 = java.lang.Double.toString(r4)
            r9.setAttribute(r6, r4)
            r10.getDouble(r6)
        L68:
            int r3 = r3 + 1
            goto L5
        L6b:
            java.lang.String r0 = "GPSLatitude"
            boolean r1 = r10.hasKey(r0)
            if (r1 == 0) goto L86
            java.lang.String r1 = "GPSLongitude"
            boolean r2 = r10.hasKey(r1)
            if (r2 == 0) goto L86
            double r2 = r10.getDouble(r0)
            double r0 = r10.getDouble(r1)
            r9.setLatLong(r2, r0)
        L86:
            java.lang.String r0 = "GPSAltitude"
            boolean r1 = r10.hasKey(r0)
            if (r1 == 0) goto L95
            double r0 = r10.getDouble(r0)
            r9.setAltitude(r0)
        L95:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.reactnative.camera.e.t(androidx.exifinterface.media.ExifInterface, com.facebook.react.bridge.ReadableMap):void");
    }
}