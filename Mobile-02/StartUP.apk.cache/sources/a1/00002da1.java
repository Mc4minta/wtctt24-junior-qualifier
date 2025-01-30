package com.facebook.react.bridge;

import e.f.l.a.a;

@a
/* loaded from: classes2.dex */
interface ReactCallback {
    @a
    void decrementPendingJSCalls();

    @a
    void incrementPendingJSCalls();

    @a
    void onBatchComplete();
}