package com.facebook.react.modules.debug;

import android.widget.Toast;
import com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.debug.b;
import java.util.Locale;

@e.f.m.x.a.a(name = AnimationsDebugModule.NAME)
/* loaded from: classes2.dex */
public class AnimationsDebugModule extends NativeAnimationsDebugModuleSpec {
    protected static final String NAME = "AnimationsDebugModule";
    private final com.facebook.react.modules.debug.c.a mCatalystSettings;
    private b mFrameCallback;

    public AnimationsDebugModule(ReactApplicationContext reactApplicationContext, com.facebook.react.modules.debug.c.a aVar) {
        super(reactApplicationContext);
        this.mCatalystSettings = aVar;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void onCatalystInstanceDestroy() {
        b bVar = this.mFrameCallback;
        if (bVar != null) {
            bVar.n();
            this.mFrameCallback = null;
        }
    }

    @Override // com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec
    public void startRecordingFps() {
        com.facebook.react.modules.debug.c.a aVar = this.mCatalystSettings;
        if (aVar == null || !aVar.a()) {
            return;
        }
        if (this.mFrameCallback == null) {
            b bVar = new b(getReactApplicationContext());
            this.mFrameCallback = bVar;
            bVar.m();
            return;
        }
        throw new JSApplicationCausedNativeException("Already recording FPS!");
    }

    @Override // com.facebook.fbreact.specs.NativeAnimationsDebugModuleSpec
    public void stopRecordingFps(double d2) {
        b bVar = this.mFrameCallback;
        if (bVar == null) {
            return;
        }
        bVar.n();
        b.C0119b g2 = this.mFrameCallback.g((long) d2);
        if (g2 == null) {
            Toast.makeText(getReactApplicationContext(), "Unable to get FPS info", 1);
        } else {
            Locale locale = Locale.US;
            String str = String.format(locale, "FPS: %.2f, %d frames (%d expected)", Double.valueOf(g2.f4936e), Integer.valueOf(g2.a), Integer.valueOf(g2.f4934c)) + "\n" + String.format(locale, "JS FPS: %.2f, %d frames (%d expected)", Double.valueOf(g2.f4937f), Integer.valueOf(g2.f4933b), Integer.valueOf(g2.f4934c)) + "\nTotal Time MS: " + String.format(locale, "%d", Integer.valueOf(g2.f4938g));
            e.f.d.d.a.b("ReactNative", str);
            Toast.makeText(getReactApplicationContext(), str, 1).show();
        }
        this.mFrameCallback = null;
    }
}