package com.facebook.react.uimanager;

import com.facebook.react.uimanager.UIManagerModule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: UIManagerModuleConstantsHelper.java */
/* loaded from: classes2.dex */
public class q0 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> a(UIManagerModule.g gVar) {
        Map<String, Object> b2 = p0.b();
        b2.put("ViewManagerNames", gVar.a());
        b2.put("LazyViewManagersEnabled", Boolean.TRUE);
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> b(List<ViewManager> list, Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> b2 = p0.b();
        Map<? extends String, ? extends Object> a = p0.a();
        Map<? extends String, ? extends Object> c2 = p0.c();
        if (map != null) {
            map.putAll(a);
        }
        if (map2 != null) {
            map2.putAll(c2);
        }
        for (ViewManager viewManager : list) {
            String name = viewManager.getName();
            com.facebook.systrace.b.a(0L, "UIManagerModuleConstantsHelper.createConstants").b("ViewManager", name).b("Lazy", Boolean.FALSE).c();
            try {
                Map<String, Object> c3 = c(viewManager, null, null, map, map2);
                if (!c3.isEmpty()) {
                    b2.put(name, c3);
                }
            } finally {
                com.facebook.systrace.b.b(0L);
            }
        }
        b2.put("genericBubblingEventTypes", a);
        b2.put("genericDirectEventTypes", c2);
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> c(ViewManager viewManager, Map map, Map map2, Map map3, Map map4) {
        HashMap b2 = com.facebook.react.common.c.b();
        Map<String, Object> exportedCustomBubblingEventTypeConstants = viewManager.getExportedCustomBubblingEventTypeConstants();
        if (exportedCustomBubblingEventTypeConstants != null) {
            e(map3, exportedCustomBubblingEventTypeConstants);
            e(exportedCustomBubblingEventTypeConstants, map);
            b2.put("bubblingEventTypes", exportedCustomBubblingEventTypeConstants);
        } else if (map != null) {
            b2.put("bubblingEventTypes", map);
        }
        Map<String, Object> exportedCustomDirectEventTypeConstants = viewManager.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants != null) {
            e(map4, exportedCustomDirectEventTypeConstants);
            e(exportedCustomDirectEventTypeConstants, map2);
            b2.put("directEventTypes", exportedCustomDirectEventTypeConstants);
        } else if (map2 != null) {
            b2.put("directEventTypes", map2);
        }
        Map<String, Object> exportedViewConstants = viewManager.getExportedViewConstants();
        if (exportedViewConstants != null) {
            b2.put("Constants", exportedViewConstants);
        }
        Map<String, Integer> commandsMap = viewManager.getCommandsMap();
        if (commandsMap != null) {
            b2.put("Commands", commandsMap);
        }
        Map<String, String> nativeProps = viewManager.getNativeProps();
        if (!nativeProps.isEmpty()) {
            b2.put("NativeProps", nativeProps);
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> d() {
        return com.facebook.react.common.c.e("bubblingEventTypes", p0.a(), "directEventTypes", p0.c());
    }

    private static void e(Map map, Map map2) {
        if (map == null || map2 == null || map2.isEmpty()) {
            return;
        }
        for (Object obj : map2.keySet()) {
            Object obj2 = map2.get(obj);
            Object obj3 = map.get(obj);
            if (obj3 != null && (obj2 instanceof Map) && (obj3 instanceof Map)) {
                e((Map) obj3, (Map) obj2);
            } else {
                map.put(obj, obj2);
            }
        }
    }
}