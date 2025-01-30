package e.f.m;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.uimanager.ViewManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.inject.Provider;

/* compiled from: TurboReactPackage.java */
/* loaded from: classes2.dex */
public abstract class t implements p {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TurboReactPackage.java */
    /* loaded from: classes2.dex */
    public class a implements Iterable<ModuleHolder> {
        final /* synthetic */ Iterator a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReactApplicationContext f12883b;

        /* compiled from: TurboReactPackage.java */
        /* renamed from: e.f.m.t$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0286a implements Iterator<ModuleHolder> {
            Map.Entry<String, ReactModuleInfo> a = null;

            C0286a() {
            }

            /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private void b() {
                /*
                    r3 = this;
                L0:
                    e.f.m.t$a r0 = e.f.m.t.a.this
                    java.util.Iterator r0 = r0.a
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L28
                    e.f.m.t$a r0 = e.f.m.t.a.this
                    java.util.Iterator r0 = r0.a
                    java.lang.Object r0 = r0.next()
                    java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                    java.lang.Object r1 = r0.getValue()
                    com.facebook.react.module.model.ReactModuleInfo r1 = (com.facebook.react.module.model.ReactModuleInfo) r1
                    boolean r2 = e.f.m.v.a.a
                    if (r2 == 0) goto L25
                    boolean r1 = r1.e()
                    if (r1 == 0) goto L25
                    goto L0
                L25:
                    r3.a = r0
                    return
                L28:
                    r0 = 0
                    r3.a = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: e.f.m.t.a.C0286a.b():void");
            }

            @Override // java.util.Iterator
            /* renamed from: c */
            public ModuleHolder next() {
                if (this.a == null) {
                    b();
                }
                Map.Entry<String, ReactModuleInfo> entry = this.a;
                if (entry != null) {
                    b();
                    a aVar = a.this;
                    return new ModuleHolder(entry.getValue(), new b(entry.getKey(), aVar.f12883b));
                }
                throw new NoSuchElementException("ModuleHolder not found");
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.a == null) {
                    b();
                }
                return this.a != null;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove native modules from the list");
            }
        }

        a(Iterator it, ReactApplicationContext reactApplicationContext) {
            this.a = it;
            this.f12883b = reactApplicationContext;
        }

        @Override // java.lang.Iterable
        public Iterator<ModuleHolder> iterator() {
            return new C0286a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TurboReactPackage.java */
    /* loaded from: classes2.dex */
    public class b implements Provider<NativeModule> {
        private final String a;

        /* renamed from: b  reason: collision with root package name */
        private final ReactApplicationContext f12886b;

        public b(String str, ReactApplicationContext reactApplicationContext) {
            this.a = str;
            this.f12886b = reactApplicationContext;
        }

        @Override // javax.inject.Provider
        /* renamed from: a */
        public NativeModule get() {
            return t.this.c(this.a, this.f12886b);
        }
    }

    public abstract NativeModule c(String str, ReactApplicationContext reactApplicationContext);

    @Override // e.f.m.p
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        throw new UnsupportedOperationException("In case of TurboModules, createNativeModules is not supported. NativeModuleRegistry should instead use getModuleList or getModule method");
    }

    @Override // e.f.m.p
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        List<ModuleSpec> f2 = f(reactApplicationContext);
        if (f2 != null && !f2.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (ModuleSpec moduleSpec : f2) {
                arrayList.add((ViewManager) moduleSpec.getProvider().get());
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    public Iterable<ModuleHolder> d(ReactApplicationContext reactApplicationContext) {
        return new a(e().a().entrySet().iterator(), reactApplicationContext);
    }

    public abstract com.facebook.react.module.model.a e();

    protected List<ModuleSpec> f(ReactApplicationContext reactApplicationContext) {
        return Collections.emptyList();
    }
}