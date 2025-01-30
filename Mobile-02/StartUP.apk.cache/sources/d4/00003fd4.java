package com.swmansion.reanimated;

import android.util.SparseArray;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.g;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.m0;
import com.facebook.react.uimanager.s0;
import com.facebook.react.uimanager.y;
import com.swmansion.reanimated.nodes.EventNode;
import com.swmansion.reanimated.nodes.f;
import com.swmansion.reanimated.nodes.h;
import com.swmansion.reanimated.nodes.i;
import com.swmansion.reanimated.nodes.k;
import com.swmansion.reanimated.nodes.l;
import com.swmansion.reanimated.nodes.m;
import com.swmansion.reanimated.nodes.n;
import com.swmansion.reanimated.nodes.o;
import com.swmansion.reanimated.nodes.p;
import com.swmansion.reanimated.nodes.q;
import com.swmansion.reanimated.nodes.r;
import com.swmansion.reanimated.nodes.s;
import com.swmansion.reanimated.nodes.t;
import com.swmansion.reanimated.nodes.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: NodesManager.java */
/* loaded from: classes2.dex */
public class b implements com.facebook.react.uimanager.events.e {
    private static final Double a = Double.valueOf(0.0d);

    /* renamed from: d  reason: collision with root package name */
    private final m0 f10945d;

    /* renamed from: e  reason: collision with root package name */
    private final DeviceEventManagerModule.RCTDeviceEventEmitter f10946e;

    /* renamed from: f  reason: collision with root package name */
    private final g f10947f;

    /* renamed from: g  reason: collision with root package name */
    private final com.facebook.react.uimanager.e f10948g;

    /* renamed from: h  reason: collision with root package name */
    private final UIManagerModule.e f10949h;

    /* renamed from: j  reason: collision with root package name */
    private final n f10951j;

    /* renamed from: k  reason: collision with root package name */
    private final ReactContext f10952k;

    /* renamed from: l  reason: collision with root package name */
    private final UIManagerModule f10953l;
    private boolean o;
    public double p;
    public final com.swmansion.reanimated.d q;

    /* renamed from: b  reason: collision with root package name */
    private final SparseArray<m> f10943b = new SparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, EventNode> f10944c = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final AtomicBoolean f10950i = new AtomicBoolean();
    private List<d> m = new ArrayList();
    private ConcurrentLinkedQueue<com.facebook.react.uimanager.events.c> n = new ConcurrentLinkedQueue<>();
    public Set<String> r = Collections.emptySet();
    public Set<String> s = Collections.emptySet();
    private Queue<c> t = new LinkedList();

    /* compiled from: NodesManager.java */
    /* loaded from: classes2.dex */
    class a extends com.facebook.react.uimanager.e {
        a(ReactContext reactContext) {
            super(reactContext);
        }

