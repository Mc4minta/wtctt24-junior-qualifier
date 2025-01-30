package com.bugsnag.android;

import com.bugsnag.android.d;

/* compiled from: AnrPlugin.kt */
/* loaded from: classes.dex */
final class b implements d.b {
    private final /* synthetic */ kotlin.e0.c.l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(kotlin.e0.c.l lVar) {
        this.a = lVar;
    }

    @Override // com.bugsnag.android.d.b
    public final /* synthetic */ void a(Thread thread) {
        kotlin.jvm.internal.m.d(this.a.invoke(thread), "invoke(...)");
    }
}