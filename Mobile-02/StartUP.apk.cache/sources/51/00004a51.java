package e.j.l.t;

import com.toshi.exception.DeviceNotSecureException;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: ErrorHandling.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final int a(Throwable throwable) {
        m.g(throwable, "throwable");
        return throwable instanceof DeviceNotSecureException ? R.string.activate_secure_lock_screen : R.string.unable_to_restore_wallet;
    }
}