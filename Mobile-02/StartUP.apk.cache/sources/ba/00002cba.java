package com.facebook.imagepipeline.memory;

/* compiled from: MemoryChunkUtil.java */
/* loaded from: classes2.dex */
public class v {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i2, int i3, int i4) {
        return Math.min(Math.max(0, i4 - i2), i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i2, int i3, int i4, int i5, int i6) {
        e.f.d.c.i.b(i5 >= 0);
        e.f.d.c.i.b(i2 >= 0);
        e.f.d.c.i.b(i4 >= 0);
        e.f.d.c.i.b(i2 + i5 <= i6);
        e.f.d.c.i.b(i4 + i5 <= i3);
    }
}