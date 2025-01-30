package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.g;
import androidx.lifecycle.i;
import androidx.lifecycle.o;
import androidx.lifecycle.t;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;

/* loaded from: classes2.dex */
public class LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter implements g {
    final LifecycleEventsObservable.ArchLifecycleObserver a;

    LifecycleEventsObservable_ArchLifecycleObserver_LifecycleAdapter(LifecycleEventsObservable.ArchLifecycleObserver archLifecycleObserver) {
        this.a = archLifecycleObserver;
    }

    @Override // androidx.lifecycle.g
    public void a(o oVar, i.a aVar, boolean z, t tVar) {
        boolean z2 = tVar != null;
        if (z) {
            if (!z2 || tVar.a("onStateChange", 4)) {
                this.a.onStateChange(oVar, aVar);
            }
        }
    }
}