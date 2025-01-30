package com.bugsnag.android;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.TypeCastException;

/* compiled from: BugsnagPluginInterface.kt */
/* loaded from: classes.dex */
public final class m {

    /* renamed from: b  reason: collision with root package name */
    public static final m f3667b = new m();
    private static final Set<Class<?>> a = new LinkedHashSet();

    private m() {
    }

    private final l a(Class<?> cls) {
        try {
            Object newInstance = cls.newInstance();
            if (newInstance != null) {
                return (l) newInstance;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.bugsnag.android.BugsnagPlugin");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void b(q client) {
        Set<Class<?>> M0;
        kotlin.jvm.internal.m.h(client, "client");
        M0 = kotlin.a0.z.M0(a);
        ArrayList<l> arrayList = new ArrayList();
        for (Class<?> cls : M0) {
            l a2 = f3667b.a(cls);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        for (l lVar : arrayList) {
            lVar.initialisePlugin(client);
        }
    }

    public final void c(Class<?> clz) {
        kotlin.jvm.internal.m.h(clz, "clz");
        a.add(clz);
    }
}