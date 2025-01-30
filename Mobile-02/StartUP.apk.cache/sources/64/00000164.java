package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.w;
import com.coinbase.ApiConstants;
import java.security.Signature;
import java.util.concurrent.Executor;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import org.spongycastle.i18n.MessageBundle;

@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes.dex */
public class BiometricPrompt {
    private androidx.fragment.app.d a;

    /* renamed from: b  reason: collision with root package name */
    private Fragment f954b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f955c;

    /* renamed from: d  reason: collision with root package name */
    private final b f956d;

    /* renamed from: e  reason: collision with root package name */
    private androidx.biometric.d f957e;

    /* renamed from: f  reason: collision with root package name */
    private androidx.biometric.e f958f;

    /* renamed from: g  reason: collision with root package name */
    private androidx.biometric.a f959g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f960h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f961i;

    /* renamed from: j  reason: collision with root package name */
    private final DialogInterface.OnClickListener f962j = new a();

    /* renamed from: k  reason: collision with root package name */
    private final n f963k;

    /* loaded from: classes.dex */
    class a implements DialogInterface.OnClickListener {

        /* renamed from: androidx.biometric.BiometricPrompt$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0010a implements Runnable {
            RunnableC0010a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!BiometricPrompt.a() || BiometricPrompt.this.f959g == null) {
                    if (BiometricPrompt.this.f957e != null && BiometricPrompt.this.f958f != null) {
                        CharSequence q = BiometricPrompt.this.f957e.q();
                        BiometricPrompt.this.f956d.onAuthenticationError(13, q != null ? q : "");
                        BiometricPrompt.this.f958f.j(2);
                        return;
                    }
                    Log.e("BiometricPromptCompat", "Negative button callback not run. Fragment was null.");
                    return;
                }
                CharSequence k2 = BiometricPrompt.this.f959g.k();
                BiometricPrompt.this.f956d.onAuthenticationError(13, k2 != null ? k2 : "");
                BiometricPrompt.this.f959g.j();
            }
        }

        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            BiometricPrompt.this.f955c.execute(new RunnableC0010a());
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void onAuthenticationError(int i2, CharSequence charSequence);

        public abstract void onAuthenticationFailed();

        public abstract void onAuthenticationSucceeded(c cVar);
    }

    /* loaded from: classes.dex */
    public static class c {
        private final d a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(d dVar) {
            this.a = dVar;
        }

        public d a() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        private Bundle a;

        /* loaded from: classes.dex */
        public static class a {
            private final Bundle a = new Bundle();

            public e a() {
                CharSequence charSequence = this.a.getCharSequence(MessageBundle.TITLE_ENTRY);
                CharSequence charSequence2 = this.a.getCharSequence("negative_text");
                boolean z = this.a.getBoolean("allow_device_credential");
                boolean z2 = this.a.getBoolean("handling_device_credential_result");
                if (!TextUtils.isEmpty(charSequence)) {
                    if (TextUtils.isEmpty(charSequence2) && !z) {
                        throw new IllegalArgumentException("Negative text must be set and non-empty");
                    }
                    if (TextUtils.isEmpty(charSequence2) || !z) {
                        if (z2 && !z) {
                            throw new IllegalArgumentException("Can't be handling device credential result without device credential enabled");
                        }
                        return new e(this.a);
                    }
                    throw new IllegalArgumentException("Can't have both negative button behavior and device credential enabled");
                }
                throw new IllegalArgumentException("Title must be set and non-empty");
            }

            public a b(CharSequence charSequence) {
                this.a.putCharSequence(ApiConstants.DESCRIPTION, charSequence);
                return this;
            }

            public a c(CharSequence charSequence) {
                this.a.putCharSequence("negative_text", charSequence);
                return this;
            }

            public a d(CharSequence charSequence) {
                this.a.putCharSequence("subtitle", charSequence);
                return this;
            }

            public a e(CharSequence charSequence) {
                this.a.putCharSequence(MessageBundle.TITLE_ENTRY, charSequence);
                return this;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Bundle bundle) {
            this.a = bundle;
        }

        Bundle a() {
            return this.a;
        }

        public boolean b() {
            return this.a.getBoolean("allow_device_credential");
        }

        boolean c() {
            return this.a.getBoolean("handling_device_credential_result");
        }
    }

