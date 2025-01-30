package com.toshi.qr.view.fragment;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.lifecycle.b0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import com.appsflyer.share.Constants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.walletlink.models.WalletLinkOnboardingState;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.toshi.qr.view.custom.QROverlay;
import com.toshi.view.custom.ToolbarLayout;
import h.c.a0;
import h.c.s;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.a0.q;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.x;
import org.toshi.R;

/* compiled from: UniversalQRScannerFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001oB\u0007¢\u0006\u0004\bn\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0010H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J-\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001f\u0010 J/\u0010(\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u000e\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020$0#2\u0006\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0004H\u0016¢\u0006\u0004\b+\u0010\u0006J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0006J\u000f\u0010-\u001a\u00020\u0004H\u0016¢\u0006\u0004\b-\u0010\u0006J\u000f\u0010/\u001a\u00020.H\u0016¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u0002012\u0006\u0010\u001e\u001a\u00020\u001b2\u0006\u00102\u001a\u000201H\u0016¢\u0006\u0004\b3\u00104R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R$\u0010?\u001a\u0002092\u0006\u0010:\u001a\u0002098\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b;\u0010<\"\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bA\u0010BR\u001d\u0010G\u001a\u00020.8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u00100R\u0016\u0010K\u001a\u00020H8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u001d\u0010N\u001a\u00020$8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010E\u001a\u0004\b6\u0010MR\u0016\u0010R\u001a\u00020O8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR(\u0010Z\u001a\b\u0012\u0004\u0012\u00020@0S8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bT\u0010U\u001a\u0004\bV\u0010W\"\u0004\bX\u0010YR\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\\\u0010]R\u001e\u0010c\u001a\n `*\u0004\u0018\u00010_0_8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020O8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bd\u0010QR(\u0010i\u001a\b\u0012\u0004\u0012\u00020[0S8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\bf\u0010U\u001a\u0004\bg\u0010W\"\u0004\bh\u0010YR\u0016\u0010k\u001a\u00020O8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bj\u0010QR\u0016\u0010m\u001a\u00020.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010l¨\u0006p"}, d2 = {"Lcom/toshi/qr/view/fragment/UniversalQRScannerFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "p", "initViewModel", "initClickListeners", "initObservables", "w", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "result", "o", "(Lcom/coinbase/wallet/qr/models/QRCodeScanResult;)V", "", "results", "n", "(Ljava/util/List;)V", "u", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "onResume", "onPause", "onStart", "onStop", "", "onBackPressed", "()Z", "Lc/h/k/d0;", "insets", "applyWindowInsets", "(Landroid/view/View;Lc/h/k/d0;)Lc/h/k/d0;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "k", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isScanning", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkOnboardingState;", "value", "j", "Lcom/coinbase/wallet/features/walletlink/models/WalletLinkOnboardingState;", "v", "(Lcom/coinbase/wallet/features/walletlink/models/WalletLinkOnboardingState;)V", "walletLinkState", "Le/j/h/a/l;", "f", "Le/j/h/a/l;", "viewModel", "b", "Lkotlin/h;", "m", "showQRCodeButton", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", Constants.URL_CAMPAIGN, "()Ljava/lang/String;", "callingClass", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "e", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "viewModelFactory", "Le/j/h/a/j;", "h", "Le/j/h/a/j;", "qrScannerViewModel", "Lh/c/a0;", "kotlin.jvm.PlatformType", "d", "Lh/c/a0;", "mainScheduler", "getOnDestroyScopeProvider", "onDestroyScopeProvider", "g", "getQrScannerViewModelFactory$app_productionRelease", "setQrScannerViewModelFactory$app_productionRelease", "qrScannerViewModelFactory", "l", "onStopScopeProvider", "Z", "isTorchOn", "<init>", "a", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UniversalQRScannerFragment extends BaseFragment implements StyledFragment, BackableFragment {
    public static final a a = new a(null);

    /* renamed from: b */
    private final kotlin.h f11116b;

    /* renamed from: c */
    private final kotlin.h f11117c;

    /* renamed from: d */
    private final a0 f11118d;

    /* renamed from: e */
    public GenericViewModelFactory<e.j.h.a.l> f11119e;

    /* renamed from: f */
    private e.j.h.a.l f11120f;

    /* renamed from: g */
    public GenericViewModelFactory<e.j.h.a.j> f11121g;

    /* renamed from: h */
    private e.j.h.a.j f11122h;

    /* renamed from: j */
    private WalletLinkOnboardingState f11123j;

    /* renamed from: k */
    private AtomicBoolean f11124k;

    /* renamed from: l */
    private boolean f11125l;

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle a(boolean z, String callingClass) {
            kotlin.jvm.internal.m.g(callingClass, "callingClass");
            Bundle bundle = new Bundle();
            bundle.putBoolean("ShowQRCodeButton", z);
            bundle.putString("CallingClass", callingClass);
            return bundle;
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[WalletLinkOnboardingState.values().length];
            iArr[WalletLinkOnboardingState.Linking.ordinal()] = 1;
            iArr[WalletLinkOnboardingState.Connected.ordinal()] = 2;
            iArr[WalletLinkOnboardingState.Failure.ordinal()] = 3;
            iArr[WalletLinkOnboardingState.None.ordinal()] = 4;
            a = iArr;
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends kotlin.jvm.internal.o implements kotlin.e0.c.a<String> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c() {
            super(0);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public final String invoke() {
            return e.j.f.e.d(UniversalQRScannerFragment.this.getArguments(), "CallingClass");
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class d extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Throwable, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Throwable th) {
            invoke2(th);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Throwable it) {
            kotlin.jvm.internal.m.g(it, "it");
            UniversalQRScannerFragment.this.v(WalletLinkOnboardingState.Failure);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class e extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends WalletLinkOnboardingState>, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Optional<? extends WalletLinkOnboardingState> optional) {
            invoke2(optional);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Optional<? extends WalletLinkOnboardingState> optional) {
            WalletLinkOnboardingState nullable = optional.toNullable();
            if (nullable == null) {
                return;
            }
            UniversalQRScannerFragment.this.v(nullable);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class f extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends Wallet>, x> {

        /* renamed from: b */
        final /* synthetic */ QRCodeScanResult f11126b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(QRCodeScanResult qRCodeScanResult) {
            super(1);
            UniversalQRScannerFragment.this = r1;
            this.f11126b = qRCodeScanResult;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Optional<? extends Wallet> optional) {
            invoke2((Optional<Wallet>) optional);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(Optional<Wallet> optional) {
            List<? extends QRCodeScanResult> b2;
            if (optional.getValue() != null) {
                e.j.h.a.j jVar = UniversalQRScannerFragment.this.f11122h;
                if (jVar == null) {
                    kotlin.jvm.internal.m.w("qrScannerViewModel");
                    throw null;
                }
                b2 = q.b(this.f11126b);
                jVar.e(b2);
                return;
            }
            e.j.h.a.j jVar2 = UniversalQRScannerFragment.this.f11122h;
            if (jVar2 != null) {
                jVar2.g(LocalizedStrings.INSTANCE.get(R.string.universal_qr_coin_not_found));
            } else {
                kotlin.jvm.internal.m.w("qrScannerViewModel");
                throw null;
            }
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class g extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            View view = UniversalQRScannerFragment.this.getView();
            ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).setVisibility(4);
            Fragment_CommonKt.navigateUp(UniversalQRScannerFragment.this);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class h extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            UniversalQRScannerFragment universalQRScannerFragment = UniversalQRScannerFragment.this;
            universalQRScannerFragment.f11125l = !universalQRScannerFragment.f11125l;
            Drawable f2 = androidx.core.content.a.f(UniversalQRScannerFragment.this.requireContext(), UniversalQRScannerFragment.this.f11125l ? R.drawable.ic_noflash : R.drawable.ic_flash);
            View view = UniversalQRScannerFragment.this.getView();
            ((ImageButton) (view == null ? null : view.findViewById(e.j.a.flashButton))).setImageDrawable(f2);
            View view2 = UniversalQRScannerFragment.this.getView();
            ((BarcodeView) (view2 != null ? view2.findViewById(e.j.a.cameraView) : null)).setTorch(UniversalQRScannerFragment.this.f11125l);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class i extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            View view = UniversalQRScannerFragment.this.getView();
            ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).setVisibility(4);
            Fragment_CommonKt.navigate$default(UniversalQRScannerFragment.this, R.id.action_universalQRScannerFragment_to_receiveCoinToReceiveFragment, null, null, null, 14, null);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class j extends kotlin.jvm.internal.o implements kotlin.e0.c.l<View, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(View view) {
            invoke2(view);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(View it) {
            kotlin.jvm.internal.m.g(it, "it");
            UniversalQRScannerFragment.this.v(WalletLinkOnboardingState.None);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class k extends kotlin.jvm.internal.o implements kotlin.e0.c.l<x, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(x xVar) {
            invoke2(xVar);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(x xVar) {
            View view = UniversalQRScannerFragment.this.getView();
            ((QROverlay) (view == null ? null : view.findViewById(e.j.a.overlay))).m();
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class l extends kotlin.jvm.internal.o implements kotlin.e0.c.l<ViewModelNavRoute, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        l() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(ViewModelNavRoute viewModelNavRoute) {
            invoke2(viewModelNavRoute);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(ViewModelNavRoute viewModelNavRoute) {
            Fragment_CommonKt.navigate$default(UniversalQRScannerFragment.this, viewModelNavRoute.getResourceId(), viewModelNavRoute.getArgs(), null, null, 12, null);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    static final class m extends kotlin.jvm.internal.o implements kotlin.e0.c.a<Boolean> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m() {
            super(0);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.a
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return Boolean.valueOf(invoke2());
        }

        /* renamed from: invoke */
        public final boolean invoke2() {
            return e.j.f.e.a(UniversalQRScannerFragment.this.getArguments(), "ShowQRCodeButton");
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class n implements com.journeyapps.barcodescanner.a {
        n() {
            UniversalQRScannerFragment.this = r1;
        }

        @Override // com.journeyapps.barcodescanner.a
        public void a(List<com.google.zxing.m> list) {
        }

        @Override // com.journeyapps.barcodescanner.a
        public void b(com.journeyapps.barcodescanner.b bVar) {
            if (bVar == null) {
                return;
            }
            e.j.h.a.l lVar = UniversalQRScannerFragment.this.f11120f;
            if (lVar == null) {
                kotlin.jvm.internal.m.w("viewModel");
                throw null;
            }
            String text = bVar.e();
            kotlin.jvm.internal.m.f(text, "text");
            lVar.p(text);
        }
    }

    /* compiled from: UniversalQRScannerFragment.kt */
    /* loaded from: classes2.dex */
    public static final class o extends kotlin.jvm.internal.o implements kotlin.e0.c.l<List<? extends QRCodeScanResult>, x> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o() {
            super(1);
            UniversalQRScannerFragment.this = r1;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(List<? extends QRCodeScanResult> list) {
            invoke2(list);
            return x.a;
        }

        /* renamed from: invoke */
        public final void invoke2(List<? extends QRCodeScanResult> results) {
            int size = results.size();
            if (size == 0) {
                e.j.h.a.j jVar = UniversalQRScannerFragment.this.f11122h;
                if (jVar == null) {
                    kotlin.jvm.internal.m.w("qrScannerViewModel");
                    throw null;
                }
                String string = UniversalQRScannerFragment.this.getString(R.string.universal_qr_warning);
                kotlin.jvm.internal.m.f(string, "getString(R.string.universal_qr_warning)");
                jVar.g(string);
            } else if (size != 1) {
                UniversalQRScannerFragment universalQRScannerFragment = UniversalQRScannerFragment.this;
                kotlin.jvm.internal.m.f(results, "results");
                universalQRScannerFragment.n(results);
            } else {
                UniversalQRScannerFragment universalQRScannerFragment2 = UniversalQRScannerFragment.this;
                kotlin.jvm.internal.m.f(results, "results");
                universalQRScannerFragment2.o((QRCodeScanResult) p.Y(results));
            }
        }
    }

    public UniversalQRScannerFragment() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(new m());
        this.f11116b = b2;
        b3 = kotlin.k.b(new c());
        this.f11117c = b3;
        this.f11118d = h.c.j0.c.a.b();
        this.f11123j = WalletLinkOnboardingState.None;
        this.f11124k = new AtomicBoolean(false);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    private final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final void init() {
        View view = getView();
        View showQrButton = view == null ? null : view.findViewById(e.j.a.showQrButton);
        kotlin.jvm.internal.m.f(showQrButton, "showQrButton");
        showQrButton.setVisibility(m() ? 0 : 8);
        p();
        initViewModel();
        initClickListeners();
        initObservables();
        w();
    }

    private final void initClickListeners() {
        View view = getView();
        View closeButton = view == null ? null : view.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new g(), 1, null);
        View view2 = getView();
        View flashButton = view2 == null ? null : view2.findViewById(e.j.a.flashButton);
        kotlin.jvm.internal.m.f(flashButton, "flashButton");
        View_CommonKt.setOnSingleClickListener$default(flashButton, 0L, new h(), 1, null);
        View view3 = getView();
        View showQrButton = view3 == null ? null : view3.findViewById(e.j.a.showQrButton);
        kotlin.jvm.internal.m.f(showQrButton, "showQrButton");
        View_CommonKt.setOnSingleClickListener$default(showQrButton, 0L, new i(), 1, null);
        View view4 = getView();
        View tryAgainButton = view4 != null ? view4.findViewById(e.j.a.tryAgainButton) : null;
        kotlin.jvm.internal.m.f(tryAgainButton, "tryAgainButton");
        View_CommonKt.setOnSingleClickListener$default(tryAgainButton, 0L, new j(), 1, null);
    }

    private final void initObservables() {
        e.j.h.a.j jVar = this.f11122h;
        if (jVar != null) {
            s logError$default = Observable_AnalyticsKt.logError$default(jVar.d(), null, null, 3, null);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            Object as = logError$default.throttleFirst(1L, timeUnit).observeOn(this.f11118d).map(new h.c.m0.n() { // from class: com.toshi.qr.view.fragment.a
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return UniversalQRScannerFragment.r(UniversalQRScannerFragment.this, (Optional) obj);
                }
            }).delay(1L, timeUnit).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "qrScannerViewModel.warningObservable\n            .logError()\n            .throttleFirst(1, TimeUnit.SECONDS)\n            .observeOn(mainScheduler)\n            .map { overlay.showWarning(it.value) }\n            .delay(1, TimeUnit.SECONDS)\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new k(), 3, null);
            e.j.h.a.l lVar = this.f11120f;
            if (lVar != null) {
                Object as2 = Observable_AnalyticsKt.logError$default(lVar.getNavigationObservable(), null, null, 3, null).observeOn(this.f11118d).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.navigationObservable\n            .logError()\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new l(), 3, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModel");
        throw null;
    }

    private final void initViewModel() {
        b0 b2;
        b0 a2 = new d0(this, getViewModelFactory$app_productionRelease()).a(e.j.h.a.l.class);
        kotlin.jvm.internal.m.f(a2, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.f11120f = (e.j.h.a.l) a2;
        GenericViewModelFactory<e.j.h.a.j> qrScannerViewModelFactory$app_productionRelease = getQrScannerViewModelFactory$app_productionRelease();
        String k2 = k();
        if (k2 == null) {
            b2 = new d0(requireActivity(), qrScannerViewModelFactory$app_productionRelease).a(e.j.h.a.j.class);
            kotlin.jvm.internal.m.f(b2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(T::class.java)\n}");
        } else {
            b2 = new d0(requireActivity(), qrScannerViewModelFactory$app_productionRelease).b(k2, e.j.h.a.j.class);
            kotlin.jvm.internal.m.f(b2, "{\n    ViewModelProvider(requireActivity(), viewModelFactory).get(key, T::class.java)\n}");
        }
        this.f11122h = (e.j.h.a.j) b2;
    }

    private final String k() {
        return (String) this.f11117c.getValue();
    }

    private final FragmentLifecycleScopeProvider l() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_STOP);
    }

    private final boolean m() {
        return ((Boolean) this.f11116b.getValue()).booleanValue();
    }

    public final void n(List<? extends QRCodeScanResult> list) {
        if (list.isEmpty()) {
            return;
        }
        e.j.h.a.j jVar = this.f11122h;
        if (jVar != null) {
            jVar.e(list);
        } else {
            kotlin.jvm.internal.m.w("qrScannerViewModel");
            throw null;
        }
    }

    public final void o(QRCodeScanResult qRCodeScanResult) {
        List<? extends QRCodeScanResult> b2;
        if (qRCodeScanResult instanceof QRCodeScanResult.WalletLink) {
            WalletLinkOnboardingState walletLinkOnboardingState = this.f11123j;
            WalletLinkOnboardingState walletLinkOnboardingState2 = WalletLinkOnboardingState.Linking;
            if (walletLinkOnboardingState == walletLinkOnboardingState2) {
                return;
            }
            v(walletLinkOnboardingState2);
            e.j.h.a.l lVar = this.f11120f;
            if (lVar != null) {
                Object as = Single_AnalyticsKt.logError$default(lVar.b((QRCodeScanResult.WalletLink) qRCodeScanResult), null, null, 3, null).observeOn(this.f11118d).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as, "viewModel.connect(result)\n                    .logError()\n                    .observeOn(mainScheduler)\n                    .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new d(), new e());
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else if (qRCodeScanResult instanceof QRCodeScanResult.ERC20) {
            String contractAddress = ((QRCodeScanResult.ERC20) qRCodeScanResult).getContractAddress();
            if (contractAddress == null) {
                return;
            }
            e.j.h.a.l lVar2 = this.f11120f;
            if (lVar2 != null) {
                Object as2 = Single_AnalyticsKt.logError$default(lVar2.d(contractAddress), null, null, 3, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
                kotlin.jvm.internal.m.f(as2, "viewModel.getErc20Wallet(contractAddress)\n                        .logError()\n                        .`as`(autoDisposable(onDestroyScopeProvider))");
                SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as2, null, new f(qRCodeScanResult), 1, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        } else {
            e.j.h.a.j jVar = this.f11122h;
            if (jVar == null) {
                kotlin.jvm.internal.m.w("qrScannerViewModel");
                throw null;
            }
            b2 = q.b(qRCodeScanResult);
            jVar.e(b2);
        }
    }

    private final void p() {
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).setDecoderFactory(new com.journeyapps.barcodescanner.i(null, null, null, 2));
        View view2 = getView();
        ((BarcodeView) (view2 == null ? null : view2.findViewById(e.j.a.cameraView))).setVisibility(0);
        View view3 = getView();
        ((BarcodeView) (view3 != null ? view3.findViewById(e.j.a.cameraView) : null)).startAnimation(AnimationUtils.loadAnimation(requireContext(), 17432576));
        if (androidx.core.content.a.a(requireContext(), "android.permission.CAMERA") != 0) {
            requestPermissions(new String[]{"android.permission.CAMERA"}, 10000);
        }
    }

    public static final x q(UniversalQRScannerFragment this$0, Optional it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        View view = this$0.getView();
        ((QROverlay) (view == null ? null : view.findViewById(e.j.a.overlay))).o((String) it.getValue());
        return x.a;
    }

    public static /* synthetic */ x r(UniversalQRScannerFragment universalQRScannerFragment, Optional optional) {
        return q(universalQRScannerFragment, optional);
    }

    public static /* synthetic */ void s(UniversalQRScannerFragment universalQRScannerFragment) {
        x(universalQRScannerFragment);
    }

    public static /* synthetic */ boolean t(UniversalQRScannerFragment universalQRScannerFragment, List list) {
        return y(universalQRScannerFragment, list);
    }

    private final void u() {
        int i2 = b.a[this.f11123j.ordinal()];
        if (i2 == 1) {
            View view = getView();
            ((QROverlay) (view == null ? null : view.findViewById(e.j.a.overlay))).setVisibility(4);
            View view2 = getView();
            ((Button) (view2 == null ? null : view2.findViewById(e.j.a.showQrButton))).setVisibility(4);
            View view3 = getView();
            ((ToolbarLayout) (view3 == null ? null : view3.findViewById(e.j.a.T6))).setVisibility(4);
            View view4 = getView();
            (view4 == null ? null : view4.findViewById(e.j.a.resultOverlay)).setVisibility(0);
            View view5 = getView();
            ((ProgressBar) (view5 != null ? view5.findViewById(e.j.a.E3) : null)).setVisibility(0);
        } else if (i2 == 2) {
            Fragment_CommonKt.navigateUp(this);
        } else if (i2 == 3) {
            View view6 = getView();
            ((ProgressBar) (view6 == null ? null : view6.findViewById(e.j.a.E3))).setVisibility(4);
            View view7 = getView();
            TextView textView = (TextView) (view7 == null ? null : view7.findViewById(e.j.a.infoTitle));
            textView.setVisibility(0);
            textView.setText(R.string.link_failed);
            View view8 = getView();
            TextView textView2 = (TextView) (view8 == null ? null : view8.findViewById(e.j.a.infoMessage));
            textView2.setVisibility(0);
            textView2.setText(R.string.wallet_link_failed_message);
            View view9 = getView();
            ((Button) (view9 != null ? view9.findViewById(e.j.a.tryAgainButton) : null)).setVisibility(0);
        } else if (i2 != 4) {
        } else {
            View view10 = getView();
            ((QROverlay) (view10 == null ? null : view10.findViewById(e.j.a.overlay))).setVisibility(0);
            View view11 = getView();
            ((Button) (view11 == null ? null : view11.findViewById(e.j.a.showQrButton))).setVisibility(0);
            View view12 = getView();
            ((ToolbarLayout) (view12 == null ? null : view12.findViewById(e.j.a.T6))).setVisibility(0);
            View view13 = getView();
            (view13 == null ? null : view13.findViewById(e.j.a.resultOverlay)).setVisibility(4);
            View view14 = getView();
            ((ProgressBar) (view14 == null ? null : view14.findViewById(e.j.a.E3))).setVisibility(4);
            View view15 = getView();
            ((TextView) (view15 == null ? null : view15.findViewById(e.j.a.infoTitle))).setVisibility(4);
            View view16 = getView();
            ((TextView) (view16 == null ? null : view16.findViewById(e.j.a.infoMessage))).setVisibility(4);
            View view17 = getView();
            ((Button) (view17 != null ? view17.findViewById(e.j.a.tryAgainButton) : null)).setVisibility(4);
            w();
        }
    }

    public final void v(WalletLinkOnboardingState walletLinkOnboardingState) {
        this.f11123j = walletLinkOnboardingState;
        u();
    }

    private final void w() {
        requireView().post(new Runnable() { // from class: com.toshi.qr.view.fragment.b
            @Override // java.lang.Runnable
            public final void run() {
                UniversalQRScannerFragment.s(UniversalQRScannerFragment.this);
            }
        });
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).I(new n());
        e.j.h.a.l lVar = this.f11120f;
        if (lVar != null) {
            Object as = Observable_AnalyticsKt.logError$default(lVar.g(), null, null, 3, null).filter(new h.c.m0.p() { // from class: com.toshi.qr.view.fragment.c
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return UniversalQRScannerFragment.t(UniversalQRScannerFragment.this, (List) obj);
                }
            }).observeOn(this.f11118d).as(com.uber.autodispose.d.a(l()));
            kotlin.jvm.internal.m.f(as, "viewModel.qrResultsObservable\n            .logError()\n            .filter { isScanning.get() }\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(onStopScopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new o(), 3, null);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    public static final void x(UniversalQRScannerFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).setFramingRectSize(new com.journeyapps.barcodescanner.n(this$0.requireView().getWidth(), this$0.requireView().getHeight()));
    }

    public static final boolean y(UniversalQRScannerFragment this$0, List it) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(it, "it");
        return this$0.f11124k.get();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 insets) {
        kotlin.jvm.internal.m.g(view, "view");
        kotlin.jvm.internal.m.g(insets, "insets");
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.showQrButton))).setTranslationY(-insets.i());
        return insets;
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.DefaultImpls.getAttributes(this).copy(true, true, true);
    }

    public final GenericViewModelFactory<e.j.h.a.j> getQrScannerViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<e.j.h.a.j> genericViewModelFactory = this.f11121g;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("qrScannerViewModelFactory");
        throw null;
    }

    public final GenericViewModelFactory<e.j.h.a.l> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<e.j.h.a.l> genericViewModelFactory = this.f11119e;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).setVisibility(4);
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_universal_qr_scanner, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        this.f11124k.set(false);
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).u();
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i2, String[] permissions, int[] grantResults) {
        int x;
        kotlin.jvm.internal.m.g(permissions, "permissions");
        kotlin.jvm.internal.m.g(grantResults, "grantResults");
        super.onRequestPermissionsResult(i2, permissions, grantResults);
        if (i2 == 10000) {
            if ((!(permissions.length == 0)) && kotlin.jvm.internal.m.c(kotlin.a0.j.y(permissions), "android.permission.CAMERA")) {
                x = kotlin.a0.n.x(grantResults);
                if (x == 0) {
                    View view = getView();
                    ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).y();
                    return;
                }
                return;
            }
            return;
        }
        l.a.a.a("Unrecognized permissions:\nRequest code:" + i2 + ",\nPermissions:" + permissions, new Object[0]);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).y();
        this.f11124k.set(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        View view = getView();
        ((BarcodeView) (view == null ? null : view.findViewById(e.j.a.cameraView))).N();
        super.onStop();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }
}