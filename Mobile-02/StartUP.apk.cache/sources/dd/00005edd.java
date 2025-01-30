package org.reactnative.camera.g;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.google.android.gms.vision.face.Face;

/* compiled from: FaceDetectorAsyncTask.java */
/* loaded from: classes3.dex */
public class e extends AsyncTask<Void, Void, SparseArray<Face>> {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17715b;

    /* renamed from: c  reason: collision with root package name */
    private int f17716c;

    /* renamed from: d  reason: collision with root package name */
    private int f17717d;

    /* renamed from: e  reason: collision with root package name */
    private org.reactnative.facedetector.b f17718e;

    /* renamed from: f  reason: collision with root package name */
    private f f17719f;

    /* renamed from: g  reason: collision with root package name */
    private org.reactnative.camera.h.a f17720g;

    /* renamed from: h  reason: collision with root package name */
    private double f17721h;

    /* renamed from: i  reason: collision with root package name */
    private double f17722i;

    /* renamed from: j  reason: collision with root package name */
    private int f17723j;

    /* renamed from: k  reason: collision with root package name */
    private int f17724k;

    public e(f fVar, org.reactnative.facedetector.b bVar, byte[] bArr, int i2, int i3, int i4, float f2, int i5, int i6, int i7, int i8, int i9) {
        this.a = bArr;
        this.f17715b = i2;
        this.f17716c = i3;
        this.f17717d = i4;
        this.f17719f = fVar;
        this.f17718e = bVar;
        org.reactnative.camera.h.a aVar = new org.reactnative.camera.h.a(i2, i3, i4, i5);
        this.f17720g = aVar;
        this.f17721h = i6 / (aVar.d() * f2);
        this.f17722i = i7 / (this.f17720g.b() * f2);
        this.f17723j = i8;
        this.f17724k = i9;
    }

    private WritableArray c(SparseArray<Face> sparseArray) {
        WritableMap a;
        WritableArray createArray = Arguments.createArray();
        for (int i2 = 0; i2 < sparseArray.size(); i2++) {
            WritableMap g2 = org.reactnative.facedetector.a.g(sparseArray.valueAt(i2), this.f17721h, this.f17722i, this.f17715b, this.f17716c, this.f17723j, this.f17724k);
            if (this.f17720g.a() == 1) {
                a = org.reactnative.facedetector.a.e(g2, this.f17720g.d(), this.f17721h);
            } else {
                a = org.reactnative.facedetector.a.a(g2);
            }
            createArray.pushMap(a);
        }
        return createArray;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public SparseArray<Face> doInBackground(Void... voidArr) {
        org.reactnative.facedetector.b bVar;
        if (isCancelled() || this.f17719f == null || (bVar = this.f17718e) == null || !bVar.c()) {
            return null;
        }
        return this.f17718e.b(k.b.b.b.b(this.a, this.f17715b, this.f17716c, this.f17717d));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(SparseArray<Face> sparseArray) {
        super.onPostExecute(sparseArray);
        if (sparseArray == null) {
            this.f17719f.b(this.f17718e);
            return;
        }
        if (sparseArray.size() > 0) {
            this.f17719f.c(c(sparseArray));
        }
        this.f17719f.i();
    }
}