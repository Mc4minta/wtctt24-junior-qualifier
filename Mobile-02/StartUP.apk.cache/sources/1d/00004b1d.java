package e.j.n.p3;

import androidx.lifecycle.b0;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;

/* compiled from: PinLockViewModel.kt */
/* loaded from: classes2.dex */
public final class n extends b0 {
    private final AppLockRepositoryInterface a;

    public n(AppLockRepositoryInterface appLockRepository) {
        kotlin.jvm.internal.m.g(appLockRepository, "appLockRepository");
        this.a = appLockRepository;
    }

    public final h.c.b0<Boolean> a(String pin) {
        kotlin.jvm.internal.m.g(pin, "pin");
        return this.a.isValidPermit(new e.j.d.d(pin));
    }
}