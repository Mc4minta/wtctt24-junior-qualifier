package com.facebook.react.modules.vibration;

import android.annotation.SuppressLint;
import android.os.Vibrator;
import com.facebook.fbreact.specs.NativeVibrationSpec;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import e.f.m.x.a.a;

@a(name = VibrationModule.NAME)
@SuppressLint({"MissingPermission"})
/* loaded from: classes2.dex */
public class VibrationModule extends NativeVibrationSpec {
    public static final String NAME = "Vibration";

    public VibrationModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeVibrationSpec
    public void cancel() {
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeVibrationSpec
    public void vibrate(double d2) {
        int i2 = (int) d2;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.vibrate(i2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativeVibrationSpec
    public void vibrateByPattern(ReadableArray readableArray, double d2) {
        int i2 = (int) d2;
        Vibrator vibrator = (Vibrator) getReactApplicationContext().getSystemService("vibrator");
        if (vibrator != null) {
            long[] jArr = new long[readableArray.size()];
            for (int i3 = 0; i3 < readableArray.size(); i3++) {
                jArr[i3] = readableArray.getInt(i3);
            }
            vibrator.vibrate(jArr, i2);
        }
    }
}