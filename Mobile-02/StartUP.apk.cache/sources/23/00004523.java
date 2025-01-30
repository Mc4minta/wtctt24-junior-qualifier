package e.d.a.a.a;

import com.crashlytics.android.answers.CustomEvent;
import java.util.HashMap;
import java.util.Map;

/* compiled from: KitEvent.java */
/* loaded from: classes2.dex */
public class c {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f11981b = new HashMap();

    public c(String str) {
        this.a = str;
    }

    public c a(String str, String str2) {
        this.f11981b.put(str, str2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomEvent b() {
        CustomEvent customEvent = new CustomEvent(this.a);
        for (String str : this.f11981b.keySet()) {
            Object obj = this.f11981b.get(str);
            if (obj instanceof String) {
                customEvent.putCustomAttribute(str, (String) obj);
            } else if (obj instanceof Number) {
                customEvent.putCustomAttribute(str, (Number) obj);
            }
        }
        return customEvent;
    }
}