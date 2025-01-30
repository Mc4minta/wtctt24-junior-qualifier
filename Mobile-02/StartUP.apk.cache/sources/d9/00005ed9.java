package org.reactnative.camera.g;

import android.os.AsyncTask;
import com.google.zxing.NotFoundException;
import com.google.zxing.k;

/* compiled from: BarCodeScannerAsyncTask.java */
/* loaded from: classes3.dex */
public class a extends AsyncTask<Void, Void, k> {
    private byte[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f17694b;

    /* renamed from: c  reason: collision with root package name */
    private int f17695c;

    /* renamed from: d  reason: collision with root package name */
    private b f17696d;

    /* renamed from: e  reason: collision with root package name */
    private final com.google.zxing.h f17697e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17698f;

    /* renamed from: g  reason: collision with root package name */
    private float f17699g;

    /* renamed from: h  reason: collision with root package name */
    private float f17700h;

    /* renamed from: i  reason: collision with root package name */
    private float f17701i;

    /* renamed from: j  reason: collision with root package name */
    private float f17702j;

    /* renamed from: k  reason: collision with root package name */
    private int f17703k;

    /* renamed from: l  reason: collision with root package name */
    private int f17704l;
    private float m;

    public a(b bVar, com.google.zxing.h hVar, byte[] bArr, int i2, int i3, boolean z, float f2, float f3, float f4, float f5, int i4, int i5, float f6) {
        this.a = bArr;
        this.f17694b = i2;
        this.f17695c = i3;
        this.f17696d = bVar;
        this.f17697e = hVar;
        this.f17698f = z;
        this.f17699g = f2;
        this.f17700h = f3;
        this.f17701i = f4;
        this.f17702j = f5;
        this.f17703k = i4;
        this.f17704l = i5;
        this.m = f6;
    }

    private com.google.zxing.c b(byte[] bArr, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        com.google.zxing.i iVar;
        if (this.f17698f) {
            iVar = new com.google.zxing.i(bArr, i2, i3, i4, i5, i6, i7, false);
        } else {
            iVar = new com.google.zxing.i(bArr, i2, i3, 0, 0, i2, i3, false);
        }
        if (z) {
            return new com.google.zxing.c(new com.google.zxing.q.j(iVar.e()));
        }
        return new com.google.zxing.c(new com.google.zxing.q.j(iVar));
    }

    private byte[] d(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[bArr.length];
        for (int i4 = 0; i4 < i3; i4++) {
            for (int i5 = 0; i5 < i2; i5++) {
                bArr2[(((i5 * i3) + i3) - i4) - 1] = bArr[(i4 * i2) + i5];
            }
        }
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public k doInBackground(Void... voidArr) {
        k d2;
        if (isCancelled() || this.f17696d == null) {
            return null;
        }
        int i2 = (int) (this.f17704l / this.m);
        int i3 = this.f17703k;
        float f2 = i2;
        float f3 = this.f17699g;
        int i4 = this.f17694b;
        int i5 = (int) (f3 * i4);
        int i6 = this.f17695c;
        int i7 = (int) (((((i2 - i3) / 2) + (this.f17700h * i3)) / f2) * i6);
        int i8 = (int) (this.f17701i * i4);
        int i9 = (int) (((this.f17702j * i3) / f2) * i6);
        try {
            return this.f17697e.d(b(this.a, i4, i6, false, i5, i7, i8, i9));
        } catch (NotFoundException unused) {
            byte[] d3 = d(this.a, this.f17694b, this.f17695c);
            int i10 = this.f17695c;
            try {
                d2 = this.f17697e.d(b(d3, i10, this.f17694b, false, (i10 - i9) - i7, i5, i9, i8));
            } catch (NotFoundException unused2) {
                byte[] bArr = this.a;
                int i11 = this.f17694b;
                int i12 = this.f17695c;
                try {
                    d2 = this.f17697e.d(b(bArr, i11, i12, true, (i11 - i8) - i5, (i12 - i9) - i7, i8, i9));
                } catch (NotFoundException unused3) {
                    byte[] d4 = d(this.a, this.f17694b, this.f17695c);
                    int i13 = this.f17695c;
                    int i14 = this.f17694b;
                    try {
                        d2 = this.f17697e.d(b(d4, i13, i14, true, i7, (i14 - i8) - i5, i9, i8));
                    } catch (NotFoundException unused4) {
                        return null;
                    }
                }
            }
            return d2;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: c */
    public void onPostExecute(k kVar) {
        super.onPostExecute(kVar);
        if (kVar != null) {
            this.f17696d.d(kVar, this.f17694b, this.f17695c, this.a);
        }
        this.f17696d.g();
    }
}