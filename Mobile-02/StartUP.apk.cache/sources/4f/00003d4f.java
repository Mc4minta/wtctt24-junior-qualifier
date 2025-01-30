package com.google.zxing.t.r.g.e;

import com.google.zxing.FormatException;

/* compiled from: DecodedNumeric.java */
/* loaded from: classes2.dex */
final class p extends q {

    /* renamed from: b  reason: collision with root package name */
    private final int f10062b;

    /* renamed from: c  reason: collision with root package name */
    private final int f10063c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(int i2, int i3, int i4) throws FormatException {
        super(i2);
        if (i3 >= 0 && i3 <= 10 && i4 >= 0 && i4 <= 10) {
            this.f10062b = i3;
            this.f10063c = i4;
            return;
        }
        throw FormatException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        return this.f10062b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f10063c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f10062b == 10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.f10063c == 10;
    }
}