package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.i;
import com.google.android.gms.common.internal.n;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public abstract class c<T extends IInterface> {
    private static final com.google.android.gms.common.d[] a = new com.google.android.gms.common.d[0];

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f6187b = {"service_esmobile", "service_googleme"};
    private boolean A;
    private volatile i0 B;
    protected AtomicInteger C;

    /* renamed from: c  reason: collision with root package name */
    private int f6188c;

    /* renamed from: d  reason: collision with root package name */
    private long f6189d;

    /* renamed from: e  reason: collision with root package name */
    private long f6190e;

    /* renamed from: f  reason: collision with root package name */
    private int f6191f;

    /* renamed from: g  reason: collision with root package name */
    private long f6192g;

    /* renamed from: h  reason: collision with root package name */
    private o0 f6193h;

    /* renamed from: i  reason: collision with root package name */
    private final Context f6194i;

    /* renamed from: j  reason: collision with root package name */
    private final Looper f6195j;

    /* renamed from: k  reason: collision with root package name */
    private final com.google.android.gms.common.internal.i f6196k;

    /* renamed from: l  reason: collision with root package name */
    private final com.google.android.gms.common.f f6197l;
    final Handler m;
    private final Object n;
    private final Object o;
    private p p;
    protected InterfaceC0141c q;
    private T r;
    private final ArrayList<g<?>> s;
    private j t;
    private int u;
    private final a v;
    private final b w;
    private final int x;
    private final String y;
    private com.google.android.gms.common.b z;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public interface a {
        void n(int i2);

        void q(Bundle bundle);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public interface b {
        void p(com.google.android.gms.common.b bVar);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.internal.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0141c {
        void a(com.google.android.gms.common.b bVar);
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    protected class d implements InterfaceC0141c {
        public d() {
        }

        @Override // com.google.android.gms.common.internal.c.InterfaceC0141c
        public void a(com.google.android.gms.common.b bVar) {
            if (!bVar.m1()) {
                if (c.this.w != null) {
                    c.this.w.p(bVar);
                    return;
                }
                return;
            }
            c cVar = c.this;
            cVar.b(null, cVar.A());
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public interface e {
        void a();
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    private abstract class f extends g<Boolean> {

        /* renamed from: d  reason: collision with root package name */
        private final int f6198d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f6199e;

        protected f(int i2, Bundle bundle) {
            super(Boolean.TRUE);
            this.f6198d = i2;
            this.f6199e = bundle;
        }

        @Override // com.google.android.gms.common.internal.c.g
        protected final /* synthetic */ void c(Boolean bool) {
            if (bool == null) {
                c.this.Q(1, null);
                return;
            }
            int i2 = this.f6198d;
            if (i2 == 0) {
                if (g()) {
                    return;
                }
                c.this.Q(1, null);
                f(new com.google.android.gms.common.b(8, null));
            } else if (i2 != 10) {
                c.this.Q(1, null);
                Bundle bundle = this.f6199e;
                f(new com.google.android.gms.common.b(this.f6198d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
            } else {
                c.this.Q(1, null);
                throw new IllegalStateException(String.format("A fatal developer error has occurred. Class name: %s. Start service action: %s. Service Descriptor: %s. ", getClass().getSimpleName(), c.this.q(), c.this.k()));
            }
        }

        @Override // com.google.android.gms.common.internal.c.g
        protected final void d() {
        }

        protected abstract void f(com.google.android.gms.common.b bVar);

        protected abstract boolean g();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public abstract class g<TListener> {
        private TListener a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6201b = false;

        public g(TListener tlistener) {
            this.a = tlistener;
        }

        public final void a() {
            synchronized (this) {
                this.a = null;
            }
        }

        public final void b() {
            a();
            synchronized (c.this.s) {
                c.this.s.remove(this);
            }
        }

        protected abstract void c(TListener tlistener);

        protected abstract void d();

        public final void e() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.a;
                if (this.f6201b) {
                    String valueOf = String.valueOf(this);
                    StringBuilder sb = new StringBuilder(valueOf.length() + 47);
                    sb.append("Callback proxy ");
                    sb.append(valueOf);
                    sb.append(" being reused. This is not safe.");
                    Log.w("GmsClient", sb.toString());
                }
            }
            if (tlistener != null) {
                try {
                    c(tlistener);
                } catch (RuntimeException e2) {
                    d();
                    throw e2;
                }
            } else {
                d();
            }
            synchronized (this) {
                this.f6201b = true;
            }
            b();
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    final class h extends e.g.a.e.d.e.h {
        public h(Looper looper) {
            super(looper);
        }

        private static void a(Message message) {
            g gVar = (g) message.obj;
            gVar.d();
            gVar.b();
        }

        private static boolean b(Message message) {
            int i2 = message.what;
            return i2 == 2 || i2 == 1 || i2 == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            com.google.android.gms.common.b bVar;
            com.google.android.gms.common.b bVar2;
            if (c.this.C.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            int i2 = message.what;
            if ((i2 == 1 || i2 == 7 || ((i2 == 4 && !c.this.t()) || message.what == 5)) && !c.this.d()) {
                a(message);
                return;
            }
            int i3 = message.what;
            if (i3 == 4) {
                c.this.z = new com.google.android.gms.common.b(message.arg2);
                if (!c.this.g0() || c.this.A) {
                    if (c.this.z != null) {
                        bVar2 = c.this.z;
                    } else {
                        bVar2 = new com.google.android.gms.common.b(8);
                    }
                    c.this.q.a(bVar2);
                    c.this.F(bVar2);
                    return;
                }
                c.this.Q(3, null);
            } else if (i3 == 5) {
                if (c.this.z != null) {
                    bVar = c.this.z;
                } else {
                    bVar = new com.google.android.gms.common.b(8);
                }
                c.this.q.a(bVar);
                c.this.F(bVar);
            } else if (i3 == 3) {
                Object obj = message.obj;
                com.google.android.gms.common.b bVar3 = new com.google.android.gms.common.b(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
                c.this.q.a(bVar3);
                c.this.F(bVar3);
            } else if (i3 == 6) {
                c.this.Q(5, null);
                if (c.this.v != null) {
                    c.this.v.n(message.arg2);
                }
                c.this.G(message.arg2);
                c.this.V(5, 1, null);
            } else if (i3 == 2 && !c.this.j()) {
                a(message);
            } else if (b(message)) {
                ((g) message.obj).e();
            } else {
                int i4 = message.what;
                StringBuilder sb = new StringBuilder(45);
                sb.append("Don't know how to handle message: ");
                sb.append(i4);
                Log.wtf("GmsClient", sb.toString(), new Exception());
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public static final class i extends n.a {
        private c a;

        /* renamed from: b  reason: collision with root package name */
        private final int f6203b;

        public i(c cVar, int i2) {
            this.a = cVar;
            this.f6203b = i2;
        }

        @Override // com.google.android.gms.common.internal.n
        public final void X(int i2, Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.n
        public final void Z(int i2, IBinder iBinder, i0 i0Var) {
            t.l(this.a, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            t.k(i0Var);
            this.a.U(i0Var);
            a0(i2, iBinder, i0Var.a);
        }

        @Override // com.google.android.gms.common.internal.n
        public final void a0(int i2, IBinder iBinder, Bundle bundle) {
            t.l(this.a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.a.H(i2, iBinder, bundle, this.f6203b);
            this.a = null;
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public final class j implements ServiceConnection {
        private final int a;

        public j(int i2) {
            this.a = i2;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            p oVar;
            if (iBinder == null) {
                c.this.X(16);
                return;
            }
            synchronized (c.this.o) {
                c cVar = c.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface != null && (queryLocalInterface instanceof p)) {
                    oVar = (p) queryLocalInterface;
                } else {
                    oVar = new o(iBinder);
                }
                cVar.p = oVar;
            }
            c.this.P(0, null, this.a);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (c.this.o) {
                c.this.p = null;
            }
            Handler handler = c.this.m;
            handler.sendMessage(handler.obtainMessage(6, this.a, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public final class k extends f {
        public k(int i2, Bundle bundle) {
            super(i2, null);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(com.google.android.gms.common.b bVar) {
            if (c.this.t() && c.this.g0()) {
                c.this.X(16);
                return;
            }
            c.this.q.a(bVar);
            c.this.F(bVar);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            c.this.q.a(com.google.android.gms.common.b.a);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* loaded from: classes2.dex */
    public final class l extends f {

        /* renamed from: g  reason: collision with root package name */
        private final IBinder f6206g;

        public l(int i2, IBinder iBinder, Bundle bundle) {
            super(i2, bundle);
            this.f6206g = iBinder;
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final void f(com.google.android.gms.common.b bVar) {
            if (c.this.w != null) {
                c.this.w.p(bVar);
            }
            c.this.F(bVar);
        }

        @Override // com.google.android.gms.common.internal.c.f
        protected final boolean g() {
            try {
                String interfaceDescriptor = this.f6206g.getInterfaceDescriptor();
                if (!c.this.k().equals(interfaceDescriptor)) {
                    String k2 = c.this.k();
                    StringBuilder sb = new StringBuilder(String.valueOf(k2).length() + 34 + String.valueOf(interfaceDescriptor).length());
                    sb.append("service descriptor mismatch: ");
                    sb.append(k2);
                    sb.append(" vs. ");
                    sb.append(interfaceDescriptor);
                    Log.e("GmsClient", sb.toString());
                    return false;
                }
                IInterface l2 = c.this.l(this.f6206g);
                if (l2 == null || !(c.this.V(2, 4, l2) || c.this.V(3, 4, l2))) {
                    return false;
                }
                c.this.z = null;
                Bundle w = c.this.w();
                if (c.this.v != null) {
                    c.this.v.q(w);
                    return true;
                }
                return true;
            } catch (RemoteException unused) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, int i2, a aVar, b bVar, String str) {
        this(context, looper, com.google.android.gms.common.internal.i.b(context), com.google.android.gms.common.f.f(), i2, (a) t.k(aVar), (b) t.k(bVar), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(int i2, T t) {
        o0 o0Var;
        o0 o0Var2;
        t.a((i2 == 4) == (t != null));
        synchronized (this.n) {
            this.u = i2;
            this.r = t;
            I(i2, t);
            if (i2 != 1) {
                if (i2 == 2 || i2 == 3) {
                    if (this.t != null && (o0Var2 = this.f6193h) != null) {
                        String d2 = o0Var2.d();
                        String a2 = this.f6193h.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(d2).length() + 70 + String.valueOf(a2).length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(d2);
                        sb.append(" on ");
                        sb.append(a2);
                        Log.e("GmsClient", sb.toString());
                        this.f6196k.d(this.f6193h.d(), this.f6193h.a(), this.f6193h.c(), this.t, e0(), this.f6193h.b());
                        this.C.incrementAndGet();
                    }
                    this.t = new j(this.C.get());
                    if (this.u == 3 && z() != null) {
                        o0Var = new o0(x().getPackageName(), z(), true, 129, false);
                    } else {
                        o0Var = new o0(C(), q(), false, 129, D());
                    }
                    this.f6193h = o0Var;
                    if (o0Var.b() && n() < 17895000) {
                        String valueOf = String.valueOf(this.f6193h.d());
                        throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                    }
                    if (!this.f6196k.e(new i.a(this.f6193h.d(), this.f6193h.a(), this.f6193h.c(), this.f6193h.b()), this.t, e0())) {
                        String d3 = this.f6193h.d();
                        String a3 = this.f6193h.a();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(d3).length() + 34 + String.valueOf(a3).length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(d3);
                        sb2.append(" on ");
                        sb2.append(a3);
                        Log.e("GmsClient", sb2.toString());
                        P(16, null, this.C.get());
                    }
                } else if (i2 == 4) {
                    E(t);
                }
            } else if (this.t != null) {
                this.f6196k.d(this.f6193h.d(), this.f6193h.a(), this.f6193h.c(), this.t, e0(), this.f6193h.b());
                this.t = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U(i0 i0Var) {
        this.B = i0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean V(int i2, int i3, T t) {
        synchronized (this.n) {
            if (this.u != i2) {
                return false;
            }
            Q(i3, t);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int i2) {
        int i3;
        if (f0()) {
            i3 = 5;
            this.A = true;
        } else {
            i3 = 4;
        }
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(i3, this.C.get(), 16));
    }

    private final String e0() {
        String str = this.y;
        return str == null ? this.f6194i.getClass().getName() : str;
    }

    private final boolean f0() {
        boolean z;
        synchronized (this.n) {
            z = this.u == 3;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean g0() {
        if (this.A || TextUtils.isEmpty(k()) || TextUtils.isEmpty(z())) {
            return false;
        }
        try {
            Class.forName(k());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    protected Set<Scope> A() {
        return Collections.EMPTY_SET;
    }

    public final T B() throws DeadObjectException {
        T t;
        synchronized (this.n) {
            if (this.u != 5) {
                s();
                t.o(this.r != null, "Client is connected but service is null");
                t = this.r;
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    protected String C() {
        return "com.google.android.gms";
    }

    protected boolean D() {
        return false;
    }

    protected void E(T t) {
        this.f6190e = System.currentTimeMillis();
    }

    protected void F(com.google.android.gms.common.b bVar) {
        this.f6191f = bVar.i1();
        this.f6192g = System.currentTimeMillis();
    }

    protected void G(int i2) {
        this.f6188c = i2;
        this.f6189d = System.currentTimeMillis();
    }

    protected void H(int i2, IBinder iBinder, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(1, i3, -1, new l(i2, iBinder, bundle)));
    }

    void I(int i2, T t) {
    }

    public boolean J() {
        return false;
    }

    public void K(int i2) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(6, this.C.get(), i2));
    }

    protected void L(InterfaceC0141c interfaceC0141c, int i2, PendingIntent pendingIntent) {
        this.q = (InterfaceC0141c) t.l(interfaceC0141c, "Connection progress callbacks cannot be null.");
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(3, this.C.get(), i2, pendingIntent));
    }

    protected final void P(int i2, Bundle bundle, int i3) {
        Handler handler = this.m;
        handler.sendMessage(handler.obtainMessage(7, i3, -1, new k(i2, null)));
    }

    public void b(com.google.android.gms.common.internal.l lVar, Set<Scope> set) {
        Bundle y = y();
        com.google.android.gms.common.internal.g gVar = new com.google.android.gms.common.internal.g(this.x);
        gVar.f6231d = this.f6194i.getPackageName();
        gVar.f6234g = y;
        if (set != null) {
            gVar.f6233f = (Scope[]) set.toArray(new Scope[set.size()]);
        }
        if (p()) {
            gVar.f6235h = u() != null ? u() : new Account("<<default account>>", "com.google");
            if (lVar != null) {
                gVar.f6232e = lVar.asBinder();
            }
        } else if (J()) {
            gVar.f6235h = u();
        }
        gVar.f6236j = a;
        gVar.f6237k = v();
        try {
            synchronized (this.o) {
                p pVar = this.p;
                if (pVar != null) {
                    pVar.H(new i(this, this.C.get()), gVar);
                } else {
                    Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                }
            }
        } catch (DeadObjectException e2) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e2);
            K(1);
        } catch (RemoteException e3) {
            e = e3;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            H(8, null, null, this.C.get());
        } catch (SecurityException e4) {
            throw e4;
        } catch (RuntimeException e5) {
            e = e5;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            H(8, null, null, this.C.get());
        }
    }

    public boolean d() {
        boolean z;
        synchronized (this.n) {
            int i2 = this.u;
            z = i2 == 2 || i2 == 3;
        }
        return z;
    }

    public void disconnect() {
        this.C.incrementAndGet();
        synchronized (this.s) {
            int size = this.s.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.s.get(i2).a();
            }
            this.s.clear();
        }
        synchronized (this.o) {
            this.p = null;
        }
        Q(1, null);
    }

    public String e() {
        o0 o0Var;
        if (j() && (o0Var = this.f6193h) != null) {
            return o0Var.a();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    public void f(InterfaceC0141c interfaceC0141c) {
        this.q = (InterfaceC0141c) t.l(interfaceC0141c, "Connection progress callbacks cannot be null.");
        Q(2, null);
    }

    public void i(e eVar) {
        eVar.a();
    }

    public boolean j() {
        boolean z;
        synchronized (this.n) {
            z = this.u == 4;
        }
        return z;
    }

    protected abstract String k();

    protected abstract T l(IBinder iBinder);

    public boolean m() {
        return true;
    }

    public int n() {
        return com.google.android.gms.common.f.a;
    }

    public final com.google.android.gms.common.d[] o() {
        i0 i0Var = this.B;
        if (i0Var == null) {
            return null;
        }
        return i0Var.f6245b;
    }

    public boolean p() {
        return false;
    }

    protected abstract String q();

    public void r() {
        int h2 = this.f6197l.h(this.f6194i, n());
        if (h2 != 0) {
            Q(1, null);
            L(new d(), h2, null);
            return;
        }
        f(new d());
    }

    protected final void s() {
        if (!j()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    protected boolean t() {
        return false;
    }

    public Account u() {
        return null;
    }

    public com.google.android.gms.common.d[] v() {
        return a;
    }

    public Bundle w() {
        return null;
    }

    public final Context x() {
        return this.f6194i;
    }

    protected Bundle y() {
        return new Bundle();
    }

    protected String z() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, Looper looper, com.google.android.gms.common.internal.i iVar, com.google.android.gms.common.f fVar, int i2, a aVar, b bVar, String str) {
        this.n = new Object();
        this.o = new Object();
        this.s = new ArrayList<>();
        this.u = 1;
        this.z = null;
        this.A = false;
        this.B = null;
        this.C = new AtomicInteger(0);
        this.f6194i = (Context) t.l(context, "Context must not be null");
        this.f6195j = (Looper) t.l(looper, "Looper must not be null");
        this.f6196k = (com.google.android.gms.common.internal.i) t.l(iVar, "Supervisor must not be null");
        this.f6197l = (com.google.android.gms.common.f) t.l(fVar, "API availability must not be null");
        this.m = new h(looper);
        this.x = i2;
        this.v = aVar;
        this.w = bVar;
        this.y = str;
    }
}