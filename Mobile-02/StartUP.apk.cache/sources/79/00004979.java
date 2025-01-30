package e.j.f;

import android.graphics.drawable.ColorDrawable;
import android.view.Window;

/* compiled from: WindowExtensions.kt */
/* loaded from: classes2.dex */
public final class z {
    public static final void a(Window window, int i2) {
        kotlin.jvm.internal.m.g(window, "<this>");
        window.setBackgroundDrawable(new ColorDrawable(i2));
    }

    public static final void b(Window window, int i2) {
        kotlin.jvm.internal.m.g(window, "<this>");
        a(window, androidx.core.content.a.d(window.getContext(), i2));
    }
}