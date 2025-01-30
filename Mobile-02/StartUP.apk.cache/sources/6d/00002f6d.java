package com.facebook.react.uimanager;

import com.facebook.react.uimanager.UIManagerModule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ViewManagerRegistry.java */
/* loaded from: classes2.dex */
public final class y0 {
    private final Map<String, ViewManager> a;

    /* renamed from: b  reason: collision with root package name */
    private final UIManagerModule.g f5271b;

    public y0(UIManagerModule.g gVar) {
        this.a = com.facebook.react.common.c.b();
        this.f5271b = gVar;
    }

    private ViewManager b(String str) {
        ViewManager b2 = this.f5271b.b(str);
        if (b2 != null) {
            this.a.put(str, b2);
        }
        return b2;
    }

    public ViewManager a(String str) {
        ViewManager viewManager = this.a.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.f5271b != null) {
            ViewManager b2 = b(str);
            if (b2 != null) {
                return b2;
            }
            throw new IllegalViewOperationException("ViewManagerResolver returned null for " + str);
        }
        throw new IllegalViewOperationException("No ViewManager found for class " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewManager c(String str) {
        ViewManager viewManager = this.a.get(str);
        if (viewManager != null) {
            return viewManager;
        }
        if (this.f5271b != null) {
            return b(str);
        }
        return null;
    }

    public y0(List<ViewManager> list) {
        HashMap b2 = com.facebook.react.common.c.b();
        for (ViewManager viewManager : list) {
            b2.put(viewManager.getName(), viewManager);
        }
        this.a = b2;
        this.f5271b = null;
    }
}