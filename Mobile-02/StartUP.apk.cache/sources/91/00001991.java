package com.coinbase.wallet.di;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import com.coinbase.Coinbase;
import com.coinbase.ciphercore.CipherCoreInterface;
import com.coinbase.wallet.application.BaseApplication;
import com.coinbase.wallet.application.BaseApplication_MembersInjector;
import com.coinbase.wallet.application.MainActivity;
import com.coinbase.wallet.application.MainActivity_MembersInjector;
import com.coinbase.wallet.application.fragment.SignOutFragment;
import com.coinbase.wallet.application.fragment.SignOutFragment_MembersInjector;
import com.coinbase.wallet.application.migrations.AppVersion210Migration;
import com.coinbase.wallet.application.migrations.AppVersion210Migration_Factory;
import com.coinbase.wallet.application.migrations.AppVersion232Migration;
import com.coinbase.wallet.application.migrations.AppVersion232Migration_Factory;
import com.coinbase.wallet.application.migrations.AppVersion251Migration;
import com.coinbase.wallet.application.migrations.AppVersion251Migration_Factory;
import com.coinbase.wallet.application.migrations.AppVersion304Migration;
import com.coinbase.wallet.application.migrations.AppVersion304Migration_Factory;
import com.coinbase.wallet.application.migrations.Migratable;
import com.coinbase.wallet.application.migrations.Migrations;
import com.coinbase.wallet.application.migrations.MigrationsDao;
import com.coinbase.wallet.application.migrations.MigrationsDao_Factory;
import com.coinbase.wallet.application.migrations.Migrations_Factory;
import com.coinbase.wallet.application.model.Notification;
import com.coinbase.wallet.application.repository.NotificationRepository;
import com.coinbase.wallet.application.repository.NotificationRepository_Factory;
import com.coinbase.wallet.application.repository.interfaces.AppLockRepositoryInterface;
import com.coinbase.wallet.application.repository.interfaces.MnemonicRepositoryInterface;
import com.coinbase.wallet.application.service.ApplicationService;
import com.coinbase.wallet.application.service.ApplicationService_Factory;
import com.coinbase.wallet.application.service.WalletFirebaseMessagingService;
import com.coinbase.wallet.application.service.WalletFirebaseMessagingService_MembersInjector;
import com.coinbase.wallet.application.util.ContactUsLauncher;
import com.coinbase.wallet.application.view.HomeFragment;
import com.coinbase.wallet.application.view.HomeFragment_MembersInjector;
import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel;
import com.coinbase.wallet.application.viewmodel.LoadingPillViewModel_Factory;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel_Factory;
import com.coinbase.wallet.application.viewmodel.SignOutViewModel;
import com.coinbase.wallet.application.viewmodel.SignOutViewModel_Factory;
import com.coinbase.wallet.appreview.repositories.AppReviewRepository;
import com.coinbase.wallet.appreview.repositories.AppReviewRepository_Factory;
import com.coinbase.wallet.blockchains.models.Blockchain;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.blockchains.models.NetworkSetting;
import com.coinbase.wallet.blockchains.models.TxState;
import com.coinbase.wallet.blockchains.models.TxUpdate;
import com.coinbase.wallet.blockchains.models.Wallet;
import com.coinbase.wallet.common.utilities.BuildConfigWrapper;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.utilities.AmountPickerFormatter;
import com.coinbase.wallet.commonui.utilities.ViewModelFactoryWithMap;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel;
import com.coinbase.wallet.commonui.viewmodels.AmountViewModel_Factory;
import com.coinbase.wallet.compoundfinance.repositories.CompoundFinanceRepository;
import com.coinbase.wallet.consumer.apis.ConsumerAPI;
import com.coinbase.wallet.consumer.daos.ConsumerAccountsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerAvailablePaymentMethodsDAO;
import com.coinbase.wallet.consumer.daos.ConsumerPaymentMethodsDAO;
import com.coinbase.wallet.consumer.db.ConsumerDatabase;
import com.coinbase.wallet.consumer.di.ConsumerCoreComponent;
import com.coinbase.wallet.consumer.models.ConsumerNetworkConfig;
import com.coinbase.wallet.consumer.models.ConsumerWebViewConfig;
import com.coinbase.wallet.consumer.repositories.AppToAppAuthRepository;
import com.coinbase.wallet.consumer.repositories.AppToAppAuthRepository_Factory;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerAccountsRepository_Factory;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerTransferRepository_Factory;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository;
import com.coinbase.wallet.consumer.repositories.ConsumerUserRepository_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAccountsViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAddCardViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAmountPickerViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAppToAppViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAppToAppViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerAvailablePaymentMethodsViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerCardCDVViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerInterstitialViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerOnboardingViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSecure3DVerificationViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSendTwoFactorViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSendTwoFactorViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerSettingViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferInitiatedViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferInitiatedViewModel_Factory;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel_AssistedFactory;
import com.coinbase.wallet.consumer.views.ConsumerAddCardFragment;
import com.coinbase.wallet.consumer.views.ConsumerAddCardFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerAmountPickerFragment;
import com.coinbase.wallet.consumer.views.ConsumerAmountPickerFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerAvailablePaymentMethodsFragment;
import com.coinbase.wallet.consumer.views.ConsumerAvailablePaymentMethodsFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerCardCDVFragment;
import com.coinbase.wallet.consumer.views.ConsumerCardCDVFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerFragment;
import com.coinbase.wallet.consumer.views.ConsumerFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerInterstitialFragment;
import com.coinbase.wallet.consumer.views.ConsumerInterstitialFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerOnboardingFragment;
import com.coinbase.wallet.consumer.views.ConsumerOnboardingFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerSecure3DVerificationFragment;
import com.coinbase.wallet.consumer.views.ConsumerSecure3DVerificationFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerSendTwoFactorFragment;
import com.coinbase.wallet.consumer.views.ConsumerSendTwoFactorFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerTransferConfirmationFragment;
import com.coinbase.wallet.consumer.views.ConsumerTransferConfirmationFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerTransferInitiatedFragment;
import com.coinbase.wallet.consumer.views.ConsumerTransferInitiatedFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.ConsumerTransferMethodsFragment;
import com.coinbase.wallet.consumer.views.ConsumerTransferMethodsFragment_MembersInjector;
import com.coinbase.wallet.consumer.views.UMOActivity;
import com.coinbase.wallet.consumer.views.UMOActivity_MembersInjector;
import com.coinbase.wallet.core.interfaces.Destroyable;
import com.coinbase.wallet.core.interfaces.Refreshable;
import com.coinbase.wallet.core.interfaces.Startable;
import com.coinbase.wallet.core.interfaces.Tracing;
import com.coinbase.wallet.db.AppDatabase;
import com.coinbase.wallet.di.AppComponent;
import com.coinbase.wallet.ethereum.apis.MinerFeeAPI;
import com.coinbase.wallet.ethereum.daos.EthereumSignedTxDao;
import com.coinbase.wallet.ethereum.interfaces.IETHTxRepository;
import com.coinbase.wallet.ethereum.interfaces.IETHWalletRepository;
import com.coinbase.wallet.featureflags.repositories.FeatureFlagsRepository;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt;
import com.coinbase.wallet.features.cloudbackup.prompts.CloudBackupPrompt_Factory;
import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper;
import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper_Factory;
import com.coinbase.wallet.features.cloudbackup.view.BackupPickerFragment;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.CreatePasswordFragment;
import com.coinbase.wallet.features.cloudbackup.view.CreatePasswordFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.CreatePasswordInfoFragment;
import com.coinbase.wallet.features.cloudbackup.view.EnterPasswordFragment;
import com.coinbase.wallet.features.cloudbackup.view.EnterPasswordFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.ManualBackupFragment;
import com.coinbase.wallet.features.cloudbackup.view.ManualBackupFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.OnboardingBackupRecoveryPhraseFragment;
import com.coinbase.wallet.features.cloudbackup.view.OnboardingBackupRecoveryPhraseFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.RestoreWalletFragment;
import com.coinbase.wallet.features.cloudbackup.view.RestoreWalletFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.view.VerifyManualBackupFragment;
import com.coinbase.wallet.features.cloudbackup.view.VerifyManualBackupFragment_MembersInjector;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel_Factory;
import com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel;
import com.coinbase.wallet.features.cloudbackup.viewModel.CreatePasswordViewModel_Factory;
import com.coinbase.wallet.features.cloudbackup.viewModel.EnterPasswordViewModel;
import com.coinbase.wallet.features.cloudbackup.viewModel.EnterPasswordViewModel_Factory;
import com.coinbase.wallet.features.cloudbackup.viewModel.OnboardingBackupRecoveryPhraseViewModel_AssistedFactory;
import com.coinbase.wallet.features.cloudbackup.viewModel.RestoreWalletViewModel;
import com.coinbase.wallet.features.cloudbackup.viewModel.RestoreWalletViewModel_Factory;
import com.coinbase.wallet.features.collectibles.CollectibleTypesTabFragment;
import com.coinbase.wallet.features.collectibles.CollectibleTypesTabFragment_MembersInjector;
import com.coinbase.wallet.features.debugmenu.util.DebugSettings;
import com.coinbase.wallet.features.debugmenu.util.DebugSettings_Factory;
import com.coinbase.wallet.features.debugmenu.views.DebugMenuFragment;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApiHttp;
import com.coinbase.wallet.features.ethereum.apis.CollectiblesApi_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendAmountPickerViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendAmountPickerViewModel_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendCoinPickerViewModel_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendDashboardViewModel_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendProviderPickerViewModel_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendUserAgreementViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendUserAgreementViewModel_Factory;
import com.coinbase.wallet.features.lend.viewmodels.LendViewModel;
import com.coinbase.wallet.features.lend.viewmodels.LendViewModel_Factory;
import com.coinbase.wallet.features.lend.views.LendCoinPickerFragment;
import com.coinbase.wallet.features.lend.views.LendCoinPickerFragment_MembersInjector;
import com.coinbase.wallet.features.lend.views.LendDashboardFragment;
import com.coinbase.wallet.features.lend.views.LendDashboardFragment_MembersInjector;
import com.coinbase.wallet.features.lend.views.LendInterstitialFragment;
import com.coinbase.wallet.features.lend.views.LendInterstitialFragment_MembersInjector;
import com.coinbase.wallet.features.lend.views.LendProviderPickerFragment;
import com.coinbase.wallet.features.lend.views.LendProviderPickerFragment_MembersInjector;
import com.coinbase.wallet.features.lend.views.LendUserAgreementFragment;
import com.coinbase.wallet.features.lend.views.LendUserAgreementFragment_MembersInjector;
import com.coinbase.wallet.features.ofac.apis.OFACApi;
import com.coinbase.wallet.features.ofac.apis.OFACApiHttp;
import com.coinbase.wallet.features.ofac.apis.OFACApi_Factory;
import com.coinbase.wallet.features.ofac.repositories.OFACRepository;
import com.coinbase.wallet.features.ofac.repositories.OFACRepository_Factory;
import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApi;
import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApiInterface;
import com.coinbase.wallet.features.pushnotifications.apis.PushNotificationApi_Factory;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository;
import com.coinbase.wallet.features.pushnotifications.repositories.PushNotificationRepository_Factory;
import com.coinbase.wallet.features.pushnotifications.services.PushNotificationDisplayService;
import com.coinbase.wallet.features.pushnotifications.services.PushNotificationDisplayService_Factory;
import com.coinbase.wallet.features.send.apis.RecipientAPI;
import com.coinbase.wallet.features.send.apis.RecipientAPIHttp;
import com.coinbase.wallet.features.send.apis.RecipientAPI_Factory;
import com.coinbase.wallet.features.send.daos.RecipientDao;
import com.coinbase.wallet.features.send.di.ENSModule_ProvidesResolverServiceFactory;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt;
import com.coinbase.wallet.features.send.prompts.HighMinerFeesPrompt_Factory;
import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository;
import com.coinbase.wallet.features.send.repositories.AdjustableMinerFeeRepository_Factory;
import com.coinbase.wallet.features.send.repositories.RecipientRepository;
import com.coinbase.wallet.features.send.repositories.RecipientRepository_Factory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFee1559ViewModel_AssistedFactory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeSharedViewModel_Factory;
import com.coinbase.wallet.features.send.viewmodels.AdjustableMinerFeeViewModel_AssistedFactory;
import com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel;
import com.coinbase.wallet.features.send.viewmodels.LendConfirmationViewModel_Factory;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendAmountPickerViewModel_Factory;
import com.coinbase.wallet.features.send.viewmodels.SendCompleteViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendCompleteViewModel_Factory;
import com.coinbase.wallet.features.send.viewmodels.SendConfirmationViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendConfirmationViewModel_Factory;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel;
import com.coinbase.wallet.features.send.viewmodels.SendDestinationPickerViewModel_Factory;
import com.coinbase.wallet.features.send.views.AdjustableMinerFee1559Fragment;
import com.coinbase.wallet.features.send.views.AdjustableMinerFee1559Fragment_MembersInjector;
import com.coinbase.wallet.features.send.views.AdjustableMinerFeeFragment;
import com.coinbase.wallet.features.send.views.AdjustableMinerFeeFragment_MembersInjector;
import com.coinbase.wallet.features.send.views.AmountFragment;
import com.coinbase.wallet.features.send.views.AmountFragment_MembersInjector;
import com.coinbase.wallet.features.send.views.AmountPickerFragment;
import com.coinbase.wallet.features.send.views.AmountPickerFragment_MembersInjector;
import com.coinbase.wallet.features.send.views.CompleteFragment;
import com.coinbase.wallet.features.send.views.CompleteFragment_MembersInjector;
import com.coinbase.wallet.features.send.views.ConfirmationFragment;
import com.coinbase.wallet.features.send.views.ConfirmationFragment_MembersInjector;
import com.coinbase.wallet.features.send.views.SendDestinationPickerFragment;
import com.coinbase.wallet.features.send.views.SendDestinationPickerFragment_MembersInjector;
import com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel;
import com.coinbase.wallet.features.settings.viewmodels.UserProfileViewModel_Factory;
import com.coinbase.wallet.features.settings.views.UserProfileFragment;
import com.coinbase.wallet.features.settings.views.UserProfileFragment_MembersInjector;
import com.coinbase.wallet.features.signer.viewmodel.MessageSignerViewModel;
import com.coinbase.wallet.features.signer.viewmodel.MessageSignerViewModel_Factory;
import com.coinbase.wallet.features.signer.viewmodel.ParentRequestEthereumAccountsViewModel;
import com.coinbase.wallet.features.signer.viewmodel.ParentRequestEthereumAccountsViewModel_Factory;
import com.coinbase.wallet.features.signer.viewmodel.RequestEthereumAccountsViewModel;
import com.coinbase.wallet.features.signer.viewmodel.RequestEthereumAccountsViewModel_Factory;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel;
import com.coinbase.wallet.features.signer.viewmodel.SignerViewModel_Factory;
import com.coinbase.wallet.features.signer.viewmodel.SwitchEthereumChainViewModel;
import com.coinbase.wallet.features.signer.viewmodel.SwitchEthereumChainViewModel_Factory;
import com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel;
import com.coinbase.wallet.features.signer.viewmodel.TxSignerViewModel_Factory;
import com.coinbase.wallet.features.signer.views.MessageSignerFragment;
import com.coinbase.wallet.features.signer.views.MessageSignerFragment_MembersInjector;
import com.coinbase.wallet.features.signer.views.ParentRequestEthereumAccountsFragment;
import com.coinbase.wallet.features.signer.views.ParentRequestEthereumAccountsFragment_MembersInjector;
import com.coinbase.wallet.features.signer.views.RequestEthereumAccountsFragment;
import com.coinbase.wallet.features.signer.views.RequestEthereumAccountsFragment_MembersInjector;
import com.coinbase.wallet.features.signer.views.SignerViewFragment;
import com.coinbase.wallet.features.signer.views.SignerViewFragment_MembersInjector;
import com.coinbase.wallet.features.signer.views.SwitchEthereumChainFragment;
import com.coinbase.wallet.features.signer.views.SwitchEthereumChainFragment_MembersInjector;
import com.coinbase.wallet.features.signer.views.TxSignerFragment;
import com.coinbase.wallet.features.signer.views.TxSignerFragment_MembersInjector;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt;
import com.coinbase.wallet.features.swap.prompts.UnsupportedSwapAssetPrompt_Factory;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapAssetPickerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapCompleteViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapConfirmationViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapDisclaimerViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.viewmodels.SwapInterstitialViewModel_AssistedFactory;
import com.coinbase.wallet.features.swap.views.SwapAmountPickerFragment;
import com.coinbase.wallet.features.swap.views.SwapAmountPickerFragment_MembersInjector;
import com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment;
import com.coinbase.wallet.features.swap.views.SwapAssetPickerFragment_MembersInjector;
import com.coinbase.wallet.features.swap.views.SwapCompleteFragment;
import com.coinbase.wallet.features.swap.views.SwapCompleteFragment_MembersInjector;
import com.coinbase.wallet.features.swap.views.SwapConfirmationFragment;
import com.coinbase.wallet.features.swap.views.SwapConfirmationFragment_MembersInjector;
import com.coinbase.wallet.features.swap.views.SwapDisclaimerFragment;
import com.coinbase.wallet.features.swap.views.SwapDisclaimerFragment_MembersInjector;
import com.coinbase.wallet.features.swap.views.SwapInterstitialFragment;
import com.coinbase.wallet.features.swap.views.SwapInterstitialFragment_MembersInjector;
import com.coinbase.wallet.features.walletlink.di.WalletLinkModule_ProvideWalletLinkInterfaceFactory;
import com.coinbase.wallet.features.walletlink.models.WalletLinkPushNotificationCreator_Factory;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository;
import com.coinbase.wallet.features.walletlink.repositories.WalletLinkRepository_Factory;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkCompleteViewModel;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkCompleteViewModel_Factory;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel;
import com.coinbase.wallet.features.walletlink.viewmodels.WalletLinkSettingsViewModel_Factory;
import com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment;
import com.coinbase.wallet.features.walletlink.views.WalletLinkSettingsFragment_MembersInjector;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel;
import com.coinbase.wallet.features.wallets.viewmodels.ActionItemsViewModel_Factory;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel;
import com.coinbase.wallet.features.wallets.viewmodels.WalletsTabViewModel_Factory;
import com.coinbase.wallet.features.wallets.views.SendCoinPickerFragment;
import com.coinbase.wallet.features.wallets.views.SendCoinPickerFragment_MembersInjector;
import com.coinbase.wallet.features.wallets.views.WalletsTabFragment;
import com.coinbase.wallet.features.wallets.views.WalletsTabFragment_MembersInjector;
import com.coinbase.wallet.http.connectivity.ConnectionStatus;
import com.coinbase.wallet.lending.db.LendDatabase;
import com.coinbase.wallet.lending.di.LendContainer;
import com.coinbase.wallet.lending.interfaces.ILendRepository;
import com.coinbase.wallet.libraries.databases.db.Database;
import com.coinbase.wallet.qr.di.QrCodeParsersModule_ProvidesQrParsersFactory;
import com.coinbase.wallet.qr.parsers.BitcoinCashQrCodeParser;
import com.coinbase.wallet.qr.parsers.BitcoinCashQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.BitcoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.BitcoinQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.DogecoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.DogecoinQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.ERC20QRCodeParser;
import com.coinbase.wallet.qr.parsers.ERC20QRCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.EthereumClassicQrCodeParser;
import com.coinbase.wallet.qr.parsers.EthereumClassicQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.EthereumQrCodeParser;
import com.coinbase.wallet.qr.parsers.EthereumQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.HexStringFixedLengthQrCodeParser;
import com.coinbase.wallet.qr.parsers.HexStringFixedLengthQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.LitecoinQrCodeParser;
import com.coinbase.wallet.qr.parsers.LitecoinQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import com.coinbase.wallet.qr.parsers.StellarQrCodeParser;
import com.coinbase.wallet.qr.parsers.StellarQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.UnsignedIntegerQrCodeParser;
import com.coinbase.wallet.qr.parsers.UnsignedIntegerQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.Utf8StringFixedLengthQrCodeParser;
import com.coinbase.wallet.qr.parsers.Utf8StringFixedLengthQrCodeParser_Factory;
import com.coinbase.wallet.qr.parsers.WalletLinkQrParser;
import com.coinbase.wallet.qr.parsers.WalletLinkQrParser_Factory;
import com.coinbase.wallet.qr.parsers.XRPQrCodeParser;
import com.coinbase.wallet.qr.parsers.XRPQrCodeParser_Factory;
import com.coinbase.wallet.routing.models.RouteAction;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.models.RouteScheme;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository;
import com.coinbase.wallet.routing.repositories.DeepLinkRepository_Factory;
import com.coinbase.wallet.routing.viewmodels.DeepLinkViewModel;
import com.coinbase.wallet.routing.viewmodels.DeepLinkViewModel_Factory;
import com.coinbase.wallet.store.interfaces.StoreInterface;
import com.coinbase.wallet.swap.di.SwapComponent;
import com.coinbase.wallet.swap.interfaces.ISwapRepository;
import com.coinbase.wallet.txhistory.apis.TxHistoryApi_Factory;
import com.coinbase.wallet.txhistory.daos.TxAddressDAO;
import com.coinbase.wallet.txhistory.daos.TxHistoryDAO;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository;
import com.coinbase.wallet.txhistory.repositories.TxHistoryRepository_Factory;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailFragment_MembersInjector;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailViewModel;
import com.coinbase.wallet.txhistory.views.TxHistoryDetailViewModel_Factory;
import com.coinbase.wallet.user.apis.UserApi;
import com.coinbase.wallet.user.apis.UserApiHttp;
import com.coinbase.wallet.user.apis.UserApi_Factory;
import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.user.repositories.AccessTokenRepository;
import com.coinbase.wallet.user.repositories.UserRepository;
import com.coinbase.wallet.user.repositories.UserRepository_Factory;
import com.coinbase.wallet.wallets.db.WalletsDatabase;
import com.coinbase.wallet.wallets.di.CryptoContainer;
import com.coinbase.wallet.wallets.di.WalletsContainer;
import com.coinbase.wallet.wallets.formatters.CurrencyFormatter;
import com.coinbase.wallet.wallets.interfaces.IExchangeRateRepository;
import com.coinbase.wallet.wallets.interfaces.IFiatCurrencyRepository;
import com.coinbase.wallet.wallets.interfaces.ITxRepository;
import com.coinbase.wallet.wallets.interfaces.IWalletRepository;
import com.coinbase.walletengine.WalletEngine;
import com.coinbase.walletengine.services.resolver.ResolverService;
import com.coinbase.walletengine.services.xrp.XRPService;
import com.coinbase.walletlink.WalletLinkInterface;
import com.squareup.moshi.Moshi;
import com.toshi.db.DerivedDatabase;
import com.toshi.db.WalletDatabase;
import com.toshi.network.VersioningInterface;
import com.toshi.qr.view.fragment.UniversalQRScannerFragment;
import com.toshi.view.activity.BannedLocationActivity;
import com.toshi.view.activity.OnboardingWizardActivity;
import com.toshi.view.activity.a0;
import com.toshi.view.activity.a1;
import com.toshi.view.activity.a2;
import com.toshi.view.activity.a3;
import com.toshi.view.activity.b;
import com.toshi.view.activity.b0;
import com.toshi.view.activity.b1;
import com.toshi.view.activity.b2;
import com.toshi.view.activity.b3;
import com.toshi.view.activity.c;
import com.toshi.view.activity.c0;
import com.toshi.view.activity.c1;
import com.toshi.view.activity.c2;
import com.toshi.view.activity.c3;
import com.toshi.view.activity.d;
import com.toshi.view.activity.d0;
import com.toshi.view.activity.d1;
import com.toshi.view.activity.d2;
import com.toshi.view.activity.d3;
import com.toshi.view.activity.e;
import com.toshi.view.activity.e0;
import com.toshi.view.activity.e1;
import com.toshi.view.activity.e2;
import com.toshi.view.activity.e3;
import com.toshi.view.activity.f;
import com.toshi.view.activity.f0;
import com.toshi.view.activity.f1;
import com.toshi.view.activity.f2;
import com.toshi.view.activity.f3;
import com.toshi.view.activity.g;
import com.toshi.view.activity.g0;
import com.toshi.view.activity.g1;
import com.toshi.view.activity.g2;
import com.toshi.view.activity.g3;
import com.toshi.view.activity.h;
import com.toshi.view.activity.h0;
import com.toshi.view.activity.h1;
import com.toshi.view.activity.h2;
import com.toshi.view.activity.h3;
import com.toshi.view.activity.i;
import com.toshi.view.activity.i0;
import com.toshi.view.activity.i1;
import com.toshi.view.activity.i2;
import com.toshi.view.activity.j;
import com.toshi.view.activity.j0;
import com.toshi.view.activity.j1;
import com.toshi.view.activity.j2;
import com.toshi.view.activity.k;
import com.toshi.view.activity.k0;
import com.toshi.view.activity.k1;
import com.toshi.view.activity.k2;
import com.toshi.view.activity.l;
import com.toshi.view.activity.l0;
import com.toshi.view.activity.l1;
import com.toshi.view.activity.l2;
import com.toshi.view.activity.m;
import com.toshi.view.activity.m0;
import com.toshi.view.activity.m1;
import com.toshi.view.activity.m2;
import com.toshi.view.activity.n;
import com.toshi.view.activity.n0;
import com.toshi.view.activity.n1;
import com.toshi.view.activity.n2;
import com.toshi.view.activity.o;
import com.toshi.view.activity.o0;
import com.toshi.view.activity.o1;
import com.toshi.view.activity.o2;
import com.toshi.view.activity.p;
import com.toshi.view.activity.p0;
import com.toshi.view.activity.p1;
import com.toshi.view.activity.p2;
import com.toshi.view.activity.pin.SetupPinLockActivity;
import com.toshi.view.activity.pin.SwitchPinLockFragment;
import com.toshi.view.activity.q;
import com.toshi.view.activity.q0;
import com.toshi.view.activity.q1;
import com.toshi.view.activity.q2;
import com.toshi.view.activity.r;
import com.toshi.view.activity.r0;
import com.toshi.view.activity.r1;
import com.toshi.view.activity.r2;
import com.toshi.view.activity.s;
import com.toshi.view.activity.s0;
import com.toshi.view.activity.s1;
import com.toshi.view.activity.s2;
import com.toshi.view.activity.t;
import com.toshi.view.activity.t0;
import com.toshi.view.activity.t1;
import com.toshi.view.activity.t2;
import com.toshi.view.activity.u;
import com.toshi.view.activity.u0;
import com.toshi.view.activity.u1;
import com.toshi.view.activity.u2;
import com.toshi.view.activity.v;
import com.toshi.view.activity.v0;
import com.toshi.view.activity.v1;
import com.toshi.view.activity.v2;
import com.toshi.view.activity.w;
import com.toshi.view.activity.w0;
import com.toshi.view.activity.w1;
import com.toshi.view.activity.w2;
import com.toshi.view.activity.x;
import com.toshi.view.activity.x0;
import com.toshi.view.activity.x1;
import com.toshi.view.activity.x2;
import com.toshi.view.activity.y;
import com.toshi.view.activity.y0;
import com.toshi.view.activity.y1;
import com.toshi.view.activity.y2;
import com.toshi.view.activity.z;
import com.toshi.view.activity.z0;
import com.toshi.view.activity.z1;
import com.toshi.view.activity.z2;
import com.toshi.view.fragment.AdvancedSettingsFragment;
import com.toshi.view.fragment.AppLockSettingsFragment;
import com.toshi.view.fragment.AuthenticationFragment;
import com.toshi.view.fragment.BannedLocationFragment;
import com.toshi.view.fragment.BannedLocationNavFragment;
import com.toshi.view.fragment.CollectibleDetailFragment;
import com.toshi.view.fragment.CurrencyFragment;
import com.toshi.view.fragment.DisplayCoinAddressFragment;
import com.toshi.view.fragment.NetworkSwitcherFragment;
import com.toshi.view.fragment.OnboardingWizardFragment;
import com.toshi.view.fragment.ReadMoreRecoveryPhraseFragment;
import com.toshi.view.fragment.ReceiveCoinPickerFragment;
import com.toshi.view.fragment.SignInFragment;
import com.toshi.view.fragment.ViewCollectibleTypeFragment;
import com.toshi.view.fragment.WalletPickerFragment;
import com.toshi.view.fragment.coin.WalletDetailFragment;
import com.toshi.view.fragment.e0;
import com.toshi.view.fragment.h0;
import com.toshi.view.fragment.legal.LegalFragment;
import com.toshi.view.fragment.legal.LegalViewFragment;
import com.toshi.view.fragment.legal.LicenseFragment;
import com.toshi.view.fragment.legal.LicenseListFragment;
import com.toshi.view.fragment.n0;
import com.toshi.view.fragment.onboarding.LandingFragment;
import com.toshi.view.fragment.onboarding.LegalAgreementFragment;
import com.toshi.view.fragment.onboarding.PrivacySelectionFragment;
import com.toshi.view.fragment.onboarding.authMethod.NewWalletAuthenticationOnboardingFragment;
import com.toshi.view.fragment.onboarding.authMethod.SignInWalletAuthenticationOnboardingFragment;
import com.toshi.view.fragment.pickUsername.PickUsernameFragment;
import com.toshi.view.fragment.pickUsername.SignInPickUsernameFragment;
import com.toshi.view.fragment.toplevel.DappsFragment;
import com.toshi.view.fragment.toplevel.SettingsFragment;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.b;
import e.j.d.g.t;
import e.j.d.g.w;
import e.j.i.a2;
import e.j.i.c2;
import e.j.i.g2;
import e.j.i.u1;
import e.j.i.w1;
import e.j.i.y1;
import e.j.n.b3;
import e.j.n.c3;
import e.j.n.d3;
import e.j.n.e3;
import e.j.n.f3;
import e.j.n.g3;
import e.j.n.i3;
import e.j.n.j3;
import e.j.n.k3;
import e.j.n.l3;
import e.j.n.n3;
import e.j.n.o2;
import e.j.n.o3;
import e.j.n.p2;
import e.j.n.p3.n;
import e.j.n.s2;
import e.j.n.t2;
import e.j.n.w2;
import e.j.n.x2;
import e.j.n.y2;
import e.j.n.z2;
import h.c.b0;
import h.c.s;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Provider;
import kotlin.e0.c.l;
import kotlin.e0.c.q;
import okhttp3.Cache;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public final class DaggerAppComponent implements AppComponent {
    private Provider<AccessTokenRepository> accessTokenRepositoryProvider;
    private Provider<AdjustableMinerFeeRepository> adjustableMinerFeeRepositoryProvider;
    private final DaggerAppComponent appComponent;
    private final AppCoreComponent appCoreComponent;
    private Provider<AppLockRepositoryInterface> appLockRepositoryProvider;
    private Provider<e.j.j.b> appPrefsProvider;
    private Provider<AppReviewRepository> appReviewRepositoryProvider;
    private Provider<AppVersion210Migration> appVersion210MigrationProvider;
    private Provider<AppVersion232Migration> appVersion232MigrationProvider;
    private Provider<AppVersion251Migration> appVersion251MigrationProvider;
    private Provider<AppVersion304Migration> appVersion304MigrationProvider;
    private Provider<Application> applicationProvider;
    private Provider<ApplicationService> applicationServiceProvider;
    private Provider<AuthenticationHelper> authenticationHelperProvider;
    private Provider<b.a> bannedLocationActivitySubcomponentFactoryProvider;
    private Provider<e.j.l.o.a> base64Provider;
    private Provider<BaseApplication> baseApplicationProvider;
    private Provider<BitcoinCashQrCodeParser> bitcoinCashQrCodeParserProvider;
    private Provider<BitcoinQrCodeParser> bitcoinQrCodeParserProvider;
    private Provider<u1> bookmarkRepositoryProvider;
    private Provider<BuildConfigWrapper> buildConfigWrapperProvider;
    private Provider<Cache> cacheProvider;
    private Provider<CipherCoreInterface> cipherCoreProvider;
    private Provider<Coinbase> coinbaseSdkProvider;
    private Provider<w1> collectibleTypesRepositoryProvider;
    private Provider<CollectiblesApiHttp> collectiblesApiHttpProvider;
    private Provider<CollectiblesApi> collectiblesApiProvider;
    private Provider<CompoundFinanceRepository> compoundFinanceRepositoryProvider;
    private Provider<ConsumerAPI> consumerAPIProvider;
    private Provider<ConsumerAccountsDAO> consumerAccountsDAOProvider;
    private Provider<ConsumerAccountsRepository> consumerAccountsRepositoryProvider;
    private Provider<ConsumerAvailablePaymentMethodsDAO> consumerAvailablePaymentMethodsDAOProvider;
    private final ConsumerCoreComponent consumerCoreComponent;
    private Provider<Database<ConsumerDatabase>> consumerDatabaseProvider;
    private Provider<ConsumerNetworkConfig> consumerNetworkConfigProvider;
    private Provider<e.j.c.a.a> consumerOAuthPrefsProvider;
    private Provider<ConsumerPaymentMethodsDAO> consumerPaymentMethodsDAOProvider;
    private Provider<ConsumerTransferRepository> consumerTransferRepositoryProvider;
    private Provider<ConsumerUserRepository> consumerUserRepositoryProvider;
    private Provider<ConsumerWebViewConfig> consumerWebviewConfigProvider;
    private Provider<Context> contextProvider;
    private final CryptoContainer cryptoContainer;
    private Provider<CurrencyFormatter> currencyFormatterProvider;
    private Provider<DebugSettings> debugSettingsProvider;
    private Provider<DeepLinkRepository> deepLinkRepositoryProvider;
    private Provider<com.toshi.db.c> derivedDatabaseDestroyableProvider;
    private Provider<h0> displayCoinAddressFragmentFactoryProvider;
    private Provider<DogecoinQrCodeParser> dogecoinQrCodeParserProvider;
    private Provider<ERC20QRCodeParser> eRC20QRCodeParserProvider;
    private Provider<y1> erc721RepositoryProvider;
    private Provider<IETHTxRepository> ethTxRepositoryProvider;
    private Provider<IETHWalletRepository> ethWalletRepositoryProvider;
    private Provider<EthereumClassicQrCodeParser> ethereumClassicQrCodeParserProvider;
    private Provider<EthereumQrCodeParser> ethereumQrCodeParserProvider;
    private Provider<EthereumSignedTxDao> ethereumSignedTxDaoProvider;
    private Provider<IExchangeRateRepository> exchangeRateRepositoryProvider;
    private Provider<FeatureFlagsRepository> featureFlagsRepositoryProvider;
    private Provider<IFiatCurrencyRepository> fiatCurrencyRepositoryProvider;
    private Provider<t> keyStoreHandlerProvider;
    private Provider<Database<LendDatabase>> lendDatabaseProvider;
    private Provider<ILendRepository> lendRepositoryProvider;
    private Provider<LitecoinQrCodeParser> litecoinQrCodeParserProvider;
    private Provider<c.a> mainActivitySubcomponentFactoryProvider;
    private Provider<Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser>> mapOfClassOfAndQRCodeIntentParserProvider;
    private Provider<Map<Integer, Provider<Destroyable>>> mapOfIntegerAndProviderOfDestroyableProvider;
    private Provider<Map<Integer, Provider<Migratable>>> mapOfIntegerAndProviderOfMigratableProvider;
    private Provider<Map<Integer, Provider<Notification>>> mapOfIntegerAndProviderOfNotificationProvider;
    private Provider<Map<Integer, Provider<Startable>>> mapOfIntegerAndProviderOfStartableProvider;
    private Provider<Map<Integer, Refreshable>> mapOfIntegerAndRefreshableProvider;
    private Provider<w> masterSeedHandlerProvider;
    private Provider<MigrationsDao> migrationsDaoProvider;
    private Provider<Migrations> migrationsProvider;
    private Provider<MinerFeeAPI> minerFeeAPIProvider;
    private Provider<a2> mnemonicBackupRepositoryProvider;
    private Provider<MnemonicRepositoryInterface> mnemonicRepositoryProvider;
    private Provider<Moshi> moshiProvider;
    private Provider<List<NetworkSetting>> networkSettingsProvider;
    private Provider<e.j.j.j> notificationPrefsProvider;
    private Provider<NotificationRepository> notificationRepositoryProvider;
    private Provider<OFACApi> oFACApiProvider;
    private Provider<OFACRepository> oFACRepositoryProvider;
    private Provider<OFACApiHttp> ofacApiHttpProvider;
    private Provider<d.a> onboardingWizardActivitySubcomponentFactoryProvider;
    private Provider<n> pinLockViewModelProvider;
    private Provider<WalletLinkInterface> provideWalletLinkInterfaceProvider;
    private Provider<AmountPickerFormatter> providesAmountPickerFormatterProvider;
    private Provider<Database<AppDatabase>> providesAppDatabaseProvider;
    private Provider<com.toshi.db.g.b> providesBookmarkDaoProvider;
    private Provider<io.branch.referral.b> providesBranchClientProvider;
    private Provider<Destroyable> providesCacheDestroyableProvider;
    private Provider<com.toshi.db.h.b> providesCollectibleTypeDaoProvider;
    private Provider<s<ConnectionStatus>> providesConnectivitySubjectProvider;
    private Provider<Notification> providesConsumerNotification$app_productionReleaseProvider;
    private Provider<Notification> providesConsumerOnrampNotification$app_productionReleaseProvider;
    private Provider<DerivedDatabase> providesDerivedDatabaseProvider;
    private Provider<com.toshi.db.i.b> providesErc721TokenDaoProvider;
    private Provider<Refreshable> providesExchangeRateRepositoryProvider;
    private Provider<Refreshable> providesFeatureFlagsRefreshableProvider;
    private Provider<q<Blockchain, Network, String, b0<TxState>>> providesGetTxStateProvider;
    private Provider<Refreshable> providesInternetRefreshableProvider;
    private Provider<Refreshable> providesLendRepositoryRefreshableProvider;
    private Provider<Notification> providesNewUserCloudBackupPrompt$app_productionReleaseProvider;
    private Provider<PackageManager> providesPackageManagerProvider;
    private Provider<Map<RouteScheme, l<Uri, RouteAction>>> providesPaymentRouteActionsProvider;
    private Provider<PushNotificationApiInterface> providesPushNotificationApiInterfaceProvider;
    private Provider<Set<QRCodeIntentParser>> providesQrParsersProvider;
    private Provider<List<Refreshable>> providesRefreshableListProvider;
    private Provider<ResolverService> providesResolverServiceProvider;
    private Provider<SimpleDateFormat> providesRfc3399SimpleDateFormatProvider;
    private Provider<Map<RouteActionKey, l<Uri, RouteAction>>> providesRouteActionsProvider;
    private Provider<Notification> providesSecurityProviderPrompt$app_productionReleaseProvider;
    private Provider<RecipientDao> providesSuggestedRecipientDaoProvider;
    private Provider<Notification> providesSwapTOSNotification$app_productionReleaseProvider;
    private Provider<Tracing> providesTraceLoggerProvider;
    private Provider<TxAddressDAO> providesTxAddressDAOProvider;
    private Provider<TxHistoryDAO> providesTxHistoryDaoProvider;
    private Provider<Refreshable> providesTxResumbmitterProvider;
    private Provider<s<TxUpdate>> providesTxUpdatesObservableProvider;
    private Provider<UserDaoInterface> providesUserDaoProvider;
    private Provider<Notification> providesVerifyAppsPrompt$app_productionReleaseProvider;
    private Provider<VersioningInterface> providesVersioningInterfaceProvider;
    private Provider<WalletDatabase> providesWalletDatabaseProvider;
    private Provider<Refreshable> providesWalletRepositoryRefreshableProvider;
    private Provider<s<List<Wallet>>> providesWalletsObservableProvider;
    private Provider<PushNotificationApi> pushNotificationApiProvider;
    private Provider<PushNotificationDisplayService> pushNotificationDisplayServiceProvider;
    private Provider<PushNotificationRepository> pushNotificationRepositoryProvider;
    private Provider<RecipientAPI> recipientAPIProvider;
    private Provider<RecipientAPIHttp> recipientApiInterfaceProvider;
    private Provider<RecipientRepository> recipientRepositoryProvider;
    private Provider<RecoveryPhraseClipboardWrapper> recoveryPhraseClipboardWrapperProvider;
    private Provider<c2> refreshServiceProvider;
    private Provider<retrofit2.t> retrofitWalletServiceProvider;
    private final RouteActionModule routeActionModule;
    private Provider<e.a> setupPinLockActivitySubcomponentFactoryProvider;
    private Provider<SignerViewModel> signerViewModelProvider;
    private Provider<StellarQrCodeParser> stellarQrCodeParserProvider;
    private Provider<StoreInterface> storeProvider;
    private final SwapComponent swapComponent;
    private Provider<ISwapRepository> swapRepositoryProvider;
    private Provider<TxHistoryRepository> txHistoryRepositoryProvider;
    private Provider<ITxRepository> txRepositoryProvider;
    private Provider<f.a> uMOActivitySubcomponentFactoryProvider;
    private Provider<UserApiHttp> userApiInterfaceProvider;
    private Provider<UserApi> userApiProvider;
    private Provider<UserRepository> userRepositoryProvider;
    private Provider<g2> versioningRepositoryProvider;
    private Provider<com.toshi.db.e> walletDatabaseDestroyableProvider;
    private Provider<WalletEngine> walletEngineProvider;
    private Provider<WalletLinkRepository> walletLinkRepositoryProvider;
    private Provider<IWalletRepository> walletRepositoryProvider;
    private final WalletsContainer walletsContainer;
    private Provider<Database<WalletsDatabase>> walletsDatabaseProvider;
    private Provider<XRPQrCodeParser> xRPQrCodeParserProvider;
    private Provider<XRPService> xrpServiceProvider;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BannedLocationActivitySubcomponentFactory implements b.a {
        private final DaggerAppComponent appComponent;

        private BannedLocationActivitySubcomponentFactory(DaggerAppComponent daggerAppComponent) {
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b.a
        public com.toshi.view.activity.b create(BannedLocationActivity bannedLocationActivity) {
            f.c.h.b(bannedLocationActivity);
            return new BannedLocationActivitySubcomponentImpl(bannedLocationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BannedLocationActivitySubcomponentImpl implements com.toshi.view.activity.b {
        private final DaggerAppComponent appComponent;
        private Provider<g.a> backupPickerFragmentSubcomponentFactoryProvider;
        private Provider<h.a> backupRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
        private Provider<i.a> bannedLocationFragmentSubcomponentFactoryProvider;
        private Provider<j.a> bannedLocationNavFragmentSubcomponentFactoryProvider;
        private Provider<k.a> enterPasswordFragmentSubcomponentFactoryProvider;
        private Provider<l.a> landingFragmentSubcomponentFactoryProvider;
        private Provider<o2> mainViewModelProvider;
        private Provider<m.a> manualBackupFragmentSubcomponentFactoryProvider;
        private Provider<n.a> readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private Provider<o.a> restoreWalletFragmentSubcomponentFactoryProvider;
        private Provider<p.a> signInFragmentSubcomponentFactoryProvider;
        private Provider<q.a> signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider;
        private Provider<r.a> verifyManualBackupFragmentSubcomponentFactoryProvider;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_BPF_BackupPickerFragmentSubcomponentFactory implements g.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_BPF_BackupPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.g create(BackupPickerFragment backupPickerFragment) {
                f.c.h.b(backupPickerFragment);
                return new BLAFBM_BPF_BackupPickerFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, backupPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_BPF_BackupPickerFragmentSubcomponentImpl implements com.toshi.view.activity.g {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_BPF_BackupPickerFragmentSubcomponentImpl bLAFBM_BPF_BackupPickerFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BackupPickerFragment injectBackupPickerFragment(BackupPickerFragment backupPickerFragment) {
                dagger.android.g.i.a(backupPickerFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return backupPickerFragment;
            }

            private BLAFBM_BPF_BackupPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, BackupPickerFragment backupPickerFragment) {
                this.bLAFBM_BPF_BackupPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(BackupPickerFragment backupPickerFragment) {
                injectBackupPickerFragment(backupPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory implements h.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.h create(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                f.c.h.b(backupRecoveryPhraseFragment);
                return new BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl implements com.toshi.view.activity.h {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl bLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl;
            private Provider<BackupRecoveryPhraseViewModel> backupRecoveryPhraseViewModelProvider;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactoryOfBackupRecoveryPhraseViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.backupRecoveryPhraseViewModelProvider));
            }

            private void initialize(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.backupRecoveryPhraseViewModelProvider = BackupRecoveryPhraseViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private BackupRecoveryPhraseFragment injectBackupRecoveryPhraseFragment(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                dagger.android.g.i.a(backupRecoveryPhraseFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                BackupRecoveryPhraseFragment_MembersInjector.injectAuthenticationHelper(backupRecoveryPhraseFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                BackupRecoveryPhraseFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(backupRecoveryPhraseFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                BackupRecoveryPhraseFragment_MembersInjector.injectViewModelFactory(backupRecoveryPhraseFragment, genericViewModelFactoryOfBackupRecoveryPhraseViewModel());
                return backupRecoveryPhraseFragment;
            }

            private BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.bLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(backupRecoveryPhraseFragment);
            }

            @Override // dagger.android.b
            public void inject(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                injectBackupRecoveryPhraseFragment(backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_EPF_EnterPasswordFragmentSubcomponentFactory implements k.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_EPF_EnterPasswordFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public k create(EnterPasswordFragment enterPasswordFragment) {
                f.c.h.b(enterPasswordFragment);
                return new BLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, enterPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl implements k {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl bLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private Provider<EnterPasswordViewModel> enterPasswordViewModelProvider;

            private GenericViewModelFactory<EnterPasswordViewModel> genericViewModelFactoryOfEnterPasswordViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.enterPasswordViewModelProvider));
            }

            private void initialize(EnterPasswordFragment enterPasswordFragment) {
                this.enterPasswordViewModelProvider = EnterPasswordViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private EnterPasswordFragment injectEnterPasswordFragment(EnterPasswordFragment enterPasswordFragment) {
                dagger.android.g.i.a(enterPasswordFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                EnterPasswordFragment_MembersInjector.injectViewModelFactory(enterPasswordFragment, genericViewModelFactoryOfEnterPasswordViewModel());
                return enterPasswordFragment;
            }

            private BLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, EnterPasswordFragment enterPasswordFragment) {
                this.bLAFBM_EPF_EnterPasswordFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(enterPasswordFragment);
            }

            @Override // dagger.android.b
            public void inject(EnterPasswordFragment enterPasswordFragment) {
                injectEnterPasswordFragment(enterPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_LF_LandingFragmentSubcomponentFactory implements l.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_LF_LandingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.l create(LandingFragment landingFragment) {
                f.c.h.b(landingFragment);
                return new BLAFBM_LF_LandingFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, landingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_LF_LandingFragmentSubcomponentImpl implements com.toshi.view.activity.l {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_LF_LandingFragmentSubcomponentImpl bLAFBM_LF_LandingFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private LandingFragment injectLandingFragment(LandingFragment landingFragment) {
                dagger.android.g.i.a(landingFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return landingFragment;
            }

            private BLAFBM_LF_LandingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, LandingFragment landingFragment) {
                this.bLAFBM_LF_LandingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LandingFragment landingFragment) {
                injectLandingFragment(landingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_MBF_ManualBackupFragmentSubcomponentFactory implements m.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_MBF_ManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public m create(ManualBackupFragment manualBackupFragment) {
                f.c.h.b(manualBackupFragment);
                return new BLAFBM_MBF_ManualBackupFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_MBF_ManualBackupFragmentSubcomponentImpl implements m {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_MBF_ManualBackupFragmentSubcomponentImpl bLAFBM_MBF_ManualBackupFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private ManualBackupFragment injectManualBackupFragment(ManualBackupFragment manualBackupFragment) {
                dagger.android.g.i.a(manualBackupFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ManualBackupFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(manualBackupFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                return manualBackupFragment;
            }

            private BLAFBM_MBF_ManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, ManualBackupFragment manualBackupFragment) {
                this.bLAFBM_MBF_ManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ManualBackupFragment manualBackupFragment) {
                injectManualBackupFragment(manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory implements n.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.n create(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                f.c.h.b(readMoreRecoveryPhraseFragment);
                return new BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, readMoreRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl implements com.toshi.view.activity.n {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl bLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private ReadMoreRecoveryPhraseFragment injectReadMoreRecoveryPhraseFragment(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                dagger.android.g.i.a(readMoreRecoveryPhraseFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return readMoreRecoveryPhraseFragment;
            }

            private BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                this.bLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                injectReadMoreRecoveryPhraseFragment(readMoreRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_RWF_RestoreWalletFragmentSubcomponentFactory implements o.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_RWF_RestoreWalletFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public o create(RestoreWalletFragment restoreWalletFragment) {
                f.c.h.b(restoreWalletFragment);
                return new BLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, restoreWalletFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl implements o {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl bLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private Provider<RestoreWalletViewModel> restoreWalletViewModelProvider;

            private GenericViewModelFactory<RestoreWalletViewModel> genericViewModelFactoryOfRestoreWalletViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.restoreWalletViewModelProvider));
            }

            private void initialize(RestoreWalletFragment restoreWalletFragment) {
                this.restoreWalletViewModelProvider = RestoreWalletViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private RestoreWalletFragment injectRestoreWalletFragment(RestoreWalletFragment restoreWalletFragment) {
                dagger.android.g.i.a(restoreWalletFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                RestoreWalletFragment_MembersInjector.injectViewModelFactory(restoreWalletFragment, genericViewModelFactoryOfRestoreWalletViewModel());
                return restoreWalletFragment;
            }

            private BLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, RestoreWalletFragment restoreWalletFragment) {
                this.bLAFBM_RWF_RestoreWalletFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(restoreWalletFragment);
            }

            @Override // dagger.android.b
            public void inject(RestoreWalletFragment restoreWalletFragment) {
                injectRestoreWalletFragment(restoreWalletFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_SIF_SignInFragmentSubcomponentFactory implements p.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_SIF_SignInFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public p create(SignInFragment signInFragment) {
                f.c.h.b(signInFragment);
                return new BLAFBM_SIF_SignInFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, signInFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_SIF_SignInFragmentSubcomponentImpl implements p {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_SIF_SignInFragmentSubcomponentImpl bLAFBM_SIF_SignInFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private Provider<d3> signInViewModelProvider;

            private GenericViewModelFactory<d3> genericViewModelFactoryOfSignInViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.signInViewModelProvider));
            }

            private void initialize(SignInFragment signInFragment) {
                this.signInViewModelProvider = e3.a(this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private SignInFragment injectSignInFragment(SignInFragment signInFragment) {
                dagger.android.g.i.a(signInFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                n0.a(signInFragment, genericViewModelFactoryOfSignInViewModel());
                return signInFragment;
            }

            private BLAFBM_SIF_SignInFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, SignInFragment signInFragment) {
                this.bLAFBM_SIF_SignInFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(signInFragment);
            }

            @Override // dagger.android.b
            public void inject(SignInFragment signInFragment) {
                injectSignInFragment(signInFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory implements q.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.q create(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                f.c.h.b(signInWalletAuthenticationOnboardingFragment);
                return new BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, signInWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl implements com.toshi.view.activity.q {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl bLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private Provider<f3> signInWalletAuthenticationOnboardingViewModelProvider;

            private GenericViewModelFactory<f3> genericViewModelFactoryOfSignInWalletAuthenticationOnboardingViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.signInWalletAuthenticationOnboardingViewModelProvider));
            }

            private void initialize(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                this.signInWalletAuthenticationOnboardingViewModelProvider = g3.a(this.appComponent.appPrefsProvider, this.appComponent.masterSeedHandlerProvider, this.appComponent.appLockRepositoryProvider, this.appComponent.keyStoreHandlerProvider, this.appComponent.userRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.mnemonicRepositoryProvider);
            }

            private SignInWalletAuthenticationOnboardingFragment injectSignInWalletAuthenticationOnboardingFragment(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                dagger.android.g.i.a(signInWalletAuthenticationOnboardingFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.onboarding.authMethod.h.b(signInWalletAuthenticationOnboardingFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.c(signInWalletAuthenticationOnboardingFragment, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.a(signInWalletAuthenticationOnboardingFragment, (ApplicationService) this.appComponent.applicationServiceProvider.get());
                com.toshi.view.fragment.onboarding.authMethod.j.a(signInWalletAuthenticationOnboardingFragment, genericViewModelFactoryOfSignInWalletAuthenticationOnboardingViewModel());
                return signInWalletAuthenticationOnboardingFragment;
            }

            private BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                this.bLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(signInWalletAuthenticationOnboardingFragment);
            }

            @Override // dagger.android.b
            public void inject(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                injectSignInWalletAuthenticationOnboardingFragment(signInWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory implements r.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public r create(VerifyManualBackupFragment verifyManualBackupFragment) {
                f.c.h.b(verifyManualBackupFragment);
                return new BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl implements r {
            private final DaggerAppComponent appComponent;
            private final BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl bLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private Provider<i3> verifyManualBackupViewModelProvider;

            private GenericViewModelFactory<i3> genericViewModelFactoryOfVerifyManualBackupViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.verifyManualBackupViewModelProvider));
            }

            private void initialize(VerifyManualBackupFragment verifyManualBackupFragment) {
                this.verifyManualBackupViewModelProvider = j3.a(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private VerifyManualBackupFragment injectVerifyManualBackupFragment(VerifyManualBackupFragment verifyManualBackupFragment) {
                dagger.android.g.i.a(verifyManualBackupFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                VerifyManualBackupFragment_MembersInjector.injectViewModelFactory(verifyManualBackupFragment, genericViewModelFactoryOfVerifyManualBackupViewModel());
                return verifyManualBackupFragment;
            }

            private BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, VerifyManualBackupFragment verifyManualBackupFragment) {
                this.bLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
                initialize(verifyManualBackupFragment);
            }

            @Override // dagger.android.b
            public void inject(VerifyManualBackupFragment verifyManualBackupFragment) {
                injectVerifyManualBackupFragment(verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BannedLocationFragmentSubcomponentFactory implements i.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BannedLocationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.i create(BannedLocationFragment bannedLocationFragment) {
                f.c.h.b(bannedLocationFragment);
                return new BannedLocationFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, bannedLocationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BannedLocationFragmentSubcomponentImpl implements com.toshi.view.activity.i {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private final BannedLocationFragmentSubcomponentImpl bannedLocationFragmentSubcomponentImpl;

            private GenericViewModelFactory<o2> genericViewModelFactoryOfMainViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.bannedLocationActivitySubcomponentImpl.mainViewModelProvider));
            }

            private BannedLocationFragment injectBannedLocationFragment(BannedLocationFragment bannedLocationFragment) {
                dagger.android.g.i.a(bannedLocationFragment, this.bannedLocationActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                e0.a(bannedLocationFragment, genericViewModelFactoryOfMainViewModel());
                return bannedLocationFragment;
            }

            private BannedLocationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, BannedLocationFragment bannedLocationFragment) {
                this.bannedLocationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(BannedLocationFragment bannedLocationFragment) {
                injectBannedLocationFragment(bannedLocationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BannedLocationNavFragmentSubcomponentFactory implements j.a {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;

            private BannedLocationNavFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.j create(BannedLocationNavFragment bannedLocationNavFragment) {
                f.c.h.b(bannedLocationNavFragment);
                return new BannedLocationNavFragmentSubcomponentImpl(this.appComponent, this.bannedLocationActivitySubcomponentImpl, bannedLocationNavFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BannedLocationNavFragmentSubcomponentImpl implements com.toshi.view.activity.j {
            private final DaggerAppComponent appComponent;
            private final BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl;
            private final BannedLocationNavFragmentSubcomponentImpl bannedLocationNavFragmentSubcomponentImpl;

            @Override // dagger.android.b
            public void inject(BannedLocationNavFragment bannedLocationNavFragment) {
            }

            private BannedLocationNavFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivitySubcomponentImpl bannedLocationActivitySubcomponentImpl, BannedLocationNavFragment bannedLocationNavFragment) {
                this.bannedLocationNavFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.bannedLocationActivitySubcomponentImpl = bannedLocationActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DispatchingAndroidInjector<Object> dispatchingAndroidInjectorOfObject() {
            return dagger.android.e.a(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), com.google.common.collect.m.l());
        }

        private void initialize(BannedLocationActivity bannedLocationActivity) {
            this.bannedLocationNavFragmentSubcomponentFactoryProvider = new Provider<j.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public j.a get() {
                    return new BannedLocationNavFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.bannedLocationFragmentSubcomponentFactoryProvider = new Provider<i.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public i.a get() {
                    return new BannedLocationFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.backupPickerFragmentSubcomponentFactoryProvider = new Provider<g.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public g.a get() {
                    return new BLAFBM_BPF_BackupPickerFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.enterPasswordFragmentSubcomponentFactoryProvider = new Provider<k.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public k.a get() {
                    return new BLAFBM_EPF_EnterPasswordFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider = new Provider<q.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public q.a get() {
                    return new BLAFBM_SIWAF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.landingFragmentSubcomponentFactoryProvider = new Provider<l.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public l.a get() {
                    return new BLAFBM_LF_LandingFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.restoreWalletFragmentSubcomponentFactoryProvider = new Provider<o.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public o.a get() {
                    return new BLAFBM_RWF_RestoreWalletFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.signInFragmentSubcomponentFactoryProvider = new Provider<p.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public p.a get() {
                    return new BLAFBM_SIF_SignInFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<n.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public n.a get() {
                    return new BLAFBM_RMF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<h.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public h.a get() {
                    return new BLAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.manualBackupFragmentSubcomponentFactoryProvider = new Provider<m.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public m.a get() {
                    return new BLAFBM_MBF_ManualBackupFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.verifyManualBackupFragmentSubcomponentFactoryProvider = new Provider<r.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.BannedLocationActivitySubcomponentImpl.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public r.a get() {
                    return new BLAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(BannedLocationActivitySubcomponentImpl.this.appComponent, BannedLocationActivitySubcomponentImpl.this.bannedLocationActivitySubcomponentImpl);
                }
            };
            this.mainViewModelProvider = f.c.c.b(p2.a(this.appComponent.appReviewRepositoryProvider, this.appComponent.versioningRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.appPrefsProvider, this.appComponent.notificationRepositoryProvider, this.appComponent.userRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.appLockRepositoryProvider, this.appComponent.deepLinkRepositoryProvider, this.appComponent.storeProvider, this.appComponent.pushNotificationRepositoryProvider, this.appComponent.authenticationHelperProvider, this.appComponent.mnemonicRepositoryProvider, this.appComponent.providesConnectivitySubjectProvider));
        }

        private BannedLocationActivity injectBannedLocationActivity(BannedLocationActivity bannedLocationActivity) {
            dagger.android.g.c.a(bannedLocationActivity, dispatchingAndroidInjectorOfObject());
            return bannedLocationActivity;
        }

        private Map<Class<?>, Provider<b.a<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
            return com.google.common.collect.m.a().c(MainActivity.class, this.appComponent.mainActivitySubcomponentFactoryProvider).c(OnboardingWizardActivity.class, this.appComponent.onboardingWizardActivitySubcomponentFactoryProvider).c(SetupPinLockActivity.class, this.appComponent.setupPinLockActivitySubcomponentFactoryProvider).c(BannedLocationActivity.class, this.appComponent.bannedLocationActivitySubcomponentFactoryProvider).c(UMOActivity.class, this.appComponent.uMOActivitySubcomponentFactoryProvider).c(BannedLocationNavFragment.class, this.bannedLocationNavFragmentSubcomponentFactoryProvider).c(BannedLocationFragment.class, this.bannedLocationFragmentSubcomponentFactoryProvider).c(BackupPickerFragment.class, this.backupPickerFragmentSubcomponentFactoryProvider).c(EnterPasswordFragment.class, this.enterPasswordFragmentSubcomponentFactoryProvider).c(SignInWalletAuthenticationOnboardingFragment.class, this.signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider).c(LandingFragment.class, this.landingFragmentSubcomponentFactoryProvider).c(RestoreWalletFragment.class, this.restoreWalletFragmentSubcomponentFactoryProvider).c(SignInFragment.class, this.signInFragmentSubcomponentFactoryProvider).c(ReadMoreRecoveryPhraseFragment.class, this.readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider).c(BackupRecoveryPhraseFragment.class, this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider).c(ManualBackupFragment.class, this.manualBackupFragmentSubcomponentFactoryProvider).c(VerifyManualBackupFragment.class, this.verifyManualBackupFragmentSubcomponentFactoryProvider).a();
        }

        private BannedLocationActivitySubcomponentImpl(DaggerAppComponent daggerAppComponent, BannedLocationActivity bannedLocationActivity) {
            this.bannedLocationActivitySubcomponentImpl = this;
            this.appComponent = daggerAppComponent;
            initialize(bannedLocationActivity);
        }

        @Override // dagger.android.b
        public void inject(BannedLocationActivity bannedLocationActivity) {
            injectBannedLocationActivity(bannedLocationActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Factory implements AppComponent.Factory {
        private Factory() {
        }

        @Override // com.coinbase.wallet.di.AppComponent.Factory
        public AppComponent create(CryptoContainer cryptoContainer, WalletsContainer walletsContainer, AppCoreComponent appCoreComponent, LendContainer lendContainer, ConsumerCoreComponent consumerCoreComponent, SwapComponent swapComponent) {
            f.c.h.b(cryptoContainer);
            f.c.h.b(walletsContainer);
            f.c.h.b(appCoreComponent);
            f.c.h.b(lendContainer);
            f.c.h.b(consumerCoreComponent);
            f.c.h.b(swapComponent);
            return new DaggerAppComponent(new RouteActionModule(), appCoreComponent, cryptoContainer, walletsContainer, lendContainer, consumerCoreComponent, swapComponent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class MainActivitySubcomponentFactory implements c.a {
        private final DaggerAppComponent appComponent;

        private MainActivitySubcomponentFactory(DaggerAppComponent daggerAppComponent) {
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b.a
        public com.toshi.view.activity.c create(MainActivity mainActivity) {
            f.c.h.b(mainActivity);
            return new MainActivitySubcomponentImpl(mainActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class MainActivitySubcomponentImpl implements com.toshi.view.activity.c {
        private Provider<s.a> adjustableMinerFee1559FragmentSubcomponentFactoryProvider;
        private Provider<t.a> adjustableMinerFeeFragmentSubcomponentFactoryProvider;
        private Provider<u.a> advancedSettingsFragmentSubcomponentFactoryProvider;
        private Provider<m1.a> amountFragmentSubcomponentFactoryProvider;
        private Provider<n1.a> amountPickerFragmentSubcomponentFactoryProvider;
        private final DaggerAppComponent appComponent;
        private Provider<v.a> appLockSettingsFragmentSubcomponentFactoryProvider;
        private Provider<x.a> authenticationFragmentSubcomponentFactoryProvider;
        private Provider<y.a> backupRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private Provider<e.j.n.a2> bannedLocationViewModelProvider;
        private Provider<z.a> basePickUsernameFragmentSubcomponentFactoryProvider;
        private Provider<a0.a> baseWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider;
        private Provider<c0.a> collectibleDetailFragmentSubcomponentFactoryProvider;
        private Provider<d0.a> collectibleTypesTabFragmentSubcomponentFactoryProvider;
        private Provider<e0.a> completeFragmentSubcomponentFactoryProvider;
        private Provider<p1.a> confirmationFragmentSubcomponentFactoryProvider;
        private Provider<f0.a> consumerAddCardFragmentSubcomponentFactoryProvider;
        private Provider<g0.a> consumerAmountPickerFragmentSubcomponentFactoryProvider;
        private Provider<h0.a> consumerAvailablePaymentMethodsFragmentSubcomponentFactoryProvider;
        private Provider<i0.a> consumerCardCDVFragmentSubcomponentFactoryProvider;
        private Provider<j0.a> consumerFragmentSubcomponentFactoryProvider;
        private Provider<k0.a> consumerInterstitialFragmentSubcomponentFactoryProvider;
        private Provider<l0.a> consumerOnboardingFragmentSubcomponentFactoryProvider;
        private Provider<m0.a> consumerSecure3DVerificationFragmentSubcomponentFactoryProvider;
        private Provider<n0.a> consumerSendTwoFactorFragmentSubcomponentFactoryProvider;
        private Provider<o0.a> consumerTransferConfirmationFragmentSubcomponentFactoryProvider;
        private Provider<p0.a> consumerTransferInitiatedFragmentSubcomponentFactoryProvider;
        private Provider<q0.a> consumerTransferMethodsFragmentSubcomponentFactoryProvider;
        private Provider<r0.a> createPasswordFragmentSubcomponentFactoryProvider;
        private Provider<s0.a> createPasswordInfoFragmentSubcomponentFactoryProvider;
        private Provider<t0.a> currencyFragmentSubcomponentFactoryProvider;
        private Provider<u0.a> dappNavFragmentSubcomponentFactoryProvider;
        private Provider<n2.a> dappsFragmentSubcomponentFactoryProvider;
        private Provider<v0.a> debugMenuFragmentSubcomponentFactoryProvider;
        private Provider<DeepLinkViewModel> deepLinkViewModelProvider;
        private Provider<w0.a> displayCoinAddressFragmentSubcomponentFactoryProvider;
        private Provider<j2.a> homeFragmentSubcomponentFactoryProvider;
        private Provider<x0.a> legalFragmentSubcomponentFactoryProvider;
        private Provider<y0.a> legalViewFragmentSubcomponentFactoryProvider;
        private Provider<z0.a> lendCoinPickerFragmentSubcomponentFactoryProvider;
        private Provider<a1.a> lendDashboardFragmentSubcomponentFactoryProvider;
        private Provider<b1.a> lendInterstitialFragmentSubcomponentFactoryProvider;
        private Provider<c1.a> lendProviderPickerFragmentSubcomponentFactoryProvider;
        private Provider<d1.a> lendUserAgreementFragmentSubcomponentFactoryProvider;
        private Provider<e1.a> licenseFragmentSubcomponentFactoryProvider;
        private Provider<f1.a> licenseListFragmentSubcomponentFactoryProvider;
        private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
        private Provider<o2> mainViewModelProvider;
        private Provider<g1.a> manualBackupFragmentSubcomponentFactoryProvider;
        private Provider<h1.a> messageSignerFragmentSubcomponentFactoryProvider;
        private Provider<i1.a> networkSwitcherFragmentSubcomponentFactoryProvider;
        private Provider<j1.a> parentRequestEthereumAccountsFragmentSubcomponentFactoryProvider;
        private Provider<k1.a> receiveCoinPickerFragmentSubcomponentFactoryProvider;
        private Provider<l1.a> requestEthereumAccountsFragmentSubcomponentFactoryProvider;
        private Provider<o1.a> sendCoinPickerFragmentSubcomponentFactoryProvider;
        private Provider<q1.a> sendDestinationPickerFragmentSubcomponentFactoryProvider;
        private Provider<s1.a> settingsFragmentSubcomponentFactoryProvider;
        private Provider<r1.a> settingsNavFragmentSubcomponentFactoryProvider;
        private Provider<t1.a> signOutFragmentSubcomponentFactoryProvider;
        private Provider<u1.a> signerViewFragmentSubcomponentFactoryProvider;
        private Provider<v1.a> swapAmountPickerFragmentSubcomponentFactoryProvider;
        private Provider<w1.a> swapAssetPickerFragmentSubcomponentFactoryProvider;
        private Provider<x1.a> swapCompleteFragmentSubcomponentFactoryProvider;
        private Provider<y1.a> swapConfirmationFragmentSubcomponentFactoryProvider;
        private Provider<z1.a> swapDisclaimerFragmentSubcomponentFactoryProvider;
        private Provider<a2.a> swapInterstitialFragmentSubcomponentFactoryProvider;
        private Provider<w.a> switchEthereumChainFragmentSubcomponentFactoryProvider;
        private Provider<b2.a> switchPinLockFragmentSubcomponentFactoryProvider;
        private Provider<c2.a> txHistoryDetailFragmentSubcomponentFactoryProvider;
        private Provider<d2.a> txSignerFragmentSubcomponentFactoryProvider;
        private Provider<e2.a> universalQRScannerFragmentSubcomponentFactoryProvider;
        private Provider<f2.a> userProfileFragmentSubcomponentFactoryProvider;
        private Provider<g2.a> verifyManualBackupFragmentSubcomponentFactoryProvider;
        private Provider<h2.a> viewCollectibleTypeFragmentSubcomponentFactoryProvider;
        private Provider<i2.a> walletDetailFragmentSubcomponentFactoryProvider;
        private Provider<k2.a> walletLinkSettingsFragmentSubcomponentFactoryProvider;
        private Provider<l2.a> walletNavFragmentSubcomponentFactoryProvider;
        private Provider<m2.a> walletPickerFragmentSubcomponentFactoryProvider;
        private Provider<b0.a> walletsTabFragmentSubcomponentFactoryProvider;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdjustableMinerFee1559FragmentSubcomponentFactory implements s.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AdjustableMinerFee1559FragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.s create(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
                f.c.h.b(adjustableMinerFee1559Fragment);
                return new AdjustableMinerFee1559FragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, adjustableMinerFee1559Fragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdjustableMinerFee1559FragmentSubcomponentImpl implements com.toshi.view.activity.s {
            private final AdjustableMinerFee1559FragmentSubcomponentImpl adjustableMinerFee1559FragmentSubcomponentImpl;
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AdjustableMinerFee1559ViewModel_AssistedFactory adjustableMinerFee1559ViewModel_AssistedFactory() {
                return new AdjustableMinerFee1559ViewModel_AssistedFactory(this.appComponent.currencyFormatterProvider, this.appComponent.adjustableMinerFeeRepositoryProvider);
            }

            private GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(AdjustableMinerFeeSharedViewModel_Factory.create()));
            }

            private AdjustableMinerFee1559Fragment injectAdjustableMinerFee1559Fragment(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
                AdjustableMinerFee1559Fragment_MembersInjector.injectViewModelFactory(adjustableMinerFee1559Fragment, adjustableMinerFee1559ViewModel_AssistedFactory());
                AdjustableMinerFee1559Fragment_MembersInjector.injectAdjustableMinerFeeSharedFactory(adjustableMinerFee1559Fragment, genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel());
                return adjustableMinerFee1559Fragment;
            }

            private AdjustableMinerFee1559FragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
                this.adjustableMinerFee1559FragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(AdjustableMinerFee1559Fragment adjustableMinerFee1559Fragment) {
                injectAdjustableMinerFee1559Fragment(adjustableMinerFee1559Fragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdjustableMinerFeeFragmentSubcomponentFactory implements t.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AdjustableMinerFeeFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.t create(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
                f.c.h.b(adjustableMinerFeeFragment);
                return new AdjustableMinerFeeFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, adjustableMinerFeeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdjustableMinerFeeFragmentSubcomponentImpl implements com.toshi.view.activity.t {
            private final AdjustableMinerFeeFragmentSubcomponentImpl adjustableMinerFeeFragmentSubcomponentImpl;
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AdjustableMinerFeeViewModel_AssistedFactory adjustableMinerFeeViewModel_AssistedFactory() {
                return new AdjustableMinerFeeViewModel_AssistedFactory(this.appComponent.currencyFormatterProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.adjustableMinerFeeRepositoryProvider);
            }

            private GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(AdjustableMinerFeeSharedViewModel_Factory.create()));
            }

            private AdjustableMinerFeeFragment injectAdjustableMinerFeeFragment(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
                AdjustableMinerFeeFragment_MembersInjector.injectViewModelFactory(adjustableMinerFeeFragment, adjustableMinerFeeViewModel_AssistedFactory());
                AdjustableMinerFeeFragment_MembersInjector.injectAdjustableMinerFeeSharedFactory(adjustableMinerFeeFragment, genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel());
                return adjustableMinerFeeFragment;
            }

            private AdjustableMinerFeeFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
                this.adjustableMinerFeeFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(AdjustableMinerFeeFragment adjustableMinerFeeFragment) {
                injectAdjustableMinerFeeFragment(adjustableMinerFeeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdvancedSettingsFragmentSubcomponentFactory implements u.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AdvancedSettingsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public u create(AdvancedSettingsFragment advancedSettingsFragment) {
                f.c.h.b(advancedSettingsFragment);
                return new AdvancedSettingsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, advancedSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AdvancedSettingsFragmentSubcomponentImpl implements u {
            private final AdvancedSettingsFragmentSubcomponentImpl advancedSettingsFragmentSubcomponentImpl;
            private Provider<e.j.n.u1> advancedSettingsViewModelProvider;
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.u1> genericViewModelFactoryOfAdvancedSettingsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.advancedSettingsViewModelProvider));
            }

            private void initialize(AdvancedSettingsFragment advancedSettingsFragment) {
                this.advancedSettingsViewModelProvider = e.j.n.v1.a(this.appComponent.appPrefsProvider, this.appComponent.walletRepositoryProvider, this.appComponent.ethWalletRepositoryProvider);
            }

            private AdvancedSettingsFragment injectAdvancedSettingsFragment(AdvancedSettingsFragment advancedSettingsFragment) {
                dagger.android.g.i.a(advancedSettingsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.b0.a(advancedSettingsFragment, genericViewModelFactoryOfAdvancedSettingsViewModel());
                return advancedSettingsFragment;
            }

            private AdvancedSettingsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AdvancedSettingsFragment advancedSettingsFragment) {
                this.advancedSettingsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(advancedSettingsFragment);
            }

            @Override // dagger.android.b
            public void inject(AdvancedSettingsFragment advancedSettingsFragment) {
                injectAdvancedSettingsFragment(advancedSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AmountFragmentSubcomponentFactory implements m1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AmountFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public m1 create(AmountFragment amountFragment) {
                f.c.h.b(amountFragment);
                return new AmountFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, amountFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AmountFragmentSubcomponentImpl implements m1 {
            private final AmountFragmentSubcomponentImpl amountFragmentSubcomponentImpl;
            private Provider<AmountViewModel> amountViewModelProvider;
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<AmountViewModel> genericViewModelFactoryOfAmountViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.amountViewModelProvider));
            }

            private void initialize(AmountFragment amountFragment) {
                this.amountViewModelProvider = AmountViewModel_Factory.create(this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private AmountFragment injectAmountFragment(AmountFragment amountFragment) {
                dagger.android.g.i.a(amountFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                AmountFragment_MembersInjector.injectAmountViewModelFactory(amountFragment, genericViewModelFactoryOfAmountViewModel());
                return amountFragment;
            }

            private AmountFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AmountFragment amountFragment) {
                this.amountFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(amountFragment);
            }

            @Override // dagger.android.b
            public void inject(AmountFragment amountFragment) {
                injectAmountFragment(amountFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AmountPickerFragmentSubcomponentFactory implements n1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AmountPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public n1 create(AmountPickerFragment amountPickerFragment) {
                f.c.h.b(amountPickerFragment);
                return new AmountPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, amountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AmountPickerFragmentSubcomponentImpl implements n1 {
            private final AmountPickerFragmentSubcomponentImpl amountPickerFragmentSubcomponentImpl;
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
            private Provider<LendAmountPickerViewModel> lendAmountPickerViewModelProvider;
            private Provider<LendConfirmationViewModel> lendConfirmationViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<SendAmountPickerViewModel> sendAmountPickerViewModelProvider;
            private Provider<SendCompleteViewModel> sendCompleteViewModelProvider;
            private Provider<SendConfirmationViewModel> sendConfirmationViewModelProvider;

            private void initialize(AmountPickerFragment amountPickerFragment) {
                this.sendCompleteViewModelProvider = SendCompleteViewModel_Factory.create(this.appComponent.currencyFormatterProvider);
                this.highMinerFeesPromptProvider = HighMinerFeesPrompt_Factory.create(this.appComponent.storeProvider);
                this.lendConfirmationViewModelProvider = LendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.highMinerFeesPromptProvider, this.appComponent.currencyFormatterProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.lendRepositoryProvider, this.appComponent.walletRepositoryProvider);
                this.sendConfirmationViewModelProvider = SendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.appComponent.currencyFormatterProvider, this.appComponent.walletRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.highMinerFeesPromptProvider);
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.lendAmountPickerViewModelProvider = LendAmountPickerViewModel_Factory.create(this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider, this.cloudBackupPromptProvider, this.appComponent.mnemonicBackupRepositoryProvider);
                this.sendAmountPickerViewModelProvider = SendAmountPickerViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider);
            }

            private AmountPickerFragment injectAmountPickerFragment(AmountPickerFragment amountPickerFragment) {
                dagger.android.g.i.a(amountPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                AmountPickerFragment_MembersInjector.injectViewModelFactory(amountPickerFragment, viewModelFactoryWithMap());
                return amountPickerFragment;
            }

            private Map<Class<? extends androidx.lifecycle.b0>, Provider<androidx.lifecycle.b0>> mapOfClassOfAndProviderOfViewModel() {
                return com.google.common.collect.m.a().c(WalletLinkCompleteViewModel.class, WalletLinkCompleteViewModel_Factory.create()).c(SendCompleteViewModel.class, this.sendCompleteViewModelProvider).c(LendConfirmationViewModel.class, this.lendConfirmationViewModelProvider).c(SendConfirmationViewModel.class, this.sendConfirmationViewModelProvider).c(LendAmountPickerViewModel.class, this.lendAmountPickerViewModelProvider).c(SendAmountPickerViewModel.class, this.sendAmountPickerViewModelProvider).a();
            }

            private ViewModelFactoryWithMap viewModelFactoryWithMap() {
                return new ViewModelFactoryWithMap(mapOfClassOfAndProviderOfViewModel());
            }

            private AmountPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AmountPickerFragment amountPickerFragment) {
                this.amountPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(amountPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(AmountPickerFragment amountPickerFragment) {
                injectAmountPickerFragment(amountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AppLockSettingsFragmentSubcomponentFactory implements v.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AppLockSettingsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public v create(AppLockSettingsFragment appLockSettingsFragment) {
                f.c.h.b(appLockSettingsFragment);
                return new AppLockSettingsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, appLockSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AppLockSettingsFragmentSubcomponentImpl implements v {
            private final DaggerAppComponent appComponent;
            private final AppLockSettingsFragmentSubcomponentImpl appLockSettingsFragmentSubcomponentImpl;
            private Provider<e.j.n.w1> appLockSettingsViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.w1> genericViewModelFactoryOfAppLockSettingsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.appLockSettingsViewModelProvider));
            }

            private void initialize(AppLockSettingsFragment appLockSettingsFragment) {
                this.appLockSettingsViewModelProvider = e.j.n.x1.a(this.appComponent.appLockRepositoryProvider, this.appComponent.authenticationHelperProvider, this.appComponent.mnemonicRepositoryProvider, this.appComponent.keyStoreHandlerProvider);
            }

            private AppLockSettingsFragment injectAppLockSettingsFragment(AppLockSettingsFragment appLockSettingsFragment) {
                dagger.android.g.i.a(appLockSettingsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.c0.c(appLockSettingsFragment, genericViewModelFactoryOfAppLockSettingsViewModel());
                com.toshi.view.fragment.c0.b(appLockSettingsFragment, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.c0.a(appLockSettingsFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                return appLockSettingsFragment;
            }

            private AppLockSettingsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AppLockSettingsFragment appLockSettingsFragment) {
                this.appLockSettingsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(appLockSettingsFragment);
            }

            @Override // dagger.android.b
            public void inject(AppLockSettingsFragment appLockSettingsFragment) {
                injectAppLockSettingsFragment(appLockSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AuthenticationFragmentSubcomponentFactory implements x.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private AuthenticationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public x create(AuthenticationFragment authenticationFragment) {
                f.c.h.b(authenticationFragment);
                return new AuthenticationFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, authenticationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class AuthenticationFragmentSubcomponentImpl implements x {
            private final DaggerAppComponent appComponent;
            private final AuthenticationFragmentSubcomponentImpl authenticationFragmentSubcomponentImpl;
            private Provider<e.j.n.y1> authenticationViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.y1> genericViewModelFactoryOfAuthenticationViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.authenticationViewModelProvider));
            }

            private void initialize(AuthenticationFragment authenticationFragment) {
                this.authenticationViewModelProvider = e.j.n.z1.a(this.appComponent.appLockRepositoryProvider, this.appComponent.mnemonicRepositoryProvider);
            }

            private AuthenticationFragment injectAuthenticationFragment(AuthenticationFragment authenticationFragment) {
                dagger.android.g.i.a(authenticationFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.d0.a(authenticationFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.d0.b(authenticationFragment, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.d0.c(authenticationFragment, genericViewModelFactoryOfAuthenticationViewModel());
                return authenticationFragment;
            }

            private AuthenticationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, AuthenticationFragment authenticationFragment) {
                this.authenticationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(authenticationFragment);
            }

            @Override // dagger.android.b
            public void inject(AuthenticationFragment authenticationFragment) {
                injectAuthenticationFragment(authenticationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BasePickUsernameFragmentSubcomponentFactory implements z.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private BasePickUsernameFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public z create(com.toshi.view.fragment.pickUsername.h hVar) {
                f.c.h.b(hVar);
                return new BasePickUsernameFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BasePickUsernameFragmentSubcomponentImpl implements z {
            private final DaggerAppComponent appComponent;
            private final BasePickUsernameFragmentSubcomponentImpl basePickUsernameFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<w2> pickUsernameViewModelProvider;

            private GenericViewModelFactory<w2> genericViewModelFactoryOfPickUsernameViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.pickUsernameViewModelProvider));
            }

            private void initialize(com.toshi.view.fragment.pickUsername.h hVar) {
                this.pickUsernameViewModelProvider = x2.a(this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private com.toshi.view.fragment.pickUsername.h injectBasePickUsernameFragment(com.toshi.view.fragment.pickUsername.h hVar) {
                dagger.android.g.i.a(hVar, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.pickUsername.i.a(hVar, genericViewModelFactoryOfPickUsernameViewModel());
                return hVar;
            }

            private BasePickUsernameFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, com.toshi.view.fragment.pickUsername.h hVar) {
                this.basePickUsernameFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(hVar);
            }

            @Override // dagger.android.b
            public void inject(com.toshi.view.fragment.pickUsername.h hVar) {
                injectBasePickUsernameFragment(hVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BaseWalletAuthenticationOnboardingFragmentSubcomponentFactory implements a0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private BaseWalletAuthenticationOnboardingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public a0 create(com.toshi.view.fragment.onboarding.authMethod.g gVar) {
                f.c.h.b(gVar);
                return new BaseWalletAuthenticationOnboardingFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class BaseWalletAuthenticationOnboardingFragmentSubcomponentImpl implements a0 {
            private final DaggerAppComponent appComponent;
            private final BaseWalletAuthenticationOnboardingFragmentSubcomponentImpl baseWalletAuthenticationOnboardingFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private com.toshi.view.fragment.onboarding.authMethod.g injectBaseWalletAuthenticationOnboardingFragment(com.toshi.view.fragment.onboarding.authMethod.g gVar) {
                dagger.android.g.i.a(gVar, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.onboarding.authMethod.h.b(gVar, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.c(gVar, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.a(gVar, (ApplicationService) this.appComponent.applicationServiceProvider.get());
                return gVar;
            }

            private BaseWalletAuthenticationOnboardingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, com.toshi.view.fragment.onboarding.authMethod.g gVar) {
                this.baseWalletAuthenticationOnboardingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(com.toshi.view.fragment.onboarding.authMethod.g gVar) {
                injectBaseWalletAuthenticationOnboardingFragment(gVar);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CollectibleDetailFragmentSubcomponentFactory implements c0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CollectibleDetailFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public c0 create(CollectibleDetailFragment collectibleDetailFragment) {
                f.c.h.b(collectibleDetailFragment);
                return new CollectibleDetailFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, collectibleDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CollectibleDetailFragmentSubcomponentImpl implements c0 {
            private final DaggerAppComponent appComponent;
            private final CollectibleDetailFragmentSubcomponentImpl collectibleDetailFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CollectibleDetailFragment injectCollectibleDetailFragment(CollectibleDetailFragment collectibleDetailFragment) {
                dagger.android.g.i.a(collectibleDetailFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return collectibleDetailFragment;
            }

            private CollectibleDetailFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CollectibleDetailFragment collectibleDetailFragment) {
                this.collectibleDetailFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(CollectibleDetailFragment collectibleDetailFragment) {
                injectCollectibleDetailFragment(collectibleDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CollectibleTypesTabFragmentSubcomponentFactory implements d0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CollectibleTypesTabFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public d0 create(CollectibleTypesTabFragment collectibleTypesTabFragment) {
                f.c.h.b(collectibleTypesTabFragment);
                return new CollectibleTypesTabFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, collectibleTypesTabFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CollectibleTypesTabFragmentSubcomponentImpl implements d0 {
            private final DaggerAppComponent appComponent;
            private final CollectibleTypesTabFragmentSubcomponentImpl collectibleTypesTabFragmentSubcomponentImpl;
            private Provider<e.j.n.d2> collectibleTypesTabViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.d2> genericViewModelFactoryOfCollectibleTypesTabViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.collectibleTypesTabViewModelProvider));
            }

            private GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactoryOfScrolledToTopViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(ScrolledToTopViewModel_Factory.create()));
            }

            private void initialize(CollectibleTypesTabFragment collectibleTypesTabFragment) {
                this.collectibleTypesTabViewModelProvider = e.j.n.e2.a(this.appComponent.collectibleTypesRepositoryProvider);
            }

            private CollectibleTypesTabFragment injectCollectibleTypesTabFragment(CollectibleTypesTabFragment collectibleTypesTabFragment) {
                dagger.android.g.i.a(collectibleTypesTabFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                CollectibleTypesTabFragment_MembersInjector.injectViewModelFactory(collectibleTypesTabFragment, genericViewModelFactoryOfCollectibleTypesTabViewModel());
                CollectibleTypesTabFragment_MembersInjector.injectScrolledToTopViewModelFactory(collectibleTypesTabFragment, genericViewModelFactoryOfScrolledToTopViewModel());
                return collectibleTypesTabFragment;
            }

            private CollectibleTypesTabFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CollectibleTypesTabFragment collectibleTypesTabFragment) {
                this.collectibleTypesTabFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(collectibleTypesTabFragment);
            }

            @Override // dagger.android.b
            public void inject(CollectibleTypesTabFragment collectibleTypesTabFragment) {
                injectCollectibleTypesTabFragment(collectibleTypesTabFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CompleteFragmentSubcomponentFactory implements e0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CompleteFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.e0 create(CompleteFragment completeFragment) {
                f.c.h.b(completeFragment);
                return new CompleteFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, completeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CompleteFragmentSubcomponentImpl implements com.toshi.view.activity.e0 {
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private final CompleteFragmentSubcomponentImpl completeFragmentSubcomponentImpl;
            private Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
            private Provider<LendAmountPickerViewModel> lendAmountPickerViewModelProvider;
            private Provider<LendConfirmationViewModel> lendConfirmationViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<SendAmountPickerViewModel> sendAmountPickerViewModelProvider;
            private Provider<SendCompleteViewModel> sendCompleteViewModelProvider;
            private Provider<SendConfirmationViewModel> sendConfirmationViewModelProvider;

            private void initialize(CompleteFragment completeFragment) {
                this.sendCompleteViewModelProvider = SendCompleteViewModel_Factory.create(this.appComponent.currencyFormatterProvider);
                this.highMinerFeesPromptProvider = HighMinerFeesPrompt_Factory.create(this.appComponent.storeProvider);
                this.lendConfirmationViewModelProvider = LendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.highMinerFeesPromptProvider, this.appComponent.currencyFormatterProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.lendRepositoryProvider, this.appComponent.walletRepositoryProvider);
                this.sendConfirmationViewModelProvider = SendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.appComponent.currencyFormatterProvider, this.appComponent.walletRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.highMinerFeesPromptProvider);
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.lendAmountPickerViewModelProvider = LendAmountPickerViewModel_Factory.create(this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider, this.cloudBackupPromptProvider, this.appComponent.mnemonicBackupRepositoryProvider);
                this.sendAmountPickerViewModelProvider = SendAmountPickerViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider);
            }

            private CompleteFragment injectCompleteFragment(CompleteFragment completeFragment) {
                dagger.android.g.i.a(completeFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                CompleteFragment_MembersInjector.injectViewModelFactory(completeFragment, viewModelFactoryWithMap());
                return completeFragment;
            }

            private Map<Class<? extends androidx.lifecycle.b0>, Provider<androidx.lifecycle.b0>> mapOfClassOfAndProviderOfViewModel() {
                return com.google.common.collect.m.a().c(WalletLinkCompleteViewModel.class, WalletLinkCompleteViewModel_Factory.create()).c(SendCompleteViewModel.class, this.sendCompleteViewModelProvider).c(LendConfirmationViewModel.class, this.lendConfirmationViewModelProvider).c(SendConfirmationViewModel.class, this.sendConfirmationViewModelProvider).c(LendAmountPickerViewModel.class, this.lendAmountPickerViewModelProvider).c(SendAmountPickerViewModel.class, this.sendAmountPickerViewModelProvider).a();
            }

            private ViewModelFactoryWithMap viewModelFactoryWithMap() {
                return new ViewModelFactoryWithMap(mapOfClassOfAndProviderOfViewModel());
            }

            private CompleteFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CompleteFragment completeFragment) {
                this.completeFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(completeFragment);
            }

            @Override // dagger.android.b
            public void inject(CompleteFragment completeFragment) {
                injectCompleteFragment(completeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConfirmationFragmentSubcomponentFactory implements p1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConfirmationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public p1 create(ConfirmationFragment confirmationFragment) {
                f.c.h.b(confirmationFragment);
                return new ConfirmationFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, confirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConfirmationFragmentSubcomponentImpl implements p1 {
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private final ConfirmationFragmentSubcomponentImpl confirmationFragmentSubcomponentImpl;
            private Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
            private Provider<LendAmountPickerViewModel> lendAmountPickerViewModelProvider;
            private Provider<LendConfirmationViewModel> lendConfirmationViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<SendAmountPickerViewModel> sendAmountPickerViewModelProvider;
            private Provider<SendCompleteViewModel> sendCompleteViewModelProvider;
            private Provider<SendConfirmationViewModel> sendConfirmationViewModelProvider;

            private void initialize(ConfirmationFragment confirmationFragment) {
                this.sendCompleteViewModelProvider = SendCompleteViewModel_Factory.create(this.appComponent.currencyFormatterProvider);
                this.highMinerFeesPromptProvider = HighMinerFeesPrompt_Factory.create(this.appComponent.storeProvider);
                this.lendConfirmationViewModelProvider = LendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.highMinerFeesPromptProvider, this.appComponent.currencyFormatterProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.lendRepositoryProvider, this.appComponent.walletRepositoryProvider);
                this.sendConfirmationViewModelProvider = SendConfirmationViewModel_Factory.create(this.appComponent.authenticationHelperProvider, this.appComponent.currencyFormatterProvider, this.appComponent.walletRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.highMinerFeesPromptProvider);
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.lendAmountPickerViewModelProvider = LendAmountPickerViewModel_Factory.create(this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider, this.cloudBackupPromptProvider, this.appComponent.mnemonicBackupRepositoryProvider);
                this.sendAmountPickerViewModelProvider = SendAmountPickerViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider);
            }

            private ConfirmationFragment injectConfirmationFragment(ConfirmationFragment confirmationFragment) {
                dagger.android.g.i.a(confirmationFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConfirmationFragment_MembersInjector.injectViewModelFactory(confirmationFragment, viewModelFactoryWithMap());
                return confirmationFragment;
            }

            private Map<Class<? extends androidx.lifecycle.b0>, Provider<androidx.lifecycle.b0>> mapOfClassOfAndProviderOfViewModel() {
                return com.google.common.collect.m.a().c(WalletLinkCompleteViewModel.class, WalletLinkCompleteViewModel_Factory.create()).c(SendCompleteViewModel.class, this.sendCompleteViewModelProvider).c(LendConfirmationViewModel.class, this.lendConfirmationViewModelProvider).c(SendConfirmationViewModel.class, this.sendConfirmationViewModelProvider).c(LendAmountPickerViewModel.class, this.lendAmountPickerViewModelProvider).c(SendAmountPickerViewModel.class, this.sendAmountPickerViewModelProvider).a();
            }

            private ViewModelFactoryWithMap viewModelFactoryWithMap() {
                return new ViewModelFactoryWithMap(mapOfClassOfAndProviderOfViewModel());
            }

            private ConfirmationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConfirmationFragment confirmationFragment) {
                this.confirmationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(confirmationFragment);
            }

            @Override // dagger.android.b
            public void inject(ConfirmationFragment confirmationFragment) {
                injectConfirmationFragment(confirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAddCardFragmentSubcomponentFactory implements f0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerAddCardFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public f0 create(ConsumerAddCardFragment consumerAddCardFragment) {
                f.c.h.b(consumerAddCardFragment);
                return new ConsumerAddCardFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerAddCardFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAddCardFragmentSubcomponentImpl implements f0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerAddCardFragmentSubcomponentImpl consumerAddCardFragmentSubcomponentImpl;
            private Provider<ConsumerAddCardViewModel> consumerAddCardViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<ConsumerAddCardViewModel> genericViewModelFactoryOfConsumerAddCardViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerAddCardViewModelProvider));
            }

            private void initialize(ConsumerAddCardFragment consumerAddCardFragment) {
                this.consumerAddCardViewModelProvider = ConsumerAddCardViewModel_Factory.create(this.appComponent.consumerWebviewConfigProvider, this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerAddCardFragment injectConsumerAddCardFragment(ConsumerAddCardFragment consumerAddCardFragment) {
                dagger.android.g.i.a(consumerAddCardFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerAddCardFragment_MembersInjector.injectViewModelFactory(consumerAddCardFragment, genericViewModelFactoryOfConsumerAddCardViewModel());
                ConsumerAddCardFragment_MembersInjector.injectConsumerWebViewConfig(consumerAddCardFragment, (ConsumerWebViewConfig) f.c.h.e(this.appComponent.consumerCoreComponent.consumerWebviewConfig()));
                ConsumerAddCardFragment_MembersInjector.injectStore(consumerAddCardFragment, (StoreInterface) f.c.h.e(this.appComponent.appCoreComponent.store()));
                return consumerAddCardFragment;
            }

            private ConsumerAddCardFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerAddCardFragment consumerAddCardFragment) {
                this.consumerAddCardFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerAddCardFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerAddCardFragment consumerAddCardFragment) {
                injectConsumerAddCardFragment(consumerAddCardFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAmountPickerFragmentSubcomponentFactory implements g0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerAmountPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public g0 create(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
                f.c.h.b(consumerAmountPickerFragment);
                return new ConsumerAmountPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerAmountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAmountPickerFragmentSubcomponentImpl implements g0 {
            private Provider<AmountViewModel> amountViewModelProvider;
            private final DaggerAppComponent appComponent;
            private final ConsumerAmountPickerFragmentSubcomponentImpl consumerAmountPickerFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerAmountPickerViewModel_AssistedFactory consumerAmountPickerViewModel_AssistedFactory() {
                return new ConsumerAmountPickerViewModel_AssistedFactory(this.appComponent.fiatCurrencyRepositoryProvider, this.amountViewModelProvider, this.appComponent.walletRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.storeProvider, this.appComponent.consumerTransferRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider);
            }

            private void initialize(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
                this.amountViewModelProvider = AmountViewModel_Factory.create(this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private ConsumerAmountPickerFragment injectConsumerAmountPickerFragment(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
                dagger.android.g.i.a(consumerAmountPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerAmountPickerFragment_MembersInjector.injectViewModelFactory(consumerAmountPickerFragment, consumerAmountPickerViewModel_AssistedFactory());
                return consumerAmountPickerFragment;
            }

            private ConsumerAmountPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerAmountPickerFragment consumerAmountPickerFragment) {
                this.consumerAmountPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerAmountPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerAmountPickerFragment consumerAmountPickerFragment) {
                injectConsumerAmountPickerFragment(consumerAmountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAvailablePaymentMethodsFragmentSubcomponentFactory implements h0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerAvailablePaymentMethodsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.h0 create(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
                f.c.h.b(consumerAvailablePaymentMethodsFragment);
                return new ConsumerAvailablePaymentMethodsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerAvailablePaymentMethodsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerAvailablePaymentMethodsFragmentSubcomponentImpl implements com.toshi.view.activity.h0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerAvailablePaymentMethodsFragmentSubcomponentImpl consumerAvailablePaymentMethodsFragmentSubcomponentImpl;
            private Provider<ConsumerAvailablePaymentMethodsViewModel> consumerAvailablePaymentMethodsViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<ConsumerAvailablePaymentMethodsViewModel> genericViewModelFactoryOfConsumerAvailablePaymentMethodsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerAvailablePaymentMethodsViewModelProvider));
            }

            private void initialize(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
                this.consumerAvailablePaymentMethodsViewModelProvider = ConsumerAvailablePaymentMethodsViewModel_Factory.create(this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerAvailablePaymentMethodsFragment injectConsumerAvailablePaymentMethodsFragment(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
                dagger.android.g.i.a(consumerAvailablePaymentMethodsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerAvailablePaymentMethodsFragment_MembersInjector.injectViewModelFactory(consumerAvailablePaymentMethodsFragment, genericViewModelFactoryOfConsumerAvailablePaymentMethodsViewModel());
                return consumerAvailablePaymentMethodsFragment;
            }

            private ConsumerAvailablePaymentMethodsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
                this.consumerAvailablePaymentMethodsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerAvailablePaymentMethodsFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerAvailablePaymentMethodsFragment consumerAvailablePaymentMethodsFragment) {
                injectConsumerAvailablePaymentMethodsFragment(consumerAvailablePaymentMethodsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerCardCDVFragmentSubcomponentFactory implements i0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerCardCDVFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public i0 create(ConsumerCardCDVFragment consumerCardCDVFragment) {
                f.c.h.b(consumerCardCDVFragment);
                return new ConsumerCardCDVFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerCardCDVFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerCardCDVFragmentSubcomponentImpl implements i0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerCardCDVFragmentSubcomponentImpl consumerCardCDVFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerCardCDVViewModel_AssistedFactory consumerCardCDVViewModel_AssistedFactory() {
                return new ConsumerCardCDVViewModel_AssistedFactory(this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerCardCDVFragment injectConsumerCardCDVFragment(ConsumerCardCDVFragment consumerCardCDVFragment) {
                dagger.android.g.i.a(consumerCardCDVFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerCardCDVFragment_MembersInjector.injectViewModelFactory(consumerCardCDVFragment, consumerCardCDVViewModel_AssistedFactory());
                return consumerCardCDVFragment;
            }

            private ConsumerCardCDVFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerCardCDVFragment consumerCardCDVFragment) {
                this.consumerCardCDVFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerCardCDVFragment consumerCardCDVFragment) {
                injectConsumerCardCDVFragment(consumerCardCDVFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerFragmentSubcomponentFactory implements j0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public j0 create(ConsumerFragment consumerFragment) {
                f.c.h.b(consumerFragment);
                return new ConsumerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerFragmentSubcomponentImpl implements j0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerFragmentSubcomponentImpl consumerFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerAccountsViewModel_AssistedFactory consumerAccountsViewModel_AssistedFactory() {
                return new ConsumerAccountsViewModel_AssistedFactory(this.appComponent.consumerAccountsRepositoryProvider, this.appComponent.consumerUserRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.consumerTransferRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.walletRepositoryProvider);
            }

            private ConsumerFragment injectConsumerFragment(ConsumerFragment consumerFragment) {
                dagger.android.g.i.a(consumerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerFragment_MembersInjector.injectAccountsViewModelFactory(consumerFragment, consumerAccountsViewModel_AssistedFactory());
                return consumerFragment;
            }

            private ConsumerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerFragment consumerFragment) {
                this.consumerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerFragment consumerFragment) {
                injectConsumerFragment(consumerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerInterstitialFragmentSubcomponentFactory implements k0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerInterstitialFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public k0 create(ConsumerInterstitialFragment consumerInterstitialFragment) {
                f.c.h.b(consumerInterstitialFragment);
                return new ConsumerInterstitialFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerInterstitialFragmentSubcomponentImpl implements k0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerInterstitialFragmentSubcomponentImpl consumerInterstitialFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerInterstitialFragment injectConsumerInterstitialFragment(ConsumerInterstitialFragment consumerInterstitialFragment) {
                dagger.android.g.i.a(consumerInterstitialFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerInterstitialFragment_MembersInjector.injectConsumerInterstitialViewModelFactory(consumerInterstitialFragment, new ConsumerInterstitialViewModel_AssistedFactory());
                return consumerInterstitialFragment;
            }

            private ConsumerInterstitialFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerInterstitialFragment consumerInterstitialFragment) {
                this.consumerInterstitialFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerInterstitialFragment consumerInterstitialFragment) {
                injectConsumerInterstitialFragment(consumerInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerOnboardingFragmentSubcomponentFactory implements l0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerOnboardingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public l0 create(ConsumerOnboardingFragment consumerOnboardingFragment) {
                f.c.h.b(consumerOnboardingFragment);
                return new ConsumerOnboardingFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerOnboardingFragmentSubcomponentImpl implements l0 {
            private final DaggerAppComponent appComponent;
            private Provider<AppToAppAuthRepository> appToAppAuthRepositoryProvider;
            private Provider<ConsumerAppToAppViewModel> consumerAppToAppViewModelProvider;
            private final ConsumerOnboardingFragmentSubcomponentImpl consumerOnboardingFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<ConsumerAppToAppViewModel> genericViewModelFactoryOfConsumerAppToAppViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerAppToAppViewModelProvider));
            }

            private void initialize(ConsumerOnboardingFragment consumerOnboardingFragment) {
                this.appToAppAuthRepositoryProvider = AppToAppAuthRepository_Factory.create(this.appComponent.providesPackageManagerProvider, this.appComponent.buildConfigWrapperProvider);
                this.consumerAppToAppViewModelProvider = ConsumerAppToAppViewModel_Factory.create(this.appComponent.consumerUserRepositoryProvider, this.appToAppAuthRepositoryProvider, this.appComponent.providesPackageManagerProvider);
            }

            private ConsumerOnboardingFragment injectConsumerOnboardingFragment(ConsumerOnboardingFragment consumerOnboardingFragment) {
                dagger.android.g.i.a(consumerOnboardingFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerOnboardingFragment_MembersInjector.injectAppToAppViewModelFactory(consumerOnboardingFragment, genericViewModelFactoryOfConsumerAppToAppViewModel());
                ConsumerOnboardingFragment_MembersInjector.injectOnboardingViewModelFactory(consumerOnboardingFragment, new ConsumerOnboardingViewModel_AssistedFactory());
                ConsumerOnboardingFragment_MembersInjector.injectCoinbaseApi(consumerOnboardingFragment, (Coinbase) f.c.h.e(this.appComponent.consumerCoreComponent.coinbaseSdk()));
                ConsumerOnboardingFragment_MembersInjector.injectConsumerUserRepository(consumerOnboardingFragment, (ConsumerUserRepository) this.appComponent.consumerUserRepositoryProvider.get());
                ConsumerOnboardingFragment_MembersInjector.injectConsumerWebviewConfig(consumerOnboardingFragment, (ConsumerWebViewConfig) f.c.h.e(this.appComponent.consumerCoreComponent.consumerWebviewConfig()));
                return consumerOnboardingFragment;
            }

            private ConsumerOnboardingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerOnboardingFragment consumerOnboardingFragment) {
                this.consumerOnboardingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerOnboardingFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerOnboardingFragment consumerOnboardingFragment) {
                injectConsumerOnboardingFragment(consumerOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerSecure3DVerificationFragmentSubcomponentFactory implements m0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerSecure3DVerificationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public m0 create(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
                f.c.h.b(consumerSecure3DVerificationFragment);
                return new ConsumerSecure3DVerificationFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerSecure3DVerificationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerSecure3DVerificationFragmentSubcomponentImpl implements m0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerSecure3DVerificationFragmentSubcomponentImpl consumerSecure3DVerificationFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerSecure3DVerificationViewModel_AssistedFactory consumerSecure3DVerificationViewModel_AssistedFactory() {
                return new ConsumerSecure3DVerificationViewModel_AssistedFactory(this.appComponent.consumerWebviewConfigProvider);
            }

            private ConsumerSecure3DVerificationFragment injectConsumerSecure3DVerificationFragment(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
                dagger.android.g.i.a(consumerSecure3DVerificationFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerSecure3DVerificationFragment_MembersInjector.injectWebviewConfig(consumerSecure3DVerificationFragment, (ConsumerWebViewConfig) f.c.h.e(this.appComponent.consumerCoreComponent.consumerWebviewConfig()));
                ConsumerSecure3DVerificationFragment_MembersInjector.injectViewModelFactory(consumerSecure3DVerificationFragment, consumerSecure3DVerificationViewModel_AssistedFactory());
                return consumerSecure3DVerificationFragment;
            }

            private ConsumerSecure3DVerificationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
                this.consumerSecure3DVerificationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerSecure3DVerificationFragment consumerSecure3DVerificationFragment) {
                injectConsumerSecure3DVerificationFragment(consumerSecure3DVerificationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerSendTwoFactorFragmentSubcomponentFactory implements n0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerSendTwoFactorFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.n0 create(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
                f.c.h.b(consumerSendTwoFactorFragment);
                return new ConsumerSendTwoFactorFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerSendTwoFactorFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerSendTwoFactorFragmentSubcomponentImpl implements com.toshi.view.activity.n0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerSendTwoFactorFragmentSubcomponentImpl consumerSendTwoFactorFragmentSubcomponentImpl;
            private Provider<ConsumerSendTwoFactorViewModel> consumerSendTwoFactorViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<ConsumerSendTwoFactorViewModel> genericViewModelFactoryOfConsumerSendTwoFactorViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerSendTwoFactorViewModelProvider));
            }

            private void initialize(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
                this.consumerSendTwoFactorViewModelProvider = ConsumerSendTwoFactorViewModel_Factory.create(this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerSendTwoFactorFragment injectConsumerSendTwoFactorFragment(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
                dagger.android.g.i.a(consumerSendTwoFactorFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerSendTwoFactorFragment_MembersInjector.injectViewModelFactory(consumerSendTwoFactorFragment, genericViewModelFactoryOfConsumerSendTwoFactorViewModel());
                return consumerSendTwoFactorFragment;
            }

            private ConsumerSendTwoFactorFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
                this.consumerSendTwoFactorFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerSendTwoFactorFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerSendTwoFactorFragment consumerSendTwoFactorFragment) {
                injectConsumerSendTwoFactorFragment(consumerSendTwoFactorFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferConfirmationFragmentSubcomponentFactory implements o0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerTransferConfirmationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public o0 create(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
                f.c.h.b(consumerTransferConfirmationFragment);
                return new ConsumerTransferConfirmationFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerTransferConfirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferConfirmationFragmentSubcomponentImpl implements o0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerTransferConfirmationFragmentSubcomponentImpl consumerTransferConfirmationFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerTransferConfirmationViewModel_AssistedFactory consumerTransferConfirmationViewModel_AssistedFactory() {
                return new ConsumerTransferConfirmationViewModel_AssistedFactory(this.appComponent.consumerTransferRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private ConsumerTransferMethodsViewModel_AssistedFactory consumerTransferMethodsViewModel_AssistedFactory() {
                return new ConsumerTransferMethodsViewModel_AssistedFactory(this.appComponent.currencyFormatterProvider, this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerTransferConfirmationFragment injectConsumerTransferConfirmationFragment(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
                dagger.android.g.i.a(consumerTransferConfirmationFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerTransferConfirmationFragment_MembersInjector.injectViewModelFactory(consumerTransferConfirmationFragment, consumerTransferConfirmationViewModel_AssistedFactory());
                ConsumerTransferConfirmationFragment_MembersInjector.injectTransferMethodsViewModelFactory(consumerTransferConfirmationFragment, consumerTransferMethodsViewModel_AssistedFactory());
                return consumerTransferConfirmationFragment;
            }

            private ConsumerTransferConfirmationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
                this.consumerTransferConfirmationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment) {
                injectConsumerTransferConfirmationFragment(consumerTransferConfirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferInitiatedFragmentSubcomponentFactory implements p0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerTransferInitiatedFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public p0 create(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
                f.c.h.b(consumerTransferInitiatedFragment);
                return new ConsumerTransferInitiatedFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerTransferInitiatedFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferInitiatedFragmentSubcomponentImpl implements p0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerTransferInitiatedFragmentSubcomponentImpl consumerTransferInitiatedFragmentSubcomponentImpl;
            private Provider<ConsumerTransferInitiatedViewModel> consumerTransferInitiatedViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<ConsumerTransferInitiatedViewModel> genericViewModelFactoryOfConsumerTransferInitiatedViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerTransferInitiatedViewModelProvider));
            }

            private void initialize(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
                this.consumerTransferInitiatedViewModelProvider = ConsumerTransferInitiatedViewModel_Factory.create(this.appComponent.appReviewRepositoryProvider);
            }

            private ConsumerTransferInitiatedFragment injectConsumerTransferInitiatedFragment(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
                dagger.android.g.i.a(consumerTransferInitiatedFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ConsumerTransferInitiatedFragment_MembersInjector.injectViewModelFactory(consumerTransferInitiatedFragment, genericViewModelFactoryOfConsumerTransferInitiatedViewModel());
                return consumerTransferInitiatedFragment;
            }

            private ConsumerTransferInitiatedFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
                this.consumerTransferInitiatedFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(consumerTransferInitiatedFragment);
            }

            @Override // dagger.android.b
            public void inject(ConsumerTransferInitiatedFragment consumerTransferInitiatedFragment) {
                injectConsumerTransferInitiatedFragment(consumerTransferInitiatedFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferMethodsFragmentSubcomponentFactory implements q0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerTransferMethodsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public q0 create(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
                f.c.h.b(consumerTransferMethodsFragment);
                return new ConsumerTransferMethodsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, consumerTransferMethodsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ConsumerTransferMethodsFragmentSubcomponentImpl implements q0 {
            private final DaggerAppComponent appComponent;
            private final ConsumerTransferMethodsFragmentSubcomponentImpl consumerTransferMethodsFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ConsumerTransferMethodsViewModel_AssistedFactory consumerTransferMethodsViewModel_AssistedFactory() {
                return new ConsumerTransferMethodsViewModel_AssistedFactory(this.appComponent.currencyFormatterProvider, this.appComponent.consumerTransferRepositoryProvider);
            }

            private ConsumerTransferMethodsFragment injectConsumerTransferMethodsFragment(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
                ConsumerTransferMethodsFragment_MembersInjector.injectViewModelFactory(consumerTransferMethodsFragment, consumerTransferMethodsViewModel_AssistedFactory());
                return consumerTransferMethodsFragment;
            }

            private ConsumerTransferMethodsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
                this.consumerTransferMethodsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ConsumerTransferMethodsFragment consumerTransferMethodsFragment) {
                injectConsumerTransferMethodsFragment(consumerTransferMethodsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CurrencyFragmentSubcomponentFactory implements t0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CurrencyFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public t0 create(CurrencyFragment currencyFragment) {
                f.c.h.b(currencyFragment);
                return new CurrencyFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, currencyFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class CurrencyFragmentSubcomponentImpl implements t0 {
            private final DaggerAppComponent appComponent;
            private final CurrencyFragmentSubcomponentImpl currencyFragmentSubcomponentImpl;
            private Provider<e.j.n.f2> currencyViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.f2> genericViewModelFactoryOfCurrencyViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.currencyViewModelProvider));
            }

            private void initialize(CurrencyFragment currencyFragment) {
                this.currencyViewModelProvider = e.j.n.g2.a(this.appComponent.fiatCurrencyRepositoryProvider);
            }

            private CurrencyFragment injectCurrencyFragment(CurrencyFragment currencyFragment) {
                dagger.android.g.i.a(currencyFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.g0.a(currencyFragment, genericViewModelFactoryOfCurrencyViewModel());
                return currencyFragment;
            }

            private CurrencyFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CurrencyFragment currencyFragment) {
                this.currencyFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(currencyFragment);
            }

            @Override // dagger.android.b
            public void inject(CurrencyFragment currencyFragment) {
                injectCurrencyFragment(currencyFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DappNavFragmentSubcomponentFactory implements u0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private DappNavFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public u0 create(com.toshi.view.fragment.toplevel.c0 c0Var) {
                f.c.h.b(c0Var);
                return new DappNavFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, c0Var);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DappNavFragmentSubcomponentImpl implements u0 {
            private final DaggerAppComponent appComponent;
            private final DappNavFragmentSubcomponentImpl dappNavFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            @Override // dagger.android.b
            public void inject(com.toshi.view.fragment.toplevel.c0 c0Var) {
            }

            private DappNavFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, com.toshi.view.fragment.toplevel.c0 c0Var) {
                this.dappNavFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DappsFragmentSubcomponentFactory implements n2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private DappsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public n2 create(DappsFragment dappsFragment) {
                f.c.h.b(dappsFragment);
                return new DappsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, dappsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DappsFragmentSubcomponentImpl implements n2 {
            private final DaggerAppComponent appComponent;
            private final DappsFragmentSubcomponentImpl dappsFragmentSubcomponentImpl;
            private Provider<e.j.n.h2> dappsViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.h2> genericViewModelFactoryOfDappsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.dappsViewModelProvider));
            }

            private void initialize(DappsFragment dappsFragment) {
                this.dappsViewModelProvider = e.j.n.i2.a(this.appComponent.bookmarkRepositoryProvider, this.appComponent.cipherCoreProvider, this.appComponent.deepLinkRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.ethTxRepositoryProvider, this.appComponent.signerViewModelProvider, this.appComponent.ethWalletRepositoryProvider);
            }

            private DappsFragment injectDappsFragment(DappsFragment dappsFragment) {
                dagger.android.g.i.a(dappsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.toplevel.d0.g(dappsFragment, genericViewModelFactoryOfDappsViewModel());
                com.toshi.view.fragment.toplevel.d0.a(dappsFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.toplevel.d0.d(dappsFragment, (Moshi) f.c.h.e(this.appComponent.appCoreComponent.moshi()));
                com.toshi.view.fragment.toplevel.d0.b(dappsFragment, (e.j.l.o.a) f.c.h.e(this.appComponent.appCoreComponent.base64()));
                com.toshi.view.fragment.toplevel.d0.e(dappsFragment, (OkHttpClient) f.c.h.e(this.appComponent.appCoreComponent.okHttp()));
                com.toshi.view.fragment.toplevel.d0.f(dappsFragment, this.appComponent.mapOfRouteSchemeAndFunction1OfUriAndRouteAction());
                com.toshi.view.fragment.toplevel.d0.c(dappsFragment, (DeepLinkRepository) this.appComponent.deepLinkRepositoryProvider.get());
                return dappsFragment;
            }

            private DappsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, DappsFragment dappsFragment) {
                this.dappsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(dappsFragment);
            }

            @Override // dagger.android.b
            public void inject(DappsFragment dappsFragment) {
                injectDappsFragment(dappsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DebugMenuFragmentSubcomponentFactory implements v0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private DebugMenuFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public v0 create(DebugMenuFragment debugMenuFragment) {
                f.c.h.b(debugMenuFragment);
                return new DebugMenuFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, debugMenuFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DebugMenuFragmentSubcomponentImpl implements v0 {
            private final DaggerAppComponent appComponent;
            private final DebugMenuFragmentSubcomponentImpl debugMenuFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            @Override // dagger.android.b
            public void inject(DebugMenuFragment debugMenuFragment) {
            }

            private DebugMenuFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, DebugMenuFragment debugMenuFragment) {
                this.debugMenuFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DisplayCoinAddressFragmentSubcomponentFactory implements w0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private DisplayCoinAddressFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public w0 create(DisplayCoinAddressFragment displayCoinAddressFragment) {
                f.c.h.b(displayCoinAddressFragment);
                return new DisplayCoinAddressFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, displayCoinAddressFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class DisplayCoinAddressFragmentSubcomponentImpl implements w0 {
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private final DisplayCoinAddressFragmentSubcomponentImpl displayCoinAddressFragmentSubcomponentImpl;
            private Provider<e.j.n.j2> displayCoinAddressViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.j2> genericViewModelFactoryOfDisplayCoinAddressViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.displayCoinAddressViewModelProvider));
            }

            private void initialize(DisplayCoinAddressFragment displayCoinAddressFragment) {
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.displayCoinAddressViewModelProvider = e.j.n.k2.a(this.appComponent.userRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.cloudBackupPromptProvider);
            }

            private DisplayCoinAddressFragment injectDisplayCoinAddressFragment(DisplayCoinAddressFragment displayCoinAddressFragment) {
                dagger.android.g.i.a(displayCoinAddressFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.j0.b(displayCoinAddressFragment, genericViewModelFactoryOfDisplayCoinAddressViewModel());
                com.toshi.view.fragment.j0.a(displayCoinAddressFragment, (com.toshi.view.fragment.h0) this.appComponent.displayCoinAddressFragmentFactoryProvider.get());
                return displayCoinAddressFragment;
            }

            private DisplayCoinAddressFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, DisplayCoinAddressFragment displayCoinAddressFragment) {
                this.displayCoinAddressFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(displayCoinAddressFragment);
            }

            @Override // dagger.android.b
            public void inject(DisplayCoinAddressFragment displayCoinAddressFragment) {
                injectDisplayCoinAddressFragment(displayCoinAddressFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class HomeFragmentSubcomponentFactory implements j2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private HomeFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public j2 create(HomeFragment homeFragment) {
                f.c.h.b(homeFragment);
                return new HomeFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, homeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class HomeFragmentSubcomponentImpl implements j2 {
            private final DaggerAppComponent appComponent;
            private final HomeFragmentSubcomponentImpl homeFragmentSubcomponentImpl;
            private Provider<e.j.n.l2> homeViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<e.j.h.a.j> qRScannerViewModelProvider;

            private GenericViewModelFactory<e.j.n.l2> genericViewModelFactoryOfHomeViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.homeViewModelProvider));
            }

            private GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactoryOfLoadingPillViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(LoadingPillViewModel_Factory.create()));
            }

            private GenericViewModelFactory<e.j.h.a.j> genericViewModelFactoryOfQRScannerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.qRScannerViewModelProvider));
            }

            private GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactoryOfScrolledToTopViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(ScrolledToTopViewModel_Factory.create()));
            }

            private void initialize(HomeFragment homeFragment) {
                this.homeViewModelProvider = f.c.c.b(e.j.n.m2.a(this.appComponent.userRepositoryProvider, this.appComponent.collectibleTypesRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.lendRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.featureFlagsRepositoryProvider, this.appComponent.consumerUserRepositoryProvider, this.appComponent.appPrefsProvider, this.appComponent.refreshServiceProvider, this.appComponent.walletRepositoryProvider));
                this.qRScannerViewModelProvider = e.j.h.a.k.a(this.appComponent.walletRepositoryProvider);
            }

            private HomeFragment injectHomeFragment(HomeFragment homeFragment) {
                dagger.android.g.i.a(homeFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                HomeFragment_MembersInjector.injectViewModelFactory(homeFragment, genericViewModelFactoryOfHomeViewModel());
                HomeFragment_MembersInjector.injectLoadingPillViewModelFactory(homeFragment, genericViewModelFactoryOfLoadingPillViewModel());
                HomeFragment_MembersInjector.injectScrolledToTopViewModelFactory(homeFragment, genericViewModelFactoryOfScrolledToTopViewModel());
                HomeFragment_MembersInjector.injectQrScannerViewModelFactory(homeFragment, genericViewModelFactoryOfQRScannerViewModel());
                return homeFragment;
            }

            private HomeFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, HomeFragment homeFragment) {
                this.homeFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(homeFragment);
            }

            @Override // dagger.android.b
            public void inject(HomeFragment homeFragment) {
                injectHomeFragment(homeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LegalFragmentSubcomponentFactory implements x0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LegalFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public x0 create(LegalFragment legalFragment) {
                f.c.h.b(legalFragment);
                return new LegalFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, legalFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LegalFragmentSubcomponentImpl implements x0 {
            private final DaggerAppComponent appComponent;
            private final LegalFragmentSubcomponentImpl legalFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LegalFragment injectLegalFragment(LegalFragment legalFragment) {
                dagger.android.g.i.a(legalFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return legalFragment;
            }

            private LegalFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LegalFragment legalFragment) {
                this.legalFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LegalFragment legalFragment) {
                injectLegalFragment(legalFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendCoinPickerFragmentSubcomponentFactory implements z0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LendCoinPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public z0 create(LendCoinPickerFragment lendCoinPickerFragment) {
                f.c.h.b(lendCoinPickerFragment);
                return new LendCoinPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, lendCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendCoinPickerFragmentSubcomponentImpl implements z0 {
            private final DaggerAppComponent appComponent;
            private final LendCoinPickerFragmentSubcomponentImpl lendCoinPickerFragmentSubcomponentImpl;
            private Provider<LendCoinPickerViewModel> lendCoinPickerViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<LendCoinPickerViewModel> genericViewModelFactoryOfLendCoinPickerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.lendCoinPickerViewModelProvider));
            }

            private void initialize(LendCoinPickerFragment lendCoinPickerFragment) {
                this.lendCoinPickerViewModelProvider = LendCoinPickerViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.lendRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.appComponent.consumerUserRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private LendCoinPickerFragment injectLendCoinPickerFragment(LendCoinPickerFragment lendCoinPickerFragment) {
                dagger.android.g.i.a(lendCoinPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                LendCoinPickerFragment_MembersInjector.injectLendCoinPickerViewModelFactory(lendCoinPickerFragment, genericViewModelFactoryOfLendCoinPickerViewModel());
                return lendCoinPickerFragment;
            }

            private LendCoinPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LendCoinPickerFragment lendCoinPickerFragment) {
                this.lendCoinPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(lendCoinPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(LendCoinPickerFragment lendCoinPickerFragment) {
                injectLendCoinPickerFragment(lendCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendDashboardFragmentSubcomponentFactory implements a1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LendDashboardFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public a1 create(LendDashboardFragment lendDashboardFragment) {
                f.c.h.b(lendDashboardFragment);
                return new LendDashboardFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, lendDashboardFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendDashboardFragmentSubcomponentImpl implements a1 {
            private final DaggerAppComponent appComponent;
            private final LendDashboardFragmentSubcomponentImpl lendDashboardFragmentSubcomponentImpl;
            private Provider<LendDashboardViewModel> lendDashboardViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<LendDashboardViewModel> genericViewModelFactoryOfLendDashboardViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.lendDashboardViewModelProvider));
            }

            private void initialize(LendDashboardFragment lendDashboardFragment) {
                this.lendDashboardViewModelProvider = LendDashboardViewModel_Factory.create(this.appComponent.txHistoryRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.lendRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.cipherCoreProvider);
            }

            private LendDashboardFragment injectLendDashboardFragment(LendDashboardFragment lendDashboardFragment) {
                dagger.android.g.i.a(lendDashboardFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                LendDashboardFragment_MembersInjector.injectViewModelFactory(lendDashboardFragment, genericViewModelFactoryOfLendDashboardViewModel());
                return lendDashboardFragment;
            }

            private LendDashboardFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LendDashboardFragment lendDashboardFragment) {
                this.lendDashboardFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(lendDashboardFragment);
            }

            @Override // dagger.android.b
            public void inject(LendDashboardFragment lendDashboardFragment) {
                injectLendDashboardFragment(lendDashboardFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendInterstitialFragmentSubcomponentFactory implements b1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LendInterstitialFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public b1 create(LendInterstitialFragment lendInterstitialFragment) {
                f.c.h.b(lendInterstitialFragment);
                return new LendInterstitialFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, lendInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendInterstitialFragmentSubcomponentImpl implements b1 {
            private final DaggerAppComponent appComponent;
            private final LendInterstitialFragmentSubcomponentImpl lendInterstitialFragmentSubcomponentImpl;
            private Provider<LendViewModel> lendViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<LendViewModel> genericViewModelFactoryOfLendViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.lendViewModelProvider));
            }

            private void initialize(LendInterstitialFragment lendInterstitialFragment) {
                this.lendViewModelProvider = LendViewModel_Factory.create(this.appComponent.lendRepositoryProvider, this.appComponent.txHistoryRepositoryProvider, this.appComponent.storeProvider);
            }

            private LendInterstitialFragment injectLendInterstitialFragment(LendInterstitialFragment lendInterstitialFragment) {
                dagger.android.g.i.a(lendInterstitialFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                LendInterstitialFragment_MembersInjector.injectLendViewModelFactory(lendInterstitialFragment, genericViewModelFactoryOfLendViewModel());
                return lendInterstitialFragment;
            }

            private LendInterstitialFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LendInterstitialFragment lendInterstitialFragment) {
                this.lendInterstitialFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(lendInterstitialFragment);
            }

            @Override // dagger.android.b
            public void inject(LendInterstitialFragment lendInterstitialFragment) {
                injectLendInterstitialFragment(lendInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendProviderPickerFragmentSubcomponentFactory implements c1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LendProviderPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public c1 create(LendProviderPickerFragment lendProviderPickerFragment) {
                f.c.h.b(lendProviderPickerFragment);
                return new LendProviderPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, lendProviderPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendProviderPickerFragmentSubcomponentImpl implements c1 {
            private final DaggerAppComponent appComponent;
            private final LendProviderPickerFragmentSubcomponentImpl lendProviderPickerFragmentSubcomponentImpl;
            private Provider<LendProviderPickerViewModel> lendProviderPickerViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<LendProviderPickerViewModel> genericViewModelFactoryOfLendProviderPickerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.lendProviderPickerViewModelProvider));
            }

            private void initialize(LendProviderPickerFragment lendProviderPickerFragment) {
                this.lendProviderPickerViewModelProvider = LendProviderPickerViewModel_Factory.create(this.appComponent.featureFlagsRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private LendProviderPickerFragment injectLendProviderPickerFragment(LendProviderPickerFragment lendProviderPickerFragment) {
                dagger.android.g.i.a(lendProviderPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                LendProviderPickerFragment_MembersInjector.injectLendProviderPickerViewModelFactory(lendProviderPickerFragment, genericViewModelFactoryOfLendProviderPickerViewModel());
                return lendProviderPickerFragment;
            }

            private LendProviderPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LendProviderPickerFragment lendProviderPickerFragment) {
                this.lendProviderPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(lendProviderPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(LendProviderPickerFragment lendProviderPickerFragment) {
                injectLendProviderPickerFragment(lendProviderPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendUserAgreementFragmentSubcomponentFactory implements d1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LendUserAgreementFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public d1 create(LendUserAgreementFragment lendUserAgreementFragment) {
                f.c.h.b(lendUserAgreementFragment);
                return new LendUserAgreementFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, lendUserAgreementFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LendUserAgreementFragmentSubcomponentImpl implements d1 {
            private final DaggerAppComponent appComponent;
            private final LendUserAgreementFragmentSubcomponentImpl lendUserAgreementFragmentSubcomponentImpl;
            private Provider<LendUserAgreementViewModel> lendUserAgreementViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<LendUserAgreementViewModel> genericViewModelFactoryOfLendUserAgreementViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.lendUserAgreementViewModelProvider));
            }

            private void initialize(LendUserAgreementFragment lendUserAgreementFragment) {
                this.lendUserAgreementViewModelProvider = LendUserAgreementViewModel_Factory.create(this.appComponent.storeProvider, this.appComponent.txHistoryRepositoryProvider, this.appComponent.lendRepositoryProvider);
            }

            private LendUserAgreementFragment injectLendUserAgreementFragment(LendUserAgreementFragment lendUserAgreementFragment) {
                dagger.android.g.i.a(lendUserAgreementFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                LendUserAgreementFragment_MembersInjector.injectUserAgreementViewModelFactory(lendUserAgreementFragment, genericViewModelFactoryOfLendUserAgreementViewModel());
                return lendUserAgreementFragment;
            }

            private LendUserAgreementFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LendUserAgreementFragment lendUserAgreementFragment) {
                this.lendUserAgreementFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(lendUserAgreementFragment);
            }

            @Override // dagger.android.b
            public void inject(LendUserAgreementFragment lendUserAgreementFragment) {
                injectLendUserAgreementFragment(lendUserAgreementFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LicenseFragmentSubcomponentFactory implements e1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LicenseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public e1 create(LicenseFragment licenseFragment) {
                f.c.h.b(licenseFragment);
                return new LicenseFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, licenseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LicenseFragmentSubcomponentImpl implements e1 {
            private final DaggerAppComponent appComponent;
            private final LicenseFragmentSubcomponentImpl licenseFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LicenseFragment injectLicenseFragment(LicenseFragment licenseFragment) {
                dagger.android.g.i.a(licenseFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return licenseFragment;
            }

            private LicenseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LicenseFragment licenseFragment) {
                this.licenseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LicenseFragment licenseFragment) {
                injectLicenseFragment(licenseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LicenseListFragmentSubcomponentFactory implements f1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LicenseListFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public f1 create(LicenseListFragment licenseListFragment) {
                f.c.h.b(licenseListFragment);
                return new LicenseListFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, licenseListFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LicenseListFragmentSubcomponentImpl implements f1 {
            private final DaggerAppComponent appComponent;
            private final LicenseListFragmentSubcomponentImpl licenseListFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LicenseListFragment injectLicenseListFragment(LicenseListFragment licenseListFragment) {
                dagger.android.g.i.a(licenseListFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return licenseListFragment;
            }

            private LicenseListFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LicenseListFragment licenseListFragment) {
                this.licenseListFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LicenseListFragment licenseListFragment) {
                injectLicenseListFragment(licenseListFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory implements y.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public y create(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                f.c.h.b(backupRecoveryPhraseFragment);
                return new MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl implements y {
            private final DaggerAppComponent appComponent;
            private Provider<BackupRecoveryPhraseViewModel> backupRecoveryPhraseViewModelProvider;
            private final MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl mAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactoryOfBackupRecoveryPhraseViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.backupRecoveryPhraseViewModelProvider));
            }

            private void initialize(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.backupRecoveryPhraseViewModelProvider = BackupRecoveryPhraseViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private BackupRecoveryPhraseFragment injectBackupRecoveryPhraseFragment(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                dagger.android.g.i.a(backupRecoveryPhraseFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                BackupRecoveryPhraseFragment_MembersInjector.injectAuthenticationHelper(backupRecoveryPhraseFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                BackupRecoveryPhraseFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(backupRecoveryPhraseFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                BackupRecoveryPhraseFragment_MembersInjector.injectViewModelFactory(backupRecoveryPhraseFragment, genericViewModelFactoryOfBackupRecoveryPhraseViewModel());
                return backupRecoveryPhraseFragment;
            }

            private MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.mAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(backupRecoveryPhraseFragment);
            }

            @Override // dagger.android.b
            public void inject(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                injectBackupRecoveryPhraseFragment(backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_CPF_CreatePasswordFragmentSubcomponentFactory implements r0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_CPF_CreatePasswordFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public r0 create(CreatePasswordFragment createPasswordFragment) {
                f.c.h.b(createPasswordFragment);
                return new MAFBM_CPF_CreatePasswordFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, createPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_CPF_CreatePasswordFragmentSubcomponentImpl implements r0 {
            private final DaggerAppComponent appComponent;
            private Provider<CreatePasswordViewModel> createPasswordViewModelProvider;
            private final MAFBM_CPF_CreatePasswordFragmentSubcomponentImpl mAFBM_CPF_CreatePasswordFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private GenericViewModelFactory<CreatePasswordViewModel> genericViewModelFactoryOfCreatePasswordViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.createPasswordViewModelProvider));
            }

            private void initialize(CreatePasswordFragment createPasswordFragment) {
                this.createPasswordViewModelProvider = CreatePasswordViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private CreatePasswordFragment injectCreatePasswordFragment(CreatePasswordFragment createPasswordFragment) {
                dagger.android.g.i.a(createPasswordFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                CreatePasswordFragment_MembersInjector.injectViewModelFactory(createPasswordFragment, genericViewModelFactoryOfCreatePasswordViewModel());
                return createPasswordFragment;
            }

            private MAFBM_CPF_CreatePasswordFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CreatePasswordFragment createPasswordFragment) {
                this.mAFBM_CPF_CreatePasswordFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(createPasswordFragment);
            }

            @Override // dagger.android.b
            public void inject(CreatePasswordFragment createPasswordFragment) {
                injectCreatePasswordFragment(createPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory implements s0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public s0 create(CreatePasswordInfoFragment createPasswordInfoFragment) {
                f.c.h.b(createPasswordInfoFragment);
                return new MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, createPasswordInfoFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl implements s0 {
            private final DaggerAppComponent appComponent;
            private final MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl mAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private CreatePasswordInfoFragment injectCreatePasswordInfoFragment(CreatePasswordInfoFragment createPasswordInfoFragment) {
                dagger.android.g.i.a(createPasswordInfoFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return createPasswordInfoFragment;
            }

            private MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, CreatePasswordInfoFragment createPasswordInfoFragment) {
                this.mAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(CreatePasswordInfoFragment createPasswordInfoFragment) {
                injectCreatePasswordInfoFragment(createPasswordInfoFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_LVF_LegalViewFragmentSubcomponentFactory implements y0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_LVF_LegalViewFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public y0 create(LegalViewFragment legalViewFragment) {
                f.c.h.b(legalViewFragment);
                return new MAFBM_LVF_LegalViewFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, legalViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_LVF_LegalViewFragmentSubcomponentImpl implements y0 {
            private final DaggerAppComponent appComponent;
            private final MAFBM_LVF_LegalViewFragmentSubcomponentImpl mAFBM_LVF_LegalViewFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private LegalViewFragment injectLegalViewFragment(LegalViewFragment legalViewFragment) {
                dagger.android.g.i.a(legalViewFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return legalViewFragment;
            }

            private MAFBM_LVF_LegalViewFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, LegalViewFragment legalViewFragment) {
                this.mAFBM_LVF_LegalViewFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LegalViewFragment legalViewFragment) {
                injectLegalViewFragment(legalViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_MBF_ManualBackupFragmentSubcomponentFactory implements g1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_MBF_ManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public g1 create(ManualBackupFragment manualBackupFragment) {
                f.c.h.b(manualBackupFragment);
                return new MAFBM_MBF_ManualBackupFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_MBF_ManualBackupFragmentSubcomponentImpl implements g1 {
            private final DaggerAppComponent appComponent;
            private final MAFBM_MBF_ManualBackupFragmentSubcomponentImpl mAFBM_MBF_ManualBackupFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ManualBackupFragment injectManualBackupFragment(ManualBackupFragment manualBackupFragment) {
                dagger.android.g.i.a(manualBackupFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ManualBackupFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(manualBackupFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                return manualBackupFragment;
            }

            private MAFBM_MBF_ManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ManualBackupFragment manualBackupFragment) {
                this.mAFBM_MBF_ManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ManualBackupFragment manualBackupFragment) {
                injectManualBackupFragment(manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory implements g2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.g2 create(VerifyManualBackupFragment verifyManualBackupFragment) {
                f.c.h.b(verifyManualBackupFragment);
                return new MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl implements com.toshi.view.activity.g2 {
            private final DaggerAppComponent appComponent;
            private final MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl mAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<i3> verifyManualBackupViewModelProvider;

            private GenericViewModelFactory<i3> genericViewModelFactoryOfVerifyManualBackupViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.verifyManualBackupViewModelProvider));
            }

            private void initialize(VerifyManualBackupFragment verifyManualBackupFragment) {
                this.verifyManualBackupViewModelProvider = j3.a(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private VerifyManualBackupFragment injectVerifyManualBackupFragment(VerifyManualBackupFragment verifyManualBackupFragment) {
                dagger.android.g.i.a(verifyManualBackupFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                VerifyManualBackupFragment_MembersInjector.injectViewModelFactory(verifyManualBackupFragment, genericViewModelFactoryOfVerifyManualBackupViewModel());
                return verifyManualBackupFragment;
            }

            private MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, VerifyManualBackupFragment verifyManualBackupFragment) {
                this.mAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(verifyManualBackupFragment);
            }

            @Override // dagger.android.b
            public void inject(VerifyManualBackupFragment verifyManualBackupFragment) {
                injectVerifyManualBackupFragment(verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MessageSignerFragmentSubcomponentFactory implements h1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private MessageSignerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public h1 create(MessageSignerFragment messageSignerFragment) {
                f.c.h.b(messageSignerFragment);
                return new MessageSignerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, messageSignerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class MessageSignerFragmentSubcomponentImpl implements h1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final MessageSignerFragmentSubcomponentImpl messageSignerFragmentSubcomponentImpl;
            private Provider<MessageSignerViewModel> messageSignerViewModelProvider;

            private GenericViewModelFactory<MessageSignerViewModel> genericViewModelFactoryOfMessageSignerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.messageSignerViewModelProvider));
            }

            private void initialize(MessageSignerFragment messageSignerFragment) {
                this.messageSignerViewModelProvider = MessageSignerViewModel_Factory.create(this.appComponent.cipherCoreProvider, this.appComponent.ethWalletRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.walletLinkRepositoryProvider, this.appComponent.authenticationHelperProvider);
            }

            private MessageSignerFragment injectMessageSignerFragment(MessageSignerFragment messageSignerFragment) {
                dagger.android.g.e.a(messageSignerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                MessageSignerFragment_MembersInjector.injectViewModelFactory(messageSignerFragment, genericViewModelFactoryOfMessageSignerViewModel());
                return messageSignerFragment;
            }

            private MessageSignerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, MessageSignerFragment messageSignerFragment) {
                this.messageSignerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(messageSignerFragment);
            }

            @Override // dagger.android.b
            public void inject(MessageSignerFragment messageSignerFragment) {
                injectMessageSignerFragment(messageSignerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class NetworkSwitcherFragmentSubcomponentFactory implements i1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private NetworkSwitcherFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public i1 create(NetworkSwitcherFragment networkSwitcherFragment) {
                f.c.h.b(networkSwitcherFragment);
                return new NetworkSwitcherFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, networkSwitcherFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class NetworkSwitcherFragmentSubcomponentImpl implements i1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final NetworkSwitcherFragmentSubcomponentImpl networkSwitcherFragmentSubcomponentImpl;
            private Provider<s2> networkSwitcherViewModelProvider;

            private GenericViewModelFactory<s2> genericViewModelFactoryOfNetworkSwitcherViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.networkSwitcherViewModelProvider));
            }

            private void initialize(NetworkSwitcherFragment networkSwitcherFragment) {
                this.networkSwitcherViewModelProvider = t2.a(this.appComponent.walletRepositoryProvider, this.appComponent.networkSettingsProvider, this.appComponent.featureFlagsRepositoryProvider);
            }

            private NetworkSwitcherFragment injectNetworkSwitcherFragment(NetworkSwitcherFragment networkSwitcherFragment) {
                dagger.android.g.i.a(networkSwitcherFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.l0.b(networkSwitcherFragment, genericViewModelFactoryOfNetworkSwitcherViewModel());
                com.toshi.view.fragment.l0.a(networkSwitcherFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                return networkSwitcherFragment;
            }

            private NetworkSwitcherFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, NetworkSwitcherFragment networkSwitcherFragment) {
                this.networkSwitcherFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(networkSwitcherFragment);
            }

            @Override // dagger.android.b
            public void inject(NetworkSwitcherFragment networkSwitcherFragment) {
                injectNetworkSwitcherFragment(networkSwitcherFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ParentRequestEthereumAccountsFragmentSubcomponentFactory implements j1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ParentRequestEthereumAccountsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public j1 create(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
                f.c.h.b(parentRequestEthereumAccountsFragment);
                return new ParentRequestEthereumAccountsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, parentRequestEthereumAccountsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ParentRequestEthereumAccountsFragmentSubcomponentImpl implements j1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final ParentRequestEthereumAccountsFragmentSubcomponentImpl parentRequestEthereumAccountsFragmentSubcomponentImpl;
            private Provider<ParentRequestEthereumAccountsViewModel> parentRequestEthereumAccountsViewModelProvider;

            private GenericViewModelFactory<ParentRequestEthereumAccountsViewModel> genericViewModelFactoryOfParentRequestEthereumAccountsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.parentRequestEthereumAccountsViewModelProvider));
            }

            private void initialize(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
                this.parentRequestEthereumAccountsViewModelProvider = ParentRequestEthereumAccountsViewModel_Factory.create(this.appComponent.walletLinkRepositoryProvider);
            }

            private ParentRequestEthereumAccountsFragment injectParentRequestEthereumAccountsFragment(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
                dagger.android.g.e.a(parentRequestEthereumAccountsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ParentRequestEthereumAccountsFragment_MembersInjector.injectViewModelFactory(parentRequestEthereumAccountsFragment, genericViewModelFactoryOfParentRequestEthereumAccountsViewModel());
                return parentRequestEthereumAccountsFragment;
            }

            private ParentRequestEthereumAccountsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
                this.parentRequestEthereumAccountsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(parentRequestEthereumAccountsFragment);
            }

            @Override // dagger.android.b
            public void inject(ParentRequestEthereumAccountsFragment parentRequestEthereumAccountsFragment) {
                injectParentRequestEthereumAccountsFragment(parentRequestEthereumAccountsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ReceiveCoinPickerFragmentSubcomponentFactory implements k1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ReceiveCoinPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public k1 create(ReceiveCoinPickerFragment receiveCoinPickerFragment) {
                f.c.h.b(receiveCoinPickerFragment);
                return new ReceiveCoinPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, receiveCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ReceiveCoinPickerFragmentSubcomponentImpl implements k1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final ReceiveCoinPickerFragmentSubcomponentImpl receiveCoinPickerFragmentSubcomponentImpl;
            private Provider<y2> receiveCoinPickerViewModelProvider;

            private GenericViewModelFactory<y2> genericViewModelFactoryOfReceiveCoinPickerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.receiveCoinPickerViewModelProvider));
            }

            private void initialize(ReceiveCoinPickerFragment receiveCoinPickerFragment) {
                this.receiveCoinPickerViewModelProvider = z2.a(this.appComponent.walletRepositoryProvider);
            }

            private ReceiveCoinPickerFragment injectReceiveCoinPickerFragment(ReceiveCoinPickerFragment receiveCoinPickerFragment) {
                dagger.android.g.i.a(receiveCoinPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.m0.b(receiveCoinPickerFragment, genericViewModelFactoryOfReceiveCoinPickerViewModel());
                com.toshi.view.fragment.m0.a(receiveCoinPickerFragment, (com.toshi.view.fragment.h0) this.appComponent.displayCoinAddressFragmentFactoryProvider.get());
                return receiveCoinPickerFragment;
            }

            private ReceiveCoinPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ReceiveCoinPickerFragment receiveCoinPickerFragment) {
                this.receiveCoinPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(receiveCoinPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(ReceiveCoinPickerFragment receiveCoinPickerFragment) {
                injectReceiveCoinPickerFragment(receiveCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class RequestEthereumAccountsFragmentSubcomponentFactory implements l1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private RequestEthereumAccountsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public l1 create(RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
                f.c.h.b(requestEthereumAccountsFragment);
                return new RequestEthereumAccountsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, requestEthereumAccountsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class RequestEthereumAccountsFragmentSubcomponentImpl implements l1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final RequestEthereumAccountsFragmentSubcomponentImpl requestEthereumAccountsFragmentSubcomponentImpl;
            private Provider<RequestEthereumAccountsViewModel> requestEthereumAccountsViewModelProvider;

            private GenericViewModelFactory<RequestEthereumAccountsViewModel> genericViewModelFactoryOfRequestEthereumAccountsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.requestEthereumAccountsViewModelProvider));
            }

            private void initialize(RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
                this.requestEthereumAccountsViewModelProvider = RequestEthereumAccountsViewModel_Factory.create(this.appComponent.walletLinkRepositoryProvider);
            }

            private RequestEthereumAccountsFragment injectRequestEthereumAccountsFragment(RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
                dagger.android.g.e.a(requestEthereumAccountsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                RequestEthereumAccountsFragment_MembersInjector.injectViewModelFactory(requestEthereumAccountsFragment, genericViewModelFactoryOfRequestEthereumAccountsViewModel());
                return requestEthereumAccountsFragment;
            }

            private RequestEthereumAccountsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
                this.requestEthereumAccountsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(requestEthereumAccountsFragment);
            }

            @Override // dagger.android.b
            public void inject(RequestEthereumAccountsFragment requestEthereumAccountsFragment) {
                injectRequestEthereumAccountsFragment(requestEthereumAccountsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SendCoinPickerFragmentSubcomponentFactory implements o1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SendCoinPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public o1 create(SendCoinPickerFragment sendCoinPickerFragment) {
                f.c.h.b(sendCoinPickerFragment);
                return new SendCoinPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, sendCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SendCoinPickerFragmentSubcomponentImpl implements o1 {
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SendCoinPickerFragmentSubcomponentImpl sendCoinPickerFragmentSubcomponentImpl;
            private Provider<WalletsTabViewModel> walletsTabViewModelProvider;

            private GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactoryOfWalletsTabViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.walletsTabViewModelProvider));
            }

            private void initialize(SendCoinPickerFragment sendCoinPickerFragment) {
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.walletsTabViewModelProvider = WalletsTabViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.txHistoryRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.appPrefsProvider, this.appComponent.currencyFormatterProvider, this.appComponent.networkSettingsProvider, this.cloudBackupPromptProvider, this.appComponent.consumerUserRepositoryProvider);
            }

            private SendCoinPickerFragment injectSendCoinPickerFragment(SendCoinPickerFragment sendCoinPickerFragment) {
                dagger.android.g.i.a(sendCoinPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SendCoinPickerFragment_MembersInjector.injectViewModelFactory(sendCoinPickerFragment, genericViewModelFactoryOfWalletsTabViewModel());
                return sendCoinPickerFragment;
            }

            private SendCoinPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SendCoinPickerFragment sendCoinPickerFragment) {
                this.sendCoinPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(sendCoinPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(SendCoinPickerFragment sendCoinPickerFragment) {
                injectSendCoinPickerFragment(sendCoinPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SendDestinationPickerFragmentSubcomponentFactory implements q1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SendDestinationPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public q1 create(SendDestinationPickerFragment sendDestinationPickerFragment) {
                f.c.h.b(sendDestinationPickerFragment);
                return new SendDestinationPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, sendDestinationPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SendDestinationPickerFragmentSubcomponentImpl implements q1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<e.j.h.a.j> qRScannerViewModelProvider;
            private final SendDestinationPickerFragmentSubcomponentImpl sendDestinationPickerFragmentSubcomponentImpl;
            private Provider<SendDestinationPickerViewModel> sendDestinationPickerViewModelProvider;

            private GenericViewModelFactory<e.j.h.a.j> genericViewModelFactoryOfQRScannerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.qRScannerViewModelProvider));
            }

            private GenericViewModelFactory<SendDestinationPickerViewModel> genericViewModelFactoryOfSendDestinationPickerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.sendDestinationPickerViewModelProvider));
            }

            private void initialize(SendDestinationPickerFragment sendDestinationPickerFragment) {
                this.sendDestinationPickerViewModelProvider = SendDestinationPickerViewModel_Factory.create(this.appComponent.txRepositoryProvider, this.appComponent.recipientRepositoryProvider, this.appComponent.contextProvider);
                this.qRScannerViewModelProvider = e.j.h.a.k.a(this.appComponent.walletRepositoryProvider);
            }

            private SendDestinationPickerFragment injectSendDestinationPickerFragment(SendDestinationPickerFragment sendDestinationPickerFragment) {
                dagger.android.g.i.a(sendDestinationPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SendDestinationPickerFragment_MembersInjector.injectViewModelFactory(sendDestinationPickerFragment, genericViewModelFactoryOfSendDestinationPickerViewModel());
                SendDestinationPickerFragment_MembersInjector.injectQrScannerViewModelFactory(sendDestinationPickerFragment, genericViewModelFactoryOfQRScannerViewModel());
                return sendDestinationPickerFragment;
            }

            private SendDestinationPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SendDestinationPickerFragment sendDestinationPickerFragment) {
                this.sendDestinationPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(sendDestinationPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(SendDestinationPickerFragment sendDestinationPickerFragment) {
                injectSendDestinationPickerFragment(sendDestinationPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SettingsFragmentSubcomponentFactory implements s1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SettingsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public s1 create(SettingsFragment settingsFragment) {
                f.c.h.b(settingsFragment);
                return new SettingsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, settingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SettingsFragmentSubcomponentImpl implements s1 {
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private Provider<ConsumerSettingViewModel> consumerSettingViewModelProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SettingsFragmentSubcomponentImpl settingsFragmentSubcomponentImpl;
            private Provider<b3> settingsViewModelProvider;

            private GenericViewModelFactory<ConsumerSettingViewModel> genericViewModelFactoryOfConsumerSettingViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.consumerSettingViewModelProvider));
            }

            private GenericViewModelFactory<b3> genericViewModelFactoryOfSettingsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.settingsViewModelProvider));
            }

            private void initialize(SettingsFragment settingsFragment) {
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.settingsViewModelProvider = c3.a(this.appComponent.userRepositoryProvider, this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.walletLinkRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.cloudBackupPromptProvider, this.appComponent.walletRepositoryProvider);
                this.consumerSettingViewModelProvider = ConsumerSettingViewModel_Factory.create(this.appComponent.consumerUserRepositoryProvider, this.appComponent.consumerTransferRepositoryProvider, this.appComponent.consumerAccountsRepositoryProvider, this.appComponent.walletRepositoryProvider);
            }

            private SettingsFragment injectSettingsFragment(SettingsFragment settingsFragment) {
                dagger.android.g.i.a(settingsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.toplevel.e0.c(settingsFragment, genericViewModelFactoryOfSettingsViewModel());
                com.toshi.view.fragment.toplevel.e0.a(settingsFragment, genericViewModelFactoryOfConsumerSettingViewModel());
                com.toshi.view.fragment.toplevel.e0.b(settingsFragment, new ContactUsLauncher());
                return settingsFragment;
            }

            private SettingsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SettingsFragment settingsFragment) {
                this.settingsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(settingsFragment);
            }

            @Override // dagger.android.b
            public void inject(SettingsFragment settingsFragment) {
                injectSettingsFragment(settingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SettingsNavFragmentSubcomponentFactory implements r1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SettingsNavFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public r1 create(com.toshi.view.fragment.toplevel.f0 f0Var) {
                f.c.h.b(f0Var);
                return new SettingsNavFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, f0Var);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SettingsNavFragmentSubcomponentImpl implements r1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SettingsNavFragmentSubcomponentImpl settingsNavFragmentSubcomponentImpl;

            @Override // dagger.android.b
            public void inject(com.toshi.view.fragment.toplevel.f0 f0Var) {
            }

            private SettingsNavFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, com.toshi.view.fragment.toplevel.f0 f0Var) {
                this.settingsNavFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignOutFragmentSubcomponentFactory implements t1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SignOutFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public t1 create(SignOutFragment signOutFragment) {
                f.c.h.b(signOutFragment);
                return new SignOutFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, signOutFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignOutFragmentSubcomponentImpl implements t1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SignOutFragmentSubcomponentImpl signOutFragmentSubcomponentImpl;
            private Provider<SignOutViewModel> signOutViewModelProvider;

            private GenericViewModelFactory<SignOutViewModel> genericViewModelFactoryOfSignOutViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.signOutViewModelProvider));
            }

            private void initialize(SignOutFragment signOutFragment) {
                this.signOutViewModelProvider = SignOutViewModel_Factory.create(this.appComponent.applicationServiceProvider);
            }

            private SignOutFragment injectSignOutFragment(SignOutFragment signOutFragment) {
                dagger.android.g.g.a(signOutFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SignOutFragment_MembersInjector.injectViewModelFactory(signOutFragment, genericViewModelFactoryOfSignOutViewModel());
                return signOutFragment;
            }

            private SignOutFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SignOutFragment signOutFragment) {
                this.signOutFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(signOutFragment);
            }

            @Override // dagger.android.b
            public void inject(SignOutFragment signOutFragment) {
                injectSignOutFragment(signOutFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignerViewFragmentSubcomponentFactory implements u1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SignerViewFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.u1 create(SignerViewFragment signerViewFragment) {
                f.c.h.b(signerViewFragment);
                return new SignerViewFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, signerViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignerViewFragmentSubcomponentImpl implements com.toshi.view.activity.u1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SignerViewFragmentSubcomponentImpl signerViewFragmentSubcomponentImpl;

            private GenericViewModelFactory<SignerViewModel> genericViewModelFactoryOfSignerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.appComponent.signerViewModelProvider));
            }

            private SignerViewFragment injectSignerViewFragment(SignerViewFragment signerViewFragment) {
                dagger.android.g.i.a(signerViewFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SignerViewFragment_MembersInjector.injectViewModelFactory(signerViewFragment, genericViewModelFactoryOfSignerViewModel());
                return signerViewFragment;
            }

            private SignerViewFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SignerViewFragment signerViewFragment) {
                this.signerViewFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(SignerViewFragment signerViewFragment) {
                injectSignerViewFragment(signerViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapAmountPickerFragmentSubcomponentFactory implements v1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapAmountPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public v1 create(SwapAmountPickerFragment swapAmountPickerFragment) {
                f.c.h.b(swapAmountPickerFragment);
                return new SwapAmountPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapAmountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapAmountPickerFragmentSubcomponentImpl implements v1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapAmountPickerFragmentSubcomponentImpl swapAmountPickerFragmentSubcomponentImpl;

            private SwapAmountPickerFragment injectSwapAmountPickerFragment(SwapAmountPickerFragment swapAmountPickerFragment) {
                dagger.android.g.i.a(swapAmountPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapAmountPickerFragment_MembersInjector.injectSwapAmountPickerViewModelFactory(swapAmountPickerFragment, swapAmountPickerViewModel_AssistedFactory());
                return swapAmountPickerFragment;
            }

            private SwapAmountPickerViewModel_AssistedFactory swapAmountPickerViewModel_AssistedFactory() {
                return new SwapAmountPickerViewModel_AssistedFactory(this.appComponent.appLockRepositoryProvider, this.appComponent.swapRepositoryProvider, this.appComponent.providesAmountPickerFormatterProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.walletRepositoryProvider);
            }

            private SwapAmountPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapAmountPickerFragment swapAmountPickerFragment) {
                this.swapAmountPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(SwapAmountPickerFragment swapAmountPickerFragment) {
                injectSwapAmountPickerFragment(swapAmountPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapAssetPickerFragmentSubcomponentFactory implements w1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapAssetPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.w1 create(SwapAssetPickerFragment swapAssetPickerFragment) {
                f.c.h.b(swapAssetPickerFragment);
                return new SwapAssetPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapAssetPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapAssetPickerFragmentSubcomponentImpl implements com.toshi.view.activity.w1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapAssetPickerFragmentSubcomponentImpl swapAssetPickerFragmentSubcomponentImpl;
            private Provider<UnsupportedSwapAssetPrompt> unsupportedSwapAssetPromptProvider;

            private void initialize(SwapAssetPickerFragment swapAssetPickerFragment) {
                this.unsupportedSwapAssetPromptProvider = UnsupportedSwapAssetPrompt_Factory.create(this.appComponent.deepLinkRepositoryProvider);
            }

            private SwapAssetPickerFragment injectSwapAssetPickerFragment(SwapAssetPickerFragment swapAssetPickerFragment) {
                dagger.android.g.i.a(swapAssetPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapAssetPickerFragment_MembersInjector.injectViewModelFactory(swapAssetPickerFragment, swapAssetPickerViewModel_AssistedFactory());
                return swapAssetPickerFragment;
            }

            private SwapAssetPickerViewModel_AssistedFactory swapAssetPickerViewModel_AssistedFactory() {
                return new SwapAssetPickerViewModel_AssistedFactory(this.appComponent.walletRepositoryProvider, this.appComponent.swapRepositoryProvider, this.appComponent.currencyFormatterProvider, this.unsupportedSwapAssetPromptProvider);
            }

            private SwapAssetPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapAssetPickerFragment swapAssetPickerFragment) {
                this.swapAssetPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(swapAssetPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(SwapAssetPickerFragment swapAssetPickerFragment) {
                injectSwapAssetPickerFragment(swapAssetPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapCompleteFragmentSubcomponentFactory implements x1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapCompleteFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public x1 create(SwapCompleteFragment swapCompleteFragment) {
                f.c.h.b(swapCompleteFragment);
                return new SwapCompleteFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapCompleteFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapCompleteFragmentSubcomponentImpl implements x1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapCompleteFragmentSubcomponentImpl swapCompleteFragmentSubcomponentImpl;

            private SwapCompleteFragment injectSwapCompleteFragment(SwapCompleteFragment swapCompleteFragment) {
                dagger.android.g.i.a(swapCompleteFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapCompleteFragment_MembersInjector.injectViewModelFactory(swapCompleteFragment, swapCompleteViewModel_AssistedFactory());
                return swapCompleteFragment;
            }

            private SwapCompleteViewModel_AssistedFactory swapCompleteViewModel_AssistedFactory() {
                return new SwapCompleteViewModel_AssistedFactory(this.appComponent.walletRepositoryProvider);
            }

            private SwapCompleteFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapCompleteFragment swapCompleteFragment) {
                this.swapCompleteFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(SwapCompleteFragment swapCompleteFragment) {
                injectSwapCompleteFragment(swapCompleteFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapConfirmationFragmentSubcomponentFactory implements y1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapConfirmationFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.y1 create(SwapConfirmationFragment swapConfirmationFragment) {
                f.c.h.b(swapConfirmationFragment);
                return new SwapConfirmationFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapConfirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapConfirmationFragmentSubcomponentImpl implements com.toshi.view.activity.y1 {
            private final DaggerAppComponent appComponent;
            private Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapConfirmationFragmentSubcomponentImpl swapConfirmationFragmentSubcomponentImpl;

            private void initialize(SwapConfirmationFragment swapConfirmationFragment) {
                this.highMinerFeesPromptProvider = HighMinerFeesPrompt_Factory.create(this.appComponent.storeProvider);
            }

            private SwapConfirmationFragment injectSwapConfirmationFragment(SwapConfirmationFragment swapConfirmationFragment) {
                dagger.android.g.i.a(swapConfirmationFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapConfirmationFragment_MembersInjector.injectViewModelFactory(swapConfirmationFragment, swapConfirmationViewModel_AssistedFactory());
                return swapConfirmationFragment;
            }

            private SwapConfirmationViewModel_AssistedFactory swapConfirmationViewModel_AssistedFactory() {
                return new SwapConfirmationViewModel_AssistedFactory(this.appComponent.walletRepositoryProvider, this.appComponent.swapRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.ethTxRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.authenticationHelperProvider, this.highMinerFeesPromptProvider);
            }

            private SwapConfirmationFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapConfirmationFragment swapConfirmationFragment) {
                this.swapConfirmationFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(swapConfirmationFragment);
            }

            @Override // dagger.android.b
            public void inject(SwapConfirmationFragment swapConfirmationFragment) {
                injectSwapConfirmationFragment(swapConfirmationFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapDisclaimerFragmentSubcomponentFactory implements z1.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapDisclaimerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public z1 create(SwapDisclaimerFragment swapDisclaimerFragment) {
                f.c.h.b(swapDisclaimerFragment);
                return new SwapDisclaimerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapDisclaimerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapDisclaimerFragmentSubcomponentImpl implements z1 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapDisclaimerFragmentSubcomponentImpl swapDisclaimerFragmentSubcomponentImpl;

            private SwapDisclaimerFragment injectSwapDisclaimerFragment(SwapDisclaimerFragment swapDisclaimerFragment) {
                dagger.android.g.i.a(swapDisclaimerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapDisclaimerFragment_MembersInjector.injectViewModelFactory(swapDisclaimerFragment, swapDisclaimerViewModel_AssistedFactory());
                return swapDisclaimerFragment;
            }

            private SwapDisclaimerViewModel_AssistedFactory swapDisclaimerViewModel_AssistedFactory() {
                return new SwapDisclaimerViewModel_AssistedFactory(this.appComponent.storeProvider);
            }

            private SwapDisclaimerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapDisclaimerFragment swapDisclaimerFragment) {
                this.swapDisclaimerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(SwapDisclaimerFragment swapDisclaimerFragment) {
                injectSwapDisclaimerFragment(swapDisclaimerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapInterstitialFragmentSubcomponentFactory implements a2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwapInterstitialFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.a2 create(SwapInterstitialFragment swapInterstitialFragment) {
                f.c.h.b(swapInterstitialFragment);
                return new SwapInterstitialFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, swapInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwapInterstitialFragmentSubcomponentImpl implements com.toshi.view.activity.a2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwapInterstitialFragmentSubcomponentImpl swapInterstitialFragmentSubcomponentImpl;

            private SwapInterstitialFragment injectSwapInterstitialFragment(SwapInterstitialFragment swapInterstitialFragment) {
                dagger.android.g.i.a(swapInterstitialFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwapInterstitialFragment_MembersInjector.injectSwapInterstitialViewModelFactory(swapInterstitialFragment, swapInterstitialViewModel_AssistedFactory());
                return swapInterstitialFragment;
            }

            private SwapInterstitialViewModel_AssistedFactory swapInterstitialViewModel_AssistedFactory() {
                return new SwapInterstitialViewModel_AssistedFactory(this.appComponent.storeProvider);
            }

            private SwapInterstitialFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwapInterstitialFragment swapInterstitialFragment) {
                this.swapInterstitialFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(SwapInterstitialFragment swapInterstitialFragment) {
                injectSwapInterstitialFragment(swapInterstitialFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwitchEthereumChainFragmentSubcomponentFactory implements w.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwitchEthereumChainFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.w create(SwitchEthereumChainFragment switchEthereumChainFragment) {
                f.c.h.b(switchEthereumChainFragment);
                return new SwitchEthereumChainFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, switchEthereumChainFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwitchEthereumChainFragmentSubcomponentImpl implements com.toshi.view.activity.w {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwitchEthereumChainFragmentSubcomponentImpl switchEthereumChainFragmentSubcomponentImpl;
            private Provider<SwitchEthereumChainViewModel> switchEthereumChainViewModelProvider;

            private GenericViewModelFactory<SwitchEthereumChainViewModel> genericViewModelFactoryOfSwitchEthereumChainViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.switchEthereumChainViewModelProvider));
            }

            private void initialize(SwitchEthereumChainFragment switchEthereumChainFragment) {
                this.switchEthereumChainViewModelProvider = SwitchEthereumChainViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.walletLinkRepositoryProvider);
            }

            private SwitchEthereumChainFragment injectSwitchEthereumChainFragment(SwitchEthereumChainFragment switchEthereumChainFragment) {
                dagger.android.g.e.a(switchEthereumChainFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                SwitchEthereumChainFragment_MembersInjector.injectViewModelFactory(switchEthereumChainFragment, genericViewModelFactoryOfSwitchEthereumChainViewModel());
                return switchEthereumChainFragment;
            }

            private SwitchEthereumChainFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwitchEthereumChainFragment switchEthereumChainFragment) {
                this.switchEthereumChainFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(switchEthereumChainFragment);
            }

            @Override // dagger.android.b
            public void inject(SwitchEthereumChainFragment switchEthereumChainFragment) {
                injectSwitchEthereumChainFragment(switchEthereumChainFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwitchPinLockFragmentSubcomponentFactory implements b2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private SwitchPinLockFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public b2 create(SwitchPinLockFragment switchPinLockFragment) {
                f.c.h.b(switchPinLockFragment);
                return new SwitchPinLockFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, switchPinLockFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SwitchPinLockFragmentSubcomponentImpl implements b2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final SwitchPinLockFragmentSubcomponentImpl switchPinLockFragmentSubcomponentImpl;
            private Provider<e.j.n.p3.s> switchPinLockViewModelProvider;

            private GenericViewModelFactory<e.j.n.p3.s> genericViewModelFactoryOfSwitchPinLockViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.switchPinLockViewModelProvider));
            }

            private void initialize(SwitchPinLockFragment switchPinLockFragment) {
                this.switchPinLockViewModelProvider = e.j.n.p3.t.a(this.appComponent.appLockRepositoryProvider);
            }

            private SwitchPinLockFragment injectSwitchPinLockFragment(SwitchPinLockFragment switchPinLockFragment) {
                dagger.android.g.i.a(switchPinLockFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.activity.pin.l.a(switchPinLockFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.activity.pin.l.b(switchPinLockFragment, genericViewModelFactoryOfSwitchPinLockViewModel());
                return switchPinLockFragment;
            }

            private SwitchPinLockFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, SwitchPinLockFragment switchPinLockFragment) {
                this.switchPinLockFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(switchPinLockFragment);
            }

            @Override // dagger.android.b
            public void inject(SwitchPinLockFragment switchPinLockFragment) {
                injectSwitchPinLockFragment(switchPinLockFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class TxHistoryDetailFragmentSubcomponentFactory implements c2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private TxHistoryDetailFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.c2 create(TxHistoryDetailFragment txHistoryDetailFragment) {
                f.c.h.b(txHistoryDetailFragment);
                return new TxHistoryDetailFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, txHistoryDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class TxHistoryDetailFragmentSubcomponentImpl implements com.toshi.view.activity.c2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final TxHistoryDetailFragmentSubcomponentImpl txHistoryDetailFragmentSubcomponentImpl;
            private Provider<TxHistoryDetailViewModel> txHistoryDetailViewModelProvider;

            private GenericViewModelFactory<TxHistoryDetailViewModel> genericViewModelFactoryOfTxHistoryDetailViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.txHistoryDetailViewModelProvider));
            }

            private void initialize(TxHistoryDetailFragment txHistoryDetailFragment) {
                this.txHistoryDetailViewModelProvider = TxHistoryDetailViewModel_Factory.create(this.appComponent.currencyFormatterProvider, this.appComponent.providesTxHistoryDaoProvider);
            }

            private TxHistoryDetailFragment injectTxHistoryDetailFragment(TxHistoryDetailFragment txHistoryDetailFragment) {
                dagger.android.g.i.a(txHistoryDetailFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                TxHistoryDetailFragment_MembersInjector.injectViewModelFactory(txHistoryDetailFragment, genericViewModelFactoryOfTxHistoryDetailViewModel());
                return txHistoryDetailFragment;
            }

            private TxHistoryDetailFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, TxHistoryDetailFragment txHistoryDetailFragment) {
                this.txHistoryDetailFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(txHistoryDetailFragment);
            }

            @Override // dagger.android.b
            public void inject(TxHistoryDetailFragment txHistoryDetailFragment) {
                injectTxHistoryDetailFragment(txHistoryDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class TxSignerFragmentSubcomponentFactory implements d2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private TxSignerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public d2 create(TxSignerFragment txSignerFragment) {
                f.c.h.b(txSignerFragment);
                return new TxSignerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, txSignerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class TxSignerFragmentSubcomponentImpl implements d2 {
            private final DaggerAppComponent appComponent;
            private Provider<HighMinerFeesPrompt> highMinerFeesPromptProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final TxSignerFragmentSubcomponentImpl txSignerFragmentSubcomponentImpl;
            private Provider<TxSignerViewModel> txSignerViewModelProvider;

            private GenericViewModelFactory<AdjustableMinerFeeSharedViewModel> genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(AdjustableMinerFeeSharedViewModel_Factory.create()));
            }

            private GenericViewModelFactory<TxSignerViewModel> genericViewModelFactoryOfTxSignerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.txSignerViewModelProvider));
            }

            private void initialize(TxSignerFragment txSignerFragment) {
                this.highMinerFeesPromptProvider = HighMinerFeesPrompt_Factory.create(this.appComponent.storeProvider);
                this.txSignerViewModelProvider = TxSignerViewModel_Factory.create(this.appComponent.currencyFormatterProvider, this.highMinerFeesPromptProvider, this.appComponent.walletRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.ethTxRepositoryProvider, this.appComponent.walletLinkRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.authenticationHelperProvider, this.appComponent.minerFeeAPIProvider, this.appComponent.storeProvider);
            }

            private TxSignerFragment injectTxSignerFragment(TxSignerFragment txSignerFragment) {
                dagger.android.g.e.a(txSignerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                TxSignerFragment_MembersInjector.injectAdjustableMinerFeesFactory(txSignerFragment, genericViewModelFactoryOfAdjustableMinerFeeSharedViewModel());
                TxSignerFragment_MembersInjector.injectViewModelFactory(txSignerFragment, genericViewModelFactoryOfTxSignerViewModel());
                return txSignerFragment;
            }

            private TxSignerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, TxSignerFragment txSignerFragment) {
                this.txSignerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(txSignerFragment);
            }

            @Override // dagger.android.b
            public void inject(TxSignerFragment txSignerFragment) {
                injectTxSignerFragment(txSignerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class UniversalQRScannerFragmentSubcomponentFactory implements e2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private UniversalQRScannerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public e2 create(UniversalQRScannerFragment universalQRScannerFragment) {
                f.c.h.b(universalQRScannerFragment);
                return new UniversalQRScannerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, universalQRScannerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class UniversalQRScannerFragmentSubcomponentImpl implements e2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<e.j.h.a.j> qRScannerViewModelProvider;
            private final UniversalQRScannerFragmentSubcomponentImpl universalQRScannerFragmentSubcomponentImpl;
            private Provider<e.j.h.a.l> universalQRScannerViewModelProvider;

            private GenericViewModelFactory<e.j.h.a.j> genericViewModelFactoryOfQRScannerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.qRScannerViewModelProvider));
            }

            private GenericViewModelFactory<e.j.h.a.l> genericViewModelFactoryOfUniversalQRScannerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.universalQRScannerViewModelProvider));
            }

            private void initialize(UniversalQRScannerFragment universalQRScannerFragment) {
                this.universalQRScannerViewModelProvider = e.j.h.a.m.a(this.appComponent.providesQrParsersProvider, this.appComponent.walletRepositoryProvider, this.appComponent.walletLinkRepositoryProvider);
                this.qRScannerViewModelProvider = e.j.h.a.k.a(this.appComponent.walletRepositoryProvider);
            }

            private UniversalQRScannerFragment injectUniversalQRScannerFragment(UniversalQRScannerFragment universalQRScannerFragment) {
                dagger.android.g.i.a(universalQRScannerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.qr.view.fragment.d.b(universalQRScannerFragment, genericViewModelFactoryOfUniversalQRScannerViewModel());
                com.toshi.qr.view.fragment.d.a(universalQRScannerFragment, genericViewModelFactoryOfQRScannerViewModel());
                return universalQRScannerFragment;
            }

            private UniversalQRScannerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, UniversalQRScannerFragment universalQRScannerFragment) {
                this.universalQRScannerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(universalQRScannerFragment);
            }

            @Override // dagger.android.b
            public void inject(UniversalQRScannerFragment universalQRScannerFragment) {
                injectUniversalQRScannerFragment(universalQRScannerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class UserProfileFragmentSubcomponentFactory implements f2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private UserProfileFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public f2 create(UserProfileFragment userProfileFragment) {
                f.c.h.b(userProfileFragment);
                return new UserProfileFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, userProfileFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class UserProfileFragmentSubcomponentImpl implements f2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final UserProfileFragmentSubcomponentImpl userProfileFragmentSubcomponentImpl;
            private Provider<UserProfileViewModel> userProfileViewModelProvider;

            private GenericViewModelFactory<UserProfileViewModel> genericViewModelFactoryOfUserProfileViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.userProfileViewModelProvider));
            }

            private void initialize(UserProfileFragment userProfileFragment) {
                this.userProfileViewModelProvider = UserProfileViewModel_Factory.create(this.appComponent.userRepositoryProvider);
            }

            private UserProfileFragment injectUserProfileFragment(UserProfileFragment userProfileFragment) {
                dagger.android.g.i.a(userProfileFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                UserProfileFragment_MembersInjector.injectViewModelFactory(userProfileFragment, genericViewModelFactoryOfUserProfileViewModel());
                return userProfileFragment;
            }

            private UserProfileFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, UserProfileFragment userProfileFragment) {
                this.userProfileFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(userProfileFragment);
            }

            @Override // dagger.android.b
            public void inject(UserProfileFragment userProfileFragment) {
                injectUserProfileFragment(userProfileFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ViewCollectibleTypeFragmentSubcomponentFactory implements h2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private ViewCollectibleTypeFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public h2 create(ViewCollectibleTypeFragment viewCollectibleTypeFragment) {
                f.c.h.b(viewCollectibleTypeFragment);
                return new ViewCollectibleTypeFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, viewCollectibleTypeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class ViewCollectibleTypeFragmentSubcomponentImpl implements h2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final ViewCollectibleTypeFragmentSubcomponentImpl viewCollectibleTypeFragmentSubcomponentImpl;
            private Provider<k3> viewErc721TokensViewModelProvider;

            private GenericViewModelFactory<k3> genericViewModelFactoryOfViewErc721TokensViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.viewErc721TokensViewModelProvider));
            }

            private void initialize(ViewCollectibleTypeFragment viewCollectibleTypeFragment) {
                this.viewErc721TokensViewModelProvider = l3.a(this.appComponent.erc721RepositoryProvider);
            }

            private ViewCollectibleTypeFragment injectViewCollectibleTypeFragment(ViewCollectibleTypeFragment viewCollectibleTypeFragment) {
                dagger.android.g.i.a(viewCollectibleTypeFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.p0.a(viewCollectibleTypeFragment, genericViewModelFactoryOfViewErc721TokensViewModel());
                return viewCollectibleTypeFragment;
            }

            private ViewCollectibleTypeFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, ViewCollectibleTypeFragment viewCollectibleTypeFragment) {
                this.viewCollectibleTypeFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(viewCollectibleTypeFragment);
            }

            @Override // dagger.android.b
            public void inject(ViewCollectibleTypeFragment viewCollectibleTypeFragment) {
                injectViewCollectibleTypeFragment(viewCollectibleTypeFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletDetailFragmentSubcomponentFactory implements i2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private WalletDetailFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public i2 create(WalletDetailFragment walletDetailFragment) {
                f.c.h.b(walletDetailFragment);
                return new WalletDetailFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, walletDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletDetailFragmentSubcomponentImpl implements i2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private Provider<UnsupportedSwapAssetPrompt> unsupportedSwapAssetPromptProvider;
            private final WalletDetailFragmentSubcomponentImpl walletDetailFragmentSubcomponentImpl;
            private Provider<com.toshi.view.fragment.coin.m> walletDetailViewModelProvider;

            private GenericViewModelFactory<com.toshi.view.fragment.coin.m> genericViewModelFactoryOfWalletDetailViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.walletDetailViewModelProvider));
            }

            private void initialize(WalletDetailFragment walletDetailFragment) {
                this.unsupportedSwapAssetPromptProvider = UnsupportedSwapAssetPrompt_Factory.create(this.appComponent.deepLinkRepositoryProvider);
                this.walletDetailViewModelProvider = com.toshi.view.fragment.coin.o.a(this.appComponent.txHistoryRepositoryProvider, this.appComponent.currencyFormatterProvider, this.appComponent.walletRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.appComponent.swapRepositoryProvider, this.unsupportedSwapAssetPromptProvider, this.appComponent.consumerUserRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider);
            }

            private WalletDetailFragment injectWalletDetailFragment(WalletDetailFragment walletDetailFragment) {
                dagger.android.g.i.a(walletDetailFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.coin.l.b(walletDetailFragment, genericViewModelFactoryOfWalletDetailViewModel());
                com.toshi.view.fragment.coin.l.a(walletDetailFragment, (com.toshi.view.fragment.h0) this.appComponent.displayCoinAddressFragmentFactoryProvider.get());
                return walletDetailFragment;
            }

            private WalletDetailFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, WalletDetailFragment walletDetailFragment) {
                this.walletDetailFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(walletDetailFragment);
            }

            @Override // dagger.android.b
            public void inject(WalletDetailFragment walletDetailFragment) {
                injectWalletDetailFragment(walletDetailFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletLinkSettingsFragmentSubcomponentFactory implements k2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private WalletLinkSettingsFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public k2 create(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                f.c.h.b(walletLinkSettingsFragment);
                return new WalletLinkSettingsFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, walletLinkSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletLinkSettingsFragmentSubcomponentImpl implements k2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final WalletLinkSettingsFragmentSubcomponentImpl walletLinkSettingsFragmentSubcomponentImpl;
            private Provider<WalletLinkSettingsViewModel> walletLinkSettingsViewModelProvider;

            private GenericViewModelFactory<WalletLinkSettingsViewModel> genericViewModelFactoryOfWalletLinkSettingsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.walletLinkSettingsViewModelProvider));
            }

            private void initialize(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                this.walletLinkSettingsViewModelProvider = WalletLinkSettingsViewModel_Factory.create(this.appComponent.walletLinkRepositoryProvider);
            }

            private WalletLinkSettingsFragment injectWalletLinkSettingsFragment(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                dagger.android.g.i.a(walletLinkSettingsFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                WalletLinkSettingsFragment_MembersInjector.injectViewModelFactory(walletLinkSettingsFragment, genericViewModelFactoryOfWalletLinkSettingsViewModel());
                return walletLinkSettingsFragment;
            }

            private WalletLinkSettingsFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, WalletLinkSettingsFragment walletLinkSettingsFragment) {
                this.walletLinkSettingsFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(walletLinkSettingsFragment);
            }

            @Override // dagger.android.b
            public void inject(WalletLinkSettingsFragment walletLinkSettingsFragment) {
                injectWalletLinkSettingsFragment(walletLinkSettingsFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletNavFragmentSubcomponentFactory implements l2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private WalletNavFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public l2 create(com.toshi.view.fragment.toplevel.g0 g0Var) {
                f.c.h.b(g0Var);
                return new WalletNavFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, g0Var);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletNavFragmentSubcomponentImpl implements l2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final WalletNavFragmentSubcomponentImpl walletNavFragmentSubcomponentImpl;

            @Override // dagger.android.b
            public void inject(com.toshi.view.fragment.toplevel.g0 g0Var) {
            }

            private WalletNavFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, com.toshi.view.fragment.toplevel.g0 g0Var) {
                this.walletNavFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletPickerFragmentSubcomponentFactory implements m2.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private WalletPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public m2 create(WalletPickerFragment walletPickerFragment) {
                f.c.h.b(walletPickerFragment);
                return new WalletPickerFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, walletPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletPickerFragmentSubcomponentImpl implements m2 {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final WalletPickerFragmentSubcomponentImpl walletPickerFragmentSubcomponentImpl;
            private Provider<n3> walletPickerViewModelProvider;

            private GenericViewModelFactory<n3> genericViewModelFactoryOfWalletPickerViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.walletPickerViewModelProvider));
            }

            private void initialize(WalletPickerFragment walletPickerFragment) {
                this.walletPickerViewModelProvider = o3.a(this.appComponent.ethWalletRepositoryProvider, this.appComponent.walletRepositoryProvider);
            }

            private WalletPickerFragment injectWalletPickerFragment(WalletPickerFragment walletPickerFragment) {
                dagger.android.g.i.a(walletPickerFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.q0.a(walletPickerFragment, genericViewModelFactoryOfWalletPickerViewModel());
                return walletPickerFragment;
            }

            private WalletPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, WalletPickerFragment walletPickerFragment) {
                this.walletPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(walletPickerFragment);
            }

            @Override // dagger.android.b
            public void inject(WalletPickerFragment walletPickerFragment) {
                injectWalletPickerFragment(walletPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletsTabFragmentSubcomponentFactory implements b0.a {
            private final DaggerAppComponent appComponent;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;

            private WalletsTabFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.b0 create(WalletsTabFragment walletsTabFragment) {
                f.c.h.b(walletsTabFragment);
                return new WalletsTabFragmentSubcomponentImpl(this.appComponent, this.mainActivitySubcomponentImpl, walletsTabFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class WalletsTabFragmentSubcomponentImpl implements com.toshi.view.activity.b0 {
            private Provider<ActionItemsViewModel> actionItemsViewModelProvider;
            private final DaggerAppComponent appComponent;
            private Provider<CloudBackupPrompt> cloudBackupPromptProvider;
            private final MainActivitySubcomponentImpl mainActivitySubcomponentImpl;
            private final WalletsTabFragmentSubcomponentImpl walletsTabFragmentSubcomponentImpl;
            private Provider<WalletsTabViewModel> walletsTabViewModelProvider;

            private GenericViewModelFactory<ActionItemsViewModel> genericViewModelFactoryOfActionItemsViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.actionItemsViewModelProvider));
            }

            private GenericViewModelFactory<LoadingPillViewModel> genericViewModelFactoryOfLoadingPillViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(LoadingPillViewModel_Factory.create()));
            }

            private GenericViewModelFactory<ScrolledToTopViewModel> genericViewModelFactoryOfScrolledToTopViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(ScrolledToTopViewModel_Factory.create()));
            }

            private GenericViewModelFactory<WalletsTabViewModel> genericViewModelFactoryOfWalletsTabViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.walletsTabViewModelProvider));
            }

            private void initialize(WalletsTabFragment walletsTabFragment) {
                this.cloudBackupPromptProvider = CloudBackupPrompt_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.storeProvider, this.appComponent.notificationRepositoryProvider);
                this.walletsTabViewModelProvider = WalletsTabViewModel_Factory.create(this.appComponent.walletRepositoryProvider, this.appComponent.txHistoryRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.appPrefsProvider, this.appComponent.currencyFormatterProvider, this.appComponent.networkSettingsProvider, this.cloudBackupPromptProvider, this.appComponent.consumerUserRepositoryProvider);
                this.actionItemsViewModelProvider = ActionItemsViewModel_Factory.create(this.appComponent.lendRepositoryProvider, this.appComponent.txHistoryRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.exchangeRateRepositoryProvider, this.appComponent.fiatCurrencyRepositoryProvider, this.appComponent.featureFlagsRepositoryProvider, this.appComponent.consumerUserRepositoryProvider, this.appComponent.currencyFormatterProvider);
            }

            private WalletsTabFragment injectWalletsTabFragment(WalletsTabFragment walletsTabFragment) {
                dagger.android.g.i.a(walletsTabFragment, this.mainActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                WalletsTabFragment_MembersInjector.injectWalletsTabViewModelFactory(walletsTabFragment, genericViewModelFactoryOfWalletsTabViewModel());
                WalletsTabFragment_MembersInjector.injectActionItemsViewModelFactory(walletsTabFragment, genericViewModelFactoryOfActionItemsViewModel());
                WalletsTabFragment_MembersInjector.injectLoadingPillViewModelFactory(walletsTabFragment, genericViewModelFactoryOfLoadingPillViewModel());
                WalletsTabFragment_MembersInjector.injectScrolledToTopViewModelFactory(walletsTabFragment, genericViewModelFactoryOfScrolledToTopViewModel());
                return walletsTabFragment;
            }

            private WalletsTabFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivitySubcomponentImpl mainActivitySubcomponentImpl, WalletsTabFragment walletsTabFragment) {
                this.walletsTabFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.mainActivitySubcomponentImpl = mainActivitySubcomponentImpl;
                initialize(walletsTabFragment);
            }

            @Override // dagger.android.b
            public void inject(WalletsTabFragment walletsTabFragment) {
                injectWalletsTabFragment(walletsTabFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DispatchingAndroidInjector<Object> dispatchingAndroidInjectorOfObject() {
            return dagger.android.e.a(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), com.google.common.collect.m.l());
        }

        private GenericViewModelFactory<e.j.n.a2> genericViewModelFactoryOfBannedLocationViewModel() {
            return new GenericViewModelFactory<>(f.c.c.a(this.bannedLocationViewModelProvider));
        }

        private GenericViewModelFactory<DeepLinkViewModel> genericViewModelFactoryOfDeepLinkViewModel() {
            return new GenericViewModelFactory<>(f.c.c.a(this.deepLinkViewModelProvider));
        }

        private GenericViewModelFactory<o2> genericViewModelFactoryOfMainViewModel() {
            return new GenericViewModelFactory<>(f.c.c.a(this.mainViewModelProvider));
        }

        private void initialize(MainActivity mainActivity) {
            this.userProfileFragmentSubcomponentFactoryProvider = new Provider<f2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public f2.a get() {
                    return new UserProfileFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.advancedSettingsFragmentSubcomponentFactoryProvider = new Provider<u.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public u.a get() {
                    return new AdvancedSettingsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.debugMenuFragmentSubcomponentFactoryProvider = new Provider<v0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public v0.a get() {
                    return new DebugMenuFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.authenticationFragmentSubcomponentFactoryProvider = new Provider<x.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public x.a get() {
                    return new AuthenticationFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<y.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public y.a get() {
                    return new MAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.basePickUsernameFragmentSubcomponentFactoryProvider = new Provider<z.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public z.a get() {
                    return new BasePickUsernameFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.baseWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider = new Provider<a0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public a0.a get() {
                    return new BaseWalletAuthenticationOnboardingFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.collectibleDetailFragmentSubcomponentFactoryProvider = new Provider<c0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public c0.a get() {
                    return new CollectibleDetailFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.collectibleTypesTabFragmentSubcomponentFactoryProvider = new Provider<d0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public d0.a get() {
                    return new CollectibleTypesTabFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.universalQRScannerFragmentSubcomponentFactoryProvider = new Provider<e2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public e2.a get() {
                    return new UniversalQRScannerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerOnboardingFragmentSubcomponentFactoryProvider = new Provider<l0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public l0.a get() {
                    return new ConsumerOnboardingFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerInterstitialFragmentSubcomponentFactoryProvider = new Provider<k0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public k0.a get() {
                    return new ConsumerInterstitialFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerFragmentSubcomponentFactoryProvider = new Provider<j0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public j0.a get() {
                    return new ConsumerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerAmountPickerFragmentSubcomponentFactoryProvider = new Provider<g0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public g0.a get() {
                    return new ConsumerAmountPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerTransferConfirmationFragmentSubcomponentFactoryProvider = new Provider<o0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.15
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public o0.a get() {
                    return new ConsumerTransferConfirmationFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerTransferMethodsFragmentSubcomponentFactoryProvider = new Provider<q0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public q0.a get() {
                    return new ConsumerTransferMethodsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerSecure3DVerificationFragmentSubcomponentFactoryProvider = new Provider<m0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public m0.a get() {
                    return new ConsumerSecure3DVerificationFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerSendTwoFactorFragmentSubcomponentFactoryProvider = new Provider<n0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.18
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public n0.a get() {
                    return new ConsumerSendTwoFactorFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerTransferInitiatedFragmentSubcomponentFactoryProvider = new Provider<p0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.19
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public p0.a get() {
                    return new ConsumerTransferInitiatedFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerAvailablePaymentMethodsFragmentSubcomponentFactoryProvider = new Provider<h0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.20
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public h0.a get() {
                    return new ConsumerAvailablePaymentMethodsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerAddCardFragmentSubcomponentFactoryProvider = new Provider<f0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.21
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public f0.a get() {
                    return new ConsumerAddCardFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.consumerCardCDVFragmentSubcomponentFactoryProvider = new Provider<i0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.22
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public i0.a get() {
                    return new ConsumerCardCDVFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.createPasswordFragmentSubcomponentFactoryProvider = new Provider<r0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.23
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public r0.a get() {
                    return new MAFBM_CPF_CreatePasswordFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.createPasswordInfoFragmentSubcomponentFactoryProvider = new Provider<s0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.24
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public s0.a get() {
                    return new MAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.currencyFragmentSubcomponentFactoryProvider = new Provider<t0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.25
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public t0.a get() {
                    return new CurrencyFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.appLockSettingsFragmentSubcomponentFactoryProvider = new Provider<v.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.26
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public v.a get() {
                    return new AppLockSettingsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.displayCoinAddressFragmentSubcomponentFactoryProvider = new Provider<w0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.27
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public w0.a get() {
                    return new DisplayCoinAddressFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.walletsTabFragmentSubcomponentFactoryProvider = new Provider<b0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.28
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public b0.a get() {
                    return new WalletsTabFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.legalFragmentSubcomponentFactoryProvider = new Provider<x0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.29
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public x0.a get() {
                    return new LegalFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.licenseFragmentSubcomponentFactoryProvider = new Provider<e1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.30
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public e1.a get() {
                    return new LicenseFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.licenseListFragmentSubcomponentFactoryProvider = new Provider<f1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.31
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public f1.a get() {
                    return new LicenseListFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.manualBackupFragmentSubcomponentFactoryProvider = new Provider<g1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.32
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public g1.a get() {
                    return new MAFBM_MBF_ManualBackupFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.settingsFragmentSubcomponentFactoryProvider = new Provider<s1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.33
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public s1.a get() {
                    return new SettingsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.signOutFragmentSubcomponentFactoryProvider = new Provider<t1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.34
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public t1.a get() {
                    return new SignOutFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.networkSwitcherFragmentSubcomponentFactoryProvider = new Provider<i1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.35
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public i1.a get() {
                    return new NetworkSwitcherFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.receiveCoinPickerFragmentSubcomponentFactoryProvider = new Provider<k1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.36
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public k1.a get() {
                    return new ReceiveCoinPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.sendCoinPickerFragmentSubcomponentFactoryProvider = new Provider<o1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.37
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public o1.a get() {
                    return new SendCoinPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.legalViewFragmentSubcomponentFactoryProvider = new Provider<y0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.38
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public y0.a get() {
                    return new MAFBM_LVF_LegalViewFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.verifyManualBackupFragmentSubcomponentFactoryProvider = new Provider<g2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.39
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public g2.a get() {
                    return new MAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.viewCollectibleTypeFragmentSubcomponentFactoryProvider = new Provider<h2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.40
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public h2.a get() {
                    return new ViewCollectibleTypeFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.walletDetailFragmentSubcomponentFactoryProvider = new Provider<i2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.41
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public i2.a get() {
                    return new WalletDetailFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.homeFragmentSubcomponentFactoryProvider = new Provider<j2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.42
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public j2.a get() {
                    return new HomeFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.walletPickerFragmentSubcomponentFactoryProvider = new Provider<m2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.43
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public m2.a get() {
                    return new WalletPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.dappsFragmentSubcomponentFactoryProvider = new Provider<n2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.44
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public n2.a get() {
                    return new DappsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.switchPinLockFragmentSubcomponentFactoryProvider = new Provider<b2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.45
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public b2.a get() {
                    return new SwitchPinLockFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.txHistoryDetailFragmentSubcomponentFactoryProvider = new Provider<c2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.46
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public c2.a get() {
                    return new TxHistoryDetailFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.amountPickerFragmentSubcomponentFactoryProvider = new Provider<n1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.47
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public n1.a get() {
                    return new AmountPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.walletLinkSettingsFragmentSubcomponentFactoryProvider = new Provider<k2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.48
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public k2.a get() {
                    return new WalletLinkSettingsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.signerViewFragmentSubcomponentFactoryProvider = new Provider<u1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.49
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public u1.a get() {
                    return new SignerViewFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.switchEthereumChainFragmentSubcomponentFactoryProvider = new Provider<w.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.50
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public w.a get() {
                    return new SwitchEthereumChainFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.requestEthereumAccountsFragmentSubcomponentFactoryProvider = new Provider<l1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.51
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public l1.a get() {
                    return new RequestEthereumAccountsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.parentRequestEthereumAccountsFragmentSubcomponentFactoryProvider = new Provider<j1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.52
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public j1.a get() {
                    return new ParentRequestEthereumAccountsFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.txSignerFragmentSubcomponentFactoryProvider = new Provider<d2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.53
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public d2.a get() {
                    return new TxSignerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.adjustableMinerFeeFragmentSubcomponentFactoryProvider = new Provider<t.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.54
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public t.a get() {
                    return new AdjustableMinerFeeFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.adjustableMinerFee1559FragmentSubcomponentFactoryProvider = new Provider<s.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.55
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public s.a get() {
                    return new AdjustableMinerFee1559FragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.messageSignerFragmentSubcomponentFactoryProvider = new Provider<h1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.56
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public h1.a get() {
                    return new MessageSignerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.sendDestinationPickerFragmentSubcomponentFactoryProvider = new Provider<q1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.57
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public q1.a get() {
                    return new SendDestinationPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.confirmationFragmentSubcomponentFactoryProvider = new Provider<p1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.58
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public p1.a get() {
                    return new ConfirmationFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.amountFragmentSubcomponentFactoryProvider = new Provider<m1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.59
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public m1.a get() {
                    return new AmountFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.completeFragmentSubcomponentFactoryProvider = new Provider<e0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.60
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public e0.a get() {
                    return new CompleteFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.walletNavFragmentSubcomponentFactoryProvider = new Provider<l2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.61
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public l2.a get() {
                    return new WalletNavFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.dappNavFragmentSubcomponentFactoryProvider = new Provider<u0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.62
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public u0.a get() {
                    return new DappNavFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.settingsNavFragmentSubcomponentFactoryProvider = new Provider<r1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.63
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public r1.a get() {
                    return new SettingsNavFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.lendUserAgreementFragmentSubcomponentFactoryProvider = new Provider<d1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.64
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public d1.a get() {
                    return new LendUserAgreementFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.lendDashboardFragmentSubcomponentFactoryProvider = new Provider<a1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.65
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public a1.a get() {
                    return new LendDashboardFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.lendInterstitialFragmentSubcomponentFactoryProvider = new Provider<b1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.66
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public b1.a get() {
                    return new LendInterstitialFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.lendCoinPickerFragmentSubcomponentFactoryProvider = new Provider<z0.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.67
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public z0.a get() {
                    return new LendCoinPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.lendProviderPickerFragmentSubcomponentFactoryProvider = new Provider<c1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.68
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public c1.a get() {
                    return new LendProviderPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapInterstitialFragmentSubcomponentFactoryProvider = new Provider<a2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.69
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public a2.a get() {
                    return new SwapInterstitialFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapDisclaimerFragmentSubcomponentFactoryProvider = new Provider<z1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.70
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public z1.a get() {
                    return new SwapDisclaimerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapAmountPickerFragmentSubcomponentFactoryProvider = new Provider<v1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.71
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public v1.a get() {
                    return new SwapAmountPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapAssetPickerFragmentSubcomponentFactoryProvider = new Provider<w1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.72
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public w1.a get() {
                    return new SwapAssetPickerFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapConfirmationFragmentSubcomponentFactoryProvider = new Provider<y1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.73
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public y1.a get() {
                    return new SwapConfirmationFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.swapCompleteFragmentSubcomponentFactoryProvider = new Provider<x1.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.MainActivitySubcomponentImpl.74
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public x1.a get() {
                    return new SwapCompleteFragmentSubcomponentFactory(MainActivitySubcomponentImpl.this.appComponent, MainActivitySubcomponentImpl.this.mainActivitySubcomponentImpl);
                }
            };
            this.mainViewModelProvider = f.c.c.b(p2.a(this.appComponent.appReviewRepositoryProvider, this.appComponent.versioningRepositoryProvider, this.appComponent.txRepositoryProvider, this.appComponent.appPrefsProvider, this.appComponent.notificationRepositoryProvider, this.appComponent.userRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.appLockRepositoryProvider, this.appComponent.deepLinkRepositoryProvider, this.appComponent.storeProvider, this.appComponent.pushNotificationRepositoryProvider, this.appComponent.authenticationHelperProvider, this.appComponent.mnemonicRepositoryProvider, this.appComponent.providesConnectivitySubjectProvider));
            this.deepLinkViewModelProvider = DeepLinkViewModel_Factory.create(this.appComponent.providesPaymentRouteActionsProvider, this.appComponent.providesRouteActionsProvider);
            this.bannedLocationViewModelProvider = e.j.n.b2.a(this.appComponent.oFACRepositoryProvider);
        }

        private MainActivity injectMainActivity(MainActivity mainActivity) {
            dagger.android.g.c.a(mainActivity, dispatchingAndroidInjectorOfObject());
            MainActivity_MembersInjector.injectAuthenticationHelper(mainActivity, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
            MainActivity_MembersInjector.injectViewModelFactory(mainActivity, genericViewModelFactoryOfMainViewModel());
            MainActivity_MembersInjector.injectDeepLinkViewModelFactory(mainActivity, genericViewModelFactoryOfDeepLinkViewModel());
            MainActivity_MembersInjector.injectBannedLocationViewModelFactory(mainActivity, genericViewModelFactoryOfBannedLocationViewModel());
            MainActivity_MembersInjector.injectContactUsLauncher(mainActivity, new ContactUsLauncher());
            return mainActivity;
        }

        private Map<Class<?>, Provider<b.a<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
            return com.google.common.collect.m.a().c(MainActivity.class, this.appComponent.mainActivitySubcomponentFactoryProvider).c(OnboardingWizardActivity.class, this.appComponent.onboardingWizardActivitySubcomponentFactoryProvider).c(SetupPinLockActivity.class, this.appComponent.setupPinLockActivitySubcomponentFactoryProvider).c(BannedLocationActivity.class, this.appComponent.bannedLocationActivitySubcomponentFactoryProvider).c(UMOActivity.class, this.appComponent.uMOActivitySubcomponentFactoryProvider).c(UserProfileFragment.class, this.userProfileFragmentSubcomponentFactoryProvider).c(AdvancedSettingsFragment.class, this.advancedSettingsFragmentSubcomponentFactoryProvider).c(DebugMenuFragment.class, this.debugMenuFragmentSubcomponentFactoryProvider).c(AuthenticationFragment.class, this.authenticationFragmentSubcomponentFactoryProvider).c(BackupRecoveryPhraseFragment.class, this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider).c(com.toshi.view.fragment.pickUsername.h.class, this.basePickUsernameFragmentSubcomponentFactoryProvider).c(com.toshi.view.fragment.onboarding.authMethod.g.class, this.baseWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider).c(CollectibleDetailFragment.class, this.collectibleDetailFragmentSubcomponentFactoryProvider).c(CollectibleTypesTabFragment.class, this.collectibleTypesTabFragmentSubcomponentFactoryProvider).c(UniversalQRScannerFragment.class, this.universalQRScannerFragmentSubcomponentFactoryProvider).c(ConsumerOnboardingFragment.class, this.consumerOnboardingFragmentSubcomponentFactoryProvider).c(ConsumerInterstitialFragment.class, this.consumerInterstitialFragmentSubcomponentFactoryProvider).c(ConsumerFragment.class, this.consumerFragmentSubcomponentFactoryProvider).c(ConsumerAmountPickerFragment.class, this.consumerAmountPickerFragmentSubcomponentFactoryProvider).c(ConsumerTransferConfirmationFragment.class, this.consumerTransferConfirmationFragmentSubcomponentFactoryProvider).c(ConsumerTransferMethodsFragment.class, this.consumerTransferMethodsFragmentSubcomponentFactoryProvider).c(ConsumerSecure3DVerificationFragment.class, this.consumerSecure3DVerificationFragmentSubcomponentFactoryProvider).c(ConsumerSendTwoFactorFragment.class, this.consumerSendTwoFactorFragmentSubcomponentFactoryProvider).c(ConsumerTransferInitiatedFragment.class, this.consumerTransferInitiatedFragmentSubcomponentFactoryProvider).c(ConsumerAvailablePaymentMethodsFragment.class, this.consumerAvailablePaymentMethodsFragmentSubcomponentFactoryProvider).c(ConsumerAddCardFragment.class, this.consumerAddCardFragmentSubcomponentFactoryProvider).c(ConsumerCardCDVFragment.class, this.consumerCardCDVFragmentSubcomponentFactoryProvider).c(CreatePasswordFragment.class, this.createPasswordFragmentSubcomponentFactoryProvider).c(CreatePasswordInfoFragment.class, this.createPasswordInfoFragmentSubcomponentFactoryProvider).c(CurrencyFragment.class, this.currencyFragmentSubcomponentFactoryProvider).c(AppLockSettingsFragment.class, this.appLockSettingsFragmentSubcomponentFactoryProvider).c(DisplayCoinAddressFragment.class, this.displayCoinAddressFragmentSubcomponentFactoryProvider).c(WalletsTabFragment.class, this.walletsTabFragmentSubcomponentFactoryProvider).c(LegalFragment.class, this.legalFragmentSubcomponentFactoryProvider).c(LicenseFragment.class, this.licenseFragmentSubcomponentFactoryProvider).c(LicenseListFragment.class, this.licenseListFragmentSubcomponentFactoryProvider).c(ManualBackupFragment.class, this.manualBackupFragmentSubcomponentFactoryProvider).c(SettingsFragment.class, this.settingsFragmentSubcomponentFactoryProvider).c(SignOutFragment.class, this.signOutFragmentSubcomponentFactoryProvider).c(NetworkSwitcherFragment.class, this.networkSwitcherFragmentSubcomponentFactoryProvider).c(ReceiveCoinPickerFragment.class, this.receiveCoinPickerFragmentSubcomponentFactoryProvider).c(SendCoinPickerFragment.class, this.sendCoinPickerFragmentSubcomponentFactoryProvider).c(LegalViewFragment.class, this.legalViewFragmentSubcomponentFactoryProvider).c(VerifyManualBackupFragment.class, this.verifyManualBackupFragmentSubcomponentFactoryProvider).c(ViewCollectibleTypeFragment.class, this.viewCollectibleTypeFragmentSubcomponentFactoryProvider).c(WalletDetailFragment.class, this.walletDetailFragmentSubcomponentFactoryProvider).c(HomeFragment.class, this.homeFragmentSubcomponentFactoryProvider).c(WalletPickerFragment.class, this.walletPickerFragmentSubcomponentFactoryProvider).c(DappsFragment.class, this.dappsFragmentSubcomponentFactoryProvider).c(SwitchPinLockFragment.class, this.switchPinLockFragmentSubcomponentFactoryProvider).c(TxHistoryDetailFragment.class, this.txHistoryDetailFragmentSubcomponentFactoryProvider).c(AmountPickerFragment.class, this.amountPickerFragmentSubcomponentFactoryProvider).c(WalletLinkSettingsFragment.class, this.walletLinkSettingsFragmentSubcomponentFactoryProvider).c(SignerViewFragment.class, this.signerViewFragmentSubcomponentFactoryProvider).c(SwitchEthereumChainFragment.class, this.switchEthereumChainFragmentSubcomponentFactoryProvider).c(RequestEthereumAccountsFragment.class, this.requestEthereumAccountsFragmentSubcomponentFactoryProvider).c(ParentRequestEthereumAccountsFragment.class, this.parentRequestEthereumAccountsFragmentSubcomponentFactoryProvider).c(TxSignerFragment.class, this.txSignerFragmentSubcomponentFactoryProvider).c(AdjustableMinerFeeFragment.class, this.adjustableMinerFeeFragmentSubcomponentFactoryProvider).c(AdjustableMinerFee1559Fragment.class, this.adjustableMinerFee1559FragmentSubcomponentFactoryProvider).c(MessageSignerFragment.class, this.messageSignerFragmentSubcomponentFactoryProvider).c(SendDestinationPickerFragment.class, this.sendDestinationPickerFragmentSubcomponentFactoryProvider).c(ConfirmationFragment.class, this.confirmationFragmentSubcomponentFactoryProvider).c(AmountFragment.class, this.amountFragmentSubcomponentFactoryProvider).c(CompleteFragment.class, this.completeFragmentSubcomponentFactoryProvider).c(com.toshi.view.fragment.toplevel.g0.class, this.walletNavFragmentSubcomponentFactoryProvider).c(com.toshi.view.fragment.toplevel.c0.class, this.dappNavFragmentSubcomponentFactoryProvider).c(com.toshi.view.fragment.toplevel.f0.class, this.settingsNavFragmentSubcomponentFactoryProvider).c(LendUserAgreementFragment.class, this.lendUserAgreementFragmentSubcomponentFactoryProvider).c(LendDashboardFragment.class, this.lendDashboardFragmentSubcomponentFactoryProvider).c(LendInterstitialFragment.class, this.lendInterstitialFragmentSubcomponentFactoryProvider).c(LendCoinPickerFragment.class, this.lendCoinPickerFragmentSubcomponentFactoryProvider).c(LendProviderPickerFragment.class, this.lendProviderPickerFragmentSubcomponentFactoryProvider).c(SwapInterstitialFragment.class, this.swapInterstitialFragmentSubcomponentFactoryProvider).c(SwapDisclaimerFragment.class, this.swapDisclaimerFragmentSubcomponentFactoryProvider).c(SwapAmountPickerFragment.class, this.swapAmountPickerFragmentSubcomponentFactoryProvider).c(SwapAssetPickerFragment.class, this.swapAssetPickerFragmentSubcomponentFactoryProvider).c(SwapConfirmationFragment.class, this.swapConfirmationFragmentSubcomponentFactoryProvider).c(SwapCompleteFragment.class, this.swapCompleteFragmentSubcomponentFactoryProvider).a();
        }

        private MainActivitySubcomponentImpl(DaggerAppComponent daggerAppComponent, MainActivity mainActivity) {
            this.mainActivitySubcomponentImpl = this;
            this.appComponent = daggerAppComponent;
            initialize(mainActivity);
        }

        @Override // dagger.android.b
        public void inject(MainActivity mainActivity) {
            injectMainActivity(mainActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class OnboardingWizardActivitySubcomponentFactory implements d.a {
        private final DaggerAppComponent appComponent;

        private OnboardingWizardActivitySubcomponentFactory(DaggerAppComponent daggerAppComponent) {
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b.a
        public com.toshi.view.activity.d create(OnboardingWizardActivity onboardingWizardActivity) {
            f.c.h.b(onboardingWizardActivity);
            return new OnboardingWizardActivitySubcomponentImpl(onboardingWizardActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class OnboardingWizardActivitySubcomponentImpl implements com.toshi.view.activity.d {
        private final DaggerAppComponent appComponent;
        private Provider<o2.a> backupPickerFragmentSubcomponentFactoryProvider;
        private Provider<p2.a> backupRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private Provider<e.j.n.a2> bannedLocationViewModelProvider;
        private Provider<q2.a> createPasswordFragmentSubcomponentFactoryProvider;
        private Provider<r2.a> createPasswordInfoFragmentSubcomponentFactoryProvider;
        private Provider<s2.a> enterPasswordFragmentSubcomponentFactoryProvider;
        private Provider<t2.a> landingFragmentSubcomponentFactoryProvider;
        private Provider<u2.a> legalAgreementFragmentSubcomponentFactoryProvider;
        private Provider<v2.a> legalViewFragmentSubcomponentFactoryProvider;
        private Provider<w2.a> manualBackupFragmentSubcomponentFactoryProvider;
        private Provider<x2.a> newWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider;
        private Provider<y2.a> onboardingBackupRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
        private Provider<z2.a> onboardingWizardFragmentSubcomponentFactoryProvider;
        private Provider<a3.a> pickUsernameFragmentSubcomponentFactoryProvider;
        private Provider<b3.a> privacySelectionFragmentSubcomponentFactoryProvider;
        private Provider<c3.a> readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider;
        private Provider<d3.a> restoreWalletFragmentSubcomponentFactoryProvider;
        private Provider<e3.a> signInFragmentSubcomponentFactoryProvider;
        private Provider<f3.a> signInPickUsernameFragmentSubcomponentFactoryProvider;
        private Provider<g3.a> signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider;
        private Provider<h3.a> verifyManualBackupFragmentSubcomponentFactoryProvider;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LegalAgreementFragmentSubcomponentFactory implements u2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private LegalAgreementFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public u2 create(LegalAgreementFragment legalAgreementFragment) {
                f.c.h.b(legalAgreementFragment);
                return new LegalAgreementFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, legalAgreementFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class LegalAgreementFragmentSubcomponentImpl implements u2 {
            private final DaggerAppComponent appComponent;
            private final LegalAgreementFragmentSubcomponentImpl legalAgreementFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private LegalAgreementFragment injectLegalAgreementFragment(LegalAgreementFragment legalAgreementFragment) {
                dagger.android.g.i.a(legalAgreementFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return legalAgreementFragment;
            }

            private LegalAgreementFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, LegalAgreementFragment legalAgreementFragment) {
                this.legalAgreementFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LegalAgreementFragment legalAgreementFragment) {
                injectLegalAgreementFragment(legalAgreementFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class NewWalletAuthenticationOnboardingFragmentSubcomponentFactory implements x2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private NewWalletAuthenticationOnboardingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.x2 create(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
                f.c.h.b(newWalletAuthenticationOnboardingFragment);
                return new NewWalletAuthenticationOnboardingFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, newWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class NewWalletAuthenticationOnboardingFragmentSubcomponentImpl implements com.toshi.view.activity.x2 {
            private final DaggerAppComponent appComponent;
            private final NewWalletAuthenticationOnboardingFragmentSubcomponentImpl newWalletAuthenticationOnboardingFragmentSubcomponentImpl;
            private Provider<e.j.n.u2> newWalletAuthenticationOnboardingViewModelProvider;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private GenericViewModelFactory<e.j.n.u2> genericViewModelFactoryOfNewWalletAuthenticationOnboardingViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.newWalletAuthenticationOnboardingViewModelProvider));
            }

            private void initialize(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
                this.newWalletAuthenticationOnboardingViewModelProvider = e.j.n.v2.a(this.appComponent.appPrefsProvider, this.appComponent.masterSeedHandlerProvider, this.appComponent.appLockRepositoryProvider, this.appComponent.keyStoreHandlerProvider, this.appComponent.userRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.mnemonicRepositoryProvider);
            }

            private NewWalletAuthenticationOnboardingFragment injectNewWalletAuthenticationOnboardingFragment(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
                dagger.android.g.i.a(newWalletAuthenticationOnboardingFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.onboarding.authMethod.h.b(newWalletAuthenticationOnboardingFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.c(newWalletAuthenticationOnboardingFragment, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.a(newWalletAuthenticationOnboardingFragment, (ApplicationService) this.appComponent.applicationServiceProvider.get());
                com.toshi.view.fragment.onboarding.authMethod.i.a(newWalletAuthenticationOnboardingFragment, genericViewModelFactoryOfNewWalletAuthenticationOnboardingViewModel());
                return newWalletAuthenticationOnboardingFragment;
            }

            private NewWalletAuthenticationOnboardingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
                this.newWalletAuthenticationOnboardingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(newWalletAuthenticationOnboardingFragment);
            }

            @Override // dagger.android.b
            public void inject(NewWalletAuthenticationOnboardingFragment newWalletAuthenticationOnboardingFragment) {
                injectNewWalletAuthenticationOnboardingFragment(newWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_BPF_BackupPickerFragmentSubcomponentFactory implements o2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_BPF_BackupPickerFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.o2 create(BackupPickerFragment backupPickerFragment) {
                f.c.h.b(backupPickerFragment);
                return new OWAFBM_BPF_BackupPickerFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, backupPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_BPF_BackupPickerFragmentSubcomponentImpl implements com.toshi.view.activity.o2 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_BPF_BackupPickerFragmentSubcomponentImpl oWAFBM_BPF_BackupPickerFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private BackupPickerFragment injectBackupPickerFragment(BackupPickerFragment backupPickerFragment) {
                dagger.android.g.i.a(backupPickerFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return backupPickerFragment;
            }

            private OWAFBM_BPF_BackupPickerFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, BackupPickerFragment backupPickerFragment) {
                this.oWAFBM_BPF_BackupPickerFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(BackupPickerFragment backupPickerFragment) {
                injectBackupPickerFragment(backupPickerFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory implements p2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.p2 create(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                f.c.h.b(backupRecoveryPhraseFragment);
                return new OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl implements com.toshi.view.activity.p2 {
            private final DaggerAppComponent appComponent;
            private Provider<BackupRecoveryPhraseViewModel> backupRecoveryPhraseViewModelProvider;
            private final OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl oWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactoryOfBackupRecoveryPhraseViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.backupRecoveryPhraseViewModelProvider));
            }

            private void initialize(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.backupRecoveryPhraseViewModelProvider = BackupRecoveryPhraseViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private BackupRecoveryPhraseFragment injectBackupRecoveryPhraseFragment(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                dagger.android.g.i.a(backupRecoveryPhraseFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                BackupRecoveryPhraseFragment_MembersInjector.injectAuthenticationHelper(backupRecoveryPhraseFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                BackupRecoveryPhraseFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(backupRecoveryPhraseFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                BackupRecoveryPhraseFragment_MembersInjector.injectViewModelFactory(backupRecoveryPhraseFragment, genericViewModelFactoryOfBackupRecoveryPhraseViewModel());
                return backupRecoveryPhraseFragment;
            }

            private OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                this.oWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(backupRecoveryPhraseFragment);
            }

            @Override // dagger.android.b
            public void inject(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment) {
                injectBackupRecoveryPhraseFragment(backupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_CPF_CreatePasswordFragmentSubcomponentFactory implements q2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_CPF_CreatePasswordFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public q2 create(CreatePasswordFragment createPasswordFragment) {
                f.c.h.b(createPasswordFragment);
                return new OWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, createPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl implements q2 {
            private final DaggerAppComponent appComponent;
            private Provider<CreatePasswordViewModel> createPasswordViewModelProvider;
            private final OWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl oWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private GenericViewModelFactory<CreatePasswordViewModel> genericViewModelFactoryOfCreatePasswordViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.createPasswordViewModelProvider));
            }

            private void initialize(CreatePasswordFragment createPasswordFragment) {
                this.createPasswordViewModelProvider = CreatePasswordViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private CreatePasswordFragment injectCreatePasswordFragment(CreatePasswordFragment createPasswordFragment) {
                dagger.android.g.i.a(createPasswordFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                CreatePasswordFragment_MembersInjector.injectViewModelFactory(createPasswordFragment, genericViewModelFactoryOfCreatePasswordViewModel());
                return createPasswordFragment;
            }

            private OWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, CreatePasswordFragment createPasswordFragment) {
                this.oWAFBM_CPF_CreatePasswordFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(createPasswordFragment);
            }

            @Override // dagger.android.b
            public void inject(CreatePasswordFragment createPasswordFragment) {
                injectCreatePasswordFragment(createPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory implements r2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public r2 create(CreatePasswordInfoFragment createPasswordInfoFragment) {
                f.c.h.b(createPasswordInfoFragment);
                return new OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, createPasswordInfoFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl implements r2 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl oWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private CreatePasswordInfoFragment injectCreatePasswordInfoFragment(CreatePasswordInfoFragment createPasswordInfoFragment) {
                dagger.android.g.i.a(createPasswordInfoFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return createPasswordInfoFragment;
            }

            private OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, CreatePasswordInfoFragment createPasswordInfoFragment) {
                this.oWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(CreatePasswordInfoFragment createPasswordInfoFragment) {
                injectCreatePasswordInfoFragment(createPasswordInfoFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_EPF_EnterPasswordFragmentSubcomponentFactory implements s2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_EPF_EnterPasswordFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.s2 create(EnterPasswordFragment enterPasswordFragment) {
                f.c.h.b(enterPasswordFragment);
                return new OWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, enterPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl implements com.toshi.view.activity.s2 {
            private final DaggerAppComponent appComponent;
            private Provider<EnterPasswordViewModel> enterPasswordViewModelProvider;
            private final OWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl oWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private GenericViewModelFactory<EnterPasswordViewModel> genericViewModelFactoryOfEnterPasswordViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.enterPasswordViewModelProvider));
            }

            private void initialize(EnterPasswordFragment enterPasswordFragment) {
                this.enterPasswordViewModelProvider = EnterPasswordViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private EnterPasswordFragment injectEnterPasswordFragment(EnterPasswordFragment enterPasswordFragment) {
                dagger.android.g.i.a(enterPasswordFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                EnterPasswordFragment_MembersInjector.injectViewModelFactory(enterPasswordFragment, genericViewModelFactoryOfEnterPasswordViewModel());
                return enterPasswordFragment;
            }

            private OWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, EnterPasswordFragment enterPasswordFragment) {
                this.oWAFBM_EPF_EnterPasswordFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(enterPasswordFragment);
            }

            @Override // dagger.android.b
            public void inject(EnterPasswordFragment enterPasswordFragment) {
                injectEnterPasswordFragment(enterPasswordFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_LF_LandingFragmentSubcomponentFactory implements t2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_LF_LandingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.t2 create(LandingFragment landingFragment) {
                f.c.h.b(landingFragment);
                return new OWAFBM_LF_LandingFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, landingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_LF_LandingFragmentSubcomponentImpl implements com.toshi.view.activity.t2 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_LF_LandingFragmentSubcomponentImpl oWAFBM_LF_LandingFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private LandingFragment injectLandingFragment(LandingFragment landingFragment) {
                dagger.android.g.i.a(landingFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return landingFragment;
            }

            private OWAFBM_LF_LandingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, LandingFragment landingFragment) {
                this.oWAFBM_LF_LandingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LandingFragment landingFragment) {
                injectLandingFragment(landingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_LVF_LegalViewFragmentSubcomponentFactory implements v2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_LVF_LegalViewFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public v2 create(LegalViewFragment legalViewFragment) {
                f.c.h.b(legalViewFragment);
                return new OWAFBM_LVF_LegalViewFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, legalViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_LVF_LegalViewFragmentSubcomponentImpl implements v2 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_LVF_LegalViewFragmentSubcomponentImpl oWAFBM_LVF_LegalViewFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private LegalViewFragment injectLegalViewFragment(LegalViewFragment legalViewFragment) {
                dagger.android.g.i.a(legalViewFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return legalViewFragment;
            }

            private OWAFBM_LVF_LegalViewFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, LegalViewFragment legalViewFragment) {
                this.oWAFBM_LVF_LegalViewFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(LegalViewFragment legalViewFragment) {
                injectLegalViewFragment(legalViewFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_MBF_ManualBackupFragmentSubcomponentFactory implements w2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_MBF_ManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.w2 create(ManualBackupFragment manualBackupFragment) {
                f.c.h.b(manualBackupFragment);
                return new OWAFBM_MBF_ManualBackupFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_MBF_ManualBackupFragmentSubcomponentImpl implements com.toshi.view.activity.w2 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_MBF_ManualBackupFragmentSubcomponentImpl oWAFBM_MBF_ManualBackupFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private ManualBackupFragment injectManualBackupFragment(ManualBackupFragment manualBackupFragment) {
                dagger.android.g.i.a(manualBackupFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                ManualBackupFragment_MembersInjector.injectRecoveryPhraseClipboardWrapper(manualBackupFragment, (RecoveryPhraseClipboardWrapper) this.appComponent.recoveryPhraseClipboardWrapperProvider.get());
                return manualBackupFragment;
            }

            private OWAFBM_MBF_ManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, ManualBackupFragment manualBackupFragment) {
                this.oWAFBM_MBF_ManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ManualBackupFragment manualBackupFragment) {
                injectManualBackupFragment(manualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory implements c3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.c3 create(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                f.c.h.b(readMoreRecoveryPhraseFragment);
                return new OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, readMoreRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl implements com.toshi.view.activity.c3 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl oWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private ReadMoreRecoveryPhraseFragment injectReadMoreRecoveryPhraseFragment(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                dagger.android.g.i.a(readMoreRecoveryPhraseFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return readMoreRecoveryPhraseFragment;
            }

            private OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                this.oWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(ReadMoreRecoveryPhraseFragment readMoreRecoveryPhraseFragment) {
                injectReadMoreRecoveryPhraseFragment(readMoreRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_RWF_RestoreWalletFragmentSubcomponentFactory implements d3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_RWF_RestoreWalletFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.d3 create(RestoreWalletFragment restoreWalletFragment) {
                f.c.h.b(restoreWalletFragment);
                return new OWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, restoreWalletFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl implements com.toshi.view.activity.d3 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl oWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private Provider<RestoreWalletViewModel> restoreWalletViewModelProvider;

            private GenericViewModelFactory<RestoreWalletViewModel> genericViewModelFactoryOfRestoreWalletViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.restoreWalletViewModelProvider));
            }

            private void initialize(RestoreWalletFragment restoreWalletFragment) {
                this.restoreWalletViewModelProvider = RestoreWalletViewModel_Factory.create(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private RestoreWalletFragment injectRestoreWalletFragment(RestoreWalletFragment restoreWalletFragment) {
                dagger.android.g.i.a(restoreWalletFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                RestoreWalletFragment_MembersInjector.injectViewModelFactory(restoreWalletFragment, genericViewModelFactoryOfRestoreWalletViewModel());
                return restoreWalletFragment;
            }

            private OWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, RestoreWalletFragment restoreWalletFragment) {
                this.oWAFBM_RWF_RestoreWalletFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(restoreWalletFragment);
            }

            @Override // dagger.android.b
            public void inject(RestoreWalletFragment restoreWalletFragment) {
                injectRestoreWalletFragment(restoreWalletFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_SIF_SignInFragmentSubcomponentFactory implements e3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_SIF_SignInFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.e3 create(SignInFragment signInFragment) {
                f.c.h.b(signInFragment);
                return new OWAFBM_SIF_SignInFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, signInFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_SIF_SignInFragmentSubcomponentImpl implements com.toshi.view.activity.e3 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_SIF_SignInFragmentSubcomponentImpl oWAFBM_SIF_SignInFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private Provider<e.j.n.d3> signInViewModelProvider;

            private GenericViewModelFactory<e.j.n.d3> genericViewModelFactoryOfSignInViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.signInViewModelProvider));
            }

            private void initialize(SignInFragment signInFragment) {
                this.signInViewModelProvider = e.j.n.e3.a(this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private SignInFragment injectSignInFragment(SignInFragment signInFragment) {
                dagger.android.g.i.a(signInFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.n0.a(signInFragment, genericViewModelFactoryOfSignInViewModel());
                return signInFragment;
            }

            private OWAFBM_SIF_SignInFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, SignInFragment signInFragment) {
                this.oWAFBM_SIF_SignInFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(signInFragment);
            }

            @Override // dagger.android.b
            public void inject(SignInFragment signInFragment) {
                injectSignInFragment(signInFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory implements g3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.g3 create(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                f.c.h.b(signInWalletAuthenticationOnboardingFragment);
                return new OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, signInWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl implements com.toshi.view.activity.g3 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl oWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private Provider<e.j.n.f3> signInWalletAuthenticationOnboardingViewModelProvider;

            private GenericViewModelFactory<e.j.n.f3> genericViewModelFactoryOfSignInWalletAuthenticationOnboardingViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.signInWalletAuthenticationOnboardingViewModelProvider));
            }

            private void initialize(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                this.signInWalletAuthenticationOnboardingViewModelProvider = e.j.n.g3.a(this.appComponent.appPrefsProvider, this.appComponent.masterSeedHandlerProvider, this.appComponent.appLockRepositoryProvider, this.appComponent.keyStoreHandlerProvider, this.appComponent.userRepositoryProvider, this.appComponent.walletRepositoryProvider, this.appComponent.mnemonicBackupRepositoryProvider, this.appComponent.mnemonicRepositoryProvider);
            }

            private SignInWalletAuthenticationOnboardingFragment injectSignInWalletAuthenticationOnboardingFragment(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                dagger.android.g.i.a(signInWalletAuthenticationOnboardingFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.onboarding.authMethod.h.b(signInWalletAuthenticationOnboardingFragment, (AuthenticationHelper) f.c.h.e(this.appComponent.appCoreComponent.authenticationHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.c(signInWalletAuthenticationOnboardingFragment, (e.j.l.n.b) f.c.h.e(this.appComponent.appCoreComponent.biometricHelper()));
                com.toshi.view.fragment.onboarding.authMethod.h.a(signInWalletAuthenticationOnboardingFragment, (ApplicationService) this.appComponent.applicationServiceProvider.get());
                com.toshi.view.fragment.onboarding.authMethod.j.a(signInWalletAuthenticationOnboardingFragment, genericViewModelFactoryOfSignInWalletAuthenticationOnboardingViewModel());
                return signInWalletAuthenticationOnboardingFragment;
            }

            private OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                this.oWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(signInWalletAuthenticationOnboardingFragment);
            }

            @Override // dagger.android.b
            public void inject(SignInWalletAuthenticationOnboardingFragment signInWalletAuthenticationOnboardingFragment) {
                injectSignInWalletAuthenticationOnboardingFragment(signInWalletAuthenticationOnboardingFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory implements h3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public h3 create(VerifyManualBackupFragment verifyManualBackupFragment) {
                f.c.h.b(verifyManualBackupFragment);
                return new OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl implements h3 {
            private final DaggerAppComponent appComponent;
            private final OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl oWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private Provider<i3> verifyManualBackupViewModelProvider;

            private GenericViewModelFactory<i3> genericViewModelFactoryOfVerifyManualBackupViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.verifyManualBackupViewModelProvider));
            }

            private void initialize(VerifyManualBackupFragment verifyManualBackupFragment) {
                this.verifyManualBackupViewModelProvider = j3.a(this.appComponent.mnemonicBackupRepositoryProvider);
            }

            private VerifyManualBackupFragment injectVerifyManualBackupFragment(VerifyManualBackupFragment verifyManualBackupFragment) {
                dagger.android.g.i.a(verifyManualBackupFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                VerifyManualBackupFragment_MembersInjector.injectViewModelFactory(verifyManualBackupFragment, genericViewModelFactoryOfVerifyManualBackupViewModel());
                return verifyManualBackupFragment;
            }

            private OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, VerifyManualBackupFragment verifyManualBackupFragment) {
                this.oWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(verifyManualBackupFragment);
            }

            @Override // dagger.android.b
            public void inject(VerifyManualBackupFragment verifyManualBackupFragment) {
                injectVerifyManualBackupFragment(verifyManualBackupFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OnboardingBackupRecoveryPhraseFragmentSubcomponentFactory implements y2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OnboardingBackupRecoveryPhraseFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.y2 create(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment) {
                f.c.h.b(onboardingBackupRecoveryPhraseFragment);
                return new OnboardingBackupRecoveryPhraseFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, onboardingBackupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OnboardingBackupRecoveryPhraseFragmentSubcomponentImpl implements com.toshi.view.activity.y2 {
            private final DaggerAppComponent appComponent;
            private final OnboardingBackupRecoveryPhraseFragmentSubcomponentImpl onboardingBackupRecoveryPhraseFragmentSubcomponentImpl;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OnboardingBackupRecoveryPhraseFragment injectOnboardingBackupRecoveryPhraseFragment(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment) {
                dagger.android.g.i.a(onboardingBackupRecoveryPhraseFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                OnboardingBackupRecoveryPhraseFragment_MembersInjector.injectViewModelFactory(onboardingBackupRecoveryPhraseFragment, onboardingBackupRecoveryPhraseViewModel_AssistedFactory());
                return onboardingBackupRecoveryPhraseFragment;
            }

            private OnboardingBackupRecoveryPhraseViewModel_AssistedFactory onboardingBackupRecoveryPhraseViewModel_AssistedFactory() {
                return new OnboardingBackupRecoveryPhraseViewModel_AssistedFactory(this.appComponent.storeProvider);
            }

            private OnboardingBackupRecoveryPhraseFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment) {
                this.onboardingBackupRecoveryPhraseFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(OnboardingBackupRecoveryPhraseFragment onboardingBackupRecoveryPhraseFragment) {
                injectOnboardingBackupRecoveryPhraseFragment(onboardingBackupRecoveryPhraseFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OnboardingWizardFragmentSubcomponentFactory implements z2.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private OnboardingWizardFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.z2 create(OnboardingWizardFragment onboardingWizardFragment) {
                f.c.h.b(onboardingWizardFragment);
                return new OnboardingWizardFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, onboardingWizardFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class OnboardingWizardFragmentSubcomponentImpl implements com.toshi.view.activity.z2 {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private final OnboardingWizardFragmentSubcomponentImpl onboardingWizardFragmentSubcomponentImpl;

            @Override // dagger.android.b
            public void inject(OnboardingWizardFragment onboardingWizardFragment) {
            }

            private OnboardingWizardFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, OnboardingWizardFragment onboardingWizardFragment) {
                this.onboardingWizardFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class PickUsernameFragmentSubcomponentFactory implements a3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private PickUsernameFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public a3 create(PickUsernameFragment pickUsernameFragment) {
                f.c.h.b(pickUsernameFragment);
                return new PickUsernameFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, pickUsernameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class PickUsernameFragmentSubcomponentImpl implements a3 {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private final PickUsernameFragmentSubcomponentImpl pickUsernameFragmentSubcomponentImpl;
            private Provider<e.j.n.w2> pickUsernameViewModelProvider;

            private GenericViewModelFactory<e.j.n.w2> genericViewModelFactoryOfPickUsernameViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.pickUsernameViewModelProvider));
            }

            private void initialize(PickUsernameFragment pickUsernameFragment) {
                this.pickUsernameViewModelProvider = e.j.n.x2.a(this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private PickUsernameFragment injectPickUsernameFragment(PickUsernameFragment pickUsernameFragment) {
                dagger.android.g.i.a(pickUsernameFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.pickUsername.i.a(pickUsernameFragment, genericViewModelFactoryOfPickUsernameViewModel());
                return pickUsernameFragment;
            }

            private PickUsernameFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, PickUsernameFragment pickUsernameFragment) {
                this.pickUsernameFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(pickUsernameFragment);
            }

            @Override // dagger.android.b
            public void inject(PickUsernameFragment pickUsernameFragment) {
                injectPickUsernameFragment(pickUsernameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class PrivacySelectionFragmentSubcomponentFactory implements b3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private PrivacySelectionFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.b3 create(PrivacySelectionFragment privacySelectionFragment) {
                f.c.h.b(privacySelectionFragment);
                return new PrivacySelectionFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, privacySelectionFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class PrivacySelectionFragmentSubcomponentImpl implements com.toshi.view.activity.b3 {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private final PrivacySelectionFragmentSubcomponentImpl privacySelectionFragmentSubcomponentImpl;

            private PrivacySelectionFragment injectPrivacySelectionFragment(PrivacySelectionFragment privacySelectionFragment) {
                dagger.android.g.i.a(privacySelectionFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                return privacySelectionFragment;
            }

            private PrivacySelectionFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, PrivacySelectionFragment privacySelectionFragment) {
                this.privacySelectionFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b
            public void inject(PrivacySelectionFragment privacySelectionFragment) {
                injectPrivacySelectionFragment(privacySelectionFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignInPickUsernameFragmentSubcomponentFactory implements f3.a {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;

            private SignInPickUsernameFragmentSubcomponentFactory(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl) {
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
            }

            @Override // dagger.android.b.a
            public com.toshi.view.activity.f3 create(SignInPickUsernameFragment signInPickUsernameFragment) {
                f.c.h.b(signInPickUsernameFragment);
                return new SignInPickUsernameFragmentSubcomponentImpl(this.appComponent, this.onboardingWizardActivitySubcomponentImpl, signInPickUsernameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static final class SignInPickUsernameFragmentSubcomponentImpl implements com.toshi.view.activity.f3 {
            private final DaggerAppComponent appComponent;
            private final OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl;
            private Provider<e.j.n.w2> pickUsernameViewModelProvider;
            private final SignInPickUsernameFragmentSubcomponentImpl signInPickUsernameFragmentSubcomponentImpl;

            private GenericViewModelFactory<e.j.n.w2> genericViewModelFactoryOfPickUsernameViewModel() {
                return new GenericViewModelFactory<>(f.c.c.a(this.pickUsernameViewModelProvider));
            }

            private void initialize(SignInPickUsernameFragment signInPickUsernameFragment) {
                this.pickUsernameViewModelProvider = e.j.n.x2.a(this.appComponent.mnemonicRepositoryProvider, this.appComponent.userRepositoryProvider);
            }

            private SignInPickUsernameFragment injectSignInPickUsernameFragment(SignInPickUsernameFragment signInPickUsernameFragment) {
                dagger.android.g.i.a(signInPickUsernameFragment, this.onboardingWizardActivitySubcomponentImpl.dispatchingAndroidInjectorOfObject());
                com.toshi.view.fragment.pickUsername.i.a(signInPickUsernameFragment, genericViewModelFactoryOfPickUsernameViewModel());
                return signInPickUsernameFragment;
            }

            private SignInPickUsernameFragmentSubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivitySubcomponentImpl onboardingWizardActivitySubcomponentImpl, SignInPickUsernameFragment signInPickUsernameFragment) {
                this.signInPickUsernameFragmentSubcomponentImpl = this;
                this.appComponent = daggerAppComponent;
                this.onboardingWizardActivitySubcomponentImpl = onboardingWizardActivitySubcomponentImpl;
                initialize(signInPickUsernameFragment);
            }

            @Override // dagger.android.b
            public void inject(SignInPickUsernameFragment signInPickUsernameFragment) {
                injectSignInPickUsernameFragment(signInPickUsernameFragment);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public DispatchingAndroidInjector<Object> dispatchingAndroidInjectorOfObject() {
            return dagger.android.e.a(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), com.google.common.collect.m.l());
        }

        private GenericViewModelFactory<e.j.n.a2> genericViewModelFactoryOfBannedLocationViewModel() {
            return new GenericViewModelFactory<>(f.c.c.a(this.bannedLocationViewModelProvider));
        }

        private void initialize(OnboardingWizardActivity onboardingWizardActivity) {
            this.landingFragmentSubcomponentFactoryProvider = new Provider<t2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public t2.a get() {
                    return new OWAFBM_LF_LandingFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.signInFragmentSubcomponentFactoryProvider = new Provider<e3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public e3.a get() {
                    return new OWAFBM_SIF_SignInFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.legalAgreementFragmentSubcomponentFactoryProvider = new Provider<u2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public u2.a get() {
                    return new LegalAgreementFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.pickUsernameFragmentSubcomponentFactoryProvider = new Provider<a3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public a3.a get() {
                    return new PickUsernameFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.privacySelectionFragmentSubcomponentFactoryProvider = new Provider<b3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.5
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public b3.a get() {
                    return new PrivacySelectionFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.newWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider = new Provider<x2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public x2.a get() {
                    return new NewWalletAuthenticationOnboardingFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.onboardingBackupRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<y2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public y2.a get() {
                    return new OnboardingBackupRecoveryPhraseFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider = new Provider<g3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.8
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public g3.a get() {
                    return new OWAFBM_SIWAOF_SignInWalletAuthenticationOnboardingFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<c3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public c3.a get() {
                    return new OWAFBM_RMRPF_ReadMoreRecoveryPhraseFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.legalViewFragmentSubcomponentFactoryProvider = new Provider<v2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.10
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public v2.a get() {
                    return new OWAFBM_LVF_LegalViewFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.signInPickUsernameFragmentSubcomponentFactoryProvider = new Provider<f3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public f3.a get() {
                    return new SignInPickUsernameFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.restoreWalletFragmentSubcomponentFactoryProvider = new Provider<d3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.12
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public d3.a get() {
                    return new OWAFBM_RWF_RestoreWalletFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.backupPickerFragmentSubcomponentFactoryProvider = new Provider<o2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.13
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public o2.a get() {
                    return new OWAFBM_BPF_BackupPickerFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.enterPasswordFragmentSubcomponentFactoryProvider = new Provider<s2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.14
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public s2.a get() {
                    return new OWAFBM_EPF_EnterPasswordFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.onboardingWizardFragmentSubcomponentFactoryProvider = new Provider<z2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.15
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public z2.a get() {
                    return new OnboardingWizardFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider = new Provider<p2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.16
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public p2.a get() {
                    return new OWAFBM_BRPF_BackupRecoveryPhraseFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.manualBackupFragmentSubcomponentFactoryProvider = new Provider<w2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.17
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public w2.a get() {
                    return new OWAFBM_MBF_ManualBackupFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.verifyManualBackupFragmentSubcomponentFactoryProvider = new Provider<h3.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.18
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public h3.a get() {
                    return new OWAFBM_VMBF_VerifyManualBackupFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.createPasswordFragmentSubcomponentFactoryProvider = new Provider<q2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.19
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public q2.a get() {
                    return new OWAFBM_CPF_CreatePasswordFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.createPasswordInfoFragmentSubcomponentFactoryProvider = new Provider<r2.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.OnboardingWizardActivitySubcomponentImpl.20
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // javax.inject.Provider
                public r2.a get() {
                    return new OWAFBM_CPIF_CreatePasswordInfoFragmentSubcomponentFactory(OnboardingWizardActivitySubcomponentImpl.this.appComponent, OnboardingWizardActivitySubcomponentImpl.this.onboardingWizardActivitySubcomponentImpl);
                }
            };
            this.bannedLocationViewModelProvider = e.j.n.b2.a(this.appComponent.oFACRepositoryProvider);
        }

        private OnboardingWizardActivity injectOnboardingWizardActivity(OnboardingWizardActivity onboardingWizardActivity) {
            dagger.android.g.c.a(onboardingWizardActivity, dispatchingAndroidInjectorOfObject());
            com.toshi.view.activity.i3.a(onboardingWizardActivity, genericViewModelFactoryOfBannedLocationViewModel());
            return onboardingWizardActivity;
        }

        private Map<Class<?>, Provider<b.a<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
            return com.google.common.collect.m.a().c(MainActivity.class, this.appComponent.mainActivitySubcomponentFactoryProvider).c(OnboardingWizardActivity.class, this.appComponent.onboardingWizardActivitySubcomponentFactoryProvider).c(SetupPinLockActivity.class, this.appComponent.setupPinLockActivitySubcomponentFactoryProvider).c(BannedLocationActivity.class, this.appComponent.bannedLocationActivitySubcomponentFactoryProvider).c(UMOActivity.class, this.appComponent.uMOActivitySubcomponentFactoryProvider).c(LandingFragment.class, this.landingFragmentSubcomponentFactoryProvider).c(SignInFragment.class, this.signInFragmentSubcomponentFactoryProvider).c(LegalAgreementFragment.class, this.legalAgreementFragmentSubcomponentFactoryProvider).c(PickUsernameFragment.class, this.pickUsernameFragmentSubcomponentFactoryProvider).c(PrivacySelectionFragment.class, this.privacySelectionFragmentSubcomponentFactoryProvider).c(NewWalletAuthenticationOnboardingFragment.class, this.newWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider).c(OnboardingBackupRecoveryPhraseFragment.class, this.onboardingBackupRecoveryPhraseFragmentSubcomponentFactoryProvider).c(SignInWalletAuthenticationOnboardingFragment.class, this.signInWalletAuthenticationOnboardingFragmentSubcomponentFactoryProvider).c(ReadMoreRecoveryPhraseFragment.class, this.readMoreRecoveryPhraseFragmentSubcomponentFactoryProvider).c(LegalViewFragment.class, this.legalViewFragmentSubcomponentFactoryProvider).c(SignInPickUsernameFragment.class, this.signInPickUsernameFragmentSubcomponentFactoryProvider).c(RestoreWalletFragment.class, this.restoreWalletFragmentSubcomponentFactoryProvider).c(BackupPickerFragment.class, this.backupPickerFragmentSubcomponentFactoryProvider).c(EnterPasswordFragment.class, this.enterPasswordFragmentSubcomponentFactoryProvider).c(OnboardingWizardFragment.class, this.onboardingWizardFragmentSubcomponentFactoryProvider).c(BackupRecoveryPhraseFragment.class, this.backupRecoveryPhraseFragmentSubcomponentFactoryProvider).c(ManualBackupFragment.class, this.manualBackupFragmentSubcomponentFactoryProvider).c(VerifyManualBackupFragment.class, this.verifyManualBackupFragmentSubcomponentFactoryProvider).c(CreatePasswordFragment.class, this.createPasswordFragmentSubcomponentFactoryProvider).c(CreatePasswordInfoFragment.class, this.createPasswordInfoFragmentSubcomponentFactoryProvider).a();
        }

        private OnboardingWizardActivitySubcomponentImpl(DaggerAppComponent daggerAppComponent, OnboardingWizardActivity onboardingWizardActivity) {
            this.onboardingWizardActivitySubcomponentImpl = this;
            this.appComponent = daggerAppComponent;
            initialize(onboardingWizardActivity);
        }

        @Override // dagger.android.b
        public void inject(OnboardingWizardActivity onboardingWizardActivity) {
            injectOnboardingWizardActivity(onboardingWizardActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetupPinLockActivitySubcomponentFactory implements e.a {
        private final DaggerAppComponent appComponent;

        private SetupPinLockActivitySubcomponentFactory(DaggerAppComponent daggerAppComponent) {
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b.a
        public com.toshi.view.activity.e create(SetupPinLockActivity setupPinLockActivity) {
            f.c.h.b(setupPinLockActivity);
            return new SetupPinLockActivitySubcomponentImpl(setupPinLockActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class SetupPinLockActivitySubcomponentImpl implements com.toshi.view.activity.e {
        private final DaggerAppComponent appComponent;
        private final SetupPinLockActivitySubcomponentImpl setupPinLockActivitySubcomponentImpl;

        private GenericViewModelFactory<e.j.n.p3.q> genericViewModelFactoryOfSetupPinLockViewModel() {
            return new GenericViewModelFactory<>(f.c.c.a(e.j.n.p3.r.a()));
        }

        private SetupPinLockActivity injectSetupPinLockActivity(SetupPinLockActivity setupPinLockActivity) {
            dagger.android.g.c.a(setupPinLockActivity, this.appComponent.dispatchingAndroidInjectorOfObject());
            com.toshi.view.activity.pin.k.a(setupPinLockActivity, genericViewModelFactoryOfSetupPinLockViewModel());
            return setupPinLockActivity;
        }

        private SetupPinLockActivitySubcomponentImpl(DaggerAppComponent daggerAppComponent, SetupPinLockActivity setupPinLockActivity) {
            this.setupPinLockActivitySubcomponentImpl = this;
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b
        public void inject(SetupPinLockActivity setupPinLockActivity) {
            injectSetupPinLockActivity(setupPinLockActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class UMOActivitySubcomponentFactory implements f.a {
        private final DaggerAppComponent appComponent;

        private UMOActivitySubcomponentFactory(DaggerAppComponent daggerAppComponent) {
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b.a
        public com.toshi.view.activity.f create(UMOActivity uMOActivity) {
            f.c.h.b(uMOActivity);
            return new UMOActivitySubcomponentImpl(uMOActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class UMOActivitySubcomponentImpl implements com.toshi.view.activity.f {
        private final DaggerAppComponent appComponent;
        private final UMOActivitySubcomponentImpl uMOActivitySubcomponentImpl;

        private UMOActivity injectUMOActivity(UMOActivity uMOActivity) {
            dagger.android.g.c.a(uMOActivity, this.appComponent.dispatchingAndroidInjectorOfObject());
            UMOActivity_MembersInjector.injectStore(uMOActivity, (StoreInterface) f.c.h.e(this.appComponent.appCoreComponent.store()));
            UMOActivity_MembersInjector.injectConsumerUserRepository(uMOActivity, (ConsumerUserRepository) this.appComponent.consumerUserRepositoryProvider.get());
            UMOActivity_MembersInjector.injectConsumerAccountsRepository(uMOActivity, (ConsumerAccountsRepository) this.appComponent.consumerAccountsRepositoryProvider.get());
            UMOActivity_MembersInjector.injectConsumerTransferRepository(uMOActivity, (ConsumerTransferRepository) this.appComponent.consumerTransferRepositoryProvider.get());
            UMOActivity_MembersInjector.injectBuildConfig(uMOActivity, (BuildConfigWrapper) f.c.h.e(this.appComponent.appCoreComponent.buildConfigWrapper()));
            UMOActivity_MembersInjector.injectNetworkConfig(uMOActivity, (ConsumerNetworkConfig) f.c.h.e(this.appComponent.consumerCoreComponent.consumerNetworkConfig()));
            UMOActivity_MembersInjector.injectCoinbase(uMOActivity, f.c.c.a(this.appComponent.coinbaseSdkProvider));
            return uMOActivity;
        }

        private UMOActivitySubcomponentImpl(DaggerAppComponent daggerAppComponent, UMOActivity uMOActivity) {
            this.uMOActivitySubcomponentImpl = this;
            this.appComponent = daggerAppComponent;
        }

        @Override // dagger.android.b
        public void inject(UMOActivity uMOActivity) {
            injectUMOActivity(uMOActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_coinbaseSdk implements Provider<Coinbase> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_coinbaseSdk(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Coinbase get() {
            return (Coinbase) f.c.h.e(this.consumerCoreComponent.coinbaseSdk());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAPI implements Provider<ConsumerAPI> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAPI(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerAPI get() {
            return (ConsumerAPI) f.c.h.e(this.consumerCoreComponent.consumerAPI());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAccountsDAO implements Provider<ConsumerAccountsDAO> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAccountsDAO(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerAccountsDAO get() {
            return (ConsumerAccountsDAO) f.c.h.e(this.consumerCoreComponent.consumerAccountsDAO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAvailablePaymentMethodsDAO implements Provider<ConsumerAvailablePaymentMethodsDAO> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAvailablePaymentMethodsDAO(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerAvailablePaymentMethodsDAO get() {
            return (ConsumerAvailablePaymentMethodsDAO) f.c.h.e(this.consumerCoreComponent.consumerAvailablePaymentMethodsDAO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerDatabase implements Provider<Database<ConsumerDatabase>> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerDatabase(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Database<ConsumerDatabase> get() {
            return (Database) f.c.h.e(this.consumerCoreComponent.consumerDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerNetworkConfig implements Provider<ConsumerNetworkConfig> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerNetworkConfig(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerNetworkConfig get() {
            return (ConsumerNetworkConfig) f.c.h.e(this.consumerCoreComponent.consumerNetworkConfig());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerPaymentMethodsDAO implements Provider<ConsumerPaymentMethodsDAO> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerPaymentMethodsDAO(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerPaymentMethodsDAO get() {
            return (ConsumerPaymentMethodsDAO) f.c.h.e(this.consumerCoreComponent.consumerPaymentMethodsDAO());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerWebviewConfig implements Provider<ConsumerWebViewConfig> {
        private final ConsumerCoreComponent consumerCoreComponent;

        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerWebviewConfig(ConsumerCoreComponent consumerCoreComponent) {
            this.consumerCoreComponent = consumerCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ConsumerWebViewConfig get() {
            return (ConsumerWebViewConfig) f.c.h.e(this.consumerCoreComponent.consumerWebviewConfig());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_accessTokenRepository implements Provider<AccessTokenRepository> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_accessTokenRepository(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AccessTokenRepository get() {
            return (AccessTokenRepository) f.c.h.e(this.appCoreComponent.accessTokenRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_appLockRepository implements Provider<AppLockRepositoryInterface> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_appLockRepository(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AppLockRepositoryInterface get() {
            return (AppLockRepositoryInterface) f.c.h.e(this.appCoreComponent.appLockRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_appPrefs implements Provider<e.j.j.b> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_appPrefs(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public e.j.j.b get() {
            return (e.j.j.b) f.c.h.e(this.appCoreComponent.appPrefs());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_authenticationHelper implements Provider<AuthenticationHelper> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_authenticationHelper(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public AuthenticationHelper get() {
            return (AuthenticationHelper) f.c.h.e(this.appCoreComponent.authenticationHelper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_base64 implements Provider<e.j.l.o.a> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_base64(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public e.j.l.o.a get() {
            return (e.j.l.o.a) f.c.h.e(this.appCoreComponent.base64());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_baseApplication implements Provider<BaseApplication> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_baseApplication(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public BaseApplication get() {
            return (BaseApplication) f.c.h.e(this.appCoreComponent.baseApplication());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_buildConfigWrapper implements Provider<BuildConfigWrapper> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_buildConfigWrapper(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public BuildConfigWrapper get() {
            return (BuildConfigWrapper) f.c.h.e(this.appCoreComponent.buildConfigWrapper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_cache implements Provider<Cache> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_cache(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        @Override // javax.inject.Provider
        public Cache get() {
            return (Cache) f.c.h.e(this.appCoreComponent.cache());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_featureFlagsRepository implements Provider<FeatureFlagsRepository> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_featureFlagsRepository(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public FeatureFlagsRepository get() {
            return (FeatureFlagsRepository) f.c.h.e(this.appCoreComponent.featureFlagsRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_keyStoreHandler implements Provider<e.j.d.g.t> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_keyStoreHandler(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public e.j.d.g.t get() {
            return (e.j.d.g.t) f.c.h.e(this.appCoreComponent.keyStoreHandler());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_masterSeedHandler implements Provider<e.j.d.g.w> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_masterSeedHandler(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public e.j.d.g.w get() {
            return (e.j.d.g.w) f.c.h.e(this.appCoreComponent.masterSeedHandler());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_mnemonicRepository implements Provider<MnemonicRepositoryInterface> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_mnemonicRepository(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public MnemonicRepositoryInterface get() {
            return (MnemonicRepositoryInterface) f.c.h.e(this.appCoreComponent.mnemonicRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_moshi implements Provider<Moshi> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_moshi(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Moshi get() {
            return (Moshi) f.c.h.e(this.appCoreComponent.moshi());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_retrofitWalletService implements Provider<retrofit2.t> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_retrofitWalletService(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        @Override // javax.inject.Provider
        public retrofit2.t get() {
            return (retrofit2.t) f.c.h.e(this.appCoreComponent.retrofitWalletService());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_di_AppCoreComponent_store implements Provider<StoreInterface> {
        private final AppCoreComponent appCoreComponent;

        com_coinbase_wallet_di_AppCoreComponent_store(AppCoreComponent appCoreComponent) {
            this.appCoreComponent = appCoreComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public StoreInterface get() {
            return (StoreInterface) f.c.h.e(this.appCoreComponent.store());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_lending_di_LendContainer_lendDatabase implements Provider<Database<LendDatabase>> {
        private final LendContainer lendContainer;

        com_coinbase_wallet_lending_di_LendContainer_lendDatabase(LendContainer lendContainer) {
            this.lendContainer = lendContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Database<LendDatabase> get() {
            return (Database) f.c.h.e(this.lendContainer.lendDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_lending_di_LendContainer_lendRepository implements Provider<ILendRepository> {
        private final LendContainer lendContainer;

        com_coinbase_wallet_lending_di_LendContainer_lendRepository(LendContainer lendContainer) {
            this.lendContainer = lendContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ILendRepository get() {
            return (ILendRepository) f.c.h.e(this.lendContainer.lendRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_swap_di_SwapComponent_swapRepository implements Provider<ISwapRepository> {
        private final SwapComponent swapComponent;

        com_coinbase_wallet_swap_di_SwapComponent_swapRepository(SwapComponent swapComponent) {
            this.swapComponent = swapComponent;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ISwapRepository get() {
            return (ISwapRepository) f.c.h.e(this.swapComponent.swapRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_CryptoContainer_application implements Provider<Application> {
        private final CryptoContainer cryptoContainer;

        com_coinbase_wallet_wallets_di_CryptoContainer_application(CryptoContainer cryptoContainer) {
            this.cryptoContainer = cryptoContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Application get() {
            return (Application) f.c.h.e(this.cryptoContainer.application());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore implements Provider<CipherCoreInterface> {
        private final CryptoContainer cryptoContainer;

        com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore(CryptoContainer cryptoContainer) {
            this.cryptoContainer = cryptoContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CipherCoreInterface get() {
            return (CipherCoreInterface) f.c.h.e(this.cryptoContainer.cipherCore());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_CryptoContainer_context implements Provider<Context> {
        private final CryptoContainer cryptoContainer;

        com_coinbase_wallet_wallets_di_CryptoContainer_context(CryptoContainer cryptoContainer) {
            this.cryptoContainer = cryptoContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Context get() {
            return (Context) f.c.h.e(this.cryptoContainer.context());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_compoundFinanceRepository implements Provider<CompoundFinanceRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_compoundFinanceRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CompoundFinanceRepository get() {
            return (CompoundFinanceRepository) f.c.h.e(this.walletsContainer.compoundFinanceRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_currencyFormatter implements Provider<CurrencyFormatter> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_currencyFormatter(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public CurrencyFormatter get() {
            return (CurrencyFormatter) f.c.h.e(this.walletsContainer.currencyFormatter());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_ethTxRepository implements Provider<IETHTxRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_ethTxRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public IETHTxRepository get() {
            return (IETHTxRepository) f.c.h.e(this.walletsContainer.ethTxRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_ethWalletRepository implements Provider<IETHWalletRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_ethWalletRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public IETHWalletRepository get() {
            return (IETHWalletRepository) f.c.h.e(this.walletsContainer.ethWalletRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_ethereumSignedTxDao implements Provider<EthereumSignedTxDao> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_ethereumSignedTxDao(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public EthereumSignedTxDao get() {
            return (EthereumSignedTxDao) f.c.h.e(this.walletsContainer.ethereumSignedTxDao());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_exchangeRateRepository implements Provider<IExchangeRateRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_exchangeRateRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public IExchangeRateRepository get() {
            return (IExchangeRateRepository) f.c.h.e(this.walletsContainer.exchangeRateRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_fiatCurrencyRepository implements Provider<IFiatCurrencyRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_fiatCurrencyRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public IFiatCurrencyRepository get() {
            return (IFiatCurrencyRepository) f.c.h.e(this.walletsContainer.fiatCurrencyRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_minerFeeAPI implements Provider<MinerFeeAPI> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_minerFeeAPI(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public MinerFeeAPI get() {
            return (MinerFeeAPI) f.c.h.e(this.walletsContainer.minerFeeAPI());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_networkSettings implements Provider<List<NetworkSetting>> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_networkSettings(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        @Override // javax.inject.Provider
        public List<NetworkSetting> get() {
            return (List) f.c.h.e(this.walletsContainer.networkSettings());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_txRepository implements Provider<ITxRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_txRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public ITxRepository get() {
            return (ITxRepository) f.c.h.e(this.walletsContainer.txRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_walletEngine implements Provider<WalletEngine> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_walletEngine(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public WalletEngine get() {
            return (WalletEngine) f.c.h.e(this.walletsContainer.walletEngine());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_walletRepository implements Provider<IWalletRepository> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_walletRepository(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public IWalletRepository get() {
            return (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_walletsDatabase implements Provider<Database<WalletsDatabase>> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_walletsDatabase(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public Database<WalletsDatabase> get() {
            return (Database) f.c.h.e(this.walletsContainer.walletsDatabase());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class com_coinbase_wallet_wallets_di_WalletsContainer_xrpService implements Provider<XRPService> {
        private final WalletsContainer walletsContainer;

        com_coinbase_wallet_wallets_di_WalletsContainer_xrpService(WalletsContainer walletsContainer) {
            this.walletsContainer = walletsContainer;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // javax.inject.Provider
        public XRPService get() {
            return (XRPService) f.c.h.e(this.walletsContainer.xrpService());
        }
    }

    private BitcoinCashQrCodeParser bitcoinCashQrCodeParser() {
        return new BitcoinCashQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    private BitcoinQrCodeParser bitcoinQrCodeParser() {
        return new BitcoinQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DispatchingAndroidInjector<Object> dispatchingAndroidInjectorOfObject() {
        return dagger.android.e.a(mapOfClassOfAndProviderOfAndroidInjectorFactoryOf(), com.google.common.collect.m.l());
    }

    private DogecoinQrCodeParser dogecoinQrCodeParser() {
        return new DogecoinQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    private ERC20QRCodeParser eRC20QRCodeParser() {
        return new ERC20QRCodeParser((CipherCoreInterface) f.c.h.e(this.cryptoContainer.cipherCore()));
    }

    private EthereumClassicQrCodeParser ethereumClassicQrCodeParser() {
        return new EthereumClassicQrCodeParser((CipherCoreInterface) f.c.h.e(this.cryptoContainer.cipherCore()));
    }

    private EthereumQrCodeParser ethereumQrCodeParser() {
        return new EthereumQrCodeParser((CipherCoreInterface) f.c.h.e(this.cryptoContainer.cipherCore()));
    }

    public static AppComponent.Factory factory() {
        return new Factory();
    }

    private GenericViewModelFactory<e.j.n.p3.n> genericViewModelFactoryOfPinLockViewModel() {
        return new GenericViewModelFactory<>(f.c.c.a(this.pinLockViewModelProvider));
    }

    private void initialize(RouteActionModule routeActionModule, AppCoreComponent appCoreComponent, CryptoContainer cryptoContainer, WalletsContainer walletsContainer, LendContainer lendContainer, ConsumerCoreComponent consumerCoreComponent, SwapComponent swapComponent) {
        this.mainActivitySubcomponentFactoryProvider = new Provider<c.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public c.a get() {
                return new MainActivitySubcomponentFactory();
            }
        };
        this.onboardingWizardActivitySubcomponentFactoryProvider = new Provider<d.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public d.a get() {
                return new OnboardingWizardActivitySubcomponentFactory();
            }
        };
        this.setupPinLockActivitySubcomponentFactoryProvider = new Provider<e.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public e.a get() {
                return new SetupPinLockActivitySubcomponentFactory();
            }
        };
        this.bannedLocationActivitySubcomponentFactoryProvider = new Provider<b.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.4
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public b.a get() {
                return new BannedLocationActivitySubcomponentFactory();
            }
        };
        this.uMOActivitySubcomponentFactoryProvider = new Provider<f.a>() { // from class: com.coinbase.wallet.di.DaggerAppComponent.5
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // javax.inject.Provider
            public f.a get() {
                return new UMOActivitySubcomponentFactory();
            }
        };
        this.applicationProvider = new com_coinbase_wallet_wallets_di_CryptoContainer_application(cryptoContainer);
        this.walletsDatabaseProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_walletsDatabase(walletsContainer);
        this.providesAppDatabaseProvider = f.c.c.b(DatabaseModule_ProvidesAppDatabaseFactory.create(this.applicationProvider));
        this.consumerDatabaseProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerDatabase(consumerCoreComponent);
        this.lendDatabaseProvider = new com_coinbase_wallet_lending_di_LendContainer_lendDatabase(lendContainer);
        Provider<WalletDatabase> b2 = f.c.c.b(DatabaseModule_ProvidesWalletDatabaseFactory.create(this.applicationProvider));
        this.providesWalletDatabaseProvider = b2;
        this.walletDatabaseDestroyableProvider = f.c.c.b(com.toshi.db.f.a(b2));
        Provider<DerivedDatabase> b3 = f.c.c.b(DatabaseModule_ProvidesDerivedDatabaseFactory.create(this.applicationProvider));
        this.providesDerivedDatabaseProvider = b3;
        this.derivedDatabaseDestroyableProvider = f.c.c.b(com.toshi.db.d.a(b3));
        com_coinbase_wallet_di_AppCoreComponent_baseApplication com_coinbase_wallet_di_appcorecomponent_baseapplication = new com_coinbase_wallet_di_AppCoreComponent_baseApplication(appCoreComponent);
        this.baseApplicationProvider = com_coinbase_wallet_di_appcorecomponent_baseapplication;
        this.provideWalletLinkInterfaceProvider = f.c.c.b(WalletLinkModule_ProvideWalletLinkInterfaceFactory.create(com_coinbase_wallet_di_appcorecomponent_baseapplication));
        this.appPrefsProvider = new com_coinbase_wallet_di_AppCoreComponent_appPrefs(appCoreComponent);
        com_coinbase_wallet_di_AppCoreComponent_cache com_coinbase_wallet_di_appcorecomponent_cache = new com_coinbase_wallet_di_AppCoreComponent_cache(appCoreComponent);
        this.cacheProvider = com_coinbase_wallet_di_appcorecomponent_cache;
        this.providesCacheDestroyableProvider = f.c.c.b(DestroyableModule_ProvidesCacheDestroyableFactory.create(com_coinbase_wallet_di_appcorecomponent_cache));
        this.storeProvider = new com_coinbase_wallet_di_AppCoreComponent_store(appCoreComponent);
        this.consumerAccountsDAOProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAccountsDAO(consumerCoreComponent);
        this.consumerAPIProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAPI(consumerCoreComponent);
        this.coinbaseSdkProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_coinbaseSdk(consumerCoreComponent);
        com_coinbase_wallet_di_AppCoreComponent_retrofitWalletService com_coinbase_wallet_di_appcorecomponent_retrofitwalletservice = new com_coinbase_wallet_di_AppCoreComponent_retrofitWalletService(appCoreComponent);
        this.retrofitWalletServiceProvider = com_coinbase_wallet_di_appcorecomponent_retrofitwalletservice;
        Provider<UserApiHttp> b4 = f.c.c.b(ApiModule_UserApiInterfaceFactory.create(com_coinbase_wallet_di_appcorecomponent_retrofitwalletservice));
        this.userApiInterfaceProvider = b4;
        this.userApiProvider = f.c.c.b(UserApi_Factory.create(b4));
        this.providesUserDaoProvider = f.c.c.b(DatabaseModule_ProvidesUserDaoFactory.create(this.providesDerivedDatabaseProvider));
        this.accessTokenRepositoryProvider = new com_coinbase_wallet_di_AppCoreComponent_accessTokenRepository(appCoreComponent);
        this.walletRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_walletRepository(walletsContainer);
        Provider<Tracing> b5 = f.c.c.b(AppModule_ProvidesTraceLoggerFactory.create());
        this.providesTraceLoggerProvider = b5;
        Provider<UserRepository> b6 = f.c.c.b(UserRepository_Factory.create(this.userApiProvider, this.providesUserDaoProvider, this.accessTokenRepositoryProvider, this.storeProvider, this.walletRepositoryProvider, b5));
        this.userRepositoryProvider = b6;
        this.consumerAccountsRepositoryProvider = f.c.c.b(ConsumerAccountsRepository_Factory.create(this.storeProvider, this.consumerAccountsDAOProvider, this.consumerAPIProvider, this.coinbaseSdkProvider, b6, this.walletRepositoryProvider, this.providesUserDaoProvider, this.providesTraceLoggerProvider));
        this.featureFlagsRepositoryProvider = new com_coinbase_wallet_di_AppCoreComponent_featureFlagsRepository(appCoreComponent);
        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerNetworkConfig com_coinbase_wallet_consumer_di_consumercorecomponent_consumernetworkconfig = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerNetworkConfig(consumerCoreComponent);
        this.consumerNetworkConfigProvider = com_coinbase_wallet_consumer_di_consumercorecomponent_consumernetworkconfig;
        this.consumerUserRepositoryProvider = f.c.c.b(ConsumerUserRepository_Factory.create(this.storeProvider, this.consumerAPIProvider, this.coinbaseSdkProvider, this.providesTraceLoggerProvider, this.featureFlagsRepositoryProvider, com_coinbase_wallet_consumer_di_consumercorecomponent_consumernetworkconfig));
        Provider<PushNotificationApiInterface> b7 = f.c.c.b(ApiModule_ProvidesPushNotificationApiInterfaceFactory.create(this.retrofitWalletServiceProvider));
        this.providesPushNotificationApiInterfaceProvider = b7;
        PushNotificationApi_Factory create = PushNotificationApi_Factory.create(b7);
        this.pushNotificationApiProvider = create;
        this.pushNotificationRepositoryProvider = f.c.c.b(PushNotificationRepository_Factory.create(create, this.storeProvider));
        this.compoundFinanceRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_compoundFinanceRepository(walletsContainer);
        this.txRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_txRepository(walletsContainer);
        this.currencyFormatterProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_currencyFormatter(walletsContainer);
        this.fiatCurrencyRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_fiatCurrencyRepository(walletsContainer);
        this.exchangeRateRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_exchangeRateRepository(walletsContainer);
        this.providesTxHistoryDaoProvider = f.c.c.b(DatabaseModule_ProvidesTxHistoryDaoFactory.create(this.providesAppDatabaseProvider));
        this.providesTxAddressDAOProvider = f.c.c.b(DatabaseModule_ProvidesTxAddressDAOFactory.create(this.providesAppDatabaseProvider));
        this.xrpServiceProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_xrpService(walletsContainer);
        this.ethWalletRepositoryProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_ethWalletRepository(walletsContainer);
        this.consumerPaymentMethodsDAOProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerPaymentMethodsDAO(consumerCoreComponent);
        com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAvailablePaymentMethodsDAO com_coinbase_wallet_consumer_di_consumercorecomponent_consumeravailablepaymentmethodsdao = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerAvailablePaymentMethodsDAO(consumerCoreComponent);
        this.consumerAvailablePaymentMethodsDAOProvider = com_coinbase_wallet_consumer_di_consumercorecomponent_consumeravailablepaymentmethodsdao;
        Provider<ConsumerTransferRepository> b8 = f.c.c.b(ConsumerTransferRepository_Factory.create(this.consumerAccountsRepositoryProvider, this.consumerAPIProvider, this.ethWalletRepositoryProvider, this.consumerUserRepositoryProvider, this.currencyFormatterProvider, this.consumerPaymentMethodsDAOProvider, com_coinbase_wallet_consumer_di_consumercorecomponent_consumeravailablepaymentmethodsdao, this.featureFlagsRepositoryProvider, this.exchangeRateRepositoryProvider));
        this.consumerTransferRepositoryProvider = b8;
        this.providesTxUpdatesObservableProvider = e.j.e.d.a(this.txRepositoryProvider, b8);
        this.providesWalletsObservableProvider = e.j.e.e.a(this.walletRepositoryProvider);
        this.providesGetTxStateProvider = e.j.e.c.a(this.txRepositoryProvider);
        this.txHistoryRepositoryProvider = f.c.c.b(TxHistoryRepository_Factory.create(this.providesTxHistoryDaoProvider, this.providesTxAddressDAOProvider, TxHistoryApi_Factory.create(), this.walletRepositoryProvider, this.consumerAPIProvider, this.storeProvider, this.xrpServiceProvider, this.providesTxUpdatesObservableProvider, this.providesWalletsObservableProvider, this.providesGetTxStateProvider, this.providesTraceLoggerProvider));
        this.mapOfIntegerAndProviderOfDestroyableProvider = f.c.g.b(14).c(13, this.providesCacheDestroyableProvider).c(0, this.consumerAccountsRepositoryProvider).c(1, this.consumerUserRepositoryProvider).c(2, this.walletDatabaseDestroyableProvider).c(3, this.derivedDatabaseDestroyableProvider).c(4, this.pushNotificationRepositoryProvider).c(5, this.compoundFinanceRepositoryProvider).c(6, this.txRepositoryProvider).c(7, this.currencyFormatterProvider).c(8, this.walletRepositoryProvider).c(9, this.fiatCurrencyRepositoryProvider).c(10, this.exchangeRateRepositoryProvider).c(11, this.txHistoryRepositoryProvider).c(12, this.userRepositoryProvider).b();
        Provider<CollectiblesApiHttp> b9 = f.c.c.b(ApiModule_CollectiblesApiHttpFactory.create(this.retrofitWalletServiceProvider));
        this.collectiblesApiHttpProvider = b9;
        this.collectiblesApiProvider = CollectiblesApi_Factory.create(b9);
        Provider<com.toshi.db.h.b> b10 = f.c.c.b(DatabaseModule_ProvidesCollectibleTypeDaoFactory.create(this.providesDerivedDatabaseProvider));
        this.providesCollectibleTypeDaoProvider = b10;
        this.collectibleTypesRepositoryProvider = f.c.c.b(e.j.i.x1.a(this.collectiblesApiProvider, b10, this.walletRepositoryProvider, this.providesTraceLoggerProvider));
        this.providesSecurityProviderPrompt$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesSecurityProviderPrompt$app_productionReleaseFactory.create(this.baseApplicationProvider));
        this.providesVerifyAppsPrompt$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesVerifyAppsPrompt$app_productionReleaseFactory.create(this.baseApplicationProvider));
        this.providesSwapTOSNotification$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesSwapTOSNotification$app_productionReleaseFactory.create(this.featureFlagsRepositoryProvider, this.appPrefsProvider));
        this.providesConsumerNotification$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesConsumerNotification$app_productionReleaseFactory.create(this.consumerUserRepositoryProvider, this.appPrefsProvider, this.featureFlagsRepositoryProvider));
        this.providesConsumerOnrampNotification$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesConsumerOnrampNotification$app_productionReleaseFactory.create(this.consumerUserRepositoryProvider, this.appPrefsProvider, this.featureFlagsRepositoryProvider));
        this.base64Provider = new com_coinbase_wallet_di_AppCoreComponent_base64(appCoreComponent);
        this.providesRfc3399SimpleDateFormatProvider = f.c.c.b(AppModule_ProvidesRfc3399SimpleDateFormatFactory.create());
        this.moshiProvider = new com_coinbase_wallet_di_AppCoreComponent_moshi(appCoreComponent);
        com_coinbase_wallet_di_AppCoreComponent_buildConfigWrapper com_coinbase_wallet_di_appcorecomponent_buildconfigwrapper = new com_coinbase_wallet_di_AppCoreComponent_buildConfigWrapper(appCoreComponent);
        this.buildConfigWrapperProvider = com_coinbase_wallet_di_appcorecomponent_buildconfigwrapper;
        Provider<e.j.i.a2> b11 = f.c.c.b(e.j.i.b2.a(this.appPrefsProvider, this.base64Provider, this.providesRfc3399SimpleDateFormatProvider, this.moshiProvider, this.storeProvider, com_coinbase_wallet_di_appcorecomponent_buildconfigwrapper));
        this.mnemonicBackupRepositoryProvider = b11;
        this.providesNewUserCloudBackupPrompt$app_productionReleaseProvider = f.c.c.b(NotificationsModule_ProvidesNewUserCloudBackupPrompt$app_productionReleaseFactory.create(b11, this.storeProvider));
        f.c.g b12 = f.c.g.b(6).c(0, this.providesSecurityProviderPrompt$app_productionReleaseProvider).c(1, this.providesVerifyAppsPrompt$app_productionReleaseProvider).c(2, this.providesSwapTOSNotification$app_productionReleaseProvider).c(3, this.providesConsumerNotification$app_productionReleaseProvider).c(4, this.providesConsumerOnrampNotification$app_productionReleaseProvider).c(5, this.providesNewUserCloudBackupPrompt$app_productionReleaseProvider).b();
        this.mapOfIntegerAndProviderOfNotificationProvider = b12;
        this.notificationRepositoryProvider = f.c.c.b(NotificationRepository_Factory.create(this.appPrefsProvider, b12, this.storeProvider));
        this.providesInternetRefreshableProvider = f.c.c.b(RefreshablesModule_ProvidesInternetRefreshableFactory.create());
        this.providesExchangeRateRepositoryProvider = f.c.c.b(this.exchangeRateRepositoryProvider);
        this.providesWalletRepositoryRefreshableProvider = f.c.c.b(this.walletRepositoryProvider);
        this.providesTxResumbmitterProvider = f.c.c.b(this.txRepositoryProvider);
        com_coinbase_wallet_lending_di_LendContainer_lendRepository com_coinbase_wallet_lending_di_lendcontainer_lendrepository = new com_coinbase_wallet_lending_di_LendContainer_lendRepository(lendContainer);
        this.lendRepositoryProvider = com_coinbase_wallet_lending_di_lendcontainer_lendrepository;
        this.providesLendRepositoryRefreshableProvider = f.c.c.b(com_coinbase_wallet_lending_di_lendcontainer_lendrepository);
        this.providesFeatureFlagsRefreshableProvider = f.c.c.b(this.featureFlagsRepositoryProvider);
        f.c.f b13 = f.c.f.b(10).c(9, this.providesInternetRefreshableProvider).c(0, this.collectibleTypesRepositoryProvider).c(1, this.providesExchangeRateRepositoryProvider).c(2, this.userRepositoryProvider).c(3, this.providesWalletRepositoryRefreshableProvider).c(4, this.providesTxResumbmitterProvider).c(5, this.txHistoryRepositoryProvider).c(6, this.providesLendRepositoryRefreshableProvider).c(7, this.consumerTransferRepositoryProvider).c(8, this.providesFeatureFlagsRefreshableProvider).b();
        this.mapOfIntegerAndRefreshableProvider = b13;
        Provider<List<Refreshable>> b14 = f.c.c.b(RefreshablesModule_ProvidesRefreshableListFactory.create(b13));
        this.providesRefreshableListProvider = b14;
        this.refreshServiceProvider = f.c.c.b(e.j.i.f2.a(b14, this.walletRepositoryProvider));
        this.providesSuggestedRecipientDaoProvider = f.c.c.b(DatabaseModule_ProvidesSuggestedRecipientDaoFactory.create(this.providesAppDatabaseProvider));
        Provider<RecipientAPIHttp> b15 = f.c.c.b(ApiModule_RecipientApiInterfaceFactory.create(this.retrofitWalletServiceProvider));
        this.recipientApiInterfaceProvider = b15;
        this.recipientAPIProvider = f.c.c.b(RecipientAPI_Factory.create(b15));
        com_coinbase_wallet_wallets_di_WalletsContainer_walletEngine com_coinbase_wallet_wallets_di_walletscontainer_walletengine = new com_coinbase_wallet_wallets_di_WalletsContainer_walletEngine(walletsContainer);
        this.walletEngineProvider = com_coinbase_wallet_wallets_di_walletscontainer_walletengine;
        Provider<ResolverService> b16 = f.c.c.b(ENSModule_ProvidesResolverServiceFactory.create(com_coinbase_wallet_wallets_di_walletscontainer_walletengine));
        this.providesResolverServiceProvider = b16;
        this.recipientRepositoryProvider = f.c.c.b(RecipientRepository_Factory.create(this.providesTxAddressDAOProvider, this.providesSuggestedRecipientDaoProvider, this.recipientAPIProvider, b16, this.storeProvider, this.consumerAccountsRepositoryProvider, this.featureFlagsRepositoryProvider, this.txRepositoryProvider));
        Provider<com.toshi.db.i.b> b17 = f.c.c.b(DatabaseModule_ProvidesErc721TokenDaoFactory.create(this.providesDerivedDatabaseProvider));
        this.providesErc721TokenDaoProvider = b17;
        this.erc721RepositoryProvider = f.c.c.b(e.j.i.z1.a(this.collectibleTypesRepositoryProvider, this.collectiblesApiProvider, b17, this.walletRepositoryProvider));
        this.mapOfIntegerAndProviderOfStartableProvider = f.c.g.b(16).c(0, this.featureFlagsRepositoryProvider).c(1, this.exchangeRateRepositoryProvider).c(2, this.userRepositoryProvider).c(3, this.collectibleTypesRepositoryProvider).c(4, this.fiatCurrencyRepositoryProvider).c(5, this.notificationRepositoryProvider).c(6, this.refreshServiceProvider).c(8, this.consumerAccountsRepositoryProvider).c(9, this.compoundFinanceRepositoryProvider).c(10, this.txRepositoryProvider).c(11, this.currencyFormatterProvider).c(12, this.walletRepositoryProvider).c(13, this.txHistoryRepositoryProvider).c(14, this.recipientRepositoryProvider).c(15, this.lendRepositoryProvider).c(16, this.erc721RepositoryProvider).b();
        this.appLockRepositoryProvider = new com_coinbase_wallet_di_AppCoreComponent_appLockRepository(appCoreComponent);
        com_coinbase_wallet_wallets_di_CryptoContainer_context com_coinbase_wallet_wallets_di_cryptocontainer_context = new com_coinbase_wallet_wallets_di_CryptoContainer_context(cryptoContainer);
        this.contextProvider = com_coinbase_wallet_wallets_di_cryptocontainer_context;
        this.migrationsDaoProvider = f.c.c.b(MigrationsDao_Factory.create(com_coinbase_wallet_wallets_di_cryptocontainer_context));
        Provider<e.j.c.a.a> b18 = f.c.c.b(e.j.c.a.b.a(this.contextProvider));
        this.consumerOAuthPrefsProvider = b18;
        this.appVersion210MigrationProvider = f.c.c.b(AppVersion210Migration_Factory.create(this.migrationsDaoProvider, b18, this.storeProvider));
        this.appVersion232MigrationProvider = f.c.c.b(AppVersion232Migration_Factory.create(this.migrationsDaoProvider, this.storeProvider, this.contextProvider));
        Provider<e.j.j.j> b19 = f.c.c.b(e.j.j.l.a(this.contextProvider));
        this.notificationPrefsProvider = b19;
        this.appVersion251MigrationProvider = f.c.c.b(AppVersion251Migration_Factory.create(this.migrationsDaoProvider, b19, this.storeProvider));
        this.appVersion304MigrationProvider = f.c.c.b(AppVersion304Migration_Factory.create(this.migrationsDaoProvider, this.contextProvider, this.storeProvider));
    }

    private void initialize2(RouteActionModule routeActionModule, AppCoreComponent appCoreComponent, CryptoContainer cryptoContainer, WalletsContainer walletsContainer, LendContainer lendContainer, ConsumerCoreComponent consumerCoreComponent, SwapComponent swapComponent) {
        f.c.g b2 = f.c.g.b(4).c(0, this.appVersion210MigrationProvider).c(1, this.appVersion232MigrationProvider).c(2, this.appVersion251MigrationProvider).c(3, this.appVersion304MigrationProvider).b();
        this.mapOfIntegerAndProviderOfMigratableProvider = b2;
        this.migrationsProvider = Migrations_Factory.create(b2);
        this.cipherCoreProvider = new com_coinbase_wallet_wallets_di_CryptoContainer_cipherCore(cryptoContainer);
        this.mnemonicRepositoryProvider = new com_coinbase_wallet_di_AppCoreComponent_mnemonicRepository(appCoreComponent);
        this.debugSettingsProvider = f.c.c.b(DebugSettings_Factory.create());
        com_coinbase_wallet_wallets_di_WalletsContainer_ethTxRepository com_coinbase_wallet_wallets_di_walletscontainer_ethtxrepository = new com_coinbase_wallet_wallets_di_WalletsContainer_ethTxRepository(walletsContainer);
        this.ethTxRepositoryProvider = com_coinbase_wallet_wallets_di_walletscontainer_ethtxrepository;
        this.walletLinkRepositoryProvider = f.c.c.b(WalletLinkRepository_Factory.create(this.provideWalletLinkInterfaceProvider, this.cipherCoreProvider, this.userRepositoryProvider, this.pushNotificationRepositoryProvider, this.ethWalletRepositoryProvider, com_coinbase_wallet_wallets_di_walletscontainer_ethtxrepository, this.walletRepositoryProvider));
        Provider<PushNotificationDisplayService> b3 = f.c.c.b(PushNotificationDisplayService_Factory.create(this.pushNotificationRepositoryProvider, this.contextProvider));
        this.pushNotificationDisplayServiceProvider = b3;
        this.applicationServiceProvider = f.c.c.b(ApplicationService_Factory.create(this.applicationProvider, this.walletsDatabaseProvider, this.providesAppDatabaseProvider, this.consumerDatabaseProvider, this.lendDatabaseProvider, this.walletDatabaseDestroyableProvider, this.derivedDatabaseDestroyableProvider, this.provideWalletLinkInterfaceProvider, this.appPrefsProvider, this.mapOfIntegerAndProviderOfDestroyableProvider, this.mapOfIntegerAndProviderOfStartableProvider, this.storeProvider, this.appLockRepositoryProvider, this.migrationsProvider, this.walletEngineProvider, this.cipherCoreProvider, this.mnemonicBackupRepositoryProvider, this.mnemonicRepositoryProvider, this.walletRepositoryProvider, this.exchangeRateRepositoryProvider, this.debugSettingsProvider, this.walletLinkRepositoryProvider, this.pushNotificationRepositoryProvider, b3));
        this.pinLockViewModelProvider = e.j.n.p3.o.a(this.appLockRepositoryProvider);
        this.appReviewRepositoryProvider = f.c.c.b(AppReviewRepository_Factory.create(this.storeProvider));
        Provider<VersioningInterface> b4 = f.c.c.b(ApiModule_ProvidesVersioningInterfaceFactory.create(this.retrofitWalletServiceProvider));
        this.providesVersioningInterfaceProvider = b4;
        this.versioningRepositoryProvider = f.c.c.b(e.j.i.h2.a(b4));
        Provider<io.branch.referral.b> b5 = f.c.c.b(AppModule_ProvidesBranchClientFactory.create(this.applicationProvider));
        this.providesBranchClientProvider = b5;
        this.deepLinkRepositoryProvider = f.c.c.b(DeepLinkRepository_Factory.create(b5));
        this.authenticationHelperProvider = new com_coinbase_wallet_di_AppCoreComponent_authenticationHelper(appCoreComponent);
        this.providesConnectivitySubjectProvider = f.c.c.b(AppModule_ProvidesConnectivitySubjectFactory.create());
        this.ethereumQrCodeParserProvider = EthereumQrCodeParser_Factory.create(this.cipherCoreProvider);
        this.ethereumClassicQrCodeParserProvider = EthereumClassicQrCodeParser_Factory.create(this.cipherCoreProvider);
        this.eRC20QRCodeParserProvider = ERC20QRCodeParser_Factory.create(this.cipherCoreProvider);
        this.stellarQrCodeParserProvider = StellarQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.xRPQrCodeParserProvider = XRPQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.bitcoinQrCodeParserProvider = BitcoinQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.bitcoinCashQrCodeParserProvider = BitcoinCashQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.litecoinQrCodeParserProvider = LitecoinQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.dogecoinQrCodeParserProvider = DogecoinQrCodeParser_Factory.create(this.txRepositoryProvider, this.walletRepositoryProvider);
        this.mapOfClassOfAndQRCodeIntentParserProvider = f.c.f.b(13).c(EthereumQrCodeParser.class, this.ethereumQrCodeParserProvider).c(EthereumClassicQrCodeParser.class, this.ethereumClassicQrCodeParserProvider).c(ERC20QRCodeParser.class, this.eRC20QRCodeParserProvider).c(StellarQrCodeParser.class, this.stellarQrCodeParserProvider).c(XRPQrCodeParser.class, this.xRPQrCodeParserProvider).c(BitcoinQrCodeParser.class, this.bitcoinQrCodeParserProvider).c(BitcoinCashQrCodeParser.class, this.bitcoinCashQrCodeParserProvider).c(LitecoinQrCodeParser.class, this.litecoinQrCodeParserProvider).c(DogecoinQrCodeParser.class, this.dogecoinQrCodeParserProvider).c(Utf8StringFixedLengthQrCodeParser.class, Utf8StringFixedLengthQrCodeParser_Factory.create()).c(HexStringFixedLengthQrCodeParser.class, HexStringFixedLengthQrCodeParser_Factory.create()).c(UnsignedIntegerQrCodeParser.class, UnsignedIntegerQrCodeParser_Factory.create()).c(WalletLinkQrParser.class, WalletLinkQrParser_Factory.create()).b();
        com_coinbase_wallet_swap_di_SwapComponent_swapRepository com_coinbase_wallet_swap_di_swapcomponent_swaprepository = new com_coinbase_wallet_swap_di_SwapComponent_swapRepository(swapComponent);
        this.swapRepositoryProvider = com_coinbase_wallet_swap_di_swapcomponent_swaprepository;
        this.providesPaymentRouteActionsProvider = RouteActionModule_ProvidesPaymentRouteActionsFactory.create(routeActionModule, this.mapOfClassOfAndQRCodeIntentParserProvider, this.walletRepositoryProvider, com_coinbase_wallet_swap_di_swapcomponent_swaprepository);
        this.providesRouteActionsProvider = RouteActionModule_ProvidesRouteActionsFactory.create(routeActionModule, this.consumerUserRepositoryProvider);
        Provider<OFACApiHttp> b6 = f.c.c.b(ApiModule_OfacApiHttpFactory.create(this.retrofitWalletServiceProvider));
        this.ofacApiHttpProvider = b6;
        OFACApi_Factory create = OFACApi_Factory.create(b6);
        this.oFACApiProvider = create;
        this.oFACRepositoryProvider = f.c.c.b(OFACRepository_Factory.create(create));
        this.recoveryPhraseClipboardWrapperProvider = f.c.c.b(RecoveryPhraseClipboardWrapper_Factory.create(this.contextProvider));
        this.providesQrParsersProvider = QrCodeParsersModule_ProvidesQrParsersFactory.create(this.mapOfClassOfAndQRCodeIntentParserProvider);
        this.providesPackageManagerProvider = f.c.c.b(AppModule_ProvidesPackageManagerFactory.create(this.baseApplicationProvider));
        this.consumerWebviewConfigProvider = new com_coinbase_wallet_consumer_di_ConsumerCoreComponent_consumerWebviewConfig(consumerCoreComponent);
        this.keyStoreHandlerProvider = new com_coinbase_wallet_di_AppCoreComponent_keyStoreHandler(appCoreComponent);
        this.displayCoinAddressFragmentFactoryProvider = f.c.c.b(com.toshi.view.fragment.i0.a(this.moshiProvider));
        this.networkSettingsProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_networkSettings(walletsContainer);
        Provider<com.toshi.db.g.b> b7 = f.c.c.b(DatabaseModule_ProvidesBookmarkDaoFactory.create(this.providesWalletDatabaseProvider));
        this.providesBookmarkDaoProvider = b7;
        this.bookmarkRepositoryProvider = f.c.c.b(e.j.i.v1.a(b7));
        this.signerViewModelProvider = f.c.c.b(SignerViewModel_Factory.create(this.ethWalletRepositoryProvider, this.walletLinkRepositoryProvider, this.pushNotificationRepositoryProvider, WalletLinkPushNotificationCreator_Factory.create(), this.appLockRepositoryProvider));
        this.minerFeeAPIProvider = new com_coinbase_wallet_wallets_di_WalletsContainer_minerFeeAPI(walletsContainer);
        com_coinbase_wallet_wallets_di_WalletsContainer_ethereumSignedTxDao com_coinbase_wallet_wallets_di_walletscontainer_ethereumsignedtxdao = new com_coinbase_wallet_wallets_di_WalletsContainer_ethereumSignedTxDao(walletsContainer);
        this.ethereumSignedTxDaoProvider = com_coinbase_wallet_wallets_di_walletscontainer_ethereumsignedtxdao;
        this.adjustableMinerFeeRepositoryProvider = f.c.c.b(AdjustableMinerFeeRepository_Factory.create(this.exchangeRateRepositoryProvider, this.currencyFormatterProvider, this.cipherCoreProvider, this.minerFeeAPIProvider, com_coinbase_wallet_wallets_di_walletscontainer_ethereumsignedtxdao, this.storeProvider));
        this.providesAmountPickerFormatterProvider = f.c.c.b(AppModule_ProvidesAmountPickerFormatterFactory.create(this.fiatCurrencyRepositoryProvider, this.exchangeRateRepositoryProvider));
        this.masterSeedHandlerProvider = new com_coinbase_wallet_di_AppCoreComponent_masterSeedHandler(appCoreComponent);
    }

    private BaseApplication injectBaseApplication(BaseApplication baseApplication) {
        dagger.android.d.a(baseApplication, dispatchingAndroidInjectorOfObject());
        BaseApplication_MembersInjector.injectApplicationService(baseApplication, this.applicationServiceProvider.get());
        return baseApplication;
    }

    private com.toshi.view.fragment.r0.e injectPinLockDialog(com.toshi.view.fragment.r0.e eVar) {
        com.toshi.view.fragment.r0.f.a(eVar, genericViewModelFactoryOfPinLockViewModel());
        return eVar;
    }

    private WalletFirebaseMessagingService injectWalletFirebaseMessagingService(WalletFirebaseMessagingService walletFirebaseMessagingService) {
        WalletFirebaseMessagingService_MembersInjector.injectPushNotificationRepository(walletFirebaseMessagingService, this.pushNotificationRepositoryProvider.get());
        WalletFirebaseMessagingService_MembersInjector.injectAppLockRepository(walletFirebaseMessagingService, (AppLockRepositoryInterface) f.c.h.e(this.appCoreComponent.appLockRepository()));
        return walletFirebaseMessagingService;
    }

    private LitecoinQrCodeParser litecoinQrCodeParser() {
        return new LitecoinQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    private Map<Class<?>, Provider<b.a<?>>> mapOfClassOfAndProviderOfAndroidInjectorFactoryOf() {
        return com.google.common.collect.m.n(MainActivity.class, this.mainActivitySubcomponentFactoryProvider, OnboardingWizardActivity.class, this.onboardingWizardActivitySubcomponentFactoryProvider, SetupPinLockActivity.class, this.setupPinLockActivitySubcomponentFactoryProvider, BannedLocationActivity.class, this.bannedLocationActivitySubcomponentFactoryProvider, UMOActivity.class, this.uMOActivitySubcomponentFactoryProvider);
    }

    private Map<Class<? extends QRCodeIntentParser>, QRCodeIntentParser> mapOfClassOfAndQRCodeIntentParser() {
        return com.google.common.collect.m.a().c(EthereumQrCodeParser.class, ethereumQrCodeParser()).c(EthereumClassicQrCodeParser.class, ethereumClassicQrCodeParser()).c(ERC20QRCodeParser.class, eRC20QRCodeParser()).c(StellarQrCodeParser.class, stellarQrCodeParser()).c(XRPQrCodeParser.class, xRPQrCodeParser()).c(BitcoinQrCodeParser.class, bitcoinQrCodeParser()).c(BitcoinCashQrCodeParser.class, bitcoinCashQrCodeParser()).c(LitecoinQrCodeParser.class, litecoinQrCodeParser()).c(DogecoinQrCodeParser.class, dogecoinQrCodeParser()).c(Utf8StringFixedLengthQrCodeParser.class, new Utf8StringFixedLengthQrCodeParser()).c(HexStringFixedLengthQrCodeParser.class, new HexStringFixedLengthQrCodeParser()).c(UnsignedIntegerQrCodeParser.class, new UnsignedIntegerQrCodeParser()).c(WalletLinkQrParser.class, new WalletLinkQrParser()).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<RouteScheme, kotlin.e0.c.l<Uri, RouteAction>> mapOfRouteSchemeAndFunction1OfUriAndRouteAction() {
        return RouteActionModule_ProvidesPaymentRouteActionsFactory.providesPaymentRouteActions(this.routeActionModule, mapOfClassOfAndQRCodeIntentParser(), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()), (ISwapRepository) f.c.h.e(this.swapComponent.swapRepository()));
    }

    private StellarQrCodeParser stellarQrCodeParser() {
        return new StellarQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    private XRPQrCodeParser xRPQrCodeParser() {
        return new XRPQrCodeParser((ITxRepository) f.c.h.e(this.walletsContainer.txRepository()), (IWalletRepository) f.c.h.e(this.walletsContainer.walletRepository()));
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public FeatureFlagsRepository featureFlagsRepository() {
        return (FeatureFlagsRepository) f.c.h.e(this.appCoreComponent.featureFlagsRepository());
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public void inject(com.toshi.view.fragment.r0.g gVar) {
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public Moshi moshi() {
        return (Moshi) f.c.h.e(this.appCoreComponent.moshi());
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public Database<WalletsDatabase> walletsDatabase() {
        return (Database) f.c.h.e(this.walletsContainer.walletsDatabase());
    }

    private DaggerAppComponent(RouteActionModule routeActionModule, AppCoreComponent appCoreComponent, CryptoContainer cryptoContainer, WalletsContainer walletsContainer, LendContainer lendContainer, ConsumerCoreComponent consumerCoreComponent, SwapComponent swapComponent) {
        this.appComponent = this;
        this.appCoreComponent = appCoreComponent;
        this.walletsContainer = walletsContainer;
        this.consumerCoreComponent = consumerCoreComponent;
        this.routeActionModule = routeActionModule;
        this.cryptoContainer = cryptoContainer;
        this.swapComponent = swapComponent;
        initialize(routeActionModule, appCoreComponent, cryptoContainer, walletsContainer, lendContainer, consumerCoreComponent, swapComponent);
        initialize2(routeActionModule, appCoreComponent, cryptoContainer, walletsContainer, lendContainer, consumerCoreComponent, swapComponent);
    }

    @Override // com.coinbase.wallet.di.AppComponent, dagger.android.b
    public void inject(BaseApplication baseApplication) {
        injectBaseApplication(baseApplication);
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public void inject(com.toshi.view.fragment.r0.e eVar) {
        injectPinLockDialog(eVar);
    }

    @Override // com.coinbase.wallet.di.AppComponent
    public void inject(WalletFirebaseMessagingService walletFirebaseMessagingService) {
        injectWalletFirebaseMessagingService(walletFirebaseMessagingService);
    }
}