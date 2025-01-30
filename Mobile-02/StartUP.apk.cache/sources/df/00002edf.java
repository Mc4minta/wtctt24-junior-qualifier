package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.b;
import org.apache.http.message.TokenParser;

/* compiled from: BaseViewManagerDelegate.java */
/* loaded from: classes2.dex */
public abstract class a<T extends View, U extends b<T>> implements w0<T> {
    protected final U a;

    public a(U u) {
        this.a = u;
    }

    @Override // com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1721943862:
                if (str.equals("translateX")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1721943861:
                if (str.equals("translateY")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1267206133:
                if (str.equals("opacity")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1228066334:
                if (str.equals("borderTopLeftRadius")) {
                    c2 = 3;
                    break;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    c2 = 4;
                    break;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    c2 = 5;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    c2 = 6;
                    break;
                }
                break;
            case -731417480:
                if (str.equals("zIndex")) {
                    c2 = 7;
                    break;
                }
                break;
            case -101663499:
                if (str.equals("accessibilityHint")) {
                    c2 = '\b';
                    break;
                }
                break;
            case -101359900:
                if (str.equals("accessibilityRole")) {
                    c2 = '\t';
                    break;
                }
                break;
            case -80891667:
                if (str.equals("renderToHardwareTextureAndroid")) {
                    c2 = '\n';
                    break;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    c2 = 11;
                    break;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 36255470:
                if (str.equals("accessibilityLiveRegion")) {
                    c2 = TokenParser.CR;
                    break;
                }
                break;
            case 333432965:
                if (str.equals("borderTopRightRadius")) {
                    c2 = 14;
                    break;
                }
                break;
            case 581268560:
                if (str.equals("borderBottomLeftRadius")) {
                    c2 = 15;
                    break;
                }
                break;
            case 588239831:
                if (str.equals("borderBottomRightRadius")) {
                    c2 = 16;
                    break;
                }
                break;
            case 746986311:
                if (str.equals("importantForAccessibility")) {
                    c2 = 17;
                    break;
                }
                break;
            case 1052666732:
                if (str.equals("transform")) {
                    c2 = 18;
                    break;
                }
                break;
            case 1146842694:
                if (str.equals("accessibilityLabel")) {
                    c2 = 19;
                    break;
                }
                break;
            case 1153872867:
                if (str.equals("accessibilityState")) {
                    c2 = 20;
                    break;
                }
                break;
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c2 = 21;
                    break;
                }
                break;
            case 1349188574:
                if (str.equals("borderRadius")) {
                    c2 = 22;
                    break;
                }
                break;
            case 1505602511:
                if (str.equals("accessibilityActions")) {
                    c2 = 23;
                    break;
                }
                break;
            case 2045685618:
                if (str.equals("nativeID")) {
                    c2 = 24;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                this.a.setTranslateX(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                return;
            case 1:
                this.a.setTranslateY(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                return;
            case 2:
                this.a.setOpacity(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                return;
            case 3:
                this.a.setBorderTopLeftRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                return;
            case 4:
                this.a.setScaleX(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                return;
            case 5:
                this.a.setScaleY(t, obj != null ? ((Double) obj).floatValue() : 1.0f);
                return;
            case 6:
                this.a.setTestId(t, (String) obj);
                return;
            case 7:
                this.a.setZIndex(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                return;
            case '\b':
                this.a.setAccessibilityHint(t, (String) obj);
                return;
            case '\t':
                this.a.setAccessibilityRole(t, (String) obj);
                return;
            case '\n':
                this.a.setRenderToHardwareTexture(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 11:
                this.a.setRotation(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                return;
            case '\f':
                this.a.setElevation(t, obj != null ? ((Double) obj).floatValue() : 0.0f);
                return;
            case '\r':
                this.a.setAccessibilityLiveRegion(t, (String) obj);
                return;
            case 14:
                this.a.setBorderTopRightRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                return;
            case 15:
                this.a.setBorderBottomLeftRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                return;
            case 16:
                this.a.setBorderBottomRightRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                return;
            case 17:
                this.a.setImportantForAccessibility(t, (String) obj);
                return;
            case 18:
                this.a.setTransform(t, (ReadableArray) obj);
                return;
            case 19:
                this.a.setAccessibilityLabel(t, (String) obj);
                return;
            case 20:
                this.a.setViewState(t, (ReadableMap) obj);
                return;
            case 21:
                this.a.setBackgroundColor(t, obj != null ? ColorPropConverter.getColor(obj, t.getContext()).intValue() : 0);
                return;
            case 22:
                this.a.setBorderRadius(t, obj != null ? ((Double) obj).floatValue() : Float.NaN);
                return;
            case 23:
                this.a.setAccessibilityActions(t, (ReadableArray) obj);
                return;
            case 24:
                this.a.setNativeId(t, (String) obj);
                return;
            default:
                return;
        }
    }
}