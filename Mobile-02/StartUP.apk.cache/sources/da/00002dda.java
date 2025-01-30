package com.facebook.react.common;

/* compiled from: LongArray.java */
/* loaded from: classes2.dex */
public class b {
    private long[] a;

    /* renamed from: b  reason: collision with root package name */
    private int f4786b = 0;

    private b(int i2) {
        this.a = new long[i2];
    }

    public static b b(int i2) {
        return new b(i2);
    }

    private void e() {
        int i2 = this.f4786b;
        if (i2 == this.a.length) {
            long[] jArr = new long[Math.max(i2 + 1, (int) (i2 * 1.8d))];
            System.arraycopy(this.a, 0, jArr, 0, this.f4786b);
            this.a = jArr;
        }
    }

    public void a(long j2) {
        e();
        long[] jArr = this.a;
        int i2 = this.f4786b;
        this.f4786b = i2 + 1;
        jArr[i2] = j2;
    }

    public void c(int i2) {
        int i3 = this.f4786b;
        if (i2 <= i3) {
            this.f4786b = i3 - i2;
            return;
        }
        throw new IndexOutOfBoundsException("Trying to drop " + i2 + " items from array of length " + this.f4786b);
    }

    public long d(int i2) {
        if (i2 < this.f4786b) {
            return this.a[i2];
        }
        throw new IndexOutOfBoundsException("" + i2 + " >= " + this.f4786b);
    }

    public void f(int i2, long j2) {
        if (i2 < this.f4786b) {
            this.a[i2] = j2;
            return;
        }
        throw new IndexOutOfBoundsException("" + i2 + " >= " + this.f4786b);
    }

    public int g() {
        return this.f4786b;
    }
}