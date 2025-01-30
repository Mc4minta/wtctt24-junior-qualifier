package com.google.api.client.http;

import e.g.b.a.d.e0;
import e.g.b.a.d.f0;
import e.g.b.a.d.n;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpHeaders;
import org.apache.http.cookie.SM;

/* compiled from: HttpHeaders.java */
/* loaded from: classes2.dex */
public class l extends e.g.b.a.d.n {
    @e.g.b.a.d.q(HttpHeaders.ACCEPT)
    private List<String> accept;
    @e.g.b.a.d.q(HttpHeaders.ACCEPT_ENCODING)
    private List<String> acceptEncoding;
    @e.g.b.a.d.q(HttpHeaders.AGE)
    private List<Long> age;
    @e.g.b.a.d.q("WWW-Authenticate")
    private List<String> authenticate;
    @e.g.b.a.d.q("Authorization")
    private List<String> authorization;
    @e.g.b.a.d.q(HttpHeaders.CACHE_CONTROL)
    private List<String> cacheControl;
    @e.g.b.a.d.q("Content-Encoding")
    private List<String> contentEncoding;
    @e.g.b.a.d.q("Content-Length")
    private List<Long> contentLength;
    @e.g.b.a.d.q(HttpHeaders.CONTENT_MD5)
    private List<String> contentMD5;
    @e.g.b.a.d.q(HttpHeaders.CONTENT_RANGE)
    private List<String> contentRange;
    @e.g.b.a.d.q("Content-Type")
    private List<String> contentType;
    @e.g.b.a.d.q(SM.COOKIE)
    private List<String> cookie;
    @e.g.b.a.d.q("Date")
    private List<String> date;
    @e.g.b.a.d.q(HttpHeaders.ETAG)
    private List<String> etag;
    @e.g.b.a.d.q(HttpHeaders.EXPIRES)
    private List<String> expires;
    @e.g.b.a.d.q(HttpHeaders.IF_MATCH)
    private List<String> ifMatch;
    @e.g.b.a.d.q(HttpHeaders.IF_MODIFIED_SINCE)
    private List<String> ifModifiedSince;
    @e.g.b.a.d.q(HttpHeaders.IF_NONE_MATCH)
    private List<String> ifNoneMatch;
    @e.g.b.a.d.q(HttpHeaders.IF_RANGE)
    private List<String> ifRange;
    @e.g.b.a.d.q(HttpHeaders.IF_UNMODIFIED_SINCE)
    private List<String> ifUnmodifiedSince;
    @e.g.b.a.d.q(HttpHeaders.LAST_MODIFIED)
    private List<String> lastModified;
    @e.g.b.a.d.q(HttpHeaders.LOCATION)
    private List<String> location;
    @e.g.b.a.d.q("MIME-Version")
    private List<String> mimeVersion;
    @e.g.b.a.d.q(HttpHeaders.RANGE)
    private List<String> range;
    @e.g.b.a.d.q(HttpHeaders.RETRY_AFTER)
    private List<String> retryAfter;
    @e.g.b.a.d.q("User-Agent")
    private List<String> userAgent;

    /* compiled from: HttpHeaders.java */
    /* loaded from: classes2.dex */
    private static class a extends x {

        /* renamed from: e  reason: collision with root package name */
        private final l f8369e;

        /* renamed from: f  reason: collision with root package name */
        private final b f8370f;

        a(l lVar, b bVar) {
            this.f8369e = lVar;
            this.f8370f = bVar;
        }

        @Override // com.google.api.client.http.x
        public void a(String str, String str2) {
            this.f8369e.p(str, str2, this.f8370f);
        }

