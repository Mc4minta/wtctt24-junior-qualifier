package com.journeyapps.barcodescanner;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.List;

/* compiled from: CameraPreview.java */
/* loaded from: classes2.dex */
public class c extends ViewGroup {
    private static final String a = c.class.getSimpleName();
    private boolean A;
    private final SurfaceHolder.Callback B;
    private final Handler.Callback C;
    private l D;
    private final f E;

    /* renamed from: b  reason: collision with root package name */
    private com.journeyapps.barcodescanner.q.b f10347b;

    /* renamed from: c  reason: collision with root package name */
    private WindowManager f10348c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f10349d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10350e;

    /* renamed from: f  reason: collision with root package name */
    private SurfaceView f10351f;

    /* renamed from: g  reason: collision with root package name */
    private TextureView f10352g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10353h;

    /* renamed from: j  reason: collision with root package name */
    private m f10354j;

    /* renamed from: k  reason: collision with root package name */
    private int f10355k;

    /* renamed from: l  reason: collision with root package name */
    private List<f> f10356l;
    private com.journeyapps.barcodescanner.q.h m;
    private com.journeyapps.barcodescanner.q.d n;
    private n p;
    private n q;
    private Rect t;
    private n u;
    private Rect v;
    private Rect w;
    private n x;
    private double y;
    private com.journeyapps.barcodescanner.q.l z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CameraPreview.java */
    /* loaded from: classes2.dex */
    public class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            onSurfaceTextureSizeChanged(surfaceTexture, i2, i3);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            c.this.u = new n(i2, i3);
            c.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* compiled from: CameraPreview.java */
    /* loaded from: classes2.dex */
    class b implements SurfaceHolder.Callback {
        b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            if (surfaceHolder == null) {
                Log.e(c.a, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            c.this.u = new n(i3, i4);
            c.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            c.this.u = null;
        }
    }

    /* compiled from: CameraPreview.java */
    /* renamed from: com.journeyapps.barcodescanner.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0215c implements Handler.Callback {
        C0215c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == com.google.zxing.p.a.g.zxing_prewiew_size_ready) {
                c.this.w((n) message.obj);
                return true;
            } else if (i2 == com.google.zxing.p.a.g.zxing_camera_error) {
                Exception exc = (Exception) message.obj;
                if (c.this.r()) {
                    c.this.u();
                    c.this.E.b(exc);
                    return false;
                }
                return false;
            } else if (i2 == com.google.zxing.p.a.g.zxing_camera_closed) {
                c.this.E.d();
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: CameraPreview.java */
    /* loaded from: classes2.dex */
    class d implements l {

