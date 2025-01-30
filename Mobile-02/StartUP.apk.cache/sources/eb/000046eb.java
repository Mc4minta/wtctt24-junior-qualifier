package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ColorPropConverter;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.b;
import e.f.m.a0.r;
import org.apache.http.message.TokenParser;

/* compiled from: SliderManagerDelegate.java */
/* loaded from: classes2.dex */
public class q<T extends View, U extends com.facebook.react.uimanager.b<T> & r<T>> extends com.facebook.react.uimanager.a<T, U> {
    /* JADX WARN: Incorrect types in method signature: (TU;)V */
    public q(com.facebook.react.uimanager.b bVar) {
        super(bVar);
    }

    @Override // com.facebook.react.uimanager.a, com.facebook.react.uimanager.w0
    public void a(T t, String str, Object obj) {
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1900655011:
                if (str.equals("maximumTrackTintColor")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1736983259:
                if (str.equals("thumbImage")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1609594047:
                if (str.equals("enabled")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1021497397:
                if (str.equals("minimumTrackTintColor")) {
                    c2 = 3;
                    break;
                }
                break;
            case -981448432:
                if (str.equals("maximumTrackImage")) {
                    c2 = 4;
                    break;
                }
                break;
            case -877170387:
                if (str.equals("testID")) {
                    c2 = 5;
                    break;
                }
                break;
            case 3540684:
                if (str.equals("step")) {
                    c2 = 6;
                    break;
                }
                break;
            case 111972721:
                if (str.equals("value")) {
                    c2 = 7;
                    break;
                }
                break;
            case 270940796:
                if (str.equals("disabled")) {
                    c2 = '\b';
                    break;
                }
                break;
            case 718061361:
                if (str.equals("maximumValue")) {
                    c2 = '\t';
                    break;
                }
                break;
            case 1139400400:
                if (str.equals("trackImage")) {
                    c2 = '\n';
                    break;
                }
                break;
            case 1192487427:
                if (str.equals("minimumValue")) {
                    c2 = 11;
                    break;
                }
                break;
            case 1333596542:
                if (str.equals("minimumTrackImage")) {
                    c2 = '\f';
                    break;
                }
                break;
            case 1912319986:
                if (str.equals("thumbTintColor")) {
                    c2 = TokenParser.CR;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                ((r) this.a).setMaximumTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 1:
                ((r) this.a).setThumbImage(t, (ReadableMap) obj);
                return;
            case 2:
                ((r) this.a).setEnabled(t, obj != null ? ((Boolean) obj).booleanValue() : true);
                return;
            case 3:
                ((r) this.a).setMinimumTrackTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            case 4:
                ((r) this.a).setMaximumTrackImage(t, (ReadableMap) obj);
                return;
            case 5:
                ((r) this.a).setTestID(t, obj == null ? "" : (String) obj);
                return;
            case 6:
                ((r) this.a).setStep(t, obj != null ? ((Double) obj).doubleValue() : 0.0d);
                return;
            case 7:
                ((r) this.a).setValue(t, obj != null ? ((Double) obj).doubleValue() : 0.0d);
                return;
            case '\b':
                ((r) this.a).setDisabled(t, obj != null ? ((Boolean) obj).booleanValue() : false);
                return;
            case '\t':
                ((r) this.a).setMaximumValue(t, obj == null ? 1.0d : ((Double) obj).doubleValue());
                return;
            case '\n':
                ((r) this.a).setTrackImage(t, (ReadableMap) obj);
                return;
            case 11:
                ((r) this.a).setMinimumValue(t, obj != null ? ((Double) obj).doubleValue() : 0.0d);
                return;
            case '\f':
                ((r) this.a).setMinimumTrackImage(t, (ReadableMap) obj);
                return;
            case '\r':
                ((r) this.a).setThumbTintColor(t, ColorPropConverter.getColor(obj, t.getContext()));
                return;
            default:
                super.a(t, str, obj);
                return;
        }
    }
}