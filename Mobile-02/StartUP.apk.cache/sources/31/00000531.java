package c.h.e;

import android.graphics.Insets;
import android.graphics.Rect;

/* compiled from: Insets.java */
/* loaded from: classes.dex */
public final class b {
    public static final b a = new b(0, 0, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    public final int f2925b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2926c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2927d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2928e;

    private b(int i2, int i3, int i4, int i5) {
        this.f2925b = i2;
        this.f2926c = i3;
        this.f2927d = i4;
        this.f2928e = i5;
    }

    public static b a(b bVar, b bVar2) {
        return b(Math.max(bVar.f2925b, bVar2.f2925b), Math.max(bVar.f2926c, bVar2.f2926c), Math.max(bVar.f2927d, bVar2.f2927d), Math.max(bVar.f2928e, bVar2.f2928e));
    }

    public static b b(int i2, int i3, int i4, int i5) {
        if (i2 == 0 && i3 == 0 && i4 == 0 && i5 == 0) {
            return a;
        }
        return new b(i2, i3, i4, i5);
    }

    public static b c(Rect rect) {
        return b(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static b d(Insets insets) {
        return b(insets.left, insets.top, insets.right, insets.bottom);
    }

    public Insets e() {
        return Insets.of(this.f2925b, this.f2926c, this.f2927d, this.f2928e);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2928e == bVar.f2928e && this.f2925b == bVar.f2925b && this.f2927d == bVar.f2927d && this.f2926c == bVar.f2926c;
    }

    public int hashCode() {
        return (((((this.f2925b * 31) + this.f2926c) * 31) + this.f2927d) * 31) + this.f2928e;
    }

    public String toString() {
        return "Insets{left=" + this.f2925b + ", top=" + this.f2926c + ", right=" + this.f2927d + ", bottom=" + this.f2928e + '}';
    }
}