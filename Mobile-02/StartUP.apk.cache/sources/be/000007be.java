package com.bugsnag.android;

import com.bugsnag.android.NativeInterface;
import com.bugsnag.android.o0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: MetaData.java */
/* loaded from: classes.dex */
public class s0 extends Observable implements o0.a {
    final Map<String, Object> a;

    /* renamed from: b  reason: collision with root package name */
    final u0 f3708b;

    public s0() {
        this(new ConcurrentHashMap());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static s0 d(s0... s0VarArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (s0 s0Var : s0VarArr) {
            if (s0Var != null) {
                arrayList.add(s0Var.a);
                String[] strArr = s0Var.f3708b.a;
                if (strArr != null) {
                    arrayList2.addAll(Arrays.asList(strArr));
                }
            }
        }
        s0 s0Var2 = new s0(e((Map[]) arrayList.toArray(new Map[0])));
        s0Var2.f((String[]) arrayList2.toArray(new String[0]));
        return s0Var2;
    }

    @SafeVarargs
    private static Map<String, Object> e(Map<String, Object>... mapArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map<String, Object> map : mapArr) {
            if (map != null) {
                HashSet<String> hashSet = new HashSet(concurrentHashMap.keySet());
                hashSet.addAll(map.keySet());
                for (String str : hashSet) {
                    Object obj = concurrentHashMap.get(str);
                    Object obj2 = map.get(str);
                    if (obj2 != null) {
                        if ((obj instanceof Map) && (obj2 instanceof Map)) {
                            concurrentHashMap.put(str, e((Map) obj, (Map) obj2));
                        } else {
                            concurrentHashMap.put(str, obj2);
                        }
                    } else if (obj != null) {
                        concurrentHashMap.put(str, obj);
                    }
                }
            }
        }
        return concurrentHashMap;
    }

    public void a(String str, String str2, Object obj) {
        Map<String, Object> c2 = c(str);
        setChanged();
        if (obj != null) {
            c2.put(str2, obj);
            notifyObservers(new NativeInterface.b(NativeInterface.c.ADD_METADATA, Arrays.asList(str, str2, obj)));
            return;
        }
        c2.remove(str2);
        notifyObservers(new NativeInterface.b(NativeInterface.c.REMOVE_METADATA, Arrays.asList(str, str2)));
    }

    public void b(String str) {
        this.a.remove(str);
        setChanged();
        notifyObservers(new NativeInterface.b(NativeInterface.c.CLEAR_METADATA_TAB, str));
    }

    Map<String, Object> c(String str) {
        Map<String, Object> map = (Map) this.a.get(str);
        if (map == null) {
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
            this.a.put(str, concurrentHashMap);
            return concurrentHashMap;
        }
        return map;
    }

    void f(String... strArr) {
        this.f3708b.a = strArr;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        this.f3708b.a(this.a, o0Var);
    }

    public s0(Map<String, Object> map) {
        this.a = new ConcurrentHashMap(map);
        this.f3708b = new u0();
    }
}