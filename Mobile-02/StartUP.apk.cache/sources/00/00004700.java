package e.f.m;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Process;
import android.view.View;
import c.h.k.v;
import com.coinbase.resources.trades.Trade;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JSIModuleType;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.n0;
import com.facebook.react.uimanager.o0;
import com.facebook.react.uimanager.w;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ReactInstanceManager.java */
/* loaded from: classes2.dex */
public class l {
    private static final String a = "l";

    /* renamed from: c  reason: collision with root package name */
    private volatile LifecycleState f12847c;

    /* renamed from: d  reason: collision with root package name */
    private j f12848d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Thread f12849e;

    /* renamed from: f  reason: collision with root package name */
    private final JavaScriptExecutorFactory f12850f;

    /* renamed from: g  reason: collision with root package name */
    private final JSBundleLoader f12851g;

    /* renamed from: h  reason: collision with root package name */
    private final String f12852h;

    /* renamed from: i  reason: collision with root package name */
    private final List<p> f12853i;

    /* renamed from: j  reason: collision with root package name */
    private final com.facebook.react.devsupport.g.c f12854j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f12855k;

    /* renamed from: l  reason: collision with root package name */
    private final NotThreadSafeBridgeIdleDebugListener f12856l;
    private volatile ReactContext n;
    private final Context o;
    private com.facebook.react.modules.core.b p;
    private Activity q;
    private final e.f.m.d u;
    private final NativeModuleCallExceptionHandler v;
    private final JSIModulePackage w;
    private List<ViewManager> x;

