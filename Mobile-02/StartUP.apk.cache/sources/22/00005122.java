package j.h0;

import j.b0;
import kotlin.jvm.internal.m;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final int a(int[] binarySearch, int i2, int i3, int i4) {
        m.g(binarySearch, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = binarySearch[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else if (i7 <= i2) {
                return i6;
            } else {
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final int b(b0 segment, int i2) {
        m.g(segment, "$this$segment");
        int a = a(segment.W(), i2 + 1, 0, segment.X().length);
        return a >= 0 ? a : ~a;
    }
}