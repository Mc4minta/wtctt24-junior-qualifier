package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class y0 extends Fragment implements i {
    private static WeakHashMap<Activity, WeakReference<y0>> a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, LifecycleCallback> f6147b = new c.e.a();

    /* renamed from: c  reason: collision with root package name */
    private int f6148c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f6149d;

    public static y0 e(Activity activity) {
        y0 y0Var;
        WeakReference<y0> weakReference = a.get(activity);
        if (weakReference == null || (y0Var = weakReference.get()) == null) {
            try {
                y0 y0Var2 = (y0) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (y0Var2 == null || y0Var2.isRemoving()) {
                    y0Var2 = new y0();
                    activity.getFragmentManager().beginTransaction().add(y0Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                a.put(activity, new WeakReference<>(y0Var2));
                return y0Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
            }
        }
        return y0Var;
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f6147b.containsKey(str)) {
            this.f6147b.put(str, lifecycleCallback);
            if (this.f6148c > 0) {
                new e.g.a.e.d.e.h(Looper.getMainLooper()).post(new z0(this, lifecycleCallback, str));
                return;
            }
            return;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
        sb.append("LifecycleCallback with tag ");
        sb.append(str);
        sb.append(" already added to this fragment.");
        throw new IllegalArgumentException(sb.toString());
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final <T extends LifecycleCallback> T b(String str, Class<T> cls) {
        return cls.cast(this.f6147b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.e(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6148c = 1;
        this.f6149d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f6147b.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f6148c = 5;
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f6148c = 3;
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f6147b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().i(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f6148c = 2;
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f6148c = 4;
        for (LifecycleCallback lifecycleCallback : this.f6147b.values()) {
            lifecycleCallback.k();
        }
    }
}