package kotlin.l0;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
public final class k implements Serializable {
    public static final a a = new a(null);

    /* renamed from: b */
    private final Pattern f17368b;

    /* compiled from: Regex.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final int b(int i2) {
            return (i2 & 2) != 0 ? i2 | 64 : i2;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public k(Pattern nativePattern) {
        kotlin.jvm.internal.m.g(nativePattern, "nativePattern");
        this.f17368b = nativePattern;
    }

    public static /* synthetic */ i b(k kVar, CharSequence charSequence, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return kVar.a(charSequence, i2);
    }

    public final i a(CharSequence input, int i2) {
        i f2;
        kotlin.jvm.internal.m.g(input, "input");
        Matcher matcher = this.f17368b.matcher(input);
        kotlin.jvm.internal.m.f(matcher, "nativePattern.matcher(input)");
        f2 = l.f(matcher, i2, input);
        return f2;
    }

    public final i c(CharSequence input) {
        i g2;
        kotlin.jvm.internal.m.g(input, "input");
        Matcher matcher = this.f17368b.matcher(input);
        kotlin.jvm.internal.m.f(matcher, "nativePattern.matcher(input)");
        g2 = l.g(matcher, input);
        return g2;
    }

    public final boolean d(CharSequence input) {
        kotlin.jvm.internal.m.g(input, "input");
        return this.f17368b.matcher(input).matches();
    }

    public final String e(CharSequence input, String replacement) {
        kotlin.jvm.internal.m.g(input, "input");
        kotlin.jvm.internal.m.g(replacement, "replacement");
        String replaceAll = this.f17368b.matcher(input).replaceAll(replacement);
        kotlin.jvm.internal.m.f(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f17368b.toString();
        kotlin.jvm.internal.m.f(pattern, "nativePattern.toString()");
        return pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.g(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.m.f(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l0.k.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(java.lang.String r2, kotlin.l0.m r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "option"
            kotlin.jvm.internal.m.g(r3, r0)
            kotlin.l0.k$a r0 = kotlin.l0.k.a
            int r3 = r3.getValue()
            int r3 = kotlin.l0.k.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…nicodeCase(option.value))"
            kotlin.jvm.internal.m.f(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l0.k.<init>(java.lang.String, kotlin.l0.m):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public k(java.lang.String r2, java.util.Set<? extends kotlin.l0.m> r3) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.m.g(r2, r0)
            java.lang.String r0 = "options"
            kotlin.jvm.internal.m.g(r3, r0)
            kotlin.l0.k$a r0 = kotlin.l0.k.a
            int r3 = kotlin.l0.l.e(r3)
            int r3 = kotlin.l0.k.a.a(r0, r3)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2, r3)
            java.lang.String r3 = "Pattern.compile(pattern,…odeCase(options.toInt()))"
            kotlin.jvm.internal.m.f(r2, r3)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.l0.k.<init>(java.lang.String, java.util.Set):void");
    }
}