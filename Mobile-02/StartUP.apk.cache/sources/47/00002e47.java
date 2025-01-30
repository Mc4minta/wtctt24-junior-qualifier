package com.facebook.react.modules.core;

import android.view.Choreographer;
import com.facebook.react.bridge.UiThreadUtil;

/* compiled from: ChoreographerCompat.java */
/* loaded from: classes2.dex */
public class a {
    private static a a;

    /* renamed from: b  reason: collision with root package name */
    private Choreographer f4875b = c();

    /* compiled from: ChoreographerCompat.java */
    /* renamed from: com.facebook.react.modules.core.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static abstract class AbstractC0115a {
        private Choreographer.FrameCallback a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ChoreographerCompat.java */
        /* renamed from: com.facebook.react.modules.core.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class Choreographer$FrameCallbackC0116a implements Choreographer.FrameCallback {
            Choreographer$FrameCallbackC0116a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j2) {
                AbstractC0115a.this.a(j2);
            }
        }

        public abstract void a(long j2);

        Choreographer.FrameCallback b() {
            if (this.a == null) {
                this.a = new Choreographer$FrameCallbackC0116a();
            }
            return this.a;
        }
    }

    private a() {
    }

    private void a(Choreographer.FrameCallback frameCallback) {
        this.f4875b.postFrameCallback(frameCallback);
    }

    private void b(Choreographer.FrameCallback frameCallback) {
        this.f4875b.removeFrameCallback(frameCallback);
    }

    private Choreographer c() {
        return Choreographer.getInstance();
    }

    public static a d() {
        UiThreadUtil.assertOnUiThread();
        if (a == null) {
            a = new a();
        }
        return a;
    }

    public void e(AbstractC0115a abstractC0115a) {
        a(abstractC0115a.b());
    }

    public void f(AbstractC0115a abstractC0115a) {
        b(abstractC0115a.b());
    }
}