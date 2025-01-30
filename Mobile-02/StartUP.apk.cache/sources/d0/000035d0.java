package com.google.android.gms.internal.measurement;

import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class y1 extends x1<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(d2 d2Var, String str, Boolean bool) {
        super(d2Var, str, bool, null);
    }

    @Override // com.google.android.gms.internal.measurement.x1
    final /* synthetic */ Boolean e(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (e1.f7104c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (e1.f7105d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        String m = super.m();
        String valueOf = String.valueOf(obj);
        StringBuilder sb = new StringBuilder(String.valueOf(m).length() + 28 + valueOf.length());
        sb.append("Invalid boolean value for ");
        sb.append(m);
        sb.append(": ");
        sb.append(valueOf);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}