package kotlin.h0;

import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Random.kt */
/* loaded from: classes3.dex */
public abstract class c {

    /* renamed from: b  reason: collision with root package name */
    public static final a f17279b = new a(null);
    private static final c a = kotlin.d0.b.a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes3.dex */
    public static final class a extends c implements Serializable {
        private a() {
        }

        @Override // kotlin.h0.c
        public int b(int i2) {
            return c.a.b(i2);
        }

        @Override // kotlin.h0.c
        public int c() {
            return c.a.c();
        }

        @Override // kotlin.h0.c
        public int d(int i2, int i3) {
            return c.a.d(i2, i3);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public abstract int b(int i2);

    public abstract int c();

    public int d(int i2, int i3) {
        int c2;
        int i4;
        int i5;
        d.b(i2, i3);
        int i6 = i3 - i2;
        if (i6 > 0 || i6 == Integer.MIN_VALUE) {
            if (((-i6) & i6) == i6) {
                i5 = b(d.c(i6));
            } else {
                do {
                    c2 = c() >>> 1;
                    i4 = c2 % i6;
                } while ((c2 - i4) + (i6 - 1) < 0);
                i5 = i4;
            }
            return i2 + i5;
        }
        while (true) {
            int c3 = c();
            if (i2 <= c3 && i3 > c3) {
                return c3;
            }
        }
    }
}