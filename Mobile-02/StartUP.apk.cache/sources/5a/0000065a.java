package c.s;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: GhostViewUtils.java */
/* loaded from: classes.dex */
class m {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT == 28) {
            return k.b(view, viewGroup, matrix);
        }
        return l.b(view, viewGroup, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            k.f(view);
        } else {
            l.f(view);
        }
    }
}