package kotlin.i0;

import kotlin.a0.h0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Progressions.kt */
/* loaded from: classes3.dex */
public class a implements Iterable<Integer>, kotlin.jvm.internal.n0.a {
    public static final C0416a a = new C0416a(null);

    /* renamed from: b  reason: collision with root package name */
    private final int f17280b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17281c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17282d;

    /* compiled from: Progressions.kt */
    /* renamed from: kotlin.i0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0416a {
        private C0416a() {
        }

        public final a a(int i2, int i3, int i4) {
            return new a(i2, i3, i4);
        }

        public /* synthetic */ C0416a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i4 != Integer.MIN_VALUE) {
            this.f17280b = i2;
            this.f17281c = kotlin.d0.c.b(i2, i3, i4);
            this.f17282d = i4;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            if (!isEmpty() || !((a) obj).isEmpty()) {
                a aVar = (a) obj;
                if (this.f17280b != aVar.f17280b || this.f17281c != aVar.f17281c || this.f17282d != aVar.f17282d) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f17280b * 31) + this.f17281c) * 31) + this.f17282d;
    }

    public final int i() {
        return this.f17280b;
    }

    public boolean isEmpty() {
        if (this.f17282d > 0) {
            if (this.f17280b > this.f17281c) {
                return true;
            }
        } else if (this.f17280b < this.f17281c) {
            return true;
        }
        return false;
    }

    public final int k() {
        return this.f17281c;
    }

    public final int l() {
        return this.f17282d;
    }

    @Override // java.lang.Iterable
    /* renamed from: m */
    public h0 iterator() {
        return new b(this.f17280b, this.f17281c, this.f17282d);
    }

    public String toString() {
        StringBuilder sb;
        int i2;
        if (this.f17282d > 0) {
            sb = new StringBuilder();
            sb.append(this.f17280b);
            sb.append("..");
            sb.append(this.f17281c);
            sb.append(" step ");
            i2 = this.f17282d;
        } else {
            sb = new StringBuilder();
            sb.append(this.f17280b);
            sb.append(" downTo ");
            sb.append(this.f17281c);
            sb.append(" step ");
            i2 = -this.f17282d;
        }
        sb.append(i2);
        return sb.toString();
    }
}