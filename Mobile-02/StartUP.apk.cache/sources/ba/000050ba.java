package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestRegisterOpen.java */
/* loaded from: classes2.dex */
public class d0 extends x {

    /* renamed from: k  reason: collision with root package name */
    b.g f16935k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0(Context context, b.g gVar) {
        super(context, n.RegisterOpen.h());
        this.f16935k = gVar;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(l.DeviceFingerprintID.h(), this.f17104c.s());
            jSONObject.put(l.IdentityID.h(), this.f17104c.y());
            z(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f17108g = true;
        }
    }

    @Override // io.branch.referral.x
    public String I() {
        return "open";
    }

    @Override // io.branch.referral.x
    public boolean K() {
        return this.f16935k != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P(b.g gVar) {
        if (gVar != null) {
            this.f16935k = gVar;
        }
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f16935k = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        if (this.f16935k != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.g gVar = this.f16935k;
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
        if (b.V().M) {
            this.f16935k.a(b.V().W(), null);
            b.V().F(l.InstantDeepLinkSession.h(), "true");
            b.V().M = false;
            b.V().G = true;
        }
    }

    @Override // io.branch.referral.x, io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        super.v(e0Var, bVar);
        try {
            JSONObject c2 = e0Var.c();
            l lVar = l.LinkClickID;
            if (c2.has(lVar.h())) {
                this.f17104c.u0(e0Var.c().getString(lVar.h()));
            } else {
                this.f17104c.u0("bnc_no_value");
            }
            JSONObject c3 = e0Var.c();
            l lVar2 = l.Data;
            if (c3.has(lVar2.h())) {
                JSONObject jSONObject = new JSONObject(e0Var.c().getString(lVar2.h()));
                l lVar3 = l.Clicked_Branch_Link;
                if (jSONObject.has(lVar3.h()) && jSONObject.getBoolean(lVar3.h()) && this.f17104c.A().equals("bnc_no_value") && this.f17104c.F() == 1) {
                    this.f17104c.o0(e0Var.c().getString(lVar2.h()));
                }
            }
            if (e0Var.c().has(lVar2.h())) {
                this.f17104c.z0(e0Var.c().getString(lVar2.h()));
            } else {
                this.f17104c.z0("bnc_no_value");
            }
            b.g gVar = this.f16935k;
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
    public d0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }
}