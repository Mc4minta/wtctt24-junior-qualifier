package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.b;
import e.f.m.a0.d;

/* compiled from: AndroidDrawerLayoutManagerDelegate.java */
/* loaded from: classes2.dex */
public class c<T extends View, U extends com.facebook.react.uimanager.b<T> & d<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public c(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -2082382380:
                if (str.equals("statusBarBackgroundColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1233873500:
                if (str.equals("drawerBackgroundColor")) {
                    c2 = 1;
                    break;
                }
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c2 = 2;
                    break;
                }
                break;
            case 268251989:
                if (str.equals("drawerWidth")) {
                    c2 = 3;
                    break;
                }
                break;
            case 695891258:
                if (str.equals("drawerPosition")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1857208703:
                if (str.equals("drawerLockMode")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((d) this.a).setStatusBarBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 1:
                ((d) this.a).setDrawerBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 2:
                ((d) this.a).setKeyboardDismissMode(t, (String) obj);
                return;
            case 3:
                ((d) this.a).setDrawerWidth(t, obj == null ? null : Float.valueOf(((Double) obj).floatValue()));
                return;
            case 4:
                ((d) this.a).setDrawerPosition(t, (String) obj);
                return;
            case 5:
                ((d) this.a).setDrawerLockMode(t, (String) obj);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}