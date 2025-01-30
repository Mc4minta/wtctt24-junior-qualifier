package com.bugsnag.android;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: StrictModeHandler.java */
/* loaded from: classes.dex */
class b1 {
    @SuppressLint({"UseSparseArrays"})
    private static final Map<Integer, String> a;

    static {
        HashMap hashMap = new HashMap();
        a = hashMap;
        hashMap.put(1, "DiskWrite");
        hashMap.put(2, "DiskRead");
        hashMap.put(4, "NetworkOperation");
        hashMap.put(8, "CustomSlowCall");
        hashMap.put(16, "ResourceMismatch");
        hashMap.put(256, "CursorLeak");
        hashMap.put(512, "CloseableLeak");
        hashMap.put(1024, "ActivityLeak");
        hashMap.put(Integer.valueOf((int) PKIFailureInfo.wrongIntegrity), "InstanceLeak");
        hashMap.put(4096, "RegistrationLeak");
        hashMap.put(Integer.valueOf((int) PKIFailureInfo.certRevoked), "FileUriLeak");
        hashMap.put(16384, "CleartextNetwork");
    }

    private Throwable a(Throwable th) {
        Throwable cause = th.getCause();
        return cause == null ? th : a(cause);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(String str) {
        if (!TextUtils.isEmpty(str)) {
            int lastIndexOf = str.lastIndexOf("violation=");
            if (lastIndexOf != -1) {
                String replace = str.substring(lastIndexOf).replace("violation=", "");
                if (TextUtils.isDigitsOnly(replace)) {
                    return a.get(Integer.valueOf(replace));
                }
                return null;
            }
            return null;
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(Throwable th) {
        return a(th).getClass().getName().toLowerCase(Locale.US).startsWith("android.os.strictmode");
    }
}