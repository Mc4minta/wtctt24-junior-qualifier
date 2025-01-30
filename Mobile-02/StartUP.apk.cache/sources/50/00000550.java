package c.h.i;

import android.util.Base64;
import androidx.core.util.h;
import java.util.List;

/* compiled from: FontRequest.java */
/* loaded from: classes.dex */
public final class d {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2954b;

    /* renamed from: c  reason: collision with root package name */
    private final String f2955c;

    /* renamed from: d  reason: collision with root package name */
    private final List<List<byte[]>> f2956d;

    /* renamed from: e  reason: collision with root package name */
    private final int f2957e = 0;

    /* renamed from: f  reason: collision with root package name */
    private final String f2958f;

    public d(String str, String str2, String str3, List<List<byte[]>> list) {
        this.a = (String) h.b(str);
        this.f2954b = (String) h.b(str2);
        this.f2955c = (String) h.b(str3);
        this.f2956d = (List) h.b(list);
        this.f2958f = a(str, str2, str3);
    }

    private String a(String str, String str2, String str3) {
        return str + "-" + str2 + "-" + str3;
    }

    public List<List<byte[]>> b() {
        return this.f2956d;
    }

    public int c() {
        return this.f2957e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String d() {
        return this.f2958f;
    }

    public String e() {
        return this.a;
    }

    public String f() {
        return this.f2954b;
    }

    public String g() {
        return this.f2955c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FontRequest {mProviderAuthority: " + this.a + ", mProviderPackage: " + this.f2954b + ", mQuery: " + this.f2955c + ", mCertificates:");
        for (int i2 = 0; i2 < this.f2956d.size(); i2++) {
            sb.append(" [");
            List<byte[]> list = this.f2956d.get(i2);
            for (int i3 = 0; i3 < list.size(); i3++) {
                sb.append(" \"");
                sb.append(Base64.encodeToString(list.get(i3), 0));
                sb.append("\"");
            }
            sb.append(" ]");
        }
        sb.append("}");
        sb.append("mCertificatesArray: " + this.f2957e);
        return sb.toString();
    }
}