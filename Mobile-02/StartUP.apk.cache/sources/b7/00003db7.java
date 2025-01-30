package com.horcrux.svg;

import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;

/* compiled from: SVGLength.java */
/* loaded from: classes2.dex */
class c0 {
    final double a;

    /* renamed from: b  reason: collision with root package name */
    final b f10211b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SVGLength.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            a = iArr;
            try {
                iArr[ReadableType.Number.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReadableType.String.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReadableType.Array.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: SVGLength.java */
    /* loaded from: classes2.dex */
    public enum b {
        UNKNOWN,
        NUMBER,
        PERCENTAGE,
        EMS,
        EXS,
        PX,
        CM,
        MM,
        IN,
        PT,
        PC
    }

    private c0() {
        this.a = 0.0d;
        this.f10211b = b.UNKNOWN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<c0> a(Dynamic dynamic) {
        int i2 = a.a[dynamic.getType().ordinal()];
        if (i2 == 1) {
            ArrayList<c0> arrayList = new ArrayList<>(1);
            arrayList.add(new c0(dynamic.asDouble()));
            return arrayList;
        } else if (i2 == 2) {
            ArrayList<c0> arrayList2 = new ArrayList<>(1);
            arrayList2.add(new c0(dynamic.asString()));
            return arrayList2;
        } else if (i2 != 3) {
            return null;
        } else {
            ReadableArray asArray = dynamic.asArray();
            int size = asArray.size();
            ArrayList<c0> arrayList3 = new ArrayList<>(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList3.add(b(asArray.getDynamic(i3)));
            }
            return arrayList3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c0 b(Dynamic dynamic) {
        int i2 = a.a[dynamic.getType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return new c0();
            }
            return new c0(dynamic.asString());
        }
        return new c0(dynamic.asDouble());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Dynamic dynamic) {
        int i2 = a.a[dynamic.getType().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return null;
            }
            return dynamic.asString();
        }
        return String.valueOf(dynamic.asDouble());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(double d2) {
        this.a = d2;
        this.f10211b = b.NUMBER;
    }

    private c0(String str) {
        String trim = str.trim();
        int length = trim.length();
        int i2 = length - 1;
        if (length != 0 && !trim.equals("normal")) {
            if (trim.codePointAt(i2) == 37) {
                this.f10211b = b.PERCENTAGE;
                this.a = Double.valueOf(trim.substring(0, i2)).doubleValue();
                return;
            }
            int i3 = length - 2;
            if (i3 > 0) {
                String substring = trim.substring(i3);
                substring.hashCode();
                char c2 = 65535;
                switch (substring.hashCode()) {
                    case 3178:
                        if (substring.equals("cm")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 3240:
                        if (substring.equals("em")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 3251:
                        if (substring.equals("ex")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3365:
                        if (substring.equals("in")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 3488:
                        if (substring.equals("mm")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 3571:
                        if (substring.equals("pc")) {
                            c2 = 5;
                            break;
                        }
                        break;
                    case 3588:
                        if (substring.equals("pt")) {
                            c2 = 6;
                            break;
                        }
                        break;
                    case 3592:
                        if (substring.equals("px")) {
                            c2 = 7;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        this.f10211b = b.CM;
                        length = i3;
                        break;
                    case 1:
                        this.f10211b = b.EMS;
                        length = i3;
                        break;
                    case 2:
                        this.f10211b = b.EXS;
                        length = i3;
                        break;
                    case 3:
                        this.f10211b = b.IN;
                        length = i3;
                        break;
                    case 4:
                        this.f10211b = b.MM;
                        length = i3;
                        break;
                    case 5:
                        this.f10211b = b.PC;
                        length = i3;
                        break;
                    case 6:
                        this.f10211b = b.PT;
                        length = i3;
                        break;
                    case 7:
                        this.f10211b = b.NUMBER;
                        length = i3;
                        break;
                    default:
                        this.f10211b = b.NUMBER;
                        break;
                }
                this.a = Double.valueOf(trim.substring(0, length)).doubleValue();
                return;
            }
            this.f10211b = b.NUMBER;
            this.a = Double.valueOf(trim).doubleValue();
            return;
        }
        this.f10211b = b.UNKNOWN;
        this.a = 0.0d;
    }
}