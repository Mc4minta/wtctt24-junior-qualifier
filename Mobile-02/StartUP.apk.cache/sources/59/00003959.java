package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-components@@16.0.0 */
/* loaded from: classes2.dex */
public final class f<T> {
    private final T a;

    /* renamed from: b  reason: collision with root package name */
    private final c<T> f8617b;

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    private static class b implements c<Context> {
        private final Class<? extends Service> a;

        private Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.a), 128);
                if (serviceInfo == null) {
                    Log.w("ComponentDiscovery", this.a + " has no service info.");
                    return null;
                }
                return serviceInfo.metaData;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // com.google.firebase.components.f.c
        /* renamed from: c */
        public List<String> a(Context context) {
            Bundle b2 = b(context);
            if (b2 == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : b2.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(b2.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        private b(Class<? extends Service> cls) {
            this.a = cls;
        }
    }

    /* compiled from: com.google.firebase:firebase-components@@16.0.0 */
    /* loaded from: classes2.dex */
    interface c<T> {
        List<String> a(T t);
    }

    f(T t, c<T> cVar) {
        this.a = t;
        this.f8617b = cVar;
    }

    public static f<Context> b(Context context, Class<? extends Service> cls) {
        return new f<>(context, new b(cls));
    }

    private static List<h> c(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            try {
                Class<?> cls = Class.forName(str);
                if (!h.class.isAssignableFrom(cls)) {
                    Log.w("ComponentDiscovery", String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
                } else {
                    arrayList.add((h) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                }
            } catch (ClassNotFoundException e2) {
                Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str), e2);
            } catch (IllegalAccessException e3) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e3);
            } catch (InstantiationException e4) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s.", str), e4);
            } catch (NoSuchMethodException e5) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e5);
            } catch (InvocationTargetException e6) {
                Log.w("ComponentDiscovery", String.format("Could not instantiate %s", str), e6);
            }
        }
        return arrayList;
    }

    public List<h> a() {
        return c(this.f8617b.a(this.a));
    }
}