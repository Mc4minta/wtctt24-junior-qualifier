package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class ApplicationVersionSignature {
    private static final ConcurrentMap<String, Key> PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    private static final String TAG = "AppVersionSignature";

    private ApplicationVersionSignature() {
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(TAG, "Cannot resolve info for" + context.getPackageName(), e2);
            return null;
        }
    }

    private static String getVersionCode(PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    public static Key obtain(Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = PACKAGE_NAME_TO_KEY;
        Key key = concurrentMap.get(packageName);
        if (key == null) {
            Key obtainVersionSignature = obtainVersionSignature(context);
            Key putIfAbsent = concurrentMap.putIfAbsent(packageName, obtainVersionSignature);
            return putIfAbsent == null ? obtainVersionSignature : putIfAbsent;
        }
        return key;
    }

    private static Key obtainVersionSignature(Context context) {
        return new ObjectKey(getVersionCode(getPackageInfo(context)));
    }

    static void reset() {
        PACKAGE_NAME_TO_KEY.clear();
    }
}