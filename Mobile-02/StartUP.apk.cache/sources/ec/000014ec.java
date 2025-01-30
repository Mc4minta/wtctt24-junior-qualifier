package com.coinbase.wallet.commonui.views;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.ApiConstants;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: HorizontalLineDivider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BO\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\b\b\u0001\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0001\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0016\u0010\u000f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/commonui/views/HorizontalLineDivider;", "Landroidx/recyclerview/widget/RecyclerView$n;", "Landroid/graphics/Canvas;", "canvas", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$b0;", ApiConstants.STATE, "Lkotlin/x;", "onDraw", "(Landroid/graphics/Canvas;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$b0;)V", "", "dividerHeight", "I", "leftPadding", "rightPadding", "skipEndPositions", "", "skipPositionsList", "Ljava/util/List;", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Paint;", "startPosition", "color", "<init>", "(IIIIIILjava/util/List;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class HorizontalLineDivider extends RecyclerView.n {
    private final int dividerHeight;
    private final int leftPadding;
    private final Paint paint;
    private final int rightPadding;
    private final int skipEndPositions;
    private final List<Integer> skipPositionsList;
    private final int startPosition;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ HorizontalLineDivider(int r10, int r11, int r12, int r13, int r14, int r15, java.util.List r16, int r17, kotlin.jvm.internal.DefaultConstructorMarker r18) {
        /*
            r9 = this;
            r0 = r17 & 64
            if (r0 == 0) goto La
            java.util.List r0 = kotlin.a0.p.g()
            r8 = r0
            goto Lc
        La:
            r8 = r16
        Lc:
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r5 = r13
            r6 = r14
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.commonui.views.HorizontalLineDivider.<init>(int, int, int, int, int, int, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void onDraw(Canvas canvas, RecyclerView parent, RecyclerView.b0 state) {
        m.g(canvas, "canvas");
        m.g(parent, "parent");
        m.g(state, "state");
        int paddingLeft = parent.getPaddingLeft() + this.leftPadding;
        int width = (parent.getWidth() - parent.getPaddingRight()) - this.rightPadding;
        int childCount = (parent.getChildCount() - 1) - this.skipEndPositions;
        if (childCount <= 0) {
            return;
        }
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            View childAt = parent.getChildAt(i2);
            int childAdapterPosition = parent.getChildAdapterPosition(childAt);
            if (childAdapterPosition >= this.startPosition) {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
                int bottom = childAt.getBottom() + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) layoutParams)).bottomMargin;
                int i4 = this.dividerHeight;
                int i5 = bottom - (i4 / 2);
                int i6 = (i4 / 2) + i5;
                if (!this.skipPositionsList.contains(Integer.valueOf(childAdapterPosition))) {
                    canvas.drawRect(paddingLeft, i5, width, i6, this.paint);
                }
            }
            if (i3 >= childCount) {
                return;
            }
            i2 = i3;
        }
    }

    public HorizontalLineDivider(int i2, int i3, int i4, int i5, int i6, int i7, List<Integer> skipPositionsList) {
        m.g(skipPositionsList, "skipPositionsList");
        this.leftPadding = i3;
        this.rightPadding = i4;
        this.dividerHeight = i5;
        this.startPosition = i6;
        this.skipEndPositions = i7;
        this.skipPositionsList = skipPositionsList;
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(i2);
    }
}