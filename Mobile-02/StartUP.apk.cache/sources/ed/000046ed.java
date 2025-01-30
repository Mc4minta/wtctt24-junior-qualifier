package e.f.m;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.module.model.ReactModuleInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DebugCorePackage.java */
/* loaded from: classes2.dex */
public class b extends t {

    /* compiled from: DebugCorePackage.java */
    /* loaded from: classes2.dex */
    class a implements com.facebook.react.module.model.a {
        final /* synthetic */ Map a;

        a(Map map) {
            this.a = map;
        }

        @Override // com.facebook.react.module.model.a
        public Map<String, ReactModuleInfo> a() {
            return this.a;
        }
    }

    @Override // e.f.m.t
    public NativeModule c(String str, ReactApplicationContext reactApplicationContext) {
        str.hashCode();
        if (!str.equals(JSCHeapCapture.TAG)) {
            throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + str);
        }
        return new JSCHeapCapture(reactApplicationContext);
    }

    @Override // e.f.m.t
    public com.facebook.react.module.model.a e() {
        try {
            return (com.facebook.react.module.model.a) Class.forName("com.facebook.react.DebugCorePackage$$ReactModuleInfoProvider").newInstance();
        } catch (ClassNotFoundException unused) {
            Class[] clsArr = {JSCHeapCapture.class};
            HashMap hashMap = new HashMap();
            for (int i2 = 0; i2 < 1; i2++) {
                Class cls = clsArr[i2];
                e.f.m.x.a.a aVar = (e.f.m.x.a.a) cls.getAnnotation(e.f.m.x.a.a.class);
                hashMap.put(aVar.name(), new ReactModuleInfo(aVar.name(), cls.getName(), aVar.canOverrideExistingModule(), aVar.needsEagerInit(), aVar.hasConstants(), aVar.isCxxModule(), com.facebook.react.turbomodule.core.interfaces.a.class.isAssignableFrom(cls)));
            }
            return new a(hashMap);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("No ReactModuleInfoProvider for DebugCorePackage$$ReactModuleInfoProvider", e2);
        } catch (InstantiationException e3) {
            throw new RuntimeException("No ReactModuleInfoProvider for DebugCorePackage$$ReactModuleInfoProvider", e3);
        }
    }
}