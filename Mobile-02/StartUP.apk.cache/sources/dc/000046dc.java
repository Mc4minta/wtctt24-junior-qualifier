package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: AndroidDialogPickerManagerInterface.java */
/* loaded from: classes2.dex */
public interface b<T extends View> {
    void setBackgroundColor(T t, Integer num);

    void setColor(T t, Integer num);

    void setEnabled(T t, boolean z);

    void setItems(T t, ReadableArray readableArray);

    void setPrompt(T t, String str);

    void setSelected(T t, int i2);
}