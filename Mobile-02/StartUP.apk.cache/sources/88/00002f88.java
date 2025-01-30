package com.facebook.react.views.art;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: ARTShapeShadowNode.java */
/* loaded from: classes2.dex */
public class b extends f {
    protected Path H;
    private float[] I;
    private float[] J;
    private float[] K;
    private float L = 1.0f;
    private int M = 1;
    private int N = 1;

    private Path r1(float[] fArr) {
        int i2;
        int i3;
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        int i4 = 0;
        while (i4 < fArr.length) {
            int i5 = i4 + 1;
            int i6 = (int) fArr[i4];
            if (i6 != 0) {
                if (i6 == 1) {
                    path.close();
                    i4 = i5;
                } else if (i6 != 2) {
                    if (i6 == 3) {
                        int i7 = i5 + 1;
                        float f2 = fArr[i5];
                        float f3 = this.G;
                        int i8 = i7 + 1;
                        float f4 = fArr[i7] * f3;
                        int i9 = i8 + 1;
                        int i10 = i9 + 1;
                        float f5 = fArr[i9] * f3;
                        int i11 = i10 + 1;
                        i3 = i11 + 1;
                        path.cubicTo(f2 * f3, f4, fArr[i8] * f3, f5, fArr[i10] * f3, fArr[i11] * f3);
                    } else if (i6 == 4) {
                        int i12 = i5 + 1;
                        float f6 = fArr[i5];
                        float f7 = this.G;
                        float f8 = f6 * f7;
                        int i13 = i12 + 1;
                        float f9 = fArr[i12] * f7;
                        int i14 = i13 + 1;
                        float f10 = fArr[i13] * f7;
                        int i15 = i14 + 1;
                        float degrees = (float) Math.toDegrees(fArr[i14]);
                        int i16 = i15 + 1;
                        float degrees2 = (float) Math.toDegrees(fArr[i15]);
                        i3 = i16 + 1;
                        boolean z = fArr[i16] != 1.0f;
                        float f11 = degrees2 - degrees;
                        if (Math.abs(f11) >= 360.0f) {
                            path.addCircle(f8, f9, f10, z ? Path.Direction.CCW : Path.Direction.CW);
                        } else {
                            float s1 = s1(f11, 360.0f);
                            if (z && s1 < 360.0f) {
                                s1 = (360.0f - s1) * (-1.0f);
                            }
                            path.arcTo(new RectF(f8 - f10, f9 - f10, f8 + f10, f9 + f10), degrees, s1);
                        }
                    } else {
                        throw new JSApplicationIllegalArgumentException("Unrecognized drawing instruction " + i6);
                    }
                    i4 = i3;
                } else {
                    int i17 = i5 + 1;
                    float f12 = fArr[i5];
                    float f13 = this.G;
                    i2 = i17 + 1;
                    path.lineTo(f12 * f13, fArr[i17] * f13);
                }
            } else {
                int i18 = i5 + 1;
                float f14 = fArr[i5];
                float f15 = this.G;
                i2 = i18 + 1;
                path.moveTo(f14 * f15, fArr[i18] * f15);
            }
            i4 = i2;
        }
        return path;
    }

    private float s1(float f2, float f3) {
        float f4 = f2 % f3;
        return f4 < 0.0f ? f4 + f3 : f4;
    }

    @Override // com.facebook.react.views.art.f
    public void n1(Canvas canvas, Paint paint, float f2) {
        float f3 = f2 * this.E;
        if (f3 > 0.01f) {
            p1(canvas);
            if (this.H != null) {
                if (t1(paint, f3)) {
                    canvas.drawPath(this.H, paint);
                }
                if (u1(paint, f3)) {
                    canvas.drawPath(this.H, paint);
                }
                o1(canvas);
            } else {
                throw new JSApplicationIllegalArgumentException("Shapes should have a valid path (d) prop");
            }
        }
        d();
    }

