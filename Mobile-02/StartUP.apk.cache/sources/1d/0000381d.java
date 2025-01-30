package com.google.api.client.http;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: HttpMediaType.java */
/* loaded from: classes2.dex */
public final class n {
    private static final Pattern a = Pattern.compile("[\\w!#$&.+\\-\\^_]+|[*]");

    /* renamed from: b  reason: collision with root package name */
    private static final Pattern f8374b = Pattern.compile("[\\p{ASCII}&&[^\\p{Cntrl} ;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+");

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f8375c = Pattern.compile("\\s*([^\\s/=;\"]+)/([^\\s/=;\"]+)\\s*(;.*)?", 32);

    /* renamed from: d  reason: collision with root package name */
    private static final Pattern f8376d;

    /* renamed from: e  reason: collision with root package name */
    private String f8377e = "application";

    /* renamed from: f  reason: collision with root package name */
    private String f8378f = "octet-stream";

    /* renamed from: g  reason: collision with root package name */
    private final SortedMap<String, String> f8379g = new TreeMap();

    /* renamed from: h  reason: collision with root package name */
    private String f8380h;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("\"([^\"]*)\"");
        sb.append("|");
        sb.append("[^\\s;\"]*");
        f8376d = Pattern.compile("\\s*;\\s*([^\\s/=;\"]+)=(" + sb.toString() + ")");
    }

    public n(String str) {
        d(str);
    }

    public static boolean c(String str, String str2) {
        return (str == null && str2 == null) || !(str == null || str2 == null || !new n(str).b(new n(str2)));
    }

    private n d(String str) {
        Matcher matcher = f8375c.matcher(str);
        e.g.b.a.d.y.b(matcher.matches(), "Type must be in the 'maintype/subtype; parameter=value' format");
        o(matcher.group(1));
        n(matcher.group(2));
        String group = matcher.group(3);
        if (group != null) {
            Matcher matcher2 = f8376d.matcher(group);
            while (matcher2.find()) {
                String group2 = matcher2.group(1);
                String group3 = matcher2.group(3);
                if (group3 == null) {
                    group3 = matcher2.group(2);
                }
                m(group2, group3);
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(String str) {
        return f8374b.matcher(str).matches();
    }

    private static String j(String str) {
        String replace = str.replace("\\", "\\\\").replace("\"", "\\\"");
        return "\"" + replace + "\"";
    }

    public String a() {
        String str = this.f8380h;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8377e);
        sb.append('/');
        sb.append(this.f8378f);
        SortedMap<String, String> sortedMap = this.f8379g;
        if (sortedMap != null) {
            for (Map.Entry<String, String> entry : sortedMap.entrySet()) {
                String value = entry.getValue();
                sb.append("; ");
                sb.append(entry.getKey());
                sb.append("=");
                if (!i(value)) {
                    value = j(value);
                }
                sb.append(value);
            }
        }
        String sb2 = sb.toString();
        this.f8380h = sb2;
        return sb2;
    }

    public boolean b(n nVar) {
        return nVar != null && h().equalsIgnoreCase(nVar.h()) && g().equalsIgnoreCase(nVar.g());
    }

    public Charset e() {
        String f2 = f("charset");
        if (f2 == null) {
            return null;
        }
        return Charset.forName(f2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            return b(nVar) && this.f8379g.equals(nVar.f8379g);
        }
        return false;
    }

    public String f(String str) {
        return this.f8379g.get(str.toLowerCase(Locale.US));
    }

    public String g() {
        return this.f8378f;
    }

    public String h() {
        return this.f8377e;
    }

    public int hashCode() {
        return a().hashCode();
    }

    public n k(String str) {
        this.f8380h = null;
        this.f8379g.remove(str.toLowerCase(Locale.US));
        return this;
    }

    public n l(Charset charset) {
        m("charset", charset == null ? null : charset.name());
        return this;
    }

    public n m(String str, String str2) {
        if (str2 == null) {
            k(str);
            return this;
        }
        e.g.b.a.d.y.b(f8374b.matcher(str).matches(), "Name contains reserved characters");
        this.f8380h = null;
        this.f8379g.put(str.toLowerCase(Locale.US), str2);
        return this;
    }

    public n n(String str) {
        e.g.b.a.d.y.b(a.matcher(str).matches(), "Subtype contains reserved characters");
        this.f8378f = str;
        this.f8380h = null;
        return this;
    }

    public n o(String str) {
        e.g.b.a.d.y.b(a.matcher(str).matches(), "Type contains reserved characters");
        this.f8377e = str;
        this.f8380h = null;
        return this;
    }

    public String toString() {
        return a();
    }
}