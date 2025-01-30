package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestRedeemRewards.java */
/* loaded from: classes2.dex */
public class a0 extends r {

    /* renamed from: i  reason: collision with root package name */
    b.h f16910i;

    /* renamed from: j  reason: collision with root package name */
    int f16911j;

    public a0(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f16911j = 0;
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f16910i = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        b.h hVar = this.f16910i;
        if (hVar != null) {
            hVar.a(false, new d("Trouble redeeming rewards. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        JSONObject j2 = j();
        if (j2 != null) {
            l lVar = l.Bucket;
            if (j2.has(lVar.h())) {
                l lVar2 = l.Amount;
                if (j2.has(lVar2.h())) {
                    try {
                        int i2 = j2.getInt(lVar2.h());
                        String string = j2.getString(lVar.h());
                        r5 = i2 > 0;
                        this.f17104c.g0(string, this.f17104c.r(string) - i2);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
        if (this.f16910i != null) {
            this.f16910i.a(r5, r5 ? null : new d("Trouble redeeming rewards.", -107));
        }
    }
}