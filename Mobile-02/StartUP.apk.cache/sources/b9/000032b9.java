package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class l extends f<String> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public l(p pVar, String str, String str2) {
        super(pVar, str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.clearcut.f
    /* renamed from: r */
    public final String f(SharedPreferences sharedPreferences) {
        try {
            return sharedPreferences.getString(this.f6420g, null);
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(this.f6420g);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid string value in SharedPreferences for ".concat(valueOf) : new String("Invalid string value in SharedPreferences for "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.f
    public final /* synthetic */ String m(String str) {
        return str;
    }
}