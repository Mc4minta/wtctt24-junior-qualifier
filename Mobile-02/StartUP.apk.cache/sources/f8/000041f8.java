package com.toshi.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.appsflyer.share.Constants;
import e.j.f.y;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.toshi.R;

/* compiled from: SpinnerOverlayLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\r\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\fR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/toshi/view/custom/SpinnerOverlayLayout;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/x;", "d", "(Landroid/util/AttributeSet;)V", "a", "()V", "", "isVisible", "b", "(Z)V", Constants.URL_CAMPAIGN, "loading", "setLoading", "", "Ljava/lang/Integer;", "overlayColor", "Landroid/content/Context;", "context", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class SpinnerOverlayLayout extends FrameLayout {
    private Integer a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpinnerOverlayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.m.g(context, "context");
    }

    public /* synthetic */ SpinnerOverlayLayout(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void a() {
        Integer num = this.a;
        setBackgroundColor(num == null ? y.b(this, R.color.semi_transparent_overlay) : num.intValue());
        setVisibility(8);
        setClickable(true);
        setFocusable(true);
    }

    private final void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.j.b.v1);
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.SpinnerOverlayLayout)");
        this.a = Integer.valueOf(obtainStyledAttributes.getColor(0, y.b(this, R.color.semi_transparent_overlay)));
        obtainStyledAttributes.recycle();
    }

    public final void b(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public final void c(boolean z) {
        android.widget.ProgressBar loadingSpinner = (android.widget.ProgressBar) findViewById(e.j.a.E3);
        kotlin.jvm.internal.m.f(loadingSpinner, "loadingSpinner");
        loadingSpinner.setVisibility(z ? 0 : 8);
    }

    public final void setLoading(boolean z) {
        setVisibility(z ? 0 : 8);
        android.widget.ProgressBar loadingSpinner = (android.widget.ProgressBar) findViewById(e.j.a.E3);
        kotlin.jvm.internal.m.f(loadingSpinner, "loadingSpinner");
        loadingSpinner.setVisibility(z ? 0 : 8);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerOverlayLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        kotlin.jvm.internal.m.g(context, "context");
        LayoutInflater.from(context).inflate(R.layout.view_spinner_overlay, this);
        a();
        if (attributeSet == null) {
            return;
        }
        d(attributeSet);
    }
}