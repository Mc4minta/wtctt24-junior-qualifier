package com.facebook.react.modules.permissions;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.util.SparseArray;
import com.facebook.fbreact.specs.NativePermissionsAndroidSpec;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.e;
import com.facebook.react.modules.core.f;
import java.util.ArrayList;

@e.f.m.x.a.a(name = PermissionsModule.NAME)
/* loaded from: classes2.dex */
public class PermissionsModule extends NativePermissionsAndroidSpec implements f {
    private static final String ERROR_INVALID_ACTIVITY = "E_INVALID_ACTIVITY";
    public static final String NAME = "PermissionsAndroid";
    private final String DENIED;
    private final String GRANTED;
    private final String NEVER_ASK_AGAIN;
    private final SparseArray<Callback> mCallbacks;
    private int mRequestCode;

    /* loaded from: classes2.dex */
    class a implements Callback {
        final /* synthetic */ Promise a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f4987b;

        a(Promise promise, String str) {
            this.a = promise;
            this.f4987b = str;
        }

        @Override // com.facebook.react.bridge.Callback
        public void invoke(Object... objArr) {
            int[] iArr = (int[]) objArr[0];
            if (iArr.length > 0 && iArr[0] == 0) {
                this.a.resolve("granted");
            } else if (((e) objArr[1]).shouldShowRequestPermissionRationale(this.f4987b)) {
                this.a.resolve("denied");
            } else {
                this.a.resolve("never_ask_again");
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Callback {
        final /* synthetic */ ArrayList a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ WritableMap f4989b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Promise f4990c;

        b(ArrayList arrayList, WritableMap writableMap, Promise promise) {
            this.a = arrayList;
            this.f4989b = writableMap;
            this.f4990c = promise;
        }

        @Override // com.facebook.react.bridge.Callback
        public void invoke(Object... objArr) {
            int[] iArr = (int[]) objArr[0];
            e eVar = (e) objArr[1];
            for (int i2 = 0; i2 < this.a.size(); i2++) {
                String str = (String) this.a.get(i2);
                if (iArr.length > 0 && iArr[i2] == 0) {
                    this.f4989b.putString(str, "granted");
                } else if (eVar.shouldShowRequestPermissionRationale(str)) {
                    this.f4989b.putString(str, "denied");
                } else {
                    this.f4989b.putString(str, "never_ask_again");
                }
            }
            this.f4990c.resolve(this.f4989b);
        }
    }

    public PermissionsModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mRequestCode = 0;
        this.GRANTED = "granted";
        this.DENIED = "denied";
        this.NEVER_ASK_AGAIN = "never_ask_again";
        this.mCallbacks = new SparseArray<>();
    }

    private e getPermissionAwareActivity() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (currentActivity instanceof e) {
                return (e) currentActivity;
            }
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
        throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void checkPermission(String str, Promise promise) {
        Context baseContext = getReactApplicationContext().getBaseContext();
        if (Build.VERSION.SDK_INT < 23) {
            promise.resolve(Boolean.valueOf(baseContext.checkPermission(str, Process.myPid(), Process.myUid()) == 0));
        } else {
            promise.resolve(Boolean.valueOf(baseContext.checkSelfPermission(str) == 0));
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return NAME;
    }

    @Override // com.facebook.react.modules.core.f
    public boolean onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        this.mCallbacks.get(i2).invoke(iArr, getPermissionAwareActivity());
        this.mCallbacks.remove(i2);
        return this.mCallbacks.size() == 0;
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void requestMultiplePermissions(ReadableArray readableArray, Promise promise) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        ArrayList arrayList = new ArrayList();
        Context baseContext = getReactApplicationContext().getBaseContext();
        int i2 = 0;
        for (int i3 = 0; i3 < readableArray.size(); i3++) {
            String string = readableArray.getString(i3);
            if (Build.VERSION.SDK_INT < 23) {
                writableNativeMap.putString(string, baseContext.checkPermission(string, Process.myPid(), Process.myUid()) != 0 ? "denied" : "granted");
            } else if (baseContext.checkSelfPermission(string) == 0) {
                writableNativeMap.putString(string, "granted");
            } else {
                arrayList.add(string);
            }
            i2++;
        }
        if (readableArray.size() == i2) {
            promise.resolve(writableNativeMap);
            return;
        }
        try {
            e permissionAwareActivity = getPermissionAwareActivity();
            this.mCallbacks.put(this.mRequestCode, new b(arrayList, writableNativeMap, promise));
            permissionAwareActivity.requestPermissions((String[]) arrayList.toArray(new String[0]), this.mRequestCode, this);
            this.mRequestCode++;
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void requestPermission(String str, Promise promise) {
        Context baseContext = getReactApplicationContext().getBaseContext();
        if (Build.VERSION.SDK_INT < 23) {
            promise.resolve(baseContext.checkPermission(str, Process.myPid(), Process.myUid()) != 0 ? "denied" : "granted");
        } else if (baseContext.checkSelfPermission(str) == 0) {
            promise.resolve("granted");
        } else {
            try {
                e permissionAwareActivity = getPermissionAwareActivity();
                this.mCallbacks.put(this.mRequestCode, new a(promise, str));
                permissionAwareActivity.requestPermissions(new String[]{str}, this.mRequestCode, this);
                this.mRequestCode++;
            } catch (IllegalStateException e2) {
                promise.reject(ERROR_INVALID_ACTIVITY, e2);
            }
        }
    }

    @Override // com.facebook.fbreact.specs.NativePermissionsAndroidSpec
    public void shouldShowRequestPermissionRationale(String str, Promise promise) {
        if (Build.VERSION.SDK_INT < 23) {
            promise.resolve(Boolean.FALSE);
            return;
        }
        try {
            promise.resolve(Boolean.valueOf(getPermissionAwareActivity().shouldShowRequestPermissionRationale(str)));
        } catch (IllegalStateException e2) {
            promise.reject(ERROR_INVALID_ACTIVITY, e2);
        }
    }
}