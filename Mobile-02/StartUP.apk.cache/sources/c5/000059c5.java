package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ULong.kt */
/* loaded from: classes3.dex */
public final class v implements Comparable<v> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final long f17413b;

    /* compiled from: ULong.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ v(long j2) {
        this.f17413b = j2;
    }

    public static String A(long j2) {
        return z.e(j2);
    }

    public static final /* synthetic */ v h(long j2) {
        return new v(j2);
    }

    private int n(long j2) {
        return q(this.f17413b, j2);
    }

    private static int q(long j2, long j3) {
        return z.c(j2, j3);
    }

    public static long s(long j2) {
        return j2;
    }

    public static boolean y(long j2, Object obj) {
        return (obj instanceof v) && j2 == ((v) obj).B();
    }

    public static int z(long j2) {
        return (int) (j2 ^ (j2 >>> 32));
    }

    public final /* synthetic */ long B() {
        return this.f17413b;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(v vVar) {
        return n(vVar.B());
    }

    public boolean equals(Object obj) {
        return y(this.f17413b, obj);
    }

    public int hashCode() {
        return z(this.f17413b);
    }

    public String toString() {
        return A(this.f17413b);
    }
}