package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.m;
import java.util.List;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class g extends m {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final long f5762b;

    /* renamed from: c  reason: collision with root package name */
    private final k f5763c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f5764d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5765e;

    /* renamed from: f  reason: collision with root package name */
    private final List<l> f5766f;

    /* renamed from: g  reason: collision with root package name */
    private final p f5767g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b extends m.a {
        private Long a;

        /* renamed from: b  reason: collision with root package name */
        private Long f5768b;

        /* renamed from: c  reason: collision with root package name */
        private k f5769c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f5770d;

        /* renamed from: e  reason: collision with root package name */
        private String f5771e;

        /* renamed from: f  reason: collision with root package name */
        private List<l> f5772f;

        /* renamed from: g  reason: collision with root package name */
        private p f5773g;

        @Override // com.google.android.datatransport.cct.b.m.a
        public m.a b(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        public m.a c(k kVar) {
            this.f5769c = kVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        public m.a d(p pVar) {
            this.f5773g = pVar;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        m.a e(Integer num) {
            this.f5770d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        m.a f(String str) {
            this.f5771e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        public m.a g(List<l> list) {
            this.f5772f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        public m h() {
            String str = "";
            if (this.a == null) {
                str = " requestTimeMs";
            }
            if (this.f5768b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new g(this.a.longValue(), this.f5768b.longValue(), this.f5769c, this.f5770d, this.f5771e, this.f5772f, this.f5773g, null);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.b.m.a
        public m.a i(long j2) {
            this.f5768b = Long.valueOf(j2);
            return this;
        }
    }

    /* synthetic */ g(long j2, long j3, k kVar, Integer num, String str, List list, p pVar, a aVar) {
        this.a = j2;
        this.f5762b = j3;
        this.f5763c = kVar;
        this.f5764d = num;
        this.f5765e = str;
        this.f5766f = list;
        this.f5767g = pVar;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public k b() {
        return this.f5763c;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public List<l> c() {
        return this.f5766f;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public Integer d() {
        return this.f5764d;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public String e() {
        return this.f5765e;
    }

    public boolean equals(Object obj) {
        k kVar;
        Integer num;
        String str;
        List<l> list;
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            m mVar = (m) obj;
            if (this.a == mVar.g() && this.f5762b == mVar.h() && ((kVar = this.f5763c) != null ? kVar.equals(((g) mVar).f5763c) : ((g) mVar).f5763c == null) && ((num = this.f5764d) != null ? num.equals(((g) mVar).f5764d) : ((g) mVar).f5764d == null) && ((str = this.f5765e) != null ? str.equals(((g) mVar).f5765e) : ((g) mVar).f5765e == null) && ((list = this.f5766f) != null ? list.equals(((g) mVar).f5766f) : ((g) mVar).f5766f == null)) {
                p pVar = this.f5767g;
                if (pVar == null) {
                    if (((g) mVar).f5767g == null) {
                        return true;
                    }
                } else if (pVar.equals(((g) mVar).f5767g)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public p f() {
        return this.f5767g;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public long g() {
        return this.a;
    }

    @Override // com.google.android.datatransport.cct.b.m
    public long h() {
        return this.f5762b;
    }

    public int hashCode() {
        long j2 = this.a;
        long j3 = this.f5762b;
        int i2 = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j3 >>> 32) ^ j3))) * 1000003;
        k kVar = this.f5763c;
        int hashCode = (i2 ^ (kVar == null ? 0 : kVar.hashCode())) * 1000003;
        Integer num = this.f5764d;
        int hashCode2 = (hashCode ^ (num == null ? 0 : num.hashCode())) * 1000003;
        String str = this.f5765e;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        List<l> list = this.f5766f;
        int hashCode4 = (hashCode3 ^ (list == null ? 0 : list.hashCode())) * 1000003;
        p pVar = this.f5767g;
        return hashCode4 ^ (pVar != null ? pVar.hashCode() : 0);
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.a + ", requestUptimeMs=" + this.f5762b + ", clientInfo=" + this.f5763c + ", logSource=" + this.f5764d + ", logSourceName=" + this.f5765e + ", logEvents=" + this.f5766f + ", qosTier=" + this.f5767g + "}";
    }
}