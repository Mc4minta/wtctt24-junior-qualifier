package dagger.android;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dagger.android.b;
import f.c.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DispatchingAndroidInjector<T> implements b<T> {
    private final Map<String, Provider<b.a<?>>> a;

    /* loaded from: classes2.dex */
    public static final class InvalidInjectorBindingException extends RuntimeException {
        InvalidInjectorBindingException(String str, ClassCastException classCastException) {
            super(str, classCastException);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DispatchingAndroidInjector(Map<Class<?>, Provider<b.a<?>>> map, Map<String, Provider<b.a<?>>> map2) {
        this.a = c(map, map2);
    }

    private String a(T t) {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = t.getClass(); cls != null; cls = cls.getSuperclass()) {
            if (this.a.containsKey(cls.getCanonicalName())) {
                arrayList.add(cls.getCanonicalName());
            }
        }
        return arrayList.isEmpty() ? String.format("No injector factory bound for Class<%s>", t.getClass().getCanonicalName()) : String.format("No injector factory bound for Class<%1$s>. Injector factories were bound for supertypes of %1$s: %2$s. Did you mean to bind an injector factory for the subtype?", t.getClass().getCanonicalName(), arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C, V> Map<String, Provider<b.a<?>>> c(Map<Class<? extends C>, V> map, Map<String, V> map2) {
        if (map.isEmpty()) {
            return map2;
        }
        LinkedHashMap c2 = f.c.b.c(map.size() + map2.size());
        c2.putAll(map2);
        for (Map.Entry<Class<? extends C>, V> entry : map.entrySet()) {
            c2.put(entry.getKey().getName(), entry.getValue());
        }
        return Collections.unmodifiableMap(c2);
    }

    @CanIgnoreReturnValue
    public boolean b(T t) {
        Provider<b.a<?>> provider = this.a.get(t.getClass().getName());
        if (provider == null) {
            return false;
        }
        b.a<?> aVar = provider.get();
        try {
            ((b) h.d(aVar.create(t), "%s.create(I) should not return null.", aVar.getClass())).inject(t);
            return true;
        } catch (ClassCastException e2) {
            throw new InvalidInjectorBindingException(String.format("%s does not implement AndroidInjector.Factory<%s>", aVar.getClass().getCanonicalName(), t.getClass().getCanonicalName()), e2);
        }
    }

    @Override // dagger.android.b
    public void inject(T t) {
        if (!b(t)) {
            throw new IllegalArgumentException(a(t));
        }
    }
}