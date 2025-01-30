package io.branch.referral;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestRegisterClose.java */
/* loaded from: classes2.dex */
public class b0 extends r {
    public b0(Context context) {
        super(context, n.RegisterClose.h());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(l.DeviceFingerprintID.h(), this.f17104c.s());
            jSONObject.put(l.IdentityID.h(), this.f17104c.y());
            jSONObject.put(l.SessionID.h(), this.f17104c.O());
            if (!this.f17104c.H().equals("bnc_no_value")) {
                jSONObject.put(l.LinkClickID.h(), this.f17104c.H());
            }
            JSONObject v = h.b.a.b.w().v(context);
            if (v != null) {
                jSONObject.put(l.ContentDiscovery.h(), v);
            }
            if (o.e() != null) {
                jSONObject.put(l.AppVersion.h(), o.e().a());
            }
            z(jSONObject);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f17108g = true;
        }
    }

    @Override // io.branch.referral.r
    public void b() {
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    @Override // io.branch.referral.r
    boolean r() {
        return false;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        this.f17104c.z0("bnc_no_value");
    }

    public b0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }
}