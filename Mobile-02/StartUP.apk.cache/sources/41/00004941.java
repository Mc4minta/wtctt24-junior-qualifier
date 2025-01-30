package e.j.d.g;

import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyPermanentlyInvalidatedException;
import androidx.biometric.BiometricPrompt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.application.model.BiometricsProtectionType;
import com.coinbase.wallet.application.repository.MnemonicRepository;
import com.coinbase.wallet.crypto.ciphers.KeyStores;
import com.toshi.exception.KeyStoreException;
import h.c.b0;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableEntryException;
import java.util.concurrent.Callable;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KeyStoreKeyHandler.kt */
/* loaded from: classes2.dex */
public final class t {
    public static final a a = new a(null);

    /* renamed from: b */
    private static final KeyGenParameterSpec f13551b;

    /* renamed from: c */
    private static final KeyGenParameterSpec f13552c;

    /* renamed from: d */
    private static final KeyGenParameterSpec f13553d;

    /* renamed from: e */
    private final e.j.d.f.e f13554e;

    /* renamed from: f */
    private final e.j.d.f.c f13555f;

    /* renamed from: g */
    private final MnemonicRepository f13556g;

    /* compiled from: KeyStoreKeyHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: KeyStoreKeyHandler.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BiometricsProtectionType.values().length];
            iArr[BiometricsProtectionType.anyBiometrics.ordinal()] = 1;
            iArr[BiometricsProtectionType.currentBiometrics.ordinal()] = 2;
            iArr[BiometricsProtectionType.legacy.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        KeyStores keyStores = KeyStores.INSTANCE;
        f13551b = keyStores.buildGCMBiometricSpec("SecureMasterSeedCurrentBiometrics", true, true);
        f13552c = keyStores.buildGCMBiometricSpec("SecureMasterSeedAllBiometrics", true, false);
        f13553d = keyStores.buildGCMBiometricSpec("SecureMasterSeedAlias", true, true);
    }

    public t(e.j.d.f.e encryptor, e.j.d.f.c decryptor, MnemonicRepository mnemonicRepository) {
        kotlin.jvm.internal.m.g(encryptor, "encryptor");
        kotlin.jvm.internal.m.g(decryptor, "decryptor");
        kotlin.jvm.internal.m.g(mnemonicRepository, "mnemonicRepository");
        this.f13554e = encryptor;
        this.f13555f = decryptor;
        this.f13556g = mnemonicRepository;
    }

    public static final String d(t this$0, String encrypted, e.j.d.a permit) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(encrypted, "$encrypted");
        kotlin.jvm.internal.m.g(permit, "$permit");
        try {
            return this$0.f13555f.b(encrypted, permit.a());
        } catch (Exception e2) {
            if (e2 instanceof IllegalBlockSizeException ? true : e2 instanceof BadPaddingException ? true : e2 instanceof UnsupportedEncodingException) {
                throw new IllegalStateException(e2);
            }
            throw e2;
        }
    }

    public static final String h(t this$0, String unencrypted, e.j.d.a permit) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(unencrypted, "$unencrypted");
        kotlin.jvm.internal.m.g(permit, "$permit");
        try {
            return this$0.f13554e.c(unencrypted, permit.a());
        } catch (Exception e2) {
            if (e2 instanceof BadPaddingException ? true : e2 instanceof IllegalBlockSizeException) {
                throw new IllegalStateException(e2);
            }
            throw e2;
        }
    }

    public static /* synthetic */ String j(t tVar, String str, e.j.d.a aVar) {
        return d(tVar, str, aVar);
    }

    public static /* synthetic */ String k(t tVar, String str, e.j.d.a aVar) {
        return h(tVar, str, aVar);
    }

