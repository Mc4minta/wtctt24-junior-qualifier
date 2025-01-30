package com.facebook.react.views.picker;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.w0;
import e.f.m.a0.e;
import e.f.m.a0.f;

@e.f.m.x.a.a(name = ReactDropdownPickerManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactDropdownPickerManager extends ReactPickerManager implements f<a> {
    public static final String REACT_CLASS = "AndroidDropdownPicker";
    private final w0<a> mDelegate = new e(this);

    @Override // com.facebook.react.uimanager.ViewManager
    protected w0<a> getDelegate() {
        return this.mDelegate;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @Override // e.f.m.a0.f
    @com.facebook.react.uimanager.c1.a(customType = "Color", name = "color")
    public /* bridge */ /* synthetic */ void setColor(a aVar, Integer num) {
        super.setColor(aVar, num);
    }

    @Override // e.f.m.a0.f
    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public /* bridge */ /* synthetic */ void setEnabled(a aVar, boolean z) {
        super.setEnabled(aVar, z);
    }

    @Override // e.f.m.a0.f
    @com.facebook.react.uimanager.c1.a(name = "items")
    public /* bridge */ /* synthetic */ void setItems(a aVar, ReadableArray readableArray) {
        super.setItems(aVar, readableArray);
    }

    @Override // e.f.m.a0.f
    @com.facebook.react.uimanager.c1.a(name = "prompt")
    public /* bridge */ /* synthetic */ void setPrompt(a aVar, String str) {
        super.setPrompt(aVar, str);
    }

    @Override // e.f.m.a0.f
    @com.facebook.react.uimanager.c1.a(name = "selected")
    public /* bridge */ /* synthetic */ void setSelected(a aVar, int i2) {
        super.setSelected(aVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public a createViewInstance(i0 i0Var) {
        return new a(i0Var, 1);
    }
}