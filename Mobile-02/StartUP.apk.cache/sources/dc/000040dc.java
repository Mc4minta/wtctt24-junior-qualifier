package com.toshi.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.coinbase.wallet.commonui.extensions.Activity_CommonKt;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: MustUpdateWalletVersionActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/toshi/view/activity/MustUpdateWalletVersionActivity;", "Landroidx/appcompat/app/d;", "Lkotlin/x;", "a", "()V", "d", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class MustUpdateWalletVersionActivity extends androidx.appcompat.app.d {
    private final void a() {
        ((Button) findViewById(e.j.a.updateWalletButton)).setOnClickListener(new View.OnClickListener() { // from class: com.toshi.view.activity.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MustUpdateWalletVersionActivity.c(MustUpdateWalletVersionActivity.this, view);
            }
        });
    }

    public static final void b(MustUpdateWalletVersionActivity this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.d();
    }

    public static /* synthetic */ void c(MustUpdateWalletVersionActivity mustUpdateWalletVersionActivity, View view) {
        b(mustUpdateWalletVersionActivity, view);
    }

    private final void d() {
        startActivity(e.j.f.n.a());
    }

    @Override // androidx.appcompat.app.d, androidx.fragment.app.d, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_update_wallet);
        Activity_CommonKt.enableFullscreenWindow(this);
        a();
    }
}