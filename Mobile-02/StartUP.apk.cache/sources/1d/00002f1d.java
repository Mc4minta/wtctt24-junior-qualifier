package com.facebook.react.uimanager;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableType;

/* compiled from: LayoutShadowNode.java */
/* loaded from: classes2.dex */
public class h extends z {
    private final b C = new b(null);
    boolean D;

    /* compiled from: LayoutShadowNode.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[com.facebook.yoga.u.values().length];
            a = iArr;
            try {
                iArr[com.facebook.yoga.u.POINT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[com.facebook.yoga.u.UNDEFINED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[com.facebook.yoga.u.AUTO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[com.facebook.yoga.u.PERCENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: LayoutShadowNode.java */
    /* loaded from: classes2.dex */
    private static class b {
        float a;

        /* renamed from: b  reason: collision with root package name */
        com.facebook.yoga.u f5128b;

        /* synthetic */ b(a aVar) {
            this();
        }

        void a(Dynamic dynamic) {
            if (dynamic.isNull()) {
                this.f5128b = com.facebook.yoga.u.UNDEFINED;
                this.a = Float.NaN;
            } else if (dynamic.getType() == ReadableType.String) {
                String asString = dynamic.asString();
                if (asString.equals("auto")) {
                    this.f5128b = com.facebook.yoga.u.AUTO;
                    this.a = Float.NaN;
                } else if (asString.endsWith("%")) {
                    this.f5128b = com.facebook.yoga.u.PERCENT;
                    this.a = Float.parseFloat(asString.substring(0, asString.length() - 1));
                } else {
                    throw new IllegalArgumentException("Unknown value: " + asString);
                }
            } else {
                this.f5128b = com.facebook.yoga.u.POINT;
                this.a = o.b(dynamic.asDouble());
            }
        }

        private b() {
        }
    }

    private int n1(int i2) {
        if (com.facebook.react.modules.i18nmanager.a.d().b(F())) {
            if (i2 != 0) {
                if (i2 != 2) {
                    return i2;
                }
                return 5;
            }
            return 4;
        }
        return i2;
    }

