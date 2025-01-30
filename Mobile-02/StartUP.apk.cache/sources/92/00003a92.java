package com.google.firebase.crashlytics.c.n.d;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.SendConfirmationArgs;
import com.google.firebase.crashlytics.c.g.b0;
import com.google.firebase.crashlytics.c.g.k;
import java.io.File;
import java.io.IOException;

/* compiled from: com.google.firebase:firebase-crashlytics@@17.0.0 */
/* loaded from: classes2.dex */
public class d extends com.google.firebase.crashlytics.c.g.a implements b {

    /* renamed from: f  reason: collision with root package name */
    private final String f9021f;

    public d(String str, String str2, com.google.firebase.crashlytics.c.k.c cVar, String str3) {
        super(str, str2, cVar, com.google.firebase.crashlytics.c.k.a.POST);
        this.f9021f = str3;
    }

    private com.google.firebase.crashlytics.c.k.b g(com.google.firebase.crashlytics.c.k.b bVar, String str) {
        bVar.d("User-Agent", "Crashlytics Android SDK/" + k.i()).d("X-CRASHLYTICS-API-CLIENT-TYPE", "android").d("X-CRASHLYTICS-API-CLIENT-VERSION", this.f9021f).d("X-CRASHLYTICS-GOOGLE-APP-ID", str);
        return bVar;
    }

    private com.google.firebase.crashlytics.c.k.b h(com.google.firebase.crashlytics.c.k.b bVar, String str, com.google.firebase.crashlytics.c.n.c.c cVar) {
        File[] d2;
        if (str != null) {
            bVar.g("org_id", str);
        }
        bVar.g("report_id", cVar.a());
        for (File file : cVar.d()) {
            if (file.getName().equals("minidump")) {
                bVar.h("minidump_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals(SendConfirmationArgs.metadataKey)) {
                bVar.h("crash_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("binaryImages")) {
                bVar.h("binary_images_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("session")) {
                bVar.h("session_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("app")) {
                bVar.h("app_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("device")) {
                bVar.h("device_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("os")) {
                bVar.h("os_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals(ApiConstants.USER)) {
                bVar.h("user_meta_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("logs")) {
                bVar.h("logs_file", file.getName(), "application/octet-stream", file);
            } else if (file.getName().equals("keys")) {
                bVar.h("keys_file", file.getName(), "application/octet-stream", file);
            }
        }
        return bVar;
    }

    @Override // com.google.firebase.crashlytics.c.n.d.b
    public boolean b(com.google.firebase.crashlytics.c.n.c.a aVar, boolean z) {
        if (z) {
            com.google.firebase.crashlytics.c.k.b h2 = h(g(c(), aVar.f9013b), aVar.a, aVar.f9014c);
            com.google.firebase.crashlytics.c.b f2 = com.google.firebase.crashlytics.c.b.f();
            f2.b("Sending report to: " + e());
            try {
                int b2 = h2.b().b();
                com.google.firebase.crashlytics.c.b f3 = com.google.firebase.crashlytics.c.b.f();
                f3.b("Result was: " + b2);
                return b0.a(b2) == 0;
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        throw new RuntimeException("An invalid data collection token was used.");
    }
}