    @com.facebook.react.uimanager.c1.a(name = "fill")
    public void setFill(ReadableArray readableArray) {
        this.J = g.b(readableArray);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "d")
    public void setShapePath(ReadableArray readableArray) {
        this.H = r1(g.b(readableArray));
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "stroke")
    public void setStroke(ReadableArray readableArray) {
        this.I = g.b(readableArray);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeCap")
    public void setStrokeCap(int i2) {
        this.M = i2;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "strokeDash")
    public void setStrokeDash(ReadableArray readableArray) {
        this.K = g.b(readableArray);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "strokeJoin")
    public void setStrokeJoin(int i2) {
        this.N = i2;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(float f2) {
        this.L = f2;
        w0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean t1(Paint paint, float f2) {
        int[] iArr;
        float[] fArr;
        float[] fArr2 = this.J;
        int i2 = 0;
        if (fArr2 == null || fArr2.length <= 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.FILL);
        float[] fArr3 = this.J;
        int i3 = (int) fArr3[0];
        if (i3 == 0) {
            paint.setARGB((int) (fArr3.length > 4 ? fArr3[4] * f2 * 255.0f : f2 * 255.0f), (int) (fArr3[1] * 255.0f), (int) (fArr3[2] * 255.0f), (int) (fArr3[3] * 255.0f));
            return true;
        } else if (i3 != 1) {
            e.f.d.d.a.A("ReactNative", "ART: Color type " + i3 + " not supported!");
            return true;
        } else {
            int i4 = 5;
            if (fArr3.length < 5) {
                e.f.d.d.a.A("ReactNative", "[ARTShapeShadowNode setupFillPaint] expects 5 elements, received " + this.J.length);
                return false;
            }
            float f3 = fArr3[1];
            float f4 = this.G;
            float f5 = f3 * f4;
            float f6 = fArr3[2] * f4;
            float f7 = fArr3[3] * f4;
            float f8 = fArr3[4] * f4;
            int length = (fArr3.length - 5) / 5;
            if (length > 0) {
                int[] iArr2 = new int[length];
                float[] fArr4 = new float[length];
                while (i2 < length) {
                    float[] fArr5 = this.J;
                    fArr4[i2] = fArr5[(length * 4) + i4 + i2];
                    int i5 = (i2 * 4) + i4;
                    iArr2[i2] = Color.argb((int) (fArr5[i5 + 3] * 255.0f), (int) (fArr5[i5 + 0] * 255.0f), (int) (fArr5[i5 + 1] * 255.0f), (int) (fArr5[i5 + 2] * 255.0f));
                    i2++;
                    i4 = 5;
                }
                iArr = iArr2;
                fArr = fArr4;
            } else {
                iArr = null;
                fArr = null;
            }
            paint.setShader(new LinearGradient(f5, f6, f7, f8, iArr, fArr, Shader.TileMode.CLAMP));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean u1(Paint paint, float f2) {
        float[] fArr;
        if (this.L == 0.0f || (fArr = this.I) == null || fArr.length == 0) {
            return false;
        }
        paint.reset();
        paint.setFlags(1);
        paint.setStyle(Paint.Style.STROKE);
        int i2 = this.M;
        if (i2 == 0) {
            paint.setStrokeCap(Paint.Cap.BUTT);
        } else if (i2 == 1) {
            paint.setStrokeCap(Paint.Cap.ROUND);
        } else if (i2 == 2) {
            paint.setStrokeCap(Paint.Cap.SQUARE);
        } else {
            throw new JSApplicationIllegalArgumentException("strokeCap " + this.M + " unrecognized");
        }
        int i3 = this.N;
        if (i3 == 0) {
            paint.setStrokeJoin(Paint.Join.MITER);
        } else if (i3 == 1) {
            paint.setStrokeJoin(Paint.Join.ROUND);
        } else if (i3 == 2) {
            paint.setStrokeJoin(Paint.Join.BEVEL);
        } else {
            throw new JSApplicationIllegalArgumentException("strokeJoin " + this.N + " unrecognized");
        }
        paint.setStrokeWidth(this.L * this.G);
        float[] fArr2 = this.I;
        paint.setARGB((int) (fArr2.length > 3 ? fArr2[3] * f2 * 255.0f : f2 * 255.0f), (int) (fArr2[0] * 255.0f), (int) (fArr2[1] * 255.0f), (int) (fArr2[2] * 255.0f));
        float[] fArr3 = this.K;
        if (fArr3 != null && fArr3.length > 0) {
            paint.setPathEffect(new DashPathEffect(this.K, 0.0f));
        }
        return true;
    }
}