package com.google.android.gms.auth.api.signin.internal;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import c.o.a.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
@KeepName
/* loaded from: classes2.dex */
public class SignInHubActivity extends androidx.fragment.app.d {
    private static boolean a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5991b = false;

    /* renamed from: c  reason: collision with root package name */
    private SignInConfiguration f5992c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5993d;

    /* renamed from: e  reason: collision with root package name */
    private int f5994e;

    /* renamed from: f  reason: collision with root package name */
    private Intent f5995f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
    /* loaded from: classes2.dex */
    public class a implements a.InterfaceC0077a<Void> {
        private a() {
        }

        @Override // c.o.a.a.InterfaceC0077a
        public final /* synthetic */ void a(c.o.b.b<Void> bVar, Void r3) {
            SignInHubActivity signInHubActivity = SignInHubActivity.this;
            signInHubActivity.setResult(signInHubActivity.f5994e, SignInHubActivity.this.f5995f);
            SignInHubActivity.this.finish();
        }

        @Override // c.o.a.a.InterfaceC0077a
        public final c.o.b.b<Void> b(int i2, Bundle bundle) {
            return new h(SignInHubActivity.this, com.google.android.gms.common.api.d.c());
        }

        @Override // c.o.a.a.InterfaceC0077a
        public final void c(c.o.b.b<Void> bVar) {
        }
    }

    private final void b(int i2) {
        Status status = new Status(i2);
        Intent intent = new Intent();
        intent.putExtra("googleSignInStatus", status);
        setResult(0, intent);
        finish();
        a = false;
    }

    private final void d() {
        getSupportLoaderManager().c(0, null, new a());
        a = false;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (this.f5991b) {
            return;
        }
        setResult(0);
        if (i2 != 40962) {
            return;
        }
        if (intent != null) {
            SignInAccount signInAccount = (SignInAccount) intent.getParcelableExtra("signInAccount");
            if (signInAccount != null && signInAccount.k0() != null) {
                GoogleSignInAccount k0 = signInAccount.k0();
                o.c(this).b(this.f5992c.i1(), (GoogleSignInAccount) e.g.a.e.d.b.b.a(k0));
                intent.removeExtra("signInAccount");
                intent.putExtra("googleSignInAccount", k0);
                this.f5993d = true;
                this.f5994e = i3;
                this.f5995f = intent;
                d();
                return;
            } else if (intent.hasExtra("errorCode")) {
                int intExtra = intent.getIntExtra("errorCode", 8);
                if (intExtra == 13) {
                    intExtra = 12501;
                }
                b(intExtra);
                return;
            }
        }
        b(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        String str = (String) e.g.a.e.d.b.b.a(intent.getAction());
        if ("com.google.android.gms.auth.NO_IMPL".equals(str)) {
            b(12500);
        } else if (!str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN") && !str.equals("com.google.android.gms.auth.APPAUTH_SIGN_IN")) {
            String valueOf = String.valueOf(intent.getAction());
            Log.e("AuthSignInClient", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            finish();
        } else {
            SignInConfiguration signInConfiguration = (SignInConfiguration) ((Bundle) e.g.a.e.d.b.b.a(intent.getBundleExtra("config"))).getParcelable("config");
            if (signInConfiguration == null) {
                Log.e("AuthSignInClient", "Activity started with invalid configuration.");
                setResult(0);
                finish();
                return;
            }
            this.f5992c = signInConfiguration;
            if (bundle == null) {
                if (a) {
                    setResult(0);
                    b(12502);
                    return;
                }
                a = true;
                Intent intent2 = new Intent(str);
                if (str.equals("com.google.android.gms.auth.GOOGLE_SIGN_IN")) {
                    intent2.setPackage("com.google.android.gms");
                } else {
                    intent2.setPackage(getPackageName());
                }
                intent2.putExtra("config", this.f5992c);
                try {
                    startActivityForResult(intent2, 40962);
                    return;
                } catch (ActivityNotFoundException unused) {
                    this.f5991b = true;
                    Log.w("AuthSignInClient", "Could not launch sign in Intent. Google Play Service is probably being updated...");
                    b(17);
                    return;
                }
            }
            boolean z = bundle.getBoolean("signingInGoogleApiClients");
            this.f5993d = z;
            if (z) {
                this.f5994e = bundle.getInt("signInResultCode");
                this.f5995f = (Intent) e.g.a.e.d.b.b.a((Intent) bundle.getParcelable("signInResultData"));
                d();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("signingInGoogleApiClients", this.f5993d);
        if (this.f5993d) {
            bundle.putInt("signInResultCode", this.f5994e);
            bundle.putParcelable("signInResultData", this.f5995f);
        }
    }
}