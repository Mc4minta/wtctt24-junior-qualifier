package e.j.d.f;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: CipherGenerator.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final C0317a a = new C0317a(null);

    /* compiled from: CipherGenerator.kt */
    /* renamed from: e.j.d.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0317a {
        private C0317a() {
        }

        public /* synthetic */ C0317a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final Cipher a(SecretKey secretKey, byte[] iv) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedOperationException {
        m.g(secretKey, "secretKey");
        m.g(iv, "iv");
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, iv);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, secretKey, gCMParameterSpec);
        m.f(cipher, "cipher");
        return cipher;
    }

    public final Cipher b(SecretKey secretKey) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedOperationException {
        m.g(secretKey, "secretKey");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, secretKey);
        m.f(cipher, "cipher");
        return cipher;
    }
}