package e.g.b.a.b.c;

import com.google.api.client.http.g;
import com.google.api.client.http.o;
import com.google.api.client.http.p;
import com.google.api.client.http.q;
import com.google.api.client.http.u;
import e.g.b.a.d.a0;
import e.g.b.a.d.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BatchRequest.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private final p f13341b;
    private g a = new g("https://www.googleapis.com/batch");

    /* renamed from: c  reason: collision with root package name */
    List<a<?, ?>> f13342c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private a0 f13343d = a0.a;

    /* compiled from: BatchRequest.java */
    /* loaded from: classes2.dex */
    static class a<T, E> {
        final e.g.b.a.b.c.a<T, E> a;

        /* renamed from: b  reason: collision with root package name */
        final Class<T> f13344b;

        /* renamed from: c  reason: collision with root package name */
        final Class<E> f13345c;

        /* renamed from: d  reason: collision with root package name */
        final o f13346d;

        a(e.g.b.a.b.c.a<T, E> aVar, Class<T> cls, Class<E> cls2, o oVar) {
            this.a = aVar;
            this.f13344b = cls;
            this.f13345c = cls2;
            this.f13346d = oVar;
        }
    }

    public b(u uVar, q qVar) {
        this.f13341b = qVar == null ? uVar.c() : uVar.d(qVar);
    }

    public <T, E> b a(o oVar, Class<T> cls, Class<E> cls2, e.g.b.a.b.c.a<T, E> aVar) throws IOException {
        y.d(oVar);
        y.d(aVar);
        y.d(cls);
        y.d(cls2);
        this.f13342c.add(new a<>(aVar, cls, cls2, oVar));
        return this;
    }

    public b b(g gVar) {
        this.a = gVar;
        return this;
    }
}