package com.horcrux.svg;

import com.facebook.react.bridge.ReadableArray;
import com.horcrux.svg.c0;

/* compiled from: PropHelper.java */
/* loaded from: classes2.dex */
class w {

    /* compiled from: PropHelper.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c0.b.values().length];
            a = iArr;
            try {
                iArr[c0.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c0.b.PX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c0.b.PERCENTAGE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c0.b.EMS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[c0.b.EXS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[c0.b.CM.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[c0.b.MM.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[c0.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[c0.b.PT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[c0.b.PC.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[c0.b.UNKNOWN.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static double a(c0 c0Var, double d2, double d3, double d4, double d5) {
        double d6;
        if (c0Var == null) {
            return d3;
        }
        c0.b bVar = c0Var.f10211b;
        double d7 = c0Var.a;
        switch (a.a[bVar.ordinal()]) {
            case 1:
            case 2:
                d5 = 1.0d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 3:
                d6 = (d7 / 100.0d) * d2;
                break;
            case 4:
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 5:
                d5 /= 2.0d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 6:
                d5 = 35.43307d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 7:
                d5 = 3.543307d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 8:
                d5 = 90.0d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 9:
                d5 = 1.25d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            case 10:
                d5 = 15.0d;
                d7 *= d5;
                d6 = d7 * d4;
                break;
            default:
                d6 = d7 * d4;
                break;
        }
        return d6 + d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static double b(String str, double d2, double d3, double d4) {
        double doubleValue;
        String trim = str.trim();
        int length = trim.length();
        int i2 = length - 1;
        if (length == 0 || trim.equals("normal")) {
            return 0.0d;
        }
        if (trim.codePointAt(i2) == 37) {
            return (Double.valueOf(trim.substring(0, i2)).doubleValue() / 100.0d) * d2;
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
                case 3365:
                    if (substring.equals("in")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 3488:
                    if (substring.equals("mm")) {
                        c2 = 3;
                        break;
                    }
                    break;
                case 3571:
                    if (substring.equals("pc")) {
                        c2 = 4;
                        break;
                    }
                    break;
                case 3588:
                    if (substring.equals("pt")) {
                        c2 = 5;
                        break;
                    }
                    break;
                case 3592:
                    if (substring.equals("px")) {
                        c2 = 6;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    d4 = 35.43307d;
                    length = i3;
                    break;
                case 1:
                    length = i3;
                    break;
                case 2:
                    d4 = 90.0d;
                    length = i3;
                    break;
                case 3:
                    d4 = 3.543307d;
                    length = i3;
                    break;
                case 4:
                    d4 = 15.0d;
                    length = i3;
                    break;
                case 5:
                    d4 = 1.25d;
                    length = i3;
                    break;
                case 6:
                    length = i3;
                    d4 = 1.0d;
                    break;
                default:
                    d4 = 1.0d;
                    break;
            }
            doubleValue = Double.valueOf(trim.substring(0, length)).doubleValue() * d4;
        } else {
            doubleValue = Double.valueOf(trim).doubleValue();
        }
        return doubleValue * d3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(ReadableArray readableArray, float[] fArr, float f2) {
        int size = readableArray.size();
        if (size != 6) {
            return size;
        }
        fArr[0] = (float) readableArray.getDouble(0);
        fArr[1] = (float) readableArray.getDouble(2);
        fArr[2] = ((float) readableArray.getDouble(4)) * f2;
        fArr[3] = (float) readableArray.getDouble(1);
        fArr[4] = (float) readableArray.getDouble(3);
        fArr[5] = ((float) readableArray.getDouble(5)) * f2;
        return 6;
    }
}