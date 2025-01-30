package org.reactnative.facedetector;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

/* compiled from: RNFaceDetector.java */
/* loaded from: classes3.dex */
public class b {
    public static int a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static int f17745b = 0;

    /* renamed from: c  reason: collision with root package name */
    public static int f17746c = 1;

    /* renamed from: d  reason: collision with root package name */
    public static int f17747d = 0;

    /* renamed from: e  reason: collision with root package name */
    public static int f17748e = 1;

    /* renamed from: f  reason: collision with root package name */
    public static int f17749f;

    /* renamed from: h  reason: collision with root package name */
    private org.reactnative.camera.h.a f17751h;

    /* renamed from: i  reason: collision with root package name */
    private FaceDetector.Builder f17752i;

    /* renamed from: g  reason: collision with root package name */
    private FaceDetector f17750g = null;

    /* renamed from: j  reason: collision with root package name */
    private int f17753j = f17745b;

    /* renamed from: k  reason: collision with root package name */
    private int f17754k = f17747d;

    /* renamed from: l  reason: collision with root package name */
    private float f17755l = 0.15f;
    private int m = f17749f;

    public b(Context context) {
        this.f17752i = null;
        FaceDetector.Builder builder = new FaceDetector.Builder(context);
        this.f17752i = builder;
        builder.setMinFaceSize(this.f17755l);
        this.f17752i.setMode(this.m);
        this.f17752i.setLandmarkType(this.f17754k);
        this.f17752i.setClassificationType(this.f17753j);
    }

    private void a() {
        this.f17750g = this.f17752i.build();
    }

    private void e() {
        FaceDetector faceDetector = this.f17750g;
        if (faceDetector != null) {
            faceDetector.release();
            this.f17750g = null;
        }
    }

    public SparseArray<Face> b(k.b.b.a aVar) {
        if (!aVar.a().equals(this.f17751h)) {
            e();
        }
        if (this.f17750g == null) {
            a();
            this.f17751h = aVar.a();
        }
        return this.f17750g.detect(aVar.b());
    }

    public boolean c() {
        if (this.f17750g == null) {
            a();
        }
        return this.f17750g.isOperational();
    }

    public void d() {
        e();
        this.f17751h = null;
    }

    public void f(int i2) {
        if (i2 != this.f17753j) {
            d();
            this.f17752i.setClassificationType(i2);
            this.f17753j = i2;
        }
    }

    public void g(int i2) {
        if (i2 != this.f17754k) {
            d();
            this.f17752i.setLandmarkType(i2);
            this.f17754k = i2;
        }
    }

    public void h(int i2) {
        if (i2 != this.m) {
            d();
            this.f17752i.setMode(i2);
            this.m = i2;
        }
    }

    public void i(boolean z) {
        d();
        this.f17752i.setTrackingEnabled(z);
    }
}