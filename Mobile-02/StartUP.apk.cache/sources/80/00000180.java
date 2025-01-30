package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.Fragment;
import c.h.f.a.a;
import java.util.concurrent.Executor;

/* compiled from: FingerprintHelperFragment.java */
@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes.dex */
public class e extends Fragment {
    private b a;

    /* renamed from: b  reason: collision with root package name */
    Executor f1001b;

    /* renamed from: c  reason: collision with root package name */
    BiometricPrompt.b f1002c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f1003d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1004e;

    /* renamed from: f  reason: collision with root package name */
    private BiometricPrompt.d f1005f;

    /* renamed from: g  reason: collision with root package name */
    private Context f1006g;

    /* renamed from: h  reason: collision with root package name */
    private int f1007h;

    /* renamed from: j  reason: collision with root package name */
    private androidx.core.os.c f1008j;

    /* renamed from: k  reason: collision with root package name */
    final a.b f1009k = new a();

    /* compiled from: FingerprintHelperFragment.java */
    /* loaded from: classes.dex */
    class a extends a.b {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: FingerprintHelperFragment.java */
        /* renamed from: androidx.biometric.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0016a implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CharSequence f1010b;

            RunnableC0016a(int i2, CharSequence charSequence) {
                this.a = i2;
                this.f1010b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f1002c.onAuthenticationError(this.a, this.f1010b);
            }
        }

        /* compiled from: FingerprintHelperFragment.java */
        /* loaded from: classes.dex */
        class b implements Runnable {
            final /* synthetic */ int a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ CharSequence f1012b;

            b(int i2, CharSequence charSequence) {
                this.a = i2;
                this.f1012b = charSequence;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f(this.a, this.f1012b);
                e.this.k();
            }
        }

        /* compiled from: FingerprintHelperFragment.java */
        /* loaded from: classes.dex */
        class c implements Runnable {
            final /* synthetic */ BiometricPrompt.c a;

            c(BiometricPrompt.c cVar) {
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f1002c.onAuthenticationSucceeded(this.a);
            }
        }

        /* compiled from: FingerprintHelperFragment.java */
        /* loaded from: classes.dex */
        class d implements Runnable {
            d() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f1002c.onAuthenticationFailed();
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i2, CharSequence charSequence) {
            e.this.a.a(3);
            if (m.a()) {
                return;
            }
            e.this.f1001b.execute(new RunnableC0016a(i2, charSequence));
        }

        @Override // c.h.f.a.a.b
        public void a(int i2, CharSequence charSequence) {
            if (i2 == 5) {
                if (e.this.f1007h == 0) {
                    f(i2, charSequence);
                }
                e.this.k();
            } else if (i2 != 7 && i2 != 9) {
                if (charSequence == null) {
                    Log.e("FingerprintHelperFrag", "Got null string for error message: " + i2);
                    charSequence = e.this.f1006g.getResources().getString(k.default_error_msg);
                }
                if (m.c(i2)) {
                    i2 = 8;
                }
                e.this.a.b(2, i2, 0, charSequence);
                e.this.f1003d.postDelayed(new b(i2, charSequence), androidx.biometric.d.p(e.this.getContext()));
            } else {
                f(i2, charSequence);
                e.this.k();
            }
        }

        @Override // c.h.f.a.a.b
        public void b() {
            e.this.a.c(1, e.this.f1006g.getResources().getString(k.fingerprint_not_recognized));
            e.this.f1001b.execute(new d());
        }

        @Override // c.h.f.a.a.b
        public void c(int i2, CharSequence charSequence) {
            e.this.a.c(1, charSequence);
        }

        @Override // c.h.f.a.a.b
        public void d(a.c cVar) {
            e.this.a.a(5);
            e.this.f1001b.execute(new c(cVar != null ? new BiometricPrompt.c(e.s(cVar.a())) : new BiometricPrompt.c(null)));
            e.this.k();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FingerprintHelperFragment.java */
    /* loaded from: classes.dex */
    public static class b {
        private final Handler a;

        b(Handler handler) {
            this.a = handler;
        }

        void a(int i2) {
            this.a.obtainMessage(i2).sendToTarget();
        }

        void b(int i2, int i3, int i4, Object obj) {
            this.a.obtainMessage(i2, i3, i4, obj).sendToTarget();
        }

        void c(int i2, Object obj) {
            this.a.obtainMessage(i2, obj).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        this.f1004e = false;
        androidx.fragment.app.d activity = getActivity();
        if (getFragmentManager() != null) {
            getFragmentManager().j().n(this).k();
        }
        if (m.a()) {
            return;
        }
        m.f(activity);
    }

    private String l(Context context, int i2) {
        if (i2 != 1) {
            switch (i2) {
                case 10:
                    return context.getString(k.fingerprint_error_user_canceled);
                case 11:
                    return context.getString(k.fingerprint_error_no_fingerprints);
                case 12:
                    return context.getString(k.fingerprint_error_hw_not_present);
                default:
                    Log.e("FingerprintHelperFrag", "Unknown error code: " + i2);
                    return context.getString(k.default_error_msg);
            }
        }
        return context.getString(k.fingerprint_error_hw_not_available);
    }

    private boolean m(c.h.f.a.a aVar) {
        if (!aVar.e()) {
            o(12);
            return true;
        } else if (aVar.d()) {
            return false;
        } else {
            o(11);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e n() {
        return new e();
    }

    private void o(int i2) {
        if (m.a()) {
            return;
        }
        this.f1002c.onAuthenticationError(i2, l(this.f1006g, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BiometricPrompt.d s(a.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.a() != null) {
            return new BiometricPrompt.d(dVar.a());
        }
        if (dVar.c() != null) {
            return new BiometricPrompt.d(dVar.c());
        }
        if (dVar.b() != null) {
            return new BiometricPrompt.d(dVar.b());
        }
        return null;
    }

    private static a.d t(BiometricPrompt.d dVar) {
        if (dVar == null) {
            return null;
        }
        if (dVar.a() != null) {
            return new a.d(dVar.a());
        }
        if (dVar.c() != null) {
            return new a.d(dVar.c());
        }
        if (dVar.b() != null) {
            return new a.d(dVar.b());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i2) {
        this.f1007h = i2;
        if (i2 == 1) {
            o(10);
        }
        androidx.core.os.c cVar = this.f1008j;
        if (cVar != null) {
            cVar.a();
        }
        k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
        this.f1006g = getContext();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (!this.f1004e) {
            this.f1008j = new androidx.core.os.c();
            this.f1007h = 0;
            c.h.f.a.a b2 = c.h.f.a.a.b(this.f1006g);
            if (m(b2)) {
                this.a.a(3);
                k();
            } else {
                b2.a(t(this.f1005f), 0, this.f1008j, this.f1009k, null);
                this.f1004e = true;
            }
        }
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Executor executor, BiometricPrompt.b bVar) {
        this.f1001b = executor;
        this.f1002c = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(BiometricPrompt.d dVar) {
        this.f1005f = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(Handler handler) {
        this.f1003d = handler;
        this.a = new b(handler);
    }
}