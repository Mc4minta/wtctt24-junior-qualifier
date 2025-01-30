package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: UInt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087@\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0014\b\u0001\u0012\u0006\u0010\u0013\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\nJ\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u001c\u0010\u0013\u001a\u00020\u00038\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0011\u0010\u0012ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlin/UInt;", "", "other", "", "q", "(II)I", "", "A", "(I)Ljava/lang/String;", "z", "(I)I", "", "", "y", "(ILjava/lang/Object;)Z", "b", "I", "getData$annotations", "()V", "data", "s", "a", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class UInt implements Comparable<UInt> {
    public static final a a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final int f17203b;

    /* compiled from: UInt.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UInt(int i2) {
        this.f17203b = i2;
    }

    public static String A(int i2) {
        return String.valueOf(i2 & 4294967295L);
    }

    public static final /* synthetic */ UInt h(int i2) {
        return new UInt(i2);
    }

    private int n(int i2) {
        return q(this.f17203b, i2);
    }

    private static int q(int i2, int i3) {
        return z.a(i2, i3);
    }

    public static int s(int i2) {
        return i2;
    }

    public static boolean y(int i2, Object obj) {
        return (obj instanceof UInt) && i2 == ((UInt) obj).B();
    }

    public static int z(int i2) {
        return i2;
    }

    public final /* synthetic */ int B() {
        return this.f17203b;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return n(uInt.B());
    }

    public boolean equals(Object obj) {
        return y(this.f17203b, obj);
    }

    public int hashCode() {
        return z(this.f17203b);
    }

    public String toString() {
        return A(this.f17203b);
    }
}