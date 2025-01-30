package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.0 */
/* loaded from: classes2.dex */
final class j3 implements Comparator<h3> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(h3 h3Var, h3 h3Var2) {
        int t;
        int t2;
        h3 h3Var3 = h3Var;
        h3 h3Var4 = h3Var2;
        m3 m3Var = (m3) h3Var3.iterator();
        m3 m3Var2 = (m3) h3Var4.iterator();
        while (m3Var.hasNext() && m3Var2.hasNext()) {
            t = h3.t(m3Var.a());
            t2 = h3.t(m3Var2.a());
            int compare = Integer.compare(t, t2);
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(h3Var3.i(), h3Var4.i());
    }
}