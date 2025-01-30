package e.a.a.x;

/* compiled from: FileExtension.java */
/* loaded from: classes.dex */
public enum a {
    JSON(".json"),
    ZIP(".zip");
    

    /* renamed from: d  reason: collision with root package name */
    public final String f11915d;

    a(String str) {
        this.f11915d = str;
    }

    public String h() {
        return ".temp" + this.f11915d;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f11915d;
    }
}