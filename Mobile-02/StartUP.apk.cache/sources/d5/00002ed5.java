package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@e.f.m.x.a.a(name = UIManagerModule.NAME)
/* loaded from: classes2.dex */
public class UIManagerModule extends ReactContextBaseJavaModule implements OnBatchCompleteListener, LifecycleEventListener, UIManager {
    private static final boolean DEBUG = e.f.f.b.c.a().a(e.f.f.c.a.f12130f);
    public static final String NAME = "UIManager";
    private int mBatchId;
    private final Map<String, Object> mCustomDirectEvents;
    private final com.facebook.react.uimanager.events.d mEventDispatcher;
    private final List<r0> mListeners;
    private final f mMemoryTrimCallback;
    private final Map<String, Object> mModuleConstants;
    private final m0 mUIImplementation;
    private Map<String, WritableMap> mViewManagerConstantsCache;
    private volatile int mViewManagerConstantsCacheSize;
    private final y0 mViewManagerRegistry;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements e {
        a() {
        }

        @Override // com.facebook.react.uimanager.UIManagerModule.e
        public String a(String str) {
            Map map = (Map) UIManagerModule.this.mCustomDirectEvents.get(str);
            return map != null ? (String) map.get("registrationName") : str;
        }
    }

    /* loaded from: classes2.dex */
    class b extends GuardedRunnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f5036b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(ReactContext reactContext, int i2, Object obj) {
            super(reactContext);
            this.a = i2;
            this.f5036b = obj;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        public void runGuarded() {
            UIManagerModule.this.mUIImplementation.X(this.a, this.f5036b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class c implements Runnable {
        final /* synthetic */ UIManager a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ReadableMap f5039c;

        c(UIManager uIManager, int i2, ReadableMap readableMap) {
            this.a = uIManager;
            this.f5038b = i2;
            this.f5039c = readableMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.synchronouslyUpdateViewOnUIThread(this.f5038b, this.f5039c);
        }
    }

    /* loaded from: classes2.dex */
    class d extends GuardedRunnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f5041b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f5042c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ReactContext reactContext, int i2, int i3, int i4) {
            super(reactContext);
            this.a = i2;
            this.f5041b = i3;
            this.f5042c = i4;
        }

        @Override // com.facebook.react.bridge.GuardedRunnable
        public void runGuarded() {
            UIManagerModule.this.mUIImplementation.b0(this.a, this.f5041b, this.f5042c);
            UIManagerModule.this.mUIImplementation.n(-1);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        String a(String str);
    }

    /* loaded from: classes2.dex */
    private class f implements ComponentCallbacks2 {
        private f() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i2) {
            if (i2 >= 60) {
                b1.a().a();
            }
        }

        /* synthetic */ f(UIManagerModule uIManagerModule, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface g {
        List<String> a();

        ViewManager b(String str);
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, g gVar, int i2) {
        this(reactApplicationContext, gVar, new n0(), i2);
    }

    private WritableMap computeConstantsForViewManager(String str) {
        ViewManager R = str != null ? this.mUIImplementation.R(str) : null;
        if (R == null) {
            return null;
        }
        com.facebook.systrace.b.a(0L, "UIManagerModule.getConstantsForViewManager").b("ViewManager", R.getName()).b("Lazy", Boolean.TRUE).c();
        try {
            Map<String, Object> c2 = q0.c(R, null, null, null, this.mCustomDirectEvents);
            if (c2 != null) {
                return Arguments.makeNativeMap(c2);
            }
            return null;
        } finally {
            com.facebook.systrace.b.b(0L).c();
        }
    }

    private static Map<String, Object> createConstants(g gVar) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        com.facebook.systrace.b.a(0L, "CreateUIManagerConstants").b("Lazy", Boolean.TRUE).c();
        try {
            return q0.a(gVar);
        } finally {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    public <T extends View> int addRootView(T t) {
        return addRootView(t, null, null);
    }

    public void addUIBlock(l0 l0Var) {
        this.mUIImplementation.a(l0Var);
    }

    public void addUIManagerListener(r0 r0Var) {
        this.mListeners.add(r0Var);
    }

    @ReactMethod
    public void clearJSResponder() {
        this.mUIImplementation.f();
    }

    @ReactMethod
    public void configureNextLayoutAnimation(ReadableMap readableMap, Callback callback, Callback callback2) {
        this.mUIImplementation.g(readableMap, callback);
    }

    @ReactMethod
    public void createView(int i2, String str, int i3, ReadableMap readableMap) {
        if (DEBUG) {
            String str2 = "(UIManager.createView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            e.f.d.d.a.b("ReactNative", str2);
            e.f.f.b.c.a().c(e.f.f.c.a.f12130f, str2);
        }
        this.mUIImplementation.j(i2, str, i3, readableMap);
    }

    @ReactMethod
    public void dismissPopupMenu() {
        this.mUIImplementation.k();
    }

    @Override // com.facebook.react.bridge.UIManager
    @Deprecated
    public void dispatchCommand(int i2, int i3, ReadableArray readableArray) {
        this.mUIImplementation.l(i2, i3, readableArray);
    }

    @ReactMethod
    public void dispatchViewManagerCommand(int i2, Dynamic dynamic, ReadableArray readableArray) {
        UIManager d2 = o0.d(getReactApplicationContext(), com.facebook.react.uimanager.d1.a.a(i2));
        if (d2 == null) {
            return;
        }
        if (dynamic.getType() == ReadableType.Number) {
            d2.dispatchCommand(i2, dynamic.asInt(), readableArray);
        } else if (dynamic.getType() == ReadableType.String) {
            d2.dispatchCommand(i2, dynamic.asString(), readableArray);
        }
    }

    @ReactMethod
    public void findSubviewIn(int i2, ReadableArray readableArray, Callback callback) {
        this.mUIImplementation.p(i2, Math.round(o.b(readableArray.getDouble(0))), Math.round(o.b(readableArray.getDouble(1))), callback);
    }

    @Override // com.facebook.react.bridge.BaseJavaModule
    public Map<String, Object> getConstants() {
        return this.mModuleConstants;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getConstantsForViewManager(String str) {
        Map<String, WritableMap> map = this.mViewManagerConstantsCache;
        if (map != null && map.containsKey(str)) {
            WritableMap writableMap = this.mViewManagerConstantsCache.get(str);
            int i2 = this.mViewManagerConstantsCacheSize - 1;
            this.mViewManagerConstantsCacheSize = i2;
            if (i2 <= 0) {
                this.mViewManagerConstantsCache = null;
            }
            return writableMap;
        }
        return computeConstantsForViewManager(str);
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public WritableMap getDefaultEventTypes() {
        return Arguments.makeNativeMap(q0.d());
    }

    public e getDirectEventNamesResolver() {
        return new a();
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public Map<String, Long> getPerformanceCounters() {
        return this.mUIImplementation.q();
    }

    public m0 getUIImplementation() {
        return this.mUIImplementation;
    }

    @Deprecated
    public y0 getViewManagerRegistry_DO_NOT_USE() {
        return this.mViewManagerRegistry;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
        this.mEventDispatcher.B(1, (RCTEventEmitter) getReactApplicationContext().getJSModule(RCTEventEmitter.class));
    }

    public void invalidateNodeLayout(int i2) {
        y Q = this.mUIImplementation.Q(i2);
        if (Q == null) {
            e.f.d.d.a.A("ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + i2);
            return;
        }
        Q.h();
        this.mUIImplementation.n(-1);
    }

    @ReactMethod
    public void manageChildren(int i2, ReadableArray readableArray, ReadableArray readableArray2, ReadableArray readableArray3, ReadableArray readableArray4, ReadableArray readableArray5) {
        if (DEBUG) {
            String str = "(UIManager.manageChildren) tag: " + i2 + ", moveFrom: " + readableArray + ", moveTo: " + readableArray2 + ", addTags: " + readableArray3 + ", atIndices: " + readableArray4 + ", removeFrom: " + readableArray5;
            e.f.d.d.a.b("ReactNative", str);
            e.f.f.b.c.a().c(e.f.f.c.a.f12130f, str);
        }
        this.mUIImplementation.u(i2, readableArray, readableArray2, readableArray3, readableArray4, readableArray5);
    }

    @ReactMethod
    public void measure(int i2, Callback callback) {
        this.mUIImplementation.v(i2, callback);
    }

    @ReactMethod
    public void measureInWindow(int i2, Callback callback) {
        this.mUIImplementation.w(i2, callback);
    }

    @ReactMethod
    public void measureLayout(int i2, int i3, Callback callback, Callback callback2) {
        this.mUIImplementation.x(i2, i3, callback, callback2);
    }

    @ReactMethod
    @Deprecated
    public void measureLayoutRelativeToParent(int i2, Callback callback, Callback callback2) {
        this.mUIImplementation.z(i2, callback, callback2);
    }

    @Override // com.facebook.react.bridge.OnBatchCompleteListener
    public void onBatchComplete() {
        int i2 = this.mBatchId;
        this.mBatchId = i2 + 1;
        com.facebook.systrace.b.a(0L, "onBatchCompleteUI").a("BatchId", i2).c();
        for (r0 r0Var : this.mListeners) {
            r0Var.willDispatchViewUpdates(this);
        }
        try {
            this.mUIImplementation.n(i2);
        } finally {
            com.facebook.systrace.a.g(0L);
        }
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        super.onCatalystInstanceDestroy();
        this.mEventDispatcher.A();
        getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
        b1.a().a();
        x0.a();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
        this.mUIImplementation.D();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.mUIImplementation.E();
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mUIImplementation.F();
    }

    @ReactMethod
    @Deprecated
    public void playTouchSound() {
        AudioManager audioManager = (AudioManager) getReactApplicationContext().getSystemService("audio");
        if (audioManager != null) {
            audioManager.playSoundEffect(0);
        }
    }

    @Deprecated
    public void preComputeConstantsForViewManager(List<String> list) {
        c.e.a aVar = new c.e.a();
        for (String str : list) {
            WritableMap computeConstantsForViewManager = computeConstantsForViewManager(str);
            if (computeConstantsForViewManager != null) {
                aVar.put(str, computeConstantsForViewManager);
            }
        }
        this.mViewManagerConstantsCacheSize = list.size();
        this.mViewManagerConstantsCache = Collections.unmodifiableMap(aVar);
    }

    public void prependUIBlock(l0 l0Var) {
        this.mUIImplementation.G(l0Var);
    }

    @Override // com.facebook.react.bridge.PerformanceCounter
    public void profileNextBatch() {
        this.mUIImplementation.H();
    }

    @ReactMethod
    public void removeRootView(int i2) {
        this.mUIImplementation.K(i2);
    }

    @ReactMethod
    @Deprecated
    public void removeSubviewsFromContainerWithID(int i2) {
        this.mUIImplementation.N(i2);
    }

    public void removeUIManagerListener(r0 r0Var) {
        this.mListeners.remove(r0Var);
    }

    @ReactMethod
    @Deprecated
    public void replaceExistingNonRootView(int i2, int i3) {
        this.mUIImplementation.O(i2, i3);
    }

    @Deprecated
    public int resolveRootTagFromReactTag(int i2) {
        return com.facebook.react.uimanager.d1.a.b(i2) ? i2 : this.mUIImplementation.P(i2);
    }

    public View resolveView(int i2) {
        UiThreadUtil.assertOnUiThread();
        return this.mUIImplementation.r().V().w(i2);
    }

    @Override // com.facebook.react.bridge.UIManager
    @ReactMethod
    public void sendAccessibilityEvent(int i2, int i3) {
        int a2 = com.facebook.react.uimanager.d1.a.a(i2);
        if (a2 == 2) {
            UIManager d2 = o0.d(getReactApplicationContext(), a2);
            if (d2 != null) {
                d2.sendAccessibilityEvent(i2, i3);
                return;
            }
            return;
        }
        this.mUIImplementation.S(i2, i3);
    }

    @ReactMethod
    public void setChildren(int i2, ReadableArray readableArray) {
        if (DEBUG) {
            String str = "(UIManager.setChildren) tag: " + i2 + ", children: " + readableArray;
            e.f.d.d.a.b("ReactNative", str);
            e.f.f.b.c.a().c(e.f.f.c.a.f12130f, str);
        }
        this.mUIImplementation.T(i2, readableArray);
    }

    @ReactMethod
    public void setJSResponder(int i2, boolean z) {
        this.mUIImplementation.U(i2, z);
    }

    @ReactMethod
    public void setLayoutAnimationEnabledExperimental(boolean z) {
        this.mUIImplementation.V(z);
    }

    public void setViewHierarchyUpdateDebugListener(com.facebook.react.uimanager.e1.a aVar) {
        this.mUIImplementation.W(aVar);
    }

    public void setViewLocalData(int i2, Object obj) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.assertOnUiQueueThread();
        reactApplicationContext.runOnNativeModulesQueueThread(new b(reactApplicationContext, i2, obj));
    }

    @ReactMethod
    public void showPopupMenu(int i2, ReadableArray readableArray, Callback callback, Callback callback2) {
        this.mUIImplementation.Y(i2, readableArray, callback, callback2);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void synchronouslyUpdateViewOnUIThread(int i2, ReadableMap readableMap) {
        int a2 = com.facebook.react.uimanager.d1.a.a(i2);
        if (a2 == 2) {
            UIManager d2 = o0.d(getReactApplicationContext(), a2);
            if (d2 != null) {
                d2.synchronouslyUpdateViewOnUIThread(i2, readableMap);
                return;
            }
            return;
        }
        this.mUIImplementation.Z(i2, new a0(readableMap));
    }

    public void updateNodeSize(int i2, int i3, int i4) {
        getReactApplicationContext().assertOnNativeModulesQueueThread();
        this.mUIImplementation.a0(i2, i3, i4);
    }

    @Override // com.facebook.react.bridge.UIManager
    public void updateRootLayoutSpecs(int i2, int i3, int i4) {
        ReactApplicationContext reactApplicationContext = getReactApplicationContext();
        reactApplicationContext.runOnNativeModulesQueueThread(new d(reactApplicationContext, i2, i3, i4));
    }

    @ReactMethod
    public void updateView(int i2, String str, ReadableMap readableMap) {
        UIManager d2;
        if (DEBUG) {
            String str2 = "(UIManager.updateView) tag: " + i2 + ", class: " + str + ", props: " + readableMap;
            e.f.d.d.a.b("ReactNative", str2);
            e.f.f.b.c.a().c(e.f.f.c.a.f12130f, str2);
        }
        int a2 = com.facebook.react.uimanager.d1.a.a(i2);
        if (a2 == 2) {
            ReactApplicationContext reactApplicationContext = getReactApplicationContext();
            if (!reactApplicationContext.hasActiveCatalystInstance() || (d2 = o0.d(reactApplicationContext, a2)) == null) {
                return;
            }
            reactApplicationContext.runOnUiQueueThread(new c(d2, i2, readableMap));
            return;
        }
        this.mUIImplementation.d0(i2, str, readableMap);
    }

    @ReactMethod
    @Deprecated
    public void viewIsDescendantOf(int i2, int i3, Callback callback) {
        this.mUIImplementation.f0(i2, i3, callback);
    }

    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, int i2) {
        this(reactApplicationContext, list, new n0(), i2);
    }

    @Override // com.facebook.react.bridge.UIManager
    public <T extends View> int addRootView(T t, WritableMap writableMap, String str) {
        com.facebook.systrace.a.c(0L, "UIManagerModule.addRootView");
        int a2 = x.a();
        this.mUIImplementation.I(t, a2, new i0(getReactApplicationContext(), t.getContext(), ((w) t).getSurfaceID()));
        com.facebook.systrace.a.g(0L);
        return a2;
    }

    @Override // com.facebook.react.bridge.UIManager
    public void dispatchCommand(int i2, String str, ReadableArray readableArray) {
        this.mUIImplementation.m(i2, str, readableArray);
    }

    @Override // com.facebook.react.bridge.UIManager
    public com.facebook.react.uimanager.events.d getEventDispatcher() {
        return this.mEventDispatcher;
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, g gVar, n0 n0Var, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new f(this, null);
        this.mListeners = new ArrayList();
        this.mBatchId = 0;
        com.facebook.react.uimanager.c.h(reactApplicationContext);
        com.facebook.react.uimanager.events.d dVar = new com.facebook.react.uimanager.events.d(reactApplicationContext);
        this.mEventDispatcher = dVar;
        this.mModuleConstants = createConstants(gVar);
        this.mCustomDirectEvents = p0.c();
        y0 y0Var = new y0(gVar);
        this.mViewManagerRegistry = y0Var;
        this.mUIImplementation = n0Var.a(reactApplicationContext, y0Var, dVar, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }

    private static Map<String, Object> createConstants(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
        com.facebook.systrace.b.a(0L, "CreateUIManagerConstants").b("Lazy", Boolean.FALSE).c();
        try {
            return q0.b(list, map, map2);
        } finally {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
        }
    }

    @Deprecated
    public UIManagerModule(ReactApplicationContext reactApplicationContext, List<ViewManager> list, n0 n0Var, int i2) {
        super(reactApplicationContext);
        this.mMemoryTrimCallback = new f(this, null);
        this.mListeners = new ArrayList();
        this.mBatchId = 0;
        com.facebook.react.uimanager.c.h(reactApplicationContext);
        com.facebook.react.uimanager.events.d dVar = new com.facebook.react.uimanager.events.d(reactApplicationContext);
        this.mEventDispatcher = dVar;
        HashMap b2 = com.facebook.react.common.c.b();
        this.mCustomDirectEvents = b2;
        this.mModuleConstants = createConstants(list, null, b2);
        y0 y0Var = new y0(list);
        this.mViewManagerRegistry = y0Var;
        this.mUIImplementation = n0Var.a(reactApplicationContext, y0Var, dVar, i2);
        reactApplicationContext.addLifecycleEventListener(this);
    }
}