package kotlin.reflect.full;

import kotlin.j0.u;

/* loaded from: classes3.dex */
public final /* synthetic */ class b {
    public static final /* synthetic */ int[] a;

    static {
        int[] iArr = new int[u.values().length];
        a = iArr;
        iArr[u.INVARIANT.ordinal()] = 1;
        iArr[u.IN.ordinal()] = 2;
        iArr[u.OUT.ordinal()] = 3;
    }
}