package e.j.f;

import android.content.Intent;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

/* compiled from: ThrowableExtensions.kt */
/* loaded from: classes2.dex */
public final class w {
    public static final Intent a(Throwable th) {
        if (th instanceof UserRecoverableAuthException) {
            return ((UserRecoverableAuthException) th).a();
        }
        if (th instanceof UserRecoverableAuthIOException) {
            return ((UserRecoverableAuthIOException) th).c();
        }
        return null;
    }

    public static final boolean b(Throwable th) {
        return th != null && ((th instanceof KeyPermanentlyInvalidatedException) || (th.getCause() instanceof KeyPermanentlyInvalidatedException));
    }
}