package e.j.m.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: SpaceDecoration.kt */
/* loaded from: classes2.dex */
public final class b extends RecyclerView.n {
    private final int a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f13798b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f13799c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f13800d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f13801e;

    public /* synthetic */ b(int i2, boolean z, boolean z2, boolean z3, boolean z4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? false : z, (i3 & 4) != 0 ? true : z2, (i3 & 8) != 0 ? false : z3, (i3 & 16) != 0 ? true : z4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.b0 state) {
        m.g(outRect, "outRect");
        m.g(view, "view");
        m.g(parent, "parent");
        m.g(state, "state");
        if (this.f13798b) {
            outRect.left = this.a;
        }
        if (this.f13799c) {
            outRect.right = this.a;
        }
        if (this.f13800d) {
            outRect.top = this.a;
        }
        if (this.f13801e) {
            outRect.bottom = this.a;
        }
    }

    public b(int i2, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = i2;
        this.f13798b = z;
        this.f13799c = z2;
        this.f13800d = z3;
        this.f13801e = z4;
    }

    public b(int i2) {
        this(i2, false, false, false, true, 14, null);
    }
}