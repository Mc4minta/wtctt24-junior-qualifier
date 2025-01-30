package com.facebook.react.animated;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: InterpolationAnimatedNode.java */
/* loaded from: classes2.dex */
class i extends s {

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f4731i = Pattern.compile("[+-]?(\\d+\\.?\\d*|\\.\\d+)([eE][+-]?\\d+)?");

    /* renamed from: j  reason: collision with root package name */
    private final double[] f4732j;

    /* renamed from: k  reason: collision with root package name */
    private final double[] f4733k;

    /* renamed from: l  reason: collision with root package name */
    private String f4734l;
    private double[][] m;
    private final boolean n;
    private final Matcher o;
    private final String p;
    private final String q;
    private s r;
    private boolean s;
    private int t;

    public i(ReadableMap readableMap) {
        this.f4732j = m(readableMap.getArray("inputRange"));
        ReadableArray array = readableMap.getArray("outputRange");
        boolean z = array.getType(0) == ReadableType.String;
        this.n = z;
        if (z) {
            int size = array.size();
            this.f4733k = new double[size];
            String string = array.getString(0);
            this.f4734l = string;
            this.s = string.startsWith("rgb");
            this.o = f4731i.matcher(this.f4734l);
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < size; i2++) {
                Matcher matcher = f4731i.matcher(array.getString(i2));
                ArrayList arrayList2 = new ArrayList();
                arrayList.add(arrayList2);
                while (matcher.find()) {
                    arrayList2.add(Double.valueOf(Double.parseDouble(matcher.group())));
                }
                this.f4733k[i2] = ((Double) arrayList2.get(0)).doubleValue();
            }
            int size2 = ((ArrayList) arrayList.get(0)).size();
            this.t = size2;
            this.m = new double[size2];
            for (int i3 = 0; i3 < this.t; i3++) {
                double[] dArr = new double[size];
                this.m[i3] = dArr;
                for (int i4 = 0; i4 < size; i4++) {
                    dArr[i4] = ((Double) ((ArrayList) arrayList.get(i4)).get(i3)).doubleValue();
                }
            }
        } else {
            this.f4733k = m(array);
            this.o = null;
        }
        this.p = readableMap.getString("extrapolateLeft");
        this.q = readableMap.getString("extrapolateRight");
    }

    private static int l(double d2, double[] dArr) {
        int i2 = 1;
        while (i2 < dArr.length - 1 && dArr[i2] < d2) {
            i2++;
        }
        return i2 - 1;
    }

    private static double[] m(ReadableArray readableArray) {
        int size = readableArray.size();
        double[] dArr = new double[size];
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = readableArray.getDouble(i2);
        }
        return dArr;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006f, code lost:
        if (r24.equals("clamp") == false) goto L15;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00a9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static double n(double r13, double r15, double r17, double r19, double r21, java.lang.String r23, java.lang.String r24) {
        /*
            r0 = r23
            r1 = r24
            int r2 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            java.lang.String r3 = "Invalid extrapolation type "
            r4 = 2
            java.lang.String r5 = "clamp"
            r6 = 1
            java.lang.String r7 = "identity"
            r8 = 0
            java.lang.String r9 = "extend"
            r10 = -1
            if (r2 >= 0) goto L5a
            r23.hashCode()
            int r11 = r23.hashCode()
            switch(r11) {
                case -1289044198: goto L32;
                case -135761730: goto L29;
                case 94742715: goto L20;
                default: goto L1e;
            }
        L1e:
            r11 = r10
            goto L3a
        L20:
            boolean r11 = r0.equals(r5)
            if (r11 != 0) goto L27
            goto L1e
        L27:
            r11 = r4
            goto L3a
        L29:
            boolean r11 = r0.equals(r7)
            if (r11 != 0) goto L30
            goto L1e
        L30:
            r11 = r6
            goto L3a
        L32:
            boolean r11 = r0.equals(r9)
            if (r11 != 0) goto L39
            goto L1e
        L39:
            r11 = r8
        L3a:
            switch(r11) {
                case 0: goto L5a;
                case 1: goto L59;
                case 2: goto L57;
                default: goto L3d;
            }
        L3d:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r1 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "for left extrapolation"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L57:
            r11 = r15
            goto L5b
        L59:
            return r13
        L5a:
            r11 = r13
        L5b:
            int r0 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r0 <= 0) goto La4
            r24.hashCode()
            int r0 = r24.hashCode()
            switch(r0) {
                case -1289044198: goto L7b;
                case -135761730: goto L72;
                case 94742715: goto L6b;
                default: goto L69;
            }
        L69:
            r4 = r10
            goto L83
        L6b:
            boolean r0 = r1.equals(r5)
            if (r0 != 0) goto L83
            goto L69
        L72:
            boolean r0 = r1.equals(r7)
            if (r0 != 0) goto L79
            goto L69
        L79:
            r4 = r6
            goto L83
        L7b:
            boolean r0 = r1.equals(r9)
            if (r0 != 0) goto L82
            goto L69
        L82:
            r4 = r8
        L83:
            switch(r4) {
                case 0: goto La4;
                case 1: goto La3;
                case 2: goto La0;
                default: goto L86;
            }
        L86:
            com.facebook.react.bridge.JSApplicationIllegalArgumentException r0 = new com.facebook.react.bridge.JSApplicationIllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = "for right extrapolation"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            throw r0
        La0:
            r11 = r17
            goto La4
        La3:
            return r11
        La4:
            int r0 = (r19 > r21 ? 1 : (r19 == r21 ? 0 : -1))
            if (r0 != 0) goto La9
            return r19
        La9:
            int r0 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r0 != 0) goto Lb1
            if (r2 > 0) goto Lb0
            return r19
        Lb0:
            return r21
        Lb1:
            double r0 = r21 - r19
            double r11 = r11 - r15
            double r0 = r0 * r11
            double r2 = r17 - r15
            double r0 = r0 / r2
            double r0 = r19 + r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.animated.i.n(double, double, double, double, double, java.lang.String, java.lang.String):double");
    }

    static double o(double d2, double[] dArr, double[] dArr2, String str, String str2) {
        int l2 = l(d2, dArr);
        int i2 = l2 + 1;
        return n(d2, dArr[l2], dArr[i2], dArr2[l2], dArr2[i2], str, str2);
    }

    @Override // com.facebook.react.animated.b
    public void b(b bVar) {
        if (this.r == null) {
            if (bVar instanceof s) {
                this.r = (s) bVar;
                return;
            }
            throw new IllegalArgumentException("Parent is of an invalid type");
        }
        throw new IllegalStateException("Parent already attached");
    }

    @Override // com.facebook.react.animated.b
    public void c(b bVar) {
        if (bVar == this.r) {
            this.r = null;
            return;
        }
        throw new IllegalArgumentException("Invalid parent node provided");
    }

    @Override // com.facebook.react.animated.b
    public void e() {
        s sVar = this.r;
        if (sVar == null) {
            return;
        }
        double i2 = sVar.i();
        double o = o(i2, this.f4732j, this.f4733k, this.p, this.q);
        this.f4779f = o;
        if (this.n) {
            if (this.t > 1) {
                StringBuffer stringBuffer = new StringBuffer(this.f4734l.length());
                this.o.reset();
                int i3 = 0;
                while (this.o.find()) {
                    int i4 = i3 + 1;
                    double o2 = o(i2, this.f4732j, this.m[i3], this.p, this.q);
                    if (this.s) {
                        boolean z = i4 == 4;
                        if (z) {
                            o2 *= 1000.0d;
                        }
                        int round = (int) Math.round(o2);
                        this.o.appendReplacement(stringBuffer, z ? Double.toString(round / 1000.0d) : Integer.toString(round));
                    } else {
                        int i5 = (int) o2;
                        this.o.appendReplacement(stringBuffer, ((double) i5) != o2 ? Double.toString(o2) : Integer.toString(i5));
                    }
                    i3 = i4;
                }
                this.o.appendTail(stringBuffer);
                this.f4778e = stringBuffer.toString();
                return;
            }
            this.f4778e = this.o.replaceFirst(String.valueOf(o));
        }
    }
}