    public final BiometricPrompt.d a(byte[] iv) throws KeyStoreException {
        SecretKey orCreateAESSecretKey;
        kotlin.jvm.internal.m.g(iv, "iv");
        try {
            int i2 = b.a[this.f13556g.getBiometricsProtectionType().ordinal()];
            if (i2 == 1) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13552c);
            } else if (i2 == 2) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13551b);
            } else if (i2 == 3) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13553d);
            } else {
                throw new KeyStoreException("No secret key found when creating a crypto object for decryption");
            }
            return new BiometricPrompt.d(new e.j.d.f.a().a(orCreateAESSecretKey, iv));
        } catch (Exception e2) {
            if (e2 instanceof UnrecoverableEntryException ? true : e2 instanceof NoSuchAlgorithmException ? true : e2 instanceof java.security.KeyStoreException ? true : e2 instanceof NoSuchPaddingException ? true : e2 instanceof InvalidKeyException ? true : e2 instanceof InvalidAlgorithmParameterException ? true : e2 instanceof KeyPermanentlyInvalidatedException ? true : e2 instanceof IllegalStateException) {
                throw new KeyStoreException(e2);
            }
            throw e2;
        }
    }

    public final BiometricPrompt.d b(Boolean bool) throws KeyStoreException {
        SecretKey orCreateAESSecretKey;
        BiometricsProtectionType biometricsProtectionType = this.f13556g.getBiometricsProtectionType();
        try {
            if (kotlin.jvm.internal.m.c(bool, Boolean.TRUE)) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13551b);
            } else if (kotlin.jvm.internal.m.c(bool, Boolean.FALSE)) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13552c);
            } else if (biometricsProtectionType == BiometricsProtectionType.anyBiometrics) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13552c);
            } else if (biometricsProtectionType == BiometricsProtectionType.currentBiometrics) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13551b);
            } else if (biometricsProtectionType == BiometricsProtectionType.legacy) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13553d);
            } else {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13553d);
            }
            return new BiometricPrompt.d(new e.j.d.f.a().b(orCreateAESSecretKey));
        } catch (Exception e2) {
            if (e2 instanceof UnrecoverableEntryException ? true : e2 instanceof NoSuchAlgorithmException ? true : e2 instanceof NoSuchProviderException ? true : e2 instanceof InvalidAlgorithmParameterException ? true : e2 instanceof java.security.KeyStoreException ? true : e2 instanceof NoSuchPaddingException ? true : e2 instanceof InvalidKeyException ? true : e2 instanceof IllegalStateException) {
                throw new KeyStoreException(e2);
            }
            throw e2;
        }
    }

    public final b0<String> c(final String encrypted, final e.j.d.a permit) {
        kotlin.jvm.internal.m.g(encrypted, "encrypted");
        kotlin.jvm.internal.m.g(permit, "permit");
        b0 fromCallable = b0.fromCallable(new Callable() { // from class: e.j.d.g.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.j(t.this, encrypted, permit);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n            try {\n                decryptor.decrypt(encrypted, permit.cipher)\n            } catch (e: Exception) {\n                throw when (e) {\n                    is IllegalBlockSizeException,\n                    is BadPaddingException,\n                    is UnsupportedEncodingException -> IllegalStateException(e)\n                    else -> e\n                }\n            }\n        }");
        return Single_AnalyticsKt.logError$default(fromCallable, "Error while reading master seed from storage", null, 2, null);
    }

    public final void e() {
        boolean z;
        boolean z2 = true;
        try {
            KeyStores keyStores = KeyStores.INSTANCE;
            String keystoreAlias = f13551b.getKeystoreAlias();
            kotlin.jvm.internal.m.f(keystoreAlias, "currentBiometricsSpec.keystoreAlias");
            keyStores.delete("AndroidKeyStore", keystoreAlias);
            z = true;
        } catch (java.security.KeyStoreException unused) {
            z = false;
        }
        try {
            KeyStores keyStores2 = KeyStores.INSTANCE;
            String keystoreAlias2 = f13552c.getKeystoreAlias();
            kotlin.jvm.internal.m.f(keystoreAlias2, "anyBiometricsSpec.keystoreAlias");
            keyStores2.delete("AndroidKeyStore", keystoreAlias2);
            z = true;
        } catch (java.security.KeyStoreException unused2) {
        }
        try {
            KeyStores keyStores3 = KeyStores.INSTANCE;
            String keystoreAlias3 = f13553d.getKeystoreAlias();
            kotlin.jvm.internal.m.f(keystoreAlias3, "legacySpec.keystoreAlias");
            keyStores3.delete("AndroidKeyStore", keystoreAlias3);
        } catch (java.security.KeyStoreException unused3) {
            z2 = z;
        }
        if (z2) {
            return;
        }
        l.a.a.f(new KeyStoreException("Delete Failed"), "No keys found to delete", new Object[0]);
    }

    public final void f(BiometricsProtectionType biometricsProtectionType) {
        kotlin.jvm.internal.m.g(biometricsProtectionType, "biometricsProtectionType");
        try {
            int i2 = b.a[biometricsProtectionType.ordinal()];
            if (i2 == 1) {
                KeyStores keyStores = KeyStores.INSTANCE;
                String keystoreAlias = f13552c.getKeystoreAlias();
                kotlin.jvm.internal.m.f(keystoreAlias, "anyBiometricsSpec.keystoreAlias");
                keyStores.delete("AndroidKeyStore", keystoreAlias);
            } else if (i2 == 2) {
                KeyStores keyStores2 = KeyStores.INSTANCE;
                String keystoreAlias2 = f13551b.getKeystoreAlias();
                kotlin.jvm.internal.m.f(keystoreAlias2, "currentBiometricsSpec.keystoreAlias");
                keyStores2.delete("AndroidKeyStore", keystoreAlias2);
            } else if (i2 != 3) {
                throw new NoWhenBranchMatchedException();
            } else {
                KeyStores keyStores3 = KeyStores.INSTANCE;
                String keystoreAlias3 = f13553d.getKeystoreAlias();
                kotlin.jvm.internal.m.f(keystoreAlias3, "legacySpec.keystoreAlias");
                keyStores3.delete("AndroidKeyStore", keystoreAlias3);
            }
        } catch (java.security.KeyStoreException e2) {
            l.a.a.f(e2, "Unable to delete keystore private key", new Object[0]);
        }
    }

    public final b0<String> g(final String unencrypted, final e.j.d.a permit) {
        kotlin.jvm.internal.m.g(unencrypted, "unencrypted");
        kotlin.jvm.internal.m.g(permit, "permit");
        b0 fromCallable = b0.fromCallable(new Callable() { // from class: e.j.d.g.b
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return t.k(t.this, unencrypted, permit);
            }
        });
        kotlin.jvm.internal.m.f(fromCallable, "fromCallable {\n            try {\n                encryptor.encrypt(unencrypted, permit.cipher)\n            } catch (e: Exception) {\n                throw when (e) {\n                    is BadPaddingException,\n                    is IllegalBlockSizeException -> IllegalStateException(e)\n                    else -> e\n                }\n            }\n        }");
        return Single_AnalyticsKt.logError$default(fromCallable, "Error while saving master seed from storage", null, 2, null);
    }

    public final boolean i(byte[] iv) {
        SecretKey orCreateAESSecretKey;
        kotlin.jvm.internal.m.g(iv, "iv");
        try {
            int i2 = b.a[this.f13556g.getBiometricsProtectionType().ordinal()];
            if (i2 == 1) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13552c);
            } else if (i2 == 2) {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13551b);
            } else if (i2 != 3) {
                return false;
            } else {
                orCreateAESSecretKey = KeyStores.INSTANCE.getOrCreateAESSecretKey("AndroidKeyStore", f13553d);
            }
            new e.j.d.f.a().a(orCreateAESSecretKey, iv);
        } catch (Exception e2) {
            if (e2 instanceof KeyPermanentlyInvalidatedException) {
                return true;
            }
        }
        return false;
    }
}