package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.b;
import e.f.m.a0.f;

/* compiled from: AndroidDropdownPickerManagerDelegate.java */
/* loaded from: classes2.dex */
public class e<T extends View, U extends com.facebook.react.uimanager.b<T> & f<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public e(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1609594047:
                if (str.equals("enabled")) {
                    c2 = 0;
                    break;
                }
                break;
            case -979805852:
                if (str.equals("prompt")) {
                    c2 = 1;
                    break;
                }
                break;
            case 94842723:
                if (str.equals("color")) {
                    c2 = 2;
                    break;
                }
                break;
            case 100526016:
                if (str.equals("items")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1191572123:
                if (str.equals("selected")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((f) this.a).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 1:
                ((f) this.a).setPrompt(t, obj == null ? "" : (String) obj);
                return;
            case 2:
                ((f) this.a).setColor(t, obj == null ? null : Integer.valueOf(((Double) obj).intValue()));
                return;
            case 3:
                ((f) this.a).setItems(t, (ReadableArray) obj);
                return;
            case 4:
                ((f) this.a).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}