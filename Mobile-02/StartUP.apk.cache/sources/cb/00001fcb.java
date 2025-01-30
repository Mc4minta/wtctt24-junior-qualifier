package com.coinbase.wallet.features.send.prompts;

import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.features.send.extensions.StoreKeys_SendKt;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.store.models.StoreKeys;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: HighMinerFeesPrompt.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/features/send/prompts/HighMinerFeesPrompt;", "", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "feeWallet", "Ljava/math/BigInteger;", "gasPrice", "Ljava/math/BigDecimal;", "ethUSDExchangeRate", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "promptProperties", "(Lcom/coinbase/wallet/blockchains/models/Wallet;Ljava/math/BigInteger;Ljava/math/BigDecimal;)Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", Payload.TYPE_STORE, "Lcom/coinbase/wallet/store/interfaces/StoreInterface;", "", "value", "getShouldShowAutoMinerFeePrompt", "()Z", "setShouldShowAutoMinerFeePrompt", "(Z)V", "shouldShowAutoMinerFeePrompt", "<init>", "(Lcom/coinbase/wallet/store/interfaces/StoreInterface;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HighMinerFeesPrompt {
    private final StoreInterface store;

    public HighMinerFeesPrompt(StoreInterface store) {
        m.g(store, "store");
        this.store = store;
    }

    private final boolean getShouldShowAutoMinerFeePrompt() {
        Boolean bool = (Boolean) this.store.get(StoreKeys_SendKt.getShouldShowAutoMinerFeePrompt(StoreKeys.INSTANCE));
        if (bool == null) {
            return true;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setShouldShowAutoMinerFeePrompt(boolean z) {
        this.store.set(StoreKeys_SendKt.getShouldShowAutoMinerFeePrompt(StoreKeys.INSTANCE), Boolean.valueOf(z));
    }

    public final PromptDialogHelper.Properties promptProperties(Wallet feeWallet, BigInteger gasPrice, BigDecimal ethUSDExchangeRate) {
        List j2;
        m.g(feeWallet, "feeWallet");
        m.g(gasPrice, "gasPrice");
        m.g(ethUSDExchangeRate, "ethUSDExchangeRate");
        boolean z = Network_EthereumKt.getAsEthereumChain(feeWallet.getNetwork()) == EthereumChain.ETHEREUM_MAINNET;
        if (m.c(feeWallet.getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && z && getShouldShowAutoMinerFeePrompt()) {
            BigInteger multiply = gasPrice.multiply(new BigInteger("21000"));
            m.f(multiply, "this.multiply(other)");
            BigDecimal minFee = new BigDecimal(multiply).movePointLeft(feeWallet.getDecimals());
            m.f(minFee, "minFee");
            BigDecimal multiply2 = ethUSDExchangeRate.multiply(minFee);
            m.f(multiply2, "this.multiply(other)");
            if (multiply2.compareTo(BigDecimal.ONE) <= 0) {
                return null;
            }
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            j2 = r.j(new PromptDialogHelper.Action(localizedStrings.get(R.string.ok), ActionStyle.POSITIVE, HighMinerFeesPrompt$promptProperties$actions$1.INSTANCE), new PromptDialogHelper.Action(localizedStrings.get(R.string.dont_show_again), ActionStyle.NEGATIVE, new HighMinerFeesPrompt$promptProperties$actions$2(this)));
            return new PromptDialogHelper.Properties(null, localizedStrings.get(R.string.prompt_high_fees_title), localizedStrings.get(R.string.prompt_high_fees_message), null, Integer.valueOf((int) R.drawable.illustration_no_eth), j2, null, false, null, null, HighMinerFeesPrompt$promptProperties$1.INSTANCE, null, null, false, 15305, null);
        }
        return null;
    }
}