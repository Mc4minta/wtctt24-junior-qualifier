package e.f.j.n;

/* compiled from: MultiImageTranscoderFactory.java */
/* loaded from: classes2.dex */
public class f implements d {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12804b;

    /* renamed from: c  reason: collision with root package name */
    private final d f12805c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f12806d;

    public f(int i2, boolean z, d dVar, Integer num) {
        this.a = i2;
        this.f12804b = z;
        this.f12805c = dVar;
        this.f12806d = num;
    }

    private c a(e.f.i.c cVar, boolean z) {
        d dVar = this.f12805c;
        if (dVar == null) {
            return null;
        }
        return dVar.createImageTranscoder(cVar, z);
    }

    private c b(e.f.i.c cVar, boolean z) {
        Integer num = this.f12806d;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        if (intValue != 0) {
            if (intValue == 1) {
                return d(cVar, z);
            }
            throw new IllegalArgumentException("Invalid ImageTranscoderType");
        }
        return c(cVar, z);
    }

    private c c(e.f.i.c cVar, boolean z) {
        return com.facebook.imagepipeline.nativecode.c.a(this.a, this.f12804b).createImageTranscoder(cVar, z);
    }

    private c d(e.f.i.c cVar, boolean z) {
        return new h(this.a).createImageTranscoder(cVar, z);
    }

    @Override // e.f.j.n.d
    public c createImageTranscoder(e.f.i.c cVar, boolean z) {
        c a = a(cVar, z);
        if (a == null) {
            a = b(cVar, z);
        }
        if (a == null) {
            a = c(cVar, z);
        }
        return a == null ? d(cVar, z) : a;
    }
}