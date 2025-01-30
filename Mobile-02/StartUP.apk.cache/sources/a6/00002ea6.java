package com.facebook.react.modules.share;

import android.app.Activity;
import android.content.Intent;
import com.coinbase.ApiConstants;
import com.facebook.fbreact.specs.NativeShareModuleSpec;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import e.f.m.x.a.a;
import org.apache.http.protocol.HTTP;
import org.spongycastle.i18n.MessageBundle;

@a(name = ShareModule.NAME)
/* loaded from: classes2.dex */
public class ShareModule extends NativeShareModuleSpec {
    static final String ACTION_SHARED = "sharedAction";
    static final String ERROR_INVALID_CONTENT = "E_INVALID_CONTENT";
    static final String ERROR_UNABLE_TO_OPEN_DIALOG = "E_UNABLE_TO_OPEN_DIALOG";
    public static final String NAME = "ShareModule";

    public ShareModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.fbreact.specs.NativeShareModuleSpec
    public void share(ReadableMap readableMap, String str, Promise promise) {
        if (readableMap == null) {
            promise.reject(ERROR_INVALID_CONTENT, "Content cannot be null");
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setTypeAndNormalize(HTTP.PLAIN_TEXT_TYPE);
            if (readableMap.hasKey(MessageBundle.TITLE_ENTRY)) {
                intent.putExtra("android.intent.extra.SUBJECT", readableMap.getString(MessageBundle.TITLE_ENTRY));
            }
            if (readableMap.hasKey(ApiConstants.MESSAGE)) {
                intent.putExtra("android.intent.extra.TEXT", readableMap.getString(ApiConstants.MESSAGE));
            }
            Intent createChooser = Intent.createChooser(intent, str);
            createChooser.addCategory("android.intent.category.DEFAULT");
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.startActivity(createChooser);
            } else {
                getReactApplicationContext().startActivity(createChooser);
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putString("action", ACTION_SHARED);
            promise.resolve(createMap);
        } catch (Exception unused) {
            promise.reject(ERROR_UNABLE_TO_OPEN_DIALOG, "Failed to open share dialog");
        }
    }
}