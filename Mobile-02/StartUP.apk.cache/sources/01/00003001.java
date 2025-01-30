package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.t0;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: ReactTextShadowNode.java */
@TargetApi(23)
/* loaded from: classes2.dex */
public class p extends h {
    private static final TextPaint e0 = new TextPaint(1);
    private Spannable f0;
    private boolean g0;
    private final com.facebook.yoga.m h0;

    /* compiled from: ReactTextShadowNode.java */
    /* loaded from: classes2.dex */
    class a implements com.facebook.yoga.m {
        a() {
        }

        @Override // com.facebook.yoga.m
        public long T(com.facebook.yoga.p pVar, float f2, com.facebook.yoga.n nVar, float f3, com.facebook.yoga.n nVar2) {
            Spannable spannable = (Spannable) e.f.k.a.a.d(p.this.f0, "Spannable element has not been prepared in onBeforeLayout");
            Layout w1 = p.this.w1(spannable, f2, nVar);
            p pVar2 = p.this;
            if (pVar2.W) {
                int c2 = pVar2.F.c();
                int c3 = p.this.F.c();
                float f4 = c2;
                int max = (int) Math.max(p.this.X * f4, com.facebook.react.uimanager.o.c(4.0f));
                for (int i2 = -1; c3 > max && ((p.this.K != i2 && w1.getLineCount() > p.this.K) || (nVar2 != com.facebook.yoga.n.UNDEFINED && w1.getHeight() > f3)); i2 = -1) {
                    c3 -= (int) com.facebook.react.uimanager.o.c(1.0f);
                    float f5 = c3 / f4;
                    int i3 = 0;
                    f[] fVarArr = (f[]) spannable.getSpans(0, spannable.length(), f.class);
                    int length = fVarArr.length;
                    while (i3 < length) {
                        f fVar = fVarArr[i3];
                        spannable.setSpan(new f((int) Math.max(fVar.getSize() * f5, max)), spannable.getSpanStart(fVar), spannable.getSpanEnd(fVar), spannable.getSpanFlags(fVar));
                        spannable.removeSpan(fVar);
                        i3++;
                        f5 = f5;
                    }
                    w1 = p.this.w1(spannable, f2, nVar);
                }
            }
            if (p.this.g0) {
                i0 F = p.this.F();
                WritableArray a = e.a(spannable, w1, p.e0, F);
                WritableMap createMap = Arguments.createMap();
                createMap.putArray("lines", a);
                if (F.hasActiveCatalystInstance()) {
                    ((RCTEventEmitter) F.getJSModule(RCTEventEmitter.class)).receiveEvent(p.this.q(), "topTextLayout", createMap);
                } else {
                    ReactSoftException.logSoftException("ReactTextShadowNode", new ReactNoCrashSoftException("Cannot get RCTEventEmitter, no CatalystInstance"));
                }
            }
            int i4 = p.this.K;
            if (i4 != -1 && i4 < w1.getLineCount()) {
                return com.facebook.yoga.o.b(w1.getWidth(), w1.getLineBottom(p.this.K - 1));
            }
            return com.facebook.yoga.o.b(w1.getWidth(), w1.getHeight());
        }
    }

    public p() {
        this(null);
    }

    private int u1() {
        int i2 = this.L;
        if (f0() == com.facebook.yoga.h.RTL) {
            if (i2 == 5) {
                return 3;
            }
            if (i2 == 3) {
                return 5;
            }
            return i2;
        }
        return i2;
    }

