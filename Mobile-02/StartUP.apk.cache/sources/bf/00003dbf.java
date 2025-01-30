package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.Base64;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: SvgView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class f0 extends com.facebook.react.views.view.f implements com.facebook.react.uimanager.t, com.facebook.react.uimanager.u {
    private final Map<String, x0> A;
    private final Map<String, x0> B;
    private final Map<String, x0> C;
    private final Map<String, a> D;
    private Canvas E;
    private final float F;
    private float G;
    private float H;
    private float I;
    private float J;
    private c0 K;
    private c0 L;
    private String M;
    private int N;
    final Matrix O;
    private boolean P;
    private boolean Q;
    int R;
    private Bitmap w;
    private Runnable x;
    private boolean y;
    private final Map<String, x0> z;

    public f0(ReactContext reactContext) {
        super(reactContext);
        this.x = null;
        this.y = false;
        this.z = new HashMap();
        this.A = new HashMap();
        this.B = new HashMap();
        this.C = new HashMap();
        this.D = new HashMap();
        this.O = new Matrix();
        this.P = true;
        this.Q = false;
        this.R = 0;
        this.F = com.facebook.react.uimanager.c.e().density;
    }

    private Bitmap F() {
        boolean z = true;
        this.Q = true;
        float width = getWidth();
        float height = getHeight();
        if (!Float.isNaN(width) && !Float.isNaN(height) && width >= 1.0f && height >= 1.0f && Math.log10(width) + Math.log10(height) <= 42.0d) {
            z = false;
        }
        if (z) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        E(new Canvas(createBitmap));
        return createBitmap;
    }

    private int M(float f2, float f3) {
        if (this.y && this.P) {
            float[] fArr = {f2, f3};
            this.O.mapPoints(fArr);
            int i2 = -1;
            for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = getChildAt(childCount);
                if (childAt instanceof x0) {
                    i2 = ((x0) childAt).G(fArr);
                } else if (childAt instanceof f0) {
                    i2 = ((f0) childAt).M(f2, f3);
                }
                if (i2 != -1) {
                    break;
                }
            }
            return i2 == -1 ? getId() : i2;
        }
        return getId();
    }

    private RectF getViewBox() {
        float f2 = this.G;
        float f3 = this.F;
        float f4 = this.H;
        return new RectF(f2 * f3, f4 * f3, (f2 + this.I) * f3, (f4 + this.J) * f3);
    }

    private void y() {
        if (this.Q) {
            this.Q = false;
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof x0) {
                    ((x0) childAt).z();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(x0 x0Var, String str) {
        this.z.put(str, x0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(x0 x0Var, String str) {
        this.B.put(str, x0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(x0 x0Var, String str) {
        this.C.put(str, x0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(x0 x0Var, String str) {
        this.A.put(str, x0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void E(Canvas canvas) {
        this.Q = true;
        this.E = canvas;
        Matrix matrix = new Matrix();
        if (this.M != null) {
            RectF viewBox = getViewBox();
            float width = canvas.getWidth();
            float height = canvas.getHeight();
            boolean z = getParent() instanceof x0;
            if (z) {
                width = (float) w.a(this.K, width, 0.0d, this.F, 12.0d);
                height = (float) w.a(this.L, height, 0.0d, this.F, 12.0d);
            }
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            if (z) {
                canvas.clipRect(rectF);
            }
            matrix = w0.a(viewBox, rectF, this.M, this.N);
            this.P = matrix.invert(this.O);
            canvas.concat(matrix);
        }
        Paint paint = new Paint();
        paint.setFlags(385);
        paint.setTypeface(Typeface.DEFAULT);
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof x0) {
                ((x0) childAt).O();
            }
        }
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            if (childAt2 instanceof x0) {
                x0 x0Var = (x0) childAt2;
                int N = x0Var.N(canvas, matrix);
                x0Var.L(canvas, paint, 1.0f);
                x0Var.M(canvas, N);
                if (x0Var.H() && !this.y) {
                    this.y = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G() {
        if (this.y) {
            return;
        }
        this.y = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a H(String str) {
        return this.D.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 I(String str) {
        return this.z.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 J(String str) {
        return this.B.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 K(String str) {
        return this.C.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0 L(String str) {
        return this.A.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        return !this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String P() {
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        y();
        E(new Canvas(createBitmap));
        y();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String Q(int i2, int i3) {
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        y();
        E(new Canvas(createBitmap));
        y();
        invalidate();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        createBitmap.recycle();
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    @Override // com.facebook.react.uimanager.t
    public int c(float f2, float f3) {
        return M(f2, f3);
    }

    @Override // com.facebook.react.uimanager.u
    public boolean e(float f2, float f3) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect getCanvasBounds() {
        return this.E.getClipBounds();
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        ViewParent parent = getParent();
        if (parent instanceof x0) {
            if (this.Q) {
                this.Q = false;
                ((x0) parent).getSvgView().invalidate();
                return;
            }
            return;
        }
        Bitmap bitmap = this.w;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.w = null;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (getParent() instanceof x0) {
            return;
        }
        super.onDraw(canvas);
        if (this.w == null) {
            this.w = F();
        }
        Bitmap bitmap = this.w;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            Runnable runnable = this.x;
            if (runnable != null) {
                runnable.run();
                this.x = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.views.view.f, android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "align")
    public void setAlign(String str) {
        this.M = str;
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "bbHeight")
    public void setBbHeight(Dynamic dynamic) {
        this.L = c0.b(dynamic);
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "bbWidth")
    public void setBbWidth(Dynamic dynamic) {
        this.K = c0.b(dynamic);
        invalidate();
        y();
    }

    @Override // android.view.View
    public void setId(int i2) {
        super.setId(i2);
        SvgViewManager.setSvgView(i2, this);
    }

    @com.facebook.react.uimanager.c1.a(name = "meetOrSlice")
    public void setMeetOrSlice(int i2) {
        this.N = i2;
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "minX")
    public void setMinX(float f2) {
        this.G = f2;
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "minY")
    public void setMinY(float f2) {
        this.H = f2;
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "tintColor")
    public void setTintColor(Integer num) {
        if (num == null) {
            this.R = 0;
        } else {
            this.R = num.intValue();
        }
        invalidate();
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setToDataUrlTask(Runnable runnable) {
        this.x = runnable;
    }

    @com.facebook.react.uimanager.c1.a(name = "vbHeight")
    public void setVbHeight(float f2) {
        this.J = f2;
        invalidate();
        y();
    }

    @com.facebook.react.uimanager.c1.a(name = "vbWidth")
    public void setVbWidth(float f2) {
        this.I = f2;
        invalidate();
        y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(a aVar, String str) {
        this.D.put(str, aVar);
    }
}