package com.coinbase.wallet.di;

import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel;
import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel_AssistedFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel_AssistedFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel;
import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel_AssistedFactory;

/* loaded from: classes.dex */
public abstract class AssistedInject_ViewModelModule {
    private AssistedInject_ViewModelModule() {
    }

    abstract OnboardingBackupRecoveryPhraseViewModel.Factory bind_com_coinbase_wallet_features_cloudbackup_viewModel_OnboardingBackupRecoveryPhraseViewModel(OnboardingBackupRecoveryPhraseViewModel_AssistedFactory onboardingBackupRecoveryPhraseViewModel_AssistedFactory);

    abstract AdjustableMinerFee1559ViewModel.Factory bind_com_coinbase_wallet_features_send_viewmodels_AdjustableMinerFee1559ViewModel(AdjustableMinerFee1559ViewModel_AssistedFactory adjustableMinerFee1559ViewModel_AssistedFactory);

    abstract AdjustableMinerFeeViewModel.Factory bind_com_coinbase_wallet_features_send_viewmodels_AdjustableMinerFeeViewModel(AdjustableMinerFeeViewModel_AssistedFactory adjustableMinerFeeViewModel_AssistedFactory);

    abstract SwapAmountPickerViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapAmountPickerViewModel(SwapAmountPickerViewModel_AssistedFactory swapAmountPickerViewModel_AssistedFactory);

    abstract SwapAssetPickerViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapAssetPickerViewModel(SwapAssetPickerViewModel_AssistedFactory swapAssetPickerViewModel_AssistedFactory);

    abstract SwapCompleteViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapCompleteViewModel(SwapCompleteViewModel_AssistedFactory swapCompleteViewModel_AssistedFactory);

    abstract SwapConfirmationViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapConfirmationViewModel(SwapConfirmationViewModel_AssistedFactory swapConfirmationViewModel_AssistedFactory);

    abstract SwapDisclaimerViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapDisclaimerViewModel(SwapDisclaimerViewModel_AssistedFactory swapDisclaimerViewModel_AssistedFactory);

    abstract SwapInterstitialViewModel.Factory bind_com_coinbase_wallet_features_swap_viewmodels_SwapInterstitialViewModel(SwapInterstitialViewModel_AssistedFactory swapInterstitialViewModel_AssistedFactory);
}