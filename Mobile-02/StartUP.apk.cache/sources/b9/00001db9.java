package com.coinbase.wallet.features.cloudbackup.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.i;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.viewModel.RestoreWalletViewModel;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.toshi.view.fragment.o0;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: RestoreWalletFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB\u0007¢\u0006\u0004\bI\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u000f\u0010\u0011\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0012\u0010\u0005J-\u0010\u001a\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001f\u0010\u0005J)\u0010#\u001a\u00020\u00032\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R(\u0010+\u001a\b\u0012\u0004\u0012\u00020*0)8\u0006@\u0006X\u0087.¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001d\u00106\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u001d\u00109\u001a\u0002078B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b8\u00103\u001a\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u001c\u0010?\u001a\u00020>8\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u0016\u0010C\u001a\u00020*8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\bC\u0010DR\u001e\u0010G\u001a\n F*\u0004\u0018\u00010E0E8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bG\u0010H¨\u0006K"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/RestoreWalletFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initClicks", "Landroid/content/Intent;", "data", "handleSignIn", "(Landroid/content/Intent;)V", "Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;", "googleSignInAccount", "initDriveClient", "(Lcom/google/android/gms/auth/api/signin/GoogleSignInAccount;)V", "getBackups", "handleNoBackupsFound", "showBannedDialog", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onResume", "", "requestCode", "resultCode", "onActivityResult", "(IILandroid/content/Intent;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/RestoreWalletViewModel;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/google/android/gms/auth/api/signin/c;", "googleSignInClient$delegate", "Lkotlin/h;", "getGoogleSignInClient", "()Lcom/google/android/gms/auth/api/signin/c;", "googleSignInClient", "", "isBannedLocation$delegate", "isBannedLocation", "()Z", "Lcom/google/android/gms/common/api/Scope;", "fileScope", "Lcom/google/android/gms/common/api/Scope;", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "viewModel", "Lcom/coinbase/wallet/features/cloudbackup/viewModel/RestoreWalletViewModel;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RestoreWalletFragment extends o0 implements StyledFragment {
    public static final String BANNED_LOCATION_KEY = "banned_location";
    public static final Companion Companion = new Companion(null);
    private static final int GOOGLE_SIGN_IN_REQUEST_CODE = 0;
    private final StyledFragment.Attributes attributes;
    private final kotlin.h googleSignInClient$delegate;
    private final kotlin.h isBannedLocation$delegate;
    private RestoreWalletViewModel viewModel;
    public GenericViewModelFactory<RestoreWalletViewModel> viewModelFactory;
    private final Scope fileScope = new Scope(DriveScopes.DRIVE_FILE);
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();

    /* compiled from: RestoreWalletFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/RestoreWalletFragment$Companion;", "", "", "BANNED_LOCATION_KEY", "Ljava/lang/String;", "", "GOOGLE_SIGN_IN_REQUEST_CODE", "I", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestoreWalletFragment() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(new RestoreWalletFragment$googleSignInClient$2(this));
        this.googleSignInClient$delegate = b2;
        b3 = kotlin.k.b(new RestoreWalletFragment$isBannedLocation$2(this));
        this.isBannedLocation$delegate = b3;
        this.attributes = new StyledFragment.Attributes(true, false, false, 6, null);
    }

    private final void getBackups() {
        RestoreWalletViewModel restoreWalletViewModel = this.viewModel;
        if (restoreWalletViewModel != null) {
            h.c.b0<List<BackupPayload>> observeOn = restoreWalletViewModel.getBackups().observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.getBackups()\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error fetching backups", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.getBackups()\n            .observeOn(mainScheduler)\n            .logError(\"Error fetching backups\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new RestoreWalletFragment$getBackups$1(this), new RestoreWalletFragment$getBackups$2(this));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.google.android.gms.auth.api.signin.c getGoogleSignInClient() {
        Object value = this.googleSignInClient$delegate.getValue();
        kotlin.jvm.internal.m.f(value, "<get-googleSignInClient>(...)");
        return (com.google.android.gms.auth.api.signin.c) value;
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleNoBackupsFound() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.googleDriveRestore))).setVisibility(4);
        View view2 = getView();
        ((TextView) (view2 == null ? null : view2.findViewById(e.j.a.noBackupsFoundMessage))).setVisibility(0);
        View view3 = getView();
        Button button = (Button) (view3 != null ? view3.findViewById(e.j.a.manualRestore) : null);
        button.setBackground(e.j.f.m.n(this, R.drawable.button_primary));
        button.setTextColor(e.j.f.m.m(this, R.color.textColorContrast));
    }

    private final void handleSignIn(Intent intent) {
        RestoreWalletViewModel restoreWalletViewModel = this.viewModel;
        if (restoreWalletViewModel != null) {
            h.c.b0<Optional<GoogleSignInAccount>> observeOn = restoreWalletViewModel.getGoogleSignedInAccount(intent).observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "viewModel.getGoogleSignedInAccount(data)\n            .observeOn(mainScheduler)");
            Object as = Single_AnalyticsKt.logError$default(observeOn, "Error while fetching google account.", null, 2, null).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
            kotlin.jvm.internal.m.f(as, "viewModel.getGoogleSignedInAccount(data)\n            .observeOn(mainScheduler)\n            .logError(\"Error while fetching google account.\")\n            .`as`(autoDisposable(onDestroyScopeProvider))");
            SingleSubscribeProxy_CommonKt.subscribeBy((com.uber.autodispose.a0) as, new RestoreWalletFragment$handleSignIn$1(this), new RestoreWalletFragment$handleSignIn$2(this));
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void init() {
        initViewModel();
        initClicks();
    }

    private final void initClicks() {
        View view = getView();
        View backButton = view == null ? null : view.findViewById(e.j.a.backButton);
        kotlin.jvm.internal.m.f(backButton, "backButton");
        View_CommonKt.setOnSingleClickListener$default(backButton, 0L, new RestoreWalletFragment$initClicks$1(this), 1, null);
        View view2 = getView();
        View googleDriveRestore = view2 == null ? null : view2.findViewById(e.j.a.googleDriveRestore);
        kotlin.jvm.internal.m.f(googleDriveRestore, "googleDriveRestore");
        View_CommonKt.setOnSingleClickListener$default(googleDriveRestore, 0L, new RestoreWalletFragment$initClicks$2(this), 1, null);
        View view3 = getView();
        View manualRestore = view3 != null ? view3.findViewById(e.j.a.manualRestore) : null;
        kotlin.jvm.internal.m.f(manualRestore, "manualRestore");
        View_CommonKt.setOnSingleClickListener$default(manualRestore, 0L, new RestoreWalletFragment$initClicks$3(this), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initDriveClient(GoogleSignInAccount googleSignInAccount) {
        List b2;
        Context requireContext = requireContext();
        b2 = kotlin.a0.q.b(DriveScopes.DRIVE_FILE);
        com.google.api.client.googleapis.extensions.android.gms.auth.a d2 = com.google.api.client.googleapis.extensions.android.gms.auth.a.d(requireContext, b2);
        d2.c(googleSignInAccount.m());
        Drive googleDriveService = new Drive.Builder(e.g.b.a.a.a.b.a.a(), new e.g.b.a.c.j.a(), d2).setApplicationName("Coinbase Wallet").build();
        RestoreWalletViewModel restoreWalletViewModel = this.viewModel;
        if (restoreWalletViewModel != null) {
            kotlin.jvm.internal.m.f(googleDriveService, "googleDriveService");
            restoreWalletViewModel.initDriveClient(googleDriveService);
            getBackups();
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory()).a(RestoreWalletViewModel.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (RestoreWalletViewModel) a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isBannedLocation() {
        return ((Boolean) this.isBannedLocation$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBannedDialog() {
        e.j.f.m.p(this, RestoreWalletFragment$showBannedDialog$1.INSTANCE);
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
        return this.attributes;
    }

    public final GenericViewModelFactory<RestoreWalletViewModel> getViewModelFactory() {
        GenericViewModelFactory<RestoreWalletViewModel> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 0) {
            super.onActivityResult(i2, i3, intent);
        } else if (intent != null) {
            handleSignIn(intent);
        } else {
            e.j.f.m.v(this, "Failed to sign in.", 0, 2, null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_restore_wallet, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.restoreWalletLanded(AnalyticsEvent.Companion));
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setViewModelFactory(GenericViewModelFactory<RestoreWalletViewModel> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}