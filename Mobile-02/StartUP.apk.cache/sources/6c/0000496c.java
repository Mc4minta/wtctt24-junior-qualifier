package e.j.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.app.c;
import androidx.fragment.app.Fragment;
import com.coinbase.wallet.commonui.extensions.Fragment_CommonKt;
import com.coinbase.wallet.commonui.views.BackableFragment;
import com.coinbase.wallet.features.applock.legacy.AuthenticationHelper;
import java.util.List;

/* compiled from: FragmentExtensions.kt */
/* loaded from: classes2.dex */
public final class m {
    public static final Integer a(Fragment fragment, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Context context = fragment.getContext();
        if (context == null) {
            return null;
        }
        return Integer.valueOf(context.getColor(i2));
    }

    public static final ContentResolver b(Fragment fragment) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Context context = fragment.getContext();
        if (context == null) {
            return null;
        }
        return context.getContentResolver();
    }

    public static final InputMethodManager c(Fragment fragment) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Context context = fragment.getContext();
        Object systemService = context == null ? null : context.getSystemService("input_method");
        if (systemService instanceof InputMethodManager) {
            return (InputMethodManager) systemService;
        }
        return null;
    }

    public static final int d(Fragment fragment, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        return fragment.getResources().getDimensionPixelSize(i2);
    }

    public static final List<String> e(Fragment fragment, int i2) {
        List<String> e0;
        kotlin.jvm.internal.m.g(fragment, "<this>");
        String[] stringArray = fragment.getResources().getStringArray(i2);
        kotlin.jvm.internal.m.f(stringArray, "resources.getStringArray(id)");
        e0 = kotlin.a0.n.e0(stringArray);
        return e0;
    }

    public static final void f(Fragment fragment, View view) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        e.j.l.i iVar = e.j.l.i.a;
        if (view == null) {
            androidx.fragment.app.d activity = fragment.getActivity();
            view = activity == null ? null : activity.getCurrentFocus();
        }
        iVar.b(view);
    }

    public static /* synthetic */ void g(Fragment fragment, View view, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            view = null;
        }
        f(fragment, view);
    }

    public static final boolean h(Fragment fragment) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Context context = fragment.getContext();
        return context != null && h.i(context);
    }

    public static final boolean i(Fragment fragment) {
        return (fragment instanceof BackableFragment) && fragment.isVisible() && ((BackableFragment) fragment).onBackPressed();
    }

    public static final boolean j(Fragment fragment, int i2, boolean z) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        return Fragment_CommonKt.navigateUpTo(fragment, i2, z);
    }

    public static /* synthetic */ boolean k(Fragment fragment, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z = false;
        }
        return j(fragment, i2, z);
    }

    public static final void l(Fragment fragment) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Fragment_CommonKt.navigateUpToRoot(fragment);
    }

    public static final int m(Fragment fragment, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Context requireContext = fragment.requireContext();
        kotlin.jvm.internal.m.f(requireContext, "requireContext()");
        return h.f(requireContext, i2);
    }

    public static final Drawable n(Fragment fragment, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Drawable f2 = androidx.core.content.a.f(fragment.requireContext(), i2);
        if (f2 != null) {
            return f2;
        }
        throw new Resources.NotFoundException();
    }

    public static final void o(Fragment fragment, AuthenticationHelper authenticationHelper) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        kotlin.jvm.internal.m.g(authenticationHelper, "authenticationHelper");
        authenticationHelper.setActivity(fragment.requireActivity());
    }

    public static final androidx.appcompat.app.c p(Fragment fragment, kotlin.e0.c.l<? super c.a, kotlin.x> callback) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        kotlin.jvm.internal.m.g(callback, "callback");
        Context context = fragment.getContext();
        if (context == null) {
            l.a.a.i("Attempted to show a dialog, but Fragment " + fragment + " has no context", new Object[0]);
            return null;
        }
        return h.j(context, callback);
    }

    public static final void q(Fragment fragment, View view) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        e.j.l.i.a.c(view);
    }

    public static final int r(Fragment fragment, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Resources resources = fragment.getResources();
        kotlin.jvm.internal.m.f(resources, "resources");
        return Math.round(TypedValue.applyDimension(1, i2, resources.getDisplayMetrics()));
    }

    public static final void s(Fragment fragment, int i2, int i3) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        Fragment_CommonKt.toast(fragment, i2, i3);
    }

    public static final void t(Fragment fragment, String text, int i2) {
        kotlin.jvm.internal.m.g(fragment, "<this>");
        kotlin.jvm.internal.m.g(text, "text");
        Fragment_CommonKt.toast(fragment, text, i2);
    }

    public static /* synthetic */ void u(Fragment fragment, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        s(fragment, i2, i3);
    }

    public static /* synthetic */ void v(Fragment fragment, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        t(fragment, str, i2);
    }
}