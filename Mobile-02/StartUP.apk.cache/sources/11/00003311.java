package com.google.android.gms.internal.clearcut;

import com.lwansbrough.RCTCamera.RCTCameraModule;
import java.lang.reflect.Field;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class x2 {
    private int A;
    private int B;
    private Field C;
    private Object D;
    private Object E;
    private Object F;
    private final y2 a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f6612b;

    /* renamed from: c  reason: collision with root package name */
    private Class<?> f6613c;

    /* renamed from: d  reason: collision with root package name */
    private final int f6614d;

    /* renamed from: e  reason: collision with root package name */
    private final int f6615e;

    /* renamed from: f  reason: collision with root package name */
    private final int f6616f;

    /* renamed from: g  reason: collision with root package name */
    private final int f6617g;

    /* renamed from: h  reason: collision with root package name */
    private final int f6618h;

    /* renamed from: i  reason: collision with root package name */
    private final int f6619i;

    /* renamed from: j  reason: collision with root package name */
    private final int f6620j;

    /* renamed from: k  reason: collision with root package name */
    private final int f6621k;

    /* renamed from: l  reason: collision with root package name */
    private final int f6622l;
    private final int m;
    private final int[] n;
    private int o;
    private int p;
    private int q = RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO;
    private int r = Integer.MIN_VALUE;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private int v = 0;
    private int w = 0;
    private int x;
    private int y;
    private int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x2(Class<?> cls, String str, Object[] objArr) {
        this.f6613c = cls;
        y2 y2Var = new y2(str);
        this.a = y2Var;
        this.f6612b = objArr;
        this.f6614d = y2Var.b();
        int b2 = y2Var.b();
        this.f6615e = b2;
        if (b2 == 0) {
            this.f6616f = 0;
            this.f6617g = 0;
            this.f6618h = 0;
            this.f6619i = 0;
            this.f6620j = 0;
            this.f6622l = 0;
            this.f6621k = 0;
            this.m = 0;
            this.n = null;
            return;
        }
        int b3 = y2Var.b();
        this.f6616f = b3;
        int b4 = y2Var.b();
        this.f6617g = b4;
        this.f6618h = y2Var.b();
        this.f6619i = y2Var.b();
        this.f6622l = y2Var.b();
        this.f6621k = y2Var.b();
        this.f6620j = y2Var.b();
        this.m = y2Var.b();
        int b5 = y2Var.b();
        this.n = b5 != 0 ? new int[b5] : null;
        this.o = (b3 << 1) + b4;
    }

    private static Field c(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + name.length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    private final Object f() {
        Object[] objArr = this.f6612b;
        int i2 = this.o;
        this.o = i2 + 1;
        return objArr[i2];
    }

    private final boolean i() {
        return (this.f6614d & 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c6, code lost:
        if (i() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c8, code lost:
        r6.E = f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0152, code lost:
        if (((r6.y & org.spongycastle.asn1.cmp.PKIFailureInfo.wrongIntegrity) != 0) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0159, code lost:
        if (i() != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a() {
        /*
            Method dump skipped, instructions count: 358
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.x2.a():boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int g() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int h() {
        return this.z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean k() {
        return this.z > z0.c0.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field l() {
        int i2 = this.A << 1;
        Object obj = this.f6612b[i2];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c2 = c(this.f6613c, (String) obj);
        this.f6612b[i2] = c2;
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field m() {
        int i2 = (this.A << 1) + 1;
        Object obj = this.f6612b[i2];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c2 = c(this.f6613c, (String) obj);
        this.f6612b[i2] = c2;
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field n() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean o() {
        return i() && this.z <= z0.v.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Field p() {
        int i2 = (this.f6616f << 1) + (this.B / 32);
        Object obj = this.f6612b[i2];
        if (obj instanceof Field) {
            return (Field) obj;
        }
        Field c2 = c(this.f6613c, (String) obj);
        this.f6612b[i2] = c2;
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int q() {
        return this.B % 32;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean r() {
        return (this.y & 256) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        return (this.y & 512) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object t() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object u() {
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object v() {
        return this.F;
    }
}