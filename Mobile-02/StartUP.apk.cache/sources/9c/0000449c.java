package e.a.a.w;

/* compiled from: DocumentData.java */
/* loaded from: classes.dex */
public class b {
    public final String a;

    /* renamed from: b  reason: collision with root package name */
    public final String f11741b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11742c;

    /* renamed from: d  reason: collision with root package name */
    public final a f11743d;

    /* renamed from: e  reason: collision with root package name */
    public final int f11744e;

    /* renamed from: f  reason: collision with root package name */
    public final float f11745f;

    /* renamed from: g  reason: collision with root package name */
    public final float f11746g;

    /* renamed from: h  reason: collision with root package name */
    public final int f11747h;

    /* renamed from: i  reason: collision with root package name */
    public final int f11748i;

    /* renamed from: j  reason: collision with root package name */
    public final float f11749j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f11750k;

    /* compiled from: DocumentData.java */
    /* loaded from: classes.dex */
    public enum a {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public b(String str, String str2, float f2, a aVar, int i2, float f3, float f4, int i3, int i4, float f5, boolean z) {
        this.a = str;
        this.f11741b = str2;
        this.f11742c = f2;
        this.f11743d = aVar;
        this.f11744e = i2;
        this.f11745f = f3;
        this.f11746g = f4;
        this.f11747h = i3;
        this.f11748i = i4;
        this.f11749j = f5;
        this.f11750k = z;
    }

    public int hashCode() {
        int hashCode = (((((int) ((((this.a.hashCode() * 31) + this.f11741b.hashCode()) * 31) + this.f11742c)) * 31) + this.f11743d.ordinal()) * 31) + this.f11744e;
        long floatToRawIntBits = Float.floatToRawIntBits(this.f11745f);
        return (((hashCode * 31) + ((int) (floatToRawIntBits ^ (floatToRawIntBits >>> 32)))) * 31) + this.f11747h;
    }
}