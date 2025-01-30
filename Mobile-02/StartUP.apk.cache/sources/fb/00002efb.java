package com.facebook.react.uimanager.events;

import android.view.MotionEvent;
import android.view.View;
import com.facebook.react.uimanager.e0;

/* compiled from: NativeGestureUtil.java */
/* loaded from: classes2.dex */
public class f {
    public static void a(View view, MotionEvent motionEvent) {
        e0.a(view).onChildStartedNativeGesture(motionEvent);
    }
}