package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.b;
import e.f.m.a0.p;

/* compiled from: ModalHostViewManagerDelegate.java */
/* loaded from: classes2.dex */
public class o<T extends View, U extends com.facebook.react.uimanager.b<T> & p<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public o(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1851617609:
                if (str.equals("presentationStyle")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1850124175:
                if (str.equals("supportedOrientations")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1726194350:
                if (str.equals("transparent")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1618432855:
                if (str.equals("identifier")) {
                    c2 = 3;
                    break;
                }
                break;
            case -1156137512:
                if (str.equals("statusBarTranslucent")) {
                    c2 = 4;
                    break;
                }
                break;
            case -795203165:
                if (str.equals("animated")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1195991583:
                if (str.equals("hardwareAccelerated")) {
                    c2 = 6;
                    break;
                }
                break;
            case 2031205598:
                if (str.equals("animationType")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((p) this.a).setPresentationStyle(t, (String) obj);
                return;
            case 1:
                ((p) this.a).setSupportedOrientations(t, (ReadableArray) obj);
                return;
            case 2:
                ((p) this.a).setTransparent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 3:
                ((p) this.a).setIdentifier(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 4:
                ((p) this.a).setStatusBarTranslucent(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 5:
                ((p) this.a).setAnimated(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 6:
                ((p) this.a).setHardwareAccelerated(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 7:
                ((p) this.a).setAnimationType(t, (String) obj);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}