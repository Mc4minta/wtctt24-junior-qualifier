package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.api.Status;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.utils.URLEncodedUtils;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
/* loaded from: classes2.dex */
public final class e implements Runnable {
    private static final com.google.android.gms.common.l.a a = new com.google.android.gms.common.l.a("RevokeAccessOperation", new String[0]);

    /* renamed from: b  reason: collision with root package name */
    private final String f6002b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.android.gms.common.api.internal.o f6003c = new com.google.android.gms.common.api.internal.o(null);

    private e(String str) {
        this.f6002b = com.google.android.gms.common.internal.t.g(str);
    }

    public static com.google.android.gms.common.api.e<Status> a(String str) {
        if (str == null) {
            return com.google.android.gms.common.api.f.a(new Status(4), null);
        }
        e eVar = new e(str);
        new Thread(eVar).start();
        return eVar.f6003c;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Status status = Status.f6034c;
        try {
            String valueOf = String.valueOf(this.f6002b);
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(valueOf.length() != 0 ? "https://accounts.google.com/o/oauth2/revoke?token=".concat(valueOf) : new String("https://accounts.google.com/o/oauth2/revoke?token=")).openConnection();
            httpURLConnection.setRequestProperty("Content-Type", URLEncodedUtils.CONTENT_TYPE);
            int responseCode = httpURLConnection.getResponseCode();
            if (responseCode == 200) {
                status = Status.a;
            } else {
                a.b("Unable to revoke access!", new Object[0]);
            }
            com.google.android.gms.common.l.a aVar = a;
            StringBuilder sb = new StringBuilder(26);
            sb.append("Response Code: ");
            sb.append(responseCode);
            aVar.a(sb.toString(), new Object[0]);
        } catch (IOException e2) {
            com.google.android.gms.common.l.a aVar2 = a;
            String valueOf2 = String.valueOf(e2.toString());
            aVar2.b(valueOf2.length() != 0 ? "IOException when revoking access: ".concat(valueOf2) : new String("IOException when revoking access: "), new Object[0]);
        } catch (Exception e3) {
            com.google.android.gms.common.l.a aVar3 = a;
            String valueOf3 = String.valueOf(e3.toString());
            aVar3.b(valueOf3.length() != 0 ? "Exception when revoking access: ".concat(valueOf3) : new String("Exception when revoking access: "), new Object[0]);
        }
        this.f6003c.f(status);
    }
}