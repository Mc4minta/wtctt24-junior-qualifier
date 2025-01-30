package com.google.firebase.remoteconfig.internal;

/* compiled from: com.google.firebase:firebase-config@@19.0.4 */
/* loaded from: classes2.dex */
public class n implements com.google.firebase.remoteconfig.f {
    private final long a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9458b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.remoteconfig.g f9459c;

    /* compiled from: com.google.firebase:firebase-config@@19.0.4 */
    /* loaded from: classes2.dex */
    public static class b {
        private long a;

        /* renamed from: b  reason: collision with root package name */
        private int f9460b;

        /* renamed from: c  reason: collision with root package name */
        private com.google.firebase.remoteconfig.g f9461c;

        public n a() {
            return new n(this.a, this.f9460b, this.f9461c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b b(com.google.firebase.remoteconfig.g gVar) {
            this.f9461c = gVar;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b c(int i2) {
            this.f9460b = i2;
            return this;
        }

        public b d(long j2) {
            this.a = j2;
            return this;
        }

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b b() {
        return new b();
    }

    @Override // com.google.firebase.remoteconfig.f
    public int a() {
        return this.f9458b;
    }

    private n(long j2, int i2, com.google.firebase.remoteconfig.g gVar) {
        this.a = j2;
        this.f9458b = i2;
        this.f9459c = gVar;
    }
}