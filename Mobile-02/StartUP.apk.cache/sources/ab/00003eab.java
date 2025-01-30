package com.reactcommunity.rndatetimepicker;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.fragment.app.m;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableNativeMap;

@e.f.m.x.a.a(name = RNDatePickerDialogModule.FRAGMENT_TAG)
/* loaded from: classes2.dex */
public class RNDatePickerDialogModule extends ReactContextBaseJavaModule {
    public static final String FRAGMENT_TAG = "RNDatePickerAndroid";

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ReadableMap f10685b;

        a(c cVar, ReadableMap readableMap) {
            this.a = cVar;
            this.f10685b = readableMap;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.i(RNDatePickerDialogModule.this.createFragmentArguments(this.f10685b));
        }
    }

    /* loaded from: classes2.dex */
    private class b implements DatePickerDialog.OnDateSetListener, DialogInterface.OnDismissListener, DialogInterface.OnClickListener {
        private final Promise a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f10687b = false;

        public b(Promise promise) {
            this.a = promise;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f10687b || !RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "neutralButtonAction");
            this.a.resolve(writableNativeMap);
            this.f10687b = true;
        }

        @Override // android.app.DatePickerDialog.OnDateSetListener
        public void onDateSet(DatePicker datePicker, int i2, int i3, int i4) {
            if (this.f10687b || !RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dateSetAction");
            writableNativeMap.putInt("year", i2);
            writableNativeMap.putInt("month", i3);
            writableNativeMap.putInt("day", i4);
            this.a.resolve(writableNativeMap);
            this.f10687b = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f10687b || !RNDatePickerDialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            WritableNativeMap writableNativeMap = new WritableNativeMap();
            writableNativeMap.putString("action", "dismissedAction");
            this.a.resolve(writableNativeMap);
            this.f10687b = true;
        }
    }

    public RNDatePickerDialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bundle createFragmentArguments(ReadableMap readableMap) {
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("value") && !readableMap.isNull("value")) {
            bundle.putLong("value", (long) readableMap.getDouble("value"));
        }
        if (readableMap.hasKey("minimumDate") && !readableMap.isNull("minimumDate")) {
            bundle.putLong("minimumDate", (long) readableMap.getDouble("minimumDate"));
        }
        if (readableMap.hasKey("maximumDate") && !readableMap.isNull("maximumDate")) {
            bundle.putLong("maximumDate", (long) readableMap.getDouble("maximumDate"));
        }
        if (readableMap.hasKey("display") && !readableMap.isNull("display")) {
            bundle.putString("display", readableMap.getString("display"));
        }
        if (readableMap.hasKey("neutralButtonLabel") && !readableMap.isNull("neutralButtonLabel")) {
            bundle.putString("neutralButtonLabel", readableMap.getString("neutralButtonLabel"));
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
            promise.reject("E_NO_ACTIVITY", "Tried to open a DatePicker dialog while not attached to an Activity");
            return;
        }
        m supportFragmentManager = dVar.getSupportFragmentManager();
        c cVar = (c) supportFragmentManager.Z(FRAGMENT_TAG);
        if (cVar != null && readableMap != null) {
            UiThreadUtil.runOnUiThread(new a(cVar, readableMap));
            return;
        }
        c cVar2 = new c();
        if (readableMap != null) {
            cVar2.setArguments(createFragmentArguments(readableMap));
        }
        b bVar = new b(promise);
        cVar2.g(bVar);
        cVar2.f(bVar);
        cVar2.h(bVar);
        cVar2.show(supportFragmentManager, FRAGMENT_TAG);
    }
}