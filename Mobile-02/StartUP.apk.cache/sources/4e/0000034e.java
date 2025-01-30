package androidx.navigation;

import android.os.Bundle;

/* compiled from: NavArgument.java */
/* loaded from: classes.dex */
public final class d {
    private final q a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f1845b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f1846c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f1847d;

    /* compiled from: NavArgument.java */
    /* loaded from: classes.dex */
    public static final class a {
        private q<?> a;

        /* renamed from: c  reason: collision with root package name */
        private Object f1849c;

        /* renamed from: b  reason: collision with root package name */
        private boolean f1848b = false;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1850d = false;

        public d a() {
            if (this.a == null) {
                this.a = q.e(this.f1849c);
            }
            return new d(this.a, this.f1848b, this.f1849c, this.f1850d);
        }

        public a b(Object obj) {
            this.f1849c = obj;
            this.f1850d = true;
            return this;
        }

        public a c(boolean z) {
            this.f1848b = z;
            return this;
        }

        public a d(q<?> qVar) {
            this.a = qVar;
            return this;
        }
    }

    d(q<?> qVar, boolean z, Object obj, boolean z2) {
        if (!qVar.f() && z) {
            throw new IllegalArgumentException(qVar.c() + " does not allow nullable values");
        } else if (!z && z2 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + qVar.c() + " has null value but is not nullable.");
        } else {
            this.a = qVar;
            this.f1845b = z;
            this.f1847d = obj;
            this.f1846c = z2;
        }
    }

    public Object a() {
        return this.f1847d;
    }

    public q<?> b() {
        return this.a;
    }

    public boolean c() {
        return this.f1846c;
    }

    public boolean d() {
        return this.f1845b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(String str, Bundle bundle) {
        if (this.f1846c) {
            this.a.i(bundle, str, this.f1847d);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.f1845b == dVar.f1845b && this.f1846c == dVar.f1846c && this.a.equals(dVar.a)) {
            Object obj2 = this.f1847d;
            return obj2 != null ? obj2.equals(dVar.f1847d) : dVar.f1847d == null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean f(String str, Bundle bundle) {
        if (!this.f1845b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.a.b(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        int hashCode = ((((this.a.hashCode() * 31) + (this.f1845b ? 1 : 0)) * 31) + (this.f1846c ? 1 : 0)) * 31;
        Object obj = this.f1847d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }
}