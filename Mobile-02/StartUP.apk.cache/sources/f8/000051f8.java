package kotlin.i0;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Ranges.kt */
/* loaded from: classes3.dex */
public final class c extends kotlin.i0.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f17287f = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final c f17286e = new c(1, 0);

    /* compiled from: Ranges.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final c a() {
            return c.f17286e;
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // kotlin.i0.a
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (i() != cVar.i() || k() != cVar.k()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // kotlin.i0.a
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (i() * 31) + k();
    }

    @Override // kotlin.i0.a
    public boolean isEmpty() {
        return i() > k();
    }

    public boolean p(int i2) {
        return i() <= i2 && i2 <= k();
    }

    public Integer q() {
        return Integer.valueOf(k());
    }

    public Integer r() {
        return Integer.valueOf(i());
    }

    @Override // kotlin.i0.a
    public String toString() {
        return i() + ".." + k();
    }
}