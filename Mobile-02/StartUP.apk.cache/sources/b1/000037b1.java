package com.google.android.material.snackbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import c.h.k.v;
import e.g.a.f.f;
import e.g.a.f.k;

/* loaded from: classes2.dex */
public class SnackbarContentLayout extends LinearLayout {
    private TextView a;

    /* renamed from: b  reason: collision with root package name */
    private Button f8198b;

    /* renamed from: c  reason: collision with root package name */
    private int f8199c;

    /* renamed from: d  reason: collision with root package name */
    private int f8200d;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.m1);
        this.f8199c = obtainStyledAttributes.getDimensionPixelSize(k.n1, -1);
        this.f8200d = obtainStyledAttributes.getDimensionPixelSize(k.p1, -1);
        obtainStyledAttributes.recycle();
    }

    private static void a(View view, int i2, int i3) {
        if (v.U(view)) {
            v.x0(view, v.D(view), i2, v.C(view), i3);
        } else {
            view.setPadding(view.getPaddingLeft(), i2, view.getPaddingRight(), i3);
        }
    }

    private boolean b(int i2, int i3, int i4) {
        boolean z;
        if (i2 != getOrientation()) {
            setOrientation(i2);
            z = true;
        } else {
            z = false;
        }
        if (this.a.getPaddingTop() == i3 && this.a.getPaddingBottom() == i4) {
            return z;
        }
        a(this.a, i3, i4);
        return true;
    }

    public Button getActionView() {
        return this.f8198b;
    }

    public TextView getMessageView() {
        return this.a;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.a = (TextView) findViewById(f.f13263k);
        this.f8198b = (Button) findViewById(f.f13262j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        if (b(1, r0, r0 - r1) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (b(0, r0, r0) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0060, code lost:
        r3 = true;
     */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f8199c
            if (r0 <= 0) goto L18
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f8199c
            if (r0 <= r1) goto L18
            r8 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r8)
            super.onMeasure(r8, r9)
        L18:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = e.g.a.f.d.n
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = e.g.a.f.d.m
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3c
            r2 = r4
            goto L3d
        L3c:
            r2 = r3
        L3d:
            if (r2 == 0) goto L56
            int r5 = r7.f8200d
            if (r5 <= 0) goto L56
            android.widget.Button r5 = r7.f8198b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f8200d
            if (r5 <= r6) goto L56
            int r1 = r0 - r1
            boolean r0 = r7.b(r4, r0, r1)
            if (r0 == 0) goto L61
            goto L60
        L56:
            if (r2 == 0) goto L59
            goto L5a
        L59:
            r0 = r1
        L5a:
            boolean r0 = r7.b(r3, r0, r0)
            if (r0 == 0) goto L61
        L60:
            r3 = r4
        L61:
            if (r3 == 0) goto L66
            super.onMeasure(r8, r9)
        L66:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.snackbar.SnackbarContentLayout.onMeasure(int, int):void");
    }
}