package com.facebook.react.uimanager;

import android.os.Bundle;
import android.view.ViewGroup;

/* compiled from: ReactRoot.java */
/* loaded from: classes2.dex */
public interface w {
    Bundle getAppProperties();

    int getHeightMeasureSpec();

    String getInitialUITemplate();

    ViewGroup getRootViewGroup();

    int getRootViewTag();

    @Deprecated
    String getSurfaceID();

    int getUIManagerType();

    int getWidthMeasureSpec();

    void onStage(int i2);

    void runApplication();

    void setRootViewTag(int i2);

    void setShouldLogContentAppeared(boolean z);
}