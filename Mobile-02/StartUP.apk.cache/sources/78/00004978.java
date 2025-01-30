package e.j.f;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import java.util.Arrays;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes2.dex */
public final class y {
    public static final void a(View view) {
        kotlin.jvm.internal.m.g(view, "<this>");
        view.setImportantForAccessibility(2);
    }

    public static final int b(View view, int i2) {
        kotlin.jvm.internal.m.g(view, "<this>");
        Context context = view.getContext();
        kotlin.jvm.internal.m.f(context, "context");
        return h.f(context, i2);
    }

    public static final Drawable c(View view, int i2) {
        kotlin.jvm.internal.m.g(view, "<this>");
        return c.a.k.a.a.d(view.getContext(), i2);
    }

    public static final String d(View view, int i2) {
        kotlin.jvm.internal.m.g(view, "<this>");
        String string = view.getContext().getString(i2);
        kotlin.jvm.internal.m.f(string, "context.getString(id)");
        return string;
    }

    public static final String e(View view, int i2, Object... formatArgs) {
        kotlin.jvm.internal.m.g(view, "<this>");
        kotlin.jvm.internal.m.g(formatArgs, "formatArgs");
        String string = view.getContext().getString(i2, Arrays.copyOf(formatArgs, formatArgs.length));
        kotlin.jvm.internal.m.f(string, "context.getString(resId, *formatArgs)");
        return string;
    }

    public static final boolean f(View view) {
        kotlin.jvm.internal.m.g(view, "<this>");
        return view.getVisibility() != 0;
    }

    public static final int g(View view, int i2) {
        kotlin.jvm.internal.m.g(view, "<this>");
        return Math.round(TypedValue.applyDimension(1, i2, view.getResources().getDisplayMetrics()));
    }
}