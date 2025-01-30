package kotlinx.coroutines.i1;

import kotlinx.coroutines.i1.a;

/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[a.c.values().length];
        a = iArr;
        iArr[a.c.PARKING.ordinal()] = 1;
        iArr[a.c.BLOCKING.ordinal()] = 2;
        iArr[a.c.CPU_ACQUIRED.ordinal()] = 3;
        iArr[a.c.DORMANT.ordinal()] = 4;
        iArr[a.c.TERMINATED.ordinal()] = 5;
    }
}