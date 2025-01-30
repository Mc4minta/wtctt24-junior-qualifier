package io.branch.referral.network;

import android.content.Context;
import io.branch.referral.b;
import io.branch.referral.e0;
import io.branch.referral.l;
import io.branch.referral.q;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class BranchRemoteInterface {

    /* loaded from: classes2.dex */
    public static class BranchRemoteException extends Exception {
        private int a;

        public BranchRemoteException(int i2) {
            this.a = -113;
            this.a = i2;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final int f17092b;

        public a(String str, int i2) {
            this.a = str;
            this.f17092b = i2;
        }
    }

    private boolean a(JSONObject jSONObject, String str) {
        try {
            if (!jSONObject.has(l.UserData.h())) {
                jSONObject.put(l.SDK.h(), "android3.2.0");
            }
            if (str.equals("bnc_no_value")) {
                return false;
            }
            jSONObject.put(l.BranchKey.h(), str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    private String b(JSONObject jSONObject) {
        JSONArray names;
        StringBuilder sb = new StringBuilder();
        if (jSONObject != null && (names = jSONObject.names()) != null) {
            int length = names.length();
            boolean z = true;
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    String string = names.getString(i2);
                    if (z) {
                        sb.append("?");
                        z = false;
                    } else {
                        sb.append("&");
                    }
                    String string2 = jSONObject.getString(string);
                    sb.append(string);
                    sb.append("=");
                    sb.append(string2);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        return sb.toString();
    }

    public static final BranchRemoteInterface e(Context context) {
        return new io.branch.referral.network.a(context);
    }

    private e0 h(String str, int i2, String str2) {
        e0 e0Var = new e0(str2, i2);
        q.a("returned " + str);
        if (str != null) {
            try {
                try {
                    e0Var.e(new JSONObject(str));
                } catch (JSONException e2) {
                    q.a("JSON exception: " + e2.getMessage());
                }
            } catch (JSONException unused) {
                e0Var.e(new JSONArray(str));
            }
        }
        return e0Var;
    }

    public abstract a c(String str) throws BranchRemoteException;

    public abstract a d(String str, JSONObject jSONObject) throws BranchRemoteException;

    public final e0 f(String str, JSONObject jSONObject, String str2, String str3) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (a(jSONObject, str3)) {
            String str4 = str + b(jSONObject);
            long currentTimeMillis = System.currentTimeMillis();
            q.a("getting " + str4);
            try {
                try {
                    a c2 = c(str4);
                    e0 h2 = h(c2.a, c2.f17092b, str2);
                    if (b.V() != null) {
                        b.V().F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                    }
                    return h2;
                } catch (BranchRemoteException e2) {
                    if (e2.a == -111) {
                        e0 e0Var = new e0(str2, -111);
                        if (b.V() != null) {
                            b.V().F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                        }
                        return e0Var;
                    }
                    e0 e0Var2 = new e0(str2, -113);
                    if (b.V() != null) {
                        b.V().F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                    }
                    return e0Var2;
                }
            } catch (Throwable th) {
                if (b.V() != null) {
                    b.V().F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                throw th;
            }
        }
        return new e0(str2, -114);
    }

    public final e0 g(JSONObject jSONObject, String str, String str2, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (!a(jSONObject, str3)) {
            return new e0(str2, -114);
        }
        q.a("posting to " + str);
        q.a("Post value = " + jSONObject.toString());
        try {
            try {
                a d2 = d(str, jSONObject);
                e0 h2 = h(d2.a, d2.f17092b, str2);
                if (b.V() != null) {
                    b V = b.V();
                    V.F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return h2;
            } catch (BranchRemoteException e2) {
                if (e2.a == -111) {
                    e0 e0Var = new e0(str2, -111);
                    if (b.V() != null) {
                        b V2 = b.V();
                        V2.F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                    }
                    return e0Var;
                }
                e0 e0Var2 = new e0(str2, -113);
                if (b.V() != null) {
                    b V3 = b.V();
                    V3.F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
                }
                return e0Var2;
            }
        } catch (Throwable th) {
            if (b.V() != null) {
                b V4 = b.V();
                V4.F(str2 + "-" + l.Branch_Round_Trip_Time.h(), String.valueOf((int) (System.currentTimeMillis() - currentTimeMillis)));
            }
            throw th;
        }
    }
}