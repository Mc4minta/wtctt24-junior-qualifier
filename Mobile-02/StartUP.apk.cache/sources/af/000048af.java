package e.g.b.a.c;

import e.g.b.a.d.w;
import e.g.b.a.d.y;
import e.g.b.a.d.z;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: JsonObjectParser.java */
/* loaded from: classes2.dex */
public class e implements w {
    private final c a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<String> f13381b;

    /* compiled from: JsonObjectParser.java */
    /* loaded from: classes2.dex */
    public static class a {
        final c a;

        /* renamed from: b  reason: collision with root package name */
        Collection<String> f13382b = z.a();

        public a(c cVar) {
            this.a = (c) y.d(cVar);
        }

        public e a() {
            return new e(this);
        }

        public a b(Collection<String> collection) {
            this.f13382b = collection;
            return this;
        }
    }

    public e(c cVar) {
        this(new a(cVar));
    }

    private void d(f fVar) throws IOException {
        if (this.f13381b.isEmpty()) {
            return;
        }
        try {
            y.c((fVar.z(this.f13381b) == null || fVar.f() == i.END_OBJECT) ? false : true, "wrapper key(s) not found: %s", this.f13381b);
        } catch (Throwable th) {
            fVar.a();
            throw th;
        }
    }

    @Override // e.g.b.a.d.w
    public <T> T a(InputStream inputStream, Charset charset, Class<T> cls) throws IOException {
        return (T) e(inputStream, charset, cls);
    }

    public final c b() {
        return this.a;
    }

    public Set<String> c() {
        return Collections.unmodifiableSet(this.f13381b);
    }

    public Object e(InputStream inputStream, Charset charset, Type type) throws IOException {
        f c2 = this.a.c(inputStream, charset);
        d(c2);
        return c2.q(type, true);
    }

    protected e(a aVar) {
        this.a = aVar.a;
        this.f13381b = new HashSet(aVar.f13382b);
    }
}