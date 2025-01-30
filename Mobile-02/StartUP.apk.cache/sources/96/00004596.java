package e.f.h.a.a;

import android.content.Context;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.request.b;
import e.f.h.c.b;
import e.f.j.e.h;
import java.util.Set;

/* compiled from: PipelineDraweeControllerBuilder.java */
/* loaded from: classes2.dex */
public class e extends e.f.h.c.b<e, com.facebook.imagepipeline.request.b, com.facebook.common.references.a<e.f.j.i.b>, e.f.j.i.e> {
    private final h s;
    private final g t;
    private e.f.d.c.e<e.f.j.h.a> u;
    private e.f.h.a.a.i.b v;
    private e.f.h.a.a.i.f w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PipelineDraweeControllerBuilder.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[b.c.values().length];
            a = iArr;
            try {
                iArr[b.c.FULL_FETCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.c.DISK_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.c.BITMAP_MEMORY_CACHE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(Context context, g gVar, h hVar, Set<e.f.h.c.d> set) {
        super(context, set);
        this.s = hVar;
        this.t = gVar;
    }

    public static b.EnumC0109b E(b.c cVar) {
        int i2 = a.a[cVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return b.EnumC0109b.BITMAP_MEMORY_CACHE;
                }
                throw new RuntimeException("Cache level" + cVar + "is not supported. ");
            }
            return b.EnumC0109b.DISK_CACHE;
        }
        return b.EnumC0109b.FULL_FETCH;
    }

    private e.f.b.a.d F() {
        com.facebook.imagepipeline.request.b m = m();
        e.f.j.d.f j2 = this.s.j();
        if (j2 == null || m == null) {
            return null;
        }
        if (m.g() != null) {
            return j2.c(m, f());
        }
        return j2.a(m, f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.b
    /* renamed from: G */
    public e.f.e.c<com.facebook.common.references.a<e.f.j.i.b>> i(e.f.h.h.a aVar, String str, com.facebook.imagepipeline.request.b bVar, Object obj, b.c cVar) {
        return this.s.f(bVar, obj, E(cVar), H(aVar));
    }

    protected e.f.j.j.c H(e.f.h.h.a aVar) {
        if (aVar instanceof d) {
            return ((d) aVar).Z();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.h.c.b
    /* renamed from: I */
    public d u() {
        d c2;
        if (e.f.j.m.b.d()) {
            e.f.j.m.b.a("PipelineDraweeControllerBuilder#obtainController");
        }
        try {
            e.f.h.h.a n = n();
            String e2 = e.f.h.c.b.e();
            if (n instanceof d) {
                c2 = (d) n;
            } else {
                c2 = this.t.c();
            }
            c2.b0(v(c2, e2), e2, F(), f(), this.u, this.v);
            c2.c0(this.w);
            return c2;
        } finally {
            if (e.f.j.m.b.d()) {
                e.f.j.m.b.b();
            }
        }
    }

    public e J(e.f.h.a.a.i.f fVar) {
        this.w = fVar;
        return p();
    }

    @Override // e.f.h.h.d
    /* renamed from: K */
    public e a(Uri uri) {
        if (uri == null) {
            return (e) super.A(null);
        }
        return (e) super.A(ImageRequestBuilder.r(uri).D(com.facebook.imagepipeline.common.f.b()).a());
    }
}