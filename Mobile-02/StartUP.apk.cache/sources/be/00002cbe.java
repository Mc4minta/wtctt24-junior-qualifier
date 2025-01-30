package com.facebook.imagepipeline.memory;

/* compiled from: NoOpPoolStatsTracker.java */
/* loaded from: classes2.dex */
public class z implements f0 {
    private static z a;

    private z() {
    }

    public static synchronized z h() {
        z zVar;
        synchronized (z.class) {
            if (a == null) {
                a = new z();
            }
            zVar = a;
        }
        return zVar;
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void a(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void b(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void c(BasePool basePool) {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void d() {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void e(int i2) {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void f() {
    }

    @Override // com.facebook.imagepipeline.memory.f0
    public void g(int i2) {
    }
}