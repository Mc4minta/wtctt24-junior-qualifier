package io.branch.referral;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BranchLinkData.java */
/* loaded from: classes2.dex */
public class e extends JSONObject {
    private Collection<String> a;

    /* renamed from: b  reason: collision with root package name */
    private String f16936b;

    /* renamed from: c  reason: collision with root package name */
    private int f16937c;

    /* renamed from: d  reason: collision with root package name */
    private String f16938d;

    /* renamed from: e  reason: collision with root package name */
    private String f16939e;

    /* renamed from: f  reason: collision with root package name */
    private String f16940f;

    /* renamed from: g  reason: collision with root package name */
    private String f16941g;

    /* renamed from: h  reason: collision with root package name */
    private JSONObject f16942h;

    /* renamed from: i  reason: collision with root package name */
    private int f16943i;

    public String a() {
        return this.f16936b;
    }

    public String b() {
        return this.f16941g;
    }

    public String c() {
        return this.f16938d;
    }

    public int d() {
        return this.f16943i;
    }

    public String e() {
        return this.f16939e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e.class == obj.getClass()) {
            e eVar = (e) obj;
            String str = this.f16936b;
            if (str == null) {
                if (eVar.f16936b != null) {
                    return false;
                }
            } else if (!str.equals(eVar.f16936b)) {
                return false;
            }
            String str2 = this.f16938d;
            if (str2 == null) {
                if (eVar.f16938d != null) {
                    return false;
                }
            } else if (!str2.equals(eVar.f16938d)) {
                return false;
            }
            String str3 = this.f16939e;
            if (str3 == null) {
                if (eVar.f16939e != null) {
                    return false;
                }
            } else if (!str3.equals(eVar.f16939e)) {
                return false;
            }
            JSONObject jSONObject = this.f16942h;
            if (jSONObject == null) {
                if (eVar.f16942h != null) {
                    return false;
                }
            } else if (!jSONObject.equals(eVar.f16942h)) {
                return false;
            }
            String str4 = this.f16940f;
            if (str4 == null) {
                if (eVar.f16940f != null) {
                    return false;
                }
            } else if (!str4.equals(eVar.f16940f)) {
                return false;
            }
            String str5 = this.f16941g;
            if (str5 == null) {
                if (eVar.f16941g != null) {
                    return false;
                }
            } else if (!str5.equals(eVar.f16941g)) {
                return false;
            }
            if (this.f16937c == eVar.f16937c && this.f16943i == eVar.f16943i) {
                Collection<String> collection = this.a;
                if (collection == null) {
                    if (eVar.a != null) {
                        return false;
                    }
                } else if (!collection.toString().equals(eVar.a.toString())) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public JSONObject f() {
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(this.f16938d)) {
                jSONObject.put("~" + m.Channel.h(), this.f16938d);
            }
            if (!TextUtils.isEmpty(this.f16936b)) {
                jSONObject.put("~" + m.Alias.h(), this.f16936b);
            }
            if (!TextUtils.isEmpty(this.f16939e)) {
                jSONObject.put("~" + m.Feature.h(), this.f16939e);
            }
            if (!TextUtils.isEmpty(this.f16940f)) {
                jSONObject.put("~" + m.Stage.h(), this.f16940f);
            }
            if (!TextUtils.isEmpty(this.f16941g)) {
                jSONObject.put("~" + m.Campaign.h(), this.f16941g);
            }
            m mVar = m.Tags;
            if (has(mVar.h())) {
                jSONObject.put(mVar.h(), getJSONArray(mVar.h()));
            }
            jSONObject.put("~" + m.Type.h(), this.f16937c);
            jSONObject.put("~" + m.Duration.h(), this.f16943i);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public JSONObject g() {
        return this.f16942h;
    }

    public String h() {
        return this.f16940f;
    }

    @SuppressLint({"DefaultLocale"})
    public int hashCode() {
        int i2 = (this.f16937c + 19) * 19;
        String str = this.f16936b;
        int hashCode = (i2 + (str == null ? 0 : str.toLowerCase().hashCode())) * 19;
        String str2 = this.f16938d;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.toLowerCase().hashCode())) * 19;
        String str3 = this.f16939e;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.toLowerCase().hashCode())) * 19;
        String str4 = this.f16940f;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.toLowerCase().hashCode())) * 19;
        String str5 = this.f16941g;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.toLowerCase().hashCode())) * 19;
        JSONObject jSONObject = this.f16942h;
        int hashCode6 = ((hashCode5 + (jSONObject != null ? jSONObject.toString().toLowerCase().hashCode() : 0)) * 19) + this.f16943i;
        Collection<String> collection = this.a;
        if (collection != null) {
            for (String str6 : collection) {
                hashCode6 = (hashCode6 * 19) + str6.toLowerCase().hashCode();
            }
        }
        return hashCode6;
    }

    public Collection<String> i() {
        return this.a;
    }

    public int j() {
        return this.f16937c;
    }

    public void k(String str) throws JSONException {
        if (str != null) {
            this.f16936b = str;
            put(m.Alias.h(), str);
        }
    }

    public void l(String str) throws JSONException {
        if (str != null) {
            this.f16941g = str;
            put(m.Campaign.h(), str);
        }
    }

    public void m(String str) throws JSONException {
        if (str != null) {
            this.f16938d = str;
            put(m.Channel.h(), str);
        }
    }

    public void n(int i2) throws JSONException {
        if (i2 > 0) {
            this.f16943i = i2;
            put(m.Duration.h(), i2);
        }
    }

    public void o(String str) throws JSONException {
        if (str != null) {
            this.f16939e = str;
            put(m.Feature.h(), str);
        }
    }

    public void p(JSONObject jSONObject) throws JSONException {
        this.f16942h = jSONObject;
        put(m.Data.h(), jSONObject);
    }

    public void q(String str) throws JSONException {
        if (str != null) {
            this.f16940f = str;
            put(m.Stage.h(), str);
        }
    }

    public void r(Collection<String> collection) throws JSONException {
        if (collection != null) {
            this.a = collection;
            JSONArray jSONArray = new JSONArray();
            for (String str : collection) {
                jSONArray.put(str);
            }
            put(m.Tags.h(), jSONArray);
        }
    }

    public void s(int i2) throws JSONException {
        if (i2 != 0) {
            this.f16937c = i2;
            put(m.Type.h(), i2);
        }
    }
}