package e.f.m;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.uimanager.n0;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ReactInstanceManagerBuilder.java */
/* loaded from: classes2.dex */
public class m {

    /* renamed from: b  reason: collision with root package name */
    private String f12867b;

    /* renamed from: c  reason: collision with root package name */
    private JSBundleLoader f12868c;

    /* renamed from: d  reason: collision with root package name */
    private String f12869d;

    /* renamed from: e  reason: collision with root package name */
    private NotThreadSafeBridgeIdleDebugListener f12870e;

    /* renamed from: f  reason: collision with root package name */
    private Application f12871f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f12872g;

    /* renamed from: h  reason: collision with root package name */
    private LifecycleState f12873h;

    /* renamed from: i  reason: collision with root package name */
    private n0 f12874i;

    /* renamed from: j  reason: collision with root package name */
    private NativeModuleCallExceptionHandler f12875j;

    /* renamed from: k  reason: collision with root package name */
    private Activity f12876k;

    /* renamed from: l  reason: collision with root package name */
    private com.facebook.react.modules.core.b f12877l;
    private com.facebook.react.devsupport.e m;
    private boolean n;
    private com.facebook.react.devsupport.g.a o;
    private JavaScriptExecutorFactory p;
    private JSIModulePackage s;
    private Map<String, ?> t;
    private final List<p> a = new ArrayList();
    private int q = 1;
    private int r = -1;

    private JavaScriptExecutorFactory c(String str, String str2, Context context) {
        try {
            l.y(context);
            SoLoader.j("jscexecutor");
            return new com.facebook.react.jscexecutor.a(str, str2);
        } catch (UnsatisfiedLinkError e2) {
            if (!e2.getMessage().contains("__cxa_bad_typeid")) {
                try {
                    return new com.facebook.hermes.reactexecutor.a();
                } catch (UnsatisfiedLinkError e3) {
                    e3.printStackTrace();
                    throw e2;
                }
            }
            throw e2;
        }
    }

    public m a(List<p> list) {
        this.a.addAll(list);
        return this;
    }

    public l b() {
        String str;
        e.f.k.a.a.d(this.f12871f, "Application property has not been set with this builder");
        if (this.f12873h == LifecycleState.RESUMED) {
            e.f.k.a.a.d(this.f12876k, "Activity needs to be set if initial lifecycle state is resumed");
        }
        boolean z = true;
        e.f.k.a.a.b((!this.f12872g && this.f12867b == null && this.f12868c == null) ? false : true, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
        if (this.f12869d == null && this.f12867b == null && this.f12868c == null) {
            z = false;
        }
        e.f.k.a.a.b(z, "Either MainModulePath or JS Bundle File needs to be provided");
        if (this.f12874i == null) {
            this.f12874i = new n0();
        }
        String packageName = this.f12871f.getPackageName();
        String a = com.facebook.react.modules.systeminfo.a.a();
        Application application = this.f12871f;
        Activity activity = this.f12876k;
        com.facebook.react.modules.core.b bVar = this.f12877l;
        JavaScriptExecutorFactory javaScriptExecutorFactory = this.p;
        JavaScriptExecutorFactory c2 = javaScriptExecutorFactory == null ? c(packageName, a, application.getApplicationContext()) : javaScriptExecutorFactory;
        JSBundleLoader jSBundleLoader = this.f12868c;
        if (jSBundleLoader == null && (str = this.f12867b) != null) {
            jSBundleLoader = JSBundleLoader.createAssetLoader(this.f12871f, str, false);
        }
        return new l(application, activity, bVar, c2, jSBundleLoader, this.f12869d, this.a, this.f12872g, this.f12870e, (LifecycleState) e.f.k.a.a.d(this.f12873h, "Initial lifecycle state was not set"), this.f12874i, this.f12875j, this.m, this.n, this.o, this.q, this.r, this.s, this.t);
    }

    public m d(Application application) {
        this.f12871f = application;
        return this;
    }

    public m e(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            str2 = "assets://" + str;
        }
        this.f12867b = str2;
        this.f12868c = null;
        return this;
    }

    public m f(Activity activity) {
        this.f12876k = activity;
        return this;
    }

    public m g(LifecycleState lifecycleState) {
        this.f12873h = lifecycleState;
        return this;
    }

    public m h(String str) {
        this.f12869d = str;
        return this;
    }

    public m i(boolean z) {
        this.f12872g = z;
        return this;
    }
}