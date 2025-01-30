package com.coinbase.wallet.application.fragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.app.h;
import androidx.lifecycle.d0;
import com.coinbase.wallet.application.MainActivity;
import com.coinbase.wallet.application.viewmodel.SignOutViewModel;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.toshi.view.custom.SpinnerOverlayLayout;
import dagger.android.g.f;
import h.c.b0;
import h.c.m0.n;
import h.c.t0.g;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: SignOutFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b \u0010\u0015J-\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\fH\u0017¢\u0006\u0004\b\u0014\u0010\u0015R(\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006\""}, d2 = {"Lcom/coinbase/wallet/application/fragment/SignOutFragment;", "Ldagger/android/g/f;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lkotlin/x;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/app/Dialog;", "onCreateDialog", "(Landroid/os/Bundle;)Landroid/app/Dialog;", "onCreate", "(Landroid/os/Bundle;)V", "onStart", "()V", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/application/viewmodel/SignOutViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModel", "Lcom/coinbase/wallet/application/viewmodel/SignOutViewModel;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignOutFragment extends f {
    public static final Companion Companion = new Companion(null);
    public static final String tag = "SignOutFragment";
    private SignOutViewModel viewModel;
    public GenericViewModelFactory<SignOutViewModel> viewModelFactory;

    /* compiled from: SignOutFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/fragment/SignOutFragment$Companion;", "", "", "tag", "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ x d(Throwable th) {
        return m647onStart$lambda1(th);
    }

    /* renamed from: onStart$lambda-1 */
    public static final x m647onStart$lambda1(Throwable it) {
        m.g(it, "it");
        return x.a;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<SignOutViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<SignOutViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.FullscreenDialog);
    }

    @Override // androidx.fragment.app.c
    public Dialog onCreateDialog(Bundle bundle) {
        h hVar = new h(requireContext(), getTheme()) { // from class: com.coinbase.wallet.application.fragment.SignOutFragment$onCreateDialog$dialog$1
            @Override // android.app.Dialog
            public void onBackPressed() {
            }
        };
        Window window = hVar.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        hVar.setCanceledOnTouchOutside(false);
        return hVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_sign_out, viewGroup, false);
    }

    @Override // androidx.fragment.app.c, androidx.fragment.app.Fragment
    @SuppressLint({"CheckResult"})
    public void onStart() {
        super.onStart();
        View view = getView();
        ((SpinnerOverlayLayout) (view == null ? null : view.findViewById(e.j.a.spinnerOverlay))).b(true);
        Intent intent = new Intent(getActivity(), MainActivity.class);
        SignOutViewModel signOutViewModel = this.viewModel;
        if (signOutViewModel != null) {
            b0<x> onErrorReturn = signOutViewModel.signOut().observeOn(h.c.j0.c.a.b()).onErrorReturn(new n() { // from class: com.coinbase.wallet.application.fragment.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SignOutFragment.d((Throwable) obj);
                }
            });
            m.f(onErrorReturn, "viewModel.signOut()\n            .observeOn(AndroidSchedulers.mainThread())\n            .onErrorReturn { Unit }");
            g.i(onErrorReturn, null, new SignOutFragment$onStart$2(this, intent), 1, null);
            return;
        }
        m.w("viewModel");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        super.onViewCreated(view, bundle);
        androidx.lifecycle.b0 a = new d0(this, getViewModelFactory$app_productionRelease()).a(SignOutViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (SignOutViewModel) a;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<SignOutViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}