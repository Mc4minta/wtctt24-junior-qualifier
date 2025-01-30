package e.g.b.a.b.f;

import java.io.IOException;

/* compiled from: CommonGoogleClientRequestInitializer.java */
/* loaded from: classes2.dex */
public class c implements d {
    private final String key;
    private final String userIp;

    public c() {
        this(null);
    }

    public final String getKey() {
        return this.key;
    }

    public final String getUserIp() {
        return this.userIp;
    }

    @Override // e.g.b.a.b.f.d
    public void initialize(b<?> bVar) throws IOException {
        String str = this.key;
        if (str != null) {
            bVar.put("key", (Object) str);
        }
        String str2 = this.userIp;
        if (str2 != null) {
            bVar.put("userIp", (Object) str2);
        }
    }

    public c(String str) {
        this(str, null);
    }

    public c(String str, String str2) {
        this.key = str;
        this.userIp = str2;
    }
}