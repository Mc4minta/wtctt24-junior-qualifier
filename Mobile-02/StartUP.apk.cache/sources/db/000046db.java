package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.b;
import e.f.m.a0.b;

/* compiled from: AndroidDialogPickerManagerDelegate.java */
/* loaded from: classes2.dex */
public class a<T extends View, U extends com.facebook.react.uimanager.b<T> & b<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public a(com.facebook.react.uimanager.b bVar) {
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
            case 1287124693:
                if (str.equals("backgroundColor")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((b) this.a).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 1:
                ((b) this.a).setPrompt(t, obj == null ? "" : (String) obj);
                return;
            case 2:
                ((b) this.a).setColor(t, obj != null ? Integer.valueOf(((Double) obj).intValue()) : null);
                return;
            case 3:
                ((b) this.a).setItems(t, (ReadableArray) obj);
                return;
            case 4:
                ((b) this.a).setSelected(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 5:
                ((b) this.a).setBackgroundColor(t, obj != null ? Integer.valueOf(((Double) obj).intValue()) : null);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}