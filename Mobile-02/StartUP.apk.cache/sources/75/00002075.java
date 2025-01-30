package com.coinbase.wallet.features.send.views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.i;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.commonui.views.NumberKeyboardDigit;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.lend.models.LendAmountPickerArgs;
import com.coinbase.wallet.features.send.models.AmountPickerSettings;
import java.util.Locale;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: AmountFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bI\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J-\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001d\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u0017J\u001f\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0!2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\u0002¢\u0006\u0004\b$\u0010\u0004J\u0015\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%¢\u0006\u0004\b'\u0010(R\u0019\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001f0)8F@\u0006¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b.\u0010/R$\u00102\u001a\u0010\u0012\f\u0012\n 1*\u0004\u0018\u00010\u00020\u0002008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0013\u0010\u0015\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u0015\u00104R\u001f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020!8\u0006@\u0006¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b5\u00107R(\u00109\u001a\b\u0012\u0004\u0012\u00020-088\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0019\u0010A\u001a\b\u0012\u0004\u0012\u00020?0)8F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010+R\u0013\u0010D\u001a\u00020\u001f8F@\u0006¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bF\u0010G¨\u0006J"}, d2 = {"Lcom/coinbase/wallet/features/send/views/AmountFragment;", "Ldagger/android/g/h;", "Lkotlin/x;", "invalidEntry", "()V", "setupObservables", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Lcom/coinbase/wallet/blockchains/models/Wallet;", LendAmountPickerArgs.lendWalletKey, "", "isFiatSelected", "setup", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Z)V", "wallet", "setWallet", "Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;", "digit", "isLongPress", "updateAmount", "(Lcom/coinbase/wallet/commonui/views/NumberKeyboardDigit;Z)V", "", "string", "Lh/c/b0;", "updateCryptoAmount", "(Ljava/lang/String;)Lh/c/b0;", "swapFields", "Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;", "settings", "setStyles", "(Lcom/coinbase/wallet/features/send/models/AmountPickerSettings;)V", "Lh/c/s;", "getCryptoAmountObservable", "()Lh/c/s;", "cryptoAmountObservable", "Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;", "viewModel", "Lcom/coinbase/wallet/commonui/viewmodels/AmountViewModel;", "Lh/c/v0/c;", "kotlin.jvm.PlatformType", "isViewLoadedSubject", "Lh/c/v0/c;", "()Z", "isViewLoadedSingle", "Lh/c/b0;", "()Lh/c/b0;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "amountViewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getAmountViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setAmountViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Ljava/util/Locale;", "getKeyboardLocaleObservable", "keyboardLocaleObservable", "getRawCryptoAmount", "()Ljava/lang/String;", "rawCryptoAmount", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AmountFragment extends dagger.android.g.h {
    public GenericViewModelFactory<AmountViewModel> amountViewModelFactory;
    private final h.c.b0<kotlin.x> isViewLoadedSingle;
    private final h.c.v0.c<kotlin.x> isViewLoadedSubject;
    private AmountViewModel viewModel;

    public AmountFragment() {
        h.c.v0.c<kotlin.x> d2 = h.c.v0.c.d(1);
        kotlin.jvm.internal.m.f(d2, "createWithSize<Unit>(1)");
        this.isViewLoadedSubject = d2;
        h.c.b0<kotlin.x> hide = Observable_CoreKt.takeSingle(d2).hide();
        kotlin.jvm.internal.m.f(hide, "isViewLoadedSubject.takeSingle().hide()");
        this.isViewLoadedSingle = hide;
    }

    public static /* synthetic */ void d(Throwable th) {
        m1388setupObservables$lambda11(th);
    }

    public static /* synthetic */ void e(AmountFragment amountFragment, String str) {
        m1395setupObservables$lambda8(amountFragment, str);
    }

    public static /* synthetic */ void f(AmountFragment amountFragment, kotlin.x xVar) {
        m1387setupObservables$lambda10(amountFragment, xVar);
    }

    public static /* synthetic */ void g(Throwable th) {
        m1396setupObservables$lambda9(th);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public static /* synthetic */ String h(String str) {
        return m1394setupObservables$lambda7(str);
    }

    public static /* synthetic */ String i(String str) {
        return m1391setupObservables$lambda4(str);
    }

    private final void invalidEntry() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 20.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(200L);
        translateAnimation.setInterpolator(new CycleInterpolator(3.0f));
        View view = getView();
        ((AppCompatTextView) (view == null ? null : view.findViewById(e.j.a.R4))).startAnimation(translateAnimation);
    }

    public static /* synthetic */ void j(AmountFragment amountFragment, CurrencyCode currencyCode) {
        m1389setupObservables$lambda2(amountFragment, currencyCode);
    }

    public static /* synthetic */ void k(AmountFragment amountFragment, String str) {
        m1392setupObservables$lambda5(amountFragment, str);
    }

    public static /* synthetic */ void l(Throwable th) {
        m1393setupObservables$lambda6(th);
    }

    public static /* synthetic */ void m(Throwable th) {
        m1390setupObservables$lambda3(th);
    }

    private final void setupObservables() {
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            h.c.s<CurrencyCode> observeOn = amountViewModel.getCurrencyCodeObservable().subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b());
            kotlin.jvm.internal.m.f(observeOn, "viewModel.currencyCodeObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.k
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AmountFragment.j(AmountFragment.this, (CurrencyCode) obj);
                }
            }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.n
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    AmountFragment.m((Throwable) obj);
                }
            });
            AmountViewModel amountViewModel2 = this.viewModel;
            if (amountViewModel2 != null) {
                h.c.s<R> map = amountViewModel2.getPrimaryTextObservable().subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.views.j
                    @Override // h.c.m0.n
                    public final Object apply(Object obj) {
                        return AmountFragment.i((String) obj);
                    }
                });
                kotlin.jvm.internal.m.f(map, "viewModel.primaryTextObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { it.trim() }");
                ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(map, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.l
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        AmountFragment.k(AmountFragment.this, (String) obj);
                    }
                }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.m
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        AmountFragment.l((Throwable) obj);
                    }
                });
                AmountViewModel amountViewModel3 = this.viewModel;
                if (amountViewModel3 != null) {
                    h.c.s<R> map2 = amountViewModel3.getSecondaryTextObservable().subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b()).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.views.i
                        @Override // h.c.m0.n
                        public final Object apply(Object obj) {
                            return AmountFragment.h((String) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(map2, "viewModel.secondaryTextObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n            .map { it.trim() }");
                    ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(map2, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.f
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            AmountFragment.e(AmountFragment.this, (String) obj);
                        }
                    }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.h
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            AmountFragment.g((Throwable) obj);
                        }
                    });
                    AmountViewModel amountViewModel4 = this.viewModel;
                    if (amountViewModel4 != null) {
                        h.c.s<Boolean> observeOn2 = amountViewModel4.getSecondaryTextVisibleObservable().observeOn(h.c.j0.c.a.b());
                        kotlin.jvm.internal.m.f(observeOn2, "viewModel.secondaryTextVisibleObservable\n            .observeOn(AndroidSchedulers.mainThread())");
                        Object as = Observable_AnalyticsKt.logError$default(observeOn2, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                        kotlin.jvm.internal.m.f(as, "viewModel.secondaryTextVisibleObservable\n            .observeOn(AndroidSchedulers.mainThread())\n            .logError()\n            .`as`(AutoDispose.autoDisposable(onDestroyScopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new AmountFragment$setupObservables$9(this), 3, null);
                        AmountViewModel amountViewModel5 = this.viewModel;
                        if (amountViewModel5 != null) {
                            h.c.s<kotlin.x> observeOn3 = amountViewModel5.getTextEntryErrorObservable().subscribeOn(h.c.u0.a.c()).observeOn(h.c.j0.c.a.b());
                            kotlin.jvm.internal.m.f(observeOn3, "viewModel.textEntryErrorObservable\n            .subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())");
                            ((com.uber.autodispose.x) Observable_AnalyticsKt.logError$default(observeOn3, null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.g
                                @Override // h.c.m0.f
                                public final void accept(Object obj) {
                                    AmountFragment.f(AmountFragment.this, (kotlin.x) obj);
                                }
                            }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.e
                                @Override // h.c.m0.f
                                public final void accept(Object obj) {
                                    AmountFragment.d((Throwable) obj);
                                }
                            });
                            return;
                        }
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: setupObservables$lambda-10 */
    public static final void m1387setupObservables$lambda10(AmountFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.invalidEntry();
    }

    /* renamed from: setupObservables$lambda-11 */
    public static final void m1388setupObservables$lambda11(Throwable th) {
    }

    /* renamed from: setupObservables$lambda-2 */
    public static final void m1389setupObservables$lambda2(AmountFragment this$0, CurrencyCode currencyCode) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((AppCompatTextView) (view == null ? null : view.findViewById(e.j.a.i1))).setText(currencyCode.getRawValue());
    }

    /* renamed from: setupObservables$lambda-3 */
    public static final void m1390setupObservables$lambda3(Throwable th) {
    }

    /* renamed from: setupObservables$lambda-4 */
    public static final String m1391setupObservables$lambda4(String it) {
        CharSequence h1;
        kotlin.jvm.internal.m.g(it, "it");
        h1 = kotlin.l0.y.h1(it);
        return h1.toString();
    }

    /* renamed from: setupObservables$lambda-5 */
    public static final void m1392setupObservables$lambda5(AmountFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((AppCompatTextView) (view == null ? null : view.findViewById(e.j.a.R4))).setText(str);
    }

    /* renamed from: setupObservables$lambda-6 */
    public static final void m1393setupObservables$lambda6(Throwable th) {
    }

    /* renamed from: setupObservables$lambda-7 */
    public static final String m1394setupObservables$lambda7(String it) {
        CharSequence h1;
        kotlin.jvm.internal.m.g(it, "it");
        h1 = kotlin.l0.y.h1(it);
        return h1.toString();
    }

    /* renamed from: setupObservables$lambda-8 */
    public static final void m1395setupObservables$lambda8(AmountFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((AppCompatTextView) (view == null ? null : view.findViewById(e.j.a.S5))).setText(str);
    }

    /* renamed from: setupObservables$lambda-9 */
    public static final void m1396setupObservables$lambda9(Throwable th) {
    }

    public static /* synthetic */ void updateAmount$default(AmountFragment amountFragment, NumberKeyboardDigit numberKeyboardDigit, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        amountFragment.updateAmount(numberKeyboardDigit, z);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final GenericViewModelFactory<AmountViewModel> getAmountViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<AmountViewModel> genericViewModelFactory = this.amountViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("amountViewModelFactory");
        throw null;
    }

    public final h.c.s<String> getCryptoAmountObservable() {
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            return amountViewModel.getCryptoAmountObservable();
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final h.c.s<Locale> getKeyboardLocaleObservable() {
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            return amountViewModel.getKeyboardLocaleObservable();
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final String getRawCryptoAmount() {
        String h0;
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            h0 = kotlin.a0.z.h0(amountViewModel.getRawCryptoAmount(), "", null, null, 0, null, null, 62, null);
            return h0;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final boolean isFiatSelected() {
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            return amountViewModel.isFiatSelected();
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public final h.c.b0<kotlin.x> isViewLoadedSingle() {
        return this.isViewLoadedSingle;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_amount_picker_amount, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        this.isViewLoadedSubject.onNext(kotlin.x.a);
    }

    public final void setAmountViewModelFactory$app_productionRelease(GenericViewModelFactory<AmountViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.amountViewModelFactory = genericViewModelFactory;
    }

    public final void setStyles(AmountPickerSettings settings) {
        kotlin.jvm.internal.m.g(settings, "settings");
        Integer a = e.j.f.m.a(this, settings.getTextColor());
        if (a == null) {
            return;
        }
        int intValue = a.intValue();
        View view = getView();
        ((AppCompatTextView) (view == null ? null : view.findViewById(e.j.a.i1))).setTextColor(intValue);
        View view2 = getView();
        ((AppCompatTextView) (view2 == null ? null : view2.findViewById(e.j.a.S5))).setTextColor(intValue);
        View view3 = getView();
        ((AppCompatTextView) (view3 != null ? view3.findViewById(e.j.a.R4) : null)).setTextColor(intValue);
    }

    public final void setWallet(Wallet wallet, boolean z) {
        kotlin.jvm.internal.m.g(wallet, "wallet");
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        CurrencyCode currencyCode = wallet.getCurrencyCode();
        String contractAddress = wallet.getContractAddress();
        int decimals = wallet.getDecimals();
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(wallet.getNetwork());
        amountViewModel.setup(currencyCode, contractAddress, decimals, z, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
    }

    public final void setup(Wallet selectedWallet, boolean z) {
        kotlin.jvm.internal.m.g(selectedWallet, "selectedWallet");
        if (getView() != null) {
            androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getAmountViewModelFactory$app_productionRelease()).a(AmountViewModel.class);
            kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
            AmountViewModel amountViewModel = (AmountViewModel) a;
            this.viewModel = amountViewModel;
            if (amountViewModel != null) {
                CurrencyCode currencyCode = selectedWallet.getCurrencyCode();
                String contractAddress = selectedWallet.getContractAddress();
                int decimals = selectedWallet.getDecimals();
                EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(selectedWallet.getNetwork());
                amountViewModel.setup(currencyCode, contractAddress, decimals, z, asEthereumChain == null ? null : Integer.valueOf(asEthereumChain.getChainId()));
                setupObservables();
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        throw new IllegalStateException("setup must be called before the view is loaded".toString());
    }

    public final void swapFields() {
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            amountViewModel.swapFields();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public final void updateAmount(NumberKeyboardDigit digit, boolean z) {
        kotlin.jvm.internal.m.g(digit, "digit");
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            amountViewModel.updateAmount(digit, z);
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    public final h.c.b0<String> updateCryptoAmount(String string) {
        kotlin.jvm.internal.m.g(string, "string");
        AmountViewModel amountViewModel = this.viewModel;
        if (amountViewModel != null) {
            return amountViewModel.updateCryptoAmount(string);
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }
}