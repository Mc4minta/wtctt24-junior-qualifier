package e.j.d.g;

import androidx.biometric.BiometricPrompt;
import com.toshi.model.local.authentication.AuthenticationMethod;
import h.c.b0;
import java.security.KeyStoreException;

/* compiled from: MasterSeedHandlerInterface.kt */
/* loaded from: classes2.dex */
public interface w {
    b0<String> a(String str, e.j.d.c cVar);

    BiometricPrompt.d b(Boolean bool) throws KeyStoreException;

    boolean c(byte[] bArr);

    b0<kotlin.x> changeBiometricPermit(e.j.d.a aVar, e.j.d.a aVar2) throws KeyStoreException;

    BiometricPrompt.d d(byte[] bArr) throws KeyStoreException;

    b0<AuthenticationMethod> e(String str, String str2) throws IllegalStateException;

    b0<String> f(e.j.d.c cVar);

    b0<AuthenticationMethod> switchAuthenticationMethodToBiometric(String str, e.j.d.a aVar) throws IllegalStateException;

    b0<AuthenticationMethod> switchAuthenticationMethodToPin(String str, e.j.d.a aVar) throws IllegalStateException;
}