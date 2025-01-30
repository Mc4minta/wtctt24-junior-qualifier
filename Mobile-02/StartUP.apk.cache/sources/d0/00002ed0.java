package com.facebook.react.uimanager;

import android.view.View;
import com.facebook.react.bridge.JSApplicationCausedNativeException;

/* loaded from: classes2.dex */
public class IllegalViewOperationException extends JSApplicationCausedNativeException {
    private View a;

    public IllegalViewOperationException(String str) {
        super(str);
    }

    public IllegalViewOperationException(String str, View view, Throwable th) {
        super(str, th);
        this.a = view;
    }
}