package com.facebook.react.modules.email;

import android.content.Intent;
import android.content.pm.LabeledIntent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class EmailModule extends ReactContextBaseJavaModule {
    public EmailModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    private Intent createLaunchIntent(ResolveInfo resolveInfo, boolean z) {
        Intent launchIntentForPackage = getCurrentActivity().getPackageManager().getLaunchIntentForPackage(resolveInfo.activityInfo.packageName);
        if (launchIntentForPackage != null) {
            setNewTaskFlag(launchIntentForPackage, z);
        }
        return launchIntentForPackage;
    }

    private void setNewTaskFlag(Intent intent, boolean z) {
        if (z) {
            intent.addFlags(268435456);
        } else {
            intent.setFlags(intent.getFlags() & (-268435457));
        }
    }

    @ReactMethod
    public void compose(String str, String str2, String str3, String str4) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse("mailto:" + Uri.encode(str2) + "?subject=" + Uri.encode(str3) + "&body=" + Uri.encode(str4)));
        Intent createChooser = Intent.createChooser(intent, str);
        createChooser.setFlags(268435456);
        getReactApplicationContext().startActivity(createChooser);
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "Email";
    }

    @ReactMethod
    public void open(String str, boolean z) {
        Intent createLaunchIntent;
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("mailto:"));
        PackageManager packageManager = getCurrentActivity().getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        if (queryIntentActivities.size() <= 0 || (createLaunchIntent = createLaunchIntent(queryIntentActivities.get(0), z)) == null) {
            return;
        }
        Intent createChooser = Intent.createChooser(createLaunchIntent, str);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 < queryIntentActivities.size(); i2++) {
            ResolveInfo resolveInfo = queryIntentActivities.get(i2);
            String str2 = resolveInfo.activityInfo.packageName;
            Intent createLaunchIntent2 = createLaunchIntent(resolveInfo, z);
            if (createLaunchIntent2 != null) {
                arrayList.add(new LabeledIntent(createLaunchIntent2, str2, resolveInfo.loadLabel(packageManager), resolveInfo.icon));
            }
        }
        createChooser.putExtra("android.intent.extra.INITIAL_INTENTS", (LabeledIntent[]) arrayList.toArray(new LabeledIntent[arrayList.size()]));
        setNewTaskFlag(createChooser, z);
        getCurrentActivity().startActivity(createChooser);
    }
}