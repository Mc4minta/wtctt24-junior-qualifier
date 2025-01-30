package e.f.j.l;

import android.util.Pair;
import com.facebook.imagepipeline.request.b;

/* compiled from: BitmapMemoryCacheKeyMultiplexProducer.java */
/* loaded from: classes2.dex */
public class g extends d0<Pair<e.f.b.a.d, b.EnumC0109b>, com.facebook.common.references.a<e.f.j.i.b>> {

    /* renamed from: c  reason: collision with root package name */
    private final e.f.j.d.f f12613c;

    public g(e.f.j.d.f fVar, j0 j0Var) {
        super(j0Var);
        this.f12613c = fVar;
    }

    @Override // e.f.j.l.d0
    /* renamed from: k */
    public com.facebook.common.references.a<e.f.j.i.b> f(com.facebook.common.references.a<e.f.j.i.b> aVar) {
        return com.facebook.common.references.a.e(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.j.l.d0
    /* renamed from: l */
    public Pair<e.f.b.a.d, b.EnumC0109b> i(k0 k0Var) {
        return Pair.create(this.f12613c.a(k0Var.c(), k0Var.a()), k0Var.h());
    }
}