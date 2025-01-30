package com.facebook.react.modules.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.d;
import androidx.fragment.app.m;
import com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import java.util.Map;

@e.f.m.x.a.a(name = DialogModule.NAME)
/* loaded from: classes2.dex */
public class DialogModule extends NativeDialogManagerAndroidSpec implements LifecycleEventListener {
    static final String FRAGMENT_TAG = "com.facebook.catalyst.react.dialog.DialogModule";
    static final String KEY_CANCELABLE = "cancelable";
    static final String KEY_ITEMS = "items";
    static final String KEY_MESSAGE = "message";
    static final String KEY_TITLE = "title";
    public static final String NAME = "DialogManagerAndroid";
    private boolean mIsInForeground;
    static final String ACTION_BUTTON_CLICKED = "buttonClicked";
    static final String ACTION_DISMISSED = "dismissed";
    static final String KEY_BUTTON_POSITIVE = "buttonPositive";
    static final String KEY_BUTTON_NEGATIVE = "buttonNegative";
    static final String KEY_BUTTON_NEUTRAL = "buttonNeutral";
    static final Map<String, Object> CONSTANTS = com.facebook.react.common.c.h(ACTION_BUTTON_CLICKED, ACTION_BUTTON_CLICKED, ACTION_DISMISSED, ACTION_DISMISSED, KEY_BUTTON_POSITIVE, -1, KEY_BUTTON_NEGATIVE, -2, KEY_BUTTON_NEUTRAL, -3);

    /* loaded from: classes2.dex */
    class a implements Runnable {
        final /* synthetic */ c a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Bundle f4939b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Callback f4940c;

        a(c cVar, Bundle bundle, Callback callback) {
            this.a = cVar;
            this.f4939b = bundle;
            this.f4940c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.b(this.f4939b, this.f4940c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnClickListener, DialogInterface.OnDismissListener {
        private final Callback a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4942b = false;

        public b(Callback callback) {
            this.a = callback;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            if (this.f4942b || !DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            this.a.invoke(DialogModule.ACTION_BUTTON_CLICKED, Integer.valueOf(i2));
            this.f4942b = true;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (this.f4942b || !DialogModule.this.getReactApplicationContext().hasActiveCatalystInstance()) {
                return;
            }
            this.a.invoke(DialogModule.ACTION_DISMISSED);
            this.f4942b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c {
        private final m a;

        /* renamed from: b  reason: collision with root package name */
        private Object f4944b;

        public c(m mVar) {
            this.a = mVar;
        }

        private void a() {
            com.facebook.react.modules.dialog.a aVar;
            if (DialogModule.this.mIsInForeground && (aVar = (com.facebook.react.modules.dialog.a) this.a.Z(DialogModule.FRAGMENT_TAG)) != null && aVar.isResumed()) {
                aVar.dismiss();
            }
        }

        public void b(Bundle bundle, Callback callback) {
            UiThreadUtil.assertOnUiThread();
            a();
            com.facebook.react.modules.dialog.a aVar = new com.facebook.react.modules.dialog.a(callback != null ? new b(callback) : null, bundle);
            if (DialogModule.this.mIsInForeground && !this.a.v0()) {
                if (bundle.containsKey(DialogModule.KEY_CANCELABLE)) {
                    aVar.setCancelable(bundle.getBoolean(DialogModule.KEY_CANCELABLE));
                }
                aVar.show(this.a, DialogModule.FRAGMENT_TAG);
                return;
            }
            this.f4944b = aVar;
        }

        public void c() {
            UiThreadUtil.assertOnUiThread();
            SoftAssertions.assertCondition(DialogModule.this.mIsInForeground, "showPendingAlert() called in background");
            if (this.f4944b == null) {
                return;
            }
            a();
            ((com.facebook.react.modules.dialog.a) this.f4944b).show(this.a, DialogModule.FRAGMENT_TAG);
            this.f4944b = null;
        }
    }

    public DialogModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private c getFragmentManagerHelper() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null || !(currentActivity instanceof d)) {
            return null;
        }
        return new c(((d) currentActivity).getSupportFragmentManager());
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec
    public Map<String, Object> getTypedExportedConstants() {
        return CONSTANTS;
    }

    @Override // com.facebook.react.bridge.BaseJavaModule, com.facebook.react.bridge.NativeModule
    public void initialize() {
        getReactApplicationContext().addLifecycleEventListener(this);
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostDestroy() {
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostPause() {
        this.mIsInForeground = false;
    }

    @Override // com.facebook.react.bridge.LifecycleEventListener
    public void onHostResume() {
        this.mIsInForeground = true;
        c fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper != null) {
            fragmentManagerHelper.c();
        } else {
            e.f.d.d.a.w(DialogModule.class, "onHostResume called but no FragmentManager found");
        }
    }

    @Override // com.facebook.fbreact.specs.NativeDialogManagerAndroidSpec
    public void showAlert(ReadableMap readableMap, Callback callback, Callback callback2) {
        c fragmentManagerHelper = getFragmentManagerHelper();
        if (fragmentManagerHelper == null) {
            callback.invoke("Tried to show an alert while not attached to an Activity");
            return;
        }
        Bundle bundle = new Bundle();
        if (readableMap.hasKey("title")) {
            bundle.putString("title", readableMap.getString("title"));
        }
        if (readableMap.hasKey("message")) {
            bundle.putString("message", readableMap.getString("message"));
        }
        if (readableMap.hasKey(KEY_BUTTON_POSITIVE)) {
            bundle.putString("button_positive", readableMap.getString(KEY_BUTTON_POSITIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEGATIVE)) {
            bundle.putString("button_negative", readableMap.getString(KEY_BUTTON_NEGATIVE));
        }
        if (readableMap.hasKey(KEY_BUTTON_NEUTRAL)) {
            bundle.putString("button_neutral", readableMap.getString(KEY_BUTTON_NEUTRAL));
        }
        if (readableMap.hasKey(KEY_ITEMS)) {
            ReadableArray array = readableMap.getArray(KEY_ITEMS);
            CharSequence[] charSequenceArr = new CharSequence[array.size()];
            for (int i2 = 0; i2 < array.size(); i2++) {
                charSequenceArr[i2] = array.getString(i2);
            }
            bundle.putCharSequenceArray(KEY_ITEMS, charSequenceArr);
        }
        if (readableMap.hasKey(KEY_CANCELABLE)) {
            bundle.putBoolean(KEY_CANCELABLE, readableMap.getBoolean(KEY_CANCELABLE));
        }
        UiThreadUtil.runOnUiThread(new a(fragmentManagerHelper, bundle, callback2));
    }
}