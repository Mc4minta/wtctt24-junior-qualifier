package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/* compiled from: ActivityRecreator.java */
/* loaded from: classes.dex */
final class c {
    protected static final Class<?> a;

    /* renamed from: b  reason: collision with root package name */
    protected static final Field f1390b;

    /* renamed from: c  reason: collision with root package name */
    protected static final Field f1391c;

    /* renamed from: d  reason: collision with root package name */
    protected static final Method f1392d;

    /* renamed from: e  reason: collision with root package name */
    protected static final Method f1393e;

    /* renamed from: f  reason: collision with root package name */
    protected static final Method f1394f;

    /* renamed from: g  reason: collision with root package name */
    private static final Handler f1395g = new Handler(Looper.getMainLooper());

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        final /* synthetic */ d a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f1396b;

        a(d dVar, Object obj) {
            this.a = dVar;
            this.f1396b = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a = this.f1396b;
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Application a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ d f1397b;

        b(Application application, d dVar) {
            this.a = application;
            this.f1397b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.unregisterActivityLifecycleCallbacks(this.f1397b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ActivityRecreator.java */
    /* renamed from: androidx.core.app.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0023c implements Runnable {
        final /* synthetic */ Object a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f1398b;

        RunnableC0023c(Object obj, Object obj2) {
            this.a = obj;
            this.f1398b = obj2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Method method = c.f1392d;
                if (method != null) {
                    method.invoke(this.a, this.f1398b, Boolean.FALSE, "AppCompat recreation");
                } else {
                    c.f1393e.invoke(this.a, this.f1398b, Boolean.FALSE);
                }
            } catch (RuntimeException e2) {
                if (e2.getClass() == RuntimeException.class && e2.getMessage() != null && e2.getMessage().startsWith("Unable to stop")) {
                    throw e2;
                }
            } catch (Throwable th) {
                Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
            }
        }
    }

    /* compiled from: ActivityRecreator.java */
    /* loaded from: classes.dex */
    private static final class d implements Application.ActivityLifecycleCallbacks {
        Object a;

        /* renamed from: b  reason: collision with root package name */
        private Activity f1399b;

        /* renamed from: c  reason: collision with root package name */
        private final int f1400c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f1401d = false;

        /* renamed from: e  reason: collision with root package name */
        private boolean f1402e = false;

        /* renamed from: f  reason: collision with root package name */
        private boolean f1403f = false;

        d(Activity activity) {
            this.f1399b = activity;
            this.f1400c = activity.hashCode();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (this.f1399b == activity) {
                this.f1399b = null;
                this.f1402e = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (!this.f1402e || this.f1403f || this.f1401d || !c.h(this.a, this.f1400c, activity)) {
                return;
            }
            this.f1403f = true;
            this.a = null;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (this.f1399b == activity) {
                this.f1401d = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    static {
        Class<?> a2 = a();
        a = a2;
        f1390b = b();
        f1391c = f();
        f1392d = d(a2);
        f1393e = c(a2);
        f1394f = e(a2);
    }

    private static Class<?> a() {
        try {
            return Class.forName("android.app.ActivityThread");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Field b() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mMainThread");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method c(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method d(Class<?> cls) {
        if (cls == null) {
            return null;
        }
        try {
            Method declaredMethod = cls.getDeclaredMethod("performStopActivity", IBinder.class, Boolean.TYPE, String.class);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Method e(Class<?> cls) {
        if (g() && cls != null) {
            try {
                Class<?> cls2 = Boolean.TYPE;
                Method declaredMethod = cls.getDeclaredMethod("requestRelaunchActivity", IBinder.class, List.class, List.class, Integer.TYPE, cls2, Configuration.class, Configuration.class, cls2, cls2);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    private static Field f() {
        try {
            Field declaredField = Activity.class.getDeclaredField("mToken");
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean g() {
        int i2 = Build.VERSION.SDK_INT;
        return i2 == 26 || i2 == 27;
    }

    protected static boolean h(Object obj, int i2, Activity activity) {
        try {
            Object obj2 = f1391c.get(activity);
            if (obj2 == obj && activity.hashCode() == i2) {
                f1395g.postAtFrontOfQueue(new RunnableC0023c(f1390b.get(activity), obj2));
                return true;
            }
            return false;
        } catch (Throwable th) {
            Log.e("ActivityRecreator", "Exception while fetching field values", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Activity activity) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 28) {
            activity.recreate();
            return true;
        } else if (g() && f1394f == null) {
            return false;
        } else {
            if (f1393e == null && f1392d == null) {
                return false;
            }
            try {
                Object obj2 = f1391c.get(activity);
                if (obj2 == null || (obj = f1390b.get(activity)) == null) {
                    return false;
                }
                Application application = activity.getApplication();
                d dVar = new d(activity);
                application.registerActivityLifecycleCallbacks(dVar);
                Handler handler = f1395g;
                handler.post(new a(dVar, obj2));
                if (g()) {
                    Method method = f1394f;
                    Boolean bool = Boolean.FALSE;
                    method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                } else {
                    activity.recreate();
                }
                handler.post(new b(application, dVar));
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
    }
}