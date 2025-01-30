package e.j.d.g;

import com.coinbase.wallet.common.annotations.AppCoreScoped;
import com.toshi.exception.PinException;
import h.c.b0;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.concurrent.Callable;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/* compiled from: PinKeyHandler.kt */
@AppCoreScoped
/* loaded from: classes2.dex */
public final class y {
    private final e.j.j.n a;

    /* renamed from: b */
    private final e.j.d.f.e f13577b;

    /* renamed from: c */
    private final e.j.d.f.c f13578c;

    public y(e.j.j.n pinPrefs, e.j.d.f.e encryptor, e.j.d.f.c decryptor) {
        kotlin.jvm.internal.m.g(pinPrefs, "pinPrefs");
        kotlin.jvm.internal.m.g(encryptor, "encryptor");
        kotlin.jvm.internal.m.g(decryptor, "decryptor");
        this.a = pinPrefs;
        this.f13577b = encryptor;
        this.f13578c = decryptor;
    }

    public static final String b(y this$0, String encryptedMasterSeed, String pin) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(encryptedMasterSeed, "$encryptedMasterSeed");
        kotlin.jvm.internal.m.g(pin, "$pin");
        try {
            return this$0.c(encryptedMasterSeed, pin);
        } catch (Exception e2) {
            if (e2 instanceof InvalidKeyException ? true : e2 instanceof InvalidAlgorithmParameterException ? true : e2 instanceof NoSuchAlgorithmException ? true : e2 instanceof NoSuchPaddingException ? true : e2 instanceof IllegalBlockSizeException ? true : e2 instanceof BadPaddingException ? true : e2 instanceof UnsupportedEncodingException ? true : e2 instanceof AEADBadTagException ? true : e2 instanceof IllegalArgumentException ? true : e2 instanceof UnsupportedOperationException ? true : e2 instanceof InvalidKeySpecException) {
                throw new PinException(e2);
            }
            throw e2;
        }
    }

    private final String c(String str, String str2) throws IllegalStateException, PinException {
        try {
            byte[] salt = this.a.getSalt();
            if (salt != null) {
                e.j.d.h.a aVar = new e.j.d.h.a();
                Charset charset = kotlin.l0.d.a;
                if (str2 != null) {
                    byte[] bytes = str2.getBytes(charset);
                    kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
                    return this.f13578c.d(aVar.a(bytes, salt), str);
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new IllegalStateException("Salt is null when decrypting");
        } catch (Exception e2) {
            if (e2 instanceof InvalidKeyException ? true : e2 instanceof InvalidAlgorithmParameterException ? true : e2 instanceof NoSuchAlgorithmException ? true : e2 instanceof NoSuchPaddingException ? true : e2 instanceof IllegalBlockSizeException ? true : e2 instanceof BadPaddingException ? true : e2 instanceof UnsupportedEncodingException ? true : e2 instanceof AEADBadTagException ? true : e2 instanceof IllegalArgumentException ? true : e2 instanceof UnsupportedOperationException ? true : e2 instanceof InvalidKeySpecException) {
                throw new PinException(e2);
            }
            throw e2;
        }
    }

    public static final String e(y this$0, String unencryptedMasterSeed, String newPin) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unencryptedMasterSeed, "$unencryptedMasterSeed");
        kotlin.jvm.internal.m.g(newPin, "$newPin");
        try {
            return this$0.f(unencryptedMasterSeed, newPin);
        } catch (Exception e2) {
            if (e2 instanceof IllegalStateException ? true : e2 instanceof InvalidKeyException ? true : e2 instanceof InvalidAlgorithmParameterException ? true : e2 instanceof NoSuchAlgorithmException ? true : e2 instanceof NoSuchPaddingException ? true : e2 instanceof IllegalBlockSizeException ? true : e2 instanceof BadPaddingException ? true : e2 instanceof UnsupportedEncodingException ? true : e2 instanceof UnsupportedOperationException) {
                throw new PinException(e2);
            }
            throw e2;
        }
    }

    private final String f(String str, String str2) throws PinException {
        try {
            e.j.d.h.a aVar = new e.j.d.h.a();
            byte[] b2 = aVar.b();
            Charset charset = kotlin.l0.d.a;
            if (str2 != null) {
                byte[] bytes = str2.getBytes(charset);
                kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
                SecretKey a = aVar.a(bytes, b2);
                Charset UTF_8 = StandardCharsets.UTF_8;
                kotlin.jvm.internal.m.f(UTF_8, "UTF_8");
                if (str != null) {
                    byte[] bytes2 = str.getBytes(UTF_8);
                    kotlin.jvm.internal.m.f(bytes2, "(this as java.lang.String).getBytes(charset)");
                    String e2 = this.f13577b.e(a, bytes2);
                    this.a.a(b2);
                    return e2;
                }
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        } catch (Exception e3) {
            if (e3 instanceof InvalidKeyException ? true : e3 instanceof InvalidAlgorithmParameterException ? true : e3 instanceof NoSuchAlgorithmException ? true : e3 instanceof NoSuchPaddingException ? true : e3 instanceof IllegalBlockSizeException ? true : e3 instanceof BadPaddingException ? true : e3 instanceof UnsupportedEncodingException ? true : e3 instanceof UnsupportedOperationException) {
                throw new PinException(e3);
            }
            throw e3;
        }
    }

    public static /* synthetic */ String g(y yVar, String str, String str2) {
        return e(yVar, str, str2);
    }

    public static /* synthetic */ String h(y yVar, String str, String str2) {
        return b(yVar, str, str2);
    }

    public final b0<String> a(final String encryptedMasterSeed, final String pin) {
        kotlin.jvm.internal.m.g(encryptedMasterSeed, "encryptedMasterSeed");
        kotlin.jvm.internal.m.g(pin, "pin");
        b0<String> fromCallable = b0.fromCallable(new Callable() { // from class: e.j.d.g.s
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.h(y.this, encryptedMasterSeed, pin);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        try {\n            decryptSynchronous(encryptedMasterSeed = encryptedMasterSeed, pin = pin)\n        } catch (e: Exception) {\n            throw when (e) {\n                is InvalidKeyException,\n                is InvalidAlgorithmParameterException,\n                is NoSuchAlgorithmException,\n                is NoSuchPaddingException,\n                is IllegalBlockSizeException,\n                is BadPaddingException,\n                is UnsupportedEncodingException,\n                is AEADBadTagException,\n                is IllegalArgumentException,\n                is UnsupportedOperationException,\n                is InvalidKeySpecException -> PinException(e)\n                else -> e\n            }\n        }\n    }");
        return fromCallable;
    }

    public final b0<String> d(final String unencryptedMasterSeed, final String newPin) {
        kotlin.jvm.internal.m.g(unencryptedMasterSeed, "unencryptedMasterSeed");
        kotlin.jvm.internal.m.g(newPin, "newPin");
        b0<String> fromCallable = b0.fromCallable(new Callable() { // from class: e.j.d.g.r
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return y.g(y.this, unencryptedMasterSeed, newPin);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n        try {\n            encryptSynchronous(unencryptedMasterSeed = unencryptedMasterSeed, newPin = newPin)\n        } catch (e: Exception) {\n            throw when (e) {\n                is IllegalStateException,\n                is InvalidKeyException,\n                is InvalidAlgorithmParameterException,\n                is NoSuchAlgorithmException,\n                is NoSuchPaddingException,\n                is IllegalBlockSizeException,\n                is BadPaddingException,\n                is UnsupportedEncodingException,\n                is UnsupportedOperationException -> PinException(e)\n                else -> e\n            }\n        }\n    }");
        return fromCallable;
    }
}