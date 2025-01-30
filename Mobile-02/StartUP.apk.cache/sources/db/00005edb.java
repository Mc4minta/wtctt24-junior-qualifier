package org.reactnative.camera.g;

import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.barcode.Barcode;

/* compiled from: BarcodeDetectorAsyncTask.java */
/* loaded from: classes3.dex */
public class c extends AsyncTask<Void, Void, SparseArray<Barcode>> {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17705b;

    /* renamed from: c  reason: collision with root package name */
    private int f17706c;

    /* renamed from: d  reason: collision with root package name */
    private int f17707d;

    /* renamed from: e  reason: collision with root package name */
    private k.b.a.b f17708e;

    /* renamed from: f  reason: collision with root package name */
    private d f17709f;

    /* renamed from: g  reason: collision with root package name */
    private double f17710g;

    /* renamed from: h  reason: collision with root package name */
    private double f17711h;

    /* renamed from: i  reason: collision with root package name */
    private org.reactnative.camera.h.a f17712i;

    /* renamed from: j  reason: collision with root package name */
    private int f17713j;

    /* renamed from: k  reason: collision with root package name */
    private int f17714k;

    public c(d dVar, k.b.a.b bVar, byte[] bArr, int i2, int i3, int i4, float f2, int i5, int i6, int i7, int i8, int i9) {
        this.a = bArr;
        this.f17705b = i2;
        this.f17706c = i3;
        this.f17707d = i4;
        this.f17709f = dVar;
        this.f17708e = bVar;
        org.reactnative.camera.h.a aVar = new org.reactnative.camera.h.a(i2, i3, i4, i5);
        this.f17712i = aVar;
        this.f17710g = i6 / (aVar.d() * f2);
        this.f17711h = i7 / (this.f17712i.b() * f2);
        this.f17713j = i8;
        this.f17714k = i9;
    }

    private WritableMap c(Rect rect) {
        WritableMap createMap = Arguments.createMap();
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = this.f17705b;
        if (i2 < i4 / 2) {
            i2 += this.f17713j / 2;
        } else if (i2 > i4 / 2) {
            i2 -= this.f17713j / 2;
        }
        int i5 = this.f17706c;
        if (i3 < i5 / 2) {
            i3 += this.f17714k / 2;
        } else if (i3 > i5 / 2) {
            i3 -= this.f17714k / 2;
        }
        createMap.putDouble("x", i2 * this.f17710g);
        createMap.putDouble("y", i3 * this.f17711h);
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("width", rect.width() * this.f17710g);
        createMap2.putDouble("height", rect.height() * this.f17711h);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putMap("origin", createMap);
        createMap3.putMap("size", createMap2);
        return createMap3;
    }

    private WritableArray d(SparseArray<Barcode> sparseArray) {
        WritableArray createArray = Arguments.createArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            Barcode valueAt = sparseArray.valueAt(i2);
            WritableMap createMap = Arguments.createMap();
            createMap.putString("data", valueAt.displayValue);
            createMap.putString("rawData", valueAt.rawValue);
            createMap.putString("type", k.b.a.a.a(valueAt.format));
            createMap.putMap("bounds", c(valueAt.getBoundingBox()));
            createArray.pushMap(createMap);
        }
        return createArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public SparseArray<Barcode> doInBackground(Void... voidArr) {
        k.b.a.b bVar;
        if (isCancelled() || this.f17709f == null || (bVar = this.f17708e) == null || !bVar.c()) {
            return null;
        }
        return this.f17708e.b(k.b.b.b.b(this.a, this.f17705b, this.f17706c, this.f17707d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(SparseArray<Barcode> sparseArray) {
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.f17709f.e(this.f17708e);
            return;
        }
        if (sparseArray.size() > 0) {
            this.f17709f.a(d(sparseArray), this.f17705b, this.f17706c, this.a);
        }
        this.f17709f.k();
    }
}