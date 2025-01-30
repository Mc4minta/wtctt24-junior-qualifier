package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: SliderManagerInterface.java */
/* loaded from: classes2.dex */
public interface r<T extends View> {
    void setDisabled(T t, boolean z);

    void setEnabled(T t, boolean z);

    void setMaximumTrackImage(T t, ReadableMap readableMap);

    void setMaximumTrackTintColor(T t, Integer num);

    void setMaximumValue(T t, double d2);

    void setMinimumTrackImage(T t, ReadableMap readableMap);

    void setMinimumTrackTintColor(T t, Integer num);

    void setMinimumValue(T t, double d2);

    void setStep(T t, double d2);

    void setTestID(T t, String str);

    void setThumbImage(T t, ReadableMap readableMap);

    void setThumbTintColor(T t, Integer num);

    void setTrackImage(T t, ReadableMap readableMap);

    void setValue(T t, double d2);
}