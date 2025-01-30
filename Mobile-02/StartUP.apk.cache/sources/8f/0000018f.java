package androidx.browser.browseractions;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import c.c.a;

/* loaded from: classes.dex */
public class BrowserActionsFallbackMenuView extends LinearLayout {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final int f1015b;

    public BrowserActionsFallbackMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = getResources().getDimensionPixelOffset(a.f2604b);
        this.f1015b = getResources().getDimensionPixelOffset(a.a);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Math.min(getResources().getDisplayMetrics().widthPixels - (this.a * 2), this.f1015b), 1073741824), i3);
    }
}