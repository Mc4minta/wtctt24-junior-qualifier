package com.google.android.gms.internal.clearcut;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes2.dex */
public final class m<T> extends f<T> {
    private final Object m;
    private String n;
    private T o;
    private final /* synthetic */ o p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(p pVar, String str, Object obj, o oVar) {
        super(pVar, str, obj, null);
        this.p = oVar;
        this.m = new Object();
    }

    @Override // com.google.android.gms.internal.clearcut.f
    protected final T f(SharedPreferences sharedPreferences) {
        try {
            return m(sharedPreferences.getString(this.f6420g, ""));
        } catch (ClassCastException e2) {
            String valueOf = String.valueOf(this.f6420g);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Invalid byte[] value in SharedPreferences for ".concat(valueOf) : new String("Invalid byte[] value in SharedPreferences for "), e2);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.clearcut.f
    public final T m(String str) {
        T t;
        try {
            synchronized (this.m) {
                if (!str.equals(this.n)) {
                    this.n = str;
                    this.o = (T) this.p.a(Base64.decode(str, 3));
                }
                t = this.o;
            }
            return t;
        } catch (IOException | IllegalArgumentException unused) {
            String str2 = this.f6420g;
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 27 + String.valueOf(str).length());
            sb.append("Invalid byte[] value for ");
            sb.append(str2);
            sb.append(": ");
            sb.append(str);
            Log.e("PhenotypeFlag", sb.toString());
            return null;
        }
    }
}