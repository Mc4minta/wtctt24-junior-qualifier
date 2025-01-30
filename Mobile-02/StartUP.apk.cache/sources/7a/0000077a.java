package com.bugsnag.android;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: AnrDetailsCollector.kt */
/* loaded from: classes.dex */
public final class a {
    public static final C0100a a = new C0100a(null);

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f3588b;

    /* compiled from: AnrDetailsCollector.kt */
    /* renamed from: com.bugsnag.android.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0100a {
        private C0100a() {
        }

        public /* synthetic */ C0100a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: AnrDetailsCollector.kt */
    /* loaded from: classes.dex */
    public static final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f3589b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicInteger f3590c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Handler f3591d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ c0 f3592e;

        b(q qVar, AtomicInteger atomicInteger, Handler handler, c0 c0Var) {
            this.f3589b = qVar;
            this.f3590c = atomicInteger;
            this.f3591d = handler;
            this.f3592e = c0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            Context context = this.f3589b.f3684b;
            kotlin.jvm.internal.m.d(context, "client.appContext");
            ActivityManager.ProcessErrorStateInfo c2 = aVar.c(context);
            if (c2 == null) {
                if (this.f3590c.getAndIncrement() < 300) {
                    this.f3591d.postDelayed(this, 100L);
                    return;
                }
                return;
            }
            a.this.a(this.f3592e, c2);
            this.f3589b.x(this.f3592e, a0.ASYNC_WITH_CACHE, null);
        }
    }

    public a() {
        HandlerThread handlerThread = new HandlerThread("bugsnag-anr-collector");
        this.f3588b = handlerThread;
        handlerThread.start();
    }

    public final void a(c0 error, ActivityManager.ProcessErrorStateInfo anrState) {
        boolean Q;
        kotlin.jvm.internal.m.h(error, "error");
        kotlin.jvm.internal.m.h(anrState, "anrState");
        String msg = anrState.shortMsg;
        kotlin.jvm.internal.m.d(msg, "msg");
        Q = kotlin.l0.x.Q(msg, "ANR", false, 2, null);
        if (Q) {
            msg = kotlin.l0.x.M(msg, "ANR", "", false, 4, null);
        }
        error.n(msg);
    }

    public final ActivityManager.ProcessErrorStateInfo b(ActivityManager am, int i2) {
        Object obj;
        boolean z;
        kotlin.jvm.internal.m.h(am, "am");
        try {
            List<ActivityManager.ProcessErrorStateInfo> processesInErrorState = am.getProcessesInErrorState();
            if (processesInErrorState == null) {
                processesInErrorState = kotlin.a0.r.g();
            }
            Iterator<T> it = processesInErrorState.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (((ActivityManager.ProcessErrorStateInfo) obj).pid == i2) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    break;
                }
            }
            return (ActivityManager.ProcessErrorStateInfo) obj;
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public final ActivityManager.ProcessErrorStateInfo c(Context ctx) {
        kotlin.jvm.internal.m.h(ctx, "ctx");
        Object systemService = ctx.getSystemService("activity");
        if (systemService != null) {
            return b((ActivityManager) systemService, Process.myPid());
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
    }

    public final void d(q client, c0 error) {
        kotlin.jvm.internal.m.h(client, "client");
        kotlin.jvm.internal.m.h(error, "error");
        Handler handler = new Handler(this.f3588b.getLooper());
        handler.post(new b(client, new AtomicInteger(), handler, error));
    }
}