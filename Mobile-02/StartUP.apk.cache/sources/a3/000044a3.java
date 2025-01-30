package e.a.a.w;

/* compiled from: Marker.java */
/* loaded from: classes.dex */
public class h {
    private static String a = "\r";

    /* renamed from: b  reason: collision with root package name */
    private final String f11765b;

    /* renamed from: c  reason: collision with root package name */
    public final float f11766c;

    /* renamed from: d  reason: collision with root package name */
    public final float f11767d;

    public h(String str, float f2, float f3) {
        this.f11765b = str;
        this.f11767d = f3;
        this.f11766c = f2;
    }

    public boolean a(String str) {
        if (this.f11765b.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f11765b.endsWith(a)) {
            String str2 = this.f11765b;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}