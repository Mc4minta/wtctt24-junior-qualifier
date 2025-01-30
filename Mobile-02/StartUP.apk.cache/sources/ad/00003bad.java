package com.google.firebase.remoteconfig;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class g {
    private final boolean a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9408b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9409c;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class b {
        private boolean a = false;

        /* renamed from: b  reason: collision with root package name */
        private long f9410b = 60;

        /* renamed from: c  reason: collision with root package name */
        private long f9411c = com.google.firebase.remoteconfig.internal.j.a;

        public g d() {
            return new g(this);
        }

        @Deprecated
        public b e(boolean z) {
            this.a = z;
            return this;
        }

        public b f(long j2) throws IllegalArgumentException {
            if (j2 >= 0) {
                this.f9410b = j2;
                return this;
            }
            throw new IllegalArgumentException(String.format("Fetch connection timeout has to be a non-negative number. %d is an invalid argument", Long.valueOf(j2)));
        }

        public b g(long j2) {
            if (j2 >= 0) {
                this.f9411c = j2;
                return this;
            }
            throw new IllegalArgumentException("Minimum interval between fetches has to be a non-negative number. " + j2 + " is an invalid argument");
        }
    }

    private g(b bVar) {
        this.a = bVar.a;
        this.f9408b = bVar.f9410b;
        this.f9409c = bVar.f9411c;
    }
}