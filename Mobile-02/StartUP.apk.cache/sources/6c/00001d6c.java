package com.coinbase.wallet.features.cloudbackup.view;

import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.lifecycle.i;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.authentication.AppLockType;
import com.coinbase.wallet.authentication.AuthenticationResult;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.models.ForwardArgs;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper;
import com.coinbase.wallet.features.cloudbackup.view.BackupRecoveryPhraseFragment$screenshotObserver$2;
import com.coinbase.wallet.features.cloudbackup.view.CreatePasswordInfoFragment;
import com.coinbase.wallet.features.cloudbackup.viewModel.BackupRecoveryPhraseViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.toshi.view.fragment.o0;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.spongycastle.i18n.TextBundle;
import org.toshi.R;

/* compiled from: BackupRecoveryPhraseFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000á\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001T\b\u0007\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u0095\u0001B\b¢\u0006\u0005\b\u0094\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\r\u0010\u0006J\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0006J\u000f\u0010\u0014\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0006J\u000f\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0006J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0017\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0018\u0010\u0006J\u000f\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u0006J\u0019\u0010\u001d\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0002¢\u0006\u0004\b!\u0010\"J\u0019\u0010#\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b#\u0010\u0012J-\u0010(\u001a\u00020\u00042\b\b\u0001\u0010%\u001a\u00020$2\b\b\u0001\u0010&\u001a\u00020$2\b\b\u0001\u0010'\u001a\u00020$H\u0002¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0004H\u0002¢\u0006\u0004\b*\u0010\u0006J\u000f\u0010+\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010\u0006J\u0011\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b-\u0010.J-\u00106\u001a\u0004\u0018\u0001052\u0006\u00100\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001012\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b6\u00107J!\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u0002052\b\u00104\u001a\u0004\u0018\u000103H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010\u0006J\u000f\u0010<\u001a\u00020\u0004H\u0016¢\u0006\u0004\b<\u0010\u0006J\u000f\u0010=\u001a\u00020\u0004H\u0016¢\u0006\u0004\b=\u0010\u0006J\u000f\u0010>\u001a\u00020\u0004H\u0016¢\u0006\u0004\b>\u0010\u0006J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ)\u0010D\u001a\u00020\u00042\u0006\u0010B\u001a\u00020$2\u0006\u0010C\u001a\u00020$2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016¢\u0006\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020F8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020F8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010HR\u001e\u0010N\u001a\n M*\u0004\u0018\u00010L0L8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020P8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u001d\u0010Y\u001a\u00020T8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001d\u0010^\u001a\u00020Z8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010]R\u0018\u0010_\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0016\u0010a\u001a\u00020?8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\ba\u0010AR\u001d\u0010f\u001a\u00020b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\bc\u0010V\u001a\u0004\bd\u0010eR(\u0010i\u001a\u0004\u0018\u00010g2\b\u0010h\u001a\u0004\u0018\u00010g8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\bi\u0010j\"\u0004\bk\u0010lR$\u0010n\u001a\u0010\u0012\f\u0012\n M*\u0004\u0018\u00010g0g0m8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010s\u001a\u00020p8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR\u0016\u0010u\u001a\u00020t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010x\u001a\u00020w8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bx\u0010yR#\u0010{\u001a\u00020z8\u0000@\u0000X\u0081.¢\u0006\u0013\n\u0004\b{\u0010|\u001a\u0004\b}\u0010~\"\u0005\b\u007f\u0010\u0080\u0001R \u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00020g0\u0081\u00018B@\u0002X\u0082\u0004¢\u0006\b\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R0\u0010\u0086\u0001\u001a\t\u0012\u0004\u0012\u00020w0\u0085\u00018\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R*\u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0000@\u0000X\u0081.¢\u0006\u0018\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001\"\u0006\b\u0091\u0001\u0010\u0092\u0001R\u0018\u0010\u0093\u0001\u001a\u00020?8B@\u0002X\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010A¨\u0006\u0096\u0001"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "setupGoogleAccount", "()V", "setupViewModel", "setupViews", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;", "backupStatus", "handleBackupStatusChange", "(Lcom/coinbase/wallet/features/cloudbackup/models/BackupStatus;)V", "startScreenshotObserver", "stopScreenshotObserver", "", "throwable", "handleRecoveryPhraseError", "(Ljava/lang/Throwable;)V", "showRecoveryPhraseErrorDialog", "setupRecyclerView", "setupObservers", "doCopyAndAnimate", "setupClickListeners", "signInToGoogle", "checkBannedLocation", "showBannedDialog", "Landroid/content/Intent;", "data", "handleSignIn", "(Landroid/content/Intent;)V", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "googleSignInAccount", "setupGoogleDriveClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;)V", "handleFetchBackupStatusException", "", "drawable", "color", TextBundle.TEXT_ENTRY, "setBackupStatusView", "(III)V", "navigateToCreatePasswordScreen", "navigateToManualBackupScreen", "Landroidx/appcompat/app/c;", "createAndShowScreenshotDialog", "()Landroidx/appcompat/app/c;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onResume", "onStop", "onDestroyView", "", "onBackPressed", "()Z", "requestCode", "resultCode", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "getScopeProvider", "scopeProvider", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "com/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment$screenshotObserver$2$1", "screenshotObserver$delegate", "Lkotlin/h;", "getScreenshotObserver", "()Lcom/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment$screenshotObserver$2$1;", "screenshotObserver", "Le/j/m/a/l;", "recoveryPhraseAdapter$delegate", "getRecoveryPhraseAdapter", "()Le/j/m/a/l;", "recoveryPhraseAdapter", "lastSignedInAccount", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "isBannedLocation", "Lcom/google/android/gms/auth/api/signin/c;", "googleSignInClient$delegate", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/c;", "googleSignInClient", "", "value", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Ljava/lang/String;", "setMnemonic", "(Ljava/lang/String;)V", "Lh/c/v0/a;", "mnemonicSubject", "Lh/c/v0/a;", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel$BackupMode;", "getBackupMode", "()Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel$BackupMode;", "backupMode", "Lcom/google/android/gms/common/api/Scope;", "fileScope", "Lcom/google/android/gms/common/api/Scope;", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel;", "viewModel", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel;", "Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "recoveryPhraseClipboardWrapper", "Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "getRecoveryPhraseClipboardWrapper$app_productionRelease", "()Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "setRecoveryPhraseClipboardWrapper$app_productionRelease", "(Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;)V", "Lh/c/s;", "getMnemonicObservable", "()Lh/c/s;", "mnemonicObservable", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "authenticationHelper", "Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "getAuthenticationHelper$app_productionRelease", "()Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;", "setAuthenticationHelper$app_productionRelease", "(Lcom/coinbase/wallet/features/applock/legacy/AuthenticationHelper;)V", "isModal", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupRecoveryPhraseFragment extends o0 implements StyledFragment, BackableFragment {
    public static final String BACKUP_MNEMONIC = "BACKUP_MNEMONIC";
    public static final Companion Companion = new Companion(null);
    private static final int GOOGLE_DRIVE_RECOVERY_REQUEST_CODE = 1;
    private static final int GOOGLE_SIGN_IN_REQUEST_CODE = 2;
    public static final String KEY_BACKUP_MODE = "BACKUP_MODE";
    public static final String KEY_IS_BANNED_LOCATION = "banned_location";
    public static final String KEY_MNEMONIC = "MNEMONIC";
    public AuthenticationHelper authenticationHelper;
    private final Scope fileScope;
    private final kotlin.h googleSignInClient$delegate;
    private GoogleSignInAccount lastSignedInAccount;
    private final h.c.a0 mainScheduler;
    private String mnemonic;
    private final h.c.v0.a<String> mnemonicSubject;
    private final kotlin.h recoveryPhraseAdapter$delegate;
    public RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper;
    private final kotlin.h screenshotObserver$delegate;
    private BackupRecoveryPhraseViewModel viewModel;
    public GenericViewModelFactory<BackupRecoveryPhraseViewModel> viewModelFactory;

    /* compiled from: BackupRecoveryPhraseFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0016\u0010\u0012\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/BackupRecoveryPhraseFragment$Companion;", "", "", "isBannedLocation", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel$BackupMode;", "backupMode", "Landroid/os/Bundle;", "createArgs", "(ZLjava/lang/String;Lcom/coinbase/wallet/features/cloudbackup/viewModel/BackupRecoveryPhraseViewModel$BackupMode;)Landroid/os/Bundle;", BackupRecoveryPhraseFragment.BACKUP_MNEMONIC, "Ljava/lang/String;", "", "GOOGLE_DRIVE_RECOVERY_REQUEST_CODE", "I", "GOOGLE_SIGN_IN_REQUEST_CODE", "KEY_BACKUP_MODE", "KEY_IS_BANNED_LOCATION", "KEY_MNEMONIC", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ Bundle createArgs$default(Companion companion, boolean z, String str, BackupRecoveryPhraseViewModel.BackupMode backupMode, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = false;
            }
            if ((i2 & 2) != 0) {
                str = null;
            }
            if ((i2 & 4) != 0) {
                backupMode = BackupRecoveryPhraseViewModel.BackupMode.BackupAll;
            }
            return companion.createArgs(z, str, backupMode);
        }

        public final Bundle createArgs(boolean z, String str, BackupRecoveryPhraseViewModel.BackupMode backupMode) {
            kotlin.jvm.internal.m.g(backupMode, "backupMode");
            return androidx.core.os.b.a(kotlin.u.a("banned_location", Boolean.valueOf(z)), kotlin.u.a(BackupRecoveryPhraseFragment.KEY_MNEMONIC, str), kotlin.u.a(BackupRecoveryPhraseFragment.KEY_BACKUP_MODE, backupMode));
        }
    }

    public BackupRecoveryPhraseFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        b2 = kotlin.k.b(BackupRecoveryPhraseFragment$recoveryPhraseAdapter$2.INSTANCE);
        this.recoveryPhraseAdapter$delegate = b2;
        this.fileScope = new Scope(DriveScopes.DRIVE_FILE);
        this.mainScheduler = h.c.j0.c.a.b();
        h.c.v0.a<String> d2 = h.c.v0.a.d();
        kotlin.jvm.internal.m.f(d2, "create<String>()");
        this.mnemonicSubject = d2;
        b3 = kotlin.k.b(new BackupRecoveryPhraseFragment$screenshotObserver$2(this));
        this.screenshotObserver$delegate = b3;
        b4 = kotlin.k.b(new BackupRecoveryPhraseFragment$googleSignInClient$2(this));
        this.googleSignInClient$delegate = b4;
    }

    private final void checkBannedLocation() {
        if (isBannedLocation()) {
            View view = getView();
            View cloudBackupBtn = view == null ? null : view.findViewById(e.j.a.cloudBackupBtn);
            kotlin.jvm.internal.m.f(cloudBackupBtn, "cloudBackupBtn");
            View_CommonKt.setOnSingleClickListener$default(cloudBackupBtn, 0L, new BackupRecoveryPhraseFragment$checkBannedLocation$1(this), 1, null);
            View view2 = getView();
            View manualBackupLbl = view2 == null ? null : view2.findViewById(e.j.a.manualBackupLbl);
            kotlin.jvm.internal.m.f(manualBackupLbl, "manualBackupLbl");
            View_CommonKt.setOnSingleClickListener$default(manualBackupLbl, 0L, new BackupRecoveryPhraseFragment$checkBannedLocation$2(this), 1, null);
            View view3 = getView();
            View manualBackupBtn = view3 == null ? null : view3.findViewById(e.j.a.manualBackupBtn);
            kotlin.jvm.internal.m.f(manualBackupBtn, "manualBackupBtn");
            View_CommonKt.setOnSingleClickListener$default(manualBackupBtn, 0L, new BackupRecoveryPhraseFragment$checkBannedLocation$3(this), 1, null);
            View view4 = getView();
            ((ImageButton) (view4 != null ? view4.findViewById(e.j.a.t0) : null)).setVisibility(4);
            showBannedDialog();
        }
    }

    public final androidx.appcompat.app.c createAndShowScreenshotDialog() {
        return e.j.f.m.p(this, BackupRecoveryPhraseFragment$createAndShowScreenshotDialog$1.INSTANCE);
    }

    public static /* synthetic */ boolean d(String str) {
        return m1222setupObservers$lambda2(str);
    }

    public final void doCopyAndAnimate() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn))).setClickable(false);
        String str = this.mnemonic;
        if (str != null) {
            getRecoveryPhraseClipboardWrapper$app_productionRelease().copyRecoveryPhrase(str);
        }
        int d2 = androidx.core.content.a.d(requireContext(), R.color.primary_green);
        int d3 = androidx.core.content.a.d(requireContext(), R.color.primary_blue);
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.copyToClipboardBtn))).setTextColor(d2);
        e.j.f.m.u(this, R.string.copied_to_clipboard, 0, 2, null);
        final ValueAnimator ofArgb = ValueAnimator.ofArgb(d2, d3);
        ofArgb.setDuration(250L);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.b
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BackupRecoveryPhraseFragment.e(BackupRecoveryPhraseFragment.this, ofArgb, valueAnimator);
            }
        });
        View view3 = getView();
        ((Button) (view3 != null ? view3.findViewById(e.j.a.copyToClipboardBtn) : null)).setText(getString(R.string.manual_backup_copy_to_clipboard_clear));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h.c.a0 mainScheduler = this.mainScheduler;
        kotlin.jvm.internal.m.f(mainScheduler, "mainScheduler");
        Fragment_CommonKt.withDelay(this, 2L, timeUnit, mainScheduler, new BackupRecoveryPhraseFragment$doCopyAndAnimate$2(this, ofArgb));
    }

    /* renamed from: doCopyAndAnimate$lambda-5$lambda-4 */
    public static final void m1219doCopyAndAnimate$lambda5$lambda4(BackupRecoveryPhraseFragment this$0, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        if (this$0.getActivity() != null) {
            View view = this$0.getView();
            if ((view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn)) != null) {
                View view2 = this$0.getView();
                View findViewById = view2 != null ? view2.findViewById(e.j.a.copyToClipboardBtn) : null;
                Object animatedValue = valueAnimator.getAnimatedValue();
                Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
                ((Button) findViewById).setTextColor(((Integer) animatedValue).intValue());
            }
        }
    }

    public static /* synthetic */ void e(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        m1219doCopyAndAnimate$lambda5$lambda4(backupRecoveryPhraseFragment, valueAnimator, valueAnimator2);
    }

    public static /* synthetic */ kotlin.x f(BackupRecoveryPhraseFragment backupRecoveryPhraseFragment, BackupStatus backupStatus) {
        return m1223signInToGoogle$lambda8(backupRecoveryPhraseFragment, backupStatus);
    }

    private final BackupRecoveryPhraseViewModel.BackupMode getBackupMode() {
        Bundle arguments = getArguments();
        Object obj = arguments == null ? null : arguments.get(KEY_BACKUP_MODE);
        BackupRecoveryPhraseViewModel.BackupMode backupMode = obj instanceof BackupRecoveryPhraseViewModel.BackupMode ? (BackupRecoveryPhraseViewModel.BackupMode) obj : null;
        return backupMode == null ? BackupRecoveryPhraseViewModel.BackupMode.BackupAll : backupMode;
    }

    private final com.google.android.gms.auth.api.signin.c getGoogleSignInClient() {
        Object value = this.googleSignInClient$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-googleSignInClient>(...)");
        return (com.google.android.gms.auth.api.signin.c) value;
    }

    private final h.c.s<String> getMnemonicObservable() {
        h.c.s<String> hide = this.mnemonicSubject.hide();
        kotlin.jvm.internal.m.f(hide, "mnemonicSubject.hide()");
        return hide;
    }

    public final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final e.j.m.a.l getRecoveryPhraseAdapter() {
        return (e.j.m.a.l) this.recoveryPhraseAdapter$delegate.getValue();
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    private final BackupRecoveryPhraseFragment$screenshotObserver$2.AnonymousClass1 getScreenshotObserver() {
        return (BackupRecoveryPhraseFragment$screenshotObserver$2.AnonymousClass1) this.screenshotObserver$delegate.getValue();
    }

    public final void handleBackupStatusChange(BackupStatus backupStatus) {
        if (backupStatus instanceof BackupStatus.BackedUpAll) {
            View view = getView();
            ((Button) (view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn))).setVisibility(0);
            setBackupStatusView(R.drawable.ic_icon_success, R.color.primary_green, R.string.mnemonic_backed_up);
            View view2 = getView();
            TextView textView = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.backupAccountInfo));
            Object[] objArr = new Object[1];
            GoogleSignInAccount googleSignInAccount = this.lastSignedInAccount;
            objArr[0] = googleSignInAccount == null ? null : googleSignInAccount.k1();
            textView.setText(getString(R.string.mnemonic_backup_account_info, objArr));
            View view3 = getView();
            ((TextView) (view3 == null ? null : view3.findViewById(e.j.a.backupMessage))).setVisibility(8);
            View view4 = getView();
            ((Button) (view4 == null ? null : view4.findViewById(e.j.a.manualBackupLbl))).setVisibility(8);
            View view5 = getView();
            ((TextView) (view5 == null ? null : view5.findViewById(e.j.a.backupAccountInfo))).setVisibility(0);
            View view6 = getView();
            View doneBtn = view6 == null ? null : view6.findViewById(e.j.a.Q1);
            kotlin.jvm.internal.m.f(doneBtn, "doneBtn");
            doneBtn.setVisibility(0);
            View view7 = getView();
            View manualBackupBtnGroup = view7 != null ? view7.findViewById(e.j.a.manualBackupBtnGroup) : null;
            kotlin.jvm.internal.m.f(manualBackupBtnGroup, "manualBackupBtnGroup");
            manualBackupBtnGroup.setVisibility(8);
        } else if (backupStatus instanceof BackupStatus.BackedUpToCloud) {
            View view8 = getView();
            ((Button) (view8 == null ? null : view8.findViewById(e.j.a.copyToClipboardBtn))).setVisibility(0);
            setBackupStatusView(R.drawable.ic_icon_success, R.color.primary_green, R.string.mnemonic_backed_up);
            View view9 = getView();
            TextView textView2 = (TextView) (view9 == null ? null : view9.findViewById(e.j.a.backupAccountInfo));
            Object[] objArr2 = new Object[1];
            GoogleSignInAccount googleSignInAccount2 = this.lastSignedInAccount;
            objArr2[0] = googleSignInAccount2 == null ? null : googleSignInAccount2.k1();
            textView2.setText(getString(R.string.mnemonic_backup_account_info, objArr2));
            View view10 = getView();
            ((TextView) (view10 == null ? null : view10.findViewById(e.j.a.backupAccountInfo))).setVisibility(0);
            View view11 = getView();
            View doneBtn2 = view11 == null ? null : view11.findViewById(e.j.a.Q1);
            kotlin.jvm.internal.m.f(doneBtn2, "doneBtn");
            BackupRecoveryPhraseViewModel.BackupMode backupMode = getBackupMode();
            BackupRecoveryPhraseViewModel.BackupMode backupMode2 = BackupRecoveryPhraseViewModel.BackupMode.BackupOne;
            doneBtn2.setVisibility(backupMode == backupMode2 ? 0 : 8);
            if (getBackupMode() == backupMode2) {
                View view12 = getView();
                View manualBackupBtnGroup2 = view12 == null ? null : view12.findViewById(e.j.a.manualBackupBtnGroup);
                kotlin.jvm.internal.m.f(manualBackupBtnGroup2, "manualBackupBtnGroup");
                manualBackupBtnGroup2.setVisibility(8);
                View view13 = getView();
                View doneBtn3 = view13 == null ? null : view13.findViewById(e.j.a.Q1);
                kotlin.jvm.internal.m.f(doneBtn3, "doneBtn");
                doneBtn3.setVisibility(0);
            } else {
                View view14 = getView();
                View manualBackupBtnGroup3 = view14 == null ? null : view14.findViewById(e.j.a.manualBackupBtnGroup);
                kotlin.jvm.internal.m.f(manualBackupBtnGroup3, "manualBackupBtnGroup");
                manualBackupBtnGroup3.setVisibility(0);
                View view15 = getView();
                View doneBtn4 = view15 == null ? null : view15.findViewById(e.j.a.Q1);
                kotlin.jvm.internal.m.f(doneBtn4, "doneBtn");
                doneBtn4.setVisibility(8);
            }
            View view16 = getView();
            ((Button) (view16 == null ? null : view16.findViewById(e.j.a.manualBackupLbl))).setVisibility(8);
            View view17 = getView();
            ((TextView) (view17 == null ? null : view17.findViewById(e.j.a.backupMessage))).setVisibility(4);
            View view18 = getView();
            ((Button) (view18 == null ? null : view18.findViewById(e.j.a.deleteCloudBackupBtn))).setVisibility(0);
            View view19 = getView();
            ((Button) (view19 != null ? view19.findViewById(e.j.a.cloudBackupBtn) : null)).setVisibility(8);
        } else if (backupStatus instanceof BackupStatus.BackedUpManually) {
            setBackupStatusView(R.drawable.ic_icon_warning, R.color.primary_yellow, R.string.mnemonic_backed_up_manually);
            if (getBackupMode() == BackupRecoveryPhraseViewModel.BackupMode.BackupOne) {
                View view20 = getView();
                View doneBtn5 = view20 == null ? null : view20.findViewById(e.j.a.Q1);
                kotlin.jvm.internal.m.f(doneBtn5, "doneBtn");
                doneBtn5.setVisibility(0);
                View view21 = getView();
                View cloudBackupBtn = view21 == null ? null : view21.findViewById(e.j.a.cloudBackupBtn);
                kotlin.jvm.internal.m.f(cloudBackupBtn, "cloudBackupBtn");
                cloudBackupBtn.setVisibility(8);
            } else {
                View view22 = getView();
                View cloudBackupBtn2 = view22 == null ? null : view22.findViewById(e.j.a.cloudBackupBtn);
                kotlin.jvm.internal.m.f(cloudBackupBtn2, "cloudBackupBtn");
                cloudBackupBtn2.setVisibility(0);
            }
            View view23 = getView();
            ((Button) (view23 == null ? null : view23.findViewById(e.j.a.copyToClipboardBtn))).setVisibility(0);
            View view24 = getView();
            ((Group) (view24 == null ? null : view24.findViewById(e.j.a.manualBackupBtnGroup))).setVisibility(8);
            View view25 = getView();
            ((Button) (view25 == null ? null : view25.findViewById(e.j.a.manualBackupLbl))).setVisibility(8);
            View view26 = getView();
            ((TextView) (view26 == null ? null : view26.findViewById(e.j.a.backupAccountInfo))).setVisibility(4);
            View view27 = getView();
            ((Button) (view27 == null ? null : view27.findViewById(e.j.a.deleteCloudBackupBtn))).setVisibility(4);
            View view28 = getView();
            ((TextView) (view28 != null ? view28.findViewById(e.j.a.backupMessage) : null)).setVisibility(0);
        } else if (backupStatus instanceof BackupStatus.NotBackedUp) {
            View view29 = getView();
            ((Button) (view29 == null ? null : view29.findViewById(e.j.a.copyToClipboardBtn))).setVisibility(isBannedLocation() ? 0 : 8);
            setBackupStatusView(R.drawable.ic_icon_warning, R.color.primary_yellow, R.string.mnemonic_not_backed_up);
            View view30 = getView();
            View doneBtn6 = view30 == null ? null : view30.findViewById(e.j.a.Q1);
            kotlin.jvm.internal.m.f(doneBtn6, "doneBtn");
            doneBtn6.setVisibility(8);
            View view31 = getView();
            ((Group) (view31 == null ? null : view31.findViewById(e.j.a.manualBackupBtnGroup))).setVisibility(8);
            View view32 = getView();
            ((TextView) (view32 == null ? null : view32.findViewById(e.j.a.backupAccountInfo))).setVisibility(4);
            View view33 = getView();
            ((Button) (view33 == null ? null : view33.findViewById(e.j.a.manualBackupLbl))).setVisibility(0);
            View view34 = getView();
            ((TextView) (view34 == null ? null : view34.findViewById(e.j.a.backupMessage))).setVisibility(0);
            View view35 = getView();
            ((Button) (view35 == null ? null : view35.findViewById(e.j.a.deleteCloudBackupBtn))).setVisibility(4);
            View view36 = getView();
            ((Button) (view36 != null ? view36.findViewById(e.j.a.cloudBackupBtn) : null)).setVisibility(0);
        } else if (backupStatus instanceof BackupStatus.Error) {
            e.j.f.m.v(this, "Backup Failed", 0, 2, null);
            l.a.a.f(((BackupStatus.Error) backupStatus).getThrowable(), "Backup Failed", new Object[0]);
        }
    }

    public final void handleFetchBackupStatusException(Throwable th) {
        l.a.a.f(th, "Error while fetching backup status", new Object[0]);
        Intent a = e.j.f.w.a(th);
        if (a == null) {
            e.j.f.m.p(this, BackupRecoveryPhraseFragment$handleFetchBackupStatusException$1.INSTANCE);
            return;
        }
        l.a.a.c(th, "Error contains an Intent, will try to recover...", new Object[0]);
        startActivityForResult(a, 1);
    }

    public final void handleRecoveryPhraseError(Throwable th) {
        if (e.j.f.w.b(th)) {
            return;
        }
        showRecoveryPhraseErrorDialog();
    }

    private final void handleSignIn(Intent intent) {
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel = this.viewModel;
        if (backupRecoveryPhraseViewModel != null) {
            h.c.b0<GoogleSignInAccount> observeOn = backupRecoveryPhraseViewModel.getGoogleSignedInAccount(intent).observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.getGoogleSignedInAccount(data)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error while fetching google account.", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.getGoogleSignedInAccount(data)\n            .observeOn(mainScheduler)\n            .logError(\"Error while fetching google account.\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new BackupRecoveryPhraseFragment$handleSignIn$1(this), new BackupRecoveryPhraseFragment$handleSignIn$2(this));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final boolean isBannedLocation() {
        Bundle arguments = getArguments();
        if (arguments == null) {
            return false;
        }
        return arguments.getBoolean("banned_location");
    }

    private final boolean isModal() {
        Bundle arguments = getArguments();
        return (arguments == null ? null : ForwardArgs.INSTANCE.modalSourceFromArgs(arguments)) != null;
    }

    public final void navigateToCreatePasswordScreen() {
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.backupCloudStart(AnalyticsEvent.Companion));
        CreatePasswordInfoFragment.Companion companion = CreatePasswordInfoFragment.Companion;
        String str = this.mnemonic;
        if (str != null) {
            Fragment_CommonKt.navigate$default(this, R.id.action_backupRecoveryPhraseFragment_to_createPasswordInfoFragment, companion.createArguments(str), null, null, 12, null);
            return;
        }
        throw new IllegalStateException("Mnemonic is null");
    }

    public final void navigateToManualBackupScreen() {
        String str = this.mnemonic;
        if (str == null) {
            return;
        }
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.backupManualStart(AnalyticsEvent.Companion));
        Fragment_CommonKt.navigate$default(this, R.id.action_backupRecoveryPhraseFragment_to_manualBackupFragment, ManualBackupFragment.Companion.createArguments(str), null, null, 12, null);
    }

    private final void setBackupStatusView(int i2, int i3, int i4) {
        View view = getView();
        TextView textView = (TextView) (view == null ? null : view.findViewById(e.j.a.backupStatusText));
        if (textView != null) {
            textView.setText(getString(i4));
        }
        View view2 = getView();
        TextView textView2 = (TextView) (view2 == null ? null : view2.findViewById(e.j.a.backupStatusText));
        if (textView2 != null) {
            textView2.setTextColor(e.j.f.m.m(this, i3));
        }
        View view3 = getView();
        ImageView imageView = (ImageView) (view3 != null ? view3.findViewById(e.j.a.backupStatusIcon) : null);
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(e.j.f.m.n(this, i2));
    }

    public final void setMnemonic(String str) {
        this.mnemonic = str;
        if (str == null || str.length() == 0) {
            return;
        }
        this.mnemonicSubject.onNext(str);
    }

    private final void setupClickListeners() {
        View view = getView();
        View copyToClipboardBtn = view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn);
        kotlin.jvm.internal.m.f(copyToClipboardBtn, "copyToClipboardBtn");
        View_CommonKt.setOnSingleClickListener$default(copyToClipboardBtn, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$1(this), 1, null);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$2(this), 1, null);
        View view3 = getView();
        View cloudBackupBtn = view3 == null ? null : view3.findViewById(e.j.a.cloudBackupBtn);
        kotlin.jvm.internal.m.f(cloudBackupBtn, "cloudBackupBtn");
        View_CommonKt.setOnSingleClickListener$default(cloudBackupBtn, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$3(this), 1, null);
        View view4 = getView();
        View manualBackupLbl = view4 == null ? null : view4.findViewById(e.j.a.manualBackupLbl);
        kotlin.jvm.internal.m.f(manualBackupLbl, "manualBackupLbl");
        View_CommonKt.setOnSingleClickListener$default(manualBackupLbl, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$4(this), 1, null);
        View view5 = getView();
        View manualBackupBtn = view5 == null ? null : view5.findViewById(e.j.a.manualBackupBtn);
        kotlin.jvm.internal.m.f(manualBackupBtn, "manualBackupBtn");
        View_CommonKt.setOnSingleClickListener$default(manualBackupBtn, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$5(this), 1, null);
        View view6 = getView();
        View doneBtn = view6 == null ? null : view6.findViewById(e.j.a.Q1);
        kotlin.jvm.internal.m.f(doneBtn, "doneBtn");
        View_CommonKt.setOnSingleClickListener$default(doneBtn, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$8(this), 1, null);
        View view7 = getView();
        View deleteCloudBackupBtn = view7 != null ? view7.findViewById(e.j.a.deleteCloudBackupBtn) : null;
        kotlin.jvm.internal.m.f(deleteCloudBackupBtn, "deleteCloudBackupBtn");
        View_CommonKt.setOnSingleClickListener$default(deleteCloudBackupBtn, 0L, new BackupRecoveryPhraseFragment$setupClickListeners$9(this), 1, null);
    }

    /* renamed from: setupClickListeners$lambda-6 */
    private static final boolean m1220setupClickListeners$lambda6(BackupRecoveryPhraseFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.lastSignedInAccount = GoogleSignInAccount.i1();
        this$0.handleBackupStatusChange(BackupStatus.BackedUpToCloud.INSTANCE);
        return true;
    }

    /* renamed from: setupClickListeners$lambda-7 */
    private static final boolean m1221setupClickListeners$lambda7(BackupRecoveryPhraseFragment this$0, View view) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        this$0.lastSignedInAccount = GoogleSignInAccount.i1();
        this$0.handleBackupStatusChange(BackupStatus.BackedUpAll.INSTANCE);
        return true;
    }

    private final void setupGoogleAccount() {
        this.lastSignedInAccount = com.google.android.gms.auth.api.signin.a.c(requireContext());
    }

    public final void setupGoogleDriveClient(GoogleSignInAccount googleSignInAccount) {
        List b2;
        Context requireContext = requireContext();
        b2 = kotlin.a0.q.b(DriveScopes.DRIVE_FILE);
        com.google.api.client.googleapis.extensions.android.gms.auth.a d2 = com.google.api.client.googleapis.extensions.android.gms.auth.a.d(requireContext, b2);
        d2.c(googleSignInAccount.m());
        Drive googleDriveService = new Drive.Builder(e.g.b.a.a.a.b.a.a(), new e.g.b.a.c.j.a(), d2).setApplicationName("Coinbase Wallet").build();
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel = this.viewModel;
        if (backupRecoveryPhraseViewModel == null) {
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.f(googleDriveService, "googleDriveService");
        backupRecoveryPhraseViewModel.setupGoogleDriveClient(googleDriveService);
    }

    private final void setupObservers() {
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel = this.viewModel;
        if (backupRecoveryPhraseViewModel != null) {
            Object as = backupRecoveryPhraseViewModel.getBackupStatus().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.backupStatus\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, new BackupRecoveryPhraseFragment$setupObservers$1(this), null, new BackupRecoveryPhraseFragment$setupObservers$2(this), 2, null);
            h.c.s<String> filter = getMnemonicObservable().filter(new h.c.m0.p() { // from class: com.coinbase.wallet.features.cloudbackup.view.a
                @Override // h.c.m0.p
                public final boolean test(Object obj) {
                    return BackupRecoveryPhraseFragment.d((String) obj);
                }
            });
            kotlin.jvm.internal.m.f(filter, "mnemonicObservable\n            .filter { it.isNotEmpty() }");
            Object as2 = Observable_AnalyticsKt.logError$default(filter, "Error while subscribing to mnemonic updates", null, 2, null).observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
            kotlin.jvm.internal.m.f(as2, "mnemonicObservable\n            .filter { it.isNotEmpty() }\n            .logError(\"Error while subscribing to mnemonic updates\")\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
            ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new BackupRecoveryPhraseFragment$setupObservers$4(this), 3, null);
            BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel2 = this.viewModel;
            if (backupRecoveryPhraseViewModel2 != null) {
                Object as3 = backupRecoveryPhraseViewModel2.getNavigateToCreatePasswordObservable().observeOn(this.mainScheduler).as(com.uber.autodispose.d.a(getScopeProvider()));
                kotlin.jvm.internal.m.f(as3, "viewModel.navigateToCreatePasswordObservable\n            .observeOn(mainScheduler)\n            .`as`(autoDisposable(scopeProvider))");
                ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new BackupRecoveryPhraseFragment$setupObservers$5(this), 3, null);
                return;
            }
            kotlin.jvm.internal.m.w("viewModel");
            throw null;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: setupObservers$lambda-2 */
    public static final boolean m1222setupObservers$lambda2(String it) {
        kotlin.jvm.internal.m.g(it, "it");
        return it.length() > 0;
    }

    private final void setupRecyclerView() {
        View view = getView();
        if (((RecyclerView) (view == null ? null : view.findViewById(e.j.a.recoveryPhrase))).getAdapter() != null) {
            return;
        }
        View view2 = getView();
        RecyclerView recyclerView = (RecyclerView) (view2 != null ? view2.findViewById(e.j.a.recoveryPhrase) : null);
        kotlin.jvm.internal.m.f(recyclerView, "");
        recyclerView.addItemDecoration(new e.j.m.b.b(View_CommonKt.getPxSize(recyclerView, R.dimen.backup_phrase_spacing)));
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        recyclerView.setAdapter(getRecoveryPhraseAdapter());
    }

    private final void setupViewModel() {
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(BackupRecoveryPhraseViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (BackupRecoveryPhraseViewModel) a;
    }

    private final void setupViews() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.cloudBackupBtn))).setVisibility(0);
        View view2 = getView();
        ((Group) (view2 == null ? null : view2.findViewById(e.j.a.manualBackupBtnGroup))).setVisibility(8);
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.manualBackupLbl))).setVisibility(0);
        View view4 = getView();
        ((Button) (view4 == null ? null : view4.findViewById(e.j.a.copyToClipboardBtn))).setVisibility(8);
        int i2 = isModal() ? R.drawable.ic_close_black_24dp : R.drawable.ic_arrow_back;
        View view5 = getView();
        ((ImageButton) (view5 != null ? view5.findViewById(e.j.a.t0) : null)).setImageDrawable(getResources().getDrawable(i2));
    }

    public final void showBannedDialog() {
        e.j.f.m.p(this, BackupRecoveryPhraseFragment$showBannedDialog$1.INSTANCE);
    }

    private final void showRecoveryPhraseErrorDialog() {
        e.j.f.m.p(this, new BackupRecoveryPhraseFragment$showRecoveryPhraseErrorDialog$1(this));
    }

    public final void signInToGoogle() {
        GoogleSignInAccount googleSignInAccount = this.lastSignedInAccount;
        if (googleSignInAccount == null) {
            startActivityForResult(getGoogleSignInClient().o(), 2);
            return;
        }
        BackupRecoveryPhraseViewModel backupRecoveryPhraseViewModel = this.viewModel;
        if (backupRecoveryPhraseViewModel != null) {
            ((com.uber.autodispose.x) backupRecoveryPhraseViewModel.getBackupStatus().skip(1L).observeOn(this.mainScheduler).map(new h.c.m0.n() { // from class: com.coinbase.wallet.features.cloudbackup.view.c
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return BackupRecoveryPhraseFragment.f(BackupRecoveryPhraseFragment.this, (BackupStatus) obj);
                }
            }).as(com.uber.autodispose.d.a(getScopeProvider()))).subscribe();
            setupGoogleDriveClient(googleSignInAccount);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: signInToGoogle$lambda-8 */
    public static final kotlin.x m1223signInToGoogle$lambda8(BackupRecoveryPhraseFragment this$0, BackupStatus status) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        kotlin.jvm.internal.m.g(status, "status");
        if (!kotlin.jvm.internal.m.c(status, BackupStatus.BackedUpAll.INSTANCE) && !kotlin.jvm.internal.m.c(status, BackupStatus.BackedUpToCloud.INSTANCE)) {
            this$0.navigateToCreatePasswordScreen();
        }
        return kotlin.x.a;
    }

    private final void startScreenshotObserver() {
        ContentResolver b2 = e.j.f.m.b(this);
        if (b2 == null) {
            return;
        }
        b2.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, getScreenshotObserver());
    }

    private final void stopScreenshotObserver() {
        ContentResolver b2 = e.j.f.m.b(this);
        if (b2 == null) {
            return;
        }
        b2.unregisterContentObserver(getScreenshotObserver());
    }

    @Override // com.toshi.view.fragment.o0, com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public c.h.k.d0 applyWindowInsets(View view, c.h.k.d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return StyledFragment.Attributes.copy$default(StyledFragment.DefaultImpls.getAttributes(this), true, false, false, 4, null);
    }

    public final AuthenticationHelper getAuthenticationHelper$app_productionRelease() {
        AuthenticationHelper authenticationHelper = this.authenticationHelper;
        if (authenticationHelper != null) {
            return authenticationHelper;
        }
        kotlin.jvm.internal.m.w("authenticationHelper");
        throw null;
    }

    public final RecoveryPhraseClipboardWrapper getRecoveryPhraseClipboardWrapper$app_productionRelease() {
        RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper = this.recoveryPhraseClipboardWrapper;
        if (recoveryPhraseClipboardWrapper != null) {
            return recoveryPhraseClipboardWrapper;
        }
        kotlin.jvm.internal.m.w("recoveryPhraseClipboardWrapper");
        throw null;
    }

    public final GenericViewModelFactory<BackupRecoveryPhraseViewModel> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1) {
            l.a.a.a("User finished error recovery flow", new Object[0]);
        } else if (i2 != 2) {
        } else {
            handleSignIn(intent);
        }
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        if (isBannedLocation()) {
            showBannedDialog();
            return true;
        }
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_backup_phrase, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        getAuthenticationHelper$app_productionRelease().clear();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.recoveryPhraseLanded(AnalyticsEvent.Companion));
        if (this.mnemonic != null) {
            return;
        }
        h.c.b0<AuthenticationResult> subscribeOn = getAuthenticationHelper$app_productionRelease().unlock(AppLockType.RequireAuthentication.INSTANCE).subscribeOn(this.mainScheduler);
        kotlin.jvm.internal.m.f(subscribeOn, "authenticationHelper.unlock(AppLockType.RequireAuthentication)\n            .subscribeOn(mainScheduler)");
        Object as = Single_AnalyticsKt.logError$default(subscribeOn, "Error while unlocking recovery phrase", null, 2, null).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "authenticationHelper.unlock(AppLockType.RequireAuthentication)\n            .subscribeOn(mainScheduler)\n            .logError(\"Error while unlocking recovery phrase\")\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new BackupRecoveryPhraseFragment$onResume$1(this), new BackupRecoveryPhraseFragment$onResume$2(this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setupGoogleAccount();
        startScreenshotObserver();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        stopScreenshotObserver();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        e.j.f.m.o(this, getAuthenticationHelper$app_productionRelease());
        setupViewModel();
        setupViews();
        setupRecyclerView();
        setupObservers();
        setupClickListeners();
        checkBannedLocation();
        Bundle arguments = getArguments();
        setMnemonic(arguments == null ? null : arguments.getString(KEY_MNEMONIC));
    }

    public final void setAuthenticationHelper$app_productionRelease(AuthenticationHelper authenticationHelper) {
        kotlin.jvm.internal.m.g(authenticationHelper, "<set-?>");
        this.authenticationHelper = authenticationHelper;
    }

    public final void setRecoveryPhraseClipboardWrapper$app_productionRelease(RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper) {
        kotlin.jvm.internal.m.g(recoveryPhraseClipboardWrapper, "<set-?>");
        this.recoveryPhraseClipboardWrapper = recoveryPhraseClipboardWrapper;
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<BackupRecoveryPhraseViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}