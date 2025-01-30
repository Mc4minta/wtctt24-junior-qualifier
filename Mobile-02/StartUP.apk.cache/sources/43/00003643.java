package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.4.0 */
/* loaded from: classes2.dex */
public final class fa {
    private com.google.android.gms.internal.measurement.t0 a;

    /* renamed from: b  reason: collision with root package name */
    private Long f7595b;

    /* renamed from: c  reason: collision with root package name */
    private long f7596c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ aa f7597d;

    private fa(aa aaVar) {
        this.f7597d = aaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final com.google.android.gms.internal.measurement.t0 a(String str, com.google.android.gms.internal.measurement.t0 t0Var) {
        Object obj;
        String T = t0Var.T();
        List<com.google.android.gms.internal.measurement.v0> C = t0Var.C();
        Long l2 = (Long) this.f7597d.q().W(t0Var, "_eid");
        boolean z = l2 != null;
        if (z && T.equals("_ep")) {
            T = (String) this.f7597d.q().W(t0Var, "_en");
            if (TextUtils.isEmpty(T)) {
                this.f7597d.f().I().b("Extra parameter without an event name. eventId", l2);
                return null;
            }
            if (this.a == null || this.f7595b == null || l2.longValue() != this.f7595b.longValue()) {
                Pair<com.google.android.gms.internal.measurement.t0, Long> C2 = this.f7597d.r().C(str, l2);
                if (C2 != null && (obj = C2.first) != null) {
                    this.a = (com.google.android.gms.internal.measurement.t0) obj;
                    this.f7596c = ((Long) C2.second).longValue();
                    this.f7595b = (Long) this.f7597d.q().W(this.a, "_eid");
                } else {
                    this.f7597d.f().I().c("Extra parameter without existing main event. eventName, eventId", T, l2);
                    return null;
                }
            }
            long j2 = this.f7596c - 1;
            this.f7596c = j2;
            if (j2 <= 0) {
                e r = this.f7597d.r();
                r.d();
                r.f().P().b("Clearing complex main event info. appId", str);
                try {
                    r.y().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e2) {
                    r.f().H().b("Error clearing complex main event", e2);
                }
            } else {
                this.f7597d.r().Y(str, l2, this.f7596c, this.a);
            }
            ArrayList arrayList = new ArrayList();
            for (com.google.android.gms.internal.measurement.v0 v0Var : this.a.C()) {
                this.f7597d.q();
                if (r9.A(t0Var, v0Var.M()) == null) {
                    arrayList.add(v0Var);
                }
            }
            if (!arrayList.isEmpty()) {
                arrayList.addAll(C);
                C = arrayList;
            } else {
                this.f7597d.f().I().b("No unique parameters in main event. eventName", T);
            }
        } else if (z) {
            this.f7595b = l2;
            this.a = t0Var;
            Object W = this.f7597d.q().W(t0Var, "_epc");
            long longValue = (W != null ? W : 0L).longValue();
            this.f7596c = longValue;
            if (longValue <= 0) {
                this.f7597d.f().I().b("Complex event with zero extra param count. eventName", T);
            } else {
                this.f7597d.r().Y(str, l2, this.f7596c, t0Var);
            }
        }
        return (com.google.android.gms.internal.measurement.t0) ((com.google.android.gms.internal.measurement.n4) t0Var.x().B(T).H().A(C).j());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ fa(aa aaVar, da daVar) {
        this(aaVar);
    }
}