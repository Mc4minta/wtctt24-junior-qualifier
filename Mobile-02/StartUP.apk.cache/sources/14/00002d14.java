package com.facebook.react.animated;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReadableMap;

/* compiled from: AnimationDriver.java */
/* loaded from: classes2.dex */
abstract class d {
    boolean a = false;

    /* renamed from: b  reason: collision with root package name */
    s f4709b;

    /* renamed from: c  reason: collision with root package name */
    Callback f4710c;

    /* renamed from: d  reason: collision with root package name */
    int f4711d;

    public void a(ReadableMap readableMap) {
        throw new JSApplicationCausedNativeException("Animation config for " + getClass().getSimpleName() + " cannot be reset");
    }

    public abstract void b(long j2);
}