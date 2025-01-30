package com.toshi.view.activity;

import android.os.Bundle;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: BannedLocationActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\bJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/toshi/view/activity/BannedLocationActivity;", "Ldagger/android/g/b;", "Landroid/os/Bundle;", "savedInstanceState", "Lkotlin/x;", "onCreate", "(Landroid/os/Bundle;)V", "onBackPressed", "()V", "", "onSupportNavigateUp", "()Z", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class BannedLocationActivity extends dagger.android.g.b {
    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (e.j.f.m.i(getSupportFragmentManager().Y(R.id.bannedLocationFragment))) {
            return;
        }
        super.onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // dagger.android.g.b, androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_banned_location);
        Activity_CommonKt.enableFullscreenWindow(this);
    }

    @Override // androidx.appcompat.app.d
    public boolean onSupportNavigateUp() {
        return e.j.f.c.d(this, R.id.bannedLocationFragment).r();
    }
}