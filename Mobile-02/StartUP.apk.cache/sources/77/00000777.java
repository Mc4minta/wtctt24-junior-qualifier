package com.bugsnag.android;

import com.bugsnag.android.ndk.NativeBridge;
import kotlin.Metadata;

/* compiled from: NdkPlugin.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bugsnag/android/NdkPlugin;", "Lcom/bugsnag/android/l;", "Lcom/bugsnag/android/q;", "client", "Lkotlin/x;", "initialisePlugin", "(Lcom/bugsnag/android/q;)V", "<init>", "()V", "bugsnag-plugin-android-ndk_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class NdkPlugin implements l {
    @Override // com.bugsnag.android.l
    public void initialisePlugin(q client) {
        kotlin.jvm.internal.m.h(client, "client");
        System.loadLibrary("bugsnag-ndk");
        client.addObserver(new NativeBridge());
        client.E();
        q0.b("Initialised NDK Plugin");
    }
}