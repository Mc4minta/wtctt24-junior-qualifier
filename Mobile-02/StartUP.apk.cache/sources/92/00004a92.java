package e.j.m.b;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: GridSpacingDecoration.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.n {
    private int a;

    /* renamed from: b  reason: collision with root package name */
    private int f13796b;

    /* renamed from: c  reason: collision with root package name */
    private int f13797c;

    public a(int i2, int i3, int i4) {
        this.a = i2;
        this.f13796b = i3;
        this.f13797c = i4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.b0 b0Var) {
        int childAdapterPosition = (recyclerView.getChildAdapterPosition(view) + 1) % this.a;
        if (childAdapterPosition == 2) {
            int i2 = this.f13796b;
            rect.right = i2 / 2;
            rect.left = i2 / 2;
        } else if (childAdapterPosition == 1) {
            rect.right = this.f13796b / 2;
        } else if (childAdapterPosition == 0) {
            rect.left = this.f13796b / 2;
        }
        rect.top = this.f13797c;
    }
}