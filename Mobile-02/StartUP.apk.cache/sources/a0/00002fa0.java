package com.facebook.react.views.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.o0;
import com.reactnativecommunity.webview.RNCWebViewManager;
import e.f.h.e.l;
import e.f.h.e.q;
import e.f.h.f.d;
import e.f.m.b0.b.b;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpStatus;

/* compiled from: ReactImageView.java */
/* loaded from: classes2.dex */
public class g extends e.f.h.i.d {

    /* renamed from: g  reason: collision with root package name */
    private static float[] f5308g = new float[4];

    /* renamed from: h  reason: collision with root package name */
    private static final Matrix f5309h = new Matrix();

    /* renamed from: j  reason: collision with root package name */
    private static final Matrix f5310j = new Matrix();

    /* renamed from: k  reason: collision with root package name */
    private static final Matrix f5311k = new Matrix();
    private float[] A;
    private q.b B;
    private Shader.TileMode C;
    private boolean D;
    private final e.f.h.c.b E;
    private final b F;
    private final c G;
    private e.f.j.k.a H;
    private e.f.h.c.d I;
    private e.f.h.c.d J;
    private com.facebook.react.views.image.a K;
    private Object L;
    private int M;
    private boolean N;
    private ReadableMap O;

    /* renamed from: l  reason: collision with root package name */
    private com.facebook.react.views.image.c f5312l;
    private final List<e.f.m.b0.b.a> m;
    private e.f.m.b0.b.a n;
    private e.f.m.b0.b.a p;
    private Drawable q;
    private Drawable t;
    private l u;
    private int v;
    private int w;
    private int x;
    private float y;
    private float z;

    /* compiled from: ReactImageView.java */
    /* loaded from: classes2.dex */
    class a extends e.f.h.c.c<e.f.j.i.e> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.react.uimanager.events.d f5313b;

        a(com.facebook.react.uimanager.events.d dVar) {
            this.f5313b = dVar;
        }

        @Override // e.f.h.c.c, e.f.h.c.d
        public void c(String str, Throwable th) {
            this.f5313b.v(new com.facebook.react.views.image.b(g.this.getId(), 1, true, th.getMessage()));
        }

        @Override // e.f.h.c.c, e.f.h.c.d
        public void e(String str, Object obj) {
            this.f5313b.v(new com.facebook.react.views.image.b(g.this.getId(), 4));
        }

