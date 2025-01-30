package androidx.navigation;

import android.os.Bundle;
import androidx.navigation.s;

/* compiled from: NavGraphNavigator.java */
@s.b("navigation")
/* loaded from: classes.dex */
public class m extends s<l> {
    private final t a;

    public m(t tVar) {
        this.a = tVar;
    }

    @Override // androidx.navigation.s
    /* renamed from: a */
    public l createDestination() {
        return new l(this);
    }

    @Override // androidx.navigation.s
    /* renamed from: b */
    public k navigate(l lVar, Bundle bundle, p pVar, s.a aVar) {
        int J = lVar.J();
        if (J != 0) {
            k H = lVar.H(J, false);
            if (H != null) {
                return this.a.d(H.t()).navigate(H, H.k(bundle), pVar, aVar);
            }
            String I = lVar.I();
            throw new IllegalArgumentException("navigation destination " + I + " is not a direct child of this NavGraph");
        }
        throw new IllegalStateException("no start destination defined via app:startDestination for " + lVar.p());
    }

    @Override // androidx.navigation.s
    public boolean popBackStack() {
        return true;
    }
}