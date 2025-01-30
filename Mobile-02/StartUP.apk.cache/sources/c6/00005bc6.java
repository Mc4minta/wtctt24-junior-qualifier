package org.apache.commons.logging;

import java.security.PrivilegedAction;

/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
final class g implements PrivilegedAction {
    private final /* synthetic */ String a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f17585b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(String str, String str2) {
        this.a = str;
        this.f17585b = str2;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        return System.getProperty(this.a, this.f17585b);
    }
}