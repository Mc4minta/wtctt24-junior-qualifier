package e.f.j.n;

/* compiled from: SimpleImageTranscoderFactory.java */
/* loaded from: classes2.dex */
public class h implements d {
    private final int a;

    public h(int i2) {
        this.a = i2;
    }

    @Override // e.f.j.n.d
    public c createImageTranscoder(e.f.i.c cVar, boolean z) {
        return new g(z, this.a);
    }
}