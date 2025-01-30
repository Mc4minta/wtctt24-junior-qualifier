package com.facebook.react.views.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.TypedValue;
import android.widget.CompoundButton;
import androidx.appcompat.widget.p0;
import androidx.core.widget.c;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.i0;

/* loaded from: classes2.dex */
public class ReactCheckBoxManager extends SimpleViewManager<com.facebook.react.views.checkbox.a> {
    private static final CompoundButton.OnCheckedChangeListener ON_CHECKED_CHANGE_LISTENER = new a();
    public static final String REACT_CLASS = "AndroidCheckBox";

    /* loaded from: classes2.dex */
    static class a implements CompoundButton.OnCheckedChangeListener {
        a() {
        }

        private ReactContext a(CompoundButton compoundButton) {
            Context context = compoundButton.getContext();
            if (context instanceof p0) {
                return (ReactContext) ((p0) context).getBaseContext();
            }
            return (ReactContext) compoundButton.getContext();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            ((UIManagerModule) a(compoundButton).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new b(compoundButton.getId(), z));
        }
    }

    private static int getIdentifier(Context context, String str) {
        return context.getResources().getIdentifier(str, "attr", context.getPackageName());
    }

    private static int getThemeColor(Context context, String str) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(getIdentifier(context, str), typedValue, true);
        return typedValue.data;
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(defaultBoolean = true, name = "enabled")
    public void setEnabled(com.facebook.react.views.checkbox.a aVar, boolean z) {
        aVar.setEnabled(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "on")
    public void setOn(com.facebook.react.views.checkbox.a aVar, boolean z) {
        aVar.setOnCheckedChangeListener(null);
        aVar.a(z);
        aVar.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    @com.facebook.react.uimanager.c1.a(name = "tintColors")
    public void setTintColors(com.facebook.react.views.checkbox.a aVar, ReadableMap readableMap) {
        int themeColor;
        int themeColor2;
        if (readableMap != null && readableMap.hasKey("true")) {
            themeColor = readableMap.getInt("true");
        } else {
            themeColor = getThemeColor(aVar.getContext(), "colorAccent");
        }
        if (readableMap != null && readableMap.hasKey("false")) {
            themeColor2 = readableMap.getInt("false");
        } else {
            themeColor2 = getThemeColor(aVar.getContext(), "colorPrimaryDark");
        }
        c.b(aVar, new ColorStateList(new int[][]{new int[]{16842912}, new int[]{-16842912}}, new int[]{themeColor, themeColor2}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void addEventEmitters(i0 i0Var, com.facebook.react.views.checkbox.a aVar) {
        aVar.setOnCheckedChangeListener(ON_CHECKED_CHANGE_LISTENER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public com.facebook.react.views.checkbox.a createViewInstance(i0 i0Var) {
        return new com.facebook.react.views.checkbox.a(i0Var);
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(com.facebook.react.views.checkbox.a aVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setNativeValue") && readableArray != null) {
            setOn(aVar, readableArray.getBoolean(0));
        }
    }
}