package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p000firebaseperf.o0;
import java.util.Locale;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
/* loaded from: classes2.dex */
public abstract class s {
    public static String a(Map.Entry<String, String> entry) {
        String key = entry.getKey();
        String value = entry.getValue();
        if (key == null) {
            return "Attribute key must not be null";
        }
        if (value == null) {
            return "Attribute value must not be null";
        }
        if (key.length() > 40) {
            return String.format(Locale.US, "Attribute key length must not exceed %d characters", 40);
        }
        if (value.length() > 100) {
            return String.format(Locale.US, "Attribute value length must not exceed %d characters", 100);
        }
        if (key.matches("^(?!(firebase_|google_|ga_))[A-Za-z][A-Za-z_0-9]*")) {
            return null;
        }
        return "Attribute key must start with letter, must only contain alphanumeric characters and underscore and must not start with \"firebase_\", \"google_\" and \"ga_";
    }

    public static String c(String str) {
        if (str == null) {
            return "Metric name must not be null";
        }
        if (str.length() > 100) {
            return String.format(Locale.US, "Metric name must not exceed %d characters", 100);
        }
        if (str.startsWith("_")) {
            for (o0 o0Var : o0.values()) {
                if (o0Var.toString().equals(str)) {
                    return null;
                }
            }
            return "Metric name must not start with '_'";
        }
        return null;
    }

    public abstract boolean b();
}