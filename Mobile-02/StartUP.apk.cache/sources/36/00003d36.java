package com.google.zxing.t.r;

/* compiled from: DataCharacter.java */
/* loaded from: classes2.dex */
public class b {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f10028b;

    public b(int i2, int i3) {
        this.a = i2;
        this.f10028b = i3;
    }

    public final int a() {
        return this.f10028b;
    }

    public final int b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            return this.a == bVar.a && this.f10028b == bVar.f10028b;
        }
        return false;
    }

    public final int hashCode() {
        return this.a ^ this.f10028b;
    }

    public final String toString() {
        return this.a + "(" + this.f10028b + ')';
    }
}