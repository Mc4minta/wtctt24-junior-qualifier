package com.bugsnag.android;

import com.bugsnag.android.c0;
import java.nio.ByteBuffer;
import kotlin.Metadata;

/* compiled from: AnrPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/bugsnag/android/AnrPlugin;", "Lcom/bugsnag/android/l;", "Ljava/nio/ByteBuffer;", "sentinelBuffer", "Lkotlin/x;", "installAnrDetection", "(Ljava/nio/ByteBuffer;)V", "Ljava/lang/Thread;", "thread", "Lcom/bugsnag/android/q;", "client", "handleAnr", "(Ljava/lang/Thread;Lcom/bugsnag/android/q;)V", "initialisePlugin", "(Lcom/bugsnag/android/q;)V", "Lcom/bugsnag/android/a;", "collector", "Lcom/bugsnag/android/a;", "<init>", "()V", "bugsnag-plugin-android-anr_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AnrPlugin implements l {
    private final com.bugsnag.android.a collector = new com.bugsnag.android.a();

    /* compiled from: AnrPlugin.kt */
    /* loaded from: classes.dex */
    static final class a extends kotlin.jvm.internal.o implements kotlin.e0.c.l<Thread, kotlin.x> {

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f3576b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(q qVar) {
            super(1);
            this.f3576b = qVar;
        }

        public final void a(Thread it) {
            kotlin.jvm.internal.m.h(it, "it");
            AnrPlugin.this.handleAnr(it, this.f3576b);
        }

        @Override // kotlin.e0.c.l
        public /* bridge */ /* synthetic */ kotlin.x invoke(Thread thread) {
            a(thread);
            return kotlin.x.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleAnr(Thread thread, q qVar) {
        c0 error = new c0.a(qVar.a, new k("ANR", "Application did not respond to UI input", thread.getStackTrace()), qVar.f3692k, thread, true).e(Severity.ERROR).f("anrError").b();
        com.bugsnag.android.a aVar = this.collector;
        kotlin.jvm.internal.m.d(error, "error");
        aVar.d(qVar, error);
    }

    private final native void installAnrDetection(ByteBuffer byteBuffer);

    @Override // com.bugsnag.android.l
    public void initialisePlugin(q client) {
        kotlin.jvm.internal.m.h(client, "client");
        System.loadLibrary("bugsnag-plugin-android-anr");
        d dVar = new d(new b(new a(client)));
        dVar.d();
        ByteBuffer c2 = dVar.c();
        kotlin.jvm.internal.m.d(c2, "monitor.sentinelBuffer");
        installAnrDetection(c2);
        q0.b("Initialised ANR Plugin");
    }
}