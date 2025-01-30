package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.i;
import androidx.lifecycle.n;
import androidx.lifecycle.o;
import androidx.lifecycle.w;
import com.uber.autodispose.b0.b.c;
import com.uber.autodispose.b0.b.d;
import h.c.s;
import h.c.z;

/* loaded from: classes2.dex */
class LifecycleEventsObservable extends s<i.a> {
    private final i a;

    /* renamed from: b  reason: collision with root package name */
    private final h.c.v0.a<i.a> f11419b = h.c.v0.a.d();

    /* loaded from: classes2.dex */
    static final class ArchLifecycleObserver extends d implements n {

        /* renamed from: b  reason: collision with root package name */
        private final i f11420b;

        /* renamed from: c  reason: collision with root package name */
        private final z<? super i.a> f11421c;

        /* renamed from: d  reason: collision with root package name */
        private final h.c.v0.a<i.a> f11422d;

        ArchLifecycleObserver(i iVar, z<? super i.a> zVar, h.c.v0.a<i.a> aVar) {
            this.f11420b = iVar;
            this.f11421c = zVar;
            this.f11422d = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.uber.autodispose.b0.b.d
        public void h() {
            this.f11420b.c(this);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @w(i.a.ON_ANY)
        public void onStateChange(o oVar, i.a aVar) {
            if (isDisposed()) {
                return;
            }
            if (aVar != i.a.ON_CREATE || this.f11422d.f() != aVar) {
                this.f11422d.onNext(aVar);
            }
            this.f11421c.onNext(aVar);
        }
    }

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.b.values().length];
            a = iArr;
            try {
                iArr[i.b.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.b.CREATED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.b.STARTED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.b.RESUMED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.b.DESTROYED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LifecycleEventsObservable(i iVar) {
        this.a = iVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        i.a aVar;
        int i2 = a.a[this.a.b().ordinal()];
        if (i2 == 1) {
            aVar = i.a.ON_CREATE;
        } else if (i2 == 2) {
            aVar = i.a.ON_START;
        } else if (i2 != 3 && i2 != 4) {
            aVar = i.a.ON_DESTROY;
        } else {
            aVar = i.a.ON_RESUME;
        }
        this.f11419b.onNext(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i.a c() {
        return this.f11419b.f();
    }

    @Override // h.c.s
    protected void subscribeActual(z<? super i.a> zVar) {
        ArchLifecycleObserver archLifecycleObserver = new ArchLifecycleObserver(this.a, zVar, this.f11419b);
        zVar.onSubscribe(archLifecycleObserver);
        if (!c.a()) {
            zVar.onError(new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.a.a(archLifecycleObserver);
        if (archLifecycleObserver.isDisposed()) {
            this.a.c(archLifecycleObserver);
        }
    }
}