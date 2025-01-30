package e.g.b.a.d;

/* compiled from: Sleeper.java */
/* loaded from: classes2.dex */
public interface a0 {
    public static final a0 a = new a();

    /* compiled from: Sleeper.java */
    /* loaded from: classes2.dex */
    static class a implements a0 {
        a() {
        }

        @Override // e.g.b.a.d.a0
        public void a(long j2) throws InterruptedException {
            Thread.sleep(j2);
        }
    }

    void a(long j2) throws InterruptedException;
}