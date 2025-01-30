package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import c.h.k.v;
import com.google.android.flexbox.d;
import java.util.ArrayList;
import java.util.List;
import okhttp3.internal.http2.Http2Connection;

/* loaded from: classes2.dex */
public class FlexboxLayout extends ViewGroup implements com.google.android.flexbox.a {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f5873b;

    /* renamed from: c  reason: collision with root package name */
    private int f5874c;

    /* renamed from: d  reason: collision with root package name */
    private int f5875d;

    /* renamed from: e  reason: collision with root package name */
    private int f5876e;

    /* renamed from: f  reason: collision with root package name */
    private int f5877f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f5878g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f5879h;

    /* renamed from: j  reason: collision with root package name */
    private int f5880j;

    /* renamed from: k  reason: collision with root package name */
    private int f5881k;

    /* renamed from: l  reason: collision with root package name */
    private int f5882l;
    private int m;
    private int[] n;
    private SparseIntArray p;
    private d q;
    private List<c> t;
    private d.b u;

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f5878g == null && this.f5879h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean a(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.t.get(i3).c() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean l(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            View r = r(i2 - i4);
            if (r != null && r.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void m(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.t.size();
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = this.t.get(i4);
            for (int i5 = 0; i5 < cVar.f5922h; i5++) {
                int i6 = cVar.o + i5;
                View r = r(i6);
                if (r != null && r.getVisibility() != 8) {
                    a aVar = (a) r.getLayoutParams();
                    if (s(i6, i5)) {
                        if (z) {
                            left = r.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        } else {
                            left = (r.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.m;
                        }
                        p(canvas, left, cVar.f5916b, cVar.f5921g);
                    }
                    if (i5 == cVar.f5922h - 1 && (this.f5881k & 4) > 0) {
                        if (z) {
                            right = (r.getLeft() - ((ViewGroup.MarginLayoutParams) aVar).leftMargin) - this.m;
                        } else {
                            right = r.getRight() + ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
                        }
                        p(canvas, right, cVar.f5916b, cVar.f5921g);
                    }
                }
            }
            if (t(i4)) {
                if (z2) {
                    i3 = cVar.f5918d;
                } else {
                    i3 = cVar.f5916b - this.f5882l;
                }
                o(canvas, paddingLeft, i3, max);
            }
            if (u(i4) && (this.f5880j & 4) > 0) {
                if (z2) {
                    i2 = cVar.f5916b - this.f5882l;
                } else {
                    i2 = cVar.f5918d;
                }
                o(canvas, paddingLeft, i2, max);
            }
        }
    }

    private void n(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.t.size();
        for (int i4 = 0; i4 < size; i4++) {
            c cVar = this.t.get(i4);
            for (int i5 = 0; i5 < cVar.f5922h; i5++) {
                int i6 = cVar.o + i5;
                View r = r(i6);
                if (r != null && r.getVisibility() != 8) {
                    a aVar = (a) r.getLayoutParams();
                    if (s(i6, i5)) {
                        if (z2) {
                            top = r.getBottom() + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        } else {
                            top = (r.getTop() - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - this.f5882l;
                        }
                        o(canvas, cVar.a, top, cVar.f5921g);
                    }
                    if (i5 == cVar.f5922h - 1 && (this.f5880j & 4) > 0) {
                        if (z2) {
                            bottom = (r.getTop() - ((ViewGroup.MarginLayoutParams) aVar).topMargin) - this.f5882l;
                        } else {
                            bottom = r.getBottom() + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
                        }
                        o(canvas, cVar.a, bottom, cVar.f5921g);
                    }
                }
            }
            if (t(i4)) {
                if (z) {
                    i3 = cVar.f5917c;
                } else {
                    i3 = cVar.a - this.m;
                }
                p(canvas, i3, paddingTop, max);
            }
            if (u(i4) && (this.f5881k & 4) > 0) {
                if (z) {
                    i2 = cVar.a - this.m;
                } else {
                    i2 = cVar.f5917c;
                }
                p(canvas, i2, paddingTop, max);
            }
        }
    }

    private void o(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f5878g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, i4 + i2, this.f5882l + i3);
        this.f5878g.draw(canvas);
    }

    private void p(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f5879h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, this.m + i2, i4 + i3);
        this.f5879h.draw(canvas);
    }

    private boolean s(int i2, int i3) {
        return l(i2, i3) ? j() ? (this.f5881k & 1) != 0 : (this.f5880j & 1) != 0 : j() ? (this.f5881k & 2) != 0 : (this.f5880j & 2) != 0;
    }

    private boolean t(int i2) {
        if (i2 < 0 || i2 >= this.t.size()) {
            return false;
        }
        return a(i2) ? j() ? (this.f5880j & 1) != 0 : (this.f5881k & 1) != 0 : j() ? (this.f5880j & 2) != 0 : (this.f5881k & 2) != 0;
    }

    private boolean u(int i2) {
        if (i2 < 0 || i2 >= this.t.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.t.size(); i3++) {
            if (this.t.get(i3).c() > 0) {
                return false;
            }
        }
        return j() ? (this.f5880j & 4) != 0 : (this.f5881k & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, boolean, int, int, int, int):void");
    }

    private void x(int i2, int i3) {
        this.t.clear();
        this.u.a();
        this.q.c(this.u, i2, i3);
        this.t = this.u.a;
        this.q.p(i2, i3);
        if (this.f5875d == 3) {
            for (c cVar : this.t) {
                int i4 = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < cVar.f5922h; i5++) {
                    View r = r(cVar.o + i5);
                    if (r != null && r.getVisibility() != 8) {
                        a aVar = (a) r.getLayoutParams();
                        if (this.f5873b != 2) {
                            i4 = Math.max(i4, r.getMeasuredHeight() + Math.max(cVar.f5926l - r.getBaseline(), ((ViewGroup.MarginLayoutParams) aVar).topMargin) + ((ViewGroup.MarginLayoutParams) aVar).bottomMargin);
                        } else {
                            i4 = Math.max(i4, r.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) aVar).topMargin + Math.max((cVar.f5926l - r.getMeasuredHeight()) + r.getBaseline(), ((ViewGroup.MarginLayoutParams) aVar).bottomMargin));
                        }
                    }
                }
                cVar.f5921g = i4;
            }
        }
        this.q.o(i2, i3, getPaddingTop() + getPaddingBottom());
        this.q.X();
        z(this.a, i2, i3, this.u.f5931b);
    }

    private void y(int i2, int i3) {
        this.t.clear();
        this.u.a();
        this.q.f(this.u, i2, i3);
        this.t = this.u.a;
        this.q.p(i2, i3);
        this.q.o(i2, i3, getPaddingLeft() + getPaddingRight());
        this.q.X();
        z(this.a, i2, i3, this.u.f5931b);
    }

    private void z(int i2, int i3, int i4, int i5) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + i2);
        } else {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i3, i5);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.p == null) {
            this.p = new SparseIntArray(getChildCount());
        }
        this.n = this.q.n(view, i2, layoutParams, this.p);
        super.addView(view, i2, layoutParams);
    }

    @Override // com.google.android.flexbox.a
    public void b(View view, int i2, int i3, c cVar) {
        if (s(i2, i3)) {
            if (j()) {
                int i4 = cVar.f5919e;
                int i5 = this.m;
                cVar.f5919e = i4 + i5;
                cVar.f5920f += i5;
                return;
            }
            int i6 = cVar.f5919e;
            int i7 = this.f5882l;
            cVar.f5919e = i6 + i7;
            cVar.f5920f += i7;
        }
    }

    @Override // com.google.android.flexbox.a
    public void c(c cVar) {
        if (j()) {
            if ((this.f5881k & 4) > 0) {
                int i2 = cVar.f5919e;
                int i3 = this.m;
                cVar.f5919e = i2 + i3;
                cVar.f5920f += i3;
            }
        } else if ((this.f5880j & 4) > 0) {
            int i4 = cVar.f5919e;
            int i5 = this.f5882l;
            cVar.f5919e = i4 + i5;
            cVar.f5920f += i5;
        }
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    @Override // com.google.android.flexbox.a
    public View d(int i2) {
        return r(i2);
    }

    @Override // com.google.android.flexbox.a
    public int e(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // com.google.android.flexbox.a
    public void f(int i2, View view) {
    }

    @Override // com.google.android.flexbox.a
    public View g(int i2) {
        return getChildAt(i2);
    }

    @Override // com.google.android.flexbox.a
    public int getAlignContent() {
        return this.f5876e;
    }

    @Override // com.google.android.flexbox.a
    public int getAlignItems() {
        return this.f5875d;
    }

    public Drawable getDividerDrawableHorizontal() {
        return this.f5878g;
    }

    public Drawable getDividerDrawableVertical() {
        return this.f5879h;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexDirection() {
        return this.a;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexItemCount() {
        return getChildCount();
    }

    public List<c> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.t.size());
        for (c cVar : this.t) {
            if (cVar.c() != 0) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    @Override // com.google.android.flexbox.a
    public List<c> getFlexLinesInternal() {
        return this.t;
    }

    @Override // com.google.android.flexbox.a
    public int getFlexWrap() {
        return this.f5873b;
    }

    public int getJustifyContent() {
        return this.f5874c;
    }

    @Override // com.google.android.flexbox.a
    public int getLargestMainSize() {
        int i2 = Integer.MIN_VALUE;
        for (c cVar : this.t) {
            i2 = Math.max(i2, cVar.f5919e);
        }
        return i2;
    }

    @Override // com.google.android.flexbox.a
    public int getMaxLine() {
        return this.f5877f;
    }

    public int getShowDividerHorizontal() {
        return this.f5880j;
    }

    public int getShowDividerVertical() {
        return this.f5881k;
    }

    @Override // com.google.android.flexbox.a
    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.t.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            c cVar = this.t.get(i5);
            if (t(i5)) {
                if (j()) {
                    i3 = this.f5882l;
                } else {
                    i3 = this.m;
                }
                i4 += i3;
            }
            if (u(i5)) {
                if (j()) {
                    i2 = this.f5882l;
                } else {
                    i2 = this.m;
                }
                i4 += i2;
            }
            i4 += cVar.f5921g;
        }
        return i4;
    }

    @Override // com.google.android.flexbox.a
    public int h(View view, int i2, int i3) {
        int i4;
        int i5;
        if (j()) {
            i4 = s(i2, i3) ? 0 + this.m : 0;
            if ((this.f5881k & 4) <= 0) {
                return i4;
            }
            i5 = this.m;
        } else {
            i4 = s(i2, i3) ? 0 + this.f5882l : 0;
            if ((this.f5880j & 4) <= 0) {
                return i4;
            }
            i5 = this.f5882l;
        }
        return i4 + i5;
    }

    @Override // com.google.android.flexbox.a
    public int i(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // com.google.android.flexbox.a
    public boolean j() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    @Override // com.google.android.flexbox.a
    public int k(View view) {
        return 0;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f5879h == null && this.f5878g == null) {
            return;
        }
        if (this.f5880j == 0 && this.f5881k == 0) {
            return;
        }
        int y = v.y(this);
        int i2 = this.a;
        if (i2 == 0) {
            m(canvas, y == 1, this.f5873b == 2);
        } else if (i2 == 1) {
            m(canvas, y != 1, this.f5873b == 2);
        } else if (i2 == 2) {
            boolean z = y == 1;
            if (this.f5873b == 2) {
                z = !z;
            }
            n(canvas, z, false);
        } else if (i2 != 3) {
        } else {
            boolean z2 = y == 1;
            if (this.f5873b == 2) {
                z2 = !z2;
            }
            n(canvas, z2, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int y = v.y(this);
        int i6 = this.a;
        if (i6 == 0) {
            v(y == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            v(y != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            z2 = y == 1;
            w(this.f5873b == 2 ? !z2 : z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            z2 = y == 1;
            w(this.f5873b == 2 ? !z2 : z2, true, i2, i3, i4, i5);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.a);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        if (this.p == null) {
            this.p = new SparseIntArray(getChildCount());
        }
        if (this.q.O(this.p)) {
            this.n = this.q.m(this.p);
        }
        int i4 = this.a;
        if (i4 == 0 || i4 == 1) {
            x(i2, i3);
        } else if (i4 != 2 && i4 != 3) {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.a);
        } else {
            y(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: q */
    public a generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public View r(int i2) {
        if (i2 >= 0) {
            int[] iArr = this.n;
            if (i2 >= iArr.length) {
                return null;
            }
            return getChildAt(iArr[i2]);
        }
        return null;
    }

    public void setAlignContent(int i2) {
        if (this.f5876e != i2) {
            this.f5876e = i2;
            requestLayout();
        }
    }

    public void setAlignItems(int i2) {
        if (this.f5875d != i2) {
            this.f5875d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(Drawable drawable) {
        if (drawable == this.f5878g) {
            return;
        }
        this.f5878g = drawable;
        if (drawable != null) {
            this.f5882l = drawable.getIntrinsicHeight();
        } else {
            this.f5882l = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(Drawable drawable) {
        if (drawable == this.f5879h) {
            return;
        }
        this.f5879h = drawable;
        if (drawable != null) {
            this.m = drawable.getIntrinsicWidth();
        } else {
            this.m = 0;
        }
        A();
        requestLayout();
    }

    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            this.a = i2;
            requestLayout();
        }
    }

    @Override // com.google.android.flexbox.a
    public void setFlexLines(List<c> list) {
        this.t = list;
    }

    public void setFlexWrap(int i2) {
        if (this.f5873b != i2) {
            this.f5873b = i2;
            requestLayout();
        }
    }

    public void setJustifyContent(int i2) {
        if (this.f5874c != i2) {
            this.f5874c = i2;
            requestLayout();
        }
    }

    public void setMaxLine(int i2) {
        if (this.f5877f != i2) {
            this.f5877f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f5880j) {
            this.f5880j = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.f5881k) {
            this.f5881k = i2;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof a) {
            return new a((a) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new a((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new a(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f5877f = -1;
        this.q = new d(this);
        this.t = new ArrayList();
        this.u = new d.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.f5933b, i2, 0);
        this.a = obtainStyledAttributes.getInt(e.f5939h, 0);
        this.f5873b = obtainStyledAttributes.getInt(e.f5940i, 0);
        this.f5874c = obtainStyledAttributes.getInt(e.f5941j, 0);
        this.f5875d = obtainStyledAttributes.getInt(e.f5935d, 0);
        this.f5876e = obtainStyledAttributes.getInt(e.f5934c, 0);
        this.f5877f = obtainStyledAttributes.getInt(e.f5942k, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(e.f5936e);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(e.f5937f);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(e.f5938g);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(e.f5943l, 0);
        if (i3 != 0) {
            this.f5881k = i3;
            this.f5880j = i3;
        }
        int i4 = obtainStyledAttributes.getInt(e.n, 0);
        if (i4 != 0) {
            this.f5881k = i4;
        }
        int i5 = obtainStyledAttributes.getInt(e.m, 0);
        if (i5 != 0) {
            this.f5880j = i5;
        }
        obtainStyledAttributes.recycle();
    }

    /* loaded from: classes2.dex */
    public static class a extends ViewGroup.MarginLayoutParams implements b {
        public static final Parcelable.Creator<a> CREATOR = new C0135a();
        private int a;

        /* renamed from: b  reason: collision with root package name */
        private float f5883b;

        /* renamed from: c  reason: collision with root package name */
        private float f5884c;

        /* renamed from: d  reason: collision with root package name */
        private int f5885d;

        /* renamed from: e  reason: collision with root package name */
        private float f5886e;

        /* renamed from: f  reason: collision with root package name */
        private int f5887f;

        /* renamed from: g  reason: collision with root package name */
        private int f5888g;

        /* renamed from: h  reason: collision with root package name */
        private int f5889h;

        /* renamed from: j  reason: collision with root package name */
        private int f5890j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f5891k;

        /* renamed from: com.google.android.flexbox.FlexboxLayout$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0135a implements Parcelable.Creator<a> {
            C0135a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public a[] newArray(int i2) {
                return new a[i2];
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.o);
            this.a = obtainStyledAttributes.getInt(e.x, 1);
            this.f5883b = obtainStyledAttributes.getFloat(e.r, 0.0f);
            this.f5884c = obtainStyledAttributes.getFloat(e.s, 1.0f);
            this.f5885d = obtainStyledAttributes.getInt(e.p, -1);
            this.f5886e = obtainStyledAttributes.getFraction(e.q, 1, 1, -1.0f);
            this.f5887f = obtainStyledAttributes.getDimensionPixelSize(e.w, -1);
            this.f5888g = obtainStyledAttributes.getDimensionPixelSize(e.v, -1);
            this.f5889h = obtainStyledAttributes.getDimensionPixelSize(e.u, 16777215);
            this.f5890j = obtainStyledAttributes.getDimensionPixelSize(e.t, 16777215);
            this.f5891k = obtainStyledAttributes.getBoolean(e.y, false);
            obtainStyledAttributes.recycle();
        }

        @Override // com.google.android.flexbox.b
        public int I0() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.b
        public int M0() {
            return this.f5888g;
        }

        @Override // com.google.android.flexbox.b
        public float O() {
            return this.f5884c;
        }

        @Override // com.google.android.flexbox.b
        public boolean O0() {
            return this.f5891k;
        }

        @Override // com.google.android.flexbox.b
        public int V() {
            return this.f5887f;
        }

        @Override // com.google.android.flexbox.b
        public int W0() {
            return this.f5890j;
        }

        public void a(float f2) {
            this.f5886e = f2;
        }

        @Override // com.google.android.flexbox.b
        public void a0(int i2) {
            this.f5887f = i2;
        }

        public void b(float f2) {
            this.f5883b = f2;
        }

        @Override // com.google.android.flexbox.b
        public int d0() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.b
        public int f1() {
            return this.f5889h;
        }

        @Override // com.google.android.flexbox.b
        public int g0() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.b
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.b
        public int getOrder() {
            return this.a;
        }

        @Override // com.google.android.flexbox.b
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.b
        public int o0() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.b
        public void s0(int i2) {
            this.f5888g = i2;
        }

        @Override // com.google.android.flexbox.b
        public float w0() {
            return this.f5883b;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.a);
            parcel.writeFloat(this.f5883b);
            parcel.writeFloat(this.f5884c);
            parcel.writeInt(this.f5885d);
            parcel.writeFloat(this.f5886e);
            parcel.writeInt(this.f5887f);
            parcel.writeInt(this.f5888g);
            parcel.writeInt(this.f5889h);
            parcel.writeInt(this.f5890j);
            parcel.writeByte(this.f5891k ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        @Override // com.google.android.flexbox.b
        public int z() {
            return this.f5885d;
        }

        @Override // com.google.android.flexbox.b
        public float z0() {
            return this.f5886e;
        }

        public a(a aVar) {
            super((ViewGroup.MarginLayoutParams) aVar);
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
            this.a = aVar.a;
            this.f5883b = aVar.f5883b;
            this.f5884c = aVar.f5884c;
            this.f5885d = aVar.f5885d;
            this.f5886e = aVar.f5886e;
            this.f5887f = aVar.f5887f;
            this.f5888g = aVar.f5888g;
            this.f5889h = aVar.f5889h;
            this.f5890j = aVar.f5890j;
            this.f5891k = aVar.f5891k;
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
        }

        public a(int i2, int i3) {
            super(new ViewGroup.LayoutParams(i2, i3));
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
        }

        public a(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
        }

        protected a(Parcel parcel) {
            super(0, 0);
            this.a = 1;
            this.f5883b = 0.0f;
            this.f5884c = 1.0f;
            this.f5885d = -1;
            this.f5886e = -1.0f;
            this.f5887f = -1;
            this.f5888g = -1;
            this.f5889h = 16777215;
            this.f5890j = 16777215;
            this.a = parcel.readInt();
            this.f5883b = parcel.readFloat();
            this.f5884c = parcel.readFloat();
            this.f5885d = parcel.readInt();
            this.f5886e = parcel.readFloat();
            this.f5887f = parcel.readInt();
            this.f5888g = parcel.readInt();
            this.f5889h = parcel.readInt();
            this.f5890j = parcel.readInt();
            this.f5891k = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}