        @Override // e.f.h.c.c, e.f.h.c.d
        /* renamed from: h */
        public void b(String str, e.f.j.i.e eVar, Animatable animatable) {
            if (eVar != null) {
                this.f5313b.v(new com.facebook.react.views.image.b(g.this.getId(), 2, g.this.n.d(), eVar.getWidth(), eVar.getHeight()));
                this.f5313b.v(new com.facebook.react.views.image.b(g.this.getId(), 3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactImageView.java */
    /* loaded from: classes2.dex */
    public class b extends com.facebook.imagepipeline.request.a {
        private b() {
        }

        @Override // com.facebook.imagepipeline.request.a
        public void f(Bitmap bitmap, Bitmap bitmap2) {
            g.this.p(g.f5308g);
            bitmap.setHasAlpha(true);
            if (com.facebook.react.uimanager.d.a(g.f5308g[0], 0.0f) && com.facebook.react.uimanager.d.a(g.f5308g[1], 0.0f) && com.facebook.react.uimanager.d.a(g.f5308g[2], 0.0f) && com.facebook.react.uimanager.d.a(g.f5308g[3], 0.0f)) {
                super.f(bitmap, bitmap2);
                return;
            }
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            paint.setShader(new BitmapShader(bitmap2, tileMode, tileMode));
            Canvas canvas = new Canvas(bitmap);
            float[] fArr = new float[8];
            g(bitmap2, g.f5308g, fArr);
            Path path = new Path();
            path.addRoundRect(new RectF(0.0f, 0.0f, bitmap2.getWidth(), bitmap2.getHeight()), fArr, Path.Direction.CW);
            canvas.drawPath(path, paint);
        }

        void g(Bitmap bitmap, float[] fArr, float[] fArr2) {
            g.this.B.a(g.f5309h, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            g.f5309h.invert(g.f5310j);
            fArr2[0] = g.f5310j.mapRadius(fArr[0]);
            fArr2[1] = fArr2[0];
            fArr2[2] = g.f5310j.mapRadius(fArr[1]);
            fArr2[3] = fArr2[2];
            fArr2[4] = g.f5310j.mapRadius(fArr[2]);
            fArr2[5] = fArr2[4];
            fArr2[6] = g.f5310j.mapRadius(fArr[3]);
            fArr2[7] = fArr2[6];
        }

        /* synthetic */ b(g gVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactImageView.java */
    /* loaded from: classes2.dex */
    public class c extends com.facebook.imagepipeline.request.a {
        private c() {
        }

        @Override // com.facebook.imagepipeline.request.a, com.facebook.imagepipeline.request.c
        public com.facebook.common.references.a<Bitmap> b(Bitmap bitmap, e.f.j.c.f fVar) {
            Rect rect = new Rect(0, 0, g.this.getWidth(), g.this.getHeight());
            g.this.B.a(g.f5311k, rect, bitmap.getWidth(), bitmap.getHeight(), 0.0f, 0.0f);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            BitmapShader bitmapShader = new BitmapShader(bitmap, g.this.C, g.this.C);
            bitmapShader.setLocalMatrix(g.f5311k);
            paint.setShader(bitmapShader);
            com.facebook.common.references.a<Bitmap> a = fVar.a(g.this.getWidth(), g.this.getHeight());
            try {
                new Canvas(a.n()).drawRect(rect, paint);
                return a.clone();
            } finally {
                com.facebook.common.references.a.f(a);
            }
        }

        /* synthetic */ c(g gVar, a aVar) {
            this();
        }
    }

    public g(Context context, e.f.h.c.b bVar, com.facebook.react.views.image.a aVar, Object obj) {
        super(context, o(context));
        this.f5312l = com.facebook.react.views.image.c.AUTO;
        this.v = 0;
        this.z = Float.NaN;
        this.C = d.a();
        this.M = -1;
        this.B = d.b();
        this.E = bVar;
        this.F = new b(this, null);
        this.G = new c(this, null);
        this.K = aVar;
        this.L = obj;
        this.m = new LinkedList();
    }

    private static e.f.h.f.a o(Context context) {
        return new e.f.h.f.b(context.getResources()).u(e.f.h.f.d.a(0.0f)).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(float[] fArr) {
        float f2 = !com.facebook.yoga.g.a(this.z) ? this.z : 0.0f;
        float[] fArr2 = this.A;
        fArr[0] = (fArr2 == null || com.facebook.yoga.g.a(fArr2[0])) ? f2 : this.A[0];
        float[] fArr3 = this.A;
        fArr[1] = (fArr3 == null || com.facebook.yoga.g.a(fArr3[1])) ? f2 : this.A[1];
        float[] fArr4 = this.A;
        fArr[2] = (fArr4 == null || com.facebook.yoga.g.a(fArr4[2])) ? f2 : this.A[2];
        float[] fArr5 = this.A;
        if (fArr5 != null && !com.facebook.yoga.g.a(fArr5[3])) {
            f2 = this.A[3];
        }
        fArr[3] = f2;
    }

    private boolean q() {
        return this.m.size() > 1;
    }

    private boolean r() {
        return this.C != Shader.TileMode.CLAMP;
    }

    private void u() {
        this.n = null;
        if (this.m.isEmpty()) {
            this.m.add(new e.f.m.b0.b.a(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="));
        } else if (q()) {
            b.C0283b a2 = e.f.m.b0.b.b.a(getWidth(), getHeight(), this.m);
            this.n = a2.a();
            this.p = a2.b();
            return;
        }
        this.n = this.m.get(0);
    }

    private boolean v(e.f.m.b0.b.a aVar) {
        com.facebook.react.views.image.c cVar = this.f5312l;
        return cVar == com.facebook.react.views.image.c.AUTO ? com.facebook.common.util.e.h(aVar.e()) || com.facebook.common.util.e.i(aVar.e()) : cVar == com.facebook.react.views.image.c.RESIZE;
    }

    private void x(String str) {
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 <= 0 || i3 <= 0) {
            return;
        }
        this.D = this.D || q() || r();
        s();
    }

    public void s() {
        if (this.D) {
            if (!q() || (getWidth() > 0 && getHeight() > 0)) {
                u();
                e.f.m.b0.b.a aVar = this.n;
                if (aVar == null) {
                    return;
                }
                boolean v = v(aVar);
                if (!v || (getWidth() > 0 && getHeight() > 0)) {
                    if (!r() || (getWidth() > 0 && getHeight() > 0)) {
                        e.f.h.f.a hierarchy = getHierarchy();
                        hierarchy.q(this.B);
                        Drawable drawable = this.q;
                        if (drawable != null) {
                            hierarchy.u(drawable, this.B);
                        }
                        Drawable drawable2 = this.t;
                        if (drawable2 != null) {
                            hierarchy.u(drawable2, q.b.f12316e);
                        }
                        q.b bVar = this.B;
                        boolean z = (bVar == q.b.f12318g || bVar == q.b.f12319h) ? false : true;
                        e.f.h.f.d m = hierarchy.m();
                        p(f5308g);
                        float[] fArr = f5308g;
                        m.m(fArr[0], fArr[1], fArr[2], fArr[3]);
                        l lVar = this.u;
                        if (lVar != null) {
                            lVar.a(this.w, this.y);
                            this.u.l(m.d());
                            hierarchy.r(this.u);
                        }
                        if (z) {
                            m.n(0.0f);
                        }
                        m.l(this.w, this.y);
                        int i2 = this.x;
                        if (i2 != 0) {
                            m.o(i2);
                        } else {
                            m.p(d.a.BITMAP_ONLY);
                        }
                        hierarchy.w(m);
                        int i3 = this.M;
                        if (i3 < 0) {
                            i3 = this.n.f() ? 0 : HttpStatus.SC_MULTIPLE_CHOICES;
                        }
                        hierarchy.t(i3);
                        LinkedList linkedList = new LinkedList();
                        if (z) {
                            linkedList.add(this.F);
                        }
                        e.f.j.k.a aVar2 = this.H;
                        if (aVar2 != null) {
                            linkedList.add(aVar2);
                        }
                        if (r()) {
                            linkedList.add(this.G);
                        }
                        com.facebook.imagepipeline.request.c d2 = e.d(linkedList);
                        com.facebook.imagepipeline.common.e eVar = v ? new com.facebook.imagepipeline.common.e(getWidth(), getHeight()) : null;
                        com.facebook.react.modules.fresco.a w = com.facebook.react.modules.fresco.a.w(ImageRequestBuilder.r(this.n.e()).y(d2).C(eVar).s(true).z(this.N), this.O);
                        com.facebook.react.views.image.a aVar3 = this.K;
                        if (aVar3 != null) {
                            aVar3.a(this.n.e());
                        }
                        this.E.w();
                        this.E.x(true).y(this.L).b(getController()).A(w);
                        e.f.m.b0.b.a aVar4 = this.p;
                        if (aVar4 != null) {
                            this.E.B(ImageRequestBuilder.r(aVar4.e()).y(d2).C(eVar).s(true).z(this.N).a());
                        }
                        e.f.h.c.d dVar = this.I;
                        if (dVar != null && this.J != null) {
                            e.f.h.c.f fVar = new e.f.h.c.f();
                            fVar.g(this.I);
                            fVar.g(this.J);
                            this.E.z(fVar);
                        } else {
                            e.f.h.c.d dVar2 = this.J;
                            if (dVar2 != null) {
                                this.E.z(dVar2);
                            } else if (dVar != null) {
                                this.E.z(dVar);
                            }
                        }
                        setController(this.E.build());
                        this.D = false;
                        this.E.w();
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i2) {
        if (this.v != i2) {
            this.v = i2;
            this.u = new l(i2);
            this.D = true;
        }
    }

    public void setBlurRadius(float f2) {
        int c2 = (int) o.c(f2);
        if (c2 == 0) {
            this.H = null;
        } else {
            this.H = new e.f.j.k.a(c2);
        }
        this.D = true;
    }

    public void setBorderColor(int i2) {
        this.w = i2;
        this.D = true;
    }

    public void setBorderRadius(float f2) {
        if (com.facebook.react.uimanager.d.a(this.z, f2)) {
            return;
        }
        this.z = f2;
        this.D = true;
    }

    public void setBorderWidth(float f2) {
        this.y = o.c(f2);
        this.D = true;
    }

    public void setControllerListener(e.f.h.c.d dVar) {
        this.J = dVar;
        this.D = true;
        s();
    }

    public void setDefaultSource(String str) {
        this.q = e.f.m.b0.b.c.a().b(getContext(), str);
        this.D = true;
    }

    public void setFadeDuration(int i2) {
        this.M = i2;
    }

    public void setHeaders(ReadableMap readableMap) {
        this.O = readableMap;
    }

    public void setLoadingIndicatorSource(String str) {
        Drawable b2 = e.f.m.b0.b.c.a().b(getContext(), str);
        this.t = b2 != null ? new e.f.h.e.b(b2, RNCWebViewManager.COMMAND_CLEAR_FORM_DATA) : null;
        this.D = true;
    }

    public void setOverlayColor(int i2) {
        this.x = i2;
        this.D = true;
    }

    public void setProgressiveRenderingEnabled(boolean z) {
        this.N = z;
    }

    public void setResizeMethod(com.facebook.react.views.image.c cVar) {
        this.f5312l = cVar;
        this.D = true;
    }

    public void setScaleType(q.b bVar) {
        this.B = bVar;
        this.D = true;
    }

    public void setShouldNotifyLoadEvents(boolean z) {
        if (!z) {
            this.I = null;
        } else {
            this.I = new a(o0.b((ReactContext) getContext(), getId()));
        }
        this.D = true;
    }

    public void setSource(ReadableArray readableArray) {
        this.m.clear();
        if (readableArray != null && readableArray.size() != 0) {
            if (readableArray.size() == 1) {
                String string = readableArray.getMap(0).getString("uri");
                e.f.m.b0.b.a aVar = new e.f.m.b0.b.a(getContext(), string);
                this.m.add(aVar);
                if (Uri.EMPTY.equals(aVar.e())) {
                    x(string);
                }
            } else {
                for (int i2 = 0; i2 < readableArray.size(); i2++) {
                    ReadableMap map = readableArray.getMap(i2);
                    String string2 = map.getString("uri");
                    e.f.m.b0.b.a aVar2 = new e.f.m.b0.b.a(getContext(), string2, map.getDouble("width"), map.getDouble("height"));
                    this.m.add(aVar2);
                    if (Uri.EMPTY.equals(aVar2.e())) {
                        x(string2);
                    }
                }
            }
        } else {
            this.m.add(new e.f.m.b0.b.a(getContext(), "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAQAAAC1HAwCAAAAC0lEQVR42mNkYAAAAAYAAjCB0C8AAAAASUVORK5CYII="));
        }
        this.D = true;
    }

    public void setTileMode(Shader.TileMode tileMode) {
        this.C = tileMode;
        this.D = true;
    }

    public void t(float f2, int i2) {
        if (this.A == null) {
            float[] fArr = new float[4];
            this.A = fArr;
            Arrays.fill(fArr, Float.NaN);
        }
        if (com.facebook.react.uimanager.d.a(this.A[i2], f2)) {
            return;
        }
        this.A[i2] = f2;
        this.D = true;
    }

    public void w(Object obj) {
        this.L = obj;
        this.D = true;
    }
}