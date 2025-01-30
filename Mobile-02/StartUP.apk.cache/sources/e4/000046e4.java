package e.f.m.a0;

import android.view.View;
import com.facebook.react.bridge.ReadableArray;

/* compiled from: AndroidSwipeRefreshLayoutManagerInterface.java */
/* loaded from: classes2.dex */
public interface j<T extends View> {
    void setColors(T t, ReadableArray readableArray);

    void setEnabled(T t, boolean z);

    void setProgressBackgroundColor(T t, Integer num);

    void setProgressViewOffset(T t, float f2);

    void setRefreshing(T t, boolean z);

    void setSize(T t, int i2);
}