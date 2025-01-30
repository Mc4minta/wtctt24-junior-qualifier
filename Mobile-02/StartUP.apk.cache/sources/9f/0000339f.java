package com.google.android.gms.internal.p000firebaseperf;

import java.util.Comparator;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* renamed from: com.google.android.gms.internal.firebase-perf.k3  reason: invalid package */
/* loaded from: classes2.dex */
final class k3 implements Comparator<i3> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(i3 i3Var, i3 i3Var2) {
        int h2;
        int h3;
        i3 i3Var3 = i3Var;
        i3 i3Var4 = i3Var2;
        r3 r3Var = (r3) i3Var3.iterator();
        r3 r3Var2 = (r3) i3Var4.iterator();
        while (r3Var.hasNext() && r3Var2.hasNext()) {
            h2 = i3.h(r3Var.nextByte());
            h3 = i3.h(r3Var2.nextByte());
            int compare = Integer.compare(h2, h3);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(i3Var3.size(), i3Var4.size());
    }
}