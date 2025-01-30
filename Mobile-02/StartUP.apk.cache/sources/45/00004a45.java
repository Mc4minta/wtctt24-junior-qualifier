package e.j.l.p;

import android.os.Build;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import javax.crypto.IllegalBlockSizeException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: DecryptionEdgeCaseHandler.kt */
/* loaded from: classes2.dex */
public final class e {
    public static final a a = new a(null);

    /* compiled from: DecryptionEdgeCaseHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean a(Throwable th) {
            boolean Q;
            Q = x.Q(String.valueOf(th), "android.security.KeyStoreException: Key user not authenticated", false, 2, null);
            return Q;
        }

        private final boolean c(Exception exc) {
            return Build.VERSION.SDK_INT >= 26 && (exc instanceof IllegalBlockSizeException) && a(exc.getCause());
        }

        public final Exception b(Exception e2) {
            m.g(e2, "e");
            return c(e2) ? new KeyPermanentlyInvalidatedException() : e2;
        }
    }
}