    @com.facebook.react.uimanager.c1.a(name = "alignContent")
    public void setAlignContent(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            B0(com.facebook.yoga.a.FLEX_START);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 2;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 4;
                    break;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                B0(com.facebook.yoga.a.STRETCH);
                return;
            case 1:
                B0(com.facebook.yoga.a.BASELINE);
                return;
            case 2:
                B0(com.facebook.yoga.a.CENTER);
                return;
            case 3:
                B0(com.facebook.yoga.a.FLEX_START);
                return;
            case 4:
                B0(com.facebook.yoga.a.AUTO);
                return;
            case 5:
                B0(com.facebook.yoga.a.SPACE_BETWEEN);
                return;
            case 6:
                B0(com.facebook.yoga.a.FLEX_END);
                return;
            case 7:
                B0(com.facebook.yoga.a.SPACE_AROUND);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for alignContent: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "alignItems")
    public void setAlignItems(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            C0(com.facebook.yoga.a.STRETCH);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 2;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 4;
                    break;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                C0(com.facebook.yoga.a.STRETCH);
                return;
            case 1:
                C0(com.facebook.yoga.a.BASELINE);
                return;
            case 2:
                C0(com.facebook.yoga.a.CENTER);
                return;
            case 3:
                C0(com.facebook.yoga.a.FLEX_START);
                return;
            case 4:
                C0(com.facebook.yoga.a.AUTO);
                return;
            case 5:
                C0(com.facebook.yoga.a.SPACE_BETWEEN);
                return;
            case 6:
                C0(com.facebook.yoga.a.FLEX_END);
                return;
            case 7:
                C0(com.facebook.yoga.a.SPACE_AROUND);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for alignItems: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "alignSelf")
    public void setAlignSelf(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            D0(com.facebook.yoga.a.AUTO);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1881872635:
                if (str.equals("stretch")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1720785339:
                if (str.equals("baseline")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 2;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c2 = 3;
                    break;
                }
                break;
            case 3005871:
                if (str.equals("auto")) {
                    c2 = 4;
                    break;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                D0(com.facebook.yoga.a.STRETCH);
                return;
            case 1:
                D0(com.facebook.yoga.a.BASELINE);
                return;
            case 2:
                D0(com.facebook.yoga.a.CENTER);
                return;
            case 3:
                D0(com.facebook.yoga.a.FLEX_START);
                return;
            case 4:
                D0(com.facebook.yoga.a.AUTO);
                return;
            case 5:
                D0(com.facebook.yoga.a.SPACE_BETWEEN);
                return;
            case 6:
                D0(com.facebook.yoga.a.FLEX_END);
                return;
            case 7:
                D0(com.facebook.yoga.a.SPACE_AROUND);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for alignSelf: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "aspectRatio")
    public void setAspectRatio(float f2) {
        Y0(f2);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderStartWidth", "borderEndWidth", "borderTopWidth", "borderBottomWidth", "borderLeftWidth", "borderRightWidth"})
    public void setBorderWidths(int i2, float f2) {
        if (t()) {
            return;
        }
        E0(n1(a1.a[i2]), o.c(f2));
    }

    @com.facebook.react.uimanager.c1.a(name = "collapsable")
    public void setCollapsable(boolean z) {
        this.D = z;
    }

    @com.facebook.react.uimanager.c1.a(name = "display")
    public void setDisplay(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            G0(com.facebook.yoga.i.FLEX);
        } else if (str.equals("flex")) {
            G0(com.facebook.yoga.i.FLEX);
        } else if (!str.equals("none")) {
            throw new JSApplicationIllegalArgumentException("invalid value for display: " + str);
        } else {
            G0(com.facebook.yoga.i.NONE);
        }
    }

    @Override // com.facebook.react.uimanager.z
    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = "flex")
    public void setFlex(float f2) {
        if (t()) {
            return;
        }
        super.setFlex(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "flexBasis")
    public void setFlexBasis(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            H0(this.C.a);
        } else if (i2 == 3) {
            I0();
        } else if (i2 == 4) {
            J0(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "flexDirection")
    public void setFlexDirection(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            K0(com.facebook.yoga.k.COLUMN);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1448970769:
                if (str.equals("row-reverse")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1354837162:
                if (str.equals("column")) {
                    c2 = 1;
                    break;
                }
                break;
            case 113114:
                if (str.equals("row")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1272730475:
                if (str.equals("column-reverse")) {
                    c2 = 3;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                K0(com.facebook.yoga.k.ROW_REVERSE);
                return;
            case 1:
                K0(com.facebook.yoga.k.COLUMN);
                return;
            case 2:
                K0(com.facebook.yoga.k.ROW);
                return;
            case 3:
                K0(com.facebook.yoga.k.COLUMN_REVERSE);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for flexDirection: " + str);
        }
    }

    @Override // com.facebook.react.uimanager.z
    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = "flexGrow")
    public void setFlexGrow(float f2) {
        if (t()) {
            return;
        }
        super.setFlexGrow(f2);
    }

    @Override // com.facebook.react.uimanager.z
    @com.facebook.react.uimanager.c1.a(defaultFloat = 0.0f, name = "flexShrink")
    public void setFlexShrink(float f2) {
        if (t()) {
            return;
        }
        super.setFlexShrink(f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "flexWrap")
    public void setFlexWrap(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            L0(com.facebook.yoga.w.NO_WRAP);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1039592053:
                if (str.equals("nowrap")) {
                    c2 = 0;
                    break;
                }
                break;
            case -749527969:
                if (str.equals("wrap-reverse")) {
                    c2 = 1;
                    break;
                }
                break;
            case 3657802:
                if (str.equals("wrap")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                L0(com.facebook.yoga.w.NO_WRAP);
                return;
            case 1:
                L0(com.facebook.yoga.w.WRAP_REVERSE);
                return;
            case 2:
                L0(com.facebook.yoga.w.WRAP);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for flexWrap: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "height")
    public void setHeight(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            f(this.C.a);
        } else if (i2 == 3) {
            Z0();
        } else if (i2 == 4) {
            a1(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "justifyContent")
    public void setJustifyContent(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            M0(com.facebook.yoga.l.FLEX_START);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals("center")) {
                    c2 = 0;
                    break;
                }
                break;
            case -46581362:
                if (str.equals("flex-start")) {
                    c2 = 1;
                    break;
                }
                break;
            case 441309761:
                if (str.equals("space-between")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1742952711:
                if (str.equals("flex-end")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1937124468:
                if (str.equals("space-around")) {
                    c2 = 4;
                    break;
                }
                break;
            case 2055030478:
                if (str.equals("space-evenly")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                M0(com.facebook.yoga.l.CENTER);
                return;
            case 1:
                M0(com.facebook.yoga.l.FLEX_START);
                return;
            case 2:
                M0(com.facebook.yoga.l.SPACE_BETWEEN);
                return;
            case 3:
                M0(com.facebook.yoga.l.FLEX_END);
                return;
            case 4:
                M0(com.facebook.yoga.l.SPACE_AROUND);
                return;
            case 5:
                M0(com.facebook.yoga.l.SPACE_EVENLY);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for justifyContent: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.b(names = {"margin", "marginVertical", "marginHorizontal", "marginStart", "marginEnd", "marginTop", "marginBottom", "marginLeft", "marginRight"})
    public void setMargins(int i2, Dynamic dynamic) {
        if (t()) {
            return;
        }
        int n1 = n1(a1.f5044b[i2]);
        this.C.a(dynamic);
        int i3 = a.a[this.C.f5128b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            O0(n1, this.C.a);
        } else if (i3 == 3) {
            P0(n1);
        } else if (i3 == 4) {
            Q0(n1, this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "maxHeight")
    public void setMaxHeight(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            b1(this.C.a);
        } else if (i2 == 4) {
            c1(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "maxWidth")
    public void setMaxWidth(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            d1(this.C.a);
        } else if (i2 == 4) {
            e1(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "minHeight")
    public void setMinHeight(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            f1(this.C.a);
        } else if (i2 == 4) {
            g1(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "minWidth")
    public void setMinWidth(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            h1(this.C.a);
        } else if (i2 == 4) {
            i1(this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "overflow")
    public void setOverflow(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            S0(com.facebook.yoga.s.VISIBLE);
            return;
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1217487446:
                if (str.equals("hidden")) {
                    c2 = 0;
                    break;
                }
                break;
            case -907680051:
                if (str.equals("scroll")) {
                    c2 = 1;
                    break;
                }
                break;
            case 466743410:
                if (str.equals("visible")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                S0(com.facebook.yoga.s.HIDDEN);
                return;
            case 1:
                S0(com.facebook.yoga.s.SCROLL);
                return;
            case 2:
                S0(com.facebook.yoga.s.VISIBLE);
                return;
            default:
                throw new JSApplicationIllegalArgumentException("invalid value for overflow: " + str);
        }
    }

    @com.facebook.react.uimanager.c1.b(names = {"padding", "paddingVertical", "paddingHorizontal", "paddingStart", "paddingEnd", "paddingTop", "paddingBottom", "paddingLeft", "paddingRight"})
    public void setPaddings(int i2, Dynamic dynamic) {
        if (t()) {
            return;
        }
        int n1 = n1(a1.f5044b[i2]);
        this.C.a(dynamic);
        int i3 = a.a[this.C.f5128b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            T0(n1, this.C.a);
        } else if (i3 == 4) {
            U0(n1, this.C.a);
        }
        dynamic.recycle();
    }

    @com.facebook.react.uimanager.c1.a(name = "position")
    public void setPosition(String str) {
        if (t()) {
            return;
        }
        if (str == null) {
            X0(com.facebook.yoga.t.RELATIVE);
        } else if (str.equals("relative")) {
            X0(com.facebook.yoga.t.RELATIVE);
        } else if (!str.equals("absolute")) {
            throw new JSApplicationIllegalArgumentException("invalid value for position: " + str);
        } else {
            X0(com.facebook.yoga.t.ABSOLUTE);
        }
    }

    @com.facebook.react.uimanager.c1.b(names = {"start", "end", "left", "right", "top", "bottom"})
    public void setPositionValues(int i2, Dynamic dynamic) {
        if (t()) {
            return;
        }
        int n1 = n1(new int[]{4, 5, 0, 2, 1, 3}[i2]);
        this.C.a(dynamic);
        int i3 = a.a[this.C.f5128b.ordinal()];
        if (i3 == 1 || i3 == 2) {
            V0(n1, this.C.a);
        } else if (i3 == 4) {
            W0(n1, this.C.a);
        }
        dynamic.recycle();
    }

    @Override // com.facebook.react.uimanager.z
    @com.facebook.react.uimanager.c1.a(name = "onLayout")
    public void setShouldNotifyOnLayout(boolean z) {
        super.setShouldNotifyOnLayout(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "width")
    public void setWidth(Dynamic dynamic) {
        if (t()) {
            return;
        }
        this.C.a(dynamic);
        int i2 = a.a[this.C.f5128b.ordinal()];
        if (i2 == 1 || i2 == 2) {
            A(this.C.a);
        } else if (i2 == 3) {
            j1();
        } else if (i2 == 4) {
            k1(this.C.a);
        }
        dynamic.recycle();
    }
}