package e.j.f;

import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.RecyclerView_CommonKt;
import org.toshi.R;

/* compiled from: RecyclerViewExtensions.kt */
/* loaded from: classes2.dex */
public final class r {
    public static final void a(RecyclerView recyclerView, int i2, int i3, int i4, int i5, int i6, int i7) {
        kotlin.jvm.internal.m.g(recyclerView, "<this>");
        RecyclerView_CommonKt.addHorizontalLineDivider(recyclerView, i2, i3, i4, i5, i6, i7);
    }

    public static /* synthetic */ void b(RecyclerView recyclerView, int i2, int i3, int i4, int i5, int i6, int i7, int i8, Object obj) {
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
        a(recyclerView, i2, i9, i10, i5, (i8 & 16) != 0 ? 0 : i6, (i8 & 32) != 0 ? 0 : i7);
    }
}