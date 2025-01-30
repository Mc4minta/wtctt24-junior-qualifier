package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestCreateUrl.java */
/* loaded from: classes2.dex */
public class t extends r {

    /* renamed from: i  reason: collision with root package name */
    private e f17118i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f17119j;

    /* renamed from: k  reason: collision with root package name */
    private b.d f17120k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f17121l;
    private boolean m;

    public t(Context context, String str, int i2, int i3, Collection<String> collection, String str2, String str3, String str4, String str5, JSONObject jSONObject, b.d dVar, boolean z, boolean z2) {
        super(context, n.GetURL.h());
        this.f17119j = true;
        this.m = true;
        this.f17120k = dVar;
        this.f17119j = z;
        this.m = z2;
        e eVar = new e();
        this.f17118i = eVar;
        try {
            eVar.put(l.IdentityID.h(), this.f17104c.y());
            this.f17118i.put(l.DeviceFingerprintID.h(), this.f17104c.s());
            this.f17118i.put(l.SessionID.h(), this.f17104c.O());
            if (!this.f17104c.H().equals("bnc_no_value")) {
                this.f17118i.put(l.LinkClickID.h(), this.f17104c.H());
            }
            this.f17118i.s(i2);
            this.f17118i.n(i3);
            this.f17118i.r(collection);
            this.f17118i.k(str);
            this.f17118i.m(str2);
            this.f17118i.o(str3);
            this.f17118i.q(str4);
            this.f17118i.l(str5);
            this.f17118i.p(jSONObject);
            z(this.f17118i);
        } catch (JSONException e2) {
            e2.printStackTrace();
            this.f17108g = true;
        }
    }

    private String I(String str) {
        try {
            if (b.V().q0() && !str.contains("https://bnc.lt/a/")) {
                str = str.replace(new URL(str).getQuery(), "");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(str.contains("?") ? "" : "?");
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append(sb2.endsWith("?") ? "" : "&");
            String sb4 = sb3.toString();
            Collection<String> i2 = this.f17118i.i();
            if (i2 != null) {
                for (String str2 : i2) {
                    if (str2 != null && str2.length() > 0) {
                        sb4 = sb4 + m.Tags + "=" + URLEncoder.encode(str2, "UTF8") + "&";
                    }
                }
            }
            String a = this.f17118i.a();
            if (a != null && a.length() > 0) {
                sb4 = sb4 + m.Alias + "=" + URLEncoder.encode(a, "UTF8") + "&";
            }
            String c2 = this.f17118i.c();
            if (c2 != null && c2.length() > 0) {
                sb4 = sb4 + m.Channel + "=" + URLEncoder.encode(c2, "UTF8") + "&";
            }
            String e2 = this.f17118i.e();
            if (e2 != null && e2.length() > 0) {
                sb4 = sb4 + m.Feature + "=" + URLEncoder.encode(e2, "UTF8") + "&";
            }
            String h2 = this.f17118i.h();
            if (h2 != null && h2.length() > 0) {
                sb4 = sb4 + m.Stage + "=" + URLEncoder.encode(h2, "UTF8") + "&";
            }
            String b2 = this.f17118i.b();
            if (b2 != null && b2.length() > 0) {
                sb4 = sb4 + m.Campaign + "=" + URLEncoder.encode(b2, "UTF8") + "&";
            }
            String str3 = (sb4 + m.Type + "=" + this.f17118i.j() + "&") + m.Duration + "=" + this.f17118i.d();
            String jSONObject = this.f17118i.g().toString();
            if (jSONObject == null || jSONObject.length() <= 0) {
                return str3;
            }
            return str3 + "&source=android&data=" + URLEncoder.encode(a.e(jSONObject.getBytes(), 2), "UTF8");
        } catch (Exception unused) {
            this.f17120k.a(null, new d("Trouble creating a URL.", -116));
            return str;
        }
    }

    private void R(String str) {
        JSONObject f2 = this.f17118i.f();
        if (!P() || f2 == null) {
            return;
        }
        new p().d("Branch Share", f2, this.f17104c.y());
    }

    public e J() {
        return this.f17118i;
    }

    public String K() {
        if (!this.f17104c.S().equals("bnc_no_value")) {
            return I(this.f17104c.S());
        }
        return I("https://bnc.lt/a/" + this.f17104c.o());
    }

    public void L() {
        b.d dVar = this.f17120k;
        if (dVar != null) {
            dVar.a(null, new d("Trouble creating a URL.", -105));
        }
    }

    public boolean M(Context context) {
        if (super.e(context)) {
            return false;
        }
        b.d dVar = this.f17120k;
        if (dVar != null) {
            dVar.a(null, new d("Trouble creating a URL.", -102));
            return true;
        }
        return true;
    }

    public boolean N() {
        return this.f17119j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean O() {
        return this.m;
    }

    boolean P() {
        return this.f17121l;
    }

    public void Q(String str) {
        b.d dVar = this.f17120k;
        if (dVar != null) {
            dVar.a(str, null);
        }
        R(str);
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f17120k = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        if (this.f17120k != null) {
            String K = this.m ? K() : null;
            b.d dVar = this.f17120k;
            dVar.a(K, new d("Trouble creating a URL. " + str, i2));
        }
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
        try {
            String string = e0Var.c().getString("url");
            b.d dVar = this.f17120k;
            if (dVar != null) {
                dVar.a(string, null);
            }
            R(string);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // io.branch.referral.r
    protected boolean w() {
        return true;
    }

    public t(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f17119j = true;
        this.m = true;
    }
}