        @Override // com.facebook.react.uimanager.e
        protected void c(long j2) {
            b.this.s(j2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NodesManager.java */
    /* renamed from: com.swmansion.reanimated.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0235b extends GuardedRunnable {
        final /* synthetic */ Queue a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0235b(ReactContext reactContext, Queue queue) {
            super(reactContext);
            this.a = queue;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        public void runGuarded() {
            boolean a = s0.a(b.this.f10945d);
            while (!this.a.isEmpty()) {
                c cVar = (c) this.a.remove();
                y Q = b.this.f10945d.Q(cVar.a);
                if (Q != null) {
                    b.this.f10953l.updateView(cVar.a, Q.L(), cVar.f10956b);
                }
            }
            if (a) {
                b.this.f10945d.n(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: NodesManager.java */
    /* loaded from: classes2.dex */
    public final class c {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public WritableMap f10956b;

        public c(int i2, WritableMap writableMap) {
            this.a = i2;
            this.f10956b = writableMap;
        }
    }

    /* compiled from: NodesManager.java */
    /* loaded from: classes2.dex */
    public interface d {
        void b();
    }

    public b(ReactContext reactContext) {
        this.f10952k = reactContext;
        UIManagerModule uIManagerModule = (UIManagerModule) reactContext.getNativeModule(UIManagerModule.class);
        this.f10953l = uIManagerModule;
        this.q = new com.swmansion.reanimated.d();
        this.f10945d = uIManagerModule.getUIImplementation();
        this.f10949h = uIManagerModule.getDirectEventNamesResolver();
        this.f10946e = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
        this.f10947f = g.i();
        this.f10948g = new a(reactContext);
        this.f10951j = new n(this);
        uIManagerModule.getEventDispatcher().s(this);
    }

    private void A() {
        if (this.f10950i.getAndSet(false)) {
            this.f10947f.o(g.c.NATIVE_ANIMATED_MODULE, this.f10948g);
        }
    }

    private void r(com.facebook.react.uimanager.events.c cVar) {
        if (this.f10944c.isEmpty()) {
            return;
        }
        String a2 = this.f10949h.a(cVar.f());
        int i2 = cVar.i();
        EventNode eventNode = this.f10944c.get(i2 + a2);
        if (eventNode != null) {
            cVar.c(eventNode);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(long j2) {
        this.p = j2 / 1000000.0d;
        while (!this.n.isEmpty()) {
            r(this.n.poll());
        }
        if (!this.m.isEmpty()) {
            List<d> list = this.m;
            this.m = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.get(i2).b();
            }
        }
        if (this.o) {
            m.runUpdates(this.q);
        }
        if (!this.t.isEmpty()) {
            Queue<c> queue = this.t;
            this.t = new LinkedList();
            ReactContext reactContext = this.f10952k;
            reactContext.runOnNativeModulesQueueThread(new C0235b(reactContext, queue));
        }
        this.f10950i.set(false);
        this.o = false;
        if (this.m.isEmpty() && this.n.isEmpty()) {
            return;
        }
        z();
    }

    private void z() {
        if (this.f10950i.getAndSet(true)) {
            return;
        }
        this.f10947f.m(g.c.NATIVE_ANIMATED_MODULE, this.f10948g);
    }

    @Override // com.facebook.react.uimanager.events.e
    public void a(com.facebook.react.uimanager.events.c cVar) {
        if (UiThreadUtil.isOnUiThread()) {
            r(cVar);
            return;
        }
        this.n.offer(cVar);
        z();
    }

    public void e(int i2, String str, int i3) {
        String str2 = i2 + str;
        EventNode eventNode = (EventNode) this.f10943b.get(i3);
        if (eventNode != null) {
            if (!this.f10944c.containsKey(str2)) {
                this.f10944c.put(str2, eventNode);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Event handler already set for the given view and event type");
        }
        throw new JSApplicationIllegalArgumentException("Event node " + i3 + " does not exists");
    }

    public void f(Set<String> set, Set<String> set2) {
        this.s = set;
        this.r = set2;
    }

    public void g(int i2, int i3) {
        m mVar = this.f10943b.get(i2);
        if (mVar != null) {
            if (mVar instanceof q) {
                ((q) mVar).d(i3);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + q.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
    }

    public void h(int i2, int i3) {
        m mVar = this.f10943b.get(i2);
        m mVar2 = this.f10943b.get(i3);
        if (mVar2 != null) {
            mVar.addChild(mVar2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i3 + " does not exists");
    }

    public void i(int i2, ReadableMap readableMap) {
        m dVar;
        if (this.f10943b.get(i2) == null) {
            String string = readableMap.getString("type");
            if ("props".equals(string)) {
                dVar = new q(i2, readableMap, this, this.f10945d);
            } else if ("style".equals(string)) {
                dVar = new s(i2, readableMap, this);
            } else if ("transform".equals(string)) {
                dVar = new t(i2, readableMap, this);
            } else if ("value".equals(string)) {
                dVar = new u(i2, readableMap, this);
            } else if ("block".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.c(i2, readableMap, this);
            } else if ("cond".equals(string)) {
                dVar = new h(i2, readableMap, this);
            } else if ("op".equals(string)) {
                dVar = new o(i2, readableMap, this);
            } else if ("set".equals(string)) {
                dVar = new r(i2, readableMap, this);
            } else if ("debug".equals(string)) {
                dVar = new i(i2, readableMap, this);
            } else if ("clock".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.e(i2, readableMap, this);
            } else if ("clockStart".equals(string)) {
                dVar = new f.a(i2, readableMap, this);
            } else if ("clockStop".equals(string)) {
                dVar = new f.b(i2, readableMap, this);
            } else if ("clockTest".equals(string)) {
                dVar = new f.c(i2, readableMap, this);
            } else if ("call".equals(string)) {
                dVar = new l(i2, readableMap, this);
            } else if ("bezier".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.b(i2, readableMap, this);
            } else if ("event".equals(string)) {
                dVar = new EventNode(i2, readableMap, this);
            } else if ("always".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.a(i2, readableMap, this);
            } else if ("concat".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.g(i2, readableMap, this);
            } else if ("param".equals(string)) {
                dVar = new p(i2, readableMap, this);
            } else if ("func".equals(string)) {
                dVar = new k(i2, readableMap, this);
            } else if ("callfunc".equals(string)) {
                dVar = new com.swmansion.reanimated.nodes.d(i2, readableMap, this);
            } else {
                throw new JSApplicationIllegalArgumentException("Unsupported node type: " + string);
            }
            this.f10943b.put(i2, dVar);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " already exists");
    }

    public void j(int i2, String str, int i3) {
        this.f10944c.remove(i2 + str);
    }

    public void k(int i2, int i3) {
        m mVar = this.f10943b.get(i2);
        if (mVar != null) {
            if (mVar instanceof q) {
                ((q) mVar).e(i3);
                return;
            }
            throw new JSApplicationIllegalArgumentException("Animated node connected to view should beof type " + q.class.getName());
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i2 + " does not exists");
    }

    public void l(int i2, int i3) {
        m mVar = this.f10943b.get(i2);
        m mVar2 = this.f10943b.get(i3);
        if (mVar2 != null) {
            mVar.removeChild(mVar2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Animated node with ID " + i3 + " does not exists");
    }

    public void m(int i2) {
        this.f10943b.remove(i2);
    }

    public void n(int i2, WritableMap writableMap) {
        this.t.add(new c(i2, writableMap));
    }

    public <T extends m> T o(int i2, Class<T> cls) {
        T t = (T) this.f10943b.get(i2);
        if (t == null) {
            if (cls != m.class && cls != u.class) {
                throw new IllegalArgumentException("Requested node with id " + i2 + " of type " + cls + " cannot be found");
            }
            return this.f10951j;
        } else if (cls.isInstance(t)) {
            return t;
        } else {
            throw new IllegalArgumentException("Node with id " + i2 + " is of incompatible type " + t.getClass() + ", requested type was " + cls);
        }
    }

    public Object p(int i2) {
        m mVar = this.f10943b.get(i2);
        if (mVar != null) {
            return mVar.value();
        }
        return a;
    }

    public void q(int i2, Callback callback) {
        callback.invoke(this.f10943b.get(i2).value());
    }

    public void t() {
        if (this.f10950i.get()) {
            A();
            this.f10950i.set(true);
        }
    }

    public void u() {
        if (this.f10950i.getAndSet(false)) {
            z();
        }
    }

    public void v(d dVar) {
        this.m.add(dVar);
        z();
    }

    public void w() {
        this.o = true;
        z();
    }

    public void x(String str, WritableMap writableMap) {
        this.f10946e.emit(str, writableMap);
    }

    public void y(int i2, Double d2) {
        m mVar = this.f10943b.get(i2);
        if (mVar != null) {
            ((u) mVar).c(d2);
        }
    }
}