    private void v1() {
        if (t()) {
            return;
        }
        R0(this.h0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Layout w1(Spannable spannable, float f2, com.facebook.yoga.n nVar) {
        TextPaint textPaint = e0;
        textPaint.setTextSize(this.F.c());
        BoringLayout.Metrics isBoring = BoringLayout.isBoring(spannable, textPaint);
        float desiredWidth = isBoring == null ? Layout.getDesiredWidth(spannable, textPaint) : Float.NaN;
        boolean z = nVar == com.facebook.yoga.n.UNDEFINED || f2 < 0.0f;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        int u1 = u1();
        if (u1 == 1) {
            alignment = Layout.Alignment.ALIGN_CENTER;
        } else if (u1 == 3) {
            alignment = Layout.Alignment.ALIGN_NORMAL;
        } else if (u1 == 5) {
            alignment = Layout.Alignment.ALIGN_OPPOSITE;
        }
        Layout.Alignment alignment2 = alignment;
        if (isBoring == null && (z || (!com.facebook.yoga.g.a(desiredWidth) && desiredWidth <= f2))) {
            int ceil = (int) Math.ceil(desiredWidth);
            int i2 = Build.VERSION.SDK_INT;
            if (i2 < 23) {
                return new StaticLayout(spannable, textPaint, ceil, alignment2, 1.0f, 0.0f, this.V);
            }
            StaticLayout.Builder hyphenationFrequency = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, ceil).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.V).setBreakStrategy(this.M).setHyphenationFrequency(this.N);
            if (i2 >= 26) {
                hyphenationFrequency.setJustificationMode(this.O);
            }
            if (i2 >= 28) {
                hyphenationFrequency.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency.build();
        } else if (isBoring != null && (z || isBoring.width <= f2)) {
            return BoringLayout.make(spannable, textPaint, isBoring.width, alignment2, 1.0f, 0.0f, isBoring, this.V);
        } else {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 < 23) {
                return new StaticLayout(spannable, textPaint, (int) f2, alignment2, 1.0f, 0.0f, this.V);
            }
            StaticLayout.Builder hyphenationFrequency2 = StaticLayout.Builder.obtain(spannable, 0, spannable.length(), textPaint, (int) f2).setAlignment(alignment2).setLineSpacing(0.0f, 1.0f).setIncludePad(this.V).setBreakStrategy(this.M).setHyphenationFrequency(this.N);
            if (i3 >= 28) {
                hyphenationFrequency2.setUseLineSpacingFromFallbacks(true);
            }
            return hyphenationFrequency2.build();
        }
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public void U(com.facebook.react.uimanager.m mVar) {
        this.f0 = p1(this, null, true, mVar);
        w0();
    }

    @Override // com.facebook.react.uimanager.z, com.facebook.react.uimanager.y
    public Iterable<? extends com.facebook.react.uimanager.y> n() {
        Map<Integer, com.facebook.react.uimanager.y> map = this.d0;
        if (map == null || map.isEmpty()) {
            return null;
        }
        Spanned spanned = (Spanned) e.f.k.a.a.d(this.f0, "Spannable element has not been prepared in onBeforeLayout");
        a0[] a0VarArr = (a0[]) spanned.getSpans(0, spanned.length(), a0.class);
        ArrayList arrayList = new ArrayList(a0VarArr.length);
        for (a0 a0Var : a0VarArr) {
            com.facebook.react.uimanager.y yVar = this.d0.get(Integer.valueOf(a0Var.b()));
            yVar.s();
            arrayList.add(yVar);
        }
        return arrayList;
    }

    @Override // com.facebook.react.uimanager.z
    public boolean n0() {
        return true;
    }

    @com.facebook.react.uimanager.c1.a(name = "onTextLayout")
    public void setShouldNotifyOnTextLayout(boolean z) {
        this.g0 = z;
    }

    @Override // com.facebook.react.uimanager.z
    public boolean t0() {
        return false;
    }

    @Override // com.facebook.react.uimanager.z
    public void w0() {
        super.w0();
        super.h();
    }

    @Override // com.facebook.react.uimanager.z
    public void y0(t0 t0Var) {
        super.y0(t0Var);
        Spannable spannable = this.f0;
        if (spannable != null) {
            t0Var.R(q(), new q(spannable, -1, this.c0, j0(4), j0(1), j0(5), j0(3), u1(), this.M, this.O));
        }
    }

    public p(s sVar) {
        super(sVar);
        this.h0 = new a();
        v1();
    }
}