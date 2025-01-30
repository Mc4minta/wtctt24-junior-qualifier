package com.facebook.react.views.drawer;

import android.view.View;
import c.k.d.a;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.w0;
import com.facebook.react.views.drawer.b.b;
import e.f.m.a0.c;
import e.f.m.a0.d;
import java.util.Map;

@e.f.m.x.a.a(name = ReactDrawerLayoutManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactDrawerLayoutManager extends ViewGroupManager<com.facebook.react.views.drawer.a> implements d<com.facebook.react.views.drawer.a> {
    public static final int CLOSE_DRAWER = 2;
    public static final int OPEN_DRAWER = 1;
    public static final String REACT_CLASS = "AndroidDrawerLayout";
    private final w0<com.facebook.react.views.drawer.a> mDelegate = new c(this);

    /* loaded from: classes2.dex */
    public static class a implements a.e {
        private final c.k.d.a a;

        /* renamed from: b  reason: collision with root package name */
        private final com.facebook.react.uimanager.events.d f5297b;

        public a(c.k.d.a aVar, com.facebook.react.uimanager.events.d dVar) {
            this.a = aVar;
            this.f5297b = dVar;
        }

        @Override // c.k.d.a.e
        public void a(View view) {
            this.f5297b.v(new b(this.a.getId()));
        }

        @Override // c.k.d.a.e
        public void b(View view) {
            this.f5297b.v(new com.facebook.react.views.drawer.b.a(this.a.getId()));
        }

        @Override // c.k.d.a.e
        public void c(int i2) {
            this.f5297b.v(new com.facebook.react.views.drawer.b.d(this.a.getId(), i2));
        }

        @Override // c.k.d.a.e
        public void d(View view, float f2) {
            this.f5297b.v(new com.facebook.react.views.drawer.b.c(this.a.getId(), f2));
        }
    }

    private void setDrawerPositionInternal(com.facebook.react.views.drawer.a aVar, String str) {
        if (str.equals("left")) {
            aVar.Y(8388611);
        } else if (str.equals("right")) {
            aVar.Y(8388613);
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be 'left' or 'right', received" + str);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.e("openDrawer", 1, "closeDrawer", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public w0<com.facebook.react.views.drawer.a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public Map getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.g("topDrawerSlide", com.facebook.react.common.c.d("registrationName", "onDrawerSlide"), "topDrawerOpen", com.facebook.react.common.c.d("registrationName", "onDrawerOpen"), "topDrawerClose", com.facebook.react.common.c.d("registrationName", "onDrawerClose"), "topDrawerStateChanged", com.facebook.react.common.c.d("registrationName", "onDrawerStateChanged"));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map getExportedViewConstants() {
        return com.facebook.react.common.c.d("DrawerPosition", com.facebook.react.common.c.e("Left", 8388611, "Right", 8388613));
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager, com.facebook.react.uimanager.f
    public boolean needsCustomLayoutForChildren() {
        return true;
    }

    @Override // e.f.m.a0.d
    public void setDrawerBackgroundColor(com.facebook.react.views.drawer.a aVar, Integer num) {
    }

    @Override // e.f.m.a0.d
    public void setKeyboardDismissMode(com.facebook.react.views.drawer.a aVar, String str) {
    }

    @Override // e.f.m.a0.d
    public void setStatusBarBackgroundColor(com.facebook.react.views.drawer.a aVar, Integer num) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.drawer.a aVar) {
        aVar.a(new a(aVar, ((UIManagerModule) i0Var.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    @Override // com.facebook.react.uimanager.ViewGroupManager
    public void addView(com.facebook.react.views.drawer.a aVar, View view, int i2) {
        if (getChildCount(aVar) >= 2) {
            throw new JSApplicationIllegalArgumentException("The Drawer cannot have more than two children");
        }
        if (i2 != 0 && i2 != 1) {
            throw new JSApplicationIllegalArgumentException("The only valid indices for drawer's child are 0 or 1. Got " + i2 + " instead.");
        }
        aVar.addView(view, i2);
        aVar.Z();
    }

    public void closeDrawer(com.facebook.react.views.drawer.a aVar) {
        aVar.W();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.drawer.a createViewInstance(i0 i0Var) {
        return new com.facebook.react.views.drawer.a(i0Var);
    }

    public void openDrawer(com.facebook.react.views.drawer.a aVar) {
        aVar.X();
    }

    @Override // e.f.m.a0.d
    @com.facebook.react.uimanager.c1.a(name = "drawerLockMode")
    public void setDrawerLockMode(com.facebook.react.views.drawer.a aVar, String str) {
        if (str != null && !"unlocked".equals(str)) {
            if ("locked-closed".equals(str)) {
                aVar.setDrawerLockMode(1);
                return;
            } else if ("locked-open".equals(str)) {
                aVar.setDrawerLockMode(2);
                return;
            } else {
                throw new JSApplicationIllegalArgumentException("Unknown drawerLockMode " + str);
            }
        }
        aVar.setDrawerLockMode(0);
    }

    @Override // e.f.m.a0.d
    public void setDrawerPosition(com.facebook.react.views.drawer.a aVar, String str) {
        if (str == null) {
            aVar.Y(8388611);
        } else {
            setDrawerPositionInternal(aVar, str);
        }
    }

    @com.facebook.react.uimanager.c1.a(defaultFloat = Float.NaN, name = "drawerWidth")
    public void setDrawerWidth(com.facebook.react.views.drawer.a aVar, float f2) {
        aVar.a0(Float.isNaN(f2) ? -1 : Math.round(o.c(f2)));
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    public void setElevation(com.facebook.react.views.drawer.a aVar, float f2) {
        aVar.setDrawerElevation(o.c(f2));
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.drawer.a aVar, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            aVar.X();
        } else if (i2 != 2) {
        } else {
            aVar.W();
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "drawerPosition")
    public void setDrawerPosition(com.facebook.react.views.drawer.a aVar, Dynamic dynamic) {
        if (dynamic.isNull()) {
            aVar.Y(8388611);
        } else if (dynamic.getType() == ReadableType.Number) {
            int asInt = dynamic.asInt();
            if (8388611 != asInt && 8388613 != asInt) {
                throw new JSApplicationIllegalArgumentException("Unknown drawerPosition " + asInt);
            }
            aVar.Y(asInt);
        } else if (dynamic.getType() == ReadableType.String) {
            setDrawerPositionInternal(aVar, dynamic.asString());
        } else {
            throw new JSApplicationIllegalArgumentException("drawerPosition must be a string or int");
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.drawer.a aVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("closeDrawer")) {
            aVar.W();
        } else if (str.equals("openDrawer")) {
            aVar.X();
        }
    }

    @Override // e.f.m.a0.d
    public void setDrawerWidth(com.facebook.react.views.drawer.a aVar, Float f2) {
        aVar.a0(f2 == null ? -1 : Math.round(o.c(f2.floatValue())));
    }
}