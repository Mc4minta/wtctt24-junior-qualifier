package com.facebook.react.views.text;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.coinbase.wallet.core.extensions.Strings;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ReactBaseTextShadowNode.java */
@TargetApi(23)
/* loaded from: classes2.dex */
public abstract class h extends com.facebook.react.uimanager.h {
    protected s E;
    protected y F;
    protected boolean G;
    protected int H;
    protected boolean I;
    protected int J;
    protected int K;
    protected int L;
    protected int M;
    protected int N;
    protected int O;
    protected float P;
    protected float Q;
    protected float R;
    protected int S;
    protected boolean T;
    protected boolean U;
    protected boolean V;
    protected boolean W;
    protected float X;
    protected int Y;
    protected int Z;
    protected String a0;
    protected String b0;
    protected boolean c0;
    protected Map<Integer, com.facebook.react.uimanager.y> d0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactBaseTextShadowNode.java */
    /* loaded from: classes2.dex */
    public static class a {
        protected int a;

        /* renamed from: b  reason: collision with root package name */
        protected int f5429b;

        /* renamed from: c  reason: collision with root package name */
        protected l f5430c;

        a(int i2, int i3, l lVar) {
            this.a = i2;
            this.f5429b = i3;
            this.f5430c = lVar;
        }

        public void a(SpannableStringBuilder spannableStringBuilder, int i2) {
            int i3 = this.a;
            spannableStringBuilder.setSpan(this.f5430c, i3, this.f5429b, ((i2 << 16) & 16711680) | ((i3 == 0 ? 18 : 34) & (-16711681)));
        }
    }

    public h() {
        this(null);
    }

