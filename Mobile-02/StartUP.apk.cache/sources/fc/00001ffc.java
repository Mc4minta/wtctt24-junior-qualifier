package com.coinbase.wallet.features.send.viewmodels;

import com.coinbase.ciphercore.ethereum.EthereumChain;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.models.ActionStyle;
import com.coinbase.wallet.commonui.models.ViewModelNavRoute;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import com.coinbase.wallet.commonui.viewmodels.ViewModelWithArgs;
import com.coinbase.wallet.ethereum.extensions.Blockchain_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.Network_EthereumKt;
import com.coinbase.wallet.ethereum.extensions.WalletConfiguration_EthereumKt;
import com.coinbase.wallet.ethereum.models.EthereumBasedConfiguration;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeSelection;
import com.coinbase.wallet.features.send.models.ConfirmationSettings;
import com.coinbase.wallet.features.send.models.SendAmounts;
import com.coinbase.wallet.features.send.models.SendConfirmationResult;
import com.coinbase.wallet.features.wallets.extensions.legacy.Wallet_Erc20Kt;
import java.util.List;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: ConfirmationViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0004¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0018\u001a\u00020\u00052\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\fH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\fH&¢\u0006\u0004\b\u001e\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010 R\u001c\u0010'\u001a\b\u0012\u0004\u0012\u00020%0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010 R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0(8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010 R\u001c\u00101\u001a\b\u0012\u0004\u0012\u00020/0\u00138&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b0\u0010\u0016R\u0018\u00104\u001a\u0004\u0018\u00010\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001c\u00108\u001a\b\u0012\u0004\u0012\u00020%058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u000f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u00103R\u001c\u0010@\u001a\b\u0012\u0004\u0012\u00020\"058$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b?\u00107R\u0016\u0010D\u001a\u00020A8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bB\u0010CR\u001c\u0010F\u001a\b\u0012\u0004\u0012\u00020%0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010 R\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010 R\u0016\u0010L\u001a\u00020I8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010N\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010 ¨\u0006P"}, d2 = {"Lcom/coinbase/wallet/features/send/viewmodels/ConfirmationViewModel;", "Lcom/coinbase/wallet/commonui/viewmodels/ViewModelWithArgs;", "Lh/c/s;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;", "minerFeeSelectionObservable", "Lkotlin/x;", "setup", "(Lh/c/s;)V", "presentMinerFee", "()V", "updateMinerFeeExplainer", "adjustableMinerFeeClicked", "", "isAdjustableMinerFeeEnabled", "()Z", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "confirmTx", "(Ljava/lang/String;)V", "Lh/c/b0;", "Lcom/coinbase/wallet/authentication/AuthenticationResult;", "unlock", "()Lh/c/b0;", "adjustableMinerFeeSelection", "fetchReceiptInformation", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeSelection;)V", "expanded", "", "detailsTextColor", "(Z)I", "detailsContainerColor", "getExpandCardObservable", "()Lh/c/s;", "expandCardObservable", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "getPromptObservable", "promptObservable", "Lcom/coinbase/wallet/commonui/models/ViewModelNavRoute;", "getNavigateToSendCompleteViewObservable", "navigateToSendCompleteViewObservable", "Lh/c/v0/a;", "getMinerFeeExplainerSubject", "()Lh/c/v0/a;", "minerFeeExplainerSubject", "Lcom/coinbase/wallet/features/send/models/SendConfirmationResult;", "getSendConfirmationObservable", "sendConfirmationObservable", "Lcom/coinbase/wallet/features/send/models/SendAmounts;", "getSendAmounts", "sendAmounts", "getRecipientSubtitle", "()Ljava/lang/String;", "recipientSubtitle", "Lh/c/v0/b;", "getNavigationSubject", "()Lh/c/v0/b;", "navigationSubject", "Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "getSettings", "()Lcom/coinbase/wallet/features/send/models/ConfirmationSettings;", "settings", "getRecipientTitle", "recipientTitle", "getPromptSubject", "promptSubject", "Lcom/coinbase/wallet/blockchains/models/Wallet;", "getWallet", "()Lcom/coinbase/wallet/blockchains/models/Wallet;", "wallet", "getNavigationObservable", "navigationObservable", "getAnnualInterestObservable", "annualInterestObservable", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "getMinerFeeExplainerObservable", "minerFeeExplainerObservable", "<init>", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConfirmationViewModel extends ViewModelWithArgs {
    public static /* synthetic */ void fetchReceiptInformation$default(ConfirmationViewModel confirmationViewModel, AdjustableMinerFeeSelection adjustableMinerFeeSelection, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: fetchReceiptInformation");
        }
        if ((i2 & 1) != 0) {
            adjustableMinerFeeSelection = null;
        }
        confirmationViewModel.fetchReceiptInformation(adjustableMinerFeeSelection);
    }

    public abstract void adjustableMinerFeeClicked();

    public abstract void confirmTx(String str);

    public abstract int detailsContainerColor(boolean z);

    public abstract int detailsTextColor(boolean z);

    public abstract void fetchReceiptInformation(AdjustableMinerFeeSelection adjustableMinerFeeSelection);

    public abstract h.c.s<String> getAnnualInterestObservable();

    protected abstract AuthenticationHelper getAuthenticationHelper();

    public abstract h.c.s<Boolean> getExpandCardObservable();

    public abstract h.c.s<String> getMinerFeeExplainerObservable();

    protected abstract h.c.v0.a<String> getMinerFeeExplainerSubject();

    public abstract h.c.s<ViewModelNavRoute> getNavigateToSendCompleteViewObservable();

    public abstract h.c.s<ViewModelNavRoute> getNavigationObservable();

    protected abstract h.c.v0.b<ViewModelNavRoute> getNavigationSubject();

    public abstract h.c.s<PromptDialogHelper.Properties> getPromptObservable();

    protected abstract h.c.v0.b<PromptDialogHelper.Properties> getPromptSubject();

    public abstract String getRecipientSubtitle();

    public abstract String getRecipientTitle();

    public abstract h.c.b0<SendAmounts> getSendAmounts();

    public abstract h.c.s<SendConfirmationResult> getSendConfirmationObservable();

    public abstract ConfirmationSettings getSettings();

    protected abstract Wallet getWallet();

    public abstract boolean isAdjustableMinerFeeEnabled();

    public final void presentMinerFee() {
        String str;
        int i2;
        List b2;
        String rawValue = getWallet().getCurrencyCode().getRawValue();
        if (Wallet_Erc20Kt.isErc20(getWallet())) {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_erc20_description, rawValue);
            i2 = R.drawable.illustration_no_eth;
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.send_miner_fee_description, getWallet().getDisplayName());
            i2 = R.drawable.illustration_dollar_arrows;
        }
        EthereumChain asEthereumChain = Network_EthereumKt.getAsEthereumChain(getWallet().getNetwork());
        if (asEthereumChain != null && asEthereumChain.is1559Enabled()) {
            LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
            str = localizedStrings.get(R.string.combine, str, localizedStrings.get(R.string.miner_fee_1559_postfix));
        }
        String str2 = str;
        LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
        PromptDialogHelper.Action action = new PromptDialogHelper.Action(localizedStrings2.get(R.string.send_confirmation_miner_dialog_button), ActionStyle.POSITIVE, ConfirmationViewModel$presentMinerFee$action$1.INSTANCE);
        String str3 = localizedStrings2.get(R.string.send_confirmation_miner_fee_dialog_title);
        b2 = kotlin.a0.q.b(action);
        getPromptSubject().onNext(new PromptDialogHelper.Properties(null, str3, str2, null, Integer.valueOf(i2), b2, null, true, null, null, ConfirmationViewModel$presentMinerFee$properties$1.INSTANCE, null, null, false, 15177, null));
    }

    public abstract void setup(h.c.s<AdjustableMinerFeeSelection> sVar);

    public final h.c.b0<AuthenticationResult> unlock() {
        return getAuthenticationHelper().unlock(AppLockType.Transactions.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void updateMinerFeeExplainer() {
        String str;
        CurrencyCode currencyCodeForNetwork = WalletConfiguration_EthereumKt.getETH(EthereumBasedConfiguration.Companion).currencyCodeForNetwork(getWallet().getNetwork());
        if (kotlin.jvm.internal.m.c(getWallet().getBlockchain(), Blockchain_EthereumKt.getETHEREUM(Blockchain.Companion)) && !kotlin.jvm.internal.m.c(getWallet().getCurrencyCode(), currencyCodeForNetwork)) {
            str = LocalizedStrings.INSTANCE.get(R.string.send_confirm_fee_eth_explainer, currencyCodeForNetwork.getCode());
        } else {
            str = LocalizedStrings.INSTANCE.get(R.string.send_confirm_fee_explainer);
        }
        getMinerFeeExplainerSubject().onNext(str);
    }
}