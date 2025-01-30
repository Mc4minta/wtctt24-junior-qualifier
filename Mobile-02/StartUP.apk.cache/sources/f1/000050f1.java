package io.branch.referral;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.reactnativecommunity.webview.RNCWebViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PrefHelper.java */
/* loaded from: classes2.dex */
public class q {
    private static String a;

    /* renamed from: b  reason: collision with root package name */
    private static q f17096b;

    /* renamed from: c  reason: collision with root package name */
    private static JSONObject f17097c;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f17098d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f17099e;

    /* renamed from: f  reason: collision with root package name */
    private SharedPreferences.Editor f17100f;

    /* renamed from: g  reason: collision with root package name */
    private final JSONObject f17101g;

    /* renamed from: h  reason: collision with root package name */
    private final JSONObject f17102h;

    private q(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("branch_referral_shared_pref", 0);
        this.f17099e = sharedPreferences;
        this.f17100f = sharedPreferences.edit();
        this.f17101g = new JSONObject();
        this.f17102h = new JSONObject();
    }

    public static q B(Context context) {
        if (f17096b == null) {
            f17096b = new q(context);
        }
        return f17096b;
    }

    private String X(ArrayList<String> arrayList) {
        Iterator<String> it;
        String str = "";
        while (arrayList.iterator().hasNext()) {
            str = str + it.next() + ",";
        }
        return str.substring(0, str.length() - 1);
    }

    public static void a(String str) {
        if ((i.d() || f17098d) && !TextUtils.isEmpty(str)) {
            Log.i("BranchSDK", str);
        }
    }

    private void a0(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            A0("bnc_actions", "bnc_no_value");
        } else {
            A0("bnc_actions", X(arrayList));
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.i("BranchSDK", str);
    }

