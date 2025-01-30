package com.uber.autodispose.lifecycle;

import com.uber.autodispose.y;
import h.c.s;

/* compiled from: LifecycleScopeProvider.java */
/* loaded from: classes2.dex */
public interface d<E> extends y {
    CorrespondingEventsFunction<E> correspondingEvents();

    s<E> lifecycle();

    E peekLifecycle();
}