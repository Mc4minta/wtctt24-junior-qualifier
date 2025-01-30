package e.f.m.a0;

import android.view.View;

/* compiled from: AndroidSwitchManagerInterface.java */
/* loaded from: classes2.dex */
public interface l<T extends View> {
    void setDisabled(T t, boolean z);

    void setEnabled(T t, boolean z);

    void setOn(T t, boolean z);

    void setThumbColor(T t, Integer num);

    void setThumbTintColor(T t, Integer num);

    void setTrackColorForFalse(T t, Integer num);

    void setTrackColorForTrue(T t, Integer num);

    void setTrackTintColor(T t, Integer num);

    void setValue(T t, boolean z);
}