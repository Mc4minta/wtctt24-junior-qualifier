package com.facebook.react.uimanager.g1;

import android.view.View;
import e.f.m.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: ReactFindViewUtil.java */
/* loaded from: classes2.dex */
public class a {
    private static final List<b> a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static final Map<InterfaceC0124a, Set<String>> f5127b = new HashMap();

    /* compiled from: ReactFindViewUtil.java */
    /* renamed from: com.facebook.react.uimanager.g1.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0124a {
        void a(View view, String str);
    }

    /* compiled from: ReactFindViewUtil.java */
    /* loaded from: classes2.dex */
    public interface b {
        String a();

        void b(View view);
    }

    private static String a(View view) {
        Object tag = view.getTag(f.f12829h);
        if (tag instanceof String) {
            return (String) tag;
        }
        return null;
    }

    public static void b(View view) {
        String a2 = a(view);
        if (a2 == null) {
            return;
        }
        Iterator<b> it = a.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (a2.equals(next.a())) {
                next.b(view);
                it.remove();
            }
        }
        for (Map.Entry<InterfaceC0124a, Set<String>> entry : f5127b.entrySet()) {
            Set<String> value = entry.getValue();
            if (value != null && value.contains(a2)) {
                entry.getKey().a(view, a2);
            }
        }
    }
}