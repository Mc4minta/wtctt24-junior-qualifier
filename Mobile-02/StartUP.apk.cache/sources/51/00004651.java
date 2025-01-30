package e.f.j.i;

import com.lwansbrough.RCTCamera.RCTCameraModule;

/* compiled from: ImmutableQualityInfo.java */
/* loaded from: classes2.dex */
public class f implements g {
    public static final g a = d(RCTCameraModule.RCT_CAMERA_ORIENTATION_AUTO, true, true);

    /* renamed from: b  reason: collision with root package name */
    int f12578b;

    /* renamed from: c  reason: collision with root package name */
    boolean f12579c;

    /* renamed from: d  reason: collision with root package name */
    boolean f12580d;

    private f(int i2, boolean z, boolean z2) {
        this.f12578b = i2;
        this.f12579c = z;
        this.f12580d = z2;
    }

    public static g d(int i2, boolean z, boolean z2) {
        return new f(i2, z, z2);
    }

    @Override // e.f.j.i.g
    public boolean a() {
        return this.f12580d;
    }

    @Override // e.f.j.i.g
    public boolean b() {
        return this.f12579c;
    }

    @Override // e.f.j.i.g
    public int c() {
        return this.f12578b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f12578b == fVar.f12578b && this.f12579c == fVar.f12579c && this.f12580d == fVar.f12580d;
        }
        return false;
    }

    public int hashCode() {
        return (this.f12578b ^ (this.f12579c ? 4194304 : 0)) ^ (this.f12580d ? 8388608 : 0);
    }
}