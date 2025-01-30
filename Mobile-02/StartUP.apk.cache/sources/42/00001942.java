package com.coinbase.wallet.crypto.extensions;

import com.coinbase.wallet.core.extensions.ByteArray_CoreKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.core.util.ByteArrays;
import com.coinbase.wallet.crypto.ciphers.AES256GCM;
import com.coinbase.wallet.crypto.exceptions.EncryptionException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.d;
import kotlin.o;
import org.spongycastle.jcajce.provider.digest.Keccak;

/* compiled from: String+Crypto.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\u001a!\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0006\u001a\u0019\u0010\u0004\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\n\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0011\u0010\f\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\f\u0010\r\"\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010\"\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0010¨\u0006\u0012"}, d2 = {"", "", "secret", "iv", "encryptUsingAES256GCM", "(Ljava/lang/String;[B[B)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;[B)Ljava/lang/String;", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "decryptUsingAES256GCM", "(Ljava/lang/String;Ljava/lang/String;)[B", "sha256", "(Ljava/lang/String;)Ljava/lang/String;", "keccak256", "(Ljava/lang/String;)[B", "", "kAES256GCMAuthTagSize", "I", "kAES256GCMIVSize", "crypto_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class String_CryptoKt {
    private static final int kAES256GCMAuthTagSize = 16;
    private static final int kAES256GCMIVSize = 12;

    public static final byte[] decryptUsingAES256GCM(String str, String secret) throws EncryptionException.UnableToDecryptData {
        byte[] h2;
        byte[] h3;
        byte[] h4;
        m.g(str, "<this>");
        m.g(secret, "secret");
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(str);
        if (asHexEncodedData != null) {
            byte[] asHexEncodedData2 = String_CoreKt.asHexEncodedData(secret);
            if (asHexEncodedData2 != null) {
                if (asHexEncodedData.length >= 28) {
                    try {
                        h2 = kotlin.a0.m.h(asHexEncodedData, 0, 12);
                        h3 = kotlin.a0.m.h(asHexEncodedData, 12, 28);
                        h4 = kotlin.a0.m.h(asHexEncodedData, 28, asHexEncodedData.length);
                        return AES256GCM.Companion.decrypt(h4, asHexEncodedData2, h2, h3);
                    } catch (Exception unused) {
                        throw EncryptionException.UnableToDecryptData.INSTANCE;
                    }
                }
                throw EncryptionException.UnableToDecryptData.INSTANCE;
            }
            throw EncryptionException.UnableToDecryptData.INSTANCE;
        }
        throw EncryptionException.UnableToDecryptData.INSTANCE;
    }

    public static final String encryptUsingAES256GCM(String str, byte[] secret, byte[] iv) throws EncryptionException.UnableToEncryptData {
        byte[] n;
        byte[] n2;
        m.g(str, "<this>");
        m.g(secret, "secret");
        m.g(iv, "iv");
        try {
            byte[] bytes = str.getBytes(d.a);
            m.f(bytes, "(this as java.lang.String).getBytes(charset)");
            o<byte[], byte[]> encrypt = AES256GCM.Companion.encrypt(bytes, secret, iv);
            n = kotlin.a0.m.n(iv, encrypt.b());
            n2 = kotlin.a0.m.n(n, encrypt.a());
            return String_CoreKt.strip0x(ByteArray_CoreKt.toPrefixedHexString(n2));
        } catch (IllegalAccessException unused) {
            throw EncryptionException.UnableToEncryptData.INSTANCE;
        }
    }

    public static final byte[] keccak256(String str) {
        m.g(str, "<this>");
        Keccak.Digest256 digest256 = new Keccak.Digest256();
        byte[] bytes = str.getBytes(d.a);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        digest256.update(bytes);
        byte[] digest = digest256.digest();
        m.f(digest, "md.digest()");
        return digest;
    }

    public static final String sha256(String str) throws NoSuchAlgorithmException {
        m.g(str, "<this>");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = str.getBytes(d.a);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        byte[] digest = messageDigest.digest();
        m.f(digest, "md.digest()");
        return ByteArray_CryptoKt.toHexString(digest);
    }

    public static final String encryptUsingAES256GCM(String str, String secret, byte[] iv) throws EncryptionException.UnableToEncryptData {
        m.g(str, "<this>");
        m.g(secret, "secret");
        m.g(iv, "iv");
        byte[] asHexEncodedData = String_CoreKt.asHexEncodedData(secret);
        if (asHexEncodedData != null) {
            return encryptUsingAES256GCM(str, asHexEncodedData, iv);
        }
        throw EncryptionException.UnableToEncryptData.INSTANCE;
    }

    public static final String encryptUsingAES256GCM(String str, String secret) throws EncryptionException.UnableToEncryptData {
        m.g(str, "<this>");
        m.g(secret, "secret");
        return encryptUsingAES256GCM(str, secret, ByteArrays.Companion.randomBytes(12));
    }
}