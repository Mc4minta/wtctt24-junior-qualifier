package e.f.m.a0;

import android.view.View;
import com.BV.LinearGradient.LinearGradientManager;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.b;
import e.f.m.a0.j;

/* compiled from: AndroidSwipeRefreshLayoutManagerDelegate.java */
/* loaded from: classes2.dex */
public class i<T extends View, U extends com.facebook.react.uimanager.b<T> & j<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public i(com.facebook.react.uimanager.b bVar) {
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
            case -1354842768:
                if (str.equals(LinearGradientManager.PROP_COLORS)) {
                    c2 = 1;
                    break;
                }
                break;
            case -885150488:
                if (str.equals("progressBackgroundColor")) {
                    c2 = 2;
                    break;
                }
                break;
            case -416037467:
                if (str.equals("progressViewOffset")) {
                    c2 = 3;
                    break;
                }
                break;
            case -321826009:
                if (str.equals("refreshing")) {
                    c2 = 4;
                    break;
                }
                break;
            case 3530753:
                if (str.equals("size")) {
                    c2 = 5;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((j) this.a).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 1:
                ((j) this.a).setColors(t, (ReadableArray) obj);
                return;
            case 2:
                ((j) this.a).setProgressBackgroundColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 3:
                ((j) this.a).setProgressViewOffset(t, obj == null ? 0.0f : ((Double) obj).floatValue());
                return;
            case 4:
                ((j) this.a).setRefreshing(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case 5:
                ((j) this.a).setSize(t, obj != null ? ((Double) obj).intValue() : 1);
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}