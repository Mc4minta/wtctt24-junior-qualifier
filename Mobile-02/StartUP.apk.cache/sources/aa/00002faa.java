package com.facebook.react.views.modal;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.views.modal.d;

/* compiled from: RNGHModalUtils.java */
/* loaded from: classes2.dex */
public class c {
    public static void a(ViewGroup viewGroup, MotionEvent motionEvent) {
        ((d.b) viewGroup).onChildStartedNativeGesture(motionEvent);
    }

    public static boolean b(ViewParent viewParent) {
        return viewParent instanceof d.b;
    }
}