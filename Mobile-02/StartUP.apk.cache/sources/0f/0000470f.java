package e.f.m;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.List;

/* compiled from: ReactInstancePackage.java */
@Deprecated
/* loaded from: classes2.dex */
public abstract class n implements p {
    public abstract List<NativeModule> a(ReactApplicationContext reactApplicationContext, l lVar);

    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        throw new RuntimeException("ReactInstancePackage must be passed in the ReactInstanceManager.");
    }
}