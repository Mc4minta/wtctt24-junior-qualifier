package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestIdentifyUserRequest.java */
/* loaded from: classes2.dex */
public class w extends r {

    /* renamed from: i  reason: collision with root package name */
    b.g f17124i;

    /* renamed from: j  reason: collision with root package name */
    String f17125j;

    public w(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f17125j = null;
    }

    @Override // io.branch.referral.r
    public boolean A() {
        return true;
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f17124i = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        if (this.f17124i != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_message", "Trouble reaching server. Please try again in a few minutes");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            b.g gVar = this.f17124i;
            gVar.a(jSONObject, new d("Trouble setting the user alias. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        try {
            if (j() != null) {
                JSONObject j2 = j();
                l lVar = l.Identity;
                if (j2.has(lVar.h())) {
                    this.f17104c.m0(j().getString(lVar.h()));
                }
            }
            this.f17104c.n0(e0Var.c().getString(l.IdentityID.h()));
            this.f17104c.B0(e0Var.c().getString(l.Link.h()));
            JSONObject c2 = e0Var.c();
            l lVar2 = l.ReferringData;
            if (c2.has(lVar2.h())) {
                this.f17104c.o0(e0Var.c().getString(lVar2.h()));
            }
            b.g gVar = this.f17124i;
            if (gVar != null) {
                gVar.a(bVar.T(), null);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}