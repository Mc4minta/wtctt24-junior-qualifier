package com.facebook.react.uimanager;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import com.caverock.androidsvg.SVGParser;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.uimanager.h;
import com.facebook.react.uimanager.i;
import com.facebook.react.uimanager.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.i18n.TextBundle;

/* loaded from: classes2.dex */
public abstract class BaseViewManager<T extends View, C extends h> extends ViewManager<T, C> implements b<T> {
    private static final int PERSPECTIVE_ARRAY_INVERTED_CAMERA_DISTANCE_INDEX = 2;
    private static final String STATE_BUSY = "busy";
    private static final String STATE_CHECKED = "checked";
    private static final String STATE_EXPANDED = "expanded";
    private static final String STATE_MIXED = "mixed";
    public static final Map<String, Integer> sStateDescription;
    private static final float CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER = (float) Math.sqrt(5.0d);
    private static i.a sMatrixDecompositionContext = new i.a();
    private static double[] sTransformDecompositionArray = new double[16];

    static {
        HashMap hashMap = new HashMap();
        sStateDescription = hashMap;
        hashMap.put(STATE_BUSY, Integer.valueOf(e.f.m.h.p));
        hashMap.put(STATE_EXPANDED, Integer.valueOf(e.f.m.h.r));
        hashMap.put("collapsed", Integer.valueOf(e.f.m.h.q));
    }

    private void logUnsupportedPropertyWarning(String str) {
        e.f.d.d.a.C("ReactNative", "%s doesn't support property '%s'", getName(), str);
    }

