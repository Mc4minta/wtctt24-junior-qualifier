package com.coinbase.wallet.crypto.ciphers;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.t;

/* compiled from: AES256GCM.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/coinbase/wallet/crypto/ciphers/AES256GCM;", "", "<init>", "()V", "Companion", "crypto_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AES256GCM {
    private static final int AUTH_TAG_SIZE = 128;
    public static final Companion Companion = new Companion(null);
    private static final String TRANSFORMATION = "AES/GCM/NoPadding";

    /* compiled from: AES256GCM.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0007\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0007\u0010\fJ-\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/crypto/ciphers/AES256GCM$Companion;", "", "", "data", "key", "iv", "Lkotlin/o;", "encrypt", "([B[B[B)Lkotlin/o;", "Ljavax/crypto/SecretKey;", "secretKey", "Lkotlin/t;", "([BLjavax/crypto/SecretKey;)Lkotlin/t;", "authTag", "decrypt", "([B[B[B[B)[B", "([BLjavax/crypto/SecretKey;[B[B)[B", "", "AUTH_TAG_SIZE", "I", "", "TRANSFORMATION", "Ljava/lang/String;", "<init>", "()V", "crypto_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final byte[] decrypt(byte[] data, byte[] key, byte[] iv, byte[] authTag) {
            byte[] n;
            m.g(data, "data");
            m.g(key, "key");
            m.g(iv, "iv");
            m.g(authTag, "authTag");
            CipherLock cipherLock = CipherLock.INSTANCE;
            cipherLock.lock();
            try {
                Cipher cipher = Cipher.getInstance(AES256GCM.TRANSFORMATION);
                GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, iv);
                SecretKeySpec secretKeySpec = new SecretKeySpec(key, "AES");
                n = kotlin.a0.m.n(data, authTag);
                cipher.init(2, secretKeySpec, gCMParameterSpec);
                byte[] doFinal = cipher.doFinal(n);
                m.f(doFinal, "cipher.doFinal(encryptedData)");
                return doFinal;
            } finally {
                cipherLock.unlock();
            }
        }

        public final o<byte[], byte[]> encrypt(byte[] data, byte[] key, byte[] iv) {
            byte[] h2;
            byte[] h3;
            m.g(data, "data");
            m.g(key, "key");
            m.g(iv, "iv");
            CipherLock cipherLock = CipherLock.INSTANCE;
            cipherLock.lock();
            try {
                Cipher cipher = Cipher.getInstance(AES256GCM.TRANSFORMATION);
                cipher.init(1, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, iv));
                byte[] cipherBytes = cipher.doFinal(data);
                int length = cipherBytes.length - 16;
                m.f(cipherBytes, "cipherBytes");
                h2 = kotlin.a0.m.h(cipherBytes, 0, length);
                h3 = kotlin.a0.m.h(cipherBytes, length, cipherBytes.length);
                return new o<>(h2, h3);
            } finally {
                cipherLock.unlock();
            }
        }

        public final byte[] decrypt(byte[] data, SecretKey secretKey, byte[] iv, byte[] authTag) {
            byte[] n;
            m.g(data, "data");
            m.g(secretKey, "secretKey");
            m.g(iv, "iv");
            m.g(authTag, "authTag");
            CipherLock cipherLock = CipherLock.INSTANCE;
            cipherLock.lock();
            try {
                Cipher cipher = Cipher.getInstance(AES256GCM.TRANSFORMATION);
                GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(128, iv);
                n = kotlin.a0.m.n(data, authTag);
                cipher.init(2, secretKey, gCMParameterSpec);
                byte[] doFinal = cipher.doFinal(n);
                m.f(doFinal, "cipher.doFinal(encryptedData)");
                return doFinal;
            } finally {
                cipherLock.unlock();
            }
        }

        public final t<byte[], byte[], byte[]> encrypt(byte[] data, SecretKey secretKey) {
            byte[] h2;
            byte[] h3;
            m.g(data, "data");
            m.g(secretKey, "secretKey");
            CipherLock cipherLock = CipherLock.INSTANCE;
            cipherLock.lock();
            try {
                Cipher cipher = Cipher.getInstance(AES256GCM.TRANSFORMATION);
                cipher.init(1, secretKey);
                byte[] cipherBytes = cipher.doFinal(data);
                int length = cipherBytes.length - 16;
                m.f(cipherBytes, "cipherBytes");
                h2 = kotlin.a0.m.h(cipherBytes, 0, length);
                h3 = kotlin.a0.m.h(cipherBytes, length, cipherBytes.length);
                return new t<>(cipher.getIV(), h3, h2);
            } finally {
                cipherLock.unlock();
            }
        }
    }
}