package e.f.j.d;

import com.facebook.common.memory.PooledByteBuffer;

/* compiled from: EncodedCountingMemoryCacheFactory.java */
/* loaded from: classes2.dex */
public class l {

    /* compiled from: EncodedCountingMemoryCacheFactory.java */
    /* loaded from: classes2.dex */
    static class a implements v<PooledByteBuffer> {
        a() {
        }

        @Override // e.f.j.d.v
        /* renamed from: b */
        public int a(PooledByteBuffer pooledByteBuffer) {
            return pooledByteBuffer.size();
        }
    }

    public static h<e.f.b.a.d, PooledByteBuffer> a(e.f.d.c.l<q> lVar, com.facebook.common.memory.c cVar) {
        h<e.f.b.a.d, PooledByteBuffer> hVar = new h<>(new a(), new s(), lVar);
        cVar.a(hVar);
        return hVar;
    }
}