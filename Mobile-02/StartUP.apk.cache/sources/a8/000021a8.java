package com.coinbase.wallet.features.signer.views;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import c.h.k.d0;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.signer.interfaces.StackedRequestItem;
import com.coinbase.wallet.features.signer.models.SigningSessionEvent;
import com.coinbase.wallet.features.signer.viewmodel.SignatureRequestViewState;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import com.toshi.view.custom.SpinnerOverlayLayout;
import com.uber.autodispose.a0;
import h.c.b0;
import h.c.s;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.x;
import org.apache.http.HttpStatus;
import org.toshi.R;

/* compiled from: SignerViewFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bN\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J-\u0010\r\u001a\u00020\u00032\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bj\u0002`\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ-\u0010\u000f\u001a\u00020\u00032\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bj\u0002`\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ-\u0010\u0011\u001a\u00020\u00032\u001c\u0010\u0010\u001a\u0018\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\n0\bj\u0002`\u000bH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J%\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u0016*\u0004\u0018\u00010\u00030\u00030\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ-\u0010#\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00192\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0003H\u0016¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0016¢\u0006\u0004\b(\u0010\u0005R\u0016\u0010,\u001a\u00020)8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00130-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00101\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001d\u00108\u001a\u0002038B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u0016\u0010:\u001a\u0002098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b=\u0010>R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR8\u0010D\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b2\u0010\u0010C\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\b8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bD\u0010E\"\u0004\bF\u0010\u000eR(\u0010H\u001a\b\u0012\u0004\u0012\u00020@0G8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010M¨\u0006O"}, d2 = {"Lcom/coinbase/wallet/features/signer/views/SignerViewFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "presentNextRequest", "()V", "completeSigningFlow", "dismissCurrentPageView", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "Lcom/coinbase/wallet/features/signer/viewmodel/SignatureRequestViewState;", "Lcom/coinbase/wallet/features/signer/interfaces/StackedRequestItem;", "Lcom/coinbase/wallet/features/signer/views/RequestView;", "view", "presentCurrentPageView", "(Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;)V", "subscribeToSessionEvents", "dialogFragment", "swapCurrentPageView", "animateTransitionOut", "Lcom/coinbase/wallet/blockchains/models/CurrencyCode;", AppsFlyerProperties.CURRENCY_CODE, "Lh/c/b0;", "kotlin.jvm.PlatformType", "openCoinDetails", "(Lcom/coinbase/wallet/blockchains/models/CurrencyCode;)Lh/c/b0;", "Landroid/view/View;", "showActivityOverlay", "(Landroid/view/View;)V", "hideActivityOverlay", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "onPause", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "", "approvedCurrencyCodes", "Ljava/util/Set;", "", "currentDialogShown", "Z", "Lcom/toshi/view/custom/SpinnerOverlayLayout;", "spinnerOverlay$delegate", "Lkotlin/h;", "getSpinnerOverlay", "()Lcom/toshi/view/custom/SpinnerOverlayLayout;", "spinnerOverlay", "Lh/c/k0/a;", "currentControllerDisposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/signer/viewmodel/SignerViewModel;", "viewModel", "Lcom/coinbase/wallet/features/signer/viewmodel/SignerViewModel;", "value", "currentDialog", "Lcom/coinbase/wallet/features/signer/views/RequestSigningDialog;", "setCurrentDialog", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SignerViewFragment extends BaseFragment implements StyledFragment {
    private Set<CurrencyCode> approvedCurrencyCodes;
    private final h.c.k0.a currentControllerDisposeBag = new h.c.k0.a();
    private RequestSigningDialog<?, ?> currentDialog;
    private boolean currentDialogShown;
    private final kotlin.h spinnerOverlay$delegate;
    private SignerViewModel viewModel;
    public GenericViewModelFactory<SignerViewModel> viewModelFactory;

    public SignerViewFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new SignerViewFragment$spinnerOverlay$2(this));
        this.spinnerOverlay$delegate = b2;
        this.approvedCurrencyCodes = new LinkedHashSet();
    }

    public final void animateTransitionOut() {
        View view = getView();
        Drawable background = ((CoordinatorLayout) (view == null ? null : view.findViewById(e.j.a.signerContainer))).getBackground();
        Objects.requireNonNull(background, "null cannot be cast to non-null type android.graphics.drawable.TransitionDrawable");
        ((TransitionDrawable) background).reverseTransition(HttpStatus.SC_MULTIPLE_CHOICES);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.coinbase.wallet.features.signer.views.k
            @Override // java.lang.Runnable
            public final void run() {
                SignerViewFragment.f(SignerViewFragment.this);
            }
        });
    }

    /* renamed from: animateTransitionOut$lambda-5 */
    public static final void m1454animateTransitionOut$lambda5(SignerViewFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View signerContainer = view == null ? null : view.findViewById(e.j.a.signerContainer);
        kotlin.jvm.internal.m.f(signerContainer, "signerContainer");
        signerContainer.setVisibility(4);
        View view2 = this$0.getView();
        ((CoordinatorLayout) (view2 != null ? view2.findViewById(e.j.a.signerContainer) : null)).setClickable(false);
    }

    public final void completeSigningFlow() {
        b0<x> just;
        dismissCurrentPageView();
        SignerViewModel signerViewModel = this.viewModel;
        if (signerViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (signerViewModel.getHasPendingRequests()) {
            presentNextRequest();
        } else {
            if (this.approvedCurrencyCodes.size() == 1) {
                just = openCoinDetails((CurrencyCode) kotlin.a0.p.X(this.approvedCurrencyCodes));
            } else {
                just = b0.just(x.a);
                kotlin.jvm.internal.m.f(just, "{\n                Single.just(Unit)\n            }");
            }
            this.approvedCurrencyCodes.clear();
            b0<x> onErrorReturn = just.observeOn(h.c.j0.c.a.b()).onErrorReturn(new h.c.m0.n() { // from class: com.coinbase.wallet.features.signer.views.j
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SignerViewFragment.e((Throwable) obj);
                }
            });
            kotlin.jvm.internal.m.f(onErrorReturn, "openCoinDetailsSingle\n                .observeOn(AndroidSchedulers.mainThread())\n                .onErrorReturn { Unit }");
            h.c.t0.a.a(h.c.t0.g.i(Single_AnalyticsKt.logError$default(onErrorReturn, "Couldn't subscribe to open coin details single", null, 2, null), null, new SignerViewFragment$completeSigningFlow$2(this), 1, null), this.currentControllerDisposeBag);
        }
    }

    /* renamed from: completeSigningFlow$lambda-4 */
    public static final x m1455completeSigningFlow$lambda4(Throwable it) {
        kotlin.jvm.internal.m.g(it, "it");
        return x.a;
    }

    public static /* synthetic */ void d(Throwable th) {
        m1457onResume$lambda3(th);
    }

    public final void dismissCurrentPageView() {
        RequestSigningDialog<?, ?> requestSigningDialog = this.currentDialog;
        if (requestSigningDialog != null) {
            requestSigningDialog.dismiss();
        }
        setCurrentDialog(null);
        this.currentControllerDisposeBag.d();
    }

    public static /* synthetic */ x e(Throwable th) {
        return m1455completeSigningFlow$lambda4(th);
    }

    public static /* synthetic */ void f(SignerViewFragment signerViewFragment) {
        m1454animateTransitionOut$lambda5(signerViewFragment);
    }

    public static /* synthetic */ void g(Boolean bool) {
        m1456onResume$lambda2(bool);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final SpinnerOverlayLayout getSpinnerOverlay() {
        return (SpinnerOverlayLayout) this.spinnerOverlay$delegate.getValue();
    }

    public final void hideActivityOverlay(View view) {
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        if (viewGroup == null) {
            return;
        }
        viewGroup.removeView(getSpinnerOverlay());
    }

    /* renamed from: onResume$lambda-2 */
    public static final void m1456onResume$lambda2(Boolean bool) {
    }

    /* renamed from: onResume$lambda-3 */
    public static final void m1457onResume$lambda3(Throwable th) {
    }

    private final b0<x> openCoinDetails(CurrencyCode currencyCode) {
        b0<x> just = b0.just(x.a);
        kotlin.jvm.internal.m.f(just, "just(Unit)");
        return just;
    }

    private final void presentCurrentPageView(RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> requestSigningDialog) {
        requestSigningDialog.show(requireActivity().getSupportFragmentManager(), requestSigningDialog.getTag());
        subscribeToSessionEvents(requestSigningDialog);
        setCurrentDialog(requestSigningDialog);
    }

    public final void presentNextRequest() {
        SignerViewModel signerViewModel = this.viewModel;
        if (signerViewModel != null) {
            b0<Optional<SignatureRequestViewState>> observeOn = signerViewModel.getNextSignatureRequest().observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "viewModel.getNextSignatureRequest()\n            .observeOn(AndroidSchedulers.mainThread())");
            Object as = Single_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.getNextSignatureRequest()\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((a0) as, new SignerViewFragment$presentNextRequest$1(this), new SignerViewFragment$presentNextRequest$2(this));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void setCurrentDialog(RequestSigningDialog<?, ?> requestSigningDialog) {
        this.currentDialogShown = requestSigningDialog != null;
        this.currentDialog = requestSigningDialog;
    }

    public final void showActivityOverlay(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.rootView);
        int height = view.getHeight();
        if (!(constraintLayout instanceof ViewGroup)) {
            constraintLayout = null;
        }
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.addView(getSpinnerOverlay(), constraintLayout.getChildCount(), new ConstraintLayout.b(-1, height));
        getSpinnerOverlay().setLoading(true);
    }

    private final void subscribeToSessionEvents(RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> requestSigningDialog) {
        s<SigningSessionEvent> observeOn = requestSigningDialog.getSigningSessionEvents().observeOn(h.c.j0.c.a.b());
        kotlin.jvm.internal.m.f(observeOn, "view.signingSessionEvents\n            .observeOn(AndroidSchedulers.mainThread())");
        h.c.t0.a.a(h.c.t0.g.h(Observable_AnalyticsKt.logError$default(observeOn, "Couldn't get signing session events", null, 2, null), null, null, new SignerViewFragment$subscribeToSessionEvents$1(this, requestSigningDialog), 3, null), this.currentControllerDisposeBag);
    }

    public final void swapCurrentPageView(RequestSigningDialog<SignatureRequestViewState, StackedRequestItem<SignatureRequestViewState>> requestSigningDialog) {
        dismissCurrentPageView();
        presentCurrentPageView(requestSigningDialog);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final GenericViewModelFactory<SignerViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<SignerViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_signer_view, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.currentControllerDisposeBag.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00af  */
    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onResume() {
        /*
            r10 = this;
            super.onResume()
            androidx.fragment.app.m r0 = r10.getFragmentManager()
            r1 = 0
            if (r0 != 0) goto Lc
        La:
            r0 = r1
            goto L44
        Lc:
            java.util.List r0 = r0.h0()
            if (r0 != 0) goto L13
            goto La
        L13:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L36
            java.lang.Object r3 = r0.next()
            androidx.fragment.app.Fragment r3 = (androidx.fragment.app.Fragment) r3
            boolean r4 = r3 instanceof com.coinbase.wallet.features.signer.views.RequestSigningDialog
            if (r4 == 0) goto L2f
            com.coinbase.wallet.features.signer.views.RequestSigningDialog r3 = (com.coinbase.wallet.features.signer.views.RequestSigningDialog) r3
            goto L30
        L2f:
            r3 = r1
        L30:
            if (r3 == 0) goto L1c
            r2.add(r3)
            goto L1c
        L36:
            java.lang.Object r0 = kotlin.a0.p.a0(r2)
            com.coinbase.wallet.features.signer.views.RequestSigningDialog r0 = (com.coinbase.wallet.features.signer.views.RequestSigningDialog) r0
            if (r0 != 0) goto L3f
            goto La
        L3f:
            r10.subscribeToSessionEvents(r0)
            kotlin.x r2 = kotlin.x.a
        L44:
            r10.setCurrentDialog(r0)
            com.coinbase.wallet.features.signer.viewmodel.SignerViewModel r0 = r10.viewModel
            java.lang.String r2 = "viewModel"
            if (r0 == 0) goto Laf
            h.c.s r0 = r0.getPresentNextRequestObservable()
            h.c.a0 r3 = h.c.j0.c.a.b()
            h.c.s r0 = r0.observeOn(r3)
            java.lang.String r3 = "viewModel.presentNextRequestObservable\n            .observeOn(AndroidSchedulers.mainThread())"
            kotlin.jvm.internal.m.f(r0, r3)
            r3 = 2
            java.lang.String r4 = "Couldn't present next request"
            h.c.s r0 = com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt.logError$default(r0, r4, r1, r3, r1)
            com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider r3 = r10.getScopeProvider()
            com.uber.autodispose.g r3 = com.uber.autodispose.d.a(r3)
            java.lang.Object r0 = r0.as(r3)
            java.lang.String r3 = "viewModel.presentNextRequestObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError(\"Couldn't present next request\")\n            .`as`(autoDisposable(scopeProvider))"
            kotlin.jvm.internal.m.f(r0, r3)
            r4 = r0
            com.uber.autodispose.x r4 = (com.uber.autodispose.x) r4
            r5 = 0
            r6 = 0
            com.coinbase.wallet.features.signer.views.SignerViewFragment$onResume$3 r7 = new com.coinbase.wallet.features.signer.views.SignerViewFragment$onResume$3
            r7.<init>(r10)
            r8 = 3
            r9 = 0
            com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt.subscribeBy$default(r4, r5, r6, r7, r8, r9)
            com.coinbase.wallet.features.signer.viewmodel.SignerViewModel r0 = r10.viewModel
            if (r0 == 0) goto Lab
            h.c.s r0 = r0.isWalletLinkRequestObservable()
            h.c.a0 r1 = h.c.j0.c.a.b()
            h.c.s r0 = r0.observeOn(r1)
            com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider r1 = r10.getScopeProvider()
            com.uber.autodispose.g r1 = com.uber.autodispose.d.a(r1)
            java.lang.Object r0 = r0.as(r1)
            com.uber.autodispose.x r0 = (com.uber.autodispose.x) r0
            com.coinbase.wallet.features.signer.views.l r1 = new h.c.m0.f() { // from class: com.coinbase.wallet.features.signer.views.l
                static {
                    /*
                        com.coinbase.wallet.features.signer.views.l r0 = new com.coinbase.wallet.features.signer.views.l
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:com.coinbase.wallet.features.signer.views.l) com.coinbase.wallet.features.signer.views.l.a com.coinbase.wallet.features.signer.views.l
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.l.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.l.<init>():void");
                }

                @Override // h.c.m0.f
                public final void accept(java.lang.Object r1) {
                    /*
                        r0 = this;
                        java.lang.Boolean r1 = (java.lang.Boolean) r1
                        com.coinbase.wallet.features.signer.views.SignerViewFragment.g(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.l.accept(java.lang.Object):void");
                }
            }
            com.coinbase.wallet.features.signer.views.i r2 = new h.c.m0.f() { // from class: com.coinbase.wallet.features.signer.views.i
                static {
                    /*
                        com.coinbase.wallet.features.signer.views.i r0 = new com.coinbase.wallet.features.signer.views.i
                        r0.<init>()
                        
                        // error: 0x0005: SPUT  (r0 I:com.coinbase.wallet.features.signer.views.i) com.coinbase.wallet.features.signer.views.i.a com.coinbase.wallet.features.signer.views.i
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.i.<clinit>():void");
                }

                {
                    /*
                        r0 = this;
                        r0.<init>()
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.i.<init>():void");
                }

                @Override // h.c.m0.f
                public final void accept(java.lang.Object r1) {
                    /*
                        r0 = this;
                        java.lang.Throwable r1 = (java.lang.Throwable) r1
                        com.coinbase.wallet.features.signer.views.SignerViewFragment.d(r1)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.i.accept(java.lang.Object):void");
                }
            }
            r0.subscribe(r1, r2)
            return
        Lab:
            kotlin.jvm.internal.m.w(r2)
            throw r1
        Laf:
            kotlin.jvm.internal.m.w(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.signer.views.SignerViewFragment.onResume():void");
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        View view2 = getView();
        View signerContainer = view2 == null ? null : view2.findViewById(e.j.a.signerContainer);
        kotlin.jvm.internal.m.f(signerContainer, "signerContainer");
        View_CommonKt.setOnSingleClickListener$default(signerContainer, 0L, new SignerViewFragment$onViewCreated$1(this), 1, null);
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(SignerViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (SignerViewModel) a;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<SignerViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}