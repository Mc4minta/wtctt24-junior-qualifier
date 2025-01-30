package com.coinbase.wallet.features.cloudbackup.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.coinbase.wallet.analytics.Analytics;
import com.coinbase.wallet.analytics.extensions.Single_AnalyticsKt;
import com.coinbase.wallet.analytics.models.AnalyticsEvent;
import com.coinbase.wallet.application.extensions.AnalyticsEvent_ApplicationKt;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.commonui.di.GenericViewModelFactory;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.toshi.view.custom.VerifyBackupPhraseView;
import com.toshi.view.fragment.o0;
import e.j.n.i3;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: VerifyManualBackupFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0007¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J-\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0006J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010\"\u001a\u00020\u001d8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001f\u0010'\u001a\u0004\u0018\u00010#8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001e\u0010-\u001a\n ,*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R(\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0/8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u00109\u001a\u0002068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/VerifyManualBackupFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "init", "()V", "initViewModel", "initViews", "onRecoveryVerified", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "", "onBackPressed", "()Z", "Le/j/n/i3;", "viewModel", "Le/j/n/i3;", "", "mnemonic$delegate", "Lkotlin/h;", "getMnemonic", "()Ljava/lang/String;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "", "modalSource$delegate", "getModalSource", "()Ljava/lang/Integer;", "modalSource", "Lh/c/k0/a;", "disposeBag", "Lh/c/k0/a;", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "viewModelFactory", "Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "getViewModelFactory$app_productionRelease", "()Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;", "setViewModelFactory$app_productionRelease", "(Lcom/coinbase/wallet/commonui/di/GenericViewModelFactory;)V", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class VerifyManualBackupFragment extends o0 implements StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_MNEMONIC = "EXTRA_MNEMONIC";
    private final h.c.k0.a disposeBag = new h.c.k0.a();
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private final kotlin.h mnemonic$delegate;
    private final kotlin.h modalSource$delegate;
    private i3 viewModel;
    public GenericViewModelFactory<i3> viewModelFactory;

    /* compiled from: VerifyManualBackupFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/VerifyManualBackupFragment$Companion;", "", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Landroid/os/Bundle;", "createArguments", "(Ljava/lang/String;)Landroid/os/Bundle;", VerifyManualBackupFragment.EXTRA_MNEMONIC, "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(String mnemonic) {
            kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
            return androidx.core.os.b.a(kotlin.u.a(VerifyManualBackupFragment.EXTRA_MNEMONIC, mnemonic));
        }
    }

    public VerifyManualBackupFragment() {
        kotlin.h b2;
        kotlin.h b3;
        b2 = kotlin.k.b(new VerifyManualBackupFragment$mnemonic$2(this));
        this.mnemonic$delegate = b2;
        b3 = kotlin.k.b(new VerifyManualBackupFragment$modalSource$2(this));
        this.modalSource$delegate = b3;
    }

    public static /* synthetic */ void d(VerifyManualBackupFragment verifyManualBackupFragment) {
        m1250onRecoveryVerified$lambda3(verifyManualBackupFragment);
    }

    private final String getMnemonic() {
        return (String) this.mnemonic$delegate.getValue();
    }

    private final Integer getModalSource() {
        return (Integer) this.modalSource$delegate.getValue();
    }

    private final void init() {
        initViewModel();
        initViews();
    }

    private final void initViewModel() {
        androidx.lifecycle.b0 a = new androidx.lifecycle.d0(this, getViewModelFactory$app_productionRelease()).a(i3.class);
        kotlin.jvm.internal.m.f(a, "ViewModelProvider(this, viewModelFactory).get(T::class.java)");
        this.viewModel = (i3) a;
    }

    private final void initViews() {
        List<String> K0;
        View view = getView();
        ImageButton imageButton = (ImageButton) (view == null ? null : view.findViewById(e.j.a.t0));
        if (getModalSource() != null) {
            imageButton.setImageDrawable(imageButton.getResources().getDrawable(R.drawable.ic_close_black_24dp));
        } else {
            imageButton.setImageDrawable(imageButton.getResources().getDrawable(R.drawable.ic_arrow_back));
        }
        kotlin.jvm.internal.m.f(imageButton, "");
        View_CommonKt.setOnSingleClickListener$default(imageButton, 0L, new VerifyManualBackupFragment$initViews$1$1(this), 1, null);
        View view2 = getView();
        View findViewById = view2 == null ? null : view2.findViewById(e.j.a.dragAndDropView);
        K0 = kotlin.l0.y.K0(getMnemonic(), new String[]{" "}, false, 0, 6, null);
        ((VerifyBackupPhraseView) findViewById).setBackupPhrase(K0);
        View view3 = getView();
        VerifyBackupPhraseView verifyBackupPhraseView = (VerifyBackupPhraseView) (view3 != null ? view3.findViewById(e.j.a.dragAndDropView) : null);
        verifyBackupPhraseView.setOnFinishedListener(new VerifyManualBackupFragment$initViews$2$1(this));
        verifyBackupPhraseView.setOnErrorListener(new VerifyManualBackupFragment$initViews$2$2(this));
    }

    public final void onRecoveryVerified() {
        View view = getView();
        ((ProgressBar) (view == null ? null : view.findViewById(e.j.a.d5))).setVisibility(0);
        i3 i3Var = this.viewModel;
        if (i3Var != null) {
            h.c.b0<kotlin.x> doFinally = i3Var.a().observeOn(this.mainScheduler).doFinally(new h.c.m0.a() { // from class: com.coinbase.wallet.features.cloudbackup.view.d0
                @Override // h.c.m0.a
                public final void run() {
                    VerifyManualBackupFragment.d(VerifyManualBackupFragment.this);
                }
            });
            kotlin.jvm.internal.m.f(doFinally, "viewModel.manualBackupVerified()\n            .observeOn(mainScheduler)\n            .doFinally {\n                Analytics.log(AnalyticsEvent.backupManualSuccess())\n                modalSource?.let { navigateUpTo(it) } ?: navigateUpTo(R.id.backupRecoveryPhraseFragment)\n            }");
            h.c.t0.a.a(h.c.t0.g.i(Single_AnalyticsKt.logError$default(doFinally, "Error when marking manual backup as being verified", null, 2, null), null, null, 3, null), this.disposeBag);
            return;
        }
        kotlin.jvm.internal.m.w("viewModel");
        throw null;
    }

    /* renamed from: onRecoveryVerified$lambda-3 */
    public static final void m1250onRecoveryVerified$lambda3(VerifyManualBackupFragment this$0) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        Analytics.INSTANCE.log(AnalyticsEvent_ApplicationKt.backupManualSuccess(AnalyticsEvent.Companion));
        Integer modalSource = this$0.getModalSource();
        Boolean valueOf = modalSource == null ? null : Boolean.valueOf(e.j.f.m.k(this$0, modalSource.intValue(), false, 2, null));
        if (valueOf == null) {
            e.j.f.m.k(this$0, R.id.backupRecoveryPhraseFragment, false, 2, null);
        } else {
            valueOf.booleanValue();
        }
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

    public final GenericViewModelFactory<i3> getViewModelFactory$app_productionRelease() {
        GenericViewModelFactory<i3> genericViewModelFactory = this.viewModelFactory;
        if (genericViewModelFactory != null) {
            return genericViewModelFactory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_verify_manual_backup, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.disposeBag.d();
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setViewModelFactory$app_productionRelease(GenericViewModelFactory<i3> genericViewModelFactory) {
        kotlin.jvm.internal.m.g(genericViewModelFactory, "<set-?>");
        this.viewModelFactory = genericViewModelFactory;
    }
}