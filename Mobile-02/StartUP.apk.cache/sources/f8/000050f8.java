package io.branch.referral;

import android.content.Context;
import io.branch.referral.b;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestGetRewards.java */
/* loaded from: classes2.dex */
public class v extends r {

    /* renamed from: i  reason: collision with root package name */
    b.h f17123i;

    public v(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
    }

    @Override // io.branch.referral.r
    public void b() {
        this.f17123i = null;
    }

    @Override // io.branch.referral.r
    public String n() {
        return super.n() + this.f17104c.y();
    }

    @Override // io.branch.referral.r
    public void o(int i2, String str) {
        b.h hVar = this.f17123i;
        if (hVar != null) {
            hVar.a(false, new d("Trouble retrieving user credits. " + str, i2));
        }
    }

    @Override // io.branch.referral.r
    public boolean q() {
        return true;
    }

    @Override // io.branch.referral.r
    public void v(e0 e0Var, b bVar) {
        Iterator<String> keys = e0Var.c().keys();
        boolean z = false;
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                int i2 = e0Var.c().getInt(next);
                if (i2 != this.f17104c.r(next)) {
                    z = true;
                }
                this.f17104c.g0(next, i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        b.h hVar = this.f17123i;
        if (hVar != null) {
            hVar.a(z, null);
        }
    }
}