        /* compiled from: CameraPreview.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.z();
            }
        }

        d() {
        }

        @Override // com.journeyapps.barcodescanner.l
        public void a(int i2) {
            c.this.f10349d.postDelayed(new a(), 250L);
        }
    }

    /* compiled from: CameraPreview.java */
    /* loaded from: classes2.dex */
    class e implements f {
        e() {
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void a() {
            for (f fVar : c.this.f10356l) {
                fVar.a();
            }
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void b(Exception exc) {
            for (f fVar : c.this.f10356l) {
                fVar.b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void c() {
            for (f fVar : c.this.f10356l) {
                fVar.c();
            }
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void d() {
            for (f fVar : c.this.f10356l) {
                fVar.d();
            }
        }

        @Override // com.journeyapps.barcodescanner.c.f
        public void e() {
            for (f fVar : c.this.f10356l) {
                fVar.e();
            }
        }
    }

    /* compiled from: CameraPreview.java */
    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10350e = false;
        this.f10353h = false;
        this.f10355k = -1;
        this.f10356l = new ArrayList();
        this.n = new com.journeyapps.barcodescanner.q.d();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0.1d;
        this.z = null;
        this.A = false;
        this.B = new b();
        this.C = new C0215c();
        this.D = new d();
        this.E = new e();
        p(context, attributeSet, 0, 0);
    }

    private void A() {
        if (this.f10350e) {
            TextureView textureView = new TextureView(getContext());
            this.f10352g = textureView;
            textureView.setSurfaceTextureListener(D());
            addView(this.f10352g);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.f10351f = surfaceView;
        surfaceView.getHolder().addCallback(this.B);
        addView(this.f10351f);
    }

    private void B(com.journeyapps.barcodescanner.q.e eVar) {
        if (this.f10353h || this.f10347b == null) {
            return;
        }
        Log.i(a, "Starting preview");
        this.f10347b.u(eVar);
        this.f10347b.w();
        this.f10353h = true;
        x();
        this.E.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Rect rect;
        n nVar = this.u;
        if (nVar == null || this.q == null || (rect = this.t) == null) {
            return;
        }
        if (this.f10351f != null && nVar.equals(new n(rect.width(), this.t.height()))) {
            B(new com.journeyapps.barcodescanner.q.e(this.f10351f.getHolder()));
            return;
        }
        TextureView textureView = this.f10352g;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.q != null) {
            this.f10352g.setTransform(l(new n(this.f10352g.getWidth(), this.f10352g.getHeight()), this.q));
        }
        B(new com.journeyapps.barcodescanner.q.e(this.f10352g.getSurfaceTexture()));
    }

    @TargetApi(14)
    private TextureView.SurfaceTextureListener D() {
        return new a();
    }

    private int getDisplayRotation() {
        return this.f10348c.getDefaultDisplay().getRotation();
    }

    private void j() {
        n nVar;
        com.journeyapps.barcodescanner.q.h hVar;
        n nVar2 = this.p;
        if (nVar2 != null && (nVar = this.q) != null && (hVar = this.m) != null) {
            int i2 = nVar.a;
            int i3 = nVar.f10387b;
            int i4 = nVar2.a;
            int i5 = nVar2.f10387b;
            this.t = hVar.d(nVar);
            this.v = k(new Rect(0, 0, i4, i5), this.t);
            Rect rect = new Rect(this.v);
            Rect rect2 = this.t;
            rect.offset(-rect2.left, -rect2.top);
            Rect rect3 = new Rect((rect.left * i2) / this.t.width(), (rect.top * i3) / this.t.height(), (rect.right * i2) / this.t.width(), (rect.bottom * i3) / this.t.height());
            this.w = rect3;
            if (rect3.width() > 0 && this.w.height() > 0) {
                this.E.a();
                return;
            }
            this.w = null;
            this.v = null;
            Log.w(a, "Preview frame is too small");
            return;
        }
        this.w = null;
        this.v = null;
        this.t = null;
        throw new IllegalStateException("containerSize or previewSize is not set yet");
    }

    private void m(n nVar) {
        this.p = nVar;
        com.journeyapps.barcodescanner.q.b bVar = this.f10347b;
        if (bVar == null || bVar.l() != null) {
            return;
        }
        com.journeyapps.barcodescanner.q.h hVar = new com.journeyapps.barcodescanner.q.h(getDisplayRotation(), nVar);
        this.m = hVar;
        hVar.e(getPreviewScalingStrategy());
        this.f10347b.s(this.m);
        this.f10347b.k();
        boolean z = this.A;
        if (z) {
            this.f10347b.v(z);
        }
    }

    private void o() {
        if (this.f10347b != null) {
            Log.w(a, "initCamera called twice");
            return;
        }
        com.journeyapps.barcodescanner.q.b n = n();
        this.f10347b = n;
        n.t(this.f10349d);
        this.f10347b.p();
        this.f10355k = getDisplayRotation();
    }

    private void p(Context context, AttributeSet attributeSet, int i2, int i3) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.f10348c = (WindowManager) context.getSystemService("window");
        this.f10349d = new Handler(this.C);
        this.f10354j = new m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(n nVar) {
        this.q = nVar;
        if (this.p != null) {
            j();
            requestLayout();
            C();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        if (!r() || getDisplayRotation() == this.f10355k) {
            return;
        }
        u();
        y();
    }

    public com.journeyapps.barcodescanner.q.b getCameraInstance() {
        return this.f10347b;
    }

    public com.journeyapps.barcodescanner.q.d getCameraSettings() {
        return this.n;
    }

    public Rect getFramingRect() {
        return this.v;
    }

    public n getFramingRectSize() {
        return this.x;
    }

    public double getMarginFraction() {
        return this.y;
    }

    public Rect getPreviewFramingRect() {
        return this.w;
    }

    public com.journeyapps.barcodescanner.q.l getPreviewScalingStrategy() {
        com.journeyapps.barcodescanner.q.l lVar = this.z;
        if (lVar != null) {
            return lVar;
        }
        if (this.f10352g != null) {
            return new com.journeyapps.barcodescanner.q.g();
        }
        return new com.journeyapps.barcodescanner.q.i();
    }

    public void i(f fVar) {
        this.f10356l.add(fVar);
    }

    protected Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.x != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.x.a) / 2), Math.max(0, (rect3.height() - this.x.f10387b) / 2));
            return rect3;
        }
        int min = (int) Math.min(rect3.width() * this.y, rect3.height() * this.y);
        rect3.inset(min, min);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    protected Matrix l(n nVar, n nVar2) {
        float f2;
        float f3 = nVar.a / nVar.f10387b;
        float f4 = nVar2.a / nVar2.f10387b;
        float f5 = 1.0f;
        if (f3 < f4) {
            float f6 = f4 / f3;
            f2 = 1.0f;
            f5 = f6;
        } else {
            f2 = f3 / f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f2);
        int i2 = nVar.a;
        int i3 = nVar.f10387b;
        matrix.postTranslate((i2 - (i2 * f5)) / 2.0f, (i3 - (i3 * f2)) / 2.0f);
        return matrix;
    }

