package com.facebook.systrace;

/* compiled from: SystraceMessage.java */
/* loaded from: classes2.dex */
public final class b {
    private static final AbstractC0130b a = new c();

    /* compiled from: SystraceMessage.java */
    /* renamed from: com.facebook.systrace.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0130b {
        public abstract AbstractC0130b a(String str, int i2);

        public abstract AbstractC0130b b(String str, Object obj);

        public abstract void c();
    }

    /* compiled from: SystraceMessage.java */
    /* loaded from: classes2.dex */
    private static class c extends AbstractC0130b {
        private c() {
        }

        @Override // com.facebook.systrace.b.AbstractC0130b
        public AbstractC0130b a(String str, int i2) {
            return this;
        }

        @Override // com.facebook.systrace.b.AbstractC0130b
        public AbstractC0130b b(String str, Object obj) {
            return this;
        }

        @Override // com.facebook.systrace.b.AbstractC0130b
        public void c() {
        }
    }

    public static AbstractC0130b a(long j2, String str) {
        return a;
    }

    public static AbstractC0130b b(long j2) {
        return a;
    }
}