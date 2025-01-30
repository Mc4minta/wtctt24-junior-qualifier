package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* compiled from: JsonWriter.java */
/* loaded from: classes2.dex */
public class c implements Closeable, Flushable {
    private static final String[] a = new String[128];

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f9567b;

    /* renamed from: c  reason: collision with root package name */
    private final Writer f9568c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f9569d = new int[32];

    /* renamed from: e  reason: collision with root package name */
    private int f9570e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f9571f;

    /* renamed from: g  reason: collision with root package name */
    private String f9572g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f9573h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9574j;

    /* renamed from: k  reason: collision with root package name */
    private String f9575k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9576l;

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
        f9567b = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        N(6);
        this.f9572g = ":";
        this.f9576l = true;
        Objects.requireNonNull(writer, "out == null");
        this.f9568c = writer;
    }

    private c G(int i2, String str) throws IOException {
        b();
        N(i2);
        this.f9568c.write(str);
        return this;
    }

    private int K() {
        int i2 = this.f9570e;
        if (i2 != 0) {
            return this.f9569d[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void N(int i2) {
        int i3 = this.f9570e;
        int[] iArr = this.f9569d;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            this.f9569d = iArr2;
        }
        int[] iArr3 = this.f9569d;
        int i4 = this.f9570e;
        this.f9570e = i4 + 1;
        iArr3[i4] = i2;
    }

    private void O(int i2) {
        this.f9569d[this.f9570e - 1] = i2;
    }

    private void a() throws IOException {
        int K = K();
        if (K == 5) {
            this.f9568c.write(44);
        } else if (K != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        z();
        O(4);
    }

    private void b() throws IOException {
        int K = K();
        if (K == 1) {
            O(2);
            z();
        } else if (K == 2) {
            this.f9568c.append(',');
            z();
        } else if (K != 4) {
            if (K != 6) {
                if (K == 7) {
                    if (!this.f9573h) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            O(7);
        } else {
            this.f9568c.append((CharSequence) this.f9572g);
            O(5);
        }
    }

    private c e(int i2, int i3, String str) throws IOException {
        int K = K();
        if (K != i3 && K != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f9575k == null) {
            this.f9570e--;
            if (K == i3) {
                z();
            }
            this.f9568c.write(str);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f9575k);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void g0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f9574j
            if (r0 == 0) goto L7
            java.lang.String[] r0 = com.google.gson.stream.c.f9567b
            goto L9
        L7:
            java.lang.String[] r0 = com.google.gson.stream.c.a
        L9:
            java.io.Writer r1 = r8.f9568c
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
            java.io.Writer r6 = r8.f9568c
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.f9568c
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.f9568c
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.f9568c
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.c.g0(java.lang.String):void");
    }

    private void x0() throws IOException {
        if (this.f9575k != null) {
            a();
            g0(this.f9575k);
            this.f9575k = null;
        }
    }

    private void z() throws IOException {
        if (this.f9571f == null) {
            return;
        }
        this.f9568c.write("\n");
        int i2 = this.f9570e;
        for (int i3 = 1; i3 < i2; i3++) {
            this.f9568c.write(this.f9571f);
        }
    }

    public c A() throws IOException {
        if (this.f9575k != null) {
            if (this.f9576l) {
                x0();
            } else {
                this.f9575k = null;
                return this;
            }
        }
        b();
        this.f9568c.write("null");
        return this;
    }

    public final void V(boolean z) {
        this.f9574j = z;
    }

    public final void a0(String str) {
        if (str.length() == 0) {
            this.f9571f = null;
            this.f9572g = ":";
            return;
        }
        this.f9571f = str;
        this.f9572g = ": ";
    }

    public c c() throws IOException {
        x0();
        return G(1, "[");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9568c.close();
        int i2 = this.f9570e;
        if (i2 <= 1 && (i2 != 1 || this.f9569d[i2 - 1] == 7)) {
            this.f9570e = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public c d() throws IOException {
        x0();
        return G(3, "{");
    }

    public final void d0(boolean z) {
        this.f9573h = z;
    }

    public final void e0(boolean z) {
        this.f9576l = z;
    }

    public c f() throws IOException {
        return e(1, 2, "]");
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f9570e != 0) {
            this.f9568c.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c g() throws IOException {
        return e(3, 5, "}");
    }

    public final boolean j() {
        return this.f9576l;
    }

    public c k0(double d2) throws IOException {
        x0();
        if (!this.f9573h && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        b();
        this.f9568c.append((CharSequence) Double.toString(d2));
        return this;
    }

    public final boolean m() {
        return this.f9574j;
    }

    public boolean n() {
        return this.f9573h;
    }

    public c n0(long j2) throws IOException {
        x0();
        b();
        this.f9568c.write(Long.toString(j2));
        return this;
    }

    public c o0(Boolean bool) throws IOException {
        if (bool == null) {
            return A();
        }
        x0();
        b();
        this.f9568c.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    public c r0(Number number) throws IOException {
        if (number == null) {
            return A();
        }
        x0();
        String obj = number.toString();
        if (!this.f9573h && (obj.equals("-Infinity") || obj.equals("Infinity") || obj.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        }
        b();
        this.f9568c.append((CharSequence) obj);
        return this;
    }

    public c s0(String str) throws IOException {
        if (str == null) {
            return A();
        }
        x0();
        b();
        g0(str);
        return this;
    }

    public c v(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f9575k == null) {
            if (this.f9570e != 0) {
                this.f9575k = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public c w0(boolean z) throws IOException {
        x0();
        b();
        this.f9568c.write(z ? "true" : "false");
        return this;
    }
}