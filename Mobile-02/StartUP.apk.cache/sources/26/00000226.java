package androidx.core.app;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.View;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* compiled from: ActivityCompat.java */
/* loaded from: classes.dex */
public class a extends androidx.core.content.a {

    /* renamed from: c  reason: collision with root package name */
    private static d f1386c;

    /* compiled from: ActivityCompat.java */
    /* renamed from: androidx.core.app.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class RunnableC0021a implements Runnable {
        final /* synthetic */ String[] a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Activity f1387b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f1388c;

        RunnableC0021a(String[] strArr, Activity activity, int i2) {
            this.a = strArr;
            this.f1387b = activity;
            this.f1388c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int[] iArr = new int[this.a.length];
            PackageManager packageManager = this.f1387b.getPackageManager();
            String packageName = this.f1387b.getPackageName();
            int length = this.a.length;
            for (int i2 = 0; i2 < length; i2++) {
                iArr[i2] = packageManager.checkPermission(this.a[i2], packageName);
            }
            ((c) this.f1387b).onRequestPermissionsResult(this.f1388c, this.a, iArr);
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    class b implements Runnable {
        final /* synthetic */ Activity a;

        b(Activity activity) {
            this.a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.a.isFinishing() || androidx.core.app.c.i(this.a)) {
                return;
            }
            this.a.recreate();
        }
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface c {
        void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface d {
        boolean a(Activity activity, String[] strArr, int i2);

        boolean onActivityResult(Activity activity, int i2, int i3, Intent intent);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    public interface e {
        void validateRequestPermissionsRequestCode(int i2);
    }

    /* compiled from: ActivityCompat.java */
    /* loaded from: classes.dex */
    private static class f extends SharedElementCallback {

        /* compiled from: ActivityCompat.java */
        /* renamed from: androidx.core.app.a$f$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0022a {
            final /* synthetic */ SharedElementCallback.OnSharedElementsReadyListener a;

            C0022a(SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
                this.a = onSharedElementsReadyListener;
            }
        }

        f(p pVar) {
        }

        @Override // android.app.SharedElementCallback
        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public void onRejectSharedElements(List<View> list) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            throw null;
        }

        @Override // android.app.SharedElementCallback
        public void onSharedElementsArrived(List<String> list, List<View> list2, SharedElementCallback.OnSharedElementsReadyListener onSharedElementsReadyListener) {
            new C0022a(onSharedElementsReadyListener);
            throw null;
        }
    }

    public static void m(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.finishAffinity();
        } else {
            activity.finish();
        }
    }

    public static void n(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.finishAfterTransition();
        } else {
            activity.finish();
        }
    }

    public static d o() {
        return f1386c;
    }

    public static void p(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.postponeEnterTransition();
        }
    }

    public static void q(Activity activity) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            activity.recreate();
        } else if (i2 <= 23) {
            new Handler(activity.getMainLooper()).post(new b(activity));
        } else if (androidx.core.app.c.i(activity)) {
        } else {
            activity.recreate();
        }
    }

    public static void r(Activity activity, String[] strArr, int i2) {
        d dVar = f1386c;
        if (dVar == null || !dVar.a(activity, strArr, i2)) {
            for (String str : strArr) {
                if (TextUtils.isEmpty(str)) {
                    throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
                }
            }
            if (Build.VERSION.SDK_INT >= 23) {
                if (activity instanceof e) {
                    ((e) activity).validateRequestPermissionsRequestCode(i2);
                }
                activity.requestPermissions(strArr, i2);
            } else if (activity instanceof c) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0021a(strArr, activity, i2));
            }
        }
    }

    public static <T extends View> T s(Activity activity, int i2) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) activity.requireViewById(i2);
        }
        T t = (T) activity.findViewById(i2);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }

    public static void t(Activity activity, p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setEnterSharedElementCallback(pVar != null ? new f(pVar) : null);
        }
    }

    public static void u(Activity activity, p pVar) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setExitSharedElementCallback(pVar != null ? new f(pVar) : null);
        }
    }

    public static boolean v(Activity activity, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
        return false;
    }

    public static void w(Activity activity, Intent intent, int i2, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startActivityForResult(intent, i2, bundle);
        } else {
            activity.startActivityForResult(intent, i2);
        }
    }

    public static void x(Activity activity, IntentSender intentSender, int i2, Intent intent, int i3, int i4, int i5, Bundle bundle) throws IntentSender.SendIntentException {
        if (Build.VERSION.SDK_INT >= 16) {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5, bundle);
        } else {
            activity.startIntentSenderForResult(intentSender, i2, intent, i3, i4, i5);
        }
    }

    public static void y(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startPostponedEnterTransition();
        }
    }
}