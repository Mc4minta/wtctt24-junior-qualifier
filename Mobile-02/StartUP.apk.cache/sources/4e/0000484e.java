package e.g.a.e.h;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.r;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
/* loaded from: classes2.dex */
public final class a implements a.d {
    public static final a a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13192b = false;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13193c = false;

    /* renamed from: d  reason: collision with root package name */
    private final String f13194d = null;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f13195e = false;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f13198h = false;

    /* renamed from: f  reason: collision with root package name */
    private final String f13196f = null;

    /* renamed from: g  reason: collision with root package name */
    private final String f13197g = null;

    /* renamed from: j  reason: collision with root package name */
    private final Long f13199j = null;

    /* renamed from: k  reason: collision with root package name */
    private final Long f13200k = null;

    /* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
    /* renamed from: e.g.a.e.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0302a {
    }

    static {
        new C0302a();
        a = new a(false, false, null, false, null, null, false, null, null);
    }

    private a(boolean z, boolean z2, String str, boolean z3, String str2, String str3, boolean z4, Long l2, Long l3) {
    }

    public final Long a() {
        return this.f13199j;
    }

    public final String b() {
        return this.f13196f;
    }

    public final String c() {
        return this.f13197g;
    }

    public final Long d() {
        return this.f13200k;
    }

    public final String e() {
        return this.f13194d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f13192b == aVar.f13192b && this.f13193c == aVar.f13193c && r.a(this.f13194d, aVar.f13194d) && this.f13195e == aVar.f13195e && this.f13198h == aVar.f13198h && r.a(this.f13196f, aVar.f13196f) && r.a(this.f13197g, aVar.f13197g) && r.a(this.f13199j, aVar.f13199j) && r.a(this.f13200k, aVar.f13200k);
        }
        return false;
    }

    public final boolean f() {
        return this.f13195e;
    }

    public final boolean g() {
        return this.f13193c;
    }

    public final boolean h() {
        return this.f13192b;
    }

    public final int hashCode() {
        return r.b(Boolean.valueOf(this.f13192b), Boolean.valueOf(this.f13193c), this.f13194d, Boolean.valueOf(this.f13195e), Boolean.valueOf(this.f13198h), this.f13196f, this.f13197g, this.f13199j, this.f13200k);
    }

    public final boolean i() {
        return this.f13198h;
    }
}