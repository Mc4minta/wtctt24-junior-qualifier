package androidx.navigation;

import android.content.Intent;
import android.net.Uri;

/* compiled from: NavDeepLinkRequest.java */
/* loaded from: classes.dex */
public class j {
    private final Uri a;

    /* renamed from: b  reason: collision with root package name */
    private final String f1898b;

    /* renamed from: c  reason: collision with root package name */
    private final String f1899c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Intent intent) {
        this(intent.getData(), intent.getAction(), intent.getType());
    }

    public String a() {
        return this.f1898b;
    }

    public String b() {
        return this.f1899c;
    }

    public Uri c() {
        return this.a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NavDeepLinkRequest");
        sb.append("{");
        if (this.a != null) {
            sb.append(" uri=");
            sb.append(this.a.toString());
        }
        if (this.f1898b != null) {
            sb.append(" action=");
            sb.append(this.f1898b);
        }
        if (this.f1899c != null) {
            sb.append(" mimetype=");
            sb.append(this.f1899c);
        }
        sb.append(" }");
        return sb.toString();
    }

    j(Uri uri, String str, String str2) {
        this.a = uri;
        this.f1898b = str;
        this.f1899c = str2;
    }
}