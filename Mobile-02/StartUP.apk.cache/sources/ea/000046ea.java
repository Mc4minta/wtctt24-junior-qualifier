package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: ModalHostViewManagerInterface.java */
/* loaded from: classes2.dex */
public interface p<T extends View> {
    void setAnimated(T t, boolean z);

    void setAnimationType(T t, String str);

    void setHardwareAccelerated(T t, boolean z);

    void setIdentifier(T t, int i2);

    void setPresentationStyle(T t, String str);

    void setStatusBarTranslucent(T t, boolean z);

    void setSupportedOrientations(T t, ReadableArray readableArray);

    void setTransparent(T t, boolean z);
}