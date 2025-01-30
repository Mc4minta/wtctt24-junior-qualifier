package com.toshi.view.custom;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import e.j.f.y;
import kotlin.Metadata;
import org.toshi.R;

/* compiled from: NetworkStatusView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/toshi/view/custom/NetworkStatusView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Lkotlin/x;", "h", "()V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class NetworkStatusView extends AppCompatTextView {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NetworkStatusView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        h();
    }

    private final void h() {
        setTextColor(y.b(this, R.color.textColorContrast));
        setBackgroundColor(y.b(this, R.color.network_status_background));
        setGravity(17);
        int pxSize = View_CommonKt.getPxSize(this, R.dimen.view_size_16);
        setPadding(pxSize, 0, pxSize, 0);
        setVisibility(8);
    }
}