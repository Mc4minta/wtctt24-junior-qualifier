package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.coinbase.ApiConstants;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.UIManagerModule;
import com.horcrux.svg.c0;
import java.util.ArrayList;

/* compiled from: VirtualView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public abstract class x0 extends com.facebook.react.views.view.f {
    private static final float[] w = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    Matrix A;
    Matrix B;
    Matrix C;
    Matrix D;
    final Matrix E;
    boolean F;
    boolean G;
    boolean H;
    private RectF I;
    int J;
    private String K;
    String L;
    String M;
    String N;
    String O;
    final float P;
    private boolean Q;
    private boolean R;
    String S;
    String T;
    private f0 U;
    private Path V;
    private l W;
    private double a0;
    private double b0;
    private float c0;
    private float d0;
    private j e0;
    Path f0;
    Path g0;
    Path h0;
    Path i0;
    Path j0;
    RectF k0;
    RectF l0;
    RectF m0;
    RectF n0;
    RectF o0;
    Region p0;
    Region q0;
    Region r0;
    Region s0;
    ArrayList<r> t0;
    com.facebook.react.uimanager.p u0;
    final ReactContext x;
    float y;
    Matrix z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VirtualView.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c0.b.values().length];
            a = iArr;
            try {
                iArr[c0.b.EMS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c0.b.EXS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c0.b.CM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c0.b.MM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c0.b.IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c0.b.PT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[c0.b.PC.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x0(ReactContext reactContext) {
        super(reactContext);
        this.y = 1.0f;
        this.z = new Matrix();
        this.A = new Matrix();
        this.B = new Matrix();
        this.C = new Matrix();
        this.D = new Matrix();
        this.E = new Matrix();
        this.F = true;
        this.G = true;
        this.H = true;
        this.a0 = -1.0d;
        this.b0 = -1.0d;
        this.c0 = -1.0f;
        this.d0 = -1.0f;
        this.x = reactContext;
        this.P = com.facebook.react.uimanager.c.e().density;
    }

    private void A() {
        x0 x0Var = this;
        while (true) {
            ViewParent parent = x0Var.getParent();
            if (!(parent instanceof x0)) {
                return;
            }
            x0Var = (x0) parent;
            if (x0Var.f0 == null) {
                return;
            }
            x0Var.y();
        }
    }

    private double D(c0 c0Var) {
        double fontSizeFromContext;
        switch (a.a[c0Var.f10211b.ordinal()]) {
            case 1:
                fontSizeFromContext = getFontSizeFromContext();
                break;
            case 2:
                fontSizeFromContext = getFontSizeFromContext() / 2.0d;
                break;
            case 3:
                fontSizeFromContext = 35.43307d;
                break;
            case 4:
                fontSizeFromContext = 3.543307d;
                break;
            case 5:
                fontSizeFromContext = 90.0d;
                break;
            case 6:
                fontSizeFromContext = 1.25d;
                break;
            case 7:
                fontSizeFromContext = 15.0d;
                break;
            default:
                fontSizeFromContext = 1.0d;
                break;
        }
        return c0Var.a * fontSizeFromContext * this.P;
    }

    private double getCanvasDiagonal() {
        double d2 = this.b0;
        if (d2 != -1.0d) {
            return d2;
        }
        double sqrt = Math.sqrt(Math.pow(getCanvasWidth(), 2.0d) + Math.pow(getCanvasHeight(), 2.0d)) * 0.7071067811865476d;
        this.b0 = sqrt;
        return sqrt;
    }

    private float getCanvasHeight() {
        float f2 = this.c0;
        if (f2 != -1.0f) {
            return f2;
        }
        l textRoot = getTextRoot();
        if (textRoot == null) {
            this.c0 = getSvgView().getCanvasBounds().height();
        } else {
            this.c0 = textRoot.b0().d();
        }
        return this.c0;
    }

    private float getCanvasWidth() {
        float f2 = this.d0;
        if (f2 != -1.0f) {
            return f2;
        }
        l textRoot = getTextRoot();
        if (textRoot == null) {
            this.d0 = getSvgView().getCanvasBounds().width();
        } else {
            this.d0 = textRoot.b0().g();
        }
        return this.d0;
    }

    private double getFontSizeFromContext() {
        double d2 = this.a0;
        if (d2 != -1.0d) {
            return d2;
        }
        l textRoot = getTextRoot();
        if (textRoot == null) {
            return 12.0d;
        }
        if (this.e0 == null) {
            this.e0 = textRoot.b0();
        }
        double c2 = this.e0.c();
        this.a0 = c2;
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Canvas canvas, Paint paint) {
        Path E = E(canvas, paint);
        if (E != null) {
            canvas.clipPath(E);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void C(Canvas canvas, Paint paint, float f2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path E(Canvas canvas, Paint paint) {
        if (this.K != null) {
            c cVar = (c) getSvgView().I(this.K);
            if (cVar != null) {
                Path F = cVar.J == 0 ? cVar.F(canvas, paint) : cVar.c0(canvas, paint, Region.Op.UNION);
                F.transform(cVar.A);
                F.transform(cVar.B);
                int i2 = cVar.J;
                if (i2 == 0) {
                    F.setFillType(Path.FillType.EVEN_ODD);
                } else if (i2 != 1) {
                    e.f.d.d.a.A("ReactNative", "RNSVG: clipRule: " + this.J + " unrecognized");
                }
                this.V = F;
            } else {
                e.f.d.d.a.A("ReactNative", "RNSVG: Undefined clipPath: " + this.K);
            }
        }
        return getClipPath();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Path F(Canvas canvas, Paint paint);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int G(float[] fArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean H() {
        return this.Q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double I(c0 c0Var) {
        double d2;
        float canvasHeight;
        c0.b bVar = c0Var.f10211b;
        if (bVar == c0.b.NUMBER) {
            d2 = c0Var.a;
            canvasHeight = this.P;
        } else if (bVar == c0.b.PERCENTAGE) {
            d2 = c0Var.a / 100.0d;
            canvasHeight = getCanvasHeight();
        } else {
            return D(c0Var);
        }
        return d2 * canvasHeight;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double J(c0 c0Var) {
        double d2;
        double canvasDiagonal;
        c0.b bVar = c0Var.f10211b;
        if (bVar == c0.b.NUMBER) {
            d2 = c0Var.a;
            canvasDiagonal = this.P;
        } else if (bVar == c0.b.PERCENTAGE) {
            d2 = c0Var.a / 100.0d;
            canvasDiagonal = getCanvasDiagonal();
        } else {
            return D(c0Var);
        }
        return d2 * canvasDiagonal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double K(c0 c0Var) {
        double d2;
        float canvasWidth;
        c0.b bVar = c0Var.f10211b;
        if (bVar == c0.b.NUMBER) {
            d2 = c0Var.a;
            canvasWidth = this.P;
        } else if (bVar == c0.b.PERCENTAGE) {
            d2 = c0Var.a / 100.0d;
            canvasWidth = getCanvasWidth();
        } else {
            return D(c0Var);
        }
        return d2 * canvasWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(Canvas canvas, Paint paint, float f2) {
        C(canvas, paint, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(Canvas canvas, int i2) {
        canvas.restoreToCount(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int N(Canvas canvas, Matrix matrix) {
        int save = canvas.save();
        this.z.setConcat(this.A, this.B);
        canvas.concat(this.z);
        this.z.preConcat(matrix);
        this.G = this.z.invert(this.C);
        return save;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        if (this.T != null) {
            getSvgView().D(this, this.T);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF getClientRect() {
        return this.I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path getClipPath() {
        return this.V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l getParentTextRoot() {
        ViewParent parent = getParent();
        if (parent instanceof x0) {
            return ((x0) parent).getTextRoot();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0 getSvgView() {
        f0 f0Var = this.U;
        if (f0Var != null) {
            return f0Var;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            return null;
        }
        if (parent instanceof f0) {
            this.U = (f0) parent;
        } else if (parent instanceof x0) {
            this.U = ((x0) parent).getSvgView();
        } else {
            e.f.d.d.a.i("ReactNative", "RNSVG: " + getClass().getName() + " should be descendant of a SvgView.");
        }
        return this.U;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l getTextRoot() {
        if (this.W == null) {
            x0 x0Var = this;
            while (true) {
                if (x0Var == null) {
                    break;
                }
                if (x0Var instanceof l) {
                    l lVar = (l) x0Var;
                    if (lVar.b0() != null) {
                        this.W = lVar;
                        break;
                    }
                }
                ViewParent parent = x0Var.getParent();
                x0Var = !(parent instanceof x0) ? null : (x0) parent;
            }
        }
        return this.W;
    }

    @Override // android.view.View
    public void invalidate() {
        if ((this instanceof b0) && this.f0 == null) {
            return;
        }
        y();
        A();
        super.invalidate();
    }

    @Override // com.facebook.react.views.view.f, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        RectF rectF = this.I;
        if (rectF == null) {
            return;
        }
        if (!(this instanceof l)) {
            setLeft((int) Math.floor(rectF.left));
            setTop((int) Math.floor(this.I.top));
            setRight((int) Math.ceil(this.I.right));
            setBottom((int) Math.ceil(this.I.bottom));
        }
        setMeasuredDimension((int) Math.ceil(this.I.width()), (int) Math.ceil(this.I.height()));
    }

    @Override // com.facebook.react.views.view.f, android.view.View
    protected void onMeasure(int i2, int i3) {
        int defaultSize;
        int defaultSize2;
        RectF rectF = this.I;
        if (rectF != null) {
            defaultSize = (int) Math.ceil(rectF.width());
        } else {
            defaultSize = ViewGroup.getDefaultSize(getSuggestedMinimumWidth(), i2);
        }
        RectF rectF2 = this.I;
        if (rectF2 != null) {
            defaultSize2 = (int) Math.ceil(rectF2.height());
        } else {
            defaultSize2 = ViewGroup.getDefaultSize(getSuggestedMinimumHeight(), i3);
        }
        setMeasuredDimension(defaultSize, defaultSize2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setClientRect(RectF rectF) {
        RectF rectF2 = this.I;
        if (rectF2 == null || !rectF2.equals(rectF)) {
            this.I = rectF;
            if (rectF == null) {
                return;
            }
            int ceil = (int) Math.ceil(rectF.width());
            int ceil2 = (int) Math.ceil(this.I.height());
            int floor = (int) Math.floor(this.I.left);
            int floor2 = (int) Math.floor(this.I.top);
            int ceil3 = (int) Math.ceil(this.I.right);
            int ceil4 = (int) Math.ceil(this.I.bottom);
            setMeasuredDimension(ceil, ceil2);
            if (!(this instanceof l)) {
                setLeft(floor);
                setTop(floor2);
                setRight(ceil3);
                setBottom(ceil4);
            }
            if (this.R) {
                ((UIManagerModule) this.x.getNativeModule(UIManagerModule.class)).getEventDispatcher().v(com.facebook.react.uimanager.n.n(getId(), floor, floor2, ceil, ceil2));
            }
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "clipPath")
    public void setClipPath(String str) {
        this.V = null;
        this.K = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "clipRule")
    public void setClipRule(int i2) {
        this.J = i2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "display")
    public void setDisplay(String str) {
        this.S = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerEnd")
    public void setMarkerEnd(String str) {
        this.O = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerMid")
    public void setMarkerMid(String str) {
        this.N = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "markerStart")
    public void setMarkerStart(String str) {
        this.M = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "mask")
    public void setMask(String str) {
        this.L = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "matrix")
    public void setMatrix(Dynamic dynamic) {
        ReadableType type = dynamic.getType();
        if (!dynamic.isNull() && type.equals(ReadableType.Array)) {
            ReadableArray asArray = dynamic.asArray();
            float[] fArr = w;
            int c2 = w.c(asArray, fArr, this.P);
            if (c2 == 6) {
                if (this.A == null) {
                    this.A = new Matrix();
                    this.D = new Matrix();
                }
                this.A.setValues(fArr);
                this.F = this.A.invert(this.D);
            } else if (c2 != -1) {
                e.f.d.d.a.A("ReactNative", "RNSVG: Transform matrices must be of size 6");
            }
        } else {
            this.A.reset();
            this.D.reset();
            this.F = true;
        }
        super.invalidate();
        A();
    }

    @com.facebook.react.uimanager.c1.a(name = ApiConstants.NAME)
    public void setName(String str) {
        this.T = str;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "onLayout")
    public void setOnLayout(boolean z) {
        this.R = z;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(float f2) {
        this.y = f2;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPointerEvents(com.facebook.react.uimanager.p pVar) {
        this.u0 = pVar;
    }

    @com.facebook.react.uimanager.c1.a(name = "responsible")
    public void setResponsible(boolean z) {
        this.Q = z;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        this.b0 = -1.0d;
        this.c0 = -1.0f;
        this.d0 = -1.0f;
        this.a0 = -1.0d;
        this.r0 = null;
        this.q0 = null;
        this.p0 = null;
        this.f0 = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        y();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof x0) {
                ((x0) childAt).z();
            }
        }
    }
}