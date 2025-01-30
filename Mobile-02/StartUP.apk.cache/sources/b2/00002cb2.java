package com.facebook.imagepipeline.memory;

/* compiled from: FlexByteArrayPool.java */
/* loaded from: classes2.dex */
public class p {
    private final com.facebook.common.references.c<byte[]> a;

    /* renamed from: b  reason: collision with root package name */
    final b f4614b;

    /* compiled from: FlexByteArrayPool.java */
    /* loaded from: classes2.dex */
    class a implements com.facebook.common.references.c<byte[]> {
        a() {
        }

        @Override // com.facebook.common.references.c
        /* renamed from: a */
        public void release(byte[] bArr) {
            p.this.b(bArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FlexByteArrayPool.java */
    /* loaded from: classes2.dex */
    public static class b extends q {
        public b(com.facebook.common.memory.c cVar, e0 e0Var, f0 f0Var) {
            super(cVar, e0Var, f0Var);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        e<byte[]> r(int i2) {
            return new a0(j(i2), this.f4548c.f4606g, 0);
        }
    }

    public p(com.facebook.common.memory.c cVar, e0 e0Var) {
        e.f.d.c.i.b(e0Var.f4606g > 0);
        this.f4614b = new b(cVar, e0Var, z.h());
        this.a = new a();
    }

    public com.facebook.common.references.a<byte[]> a(int i2) {
        return com.facebook.common.references.a.e0(this.f4614b.get(i2), this.a);
    }

    public void b(byte[] bArr) {
        this.f4614b.release(bArr);
    }
}