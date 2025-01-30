package com.swmansion.reanimated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.l0;
import com.facebook.react.uimanager.r0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@e.f.m.x.a.a(name = ReanimatedModule.NAME)
/* loaded from: classes2.dex */
public class ReanimatedModule extends ReactContextBaseJavaModule implements LifecycleEventListener, r0 {
    public static final String NAME = "ReanimatedModule";
    private com.swmansion.reanimated.b mNodesManager;
    private ArrayList<m> mOperations;
    private com.swmansion.reanimated.f.c mTransitionManager;

    /* loaded from: classes2.dex */
    class a implements m {
        final /* synthetic */ Set a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f10919b;

        a(Set set, Set set2) {
            this.a = set;
            this.f10919b = set2;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.f(this.a, this.f10919b);
        }
    }

    /* loaded from: classes2.dex */
    class b implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Callback f10921b;

        b(int i2, Callback callback) {
            this.a = i2;
            this.f10921b = callback;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.q(this.a, this.f10921b);
        }
    }

    /* loaded from: classes2.dex */
    class c implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Double f10923b;

        c(int i2, Double d2) {
            this.a = i2;
            this.f10923b = d2;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.y(this.a, this.f10923b);
        }
    }

    /* loaded from: classes2.dex */
    class d implements l0 {
        final /* synthetic */ ArrayList a;

        d(ArrayList arrayList) {
            this.a = arrayList;
        }

        @Override // com.facebook.react.uimanager.l0
        public void a(com.facebook.react.uimanager.l lVar) {
            com.swmansion.reanimated.b nodesManager = ReanimatedModule.this.getNodesManager();
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((m) it.next()).a(nodesManager);
            }
        }
    }

    /* loaded from: classes2.dex */
    class e implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10926b;

        e(int i2, ReadableMap readableMap) {
            this.a = i2;
            this.f10926b = readableMap;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.i(this.a, this.f10926b);
        }
    }

    /* loaded from: classes2.dex */
    class f implements m {
        final /* synthetic */ int a;

        f(int i2) {
            this.a = i2;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.m(this.a);
        }
    }

    /* loaded from: classes2.dex */
    class g implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10929b;

        g(int i2, int i3) {
            this.a = i2;
            this.f10929b = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.h(this.a, this.f10929b);
        }
    }

    /* loaded from: classes2.dex */
    class h implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10931b;

        h(int i2, int i3) {
            this.a = i2;
            this.f10931b = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.l(this.a, this.f10931b);
        }
    }

    /* loaded from: classes2.dex */
    class i implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10933b;

        i(int i2, int i3) {
            this.a = i2;
            this.f10933b = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.g(this.a, this.f10933b);
        }
    }

    /* loaded from: classes2.dex */
    class j implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f10935b;

        j(int i2, int i3) {
            this.a = i2;
            this.f10935b = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.k(this.a, this.f10935b);
        }
    }

    /* loaded from: classes2.dex */
    class k implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10937b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10938c;

        k(int i2, String str, int i3) {
            this.a = i2;
            this.f10937b = str;
            this.f10938c = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.e(this.a, this.f10937b, this.f10938c);
        }
    }

    /* loaded from: classes2.dex */
    class l implements m {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f10940b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f10941c;

        l(int i2, String str, int i3) {
            this.a = i2;
            this.f10940b = str;
            this.f10941c = i3;
        }

        @Override // com.swmansion.reanimated.ReanimatedModule.m
        public void a(com.swmansion.reanimated.b bVar) {
            bVar.j(this.a, this.f10940b, this.f10941c);
        }
    }

    /* loaded from: classes2.dex */
    private interface m {
        void a(com.swmansion.reanimated.b bVar);
    }

    public ReanimatedModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mOperations = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.swmansion.reanimated.b getNodesManager() {
        if (this.mNodesManager == null) {
            this.mNodesManager = new com.swmansion.reanimated.b(getReactApplicationContext());
        }
        return this.mNodesManager;
    }

    @ReactMethod
    public void animateNextTransition(int i2, ReadableMap readableMap) {
        this.mTransitionManager.a(i2, readableMap);
    }

    @ReactMethod
    public void attachEvent(int i2, String str, int i3) {
        this.mOperations.add(new k(i2, str, i3));
    }

    @ReactMethod
    public void configureProps(ReadableArray readableArray, ReadableArray readableArray2) {
        int size = readableArray.size();
        HashSet hashSet = new HashSet(size);
        for (int i2 = 0; i2 < size; i2++) {
            hashSet.add(readableArray.getString(i2));
        }
        int size2 = readableArray2.size();
        HashSet hashSet2 = new HashSet(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            hashSet2.add(readableArray2.getString(i3));
        }
        this.mOperations.add(new a(hashSet, hashSet2));
    }

    @ReactMethod
    public void connectNodeToView(int i2, int i3) {
        this.mOperations.add(new i(i2, i3));
    }

    @ReactMethod
    public void connectNodes(int i2, int i3) {
        this.mOperations.add(new g(i2, i3));
    }

    @ReactMethod
    public void createNode(int i2, ReadableMap readableMap) {
        this.mOperations.add(new e(i2, readableMap));
    }

    @ReactMethod
    public void detachEvent(int i2, String str, int i3) {
        this.mOperations.add(new l(i2, str, i3));
    }

    @ReactMethod
    public void disconnectNodeFromView(int i2, int i3) {
        this.mOperations.add(new j(i2, i3));
    }

    @ReactMethod
    public void disconnectNodes(int i2, int i3) {
        this.mOperations.add(new h(i2, i3));
    }

    @ReactMethod
    public void dropNode(int i2) {
        this.mOperations.add(new f(i2));
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @ReactMethod
    public void getValue(int i2, Callback callback) {
        this.mOperations.add(new b(i2, callback));
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        UIManagerModule uIManagerModule = (UIManagerModule) reactApplicationContext.getNativeModule(UIManagerModule.class);
        reactApplicationContext.addLifecycleEventListener(this);
        uIManagerModule.addUIManagerListener(this);
        this.mTransitionManager = new com.swmansion.reanimated.f.c(uIManagerModule);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        com.swmansion.reanimated.b bVar = this.mNodesManager;
        if (bVar != null) {
            bVar.t();
        }
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        com.swmansion.reanimated.b bVar = this.mNodesManager;
        if (bVar != null) {
            bVar.u();
        }
    }

    @ReactMethod
    public void setValue(int i2, Double d2) {
        this.mOperations.add(new c(i2, d2));
    }

    @Override // com.facebook.react.uimanager.r0
    public void willDispatchViewUpdates(UIManagerModule uIManagerModule) {
        if (this.mOperations.isEmpty()) {
            return;
        }
        ArrayList<m> arrayList = this.mOperations;
        this.mOperations = new ArrayList<>();
        uIManagerModule.addUIBlock(new d(arrayList));
    }
}