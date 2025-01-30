package e.j.n.p3;

import kotlin.l0.x;

/* compiled from: SetupPinLockViewModel.kt */
/* loaded from: classes2.dex */
public final class q extends m {
    @Override // e.j.n.p3.m
    protected void o(String pinCode) {
        boolean B;
        kotlin.jvm.internal.m.g(pinCode, "pinCode");
        B = x.B(j(), pinCode, false, 2, null);
        if (B) {
            k().l(p.CONFIRMED);
            e(pinCode);
            return;
        }
        k().l(p.NOT_MATCHING);
        e.j.f.q.a(i());
    }
}