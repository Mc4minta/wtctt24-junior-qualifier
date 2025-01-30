package com.coinbase.wallet.features.settings.views;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import androidx.lifecycle.b0;
import c.h.k.d0;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.LockedFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.settings.models.UserProfileViewState;
import com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel;
import com.uber.autodispose.d;
import com.uber.autodispose.x;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.a0;
import org.toshi.R;

/* compiled from: UserProfileFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ-\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001b8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00180#8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/coinbase/wallet/features/settings/views/UserProfileFragment;", "Lcom/coinbase/wallet/commonui/views/LockedFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "", ApiConstants.USER, "Lkotlin/x;", "updateUser", "(Ljava/lang/String;)V", "Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;", "userProfileViewState", "updatePrivacySetting", "(Lcom/coinbase/wallet/features/settings/models/UserProfileViewState;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/features/settings/viewmodels/UserProfileViewModel;", "viewModel", "Lcom/coinbase/wallet/features/settings/viewmodels/UserProfileViewModel;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UserProfileFragment extends LockedFragment implements StyledFragment {
    private UserProfileViewModel viewModel;
    public GenericViewModelFactory<UserProfileViewModel> viewModelFactory;

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updatePrivacySetting(UserProfileViewState userProfileViewState) {
        ColorStateList valueOf = ColorStateList.valueOf(a.d(requireContext(), R.color.grey_30));
        m.f(valueOf, "valueOf(ContextCompat.getColor(requireContext(), R.color.grey_30))");
        ColorStateList valueOf2 = ColorStateList.valueOf(a.d(requireContext(), R.color.primary_blue));
        m.f(valueOf2, "valueOf(ContextCompat.getColor(requireContext(), R.color.primary_blue))");
        if (userProfileViewState.isSwitchingPrivacySetting() && userProfileViewState.isPublic()) {
            View view = getView();
            ((ConstraintLayout) (view == null ? null : view.findViewById(e.j.a.privacyPublicContainer))).setClickable(false);
            View view2 = getView();
            ((ConstraintLayout) (view2 == null ? null : view2.findViewById(e.j.a.privacyPrivateContainer))).setClickable(false);
            View view3 = getView();
            ((ConstraintLayout) (view3 == null ? null : view3.findViewById(e.j.a.privacyPublicContainer))).setAlpha(1.0f);
            View view4 = getView();
            ((ConstraintLayout) (view4 == null ? null : view4.findViewById(e.j.a.privacyPrivateContainer))).setAlpha(0.6f);
            View view5 = getView();
            ((ProgressBar) (view5 == null ? null : view5.findViewById(e.j.a.privacyPublicLoader))).setVisibility(8);
            View view6 = getView();
            ((ProgressBar) (view6 != null ? view6.findViewById(e.j.a.privacyPrivateLoader) : null)).setVisibility(0);
        } else if (userProfileViewState.isSwitchingPrivacySetting() && !userProfileViewState.isPublic()) {
            View view7 = getView();
            ((ConstraintLayout) (view7 == null ? null : view7.findViewById(e.j.a.privacyPublicContainer))).setClickable(false);
            View view8 = getView();
            ((ConstraintLayout) (view8 == null ? null : view8.findViewById(e.j.a.privacyPrivateContainer))).setClickable(false);
            View view9 = getView();
            ((ConstraintLayout) (view9 == null ? null : view9.findViewById(e.j.a.privacyPublicContainer))).setAlpha(0.6f);
            View view10 = getView();
            ((ConstraintLayout) (view10 == null ? null : view10.findViewById(e.j.a.privacyPrivateContainer))).setAlpha(1.0f);
            View view11 = getView();
            ((ProgressBar) (view11 == null ? null : view11.findViewById(e.j.a.privacyPublicLoader))).setVisibility(0);
            View view12 = getView();
            ((ProgressBar) (view12 != null ? view12.findViewById(e.j.a.privacyPrivateLoader) : null)).setVisibility(8);
        } else if (userProfileViewState.isPublic()) {
            View view13 = getView();
            ((ConstraintLayout) (view13 == null ? null : view13.findViewById(e.j.a.privacyPublicContainer))).setClickable(false);
            View view14 = getView();
            ((ConstraintLayout) (view14 == null ? null : view14.findViewById(e.j.a.privacyPrivateContainer))).setClickable(true);
            View view15 = getView();
            ((ConstraintLayout) (view15 == null ? null : view15.findViewById(e.j.a.privacyPublicContainer))).setBackgroundTintList(valueOf2);
            View view16 = getView();
            ((ImageView) (view16 == null ? null : view16.findViewById(e.j.a.privacyPublicImage))).setBackgroundTintList(valueOf2);
            View view17 = getView();
            ((ConstraintLayout) (view17 == null ? null : view17.findViewById(e.j.a.privacyPrivateContainer))).setBackgroundTintList(valueOf);
            View view18 = getView();
            ((ImageView) (view18 == null ? null : view18.findViewById(e.j.a.privacyPrivateImage))).setBackgroundTintList(valueOf);
            View view19 = getView();
            ((ConstraintLayout) (view19 == null ? null : view19.findViewById(e.j.a.privacyPublicContainer))).setAlpha(1.0f);
            View view20 = getView();
            ((ConstraintLayout) (view20 == null ? null : view20.findViewById(e.j.a.privacyPrivateContainer))).setAlpha(1.0f);
            View view21 = getView();
            ((ProgressBar) (view21 == null ? null : view21.findViewById(e.j.a.privacyPublicLoader))).setVisibility(8);
            View view22 = getView();
            ((ProgressBar) (view22 != null ? view22.findViewById(e.j.a.privacyPrivateLoader) : null)).setVisibility(8);
        } else {
            View view23 = getView();
            ((ConstraintLayout) (view23 == null ? null : view23.findViewById(e.j.a.privacyPublicContainer))).setClickable(true);
            View view24 = getView();
            ((ConstraintLayout) (view24 == null ? null : view24.findViewById(e.j.a.privacyPrivateContainer))).setClickable(false);
            View view25 = getView();
            ((ConstraintLayout) (view25 == null ? null : view25.findViewById(e.j.a.privacyPublicContainer))).setBackgroundTintList(valueOf);
            View view26 = getView();
            ((ImageView) (view26 == null ? null : view26.findViewById(e.j.a.privacyPublicImage))).setBackgroundTintList(valueOf);
            View view27 = getView();
            ((ConstraintLayout) (view27 == null ? null : view27.findViewById(e.j.a.privacyPrivateContainer))).setBackgroundTintList(valueOf2);
            View view28 = getView();
            ((ImageView) (view28 == null ? null : view28.findViewById(e.j.a.privacyPrivateImage))).setBackgroundTintList(valueOf2);
            View view29 = getView();
            ((ConstraintLayout) (view29 == null ? null : view29.findViewById(e.j.a.privacyPublicContainer))).setAlpha(1.0f);
            View view30 = getView();
            ((ConstraintLayout) (view30 == null ? null : view30.findViewById(e.j.a.privacyPrivateContainer))).setAlpha(1.0f);
            View view31 = getView();
            ((ProgressBar) (view31 == null ? null : view31.findViewById(e.j.a.privacyPublicLoader))).setVisibility(8);
            View view32 = getView();
            ((ProgressBar) (view32 != null ? view32.findViewById(e.j.a.privacyPrivateLoader) : null)).setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateUser(String str) {
        char l1;
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(e.j.a.username);
        String it = getString(R.string.prefixed_username, str);
        m.f(it, "it");
        SpannableString valueOf = SpannableString.valueOf(it);
        m.f(valueOf, "SpannableString.valueOf(this)");
        valueOf.setSpan(new ForegroundColorSpan(a.d(requireContext(), R.color.grey_50)), 0, 1, 33);
        ((TextView) findViewById).setText(valueOf);
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.l4))).setVisibility(0);
        View view3 = getView();
        View findViewById2 = view3 != null ? view3.findViewById(e.j.a.l4) : null;
        l1 = a0.l1(str);
        ((TextView) findViewById2).setText(String.valueOf(Character.toUpperCase(l1)));
    }

    @Override // com.coinbase.wallet.commonui.views.LockedFragment, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), false, true, false, 5, null);
    }

    public final GenericViewModelFactory<UserProfileViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<UserProfileViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_user_profile, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        m.g(view, "view");
        b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(UserProfileViewModel.class);
        m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (UserProfileViewModel) a;
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new UserProfileFragment$onViewCreated$1(this), 1, null);
        UserProfileViewModel userProfileViewModel = this.viewModel;
        if (userProfileViewModel != null) {
            Object as = Observable_AnalyticsKt.logError$default(userProfileViewModel.getViewStateObservable(), null, null, 3, null).observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
            m.f(as, "viewModel.viewStateObservable\n            .logError()\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as, null, null, new UserProfileFragment$onViewCreated$2(this), 3, null);
            UserProfileViewModel userProfileViewModel2 = this.viewModel;
            if (userProfileViewModel2 != null) {
                Object as2 = userProfileViewModel2.getErrorStateObservable().observeOn(h.c.j0.c.a.b()).as(d.a(getScopeProvider()));
                m.f(as2, "viewModel.errorStateObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((x) as2, null, null, new UserProfileFragment$onViewCreated$3(this), 3, null);
                View view3 = getView();
                View privacyPublicContainer = view3 == null ? null : view3.findViewById(e.j.a.privacyPublicContainer);
                m.f(privacyPublicContainer, "privacyPublicContainer");
                View_CommonKt.setOnSingleClickListener$default(privacyPublicContainer, 0L, new UserProfileFragment$onViewCreated$4(this), 1, null);
                View view4 = getView();
                View privacyPrivateContainer = view4 != null ? view4.findViewById(e.j.a.privacyPrivateContainer) : null;
                m.f(privacyPrivateContainer, "privacyPrivateContainer");
                View_CommonKt.setOnSingleClickListener$default(privacyPrivateContainer, 0L, new UserProfileFragment$onViewCreated$5(this), 1, null);
                return;
            }
            m.w("viewModel");
            throw null;
        }
        m.w("viewModel");
        throw null;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<UserProfileViewModel> genericViewModelFactory) {
        m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}