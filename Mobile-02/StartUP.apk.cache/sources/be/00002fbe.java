package com.facebook.react.views.progressbar;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.reactnativecommunity.webview.RNCWebViewManager;

/* compiled from: ProgressBarContainerView.java */
/* loaded from: classes2.dex */
class a extends FrameLayout {
    private Integer a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5346b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5347c;

    /* renamed from: d  reason: collision with root package name */
    private double f5348d;

    /* renamed from: e  reason: collision with root package name */
    private ProgressBar f5349e;

    public a(Context context) {
        super(context);
        this.f5346b = true;
        this.f5347c = true;
    }

    private void c(ProgressBar progressBar) {
        Drawable progressDrawable;
        if (progressBar.isIndeterminate()) {
            progressDrawable = progressBar.getIndeterminateDrawable();
        } else {
            progressDrawable = progressBar.getProgressDrawable();
        }
        if (progressDrawable == null) {
            return;
        }
        Integer num = this.a;
        if (num != null) {
            progressDrawable.setColorFilter(num.intValue(), PorterDuff.Mode.SRC_IN);
        } else {
            progressDrawable.clearColorFilter();
        }
    }

    public void a() {
        ProgressBar progressBar = this.f5349e;
        if (progressBar != null) {
            progressBar.setIndeterminate(this.f5346b);
            c(this.f5349e);
            this.f5349e.setProgress((int) (this.f5348d * 1000.0d));
            if (this.f5347c) {
                this.f5349e.setVisibility(0);
                return;
            } else {
                this.f5349e.setVisibility(4);
                return;
            }
        }
        throw new JSApplicationIllegalArgumentException("setStyle() not called");
    }

    public void b(boolean z) {
        this.f5347c = z;
    }

    public void d(Integer num) {
        this.a = num;
    }

    public void e(boolean z) {
        this.f5346b = z;
    }

    public void f(double d2) {
        this.f5348d = d2;
    }

    public void g(String str) {
        ProgressBar createProgressBar = ReactProgressBarViewManager.createProgressBar(getContext(), ReactProgressBarViewManager.getStyleFromString(str));
        this.f5349e = createProgressBar;
        createProgressBar.setMax(RNCWebViewManager.COMMAND_CLEAR_FORM_DATA);
        removeAllViews();
        addView(this.f5349e, new ViewGroup.LayoutParams(-1, -1));
    }
}