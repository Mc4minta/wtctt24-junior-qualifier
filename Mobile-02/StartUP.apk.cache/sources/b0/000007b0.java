package com.bugsnag.android;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: JsonWriter.java */
/* loaded from: classes.dex */
class p0 implements Closeable, Flushable {
    private static final String[] a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f3674b;

    /* renamed from: c  reason: collision with root package name */
    private final Writer f3675c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f3676d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    private int f3677e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f3678f;

    /* renamed from: g  reason: collision with root package name */
    private String f3679g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3680h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3681j;

    /* renamed from: k  reason: collision with root package name */
    private String f3682k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f3683l;

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
        String[] strArr2 = (String[]) strArr.clone();
        f3674b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public p0(Writer writer) {
        A(6);
        this.f3679g = ":";
        this.f3683l = true;
        Objects.requireNonNull(writer, "out == null");
        this.f3675c = writer;
    }

    private void A(int i2) {
        int i3 = this.f3677e;
        int[] iArr = this.f3676d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f3676d = iArr2;
        }
        int[] iArr3 = this.f3676d;
        int i4 = this.f3677e;
        this.f3677e = i4 + 1;
        iArr3[i4] = i2;
    }

    private void G(int i2) {
        this.f3676d[this.f3677e - 1] = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void N(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f3681j
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.bugsnag.android.p0.f3674b
            goto L9
        L7:
            java.lang.String[] r0 = com.bugsnag.android.p0.a
        L9:
            java.io.Writer r1 = r8.f3675c
            java.lang.String r2 = "\""
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = r3
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.8E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.f3675c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f3675c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f3675c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f3675c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bugsnag.android.p0.N(java.lang.String):void");
    }

    private void a() throws IOException {
        int z = z();
        if (z == 5) {
            this.f3675c.write(44);
        } else if (z != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m();
        G(4);
    }

    private p0 e(int i2, int i3, String str) throws IOException {
        int z = z();
        if (z != i3 && z != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f3682k == null) {
            this.f3677e--;
            if (z == i3) {
                m();
            }
            this.f3675c.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f3682k);
    }

    private void g0() throws IOException {
        if (this.f3682k != null) {
            a();
            N(this.f3682k);
            this.f3682k = null;
        }
    }

    private void m() throws IOException {
        if (this.f3678f == null) {
            return;
        }
        this.f3675c.write("\n");
        int i2 = this.f3677e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f3675c.write(this.f3678f);
        }
    }

    private p0 v(int i2, String str) throws IOException {
        b();
        A(i2);
        this.f3675c.write(str);
        return this;
    }

    private int z() {
        int i2 = this.f3677e;
        if (i2 != 0) {
            return this.f3676d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final void K(boolean z) {
        this.f3683l = z;
    }

    public p0 O(long j2) throws IOException {
        g0();
        b();
        this.f3675c.write(Long.toString(j2));
        return this;
    }

    public p0 V(Boolean bool) throws IOException {
        if (bool == null) {
            return n();
        }
        g0();
        b();
        this.f3675c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public p0 a0(Number number) throws IOException {
        if (number == null) {
            return n();
        }
        g0();
        String obj = number.toString();
        if (!this.f3680h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f3675c.append((CharSequence) obj);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() throws IOException {
        int z = z();
        if (z == 1) {
            G(2);
            m();
        } else if (z == 2) {
            this.f3675c.append(',');
            m();
        } else if (z != 4) {
            if (z != 6) {
                if (z == 7) {
                    if (!this.f3680h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            G(7);
        } else {
            this.f3675c.append((CharSequence) this.f3679g);
            G(5);
        }
    }

    public p0 c() throws IOException {
        g0();
        return v(1, "[");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3675c.close();
        int i2 = this.f3677e;
        if (i2 <= 1 && (i2 != 1 || this.f3676d[i2 - 1] == 7)) {
            this.f3677e = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public p0 d() throws IOException {
        g0();
        return v(3, "{");
    }

    public p0 d0(String str) throws IOException {
        if (str == null) {
            return n();
        }
        g0();
        b();
        N(str);
        return this;
    }

    public p0 e0(boolean z) throws IOException {
        g0();
        b();
        this.f3675c.write(z ? "true" : "false");
        return this;
    }

    public p0 f() throws IOException {
        return e(1, 2, "]");
    }

    public void flush() throws IOException {
        if (this.f3677e != 0) {
            this.f3675c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public p0 g() throws IOException {
        return e(3, 5, "}");
    }

    public p0 j(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f3682k == null) {
            if (this.f3677e != 0) {
                this.f3682k = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public p0 n() throws IOException {
        if (this.f3682k != null) {
            if (this.f3683l) {
                g0();
            } else {
                this.f3682k = null;
                return this;
            }
        }
        b();
        this.f3675c.write("null");
        return this;
    }
}