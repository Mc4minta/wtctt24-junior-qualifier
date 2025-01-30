package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
final class d implements PrivilegedAction {
    private final /* synthetic */ ClassLoader a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f17583b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(ClassLoader classLoader, String str) {
        this.a = classLoader;
        this.f17583b = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        ClassLoader classLoader = this.a;
        if (classLoader != null) {
            return classLoader.getResourceAsStream(this.f17583b);
        }
        return ClassLoader.getSystemResourceAsStream(this.f17583b);
    }
}