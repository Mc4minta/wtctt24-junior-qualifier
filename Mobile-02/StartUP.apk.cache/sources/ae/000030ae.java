package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.l;
import java.util.Arrays;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class f extends l {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f5750b;

    /* renamed from: c  reason: collision with root package name */
    private final long f5751c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f5752d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5753e;

    /* renamed from: f  reason: collision with root package name */
    private final long f5754f;

    /* renamed from: g  reason: collision with root package name */
    private final o f5755g;

    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    static final class b extends l.a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f5756b;

        /* renamed from: c  reason: collision with root package name */
        private Long f5757c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f5758d;

        /* renamed from: e  reason: collision with root package name */
        private String f5759e;

        /* renamed from: f  reason: collision with root package name */
        private Long f5760f;

        /* renamed from: g  reason: collision with root package name */
        private o f5761g;

        @Override // com.google.android.datatransport.cct.b.l.a
        public l.a a(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        public l.a b(o oVar) {
            this.f5761g = oVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        public l.a c(Integer num) {
            this.f5756b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        l.a d(String str) {
            this.f5759e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        l.a e(byte[] bArr) {
            this.f5758d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        public l f() {
            String str = "";
            if (this.a == null) {
                str = " eventTimeMs";
            }
            if (this.f5757c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f5760f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new f(this.a.longValue(), this.f5756b, this.f5757c.longValue(), this.f5758d, this.f5759e, this.f5760f.longValue(), this.f5761g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        public l.a g(long j2) {
            this.f5757c = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.l.a
        public l.a h(long j2) {
            this.f5760f = Long.valueOf(j2);
            return this;
        }
    }

    /* synthetic */ f(long j2, Integer num, long j3, byte[] bArr, String str, long j4, o oVar, a aVar) {
        this.a = j2;
        this.f5750b = num;
        this.f5751c = j3;
        this.f5752d = bArr;
        this.f5753e = str;
        this.f5754f = j4;
        this.f5755g = oVar;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public Integer c() {
        return this.f5750b;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public long d() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public long e() {
        return this.f5751c;
    }

    public boolean equals(Object obj) {
        Integer num;
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a == lVar.d() && ((num = this.f5750b) != null ? num.equals(((f) lVar).f5750b) : ((f) lVar).f5750b == null) && this.f5751c == lVar.e()) {
                if (Arrays.equals(this.f5752d, lVar instanceof f ? ((f) lVar).f5752d : lVar.g()) && ((str = this.f5753e) != null ? str.equals(((f) lVar).f5753e) : ((f) lVar).f5753e == null) && this.f5754f == lVar.i()) {
                    o oVar = this.f5755g;
                    if (oVar == null) {
                        if (((f) lVar).f5755g == null) {
                            return true;
                        }
                    } else if (oVar.equals(((f) lVar).f5755g)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public o f() {
        return this.f5755g;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public byte[] g() {
        return this.f5752d;
    }

    @Override // com.google.android.datatransport.cct.b.l
    public String h() {
        return this.f5753e;
    }

    public int hashCode() {
        long j2 = this.a;
        int i2 = (((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f5750b;
        int hashCode = num == null ? 0 : num.hashCode();
        long j3 = this.f5751c;
        int hashCode2 = (((((i2 ^ hashCode) * 1000003) ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f5752d)) * 1000003;
        String str = this.f5753e;
        int hashCode3 = str == null ? 0 : str.hashCode();
        long j4 = this.f5754f;
        int i3 = (((hashCode2 ^ hashCode3) * 1000003) ^ ((int) ((j4 >>> 32) ^ j4))) * 1000003;
        o oVar = this.f5755g;
        return i3 ^ (oVar != null ? oVar.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.b.l
    public long i() {
        return this.f5754f;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.a + ", eventCode=" + this.f5750b + ", eventUptimeMs=" + this.f5751c + ", sourceExtension=" + Arrays.toString(this.f5752d) + ", sourceExtensionJsonProto3=" + this.f5753e + ", timezoneOffsetSeconds=" + this.f5754f + ", networkConnectionInfo=" + this.f5755g + "}";
    }
}