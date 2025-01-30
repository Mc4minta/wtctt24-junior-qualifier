package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.journeyapps.barcodescanner.c;
import java.util.ArrayList;
import java.util.List;
import org.spongycastle.crypto.tls.CipherSuite;

/* loaded from: classes2.dex */
public class ViewfinderView extends View {
    protected static final String a = ViewfinderView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    protected static final int[] f10335b = {0, 64, 128, 192, 255, 192, 128, 64};

    /* renamed from: c  reason: collision with root package name */
    protected final Paint f10336c;

    /* renamed from: d  reason: collision with root package name */
    protected Bitmap f10337d;

    /* renamed from: e  reason: collision with root package name */
    protected final int f10338e;

    /* renamed from: f  reason: collision with root package name */
    protected final int f10339f;

    /* renamed from: g  reason: collision with root package name */
    protected final int f10340g;

    /* renamed from: h  reason: collision with root package name */
    protected final int f10341h;

    /* renamed from: j  reason: collision with root package name */
    protected int f10342j;

    /* renamed from: k  reason: collision with root package name */
    protected List<com.google.zxing.m> f10343k;

    /* renamed from: l  reason: collision with root package name */
    protected List<com.google.zxing.m> f10344l;
    protected c m;
    protected Rect n;
    protected Rect p;

    /* loaded from: classes2.dex */
    class a implements c.f {
        a() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void a() {
            ViewfinderView.this.b();
            ViewfinderView.this.invalidate();
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void b(Exception exc) {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void c() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void d() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void e() {
        }
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10336c = new Paint(1);
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.google.zxing.p.a.k.f9905f);
        this.f10338e = obtainStyledAttributes.getColor(com.google.zxing.p.a.k.f9909j, resources.getColor(com.google.zxing.p.a.f.zxing_viewfinder_mask));
        this.f10339f = obtainStyledAttributes.getColor(com.google.zxing.p.a.k.f9907h, resources.getColor(com.google.zxing.p.a.f.zxing_result_view));
        this.f10340g = obtainStyledAttributes.getColor(com.google.zxing.p.a.k.f9908i, resources.getColor(com.google.zxing.p.a.f.zxing_viewfinder_laser));
        this.f10341h = obtainStyledAttributes.getColor(com.google.zxing.p.a.k.f9906g, resources.getColor(com.google.zxing.p.a.f.zxing_possible_result_points));
        obtainStyledAttributes.recycle();
        this.f10342j = 0;
        this.f10343k = new ArrayList(20);
        this.f10344l = new ArrayList(20);
    }

    public void a(com.google.zxing.m mVar) {
        if (this.f10343k.size() < 20) {
            this.f10343k.add(mVar);
        }
    }

    protected void b() {
        c cVar = this.m;
        if (cVar == null) {
            return;
        }
        Rect framingRect = cVar.getFramingRect();
        Rect previewFramingRect = this.m.getPreviewFramingRect();
        if (framingRect == null || previewFramingRect == null) {
            return;
        }
        this.n = framingRect;
        this.p = previewFramingRect;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Rect rect;
        b();
        Rect rect2 = this.n;
        if (rect2 == null || (rect = this.p) == null) {
            return;
        }
        int width = canvas.getWidth();
        int height = canvas.getHeight();
        this.f10336c.setColor(this.f10337d != null ? this.f10339f : this.f10338e);
        float f2 = width;
        canvas.drawRect(0.0f, 0.0f, f2, rect2.top, this.f10336c);
        canvas.drawRect(0.0f, rect2.top, rect2.left, rect2.bottom + 1, this.f10336c);
        canvas.drawRect(rect2.right + 1, rect2.top, f2, rect2.bottom + 1, this.f10336c);
        canvas.drawRect(0.0f, rect2.bottom + 1, f2, height, this.f10336c);
        if (this.f10337d != null) {
            this.f10336c.setAlpha(CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256);
            canvas.drawBitmap(this.f10337d, (Rect) null, rect2, this.f10336c);
            return;
        }
        this.f10336c.setColor(this.f10340g);
        Paint paint = this.f10336c;
        int[] iArr = f10335b;
        paint.setAlpha(iArr[this.f10342j]);
        this.f10342j = (this.f10342j + 1) % iArr.length;
        int height2 = (rect2.height() / 2) + rect2.top;
        canvas.drawRect(rect2.left + 2, height2 - 1, rect2.right - 1, height2 + 2, this.f10336c);
        float width2 = rect2.width() / rect.width();
        float height3 = rect2.height() / rect.height();
        int i2 = rect2.left;
        int i3 = rect2.top;
        if (!this.f10344l.isEmpty()) {
            this.f10336c.setAlpha(80);
            this.f10336c.setColor(this.f10341h);
            for (com.google.zxing.m mVar : this.f10344l) {
                canvas.drawCircle(((int) (mVar.c() * width2)) + i2, ((int) (mVar.d() * height3)) + i3, 3.0f, this.f10336c);
            }
            this.f10344l.clear();
        }
        if (!this.f10343k.isEmpty()) {
            this.f10336c.setAlpha(CipherSuite.TLS_DH_RSA_WITH_AES_128_GCM_SHA256);
            this.f10336c.setColor(this.f10341h);
            for (com.google.zxing.m mVar2 : this.f10343k) {
                canvas.drawCircle(((int) (mVar2.c() * width2)) + i2, ((int) (mVar2.d() * height3)) + i3, 6.0f, this.f10336c);
            }
            List<com.google.zxing.m> list = this.f10343k;
            List<com.google.zxing.m> list2 = this.f10344l;
            this.f10343k = list2;
            this.f10344l = list;
            list2.clear();
        }
        postInvalidateDelayed(80L, rect2.left - 6, rect2.top - 6, rect2.right + 6, rect2.bottom + 6);
    }

    public void setCameraPreview(c cVar) {
        this.m = cVar;
        cVar.i(new a());
    }
}