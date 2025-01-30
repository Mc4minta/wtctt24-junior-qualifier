package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.d;
import com.facebook.react.uimanager.i0;
import com.facebook.react.views.picker.a;

/* loaded from: classes2.dex */
public abstract class ReactPickerManager extends SimpleViewManager<com.facebook.react.views.picker.a> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements a.c {
        private final com.facebook.react.views.picker.a a;

        /* renamed from: b  reason: collision with root package name */
        private final d f5333b;

        public a(com.facebook.react.views.picker.a aVar, d dVar) {
            this.a = aVar;
            this.f5333b = dVar;
        }

        @Override // com.facebook.react.views.picker.a.c
        public void a(int i2) {
            this.f5333b.v(new com.facebook.react.views.picker.d.a(this.a.getId(), i2));
        }
    }

    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public void setColor(com.facebook.react.views.picker.a aVar, Integer num) {
        aVar.setStagedPrimaryTextColor(num);
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(com.facebook.react.views.picker.a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "items")
    public void setItems(com.facebook.react.views.picker.a aVar, ReadableArray readableArray) {
        aVar.setStagedItems(c.a(readableArray));
    }

    @com.facebook.react.uimanager.c1.a(name = "prompt")
    public void setPrompt(com.facebook.react.views.picker.a aVar, String str) {
        aVar.setPrompt(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "selected")
    public void setSelected(com.facebook.react.views.picker.a aVar, int i2) {
        aVar.setStagedSelection(i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.picker.a aVar) {
        aVar.setOnSelectListener(new a(aVar, ((UIManagerModule) i0Var.getNativeModule(UIManagerModule.class)).getEventDispatcher()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(com.facebook.react.views.picker.a aVar) {
        super.onAfterUpdateTransaction((ReactPickerManager) aVar);
        aVar.b();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.picker.a aVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeSelectedPosition") && readableArray != null) {
            aVar.setImmediateSelection(readableArray.getInt(0));
        }
    }
}