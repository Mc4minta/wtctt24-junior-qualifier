package com.coinbase.wallet.consumer.extensions;

import android.view.View;
import android.view.animation.AnimationUtils;
import com.coinbase.wallet.consumer.R;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: View+Consumer.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroid/view/View;", "Lkotlin/x;", "showInvalidKeyStroke", "(Landroid/view/View;)V", "consumer_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class View_ConsumerKt {
    public static final void showInvalidKeyStroke(View view) {
        m.g(view, "<this>");
        view.startAnimation(AnimationUtils.loadAnimation(view.getContext(), R.anim.shake));
    }
}