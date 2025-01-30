package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
final class c implements PrivilegedAction {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ClassLoader f17582b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(String str, ClassLoader classLoader) {
        this.a = str;
        this.f17582b = classLoader;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return h.d(this.a, this.f17582b);
    }
}