package com.coinbase.wallet.features.swap.prompts;

import android.content.DialogInterface;
import android.net.Uri;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import h.c.v0.b;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import kotlin.x;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UnsupportedSwapAssetPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroid/content/DialogInterface;", "dialog", "Lkotlin/x;", "<anonymous>", "(Landroid/content/DialogInterface;)V"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UnsupportedSwapAssetPrompt$promptProperties$1$1 extends o implements l<DialogInterface, x> {
    final /* synthetic */ Aggregator $aggregator;
    final /* synthetic */ UnsupportedSwapAssetPrompt this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnsupportedSwapAssetPrompt$promptProperties$1$1(Aggregator aggregator, UnsupportedSwapAssetPrompt unsupportedSwapAssetPrompt) {
        super(1);
        this.$aggregator = aggregator;
        this.this$0 = unsupportedSwapAssetPrompt;
    }

    @Override // kotlin.e0.c.l
    public /* bridge */ /* synthetic */ x invoke(DialogInterface dialogInterface) {
        invoke2(dialogInterface);
        return x.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(DialogInterface dialog) {
        DeepLinkRepository deepLinkRepository;
        b bVar;
        m.g(dialog, "dialog");
        dialog.dismiss();
        Uri uri = new Uri.Builder().scheme(DeepLinkRepository.WALLET_SCHEME).authority(RouteActionKey.DAPP.getAction()).appendQueryParameter("url", this.$aggregator.getUrl().toString()).build();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.swapNotSupportedPromptAggregatorSelected(AnalyticsEvent.Companion, this.$aggregator.getId()));
        deepLinkRepository = this.this$0.deepLinkRepository;
        m.f(uri, "uri");
        deepLinkRepository.pushNewIntentUrl(uri);
        bVar = this.this$0.dismissSubject;
        bVar.onNext(x.a);
    }
}