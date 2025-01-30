package k.b.a;

import android.content.Context;
import android.util.SparseArray;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

/* compiled from: RNBarcodeDetector.java */
/* loaded from: classes3.dex */
public class b {
    public static int a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static int f17195b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static int f17196c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static int f17197d;

    /* renamed from: f  reason: collision with root package name */
    private org.reactnative.camera.h.a f17199f;

    /* renamed from: g  reason: collision with root package name */
    private BarcodeDetector.Builder f17200g;

    /* renamed from: e  reason: collision with root package name */
    private BarcodeDetector f17198e = null;

    /* renamed from: h  reason: collision with root package name */
    private int f17201h = 0;

    public b(Context context) {
        this.f17200g = new BarcodeDetector.Builder(context).setBarcodeFormats(this.f17201h);
    }

    private void a() {
        this.f17198e = this.f17200g.build();
    }

    private void e() {
        BarcodeDetector barcodeDetector = this.f17198e;
        if (barcodeDetector != null) {
            barcodeDetector.release();
            this.f17198e = null;
        }
    }

    public SparseArray<Barcode> b(k.b.b.a aVar) {
        if (!aVar.a().equals(this.f17199f)) {
            e();
        }
        if (this.f17198e == null) {
            a();
            this.f17199f = aVar.a();
        }
        return this.f17198e.detect(aVar.b());
    }

    public boolean c() {
        if (this.f17198e == null) {
            a();
        }
        return this.f17198e.isOperational();
    }

    public void d() {
        e();
        this.f17199f = null;
    }

    public void f(int i2) {
        if (i2 != this.f17201h) {
            d();
            this.f17200g.setBarcodeFormats(i2);
            this.f17201h = i2;
        }
    }
}