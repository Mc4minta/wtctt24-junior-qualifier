package e.a.a.y.k0;

import j.f;
import j.h;
import j.i;
import j.t;
import java.io.Closeable;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: JsonReader.java */
/* loaded from: classes.dex */
public abstract class c implements Closeable {
    private static final String[] a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    int f11924b;

    /* renamed from: c  reason: collision with root package name */
    int[] f11925c = new int[32];

    /* renamed from: d  reason: collision with root package name */
    String[] f11926d = new String[32];

    /* renamed from: e  reason: collision with root package name */
    int[] f11927e = new int[32];

    /* renamed from: f  reason: collision with root package name */
    boolean f11928f;

    /* renamed from: g  reason: collision with root package name */
    boolean f11929g;

    /* compiled from: JsonReader.java */
    /* loaded from: classes.dex */
    public static final class a {
        final String[] a;

        /* renamed from: b  reason: collision with root package name */
        final t f11930b;

        private a(String[] strArr, t tVar) {
            this.a = strArr;
            this.f11930b = tVar;
        }

        public static a a(String... strArr) {
            try {
                i[] iVarArr = new i[strArr.length];
                f fVar = new f();
                for (int i2 = 0; i2 < strArr.length; i2++) {
                    c.V(fVar, strArr[i2]);
                    fVar.m0();
                    iVarArr[i2] = fVar.v0();
                }
                return new a((String[]) strArr.clone(), t.r(iVarArr));
            } catch (IOException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    /* compiled from: JsonReader.java */
    /* loaded from: classes.dex */
    public enum b {
        BEGIN_ARRAY,
        END_ARRAY,
        BEGIN_OBJECT,
        END_OBJECT,
        NAME,
        STRING,
        NUMBER,
        BOOLEAN,
        NULL,
        END_DOCUMENT
    }

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            a[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = a;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void V(j.g r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String[] r0 = e.a.a.y.k0.c.a
            r1 = 34
            r7.R(r1)
            int r2 = r8.length()
            r3 = 0
            r4 = r3
        Ld:
            if (r3 >= r2) goto L36
            char r5 = r8.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L1c
            r5 = r0[r5]
            if (r5 != 0) goto L29
            goto L33
        L1c:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L23
            java.lang.String r5 = "\\u2028"
            goto L29
        L23:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L33
            java.lang.String r5 = "\\u2029"
        L29:
            if (r4 >= r3) goto L2e
            r7.q0(r8, r4, r3)
        L2e:
            r7.h0(r5)
            int r4 = r3 + 1
        L33:
            int r3 = r3 + 1
            goto Ld
        L36:
            if (r4 >= r2) goto L3b
            r7.q0(r8, r4, r2)
        L3b:
            r7.R(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.y.k0.c.V(j.g, java.lang.String):void");
    }

    public static c z(h hVar) {
        return new e(hVar);
    }

    public abstract b A() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void G(int i2) {
        int i3 = this.f11924b;
        int[] iArr = this.f11925c;
        if (i3 == iArr.length) {
            if (i3 != 256) {
                this.f11925c = Arrays.copyOf(iArr, iArr.length * 2);
                String[] strArr = this.f11926d;
                this.f11926d = (String[]) Arrays.copyOf(strArr, strArr.length * 2);
                int[] iArr2 = this.f11927e;
                this.f11927e = Arrays.copyOf(iArr2, iArr2.length * 2);
            } else {
                throw new e.a.a.y.k0.a("Nesting too deep at " + getPath());
            }
        }
        int[] iArr3 = this.f11925c;
        int i4 = this.f11924b;
        this.f11924b = i4 + 1;
        iArr3[i4] = i2;
    }

    public abstract int K(a aVar) throws IOException;

    public abstract void N() throws IOException;

    public abstract void O() throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final e.a.a.y.k0.b a0(String str) throws e.a.a.y.k0.b {
        throw new e.a.a.y.k0.b(str + " at path " + getPath());
    }

    public abstract void b() throws IOException;

    public abstract void c() throws IOException;

    public abstract void d() throws IOException;

    public abstract void e() throws IOException;

    public abstract boolean f() throws IOException;

    public abstract boolean g() throws IOException;

    public final String getPath() {
        return d.a(this.f11924b, this.f11925c, this.f11926d, this.f11927e);
    }

    public abstract double j() throws IOException;

    public abstract int m() throws IOException;

    public abstract String n() throws IOException;

    public abstract String v() throws IOException;
}