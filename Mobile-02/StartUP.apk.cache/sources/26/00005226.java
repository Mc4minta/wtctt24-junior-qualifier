package kotlin.j0;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KTypeProjection.kt */
/* loaded from: classes3.dex */
public final class s {

    /* renamed from: c  reason: collision with root package name */
    private final u f17295c;

    /* renamed from: d  reason: collision with root package name */
    private final q f17296d;

    /* renamed from: b  reason: collision with root package name */
    public static final a f17294b = new a(null);
    public static final s a = new s(null, null);

    /* compiled from: KTypeProjection.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final s a(q type) {
            kotlin.jvm.internal.m.g(type, "type");
            return new s(u.IN, type);
        }

        public final s b(q type) {
            kotlin.jvm.internal.m.g(type, "type");
            return new s(u.OUT, type);
        }

        public final s c() {
            return s.a;
        }

        public final s d(q type) {
            kotlin.jvm.internal.m.g(type, "type");
            return new s(u.INVARIANT, type);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public s(u uVar, q qVar) {
        String str;
        this.f17295c = uVar;
        this.f17296d = qVar;
        if ((uVar == null) == (qVar == null)) {
            return;
        }
        if (uVar == null) {
            str = "Star projection must have no type specified.";
        } else {
            str = "The projection variance " + uVar + " requires type to be specified.";
        }
        throw new IllegalArgumentException(str.toString());
    }

    public final u a() {
        return this.f17295c;
    }

    public final q b() {
        return this.f17296d;
    }

    public final q c() {
        return this.f17296d;
    }

    public final u d() {
        return this.f17295c;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof s) {
                s sVar = (s) obj;
                return kotlin.jvm.internal.m.c(this.f17295c, sVar.f17295c) && kotlin.jvm.internal.m.c(this.f17296d, sVar.f17296d);
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        u uVar = this.f17295c;
        int hashCode = (uVar != null ? uVar.hashCode() : 0) * 31;
        q qVar = this.f17296d;
        return hashCode + (qVar != null ? qVar.hashCode() : 0);
    }

    public String toString() {
        u uVar = this.f17295c;
        if (uVar == null) {
            return "*";
        }
        int i2 = t.a[uVar.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "in " + this.f17296d;
            } else if (i2 == 3) {
                return "out " + this.f17296d;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return String.valueOf(this.f17296d);
    }
}