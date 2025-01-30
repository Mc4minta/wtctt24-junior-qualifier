package com.google.zxing.t.r.g.e;

/* compiled from: DecodedInformation.java */
/* loaded from: classes2.dex */
final class o extends q {

    /* renamed from: b  reason: collision with root package name */
    private final String f10059b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10060c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f10061d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i2, String str) {
        super(i2);
        this.f10059b = str;
        this.f10061d = false;
        this.f10060c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f10059b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f10060c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f10061d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(int i2, String str, int i3) {
        super(i2);
        this.f10061d = true;
        this.f10060c = i3;
        this.f10059b = str;
    }
}