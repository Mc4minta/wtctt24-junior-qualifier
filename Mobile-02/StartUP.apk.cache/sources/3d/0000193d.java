package com.coinbase.wallet.crypto.ciphers;

import android.os.Build;
import android.security.keystore.KeyGenParameterSpec;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: KeyStores.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ-\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\u000fJ\u001d\u0010\u0010\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0013\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/crypto/ciphers/KeyStores;", "", "", "alias", "", "isAuthenticated", "isBiometricProtected", "Landroid/security/keystore/KeyGenParameterSpec;", "buildGCMBiometricSpec", "(Ljava/lang/String;ZZ)Landroid/security/keystore/KeyGenParameterSpec;", "keystore", "Ljavax/crypto/SecretKey;", "getOrCreateAESSecretKey", "(Ljava/lang/String;Ljava/lang/String;ZZ)Ljavax/crypto/SecretKey;", "spec", "(Ljava/lang/String;Landroid/security/keystore/KeyGenParameterSpec;)Ljavax/crypto/SecretKey;", "contains", "(Ljava/lang/String;Ljava/lang/String;)Z", "Lkotlin/x;", "delete", "(Ljava/lang/String;Ljava/lang/String;)V", "<init>", "()V", "crypto_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class KeyStores {
    public static final KeyStores INSTANCE = new KeyStores();

    private KeyStores() {
    }

    public final KeyGenParameterSpec buildGCMBiometricSpec(String alias, boolean z, boolean z2) {
        m.g(alias, "alias");
        if (!z2 && Build.VERSION.SDK_INT >= 24) {
            KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(alias, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setInvalidatedByBiometricEnrollment(false).setUserAuthenticationRequired(z).setRandomizedEncryptionRequired(z).build();
            m.f(build, "{\n            KeyGenParameterSpec\n                .Builder(alias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)\n                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)\n                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)\n                .setInvalidatedByBiometricEnrollment(false)\n                .setUserAuthenticationRequired(isAuthenticated)\n                .setRandomizedEncryptionRequired(isAuthenticated)\n                .build()\n        }");
            return build;
        }
        KeyGenParameterSpec build2 = new KeyGenParameterSpec.Builder(alias, 3).setBlockModes("GCM").setEncryptionPaddings("NoPadding").setUserAuthenticationRequired(z).setRandomizedEncryptionRequired(z).build();
        m.f(build2, "{\n            KeyGenParameterSpec\n                .Builder(alias, KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT)\n                .setBlockModes(KeyProperties.BLOCK_MODE_GCM)\n                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)\n                .setUserAuthenticationRequired(isAuthenticated)\n                .setRandomizedEncryptionRequired(isAuthenticated)\n                .build()\n        }");
        return build2;
    }

    public final boolean contains(String keystore, String alias) {
        m.g(keystore, "keystore");
        m.g(alias, "alias");
        CipherLock cipherLock = CipherLock.INSTANCE;
        cipherLock.lock();
        try {
            KeyStore keyStore = KeyStore.getInstance(keystore);
            keyStore.load(null);
            return keyStore.containsAlias(alias);
        } finally {
            cipherLock.unlock();
        }
    }

    public final void delete(String keystore, String alias) {
        m.g(keystore, "keystore");
        m.g(alias, "alias");
        CipherLock cipherLock = CipherLock.INSTANCE;
        cipherLock.lock();
        try {
            KeyStore keyStore = KeyStore.getInstance(keystore);
            keyStore.load(null);
            if (keyStore.containsAlias(alias)) {
                keyStore.deleteEntry(alias);
            }
            x xVar = x.a;
        } finally {
            cipherLock.unlock();
        }
    }

    public final SecretKey getOrCreateAESSecretKey(String keystore, String alias, boolean z, boolean z2) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        m.g(keystore, "keystore");
        m.g(alias, "alias");
        return getOrCreateAESSecretKey(keystore, buildGCMBiometricSpec(alias, z, z2));
    }

    public final SecretKey getOrCreateAESSecretKey(String keystore, KeyGenParameterSpec spec) throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableEntryException {
        m.g(keystore, "keystore");
        m.g(spec, "spec");
        CipherLock cipherLock = CipherLock.INSTANCE;
        cipherLock.lock();
        try {
            KeyStore keyStore = KeyStore.getInstance(keystore);
            SecretKey secretKey = null;
            keyStore.load(null);
            KeyStore.Entry entry = keyStore.getEntry(spec.getKeystoreAlias(), null);
            KeyStore.SecretKeyEntry secretKeyEntry = entry instanceof KeyStore.SecretKeyEntry ? (KeyStore.SecretKeyEntry) entry : null;
            if (secretKeyEntry != null) {
                secretKey = secretKeyEntry.getSecretKey();
            }
            if (secretKey != null) {
                return secretKey;
            }
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", keystore);
            keyGenerator.init(spec);
            SecretKey generateKey = keyGenerator.generateKey();
            m.f(generateKey, "keyGenerator.generateKey()");
            return generateKey;
        } finally {
            cipherLock.unlock();
        }
    }
}