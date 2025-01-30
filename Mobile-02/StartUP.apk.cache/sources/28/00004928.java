package e.j.d.f;

import com.toshi.exception.Base64Exception;
import e.j.l.o.a;
import e.j.l.p.d;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;

/* compiled from: Decryptor.kt */
/* loaded from: classes2.dex */
public final class c {
    private final e.j.d.f.a a;

    /* renamed from: b  reason: collision with root package name */
    private final e.j.l.o.a f13527b;

    /* renamed from: c  reason: collision with root package name */
    private final e.j.l.p.b f13528c;

    /* compiled from: Decryptor.kt */
    /* loaded from: classes2.dex */
    static final class a extends o implements l<byte[], byte[]> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Cipher f13529b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Cipher cipher) {
            super(1);
            this.f13529b = cipher;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final byte[] invoke(byte[] it) {
            m.g(it, "it");
            return c.this.g(this.f13529b, it);
        }
    }

    public c(e.j.d.f.a cipherGenerator, e.j.l.o.a base64Util, e.j.l.p.b cryptoErrorUtil) {
        m.g(cipherGenerator, "cipherGenerator");
        m.g(base64Util, "base64Util");
        m.g(cryptoErrorUtil, "cryptoErrorUtil");
        this.a = cipherGenerator;
        this.f13527b = base64Util;
        this.f13528c = cryptoErrorUtil;
    }

    private final byte[] f(Cipher cipher, byte[] bArr) {
        try {
            byte[] doFinal = cipher.doFinal(bArr);
            m.f(doFinal, "cipher.doFinal(cipherText)");
            return doFinal;
        } catch (Exception e2) {
            this.f13528c.d("Decryption failed", e2, cipher);
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] g(Cipher cipher, byte[] bArr) {
        try {
            byte[] doFinal = cipher.doFinal(bArr);
            m.f(doFinal, "cipher.doFinal(cipherText)");
            return doFinal;
        } catch (Exception e2) {
            this.f13528c.d("Decryption failed", e2, cipher);
            throw e.j.l.p.e.a.b(e2);
        }
    }

    public final String b(String encryptedData, Cipher cipher) throws IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, AEADBadTagException, IllegalArgumentException {
        m.g(encryptedData, "encryptedData");
        m.g(cipher, "cipher");
        byte[] iv = cipher.getIV();
        m.f(iv, "cipher.iv");
        return c(encryptedData, iv, new a(cipher));
    }

    public final String c(String encryptedData, byte[] iv, l<? super byte[], byte[]> predicate) {
        m.g(encryptedData, "encryptedData");
        m.g(iv, "iv");
        m.g(predicate, "predicate");
        byte[] a2 = this.f13527b.a(encryptedData, a.EnumC0327a.DEFAULT);
        if (a2 != null) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            m.f(UTF_8, "UTF_8");
            return new String(predicate.invoke(e.j.l.p.d.a.d(a2, iv)), UTF_8);
        }
        throw new Base64Exception("Result is null when decoding text");
    }

    public final String d(SecretKey secretKey, String encryptedData) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, AEADBadTagException, IllegalArgumentException, UnsupportedOperationException {
        m.g(secretKey, "secretKey");
        m.g(encryptedData, "encryptedData");
        byte[] e2 = e(secretKey, encryptedData);
        Charset UTF_8 = StandardCharsets.UTF_8;
        m.f(UTF_8, "UTF_8");
        return new String(e2, UTF_8);
    }

    public final byte[] e(SecretKey secretKey, String encryptedData) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, AEADBadTagException, IllegalArgumentException, UnsupportedOperationException {
        m.g(secretKey, "secretKey");
        m.g(encryptedData, "encryptedData");
        byte[] a2 = this.f13527b.a(encryptedData, a.EnumC0327a.DEFAULT);
        if (a2 != null) {
            d.a aVar = e.j.l.p.d.a;
            byte[] b2 = aVar.b(a2);
            return f(this.a.a(secretKey, b2), aVar.a(a2));
        }
        throw new Base64Exception("Result is null when decoding text");
    }
}