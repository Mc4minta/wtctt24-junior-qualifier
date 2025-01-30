package com.google.common.base;

import java.util.Arrays;
import org.apache.http.message.TokenParser;

/* compiled from: CharMatcher.java */
/* loaded from: classes2.dex */
public abstract class c implements com.google.common.base.m<Character> {
    @Deprecated
    public static final c a = t();
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final c f8423b = e();
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final c f8424c = d();
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final c f8425d = f();
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final c f8426e = j();
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final c f8427f = l();
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    public static final c f8428g = m();
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final c f8429h = o();
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final c f8430j = n();
    @Deprecated

    /* renamed from: k  reason: collision with root package name */
    public static final c f8431k = k();
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final c f8432l = h();
    @Deprecated
    public static final c m = s();
    @Deprecated
    public static final c n = b();
    @Deprecated
    public static final c p = q();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class a extends n {
        static final a t = new a();

        private a() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.c
        public int g(CharSequence charSequence, int i2) {
            int length = charSequence.length();
            com.google.common.base.l.l(i2, length);
            if (i2 == length) {
                return -1;
            }
            return i2;
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class b extends n {
        static final b t = new b();

        b() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return c2 <= 127;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* renamed from: com.google.common.base.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0155c extends c {
        static final c q = new C0155c();

        private C0155c() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            if (c2 != ' ' && c2 != 133 && c2 != 5760) {
                if (c2 == 8199) {
                    return false;
                }
                if (c2 != 8287 && c2 != 12288 && c2 != 8232 && c2 != 8233) {
                    switch (c2) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                        default:
                            return c2 >= 8192 && c2 <= 8202;
                    }
                }
            }
            return true;
        }

        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class d extends p {
        static final d v = new d();

        private d() {
            super("CharMatcher.digit()", v(), u());
        }

        private static char[] u() {
            char[] cArr = new char[31];
            for (int i2 = 0; i2 < 31; i2++) {
                cArr[i2] = (char) ("0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".charAt(i2) + '\t');
            }
            return cArr;
        }

        private static char[] v() {
            return "0٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray();
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    static abstract class e extends c {
        e() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class f extends p {
        static final f v = new f();

        private f() {
            super("CharMatcher.invisible()", "\u0000\u007f\u00ad\u0600\u061c\u06dd\u070f\u1680\u180e\u2000\u2028\u205f\u2066\u2067\u2068\u2069\u206a\u3000\ud800\ufeff\ufff9\ufffa".toCharArray(), "  \u00ad\u0604\u061c\u06dd\u070f\u1680\u180e\u200f \u2064\u2066\u2067\u2068\u2069\u206f\u3000\uf8ff\ufeff\ufff9\ufffb".toCharArray());
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    private static final class g extends e {
        private final char q;

        g(char c2) {
            this.q = c2;
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return c2 == this.q;
        }

        public String toString() {
            return "CharMatcher.is('" + c.r(this.q) + "')";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class h extends c {
        static final h q = new h();

        private h() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return Character.isDigit(c2);
        }

        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class i extends n {
        static final i t = new i();

        private i() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return c2 <= 31 || (c2 >= 127 && c2 <= 159);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class j extends c {
        static final j q = new j();

        private j() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return Character.isLetter(c2);
        }

        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class k extends c {
        static final k q = new k();

        private k() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return Character.isLetterOrDigit(c2);
        }

        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class l extends c {
        static final l q = new l();

        private l() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return Character.isLowerCase(c2);
        }

        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class m extends c {
        static final m q = new m();

        private m() {
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return Character.isUpperCase(c2);
        }

        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    static abstract class n extends e {
        private final String q;

        n(String str) {
            this.q = (String) com.google.common.base.l.i(str);
        }

        public final String toString() {
            return this.q;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class o extends n {
        static final o t = new o();

        private o() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.c
        public int g(CharSequence charSequence, int i2) {
            com.google.common.base.l.l(i2, charSequence.length());
            return -1;
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return false;
        }
    }

    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    private static class p extends c {
        private final String q;
        private final char[] t;
        private final char[] u;

        p(String str, char[] cArr, char[] cArr2) {
            this.q = str;
            this.t = cArr;
            this.u = cArr2;
            com.google.common.base.l.d(cArr.length == cArr2.length);
            int i2 = 0;
            while (i2 < cArr.length) {
                com.google.common.base.l.d(cArr[i2] <= cArr2[i2]);
                int i3 = i2 + 1;
                if (i3 < cArr.length) {
                    com.google.common.base.l.d(cArr2[i2] < cArr[i3]);
                }
                i2 = i3;
            }
        }

        @Override // com.google.common.base.m
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return super.c(ch);
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            int binarySearch = Arrays.binarySearch(this.t, c2);
            if (binarySearch >= 0) {
                return true;
            }
            int i2 = (~binarySearch) - 1;
            return i2 >= 0 && c2 <= this.u[i2];
        }

        public String toString() {
            return this.q;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class q extends p {
        static final q v = new q();

        private q() {
            super("CharMatcher.singleWidth()", "\u0000־א׳\u0600ݐ\u0e00Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ\u0e7f₯℺﷿\ufeffￜ".toCharArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CharMatcher.java */
    /* loaded from: classes2.dex */
    public static final class r extends n {
        static final int t = Integer.numberOfLeadingZeros(31);
        static final r u = new r();

        r() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.c
        public boolean p(char c2) {
            return "\u2002\u3000\r\u0085\u200a\u2005\u2000\u3000\u2029\u000b\u3000\u2008\u2003\u205f\u3000\u1680\t \u2006\u2001  \f\u2009\u3000\u2004\u3000\u3000\u2028\n \u3000".charAt((48906 * c2) >>> t) == c2;
        }
    }

    protected c() {
    }

    public static c b() {
        return a.t;
    }

    public static c d() {
        return b.t;
    }

    public static c e() {
        return C0155c.q;
    }

    public static c f() {
        return d.v;
    }

    public static c h() {
        return f.v;
    }

    public static c i(char c2) {
        return new g(c2);
    }

    public static c j() {
        return h.q;
    }

    public static c k() {
        return i.t;
    }

    public static c l() {
        return j.q;
    }

    public static c m() {
        return k.q;
    }

    public static c n() {
        return l.q;
    }

    public static c o() {
        return m.q;
    }

    public static c q() {
        return o.t;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String r(char c2) {
        char[] cArr = {TokenParser.ESCAPE, 'u', 0, 0, 0, 0};
        for (int i2 = 0; i2 < 4; i2++) {
            cArr[5 - i2] = "0123456789ABCDEF".charAt(c2 & 15);
            c2 = (char) (c2 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static c s() {
        return q.v;
    }

    public static c t() {
        return r.u;
    }

    @Deprecated
    public boolean c(Character ch) {
        return p(ch.charValue());
    }

    public int g(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        com.google.common.base.l.l(i2, length);
        while (i2 < length) {
            if (p(charSequence.charAt(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public abstract boolean p(char c2);
}