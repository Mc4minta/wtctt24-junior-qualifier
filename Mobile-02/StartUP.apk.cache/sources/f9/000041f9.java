package com.toshi.view.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.coinbase.wallet.commonui.views.StatusBarSpace;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.x;

/* compiled from: ToolbarLayout.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/toshi/view/custom/ToolbarLayout;", "Landroid/widget/LinearLayout;", "Lkotlin/x;", "a", "()V", "onFinishInflate", "", "Z", "includeStatusBarPadding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class ToolbarLayout extends LinearLayout {
    private final boolean a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ToolbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        kotlin.jvm.internal.m.g(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.j.b.H1);
        kotlin.jvm.internal.m.f(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ToolbarLayout)");
        this.a = obtainStyledAttributes.getBoolean(0, true);
        obtainStyledAttributes.recycle();
    }

    private final void a() {
        ArrayList<View> arrayList = new ArrayList();
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View child = getChildAt(0);
            kotlin.jvm.internal.m.f(child, "child");
            arrayList.add(child);
            removeViewAt(0);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        linearLayout.setOrientation(linearLayout.getOrientation());
        for (View view : arrayList) {
            linearLayout.addView(view);
        }
        setOrientation(1);
        Context context = getContext();
        kotlin.jvm.internal.m.f(context, "context");
        View statusBarSpace = new StatusBarSpace(context, null, 0, 6, null);
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = -1;
        x xVar = x.a;
        addView(statusBarSpace, generateDefaultLayoutParams);
        LinearLayout.LayoutParams generateDefaultLayoutParams2 = generateDefaultLayoutParams();
        Context context2 = getContext();
        kotlin.jvm.internal.m.f(context2, "context");
        generateDefaultLayoutParams2.height = e.j.f.h.c(context2);
        generateDefaultLayoutParams2.width = -1;
        addView(linearLayout, generateDefaultLayoutParams2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.a) {
            a();
        }
    }
}