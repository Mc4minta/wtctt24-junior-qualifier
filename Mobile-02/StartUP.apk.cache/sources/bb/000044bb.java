package e.a.a.w.k;

/* compiled from: MergePaths.java */
/* loaded from: classes.dex */
public class h implements b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final a f11815b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11816c;

    /* compiled from: MergePaths.java */
    /* loaded from: classes.dex */
    public enum a {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static a h(int i2) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            if (i2 != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public h(String str, a aVar, boolean z) {
        this.a = str;
        this.f11815b = aVar;
        this.f11816c = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        if (!gVar.l()) {
            e.a.a.z.d.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new e.a.a.u.b.l(this);
    }

    public a b() {
        return this.f11815b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.f11816c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f11815b + '}';
    }
}