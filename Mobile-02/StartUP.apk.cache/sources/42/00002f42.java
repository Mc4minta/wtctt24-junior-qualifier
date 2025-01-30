package com.facebook.react.uimanager;

import android.os.SystemClock;
import android.view.View;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.modules.core.g;
import com.facebook.react.uimanager.m0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: UIViewOperationQueue.java */
/* loaded from: classes2.dex */
public class t0 {
    private static final String a = "t0";
    private long A;
    private long B;

    /* renamed from: c  reason: collision with root package name */
    private final com.facebook.react.uimanager.l f5194c;

    /* renamed from: f  reason: collision with root package name */
    private final j f5197f;

    /* renamed from: g  reason: collision with root package name */
    private final ReactApplicationContext f5198g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5199h;
    private com.facebook.react.uimanager.e1.a m;
    private long q;
    private long r;
    private long s;
    private long t;
    private long u;
    private long v;
    private long w;
    private long x;
    private long y;
    private long z;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f5193b = new int[4];

    /* renamed from: d  reason: collision with root package name */
    private final Object f5195d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Object f5196e = new Object();

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<h> f5200i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<u> f5201j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<Runnable> f5202k = new ArrayList<>();

    /* renamed from: l  reason: collision with root package name */
    private ArrayDeque<u> f5203l = new ArrayDeque<>();
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public class a implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f5204b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayDeque f5205c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f5206d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ long f5207e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f5208f;

        /* renamed from: g  reason: collision with root package name */
        final /* synthetic */ long f5209g;

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ long f5210h;

