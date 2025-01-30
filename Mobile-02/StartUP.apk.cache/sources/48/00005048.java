package h.c.n0.j;

/* compiled from: Pow2.java */
/* loaded from: classes3.dex */
public final class p {
    public static int a(int i2) {
        return 1 << (32 - Integer.numberOfLeadingZeros(i2 - 1));
    }
}