        @Override // com.google.api.client.http.x
        public y b() throws IOException {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HttpHeaders.java */
    /* loaded from: classes2.dex */
    public static final class b {
        final e.g.b.a.d.b a;

        /* renamed from: b  reason: collision with root package name */
        final StringBuilder f8371b;

        /* renamed from: c  reason: collision with root package name */
        final e.g.b.a.d.i f8372c;

        /* renamed from: d  reason: collision with root package name */
        final List<Type> f8373d;

        public b(l lVar, StringBuilder sb) {
            Class<?> cls = lVar.getClass();
            this.f8373d = Arrays.asList(cls);
            this.f8372c = e.g.b.a.d.i.g(cls, true);
            this.f8371b = sb;
            this.a = new e.g.b.a.d.b(lVar);
        }

        void a() {
            this.a.b();
        }
    }

    public l() {
        super(EnumSet.of(n.c.IGNORE_CASE));
        this.acceptEncoding = new ArrayList(Collections.singleton("gzip"));
    }

    private static String K(Object obj) {
        return obj instanceof Enum ? e.g.b.a.d.m.j((Enum) obj).e() : obj.toString();
    }

    private static void b(Logger logger, StringBuilder sb, StringBuilder sb2, x xVar, String str, Object obj, Writer writer) throws IOException {
        if (obj == null || e.g.b.a.d.j.c(obj)) {
            return;
        }
        String K = K(obj);
        String str2 = (("Authorization".equalsIgnoreCase(str) || SM.COOKIE.equalsIgnoreCase(str)) && (logger == null || !logger.isLoggable(Level.ALL))) ? "<Not Logged>" : K;
        if (sb != null) {
            sb.append(str);
            sb.append(": ");
            sb.append(str2);
            sb.append(e.g.b.a.d.c0.a);
        }
        if (sb2 != null) {
            sb2.append(" -H '");
            sb2.append(str);
            sb2.append(": ");
            sb2.append(str2);
            sb2.append("'");
        }
        if (xVar != null) {
            xVar.a(str, K);
        }
        if (writer != null) {
            writer.write(str);
            writer.write(": ");
            writer.write(K);
            writer.write("\r\n");
        }
    }

    private <T> List<T> f(T t) {
        if (t == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return arrayList;
    }

    private <T> T l(List<T> list) {
        if (list == null) {
            return null;
        }
        return list.get(0);
    }

    private static Object q(Type type, List<Type> list, String str) {
        return e.g.b.a.d.j.j(e.g.b.a.d.j.k(list, type), str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void r(l lVar, StringBuilder sb, StringBuilder sb2, Logger logger, x xVar) throws IOException {
        s(lVar, sb, sb2, logger, xVar, null);
    }

    static void s(l lVar, StringBuilder sb, StringBuilder sb2, Logger logger, x xVar, Writer writer) throws IOException {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Object> entry : lVar.entrySet()) {
            String key = entry.getKey();
            e.g.b.a.d.y.c(hashSet.add(key), "multiple headers of the same name (headers are case insensitive): %s", key);
            Object value = entry.getValue();
            if (value != null) {
                e.g.b.a.d.m b2 = lVar.getClassInfo().b(key);
                if (b2 != null) {
                    key = b2.e();
                }
                String str = key;
                Class<?> cls = value.getClass();
                if (!(value instanceof Iterable) && !cls.isArray()) {
                    b(logger, sb, sb2, xVar, str, value, writer);
                } else {
                    for (Object obj : f0.l(value)) {
                        b(logger, sb, sb2, xVar, str, obj, writer);
                    }
                }
            }
        }
        if (writer != null) {
            writer.flush();
        }
    }

    public static void t(l lVar, StringBuilder sb, Logger logger, Writer writer) throws IOException {
        s(lVar, sb, null, logger, null, writer);
    }

    public l A(Long l2) {
        this.contentLength = f(l2);
        return this;
    }

    public l B(String str) {
        this.contentRange = f(str);
        return this;
    }

    public l C(String str) {
        this.contentType = f(str);
        return this;
    }

    public l D(String str) {
        this.ifMatch = f(str);
        return this;
    }

    public l E(String str) {
        this.ifModifiedSince = f(str);
        return this;
    }

    public l F(String str) {
        this.ifNoneMatch = f(str);
        return this;
    }

    public l G(String str) {
        this.ifRange = f(str);
        return this;
    }

    public l H(String str) {
        this.ifUnmodifiedSince = f(str);
        return this;
    }

    public l I(String str) {
        this.range = f(str);
        return this;
    }

    public l J(String str) {
        this.userAgent = f(str);
        return this;
    }

    @Override // e.g.b.a.d.n, java.util.AbstractMap
    /* renamed from: c */
    public l clone() {
        return (l) super.clone();
    }

    public final void d(l lVar) {
        try {
            b bVar = new b(this, null);
            r(lVar, null, null, null, new a(this, bVar));
            bVar.a();
        } catch (IOException e2) {
            throw e0.a(e2);
        }
    }

    public final void e(y yVar, StringBuilder sb) throws IOException {
        clear();
        b bVar = new b(this, sb);
        int e2 = yVar.e();
        for (int i2 = 0; i2 < e2; i2++) {
            p(yVar.f(i2), yVar.g(i2), bVar);
        }
        bVar.a();
    }

    public final String getContentType() {
        return (String) l(this.contentType);
    }

    public final String getLocation() {
        return (String) l(this.location);
    }

    public final Long i() {
        return (Long) l(this.contentLength);
    }

    public final String k() {
        return (String) l(this.contentRange);
    }

    public final String n() {
        return (String) l(this.range);
    }

    public final String o() {
        return (String) l(this.userAgent);
    }

    void p(String str, String str2, b bVar) {
        List<Type> list = bVar.f8373d;
        e.g.b.a.d.i iVar = bVar.f8372c;
        e.g.b.a.d.b bVar2 = bVar.a;
        StringBuilder sb = bVar.f8371b;
        if (sb != null) {
            sb.append(str + ": " + str2);
            sb.append(e.g.b.a.d.c0.a);
        }
        e.g.b.a.d.m b2 = iVar.b(str);
        if (b2 != null) {
            Type k2 = e.g.b.a.d.j.k(list, b2.d());
            if (f0.j(k2)) {
                Class<?> f2 = f0.f(list, f0.b(k2));
                bVar2.a(b2.b(), f2, q(f2, list, str2));
                return;
            } else if (f0.k(f0.f(list, k2), Iterable.class)) {
                Collection<Object> collection = (Collection) b2.g(this);
                if (collection == null) {
                    collection = e.g.b.a.d.j.g(k2);
                    b2.m(this, collection);
                }
                collection.add(q(k2 == Object.class ? null : f0.d(k2), list, str2));
                return;
            } else {
                b2.m(this, q(k2, list, str2));
                return;
            }
        }
        ArrayList arrayList = (ArrayList) get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
            set(str, arrayList);
        }
        arrayList.add(str2);
    }

    @Override // e.g.b.a.d.n
    /* renamed from: u */
    public l set(String str, Object obj) {
        return (l) super.set(str, obj);
    }

    public l v(String str) {
        this.acceptEncoding = f(str);
        return this;
    }

    public l w(String str) {
        return x(f(str));
    }

    public l x(List<String> list) {
        this.authorization = list;
        return this;
    }

    public l y(String str) {
        this.contentEncoding = f(str);
        return this;
    }
}