        a(int i2, ArrayList arrayList, ArrayDeque arrayDeque, ArrayList arrayList2, long j2, long j3, long j4, long j5) {
            this.a = i2;
            this.f5204b = arrayList;
            this.f5205c = arrayDeque;
            this.f5206d = arrayList2;
            this.f5207e = j2;
            this.f5208f = j3;
            this.f5209g = j4;
            this.f5210h = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.facebook.systrace.b.a(0L, "DispatchUI").a("BatchId", this.a).c();
            try {
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    ArrayList arrayList = this.f5204b;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            h hVar = (h) it.next();
                            try {
                                hVar.c();
                            } catch (RetryableMountingLayerException e2) {
                                if (hVar.a() != 0) {
                                    ReactSoftException.logSoftException(t0.a, new ReactNoCrashSoftException(e2));
                                } else {
                                    hVar.b();
                                    t0.this.f5200i.add(hVar);
                                }
                            } catch (Throwable th) {
                                ReactSoftException.logSoftException(t0.a, th);
                            }
                        }
                    }
                    ArrayDeque arrayDeque = this.f5205c;
                    if (arrayDeque != null) {
                        Iterator it2 = arrayDeque.iterator();
                        while (it2.hasNext()) {
                            ((u) it2.next()).execute();
                        }
                    }
                    ArrayList arrayList2 = this.f5206d;
                    if (arrayList2 != null) {
                        Iterator it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            ((u) it3.next()).execute();
                        }
                    }
                    if (t0.this.p && t0.this.r == 0) {
                        t0.this.r = this.f5207e;
                        t0.this.s = SystemClock.uptimeMillis();
                        t0.this.t = this.f5208f;
                        t0.this.u = this.f5209g;
                        t0.this.v = uptimeMillis;
                        t0 t0Var = t0.this;
                        t0Var.w = t0Var.s;
                        t0.this.z = this.f5210h;
                        com.facebook.systrace.a.b(0L, "delayBeforeDispatchViewUpdates", 0, t0.this.r * 1000000);
                        com.facebook.systrace.a.f(0L, "delayBeforeDispatchViewUpdates", 0, t0.this.u * 1000000);
                        com.facebook.systrace.a.b(0L, "delayBeforeBatchRunStart", 0, t0.this.u * 1000000);
                        com.facebook.systrace.a.f(0L, "delayBeforeBatchRunStart", 0, t0.this.v * 1000000);
                    }
                    t0.this.f5194c.f();
                    if (t0.this.m != null) {
                        t0.this.m.b();
                    }
                } catch (Exception e3) {
                    t0.this.o = true;
                    throw e3;
                }
            } finally {
                com.facebook.systrace.a.g(0L);
            }
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    class b extends GuardedRunnable {
        b(ReactContext reactContext) {
            super(reactContext);
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        public void runGuarded() {
            t0.this.U();
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class c extends y {

        /* renamed from: c  reason: collision with root package name */
        private final int f5212c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f5213d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f5214e;

        public c(int i2, int i3, boolean z, boolean z2) {
            super(i2);
            this.f5212c = i3;
            this.f5214e = z;
            this.f5213d = z2;
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            if (!this.f5214e) {
                t0.this.f5194c.z(this.a, this.f5212c, this.f5213d);
            } else {
                t0.this.f5194c.e();
            }
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private class d implements u {
        private final ReadableMap a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f5216b;

        /* synthetic */ d(t0 t0Var, ReadableMap readableMap, Callback callback, a aVar) {
            this(readableMap, callback);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.h(this.a, this.f5216b);
        }

        private d(ReadableMap readableMap, Callback callback) {
            this.a = readableMap;
            this.f5216b = callback;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public final class e extends y {

        /* renamed from: c  reason: collision with root package name */
        private final i0 f5218c;

        /* renamed from: d  reason: collision with root package name */
        private final String f5219d;

        /* renamed from: e  reason: collision with root package name */
        private final a0 f5220e;

        public e(i0 i0Var, int i2, String str, a0 a0Var) {
            super(i2);
            this.f5218c = i0Var;
            this.f5219d = str;
            this.f5220e = a0Var;
            com.facebook.systrace.a.j(0L, "createView", this.a);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            com.facebook.systrace.a.d(0L, "createView", this.a);
            t0.this.f5194c.j(this.f5218c, this.a, this.f5219d, this.f5220e);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class f implements u {
        private f() {
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.k();
        }

        /* synthetic */ f(t0 t0Var, a aVar) {
            this();
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    @Deprecated
    /* loaded from: classes2.dex */
    private final class g extends y implements h {

        /* renamed from: c  reason: collision with root package name */
        private final int f5222c;

        /* renamed from: d  reason: collision with root package name */
        private final ReadableArray f5223d;

        /* renamed from: e  reason: collision with root package name */
        private int f5224e;

        public g(int i2, int i3, ReadableArray readableArray) {
            super(i2);
            this.f5224e = 0;
            this.f5222c = i3;
            this.f5223d = readableArray;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public int a() {
            return this.f5224e;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public void b() {
            this.f5224e++;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public void c() {
            t0.this.f5194c.l(this.a, this.f5222c, this.f5223d);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            try {
                t0.this.f5194c.l(this.a, this.f5222c, this.f5223d);
            } catch (Throwable th) {
                ReactSoftException.logSoftException(t0.a, new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private interface h {
        int a();

        void b();

        void c();
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class i extends y implements h {

        /* renamed from: c  reason: collision with root package name */
        private final String f5226c;

        /* renamed from: d  reason: collision with root package name */
        private final ReadableArray f5227d;

        /* renamed from: e  reason: collision with root package name */
        private int f5228e;

        public i(int i2, String str, ReadableArray readableArray) {
            super(i2);
            this.f5228e = 0;
            this.f5226c = str;
            this.f5227d = readableArray;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public int a() {
            return this.f5228e;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public void b() {
            this.f5228e++;
        }

        @Override // com.facebook.react.uimanager.t0.h
        public void c() {
            t0.this.f5194c.m(this.a, this.f5226c, this.f5227d);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            try {
                t0.this.f5194c.m(this.a, this.f5226c, this.f5227d);
            } catch (Throwable th) {
                ReactSoftException.logSoftException(t0.a, new RuntimeException("Error dispatching View Command", th));
            }
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private class j extends com.facebook.react.uimanager.e {

        /* renamed from: c  reason: collision with root package name */
        private final int f5230c;

        /* synthetic */ j(t0 t0Var, ReactContext reactContext, int i2, a aVar) {
            this(reactContext, i2);
        }

        private void d(long j2) {
            u uVar;
            while (16 - ((System.nanoTime() - j2) / 1000000) >= this.f5230c) {
                synchronized (t0.this.f5196e) {
                    if (t0.this.f5203l.isEmpty()) {
                        return;
                    }
                    uVar = (u) t0.this.f5203l.pollFirst();
                }
                try {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    uVar.execute();
                    t0.this.q += SystemClock.uptimeMillis() - uptimeMillis;
                } catch (Exception e2) {
                    t0.this.o = true;
                    throw e2;
                }
            }
        }

        @Override // com.facebook.react.uimanager.e
        public void c(long j2) {
            if (t0.this.o) {
                e.f.d.d.a.A("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
                return;
            }
            com.facebook.systrace.a.c(0L, "dispatchNonBatchedUIOperations");
            try {
                d(j2);
                com.facebook.systrace.a.g(0L);
                t0.this.U();
                com.facebook.react.modules.core.g.i().m(g.c.DISPATCH_UI, this);
            } catch (Throwable th) {
                com.facebook.systrace.a.g(0L);
                throw th;
            }
        }

        private j(ReactContext reactContext, int i2) {
            super(reactContext);
            this.f5230c = i2;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class k implements u {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final float f5232b;

        /* renamed from: c  reason: collision with root package name */
        private final float f5233c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f5234d;

        /* synthetic */ k(t0 t0Var, int i2, float f2, float f3, Callback callback, a aVar) {
            this(i2, f2, f3, callback);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            try {
                t0.this.f5194c.t(this.a, t0.this.f5193b);
                float f2 = t0.this.f5193b[0];
                float f3 = t0.this.f5193b[1];
                int o = t0.this.f5194c.o(this.a, this.f5232b, this.f5233c);
                try {
                    t0.this.f5194c.t(o, t0.this.f5193b);
                    this.f5234d.invoke(Integer.valueOf(o), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[0] - f2)), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[1] - f3)), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[2])), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[3])));
                } catch (IllegalViewOperationException unused) {
                    this.f5234d.invoke(new Object[0]);
                }
            } catch (IllegalViewOperationException unused2) {
                this.f5234d.invoke(new Object[0]);
            }
        }

        private k(int i2, float f2, float f3, Callback callback) {
            this.a = i2;
            this.f5232b = f2;
            this.f5233c = f3;
            this.f5234d = callback;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class l implements u {
        private final com.facebook.react.uimanager.y a;

        /* renamed from: b  reason: collision with root package name */
        private final m0.b f5236b;

        /* synthetic */ l(t0 t0Var, com.facebook.react.uimanager.y yVar, m0.b bVar, a aVar) {
            this(yVar, bVar);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            this.f5236b.a(this.a);
        }

        private l(com.facebook.react.uimanager.y yVar, m0.b bVar) {
            this.a = yVar;
            this.f5236b = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public final class m extends y {

        /* renamed from: c  reason: collision with root package name */
        private final int[] f5238c;

        /* renamed from: d  reason: collision with root package name */
        private final u0[] f5239d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f5240e;

        public m(int i2, int[] iArr, u0[] u0VarArr, int[] iArr2) {
            super(i2);
            this.f5238c = iArr;
            this.f5239d = u0VarArr;
            this.f5240e = iArr2;
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.r(this.a, this.f5238c, this.f5239d, this.f5240e);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class n implements u {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f5242b;

        /* synthetic */ n(t0 t0Var, int i2, Callback callback, a aVar) {
            this(i2, callback);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            try {
                t0.this.f5194c.u(this.a, t0.this.f5193b);
                this.f5242b.invoke(Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[0])), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[1])), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[2])), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[3])));
            } catch (NoSuchNativeViewException unused) {
                this.f5242b.invoke(new Object[0]);
            }
        }

        private n(int i2, Callback callback) {
            this.a = i2;
            this.f5242b = callback;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class o implements u {
        private final int a;

        /* renamed from: b  reason: collision with root package name */
        private final Callback f5244b;

        /* synthetic */ o(t0 t0Var, int i2, Callback callback, a aVar) {
            this(i2, callback);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            try {
                t0.this.f5194c.t(this.a, t0.this.f5193b);
                float a = com.facebook.react.uimanager.o.a(t0.this.f5193b[0]);
                float a2 = com.facebook.react.uimanager.o.a(t0.this.f5193b[1]);
                this.f5244b.invoke(0, 0, Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[2])), Float.valueOf(com.facebook.react.uimanager.o.a(t0.this.f5193b[3])), Float.valueOf(a), Float.valueOf(a2));
            } catch (NoSuchNativeViewException unused) {
                this.f5244b.invoke(new Object[0]);
            }
        }

        private o(int i2, Callback callback) {
            this.a = i2;
            this.f5244b = callback;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class p extends y {
        public p(int i2) {
            super(i2);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.v(this.a);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class q extends y {

        /* renamed from: c  reason: collision with root package name */
        private final int f5247c;

        /* synthetic */ q(t0 t0Var, int i2, int i3, a aVar) {
            this(i2, i3);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.y(this.a, this.f5247c);
        }

        private q(int i2, int i3) {
            super(i2);
            this.f5247c = i3;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private class r implements u {
        private final boolean a;

        /* synthetic */ r(t0 t0Var, boolean z, a aVar) {
            this(z);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.A(this.a);
        }

        private r(boolean z) {
            this.a = z;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class s extends y {

        /* renamed from: c  reason: collision with root package name */
        private final ReadableArray f5250c;

        /* renamed from: d  reason: collision with root package name */
        private final Callback f5251d;

        /* renamed from: e  reason: collision with root package name */
        private final Callback f5252e;

        public s(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
            super(i2);
            this.f5250c = readableArray;
            this.f5251d = callback;
            this.f5252e = callback2;
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.B(this.a, this.f5250c, this.f5252e, this.f5251d);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private class t implements u {
        private final l0 a;

        public t(l0 l0Var) {
            this.a = l0Var;
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            this.a.a(t0.this.f5194c);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public interface u {
        void execute();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public final class v extends y {

        /* renamed from: c  reason: collision with root package name */
        private final int f5255c;

        /* renamed from: d  reason: collision with root package name */
        private final int f5256d;

        /* renamed from: e  reason: collision with root package name */
        private final int f5257e;

        /* renamed from: f  reason: collision with root package name */
        private final int f5258f;

        /* renamed from: g  reason: collision with root package name */
        private final int f5259g;

        public v(int i2, int i3, int i4, int i5, int i6, int i7) {
            super(i3);
            this.f5255c = i2;
            this.f5256d = i4;
            this.f5257e = i5;
            this.f5258f = i6;
            this.f5259g = i7;
            com.facebook.systrace.a.j(0L, "updateLayout", this.a);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            com.facebook.systrace.a.d(0L, "updateLayout", this.a);
            t0.this.f5194c.C(this.f5255c, this.a, this.f5256d, this.f5257e, this.f5258f, this.f5259g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    public final class w extends y {

        /* renamed from: c  reason: collision with root package name */
        private final a0 f5261c;

        /* synthetic */ w(t0 t0Var, int i2, a0 a0Var, a aVar) {
            this(i2, a0Var);
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.E(this.a, this.f5261c);
        }

        private w(int i2, a0 a0Var) {
            super(i2);
            this.f5261c = a0Var;
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private final class x extends y {

        /* renamed from: c  reason: collision with root package name */
        private final Object f5263c;

        public x(int i2, Object obj) {
            super(i2);
            this.f5263c = obj;
        }

        @Override // com.facebook.react.uimanager.t0.u
        public void execute() {
            t0.this.f5194c.F(this.a, this.f5263c);
        }
    }

    /* compiled from: UIViewOperationQueue.java */
    /* loaded from: classes2.dex */
    private abstract class y implements u {
        public int a;

        public y(int i2) {
            this.a = i2;
        }
    }

    public t0(ReactApplicationContext reactApplicationContext, com.facebook.react.uimanager.l lVar, int i2) {
        this.f5194c = lVar;
        this.f5197f = new j(this, reactApplicationContext, i2 == -1 ? 8 : i2, null);
        this.f5198g = reactApplicationContext;
        this.f5199h = e.f.m.v.a.f12892f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (this.o) {
            e.f.d.d.a.A("ReactNative", "Not flushing pending UI operations because of previously thrown Exception");
            return;
        }
        synchronized (this.f5195d) {
            if (this.f5202k.isEmpty()) {
                return;
            }
            ArrayList<Runnable> arrayList = this.f5202k;
            this.f5202k = new ArrayList<>();
            long uptimeMillis = SystemClock.uptimeMillis();
            Iterator<Runnable> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().run();
            }
            if (this.p) {
                this.x = SystemClock.uptimeMillis() - uptimeMillis;
                this.y = this.q;
                this.p = false;
                com.facebook.systrace.a.b(0L, "batchedExecutionTime", 0, 1000000 * uptimeMillis);
                com.facebook.systrace.a.e(0L, "batchedExecutionTime", 0);
            }
            this.q = 0L;
        }
    }

    public void A() {
        this.f5201j.add(new c(0, 0, true, false));
    }

    public void B(ReadableMap readableMap, Callback callback) {
        this.f5201j.add(new d(this, readableMap, callback, null));
    }

    public void C(i0 i0Var, int i2, String str, a0 a0Var) {
        synchronized (this.f5196e) {
            this.A++;
            this.f5203l.addLast(new e(i0Var, i2, str, a0Var));
        }
    }

    public void D() {
        this.f5201j.add(new f(this, null));
    }

    @Deprecated
    public void E(int i2, int i3, ReadableArray readableArray) {
        g gVar = new g(i2, i3, readableArray);
        if (this.f5199h) {
            this.f5200i.add(gVar);
        } else {
            this.f5201j.add(gVar);
        }
    }

    public void F(int i2, String str, ReadableArray readableArray) {
        i iVar = new i(i2, str, readableArray);
        if (this.f5199h) {
            this.f5200i.add(iVar);
        } else {
            this.f5201j.add(iVar);
        }
    }

    public void G(int i2, float f2, float f3, Callback callback) {
        this.f5201j.add(new k(this, i2, f2, f3, callback, null));
    }

    public void H(com.facebook.react.uimanager.y yVar, m0.b bVar) {
        this.f5201j.add(new l(this, yVar, bVar, null));
    }

    public void I(int i2, int[] iArr, u0[] u0VarArr, int[] iArr2) {
        this.f5201j.add(new m(i2, iArr, u0VarArr, iArr2));
    }

    public void J(int i2, Callback callback) {
        this.f5201j.add(new o(this, i2, callback, null));
    }

    public void K(int i2, Callback callback) {
        this.f5201j.add(new n(this, i2, callback, null));
    }

    public void L(int i2) {
        this.f5201j.add(new p(i2));
    }

    public void M(int i2, int i3) {
        this.f5201j.add(new q(this, i2, i3, null));
    }

    public void N(int i2, int i3, boolean z) {
        this.f5201j.add(new c(i2, i3, false, z));
    }

    public void O(boolean z) {
        this.f5201j.add(new r(this, z, null));
    }

    public void P(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.f5201j.add(new s(i2, readableArray, callback, callback2));
    }

    public void Q(l0 l0Var) {
        this.f5201j.add(new t(l0Var));
    }

    public void R(int i2, Object obj) {
        this.f5201j.add(new x(i2, obj));
    }

    public void S(int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f5201j.add(new v(i2, i3, i4, i5, i6, i7));
    }

    public void T(int i2, String str, a0 a0Var) {
        this.B++;
        this.f5201j.add(new w(this, i2, a0Var, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.facebook.react.uimanager.l V() {
        return this.f5194c;
    }

    public Map<String, Long> W() {
        HashMap hashMap = new HashMap();
        hashMap.put("CommitStartTime", Long.valueOf(this.r));
        hashMap.put("CommitEndTime", Long.valueOf(this.s));
        hashMap.put("LayoutTime", Long.valueOf(this.t));
        hashMap.put("DispatchViewUpdatesTime", Long.valueOf(this.u));
        hashMap.put("RunStartTime", Long.valueOf(this.v));
        hashMap.put("RunEndTime", Long.valueOf(this.w));
        hashMap.put("BatchedExecutionTime", Long.valueOf(this.x));
        hashMap.put("NonBatchedExecutionTime", Long.valueOf(this.y));
        hashMap.put("NativeModulesThreadCpuTime", Long.valueOf(this.z));
        hashMap.put("CreateViewCount", Long.valueOf(this.A));
        hashMap.put("UpdatePropsCount", Long.valueOf(this.B));
        return hashMap;
    }

    public boolean X() {
        return this.f5201j.isEmpty() && this.f5200i.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y() {
        this.n = false;
        com.facebook.react.modules.core.g.i().o(g.c.DISPATCH_UI, this.f5197f);
        U();
    }

    public void Z(l0 l0Var) {
        this.f5201j.add(0, new t(l0Var));
    }

    public void a0() {
        this.p = true;
        this.r = 0L;
        this.A = 0L;
        this.B = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b0() {
        this.n = true;
        com.facebook.react.modules.core.g.i().m(g.c.DISPATCH_UI, this.f5197f);
    }

    public void c0(com.facebook.react.uimanager.e1.a aVar) {
        this.m = aVar;
    }

    public void y(int i2, View view) {
        this.f5194c.b(i2, view);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v8 */
    public void z(int i2, long j2, long j3) {
        long j4;
        ArrayList<h> arrayList;
        ArrayList<u> arrayList2;
        ArrayDeque<u> arrayDeque;
        com.facebook.systrace.b.a(0L, "UIViewOperationQueue.dispatchViewUpdates").a("batchId", i2).c();
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            long currentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
            j4 = 0;
            ArrayDeque<u> arrayDeque2 = null;
            if (this.f5200i.isEmpty()) {
                arrayList = null;
            } else {
                ArrayList<h> arrayList3 = this.f5200i;
                this.f5200i = new ArrayList<>();
                arrayList = arrayList3;
            }
            if (this.f5201j.isEmpty()) {
                arrayList2 = null;
            } else {
                ArrayList<u> arrayList4 = this.f5201j;
                this.f5201j = new ArrayList<>();
                arrayList2 = arrayList4;
            }
            synchronized (this.f5196e) {
                try {
                    if (!this.f5203l.isEmpty()) {
                        arrayDeque2 = this.f5203l;
                        this.f5203l = new ArrayDeque<>();
                    }
                    arrayDeque = arrayDeque2;
                } catch (Throwable th) {
                    th = th;
                }
            }
            com.facebook.react.uimanager.e1.a aVar = this.m;
            if (aVar != null) {
                aVar.a();
            }
            try {
                a aVar2 = new a(i2, arrayList, arrayDeque, arrayList2, j2, j3, uptimeMillis, currentThreadTimeMillis);
                j4 = 0;
                com.facebook.systrace.b.a(0L, "acquiring mDispatchRunnablesLock").a("batchId", i2).c();
                synchronized (this.f5195d) {
                    com.facebook.systrace.a.g(0L);
                    this.f5202k.add(aVar2);
                }
                if (!this.n) {
                    UiThreadUtil.runOnUiThread(new b(this.f5198g));
                }
                com.facebook.systrace.a.g(0L);
            } catch (Throwable th2) {
                th = th2;
                j4 = 0;
                com.facebook.systrace.a.g(j4);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            j4 = 0;
        }
    }
}