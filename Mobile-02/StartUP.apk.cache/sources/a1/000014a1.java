package com.coinbase.wallet.commonui.extensions;

import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.R;
import com.coinbase.wallet.commonui.views.HorizontalLineDivider;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: RecyclerView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\t\u001a\u00020\b*\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00012\b\b\u0003\u0010\u0003\u001a\u00020\u00012\b\b\u0003\u0010\u0004\u001a\u00020\u00012\b\b\u0003\u0010\u0005\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u00012\b\b\u0002\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/recyclerview/widget/RecyclerView;", "", "color", "leftPadding", "rightPadding", "dividerHeight", "startPosition", "skipEndPositions", "Lkotlin/x;", "addHorizontalLineDivider", "(Landroidx/recyclerview/widget/RecyclerView;IIIIII)V", "commonui_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class RecyclerView_CommonKt {
    public static final void addHorizontalLineDivider(RecyclerView recyclerView, int i2, int i3, int i4, int i5, int i6, int i7) {
        m.g(recyclerView, "<this>");
        recyclerView.addItemDecoration(new HorizontalLineDivider(i2, i3, i4, i5, i6, i7, null, 64, null));
    }

    public static /* synthetic */ void addHorizontalLineDivider$default(RecyclerView recyclerView, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            i2 = recyclerView.getContext().getColor(R.color.divider);
        }
        if ((i8 & 2) != 0) {
            i3 = recyclerView.getResources().getDimensionPixelSize(R.dimen.view_size_16);
        }
        int i9 = i3;
        if ((i8 & 4) != 0) {
            i4 = recyclerView.getResources().getDimensionPixelSize(R.dimen.view_size_16);
        }
        int i10 = i4;
        if ((i8 & 8) != 0) {
            i5 = recyclerView.getResources().getDimensionPixelSize(R.dimen.view_size_2);
        }
        addHorizontalLineDivider(recyclerView, i2, i9, i10, i5, (i8 & 16) != 0 ? 0 : i6, (i8 & 32) != 0 ? 0 : i7);
    }
}