package e.j.l.p;

import kotlin.jvm.internal.m;

/* compiled from: CryptoErrorUtil.kt */
/* loaded from: classes2.dex */
final class f {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f13729b;

    /* renamed from: c  reason: collision with root package name */
    private final String f13730c;

    /* renamed from: d  reason: collision with root package name */
    private final String f13731d;

    /* renamed from: e  reason: collision with root package name */
    private final Boolean f13732e;

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f13733f;

    /* renamed from: g  reason: collision with root package name */
    private final Boolean f13734g;

    public f(String str, Integer num, String str2, String str3, Boolean bool, Boolean bool2, Boolean bool3) {
        this.a = str;
        this.f13729b = num;
        this.f13730c = str2;
        this.f13731d = str3;
        this.f13732e = bool;
        this.f13733f = bool2;
        this.f13734g = bool3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return m.c(this.a, fVar.a) && m.c(this.f13729b, fVar.f13729b) && m.c(this.f13730c, fVar.f13730c) && m.c(this.f13731d, fVar.f13731d) && m.c(this.f13732e, fVar.f13732e) && m.c(this.f13733f, fVar.f13733f) && m.c(this.f13734g, fVar.f13734g);
        }
        return false;
    }

    public int hashCode() {
        String str = this.a;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f13729b;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.f13730c;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f13731d;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Boolean bool = this.f13732e;
        int hashCode5 = (hashCode4 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.f13733f;
        int hashCode6 = (hashCode5 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.f13734g;
        return hashCode6 + (bool3 != null ? bool3.hashCode() : 0);
    }

    public String toString() {
        return "Info(algorithm=" + ((Object) this.a) + ", blockSize=" + this.f13729b + ", providerName=" + ((Object) this.f13730c) + ", authenticationMethod=" + ((Object) this.f13731d) + ", hasOnboarded=" + this.f13732e + ", hasBackedUpPhrase=" + this.f13733f + ", hasSignedOut=" + this.f13734g + ')';
    }
}