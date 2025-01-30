package com.horcrux.svg;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.JavaOnlyArray;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: RenderableView.java */
/* loaded from: classes2.dex */
public abstract class b0 extends x0 {
    static b0 v0;
    private static final Pattern w0 = Pattern.compile("[0-9.-]+");
    public c0 A0;
    public float B0;
    public float C0;
    public float D0;
    public Paint.Cap E0;
    public Paint.Join F0;
    public ReadableArray G0;
    public float H0;
    public Path.FillType I0;
    private ArrayList<String> J0;
    private ArrayList<Object> K0;
    private ArrayList<String> L0;
    private ArrayList<String> M0;
    public int x0;
    public ReadableArray y0;
    public c0[] z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RenderableView.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[y.values().length];
            a = iArr;
            try {
                iArr[y.kStartMarker.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[y.kMidMarker.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[y.kEndMarker.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b0(ReactContext reactContext) {
        super(reactContext);
        this.x0 = 0;
        this.A0 = new c0(1.0d);
        this.B0 = 1.0f;
        this.C0 = 4.0f;
        this.D0 = 0.0f;
        this.E0 = Paint.Cap.BUTT;
        this.F0 = Paint.Join.MITER;
        this.H0 = 1.0f;
        this.I0 = Path.FillType.WINDING;
        setPivotX(0.0f);
        setPivotY(0.0f);
    }

    private boolean Q(String str) {
        ArrayList<String> arrayList = this.M0;
        return arrayList != null && arrayList.contains(str);
    }

    private static double V(double d2) {
        if (d2 <= 0.0d) {
            return 0.0d;
        }
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        return d2;
    }

    private void X(Paint paint, float f2, ReadableArray readableArray) {
        ReadableArray readableArray2;
        b0 b0Var;
        ReadableArray readableArray3;
        int i2 = readableArray.getInt(0);
        if (i2 == 0) {
            if (readableArray.size() == 2) {
                int i3 = readableArray.getInt(1);
                paint.setColor((Math.round((i3 >>> 24) * f2) << 24) | (i3 & 16777215));
                return;
            }
            paint.setARGB((int) (readableArray.size() > 4 ? readableArray.getDouble(4) * f2 * 255.0d : f2 * 255.0f), (int) (readableArray.getDouble(1) * 255.0d), (int) (readableArray.getDouble(2) * 255.0d), (int) (readableArray.getDouble(3) * 255.0d));
        } else if (i2 == 1) {
            com.horcrux.svg.a H = getSvgView().H(readableArray.getString(1));
            if (H != null) {
                H.i(paint, this.k0, this.P, f2);
            }
        } else if (i2 == 2) {
            paint.setColor(getSvgView().R);
        } else if (i2 != 3) {
            if (i2 != 4 || (b0Var = v0) == null || (readableArray3 = b0Var.y0) == null) {
                return;
            }
            X(paint, f2, readableArray3);
        } else {
            b0 b0Var2 = v0;
            if (b0Var2 == null || (readableArray2 = b0Var2.G0) == null) {
                return;
            }
            X(paint, f2, readableArray2);
        }
    }

    private ArrayList<String> getAttributeList() {
        return this.M0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public void C(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.y;
        boolean z = this.f0 == null;
        if (z) {
            Path F = F(canvas, paint);
            this.f0 = F;
            F.setFillType(this.I0);
        }
        boolean z2 = this.x0 == 1;
        Path path = this.f0;
        if (z2) {
            path = new Path();
            this.f0.transform(this.z, path);
            canvas.setMatrix(null);
        }
        if (z || path != this.f0) {
            RectF rectF = new RectF();
            this.k0 = rectF;
            path.computeBounds(rectF, true);
        }
        RectF rectF2 = new RectF(this.k0);
        this.z.mapRect(rectF2);
        setClientRect(rectF2);
        B(canvas, paint);
        if (W(paint, this.H0 * f3)) {
            if (z) {
                Path path2 = new Path();
                this.g0 = path2;
                paint.getFillPath(path, path2);
            }
            canvas.drawPath(path, paint);
        }
        if (Y(paint, this.B0 * f3)) {
            if (z) {
                Path path3 = new Path();
                this.h0 = path3;
                paint.getFillPath(path, path3);
            }
            canvas.drawPath(path, paint);
        }
        T(canvas, paint, f3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.x0
    public int G(float[] fArr) {
        Region region;
        Region region2;
        if (this.f0 == null || !this.F || !this.H || this.u0 == com.facebook.react.uimanager.p.NONE) {
            return -1;
        }
        float[] fArr2 = new float[2];
        this.D.mapPoints(fArr2, fArr);
        this.E.mapPoints(fArr2);
        int round = Math.round(fArr2[0]);
        int round2 = Math.round(fArr2[1]);
        R();
        Region region3 = this.p0;
        if ((region3 != null && region3.contains(round, round2)) || ((region = this.r0) != null && (region.contains(round, round2) || ((region2 = this.q0) != null && region2.contains(round, round2))))) {
            if (getClipPath() == null || this.s0.contains(round, round2)) {
                return getId();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.horcrux.svg.x0
    void L(Canvas canvas, Paint paint, float f2) {
        q qVar = this.L != null ? (q) getSvgView().K(this.L) : null;
        if (qVar != null) {
            Rect clipBounds = canvas.getClipBounds();
            int height = clipBounds.height();
            int width = clipBounds.width();
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Bitmap createBitmap3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            Canvas canvas3 = new Canvas(createBitmap);
            Canvas canvas4 = new Canvas(createBitmap3);
            canvas3.clipRect((float) K(qVar.Q0), (float) I(qVar.R0), (float) K(qVar.S0), (float) I(qVar.T0));
            Paint paint2 = new Paint(1);
            qVar.C(canvas3, paint2, 1.0f);
            int i2 = width * height;
            int[] iArr = new int[i2];
            createBitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            int i3 = 0;
            while (i3 < i2) {
                int i4 = iArr[i3];
                iArr[i3] = ((int) ((i4 >>> 24) * V((((((i4 >> 16) & 255) * 0.299d) + (((i4 >> 8) & 255) * 0.587d)) + ((i4 & 255) * 0.144d)) / 255.0d))) << 24;
                i3++;
                i2 = i2;
                paint2 = paint2;
            }
            Paint paint3 = paint2;
            createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            C(canvas2, paint, f2);
            paint3.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas4.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            canvas4.drawBitmap(createBitmap, 0.0f, 0.0f, paint3);
            canvas.drawBitmap(createBitmap3, 0.0f, 0.0f, paint);
            return;
        }
        C(canvas, paint, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Region P(Path path, RectF rectF) {
        Region region = new Region();
        region.setPath(path, new Region((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom)));
        return region;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R() {
        if (this.p0 == null && this.g0 != null) {
            RectF rectF = new RectF();
            this.l0 = rectF;
            this.g0.computeBounds(rectF, true);
            this.p0 = P(this.g0, this.l0);
        }
        if (this.p0 == null && this.f0 != null) {
            RectF rectF2 = new RectF();
            this.l0 = rectF2;
            this.f0.computeBounds(rectF2, true);
            this.p0 = P(this.f0, this.l0);
        }
        if (this.r0 == null && this.h0 != null) {
            RectF rectF3 = new RectF();
            this.m0 = rectF3;
            this.h0.computeBounds(rectF3, true);
            this.r0 = P(this.h0, this.m0);
        }
        if (this.q0 == null && this.i0 != null) {
            RectF rectF4 = new RectF();
            this.n0 = rectF4;
            this.i0.computeBounds(rectF4, true);
            this.q0 = P(this.i0, this.n0);
        }
        Path clipPath = getClipPath();
        if (clipPath == null || this.j0 == clipPath) {
            return;
        }
        this.j0 = clipPath;
        RectF rectF5 = new RectF();
        this.o0 = rectF5;
        clipPath.computeBounds(rectF5, true);
        this.s0 = P(clipPath, this.o0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void S(b0 b0Var) {
        ArrayList<String> attributeList = b0Var.getAttributeList();
        if (attributeList == null || attributeList.size() == 0) {
            return;
        }
        this.K0 = new ArrayList<>();
        this.M0 = this.L0 == null ? new ArrayList<>() : new ArrayList<>(this.L0);
        int size = attributeList.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                String str = attributeList.get(i2);
                Field field = getClass().getField(str);
                Object obj = field.get(b0Var);
                this.K0.add(field.get(this));
                if (!Q(str)) {
                    this.M0.add(str);
                    field.set(this, obj);
                }
            } catch (Exception e2) {
                throw new IllegalStateException(e2);
            }
        }
        this.J0 = attributeList;
    }

    void T(Canvas canvas, Paint paint, float f2) {
        p pVar = (p) getSvgView().J(this.M);
        p pVar2 = (p) getSvgView().J(this.N);
        p pVar3 = (p) getSvgView().J(this.O);
        ArrayList<r> arrayList = this.t0;
        if (arrayList != null) {
            if (pVar == null && pVar2 == null && pVar3 == null) {
                return;
            }
            v0 = this;
            ArrayList<x> h2 = x.h(arrayList);
            c0 c0Var = this.A0;
            float J = (float) (c0Var != null ? J(c0Var) : 1.0d);
            this.i0 = new Path();
            Iterator<x> it = h2.iterator();
            while (it.hasNext()) {
                x next = it.next();
                int i2 = a.a[next.f10320h.ordinal()];
                p pVar4 = i2 != 1 ? i2 != 2 ? i2 != 3 ? null : pVar3 : pVar2 : pVar;
                if (pVar4 != null) {
                    pVar4.i0(canvas, paint, f2, next, J);
                    this.i0.addPath(pVar4.F(canvas, paint), pVar4.b1);
                }
            }
            v0 = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U() {
        ArrayList<String> arrayList = this.J0;
        if (arrayList == null || this.K0 == null) {
            return;
        }
        try {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                getClass().getField(this.J0.get(size)).set(this, this.K0.get(size));
            }
            this.J0 = null;
            this.K0 = null;
            this.M0 = this.L0;
        } catch (Exception e2) {
            throw new IllegalStateException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean W(Paint paint, float f2) {
        ReadableArray readableArray = this.G0;
        if (readableArray == null || readableArray.size() <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(385);
        paint.setStyle(Paint.Style.FILL);
        X(paint, f2, this.G0);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean Y(Paint paint, float f2) {
        ReadableArray readableArray;
        paint.reset();
        double J = J(this.A0);
        if (J == 0.0d || (readableArray = this.y0) == null || readableArray.size() == 0) {
            return false;
        }
        paint.setFlags(385);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(this.E0);
        paint.setStrokeJoin(this.F0);
        paint.setStrokeMiter(this.C0 * this.P);
        paint.setStrokeWidth((float) J);
        X(paint, f2, this.y0);
        c0[] c0VarArr = this.z0;
        if (c0VarArr != null) {
            int length = c0VarArr.length;
            float[] fArr = new float[length];
            for (int i2 = 0; i2 < length; i2++) {
                fArr[i2] = (float) J(this.z0[i2]);
            }
            paint.setPathEffect(new DashPathEffect(fArr, this.D0));
            return true;
        }
        return true;
    }

    @com.facebook.react.uimanager.c1.a(name = "fill")
    public void setFill(Dynamic dynamic) {
        if (dynamic != null && !dynamic.isNull()) {
            ReadableType type = dynamic.getType();
            int i2 = 0;
            if (type.equals(ReadableType.Number)) {
                this.G0 = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
            } else if (type.equals(ReadableType.Array)) {
                this.G0 = dynamic.asArray();
            } else {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                javaOnlyArray.pushInt(0);
                Matcher matcher = w0.matcher(dynamic.asString());
                while (matcher.find()) {
                    double parseDouble = Double.parseDouble(matcher.group());
                    int i3 = i2 + 1;
                    if (i2 < 3) {
                        parseDouble /= 255.0d;
                    }
                    javaOnlyArray.pushDouble(parseDouble);
                    i2 = i3;
                }
                this.G0 = javaOnlyArray;
            }
            invalidate();
            return;
        }
        this.G0 = null;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "fillOpacity")
    public void setFillOpacity(float f2) {
        this.H0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "fillRule")
    public void setFillRule(int i2) {
        if (i2 == 0) {
            this.I0 = Path.FillType.EVEN_ODD;
        } else if (i2 != 1) {
            throw new JSApplicationIllegalArgumentException("fillRule " + i2 + " unrecognized");
        }
        invalidate();
    }

    @Override // android.view.View
    public void setId(int i2) {
        super.setId(i2);
        RenderableViewManager.setRenderableView(i2, this);
    }

    @com.facebook.react.uimanager.c1.a(name = "propList")
    public void setPropList(ReadableArray readableArray) {
        if (readableArray != null) {
            ArrayList<String> arrayList = new ArrayList<>();
            this.M0 = arrayList;
            this.L0 = arrayList;
            for (int i2 = 0; i2 < readableArray.size(); i2++) {
                this.L0.add(readableArray.getString(i2));
            }
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "stroke")
    public void setStroke(Dynamic dynamic) {
        if (dynamic != null && !dynamic.isNull()) {
            ReadableType type = dynamic.getType();
            int i2 = 0;
            if (type.equals(ReadableType.Number)) {
                this.y0 = JavaOnlyArray.of(0, Integer.valueOf(dynamic.asInt()));
            } else if (type.equals(ReadableType.Array)) {
                this.y0 = dynamic.asArray();
            } else {
                JavaOnlyArray javaOnlyArray = new JavaOnlyArray();
                javaOnlyArray.pushInt(0);
                Matcher matcher = w0.matcher(dynamic.asString());
                while (matcher.find()) {
                    double parseDouble = Double.parseDouble(matcher.group());
                    int i3 = i2 + 1;
                    if (i2 < 3) {
                        parseDouble /= 255.0d;
                    }
                    javaOnlyArray.pushDouble(parseDouble);
                    i2 = i3;
                }
                this.y0 = javaOnlyArray;
            }
            invalidate();
            return;
        }
        this.y0 = null;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeDasharray")
    public void setStrokeDasharray(ReadableArray readableArray) {
        if (readableArray != null) {
            int size = readableArray.size();
            this.z0 = new c0[size];
            for (int i2 = 0; i2 < size; i2++) {
                this.z0[i2] = c0.b(readableArray.getDynamic(i2));
            }
        } else {
            this.z0 = null;
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeDashoffset")
    public void setStrokeDashoffset(float f2) {
        this.D0 = f2 * this.P;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeLinecap")
    public void setStrokeLinecap(int i2) {
        if (i2 == 0) {
            this.E0 = Paint.Cap.BUTT;
        } else if (i2 == 1) {
            this.E0 = Paint.Cap.ROUND;
        } else if (i2 == 2) {
            this.E0 = Paint.Cap.SQUARE;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinecap " + i2 + " unrecognized");
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeLinejoin")
    public void setStrokeLinejoin(int i2) {
        if (i2 == 0) {
            this.F0 = Paint.Join.MITER;
        } else if (i2 == 1) {
            this.F0 = Paint.Join.ROUND;
        } else if (i2 == 2) {
            this.F0 = Paint.Join.BEVEL;
        } else {
            throw new JSApplicationIllegalArgumentException("strokeLinejoin " + i2 + " unrecognized");
        }
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 4.0f, name = "strokeMiterlimit")
    public void setStrokeMiterlimit(float f2) {
        this.C0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "strokeOpacity")
    public void setStrokeOpacity(float f2) {
        this.B0 = f2;
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeWidth")
    public void setStrokeWidth(Dynamic dynamic) {
        this.A0 = c0.b(dynamic);
        invalidate();
    }

    @com.facebook.react.uimanager.c1.a(name = "vectorEffect")
    public void setVectorEffect(int i2) {
        this.x0 = i2;
        invalidate();
    }
}