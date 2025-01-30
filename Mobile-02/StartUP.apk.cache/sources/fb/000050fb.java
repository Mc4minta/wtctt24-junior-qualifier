package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestLogout.java */
/* loaded from: classes2.dex */
public class y extends r {

    /* renamed from: i  reason: collision with root package name */
    private b.l f17128i;

    public y(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f17128i = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        b.l lVar = this.f17128i;
        if (lVar != null) {
            lVar.a(false, new d("Logout error. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // io.branch.referral.r
    public boolean r() {
        return false;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        b.l lVar;
        try {
            try {
                this.f17104c.y0(e0Var.c().getString(l.SessionID.h()));
                this.f17104c.n0(e0Var.c().getString(l.IdentityID.h()));
                this.f17104c.B0(e0Var.c().getString(l.Link.h()));
                this.f17104c.o0("bnc_no_value");
                this.f17104c.z0("bnc_no_value");
                this.f17104c.m0("bnc_no_value");
                this.f17104c.g();
                lVar = this.f17128i;
                if (lVar == null) {
                    return;
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
                lVar = this.f17128i;
                if (lVar == null) {
                    return;
                }
            }
            lVar.a(true, null);
        } catch (Throwable th) {
            b.l lVar2 = this.f17128i;
            if (lVar2 != null) {
                lVar2.a(true, null);
            }
            throw th;
        }
    }
}