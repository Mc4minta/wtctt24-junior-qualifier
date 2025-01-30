package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ImageView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class m extends b0 {
    private c0 N0;
    private c0 O0;
    private c0 P0;
    private c0 Q0;
    private String R0;
    private int S0;
    private int T0;
    private String U0;
    private int V0;
    private final AtomicBoolean W0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ImageView.java */
    /* loaded from: classes2.dex */
    public class a extends e.f.j.f.b {
        a() {
        }

        @Override // e.f.e.b
        public void e(e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> cVar) {
            m.this.W0.set(false);
            e.f.d.d.a.D("ReactNative", cVar.c(), "RNSVG: fetchDecodedImage failed!", new Object[0]);
        }

        @Override // e.f.j.f.b
        public void g(Bitmap bitmap) {
            m.this.W0.set(false);
            f0 svgView = m.this.getSvgView();
            if (svgView != null) {
                svgView.invalidate();
            }
        }
    }

    public m(ReactContext reactContext) {
        super(reactContext);
        this.W0 = new AtomicBoolean(false);
    }

    private void a0(Canvas canvas, Paint paint, Bitmap bitmap, float f2) {
        if (this.S0 == 0 || this.T0 == 0) {
            this.S0 = bitmap.getWidth();
            this.T0 = bitmap.getHeight();
        }
        RectF b0 = b0();
        RectF rectF = new RectF(0.0f, 0.0f, this.S0, this.T0);
        w0.a(rectF, b0, this.U0, this.V0).mapRect(rectF);
        canvas.clipPath(F(canvas, paint));
        Path E = E(canvas, paint);
        if (E != null) {
            canvas.clipPath(E);
        }
        Paint paint2 = new Paint();
        paint2.setAlpha((int) (f2 * 255.0f));
        canvas.drawBitmap(bitmap, (Rect) null, rectF, paint2);
        this.z.mapRect(rectF);
        setClientRect(rectF);
    }

    private RectF b0() {
        double K = K(this.N0);
        double I = I(this.O0);
        double K2 = K(this.P0);
        double I2 = I(this.Q0);
        if (K2 == 0.0d) {
            K2 = this.S0 * this.P;
        }
        if (I2 == 0.0d) {
            I2 = this.T0 * this.P;
        }
        return new RectF((float) K, (float) I, (float) (K + K2), (float) (I + I2));
    }

    private void c0(e.f.j.e.h hVar, com.facebook.imagepipeline.request.b bVar) {
        this.W0.set(true);
        hVar.d(bVar, this.x).g(new a(), e.f.d.b.e.g());
    }

    private void d0(e.f.j.e.h hVar, com.facebook.imagepipeline.request.b bVar, Canvas canvas, Paint paint, float f2) {
        e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> g2 = hVar.g(bVar, this.x);
        try {
            try {
                com.facebook.common.references.a<e.f.j.i.b> f3 = g2.f();
                if (f3 == null) {
                    return;
                }
                try {
                    try {
                        e.f.j.i.b n = f3.n();
                        if (n instanceof e.f.j.i.a) {
                            Bitmap d2 = ((e.f.j.i.a) n).d();
                            if (d2 == null) {
                                return;
                            }
                            a0(canvas, paint, d2, f2);
                        }
                    } finally {
                        com.facebook.common.references.a.f(f3);
                    }
                } catch (Exception e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (Exception e3) {
                throw new IllegalStateException(e3);
            }
        } finally {
            g2.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.b0, com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        if (this.W0.get()) {
            return;
        }
        e.f.j.e.h a2 = e.f.h.a.a.c.a();
        com.facebook.imagepipeline.request.b a3 = com.facebook.imagepipeline.request.b.a(new e.f.m.b0.b.a(this.x, this.R0).e());
        if (a2.m(a3)) {
            d0(a2, a3, canvas, paint, f2 * this.y);
        } else {
            c0(a2, a3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public Path F(Canvas canvas, Paint paint) {
        Path path = new Path();
        this.f0 = path;
        path.addRect(b0(), Path.Direction.CW);
        return this.f0;
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(String str) {
        this.U0 = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        this.Q0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.V0 = i2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "src")
    public void setSrc(ReadableMap readableMap) {
        if (readableMap != null) {
            String string = readableMap.getString("uri");
            this.R0 = string;
            if (string == null || string.isEmpty()) {
                return;
            }
            if (readableMap.hasKey("width") && readableMap.hasKey("height")) {
                this.S0 = readableMap.getInt("width");
                this.T0 = readableMap.getInt("height");
            } else {
                this.S0 = 0;
                this.T0 = 0;
            }
            if (Uri.parse(this.R0).getScheme() == null) {
                e.f.m.b0.b.c.a().d(this.x, this.R0);
            }
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        this.P0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "x")
    public void setX(Dynamic dynamic) {
        this.N0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "y")
    public void setY(Dynamic dynamic) {
        this.O0 = c0.b(dynamic);
        invalidate();
    }
}