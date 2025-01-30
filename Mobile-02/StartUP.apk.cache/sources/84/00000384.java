package androidx.navigation;

import android.app.Activity;
import android.view.View;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

/* compiled from: Navigation.java */
/* loaded from: classes.dex */
public final class r {
    public static NavController a(Activity activity, int i2) {
        NavController c2 = c(androidx.core.app.a.s(activity, i2));
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("Activity " + activity + " does not have a NavController set on " + i2);
    }

    public static NavController b(View view) {
        NavController c2 = c(view);
        if (c2 != null) {
            return c2;
        }
        throw new IllegalStateException("View " + view + " does not have a NavController set");
    }

    private static NavController c(View view) {
        while (view != null) {
            NavController d2 = d(view);
            if (d2 != null) {
                return d2;
            }
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        return null;
    }

    private static NavController d(View view) {
        Object tag = view.getTag(u.a);
        if (tag instanceof WeakReference) {
            return (NavController) ((WeakReference) tag).get();
        }
        if (tag instanceof NavController) {
            return (NavController) tag;
        }
        return null;
    }

    public static void e(View view, NavController navController) {
        view.setTag(u.a, navController);
    }
}