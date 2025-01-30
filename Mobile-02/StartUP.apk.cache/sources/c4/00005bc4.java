package org.apache.commons.logging;

import java.io.IOException;
import java.security.PrivilegedAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LogFactory.java */
/* loaded from: classes3.dex */
public final class e implements PrivilegedAction {
    private final /* synthetic */ ClassLoader a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f17584b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(ClassLoader classLoader, String str) {
        this.a = classLoader;
        this.f17584b = str;
    }

    @Override // java.security.PrivilegedAction
    public Object run() {
        try {
            ClassLoader classLoader = this.a;
            if (classLoader != null) {
                return classLoader.getResources(this.f17584b);
            }
            return ClassLoader.getSystemResources(this.f17584b);
        } catch (IOException e2) {
            if (h.w()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Exception while trying to find configuration file ");
                stringBuffer.append(this.f17584b);
                stringBuffer.append(":");
                stringBuffer.append(e2.getMessage());
                h.y(stringBuffer.toString());
            }
            return null;
        } catch (NoSuchMethodError unused) {
            return null;
        }
    }
}