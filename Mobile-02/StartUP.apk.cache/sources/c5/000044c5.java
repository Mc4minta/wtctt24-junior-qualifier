package e.a.a.w.k;

import android.graphics.Paint;
import e.a.a.u.b.r;
import java.util.List;

/* compiled from: ShapeStroke.java */
/* loaded from: classes.dex */
public class p implements e.a.a.w.k.b {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final e.a.a.w.j.b f11854b;

    /* renamed from: c  reason: collision with root package name */
    private final List<e.a.a.w.j.b> f11855c;

    /* renamed from: d  reason: collision with root package name */
    private final e.a.a.w.j.a f11856d;

    /* renamed from: e  reason: collision with root package name */
    private final e.a.a.w.j.d f11857e;

    /* renamed from: f  reason: collision with root package name */
    private final e.a.a.w.j.b f11858f;

    /* renamed from: g  reason: collision with root package name */
    private final b f11859g;

    /* renamed from: h  reason: collision with root package name */
    private final c f11860h;

    /* renamed from: i  reason: collision with root package name */
    private final float f11861i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f11862j;

    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f11863b;

        static {
            int[] iArr = new int[c.values().length];
            f11863b = iArr;
            try {
                iArr[c.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f11863b[c.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f11863b[c.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[b.values().length];
            a = iArr2;
            try {
                iArr2[b.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    public enum b {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap h() {
            int i2 = a.a[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* compiled from: ShapeStroke.java */
    /* loaded from: classes.dex */
    public enum c {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join h() {
            int i2 = a.f11863b[ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public p(String str, e.a.a.w.j.b bVar, List<e.a.a.w.j.b> list, e.a.a.w.j.a aVar, e.a.a.w.j.d dVar, e.a.a.w.j.b bVar2, b bVar3, c cVar, float f2, boolean z) {
        this.a = str;
        this.f11854b = bVar;
        this.f11855c = list;
        this.f11856d = aVar;
        this.f11857e = dVar;
        this.f11858f = bVar2;
        this.f11859g = bVar3;
        this.f11860h = cVar;
        this.f11861i = f2;
        this.f11862j = z;
    }

    @Override // e.a.a.w.k.b
    public e.a.a.u.b.c a(e.a.a.g gVar, e.a.a.w.l.a aVar) {
        return new r(gVar, aVar, this);
    }

    public b b() {
        return this.f11859g;
    }

    public e.a.a.w.j.a c() {
        return this.f11856d;
    }

    public e.a.a.w.j.b d() {
        return this.f11854b;
    }

    public c e() {
        return this.f11860h;
    }

    public List<e.a.a.w.j.b> f() {
        return this.f11855c;
    }

    public float g() {
        return this.f11861i;
    }

    public String h() {
        return this.a;
    }

    public e.a.a.w.j.d i() {
        return this.f11857e;
    }

    public e.a.a.w.j.b j() {
        return this.f11858f;
    }

    public boolean k() {
        return this.f11862j;
    }
}