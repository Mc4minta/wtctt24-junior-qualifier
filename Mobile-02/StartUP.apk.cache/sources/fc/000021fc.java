package com.coinbase.wallet.features.swap.prompts;

import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.swap.models.Aggregator;
import h.c.s;
import h.c.v0.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: UnsupportedSwapAssetPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\t0\t0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/swap/prompts/UnsupportedSwapAssetPrompt;", "", "", "Lcom/coinbase/wallet/swap/models/Aggregator;", "aggregatorList", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptProperties", "(Ljava/util/List;)Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "Lh/c/s;", "Lkotlin/x;", "dismissObservable", "Lh/c/s;", "getDismissObservable", "()Lh/c/s;", "Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "deepLinkRepository", "Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;", "Lh/c/v0/b;", "kotlin.jvm.PlatformType", "dismissSubject", "Lh/c/v0/b;", "<init>", "(Lcom/coinbase/wallet/routing/repositories/DeepLinkRepository;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UnsupportedSwapAssetPrompt {
    private final DeepLinkRepository deepLinkRepository;
    private final s<x> dismissObservable;
    private final b<x> dismissSubject;

    public UnsupportedSwapAssetPrompt(DeepLinkRepository deepLinkRepository) {
        m.g(deepLinkRepository, "deepLinkRepository");
        this.deepLinkRepository = deepLinkRepository;
        b<x> d2 = b.d();
        m.f(d2, "create<Unit>()");
        this.dismissSubject = d2;
        s<x> hide = d2.hide();
        m.f(hide, "dismissSubject.hide()");
        this.dismissObservable = hide;
    }

    public final s<x> getDismissObservable() {
        return this.dismissObservable;
    }

    public final PromptDialogHelper.Properties promptProperties(List<Aggregator> aggregatorList) {
        int r;
        m.g(aggregatorList, "aggregatorList");
        LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
        String str = localizedStrings.get(R.string.swap_unsupported_token_prompt_title);
        String str2 = localizedStrings.get(R.string.swap_unsupported_token_prompt_body);
        String str3 = localizedStrings.get(R.string.swap_unsupported_token_prompt_warning);
        r = kotlin.a0.s.r(aggregatorList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (Aggregator aggregator : aggregatorList) {
            arrayList.add(new PromptDialogHelper.Action(aggregator.getName(), ActionStyle.NEUTRAL_RAISED, new UnsupportedSwapAssetPrompt$promptProperties$1$1(aggregator, this)));
        }
        return new PromptDialogHelper.Properties(null, str, str2, str3, Integer.valueOf((int) R.drawable.illustration_crypto_unsupported), arrayList, Integer.valueOf((int) R.style.DialogFadeScaleAnimation), false, null, null, UnsupportedSwapAssetPrompt$promptProperties$2.INSTANCE, null, null, false, 15233, null);
    }
}