package e.f.j.d;

import com.facebook.common.memory.PooledByteBuffer;

/* compiled from: EncodedMemoryCacheFactory.java */
/* loaded from: classes2.dex */
public class m {

    /* compiled from: EncodedMemoryCacheFactory.java */
    /* loaded from: classes2.dex */
    static class a implements r<e.f.b.a.d> {
        final /* synthetic */ n a;

        a(n nVar) {
            this.a = nVar;
        }

        @Override // e.f.j.d.r
        public void b() {
            this.a.c();
        }

        @Override // e.f.j.d.r
        public void c() {
            this.a.k();
        }

        @Override // e.f.j.d.r
        /* renamed from: d */
        public void a(e.f.b.a.d dVar) {
            this.a.e(dVar);
        }
    }

    public static o<e.f.b.a.d, PooledByteBuffer> a(h<e.f.b.a.d, PooledByteBuffer> hVar, n nVar) {
        nVar.g(hVar);
        return new o<>(hVar, new a(nVar));
    }
}