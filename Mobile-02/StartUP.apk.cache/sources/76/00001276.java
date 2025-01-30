package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.crypto.tls.CipherSuite;

/* compiled from: ViewPagerHeader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\b¢\u0006\u0004\bD\u0010EJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0010\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u000bJ1\u0010\u0018\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u001a\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ1\u0010\u001c\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\rH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010\u001e\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR$\u0010!\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00158\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010&\u001a\u00020%8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u00020\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u0010\u000bR\u0016\u00101\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010-R$\u00102\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00158\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b2\u0010\"\"\u0004\b3\u0010$R\"\u00105\u001a\u0002048\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u0016\u0010;\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0013\u0010=\u001a\u00020\u00158F@\u0006¢\u0006\u0006\u001a\u0004\b=\u0010>¨\u0006F"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/ViewPagerHeader;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroidx/viewpager/widget/ViewPager$j;", "Landroidx/constraintlayout/motion/widget/MotionLayout$i;", "Lkotlin/x;", "goToStart", "()V", "goToEnd", "", ApiConstants.STATE, "onPageScrollStateChanged", "(I)V", "position", "", "positionOffset", "positionOffsetPixels", "onPageScrolled", "(IFI)V", "onPageSelected", "p0", "p1", "", "p2", "p3", "onTransitionTrigger", "(Landroidx/constraintlayout/motion/widget/MotionLayout;IZF)V", "onTransitionStarted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;II)V", "onTransitionChange", "(Landroidx/constraintlayout/motion/widget/MotionLayout;IIF)V", "onTransitionCompleted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;I)V", "value", "inPageSelectedTransition", "Z", "setInPageSelectedTransition", "(Z)V", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "getViewPager", "()Landroidx/viewpager/widget/ViewPager;", "setViewPager", "(Landroidx/viewpager/widget/ViewPager;)V", "numPages", "I", "getNumPages", "()I", "setNumPages", "lastCompletedTransition", "inPageSwipeTransition", "setInPageSwipeTransition", "Landroid/view/View;", "transitionTouchBlocker", "Landroid/view/View;", "getTransitionTouchBlocker", "()Landroid/view/View;", "setTransitionTouchBlocker", "(Landroid/view/View;)V", "previousProgress", "F", "isTransitioning", "()Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ViewPagerHeader extends MotionLayout implements ViewPager.j, MotionLayout.i {
    private boolean inPageSelectedTransition;
    private boolean inPageSwipeTransition;
    private int lastCompletedTransition;
    private int numPages;
    private float previousProgress;
    public View transitionTouchBlocker;
    public ViewPager viewPager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerHeader(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewPagerHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ ViewPagerHeader(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void setInPageSelectedTransition(boolean z) {
        getTransitionTouchBlocker().setVisibility(z ? 0 : 8);
        this.inPageSelectedTransition = z;
    }

    private final void setInPageSwipeTransition(boolean z) {
        getTransitionTouchBlocker().setVisibility(z ? 0 : 8);
        this.inPageSwipeTransition = z;
    }

    public void _$_clearFindViewByIdCache() {
    }

    public final int getNumPages() {
        return this.numPages;
    }

    public final View getTransitionTouchBlocker() {
        View view = this.transitionTouchBlocker;
        if (view != null) {
            return view;
        }
        m.w("transitionTouchBlocker");
        throw null;
    }

    public final ViewPager getViewPager() {
        ViewPager viewPager = this.viewPager;
        if (viewPager != null) {
            return viewPager;
        }
        m.w("viewPager");
        throw null;
    }

    public final void goToEnd() {
        setTransitionDuration(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
        transitionToEnd();
    }

    public final void goToStart() {
        setTransitionDuration(CipherSuite.TLS_RSA_WITH_SEED_CBC_SHA);
        transitionToStart();
    }

    public final boolean isTransitioning() {
        return 0.0f < getProgress() && getProgress() < 1.0f;
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrollStateChanged(int i2) {
        if (i2 == 0) {
            setInPageSelectedTransition(false);
            setInPageSwipeTransition(false);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageScrolled(int i2, float f2, int i3) {
        if (!this.inPageSelectedTransition) {
            setInPageSwipeTransition(true);
        }
        if (this.inPageSwipeTransition) {
            setProgress((i2 + f2) / (this.numPages - 1));
        }
        if (!(f2 == 1.0f)) {
            if (!(f2 == 0.0f)) {
                return;
            }
        }
        setInPageSwipeTransition(false);
    }

    @Override // androidx.viewpager.widget.ViewPager.j
    public void onPageSelected(int i2) {
        setInPageSelectedTransition(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0034  */
    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onTransitionChange(androidx.constraintlayout.motion.widget.MotionLayout r2, int r3, int r4, float r5) {
        /*
            r1 = this;
            int r2 = r1.lastCompletedTransition
            r3 = 0
            r4 = 1
            if (r2 <= 0) goto L1a
            r0 = 2131362366(0x7f0a023e, float:1.834451E38)
            if (r2 != r0) goto L1a
            r0 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r0 != 0) goto L13
            r0 = r4
            goto L14
        L13:
            r0 = r3
        L14:
            if (r0 == 0) goto L1a
            r1.fireTransitionCompleted()
            goto L2e
        L1a:
            if (r2 <= 0) goto L2e
            r0 = 2131362929(0x7f0a0471, float:1.8345652E38)
            if (r2 != r0) goto L2e
            r2 = 0
            int r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r2 != 0) goto L28
            r2 = r4
            goto L29
        L28:
            r2 = r3
        L29:
            if (r2 == 0) goto L2e
            r1.fireTransitionCompleted()
        L2e:
            boolean r2 = r1.isTransitioning()
            if (r2 != 0) goto L69
            float r2 = r1.getProgress()
            float r5 = r1.previousProgress
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            r5 = 1056964608(0x3f000000, float:0.5)
            if (r2 <= 0) goto L50
            float r2 = r1.getProgress()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 <= 0) goto L50
            androidx.viewpager.widget.ViewPager r2 = r1.getViewPager()
            r2.setCurrentItem(r4, r4)
            goto L69
        L50:
            float r2 = r1.getProgress()
            float r0 = r1.previousProgress
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 >= 0) goto L69
            float r2 = r1.getProgress()
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L69
            androidx.viewpager.widget.ViewPager r2 = r1.getViewPager()
            r2.setCurrentItem(r3, r4)
        L69:
            float r2 = r1.getProgress()
            r1.previousProgress = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.application.view.custom.ViewPagerHeader.onTransitionChange(androidx.constraintlayout.motion.widget.MotionLayout, int, int, float):void");
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionCompleted(MotionLayout motionLayout, int i2) {
        this.lastCompletedTransition = i2;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
    public void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z, float f2) {
    }

    public final void setNumPages(int i2) {
        this.numPages = i2;
    }

    public final void setTransitionTouchBlocker(View view) {
        m.g(view, "<set-?>");
        this.transitionTouchBlocker = view;
    }

    public final void setViewPager(ViewPager viewPager) {
        m.g(viewPager, "<set-?>");
        this.viewPager = viewPager;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewPagerHeader(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.g(context, "context");
        this.lastCompletedTransition = -1;
        this.numPages = 2;
        setTransitionListener(this);
    }
}