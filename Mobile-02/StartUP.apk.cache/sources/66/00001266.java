package com.coinbase.wallet.application.view.custom;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.h0.c;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: LendBlobView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\b¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0006\u0010\u0004R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/LendBlobView;", "Landroid/widget/FrameLayout;", "Lkotlin/x;", "runImageTransitions", "()V", "runSlowSpinAnimation", "runFastSpinAnimation", "", "", "imageResList", "Ljava/util/List;", "Lcom/coinbase/wallet/application/view/custom/LendBlobView$LendBlobChild;", "child2", "Lcom/coinbase/wallet/application/view/custom/LendBlobView$LendBlobChild;", "child1", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LendBlobChild", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendBlobView extends FrameLayout {
    private LendBlobChild child1;
    private LendBlobChild child2;
    private final List<Integer> imageResList;

    /* compiled from: LendBlobView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B1\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/LendBlobView$LendBlobChild;", "Landroid/widget/FrameLayout;", "Lkotlin/x;", "swapViews", "()V", "", "imageRes", "transitionTo", "(I)V", "Landroid/widget/ImageView;", "newImageView", "Landroid/widget/ImageView;", "oldImageView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyle", "resource", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class LendBlobChild extends FrameLayout {
        public static final Companion Companion = new Companion(null);
        private static final float MAX_SCALE = 0.75f;
        private static final float MIN_SCALE = 0.65f;
        private ImageView newImageView;
        private ImageView oldImageView;

        /* compiled from: LendBlobView.kt */
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/application/view/custom/LendBlobView$LendBlobChild$Companion;", "", "", "MAX_SCALE", "F", "MIN_SCALE", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
        /* loaded from: classes.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LendBlobChild(Context context) {
            this(context, null, 0, 0, 14, null);
            m.g(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LendBlobChild(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, 0, 0, 12, null);
            m.g(context, "context");
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public LendBlobChild(Context context, AttributeSet attributeSet, int i2) {
            this(context, attributeSet, i2, 0, 8, null);
            m.g(context, "context");
        }

        public /* synthetic */ LendBlobChild(Context context, AttributeSet attributeSet, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
            this(context, (i4 & 2) != 0 ? null : attributeSet, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? R.drawable.lend_blob_a1 : i3);
        }

        private final void swapViews() {
            ImageView imageView = this.newImageView;
            this.newImageView = this.oldImageView;
            this.oldImageView = imageView;
        }

        public void _$_clearFindViewByIdCache() {
        }

        public final void transitionTo(int i2) {
            swapViews();
            this.newImageView.setImageResource(i2);
            ImageView imageView = this.newImageView;
            imageView.setScaleX(MIN_SCALE);
            imageView.setScaleY(MIN_SCALE);
            this.newImageView.animate().alpha(0.7f).scaleX(MAX_SCALE).scaleY(MAX_SCALE).setDuration(20000L).setInterpolator(new LinearInterpolator()).start();
            this.oldImageView.animate().alpha(0.0f).scaleX(MIN_SCALE).scaleY(MIN_SCALE).setDuration(20000L).setInterpolator(new LinearInterpolator()).start();
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public LendBlobChild(Context context, AttributeSet attributeSet, int i2, int i3) {
            super(context, attributeSet, i2);
            m.g(context, "context");
            this.newImageView = new ImageView(context);
            this.oldImageView = new ImageView(context);
            this.newImageView.setImageResource(i3);
            this.newImageView.setScaleX(MAX_SCALE);
            this.newImageView.setScaleY(MAX_SCALE);
            this.oldImageView.setAlpha(0.0f);
            addView(this.newImageView);
            addView(this.oldImageView);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LendBlobView(Context context) {
        this(context, null, 0, 6, null);
        m.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LendBlobView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        m.g(context, "context");
    }

    public /* synthetic */ LendBlobView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void a(LendBlobView lendBlobView) {
        m693runSlowSpinAnimation$lambda0(lendBlobView);
    }

    public static final /* synthetic */ LendBlobChild access$getChild1$p(LendBlobView lendBlobView) {
        return lendBlobView.child1;
    }

    public static final /* synthetic */ LendBlobChild access$getChild2$p(LendBlobView lendBlobView) {
        return lendBlobView.child2;
    }

    public static final /* synthetic */ List access$getImageResList$p(LendBlobView lendBlobView) {
        return lendBlobView.imageResList;
    }

    public static /* synthetic */ void b(LendBlobView lendBlobView) {
        m692runFastSpinAnimation$lambda1(lendBlobView);
    }

    private final void runFastSpinAnimation() {
        this.child2.setRotation(0.0f);
        this.child2.animate().rotation(360.0f).setDuration(50000L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.coinbase.wallet.application.view.custom.b
            @Override // java.lang.Runnable
            public final void run() {
                LendBlobView.b(LendBlobView.this);
            }
        }).start();
    }

    /* renamed from: runFastSpinAnimation$lambda-1 */
    public static final void m692runFastSpinAnimation$lambda1(LendBlobView this$0) {
        m.g(this$0, "this$0");
        this$0.runFastSpinAnimation();
    }

    private final void runImageTransitions() {
        final Handler handler = new Handler();
        Handler handler2 = new Handler();
        handler.postDelayed(new Runnable() { // from class: com.coinbase.wallet.application.view.custom.LendBlobView$runImageTransitions$1
            @Override // java.lang.Runnable
            public void run() {
                LendBlobView.access$getChild1$p(LendBlobView.this).transitionTo(((Number) LendBlobView.access$getImageResList$p(LendBlobView.this).get(kotlin.h0.c.f17279b.d(0, LendBlobView.access$getImageResList$p(LendBlobView.this).size()))).intValue());
                handler.postDelayed(this, r3);
            }
        }, 27000L);
        handler2.postDelayed(new Runnable() { // from class: com.coinbase.wallet.application.view.custom.LendBlobView$runImageTransitions$2
            @Override // java.lang.Runnable
            public void run() {
                LendBlobView.access$getChild2$p(LendBlobView.this).transitionTo(((Number) LendBlobView.access$getImageResList$p(LendBlobView.this).get(kotlin.h0.c.f17279b.d(0, LendBlobView.access$getImageResList$p(LendBlobView.this).size()))).intValue());
                handler.postDelayed(this, r3);
            }
        }, 25000L);
    }

    private final void runSlowSpinAnimation() {
        this.child1.setRotation(0.0f);
        this.child1.animate().rotation(-360.0f).setDuration(60000L).setInterpolator(new LinearInterpolator()).withEndAction(new Runnable() { // from class: com.coinbase.wallet.application.view.custom.a
            @Override // java.lang.Runnable
            public final void run() {
                LendBlobView.a(LendBlobView.this);
            }
        }).start();
    }

    /* renamed from: runSlowSpinAnimation$lambda-0 */
    public static final void m693runSlowSpinAnimation$lambda0(LendBlobView this$0) {
        m.g(this$0, "this$0");
        this$0.runSlowSpinAnimation();
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LendBlobView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        List<Integer> j2;
        m.g(context, "context");
        j2 = r.j(Integer.valueOf((int) R.drawable.lend_blob_a2), Integer.valueOf((int) R.drawable.lend_blob_b1), Integer.valueOf((int) R.drawable.lend_blob_a1), Integer.valueOf((int) R.drawable.lend_blob_b2), Integer.valueOf((int) R.drawable.lend_blob_c1), Integer.valueOf((int) R.drawable.lend_blob_c2), Integer.valueOf((int) R.drawable.lend_blob_d1), Integer.valueOf((int) R.drawable.lend_blob_d2));
        this.imageResList = j2;
        c.a aVar = kotlin.h0.c.f17279b;
        int d2 = aVar.d(0, j2.size());
        int d3 = aVar.d(0, j2.size());
        this.child1 = new LendBlobChild(context, null, 0, j2.get(d2).intValue(), 6, null);
        this.child2 = new LendBlobChild(context, null, 0, j2.get(d3).intValue(), 6, null);
        addView(this.child1);
        addView(this.child2);
        runSlowSpinAnimation();
        runFastSpinAnimation();
        runImageTransitions();
    }
}