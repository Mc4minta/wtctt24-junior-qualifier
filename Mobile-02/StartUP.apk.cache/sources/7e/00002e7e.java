package com.facebook.react.modules.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import com.facebook.fbreact.specs.NativeLinkingSpec;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;

@e.f.m.x.a.a(name = IntentModule.NAME)
/* loaded from: classes2.dex */
public class IntentModule extends NativeLinkingSpec {
    public static final String NAME = "IntentAndroid";

    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ReadableType.values().length];
            a = iArr;
            try {
                iArr[ReadableType.String.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ReadableType.Number.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ReadableType.Boolean.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public IntentModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void addListener(String str) {
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void canOpenURL(String str, Promise promise) {
        if (str != null && !str.isEmpty()) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                promise.resolve(Boolean.valueOf(intent.resolveActivity(getReactApplicationContext().getPackageManager()) != null));
                return;
            } catch (Exception e2) {
                promise.reject(new JSApplicationIllegalArgumentException("Could not check if URL '" + str + "' can be opened: " + e2.getMessage()));
                return;
            }
        }
        promise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + str));
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void getInitialURL(Promise promise) {
        try {
            Activity currentActivity = getCurrentActivity();
            String str = null;
            if (currentActivity != null) {
                Intent intent = currentActivity.getIntent();
                String action = intent.getAction();
                Uri data = intent.getData();
                if (data != null && ("android.intent.action.VIEW".equals(action) || "android.nfc.action.NDEF_DISCOVERED".equals(action))) {
                    str = data.toString();
                }
            }
            promise.resolve(str);
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not get the initial URL : " + e2.getMessage()));
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void openSettings(Promise promise) {
        try {
            Intent intent = new Intent();
            Activity currentActivity = getCurrentActivity();
            String packageName = getReactApplicationContext().getPackageName();
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("package:" + packageName));
            intent.addFlags(268435456);
            intent.addFlags(1073741824);
            intent.addFlags(8388608);
            currentActivity.startActivity(intent);
            promise.resolve(Boolean.TRUE);
        } catch (Exception e2) {
            promise.reject(new JSApplicationIllegalArgumentException("Could not open the Settings: " + e2.getMessage()));
        }
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void openURL(String str, Promise promise) {
        if (str != null && !str.isEmpty()) {
            try {
                Activity currentActivity = getCurrentActivity();
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str).normalizeScheme());
                String packageName = getReactApplicationContext().getPackageName();
                ComponentName resolveActivity = intent.resolveActivity(getReactApplicationContext().getPackageManager());
                String packageName2 = resolveActivity != null ? resolveActivity.getPackageName() : "";
                if (currentActivity == null || !packageName.equals(packageName2)) {
                    intent.addFlags(268435456);
                }
                if (currentActivity != null) {
                    currentActivity.startActivity(intent);
                } else {
                    getReactApplicationContext().startActivity(intent);
                }
                promise.resolve(Boolean.TRUE);
                return;
            } catch (Exception e2) {
                promise.reject(new JSApplicationIllegalArgumentException("Could not open URL '" + str + "': " + e2.getMessage()));
                return;
            }
        }
        promise.reject(new JSApplicationIllegalArgumentException("Invalid URL: " + str));
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void removeListeners(double d2) {
    }

    @Override // com.facebook.fbreact.specs.NativeLinkingSpec
    public void sendIntent(String str, ReadableArray readableArray, Promise promise) {
        if (str != null && !str.isEmpty()) {
            Intent intent = new Intent(str);
            if (intent.resolveActivity(getReactApplicationContext().getPackageManager()) == null) {
                promise.reject(new JSApplicationIllegalArgumentException("Could not launch Intent with action " + str + "."));
                return;
            }
            if (readableArray != null) {
                for (int i2 = 0; i2 < readableArray.size(); i2++) {
                    ReadableMap map = readableArray.getMap(i2);
                    String nextKey = map.keySetIterator().nextKey();
                    int i3 = a.a[map.getType(nextKey).ordinal()];
                    if (i3 == 1) {
                        intent.putExtra(nextKey, map.getString(nextKey));
                    } else if (i3 == 2) {
                        intent.putExtra(nextKey, Double.valueOf(map.getDouble(nextKey)));
                    } else if (i3 != 3) {
                        promise.reject(new JSApplicationIllegalArgumentException("Extra type for " + nextKey + " not supported."));
                        return;
                    } else {
                        intent.putExtra(nextKey, map.getBoolean(nextKey));
                    }
                }
            }
            getReactApplicationContext().startActivity(intent);
            return;
        }
        promise.reject(new JSApplicationIllegalArgumentException("Invalid Action: " + str + "."));
    }
}