package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ScrollbarHelper.java */
/* loaded from: classes.dex */
public class r {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(RecyclerView.b0 b0Var, p pVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.T() == 0 || b0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1;
        }
        return Math.min(pVar.n(), pVar.d(view2) - pVar.g(view));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(RecyclerView.b0 b0Var, p pVar, View view, View view2, RecyclerView.o oVar, boolean z, boolean z2) {
        int max;
        if (oVar.T() == 0 || b0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int min = Math.min(oVar.m0(view), oVar.m0(view2));
        int max2 = Math.max(oVar.m0(view), oVar.m0(view2));
        if (z2) {
            max = Math.max(0, (b0Var.b() - max2) - 1);
        } else {
            max = Math.max(0, min);
        }
        if (z) {
            return Math.round((max * (Math.abs(pVar.d(view2) - pVar.g(view)) / (Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1))) + (pVar.m() - pVar.g(view)));
        }
        return max;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(RecyclerView.b0 b0Var, p pVar, View view, View view2, RecyclerView.o oVar, boolean z) {
        if (oVar.T() == 0 || b0Var.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return b0Var.b();
        }
        return (int) (((pVar.d(view2) - pVar.g(view)) / (Math.abs(oVar.m0(view) - oVar.m0(view2)) + 1)) * b0Var.b());
    }
}