    protected com.journeyapps.barcodescanner.q.b n() {
        com.journeyapps.barcodescanner.q.b bVar = new com.journeyapps.barcodescanner.q.b(getContext());
        bVar.r(this.n);
        return bVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        m(new n(i4 - i2, i5 - i3));
        SurfaceView surfaceView = this.f10351f;
        if (surfaceView != null) {
            Rect rect = this.t;
            if (rect == null) {
                surfaceView.layout(0, 0, getWidth(), getHeight());
                return;
            } else {
                surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
                return;
            }
        }
        TextureView textureView = this.f10352g;
        if (textureView != null) {
            textureView.layout(0, 0, getWidth(), getHeight());
        }
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", onSaveInstanceState);
        bundle.putBoolean("torch", this.A);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void q(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.google.zxing.p.a.k.a);
        int dimension = (int) obtainStyledAttributes.getDimension(com.google.zxing.p.a.k.f9902c, -1.0f);
        int dimension2 = (int) obtainStyledAttributes.getDimension(com.google.zxing.p.a.k.f9901b, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.x = new n(dimension, dimension2);
        }
        this.f10350e = obtainStyledAttributes.getBoolean(com.google.zxing.p.a.k.f9904e, true);
        int integer = obtainStyledAttributes.getInteger(com.google.zxing.p.a.k.f9903d, -1);
        if (integer == 1) {
            this.z = new com.journeyapps.barcodescanner.q.g();
        } else if (integer == 2) {
            this.z = new com.journeyapps.barcodescanner.q.i();
        } else if (integer == 3) {
            this.z = new com.journeyapps.barcodescanner.q.j();
        }
        obtainStyledAttributes.recycle();
    }

    protected boolean r() {
        return this.f10347b != null;
    }

    public boolean s() {
        com.journeyapps.barcodescanner.q.b bVar = this.f10347b;
        return bVar == null || bVar.n();
    }

    public void setCameraSettings(com.journeyapps.barcodescanner.q.d dVar) {
        this.n = dVar;
    }

    public void setFramingRectSize(n nVar) {
        this.x = nVar;
    }

    public void setMarginFraction(double d2) {
        if (d2 < 0.5d) {
            this.y = d2;
            return;
        }
        throw new IllegalArgumentException("The margin fraction must be less than 0.5");
    }

    public void setPreviewScalingStrategy(com.journeyapps.barcodescanner.q.l lVar) {
        this.z = lVar;
    }

    public void setTorch(boolean z) {
        this.A = z;
        com.journeyapps.barcodescanner.q.b bVar = this.f10347b;
        if (bVar != null) {
            bVar.v(z);
        }
    }

    public void setUseTextureView(boolean z) {
        this.f10350e = z;
    }

    public boolean t() {
        return this.f10353h;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        p.a();
        Log.d(a, "pause()");
        this.f10355k = -1;
        com.journeyapps.barcodescanner.q.b bVar = this.f10347b;
        if (bVar != null) {
            bVar.j();
            this.f10347b = null;
            this.f10353h = false;
        } else {
            this.f10349d.sendEmptyMessage(com.google.zxing.p.a.g.zxing_camera_closed);
        }
        if (this.u == null && (surfaceView = this.f10351f) != null) {
            surfaceView.getHolder().removeCallback(this.B);
        }
        if (this.u == null && (textureView = this.f10352g) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.p = null;
        this.q = null;
        this.w = null;
        this.f10354j.f();
        this.E.c();
    }

    public void v() {
        com.journeyapps.barcodescanner.q.b cameraInstance = getCameraInstance();
        u();
        long nanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.n() && System.nanoTime() - nanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x() {
    }

    public void y() {
        p.a();
        Log.d(a, "resume()");
        o();
        if (this.u != null) {
            C();
        } else {
            SurfaceView surfaceView = this.f10351f;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.B);
            } else {
                TextureView textureView = this.f10352g;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.f10352g.getSurfaceTexture(), this.f10352g.getWidth(), this.f10352g.getHeight());
                    } else {
                        this.f10352g.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.f10354j.e(getContext(), this.D);
    }
}