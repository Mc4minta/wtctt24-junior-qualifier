package e.f.j.d;

import e.f.j.d.h;

/* compiled from: BitmapCountingMemoryCacheFactory.java */
/* loaded from: classes2.dex */
public class a {

    /* compiled from: BitmapCountingMemoryCacheFactory.java */
    /* renamed from: e.f.j.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static class C0273a implements v<e.f.j.i.b> {
        C0273a() {
        }

        @Override // e.f.j.d.v
        /* renamed from: b */
        public int a(e.f.j.i.b bVar) {
            return bVar.b();
        }
    }

    public static h<e.f.b.a.d, e.f.j.i.b> a(e.f.d.c.l<q> lVar, com.facebook.common.memory.c cVar, h.c cVar2) {
        h<e.f.b.a.d, e.f.j.i.b> hVar = new h<>(new C0273a(), cVar2, lVar);
        cVar.a(hVar);
        return hVar;
    }
}