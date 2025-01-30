package com.coinbase.wallet.consumer.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: DisconnectConsumerDialog.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ!\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00138B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/consumer/views/DisconnectConsumerDialog;", "Lcom/google/android/material/bottomsheet/b;", "Lkotlin/x;", "init", "()V", "initViews", "initClickListeners", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "email$delegate", "Lkotlin/h;", "getEmail", "()Ljava/lang/String;", "email", "Lkotlin/Function0;", "disconnectListener", "Lkotlin/e0/c/a;", "getDisconnectListener", "()Lkotlin/e0/c/a;", "setDisconnectListener", "(Lkotlin/e0/c/a;)V", "<init>", "Companion", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class DisconnectConsumerDialog extends com.google.android.material.bottomsheet.b {
    public static final Companion Companion = new Companion(null);
    private static final String KEY_EMAIL = "Email";
    public static final String TAG = "DisconnectConsumerDialog";
    private kotlin.e0.c.a<kotlin.x> disconnectListener;
    private final kotlin.h email$delegate;

    /* compiled from: DisconnectConsumerDialog.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/consumer/views/DisconnectConsumerDialog$Companion;", "", "", "email", "Lcom/coinbase/wallet/consumer/views/DisconnectConsumerDialog;", "newInstance", "(Ljava/lang/String;)Lcom/coinbase/wallet/consumer/views/DisconnectConsumerDialog;", "KEY_EMAIL", "Ljava/lang/String;", "TAG", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DisconnectConsumerDialog newInstance(String str) {
            DisconnectConsumerDialog disconnectConsumerDialog = new DisconnectConsumerDialog();
            Bundle bundle = new Bundle();
            if (str != null) {
                bundle.putString(DisconnectConsumerDialog.KEY_EMAIL, str);
            }
            kotlin.x xVar = kotlin.x.a;
            disconnectConsumerDialog.setArguments(bundle);
            return disconnectConsumerDialog;
        }
    }

    public DisconnectConsumerDialog() {
        kotlin.h b2;
        b2 = kotlin.k.b(new DisconnectConsumerDialog$email$2(this));
        this.email$delegate = b2;
    }

    private final String getEmail() {
        return (String) this.email$delegate.getValue();
    }

    private final void init() {
        initViews();
        initClickListeners();
    }

    private final void initClickListeners() {
        View view = getView();
        View disconnectButton = view == null ? null : view.findViewById(R.id.disconnectButton);
        kotlin.jvm.internal.m.f(disconnectButton, "disconnectButton");
        View_CommonKt.setOnSingleClickListener$default(disconnectButton, 0L, new DisconnectConsumerDialog$initClickListeners$1(this), 1, null);
    }

    private final void initViews() {
        String email = getEmail();
        if (email != null) {
            View view = getView();
            ((TextView) (view == null ? null : view.findViewById(R.id.emailAddress))).setText(email);
        }
        View view2 = getView();
        View emailAddress = view2 != null ? view2.findViewById(R.id.emailAddress) : null;
        kotlin.jvm.internal.m.f(emailAddress, "emailAddress");
        emailAddress.setVisibility(getEmail() != null ? 0 : 8);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final kotlin.e0.c.a<kotlin.x> getDisconnectListener() {
        return this.disconnectListener;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_disconnect_consumer_dialog, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setDisconnectListener(kotlin.e0.c.a<kotlin.x> aVar) {
        this.disconnectListener = aVar;
    }
}