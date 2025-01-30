package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class k extends f<Boolean> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public k(p pVar, String str, Boolean bool) {
        super(pVar, str, bool, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.f
    /* renamed from: r */
    public final Boolean f(SharedPreferences sharedPreferences) {
        try {
            return Boolean.valueOf(sharedPreferences.getBoolean(this.f6420g, false));
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(this.f6420g);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid boolean value in SharedPreferences for ".concat(valueOf) : new String("Invalid boolean value in SharedPreferences for "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.f
    public final /* synthetic */ Boolean m(String str) {
        if (v5.f6589c.matcher(str).matches()) {
            return Boolean.TRUE;
        }
        if (v5.f6590d.matcher(str).matches()) {
            return Boolean.FALSE;
        }
        String str2 = this.f6420g;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 28 + String.valueOf(str).length());
        sb.append("Invalid boolean value for ");
        sb.append(str2);
        sb.append(": ");
        sb.append(str);
        Log.e("PhenotypeFlag", sb.toString());
        return null;
    }
}