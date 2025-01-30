package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.b;
import e.f.m.a0.l;

/* compiled from: AndroidSwitchManagerDelegate.java */
/* loaded from: classes2.dex */
public class k<T extends View, U extends com.facebook.react.uimanager.b<T> & l<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public k(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1742453971:
                if (str.equals("thumbColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1609594047:
                if (str.equals("enabled")) {
                    c2 = 1;
                    break;
                }
                break;
            case -287374307:
                if (str.equals("trackTintColor")) {
                    c2 = 2;
                    break;
                }
                break;
            case 3551:
                if (str.equals("on")) {
                    c2 = 3;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c2 = 4;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1084662482:
                if (str.equals("trackColorForFalse")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c2 = 7;
                    break;
                }
                break;
            case 2113632767:
                if (str.equals("trackColorForTrue")) {
                    c2 = '\b';
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((l) this.a).setThumbColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 1:
                ((l) this.a).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 2:
                ((l) this.a).setTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 3:
                ((l) this.a).setOn(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 4:
                ((l) this.a).setValue(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 5:
                ((l) this.a).setDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 6:
                ((l) this.a).setTrackColorForFalse(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 7:
                ((l) this.a).setThumbTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case '\b':
                ((l) this.a).setTrackColorForTrue(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}