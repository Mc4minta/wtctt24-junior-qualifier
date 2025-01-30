package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

/* loaded from: classes2.dex */
public class HermesExecutor extends JavaScriptExecutor {
    private static String a;

    static {
        SoLoader.j("hermes");
        try {
            SoLoader.j("hermes-executor-debug");
            a = "Debug";
        } catch (UnsatisfiedLinkError unused) {
            SoLoader.j("hermes-executor-release");
            a = "Release";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HermesExecutor(b bVar) {
        super(initHybridDefaultConfig());
        if (bVar == null) {
            return;
        }
        throw null;
    }

    public static native boolean canLoadFile(String str);

    private static native HybridData initHybrid(long j2, boolean z);

    private static native HybridData initHybridDefaultConfig();

    @Override // com.facebook.react.bridge.JavaScriptExecutor
    public String getName() {
        return "HermesExecutor" + a;
    }
}