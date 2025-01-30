package androidx.lifecycle;

import java.util.HashMap;
import java.util.Map;

/* compiled from: MethodCallsLogger.java */
/* loaded from: classes.dex */
public class t {
    private Map<String, Integer> a = new HashMap();

    public boolean a(String str, int i2) {
        Integer num = this.a.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z = (intValue & i2) != 0;
        this.a.put(str, Integer.valueOf(i2 | intValue));
        return !z;
    }
}