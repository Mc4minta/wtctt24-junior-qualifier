package com.coinbase.wallet.features.swap.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.common.extensions.FlowableSubscribeProxy_CommonKt;
import com.coinbase.wallet.common.utilities.LocalizedStrings;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.commonui.utilities.FragmentLifecycleScopeProvider;
import com.coinbase.wallet.core.extensions.Observable_CoreKt;
import com.coinbase.wallet.features.commonui.views.TokenAvatarView;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerError;
import com.coinbase.wallet.features.swap.models.SwapAmountPickerViewState;
import com.coinbase.wallet.features.swap.viewmodels.SwapAmountPickerViewModel;
import com.coinbase.wallet.swap.models.SwapAsset;
import com.uber.autodispose.d;
import com.uber.autodispose.u;
import e.j.f.h;
import e.j.f.o;
import e.j.f.y;
import h.c.b0;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.f0.c;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: SwapAmountPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010<\u001a\u00020;\u0012\u0006\u0010?\u001a\u00020>¢\u0006\u0004\b@\u0010AJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000b\u0010\u0004J\u0015\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u001f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00020#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b+\u0010,R$\u0010/\u001a\u0010\u0012\f\u0012\n .*\u0004\u0018\u00010\u00020\u00020-8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00103\u001a\u00020\u00078\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b3\u0010,R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00102R\u0016\u00107\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00102R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u00105R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/coinbase/wallet/features/swap/views/SwapAmountPickerAdapter;", "Landroidx/viewpager/widget/a;", "Lkotlin/x;", "setupListeners", "()V", "Landroid/widget/TextView;", "textView", "Landroid/view/View;", "cursorView", "updateCursorHeight", "(Landroid/widget/TextView;Landroid/view/View;)V", "resetCursorAnimations", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", ApiConstants.STATE, "updateFromModel", "(Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;)V", "Landroid/view/ViewGroup;", "container", "", "position", "", "instantiateItem", "(Landroid/view/ViewGroup;I)Ljava/lang/Object;", "obj", "destroyItem", "(Landroid/view/ViewGroup;ILjava/lang/Object;)V", "view", "", "isViewFromObject", "(Landroid/view/View;Ljava/lang/Object;)Z", "getCount", "()I", "Lh/c/k0/b;", "cursorDisposable", "Lh/c/k0/b;", "Lh/c/b0;", "adapterViewsInitializedSingle", "Lh/c/b0;", "getAdapterViewsInitializedSingle", "()Lh/c/b0;", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "viewModel", "Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;", "fiatItemView", "Landroid/view/View;", "Lh/c/v0/a;", "kotlin.jvm.PlatformType", "adapterViewsInitializedSubject", "Lh/c/v0/a;", "hasSetupListeners", "Z", "cryptoItemView", "grey50", "I", "isSourceCursorAnimating", "isTargetCursorAnimating", "lastState", "Lcom/coinbase/wallet/features/swap/models/SwapAmountPickerViewState;", "primaryBlack", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "scopeProvider", "Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;", "Landroid/content/Context;", "context", "<init>", "(Lcom/coinbase/wallet/features/swap/viewmodels/SwapAmountPickerViewModel;Lcom/coinbase/wallet/commonui/utilities/FragmentLifecycleScopeProvider;Landroid/content/Context;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SwapAmountPickerAdapter extends androidx.viewpager.widget.a {
    private final b0<x> adapterViewsInitializedSingle;
    private final h.c.v0.a<x> adapterViewsInitializedSubject;
    private View cryptoItemView;
    private h.c.k0.b cursorDisposable;
    private View fiatItemView;
    private final int grey50;
    private boolean hasSetupListeners;
    private boolean isSourceCursorAnimating;
    private boolean isTargetCursorAnimating;
    private SwapAmountPickerViewState lastState;
    private final int primaryBlack;
    private final FragmentLifecycleScopeProvider scopeProvider;
    private final SwapAmountPickerViewModel viewModel;

    /* compiled from: SwapAmountPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SwapAmountPickerError.values().length];
            iArr[SwapAmountPickerError.InsufficientBalance.ordinal()] = 1;
            iArr[SwapAmountPickerError.LowLiquidity.ordinal()] = 2;
            iArr[SwapAmountPickerError.HighPriceImpact.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SwapAmountPickerAdapter(SwapAmountPickerViewModel viewModel, FragmentLifecycleScopeProvider scopeProvider, Context context) {
        m.g(viewModel, "viewModel");
        m.g(scopeProvider, "scopeProvider");
        m.g(context, "context");
        this.viewModel = viewModel;
        this.scopeProvider = scopeProvider;
        this.grey50 = h.f(context, R.color.grey_50);
        this.primaryBlack = h.f(context, R.color.primary_black);
        h.c.v0.a<x> d2 = h.c.v0.a.d();
        m.f(d2, "create<Unit>()");
        this.adapterViewsInitializedSubject = d2;
        this.adapterViewsInitializedSingle = Observable_CoreKt.takeSingle(d2);
    }

    public static /* synthetic */ void a(SwapAmountPickerAdapter swapAmountPickerAdapter) {
        m1509updateFromModel$lambda5(swapAmountPickerAdapter);
    }

    private final void resetCursorAnimations() {
        h.c.k0.b bVar = this.cursorDisposable;
        if (bVar != null) {
            bVar.dispose();
        }
        Object as = h.c.h.interval(0L, 700L, TimeUnit.MILLISECONDS).observeOn(h.c.j0.c.a.b()).as(d.a(this.scopeProvider));
        m.f(as, "interval(0, 700, TimeUnit.MILLISECONDS)\n            .observeOn(AndroidSchedulers.mainThread())\n            .`as`(AutoDispose.autoDisposable(scopeProvider))");
        this.cursorDisposable = FlowableSubscribeProxy_CommonKt.subscribeBy$default((u) as, null, null, new SwapAmountPickerAdapter$resetCursorAnimations$1(this), 3, null);
    }

    private final void setupListeners() {
        this.hasSetupListeners = true;
        View view = this.fiatItemView;
        if (view != null) {
            View findViewById = view.findViewById(e.j.a.rightAsset);
            m.f(findViewById, "fiatItemView.rightAsset");
            View_CommonKt.setOnSingleClickListener$default(findViewById, 0L, new SwapAmountPickerAdapter$setupListeners$1(this), 1, null);
            View view2 = this.fiatItemView;
            if (view2 != null) {
                View findViewById2 = view2.findViewById(e.j.a.leftAsset);
                m.f(findViewById2, "fiatItemView.leftAsset");
                View_CommonKt.setOnSingleClickListener$default(findViewById2, 0L, new SwapAmountPickerAdapter$setupListeners$2(this), 1, null);
                View view3 = this.fiatItemView;
                if (view3 != null) {
                    int i2 = e.j.a.errorInfoIcon;
                    ImageView imageView = (ImageView) view3.findViewById(i2);
                    m.f(imageView, "fiatItemView.errorInfoIcon");
                    View_CommonKt.setOnSingleClickListener$default(imageView, 0L, new SwapAmountPickerAdapter$setupListeners$3(this), 1, null);
                    View view4 = this.cryptoItemView;
                    if (view4 != null) {
                        View findViewById3 = view4.findViewById(e.j.a.topAsset);
                        m.f(findViewById3, "cryptoItemView.topAsset");
                        View_CommonKt.setOnSingleClickListener$default(findViewById3, 0L, new SwapAmountPickerAdapter$setupListeners$4(this), 1, null);
                        View view5 = this.cryptoItemView;
                        if (view5 != null) {
                            View findViewById4 = view5.findViewById(e.j.a.bottomAsset);
                            m.f(findViewById4, "cryptoItemView.bottomAsset");
                            View_CommonKt.setOnSingleClickListener$default(findViewById4, 0L, new SwapAmountPickerAdapter$setupListeners$5(this), 1, null);
                            View view6 = this.cryptoItemView;
                            if (view6 != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) view6.findViewById(e.j.a.topAmount);
                                m.f(appCompatTextView, "cryptoItemView.topAmount");
                                View_CommonKt.setOnSingleClickListener$default(appCompatTextView, 0L, new SwapAmountPickerAdapter$setupListeners$6(this), 1, null);
                                View view7 = this.cryptoItemView;
                                if (view7 != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) view7.findViewById(e.j.a.bottomAmount);
                                    m.f(appCompatTextView2, "cryptoItemView.bottomAmount");
                                    View_CommonKt.setOnSingleClickListener$default(appCompatTextView2, 0L, new SwapAmountPickerAdapter$setupListeners$7(this), 1, null);
                                    View view8 = this.cryptoItemView;
                                    if (view8 == null) {
                                        m.w("cryptoItemView");
                                        throw null;
                                    }
                                    ImageView imageView2 = (ImageView) view8.findViewById(i2);
                                    m.f(imageView2, "cryptoItemView.cryptoErrorInfoIcon");
                                    View_CommonKt.setOnSingleClickListener$default(imageView2, 0L, new SwapAmountPickerAdapter$setupListeners$8(this), 1, null);
                                    return;
                                }
                                m.w("cryptoItemView");
                                throw null;
                            }
                            m.w("cryptoItemView");
                            throw null;
                        }
                        m.w("cryptoItemView");
                        throw null;
                    }
                    m.w("cryptoItemView");
                    throw null;
                }
                m.w("fiatItemView");
                throw null;
            }
            m.w("fiatItemView");
            throw null;
        }
        m.w("fiatItemView");
        throw null;
    }

    private final void updateCursorHeight(TextView textView, View view) {
        int a;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        a = c.a(Math.abs(textView.getPaint().getFontMetrics().ascent));
        marginLayoutParams.height = Math.max(a, o.a(18));
        view.setLayoutParams(marginLayoutParams);
    }

    /* renamed from: updateFromModel$lambda-5 */
    public static final void m1509updateFromModel$lambda5(SwapAmountPickerAdapter this$0) {
        m.g(this$0, "this$0");
        View view = this$0.cryptoItemView;
        if (view == null) {
            m.w("cryptoItemView");
            throw null;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) view.findViewById(e.j.a.topAmount);
        m.f(appCompatTextView, "cryptoItemView.topAmount");
        View view2 = this$0.cryptoItemView;
        if (view2 != null) {
            View findViewById = view2.findViewById(e.j.a.topCursor);
            m.f(findViewById, "cryptoItemView.topCursor");
            this$0.updateCursorHeight(appCompatTextView, findViewById);
            View view3 = this$0.cryptoItemView;
            if (view3 == null) {
                m.w("cryptoItemView");
                throw null;
            }
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) view3.findViewById(e.j.a.bottomAmount);
            m.f(appCompatTextView2, "cryptoItemView.bottomAmount");
            View view4 = this$0.cryptoItemView;
            if (view4 == null) {
                m.w("cryptoItemView");
                throw null;
            }
            View findViewById2 = view4.findViewById(e.j.a.bottomCursor);
            m.f(findViewById2, "cryptoItemView.bottomCursor");
            this$0.updateCursorHeight(appCompatTextView2, findViewById2);
            return;
        }
        m.w("cryptoItemView");
        throw null;
    }

    @Override // androidx.viewpager.widget.a
    public void destroyItem(ViewGroup container, int i2, Object obj) {
        m.g(container, "container");
        m.g(obj, "obj");
        container.removeView((View) obj);
    }

    public final b0<x> getAdapterViewsInitializedSingle() {
        return this.adapterViewsInitializedSingle;
    }

    @Override // androidx.viewpager.widget.a
    public int getCount() {
        return 2;
    }

    @Override // androidx.viewpager.widget.a
    public Object instantiateItem(ViewGroup container, int i2) {
        View view;
        m.g(container, "container");
        if (i2 == 0) {
            View inflate = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_swap_fiat_item, container, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup = (ViewGroup) inflate;
            this.fiatItemView = viewGroup;
            if (viewGroup != null) {
                View findViewById = viewGroup.findViewById(e.j.a.leftAsset);
                int i3 = e.j.a.K6;
                LocalizedStrings localizedStrings = LocalizedStrings.INSTANCE;
                ((TextView) findViewById.findViewById(i3)).setText(localizedStrings.get(R.string.swap_main_card_convert));
                View view2 = this.fiatItemView;
                if (view2 != null) {
                    ((TextView) view2.findViewById(e.j.a.rightAsset).findViewById(i3)).setText(localizedStrings.get(R.string.swap_main_to));
                    view = this.fiatItemView;
                    if (view == null) {
                        m.w("fiatItemView");
                        throw null;
                    }
                } else {
                    m.w("fiatItemView");
                    throw null;
                }
            } else {
                m.w("fiatItemView");
                throw null;
            }
        } else {
            View inflate2 = LayoutInflater.from(container.getContext()).inflate(R.layout.pager_swap_crypto_item, container, false);
            Objects.requireNonNull(inflate2, "null cannot be cast to non-null type android.view.ViewGroup");
            ViewGroup viewGroup2 = (ViewGroup) inflate2;
            this.cryptoItemView = viewGroup2;
            if (viewGroup2 != null) {
                View findViewById2 = viewGroup2.findViewById(e.j.a.topAsset);
                int i4 = e.j.a.K6;
                LocalizedStrings localizedStrings2 = LocalizedStrings.INSTANCE;
                ((TextView) findViewById2.findViewById(i4)).setText(localizedStrings2.get(R.string.swap_main_card_convert));
                View view3 = this.cryptoItemView;
                if (view3 != null) {
                    ((TextView) view3.findViewById(e.j.a.bottomAsset).findViewById(i4)).setText(localizedStrings2.get(R.string.swap_main_to));
                    resetCursorAnimations();
                    view = this.cryptoItemView;
                    if (view == null) {
                        m.w("cryptoItemView");
                        throw null;
                    }
                } else {
                    m.w("cryptoItemView");
                    throw null;
                }
            } else {
                m.w("cryptoItemView");
                throw null;
            }
        }
        container.addView(view);
        if (this.fiatItemView != null && this.cryptoItemView != null) {
            this.adapterViewsInitializedSubject.onNext(x.a);
        }
        return view;
    }

    @Override // androidx.viewpager.widget.a
    public boolean isViewFromObject(View view, Object obj) {
        m.g(view, "view");
        m.g(obj, "obj");
        return view == obj;
    }

    public final void updateFromModel(SwapAmountPickerViewState state) {
        int i2;
        String str;
        m.g(state, "state");
        if (!this.hasSetupListeners) {
            setupListeners();
        }
        View view = this.fiatItemView;
        if (view != null) {
            int i3 = e.j.a.serverError;
            ViewFlipper viewFlipper = (ViewFlipper) view.findViewById(i3);
            m.f(viewFlipper, "fiatItemView.serverError");
            SwapAmountPickerError error = state.getError();
            SwapAmountPickerError swapAmountPickerError = SwapAmountPickerError.GenericError;
            viewFlipper.setVisibility(error == swapAmountPickerError ? 0 : 8);
            View view2 = this.fiatItemView;
            if (view2 != null) {
                int i4 = e.j.a.errorMessageContainer;
                ConstraintLayout constraintLayout = (ConstraintLayout) view2.findViewById(i4);
                m.f(constraintLayout, "fiatItemView.errorMessageContainer");
                SwapAmountPickerError error2 = state.getError();
                SwapAmountPickerError swapAmountPickerError2 = SwapAmountPickerError.InsufficientBalance;
                constraintLayout.setVisibility(error2 == swapAmountPickerError2 || state.getError() == SwapAmountPickerError.LowLiquidity || state.getError() == SwapAmountPickerError.HighPriceImpact ? 0 : 8);
                View view3 = this.fiatItemView;
                if (view3 != null) {
                    int i5 = e.j.a.errorInfoIcon;
                    ImageView imageView = (ImageView) view3.findViewById(i5);
                    m.f(imageView, "fiatItemView.errorInfoIcon");
                    SwapAmountPickerError error3 = state.getError();
                    SwapAmountPickerError swapAmountPickerError3 = SwapAmountPickerError.HighPriceImpact;
                    imageView.setVisibility(error3 == swapAmountPickerError3 ? 0 : 8);
                    SwapAmountPickerError error4 = state.getError();
                    int i6 = error4 == null ? -1 : WhenMappings.$EnumSwitchMapping$0[error4.ordinal()];
                    if (i6 == 1) {
                        View view4 = this.fiatItemView;
                        if (view4 == null) {
                            m.w("fiatItemView");
                            throw null;
                        }
                        int i7 = e.j.a.i2;
                        TextView textView = (TextView) view4.findViewById(i7);
                        View view5 = this.fiatItemView;
                        if (view5 != null) {
                            textView.setText(y.d(view5, R.string.swap_insufficient_balance));
                            View view6 = this.cryptoItemView;
                            if (view6 == null) {
                                m.w("cryptoItemView");
                                throw null;
                            }
                            TextView textView2 = (TextView) view6.findViewById(i7);
                            View view7 = this.cryptoItemView;
                            if (view7 == null) {
                                m.w("cryptoItemView");
                                throw null;
                            } else {
                                textView2.setText(y.d(view7, R.string.swap_insufficient_balance));
                                x xVar = x.a;
                            }
                        } else {
                            m.w("fiatItemView");
                            throw null;
                        }
                    } else if (i6 != 2) {
                        if (i6 == 3) {
                            View view8 = this.fiatItemView;
                            if (view8 == null) {
                                m.w("fiatItemView");
                                throw null;
                            }
                            int i8 = e.j.a.i2;
                            TextView textView3 = (TextView) view8.findViewById(i8);
                            View view9 = this.fiatItemView;
                            if (view9 != null) {
                                textView3.setText(y.d(view9, R.string.swap_amount_picker_error_high_price_impact));
                                View view10 = this.cryptoItemView;
                                if (view10 == null) {
                                    m.w("cryptoItemView");
                                    throw null;
                                }
                                TextView textView4 = (TextView) view10.findViewById(i8);
                                View view11 = this.cryptoItemView;
                                if (view11 == null) {
                                    m.w("cryptoItemView");
                                    throw null;
                                }
                                textView4.setText(y.d(view11, R.string.swap_amount_picker_error_high_price_impact));
                            } else {
                                m.w("fiatItemView");
                                throw null;
                            }
                        }
                        x xVar2 = x.a;
                    } else {
                        View view12 = this.fiatItemView;
                        if (view12 == null) {
                            m.w("fiatItemView");
                            throw null;
                        }
                        int i9 = e.j.a.i2;
                        TextView textView5 = (TextView) view12.findViewById(i9);
                        View view13 = this.fiatItemView;
                        if (view13 != null) {
                            textView5.setText(y.d(view13, R.string.swap_amount_picker_error_low_liquidity));
                            View view14 = this.cryptoItemView;
                            if (view14 == null) {
                                m.w("cryptoItemView");
                                throw null;
                            }
                            TextView textView6 = (TextView) view14.findViewById(i9);
                            View view15 = this.cryptoItemView;
                            if (view15 == null) {
                                m.w("cryptoItemView");
                                throw null;
                            } else {
                                textView6.setText(y.d(view15, R.string.swap_amount_picker_error_low_liquidity));
                                x xVar3 = x.a;
                            }
                        } else {
                            m.w("fiatItemView");
                            throw null;
                        }
                    }
                    View view16 = this.fiatItemView;
                    if (view16 != null) {
                        int i10 = e.j.a.z6;
                        ((TextView) view16.findViewById(i10)).setText(state.getEquivalentAmountInCrypto());
                        if (state.getSourceSwapAsset() != null && state.getTargetSwapAsset() != null && !state.isTargetFieldDisabled()) {
                            i2 = this.primaryBlack;
                        } else {
                            i2 = this.grey50;
                        }
                        View view17 = this.cryptoItemView;
                        if (view17 != null) {
                            int i11 = e.j.a.bottomAmount;
                            ((AppCompatTextView) view17.findViewById(i11)).setTextColor(i2);
                            x xVar4 = x.a;
                            if (state.getSourceSwapAsset() != null && state.getTargetSwapAsset() != null) {
                                View view18 = this.fiatItemView;
                                if (view18 != null) {
                                    ((AppCompatTextView) view18.findViewById(e.j.a.amount)).setTextColor(this.primaryBlack);
                                    View view19 = this.fiatItemView;
                                    if (view19 != null) {
                                        ((TextView) view19.findViewById(i10)).setTextColor(this.primaryBlack);
                                        View view20 = this.cryptoItemView;
                                        if (view20 == null) {
                                            m.w("cryptoItemView");
                                            throw null;
                                        }
                                        ((AppCompatTextView) view20.findViewById(e.j.a.topAmount)).setTextColor(this.primaryBlack);
                                    } else {
                                        m.w("fiatItemView");
                                        throw null;
                                    }
                                } else {
                                    m.w("fiatItemView");
                                    throw null;
                                }
                            } else {
                                View view21 = this.fiatItemView;
                                if (view21 != null) {
                                    ((AppCompatTextView) view21.findViewById(e.j.a.amount)).setTextColor(this.grey50);
                                    View view22 = this.fiatItemView;
                                    if (view22 != null) {
                                        ((TextView) view22.findViewById(i10)).setTextColor(this.grey50);
                                        View view23 = this.cryptoItemView;
                                        if (view23 == null) {
                                            m.w("cryptoItemView");
                                            throw null;
                                        }
                                        ((AppCompatTextView) view23.findViewById(e.j.a.topAmount)).setTextColor(this.grey50);
                                    } else {
                                        m.w("fiatItemView");
                                        throw null;
                                    }
                                } else {
                                    m.w("fiatItemView");
                                    throw null;
                                }
                            }
                            View view24 = this.fiatItemView;
                            if (view24 != null) {
                                ((AppCompatTextView) view24.findViewById(e.j.a.amount)).setText(state.getFiatAmountText().getFormattedAmount());
                                View view25 = this.fiatItemView;
                                if (view25 != null) {
                                    View findViewById = view25.findViewById(e.j.a.leftAsset);
                                    int i12 = e.j.a.placeholder;
                                    AppCompatTextView placeholder = (AppCompatTextView) findViewById.findViewById(i12);
                                    m.f(placeholder, "placeholder");
                                    placeholder.setVisibility(state.getSourceSwapAsset() == null && state.isInitialized() ? 0 : 8);
                                    int i13 = e.j.a.currencyCodeGroup;
                                    Group currencyCodeGroup = (Group) findViewById.findViewById(i13);
                                    m.f(currencyCodeGroup, "currencyCodeGroup");
                                    currencyCodeGroup.setVisibility(state.getSourceSwapAsset() == null || !state.isInitialized() ? 4 : 0);
                                    SwapAsset sourceSwapAsset = state.getSourceSwapAsset();
                                    if (sourceSwapAsset == null) {
                                        str = "cryptoItemView";
                                    } else {
                                        str = "cryptoItemView";
                                        ((AppCompatTextView) findViewById.findViewById(e.j.a.code)).setText(sourceSwapAsset.getCurrencyCode().getCode());
                                        TokenAvatarView tokenAvatarView = (TokenAvatarView) findViewById.findViewById(e.j.a.P2);
                                        String code = sourceSwapAsset.getCurrencyCode().getCode();
                                        URL imageURL = sourceSwapAsset.getImageURL();
                                        tokenAvatarView.load(code, imageURL == null ? null : imageURL.toString());
                                    }
                                    View view26 = this.fiatItemView;
                                    if (view26 != null) {
                                        View findViewById2 = view26.findViewById(e.j.a.rightAsset);
                                        AppCompatTextView placeholder2 = (AppCompatTextView) findViewById2.findViewById(i12);
                                        m.f(placeholder2, "placeholder");
                                        placeholder2.setVisibility(state.getTargetSwapAsset() == null ? 0 : 8);
                                        Group currencyCodeGroup2 = (Group) findViewById2.findViewById(i13);
                                        m.f(currencyCodeGroup2, "currencyCodeGroup");
                                        currencyCodeGroup2.setVisibility(state.getTargetSwapAsset() == null ? 4 : 0);
                                        SwapAsset targetSwapAsset = state.getTargetSwapAsset();
                                        if (targetSwapAsset != null) {
                                            ((AppCompatTextView) findViewById2.findViewById(e.j.a.code)).setText(targetSwapAsset.getCurrencyCode().getCode());
                                            TokenAvatarView tokenAvatarView2 = (TokenAvatarView) findViewById2.findViewById(e.j.a.P2);
                                            String code2 = targetSwapAsset.getCurrencyCode().getCode();
                                            URL imageURL2 = targetSwapAsset.getImageURL();
                                            tokenAvatarView2.load(code2, imageURL2 == null ? null : imageURL2.toString());
                                        }
                                        View view27 = this.cryptoItemView;
                                        if (view27 != null) {
                                            ViewFlipper viewFlipper2 = (ViewFlipper) view27.findViewById(i3);
                                            m.f(viewFlipper2, "cryptoItemView.serverError");
                                            viewFlipper2.setVisibility(state.getError() == swapAmountPickerError ? 0 : 8);
                                            View view28 = this.cryptoItemView;
                                            if (view28 != null) {
                                                ConstraintLayout constraintLayout2 = (ConstraintLayout) view28.findViewById(i4);
                                                m.f(constraintLayout2, "cryptoItemView.cryptoErrorMessageContainer");
                                                constraintLayout2.setVisibility(state.getError() == swapAmountPickerError2 || state.getError() == SwapAmountPickerError.LowLiquidity || state.getError() == swapAmountPickerError3 ? 0 : 8);
                                                View view29 = this.cryptoItemView;
                                                if (view29 != null) {
                                                    ImageView imageView2 = (ImageView) view29.findViewById(i5);
                                                    m.f(imageView2, "cryptoItemView.cryptoErrorInfoIcon");
                                                    imageView2.setVisibility(state.getError() == swapAmountPickerError3 ? 0 : 8);
                                                    View view30 = this.cryptoItemView;
                                                    if (view30 != null) {
                                                        ((AppCompatTextView) view30.findViewById(e.j.a.topAmountSubtext)).setText(state.getEquivalentAmountInFiat());
                                                        View view31 = this.cryptoItemView;
                                                        if (view31 != null) {
                                                            ((AppCompatTextView) view31.findViewById(e.j.a.topAmount)).setText(state.getCryptoSourceAmount().getFormattedAmount());
                                                            View view32 = this.cryptoItemView;
                                                            if (view32 != null) {
                                                                ((AppCompatTextView) view32.findViewById(i11)).setText(state.getCryptoTargetAmount().getFormattedAmount());
                                                                View view33 = this.cryptoItemView;
                                                                if (view33 != null) {
                                                                    view33.post(new Runnable() { // from class: com.coinbase.wallet.features.swap.views.a
                                                                        @Override // java.lang.Runnable
                                                                        public final void run() {
                                                                            SwapAmountPickerAdapter.a(SwapAmountPickerAdapter.this);
                                                                        }
                                                                    });
                                                                    View view34 = this.cryptoItemView;
                                                                    if (view34 != null) {
                                                                        View findViewById3 = view34.findViewById(e.j.a.topAsset);
                                                                        AppCompatTextView placeholder3 = (AppCompatTextView) findViewById3.findViewById(i12);
                                                                        m.f(placeholder3, "placeholder");
                                                                        placeholder3.setVisibility(state.getSourceSwapAsset() == null ? 0 : 8);
                                                                        Group currencyCodeGroup3 = (Group) findViewById3.findViewById(i13);
                                                                        m.f(currencyCodeGroup3, "currencyCodeGroup");
                                                                        currencyCodeGroup3.setVisibility(state.getSourceSwapAsset() == null ? 4 : 0);
                                                                        SwapAsset sourceSwapAsset2 = state.getSourceSwapAsset();
                                                                        if (sourceSwapAsset2 != null) {
                                                                            ((AppCompatTextView) findViewById3.findViewById(e.j.a.code)).setText(sourceSwapAsset2.getCurrencyCode().getCode());
                                                                            TokenAvatarView tokenAvatarView3 = (TokenAvatarView) findViewById3.findViewById(e.j.a.P2);
                                                                            String code3 = sourceSwapAsset2.getCurrencyCode().getCode();
                                                                            URL imageURL3 = sourceSwapAsset2.getImageURL();
                                                                            tokenAvatarView3.load(code3, imageURL3 == null ? null : imageURL3.toString());
                                                                        }
                                                                        View view35 = this.cryptoItemView;
                                                                        if (view35 != null) {
                                                                            View findViewById4 = view35.findViewById(e.j.a.bottomAsset);
                                                                            AppCompatTextView placeholder4 = (AppCompatTextView) findViewById4.findViewById(i12);
                                                                            m.f(placeholder4, "placeholder");
                                                                            placeholder4.setVisibility(state.getTargetSwapAsset() == null ? 0 : 8);
                                                                            Group currencyCodeGroup4 = (Group) findViewById4.findViewById(i13);
                                                                            m.f(currencyCodeGroup4, "currencyCodeGroup");
                                                                            currencyCodeGroup4.setVisibility(state.getTargetSwapAsset() == null ? 4 : 0);
                                                                            SwapAsset targetSwapAsset2 = state.getTargetSwapAsset();
                                                                            if (targetSwapAsset2 != null) {
                                                                                ((AppCompatTextView) findViewById4.findViewById(e.j.a.code)).setText(targetSwapAsset2.getCurrencyCode().getCode());
                                                                                TokenAvatarView tokenAvatarView4 = (TokenAvatarView) findViewById4.findViewById(e.j.a.P2);
                                                                                String code4 = targetSwapAsset2.getCurrencyCode().getCode();
                                                                                URL imageURL4 = targetSwapAsset2.getImageURL();
                                                                                tokenAvatarView4.load(code4, imageURL4 == null ? null : imageURL4.toString());
                                                                            }
                                                                            SwapAmountPickerViewState.CryptoField focusedCryptoInputField = state.getFocusedCryptoInputField();
                                                                            SwapAmountPickerViewState.CryptoField cryptoField = SwapAmountPickerViewState.CryptoField.SOURCE;
                                                                            this.isSourceCursorAnimating = focusedCryptoInputField == cryptoField;
                                                                            SwapAmountPickerViewState.CryptoField focusedCryptoInputField2 = state.getFocusedCryptoInputField();
                                                                            SwapAmountPickerViewState.CryptoField cryptoField2 = SwapAmountPickerViewState.CryptoField.TARGET;
                                                                            this.isTargetCursorAnimating = focusedCryptoInputField2 == cryptoField2;
                                                                            SwapAmountPickerViewState swapAmountPickerViewState = this.lastState;
                                                                            if (swapAmountPickerViewState != null) {
                                                                                if (swapAmountPickerViewState.getFocusedCryptoInputField() == cryptoField && state.getFocusedCryptoInputField() == cryptoField2) {
                                                                                    resetCursorAnimations();
                                                                                    View view36 = this.cryptoItemView;
                                                                                    if (view36 != null) {
                                                                                        View findViewById5 = view36.findViewById(e.j.a.bottomCursor);
                                                                                        m.f(findViewById5, "cryptoItemView.bottomCursor");
                                                                                        findViewById5.setVisibility(0);
                                                                                    } else {
                                                                                        m.w(str);
                                                                                        throw null;
                                                                                    }
                                                                                }
                                                                                if (swapAmountPickerViewState.getFocusedCryptoInputField() == cryptoField2 && state.getFocusedCryptoInputField() == cryptoField) {
                                                                                    resetCursorAnimations();
                                                                                    View view37 = this.cryptoItemView;
                                                                                    if (view37 != null) {
                                                                                        View findViewById6 = view37.findViewById(e.j.a.topCursor);
                                                                                        m.f(findViewById6, "cryptoItemView.topCursor");
                                                                                        findViewById6.setVisibility(0);
                                                                                    } else {
                                                                                        m.w(str);
                                                                                        throw null;
                                                                                    }
                                                                                }
                                                                            }
                                                                            this.lastState = state;
                                                                            return;
                                                                        }
                                                                        m.w(str);
                                                                        throw null;
                                                                    }
                                                                    m.w(str);
                                                                    throw null;
                                                                }
                                                                m.w(str);
                                                                throw null;
                                                            }
                                                            m.w(str);
                                                            throw null;
                                                        }
                                                        m.w(str);
                                                        throw null;
                                                    }
                                                    m.w(str);
                                                    throw null;
                                                }
                                                m.w(str);
                                                throw null;
                                            }
                                            m.w(str);
                                            throw null;
                                        }
                                        m.w(str);
                                        throw null;
                                    }
                                    m.w("fiatItemView");
                                    throw null;
                                }
                                m.w("fiatItemView");
                                throw null;
                            }
                            m.w("fiatItemView");
                            throw null;
                        }
                        m.w("cryptoItemView");
                        throw null;
                    }
                    m.w("fiatItemView");
                    throw null;
                }
                m.w("fiatItemView");
                throw null;
            }
            m.w("fiatItemView");
            throw null;
        }
        m.w("fiatItemView");
        throw null;
    }
}