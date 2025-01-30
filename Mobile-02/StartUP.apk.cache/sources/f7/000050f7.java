package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestGetRewardHistory.java */
/* loaded from: classes2.dex */
public class u extends r {

    /* renamed from: i  reason: collision with root package name */
    b.e f17122i;

    public u(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f17122i = null;
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        b.e eVar = this.f17122i;
        if (eVar != null) {
            eVar.a(null, new d("Trouble retrieving user credit history. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return false;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        b.e eVar = this.f17122i;
        if (eVar != null) {
            eVar.a(e0Var.a(), null);
        }
    }
}