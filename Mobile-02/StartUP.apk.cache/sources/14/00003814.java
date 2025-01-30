package com.google.api.client.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* compiled from: GenericUrl.java */
/* loaded from: classes2.dex */
public class g extends e.g.b.a.d.n {
    private static final e.g.b.a.d.h0.b a = new e.g.b.a.d.h0.c("=&-_.!~*'()@:$,;/?:", false);

    /* renamed from: b  reason: collision with root package name */
    private String f8362b;

    /* renamed from: c  reason: collision with root package name */
    private String f8363c;

    /* renamed from: d  reason: collision with root package name */
    private String f8364d;

    /* renamed from: e  reason: collision with root package name */
    private int f8365e;

    /* renamed from: f  reason: collision with root package name */
    private List<String> f8366f;

    /* renamed from: g  reason: collision with root package name */
    private String f8367g;

    public g() {
        this.f8365e = -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Set<Map.Entry<String, Object>> set, StringBuilder sb) {
        boolean z = true;
        for (Map.Entry<String, Object> entry : set) {
            Object value = entry.getValue();
            if (value != null) {
                String e2 = e.g.b.a.d.h0.a.e(entry.getKey());
                if (value instanceof Collection) {
                    for (Object obj : (Collection) value) {
                        z = c(z, sb, e2, obj);
                    }
                } else {
                    z = c(z, sb, e2, value);
                }
            }
        }
    }

    private static boolean c(boolean z, StringBuilder sb, String str, Object obj) {
        if (z) {
            z = false;
            sb.append('?');
        } else {
            sb.append('&');
        }
        sb.append(str);
        String e2 = e.g.b.a.d.h0.a.e(obj.toString());
        if (e2.length() != 0) {
            sb.append('=');
            sb.append(e2);
        }
        return z;
    }

    private void d(StringBuilder sb) {
        int size = this.f8366f.size();
        for (int i2 = 0; i2 < size; i2++) {
            String str = this.f8366f.get(i2);
            if (i2 != 0) {
                sb.append('/');
            }
            if (str.length() != 0) {
                sb.append(e.g.b.a.d.h0.a.c(str));
            }
        }
    }

    private static URL l(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static List<String> p(String str) {
        String substring;
        if (str == null || str.length() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        boolean z = true;
        while (z) {
            int indexOf = str.indexOf(47, i2);
            boolean z2 = indexOf != -1;
            if (z2) {
                substring = str.substring(i2, indexOf);
            } else {
                substring = str.substring(i2);
            }
            arrayList.add(e.g.b.a.d.h0.a.a(substring));
            i2 = indexOf + 1;
            z = z2;
        }
        return arrayList;
    }

    public final String e() {
        return f() + i();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (super.equals(obj) && (obj instanceof g)) {
            return e().equals(((g) obj).e());
        }
        return false;
    }

    public final String f() {
        StringBuilder sb = new StringBuilder();
        sb.append((String) e.g.b.a.d.y.d(this.f8362b));
        sb.append("://");
        String str = this.f8364d;
        if (str != null) {
            sb.append(e.g.b.a.d.h0.a.f(str));
            sb.append('@');
        }
        sb.append((String) e.g.b.a.d.y.d(this.f8363c));
        int i2 = this.f8365e;
        if (i2 != -1) {
            sb.append(':');
            sb.append(i2);
        }
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return e().hashCode();
    }

    public final String i() {
        StringBuilder sb = new StringBuilder();
        if (this.f8366f != null) {
            d(sb);
        }
        b(entrySet(), sb);
        String str = this.f8367g;
        if (str != null) {
            sb.append('#');
            sb.append(a.a(str));
        }
        return sb.toString();
    }

    @Override // e.g.b.a.d.n, java.util.AbstractMap
    /* renamed from: k */
    public g clone() {
        g gVar = (g) super.clone();
        if (this.f8366f != null) {
            gVar.f8366f = new ArrayList(this.f8366f);
        }
        return gVar;
    }

    @Override // e.g.b.a.d.n
    /* renamed from: n */
    public g set(String str, Object obj) {
        return (g) super.set(str, obj);
    }

    public void o(String str) {
        this.f8366f = p(str);
    }

    public final URL q() {
        return l(e());
    }

    public final URL r(String str) {
        try {
            return new URL(q(), str);
        } catch (MalformedURLException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @Override // java.util.AbstractMap
    public String toString() {
        return e();
    }

    public g(String str) {
        this(l(str));
    }

    public g(URL url) {
        this(url.getProtocol(), url.getHost(), url.getPort(), url.getPath(), url.getRef(), url.getQuery(), url.getUserInfo());
    }

    private g(String str, String str2, int i2, String str3, String str4, String str5, String str6) {
        this.f8365e = -1;
        this.f8362b = str.toLowerCase(Locale.US);
        this.f8363c = str2;
        this.f8365e = i2;
        this.f8366f = p(str3);
        this.f8367g = str4 != null ? e.g.b.a.d.h0.a.a(str4) : null;
        if (str5 != null) {
            c0.c(str5, this);
        }
        this.f8364d = str6 != null ? e.g.b.a.d.h0.a.a(str6) : null;
    }
}