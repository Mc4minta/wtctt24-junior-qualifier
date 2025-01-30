package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class aa extends k9 {

    /* renamed from: d  reason: collision with root package name */
    private String f7493d;

    /* renamed from: e  reason: collision with root package name */
    private Set<Integer> f7494e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, ca> f7495f;

    /* renamed from: g  reason: collision with root package name */
    private Long f7496g;

    /* renamed from: h  reason: collision with root package name */
    private Long f7497h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(j9 j9Var) {
        super(j9Var);
    }

    private final ca x(int i2) {
        if (this.f7495f.containsKey(Integer.valueOf(i2))) {
            return this.f7495f.get(Integer.valueOf(i2));
        }
        ca caVar = new ca(this, this.f7493d, null);
        this.f7495f.put(Integer.valueOf(i2), caVar);
        return caVar;
    }

    private final boolean z(int i2, int i3) {
        if (this.f7495f.get(Integer.valueOf(i2)) == null) {
            return false;
        }
        return ca.b(this.f7495f.get(Integer.valueOf(i2))).get(i3);
    }

    @Override // com.google.android.gms.measurement.internal.k9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x02be A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List<com.google.android.gms.internal.measurement.r0> y(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.t0> r48, java.util.List<com.google.android.gms.internal.measurement.b1> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            Method dump skipped, instructions count: 1746
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.aa.y(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}