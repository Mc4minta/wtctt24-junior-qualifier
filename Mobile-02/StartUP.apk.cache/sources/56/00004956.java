package e.j.d.h;

import java.security.SecureRandom;
import java.util.Objects;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.digests.SHA256Digest;
import org.spongycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.spongycastle.crypto.params.KeyParameter;

/* compiled from: PinKeyGenerator.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final C0318a a = new C0318a(null);

    /* compiled from: PinKeyGenerator.kt */
    /* renamed from: e.j.d.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0318a {
        private C0318a() {
        }

        public /* synthetic */ C0318a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final SecretKey a(byte[] password, byte[] salt) {
        m.g(password, "password");
        m.g(salt, "salt");
        PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA256Digest());
        pKCS5S2ParametersGenerator.init(password, salt, 50000);
        CipherParameters generateDerivedMacParameters = pKCS5S2ParametersGenerator.generateDerivedMacParameters(256);
        Objects.requireNonNull(generateDerivedMacParameters, "null cannot be cast to non-null type org.spongycastle.crypto.params.KeyParameter");
        return new SecretKeySpec(((KeyParameter) generateDerivedMacParameters).getKey(), "AES");
    }

    public final byte[] b() {
        byte[] generateSeed = new SecureRandom().generateSeed(32);
        m.f(generateSeed, "secureRandom.generateSeed(32)");
        return generateSeed;
    }
}