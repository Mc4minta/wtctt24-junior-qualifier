package e.f.m;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: LazyReactPackage.java */
/* loaded from: classes2.dex */
public abstract class c implements p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazyReactPackage.java */
    /* loaded from: classes2.dex */
    public class a implements Iterable<ModuleHolder> {
        final /* synthetic */ List a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Map f12818b;

        /* compiled from: LazyReactPackage.java */
        /* renamed from: e.f.m.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0284a implements Iterator<ModuleHolder> {
            int a = 0;

            C0284a() {
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public ModuleHolder next() {
                List list = a.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                ModuleSpec moduleSpec = (ModuleSpec) list.get(i2);
                String name = moduleSpec.getName();
                ReactModuleInfo reactModuleInfo = (ReactModuleInfo) a.this.f12818b.get(name);
                if (reactModuleInfo == null) {
                    ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, name);
                    try {
                        NativeModule nativeModule = moduleSpec.getProvider().get();
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                        return new ModuleHolder(nativeModule);
                    } catch (Throwable th) {
                        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                        throw th;
                    }
                }
                return new ModuleHolder(reactModuleInfo, moduleSpec.getProvider());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < a.this.a.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove native modules from the list");
            }
        }

        a(List list, Map map) {
            this.a = list;
            this.f12818b = map;
        }

        @Override // java.lang.Iterable
        public Iterator<ModuleHolder> iterator() {
            return new C0284a();
        }
    }

    public Iterable<ModuleHolder> a(ReactApplicationContext reactApplicationContext) {
        return new a(b(reactApplicationContext), c().a());
    }

    protected abstract List<ModuleSpec> b(ReactApplicationContext reactApplicationContext);

    public abstract com.facebook.react.module.model.a c();

    @Override // e.f.m.p
    public final List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        ArrayList arrayList = new ArrayList();
        for (ModuleSpec moduleSpec : b(reactApplicationContext)) {
            com.facebook.systrace.b.a(0L, "createNativeModule").b("module", moduleSpec.getType()).c();
            ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, moduleSpec.getName());
            try {
                NativeModule nativeModule = moduleSpec.getProvider().get();
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                com.facebook.systrace.b.b(0L).c();
                arrayList.add(nativeModule);
            } catch (Throwable th) {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
                com.facebook.systrace.b.b(0L).c();
                throw th;
            }
        }
        return arrayList;
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ModuleSpec> d2 = d(reactApplicationContext);
        if (d2 != null && !d2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ModuleSpec moduleSpec : d2) {
                arrayList.add((ViewManager) moduleSpec.getProvider().get());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public List<ModuleSpec> d(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}