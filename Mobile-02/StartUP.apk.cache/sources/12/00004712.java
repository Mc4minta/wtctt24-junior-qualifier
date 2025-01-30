package e.f.m;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReactPackageHelper.java */
/* loaded from: classes2.dex */
public class q {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReactPackageHelper.java */
    /* loaded from: classes2.dex */
    public static class a implements Iterable<ModuleHolder> {
        final /* synthetic */ List a;

        /* compiled from: ReactPackageHelper.java */
        /* renamed from: e.f.m.q$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class C0285a implements Iterator<ModuleHolder> {
            int a = 0;

            C0285a() {
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public ModuleHolder next() {
                List list = a.this.a;
                int i2 = this.a;
                this.a = i2 + 1;
                return new ModuleHolder((NativeModule) list.get(i2));
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a < a.this.a.size();
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException("Cannot remove methods ");
            }
        }

        a(List list) {
            this.a = list;
        }

        @Override // java.lang.Iterable
        public Iterator<ModuleHolder> iterator() {
            return new C0285a();
        }
    }

    public static Iterable<ModuleHolder> a(p pVar, ReactApplicationContext reactApplicationContext, l lVar) {
        List<NativeModule> createNativeModules;
        e.f.d.d.a.b("ReactNative", pVar.getClass().getSimpleName() + " is not a LazyReactPackage, falling back to old version.");
        if (pVar instanceof n) {
            createNativeModules = ((n) pVar).a(reactApplicationContext, lVar);
        } else {
            createNativeModules = pVar.createNativeModules(reactApplicationContext);
        }
        return new a(createNativeModules);
    }
}