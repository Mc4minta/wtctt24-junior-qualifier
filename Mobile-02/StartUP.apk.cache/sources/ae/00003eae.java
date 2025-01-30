package com.reactcommunity.rndatetimepicker;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TimePicker;
import androidx.fragment.app.m;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;

@e.f.m.x.a.a(name = RNTimePickerDialogModule.FRAGMENT_TAG)
/* loaded from: classes2.dex */
public class RNTimePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNTimePickerAndroid";

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ h a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10689b;

        a(h hVar, ReadableMap readableMap) {
            this.a = hVar;
            this.f10689b = readableMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.i(RNTimePickerDialogModule.this.createFragmentArguments(this.f10689b));
        }
    }

    /* loaded from: classes2.dex */
    private class b implements TimePickerDialog.OnTimeSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Promise a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10691b = false;

        public b(Promise promise) {
            this.a = promise;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f10691b || !RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "neutralButtonAction");
            this.a.resolve(writableNativeMap);
            this.f10691b = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f10691b || !RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dismissedAction");
            this.a.resolve(writableNativeMap);
            this.f10691b = true;
        }

        @Override // android.app.TimePickerDialog.OnTimeSetListener
        public void onTimeSet(TimePicker timePicker, int i2, int i3) {
            if (this.f10691b || !RNTimePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "timeSetAction");
            writableNativeMap.putInt("hour", i2);
            writableNativeMap.putInt("minute", i3);
            this.a.resolve(writableNativeMap);
            this.f10691b = true;
        }
    }

    public RNTimePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey("is24Hour") && !readableMap.isNull("is24Hour")) {
            bundle.putBoolean("is24Hour", readableMap.getBoolean("is24Hour"));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundle.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey("neutralButtonLabel") && !readableMap.isNull("neutralButtonLabel")) {
            bundle.putString("neutralButtonLabel", readableMap.getString("neutralButtonLabel"));
        }
        if (readableMap.hasKey("minuteInterval") && !readableMap.isNull("minuteInterval")) {
            bundle.putInt("minuteInterval", readableMap.getInt("minuteInterval"));
        }
        return bundle;
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return FRAGMENT_TAG;
    }

    @ReactMethod
    public void open(ReadableMap readableMap, Promise promise) {
        androidx.fragment.app.d dVar = (androidx.fragment.app.d) getCurrentActivity();
        if (dVar == null) {
            promise.reject("E_NO_ACTIVITY", "Tried to open a TimePicker dialog while not attached to an Activity");
            return;
        }
        m supportFragmentManager = dVar.getSupportFragmentManager();
        h hVar = (h) supportFragmentManager.Z(FRAGMENT_TAG);
        if (hVar != null && readableMap != null) {
            UiThreadUtil.runOnUiThread(new a(hVar, readableMap));
            return;
        }
        h hVar2 = new h();
        if (readableMap != null) {
            hVar2.setArguments(createFragmentArguments(readableMap));
        }
        b bVar = new b(promise);
        hVar2.f(bVar);
        hVar2.h(bVar);
        hVar2.g(bVar);
        hVar2.show(supportFragmentManager, FRAGMENT_TAG);
    }
}