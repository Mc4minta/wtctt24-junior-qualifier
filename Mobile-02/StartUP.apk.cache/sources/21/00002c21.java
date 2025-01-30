package com.facebook.common.memory;

/* compiled from: NoOpMemoryTrimmableRegistry.java */
/* loaded from: classes2.dex */
public class d implements c {
    private static d a;

    public static synchronized d b() {
        d dVar;
        synchronized (d.class) {
            if (a == null) {
                a = new d();
            }
            dVar = a;
        }
        return dVar;
    }

    @Override // com.facebook.common.memory.c
    public void a(b bVar) {
    }
}