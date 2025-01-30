package e.f.m;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.devsupport.LogBoxModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.TimingModule;
import com.facebook.react.modules.debug.DevSettingsModule;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.n0;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: CoreModulesPackage.java */
/* loaded from: classes2.dex */
public class a extends t implements r {
    private final l a;

    /* renamed from: b  reason: collision with root package name */
    private final com.facebook.react.modules.core.b f12808b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f12809c;

    /* renamed from: d  reason: collision with root package name */
    private final int f12810d;

    /* compiled from: CoreModulesPackage.java */
    /* renamed from: e.f.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0282a implements com.facebook.react.module.model.a {
        final /* synthetic */ Map a;

        C0282a(Map map) {
            this.a = map;
        }

        @Override // com.facebook.react.module.model.a
        public Map<String, ReactModuleInfo> a() {
            return this.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoreModulesPackage.java */
    /* loaded from: classes2.dex */
    public class b implements UIManagerModule.g {
        b() {
        }

        @Override // com.facebook.react.uimanager.UIManagerModule.g
        public List<String> a() {
            return a.this.a.x();
        }

        @Override // com.facebook.react.uimanager.UIManagerModule.g
        public ViewManager b(String str) {
            return a.this.a.r(str);
        }
    }

    public a(l lVar, com.facebook.react.modules.core.b bVar, n0 n0Var, boolean z, int i2) {
        this.a = lVar;
        this.f12808b = bVar;
        this.f12809c = z;
        this.f12810d = i2;
    }

    private UIManagerModule h(ReactApplicationContext reactApplicationContext) {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
        com.facebook.systrace.a.c(0L, "createUIManagerModule");
        try {
            if (this.f12809c) {
                return new UIManagerModule(reactApplicationContext, new b(), this.f12810d);
            }
            return new UIManagerModule(reactApplicationContext, this.a.w(reactApplicationContext), this.f12810d);
        } finally {
            com.facebook.systrace.a.g(0L);
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
        }
    }

    @Override // e.f.m.r
    public void a() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
    }

    @Override // e.f.m.r
    public void b() {
        ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
    }

    @Override // e.f.m.t
    public NativeModule c(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2013505529:
                if (str.equals(LogBoxModule.NAME)) {
                    c2 = 0;
                    break;
                }
                break;
            case -1789797270:
                if (str.equals(TimingModule.NAME)) {
                    c2 = 1;
                    break;
                }
                break;
            case -1633589448:
                if (str.equals(DevSettingsModule.NAME)) {
                    c2 = 2;
                    break;
                }
                break;
            case -1520650172:
                if (str.equals(DeviceInfoModule.NAME)) {
                    c2 = 3;
                    break;
                }
                break;
            case -1037217463:
                if (str.equals(DeviceEventManagerModule.NAME)) {
                    c2 = 4;
                    break;
                }
                break;
            case -790603268:
                if (str.equals(AndroidInfoModule.NAME)) {
                    c2 = 5;
                    break;
                }
                break;
            case 512434409:
                if (str.equals(ExceptionsManagerModule.NAME)) {
                    c2 = 6;
                    break;
                }
                break;
            case 881516744:
                if (str.equals(SourceCodeModule.NAME)) {
                    c2 = 7;
                    break;
                }
                break;
            case 1256514152:
                if (str.equals(HeadlessJsTaskSupportModule.NAME)) {
                    c2 = '\b';
                    break;
                }
                break;
            case 1861242489:
                if (str.equals(UIManagerModule.NAME)) {
                    c2 = '\t';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new LogBoxModule(reactApplicationContext, this.a.v());
            case 1:
                return new TimingModule(reactApplicationContext, this.a.v());
            case 2:
                return new DevSettingsModule(reactApplicationContext, this.a.v());
            case 3:
                return new DeviceInfoModule(reactApplicationContext);
            case 4:
                return new DeviceEventManagerModule(reactApplicationContext, this.f12808b);
            case 5:
                return new AndroidInfoModule(reactApplicationContext);
            case 6:
                return new ExceptionsManagerModule(this.a.v());
            case 7:
                return new SourceCodeModule(reactApplicationContext);
            case '\b':
                return new HeadlessJsTaskSupportModule(reactApplicationContext);
            case '\t':
                return h(reactApplicationContext);
            default:
                throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + str);
        }
    }

    @Override // e.f.m.t
    public com.facebook.react.module.model.a e() {
        try {
            return (com.facebook.react.module.model.a) Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, DevSettingsModule.class, ExceptionsManagerModule.class, LogBoxModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, TimingModule.class, UIManagerModule.class};
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < 10; i2++) {
                Class cls = clsArr[i2];
                e.f.m.x.a.a aVar = (e.f.m.x.a.a) cls.getAnnotation(e.f.m.x.a.a.class);
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), com.facebook.react.turbomodule.core.interfaces.a.class.isAssignableFrom(cls)));
            }
            return new C0282a(hashMap);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", e3);
        }
    }
}