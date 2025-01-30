package com.coinbase.wallet.features.send.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.blockchains.models.TransferValue;
import com.coinbase.wallet.blockchains.models.TxMetadataKey;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import com.coinbase.wallet.features.send.viewmodels.PendingRecipient;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import com.coinbase.wallet.features.send.views.adapters.SendDestinationAdapter;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import com.toshi.view.custom.ProgressBarButton;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: SendDestinationPickerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b`\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u0003*\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0003H\u0016¢\u0006\u0004\b \u0010\u0005J\u000f\u0010!\u001a\u00020\u0003H\u0016¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\"\u0010\u0005R(\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010-\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u001d\u00104\u001a\u00020/8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R(\u00106\u001a\b\u0012\u0004\u0012\u0002050#8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b6\u0010&\u001a\u0004\b7\u0010(\"\u0004\b8\u0010*R:\u0010:\u001a&\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e ,*\u0012\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e\u0018\u000109098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020$8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010>\u001a\u0002058\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010A\u001a\u00020@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bA\u0010BR:\u0010C\u001a&\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e ,*\u0012\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e\u0018\u000109098\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u0010;R$\u0010D\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u000e0\u000e0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bD\u0010.R\u001d\u0010I\u001a\u00020E8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bF\u00101\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020J8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010P\u001a\u00020M8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001d\u0010U\u001a\u00020Q8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\bR\u00101\u001a\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020V8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bW\u0010XR\u001e\u0010Y\u001a\n ,*\u0004\u0018\u00010@0@8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bY\u0010BR#\u0010_\u001a\b\u0012\u0004\u0012\u00020[0Z8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\\\u00101\u001a\u0004\b]\u0010^¨\u0006a"}, d2 = {"Lcom/coinbase/wallet/features/send/views/SendDestinationPickerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setupViews", "()V", "setupObservables", "checkPendingScanResults", "showMetadataField", "", "isMetadata", "setupQrScanner", "(Z)V", "Landroidx/appcompat/widget/AppCompatEditText;", "", "str", "setTextNoTrack", "(Landroidx/appcompat/widget/AppCompatEditText;Ljava/lang/String;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onCreate", "(Landroid/os/Bundle;)V", "onResume", "onDestroyView", "onDestroy", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/send/viewmodels/SendDestinationPickerViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "searchTextSubject", "Lh/c/v0/b;", "Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount$delegate", "Lkotlin/h;", "getAmount", "()Lcom/coinbase/wallet/blockchains/models/TransferValue;", "amount", "Le/j/h/a/j;", "qrScannerViewModelFactory", "getQrScannerViewModelFactory", "setQrScannerViewModelFactory", "Lh/c/s;", "metadataTextObservable", "Lh/c/s;", "viewModel", "Lcom/coinbase/wallet/features/send/viewmodels/SendDestinationPickerViewModel;", "qrScannerViewModel", "Le/j/h/a/j;", "Lh/c/a0;", "concurrentScheduler", "Lh/c/a0;", "searchTextObservable", "metadataTextSubject", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet$delegate", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter;", "adapter", "Lcom/coinbase/wallet/features/send/views/adapters/SendDestinationAdapter;", "mainScheduler", "", "Le/j/k/a/a;", "memoTypes$delegate", "getMemoTypes", "()Ljava/util/List;", "memoTypes", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SendDestinationPickerFragment extends BaseFragment implements StyledFragment {
    private SendDestinationAdapter adapter;
    private final kotlin.h amount$delegate;
    private final kotlin.h attributes$delegate;
    private final h.c.a0 concurrentScheduler;
    private h.c.k0.a disposeBag;
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private final kotlin.h memoTypes$delegate;
    private final h.c.s<String> metadataTextObservable;
    private final h.c.v0.b<String> metadataTextSubject;
    private e.j.h.a.j qrScannerViewModel;
    public GenericViewModelFactory<e.j.h.a.j> qrScannerViewModelFactory;
    private final h.c.s<String> searchTextObservable;
    private final h.c.v0.b<String> searchTextSubject;
    private SendDestinationPickerViewModel viewModel;
    public GenericViewModelFactory<SendDestinationPickerViewModel> viewModelFactory;
    private final kotlin.h wallet$delegate;

    public SendDestinationPickerFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        kotlin.h b5;
        h.c.a0 c2 = h.c.u0.a.c();
        kotlin.jvm.internal.m.f(c2, "io()");
        this.concurrentScheduler = c2;
        b2 = kotlin.k.b(new SendDestinationPickerFragment$wallet$2(this));
        this.wallet$delegate = b2;
        b3 = kotlin.k.b(new SendDestinationPickerFragment$amount$2(this));
        this.amount$delegate = b3;
        b4 = kotlin.k.b(SendDestinationPickerFragment$memoTypes$2.INSTANCE);
        this.memoTypes$delegate = b4;
        h.c.v0.b<String> d2 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d2, "create<String>()");
        this.searchTextSubject = d2;
        h.c.v0.b<String> d3 = h.c.v0.b.d();
        kotlin.jvm.internal.m.f(d3, "create<String>()");
        this.metadataTextSubject = d3;
        h.c.s<String> hide = d2.hide();
        Strings strings = Strings.INSTANCE;
        this.searchTextObservable = hide.startWith((h.c.s<String>) Strings_CoreKt.getEmpty(strings));
        this.metadataTextObservable = d3.hide().startWith((h.c.s<String>) Strings_CoreKt.getEmpty(strings));
        this.disposeBag = new h.c.k0.a();
        b5 = kotlin.k.b(new SendDestinationPickerFragment$attributes$2(this));
        this.attributes$delegate = b5;
    }

    private final void checkPendingScanResults() {
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this.viewModel;
        if (sendDestinationPickerViewModel != null) {
            ((com.uber.autodispose.a0) Observable_CoreKt.takeSingle(sendDestinationPickerViewModel.getRecipientScanResultObservable()).observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.f0
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    SendDestinationPickerFragment.e(SendDestinationPickerFragment.this, (String) obj);
                }
            }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.e0
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    SendDestinationPickerFragment.d(SendDestinationPickerFragment.this, (Throwable) obj);
                }
            });
            SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.viewModel;
            if (sendDestinationPickerViewModel2 != null) {
                ((com.uber.autodispose.a0) Observable_CoreKt.takeSingle(sendDestinationPickerViewModel2.getMetadataScanResultObservable()).observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.j0
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        SendDestinationPickerFragment.i(SendDestinationPickerFragment.this, (String) obj);
                    }
                }, new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.h0
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        SendDestinationPickerFragment.g(SendDestinationPickerFragment.this, (Throwable) obj);
                    }
                });
                return;
            } else {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: checkPendingScanResults$lambda-4 */
    public static final void m1413checkPendingScanResults$lambda4(SendDestinationPickerFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View searchField = view == null ? null : view.findViewById(e.j.a.searchField);
        kotlin.jvm.internal.m.f(searchField, "searchField");
        this$0.setTextNoTrack((AppCompatEditText) searchField, str);
        View view2 = this$0.getView();
        View metadataField = view2 == null ? null : view2.findViewById(e.j.a.metadataField);
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        if (metadataField.getVisibility() == 0) {
            View view3 = this$0.getView();
            ((AppCompatEditText) (view3 != null ? view3.findViewById(e.j.a.metadataField) : null)).requestFocus();
        }
    }

    /* renamed from: checkPendingScanResults$lambda-5 */
    public static final void m1414checkPendingScanResults$lambda5(SendDestinationPickerFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View searchField = view == null ? null : view.findViewById(e.j.a.searchField);
        kotlin.jvm.internal.m.f(searchField, "searchField");
        this$0.setTextNoTrack((AppCompatEditText) searchField, null);
    }

    /* renamed from: checkPendingScanResults$lambda-6 */
    public static final void m1415checkPendingScanResults$lambda6(SendDestinationPickerFragment this$0, String str) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.showMetadataField();
        View view = this$0.getView();
        View metadataField = view == null ? null : view.findViewById(e.j.a.metadataField);
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        this$0.setTextNoTrack((AppCompatEditText) metadataField, str);
    }

    /* renamed from: checkPendingScanResults$lambda-7 */
    public static final void m1416checkPendingScanResults$lambda7(SendDestinationPickerFragment this$0, Throwable th) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        View metadataField = view == null ? null : view.findViewById(e.j.a.metadataField);
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        this$0.setTextNoTrack((AppCompatEditText) metadataField, null);
    }

    public static /* synthetic */ void d(SendDestinationPickerFragment sendDestinationPickerFragment, Throwable th) {
        m1414checkPendingScanResults$lambda5(sendDestinationPickerFragment, th);
    }

    public static /* synthetic */ void e(SendDestinationPickerFragment sendDestinationPickerFragment, String str) {
        m1413checkPendingScanResults$lambda4(sendDestinationPickerFragment, str);
    }

    public static /* synthetic */ void f(SendDestinationPickerFragment sendDestinationPickerFragment, String str) {
        m1420setupQrScanner$lambda9(sendDestinationPickerFragment, str);
    }

    public static /* synthetic */ void g(SendDestinationPickerFragment sendDestinationPickerFragment, Throwable th) {
        m1416checkPendingScanResults$lambda7(sendDestinationPickerFragment, th);
    }

    private final TransferValue getAmount() {
        return (TransferValue) this.amount$delegate.getValue();
    }

    public final List<e.j.k.a.a> getMemoTypes() {
        return (List) this.memoTypes$delegate.getValue();
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final Wallet getWallet() {
        return (Wallet) this.wallet$delegate.getValue();
    }

    public static /* synthetic */ void h(SendDestinationPickerFragment sendDestinationPickerFragment, Boolean bool) {
        m1418setupQrScanner$lambda10(sendDestinationPickerFragment, bool);
    }

    public static /* synthetic */ void i(SendDestinationPickerFragment sendDestinationPickerFragment, String str) {
        m1415checkPendingScanResults$lambda6(sendDestinationPickerFragment, str);
    }

    public static /* synthetic */ void j(SendDestinationPickerFragment sendDestinationPickerFragment, kotlin.o oVar) {
        m1417setupObservables$lambda3(sendDestinationPickerFragment, oVar);
    }

    public static /* synthetic */ h.c.h0 k(SendDestinationPickerFragment sendDestinationPickerFragment, List list) {
        return m1419setupQrScanner$lambda8(sendDestinationPickerFragment, list);
    }

    public static /* synthetic */ void l(SendDestinationPickerFragment sendDestinationPickerFragment, View view) {
        m1421setupViews$lambda2(sendDestinationPickerFragment, view);
    }

    public final void setTextNoTrack(AppCompatEditText appCompatEditText, String str) {
        appCompatEditText.setTag(R.id.TAG_NO_TRACK, Boolean.TRUE);
        appCompatEditText.setText(str);
    }

    private final void setupObservables() {
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this.viewModel;
        if (sendDestinationPickerViewModel != null) {
            Object as = sendDestinationPickerViewModel.getStateObservable().distinctUntilChanged().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.stateObservable\n            .distinctUntilChanged()\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new SendDestinationPickerFragment$setupObservables$1(this), 3, null);
            SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.viewModel;
            if (sendDestinationPickerViewModel2 != null) {
                Object as2 = sendDestinationPickerViewModel2.getLaunchQrScannerObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.launchQrScannerObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new SendDestinationPickerFragment$setupObservables$2(this), 3, null);
                SendDestinationPickerViewModel sendDestinationPickerViewModel3 = this.viewModel;
                if (sendDestinationPickerViewModel3 != null) {
                    Object as3 = sendDestinationPickerViewModel3.getLaunchSendConfirmObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                    kotlin.jvm.internal.m.f(as3, "viewModel.launchSendConfirmObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                    ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new SendDestinationPickerFragment$setupObservables$3(this), 3, null);
                    SendDestinationPickerViewModel sendDestinationPickerViewModel4 = this.viewModel;
                    if (sendDestinationPickerViewModel4 != null) {
                        Object as4 = sendDestinationPickerViewModel4.getLaunchAddressNotFoundAlertObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as4, "viewModel.launchAddressNotFoundAlertObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as4, null, null, new SendDestinationPickerFragment$setupObservables$4(this), 3, null);
                        SendDestinationPickerViewModel sendDestinationPickerViewModel5 = this.viewModel;
                        if (sendDestinationPickerViewModel5 != null) {
                            Object as5 = sendDestinationPickerViewModel5.getDestinationUpdateObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                            kotlin.jvm.internal.m.f(as5, "viewModel.destinationUpdateObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as5, new SendDestinationPickerFragment$setupObservables$5(this), null, new SendDestinationPickerFragment$setupObservables$6(this), 2, null);
                            SendDestinationPickerViewModel sendDestinationPickerViewModel6 = this.viewModel;
                            if (sendDestinationPickerViewModel6 != null) {
                                Object as6 = sendDestinationPickerViewModel6.getMetadataPlaceholderObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                                kotlin.jvm.internal.m.f(as6, "viewModel.metadataPlaceholderObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as6, new SendDestinationPickerFragment$setupObservables$7(this), null, new SendDestinationPickerFragment$setupObservables$8(this), 2, null);
                                h.c.t0.c cVar = h.c.t0.c.a;
                                h.c.s<String> distinctUntilChanged = this.searchTextObservable.distinctUntilChanged();
                                kotlin.jvm.internal.m.f(distinctUntilChanged, "searchTextObservable.distinctUntilChanged()");
                                h.c.s<String> distinctUntilChanged2 = this.metadataTextObservable.distinctUntilChanged();
                                kotlin.jvm.internal.m.f(distinctUntilChanged2, "metadataTextObservable.distinctUntilChanged()");
                                Object as7 = cVar.a(distinctUntilChanged, distinctUntilChanged2).doOnNext(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.k0
                                    @Override // h.c.m0.f
                                    public final void accept(Object obj) {
                                        SendDestinationPickerFragment.j(SendDestinationPickerFragment.this, (kotlin.o) obj);
                                    }
                                }).debounce(100L, TimeUnit.MILLISECONDS).observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getScopeProvider()));
                                kotlin.jvm.internal.m.f(as7, "Observables\n            .combineLatest(\n                searchTextObservable.distinctUntilChanged(),\n                metadataTextObservable.distinctUntilChanged()\n            )\n            .doOnNext { viewModel.userIsTyping() }\n            .debounce(100, TimeUnit.MILLISECONDS)\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(scopeProvider))");
                                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as7, null, null, new SendDestinationPickerFragment$setupObservables$10(this), 3, null);
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
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: setupObservables$lambda-3 */
    public static final void m1417setupObservables$lambda3(SendDestinationPickerFragment this$0, kotlin.o oVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this$0.viewModel;
        if (sendDestinationPickerViewModel != null) {
            sendDestinationPickerViewModel.userIsTyping();
        } else {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
    }

    @SuppressLint({"AutoDispose"})
    public final void setupQrScanner(boolean z) {
        e.j.h.a.j jVar = this.qrScannerViewModel;
        if (jVar != null) {
            h.c.s<R> flatMapSingle = jVar.a().flatMapSingle(new h.c.m0.n() { // from class: com.coinbase.wallet.features.send.views.l0
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return SendDestinationPickerFragment.k(SendDestinationPickerFragment.this, (List) obj);
                }
            });
            kotlin.jvm.internal.m.f(flatMapSingle, "qrScannerViewModel.qrScanResultObservable\n            .flatMapSingle { Singles.zip(Single.just(it), qrScannerViewModel.getWallets(it)) }");
            h.c.s observeOn = Observable_AnalyticsKt.logError$default(flatMapSingle, null, null, 3, null).subscribeOn(this.concurrentScheduler).observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "qrScannerViewModel.qrScanResultObservable\n            .flatMapSingle { Singles.zip(Single.just(it), qrScannerViewModel.getWallets(it)) }\n            .logError()\n            .subscribeOn(concurrentScheduler)\n            .observeOn(mainScheduler)");
            h.c.t0.a.a(h.c.t0.g.h(observeOn, new SendDestinationPickerFragment$setupQrScanner$2(this), null, new SendDestinationPickerFragment$setupQrScanner$3(this, z), 2, null), this.disposeBag);
            SendDestinationPickerViewModel sendDestinationPickerViewModel = this.viewModel;
            if (sendDestinationPickerViewModel != null) {
                h.c.k0.b subscribe = sendDestinationPickerViewModel.getQrScanErrorObservable().observeOn(this.mainScheduler).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.g0
                    @Override // h.c.m0.f
                    public final void accept(Object obj) {
                        SendDestinationPickerFragment.f(SendDestinationPickerFragment.this, (String) obj);
                    }
                });
                kotlin.jvm.internal.m.f(subscribe, "viewModel.qrScanErrorObservable\n            .observeOn(mainScheduler)\n            .subscribe { qrScannerViewModel.showWarning(it) }");
                h.c.t0.a.a(subscribe, this.disposeBag);
                SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.viewModel;
                if (sendDestinationPickerViewModel2 != null) {
                    h.c.k0.b subscribe2 = Observable_AnalyticsKt.logError$default(sendDestinationPickerViewModel2.getDismissScannerObservable(), null, null, 3, null).observeOn(this.mainScheduler).subscribe(new h.c.m0.f() { // from class: com.coinbase.wallet.features.send.views.i0
                        @Override // h.c.m0.f
                        public final void accept(Object obj) {
                            SendDestinationPickerFragment.h(SendDestinationPickerFragment.this, (Boolean) obj);
                        }
                    });
                    kotlin.jvm.internal.m.f(subscribe2, "viewModel.dismissScannerObservable\n            .logError()\n            .observeOn(mainScheduler)\n            .subscribe {\n                disposeBag.clear()\n                navigateUpTo(R.id.sendDestinationPickerFragment)\n            }");
                    h.c.t0.a.a(subscribe2, this.disposeBag);
                    if (z) {
                        SendDestinationPickerViewModel sendDestinationPickerViewModel3 = this.viewModel;
                        if (sendDestinationPickerViewModel3 != null) {
                            sendDestinationPickerViewModel3.presentMetadataScanner();
                            return;
                        } else {
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
                    }
                    SendDestinationPickerViewModel sendDestinationPickerViewModel4 = this.viewModel;
                    if (sendDestinationPickerViewModel4 != null) {
                        sendDestinationPickerViewModel4.presentQrScanner();
                        return;
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                }
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModel");
        throw null;
    }

    /* renamed from: setupQrScanner$lambda-10 */
    public static final void m1418setupQrScanner$lambda10(SendDestinationPickerFragment this$0, Boolean bool) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.disposeBag.d();
        e.j.f.m.k(this$0, R.id.sendDestinationPickerFragment, false, 2, null);
    }

    /* renamed from: setupQrScanner$lambda-8 */
    public static final h.c.h0 m1419setupQrScanner$lambda8(SendDestinationPickerFragment this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        h.c.t0.e eVar = h.c.t0.e.a;
        h.c.b0 just = h.c.b0.just(it);
        kotlin.jvm.internal.m.f(just, "just(it)");
        e.j.h.a.j jVar = this$0.qrScannerViewModel;
        if (jVar != null) {
            return eVar.a(just, jVar.b(it));
        }
        kotlin.jvm.internal.m.w("qrScannerViewModel");
        throw null;
    }

    /* renamed from: setupQrScanner$lambda-9 */
    public static final void m1420setupQrScanner$lambda9(SendDestinationPickerFragment this$0, String it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        e.j.h.a.j jVar = this$0.qrScannerViewModel;
        if (jVar == null) {
            kotlin.jvm.internal.m.w("qrScannerViewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(it, "it");
        jVar.g(it);
    }

    private final void setupViews() {
        int r;
        this.adapter = new SendDestinationAdapter(null, new SendDestinationPickerFragment$setupViews$1(this), 1, null);
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.recyclerView));
        SendDestinationAdapter sendDestinationAdapter = this.adapter;
        if (sendDestinationAdapter != null) {
            recyclerView.setAdapter(sendDestinationAdapter);
            View view2 = getView();
            ((RecyclerView) (view2 == null ? null : view2.findViewById(e.j.a.recyclerView))).setLayoutManager(new LinearLayoutManager(requireContext()));
            View view3 = getView();
            ((RecyclerView) (view3 == null ? null : view3.findViewById(e.j.a.recyclerView))).setVisibility(4);
            View view4 = getView();
            AppCompatEditText appCompatEditText = (AppCompatEditText) (view4 == null ? null : view4.findViewById(e.j.a.metadataField));
            SendDestinationPickerViewModel sendDestinationPickerViewModel = this.viewModel;
            if (sendDestinationPickerViewModel != null) {
                appCompatEditText.setHint(sendDestinationPickerViewModel.getMetadataPlaceholderText());
                View view5 = getView();
                MemoTypeSpinner memoTypeSpinner = (MemoTypeSpinner) (view5 == null ? null : view5.findViewById(e.j.a.memoTypePicker));
                Context requireContext = requireContext();
                List<e.j.k.a.a> memoTypes = getMemoTypes();
                r = kotlin.a0.s.r(memoTypes, 10);
                ArrayList arrayList = new ArrayList(r);
                for (e.j.k.a.a aVar : memoTypes) {
                    arrayList.add(aVar.n());
                }
                memoTypeSpinner.setAdapter((SpinnerAdapter) new ArrayAdapter(requireContext, 17367049, arrayList));
                View view6 = getView();
                ((MemoTypeSpinner) (view6 == null ? null : view6.findViewById(e.j.a.memoTypePicker))).setSelection(0, false);
                View view7 = getView();
                ((ConstraintLayout) (view7 == null ? null : view7.findViewById(e.j.a.pasteButton))).setVisibility(8);
                View view8 = getView();
                ((AppCompatEditText) (view8 == null ? null : view8.findViewById(e.j.a.searchField))).addTextChangedListener(new e.j.m.a.t.a() { // from class: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$3
                    @Override // e.j.m.a.t.a, android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        h.c.v0.b bVar;
                        View view9 = SendDestinationPickerFragment.this.getView();
                        if (!kotlin.jvm.internal.m.c(((AppCompatEditText) (view9 == null ? null : view9.findViewById(e.j.a.searchField))).getTag(R.id.TAG_NO_TRACK), Boolean.TRUE)) {
                            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationManualSearchSelected(AnalyticsEvent.Companion));
                        }
                        View view10 = SendDestinationPickerFragment.this.getView();
                        ((AppCompatEditText) (view10 != null ? view10.findViewById(e.j.a.searchField) : null)).setTag(R.id.TAG_NO_TRACK, Boolean.FALSE);
                        bVar = SendDestinationPickerFragment.this.searchTextSubject;
                        bVar.onNext(String.valueOf(charSequence));
                    }
                });
                View view9 = getView();
                ((AppCompatEditText) (view9 == null ? null : view9.findViewById(e.j.a.metadataField))).addTextChangedListener(new e.j.m.a.t.a() { // from class: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$4
                    @Override // e.j.m.a.t.a, android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                        h.c.v0.b bVar;
                        View view10 = SendDestinationPickerFragment.this.getView();
                        if (!kotlin.jvm.internal.m.c(((AppCompatEditText) (view10 == null ? null : view10.findViewById(e.j.a.metadataField))).getTag(R.id.TAG_NO_TRACK), Boolean.TRUE)) {
                            Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationManualMetadataSelected(AnalyticsEvent.Companion));
                        }
                        View view11 = SendDestinationPickerFragment.this.getView();
                        ((AppCompatEditText) (view11 != null ? view11.findViewById(e.j.a.metadataField) : null)).setTag(R.id.TAG_NO_TRACK, Boolean.FALSE);
                        bVar = SendDestinationPickerFragment.this.metadataTextSubject;
                        bVar.onNext(String.valueOf(charSequence));
                    }
                });
                View view10 = getView();
                View closeButton = view10 == null ? null : view10.findViewById(e.j.a.t0);
                kotlin.jvm.internal.m.f(closeButton, "closeButton");
                View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new SendDestinationPickerFragment$setupViews$5(this), 1, null);
                View view11 = getView();
                View scanQrButton = view11 == null ? null : view11.findViewById(e.j.a.scanQrButton);
                kotlin.jvm.internal.m.f(scanQrButton, "scanQrButton");
                View_CommonKt.setOnSingleClickListener$default(scanQrButton, 0L, new SendDestinationPickerFragment$setupViews$6(this), 1, null);
                View view12 = getView();
                View scanMetadataButton = view12 == null ? null : view12.findViewById(e.j.a.scanMetadataButton);
                kotlin.jvm.internal.m.f(scanMetadataButton, "scanMetadataButton");
                View_CommonKt.setOnSingleClickListener$default(scanMetadataButton, 0L, new SendDestinationPickerFragment$setupViews$7(this), 1, null);
                View view13 = getView();
                ((ProgressBarButton) (view13 == null ? null : view13.findViewById(e.j.a.s4))).setOnClickListener(new View.OnClickListener() { // from class: com.coinbase.wallet.features.send.views.n0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view14) {
                        SendDestinationPickerFragment.l(SendDestinationPickerFragment.this, view14);
                    }
                });
                View view14 = getView();
                ((MemoTypeSpinner) (view14 == null ? null : view14.findViewById(e.j.a.memoTypePicker))).setOnItemSelectedListener$app_productionRelease(new AdapterView.OnItemSelectedListener() { // from class: com.coinbase.wallet.features.send.views.SendDestinationPickerFragment$setupViews$9
                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onItemSelected(AdapterView<?> adapterView, View view15, int i2, long j2) {
                        List memoTypes2;
                        SendDestinationPickerViewModel sendDestinationPickerViewModel2;
                        SendDestinationPickerViewModel sendDestinationPickerViewModel3;
                        memoTypes2 = SendDestinationPickerFragment.this.getMemoTypes();
                        e.j.k.a.a aVar2 = (e.j.k.a.a) memoTypes2.get(i2);
                        View view16 = SendDestinationPickerFragment.this.getView();
                        ((AppCompatEditText) (view16 == null ? null : view16.findViewById(e.j.a.metadataField))).setHint(aVar2.n());
                        sendDestinationPickerViewModel2 = SendDestinationPickerFragment.this.viewModel;
                        if (sendDestinationPickerViewModel2 != null) {
                            sendDestinationPickerViewModel2.setSelectedMemoType(aVar2);
                            sendDestinationPickerViewModel3 = SendDestinationPickerFragment.this.viewModel;
                            if (sendDestinationPickerViewModel3 != null) {
                                sendDestinationPickerViewModel3.memoTypeButtonTapped();
                                return;
                            } else {
                                kotlin.jvm.internal.m.w("viewModel");
                                throw null;
                            }
                        }
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }

                    @Override // android.widget.AdapterView.OnItemSelectedListener
                    public void onNothingSelected(AdapterView<?> adapterView) {
                    }
                });
                View view15 = getView();
                View pasteButton = view15 != null ? view15.findViewById(e.j.a.pasteButton) : null;
                kotlin.jvm.internal.m.f(pasteButton, "pasteButton");
                View_CommonKt.setOnSingleClickListener$default(pasteButton, 0L, new SendDestinationPickerFragment$setupViews$10(this), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("adapter");
        throw null;
    }

    /* renamed from: setupViews$lambda-2 */
    public static final void m1421setupViews$lambda2(SendDestinationPickerFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view2 = this$0.getView();
        String valueOf = String.valueOf(((AppCompatEditText) (view2 == null ? null : view2.findViewById(e.j.a.searchField))).getText());
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this$0.viewModel;
        if (sendDestinationPickerViewModel != null) {
            View view3 = this$0.getView();
            ((com.uber.autodispose.a0) sendDestinationPickerViewModel.nextButtonTapped(valueOf, String.valueOf(((AppCompatEditText) (view3 != null ? view3.findViewById(e.j.a.metadataField) : null)).getText())).as(com.uber.autodispose.d.a(this$0.getScopeProvider()))).subscribe();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void showMetadataField() {
        View view = getView();
        View scanMetadataButton = view == null ? null : view.findViewById(e.j.a.scanMetadataButton);
        kotlin.jvm.internal.m.f(scanMetadataButton, "scanMetadataButton");
        scanMetadataButton.setVisibility(0);
        View view2 = getView();
        View metadataField = view2 == null ? null : view2.findViewById(e.j.a.metadataField);
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        metadataField.setVisibility(0);
        View view3 = getView();
        View memoTypePicker = view3 != null ? view3.findViewById(e.j.a.memoTypePicker) : null;
        kotlin.jvm.internal.m.f(memoTypePicker, "memoTypePicker");
        memoTypePicker.setVisibility(8);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final GenericViewModelFactory<e.j.h.a.j> getQrScannerViewModelFactory() {
        GenericViewModelFactory<e.j.h.a.j> genericViewModelFactory = this.qrScannerViewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<SendDestinationPickerViewModel> getViewModelFactory() {
        GenericViewModelFactory<SendDestinationPickerViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory()).a(SendDestinationPickerViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        SendDestinationPickerViewModel sendDestinationPickerViewModel = (SendDestinationPickerViewModel) a;
        this.viewModel = sendDestinationPickerViewModel;
        if (sendDestinationPickerViewModel != null) {
            sendDestinationPickerViewModel.setWallet(getWallet());
            SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.viewModel;
            if (sendDestinationPickerViewModel2 != null) {
                sendDestinationPickerViewModel2.setAmount(getAmount());
                Bundle arguments = getArguments();
                String string = arguments == null ? null : arguments.getString(SendDestinationPickerArgs.ADDRESS);
                Bundle arguments2 = getArguments();
                String string2 = arguments2 == null ? null : arguments2.getString(SendDestinationPickerArgs.METADATA_VALUE);
                Bundle arguments3 = getArguments();
                TxMetadataKey txMetadataKey = arguments3 == null ? null : (TxMetadataKey) arguments3.getParcelable(SendDestinationPickerArgs.STELLAR_MEMO_TYPE);
                SendDestinationPickerViewModel sendDestinationPickerViewModel3 = this.viewModel;
                if (sendDestinationPickerViewModel3 != null) {
                    sendDestinationPickerViewModel3.setPendingRecipient(new PendingRecipient(string, string2, txMetadataKey == null ? null : e.j.k.a.a.a.a(txMetadataKey)));
                    androidx.lifecycle.b0 b2 = new androidx.lifecycle.d0(requireActivity(), getQrScannerViewModelFactory()).b(SendDestinationPickerFragment.class.getName(), e.j.h.a.j.class);
                    kotlin.jvm.internal.m.f(b2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(key, T::class.java)\n}");
                    this.qrScannerViewModel = (e.j.h.a.j) b2;
                    SendDestinationPickerViewModel sendDestinationPickerViewModel4 = this.viewModel;
                    if (sendDestinationPickerViewModel4 == null) {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                    Strings strings = Strings.INSTANCE;
                    sendDestinationPickerViewModel4.search(Strings_CoreKt.getEmpty(strings), Strings_CoreKt.getEmpty(strings));
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

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_send_destination_picker, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.disposeBag.d();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Bundle arguments = getArguments();
        if (arguments != null) {
            arguments.remove(SendDestinationPickerArgs.ADDRESS);
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            arguments2.remove(SendDestinationPickerArgs.METADATA_VALUE);
        }
        Bundle arguments3 = getArguments();
        if (arguments3 == null) {
            return;
        }
        arguments3.remove(SendDestinationPickerArgs.STELLAR_MEMO_TYPE);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SendDestinationPickerViewModel sendDestinationPickerViewModel = this.viewModel;
        if (sendDestinationPickerViewModel != null) {
            sendDestinationPickerViewModel.refreshPasteboard();
            checkPendingScanResults();
            SendDestinationPickerViewModel sendDestinationPickerViewModel2 = this.viewModel;
            if (sendDestinationPickerViewModel2 == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            PendingRecipient pendingRecipient = sendDestinationPickerViewModel2.getPendingRecipient();
            if (pendingRecipient == null) {
                return;
            }
            SendDestinationPickerViewModel sendDestinationPickerViewModel3 = this.viewModel;
            if (sendDestinationPickerViewModel3 != null) {
                if (sendDestinationPickerViewModel3.isMetadataAvailable()) {
                    View view = getView();
                    View searchField = view == null ? null : view.findViewById(e.j.a.searchField);
                    kotlin.jvm.internal.m.f(searchField, "searchField");
                    setTextNoTrack((AppCompatEditText) searchField, pendingRecipient.getAddress());
                    String metadata = pendingRecipient.getMetadata();
                    e.j.k.a.a memoType = pendingRecipient.getMemoType();
                    if (metadata != null && memoType != null) {
                        SendDestinationPickerViewModel sendDestinationPickerViewModel4 = this.viewModel;
                        if (sendDestinationPickerViewModel4 != null) {
                            sendDestinationPickerViewModel4.setSelectedMemoType(memoType);
                            View view2 = getView();
                            View metadataField = view2 == null ? null : view2.findViewById(e.j.a.metadataField);
                            kotlin.jvm.internal.m.f(metadataField, "metadataField");
                            setTextNoTrack((AppCompatEditText) metadataField, metadata);
                        } else {
                            kotlin.jvm.internal.m.w("viewModel");
                            throw null;
                        }
                    } else {
                        View view3 = getView();
                        ((AppCompatEditText) (view3 == null ? null : view3.findViewById(e.j.a.metadataField))).requestFocus();
                    }
                } else if (pendingRecipient.getAddress() != null) {
                    SendDestinationPickerViewModel sendDestinationPickerViewModel5 = this.viewModel;
                    if (sendDestinationPickerViewModel5 != null) {
                        Object as = sendDestinationPickerViewModel5.confirmSendToAddress(pendingRecipient.getAddress(), null).as(com.uber.autodispose.d.a(getScopeProvider()));
                        kotlin.jvm.internal.m.f(as, "viewModel.confirmSendToAddress(pendingRecipient.address, metadata = null)\n                .`as`(autoDisposable(scopeProvider))");
                        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, SendDestinationPickerFragment$onResume$1.INSTANCE, 1, null);
                    } else {
                        kotlin.jvm.internal.m.w("viewModel");
                        throw null;
                    }
                }
                SendDestinationPickerViewModel sendDestinationPickerViewModel6 = this.viewModel;
                if (sendDestinationPickerViewModel6 != null) {
                    sendDestinationPickerViewModel6.setPendingRecipient(null);
                    return;
                } else {
                    kotlin.jvm.internal.m.w("viewModel");
                    throw null;
                }
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.sendDestinationLanded(AnalyticsEvent.Companion));
        View view2 = getView();
        View searchField = view2 == null ? null : view2.findViewById(e.j.a.searchField);
        kotlin.jvm.internal.m.f(searchField, "searchField");
        e.j.f.y.a(searchField);
        View view3 = getView();
        View metadataField = view3 != null ? view3.findViewById(e.j.a.metadataField) : null;
        kotlin.jvm.internal.m.f(metadataField, "metadataField");
        e.j.f.y.a(metadataField);
        setupViews();
        setupObservables();
    }

    public final void setQrScannerViewModelFactory(GenericViewModelFactory<e.j.h.a.j> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.qrScannerViewModelFactory = genericViewModelFactory;
    }

    public final void setViewModelFactory(GenericViewModelFactory<SendDestinationPickerViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}