    @SuppressLint({"LambdaLast"})
    public BiometricPrompt(androidx.fragment.app.d dVar, Executor executor, b bVar) {
        n nVar = new n() { // from class: androidx.biometric.BiometricPrompt.2
            @w(i.a.ON_PAUSE)
            void onPause() {
                if (BiometricPrompt.this.z()) {
                    return;
                }
                if (!BiometricPrompt.a() || BiometricPrompt.this.f959g == null) {
                    if (BiometricPrompt.this.f957e != null && BiometricPrompt.this.f958f != null) {
                        BiometricPrompt.w(BiometricPrompt.this.f957e, BiometricPrompt.this.f958f);
                    }
                } else if (BiometricPrompt.this.f959g.l()) {
                    if (!BiometricPrompt.this.f960h) {
                        BiometricPrompt.this.f960h = true;
                    } else {
                        BiometricPrompt.this.f959g.i();
                    }
                } else {
                    BiometricPrompt.this.f959g.i();
                }
                BiometricPrompt.this.D();
            }

            @w(i.a.ON_RESUME)
            void onResume() {
                BiometricPrompt.this.f959g = BiometricPrompt.a() ? (androidx.biometric.a) BiometricPrompt.this.y().Z("BiometricFragment") : null;
                if (BiometricPrompt.a() && BiometricPrompt.this.f959g != null) {
                    BiometricPrompt.this.f959g.o(BiometricPrompt.this.f955c, BiometricPrompt.this.f962j, BiometricPrompt.this.f956d);
                } else {
                    BiometricPrompt biometricPrompt = BiometricPrompt.this;
                    biometricPrompt.f957e = (androidx.biometric.d) biometricPrompt.y().Z("FingerprintDialogFragment");
                    BiometricPrompt biometricPrompt2 = BiometricPrompt.this;
                    biometricPrompt2.f958f = (androidx.biometric.e) biometricPrompt2.y().Z("FingerprintHelperFragment");
                    if (BiometricPrompt.this.f957e != null) {
                        BiometricPrompt.this.f957e.z(BiometricPrompt.this.f962j);
                    }
                    if (BiometricPrompt.this.f958f != null) {
                        BiometricPrompt.this.f958f.p(BiometricPrompt.this.f955c, BiometricPrompt.this.f956d);
                        if (BiometricPrompt.this.f957e != null) {
                            BiometricPrompt.this.f958f.r(BiometricPrompt.this.f957e.o());
                        }
                    }
                }
                BiometricPrompt.this.B();
                BiometricPrompt.this.C(false);
            }
        };
        this.f963k = nVar;
        if (dVar == null) {
            throw new IllegalArgumentException("FragmentActivity must not be null");
        }
        if (executor == null) {
            throw new IllegalArgumentException("Executor must not be null");
        }
        if (bVar != null) {
            this.a = dVar;
            this.f956d = bVar;
            this.f955c = executor;
            dVar.getLifecycle().a(nVar);
            return;
        }
        throw new IllegalArgumentException("AuthenticationCallback must not be null");
    }

