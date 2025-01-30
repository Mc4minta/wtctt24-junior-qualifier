package com.google.android.gms.common.m;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class a {
    private static InterfaceC0143a a;

    /* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
    /* renamed from: com.google.android.gms.common.m.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0143a {
        ScheduledExecutorService a();
    }

    public static synchronized InterfaceC0143a a() {
        InterfaceC0143a interfaceC0143a;
        synchronized (a.class) {
            if (a == null) {
                a = new b();
            }
            interfaceC0143a = a;
        }
        return interfaceC0143a;
    }
}