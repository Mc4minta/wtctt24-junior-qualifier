package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import androidx.fragment.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public final class b1 extends Fragment implements i {
    private static WeakHashMap<androidx.fragment.app.d, WeakReference<b1>> a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private Map<String, LifecycleCallback> f6074b = new c.e.a();

    /* renamed from: c  reason: collision with root package name */
    private int f6075c = 0;

    /* renamed from: d  reason: collision with root package name */
    private Bundle f6076d;

    public static b1 e(androidx.fragment.app.d dVar) {
        b1 b1Var;
        WeakReference<b1> weakReference = a.get(dVar);
        if (weakReference == null || (b1Var = weakReference.get()) == null) {
            try {
                b1 b1Var2 = (b1) dVar.getSupportFragmentManager().Z("SupportLifecycleFragmentImpl");
                if (b1Var2 == null || b1Var2.isRemoving()) {
                    b1Var2 = new b1();
                    dVar.getSupportFragmentManager().j().e(b1Var2, "SupportLifecycleFragmentImpl").k();
                }
                a.put(dVar, new WeakReference<>(b1Var2));
                return b1Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
            }
        }
        return b1Var;
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (!this.f6074b.containsKey(str)) {
            this.f6074b.put(str, lifecycleCallback);
            if (this.f6075c > 0) {
                new e.g.a.e.d.e.h(Looper.getMainLooper()).post(new a1(this, lifecycleCallback, str));
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
        return cls.cast(this.f6074b.get(str));
    }

    @Override // com.google.android.gms.common.api.internal.i
    public final /* synthetic */ Activity c() {
        return getActivity();
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.e(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f6075c = 1;
        this.f6076d = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f6074b.entrySet()) {
            entry.getValue().f(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f6075c = 5;
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.g();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f6075c = 3;
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.h();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f6074b.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().i(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f6075c = 2;
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.j();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f6075c = 4;
        for (LifecycleCallback lifecycleCallback : this.f6074b.values()) {
            lifecycleCallback.k();
        }
    }
}