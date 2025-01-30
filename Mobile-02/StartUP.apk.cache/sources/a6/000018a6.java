package com.coinbase.wallet.consumer.views;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ProgressBar;
import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;

/* compiled from: UMOActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lkotlin/x;", "<anonymous>", "()V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UMOActivity$startActivityWithEmail$1$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.a<kotlin.x> {
    final /* synthetic */ View $view;
    final /* synthetic */ UMOActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UMOActivity$startActivityWithEmail$1$1(UMOActivity uMOActivity, View view) {
        super(0);
        this.this$0 = uMOActivity;
        this.$view = view;
    }

    public static /* synthetic */ void a(UMOActivity uMOActivity, View view) {
        m1054invoke$lambda0(uMOActivity, view);
    }

    /* renamed from: invoke$lambda-0 */
    public static final void m1054invoke$lambda0(UMOActivity this$0, View view) {
        CustomReactRootView customReactRootView;
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (this$0.isFinishing()) {
            return;
        }
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progress);
        kotlin.jvm.internal.m.f(progressBar, "view.progress");
        progressBar.setVisibility(8);
        customReactRootView = this$0.reactRootView;
        if (customReactRootView == null) {
            return;
        }
        customReactRootView.setVisibility(0);
    }

    @Override // kotlin.e0.c.a
    public /* bridge */ /* synthetic */ kotlin.x invoke() {
        invoke2();
        return kotlin.x.a;
    }

    /* renamed from: invoke */
    public final void invoke2() {
        Handler handler = new Handler(Looper.getMainLooper());
        final UMOActivity uMOActivity = this.this$0;
        final View view = this.$view;
        handler.postDelayed(new Runnable() { // from class: com.coinbase.wallet.consumer.views.y
            @Override // java.lang.Runnable
            public final void run() {
                UMOActivity$startActivityWithEmail$1$1.a(UMOActivity.this, view);
            }
        }, 1000L);
    }
}