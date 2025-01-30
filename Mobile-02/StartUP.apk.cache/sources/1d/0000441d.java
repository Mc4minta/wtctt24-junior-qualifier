package dagger.android;

import android.app.Activity;
import android.app.Application;
import f.c.h;

/* compiled from: AndroidInjection.java */
/* loaded from: classes2.dex */
public final class a {
    public static void a(Activity activity) {
        h.c(activity, "activity");
        Application application = activity.getApplication();
        if (application instanceof f) {
            b(activity, (f) application);
            return;
        }
        throw new RuntimeException(String.format("%s does not implement %s", application.getClass().getCanonicalName(), f.class.getCanonicalName()));
    }

    private static void b(Object obj, f fVar) {
        b<Object> androidInjector = fVar.androidInjector();
        h.d(androidInjector, "%s.androidInjector() returned null", fVar.getClass());
        androidInjector.inject(obj);
    }
}