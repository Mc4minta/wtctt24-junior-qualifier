package com.coinbase.wallet.commonui.utilities.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.Metadata;
import kotlin.e0.c.p;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import kotlin.x;

/* compiled from: AnimatorListener.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B)\u0012\u0006\u0010\u0010\u001a\u00020\r\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\f¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006R\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR(\u0010\u000e\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/animation/AnimatorListener;", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "Lkotlin/x;", "onAnimationCancel", "(Landroid/animation/Animator;)V", "animator", "onAnimationEnd", "", "isCanceled", "Z", "Lkotlin/Function2;", "Landroid/view/View;", "listener", "Lkotlin/e0/c/p;", "view", "Landroid/view/View;", "<init>", "(Landroid/view/View;Lkotlin/e0/c/p;)V", "Companion", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class AnimatorListener extends AnimatorListenerAdapter {
    public static final Companion Companion = new Companion(null);
    private boolean isCanceled;
    private final p<View, Boolean, x> listener;
    private final View view;

    /* compiled from: AnimatorListener.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u001a\u0010\u0007\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/commonui/utilities/animation/AnimatorListener$Companion;", "", "Landroid/view/View;", "view", "Lkotlin/Function2;", "", "Lkotlin/x;", "listener", "Lcom/coinbase/wallet/commonui/utilities/animation/AnimatorListener;", "getListener", "(Landroid/view/View;Lkotlin/e0/c/p;)Lcom/coinbase/wallet/commonui/utilities/animation/AnimatorListener;", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AnimatorListener getListener(View view, p<? super View, ? super Boolean, x> pVar) {
            m.g(view, "view");
            if (pVar == null) {
                return null;
            }
            return new AnimatorListener(view, pVar) { // from class: com.coinbase.wallet.commonui.utilities.animation.AnimatorListener$Companion$getListener$1
                final /* synthetic */ p<View, Boolean, x> $listener;
                final /* synthetic */ View $view;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(view, pVar);
                    this.$view = view;
                    this.$listener = pVar;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorListener(View view, p<? super View, ? super Boolean, x> listener) {
        m.g(view, "view");
        m.g(listener, "listener");
        this.view = view;
        this.listener = listener;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        this.isCanceled = true;
        super.onAnimationCancel(animator);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.listener.invoke(this.view, Boolean.valueOf(this.isCanceled));
    }
}