package com.google.android.gms.common.stats;

import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class c {
    public static String a(PowerManager.WakeLock wakeLock, String str) {
        String valueOf = String.valueOf(String.valueOf((Process.myPid() << 32) | System.identityHashCode(wakeLock)));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> b(List<String> list) {
        if (list != null && list.size() == 1 && "com.google.android.gms".equals(list.get(0))) {
            return null;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        if ("com.google.android.gms".equals(str)) {
            return null;
        }
        return str;
    }
}