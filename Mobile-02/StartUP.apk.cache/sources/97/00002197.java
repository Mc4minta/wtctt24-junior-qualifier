package com.coinbase.wallet.features.signer.views;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.d0;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.core.extensions.String_CoreKt;
import com.coinbase.wallet.features.signer.viewmodel.MessageSignerViewModel;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import e.j.f.y;
import h.c.b0;
import java.net.URL;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* compiled from: MessageSignerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\"\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0006R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00128\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u00020\u00038\u0014@\u0014X\u0094.¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/MessageSignerFragment;", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState$SignMessageViewState;", "Lcom/coinbase/wallet/features/signer/viewmodel/MessageSignerViewModel;", "Lkotlin/x;", "toggleDetailsView", "()V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "setUpViewModel", "setup", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/MessageSignerViewModel;", "getViewModel", "()Lcom/coinbase/wallet/features/signer/viewmodel/MessageSignerViewModel;", "setViewModel", "(Lcom/coinbase/wallet/features/signer/viewmodel/MessageSignerViewModel;)V", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MessageSignerFragment extends RequestSigningDialog<SignatureRequestViewState.SignMessageViewState, MessageSignerViewModel> {
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    protected MessageSignerViewModel viewModel;
    public GenericViewModelFactory<MessageSignerViewModel> viewModelFactory;

    public static /* synthetic */ void h(MessageSignerFragment messageSignerFragment, View view) {
        m1448setup$lambda3(messageSignerFragment, view);
    }

    public static /* synthetic */ void i(MessageSignerFragment messageSignerFragment, View view) {
        m1447setup$lambda2(messageSignerFragment, view);
    }

    public static /* synthetic */ void j(MessageSignerFragment messageSignerFragment, View view) {
        m1449setup$lambda4(messageSignerFragment, view);
    }

    /* renamed from: setup$lambda-2 */
    public static final void m1447setup$lambda2(MessageSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getViewModel().reject();
    }

    /* renamed from: setup$lambda-3 */
    public static final void m1448setup$lambda3(MessageSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.getViewModel().approve();
    }

    /* renamed from: setup$lambda-4 */
    public static final void m1449setup$lambda4(MessageSignerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.toggleDetailsView();
    }

    private final void toggleDetailsView() {
        b0 collapse$default;
        View view = getView();
        View messageFieldScrollView = view == null ? null : view.findViewById(e.j.a.messageFieldScrollView);
        kotlin.jvm.internal.m.f(messageFieldScrollView, "messageFieldScrollView");
        boolean f2 = y.f(messageFieldScrollView);
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.F1))).setEnabled(false);
        int r = e.j.f.m.r(this, 100);
        View view3 = getView();
        View messageField = view3 == null ? null : view3.findViewById(e.j.a.messageField);
        kotlin.jvm.internal.m.f(messageField, "messageField");
        View_CommonKt.forceMeasure(messageField);
        View view4 = getView();
        int min = Math.min(r, ((TextView) (view4 == null ? null : view4.findViewById(e.j.a.messageField))).getMeasuredHeight());
        if (f2) {
            View view5 = getView();
            View messageFieldScrollView2 = view5 == null ? null : view5.findViewById(e.j.a.messageFieldScrollView);
            kotlin.jvm.internal.m.f(messageFieldScrollView2, "messageFieldScrollView");
            collapse$default = View_CommonKt.expand$default(messageFieldScrollView2, getShown(), Integer.valueOf(min), 0, 0L, 12, null);
        } else {
            View view6 = getView();
            View messageFieldScrollView3 = view6 == null ? null : view6.findViewById(e.j.a.messageFieldScrollView);
            kotlin.jvm.internal.m.f(messageFieldScrollView3, "messageFieldScrollView");
            collapse$default = View_CommonKt.collapse$default(messageFieldScrollView3, getShown(), 0L, 2, null);
        }
        h.c.t0.a.a(h.c.t0.g.i(collapse$default, null, new MessageSignerFragment$toggleDetailsView$1(this), 1, null), this.disposeBag);
        View view7 = getView();
        ((ImageView) (view7 != null ? view7.findViewById(e.j.a.detailsImage) : null)).animate().rotation(f2 ? 180.0f : 0.0f).setDuration(100L).start();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<MessageSignerViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<MessageSignerViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.view_message_signer, viewGroup, false);
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setUpViewModel() {
        androidx.lifecycle.b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(MessageSignerViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        setViewModel((MessageSignerViewModel) a);
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<MessageSignerViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setup() {
        x xVar;
        URL dappImageUrl = getViewModel().getDappImageUrl();
        if (dappImageUrl == null) {
            xVar = null;
        } else {
            View view = getView();
            View dappIcon = view == null ? null : view.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon, "dappIcon");
            loadImageInto$app_productionRelease(dappImageUrl, (ImageView) dappIcon);
            xVar = x.a;
        }
        if (xVar == null) {
            View view2 = getView();
            View dappIcon2 = view2 == null ? null : view2.findViewById(e.j.a.dappIcon);
            kotlin.jvm.internal.m.f(dappIcon2, "dappIcon");
            dappIcon2.setVisibility(8);
        }
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.cancelButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                MessageSignerFragment.i(MessageSignerFragment.this, view4);
            }
        });
        View view4 = getView();
        ((Button) (view4 == null ? null : view4.findViewById(e.j.a.signButton))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view5) {
                MessageSignerFragment.h(MessageSignerFragment.this, view5);
            }
        });
        View view5 = getView();
        ((Button) (view5 == null ? null : view5.findViewById(e.j.a.F1))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.signer.views.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view6) {
                MessageSignerFragment.j(MessageSignerFragment.this, view6);
            }
        });
        View view6 = getView();
        TextView textView = (TextView) (view6 == null ? null : view6.findViewById(e.j.a.hostLabel));
        Uri requestUrl = getViewModel().getRequestUrl();
        textView.setText(requestUrl == null ? null : requestUrl.getHost());
        View view7 = getView();
        ((TextView) (view7 == null ? null : view7.findViewById(e.j.a.messageField))).setText(getViewModel().getReadableMessage());
        View view8 = getView();
        ((TextView) (view8 != null ? view8.findViewById(e.j.a.errorText) : null)).setVisibility(String_CoreKt.isHexString(getViewModel().getReadableMessage()) ? 0 : 8);
        toggleDetailsView();
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public MessageSignerViewModel getViewModel() {
        MessageSignerViewModel messageSignerViewModel = this.viewModel;
        if (messageSignerViewModel != null) {
            return messageSignerViewModel;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.features.signer.views.RequestSigningDialog
    public void setViewModel(MessageSignerViewModel messageSignerViewModel) {
        kotlin.jvm.internal.m.g(messageSignerViewModel, "<set-?>");
        this.viewModel = messageSignerViewModel;
    }
}