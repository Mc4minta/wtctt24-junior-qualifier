package kotlin.l0;

import java.nio.charset.Charset;
import org.apache.http.protocol.HTTP;

/* compiled from: Charsets.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final Charset a;

    /* renamed from: b  reason: collision with root package name */
    public static final Charset f17347b;

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f17348c;

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f17349d;

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f17350e;

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f17351f;

    /* renamed from: g  reason: collision with root package name */
    private static Charset f17352g;

    /* renamed from: h  reason: collision with root package name */
    private static Charset f17353h;

    /* renamed from: i  reason: collision with root package name */
    public static final d f17354i = new d();

    static {
        Charset forName = Charset.forName("UTF-8");
        kotlin.jvm.internal.m.f(forName, "Charset.forName(\"UTF-8\")");
        a = forName;
        Charset forName2 = Charset.forName(HTTP.UTF_16);
        kotlin.jvm.internal.m.f(forName2, "Charset.forName(\"UTF-16\")");
        f17347b = forName2;
        Charset forName3 = Charset.forName("UTF-16BE");
        kotlin.jvm.internal.m.f(forName3, "Charset.forName(\"UTF-16BE\")");
        f17348c = forName3;
        Charset forName4 = Charset.forName("UTF-16LE");
        kotlin.jvm.internal.m.f(forName4, "Charset.forName(\"UTF-16LE\")");
        f17349d = forName4;
        Charset forName5 = Charset.forName("US-ASCII");
        kotlin.jvm.internal.m.f(forName5, "Charset.forName(\"US-ASCII\")");
        f17350e = forName5;
        Charset forName6 = Charset.forName("ISO-8859-1");
        kotlin.jvm.internal.m.f(forName6, "Charset.forName(\"ISO-8859-1\")");
        f17351f = forName6;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = f17353h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        kotlin.jvm.internal.m.f(forName, "Charset.forName(\"UTF-32BE\")");
        f17353h = forName;
        return forName;
    }

    public final Charset b() {
        Charset charset = f17352g;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        kotlin.jvm.internal.m.f(forName, "Charset.forName(\"UTF-32LE\")");
        f17352g = forName;
        return forName;
    }
}