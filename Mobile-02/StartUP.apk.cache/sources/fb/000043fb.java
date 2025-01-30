package com.uber.autodispose.lifecycle;

import com.uber.autodispose.OutsideScopeException;
import h.c.m0.n;

/* loaded from: classes2.dex */
public interface CorrespondingEventsFunction<E> extends n<E, E> {
    @Override // h.c.m0.n
    E apply(E e2) throws OutsideScopeException;
}