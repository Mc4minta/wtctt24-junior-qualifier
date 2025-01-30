package com.google.gson.stream;

import com.google.gson.u.f;
import com.google.gson.u.n.e;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import org.apache.http.message.TokenParser;

/* compiled from: JsonReader.java */
/* loaded from: classes2.dex */
public class a implements Closeable {
    private static final char[] a = ")]}'\n".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    private final Reader f9547b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f9548c = false;

    /* renamed from: d  reason: collision with root package name */
    private final char[] f9549d = new char[1024];

    /* renamed from: e  reason: collision with root package name */
    private int f9550e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f9551f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f9552g = 0;

    /* renamed from: h  reason: collision with root package name */
    private int f9553h = 0;

    /* renamed from: j  reason: collision with root package name */
    int f9554j = 0;

    /* renamed from: k  reason: collision with root package name */
    private long f9555k;

    /* renamed from: l  reason: collision with root package name */
    private int f9556l;
    private String m;
    private int[] n;
    private int p;
    private String[] q;
    private int[] t;

    /* compiled from: JsonReader.java */
    /* renamed from: com.google.gson.stream.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0196a extends f {
        C0196a() {
        }

        @Override // com.google.gson.u.f
        public void a(a aVar) throws IOException {
            if (aVar instanceof e) {
                ((e) aVar).R0();
                return;
            }
            int i2 = aVar.f9554j;
            if (i2 == 0) {
                i2 = aVar.e();
            }
            if (i2 == 13) {
                aVar.f9554j = 9;
            } else if (i2 == 12) {
                aVar.f9554j = 8;
            } else if (i2 == 14) {
                aVar.f9554j = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.k0() + aVar.z());
            }
        }
    }

    static {
        f.a = new C0196a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.n = iArr;
        this.p = 0;
        this.p = 0 + 1;
        iArr[0] = 6;
        this.q = new String[32];
        this.t = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f9547b = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        c();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void I0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f9550e
            int r2 = r1 + r0
            int r3 = r4.f9551f
            if (r2 >= r3) goto L51
            char[] r2 = r4.f9549d
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.c()
        L4b:
            int r1 = r4.f9550e
            int r1 = r1 + r0
            r4.f9550e = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f9550e = r1
            r0 = 1
            boolean r0 = r4.j(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.I0():void");
    }

    private IOException L0(String str) throws IOException {
        throw new MalformedJsonException(str + z());
    }

    private int V(boolean z) throws IOException {
        char[] cArr = this.f9549d;
        int i2 = this.f9550e;
        int i3 = this.f9551f;
        while (true) {
            if (i2 == i3) {
                this.f9550e = i2;
                if (!j(1)) {
                    if (z) {
                        throw new EOFException("End of input" + z());
                    }
                    return -1;
                }
                i2 = this.f9550e;
                i3 = this.f9551f;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f9552g++;
                this.f9553h = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f9550e = i4;
                    if (i4 == i3) {
                        this.f9550e = i4 - 1;
                        boolean j2 = j(2);
                        this.f9550e++;
                        if (!j2) {
                            return c2;
                        }
                    }
                    c();
                    int i5 = this.f9550e;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f9550e = i5 + 1;
                        if (y0("*/")) {
                            i2 = this.f9550e + 2;
                            i3 = this.f9551f;
                        } else {
                            throw L0("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f9550e = i5 + 1;
                        z0();
                        i2 = this.f9550e;
                        i3 = this.f9551f;
                    }
                } else if (c2 == '#') {
                    this.f9550e = i4;
                    c();
                    z0();
                    i2 = this.f9550e;
                    i3 = this.f9551f;
                } else {
                    this.f9550e = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    private void c() throws IOException {
        if (!this.f9548c) {
            throw L0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void d() throws IOException {
        V(true);
        int i2 = this.f9550e - 1;
        this.f9550e = i2;
        char[] cArr = a;
        if (i2 + cArr.length > this.f9551f && !j(cArr.length)) {
            return;
        }
        int i3 = 0;
        while (true) {
            char[] cArr2 = a;
            if (i3 < cArr2.length) {
                if (this.f9549d[this.f9550e + i3] != cArr2[i3]) {
                    return;
                }
                i3++;
            } else {
                this.f9550e += cArr2.length;
                return;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f9550e = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d0(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f9549d
            r1 = 0
        L3:
            int r2 = r9.f9550e
            int r3 = r9.f9551f
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f9550e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4f
            r9.f9550e = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L40
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L40:
            r1.append(r0, r3, r7)
            char r2 = r9.s0()
            r1.append(r2)
            int r2 = r9.f9550e
            int r3 = r9.f9551f
            goto L7
        L4f:
            r5 = 10
            if (r2 != r5) goto L5a
            int r2 = r9.f9552g
            int r2 = r2 + r6
            r9.f9552g = r2
            r9.f9553h = r7
        L5a:
            r2 = r7
            goto L9
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f9550e = r2
            boolean r2 = r9.j(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.L0(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.d0(char):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        c();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String g0() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = r0
        L3:
            int r3 = r6.f9550e
            int r4 = r3 + r2
            int r5 = r6.f9551f
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f9549d
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.c()
            goto L5c
        L4e:
            char[] r3 = r6.f9549d
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.j(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.f9549d
            int r4 = r6.f9550e
            r1.append(r3, r4, r2)
            int r3 = r6.f9550e
            int r3 = r3 + r2
            r6.f9550e = r3
            r2 = 1
            boolean r2 = r6.j(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f9549d
            int r3 = r6.f9550e
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.f9549d
            int r3 = r6.f9550e
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f9550e
            int r2 = r2 + r0
            r6.f9550e = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.g0():java.lang.String");
    }

    private boolean j(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f9549d;
        int i5 = this.f9553h;
        int i6 = this.f9550e;
        this.f9553h = i5 - i6;
        int i7 = this.f9551f;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f9551f = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f9551f = 0;
        }
        this.f9550e = 0;
        do {
            Reader reader = this.f9547b;
            int i9 = this.f9551f;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f9551f + read;
            this.f9551f = i3;
            if (this.f9552g == 0 && (i4 = this.f9553h) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f9550e++;
                this.f9553h = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private int n0() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f9549d[this.f9550e];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f9550e + i3 >= this.f9551f && !j(i3 + 1)) {
                return 0;
            }
            char c3 = this.f9549d[this.f9550e + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f9550e + length < this.f9551f || j(length + 1)) && v(this.f9549d[this.f9550e + length])) {
            return 0;
        }
        this.f9550e += length;
        this.f9554j = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
        if (v(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
        r18.f9555k = r11;
        r18.f9550e += r8;
        r18.f9554j = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
        r18.f9556l = r8;
        r18.f9554j = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int o0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 247
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.stream.a.o0():int");
    }

    private void r0(int i2) {
        int i3 = this.p;
        int[] iArr = this.n;
        if (i3 == iArr.length) {
            int[] iArr2 = new int[i3 * 2];
            int[] iArr3 = new int[i3 * 2];
            String[] strArr = new String[i3 * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.t, 0, iArr3, 0, this.p);
            System.arraycopy(this.q, 0, strArr, 0, this.p);
            this.n = iArr2;
            this.t = iArr3;
            this.q = strArr;
        }
        int[] iArr4 = this.n;
        int i4 = this.p;
        this.p = i4 + 1;
        iArr4[i4] = i2;
    }

    private char s0() throws IOException {
        int i2;
        int i3;
        if (this.f9550e == this.f9551f && !j(1)) {
            throw L0("Unterminated escape sequence");
        }
        char[] cArr = this.f9549d;
        int i4 = this.f9550e;
        int i5 = i4 + 1;
        this.f9550e = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f9552g++;
            this.f9553h = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i5 + 4 > this.f9551f && !j(4)) {
                                        throw L0("Unterminated escape sequence");
                                    }
                                    char c3 = 0;
                                    int i6 = this.f9550e;
                                    int i7 = i6 + 4;
                                    while (i6 < i7) {
                                        char c4 = this.f9549d[i6];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i2 = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f9549d, this.f9550e, 4));
                                            } else {
                                                i2 = c4 - 'A';
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = c4 - '0';
                                        }
                                        c3 = (char) (c5 + i3);
                                        i6++;
                                    }
                                    this.f9550e += 4;
                                    return c3;
                                }
                                throw L0("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return TokenParser.CR;
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c2;
    }

    private boolean v(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        return false;
    }

    private void x0(char c2) throws IOException {
        char[] cArr = this.f9549d;
        do {
            int i2 = this.f9550e;
            int i3 = this.f9551f;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f9550e = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f9550e = i4;
                    s0();
                    i2 = this.f9550e;
                    i3 = this.f9551f;
                } else {
                    if (c3 == '\n') {
                        this.f9552g++;
                        this.f9553h = i4;
                    }
                    i2 = i4;
                }
            }
            this.f9550e = i2;
        } while (j(1));
        throw L0("Unterminated string");
    }

    private boolean y0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f9550e + length > this.f9551f && !j(length)) {
                return false;
            }
            char[] cArr = this.f9549d;
            int i2 = this.f9550e;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f9549d[this.f9550e + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f9552g++;
            this.f9553h = i2 + 1;
            this.f9550e++;
        }
    }

    private void z0() throws IOException {
        char c2;
        do {
            if (this.f9550e >= this.f9551f && !j(1)) {
                return;
            }
            char[] cArr = this.f9549d;
            int i2 = this.f9550e;
            int i3 = i2 + 1;
            this.f9550e = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f9552g++;
                this.f9553h = i3;
                return;
            }
        } while (c2 != '\r');
    }

    public boolean A() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 5) {
            this.f9554j = 0;
            int[] iArr = this.t;
            int i3 = this.p - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f9554j = 0;
            int[] iArr2 = this.t;
            int i4 = this.p - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + k0() + z());
        }
    }

    public double G() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f9554j = 0;
            int[] iArr = this.t;
            int i3 = this.p - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f9555k;
        }
        if (i2 == 16) {
            this.m = new String(this.f9549d, this.f9550e, this.f9556l);
            this.f9550e += this.f9556l;
        } else if (i2 == 8 || i2 == 9) {
            this.m = d0(i2 == 8 ? '\'' : TokenParser.DQUOTE);
        } else if (i2 == 10) {
            this.m = g0();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + k0() + z());
        }
        this.f9554j = 11;
        double parseDouble = Double.parseDouble(this.m);
        if (!this.f9548c && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + z());
        }
        this.m = null;
        this.f9554j = 0;
        int[] iArr2 = this.t;
        int i4 = this.p - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    public void J0() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f9554j;
            if (i3 == 0) {
                i3 = e();
            }
            if (i3 == 3) {
                r0(1);
            } else if (i3 == 1) {
                r0(3);
            } else {
                if (i3 == 4) {
                    this.p--;
                } else if (i3 == 2) {
                    this.p--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        I0();
                    } else if (i3 == 8 || i3 == 12) {
                        x0('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        x0(TokenParser.DQUOTE);
                    } else if (i3 == 16) {
                        this.f9550e += this.f9556l;
                    }
                    this.f9554j = 0;
                }
                i2--;
                this.f9554j = 0;
            }
            i2++;
            this.f9554j = 0;
        } while (i2 != 0);
        int[] iArr = this.t;
        int i4 = this.p;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.q[i4 - 1] = "null";
    }

    public int K() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            long j2 = this.f9555k;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f9554j = 0;
                int[] iArr = this.t;
                int i4 = this.p - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f9555k + z());
        }
        if (i2 == 16) {
            this.m = new String(this.f9549d, this.f9550e, this.f9556l);
            this.f9550e += this.f9556l;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected an int but was " + k0() + z());
        } else {
            if (i2 == 10) {
                this.m = g0();
            } else {
                this.m = d0(i2 == 8 ? '\'' : TokenParser.DQUOTE);
            }
            try {
                int parseInt = Integer.parseInt(this.m);
                this.f9554j = 0;
                int[] iArr2 = this.t;
                int i5 = this.p - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9554j = 11;
        double parseDouble = Double.parseDouble(this.m);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.m = null;
            this.f9554j = 0;
            int[] iArr3 = this.t;
            int i7 = this.p - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.m + z());
    }

    public long N() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 15) {
            this.f9554j = 0;
            int[] iArr = this.t;
            int i3 = this.p - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f9555k;
        }
        if (i2 == 16) {
            this.m = new String(this.f9549d, this.f9550e, this.f9556l);
            this.f9550e += this.f9556l;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected a long but was " + k0() + z());
        } else {
            if (i2 == 10) {
                this.m = g0();
            } else {
                this.m = d0(i2 == 8 ? '\'' : TokenParser.DQUOTE);
            }
            try {
                long parseLong = Long.parseLong(this.m);
                this.f9554j = 0;
                int[] iArr2 = this.t;
                int i4 = this.p - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f9554j = 11;
        double parseDouble = Double.parseDouble(this.m);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.m = null;
            this.f9554j = 0;
            int[] iArr3 = this.t;
            int i5 = this.p - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.m + z());
    }

    public String O() throws IOException {
        String d0;
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 14) {
            d0 = g0();
        } else if (i2 == 12) {
            d0 = d0('\'');
        } else if (i2 == 13) {
            d0 = d0(TokenParser.DQUOTE);
        } else {
            throw new IllegalStateException("Expected a name but was " + k0() + z());
        }
        this.f9554j = 0;
        this.q[this.p - 1] = d0;
        return d0;
    }

    public void a() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 3) {
            r0(1);
            this.t[this.p - 1] = 0;
            this.f9554j = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + k0() + z());
    }

    public void a0() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 7) {
            this.f9554j = 0;
            int[] iArr = this.t;
            int i3 = this.p - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + k0() + z());
    }

    public void b() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 1) {
            r0(3);
            this.f9554j = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + k0() + z());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9554j = 0;
        this.n[0] = 8;
        this.p = 1;
        this.f9547b.close();
    }

    int e() throws IOException {
        int V;
        int[] iArr = this.n;
        int i2 = this.p;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int V2 = V(true);
            if (V2 != 44) {
                if (V2 != 59) {
                    if (V2 == 93) {
                        this.f9554j = 4;
                        return 4;
                    }
                    throw L0("Unterminated array");
                }
                c();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (V = V(true)) != 44) {
                if (V != 59) {
                    if (V == 125) {
                        this.f9554j = 2;
                        return 2;
                    }
                    throw L0("Unterminated object");
                }
                c();
            }
            int V3 = V(true);
            if (V3 == 34) {
                this.f9554j = 13;
                return 13;
            } else if (V3 == 39) {
                c();
                this.f9554j = 12;
                return 12;
            } else if (V3 == 125) {
                if (i3 != 5) {
                    this.f9554j = 2;
                    return 2;
                }
                throw L0("Expected name");
            } else {
                c();
                this.f9550e--;
                if (v((char) V3)) {
                    this.f9554j = 14;
                    return 14;
                }
                throw L0("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int V4 = V(true);
            if (V4 != 58) {
                if (V4 == 61) {
                    c();
                    if (this.f9550e < this.f9551f || j(1)) {
                        char[] cArr = this.f9549d;
                        int i4 = this.f9550e;
                        if (cArr[i4] == '>') {
                            this.f9550e = i4 + 1;
                        }
                    }
                } else {
                    throw L0("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.f9548c) {
                d();
            }
            this.n[this.p - 1] = 7;
        } else if (i3 == 7) {
            if (V(false) == -1) {
                this.f9554j = 17;
                return 17;
            }
            c();
            this.f9550e--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int V5 = V(true);
        if (V5 == 34) {
            this.f9554j = 9;
            return 9;
        } else if (V5 == 39) {
            c();
            this.f9554j = 8;
            return 8;
        } else {
            if (V5 != 44 && V5 != 59) {
                if (V5 == 91) {
                    this.f9554j = 3;
                    return 3;
                } else if (V5 != 93) {
                    if (V5 != 123) {
                        this.f9550e--;
                        int n0 = n0();
                        if (n0 != 0) {
                            return n0;
                        }
                        int o0 = o0();
                        if (o0 != 0) {
                            return o0;
                        }
                        if (v(this.f9549d[this.f9550e])) {
                            c();
                            this.f9554j = 10;
                            return 10;
                        }
                        throw L0("Expected value");
                    }
                    this.f9554j = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f9554j = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw L0("Unexpected value");
            }
            c();
            this.f9550e--;
            this.f9554j = 7;
            return 7;
        }
    }

    public String e0() throws IOException {
        String str;
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 10) {
            str = g0();
        } else if (i2 == 8) {
            str = d0('\'');
        } else if (i2 == 9) {
            str = d0(TokenParser.DQUOTE);
        } else if (i2 == 11) {
            str = this.m;
            this.m = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f9555k);
        } else if (i2 == 16) {
            str = new String(this.f9549d, this.f9550e, this.f9556l);
            this.f9550e += this.f9556l;
        } else {
            throw new IllegalStateException("Expected a string but was " + k0() + z());
        }
        this.f9554j = 0;
        int[] iArr = this.t;
        int i3 = this.p - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public void f() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 4) {
            int i3 = this.p - 1;
            this.p = i3;
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f9554j = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + k0() + z());
    }

    public void g() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        if (i2 == 2) {
            int i3 = this.p - 1;
            this.p = i3;
            this.q[i3] = null;
            int[] iArr = this.t;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f9554j = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + k0() + z());
    }

    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.p;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.n[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.t[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.q;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public b k0() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public boolean m() throws IOException {
        int i2 = this.f9554j;
        if (i2 == 0) {
            i2 = e();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean n() {
        return this.f9548c;
    }

    public String toString() {
        return getClass().getSimpleName() + z();
    }

    public final void w0(boolean z) {
        this.f9548c = z;
    }

    String z() {
        return " at line " + (this.f9552g + 1) + " column " + ((this.f9550e - this.f9553h) + 1) + " path " + getPath();
    }
}