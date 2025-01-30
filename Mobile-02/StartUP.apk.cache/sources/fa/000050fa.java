package io.branch.referral;

import android.app.Activity;
import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestInitSession.java */
/* loaded from: classes2.dex */
public abstract class x extends r {

    /* renamed from: i  reason: collision with root package name */
    private final Context f17126i;

    /* renamed from: j  reason: collision with root package name */
    private final h.b.a.c f17127j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(Context context, String str) {
        super(context, str);
        this.f17126i = context;
        this.f17127j = h.b.a.c.b(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean L(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("open") || str.equalsIgnoreCase("install");
        }
        return false;
    }

    private void N(JSONObject jSONObject) throws JSONException {
        String a = o.e().a();
        long c2 = o.e().c();
        long f2 = o.e().f();
        int i2 = 2;
        if ("bnc_no_value".equals(this.f17104c.l())) {
            if (f2 - c2 < 86400000) {
                i2 = 0;
            }
        } else if (this.f17104c.l().equals(a)) {
            i2 = 1;
        }
        jSONObject.put(l.Update.h(), i2);
        jSONObject.put(l.FirstInstallTime.h(), c2);
        jSONObject.put(l.LastUpdateTime.h(), f2);
        long J = this.f17104c.J("bnc_original_install_time");
        if (J == 0) {
            this.f17104c.w0("bnc_original_install_time", c2);
        } else {
            c2 = J;
        }
        jSONObject.put(l.OriginalInstallTime.h(), c2);
        long J2 = this.f17104c.J("bnc_last_known_update_time");
        if (J2 < f2) {
            this.f17104c.w0("bnc_previous_update_time", J2);
            this.f17104c.w0("bnc_last_known_update_time", f2);
        }
        jSONObject.put(l.PreviousUpdateTime.h(), this.f17104c.J("bnc_previous_update_time"));
    }

    @Override // io.branch.referral.r
    protected boolean B() {
        return true;
    }

    public abstract String I();

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean J(e0 e0Var) {
        if (e0Var != null && e0Var.c() != null) {
            JSONObject c2 = e0Var.c();
            l lVar = l.BranchViewData;
            if (c2.has(lVar.h())) {
                try {
                    JSONObject jSONObject = e0Var.c().getJSONObject(lVar.h());
                    String I = I();
                    if (b.V().F != null && b.V().F.get() != null) {
                        Activity activity = b.V().F.get();
                        if (activity instanceof b.j ? true ^ ((b.j) activity).a() : true) {
                            return j.k().r(jSONObject, I, activity, b.V());
                        }
                        return j.k().n(jSONObject, I);
                    }
                    return j.k().n(jSONObject, I);
                } catch (JSONException unused) {
                }
            }
        }
        return false;
    }

    public abstract boolean K();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(e0 e0Var, b bVar) {
        h.b.a.c cVar = this.f17127j;
        if (cVar != null) {
            cVar.h(e0Var.c());
            if (bVar.F != null) {
                try {
                    h.b.a.b.w().A(bVar.F.get(), bVar.X());
                } catch (Exception unused) {
                }
            }
        }
        io.branch.referral.k0.a.g(bVar.F);
        bVar.F0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void O() {
        String I = this.f17104c.I();
        if (!I.equals("bnc_no_value")) {
            try {
                j().put(l.LinkIdentifier.h(), I);
                j().put(l.FaceBookAppLinkChecked.h(), this.f17104c.E());
            } catch (JSONException unused) {
            }
        }
        String w = this.f17104c.w();
        if (!w.equals("bnc_no_value")) {
            try {
                j().put(l.GoogleSearchInstallReferrer.h(), w);
            } catch (JSONException unused2) {
            }
        }
        String v = this.f17104c.v();
        if (!v.equals("bnc_no_value")) {
            try {
                j().put(l.GooglePlayInstallReferrer.h(), v);
            } catch (JSONException unused3) {
            }
        }
        if (this.f17104c.U()) {
            try {
                j().put(l.AndroidAppLinkURL.h(), this.f17104c.k());
                j().put(l.IsFullAppConv.h(), true);
            } catch (JSONException unused4) {
            }
        }
    }

    @Override // io.branch.referral.r
    public void t() {
        JSONObject j2 = j();
        try {
            if (!this.f17104c.k().equals("bnc_no_value")) {
                j2.put(l.AndroidAppLinkURL.h(), this.f17104c.k());
            }
            if (!this.f17104c.K().equals("bnc_no_value")) {
                j2.put(l.AndroidPushIdentifier.h(), this.f17104c.K());
            }
            if (!this.f17104c.u().equals("bnc_no_value")) {
                j2.put(l.External_Intent_URI.h(), this.f17104c.u());
            }
            if (!this.f17104c.t().equals("bnc_no_value")) {
                j2.put(l.External_Intent_Extra.h(), this.f17104c.t());
            }
            if (this.f17127j != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("mv", this.f17127j.c());
                jSONObject.put("pn", this.f17126i.getPackageName());
                j2.put("cd", jSONObject);
            }
        } catch (JSONException unused) {
        }
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        try {
            this.f17104c.v0("bnc_no_value");
            this.f17104c.l0("bnc_no_value");
            this.f17104c.k0("bnc_no_value");
            this.f17104c.j0("bnc_no_value");
            this.f17104c.i0("bnc_no_value");
            this.f17104c.b0("bnc_no_value");
            this.f17104c.x0("bnc_no_value");
            this.f17104c.r0(Boolean.FALSE);
            this.f17104c.p0("bnc_no_value");
            this.f17104c.s0(false);
            if (e0Var.c() != null) {
                JSONObject c2 = e0Var.c();
                l lVar = l.Data;
                if (c2.has(lVar.h())) {
                    JSONObject jSONObject = new JSONObject(e0Var.c().getString(lVar.h()));
                    if (jSONObject.optBoolean(l.Clicked_Branch_Link.h())) {
                        new p().d(this instanceof c0 ? "Branch Install" : "Branch Open", jSONObject, this.f17104c.y());
                    }
                }
            }
        } catch (JSONException unused) {
        }
        if (this.f17104c.J("bnc_previous_update_time") == 0) {
            q qVar = this.f17104c;
            qVar.w0("bnc_previous_update_time", qVar.J("bnc_last_known_update_time"));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.branch.referral.r
    public boolean w() {
        JSONObject j2 = j();
        if (!j2.has(l.AndroidAppLinkURL.h()) && !j2.has(l.AndroidPushIdentifier.h()) && !j2.has(l.LinkIdentifier.h())) {
            return super.w();
        }
        j2.remove(l.DeviceFingerprintID.h());
        j2.remove(l.IdentityID.h());
        j2.remove(l.FaceBookAppLinkChecked.h());
        j2.remove(l.External_Intent_Extra.h());
        j2.remove(l.External_Intent_URI.h());
        j2.remove(l.FirstInstallTime.h());
        j2.remove(l.LastUpdateTime.h());
        j2.remove(l.OriginalInstallTime.h());
        j2.remove(l.PreviousUpdateTime.h());
        j2.remove(l.InstallBeginTimeStamp.h());
        j2.remove(l.ClickedReferrerTimeStamp.h());
        j2.remove(l.HardwareID.h());
        j2.remove(l.IsHardwareIDReal.h());
        j2.remove(l.LocalIP.h());
        try {
            j2.put(l.TrackingDisabled.h(), true);
        } catch (JSONException unused) {
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.branch.referral.r
    public void z(JSONObject jSONObject) throws JSONException {
        super.z(jSONObject);
        String a = o.e().a();
        if (!o.k(a)) {
            jSONObject.put(l.AppVersion.h(), a);
        }
        jSONObject.put(l.FaceBookAppLinkChecked.h(), this.f17104c.E());
        jSONObject.put(l.IsReferrable.h(), this.f17104c.F());
        jSONObject.put(l.Debug.h(), i.d());
        N(jSONObject);
        E(this.f17126i, jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f17126i = context;
        this.f17127j = h.b.a.c.b(context);
    }
}