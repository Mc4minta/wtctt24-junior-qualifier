package e.f.h.a.a.i;

/* compiled from: ImageOriginRequestListener.java */
/* loaded from: classes2.dex */
public class c extends e.f.j.j.a {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private final b f12147b;

    public c(String str, b bVar) {
        this.f12147b = bVar;
        l(str);
    }

    @Override // e.f.j.j.a, e.f.j.l.m0
    public void e(String str, String str2, boolean z) {
        b bVar = this.f12147b;
        if (bVar != null) {
            bVar.a(this.a, d.a(str2), z, str2);
        }
    }

    public void l(String str) {
        this.a = str;
    }
}