package com.facebook.yoga;

/* compiled from: YogaValue.java */
/* loaded from: classes2.dex */
public class v {
    static final v a = new v(Float.NaN, u.UNDEFINED);

    /* renamed from: b  reason: collision with root package name */
    static final v f5719b = new v(0.0f, u.POINT);

    /* renamed from: c  reason: collision with root package name */
    static final v f5720c = new v(Float.NaN, u.AUTO);

    /* renamed from: d  reason: collision with root package name */
    public final float f5721d;

    /* renamed from: e  reason: collision with root package name */
    public final u f5722e;

    /* compiled from: YogaValue.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[u.values().length];
            a = iArr;
            try {
                iArr[u.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[u.POINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[u.PERCENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[u.AUTO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public v(float f2, u uVar) {
        this.f5721d = f2;
        this.f5722e = uVar;
    }

    public boolean equals(Object obj) {
        if (obj instanceof v) {
            v vVar = (v) obj;
            u uVar = this.f5722e;
            if (uVar == vVar.f5722e) {
                return uVar == u.UNDEFINED || uVar == u.AUTO || Float.compare(this.f5721d, vVar.f5721d) == 0;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.f5721d) + this.f5722e.n();
    }

    public String toString() {
        int i2 = a.a[this.f5722e.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return "auto";
                    }
                    throw new IllegalStateException();
                }
                return this.f5721d + "%";
            }
            return Float.toString(this.f5721d);
        }
        return "undefined";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(float f2, int i2) {
        this(f2, u.h(i2));
    }
}