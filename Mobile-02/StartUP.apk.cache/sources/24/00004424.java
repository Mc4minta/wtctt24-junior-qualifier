package dagger.android.g;

import android.util.Log;
import androidx.fragment.app.Fragment;

/* compiled from: AndroidSupportInjection.java */
/* loaded from: classes2.dex */
public final class a {
    private static dagger.android.f a(Fragment fragment) {
        Fragment fragment2 = fragment;
        do {
            fragment2 = fragment2.getParentFragment();
            if (fragment2 == null) {
                androidx.fragment.app.d activity = fragment.getActivity();
                if (activity instanceof dagger.android.f) {
                    return (dagger.android.f) activity;
                }
                if (activity.getApplication() instanceof dagger.android.f) {
                    return (dagger.android.f) activity.getApplication();
                }
                throw new IllegalArgumentException(String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
            }
        } while (!(fragment2 instanceof dagger.android.f));
        return (dagger.android.f) fragment2;
    }

    public static void b(Fragment fragment) {
        f.c.h.c(fragment, "fragment");
        dagger.android.f a = a(fragment);
        if (Log.isLoggable("dagger.android.support", 3)) {
            Log.d("dagger.android.support", String.format("An injector for %s was found in %s", fragment.getClass().getCanonicalName(), a.getClass().getCanonicalName()));
        }
        c(fragment, a);
    }

    private static void c(Object obj, dagger.android.f fVar) {
        dagger.android.b<Object> androidInjector = fVar.androidInjector();
        f.c.h.d(androidInjector, "%s.androidInjector() returned null", fVar.getClass());
        androidInjector.inject(obj);
    }
}