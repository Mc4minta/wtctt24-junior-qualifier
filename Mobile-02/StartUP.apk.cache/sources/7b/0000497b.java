package e.j.g;

import android.app.KeyguardManager;
import com.coinbase.wallet.application.BaseApplication;
import kotlin.h;
import kotlin.jvm.internal.o;
import kotlin.k;

/* compiled from: KeyguardManagerWrapper.kt */
/* loaded from: classes2.dex */
public final class b implements e.j.g.a {
    private final h a;

    /* compiled from: KeyguardManagerWrapper.kt */
    /* loaded from: classes2.dex */
    static final class a extends o implements kotlin.e0.c.a<KeyguardManager> {
        public static final a a = new a();

        a() {
            super(0);
        }

        @Override // kotlin.e0.c.a
        /* renamed from: a */
        public final KeyguardManager invoke() {
            Object systemService = BaseApplication.Companion.getInstance().getSystemService("keyguard");
            KeyguardManager keyguardManager = systemService instanceof KeyguardManager ? (KeyguardManager) systemService : null;
            if (keyguardManager != null) {
                return keyguardManager;
            }
            throw new IllegalStateException("Unable to get keyguard system service");
        }
    }

    public b() {
        h b2;
        b2 = k.b(a.a);
        this.a = b2;
    }

    private final KeyguardManager b() {
        return (KeyguardManager) this.a.getValue();
    }

    @Override // e.j.g.a
    public boolean a() {
        return b().isDeviceSecure();
    }
}