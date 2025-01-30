package com.bugsnag.android;

/* compiled from: InternalHooks.java */
/* loaded from: classes.dex */
public class m0 {

    /* compiled from: InternalHooks.java */
    /* loaded from: classes.dex */
    static class a implements i {
        a() {
        }

        @Override // com.bugsnag.android.i
        public void a(z0 z0Var) {
            com.bugsnag.c.a(z0Var.a());
        }
    }

    /* compiled from: InternalHooks.java */
    /* loaded from: classes.dex */
    static class b implements h {
        b() {
        }

        @Override // com.bugsnag.android.h
        public boolean a(v0 v0Var) {
            com.bugsnag.c.a(v0Var.a().c());
            return true;
        }
    }

    public static void a(q qVar) {
        qVar.l().a(new a());
        qVar.l().b(new b());
    }
}