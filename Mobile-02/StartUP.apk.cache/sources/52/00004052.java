package com.th3rdwave.safeareacontext;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;

/* compiled from: SafeAreaUtils.java */
/* loaded from: classes2.dex */
class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(ViewGroup viewGroup, View view) {
        if (view.getParent() == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        try {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            return new c(rect.left, rect.top, view.getWidth(), view.getHeight());
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static a b(View view) {
        if (Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            return new a(rootWindowInsets.getSystemWindowInsetTop(), rootWindowInsets.getSystemWindowInsetRight(), Math.min(rootWindowInsets.getSystemWindowInsetBottom(), rootWindowInsets.getStableInsetBottom()), rootWindowInsets.getSystemWindowInsetLeft());
        }
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return new a(rect.top, view.getWidth() - rect.right, view.getHeight() - rect.bottom, rect.left);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a c(View view) {
        View rootView;
        a b2;
        if (view.getHeight() == 0 || (b2 = b((rootView = view.getRootView()))) == null) {
            return null;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        b2.a = Math.max(b2.a - rect.top, 0.0f);
        b2.f11053d = Math.max(b2.f11053d - rect.left, 0.0f);
        b2.f11052c = Math.max(((rect.top + view.getHeight()) + b2.f11052c) - rootView.getHeight(), 0.0f);
        b2.f11051b = Math.max(((rect.left + view.getWidth()) + b2.f11051b) - rootView.getWidth(), 0.0f);
        return b2;
    }
}