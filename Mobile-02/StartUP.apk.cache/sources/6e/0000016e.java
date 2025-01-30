package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.hardware.biometrics.BiometricPrompt;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import com.coinbase.ApiConstants;
import java.util.concurrent.Executor;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: BiometricFragment.java */
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes.dex */
public class a extends Fragment {
    private Context a;

    /* renamed from: b  reason: collision with root package name */
    private Bundle f966b;

    /* renamed from: c  reason: collision with root package name */
    Executor f967c;

    /* renamed from: d  reason: collision with root package name */
    DialogInterface.OnClickListener f968d;

    /* renamed from: e  reason: collision with root package name */
    BiometricPrompt.b f969e;

    /* renamed from: f  reason: collision with root package name */
    private BiometricPrompt.d f970f;

    /* renamed from: g  reason: collision with root package name */
    private CharSequence f971g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f972h;

    /* renamed from: j  reason: collision with root package name */
    private android.hardware.biometrics.BiometricPrompt f973j;

    /* renamed from: k  reason: collision with root package name */
    private CancellationSignal f974k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f975l;
    private final Handler m = new Handler(Looper.getMainLooper());
    private final Executor n = new ExecutorC0011a();
    final BiometricPrompt.AuthenticationCallback p = new b();
    private final DialogInterface.OnClickListener q = new c();
    private final DialogInterface.OnClickListener t = new d();

    /* compiled from: BiometricFragment.java */
    /* renamed from: androidx.biometric.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class ExecutorC0011a implements Executor {
        ExecutorC0011a() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a.this.m.post(runnable);
        }
    }

    /* compiled from: BiometricFragment.java */
    /* loaded from: classes.dex */
    class b extends BiometricPrompt.AuthenticationCallback {

        /* compiled from: BiometricFragment.java */
        /* renamed from: androidx.biometric.a$b$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0012a implements Runnable {
            final /* synthetic */ CharSequence a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f976b;

            RunnableC0012a(CharSequence charSequence, int i2) {
                this.a = charSequence;
                this.f976b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                CharSequence charSequence = this.a;
                if (charSequence == null) {
                    charSequence = a.this.a.getString(k.default_error_msg) + " " + this.f976b;
                }
                a.this.f969e.onAuthenticationError(m.c(this.f976b) ? 8 : this.f976b, charSequence);
            }
        }

        /* compiled from: BiometricFragment.java */
        /* renamed from: androidx.biometric.a$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0013b implements Runnable {
            final /* synthetic */ BiometricPrompt.c a;

            RunnableC0013b(BiometricPrompt.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f969e.onAuthenticationSucceeded(this.a);
            }
        }

        /* compiled from: BiometricFragment.java */
        /* loaded from: classes.dex */
        class c implements Runnable {
            c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f969e.onAuthenticationFailed();
            }
        }

        b() {
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationError(int i2, CharSequence charSequence) {
            if (m.a()) {
                return;
            }
            a.this.f967c.execute(new RunnableC0012a(charSequence, i2));
            a.this.j();
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationFailed() {
            a.this.f967c.execute(new c());
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationHelp(int i2, CharSequence charSequence) {
        }

        @Override // android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
        public void onAuthenticationSucceeded(BiometricPrompt.AuthenticationResult authenticationResult) {
            a.this.f967c.execute(new RunnableC0013b(authenticationResult != null ? new BiometricPrompt.c(a.q(authenticationResult.getCryptoObject())) : new BiometricPrompt.c(null)));
            a.this.j();
        }
    }

    /* compiled from: BiometricFragment.java */
    /* loaded from: classes.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            a.this.f968d.onClick(dialogInterface, i2);
        }
    }

    /* compiled from: BiometricFragment.java */
    /* loaded from: classes.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (i2 == -2) {
                m.e("BiometricFragment", a.this.getActivity(), a.this.f966b, null);
            }
        }
    }

    /* compiled from: BiometricFragment.java */
    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f975l = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a m() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BiometricPrompt.d q(BiometricPrompt.CryptoObject cryptoObject) {
        if (cryptoObject == null) {
            return null;
        }
        if (cryptoObject.getCipher() != null) {
            return new BiometricPrompt.d(cryptoObject.getCipher());
        }
        if (cryptoObject.getSignature() != null) {
            return new BiometricPrompt.d(cryptoObject.getSignature());
        }
        if (cryptoObject.getMac() != null) {
            return new BiometricPrompt.d(cryptoObject.getMac());
        }
        return null;
    }

    private static BiometricPrompt.CryptoObject r(BiometricPrompt.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.a() != null) {
            return new BiometricPrompt.CryptoObject(dVar.a());
        }
        if (dVar.c() != null) {
            return new BiometricPrompt.CryptoObject(dVar.c());
        }
        if (dVar.b() != null) {
            return new BiometricPrompt.CryptoObject(dVar.b());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        if (Build.VERSION.SDK_INT >= 29 && l() && !this.f975l) {
            Log.w("BiometricFragment", "Ignoring fast cancel signal");
            return;
        }
        CancellationSignal cancellationSignal = this.f974k;
        if (cancellationSignal != null) {
            cancellationSignal.cancel();
        }
        j();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        this.f972h = false;
        androidx.fragment.app.d activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().j().n(this).k();
        }
        m.f(activity);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public CharSequence k() {
        return this.f971g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l() {
        Bundle bundle = this.f966b;
        return bundle != null && bundle.getBoolean("allow_device_credential", false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(Bundle bundle) {
        this.f966b = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Executor executor, DialogInterface.OnClickListener onClickListener, BiometricPrompt.b bVar) {
        this.f967c = executor;
        this.f968d = onClickListener;
        this.f969e = bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.a = context;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle bundle2;
        if (!this.f972h && (bundle2 = this.f966b) != null) {
            this.f971g = bundle2.getCharSequence("negative_text");
            BiometricPrompt.Builder builder = new BiometricPrompt.Builder(getContext());
            builder.setTitle(this.f966b.getCharSequence(MessageBundle.TITLE_ENTRY)).setSubtitle(this.f966b.getCharSequence("subtitle")).setDescription(this.f966b.getCharSequence(ApiConstants.DESCRIPTION));
            boolean z = this.f966b.getBoolean("allow_device_credential");
            if (z && Build.VERSION.SDK_INT <= 28) {
                String string = getString(k.confirm_device_credential_password);
                this.f971g = string;
                builder.setNegativeButton(string, this.f967c, this.t);
            } else if (!TextUtils.isEmpty(this.f971g)) {
                builder.setNegativeButton(this.f971g, this.f967c, this.q);
            }
            if (Build.VERSION.SDK_INT >= 29) {
                builder.setConfirmationRequired(this.f966b.getBoolean("require_confirmation", true));
                builder.setDeviceCredentialAllowed(z);
            }
            if (z) {
                this.f975l = false;
                this.m.postDelayed(new e(), 250L);
            }
            this.f973j = builder.build();
            CancellationSignal cancellationSignal = new CancellationSignal();
            this.f974k = cancellationSignal;
            BiometricPrompt.d dVar = this.f970f;
            if (dVar == null) {
                this.f973j.authenticate(cancellationSignal, this.n, this.p);
            } else {
                this.f973j.authenticate(r(dVar), this.f974k, this.n, this.p);
            }
        }
        this.f972h = true;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(BiometricPrompt.d dVar) {
        this.f970f = dVar;
    }
}