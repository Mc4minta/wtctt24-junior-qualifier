package io.branch.referral;

import android.content.Context;
import io.branch.referral.j;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ServerRequestActionCompleted.java */
/* loaded from: classes2.dex */
public class s extends r {

    /* renamed from: i  reason: collision with root package name */
    private final j.d f17117i;

    public s(String str, JSONObject jSONObject, Context context) {
        super(str, jSONObject, context);
        this.f17117i = null;
    }

    @Override // io.branch.referral.r
    public boolean A() {
        return true;
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
    public void v(e0 e0Var, b bVar) {
        if (e0Var.c() != null) {
            JSONObject c2 = e0Var.c();
            l lVar = l.BranchViewData;
            if (!c2.has(lVar.h()) || b.V().F == null || b.V().F.get() == null) {
                return;
            }
            String str = "";
            try {
                JSONObject j2 = j();
                if (j2 != null) {
                    l lVar2 = l.Event;
                    if (j2.has(lVar2.h())) {
                        str = j2.getString(lVar2.h());
                    }
                }
                if (b.V().F != null) {
                    JSONObject jSONObject = e0Var.c().getJSONObject(lVar.h());
                    j.k().r(jSONObject, str, b.V().F.get(), this.f17117i);
                }
            } catch (JSONException unused) {
                j.d dVar = this.f17117i;
                if (dVar != null) {
                    dVar.d(-201, "Unable to show branch view. Branch view received is invalid ", str);
                }
            }
        }
    }
}