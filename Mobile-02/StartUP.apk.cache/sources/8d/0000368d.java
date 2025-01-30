package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class m {
    final String a;

    /* renamed from: b  reason: collision with root package name */
    final String f7750b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7751c;

    /* renamed from: d  reason: collision with root package name */
    final long f7752d;

    /* renamed from: e  reason: collision with root package name */
    final long f7753e;

    /* renamed from: f  reason: collision with root package name */
    final o f7754f;

    private m(b5 b5Var, String str, String str2, String str3, long j2, long j3, o oVar) {
        com.google.android.gms.common.internal.t.g(str2);
        com.google.android.gms.common.internal.t.g(str3);
        com.google.android.gms.common.internal.t.k(oVar);
        this.a = str2;
        this.f7750b = str3;
        this.f7751c = TextUtils.isEmpty(str) ? null : str;
        this.f7752d = j2;
        this.f7753e = j3;
        if (j3 != 0 && j3 > j2) {
            b5Var.f().K().c("Event created with reverse previous/current timestamps. appId, name", x3.y(str2), x3.y(str3));
        }
        this.f7754f = oVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final m a(b5 b5Var, long j2) {
        return new m(b5Var, this.f7751c, this.a, this.f7750b, this.f7752d, j2, this.f7754f);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.f7750b;
        String valueOf = String.valueOf(this.f7754f);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + valueOf.length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b5 b5Var, String str, String str2, String str3, long j2, long j3, Bundle bundle) {
        o oVar;
        com.google.android.gms.common.internal.t.g(str2);
        com.google.android.gms.common.internal.t.g(str3);
        this.a = str2;
        this.f7750b = str3;
        this.f7751c = TextUtils.isEmpty(str) ? null : str;
        this.f7752d = j2;
        this.f7753e = j3;
        if (j3 != 0 && j3 > j2) {
            b5Var.f().K().b("Event created with reverse previous/current timestamps. appId", x3.y(str2));
        }
        if (bundle != null && !bundle.isEmpty()) {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    b5Var.f().H().a("Param name can't be null");
                    it.remove();
                } else {
                    Object H = b5Var.H().H(next, bundle2.get(next));
                    if (H == null) {
                        b5Var.f().K().b("Param value can't be null", b5Var.I().A(next));
                        it.remove();
                    } else {
                        b5Var.H().N(bundle2, next, H);
                    }
                }
            }
            oVar = new o(bundle2);
        } else {
            oVar = new o(new Bundle());
        }
        this.f7754f = oVar;
    }
}