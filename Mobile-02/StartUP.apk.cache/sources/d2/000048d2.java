package e.g.b.a.d.h0;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* compiled from: CharEscapers.java */
/* loaded from: classes2.dex */
public final class a {
    private static final b a = new c("-_.*", true);

    /* renamed from: b  reason: collision with root package name */
    private static final b f13412b = new c("-_.!~*'()@:$&,;=", false);

    /* renamed from: c  reason: collision with root package name */
    private static final b f13413c = new c("-_.!~*'()@:$&,;=+/?", false);

    /* renamed from: d  reason: collision with root package name */
    private static final b f13414d = new c("-_.!~*'():$&,;=", false);

    /* renamed from: e  reason: collision with root package name */
    private static final b f13415e = new c("-_.!~*'()@:$,;/?:", false);

    public static String a(String str) {
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static String b(String str) {
        return a.a(str);
    }

    public static String c(String str) {
        return f13412b.a(str);
    }

    public static String d(String str) {
        return f13413c.a(str);
    }

    public static String e(String str) {
        return f13415e.a(str);
    }

    public static String f(String str) {
        return f13414d.a(str);
    }
}