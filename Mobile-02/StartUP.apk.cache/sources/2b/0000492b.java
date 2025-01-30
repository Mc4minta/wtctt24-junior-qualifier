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

/* compiled from: Encryptor.kt */
/* loaded from: classes2.dex */
public final class e {
    private final e.j.d.f.a a;

    /* renamed from: b  reason: collision with root package name */
    private final e.j.l.o.a f13532b;

    /* renamed from: c  reason: collision with root package name */
    private final e.j.l.p.b f13533c;

    /* compiled from: Encryptor.kt */
    /* loaded from: classes2.dex */
    static final class a extends o implements l<byte[], byte[]> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Cipher f13534b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Cipher cipher) {
            super(1);
            this.f13534b = cipher;
        }

        @Override // kotlin.e0.c.l
        /* renamed from: a */
        public final byte[] invoke(byte[] it) {
            m.g(it, "it");
            return e.this.b(this.f13534b, it);
        }
    }

    public e(e.j.d.f.a cipherGenerator, e.j.l.o.a base64Util, e.j.l.p.b cryptoErrorUtil) {
        m.g(cipherGenerator, "cipherGenerator");
        m.g(base64Util, "base64Util");
        m.g(cryptoErrorUtil, "cryptoErrorUtil");
        this.a = cipherGenerator;
        this.f13532b = base64Util;
        this.f13533c = cryptoErrorUtil;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] b(Cipher cipher, byte[] bArr) {
        try {
            byte[] doFinal = cipher.doFinal(bArr);
            m.f(doFinal, "cipher.doFinal(cipherText)");
            return doFinal;
        } catch (Exception e2) {
            this.f13533c.d("Encryption failed", e2, cipher);
            throw e2;
        }
    }

    public final String c(String textToEncrypt, Cipher cipher) throws IllegalStateException, IllegalBlockSizeException, BadPaddingException, AEADBadTagException {
        m.g(textToEncrypt, "textToEncrypt");
        m.g(cipher, "cipher");
        byte[] iv = cipher.getIV();
        m.f(iv, "cipher.iv");
        return d(textToEncrypt, iv, new a(cipher));
    }

    public final String d(String textToEncrypt, byte[] iv, l<? super byte[], byte[]> predicate) {
        m.g(textToEncrypt, "textToEncrypt");
        m.g(iv, "iv");
        m.g(predicate, "predicate");
        Charset UTF_8 = StandardCharsets.UTF_8;
        m.f(UTF_8, "UTF_8");
        byte[] bytes = textToEncrypt.getBytes(UTF_8);
        m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        String b2 = this.f13532b.b(e.j.l.p.d.a.c(predicate.invoke(bytes), iv), a.EnumC0327a.DEFAULT);
        if (b2 != null) {
            return b2;
        }
        throw new Base64Exception("Result is null when encoding bytes");
    }

    public final String e(SecretKey secretKey, byte[] data) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, UnsupportedOperationException {
        m.g(secretKey, "secretKey");
        m.g(data, "data");
        Cipher b2 = this.a.b(secretKey);
        byte[] b3 = b(b2, data);
        d.a aVar = e.j.l.p.d.a;
        byte[] iv = b2.getIV();
        m.f(iv, "cipher.iv");
        String b4 = this.f13532b.b(aVar.c(b3, iv), a.EnumC0327a.DEFAULT);
        if (b4 != null) {
            return b4;
        }
        throw new Base64Exception("Result is null when encoding bytes");
    }
}