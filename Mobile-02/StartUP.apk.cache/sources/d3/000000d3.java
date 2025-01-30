package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.b0;

/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements b0 {
    private b0.a a;

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        b0.a aVar = this.a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // androidx.appcompat.widget.b0
    public void setOnFitSystemWindowsListener(b0.a aVar) {
        this.a = aVar;
    }
}