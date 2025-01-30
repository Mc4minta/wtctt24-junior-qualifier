package com.coinbase.wallet.application;

import android.net.Uri;
import com.coinbase.wallet.application.model.MainTab;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.swap.models.SwapInterstitialFragmentArgs;
import com.coinbase.wallet.routing.models.DappDeepLinkDestination;
import com.coinbase.wallet.routing.models.DeeplinkDestination;
import com.coinbase.wallet.routing.models.NavDeepLinkDestination;
import com.coinbase.wallet.routing.models.SwapDeepLinkDestination;
import com.coinbase.wallet.routing.viewmodels.DeepLinkViewModel;
import com.uber.autodispose.a0;
import h.c.b0;
import kotlin.Metadata;
import kotlin.x;
import org.toshi.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Landroid/net/Uri;", "kotlin.jvm.PlatformType", "uri", "Lkotlin/x;", "<anonymous>", "(Landroid/net/Uri;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class MainActivity$unlockAppSession$1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Uri, x> {
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MainActivity.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/coinbase/wallet/core/util/Optional;", "Lcom/coinbase/wallet/routing/models/DeeplinkDestination;", "kotlin.jvm.PlatformType", "destinationOptional", "Lkotlin/x;", "<anonymous>", "(Lcom/coinbase/wallet/core/util/Optional;)V"}, k = 3, mv = {1, 5, 1})
    /* renamed from: com.coinbase.wallet.application.MainActivity$unlockAppSession$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static final class AnonymousClass1 extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Optional<? extends DeeplinkDestination>, x> {
        final /* synthetic */ MainActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MainActivity mainActivity) {
            super(1);
            this.this$0 = mainActivity;
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ x invoke(Optional<? extends DeeplinkDestination> optional) {
            invoke2(optional);
            return x.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(Optional<? extends DeeplinkDestination> optional) {
            DeeplinkDestination nullable = optional.toNullable();
            if (nullable == null) {
                return;
            }
            if (nullable instanceof NavDeepLinkDestination) {
                NavDeepLinkDestination navDeepLinkDestination = (NavDeepLinkDestination) nullable;
                MainActivity.switchToTabAndNavigate$default(this.this$0, MainTab.WALLET, navDeepLinkDestination.getDestinationResId(), navDeepLinkDestination.getArgs(), null, 8, null);
            } else if (nullable instanceof DappDeepLinkDestination) {
                this.this$0.switchToDappBrowser(((DappDeepLinkDestination) nullable).getUrl());
            } else if (nullable instanceof SwapDeepLinkDestination) {
                MainActivity.switchToTabAndNavigate$default(this.this$0, MainTab.WALLET, R.id.swapInterstitialFragment, SwapInterstitialFragmentArgs.createArguments$default(SwapInterstitialFragmentArgs.INSTANCE, false, null, ((SwapDeepLinkDestination) nullable).getTargetAsset(), 2, null), null, 8, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$unlockAppSession$1(MainActivity mainActivity) {
        super(1);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(Uri uri) {
        invoke2(uri);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(Uri uri) {
        DeepLinkViewModel deepLinkViewModel;
        com.uber.autodispose.android.lifecycle.b scopeProvider;
        this.this$0.getIntent().setData(null);
        deepLinkViewModel = this.this$0.deepLinkViewModel;
        if (deepLinkViewModel != null) {
            kotlin.jvm.internal.m.f(uri, "uri");
            b0<Optional<DeeplinkDestination>> observeOn = deepLinkViewModel.route(uri).observeOn(h.c.j0.c.a.b());
            scopeProvider = this.this$0.getScopeProvider();
            Object as = observeOn.as(com.uber.autodispose.d.a(scopeProvider));
            kotlin.jvm.internal.m.f(as, "deepLinkViewModel.route(uri)\n                        .observeOn(AndroidSchedulers.mainThread())\n                        .`as`(autoDisposable(scopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy$default((a0) as, null, new AnonymousClass1(this.this$0), 1, null);
            return;
        }
        kotlin.jvm.internal.m.w("deepLinkViewModel");
        throw null;
    }
}