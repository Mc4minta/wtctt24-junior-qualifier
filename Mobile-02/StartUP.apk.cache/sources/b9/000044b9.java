package e.a.a.w.k;

/* compiled from: Mask.java */
/* loaded from: classes.dex */
public class g {
    private final a a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.w.j.h f11808b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a.a.w.j.d f11809c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11810d;

    /* compiled from: Mask.java */
    /* loaded from: classes.dex */
    public enum a {
        MASK_MODE_ADD,
        MASK_MODE_SUBTRACT,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE
    }

    public g(a aVar, e.a.a.w.j.h hVar, e.a.a.w.j.d dVar, boolean z) {
        this.a = aVar;
        this.f11808b = hVar;
        this.f11809c = dVar;
        this.f11810d = z;
    }

    public a a() {
        return this.a;
    }

    public e.a.a.w.j.h b() {
        return this.f11808b;
    }

    public e.a.a.w.j.d c() {
        return this.f11809c;
    }

    public boolean d() {
        return this.f11810d;
    }
}