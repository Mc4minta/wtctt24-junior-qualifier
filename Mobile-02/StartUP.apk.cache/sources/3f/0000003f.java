package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.i;
import androidx.lifecycle.m;
import androidx.lifecycle.o;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
final class ImmLeaksCleaner implements m {
    private static int a;

    /* renamed from: b  reason: collision with root package name */
    private static Field f398b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f399c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f400d;

    /* renamed from: e  reason: collision with root package name */
    private Activity f401e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmLeaksCleaner(Activity activity) {
        this.f401e = activity;
    }

    private static void h() {
        try {
            a = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f399c = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f400d = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f398b = declaredField3;
            declaredField3.setAccessible(true);
            a = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.m
    public void c(o oVar, i.a aVar) {
        if (aVar != i.a.ON_DESTROY) {
            return;
        }
        if (a == 0) {
            h();
        }
        if (a == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f401e.getSystemService("input_method");
            try {
                Object obj = f398b.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f399c.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f400d.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}