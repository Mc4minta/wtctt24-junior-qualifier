package e.f.m.a0;

import android.view.View;
import com.facebook.react.uimanager.b;
import e.f.m.a0.n;

/* compiled from: AndroidViewPagerManagerDelegate.java */
/* loaded from: classes2.dex */
public class m<T extends View, U extends com.facebook.react.uimanager.b<T> & n<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public m(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1151046732:
                if (str.equals("scrollEnabled")) {
                    c2 = 0;
                    break;
                }
                break;
            case -764307226:
                if (str.equals("keyboardDismissMode")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1233251315:
                if (str.equals("initialPage")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1919780198:
                if (str.equals("peekEnabled")) {
                    c2 = 4;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((n) this.a).setScrollEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 1:
                ((n) this.a).setKeyboardDismissMode(t, (String) obj);
                return;
            case 2:
                ((n) this.a).setPageMargin(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 3:
                ((n) this.a).setInitialPage(t, obj != null ? ((Double) obj).intValue() : 0);
                return;
            case 4:
                ((n) this.a).setPeekEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}