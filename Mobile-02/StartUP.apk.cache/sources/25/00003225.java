package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class StatsEvent extends com.google.android.gms.common.internal.safeparcel.a implements ReflectedParcelable {
    public abstract int i1();

    public abstract long j1();

    public abstract long k1();

    public abstract String l1();

    public String toString() {
        long j1 = j1();
        int i1 = i1();
        long k1 = k1();
        String l1 = l1();
        StringBuilder sb = new StringBuilder(String.valueOf(l1).length() + 53);
        sb.append(j1);
        sb.append("\t");
        sb.append(i1);
        sb.append("\t");
        sb.append(k1);
        sb.append(l1);
        return sb.toString();
    }
}