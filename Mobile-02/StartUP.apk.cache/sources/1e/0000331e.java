package com.google.android.gms.internal.clearcut;

/* loaded from: classes2.dex */
final class y2 {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private int f6654b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(String str) {
        this.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean a() {
        return this.f6654b < this.a.length();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        String str = this.a;
        int i2 = this.f6654b;
        this.f6654b = i2 + 1;
        char charAt = str.charAt(i2);
        if (charAt < 55296) {
            return charAt;
        }
        int i3 = charAt & 8191;
        int i4 = 13;
        while (true) {
            String str2 = this.a;
            int i5 = this.f6654b;
            this.f6654b = i5 + 1;
            char charAt2 = str2.charAt(i5);
            if (charAt2 < 55296) {
                return i3 | (charAt2 << i4);
            }
            i3 |= (charAt2 & 8191) << i4;
            i4 += 13;
        }
    }
}