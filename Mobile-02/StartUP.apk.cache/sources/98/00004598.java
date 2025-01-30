package e.f.h.a.a;

import android.content.Context;
import android.content.res.Resources;
import e.f.d.c.l;
import e.f.j.d.p;
import e.f.j.e.h;
import e.f.j.e.k;
import java.util.Set;

/* compiled from: PipelineDraweeControllerBuilderSupplier.java */
/* loaded from: classes2.dex */
public class f implements l<e> {
    private final Context a;

    /* renamed from: b  reason: collision with root package name */
    private final h f12137b;

    /* renamed from: c  reason: collision with root package name */
    private final g f12138c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<e.f.h.c.d> f12139d;

    /* renamed from: e  reason: collision with root package name */
    private final e.f.h.a.a.i.f f12140e;

    public f(Context context, b bVar) {
        this(context, k.k(), bVar);
    }

    @Override // e.f.d.c.l
    /* renamed from: a */
    public e get() {
        return new e(this.a, this.f12138c, this.f12137b, this.f12139d).J(this.f12140e);
    }

    public f(Context context, k kVar, b bVar) {
        this(context, kVar, null, bVar);
    }

    public f(Context context, k kVar, Set<e.f.h.c.d> set, b bVar) {
        this.a = context;
        h i2 = kVar.i();
        this.f12137b = i2;
        if (bVar == null) {
            g gVar = new g();
            this.f12138c = gVar;
            Resources resources = context.getResources();
            e.f.h.b.a e2 = e.f.h.b.a.e();
            e.f.j.h.a a = kVar.a(context);
            e.f.d.b.e g2 = e.f.d.b.e.g();
            p<e.f.b.a.d, e.f.j.i.b> i3 = i2.i();
            if (bVar != null) {
                throw null;
            }
            if (bVar == null) {
                gVar.a(resources, e2, a, g2, i3, null, null);
                this.f12139d = set;
                if (bVar != null) {
                    throw null;
                }
                this.f12140e = null;
                return;
            }
            throw null;
        }
        throw null;
    }
}