    public static void c(String str, Throwable th) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Log.e("BranchSDK", str, th);
    }

    private void f() {
        String H = H();
        String I = I();
        String k2 = k();
        String K = K();
        this.f17100f.clear();
        u0(H);
        v0(I);
        b0(k2);
        x0(K);
        f17096b.f17100f.apply();
    }

    private void f0(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            A0("bnc_buckets", "bnc_no_value");
        } else {
            A0("bnc_buckets", X(arrayList));
        }
    }

    private ArrayList<String> h(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, str.split(","));
        return arrayList;
    }

    private ArrayList<String> j() {
        String Q = Q("bnc_actions");
        if (Q.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return h(Q);
    }

    private ArrayList<String> q() {
        String Q = Q("bnc_buckets");
        if (Q.equals("bnc_no_value")) {
            return new ArrayList<>();
        }
        return h(Q);
    }

    public String A() {
        return Q("bnc_install_params");
    }

    public void A0(String str, String str2) {
        f17096b.f17100f.putString(str, str2);
        f17096b.f17100f.apply();
    }

    public void B0(String str) {
        A0("bnc_user_url", str);
    }

    public int C(String str) {
        return D(str, 0);
    }

    public void C0(String str) {
        q0("bnc_branch_view_use_" + str, p(str) + 1);
    }

    public int D(String str, int i2) {
        return f17096b.f17099e.getInt(str, i2);
    }

    public boolean E() {
        return m("bnc_triggered_by_fb_app_link");
    }

    public int F() {
        return C("bnc_is_referrable");
    }

    public long G() {
        return J("bnc_branch_strong_match_time");
    }

    public String H() {
        return Q("bnc_link_click_id");
    }

    public String I() {
        return Q("bnc_link_click_identifier");
    }

    public long J(String str) {
        return f17096b.f17099e.getLong(str, 0L);
    }

    public String K() {
        return Q("bnc_push_identifier");
    }

    public JSONObject L() {
        return this.f17101g;
    }

    public int M() {
        return D("bnc_retry_count", 3);
    }

    public int N() {
        return D("bnc_retry_interval", RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
    }

    public String O() {
        return Q("bnc_session_id");
    }

    public String P() {
        return Q("bnc_session_params");
    }

    public String Q(String str) {
        return f17096b.f17099e.getString(str, "bnc_no_value");
    }

    public int R() {
        return D("bnc_timeout", 5500);
    }

    public String S() {
        return Q("bnc_user_url");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean T() {
        return m("bnc_limit_facebook_tracking");
    }

    public boolean U() {
        return m("bnc_is_full_app_conversion");
    }

    public void V(JSONObject jSONObject) {
        JSONArray jSONArray;
        String O = O();
        if (O.equals("bnc_no_value")) {
            return;
        }
        if (f17097c == null) {
            f17097c = n();
        }
        try {
            if (f17097c.has(O)) {
                jSONArray = f17097c.getJSONArray(O);
            } else {
                JSONArray jSONArray2 = new JSONArray();
                f17097c.put(O, jSONArray2);
                jSONArray = jSONArray2;
            }
            jSONArray.put(jSONObject);
            A0("bnc_branch_analytical_data", f17097c.toString());
        } catch (JSONException unused) {
        }
    }

    public void W(long j2) {
        w0("bnc_branch_strong_match_time", j2);
    }

    public void Y(String str, int i2) {
        ArrayList<String> j2 = j();
        if (!j2.contains(str)) {
            j2.add(str);
            a0(j2);
        }
        q0("bnc_total_base_" + str, i2);
    }

    public void Z(String str, int i2) {
        q0("bnc_balance_base_" + str, i2);
    }

    public void b0(String str) {
        A0("bnc_app_link", str);
    }

    public void c0(String str) {
        A0("bnc_app_version", str);
    }

    public void d() {
        f17097c = null;
        A0("bnc_branch_analytical_data", "");
    }

    public void d0(String str, Boolean bool) {
        f17096b.f17100f.putBoolean(str, bool.booleanValue());
        f17096b.f17100f.apply();
    }

    public void e() {
        q0("bnc_is_referrable", 0);
    }

    public boolean e0(String str) {
        a = str;
        String Q = Q("bnc_branch_key");
        if (str == null || Q == null || !Q.equals(str)) {
            f();
            A0("bnc_branch_key", str);
            return true;
        }
        return false;
    }

    public void g() {
        Iterator<String> it = q().iterator();
        while (it.hasNext()) {
            g0(it.next(), 0);
        }
        f0(new ArrayList<>());
        Iterator<String> it2 = j().iterator();
        while (it2.hasNext()) {
            String next = it2.next();
            Y(next, 0);
            Z(next, 0);
        }
        a0(new ArrayList<>());
    }

    public void g0(String str, int i2) {
        ArrayList<String> q = q();
        if (!q.contains(str)) {
            q.add(str);
            f0(q);
        }
        q0("bnc_credit_base_" + str, i2);
    }

    public void h0(String str) {
        A0("bnc_device_fingerprint_id", str);
    }

    public String i() {
        return Build.VERSION.SDK_INT >= 20 ? "https://api2.branch.io/" : "https://api.branch.io/";
    }

    public void i0(String str) {
        A0("bnc_external_intent_extra", str);
    }

    public void j0(String str) {
        A0("bnc_external_intent_uri", str);
    }

    public String k() {
        return Q("bnc_app_link");
    }

    public void k0(String str) {
        A0("bnc_google_play_install_referrer_extras", str);
    }

    public String l() {
        return Q("bnc_app_version");
    }

    public void l0(String str) {
        A0("bnc_google_search_install_identifier", str);
    }

    public boolean m(String str) {
        return f17096b.f17099e.getBoolean(str, false);
    }

    public void m0(String str) {
        A0("bnc_identity", str);
    }

    public JSONObject n() {
        JSONObject jSONObject = f17097c;
        if (jSONObject != null) {
            return jSONObject;
        }
        String Q = Q("bnc_branch_analytical_data");
        JSONObject jSONObject2 = new JSONObject();
        if (!TextUtils.isEmpty(Q) && !Q.equals("bnc_no_value")) {
            try {
                return new JSONObject(Q);
            } catch (JSONException unused) {
            }
        }
        return jSONObject2;
    }

    public void n0(String str) {
        A0("bnc_identity_id", str);
    }

    public String o() {
        if (a == null) {
            a = Q("bnc_branch_key");
        }
        return a;
    }

    public void o0(String str) {
        A0("bnc_install_params", str);
    }

    public int p(String str) {
        return D("bnc_branch_view_use_" + str, 0);
    }

    public void p0(String str) {
        A0("bnc_install_referrer", str);
    }

    public void q0(String str, int i2) {
        f17096b.f17100f.putInt(str, i2);
        f17096b.f17100f.apply();
    }

    public int r(String str) {
        return C("bnc_credit_base_" + str);
    }

    public void r0(Boolean bool) {
        d0("bnc_triggered_by_fb_app_link", bool);
    }

    public String s() {
        return Q("bnc_device_fingerprint_id");
    }

    public void s0(boolean z) {
        d0("bnc_is_full_app_conversion", Boolean.valueOf(z));
    }

    public String t() {
        return Q("bnc_external_intent_extra");
    }

    public void t0() {
        q0("bnc_is_referrable", 1);
    }

    public String u() {
        return Q("bnc_external_intent_uri");
    }

    public void u0(String str) {
        A0("bnc_link_click_id", str);
    }

    public String v() {
        return Q("bnc_google_play_install_referrer_extras");
    }

    public void v0(String str) {
        A0("bnc_link_click_identifier", str);
    }

    public String w() {
        return Q("bnc_google_search_install_identifier");
    }

    public void w0(String str, long j2) {
        f17096b.f17100f.putLong(str, j2);
        f17096b.f17100f.apply();
    }

    public String x() {
        return Q("bnc_identity");
    }

    public void x0(String str) {
        A0("bnc_push_identifier", str);
    }

    public String y() {
        return Q("bnc_identity_id");
    }

    public void y0(String str) {
        A0("bnc_session_id", str);
    }

    public JSONObject z() {
        return this.f17102h;
    }

    public void z0(String str) {
        A0("bnc_session_params", str);
    }
}