    private void A(e eVar) {
        androidx.fragment.app.d x = x();
        if (x != null && !x.isFinishing()) {
            C(true);
            Bundle a2 = eVar.a();
            a2.putBoolean("handling_device_credential_result", true);
            Intent intent = new Intent(x, DeviceCredentialHandlerActivity.class);
            intent.putExtra("prompt_info_bundle", a2);
            x.startActivity(intent);
            return;
        }
        Log.w("BiometricPromptCompat", "Failed to start handler activity. Parent activity was null or finishing.");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        androidx.biometric.c f2;
        if (this.f961i || (f2 = androidx.biometric.c.f()) == null) {
            return;
        }
        int c2 = f2.c();
        if (c2 == 1) {
            this.f956d.onAuthenticationSucceeded(new c(null));
            f2.q();
            f2.i();
        } else if (c2 != 2) {
        } else {
            this.f956d.onAuthenticationError(10, x() != null ? x().getString(k.generic_error_user_canceled) : "");
            f2.q();
            f2.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z) {
        androidx.biometric.e eVar;
        androidx.biometric.a aVar;
        if (Build.VERSION.SDK_INT >= 29) {
            return;
        }
        androidx.biometric.c e2 = androidx.biometric.c.e();
        if (this.f961i) {
            if (v() && (aVar = this.f959g) != null) {
                e2.j(aVar);
            } else {
                androidx.biometric.d dVar = this.f957e;
                if (dVar != null && (eVar = this.f958f) != null) {
                    e2.o(dVar, eVar);
                }
            }
        } else {
            androidx.fragment.app.d x = x();
            if (x != null) {
                try {
                    e2.l(x.getPackageManager().getActivityInfo(x.getComponentName(), 0).getThemeResource());
                } catch (PackageManager.NameNotFoundException e3) {
                    Log.e("BiometricPromptCompat", "Failed to register client theme to bridge", e3);
                }
            }
        }
        e2.k(this.f955c, this.f962j, this.f956d);
        if (z) {
            e2.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        androidx.biometric.c f2 = androidx.biometric.c.f();
        if (f2 != null) {
            f2.i();
        }
    }

    static /* synthetic */ boolean a() {
        return v();
    }

    private void u(e eVar, d dVar) {
        int i2;
        this.f961i = eVar.c();
        androidx.fragment.app.d x = x();
        if (eVar.b() && (i2 = Build.VERSION.SDK_INT) <= 28) {
            if (!this.f961i) {
                A(eVar);
                return;
            } else if (i2 >= 21) {
                if (x == null) {
                    Log.e("BiometricPromptCompat", "Failed to authenticate with device credential. Activity was null.");
                    return;
                }
                androidx.biometric.c f2 = androidx.biometric.c.f();
                if (f2 == null) {
                    Log.e("BiometricPromptCompat", "Failed to authenticate with device credential. Bridge was null.");
                    return;
                } else if (!f2.h() && androidx.biometric.b.b(x).a() != 0) {
                    m.e("BiometricPromptCompat", x, eVar.a(), null);
                    return;
                }
            }
        }
        androidx.fragment.app.m y = y();
        if (y.v0()) {
            Log.w("BiometricPromptCompat", "Not launching prompt. authenticate() called after onSaveInstanceState()");
            return;
        }
        Bundle a2 = eVar.a();
        boolean z = false;
        this.f960h = false;
        if (x != null && dVar != null && m.h(x, Build.MANUFACTURER, Build.MODEL)) {
            z = true;
        }
        if (!z && v()) {
            androidx.biometric.a aVar = (androidx.biometric.a) y.Z("BiometricFragment");
            if (aVar != null) {
                this.f959g = aVar;
            } else {
                this.f959g = androidx.biometric.a.m();
            }
            this.f959g.o(this.f955c, this.f962j, this.f956d);
            this.f959g.p(dVar);
            this.f959g.n(a2);
            if (aVar == null) {
                y.j().e(this.f959g, "BiometricFragment").k();
            } else if (this.f959g.isDetached()) {
                y.j().i(this.f959g).k();
            }
        } else {
            androidx.biometric.d dVar2 = (androidx.biometric.d) y.Z("FingerprintDialogFragment");
            if (dVar2 != null) {
                this.f957e = dVar2;
            } else {
                this.f957e = androidx.biometric.d.x();
            }
            this.f957e.z(this.f962j);
            this.f957e.y(a2);
            if (x != null && !m.g(x, Build.MODEL)) {
                if (dVar2 == null) {
                    this.f957e.show(y, "FingerprintDialogFragment");
                } else if (this.f957e.isDetached()) {
                    y.j().i(this.f957e).k();
                }
            }
            androidx.biometric.e eVar2 = (androidx.biometric.e) y.Z("FingerprintHelperFragment");
            if (eVar2 != null) {
                this.f958f = eVar2;
            } else {
                this.f958f = androidx.biometric.e.n();
            }
            this.f958f.p(this.f955c, this.f956d);
            Handler o = this.f957e.o();
            this.f958f.r(o);
            this.f958f.q(dVar);
            o.sendMessageDelayed(o.obtainMessage(6), 500L);
            if (eVar2 == null) {
                y.j().e(this.f958f, "FingerprintHelperFragment").k();
            } else if (this.f958f.isDetached()) {
                y.j().i(this.f958f).k();
            }
        }
        y.V();
    }

    private static boolean v() {
        return Build.VERSION.SDK_INT >= 28;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(androidx.biometric.d dVar, androidx.biometric.e eVar) {
        dVar.m();
        eVar.j(0);
    }

    private androidx.fragment.app.d x() {
        androidx.fragment.app.d dVar = this.a;
        return dVar != null ? dVar : this.f954b.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public androidx.fragment.app.m y() {
        androidx.fragment.app.d dVar = this.a;
        return dVar != null ? dVar.getSupportFragmentManager() : this.f954b.getChildFragmentManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z() {
        return x() != null && x().isChangingConfigurations();
    }

    public void s(e eVar) {
        if (eVar != null) {
            u(eVar, null);
            return;
        }
        throw new IllegalArgumentException("PromptInfo can not be null");
    }

    public void t(e eVar, d dVar) {
        if (eVar == null) {
            throw new IllegalArgumentException("PromptInfo can not be null");
        }
        if (dVar != null) {
            if (!eVar.a().getBoolean("allow_device_credential")) {
                u(eVar, dVar);
                return;
            }
            throw new IllegalArgumentException("Device credential not supported with crypto");
        }
        throw new IllegalArgumentException("CryptoObject can not be null");
    }

    /* loaded from: classes.dex */
    public static class d {
        private final Signature a;

        /* renamed from: b  reason: collision with root package name */
        private final Cipher f964b;

        /* renamed from: c  reason: collision with root package name */
        private final Mac f965c;

        public d(Signature signature) {
            this.a = signature;
            this.f964b = null;
            this.f965c = null;
        }

        public Cipher a() {
            return this.f964b;
        }

        public Mac b() {
            return this.f965c;
        }

        public Signature c() {
            return this.a;
        }

        public d(Cipher cipher) {
            this.f964b = cipher;
            this.a = null;
            this.f965c = null;
        }

        public d(Mac mac) {
            this.f965c = mac;
            this.f964b = null;
            this.a = null;
        }
    }
}