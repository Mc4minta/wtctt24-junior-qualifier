package com.facebook.react.animated;

import com.facebook.fbreact.specs.NativeAnimatedModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.g;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.r0;
import java.util.ArrayList;
import java.util.Iterator;

@e.f.m.x.a.a(name = NativeAnimatedModule.NAME)
/* loaded from: classes2.dex */
public class NativeAnimatedModule extends NativeAnimatedModuleSpec implements LifecycleEventListener, r0 {
    public static final String NAME = "NativeAnimatedModule";
    private final com.facebook.react.uimanager.e mAnimatedFrameCallback;
    private com.facebook.react.animated.l mNodesManager;
    private ArrayList<v> mOperations;
    private ArrayList<v> mPreOperations;
    private final com.facebook.react.modules.core.g mReactChoreographer;

    /* loaded from: classes2.dex */
    class a implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f4668b;

        a(int i2, double d2) {
            this.a = i2;
            this.f4668b = d2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.r(this.a, this.f4668b);
        }
    }

    /* loaded from: classes2.dex */
    class b implements v {
        final /* synthetic */ int a;

        b(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.k(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class c implements v {
        final /* synthetic */ int a;

        c(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.j(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class d implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4672b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReadableMap f4673c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Callback f4674d;

        d(int i2, int i3, ReadableMap readableMap, Callback callback) {
            this.a = i2;
            this.f4672b = i3;
            this.f4673c = readableMap;
            this.f4674d = callback;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.t(this.a, this.f4672b, this.f4673c, this.f4674d);
        }
    }

    /* loaded from: classes2.dex */
    class e implements v {
        final /* synthetic */ int a;

        e(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.v(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class f implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4677b;

        f(int i2, int i3) {
            this.a = i2;
            this.f4677b = i3;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.e(this.a, this.f4677b);
        }
    }

    /* loaded from: classes2.dex */
    class g implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4679b;

        g(int i2, int i3) {
            this.a = i2;
            this.f4679b = i3;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.h(this.a, this.f4679b);
        }
    }

    /* loaded from: classes2.dex */
    class h implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4681b;

        h(int i2, int i3) {
            this.a = i2;
            this.f4681b = i3;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.d(this.a, this.f4681b);
        }
    }

    /* loaded from: classes2.dex */
    class i implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4683b;

        i(int i2, int i3) {
            this.a = i2;
            this.f4683b = i3;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.g(this.a, this.f4683b);
        }
    }

    /* loaded from: classes2.dex */
    class j implements v {
        final /* synthetic */ int a;

        j(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.p(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class k extends com.facebook.react.uimanager.e {
        k(ReactContext reactContext) {
            super(reactContext);
        }

        @Override // com.facebook.react.uimanager.e
        protected void c(long j2) {
            try {
                com.facebook.react.animated.l nodesManager = NativeAnimatedModule.this.getNodesManager();
                if (nodesManager.n()) {
                    nodesManager.q(j2);
                }
                ((com.facebook.react.modules.core.g) e.f.k.a.a.c(NativeAnimatedModule.this.mReactChoreographer)).m(g.c.NATIVE_ANIMATED_MODULE, NativeAnimatedModule.this.mAnimatedFrameCallback);
            } catch (Exception e2) {
                e.f.d.d.a.j("ReactNative", "Exception while executing animated frame callback.", e2);
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: classes2.dex */
    class l implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4687b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReadableMap f4688c;

        l(int i2, String str, ReadableMap readableMap) {
            this.a = i2;
            this.f4687b = str;
            this.f4688c = readableMap;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.c(this.a, this.f4687b, this.f4688c);
        }
    }

    /* loaded from: classes2.dex */
    class m implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4690b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f4691c;

        m(int i2, String str, int i3) {
            this.a = i2;
            this.f4690b = str;
            this.f4691c = i3;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.o(this.a, this.f4690b, this.f4691c);
        }
    }

    /* loaded from: classes2.dex */
    class n implements l0 {
        final /* synthetic */ ArrayList a;

        n(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            com.facebook.react.animated.l nodesManager = NativeAnimatedModule.this.getNodesManager();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a(nodesManager);
            }
        }
    }

    /* loaded from: classes2.dex */
    class o implements l0 {
        final /* synthetic */ ArrayList a;

        o(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            com.facebook.react.animated.l nodesManager = NativeAnimatedModule.this.getNodesManager();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((v) it.next()).a(nodesManager);
            }
        }
    }

    /* loaded from: classes2.dex */
    class p implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f4695b;

        p(int i2, ReadableMap readableMap) {
            this.a = i2;
            this.f4695b = readableMap;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.f(this.a, this.f4695b);
        }
    }

    /* loaded from: classes2.dex */
    class q implements com.facebook.react.animated.c {
        final /* synthetic */ int a;

        q(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.c
        public void a(double d2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("tag", this.a);
            createMap.putDouble("value", d2);
            ReactApplicationContext reactApplicationContextIfActiveOrWarn = NativeAnimatedModule.this.getReactApplicationContextIfActiveOrWarn();
            if (reactApplicationContextIfActiveOrWarn != null) {
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContextIfActiveOrWarn.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("onAnimatedValueUpdate", createMap);
            }
        }
    }

    /* loaded from: classes2.dex */
    class r implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ com.facebook.react.animated.c f4698b;

        r(int i2, com.facebook.react.animated.c cVar) {
            this.a = i2;
            this.f4698b = cVar;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.u(this.a, this.f4698b);
        }
    }

    /* loaded from: classes2.dex */
    class s implements v {
        final /* synthetic */ int a;

        s(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.x(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class t implements v {
        final /* synthetic */ int a;

        t(int i2) {
            this.a = i2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.i(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class u implements v {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f4702b;

        u(int i2, double d2) {
            this.a = i2;
            this.f4702b = d2;
        }

        @Override // com.facebook.react.animated.NativeAnimatedModule.v
        public void a(com.facebook.react.animated.l lVar) {
            lVar.s(this.a, this.f4702b);
        }
    }

    /* loaded from: classes2.dex */
    private interface v {
        void a(com.facebook.react.animated.l lVar);
    }

    public NativeAnimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mOperations = new ArrayList<>();
        this.mPreOperations = new ArrayList<>();
        this.mReactChoreographer = com.facebook.react.modules.core.g.i();
        this.mAnimatedFrameCallback = new k(reactApplicationContext);
    }

    private void clearFrameCallback() {
        ((com.facebook.react.modules.core.g) e.f.k.a.a.c(this.mReactChoreographer)).o(g.c.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    private void enqueueFrameCallback() {
        ((com.facebook.react.modules.core.g) e.f.k.a.a.c(this.mReactChoreographer)).m(g.c.NATIVE_ANIMATED_MODULE, this.mAnimatedFrameCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.facebook.react.animated.l getNodesManager() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn;
        if (this.mNodesManager == null && (reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn()) != null) {
            this.mNodesManager = new com.facebook.react.animated.l((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class));
        }
        return this.mNodesManager;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addAnimatedEventToView(double d2, String str, ReadableMap readableMap) {
        this.mOperations.add(new l((int) d2, str, readableMap));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodeToView(double d2, double d3) {
        this.mOperations.add(new h((int) d2, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void connectAnimatedNodes(double d2, double d3) {
        this.mOperations.add(new f((int) d2, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void createAnimatedNode(double d2, ReadableMap readableMap) {
        this.mOperations.add(new p((int) d2, readableMap));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodeFromView(double d2, double d3) {
        this.mOperations.add(new i((int) d2, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void disconnectAnimatedNodes(double d2, double d3) {
        this.mOperations.add(new g((int) d2, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void dropAnimatedNode(double d2) {
        this.mOperations.add(new t((int) d2));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void extractAnimatedNodeOffset(double d2) {
        this.mOperations.add(new c((int) d2));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void flattenAnimatedNodeOffset(double d2) {
        this.mOperations.add(new b((int) d2));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        ReactApplicationContext reactApplicationContextIfActiveOrWarn = getReactApplicationContextIfActiveOrWarn();
        if (reactApplicationContextIfActiveOrWarn == null || reactApplicationContextIfActiveOrWarn.isBridgeless()) {
            return;
        }
        reactApplicationContextIfActiveOrWarn.addLifecycleEventListener(this);
        ((UIManagerModule) reactApplicationContextIfActiveOrWarn.getNativeModule(UIManagerModule.class)).addUIManagerListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        clearFrameCallback();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        enqueueFrameCallback();
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeAnimatedEventFromView(double d2, String str, double d3) {
        this.mOperations.add(new m((int) d2, str, (int) d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void restoreDefaultValues(double d2) {
        this.mPreOperations.add(new j((int) d2));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeOffset(double d2, double d3) {
        this.mOperations.add(new a((int) d2, d3));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void setAnimatedNodeValue(double d2, double d3) {
        this.mOperations.add(new u((int) d2, d3));
    }

    public void setNodesManager(com.facebook.react.animated.l lVar) {
        this.mNodesManager = lVar;
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startAnimatingNode(double d2, double d3, ReadableMap readableMap, Callback callback) {
        this.mOperations.add(new d((int) d2, (int) d3, readableMap, callback));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void startListeningToAnimatedNodeValue(double d2) {
        int i2 = (int) d2;
        this.mOperations.add(new r(i2, new q(i2)));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopAnimation(double d2) {
        this.mOperations.add(new e((int) d2));
    }

    @Override // com.facebook.fbreact.specs.NativeAnimatedModuleSpec
    public void stopListeningToAnimatedNodeValue(double d2) {
        this.mOperations.add(new s((int) d2));
    }

    @Override // com.facebook.react.uimanager.r0
    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (this.mOperations.isEmpty() && this.mPreOperations.isEmpty()) {
            return;
        }
        ArrayList<v> arrayList = this.mPreOperations;
        ArrayList<v> arrayList2 = this.mOperations;
        this.mPreOperations = new ArrayList<>();
        this.mOperations = new ArrayList<>();
        uIManagerModule.prependUIBlock(new n(arrayList));
        uIManagerModule.addUIBlock(new o(arrayList2));
    }
}