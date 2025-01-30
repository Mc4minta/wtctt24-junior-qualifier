package e.f.m;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NativeModuleRegistryBuilder.java */
/* loaded from: classes2.dex */
public class e {
    private final ReactApplicationContext a;

    /* renamed from: b  reason: collision with root package name */
    private final l f12821b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, ModuleHolder> f12822c = new HashMap();

    public e(ReactApplicationContext reactApplicationContext, l lVar) {
        this.a = reactApplicationContext;
        this.f12821b = lVar;
    }

    public NativeModuleRegistry a() {
        return new NativeModuleRegistry(this.a, this.f12822c);
    }

    public void b(p pVar) {
        Iterable<ModuleHolder> a;
        if (pVar instanceof c) {
            a = ((c) pVar).a(this.a);
        } else if (pVar instanceof t) {
            a = ((t) pVar).d(this.a);
        } else {
            a = q.a(pVar, this.a, this.f12821b);
        }
        for (ModuleHolder moduleHolder : a) {
            String name = moduleHolder.getName();
            if (this.f12822c.containsKey(name)) {
                ModuleHolder moduleHolder2 = this.f12822c.get(name);
                if (moduleHolder.getCanOverrideExistingModule()) {
                    this.f12822c.remove(moduleHolder2);
                } else {
                    throw new IllegalStateException("Native module " + name + " tried to override " + moduleHolder2.getClassName() + ". Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true. This error may also be present if the package is present only once in getPackages() but is also automatically added later during build time by autolinking. Try removing the existing entry and rebuild.");
                }
            }
            this.f12822c.put(name, moduleHolder);
        }
    }
}