package c.h.f.a;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* compiled from: FingerprintManagerCompat.java */
@Deprecated
/* loaded from: classes.dex */
public class a {
    private final Context a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FingerprintManagerCompat.java */
    /* renamed from: c.h.f.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061a extends FingerprintManager.AuthenticationCallback {
        final /* synthetic */ b a;

        C0061a(b bVar) {
            this.a = bVar;
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationError(int i2, CharSequence charSequence) {
            this.a.a(i2, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationFailed() {
            this.a.b();
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
            this.a.c(i2, charSequence);
        }

        @Override // android.hardware.fingerprint.FingerprintManager.AuthenticationCallback
        public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult authenticationResult) {
            this.a.d(new c(a.f(authenticationResult.getCryptoObject())));
        }
    }

    /* compiled from: FingerprintManagerCompat.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(int i2, CharSequence charSequence);

        public abstract void b();

        public abstract void c(int i2, CharSequence charSequence);

        public abstract void d(c cVar);
    }

    /* compiled from: FingerprintManagerCompat.java */
    /* loaded from: classes.dex */
    public static final class c {
        private final d a;

        public c(d dVar) {
            this.a = dVar;
        }

        public d a() {
            return this.a;
        }
    }

    private a(Context context) {
        this.a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    private static FingerprintManager c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 23) {
            return (FingerprintManager) context.getSystemService(FingerprintManager.class);
        }
        if (i2 <= 23 || !context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
            return null;
        }
        return (FingerprintManager) context.getSystemService(FingerprintManager.class);
    }

    static d f(FingerprintManager.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new d(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new d(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new d(cryptoObject.getMac());
        }
        return null;
    }

    private static FingerprintManager.AuthenticationCallback g(b bVar) {
        return new C0061a(bVar);
    }

    private static FingerprintManager.CryptoObject h(d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.a() != null) {
            return new FingerprintManager.CryptoObject(dVar.a());
        }
        if (dVar.c() != null) {
            return new FingerprintManager.CryptoObject(dVar.c());
        }
        if (dVar.b() != null) {
            return new FingerprintManager.CryptoObject(dVar.b());
        }
        return null;
    }

    public void a(d dVar, int i2, androidx.core.os.c cVar, b bVar, Handler handler) {
        FingerprintManager c2;
        if (Build.VERSION.SDK_INT < 23 || (c2 = c(this.a)) == null) {
            return;
        }
        c2.authenticate(h(dVar), cVar != null ? (CancellationSignal) cVar.b() : null, i2, g(bVar), handler);
    }

    public boolean d() {
        FingerprintManager c2;
        return Build.VERSION.SDK_INT >= 23 && (c2 = c(this.a)) != null && c2.hasEnrolledFingerprints();
    }

    public boolean e() {
        FingerprintManager c2;
        return Build.VERSION.SDK_INT >= 23 && (c2 = c(this.a)) != null && c2.isHardwareDetected();
    }

    /* compiled from: FingerprintManagerCompat.java */
    /* loaded from: classes.dex */
    public static class d {
        private final Signature a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f2947b;

        /* renamed from: c  reason: collision with root package name */
        private final Mac f2948c;

        public d(Signature signature) {
            this.a = signature;
            this.f2947b = null;
            this.f2948c = null;
        }

        public Cipher a() {
            return this.f2947b;
        }

        public Mac b() {
            return this.f2948c;
        }

        public Signature c() {
            return this.a;
        }

        public d(Cipher cipher) {
            this.f2947b = cipher;
            this.a = null;
            this.f2948c = null;
        }

        public d(Mac mac) {
            this.f2948c = mac;
            this.f2947b = null;
            this.a = null;
        }
    }
}