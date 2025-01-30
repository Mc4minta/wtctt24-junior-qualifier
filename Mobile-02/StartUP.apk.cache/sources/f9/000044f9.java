package e.a.a.y.k0;

import e.a.a.y.k0.c;
import j.f;
import j.h;
import j.i;
import java.io.EOFException;
import java.io.IOException;
import java.util.Objects;
import org.apache.http.message.BasicHeaderValueFormatter;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JsonUtf8Reader.java */
/* loaded from: classes.dex */
public final class e extends c {

    /* renamed from: h  reason: collision with root package name */
    private static final i f11941h = i.z("'\\");

    /* renamed from: j  reason: collision with root package name */
    private static final i f11942j = i.z(BasicHeaderValueFormatter.UNSAFE_CHARS);

    /* renamed from: k  reason: collision with root package name */
    private static final i f11943k = i.z("{}[]:, \n\t\r\f/\\;#=");

    /* renamed from: l  reason: collision with root package name */
    private static final i f11944l = i.z("\n\r");
    private static final i m = i.z("*/");
    private final h n;
    private final f p;
    private int q = 0;
    private long t;
    private int u;
    private String v;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(h hVar) {
        Objects.requireNonNull(hVar, "source == null");
        this.n = hVar;
        this.p = hVar.i();
        G(6);
    }

    private void I0() throws IOException {
        long W = this.n.W(f11944l);
        f fVar = this.p;
        fVar.skip(W != -1 ? W + 1 : fVar.O0());
    }

    private void J0() throws IOException {
        long W = this.n.W(f11943k);
        f fVar = this.p;
        if (W == -1) {
            W = fVar.O0();
        }
        fVar.skip(W);
    }

