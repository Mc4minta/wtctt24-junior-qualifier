package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestRegisterInstall.java */
/* loaded from: classes2.dex */
public class c0 extends x {

    /* renamed from: k  reason: collision with root package name */
    b.g f16933k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Context context, b.g gVar, String str) {
        super(context, n.RegisterInstall.h());
        this.f16933k = gVar;
        JSONObject jSONObject = new JSONObject();
        try {
            if (!str.equals("bnc_no_value")) {
                jSONObject.put(l.LinkClickID.h(), str);
            }
            z(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f17108g = true;
        }
    }

    @Override // io.branch.referral.x
    public String I() {
        return "install";
    }

    @Override // io.branch.referral.x
    public boolean K() {
        return this.f16933k != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(b.g gVar) {
        if (gVar != null) {
            this.f16933k = gVar;
        }
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f16933k = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        if (this.f16933k != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.g gVar = this.f16933k;
            gVar.a(jSONObject, new d("Trouble initializing Branch. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    @Override // io.branch.referral.x, io.branch.referral.r
    public void t() {
        super.t();
        long J = this.f17104c.J("bnc_referrer_click_ts");
        long J2 = this.f17104c.J("bnc_install_begin_ts");
        if (J > 0) {
            try {
                j().put(l.ClickedReferrerTimeStamp.h(), J);
            } catch (JSONException unused) {
                return;
            }
        }
        if (J2 > 0) {
            j().put(l.InstallBeginTimeStamp.h(), J2);
        }
    }

    @Override // io.branch.referral.x, io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        super.v(e0Var, bVar);
        try {
            this.f17104c.B0(e0Var.c().getString(l.Link.h()));
            JSONObject c2 = e0Var.c();
            l lVar = l.Data;
            if (c2.has(lVar.h())) {
                JSONObject jSONObject = new JSONObject(e0Var.c().getString(lVar.h()));
                l lVar2 = l.Clicked_Branch_Link;
                if (jSONObject.has(lVar2.h()) && jSONObject.getBoolean(lVar2.h()) && this.f17104c.A().equals("bnc_no_value") && this.f17104c.F() == 1) {
                    this.f17104c.o0(e0Var.c().getString(lVar.h()));
                }
            }
            JSONObject c3 = e0Var.c();
            l lVar3 = l.LinkClickID;
            if (c3.has(lVar3.h())) {
                this.f17104c.u0(e0Var.c().getString(lVar3.h()));
            } else {
                this.f17104c.u0("bnc_no_value");
            }
            if (e0Var.c().has(lVar.h())) {
                this.f17104c.z0(e0Var.c().getString(lVar.h()));
            } else {
                this.f17104c.z0("bnc_no_value");
            }
            b.g gVar = this.f16933k;
            if (gVar != null && !bVar.G) {
                gVar.a(bVar.W(), null);
            }
            this.f17104c.c0(o.e().a());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        M(e0Var, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }
}