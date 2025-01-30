package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import org.apache.http.message.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GeneralAppIdDecoder.java */
/* loaded from: classes2.dex */
public final class s {
    private final com.google.zxing.q.a a;

    /* renamed from: b  reason: collision with root package name */
    private final m f10068b = new m();

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f10069c = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(com.google.zxing.q.a aVar) {
        this.a = aVar;
    }

    private n b(int i2) {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new n(i2 + 5, '$');
        }
        if (f2 >= 5 && f2 < 15) {
            return new n(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 6);
        if (f3 >= 32 && f3 < 58) {
            return new n(i2 + 6, (char) (f3 + 33));
        }
        switch (f3) {
            case 58:
                c2 = '*';
                break;
            case 59:
                c2 = ',';
                break;
            case 60:
                c2 = '-';
                break;
            case 61:
                c2 = '.';
                break;
            case 62:
                c2 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + f3);
        }
        return new n(i2 + 6, c2);
    }

    private n d(int i2) throws FormatException {
        char c2;
        int f2 = f(i2, 5);
        if (f2 == 15) {
            return new n(i2 + 5, '$');
        }
        if (f2 >= 5 && f2 < 15) {
            return new n(i2 + 5, (char) ((f2 + 48) - 5));
        }
        int f3 = f(i2, 7);
        if (f3 < 64 || f3 >= 90) {
            if (f3 >= 90 && f3 < 116) {
                return new n(i2 + 7, (char) (f3 + 7));
            }
            switch (f(i2, 8)) {
                case 232:
                    c2 = '!';
                    break;
                case 233:
                    c2 = TokenParser.DQUOTE;
                    break;
                case 234:
                    c2 = '%';
                    break;
                case 235:
                    c2 = '&';
                    break;
                case 236:
                    c2 = '\'';
                    break;
                case 237:
                    c2 = '(';
                    break;
                case 238:
                    c2 = ')';
                    break;
                case 239:
                    c2 = '*';
                    break;
                case 240:
                    c2 = '+';
                    break;
                case 241:
                    c2 = ',';
                    break;
                case 242:
                    c2 = '-';
                    break;
                case 243:
                    c2 = '.';
                    break;
                case 244:
                    c2 = '/';
                    break;
                case 245:
                    c2 = ':';
                    break;
                case 246:
                    c2 = ';';
                    break;
                case 247:
                    c2 = '<';
                    break;
                case 248:
                    c2 = '=';
                    break;
                case 249:
                    c2 = '>';
                    break;
                case 250:
                    c2 = '?';
                    break;
                case 251:
                    c2 = '_';
                    break;
                case 252:
                    c2 = TokenParser.SP;
                    break;
                default:
                    throw FormatException.a();
            }
            return new n(i2 + 8, c2);
        }
        return new n(i2 + 7, (char) (f3 + 1));
    }

    private p e(int i2) throws FormatException {
        int i3 = i2 + 7;
        if (i3 > this.a.o()) {
            int f2 = f(i2, 4);
            if (f2 == 0) {
                return new p(this.a.o(), 10, 10);
            }
            return new p(this.a.o(), f2 - 1, 10);
        }
        int f3 = f(i2, 7) - 8;
        return new p(i3, f3 / 11, f3 % 11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(com.google.zxing.q.a aVar, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (aVar.i(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }

    private boolean h(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.a.o()) {
            return false;
        }
        while (i2 < i3) {
            if (this.a.i(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean i(int i2) {
        int i3;
        if (i2 + 1 > this.a.o()) {
            return false;
        }
        for (int i4 = 0; i4 < 5 && (i3 = i4 + i2) < this.a.o(); i4++) {
            if (i4 == 2) {
                if (!this.a.i(i2 + 2)) {
                    return false;
                }
            } else if (this.a.i(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean j(int i2) {
        int i3;
        if (i2 + 1 > this.a.o()) {
            return false;
        }
        for (int i4 = 0; i4 < 4 && (i3 = i4 + i2) < this.a.o(); i4++) {
            if (this.a.i(i3)) {
                return false;
            }
        }
        return true;
    }

    private boolean k(int i2) {
        int f2;
        if (i2 + 5 > this.a.o()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 < 5 || f3 >= 16) {
            return i2 + 6 <= this.a.o() && (f2 = f(i2, 6)) >= 16 && f2 < 63;
        }
        return true;
    }

    private boolean l(int i2) {
        int f2;
        if (i2 + 5 > this.a.o()) {
            return false;
        }
        int f3 = f(i2, 5);
        if (f3 < 5 || f3 >= 16) {
            if (i2 + 7 > this.a.o()) {
                return false;
            }
            int f4 = f(i2, 7);
            if (f4 < 64 || f4 >= 116) {
                return i2 + 8 <= this.a.o() && (f2 = f(i2, 8)) >= 232 && f2 < 253;
            }
            return true;
        }
        return true;
    }

    private boolean m(int i2) {
        if (i2 + 7 > this.a.o()) {
            return i2 + 4 <= this.a.o();
        }
        int i3 = i2;
        while (true) {
            int i4 = i2 + 3;
            if (i3 < i4) {
                if (this.a.i(i3)) {
                    return true;
                }
                i3++;
            } else {
                return this.a.i(i4);
            }
        }
    }

    private l n() {
        while (k(this.f10068b.a())) {
            n b2 = b(this.f10068b.a());
            this.f10068b.h(b2.a());
            if (b2.c()) {
                return new l(new o(this.f10068b.a(), this.f10069c.toString()), true);
            }
            this.f10069c.append(b2.b());
        }
        if (h(this.f10068b.a())) {
            this.f10068b.b(3);
            this.f10068b.g();
        } else if (i(this.f10068b.a())) {
            if (this.f10068b.a() + 5 < this.a.o()) {
                this.f10068b.b(5);
            } else {
                this.f10068b.h(this.a.o());
            }
            this.f10068b.f();
        }
        return new l(false);
    }

    private o o() throws FormatException {
        l q;
        boolean b2;
        do {
            int a = this.f10068b.a();
            if (this.f10068b.c()) {
                q = n();
                b2 = q.b();
            } else if (this.f10068b.d()) {
                q = p();
                b2 = q.b();
            } else {
                q = q();
                b2 = q.b();
            }
            if (!(a != this.f10068b.a()) && !b2) {
                break;
            }
        } while (!b2);
        return q.a();
    }

    private l p() throws FormatException {
        while (l(this.f10068b.a())) {
            n d2 = d(this.f10068b.a());
            this.f10068b.h(d2.a());
            if (d2.c()) {
                return new l(new o(this.f10068b.a(), this.f10069c.toString()), true);
            }
            this.f10069c.append(d2.b());
        }
        if (h(this.f10068b.a())) {
            this.f10068b.b(3);
            this.f10068b.g();
        } else if (i(this.f10068b.a())) {
            if (this.f10068b.a() + 5 < this.a.o()) {
                this.f10068b.b(5);
            } else {
                this.f10068b.h(this.a.o());
            }
            this.f10068b.e();
        }
        return new l(false);
    }

    private l q() throws FormatException {
        o oVar;
        while (m(this.f10068b.a())) {
            p e2 = e(this.f10068b.a());
            this.f10068b.h(e2.a());
            if (e2.d()) {
                if (e2.e()) {
                    oVar = new o(this.f10068b.a(), this.f10069c.toString());
                } else {
                    oVar = new o(this.f10068b.a(), this.f10069c.toString(), e2.c());
                }
                return new l(oVar, true);
            }
            this.f10069c.append(e2.b());
            if (e2.e()) {
                return new l(new o(this.f10068b.a(), this.f10069c.toString()), true);
            }
            this.f10069c.append(e2.c());
        }
        if (j(this.f10068b.a())) {
            this.f10068b.e();
            this.f10068b.b(4);
        }
        return new l(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            o c2 = c(i2, str);
            String a = r.a(c2.b());
            if (a != null) {
                sb.append(a);
            }
            String valueOf = c2.d() ? String.valueOf(c2.c()) : null;
            if (i2 != c2.a()) {
                i2 = c2.a();
                str = valueOf;
            } else {
                return sb.toString();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o c(int i2, String str) throws FormatException {
        this.f10069c.setLength(0);
        if (str != null) {
            this.f10069c.append(str);
        }
        this.f10068b.h(i2);
        o o = o();
        if (o != null && o.d()) {
            return new o(this.f10068b.a(), this.f10069c.toString(), o.c());
        }
        return new o(this.f10068b.a(), this.f10069c.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f(int i2, int i3) {
        return g(this.a, i2, i3);
    }
}