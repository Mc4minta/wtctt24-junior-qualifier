package com.coinbase.wallet.consumer.views;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.z;
import androidx.lifecycle.i;
import c.h.k.d0;
import com.coinbase.wallet.common.extensions.ObservableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.extensions.SingleSubscribeProxy_CommonKt;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.commonui.views.BaseFragment;
import com.coinbase.wallet.commonui.views.StyledFragment;
import com.coinbase.wallet.consumer.R;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVArgs;
import com.coinbase.wallet.consumer.models.ConsumerCardCDVResult;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationArgs;
import com.coinbase.wallet.consumer.models.ConsumerSecure3DVerificationResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodResult;
import com.coinbase.wallet.consumer.models.ConsumerTransferMethodsArgs;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferConfirmationViewModel;
import com.coinbase.wallet.consumer.viewmodels.ConsumerTransferMethodsViewModel;
import h.c.a0;
import h.c.b0;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.e0;

/* compiled from: ConsumerTransferConfirmationFragment.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\bE\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0005J%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J-\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J!\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0017¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010\u001eR\u001d\u0010%\u001a\u00020 8V@\u0016X\u0096\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001d\u0010*\u001a\u00020&8B@\u0002X\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\"\u001a\u0004\b(\u0010)R\u001e\u0010-\u001a\n ,*\u0004\u0018\u00010+0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0000@\u0000X\u0081.¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0016\u0010@\u001a\u00020=8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8B@\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0016\u0010C\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006F"}, d2 = {"Lcom/coinbase/wallet/consumer/views/ConsumerTransferConfirmationFragment;", "Lcom/coinbase/wallet/commonui/views/BaseFragment;", "Lcom/coinbase/wallet/commonui/views/StyledFragment;", "Lkotlin/x;", "setStyles", "()V", "setElasticity", "sendButtonClicked", "detailsButtonClicked", "", "willExpand", "animate", "Lh/c/b0;", "updateDetailsView", "(ZZ)Lh/c/b0;", "setupOnClicks", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/graphics/PointF;", "initialCardLocation", "Landroid/graphics/PointF;", "initialMoveLocation", "Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes$delegate", "Lkotlin/h;", "getAttributes", "()Lcom/coinbase/wallet/commonui/views/StyledFragment$Attributes;", "attributes", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel;", "viewModel$delegate", "getViewModel", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel;", "viewModel", "Lh/c/a0;", "kotlin.jvm.PlatformType", "mainScheduler", "Lh/c/a0;", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel$Factory;", "viewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel$Factory;", "getViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel$Factory;", "setViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferConfirmationViewModel$Factory;)V", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "transferMethodsViewModelFactory", "Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "getTransferMethodsViewModelFactory$consumer_productionRelease", "()Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;", "setTransferMethodsViewModelFactory$consumer_productionRelease", "(Lcom/coinbase/wallet/consumer/viewmodels/ConsumerTransferMethodsViewModel$Factory;)V", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "getOnDestroyScopeProvider", "()Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "onDestroyScopeProvider", "getScopeProvider", "scopeProvider", "isFirstDetailsUpdate", "Z", "<init>", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferConfirmationFragment extends BaseFragment implements StyledFragment {
    private final kotlin.h attributes$delegate;
    public ConsumerTransferMethodsViewModel.Factory transferMethodsViewModelFactory;
    public ConsumerTransferConfirmationViewModel.Factory viewModelFactory;
    private final a0 mainScheduler = h.c.j0.c.a.b();
    private boolean isFirstDetailsUpdate = true;
    private PointF initialCardLocation = new PointF();
    private PointF initialMoveLocation = new PointF();
    private final kotlin.h viewModel$delegate = z.a(this, e0.b(ConsumerTransferConfirmationViewModel.class), new ConsumerTransferConfirmationFragment$special$$inlined$viewModel$3(new ConsumerTransferConfirmationFragment$special$$inlined$viewModel$2(this)), new ConsumerTransferConfirmationFragment$special$$inlined$viewModel$1(this, this));

    public ConsumerTransferConfirmationFragment() {
        kotlin.h b2;
        b2 = kotlin.k.b(new ConsumerTransferConfirmationFragment$attributes$2(this));
        this.attributes$delegate = b2;
    }

    public static /* synthetic */ boolean d(float f2, ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment, float f3, View view, MotionEvent motionEvent) {
        return m1043setElasticity$lambda1(f2, consumerTransferConfirmationFragment, f3, view, motionEvent);
    }

    public final void detailsButtonClicked() {
        getViewModel().detailsClicked();
    }

    public static /* synthetic */ void e(ConsumerTransferConfirmationFragment consumerTransferConfirmationFragment, kotlin.x xVar) {
        m1044updateDetailsView$lambda3(consumerTransferConfirmationFragment, xVar);
    }

    private final FragmentLifecycleScopeProvider getOnDestroyScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider(this, i.a.ON_DESTROY);
    }

    public final FragmentLifecycleScopeProvider getScopeProvider() {
        return Fragment_CommonKt.getFragmentLifecycleScopeProvider$default(this, null, 1, null);
    }

    public final ConsumerTransferConfirmationViewModel getViewModel() {
        return (ConsumerTransferConfirmationViewModel) this.viewModel$delegate.getValue();
    }

    public final void sendButtonClicked() {
        Object as = getViewModel().transfer().observeOn(h.c.j0.c.a.b()).as(com.uber.autodispose.d.a(getOnDestroyScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.transfer()\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(autoDisposable(onDestroyScopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as, null, ConsumerTransferConfirmationFragment$sendButtonClicked$1.INSTANCE, 1, null);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private final void setElasticity() {
        View view = getView();
        ((ConstraintLayout) (view == null ? null : view.findViewById(R.id.confirmationCard))).setHapticFeedbackEnabled(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        requireActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final float f2 = displayMetrics.heightPixels;
        final float f3 = displayMetrics.widthPixels;
        View view2 = getView();
        ((ConstraintLayout) (view2 != null ? view2.findViewById(R.id.confirmationCard) : null)).setOnTouchListener(new View.OnTouchListener() { // from class: com.coinbase.wallet.consumer.views.n
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view3, MotionEvent motionEvent) {
                return ConsumerTransferConfirmationFragment.d(f3, this, f2, view3, motionEvent);
            }
        });
    }

    /* renamed from: setElasticity$lambda-1 */
    public static final boolean m1043setElasticity$lambda1(float f2, ConsumerTransferConfirmationFragment this$0, float f3, View view, MotionEvent motionEvent) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        int action = motionEvent.getAction();
        if (action == 0) {
            this$0.initialMoveLocation.set(motionEvent.getRawX(), motionEvent.getRawY());
            this$0.initialCardLocation.set(view.getX(), view.getY());
        } else if (action == 1) {
            view.animate().translationY(0.0f).translationX(0.0f).setDuration(100L).start();
        } else if (action != 2) {
            return false;
        } else {
            if (motionEvent.getRawX() <= 0.0f) {
                f2 = 0.0f;
            } else if (motionEvent.getRawX() < f2) {
                f2 = motionEvent.getRawX();
            }
            float f4 = f2 - this$0.initialMoveLocation.x;
            if (motionEvent.getRawY() <= 0.0f) {
                f3 = 0.0f;
            } else if (motionEvent.getRawY() < f3) {
                f3 = motionEvent.getRawY();
            }
            view.setX((f4 / 4.0f) + this$0.initialCardLocation.x);
            view.setY(((f3 - this$0.initialMoveLocation.y) / 4.0f) + this$0.initialCardLocation.y);
        }
        return true;
    }

    private final void setStyles() {
        View view = getView();
        ((ProgressBar) (view == null ? null : view.findViewById(R.id.activityIndicator))).getIndeterminateDrawable().setColorFilter(new PorterDuffColorFilter(androidx.core.content.a.d(requireActivity(), R.color.primary_black), PorterDuff.Mode.SRC_IN));
    }

    private final void setupOnClicks() {
        View view = getView();
        View detailsButton = view == null ? null : view.findViewById(R.id.detailsButton);
        kotlin.jvm.internal.m.f(detailsButton, "detailsButton");
        View_CommonKt.setOnSingleClickListener$default(detailsButton, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$1(this), 1, null);
        View view2 = getView();
        View closeButton = view2 == null ? null : view2.findViewById(R.id.closeButton);
        kotlin.jvm.internal.m.f(closeButton, "closeButton");
        View_CommonKt.setOnSingleClickListener$default(closeButton, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$2(this), 1, null);
        View view3 = getView();
        View proceedButton = view3 == null ? null : view3.findViewById(R.id.proceedButton);
        kotlin.jvm.internal.m.f(proceedButton, "proceedButton");
        View_CommonKt.setOnSingleClickListener$default(proceedButton, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$3(this), 1, null);
        View view4 = getView();
        View minerFeeExplainerButton = view4 == null ? null : view4.findViewById(R.id.minerFeeExplainerButton);
        kotlin.jvm.internal.m.f(minerFeeExplainerButton, "minerFeeExplainerButton");
        View_CommonKt.setOnSingleClickListener$default(minerFeeExplainerButton, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$4(this), 1, null);
        View view5 = getView();
        View coinbaseFeeExplainerButton = view5 == null ? null : view5.findViewById(R.id.coinbaseFeeExplainerButton);
        kotlin.jvm.internal.m.f(coinbaseFeeExplainerButton, "coinbaseFeeExplainerButton");
        View_CommonKt.setOnSingleClickListener$default(coinbaseFeeExplainerButton, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$5(this), 1, null);
        View view6 = getView();
        View transferMethodContainer = view6 != null ? view6.findViewById(R.id.transferMethodContainer) : null;
        kotlin.jvm.internal.m.f(transferMethodContainer, "transferMethodContainer");
        View_CommonKt.setOnSingleClickListener$default(transferMethodContainer, 0L, new ConsumerTransferConfirmationFragment$setupOnClicks$6(this), 1, null);
    }

    public final b0<kotlin.x> updateDetailsView(final boolean z, boolean z2) {
        b0<kotlin.x> collapse;
        int height;
        View view = getView();
        View findViewById = view == null ? null : view.findViewById(R.id.detailsTab);
        int i2 = R.id.isAnimating;
        Object tag = ((LinearLayout) findViewById).getTag(i2);
        Boolean bool = Boolean.TRUE;
        boolean c2 = kotlin.jvm.internal.m.c(tag, bool);
        View view2 = getView();
        View findViewById2 = view2 == null ? null : view2.findViewById(R.id.detailsTab);
        int i3 = R.id.expanded;
        boolean c3 = kotlin.jvm.internal.m.c(((LinearLayout) findViewById2).getTag(i3), bool);
        if (!c2 && (c3 || z)) {
            Boolean valueOf = Boolean.valueOf(z);
            View view3 = getView();
            boolean z3 = !kotlin.jvm.internal.m.c(valueOf, ((LinearLayout) (view3 == null ? null : view3.findViewById(R.id.detailsTab))).getTag(i3));
            View view4 = getView();
            ((LinearLayout) (view4 == null ? null : view4.findViewById(R.id.detailsTab))).setTag(i3, Boolean.valueOf(z));
            View view5 = getView();
            ((LinearLayout) (view5 == null ? null : view5.findViewById(R.id.detailsTab))).setTag(i2, bool);
            final float dimension = getResources().getDimension(R.dimen.view_size_16);
            View view6 = getView();
            ViewGroup.LayoutParams layoutParams = ((TextView) (view6 == null ? null : view6.findViewById(R.id.cryptoAmountLabel))).getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            final ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            int i4 = (int) ((z ? 0.0f : dimension) + dimension);
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin != i4) {
                if (z2) {
                    Animation animation = new Animation() { // from class: com.coinbase.wallet.consumer.views.ConsumerTransferConfirmationFragment$updateDetailsView$cryptoAmountMarginAnim$1
                        @Override // android.view.animation.Animation
                        protected void applyTransformation(float f2, Transformation transformation) {
                            float f3 = dimension;
                            if (z) {
                                f2 = 1.0f - f2;
                            }
                            ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = (int) (f3 + (f2 * f3));
                            View view7 = this.getView();
                            ((TextView) (view7 == null ? null : view7.findViewById(R.id.cryptoAmountLabel))).setLayoutParams(bVar);
                            View view8 = this.getView();
                            View cryptoAmountLabel = view8 != null ? view8.findViewById(R.id.cryptoAmountLabel) : null;
                            kotlin.jvm.internal.m.f(cryptoAmountLabel, "cryptoAmountLabel");
                            View_CommonKt.forceMeasure(cryptoAmountLabel);
                        }
                    };
                    animation.setDuration(300L);
                    View view7 = getView();
                    ((TextView) (view7 == null ? null : view7.findViewById(R.id.cryptoAmountLabel))).startAnimation(animation);
                } else {
                    ((ViewGroup.MarginLayoutParams) bVar).bottomMargin = i4;
                    View view8 = getView();
                    ((TextView) (view8 == null ? null : view8.findViewById(R.id.cryptoAmountLabel))).setLayoutParams(bVar);
                    View view9 = getView();
                    View cryptoAmountLabel = view9 == null ? null : view9.findViewById(R.id.cryptoAmountLabel);
                    kotlin.jvm.internal.m.f(cryptoAmountLabel, "cryptoAmountLabel");
                    View_CommonKt.forceMeasure(cryptoAmountLabel);
                }
            }
            if (z) {
                if (z3) {
                    height = 1;
                } else {
                    View view10 = getView();
                    height = ((LinearLayout) (view10 == null ? null : view10.findViewById(R.id.detailsTab))).getHeight();
                }
                View view11 = getView();
                View detailsTab = view11 == null ? null : view11.findViewById(R.id.detailsTab);
                kotlin.jvm.internal.m.f(detailsTab, "detailsTab");
                collapse = View_CommonKt.expand$default(detailsTab, z2, null, height, 300L, 2, null);
            } else {
                View view12 = getView();
                View detailsTab2 = view12 == null ? null : view12.findViewById(R.id.detailsTab);
                kotlin.jvm.internal.m.f(detailsTab2, "detailsTab");
                collapse = View_CommonKt.collapse(detailsTab2, z2, 300L);
            }
            View view13 = getView();
            ((ImageView) (view13 != null ? view13.findViewById(R.id.chevronImageView) : null)).animate().rotation(z ? 180.0f : 0.0f).setDuration(100L).start();
            b0<kotlin.x> observeOn = collapse.doOnSuccess(new h.c.m0.f() { // from class: com.coinbase.wallet.consumer.views.p
                @Override // h.c.m0.f
                public final void accept(Object obj) {
                    ConsumerTransferConfirmationFragment.e(ConsumerTransferConfirmationFragment.this, (kotlin.x) obj);
                }
            }).subscribeOn(this.mainScheduler).observeOn(this.mainScheduler);
            kotlin.jvm.internal.m.f(observeOn, "single\n            .doOnSuccess { detailsTab.setTag(R.id.isAnimating, false) }\n            .subscribeOn(mainScheduler)\n            .observeOn(mainScheduler)");
            return observeOn;
        }
        b0<kotlin.x> observeOn2 = b0.just(kotlin.x.a).observeOn(this.mainScheduler);
        kotlin.jvm.internal.m.f(observeOn2, "just(Unit)\n                .observeOn(mainScheduler)");
        return observeOn2;
    }

    /* renamed from: updateDetailsView$lambda-3 */
    public static final void m1044updateDetailsView$lambda3(ConsumerTransferConfirmationFragment this$0, kotlin.x xVar) {
        kotlin.jvm.internal.m.g(this$0, "this$0");
        View view = this$0.getView();
        ((LinearLayout) (view == null ? null : view.findViewById(R.id.detailsTab))).setTag(R.id.isAnimating, Boolean.FALSE);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment
    public void _$_clearFindViewByIdCache() {
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public d0 applyWindowInsets(View view, d0 d0Var) {
        return StyledFragment.DefaultImpls.applyWindowInsets(this, view, d0Var);
    }

    @Override // com.coinbase.wallet.commonui.views.StyledFragment
    public StyledFragment.Attributes getAttributes() {
        return (StyledFragment.Attributes) this.attributes$delegate.getValue();
    }

    public final ConsumerTransferMethodsViewModel.Factory getTransferMethodsViewModelFactory$consumer_productionRelease() {
        ConsumerTransferMethodsViewModel.Factory factory = this.transferMethodsViewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("transferMethodsViewModelFactory");
        throw null;
    }

    public final ConsumerTransferConfirmationViewModel.Factory getViewModelFactory$consumer_productionRelease() {
        ConsumerTransferConfirmationViewModel.Factory factory = this.viewModelFactory;
        if (factory != null) {
            return factory;
        }
        kotlin.jvm.internal.m.w("viewModelFactory");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        kotlin.jvm.internal.m.g(inflater, "inflater");
        return inflater.inflate(R.layout.fragment_consumer_send_confirmation, viewGroup, false);
    }

    @Override // com.coinbase.wallet.commonui.views.BaseFragment, androidx.fragment.app.Fragment
    @SuppressLint({"AutoDispose"})
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.m.g(view, "view");
        super.onViewCreated(view, bundle);
        setStyles();
        setupOnClicks();
        setElasticity();
        this.isFirstDetailsUpdate = true;
        Object as = getViewModel().getNavigationObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as, "viewModel.navigationObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as, null, null, new ConsumerTransferConfirmationFragment$onViewCreated$1(this), 3, null);
        Object as2 = getViewModel().getEventObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as2, "viewModel.eventObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as2, null, null, new ConsumerTransferConfirmationFragment$onViewCreated$2(this), 3, null);
        Object as3 = getViewModel().getStateObservable().as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as3, "viewModel.stateObservable\n            .`as`(autoDisposable(scopeProvider))");
        ObservableSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.x) as3, null, null, new ConsumerTransferConfirmationFragment$onViewCreated$3(this), 3, null);
        h.c.s<ConsumerTransferMethodResult> transferMethodsObservable = Fragment_CommonKt.getNavigationResult(this, ConsumerTransferMethodsArgs.INSTANCE.getResultKey()).toObservable();
        h.c.s<ConsumerCardCDVResult> cardCDVResultObservable = Fragment_CommonKt.getNavigationResult(this, ConsumerCardCDVArgs.RESULT_KEY).toObservable();
        h.c.s<ConsumerSecure3DVerificationResult> secure3DVerificationObservable = Fragment_CommonKt.getNavigationResult(this, ConsumerSecure3DVerificationArgs.INSTANCE.getResultKey()).toObservable();
        ConsumerTransferConfirmationViewModel viewModel = getViewModel();
        kotlin.jvm.internal.m.f(transferMethodsObservable, "transferMethodsObservable");
        kotlin.jvm.internal.m.f(cardCDVResultObservable, "cardCDVResultObservable");
        kotlin.jvm.internal.m.f(secure3DVerificationObservable, "secure3DVerificationObservable");
        Object as4 = viewModel.setup(transferMethodsObservable, cardCDVResultObservable, secure3DVerificationObservable).as(com.uber.autodispose.d.a(getScopeProvider()));
        kotlin.jvm.internal.m.f(as4, "viewModel.setup(transferMethodsObservable, cardCDVResultObservable, secure3DVerificationObservable)\n            .`as`(autoDisposable(scopeProvider))");
        SingleSubscribeProxy_CommonKt.subscribeBy$default((com.uber.autodispose.a0) as4, null, ConsumerTransferConfirmationFragment$onViewCreated$4.INSTANCE, 1, null);
    }

    public final void setTransferMethodsViewModelFactory$consumer_productionRelease(ConsumerTransferMethodsViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.transferMethodsViewModelFactory = factory;
    }

    public final void setViewModelFactory$consumer_productionRelease(ConsumerTransferConfirmationViewModel.Factory factory) {
        kotlin.jvm.internal.m.g(factory, "<set-?>");
        this.viewModelFactory = factory;
    }
}