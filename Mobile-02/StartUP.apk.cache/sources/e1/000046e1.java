package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.uimanager.b;
import e.f.m.a0.h;

/* compiled from: AndroidProgressBarManagerDelegate.java */
/* loaded from: classes2.dex */
public class g<T extends View, U extends com.facebook.react.uimanager.b<T> & h<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public g(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1001078227:
                if (str.equals("progress")) {
                    c2 = 0;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    c2 = 1;
                    break;
                }
                break;
            case -676876213:
                if (str.equals("typeAttr")) {
                    c2 = 2;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 3;
                    break;
                }
                break;
            case 633138363:
                if (str.equals("indeterminate")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1118509918:
                if (str.equals("animating")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1804741442:
                if (str.equals("styleAttr")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((h) this.a).setProgress(t, obj == null ? 0.0d : ((Double) obj).doubleValue());
                return;
            case 1:
                ((h) this.a).setTestID(t, obj == null ? "" : (String) obj);
                return;
            case 2:
                ((h) this.a).setTypeAttr(t, obj != null ? (String) obj : null);
                return;
            case 3:
                ((h) this.a).setColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 4:
                ((h) this.a).setIndeterminate(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 5:
                ((h) this.a).setAnimating(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 6:
                ((h) this.a).setStyleAttr(t, obj != null ? (String) obj : null);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}