    private static void o1(h hVar, SpannableStringBuilder spannableStringBuilder, List<a> list, y yVar, boolean z, Map<Integer, com.facebook.react.uimanager.y> map, int i2) {
        y yVar2;
        float b0;
        float k2;
        if (yVar != null) {
            yVar2 = yVar.a(hVar.F);
        } else {
            yVar2 = hVar.F;
        }
        y yVar3 = yVar2;
        int b2 = hVar.b();
        for (int i3 = 0; i3 < b2; i3++) {
            com.facebook.react.uimanager.z a2 = hVar.a(i3);
            if (a2 instanceof k) {
                spannableStringBuilder.append((CharSequence) c0.h(((k) a2).n1(), yVar3.l()));
            } else if (a2 instanceof h) {
                o1((h) a2, spannableStringBuilder, list, yVar3, z, map, spannableStringBuilder.length());
            } else if (a2 instanceof o) {
                spannableStringBuilder.append(Strings.zero);
                list.add(new a(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), ((o) a2).o1()));
            } else if (z) {
                int q = a2.q();
                com.facebook.yoga.v C = a2.C();
                com.facebook.yoga.v m = a2.m();
                com.facebook.yoga.u uVar = C.f5722e;
                com.facebook.yoga.u uVar2 = com.facebook.yoga.u.POINT;
                if (uVar == uVar2 && m.f5722e == uVar2) {
                    b0 = C.f5721d;
                    k2 = m.f5721d;
                } else {
                    a2.s();
                    b0 = a2.b0();
                    k2 = a2.k();
                }
                spannableStringBuilder.append(Strings.zero);
                list.add(new a(spannableStringBuilder.length() - 1, spannableStringBuilder.length(), new a0(q, (int) b0, (int) k2)));
                map.put(Integer.valueOf(q), a2);
                a2.d();
            } else {
                throw new IllegalViewOperationException("Unexpected view type nested under a <Text> or <TextInput> node: " + a2.getClass());
            }
            a2.d();
        }
        int length = spannableStringBuilder.length();
        if (length >= i2) {
            if (hVar.G) {
                list.add(new a(i2, length, new j(hVar.H)));
            }
            if (hVar.I) {
                list.add(new a(i2, length, new g(hVar.J)));
            }
            if (Build.VERSION.SDK_INT >= 21) {
                float d2 = yVar3.d();
                if (!Float.isNaN(d2) && (yVar == null || yVar.d() != d2)) {
                    list.add(new a(i2, length, new com.facebook.react.views.text.a(d2)));
                }
            }
            int c2 = yVar3.c();
            if (yVar == null || yVar.c() != c2) {
                list.add(new a(i2, length, new f(c2)));
            }
            if (hVar.Y != -1 || hVar.Z != -1 || hVar.a0 != null) {
                list.add(new a(i2, length, new c(hVar.Y, hVar.Z, hVar.b0, hVar.a0, hVar.F().getAssets())));
            }
            if (hVar.T) {
                list.add(new a(i2, length, new u()));
            }
            if (hVar.U) {
                list.add(new a(i2, length, new m()));
            }
            if ((hVar.P != 0.0f || hVar.Q != 0.0f || hVar.R != 0.0f) && Color.alpha(hVar.S) != 0) {
                list.add(new a(i2, length, new w(hVar.P, hVar.Q, hVar.R, hVar.S)));
            }
            float e2 = yVar3.e();
            if (!Float.isNaN(e2) && (yVar == null || yVar.e() != e2)) {
                list.add(new a(i2, length, new b(e2)));
            }
            list.add(new a(i2, length, new n(hVar.q())));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Spannable p1(h hVar, String str, boolean z, com.facebook.react.uimanager.m mVar) {
        int i2;
        int i3 = 0;
        e.f.k.a.a.b((z && mVar == null) ? false : true, "nativeViewHierarchyOptimizer is required when inline views are supported");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        ArrayList<a> arrayList = new ArrayList();
        HashMap hashMap = z ? new HashMap() : null;
        if (str != null) {
            spannableStringBuilder.append((CharSequence) c0.h(str, hVar.F.l()));
        }
        o1(hVar, spannableStringBuilder, arrayList, null, z, hashMap, 0);
        hVar.c0 = false;
        hVar.d0 = hashMap;
        float f2 = Float.NaN;
        for (a aVar : arrayList) {
            l lVar = aVar.f5430c;
            boolean z2 = lVar instanceof z;
            if (z2 || (lVar instanceof a0)) {
                if (z2) {
                    i2 = ((z) lVar).b();
                    hVar.c0 = true;
                } else {
                    a0 a0Var = (a0) lVar;
                    int a2 = a0Var.a();
                    com.facebook.react.uimanager.y yVar = (com.facebook.react.uimanager.y) hashMap.get(Integer.valueOf(a0Var.b()));
                    mVar.h(yVar);
                    yVar.M(hVar);
                    i2 = a2;
                }
                if (Float.isNaN(f2) || i2 > f2) {
                    f2 = i2;
                }
            }
            aVar.a(spannableStringBuilder, i3);
            i3++;
        }
        hVar.F.o(f2);
        s sVar = this.E;
        if (sVar != null) {
            sVar.a(spannableStringBuilder);
        }
        return spannableStringBuilder;
    }

    @com.facebook.react.uimanager.c1.a(name = "adjustsFontSizeToFit")
    public void setAdjustFontSizeToFit(boolean z) {
        if (z != this.W) {
            this.W = z;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "allowFontScaling")
    public void setAllowFontScaling(boolean z) {
        if (z != this.F.b()) {
            this.F.m(z);
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "backgroundColor")
    public void setBackgroundColor(Integer num) {
        if (t()) {
            boolean z = num != null;
            this.I = z;
            if (z) {
                this.J = num.intValue();
            }
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public void setColor(Integer num) {
        boolean z = num != null;
        this.G = z;
        if (z) {
            this.H = num.intValue();
        }
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "fontFamily")
    public void setFontFamily(String str) {
        this.a0 = str;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "fontSize")
    public void setFontSize(float f2) {
        this.F.n(f2);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "fontStyle")
    public void setFontStyle(String str) {
        int b2 = t.b(str);
        if (b2 != this.Y) {
            this.Y = b2;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "fontVariant")
    public void setFontVariant(ReadableArray readableArray) {
        String c2 = t.c(readableArray);
        if (TextUtils.equals(c2, this.b0)) {
            return;
        }
        this.b0 = c2;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "fontWeight")
    public void setFontWeight(String str) {
        int d2 = t.d(str);
        if (d2 != this.Z) {
            this.Z = d2;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "includeFontPadding")
    public void setIncludeFontPadding(boolean z) {
        this.V = z;
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "letterSpacing")
    public void setLetterSpacing(float f2) {
        this.F.p(f2);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "lineHeight")
    public void setLineHeight(float f2) {
        this.F.q(f2);
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "maxFontSizeMultiplier")
    public void setMaxFontSizeMultiplier(float f2) {
        if (f2 != this.F.k()) {
            this.F.r(f2);
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "minimumFontScale")
    public void setMinimumFontScale(float f2) {
        if (f2 != this.X) {
            this.X = f2;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "numberOfLines")
    public void setNumberOfLines(int i2) {
        if (i2 == 0) {
            i2 = -1;
        }
        this.K = i2;
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "textAlign")
    public void setTextAlign(String str) {
        if ("justify".equals(str)) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.O = 1;
            }
            this.L = 3;
        } else {
            if (Build.VERSION.SDK_INT >= 26) {
                this.O = 0;
            }
            if (str != null && !"auto".equals(str)) {
                if ("left".equals(str)) {
                    this.L = 3;
                } else if ("right".equals(str)) {
                    this.L = 5;
                } else if ("center".equals(str)) {
                    this.L = 1;
                } else {
                    throw new JSApplicationIllegalArgumentException("Invalid textAlign: " + str);
                }
            } else {
                this.L = 0;
            }
        }
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "textBreakStrategy")
    public void setTextBreakStrategy(String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (str != null && !"highQuality".equals(str)) {
            if ("simple".equals(str)) {
                this.M = 0;
            } else if ("balanced".equals(str)) {
                this.M = 2;
            } else {
                throw new JSApplicationIllegalArgumentException("Invalid textBreakStrategy: " + str);
            }
        } else {
            this.M = 1;
        }
        w0();
    }

    @com.facebook.react.uimanager.c1.a(name = "textDecorationLine")
    public void setTextDecorationLine(String str) {
        String[] split;
        this.T = false;
        this.U = false;
        if (str != null) {
            for (String str2 : str.split(" ")) {
                if ("underline".equals(str2)) {
                    this.T = true;
                } else if ("line-through".equals(str2)) {
                    this.U = true;
                }
            }
        }
        w0();
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", defaultInt = 1426063360, name = "textShadowColor")
    public void setTextShadowColor(int i2) {
        if (i2 != this.S) {
            this.S = i2;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "textShadowOffset")
    public void setTextShadowOffset(ReadableMap readableMap) {
        this.P = 0.0f;
        this.Q = 0.0f;
        if (readableMap != null) {
            if (readableMap.hasKey("width") && !readableMap.isNull("width")) {
                this.P = com.facebook.react.uimanager.o.b(readableMap.getDouble("width"));
            }
            if (readableMap.hasKey("height") && !readableMap.isNull("height")) {
                this.Q = com.facebook.react.uimanager.o.b(readableMap.getDouble("height"));
            }
        }
        w0();
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = 1, name = "textShadowRadius")
    public void setTextShadowRadius(float f2) {
        if (f2 != this.R) {
            this.R = f2;
            w0();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "textTransform")
    public void setTextTransform(String str) {
        if (str == null) {
            this.F.s(c0.UNSET);
        } else if ("none".equals(str)) {
            this.F.s(c0.NONE);
        } else if ("uppercase".equals(str)) {
            this.F.s(c0.UPPERCASE);
        } else if ("lowercase".equals(str)) {
            this.F.s(c0.LOWERCASE);
        } else if ("capitalize".equals(str)) {
            this.F.s(c0.CAPITALIZE);
        } else {
            throw new JSApplicationIllegalArgumentException("Invalid textTransform: " + str);
        }
        w0();
    }

    public h(s sVar) {
        this.G = false;
        this.I = false;
        this.K = -1;
        this.L = 0;
        this.M = Build.VERSION.SDK_INT < 23 ? 0 : 1;
        this.N = 0;
        this.O = 0;
        this.P = 0.0f;
        this.Q = 0.0f;
        this.R = 0.0f;
        this.S = 1426063360;
        this.T = false;
        this.U = false;
        this.V = true;
        this.W = false;
        this.X = 0.0f;
        this.Y = -1;
        this.Z = -1;
        this.a0 = null;
        this.b0 = null;
        this.c0 = false;
        this.F = new y();
        this.E = sVar;
    }
}