package io.branch.referral;

import android.text.TextUtils;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtendedAnswerProvider.java */
/* loaded from: classes2.dex */
public class p {
    private void a(e.d.a.a.a.c cVar, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (str2.startsWith("~")) {
            cVar.a(str.replaceFirst("~", "") + str2.replaceFirst("~", ""), str3);
            return;
        }
        if (str2.equals("$" + l.IdentityID.h())) {
            cVar.a(l.ReferringBranchIdentity.h(), str3);
        }
    }

    private void b(e.d.a.a.a.c cVar, JSONArray jSONArray, String str) throws JSONException {
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            a(cVar, str, "~" + Integer.toString(i2), jSONArray.getString(i2));
        }
    }

    private void c(e.d.a.a.a.c cVar, JSONObject jSONObject, String str) throws JSONException {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (!next.startsWith("+")) {
                if (obj instanceof JSONObject) {
                    c(cVar, (JSONObject) obj, str + next + ".");
                } else if (obj instanceof JSONArray) {
                    b(cVar, (JSONArray) obj, next + ".");
                } else {
                    a(cVar, str, next, jSONObject.getString(next));
                }
            }
        }
    }

    public void d(String str, JSONObject jSONObject, String str2) {
        try {
            e.d.a.a.a.c cVar = new e.d.a.a.a.c(str);
            if (jSONObject != null) {
                c(cVar, jSONObject, "");
                cVar.a(l.BranchIdentity.h(), str2);
                e.d.a.a.a.b.a().a(cVar);
            }
        } catch (Throwable unused) {
        }
    }
}