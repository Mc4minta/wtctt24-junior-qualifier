package org.reactnative.camera.g;

import android.os.AsyncTask;
import android.util.SparseArray;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.i0;
import com.google.android.gms.vision.text.Line;
import com.google.android.gms.vision.text.Text;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

/* compiled from: TextRecognizerAsyncTask.java */
/* loaded from: classes3.dex */
public class i extends AsyncTask<Void, Void, SparseArray<TextBlock>> {
    private j a;

    /* renamed from: b  reason: collision with root package name */
    private i0 f17731b;

    /* renamed from: c  reason: collision with root package name */
    private TextRecognizer f17732c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f17733d;

    /* renamed from: e  reason: collision with root package name */
    private int f17734e;

    /* renamed from: f  reason: collision with root package name */
    private int f17735f;

    /* renamed from: g  reason: collision with root package name */
    private int f17736g;

    /* renamed from: h  reason: collision with root package name */
    private org.reactnative.camera.h.a f17737h;

    /* renamed from: i  reason: collision with root package name */
    private double f17738i;

    /* renamed from: j  reason: collision with root package name */
    private double f17739j;

    /* renamed from: k  reason: collision with root package name */
    private int f17740k;

    /* renamed from: l  reason: collision with root package name */
    private int f17741l;

    public i(j jVar, i0 i0Var, byte[] bArr, int i2, int i3, int i4, float f2, int i5, int i6, int i7, int i8, int i9) {
        this.a = jVar;
        this.f17731b = i0Var;
        this.f17733d = bArr;
        this.f17734e = i2;
        this.f17735f = i3;
        this.f17736g = i4;
        org.reactnative.camera.h.a aVar = new org.reactnative.camera.h.a(i2, i3, i4, i5);
        this.f17737h = aVar;
        this.f17738i = i6 / (aVar.d() * f2);
        this.f17739j = i7 / (this.f17737h.b() * f2);
        this.f17740k = i8;
        this.f17741l = i9;
    }

    private WritableMap c(WritableMap writableMap) {
        ReadableMap map = writableMap.getMap("bounds");
        WritableMap d2 = org.reactnative.facedetector.a.d(org.reactnative.facedetector.a.c(map.getMap("origin"), this.f17737h.d(), this.f17738i), -map.getMap("size").getDouble("width"));
        WritableMap createMap = Arguments.createMap();
        createMap.merge(map);
        createMap.putMap("origin", d2);
        writableMap.putMap("bounds", createMap);
        ReadableArray array = writableMap.getArray("components");
        WritableArray createArray = Arguments.createArray();
        for (int i2 = 0; i2 < array.size(); i2++) {
            WritableMap createMap2 = Arguments.createMap();
            createMap2.merge(array.getMap(i2));
            c(createMap2);
            createArray.pushMap(createMap2);
        }
        writableMap.putArray("components", createArray);
        return writableMap;
    }

    private WritableMap d(Text text) {
        String str;
        WritableMap createMap = Arguments.createMap();
        WritableArray createArray = Arguments.createArray();
        for (Text text2 : text.getComponents()) {
            createArray.pushMap(d(text2));
        }
        createMap.putArray("components", createArray);
        createMap.putString("value", text.getValue());
        int i2 = text.getBoundingBox().left;
        int i3 = text.getBoundingBox().top;
        if (text.getBoundingBox().left < this.f17734e / 2) {
            i2 += this.f17740k / 2;
        } else if (text.getBoundingBox().left > this.f17734e / 2) {
            i2 -= this.f17740k / 2;
        }
        if (text.getBoundingBox().height() < this.f17735f / 2) {
            i3 += this.f17741l / 2;
        } else if (text.getBoundingBox().height() > this.f17735f / 2) {
            i3 -= this.f17741l / 2;
        }
        WritableMap createMap2 = Arguments.createMap();
        createMap2.putDouble("x", i2 * this.f17738i);
        createMap2.putDouble("y", i3 * this.f17739j);
        WritableMap createMap3 = Arguments.createMap();
        createMap3.putDouble("width", text.getBoundingBox().width() * this.f17738i);
        createMap3.putDouble("height", text.getBoundingBox().height() * this.f17739j);
        WritableMap createMap4 = Arguments.createMap();
        createMap4.putMap("origin", createMap2);
        createMap4.putMap("size", createMap3);
        createMap.putMap("bounds", createMap4);
        if (text instanceof TextBlock) {
            str = "block";
        } else {
            str = text instanceof Line ? "line" : "element";
        }
        createMap.putString("type", str);
        return createMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public SparseArray<TextBlock> doInBackground(Void... voidArr) {
        if (isCancelled() || this.a == null) {
            return null;
        }
        this.f17732c = new TextRecognizer.Builder(this.f17731b).build();
        return this.f17732c.detect(k.b.b.b.b(this.f17733d, this.f17734e, this.f17735f, this.f17736g).b());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: b */
    public void onPostExecute(SparseArray<TextBlock> sparseArray) {
        super.onPostExecute(sparseArray);
        TextRecognizer textRecognizer = this.f17732c;
        if (textRecognizer != null) {
            textRecognizer.release();
        }
        if (sparseArray != null) {
            WritableArray createArray = Arguments.createArray();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                WritableMap d2 = d(sparseArray.valueAt(i2));
                if (this.f17737h.a() == 1) {
                    d2 = c(d2);
                }
                createArray.pushMap(d2);
            }
            this.a.j(createArray);
        }
        this.a.f();
    }
}