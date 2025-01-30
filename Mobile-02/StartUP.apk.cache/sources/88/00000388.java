package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.navigation.s;
import java.util.HashMap;
import java.util.Map;

/* compiled from: NavigatorProvider.java */
@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: classes.dex */
public class t {
    private static final HashMap<Class<?>, String> a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, s<? extends k>> f1941b = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Class<? extends s> cls) {
        HashMap<Class<?>, String> hashMap = a;
        String str = hashMap.get(cls);
        if (str == null) {
            s.b bVar = (s.b) cls.getAnnotation(s.b.class);
            str = bVar != null ? bVar.value() : null;
            if (f(str)) {
                hashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    private static boolean f(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    public final s<? extends k> a(s<? extends k> sVar) {
        return b(c(sVar.getClass()), sVar);
    }

    public s<? extends k> b(String str, s<? extends k> sVar) {
        if (f(str)) {
            return this.f1941b.put(str, sVar);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    public <T extends s<?>> T d(String str) {
        if (f(str)) {
            s<? extends k> sVar = this.f1941b.get(str);
            if (sVar != null) {
                return sVar;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, s<? extends k>> e() {
        return this.f1941b;
    }
}