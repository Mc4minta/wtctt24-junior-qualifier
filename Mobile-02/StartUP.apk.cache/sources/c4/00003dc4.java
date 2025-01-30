package com.horcrux.svg;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewParent;
import com.facebook.react.bridge.ReactContext;
import java.text.Bidi;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TSpanView.java */
@SuppressLint({"ViewConstructor"})
/* loaded from: classes2.dex */
public class h0 extends u0 {
    private Path a1;
    String b1;
    private i0 c1;
    private final ArrayList<String> d1;
    private final ArrayList<Matrix> e1;
    private final AssetManager f1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TSpanView.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f10241b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f10242c;

        static {
            int[] iArr = new int[j0.values().length];
            f10242c = iArr;
            try {
                iArr[j0.baseline.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10242c[j0.textBottom.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10242c[j0.afterEdge.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10242c[j0.textAfterEdge.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10242c[j0.alphabetic.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10242c[j0.ideographic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10242c[j0.middle.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10242c[j0.central.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10242c[j0.mathematical.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f10242c[j0.hanging.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f10242c[j0.textTop.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f10242c[j0.beforeEdge.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f10242c[j0.textBeforeEdge.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f10242c[j0.bottom.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f10242c[j0.center.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f10242c[j0.top.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            int[] iArr2 = new int[p0.values().length];
            f10241b = iArr2;
            try {
                iArr2[p0.spacing.ordinal()] = 1;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f10241b[p0.spacingAndGlyphs.ordinal()] = 2;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr3 = new int[n0.values().length];
            a = iArr3;
            try {
                iArr3[n0.start.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[n0.middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[n0.end.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
        }
    }

    public h0(ReactContext reactContext) {
        super(reactContext);
        this.d1 = new ArrayList<>();
        this.e1 = new ArrayList<>();
        this.f1 = this.x.getResources().getAssets();
    }

    private void o0(Paint paint, h hVar) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 21) {
            double d2 = hVar.o;
            paint.setLetterSpacing((float) (d2 / (hVar.f10229b * this.P)));
            if (d2 == 0.0d && hVar.f10237j == l0.normal) {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'hlig', 'cala', " + hVar.f10235h);
            } else {
                paint.setFontFeatureSettings("'rlig', 'liga', 'clig', 'calt', 'locl', 'ccmp', 'mark', 'mkmk','kern', 'liga' 0, 'clig' 0, 'dlig' 0, 'hlig' 0, 'cala' 0, " + hVar.f10235h);
            }
            if (i2 >= 26) {
                paint.setFontVariationSettings("'wght' " + hVar.f10234g + hVar.f10236i);
            }
        }
    }

    private void p0(Paint paint, h hVar) {
        int i2 = 0;
        boolean z = hVar.f10233f == m0.Bold || hVar.f10234g >= 550;
        boolean z2 = hVar.f10231d == k0.italic;
        if (z && z2) {
            i2 = 3;
        } else if (z) {
            i2 = 1;
        } else if (z2) {
            i2 = 2;
        }
        Typeface typeface = null;
        int i3 = hVar.f10234g;
        String str = hVar.f10230c;
        if (str != null && str.length() > 0) {
            String str2 = "fonts/" + str + ".otf";
            String str3 = "fonts/" + str + ".ttf";
            if (Build.VERSION.SDK_INT >= 26) {
                Typeface.Builder builder = new Typeface.Builder(this.f1, str2);
                builder.setFontVariationSettings("'wght' " + i3 + hVar.f10236i);
                builder.setWeight(i3);
                builder.setItalic(z2);
                typeface = builder.build();
                if (typeface == null) {
                    Typeface.Builder builder2 = new Typeface.Builder(this.f1, str3);
                    builder2.setFontVariationSettings("'wght' " + i3 + hVar.f10236i);
                    builder2.setWeight(i3);
                    builder2.setItalic(z2);
                    typeface = builder2.build();
                }
            } else {
                try {
                    try {
                        typeface = Typeface.create(Typeface.createFromAsset(this.f1, str2), i2);
                    } catch (Exception unused) {
                        typeface = Typeface.create(Typeface.createFromAsset(this.f1, str3), i2);
                    }
                } catch (Exception unused2) {
                }
            }
        }
        if (typeface == null) {
            try {
                typeface = com.facebook.react.views.text.i.c().e(str, i2, this.f1);
            } catch (Exception unused3) {
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 28) {
            typeface = Typeface.create(typeface, i3, z2);
        }
        paint.setLinearText(true);
        paint.setSubpixelText(true);
        paint.setTypeface(typeface);
        paint.setTextSize((float) (hVar.f10229b * this.P));
        if (i4 >= 21) {
            paint.setLetterSpacing(0.0f);
        }
    }

    private void q0(Canvas canvas, Paint paint) {
        Layout.Alignment alignment;
        j d0 = d0();
        f0();
        h b2 = d0.b();
        TextPaint textPaint = new TextPaint(paint);
        p0(textPaint, b2);
        o0(textPaint, b2);
        double c2 = d0.c();
        int i2 = a.a[b2.f10238k.ordinal()];
        if (i2 == 2) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (i2 != 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        StaticLayout t0 = t0(textPaint, alignment, true, new SpannableString(this.b1), (int) w.a(this.P0, canvas.getWidth(), 0.0d, this.P, c2));
        int lineAscent = t0.getLineAscent(0);
        e0();
        canvas.save();
        canvas.translate((float) d0.l(0.0d), (float) (d0.m() + lineAscent));
        t0.draw(canvas);
        canvas.restore();
    }

    private double r0(c0 c0Var, double d2, double d3) {
        return w.a(c0Var, d2, 0.0d, this.P, d3);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0240  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Path s0(java.lang.String r69, android.graphics.Paint r70, android.graphics.Canvas r71) {
        /*
            Method dump skipped, instructions count: 1402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.horcrux.svg.h0.s0(java.lang.String, android.graphics.Paint, android.graphics.Canvas):android.graphics.Path");
    }

    private StaticLayout t0(TextPaint textPaint, Layout.Alignment alignment, boolean z, SpannableString spannableString, int i2) {
        if (Build.VERSION.SDK_INT < 23) {
            return new StaticLayout(spannableString, textPaint, i2, alignment, 1.0f, 0.0f, z);
        }
        return StaticLayout.Builder.obtain(spannableString, 0, spannableString.length(), textPaint, i2).setAlignment(alignment).setLineSpacing(0.0f, 1.0f).setIncludePad(z).setBreakStrategy(1).setHyphenationFrequency(1).build();
    }

    private double u0(n0 n0Var, double d2) {
        int i2 = a.a[n0Var.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                return 0.0d;
            }
            return -d2;
        }
        return (-d2) / 2.0d;
    }

    private void v0() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent.getClass() == i0.class) {
                this.c1 = (i0) parent;
                return;
            } else if (!(parent instanceof u0)) {
                return;
            }
        }
    }

    public static String w0(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        Bidi bidi = new Bidi(str, -2);
        if (bidi.isLeftToRight()) {
            return str;
        }
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i2 = 0; i2 < runCount; i2++) {
            bArr[i2] = (byte) bidi.getRunLevel(i2);
            numArr[i2] = Integer.valueOf(i2);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < runCount; i3++) {
            int intValue = numArr[i3].intValue();
            int runStart = bidi.getRunStart(intValue);
            int runLimit = bidi.getRunLimit(intValue);
            if ((bArr[intValue] & 1) != 0) {
                while (true) {
                    runLimit--;
                    if (runLimit >= runStart) {
                        sb.append(str.charAt(runLimit));
                    }
                }
            } else {
                sb.append((CharSequence) str, runStart, runLimit);
            }
        }
        return sb.toString();
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    void C(Canvas canvas, Paint paint, float f2) {
        if (this.b1 != null) {
            c0 c0Var = this.P0;
            if (c0Var != null && c0Var.a != 0.0d) {
                if (W(paint, this.H0 * f2)) {
                    q0(canvas, paint);
                }
                if (Y(paint, f2 * this.B0)) {
                    q0(canvas, paint);
                    return;
                }
                return;
            }
            int size = this.d1.size();
            if (size > 0) {
                p0(paint, d0().b());
                for (int i2 = 0; i2 < size; i2++) {
                    canvas.save();
                    canvas.concat(this.e1.get(i2));
                    canvas.drawText(this.d1.get(i2), 0.0f, 0.0f, paint);
                    canvas.restore();
                }
            }
            a0(canvas, paint, f2);
            return;
        }
        B(canvas, paint);
        Z(canvas, paint, f2);
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.l, com.horcrux.svg.x0
    Path F(Canvas canvas, Paint paint) {
        Path path = this.a1;
        if (path != null) {
            return path;
        }
        if (this.b1 == null) {
            Path k0 = k0(canvas, paint);
            this.a1 = k0;
            return k0;
        }
        v0();
        f0();
        this.a1 = s0(w0(this.b1), paint, canvas);
        e0();
        return this.a1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.horcrux.svg.l, com.horcrux.svg.b0, com.horcrux.svg.x0
    public int G(float[] fArr) {
        Region region;
        if (this.b1 == null) {
            return super.G(fArr);
        }
        if (this.f0 != null && this.F && this.H) {
            float[] fArr2 = new float[2];
            this.D.mapPoints(fArr2, fArr);
            this.E.mapPoints(fArr2);
            int round = Math.round(fArr2[0]);
            int round2 = Math.round(fArr2[1]);
            R();
            Region region2 = this.p0;
            if ((region2 != null && region2.contains(round, round2)) || ((region = this.r0) != null && region.contains(round, round2))) {
                if (getClipPath() == null || this.s0.contains(round, round2)) {
                    return getId();
                }
                return -1;
            }
        }
        return -1;
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.x0, android.view.View
    public void invalidate() {
        this.a1 = null;
        super.invalidate();
    }

    @Override // com.horcrux.svg.u0
    double l0(Paint paint) {
        if (!Double.isNaN(this.Z0)) {
            return this.Z0;
        }
        String str = this.b1;
        double d2 = 0.0d;
        if (str == null) {
            for (int i2 = 0; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                if (childAt instanceof u0) {
                    d2 += ((u0) childAt).l0(paint);
                }
            }
            this.Z0 = d2;
            return d2;
        } else if (str.length() == 0) {
            this.Z0 = 0.0d;
            return 0.0d;
        } else {
            h b2 = d0().b();
            p0(paint, b2);
            o0(paint, b2);
            double measureText = paint.measureText(str);
            this.Z0 = measureText;
            return measureText;
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "content")
    public void setContent(String str) {
        this.b1 = str;
        invalidate();
    }

    @Override // com.horcrux.svg.u0, com.horcrux.svg.x0
    void y() {
        this.a1 = null;
        super.y();
    }
}