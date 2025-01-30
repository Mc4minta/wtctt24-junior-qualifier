package e.j.m.a.u;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.toshi.model.local.dapp.DappCategory;
import kotlin.jvm.internal.m;

/* compiled from: SearchDappCategoryViewHolder.kt */
/* loaded from: classes2.dex */
public final class i extends RecyclerView.e0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(View itemView) {
        super(itemView);
        m.g(itemView, "itemView");
    }

    public final void a(DappCategory category) {
        m.g(category, "category");
        ((TextView) this.itemView).setText(category.getCategory());
    }
}