package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KotlinVersion.kt */
/* loaded from: classes3.dex */
public final class f implements Comparable<f> {

    /* renamed from: c  reason: collision with root package name */
    private final int f17274c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17275d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17276e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17277f;

    /* renamed from: b  reason: collision with root package name */
    public static final a f17273b = new a(null);
    public static final f a = g.a();

    /* compiled from: KotlinVersion.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(int i2, int i3, int i4) {
        this.f17275d = i2;
        this.f17276e = i3;
        this.f17277f = i4;
        this.f17274c = n(i2, i3, i4);
    }

    private final int n(int i2, int i3, int i4) {
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            return (i2 << 16) + (i3 << 8) + i4;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            obj = null;
        }
        f fVar = (f) obj;
        return fVar != null && this.f17274c == fVar.f17274c;
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(f other) {
        kotlin.jvm.internal.m.g(other, "other");
        return this.f17274c - other.f17274c;
    }

    public int hashCode() {
        return this.f17274c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f17275d);
        sb.append('.');
        sb.append(this.f17276e);
        sb.append('.');
        sb.append(this.f17277f);
        return sb.toString();
    }
}