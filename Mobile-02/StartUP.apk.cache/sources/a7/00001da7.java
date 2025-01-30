package com.coinbase.wallet.features.cloudbackup.view;

import android.animation.ValueAnimator;
import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.common.annotations.ScreenshotProtection;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.features.cloudbackup.models.OnboardingBackupRecoveryPhraseArgs;
import com.coinbase.wallet.features.cloudbackup.util.RecoveryPhraseClipboardWrapper;
import com.coinbase.wallet.features.cloudbackup.view.ManualBackupFragment$screenshotObserver$2;
import com.toshi.view.fragment.o0;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: ManualBackupFragment.kt */
@ScreenshotProtection(behavior = ScreenshotProtection.Behavior.BLOCK)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006*\u00011\b\u0007\u0018\u0000 ;2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001;B\u0007¢\u0006\u0004\b:\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\b\u0010\u0006J\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u000f\u0010\f\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\u0006J-\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0019\u0010\u0006J\u000f\u0010\u001a\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\u00020\u001b8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u001dR\"\u0010\"\u001a\u00020!8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010*\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001d\u00100\u001a\u00020,8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\u001f\u001a\u0004\b.\u0010/R\u001d\u00105\u001a\u0002018B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u001f\u001a\u0004\b3\u00104R\u0016\u00109\u001a\u0002068V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b7\u00108¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment;", "Lcom/toshi/view/fragment/o0;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lcom/coinbase/wallet/commonui/views/BackableFragment;", "Lkotlin/x;", "doCopyAndAnimate", "()V", "init", "initRecoveryPhraseView", "initViewListeners", "startScreenshotObserver", "stopScreenshotObserver", "navigateToVerifyManualBackupScreen", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "onStop", "", "onBackPressed", "()Z", "isModal$delegate", "Lkotlin/h;", "isModal", "Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "recoveryPhraseClipboardWrapper", "Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "getRecoveryPhraseClipboardWrapper$app_productionRelease", "()Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;", "setRecoveryPhraseClipboardWrapper$app_productionRelease", "(Lcom/coinbase/wallet/features/cloudbackup/util/RecoveryPhraseClipboardWrapper;)V", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "", "mnemonic$delegate", "getMnemonic", "()Ljava/lang/String;", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "com/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment$screenshotObserver$2$1", "screenshotObserver$delegate", "getScreenshotObserver", "()Lcom/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment$screenshotObserver$2$1;", "screenshotObserver", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "<init>", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ManualBackupFragment extends o0 implements StyledFragment, BackableFragment {
    public static final Companion Companion = new Companion(null);
    private static final String EXTRA_MNEMONIC = "EXTRA_MNEMONIC";
    private final kotlin.h isModal$delegate;
    private final h.c.a0 mainScheduler = h.c.j0.c.a.b();
    private final kotlin.h mnemonic$delegate;
    public RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper;
    private final kotlin.h screenshotObserver$delegate;

    /* compiled from: ManualBackupFragment.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/ManualBackupFragment$Companion;", "", "", OnboardingBackupRecoveryPhraseArgs.mnemonicKey, "Landroid/os/Bundle;", "createArguments", "(Ljava/lang/String;)Landroid/os/Bundle;", ManualBackupFragment.EXTRA_MNEMONIC, "Ljava/lang/String;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bundle createArguments(String mnemonic) {
            kotlin.jvm.internal.m.g(mnemonic, "mnemonic");
            return androidx.core.os.b.a(kotlin.u.a(ManualBackupFragment.EXTRA_MNEMONIC, mnemonic));
        }
    }

    public ManualBackupFragment() {
        kotlin.h b2;
        kotlin.h b3;
        kotlin.h b4;
        b2 = kotlin.k.b(new ManualBackupFragment$mnemonic$2(this));
        this.mnemonic$delegate = b2;
        b3 = kotlin.k.b(new ManualBackupFragment$isModal$2(this));
        this.isModal$delegate = b3;
        b4 = kotlin.k.b(new ManualBackupFragment$screenshotObserver$2(this));
        this.screenshotObserver$delegate = b4;
    }

    public static /* synthetic */ void d(ManualBackupFragment manualBackupFragment, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        m1245doCopyAndAnimate$lambda1$lambda0(manualBackupFragment, valueAnimator, valueAnimator2);
    }

    public final void doCopyAndAnimate() {
        View view = getView();
        ((Button) (view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn))).setClickable(false);
        getRecoveryPhraseClipboardWrapper$app_productionRelease().copyRecoveryPhrase(getMnemonic());
        int d2 = androidx.core.content.a.d(requireContext(), R.color.primary_green);
        int d3 = androidx.core.content.a.d(requireContext(), R.color.primary_blue);
        View view2 = getView();
        ((Button) (view2 == null ? null : view2.findViewById(e.j.a.copyToClipboardBtn))).setTextColor(d2);
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.fade_in_short);
        View view3 = getView();
        ((Button) (view3 == null ? null : view3.findViewById(e.j.a.copyToClipboardBtn))).startAnimation(loadAnimation);
        e.j.f.m.u(this, R.string.copied_to_clipboard, 0, 2, null);
        final ValueAnimator ofArgb = ValueAnimator.ofArgb(d2, d3);
        ofArgb.setDuration(250L);
        ofArgb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coinbase.wallet.features.cloudbackup.view.y
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ManualBackupFragment.d(ManualBackupFragment.this, ofArgb, valueAnimator);
            }
        });
        View view4 = getView();
        ((Button) (view4 != null ? view4.findViewById(e.j.a.copyToClipboardBtn) : null)).setText(getString(R.string.manual_backup_copy_to_clipboard_clear));
        TimeUnit timeUnit = TimeUnit.SECONDS;
        h.c.a0 mainScheduler = this.mainScheduler;
        kotlin.jvm.internal.m.f(mainScheduler, "mainScheduler");
        Fragment_CommonKt.withDelay(this, 2L, timeUnit, mainScheduler, new ManualBackupFragment$doCopyAndAnimate$1(this, ofArgb));
    }

    /* renamed from: doCopyAndAnimate$lambda-1$lambda-0 */
    public static final void m1245doCopyAndAnimate$lambda1$lambda0(ManualBackupFragment this$0, ValueAnimator valueAnimator, ValueAnimator valueAnimator2) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        if ((view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn)) != null) {
            View view2 = this$0.getView();
            View findViewById = view2 != null ? view2.findViewById(e.j.a.copyToClipboardBtn) : null;
            Object animatedValue = valueAnimator.getAnimatedValue();
            Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
            ((Button) findViewById).setTextColor(((Integer) animatedValue).intValue());
        }
    }

    private final String getMnemonic() {
        return (String) this.mnemonic$delegate.getValue();
    }

    private final ManualBackupFragment$screenshotObserver$2.AnonymousClass1 getScreenshotObserver() {
        return (ManualBackupFragment$screenshotObserver$2.AnonymousClass1) this.screenshotObserver$delegate.getValue();
    }

    private final void init() {
        initRecoveryPhraseView();
        initViewListeners();
        if (isModal()) {
            View view = getView();
            ((ImageButton) (view != null ? view.findViewById(e.j.a.t0) : null)).setImageDrawable(getResources().getDrawable(R.drawable.ic_close_black_24dp));
            return;
        }
        View view2 = getView();
        ((ImageButton) (view2 != null ? view2.findViewById(e.j.a.t0) : null)).setImageDrawable(getResources().getDrawable(R.drawable.ic_arrow_back));
    }

    private final void initRecoveryPhraseView() {
        List<String> K0;
        View view = getView();
        RecyclerView recyclerView = (RecyclerView) (view == null ? null : view.findViewById(e.j.a.recoveryPhrase));
        kotlin.jvm.internal.m.f(recyclerView, "");
        recyclerView.addItemDecoration(new e.j.m.b.b(View_CommonKt.getPxSize(recyclerView, R.dimen.backup_phrase_spacing)));
        recyclerView.setLayoutManager(new GridLayoutManager(requireContext(), 3));
        e.j.m.a.l lVar = new e.j.m.a.l(null, 1, null);
        K0 = kotlin.l0.y.K0(getMnemonic(), new String[]{" "}, false, 0, 6, null);
        lVar.c(K0);
        recyclerView.setAdapter(lVar);
    }

    private final void initViewListeners() {
        View view = getView();
        View copyToClipboardBtn = view == null ? null : view.findViewById(e.j.a.copyToClipboardBtn);
        kotlin.jvm.internal.m.f(copyToClipboardBtn, "copyToClipboardBtn");
        View_CommonKt.setOnSingleClickListener$default(copyToClipboardBtn, 0L, new ManualBackupFragment$initViewListeners$1(this), 1, null);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(e.j.a.t0);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ManualBackupFragment$initViewListeners$2(this), 1, null);
        View view3 = getView();
        View continueButton = view3 != null ? view3.findViewById(e.j.a.continueButton) : null;
        kotlin.jvm.internal.m.f(continueButton, "continueButton");
        View_CommonKt.setOnSingleClickListener$default(continueButton, 0L, new ManualBackupFragment$initViewListeners$3(this), 1, null);
    }

    private final boolean isModal() {
        return ((Boolean) this.isModal$delegate.getValue()).booleanValue();
    }

    public final void navigateToVerifyManualBackupScreen() {
        Fragment_CommonKt.navigate$default(this, R.id.action_manualBackupFragment_to_verifyManualBackupFragment, VerifyManualBackupFragment.Companion.createArguments(getMnemonic()), null, null, 12, null);
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

    public final RecoveryPhraseClipboardWrapper getRecoveryPhraseClipboardWrapper$app_productionRelease() {
        RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper = this.recoveryPhraseClipboardWrapper;
        if (recoveryPhraseClipboardWrapper != null) {
            return recoveryPhraseClipboardWrapper;
        }
        kotlin.jvm.internal.m.w("recoveryPhraseClipboardWrapper");
        throw null;
    }

    @Override // com.coinbase.wallet.commonui.views.BackableFragment
    public boolean onBackPressed() {
        return Fragment_CommonKt.navigateUp(this);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_manual_backup, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
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
        super.onViewCreated(view, bundle);
        init();
    }

    public final void setRecoveryPhraseClipboardWrapper$app_productionRelease(RecoveryPhraseClipboardWrapper recoveryPhraseClipboardWrapper) {
        kotlin.jvm.internal.m.g(recoveryPhraseClipboardWrapper, "<set-?>");
        this.recoveryPhraseClipboardWrapper = recoveryPhraseClipboardWrapper;
    }
}