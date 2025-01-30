package e.f.j.l;

import android.util.Pair;
import com.facebook.imagepipeline.request.b;

/* compiled from: EncodedCacheKeyMultiplexProducer.java */
/* loaded from: classes2.dex */
public class q extends d0<Pair<e.f.b.a.d, b.EnumC0109b>, e.f.j.i.d> {

    /* renamed from: c  reason: collision with root package name */
    private final e.f.j.d.f f12720c;

    public q(e.f.j.d.f fVar, j0 j0Var) {
        super(j0Var);
        this.f12720c = fVar;
    }

    @Override // e.f.j.l.d0
    /* renamed from: k */
    public e.f.j.i.d f(e.f.j.i.d dVar) {
        return e.f.j.i.d.b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e.f.j.l.d0
    /* renamed from: l */
    public Pair<e.f.b.a.d, b.EnumC0109b> i(k0 k0Var) {
        return Pair.create(this.f12720c.d(k0Var.c(), k0Var.a()), k0Var.h());
    }
}