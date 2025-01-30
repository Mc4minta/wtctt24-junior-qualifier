package com.facebook.react.views.view;

import android.annotation.TargetApi;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.i0;
import com.facebook.react.uimanager.o;
import com.facebook.react.uimanager.p;
import java.util.Locale;
import java.util.Map;

@e.f.m.x.a.a(name = ReactViewManager.REACT_CLASS)
/* loaded from: classes2.dex */
public class ReactViewManager extends ReactClippingViewManager<f> {
    private static final int CMD_HOTSPOT_UPDATE = 1;
    private static final int CMD_SET_PRESSED = 2;
    private static final String HOTSPOT_UPDATE_KEY = "hotspotUpdate";
    public static final String REACT_CLASS = "RCTView";
    private static final int[] SPACING_TYPES = {8, 0, 2, 1, 3, 4, 5};

    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        final /* synthetic */ f a;

        a(f fVar) {
            this.a = fVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ((UIManagerModule) ((ReactContext) this.a.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().v(new g(this.a.getId()));
        }
    }

    private void handleHotspotUpdate(f fVar, ReadableArray readableArray) {
        if (readableArray != null && readableArray.size() == 2) {
            if (Build.VERSION.SDK_INT >= 21) {
                fVar.drawableHotspotChanged(o.b(readableArray.getDouble(0)), o.b(readableArray.getDouble(1)));
                return;
            }
            return;
        }
        throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'updateHotspot' command");
    }

    private void handleSetPressed(f fVar, ReadableArray readableArray) {
        if (readableArray != null && readableArray.size() == 1) {
            fVar.setPressed(readableArray.getBoolean(0));
            return;
        }
        throw new JSApplicationIllegalArgumentException("Illegal number of arguments for 'setPressed' command");
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Integer> getCommandsMap() {
        return com.facebook.react.common.c.e(HOTSPOT_UPDATE_KEY, 1, "setPressed", 2);
    }

    @Override // com.facebook.react.uimanager.ViewManager, com.facebook.react.bridge.NativeModule
    public String getName() {
        return REACT_CLASS;
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "nextFocusDown")
    public void nextFocusDown(f fVar, int i2) {
        fVar.setNextFocusDownId(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "nextFocusForward")
    public void nextFocusForward(f fVar, int i2) {
        fVar.setNextFocusForwardId(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "nextFocusLeft")
    public void nextFocusLeft(f fVar, int i2) {
        fVar.setNextFocusLeftId(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "nextFocusRight")
    public void nextFocusRight(f fVar, int i2) {
        fVar.setNextFocusRightId(i2);
    }

    @com.facebook.react.uimanager.c1.a(defaultInt = -1, name = "nextFocusUp")
    public void nextFocusUp(f fVar, int i2) {
        fVar.setNextFocusUpId(i2);
    }

    @com.facebook.react.uimanager.c1.a(name = "accessible")
    public void setAccessible(f fVar, boolean z) {
        fVar.setFocusable(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "backfaceVisibility")
    public void setBackfaceVisibility(f fVar, String str) {
        fVar.setBackfaceVisibility(str);
    }

    @com.facebook.react.uimanager.c1.b(customType = "Color", names = {"borderColor", "borderLeftColor", "borderRightColor", "borderTopColor", "borderBottomColor", "borderStartColor", "borderEndColor"})
    public void setBorderColor(f fVar, int i2, Integer num) {
        fVar.r(SPACING_TYPES[i2], num == null ? Float.NaN : num.intValue() & 16777215, num != null ? num.intValue() >>> 24 : Float.NaN);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderRadius", "borderTopLeftRadius", "borderTopRightRadius", "borderBottomRightRadius", "borderBottomLeftRadius", "borderTopStartRadius", "borderTopEndRadius", "borderBottomStartRadius", "borderBottomEndRadius"})
    public void setBorderRadius(f fVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        if (i2 == 0) {
            fVar.setBorderRadius(f2);
        } else {
            fVar.s(f2, i2 - 1);
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "borderStyle")
    public void setBorderStyle(f fVar, String str) {
        fVar.setBorderStyle(str);
    }

    @com.facebook.react.uimanager.c1.b(defaultFloat = Float.NaN, names = {"borderWidth", "borderLeftWidth", "borderRightWidth", "borderTopWidth", "borderBottomWidth", "borderStartWidth", "borderEndWidth"})
    public void setBorderWidth(f fVar, int i2, float f2) {
        if (!com.facebook.yoga.g.a(f2) && f2 < 0.0f) {
            f2 = Float.NaN;
        }
        if (!com.facebook.yoga.g.a(f2)) {
            f2 = o.c(f2);
        }
        fVar.t(SPACING_TYPES[i2], f2);
    }

    @com.facebook.react.uimanager.c1.a(name = "collapsable")
    public void setCollapsable(f fVar, boolean z) {
    }

    @com.facebook.react.uimanager.c1.a(name = "focusable")
    public void setFocusable(f fVar, boolean z) {
        if (z) {
            fVar.setOnClickListener(new a(fVar));
            fVar.setFocusable(true);
            return;
        }
        fVar.setOnClickListener(null);
        fVar.setClickable(false);
    }

    @com.facebook.react.uimanager.c1.a(name = "hitSlop")
    public void setHitSlop(f fVar, ReadableMap readableMap) {
        if (readableMap == null) {
            fVar.setHitSlopRect(null);
        } else {
            fVar.setHitSlopRect(new Rect(readableMap.hasKey("left") ? (int) o.b(readableMap.getDouble("left")) : 0, readableMap.hasKey("top") ? (int) o.b(readableMap.getDouble("top")) : 0, readableMap.hasKey("right") ? (int) o.b(readableMap.getDouble("right")) : 0, readableMap.hasKey("bottom") ? (int) o.b(readableMap.getDouble("bottom")) : 0));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "nativeBackgroundAndroid")
    public void setNativeBackground(f fVar, ReadableMap readableMap) {
        fVar.setTranslucentBackgroundDrawable(readableMap == null ? null : c.a(fVar.getContext(), readableMap));
    }

    @TargetApi(23)
    @com.facebook.react.uimanager.c1.a(name = "nativeForegroundAndroid")
    public void setNativeForeground(f fVar, ReadableMap readableMap) {
        fVar.setForeground(readableMap == null ? null : c.a(fVar.getContext(), readableMap));
    }

    @com.facebook.react.uimanager.c1.a(name = "needsOffscreenAlphaCompositing")
    public void setNeedsOffscreenAlphaCompositing(f fVar, boolean z) {
        fVar.setNeedsOffscreenAlphaCompositing(z);
    }

    @com.facebook.react.uimanager.c1.a(name = "overflow")
    public void setOverflow(f fVar, String str) {
        fVar.setOverflow(str);
    }

    @com.facebook.react.uimanager.c1.a(name = "pointerEvents")
    public void setPointerEvents(f fVar, String str) {
        if (str == null) {
            fVar.setPointerEvents(p.AUTO);
        } else {
            fVar.setPointerEvents(p.valueOf(str.toUpperCase(Locale.US).replace("-", "_")));
        }
    }

    @com.facebook.react.uimanager.c1.a(name = "hasTVPreferredFocus")
    public void setTVPreferredFocus(f fVar, boolean z) {
        if (z) {
            fVar.setFocusable(true);
            fVar.setFocusableInTouchMode(true);
            fVar.requestFocus();
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public f createViewInstance(i0 i0Var) {
        return new f(i0Var);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    public void setOpacity(f fVar, float f2) {
        fVar.setOpacityIfPossible(f2);
    }

    @Override // com.facebook.react.uimanager.BaseViewManager, com.facebook.react.uimanager.b
    public void setTransform(f fVar, ReadableArray readableArray) {
        super.setTransform((ReactViewManager) fVar, readableArray);
        fVar.q();
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(f fVar, int i2, ReadableArray readableArray) {
        if (i2 == 1) {
            handleHotspotUpdate(fVar, readableArray);
        } else if (i2 != 2) {
        } else {
            handleSetPressed(fVar, readableArray);
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public void receiveCommand(f fVar, String str, ReadableArray readableArray) {
        str.hashCode();
        if (str.equals("setPressed")) {
            handleSetPressed(fVar, readableArray);
        } else if (str.equals(HOTSPOT_UPDATE_KEY)) {
            handleHotspotUpdate(fVar, readableArray);
        }
    }
}