package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: Ι  reason: contains not printable characters */
    private boolean f302;

    /* renamed from: ι  reason: contains not printable characters */
    public String f303;

    /* loaded from: classes.dex */
    enum e {
        GOOGLE(0),
        AMAZON(1);
        

        /* renamed from: Ι  reason: contains not printable characters */
        private int f307;

        e(int i2) {
            this.f307 = i2;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return String.valueOf(this.f307);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(String str, boolean z) {
        this.f303 = str;
        this.f302 = z;
    }

    public final String toString() {
        return String.format("%s,%s", this.f303, Boolean.valueOf(this.f302));
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    public final boolean m200() {
        return this.f302;
    }
}