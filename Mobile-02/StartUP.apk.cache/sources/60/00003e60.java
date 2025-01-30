package com.proyecto26.inappbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import org.greenrobot.eventbus.EventBus;

/* loaded from: classes2.dex */
public class ChromeTabsManagerActivity extends Activity {
    private boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    private String f10545b = null;

    private static Intent a(Context context) {
        return new Intent(context, ChromeTabsManagerActivity.class);
    }

    public static Intent b(Context context) {
        Intent a = a(context);
        a.addFlags(67108864);
        return a;
    }

    public static Intent c(Context context, Intent intent) {
        Intent a = a(context);
        a.putExtra("browserIntent", intent);
        return a;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent().hasExtra("browserIntent") && (bundle == null || bundle.getString("browserResultType") == null)) {
            Intent intent = (Intent) getIntent().getParcelableExtra("browserIntent");
            intent.addFlags(67108864);
            startActivity(intent);
            this.f10545b = "dismiss";
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        String str = this.f10545b;
        if (str != null) {
            str.hashCode();
            if (!str.equals("cancel")) {
                EventBus.getDefault().post(new a("chrome tabs activity destroyed", "dismiss"));
            } else {
                EventBus.getDefault().post(new a("chrome tabs activity closed", this.f10545b));
            }
            this.f10545b = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f10545b = bundle.getString("browserResultType");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.a) {
            this.a = true;
            return;
        }
        this.f10545b = "cancel";
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putString("browserResultType", "dismiss");
        super.onSaveInstanceState(bundle);
    }
}