    private static void resetTransformProperty(View view) {
        view.setTranslationX(o.c(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setTranslationY(o.c(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        view.setRotation(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationX(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setRotationY(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setCameraDistance(CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER);
    }

    private static float sanitizeFloatPropertyValue(float f2) {
        if (f2 < -3.4028235E38f || f2 > Float.MAX_VALUE) {
            if (f2 < -3.4028235E38f || f2 == Float.NEGATIVE_INFINITY) {
                return -3.4028235E38f;
            }
            if (f2 > Float.MAX_VALUE || f2 == Float.POSITIVE_INFINITY) {
                return Float.MAX_VALUE;
            }
            if (Float.isNaN(f2)) {
                return CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER;
            }
            throw new IllegalStateException("Invalid float property value: " + f2);
        }
        return f2;
    }

    private static void setTransformProperty(View view, ReadableArray readableArray) {
        sMatrixDecompositionContext.a();
        k0.b(readableArray, sTransformDecompositionArray);
        i.k(sTransformDecompositionArray, sMatrixDecompositionContext);
        view.setTranslationX(o.c(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5131d[0])));
        view.setTranslationY(o.c(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5131d[1])));
        view.setRotation(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5132e[2]));
        view.setRotationX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5132e[0]));
        view.setRotationY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5132e[1]));
        view.setScaleX(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5129b[0]));
        view.setScaleY(sanitizeFloatPropertyValue((float) sMatrixDecompositionContext.f5129b[1]));
        double[] dArr = sMatrixDecompositionContext.a;
        if (dArr.length > 2) {
            float f2 = (float) dArr[2];
            if (f2 == CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER) {
                f2 = 7.8125E-4f;
            }
            float f3 = (-1.0f) / f2;
            float f4 = c.e().density;
            view.setCameraDistance(sanitizeFloatPropertyValue(f4 * f4 * f3 * CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER));
        }
    }

    private void updateViewAccessibility(T t) {
        q.o(t);
    }

    private void updateViewContentDescription(T t) {
        Dynamic dynamic;
        String str = (String) t.getTag(e.f.m.f.f12824c);
        ReadableMap readableMap = (ReadableMap) t.getTag(e.f.m.f.f12826e);
        String str2 = (String) t.getTag(e.f.m.f.f12823b);
        ArrayList arrayList = new ArrayList();
        ReadableMap readableMap2 = (ReadableMap) t.getTag(e.f.m.f.f12827f);
        if (str != null) {
            arrayList.add(str);
        }
        if (readableMap != null) {
            ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                Dynamic dynamic2 = readableMap.getDynamic(nextKey);
                if (nextKey.equals(STATE_CHECKED) && dynamic2.getType() == ReadableType.String && dynamic2.asString().equals(STATE_MIXED)) {
                    arrayList.add(t.getContext().getString(e.f.m.h.s));
                } else if (nextKey.equals(STATE_BUSY) && dynamic2.getType() == ReadableType.Boolean && dynamic2.asBoolean()) {
                    arrayList.add(t.getContext().getString(e.f.m.h.p));
                } else if (nextKey.equals(STATE_EXPANDED) && dynamic2.getType() == ReadableType.Boolean) {
                    arrayList.add(t.getContext().getString(dynamic2.asBoolean() ? e.f.m.h.r : e.f.m.h.q));
                }
            }
        }
        if (readableMap2 != null && readableMap2.hasKey(TextBundle.TEXT_ENTRY) && (dynamic = readableMap2.getDynamic(TextBundle.TEXT_ENTRY)) != null && dynamic.getType() == ReadableType.String) {
            arrayList.add(dynamic.asString());
        }
        if (str2 != null) {
            arrayList.add(str2);
        }
        if (arrayList.size() > 0) {
            t.setContentDescription(TextUtils.join(", ", arrayList));
        }
    }

    @Override // com.facebook.react.uimanager.ViewManager
    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        return com.facebook.react.common.c.a().b("topAccessibilityAction", com.facebook.react.common.c.d("registrationName", "onAccessibilityAction")).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.react.uimanager.ViewManager
    public void onAfterUpdateTransaction(T t) {
        super.onAfterUpdateTransaction(t);
        updateViewAccessibility(t);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityActions")
    public void setAccessibilityActions(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            return;
        }
        t.setTag(e.f.m.f.a, readableArray);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityHint")
    public void setAccessibilityHint(T t, String str) {
        t.setTag(e.f.m.f.f12823b, str);
        updateViewContentDescription(t);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityLabel")
    public void setAccessibilityLabel(T t, String str) {
        t.setTag(e.f.m.f.f12824c, str);
        updateViewContentDescription(t);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityLiveRegion")
    public void setAccessibilityLiveRegion(T t, String str) {
        if (str != null && !str.equals("none")) {
            if (str.equals("polite")) {
                c.h.k.v.l0(t, 1);
                return;
            } else if (str.equals("assertive")) {
                c.h.k.v.l0(t, 2);
                return;
            } else {
                return;
            }
        }
        c.h.k.v.l0(t, 0);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityRole")
    public void setAccessibilityRole(T t, String str) {
        if (str == null) {
            return;
        }
        t.setTag(e.f.m.f.f12825d, q.c.h(str));
    }

    @com.facebook.react.uimanager.c1.a(name = "accessibilityValue")
    public void setAccessibilityValue(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        t.setTag(e.f.m.f.f12827f, readableMap);
        if (readableMap.hasKey(TextBundle.TEXT_ENTRY)) {
            updateViewContentDescription(t);
        }
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(customType = "Color", defaultInt = 0, name = "backgroundColor")
    public void setBackgroundColor(T t, int i2) {
        t.setBackgroundColor(i2);
    }

    @Override // com.facebook.react.uimanager.b
    public void setBorderBottomLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderBottomLeftRadius");
    }

    @Override // com.facebook.react.uimanager.b
    public void setBorderBottomRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderBottomRightRadius");
    }

    @Override // com.facebook.react.uimanager.b
    public void setBorderRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderRadius");
    }

    @Override // com.facebook.react.uimanager.b
    public void setBorderTopLeftRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderTopLeftRadius");
    }

    @Override // com.facebook.react.uimanager.b
    public void setBorderTopRightRadius(T t, float f2) {
        logUnsupportedPropertyWarning("borderTopRightRadius");
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "elevation")
    public void setElevation(T t, float f2) {
        c.h.k.v.q0(t, o.c(f2));
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "importantForAccessibility")
    public void setImportantForAccessibility(T t, String str) {
        if (str != null && !str.equals("auto")) {
            if (str.equals("yes")) {
                c.h.k.v.t0(t, 1);
                return;
            } else if (str.equals(SVGParser.XML_STYLESHEET_ATTR_ALTERNATE_NO)) {
                c.h.k.v.t0(t, 2);
                return;
            } else if (str.equals("no-hide-descendants")) {
                c.h.k.v.t0(t, 4);
                return;
            } else {
                return;
            }
        }
        c.h.k.v.t0(t, 0);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "nativeID")
    public void setNativeId(T t, String str) {
        t.setTag(e.f.m.f.f12829h, str);
        com.facebook.react.uimanager.g1.a.b(t);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(T t, float f2) {
        t.setAlpha(f2);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "renderToHardwareTextureAndroid")
    public void setRenderToHardwareTexture(T t, boolean z) {
        t.setLayerType(z ? 2 : 0, null);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "rotation")
    @Deprecated
    public void setRotation(T t, float f2) {
        t.setRotation(f2);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "scaleX")
    @Deprecated
    public void setScaleX(T t, float f2) {
        t.setScaleX(f2);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = 1.0f, name = "scaleY")
    @Deprecated
    public void setScaleY(T t, float f2) {
        t.setScaleY(f2);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "testID")
    public void setTestId(T t, String str) {
        t.setTag(e.f.m.f.f12828g, str);
        t.setTag(str);
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "transform")
    public void setTransform(T t, ReadableArray readableArray) {
        if (readableArray == null) {
            resetTransformProperty(t);
        } else {
            setTransformProperty(t, readableArray);
        }
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "translateX")
    @Deprecated
    public void setTranslateX(T t, float f2) {
        t.setTranslationX(o.c(f2));
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(defaultFloat = CAMERA_DISTANCE_NORMALIZATION_MULTIPLIER, name = "translateY")
    @Deprecated
    public void setTranslateY(T t, float f2) {
        t.setTranslationY(o.c(f2));
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "accessibilityState")
    public void setViewState(T t, ReadableMap readableMap) {
        if (readableMap == null) {
            return;
        }
        t.setTag(e.f.m.f.f12826e, readableMap);
        t.setSelected(false);
        t.setEnabled(true);
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            if (!nextKey.equals(STATE_BUSY) && !nextKey.equals(STATE_EXPANDED) && (!nextKey.equals(STATE_CHECKED) || readableMap.getType(STATE_CHECKED) != ReadableType.String)) {
                if (Build.VERSION.SDK_INT >= 21 && t.isAccessibilityFocused()) {
                    t.sendAccessibilityEvent(1);
                }
            } else {
                updateViewContentDescription(t);
                return;
            }
        }
    }

    @Override // com.facebook.react.uimanager.b
    @com.facebook.react.uimanager.c1.a(name = "zIndex")
    public void setZIndex(T t, float f2) {
        ViewGroupManager.setViewZIndex(t, Math.round(f2));
        ViewParent parent = t.getParent();
        if (parent instanceof c0) {
            ((c0) parent).d();
        }
    }
}