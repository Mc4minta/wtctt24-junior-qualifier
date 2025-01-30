package com.facebook.react.views.progressbar;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.react.uimanager.h;
import com.facebook.yoga.m;
import com.facebook.yoga.n;
import com.facebook.yoga.o;
import com.facebook.yoga.p;
import java.util.HashSet;
import java.util.Set;

/* compiled from: ProgressBarShadowNode.java */
/* loaded from: classes2.dex */
public class b extends h implements m {
    private String E = "Normal";
    private final SparseIntArray F = new SparseIntArray();
    private final SparseIntArray G = new SparseIntArray();
    private final Set<Integer> H = new HashSet();

    public b() {
        p1();
    }

    private void p1() {
        R0(this);
    }

    @Override // com.facebook.yoga.m
    public long T(p pVar, float f2, n nVar, float f3, n nVar2) {
        int styleFromString = ReactProgressBarViewManager.getStyleFromString(o1());
        if (!this.H.contains(Integer.valueOf(styleFromString))) {
            ProgressBar createProgressBar = ReactProgressBarViewManager.createProgressBar(F(), styleFromString);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(-2, 0);
            createProgressBar.measure(makeMeasureSpec, makeMeasureSpec);
            this.F.put(styleFromString, createProgressBar.getMeasuredHeight());
            this.G.put(styleFromString, createProgressBar.getMeasuredWidth());
            this.H.add(Integer.valueOf(styleFromString));
        }
        return o.b(this.G.get(styleFromString), this.F.get(styleFromString));
    }

    public String o1() {
        return this.E;
    }

    @com.facebook.react.uimanager.c1.a(name = "styleAttr")
    public void setStyle(String str) {
        if (str == null) {
            str = "Normal";
        }
        this.E = str;
    }
}