    /* renamed from: b  reason: collision with root package name */
    private final Set<w> f12846b = Collections.synchronizedSet(new HashSet());
    private final Object m = new Object();
    private final Collection<k> r = Collections.synchronizedList(new ArrayList());
    private volatile boolean s = false;
    private volatile Boolean t = Boolean.FALSE;

    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    class a implements com.facebook.react.modules.core.b {
        a() {
        }

        @Override // com.facebook.react.modules.core.b
        public void invokeDefaultOnBackPressed() {
            l.this.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class b implements com.facebook.react.devsupport.d {
        b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class c implements com.facebook.react.devsupport.g.d {
        final /* synthetic */ com.facebook.react.modules.debug.c.a a;

        c(com.facebook.react.modules.debug.c.a aVar) {
            this.a = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class d implements View.OnAttachStateChangeListener {
        final /* synthetic */ View a;

        d(View view) {
            this.a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.a.removeOnAttachStateChangeListener(this);
            l.this.f12854j.h(true);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class e implements Runnable {
        final /* synthetic */ j a;

        /* compiled from: ReactInstanceManager.java */
        /* loaded from: classes2.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f12848d != null) {
                    l lVar = l.this;
                    lVar.R(lVar.f12848d);
                    l.this.f12848d = null;
                }
            }
        }

        /* compiled from: ReactInstanceManager.java */
        /* loaded from: classes2.dex */
        class b implements Runnable {
            final /* synthetic */ ReactApplicationContext a;

            b(ReactApplicationContext reactApplicationContext) {
                this.a = reactApplicationContext;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    l.this.S(this.a);
                } catch (Exception e2) {
                    e.f.d.d.a.j("ReactNative", "ReactInstanceManager caught exception in setupReactContext", e2);
                    l.this.f12854j.handleException(e2);
                }
            }
        }

        e(j jVar) {
            this.a = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
            synchronized (l.this.t) {
                while (l.this.t.booleanValue()) {
                    try {
                        l.this.t.wait();
                    } catch (InterruptedException unused) {
                    }
                }
            }
            l.this.s = true;
            try {
                Process.setThreadPriority(-4);
                ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
                ReactApplicationContext p = l.this.p(this.a.b().create(), this.a.a());
                l.this.f12849e = null;
                ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
                a aVar = new a();
                p.runOnNativeModulesQueueThread(new b(p));
                UiThreadUtil.runOnUiThread(aVar);
            } catch (Exception e2) {
                l.this.f12854j.handleException(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class f implements Runnable {
        final /* synthetic */ k[] a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f12861b;

        f(k[] kVarArr, ReactApplicationContext reactApplicationContext) {
            this.a = kVarArr;
            this.f12861b = reactApplicationContext;
        }

        @Override // java.lang.Runnable
        public void run() {
            k[] kVarArr;
            for (k kVar : this.a) {
                if (kVar != null) {
                    kVar.a(this.f12861b);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(0);
            ReactMarker.logMarker(ReactMarkerConstants.CHANGE_THREAD_PRIORITY, "js_default");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class h implements Runnable {
        h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class i implements Runnable {
        final /* synthetic */ int a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ w f12863b;

        i(int i2, w wVar) {
            this.a = i2;
            this.f12863b = wVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.facebook.systrace.a.e(0L, "pre_rootView.onAttachedToReactInstance", this.a);
            this.f12863b.onStage(101);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public class j {
        private final JavaScriptExecutorFactory a;

        /* renamed from: b  reason: collision with root package name */
        private final JSBundleLoader f12865b;

        public j(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
            this.a = (JavaScriptExecutorFactory) e.f.k.a.a.c(javaScriptExecutorFactory);
            this.f12865b = (JSBundleLoader) e.f.k.a.a.c(jSBundleLoader);
        }

        public JSBundleLoader a() {
            return this.f12865b;
        }

        public JavaScriptExecutorFactory b() {
            return this.a;
        }
    }

    /* compiled from: ReactInstanceManager.java */
    /* loaded from: classes2.dex */
    public interface k {
        void a(ReactContext reactContext);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(Context context, Activity activity, com.facebook.react.modules.core.b bVar, JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader, String str, List<p> list, boolean z, NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener, LifecycleState lifecycleState, n0 n0Var, NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler, com.facebook.react.devsupport.e eVar, boolean z2, com.facebook.react.devsupport.g.a aVar, int i2, int i3, JSIModulePackage jSIModulePackage, Map<String, ?> map) {
        e.f.d.d.a.b(a, "ReactInstanceManager.ctor()");
        y(context);
        com.facebook.react.uimanager.c.h(context);
        this.o = context;
        this.q = activity;
        this.p = bVar;
        this.f12850f = javaScriptExecutorFactory;
        this.f12851g = jSBundleLoader;
        this.f12852h = str;
        ArrayList arrayList = new ArrayList();
        this.f12853i = arrayList;
        this.f12855k = z;
        com.facebook.systrace.a.c(0L, "ReactInstanceManager.initDevSupportManager");
        com.facebook.react.devsupport.g.c a2 = com.facebook.react.devsupport.a.a(context, o(), str, z, eVar, aVar, i2, map);
        this.f12854j = a2;
        com.facebook.systrace.a.g(0L);
        this.f12856l = notThreadSafeBridgeIdleDebugListener;
        this.f12847c = lifecycleState;
        this.u = new e.f.m.d(context);
        this.v = nativeModuleCallExceptionHandler;
        synchronized (arrayList) {
            e.f.f.b.c.a().c(e.f.f.c.a.f12127c, "RNCore: Use Split Packages");
            arrayList.add(new e.f.m.a(this, new a(), n0Var, z2, i3));
            if (z) {
                arrayList.add(new e.f.m.b());
            }
            arrayList.addAll(list);
        }
        this.w = jSIModulePackage;
        com.facebook.react.modules.core.g.j();
        if (z) {
            a2.o();
        }
    }

    private synchronized void A() {
        if (this.f12847c == LifecycleState.RESUMED) {
            D(true);
        }
    }

    private synchronized void B() {
        ReactContext u = u();
        if (u != null) {
            if (this.f12847c == LifecycleState.RESUMED) {
                u.onHostPause();
                this.f12847c = LifecycleState.BEFORE_RESUME;
            }
            if (this.f12847c == LifecycleState.BEFORE_RESUME) {
                u.onHostDestroy();
            }
        }
        this.f12847c = LifecycleState.BEFORE_CREATE;
    }

    private synchronized void C() {
        ReactContext u = u();
        if (u != null) {
            if (this.f12847c == LifecycleState.BEFORE_CREATE) {
                u.onHostResume(this.q);
                u.onHostPause();
            } else if (this.f12847c == LifecycleState.RESUMED) {
                u.onHostPause();
            }
        }
        this.f12847c = LifecycleState.BEFORE_RESUME;
    }

    private synchronized void D(boolean z) {
        ReactContext u = u();
        if (u != null && (z || this.f12847c == LifecycleState.BEFORE_RESUME || this.f12847c == LifecycleState.BEFORE_CREATE)) {
            u.onHostResume(this.q);
        }
        this.f12847c = LifecycleState.RESUMED;
    }

    private void L(p pVar, e.f.m.e eVar) {
        com.facebook.systrace.b.a(0L, "processPackage").b("className", pVar.getClass().getSimpleName()).c();
        boolean z = pVar instanceof r;
        if (z) {
            ((r) pVar).a();
        }
        eVar.b(pVar);
        if (z) {
            ((r) pVar).b();
        }
        com.facebook.systrace.b.b(0L).c();
    }

    private NativeModuleRegistry M(ReactApplicationContext reactApplicationContext, List<p> list, boolean z) {
        e.f.m.e eVar = new e.f.m.e(reactApplicationContext, this);
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
        synchronized (this.f12853i) {
            Iterator<p> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    p next = it.next();
                    if (!z || !this.f12853i.contains(next)) {
                        com.facebook.systrace.a.c(0L, "createAndProcessCustomReactPackage");
                        if (z) {
                            this.f12853i.add(next);
                        }
                        L(next, eVar);
                        com.facebook.systrace.a.g(0L);
                    }
                }
            }
        }
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
        com.facebook.systrace.a.c(0L, "buildNativeModuleRegistry");
        try {
            return eVar.a();
        } finally {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
        }
    }

    private void O(JavaScriptExecutorFactory javaScriptExecutorFactory, JSBundleLoader jSBundleLoader) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        j jVar = new j(javaScriptExecutorFactory, jSBundleLoader);
        if (this.f12849e == null) {
            R(jVar);
        } else {
            this.f12848d = jVar;
        }
    }

    private void P() {
        e.f.d.d.a.b(a, "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
        e.f.f.b.c.a().c(e.f.f.c.a.f12127c, "RNCore: load from BundleLoader");
        O(this.f12850f, this.f12851g);
    }

    private void Q() {
        e.f.d.d.a.b(a, "ReactInstanceManager.recreateReactContextInBackgroundInner()");
        e.f.f.b.c.a().c(e.f.f.c.a.f12127c, "RNCore: recreateReactContextInBackground");
        UiThreadUtil.assertOnUiThread();
        if (this.f12855k && this.f12852h != null) {
            com.facebook.react.modules.debug.c.a m = this.f12854j.m();
            if (!com.facebook.systrace.a.h(0L)) {
                if (this.f12851g == null) {
                    this.f12854j.f();
                    return;
                } else {
                    this.f12854j.r(new c(m));
                    return;
                }
            }
        }
        P();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(j jVar) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
        UiThreadUtil.assertOnUiThread();
        synchronized (this.f12846b) {
            synchronized (this.m) {
                if (this.n != null) {
                    T(this.n);
                    this.n = null;
                }
            }
        }
        this.f12849e = new Thread(null, new e(jVar), "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.f12849e.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(ReactApplicationContext reactApplicationContext) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.setupReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_END);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_START);
        com.facebook.systrace.a.c(0L, "setupReactContext");
        synchronized (this.f12846b) {
            synchronized (this.m) {
                this.n = (ReactContext) e.f.k.a.a.c(reactApplicationContext);
            }
            CatalystInstance catalystInstance = (CatalystInstance) e.f.k.a.a.c(reactApplicationContext.getCatalystInstance());
            catalystInstance.initialize();
            this.f12854j.e(reactApplicationContext);
            this.u.a(catalystInstance);
            A();
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_START);
            for (w wVar : this.f12846b) {
                l(wVar);
            }
            ReactMarker.logMarker(ReactMarkerConstants.ATTACH_MEASURED_ROOT_VIEWS_END);
        }
        UiThreadUtil.runOnUiThread(new f((k[]) this.r.toArray(new k[this.r.size()]), reactApplicationContext));
        com.facebook.systrace.a.g(0L);
        ReactMarker.logMarker(ReactMarkerConstants.SETUP_REACT_CONTEXT_END);
        reactApplicationContext.runOnJSQueueThread(new g());
        reactApplicationContext.runOnNativeModulesQueueThread(new h());
    }

    private void T(ReactContext reactContext) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.tearDownReactContext()");
        UiThreadUtil.assertOnUiThread();
        if (this.f12847c == LifecycleState.RESUMED) {
            reactContext.onHostPause();
        }
        synchronized (this.f12846b) {
            for (w wVar : this.f12846b) {
                n(wVar);
            }
        }
        this.u.c(reactContext.getCatalystInstance());
        reactContext.destroy();
        this.f12854j.p(reactContext);
    }

    private void l(w wVar) {
        e.f.d.d.a.i("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
        com.facebook.systrace.a.c(0L, "attachRootViewToInstance");
        UIManager d2 = o0.d(this.n, wVar.getUIManagerType());
        if (d2 != null) {
            Bundle appProperties = wVar.getAppProperties();
            int addRootView = d2.addRootView(wVar.getRootViewGroup(), appProperties == null ? new WritableNativeMap() : Arguments.fromBundle(appProperties), wVar.getInitialUITemplate());
            wVar.setRootViewTag(addRootView);
            if (wVar.getUIManagerType() == 2) {
                d2.updateRootLayoutSpecs(addRootView, wVar.getWidthMeasureSpec(), wVar.getHeightMeasureSpec());
                wVar.setShouldLogContentAppeared(true);
            } else {
                wVar.runApplication();
            }
            com.facebook.systrace.a.a(0L, "pre_rootView.onAttachedToReactInstance", addRootView);
            UiThreadUtil.runOnUiThread(new i(addRootView, wVar));
            com.facebook.systrace.a.g(0L);
            return;
        }
        throw new IllegalStateException("Unable to attach a rootView to ReactInstance when UIManager is not properly initialized.");
    }

    public static m m() {
        return new m();
    }

    private void n(w wVar) {
        wVar.getRootViewGroup().removeAllViews();
        wVar.getRootViewGroup().setId(-1);
    }

    private com.facebook.react.devsupport.d o() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ReactApplicationContext p(JavaScriptExecutor javaScriptExecutor, JSBundleLoader jSBundleLoader) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.createReactContext()");
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, javaScriptExecutor.getName());
        ReactApplicationContext reactApplicationContext = new ReactApplicationContext(this.o);
        NativeModuleCallExceptionHandler nativeModuleCallExceptionHandler = this.v;
        if (nativeModuleCallExceptionHandler == null) {
            nativeModuleCallExceptionHandler = this.f12854j;
        }
        reactApplicationContext.setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        CatalystInstanceImpl.Builder nativeModuleCallExceptionHandler2 = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(javaScriptExecutor).setRegistry(M(reactApplicationContext, this.f12853i, false)).setJSBundleLoader(jSBundleLoader).setNativeModuleCallExceptionHandler(nativeModuleCallExceptionHandler);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
        com.facebook.systrace.a.c(0L, "createCatalystInstance");
        try {
            CatalystInstanceImpl build = nativeModuleCallExceptionHandler2.build();
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            reactApplicationContext.initializeWithInstance(build);
            StringBuilder sb = new StringBuilder();
            sb.append("ReactInstanceManager.createReactContext: mJSIModulePackage ");
            sb.append(this.w != null ? "not null" : "null");
            e.f.d.d.a.i("ReactNative", sb.toString());
            JSIModulePackage jSIModulePackage = this.w;
            if (jSIModulePackage != null) {
                build.addJSIModules(jSIModulePackage.getJSIModules(reactApplicationContext, build.getJavaScriptContextHolder()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append("ReactInstanceManager.createReactContext: ReactFeatureFlags.useTurboModules == ");
                sb2.append(!e.f.m.v.a.a ? "false" : "true");
                e.f.d.d.a.i("ReactNative", sb2.toString());
                if (e.f.m.v.a.a) {
                    JSIModule jSIModule = build.getJSIModule(JSIModuleType.TurboModuleManager);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("ReactInstanceManager.createReactContext: TurboModuleManager ");
                    sb3.append(jSIModule == null ? "not created" : Trade.STATUS_CREATED);
                    e.f.d.d.a.i("ReactNative", sb3.toString());
                    build.setTurboModuleManager(jSIModule);
                    TurboModuleRegistry turboModuleRegistry = (TurboModuleRegistry) jSIModule;
                    for (String str : turboModuleRegistry.a()) {
                        turboModuleRegistry.b(str);
                    }
                }
            }
            NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener = this.f12856l;
            if (notThreadSafeBridgeIdleDebugListener != null) {
                build.addBridgeIdleDebugListener(notThreadSafeBridgeIdleDebugListener);
            }
            if (com.facebook.systrace.a.h(0L)) {
                build.setGlobalVariable("__RCTProfileIsProfiling", "true");
            }
            ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
            com.facebook.systrace.a.c(0L, "runJSBundle");
            build.runJSBundle();
            com.facebook.systrace.a.g(0L);
            return reactApplicationContext;
        } catch (Throwable th) {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
            throw th;
        }
    }

    private void t(w wVar, CatalystInstance catalystInstance) {
        e.f.d.d.a.b("ReactNative", "ReactInstanceManager.detachViewFromInstance()");
        UiThreadUtil.assertOnUiThread();
        if (wVar.getUIManagerType() == 2) {
            ((ReactFabric) catalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(wVar.getRootViewTag());
        } else {
            ((AppRegistry) catalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(wVar.getRootViewTag());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void y(Context context) {
        SoLoader.g(context, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        UiThreadUtil.assertOnUiThread();
        com.facebook.react.modules.core.b bVar = this.p;
        if (bVar != null) {
            bVar.invokeDefaultOnBackPressed();
        }
    }

    public void E() {
        UiThreadUtil.assertOnUiThread();
        ReactContext reactContext = this.n;
        if (reactContext == null) {
            e.f.d.d.a.A(a, "Instance detached from instance manager");
            z();
            return;
        }
        ((DeviceEventManagerModule) reactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
    }

    public void F() {
        UiThreadUtil.assertOnUiThread();
        if (this.f12855k) {
            this.f12854j.h(false);
        }
        B();
        this.q = null;
    }

    public void G(Activity activity) {
        if (activity == this.q) {
            F();
        }
    }

    public void H() {
        UiThreadUtil.assertOnUiThread();
        this.p = null;
        if (this.f12855k) {
            this.f12854j.h(false);
        }
        C();
    }

    public void I(Activity activity) {
        e.f.k.a.a.c(this.q);
        boolean z = activity == this.q;
        e.f.k.a.a.b(z, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.q.getClass().getSimpleName() + " Paused activity: " + activity.getClass().getSimpleName());
        H();
    }

    public void J(Activity activity) {
        UiThreadUtil.assertOnUiThread();
        this.q = activity;
        if (this.f12855k) {
            View decorView = activity.getWindow().getDecorView();
            if (!v.Q(decorView)) {
                decorView.addOnAttachStateChangeListener(new d(decorView));
            } else {
                this.f12854j.h(true);
            }
        }
        D(false);
    }

    public void K(Activity activity, com.facebook.react.modules.core.b bVar) {
        UiThreadUtil.assertOnUiThread();
        this.p = bVar;
        J(activity);
    }

    public void N() {
        e.f.k.a.a.b(this.s, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
        Q();
    }

    public void k(w wVar) {
        UiThreadUtil.assertOnUiThread();
        this.f12846b.add(wVar);
        n(wVar);
        ReactContext u = u();
        if (this.f12849e != null || u == null) {
            return;
        }
        l(wVar);
    }

    public void q() {
        e.f.d.d.a.b(a, "ReactInstanceManager.createReactContextInBackground()");
        UiThreadUtil.assertOnUiThread();
        if (this.s) {
            return;
        }
        this.s = true;
        Q();
    }

    public ViewManager r(String str) {
        ViewManager a2;
        synchronized (this.m) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) u();
            if (reactApplicationContext != null && reactApplicationContext.hasActiveCatalystInstance()) {
                synchronized (this.f12853i) {
                    for (p pVar : this.f12853i) {
                        if ((pVar instanceof u) && (a2 = ((u) pVar).a(reactApplicationContext, str)) != null) {
                            return a2;
                        }
                    }
                    return null;
                }
            }
            return null;
        }
    }

    public void s(w wVar) {
        UiThreadUtil.assertOnUiThread();
        synchronized (this.f12846b) {
            if (this.f12846b.contains(wVar)) {
                ReactContext u = u();
                this.f12846b.remove(wVar);
                if (u != null && u.hasActiveCatalystInstance()) {
                    t(wVar, u.getCatalystInstance());
                }
            }
        }
    }

    public ReactContext u() {
        ReactContext reactContext;
        synchronized (this.m) {
            reactContext = this.n;
        }
        return reactContext;
    }

    public com.facebook.react.devsupport.g.c v() {
        return this.f12854j;
    }

    public List<ViewManager> w(ReactApplicationContext reactApplicationContext) {
        List<ViewManager> list;
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
        com.facebook.systrace.a.c(0L, "createAllViewManagers");
        try {
            if (this.x == null) {
                synchronized (this.f12853i) {
                    if (this.x == null) {
                        this.x = new ArrayList();
                        for (p pVar : this.f12853i) {
                            this.x.addAll(pVar.createViewManagers(reactApplicationContext));
                        }
                        list = this.x;
                    }
                }
                return list;
            }
            list = this.x;
            return list;
        } finally {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
        }
    }

    public List<String> x() {
        ArrayList arrayList;
        List<String> b2;
        com.facebook.systrace.a.c(0L, "ReactInstanceManager.getViewManagerNames");
        synchronized (this.m) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) u();
            if (reactApplicationContext != null && reactApplicationContext.hasActiveCatalystInstance()) {
                synchronized (this.f12853i) {
                    HashSet hashSet = new HashSet();
                    for (p pVar : this.f12853i) {
                        com.facebook.systrace.b.a(0L, "ReactInstanceManager.getViewManagerName").b("Package", pVar.getClass().getSimpleName()).c();
                        if ((pVar instanceof u) && (b2 = ((u) pVar).b(reactApplicationContext)) != null) {
                            hashSet.addAll(b2);
                        }
                        com.facebook.systrace.b.b(0L).c();
                    }
                    com.facebook.systrace.a.g(0L);
                    arrayList = new ArrayList(hashSet);
                }
                return arrayList;
            }
            return null;
        }
    }
}