    private void d0() throws IOException {
        if (!this.f11928f) {
            throw a0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private int e0() throws IOException {
        int[] iArr = this.f11925c;
        int i2 = this.f11924b;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int n0 = n0(true);
            this.p.m0();
            if (n0 != 44) {
                if (n0 != 59) {
                    if (n0 == 93) {
                        this.q = 4;
                        return 4;
                    }
                    throw a0("Unterminated array");
                }
                d0();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5) {
                int n02 = n0(true);
                this.p.m0();
                if (n02 != 44) {
                    if (n02 != 59) {
                        if (n02 == 125) {
                            this.q = 2;
                            return 2;
                        }
                        throw a0("Unterminated object");
                    }
                    d0();
                }
            }
            int n03 = n0(true);
            if (n03 == 34) {
                this.p.m0();
                this.q = 13;
                return 13;
            } else if (n03 == 39) {
                this.p.m0();
                d0();
                this.q = 12;
                return 12;
            } else if (n03 != 125) {
                d0();
                if (k0((char) n03)) {
                    this.q = 14;
                    return 14;
                }
                throw a0("Expected name");
            } else if (i3 != 5) {
                this.p.m0();
                this.q = 2;
                return 2;
            } else {
                throw a0("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int n04 = n0(true);
            this.p.m0();
            if (n04 != 58) {
                if (n04 == 61) {
                    d0();
                    if (this.n.request(1L) && this.p.A(0L) == 62) {
                        this.p.m0();
                    }
                } else {
                    throw a0("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            iArr[i2 - 1] = 7;
        } else if (i3 == 7) {
            if (n0(false) == -1) {
                this.q = 18;
                return 18;
            }
            d0();
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int n05 = n0(true);
        if (n05 == 34) {
            this.p.m0();
            this.q = 9;
            return 9;
        } else if (n05 == 39) {
            d0();
            this.p.m0();
            this.q = 8;
            return 8;
        } else {
            if (n05 != 44 && n05 != 59) {
                if (n05 == 91) {
                    this.p.m0();
                    this.q = 3;
                    return 3;
                } else if (n05 != 93) {
                    if (n05 != 123) {
                        int s0 = s0();
                        if (s0 != 0) {
                            return s0;
                        }
                        int w0 = w0();
                        if (w0 != 0) {
                            return w0;
                        }
                        if (k0(this.p.A(0L))) {
                            d0();
                            this.q = 10;
                            return 10;
                        }
                        throw a0("Expected value");
                    }
                    this.p.m0();
                    this.q = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.p.m0();
                    this.q = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw a0("Unexpected value");
            }
            d0();
            this.q = 7;
            return 7;
        }
    }

    private int g0(String str, c.a aVar) {
        int length = aVar.a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(aVar.a[i2])) {
                this.q = 0;
                this.f11926d[this.f11924b - 1] = str;
                return i2;
            }
        }
        return -1;
    }

    private boolean k0(int i2) throws IOException {
        if (i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 32) {
            return false;
        }
        if (i2 != 35) {
            if (i2 == 44) {
                return false;
            }
            if (i2 != 47 && i2 != 61) {
                if (i2 == 123 || i2 == 125 || i2 == 58) {
                    return false;
                }
                if (i2 != 59) {
                    switch (i2) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        d0();
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0025, code lost:
        r6.p.skip(r3 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        if (r1 != 47) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
        if (r6.n.request(2) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003b, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
        d0();
        r3 = r6.p.A(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0049, code lost:
        if (r3 == 42) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004b, code lost:
        if (r3 == 47) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004d, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004e, code lost:
        r6.p.m0();
        r6.p.m0();
        I0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        r6.p.m0();
        r6.p.m0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (z0() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        throw a0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        if (r1 != 35) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0078, code lost:
        d0();
        I0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int n0(boolean r7) throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
        L1:
            r1 = r0
        L2:
            j.h r2 = r6.n
            int r3 = r1 + 1
            long r4 = (long) r3
            boolean r2 = r2.request(r4)
            if (r2 == 0) goto L82
            j.f r2 = r6.p
            long r4 = (long) r1
            byte r1 = r2.A(r4)
            r2 = 10
            if (r1 == r2) goto L80
            r2 = 32
            if (r1 == r2) goto L80
            r2 = 13
            if (r1 == r2) goto L80
            r2 = 9
            if (r1 != r2) goto L25
            goto L80
        L25:
            j.f r2 = r6.p
            int r3 = r3 + (-1)
            long r3 = (long) r3
            r2.skip(r3)
            r2 = 47
            if (r1 != r2) goto L74
            j.h r3 = r6.n
            r4 = 2
            boolean r3 = r3.request(r4)
            if (r3 != 0) goto L3c
            return r1
        L3c:
            r6.d0()
            j.f r3 = r6.p
            r4 = 1
            byte r3 = r3.A(r4)
            r4 = 42
            if (r3 == r4) goto L5c
            if (r3 == r2) goto L4e
            return r1
        L4e:
            j.f r1 = r6.p
            r1.m0()
            j.f r1 = r6.p
            r1.m0()
            r6.I0()
            goto L1
        L5c:
            j.f r1 = r6.p
            r1.m0()
            j.f r1 = r6.p
            r1.m0()
            boolean r1 = r6.z0()
            if (r1 == 0) goto L6d
            goto L1
        L6d:
            java.lang.String r7 = "Unterminated comment"
            e.a.a.y.k0.b r7 = r6.a0(r7)
            throw r7
        L74:
            r2 = 35
            if (r1 != r2) goto L7f
            r6.d0()
            r6.I0()
            goto L1
        L7f:
            return r1
        L80:
            r1 = r3
            goto L2
        L82:
            if (r7 != 0) goto L86
            r7 = -1
            return r7
        L86:
            java.io.EOFException r7 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.y.k0.e.n0(boolean):int");
    }

    private String o0(i iVar) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long W = this.n.W(iVar);
            if (W != -1) {
                if (this.p.A(W) != 92) {
                    if (sb == null) {
                        String p = this.p.p(W);
                        this.p.m0();
                        return p;
                    }
                    sb.append(this.p.p(W));
                    this.p.m0();
                    return sb.toString();
                }
                if (sb == null) {
                    sb = new StringBuilder();
                }
                sb.append(this.p.p(W));
                this.p.m0();
                sb.append(x0());
            } else {
                throw a0("Unterminated string");
            }
        }
    }

    private String r0() throws IOException {
        long W = this.n.W(f11943k);
        return W != -1 ? this.p.p(W) : this.p.G0();
    }

    private int s0() throws IOException {
        int i2;
        String str;
        String str2;
        byte A = this.p.A(0L);
        if (A == 116 || A == 84) {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (A == 102 || A == 70) {
            i2 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (A != 110 && A != 78) {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i3 = 1;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (!this.n.request(i4)) {
                return 0;
            }
            byte A2 = this.p.A(i3);
            if (A2 != str.charAt(i3) && A2 != str2.charAt(i3)) {
                return 0;
            }
            i3 = i4;
        }
        if (this.n.request(length + 1) && k0(this.p.A(length))) {
            return 0;
        }
        this.p.skip(length);
        this.q = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (k0(r11) != false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0084, code lost:
        if (r6 != 2) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0086, code lost:
        if (r7 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x008c, code lost:
        if (r8 != Long.MIN_VALUE) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
        if (r10 == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0092, code lost:
        if (r8 != 0) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0094, code lost:
        if (r10 != false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0096, code lost:
        if (r10 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0099, code lost:
        r8 = -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009a, code lost:
        r16.t = r8;
        r16.p.skip(r5);
        r16.q = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a6, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a7, code lost:
        if (r6 == 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00aa, code lost:
        if (r6 == 4) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ad, code lost:
        if (r6 != 7) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b0, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00b2, code lost:
        r16.u = r5;
        r16.q = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00b8, code lost:
        return 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00b9, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int w0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.a.a.y.k0.e.w0():int");
    }

    private char x0() throws IOException {
        int i2;
        int i3;
        if (this.n.request(1L)) {
            byte m0 = this.p.m0();
            if (m0 == 10 || m0 == 34 || m0 == 39 || m0 == 47 || m0 == 92) {
                return (char) m0;
            }
            if (m0 != 98) {
                if (m0 != 102) {
                    if (m0 != 110) {
                        if (m0 != 114) {
                            if (m0 != 116) {
                                if (m0 != 117) {
                                    if (this.f11928f) {
                                        return (char) m0;
                                    }
                                    throw a0("Invalid escape sequence: \\" + ((char) m0));
                                } else if (this.n.request(4L)) {
                                    char c2 = 0;
                                    for (int i4 = 0; i4 < 4; i4++) {
                                        byte A = this.p.A(i4);
                                        char c3 = (char) (c2 << 4);
                                        if (A < 48 || A > 57) {
                                            if (A >= 97 && A <= 102) {
                                                i2 = A - 97;
                                            } else if (A < 65 || A > 70) {
                                                throw a0("\\u" + this.p.p(4L));
                                            } else {
                                                i2 = A - 65;
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = A - 48;
                                        }
                                        c2 = (char) (c3 + i3);
                                    }
                                    this.p.skip(4L);
                                    return c2;
                                } else {
                                    throw new EOFException("Unterminated escape sequence at path " + getPath());
                                }
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
        throw a0("Unterminated escape sequence");
    }

    private void y0(i iVar) throws IOException {
        while (true) {
            long W = this.n.W(iVar);
            if (W != -1) {
                if (this.p.A(W) == 92) {
                    this.p.skip(W + 1);
                    x0();
                } else {
                    this.p.skip(W + 1);
                    return;
                }
            } else {
                throw a0("Unterminated string");
            }
        }
    }

    private boolean z0() throws IOException {
        h hVar = this.n;
        i iVar = m;
        long M = hVar.M(iVar);
        boolean z = M != -1;
        f fVar = this.p;
        fVar.skip(z ? M + iVar.Q() : fVar.O0());
        return z;
    }

    @Override // e.a.a.y.k0.c
    public c.b A() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        switch (i2) {
            case 1:
                return c.b.BEGIN_OBJECT;
            case 2:
                return c.b.END_OBJECT;
            case 3:
                return c.b.BEGIN_ARRAY;
            case 4:
                return c.b.END_ARRAY;
            case 5:
            case 6:
                return c.b.BOOLEAN;
            case 7:
                return c.b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return c.b.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return c.b.NAME;
            case 16:
            case 17:
                return c.b.NUMBER;
            case 18:
                return c.b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    @Override // e.a.a.y.k0.c
    public int K(c.a aVar) throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 < 12 || i2 > 15) {
            return -1;
        }
        if (i2 == 15) {
            return g0(this.v, aVar);
        }
        int h1 = this.n.h1(aVar.f11930b);
        if (h1 != -1) {
            this.q = 0;
            this.f11926d[this.f11924b - 1] = aVar.a[h1];
            return h1;
        }
        String str = this.f11926d[this.f11924b - 1];
        String n = n();
        int g0 = g0(n, aVar);
        if (g0 == -1) {
            this.q = 15;
            this.v = n;
            this.f11926d[this.f11924b - 1] = str;
        }
        return g0;
    }

    @Override // e.a.a.y.k0.c
    public void N() throws IOException {
        if (!this.f11929g) {
            int i2 = this.q;
            if (i2 == 0) {
                i2 = e0();
            }
            if (i2 == 14) {
                J0();
            } else if (i2 == 13) {
                y0(f11942j);
            } else if (i2 == 12) {
                y0(f11941h);
            } else if (i2 != 15) {
                throw new a("Expected a name but was " + A() + " at path " + getPath());
            }
            this.q = 0;
            this.f11926d[this.f11924b - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + A() + " at " + getPath());
    }

    @Override // e.a.a.y.k0.c
    public void O() throws IOException {
        if (!this.f11929g) {
            int i2 = 0;
            do {
                int i3 = this.q;
                if (i3 == 0) {
                    i3 = e0();
                }
                if (i3 == 3) {
                    G(1);
                } else if (i3 == 1) {
                    G(3);
                } else {
                    if (i3 == 4) {
                        i2--;
                        if (i2 >= 0) {
                            this.f11924b--;
                        } else {
                            throw new a("Expected a value but was " + A() + " at path " + getPath());
                        }
                    } else if (i3 == 2) {
                        i2--;
                        if (i2 >= 0) {
                            this.f11924b--;
                        } else {
                            throw new a("Expected a value but was " + A() + " at path " + getPath());
                        }
                    } else if (i3 == 14 || i3 == 10) {
                        J0();
                    } else if (i3 == 9 || i3 == 13) {
                        y0(f11942j);
                    } else if (i3 == 8 || i3 == 12) {
                        y0(f11941h);
                    } else if (i3 == 17) {
                        this.p.skip(this.u);
                    } else if (i3 == 18) {
                        throw new a("Expected a value but was " + A() + " at path " + getPath());
                    }
                    this.q = 0;
                }
                i2++;
                this.q = 0;
            } while (i2 != 0);
            int[] iArr = this.f11927e;
            int i4 = this.f11924b;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
            this.f11926d[i4 - 1] = "null";
            return;
        }
        throw new a("Cannot skip unexpected " + A() + " at " + getPath());
    }

    @Override // e.a.a.y.k0.c
    public void b() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 3) {
            G(1);
            this.f11927e[this.f11924b - 1] = 0;
            this.q = 0;
            return;
        }
        throw new a("Expected BEGIN_ARRAY but was " + A() + " at path " + getPath());
    }

    @Override // e.a.a.y.k0.c
    public void c() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 1) {
            G(3);
            this.q = 0;
            return;
        }
        throw new a("Expected BEGIN_OBJECT but was " + A() + " at path " + getPath());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.q = 0;
        this.f11925c[0] = 8;
        this.f11924b = 1;
        this.p.b();
        this.n.close();
    }

    @Override // e.a.a.y.k0.c
    public void d() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 4) {
            int i3 = this.f11924b - 1;
            this.f11924b = i3;
            int[] iArr = this.f11927e;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.q = 0;
            return;
        }
        throw new a("Expected END_ARRAY but was " + A() + " at path " + getPath());
    }

    @Override // e.a.a.y.k0.c
    public void e() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 2) {
            int i3 = this.f11924b - 1;
            this.f11924b = i3;
            this.f11926d[i3] = null;
            int[] iArr = this.f11927e;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.q = 0;
            return;
        }
        throw new a("Expected END_OBJECT but was " + A() + " at path " + getPath());
    }

    @Override // e.a.a.y.k0.c
    public boolean f() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        return (i2 == 2 || i2 == 4 || i2 == 18) ? false : true;
    }

    @Override // e.a.a.y.k0.c
    public boolean g() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 5) {
            this.q = 0;
            int[] iArr = this.f11927e;
            int i3 = this.f11924b - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.q = 0;
            int[] iArr2 = this.f11927e;
            int i4 = this.f11924b - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new a("Expected a boolean but was " + A() + " at path " + getPath());
        }
    }

    @Override // e.a.a.y.k0.c
    public double j() throws IOException {
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 16) {
            this.q = 0;
            int[] iArr = this.f11927e;
            int i3 = this.f11924b - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.t;
        }
        if (i2 == 17) {
            this.v = this.p.p(this.u);
        } else if (i2 == 9) {
            this.v = o0(f11942j);
        } else if (i2 == 8) {
            this.v = o0(f11941h);
        } else if (i2 == 10) {
            this.v = r0();
        } else if (i2 != 11) {
            throw new a("Expected a double but was " + A() + " at path " + getPath());
        }
        this.q = 11;
        try {
            double parseDouble = Double.parseDouble(this.v);
            if (!this.f11928f && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                throw new b("JSON forbids NaN and infinities: " + parseDouble + " at path " + getPath());
            }
            this.v = null;
            this.q = 0;
            int[] iArr2 = this.f11927e;
            int i4 = this.f11924b - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            throw new a("Expected a double but was " + this.v + " at path " + getPath());
        }
    }

    @Override // e.a.a.y.k0.c
    public int m() throws IOException {
        String o0;
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 16) {
            long j2 = this.t;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.q = 0;
                int[] iArr = this.f11927e;
                int i4 = this.f11924b - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new a("Expected an int but was " + this.t + " at path " + getPath());
        }
        if (i2 == 17) {
            this.v = this.p.p(this.u);
        } else if (i2 == 9 || i2 == 8) {
            if (i2 == 9) {
                o0 = o0(f11942j);
            } else {
                o0 = o0(f11941h);
            }
            this.v = o0;
            try {
                int parseInt = Integer.parseInt(o0);
                this.q = 0;
                int[] iArr2 = this.f11927e;
                int i5 = this.f11924b - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i2 != 11) {
            throw new a("Expected an int but was " + A() + " at path " + getPath());
        }
        this.q = 11;
        try {
            double parseDouble = Double.parseDouble(this.v);
            int i6 = (int) parseDouble;
            if (i6 == parseDouble) {
                this.v = null;
                this.q = 0;
                int[] iArr3 = this.f11927e;
                int i7 = this.f11924b - 1;
                iArr3[i7] = iArr3[i7] + 1;
                return i6;
            }
            throw new a("Expected an int but was " + this.v + " at path " + getPath());
        } catch (NumberFormatException unused2) {
            throw new a("Expected an int but was " + this.v + " at path " + getPath());
        }
    }

    @Override // e.a.a.y.k0.c
    public String n() throws IOException {
        String str;
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 14) {
            str = r0();
        } else if (i2 == 13) {
            str = o0(f11942j);
        } else if (i2 == 12) {
            str = o0(f11941h);
        } else if (i2 == 15) {
            str = this.v;
        } else {
            throw new a("Expected a name but was " + A() + " at path " + getPath());
        }
        this.q = 0;
        this.f11926d[this.f11924b - 1] = str;
        return str;
    }

    public String toString() {
        return "JsonReader(" + this.n + ")";
    }

    @Override // e.a.a.y.k0.c
    public String v() throws IOException {
        String p;
        int i2 = this.q;
        if (i2 == 0) {
            i2 = e0();
        }
        if (i2 == 10) {
            p = r0();
        } else if (i2 == 9) {
            p = o0(f11942j);
        } else if (i2 == 8) {
            p = o0(f11941h);
        } else if (i2 == 11) {
            p = this.v;
            this.v = null;
        } else if (i2 == 16) {
            p = Long.toString(this.t);
        } else if (i2 == 17) {
            p = this.p.p(this.u);
        } else {
            throw new a("Expected a string but was " + A() + " at path " + getPath());
        }
        this.q = 0;
        int[] iArr = this.f11927e;
        int i3 = this.f11924b - 1;
        iArr[i3] = iArr[i3] + 1;
        return p;
    }
}