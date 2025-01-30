package e.f.j.d;

import android.net.Uri;
import com.facebook.common.time.RealtimeSinceBootClock;

/* compiled from: BitmapMemoryCacheKey.java */
/* loaded from: classes2.dex */
public class c implements e.f.b.a.d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.e f12420b;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.f f12421c;

    /* renamed from: d  reason: collision with root package name */
    private final com.facebook.imagepipeline.common.b f12422d;

    /* renamed from: e  reason: collision with root package name */
    private final e.f.b.a.d f12423e;

    /* renamed from: f  reason: collision with root package name */
    private final String f12424f;

    /* renamed from: g  reason: collision with root package name */
    private final int f12425g;

    /* renamed from: h  reason: collision with root package name */
    private final Object f12426h;

    /* renamed from: i  reason: collision with root package name */
    private final long f12427i;

    public c(String str, com.facebook.imagepipeline.common.e eVar, com.facebook.imagepipeline.common.f fVar, com.facebook.imagepipeline.common.b bVar, e.f.b.a.d dVar, String str2, Object obj) {
        this.a = (String) e.f.d.c.i.g(str);
        this.f12420b = eVar;
        this.f12421c = fVar;
        this.f12422d = bVar;
        this.f12423e = dVar;
        this.f12424f = str2;
        this.f12425g = com.facebook.common.util.a.d(Integer.valueOf(str.hashCode()), Integer.valueOf(eVar != null ? eVar.hashCode() : 0), Integer.valueOf(fVar.hashCode()), bVar, dVar, str2);
        this.f12426h = obj;
        this.f12427i = RealtimeSinceBootClock.get().now();
    }

    @Override // e.f.b.a.d
    public boolean a(Uri uri) {
        return b().contains(uri.toString());
    }

    @Override // e.f.b.a.d
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f12425g == cVar.f12425g && this.a.equals(cVar.a) && e.f.d.c.h.a(this.f12420b, cVar.f12420b) && e.f.d.c.h.a(this.f12421c, cVar.f12421c) && e.f.d.c.h.a(this.f12422d, cVar.f12422d) && e.f.d.c.h.a(this.f12423e, cVar.f12423e) && e.f.d.c.h.a(this.f12424f, cVar.f12424f);
        }
        return false;
    }

    public int hashCode() {
        return this.f12425g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.a, this.f12420b, this.f12421c, this.f12422d, this.f12423e, this.f12424f, Integer.valueOf(this.f12425g));
    }
}