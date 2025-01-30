package e.f.h.b;

/* compiled from: RetryManager.java */
/* loaded from: classes2.dex */
public class c {
    private boolean a;

    /* renamed from: b  reason: collision with root package name */
    private int f12199b;

    /* renamed from: c  reason: collision with root package name */
    private int f12200c;

    public c() {
        a();
    }

    public void a() {
        this.a = false;
        this.f12199b = 4;
        c();
    }

    public void b() {
        this.f12200c++;
    }

    public void c() {
        this.f12200c = 0;
    }

    public void d(boolean z) {
        this.a = z;
    }

    public boolean e() {
        return this.a && this.f12200c < this.f12199b;
    }
}