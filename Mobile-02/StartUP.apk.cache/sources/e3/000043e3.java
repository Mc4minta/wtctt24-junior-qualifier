package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.i;
import androidx.lifecycle.o;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.CorrespondingEventsFunction;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.d;
import com.uber.autodispose.lifecycle.e;
import h.c.f;
import h.c.s;

/* compiled from: AndroidLifecycleScopeProvider.java */
/* loaded from: classes2.dex */
public final class b implements d<i.a> {
    private static final CorrespondingEventsFunction<i.a> a = new CorrespondingEventsFunction() { // from class: com.uber.autodispose.android.lifecycle.a
        @Override // com.uber.autodispose.lifecycle.CorrespondingEventsFunction, h.c.m0.n
        public final Object apply(Object obj) {
            return b.f((i.a) obj);
        }
    };

    /* renamed from: b */
    private final CorrespondingEventsFunction<i.a> f11423b;

    /* renamed from: c */
    private final LifecycleEventsObservable f11424c;

    /* compiled from: AndroidLifecycleScopeProvider.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.values().length];
            a = iArr;
            try {
                iArr[i.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[i.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* compiled from: AndroidLifecycleScopeProvider.java */
    /* renamed from: com.uber.autodispose.android.lifecycle.b$b */
    /* loaded from: classes2.dex */
    public static class C0248b implements CorrespondingEventsFunction<i.a> {
        private final i.a a;

        C0248b(i.a aVar) {
            this.a = aVar;
        }

        @Override // com.uber.autodispose.lifecycle.CorrespondingEventsFunction, h.c.m0.n
        /* renamed from: a */
        public i.a apply(i.a aVar) throws OutsideScopeException {
            return this.a;
        }
    }

    private b(i iVar, CorrespondingEventsFunction<i.a> correspondingEventsFunction) {
        this.f11424c = new LifecycleEventsObservable(iVar);
        this.f11423b = correspondingEventsFunction;
    }

    public static b a(i iVar) {
        return c(iVar, a);
    }

    public static b b(i iVar, i.a aVar) {
        return c(iVar, new C0248b(aVar));
    }

    public static b c(i iVar, CorrespondingEventsFunction<i.a> correspondingEventsFunction) {
        return new b(iVar, correspondingEventsFunction);
    }

    public static b d(o oVar) {
        return a(oVar.getLifecycle());
    }

    public static b e(o oVar, i.a aVar) {
        return b(oVar.getLifecycle(), aVar);
    }

    public static /* synthetic */ i.a f(i.a aVar) throws OutsideScopeException {
        int i2 = a.a[aVar.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return i.a.ON_STOP;
                    }
                    throw new LifecycleEndedException("Lifecycle has ended! Last event was " + aVar);
                }
                return i.a.ON_PAUSE;
            }
            return i.a.ON_STOP;
        }
        return i.a.ON_DESTROY;
    }

    @Override // com.uber.autodispose.lifecycle.d
    public CorrespondingEventsFunction<i.a> correspondingEvents() {
        return this.f11423b;
    }

    @Override // com.uber.autodispose.lifecycle.d
    /* renamed from: g */
    public i.a peekLifecycle() {
        this.f11424c.b();
        return this.f11424c.c();
    }

    @Override // com.uber.autodispose.lifecycle.d
    public s<i.a> lifecycle() {
        return this.f11424c;
    }

    @Override // com.uber.autodispose.y
    public f requestScope() {
        return e.c(this);
    }
}