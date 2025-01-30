package androidx.biometric;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.biometric.BiometricPrompt;

@SuppressLint({"SyntheticAccessor"})
/* loaded from: classes.dex */
public class DeviceCredentialHandlerActivity extends androidx.appcompat.app.d {
    private boolean a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i2) {
        c f2 = c.f();
        if (f2 == null) {
            Log.e("DeviceCredentialHandler", "onActivityResult: Bridge or callback was null!");
        } else if (i2 == -1) {
            f2.n(1);
            f2.m(false);
            f2.p();
        } else {
            f2.n(2);
            f2.m(false);
            f2.p();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        a(i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        c e2 = c.e();
        boolean z = true;
        if (e2.b() != 0) {
            setTheme(e2.b());
            getTheme().applyStyle(l.TransparentStyle, true);
        }
        super.onCreate(bundle);
        if (bundle == null || !bundle.getBoolean("did_change_configuration", false)) {
            z = false;
        }
        this.a = z;
        if (!z) {
            e2.q();
        } else {
            this.a = false;
        }
        setTitle((CharSequence) null);
        setContentView(j.device_credential_handler_activity);
        if (e2.d() != null && e2.a() != null) {
            new BiometricPrompt(this, e2.d(), e2.a()).s(new BiometricPrompt.e(getIntent().getBundleExtra("prompt_info_bundle")));
            return;
        }
        Log.e("DeviceCredentialHandler", "onCreate: Executor and/or callback was null!");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.d, android.app.Activity
    public void onPause() {
        super.onPause();
        c f2 = c.f();
        if (!isChangingConfigurations() || f2 == null) {
            return;
        }
        f2.g();
        this.a = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("did_change_configuration", this.a);
    }
}