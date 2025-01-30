package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.appsflyer.internal.referrer.Payload;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.analytics.extensions.Observable_AnalyticsKt;
import com.coinbase.wallet.application.view.custom.TopAwareMotionLayout;
import com.coinbase.wallet.application.viewmodel.ScrolledToTopViewModel;
import h.c.m0.n;
import h.c.m0.p;
import h.c.s;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.x;
import org.toshi.R;

/* compiled from: TopAwareMotionLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002:;B'\b\u0007\u0012\u0006\u00104\u001a\u000203\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u000105\u0012\b\b\u0002\u00107\u001a\u00020\u001a¢\u0006\u0004\b8\u00109J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0011J\u001b\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0017\u0010\u0016J\u001b\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u00142\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0018\u0010\u0016J1\u0010\u001f\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001f\u0010 J)\u0010!\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001aH\u0016¢\u0006\u0004\b!\u0010\"J1\u0010#\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b#\u0010$J!\u0010%\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b%\u0010&J#\u0010)\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010'2\b\u0010\u001b\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b)\u0010*R$\u0010.\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010,0,0+8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/R$\u00101\u001a\u0010\u0012\f\u0012\n -*\u0004\u0018\u00010\u00040\u0004008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006<"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroidx/constraintlayout/motion/widget/MotionLayout$i;", "Landroid/view/View$OnTouchListener;", "", "isCollapsed", "Lkotlin/x;", "restoreAnimationState", "(Z)V", "useCollapsedTransition", "setTransition", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", ApiConstants.STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "()Z", "Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;", "scrolledToTopViewModel", "Lh/c/s;", "startIsTouchedListener", "(Lcom/coinbase/wallet/application/viewmodel/ScrolledToTopViewModel;)Lh/c/s;", "startTransitionSwapListener", "startRefreshableListener", "p0", "", "p1", "p2", "", "p3", "onTransitionTrigger", "(Landroidx/constraintlayout/motion/widget/MotionLayout;IZF)V", "onTransitionStarted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;II)V", "onTransitionChange", "(Landroidx/constraintlayout/motion/widget/MotionLayout;IIF)V", "onTransitionCompleted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;I)V", "Landroid/view/View;", "Landroid/view/MotionEvent;", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "Lh/c/v0/a;", "Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout$AnimationState;", "kotlin.jvm.PlatformType", "animationStateObservable", "Lh/c/v0/a;", "Lh/c/v0/b;", "motionLayoutTouchedObservable", "Lh/c/v0/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AnimationState", "SavedState", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class TopAwareMotionLayout extends MotionLayout implements MotionLayout.i, View.OnTouchListener {
    private final h.c.v0.a<AnimationState> animationStateObservable;
    private final h.c.v0.b<Boolean> motionLayoutTouchedObservable;

    /* compiled from: TopAwareMotionLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout$AnimationState;", "", "<init>", "(Ljava/lang/String;I)V", "COLLAPSED", "EXPANDED", "TRANSIT", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum AnimationState {
        COLLAPSED,
        EXPANDED,
        TRANSIT
    }

    /* compiled from: TopAwareMotionLayout.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0013\b\u0016\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0013\u0010\u0014B\u0011\b\u0016\u0012\u0006\u0010\u0015\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout$SavedState;", "Landroid/view/View$BaseSavedState;", "Landroid/os/Parcel;", "out", "", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "isCollapsed", "Z", "()Z", "setCollapsed", "(Z)V", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", Payload.SOURCE, "(Landroid/os/Parcel;)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class SavedState extends View.BaseSavedState {
        private boolean isCollapsed;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: com.coinbase.wallet.application.view.custom.TopAwareMotionLayout$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TopAwareMotionLayout.SavedState createFromParcel(Parcel source) {
                m.g(source, "source");
                return new TopAwareMotionLayout.SavedState(source);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public TopAwareMotionLayout.SavedState[] newArray(int i2) {
                return new TopAwareMotionLayout.SavedState[i2];
            }
        };

        /* compiled from: TopAwareMotionLayout.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout$SavedState$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/coinbase/wallet/application/view/custom/TopAwareMotionLayout$SavedState;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final boolean isCollapsed() {
            return this.isCollapsed;
        }

        public final void setCollapsed(boolean z) {
            this.isCollapsed = z;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int i2) {
            m.g(out, "out");
            super.writeToParcel(out, i2);
            out.writeByte(this.isCollapsed ? (byte) 1 : (byte) 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source) {
            super(source);
            m.g(source, "source");
            this.isCollapsed = source.readByte() != 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopAwareMotionLayout(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopAwareMotionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ TopAwareMotionLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ Boolean a(o oVar) {
        return m695startRefreshableListener$lambda4(oVar);
    }

    public static /* synthetic */ x b(ScrolledToTopViewModel scrolledToTopViewModel, Boolean bool) {
        return m694startIsTouchedListener$lambda0(scrolledToTopViewModel, bool);
    }

    public static /* synthetic */ boolean c(o oVar) {
        return m696startTransitionSwapListener$lambda1(oVar);
    }

    public static /* synthetic */ x d(TopAwareMotionLayout topAwareMotionLayout, Boolean bool) {
        return m698startTransitionSwapListener$lambda3(topAwareMotionLayout, bool);
    }

    public static /* synthetic */ Boolean e(o oVar) {
        return m697startTransitionSwapListener$lambda2(oVar);
    }

    private final void restoreAnimationState(boolean z) {
        if (z) {
            transitionToEnd();
            this.animationStateObservable.onNext(AnimationState.COLLAPSED);
            return;
        }
        this.animationStateObservable.onNext(AnimationState.EXPANDED);
    }

    private final void setTransition(boolean z) {
        String str;
        if (z) {
            setTransition(getTransition(R.id.walletToolbarTransitionCollapsed));
            str = "collapsed";
        } else {
            setTransition(getTransition(R.id.walletToolbarTransitionExpanded));
            str = "expanded";
        }
        setTransitionName(str);
    }

    /* renamed from: startIsTouchedListener$lambda-0 */
    public static final x m694startIsTouchedListener$lambda0(ScrolledToTopViewModel scrolledToTopViewModel, Boolean isTouched) {
        m.g(scrolledToTopViewModel, "$scrolledToTopViewModel");
        m.g(isTouched, "isTouched");
        scrolledToTopViewModel.isTouched(isTouched.booleanValue());
        return x.a;
    }

    /* renamed from: startRefreshableListener$lambda-4 */
    public static final Boolean m695startRefreshableListener$lambda4(o dstr$animationState$scrolledToTop) {
        m.g(dstr$animationState$scrolledToTop, "$dstr$animationState$scrolledToTop");
        return Boolean.valueOf(((AnimationState) dstr$animationState$scrolledToTop.a()) == AnimationState.EXPANDED && ((Boolean) dstr$animationState$scrolledToTop.b()).booleanValue());
    }

    /* renamed from: startTransitionSwapListener$lambda-1 */
    public static final boolean m696startTransitionSwapListener$lambda1(o dstr$state$_u24__u24) {
        m.g(dstr$state$_u24__u24, "$dstr$state$_u24__u24");
        return ((AnimationState) dstr$state$_u24__u24.a()) != AnimationState.TRANSIT;
    }

    /* renamed from: startTransitionSwapListener$lambda-2 */
    public static final Boolean m697startTransitionSwapListener$lambda2(o dstr$state$isTop) {
        m.g(dstr$state$isTop, "$dstr$state$isTop");
        return Boolean.valueOf(((AnimationState) dstr$state$isTop.a()) == AnimationState.EXPANDED && !((Boolean) dstr$state$isTop.b()).booleanValue());
    }

    /* renamed from: startTransitionSwapListener$lambda-3 */
    public static final x m698startTransitionSwapListener$lambda3(TopAwareMotionLayout this$0, Boolean isUnlocked) {
        m.g(this$0, "this$0");
        m.g(isUnlocked, "isUnlocked");
        this$0.setTransition(isUnlocked.booleanValue());
        return x.a;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final boolean isCollapsed() {
        return this.animationStateObservable.f() == AnimationState.COLLAPSED;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        Objects.requireNonNull(parcelable, "null cannot be cast to non-null type com.coinbase.wallet.application.view.custom.TopAwareMotionLayout.SavedState");
        SavedState savedState = (SavedState) parcelable;
        restoreAnimationState(savedState.isCollapsed());
        setTransition(savedState.isCollapsed());
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setCollapsed(isCollapsed());
        return savedState;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getAction() == 0) {
            this.motionLayoutTouchedObservable.onNext(Boolean.TRUE);
        } else {
            if (motionEvent != null && motionEvent.getAction() == 1) {
                this.motionLayoutTouchedObservable.onNext(Boolean.FALSE);
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionChange(MotionLayout motionLayout, int i2, int i3, float f2) {
        if (f2 == 0.0f) {
            if (m.c(getTransitionName(), "collapsed")) {
                this.animationStateObservable.onNext(AnimationState.COLLAPSED);
                return;
            } else {
                this.animationStateObservable.onNext(AnimationState.EXPANDED);
                return;
            }
        }
        if (f2 == 1.0f) {
            if (m.c(getTransitionName(), "collapsed")) {
                this.animationStateObservable.onNext(AnimationState.EXPANDED);
                return;
            } else {
                this.animationStateObservable.onNext(AnimationState.COLLAPSED);
                return;
            }
        }
        this.animationStateObservable.onNext(AnimationState.TRANSIT);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionCompleted(MotionLayout motionLayout, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z, float f2) {
    }

    public final s<x> startIsTouchedListener(final ScrolledToTopViewModel scrolledToTopViewModel) {
        m.g(scrolledToTopViewModel, "scrolledToTopViewModel");
        s<Boolean> observeOn = this.motionLayoutTouchedObservable.observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "motionLayoutTouchedObservable\n        .observeOn(AndroidSchedulers.mainThread())");
        s<x> map = Observable_AnalyticsKt.logError$default(observeOn, "Could not update touched state of motionLayout", null, 2, null).map(new n() { // from class: com.coinbase.wallet.application.view.custom.d
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareMotionLayout.b(ScrolledToTopViewModel.this, (Boolean) obj);
            }
        });
        m.f(map, "motionLayoutTouchedObservable\n        .observeOn(AndroidSchedulers.mainThread())\n        .logError(\"Could not update touched state of motionLayout\")\n        .map { isTouched -> scrolledToTopViewModel.isTouched(isTouched) }");
        return map;
    }

    public final s<Boolean> startRefreshableListener(ScrolledToTopViewModel scrolledToTopViewModel) {
        m.g(scrolledToTopViewModel, "scrolledToTopViewModel");
        s map = h.c.t0.c.a.a(this.animationStateObservable, scrolledToTopViewModel.getScrolledToTopObservable()).map(new n() { // from class: com.coinbase.wallet.application.view.custom.c
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareMotionLayout.a((o) obj);
            }
        });
        m.f(map, "Observables\n        .combineLatest(animationStateObservable, scrolledToTopViewModel.scrolledToTopObservable)\n        .map { (animationState, scrolledToTop) -> (animationState == AnimationState.EXPANDED && scrolledToTop) }");
        return Observable_AnalyticsKt.logError$default(map, "Could not update refreshable state", null, 2, null);
    }

    public final s<x> startTransitionSwapListener(ScrolledToTopViewModel scrolledToTopViewModel) {
        m.g(scrolledToTopViewModel, "scrolledToTopViewModel");
        s observeOn = h.c.t0.c.a.a(this.animationStateObservable, scrolledToTopViewModel.getScrolledToTopObservable()).observeOn(h.c.j0.c.a.b());
        m.f(observeOn, "Observables\n        .combineLatest(animationStateObservable, scrolledToTopViewModel.scrolledToTopObservable)\n        .observeOn(AndroidSchedulers.mainThread())");
        s<x> map = Observable_AnalyticsKt.logError$default(observeOn, "Could not update swap state of motionLayout", null, 2, null).filter(new p() { // from class: com.coinbase.wallet.application.view.custom.e
            @Override // h.c.m0.p
            public final boolean test(Object obj) {
                return TopAwareMotionLayout.c((o) obj);
            }
        }).map(new n() { // from class: com.coinbase.wallet.application.view.custom.g
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareMotionLayout.e((o) obj);
            }
        }).distinctUntilChanged().skip(1L).map(new n() { // from class: com.coinbase.wallet.application.view.custom.f
            @Override // h.c.m0.n
            public final Object apply(Object obj) {
                return TopAwareMotionLayout.d(TopAwareMotionLayout.this, (Boolean) obj);
            }
        });
        m.f(map, "Observables\n        .combineLatest(animationStateObservable, scrolledToTopViewModel.scrolledToTopObservable)\n        .observeOn(AndroidSchedulers.mainThread())\n        .logError(\"Could not update swap state of motionLayout\")\n        .filter { (state, _) -> state != AnimationState.TRANSIT }\n        .map { (state, isTop) -> (state == AnimationState.EXPANDED && !isTop) }\n        .distinctUntilChanged()\n        .skip(1)\n        .map { isUnlocked -> setTransition(useCollapsedTransition = isUnlocked) }");
        return map;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TopAwareMotionLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        h.c.v0.a<AnimationState> d2 = h.c.v0.a.d();
        m.f(d2, "create<AnimationState>()");
        this.animationStateObservable = d2;
        h.c.v0.b<Boolean> d3 = h.c.v0.b.d();
        m.f(d3, "create<Boolean>()");
        this.motionLayoutTouchedObservable = d3;
        setSaveEnabled(true);
        setTransitionListener(this);
        setOnTouchListener(this);
    }
}