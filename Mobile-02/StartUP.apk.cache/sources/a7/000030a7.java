package com.google.android.datatransport.cct.b;

import com.google.android.datatransport.cct.b.a;

/* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
/* loaded from: classes2.dex */
final class c extends com.google.android.datatransport.cct.b.a {
    private final Integer a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5734b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5735c;

    /* renamed from: d  reason: collision with root package name */
    private final String f5736d;

    /* renamed from: e  reason: collision with root package name */
    private final String f5737e;

    /* renamed from: f  reason: collision with root package name */
    private final String f5738f;

    /* renamed from: g  reason: collision with root package name */
    private final String f5739g;

    /* renamed from: h  reason: collision with root package name */
    private final String f5740h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: com.google.android.datatransport:transport-backend-cct@@2.2.1 */
    /* loaded from: classes2.dex */
    public static final class b extends a.AbstractC0131a {
        private Integer a;

        /* renamed from: b  reason: collision with root package name */
        private String f5741b;

        /* renamed from: c  reason: collision with root package name */
        private String f5742c;

        /* renamed from: d  reason: collision with root package name */
        private String f5743d;

        /* renamed from: e  reason: collision with root package name */
        private String f5744e;

        /* renamed from: f  reason: collision with root package name */
        private String f5745f;

        /* renamed from: g  reason: collision with root package name */
        private String f5746g;

        /* renamed from: h  reason: collision with root package name */
        private String f5747h;

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a a(Integer num) {
            this.a = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a b(String str) {
            this.f5743d = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public com.google.android.datatransport.cct.b.a c() {
            return new c(this.a, this.f5741b, this.f5742c, this.f5743d, this.f5744e, this.f5745f, this.f5746g, this.f5747h, null);
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a d(String str) {
            this.f5747h = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a e(String str) {
            this.f5742c = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a f(String str) {
            this.f5746g = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a g(String str) {
            this.f5741b = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a h(String str) {
            this.f5745f = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.b.a.AbstractC0131a
        public a.AbstractC0131a i(String str) {
            this.f5744e = str;
            return this;
        }
    }

    /* synthetic */ c(Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, a aVar) {
        this.a = num;
        this.f5734b = str;
        this.f5735c = str2;
        this.f5736d = str3;
        this.f5737e = str4;
        this.f5738f = str5;
        this.f5739g = str6;
        this.f5740h = str7;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String b() {
        return this.f5736d;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String c() {
        return this.f5740h;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String d() {
        return this.f5735c;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String e() {
        return this.f5739g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof com.google.android.datatransport.cct.b.a) {
            Integer num = this.a;
            if (num != null ? num.equals(((c) obj).a) : ((c) obj).a == null) {
                String str = this.f5734b;
                if (str != null ? str.equals(((c) obj).f5734b) : ((c) obj).f5734b == null) {
                    String str2 = this.f5735c;
                    if (str2 != null ? str2.equals(((c) obj).f5735c) : ((c) obj).f5735c == null) {
                        String str3 = this.f5736d;
                        if (str3 != null ? str3.equals(((c) obj).f5736d) : ((c) obj).f5736d == null) {
                            String str4 = this.f5737e;
                            if (str4 != null ? str4.equals(((c) obj).f5737e) : ((c) obj).f5737e == null) {
                                String str5 = this.f5738f;
                                if (str5 != null ? str5.equals(((c) obj).f5738f) : ((c) obj).f5738f == null) {
                                    String str6 = this.f5739g;
                                    if (str6 != null ? str6.equals(((c) obj).f5739g) : ((c) obj).f5739g == null) {
                                        String str7 = this.f5740h;
                                        if (str7 == null) {
                                            if (((c) obj).f5740h == null) {
                                                return true;
                                            }
                                        } else if (str7.equals(((c) obj).f5740h)) {
                                            return true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String f() {
        return this.f5734b;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String g() {
        return this.f5738f;
    }

    @Override // com.google.android.datatransport.cct.b.a
    public String h() {
        return this.f5737e;
    }

    public int hashCode() {
        Integer num = this.a;
        int hashCode = ((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003;
        String str = this.f5734b;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f5735c;
        int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.f5736d;
        int hashCode4 = (hashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.f5737e;
        int hashCode5 = (hashCode4 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
        String str5 = this.f5738f;
        int hashCode6 = (hashCode5 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
        String str6 = this.f5739g;
        int hashCode7 = (hashCode6 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
        String str7 = this.f5740h;
        return hashCode7 ^ (str7 != null ? str7.hashCode() : 0);
    }

    @Override // com.google.android.datatransport.cct.b.a
    public Integer i() {
        return this.a;
    }

    public String toString() {
        return "AndroidClientInfo{sdkVersion=" + this.a + ", model=" + this.f5734b + ", hardware=" + this.f5735c + ", device=" + this.f5736d + ", product=" + this.f5737e + ", osBuild=" + this.f5738f + ", manufacturer=" + this.f5739g + ", fingerprint=" + this.f5740h + "}";
    }
}