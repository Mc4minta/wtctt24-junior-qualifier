package com.bugsnag.android;

import android.text.TextUtils;
import com.bugsnag.android.o0;
import java.io.IOException;

/* compiled from: HandledState.java */
/* loaded from: classes.dex */
public final class k0 implements o0.a {
    private final String a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3663b;

    /* renamed from: c  reason: collision with root package name */
    private final Severity f3664c;

    /* renamed from: d  reason: collision with root package name */
    private Severity f3665d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f3666e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(String str, Severity severity, boolean z, String str2) {
        this.a = str;
        this.f3664c = severity;
        this.f3666e = z;
        this.f3663b = str2;
        this.f3665d = severity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k0 c(String str, Severity severity, String str2) {
        if (str.equals("strictMode") && TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("No reason supplied for strictmode");
        }
        if (!str.equals("strictMode") && !str.equals("log") && !TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("attributeValue should not be supplied");
        }
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1876197364:
                if (str.equals("strictMode")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1773746641:
                if (str.equals("userCallbackSetSeverity")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1591166708:
                if (str.equals("unhandledException")) {
                    c2 = 2;
                    break;
                }
                break;
            case -1107031998:
                if (str.equals("userSpecifiedSeverity")) {
                    c2 = 3;
                    break;
                }
                break;
            case -573976797:
                if (str.equals("anrError")) {
                    c2 = 4;
                    break;
                }
                break;
            case 107332:
                if (str.equals("log")) {
                    c2 = 5;
                    break;
                }
                break;
            case 87505361:
                if (str.equals("unhandledPromiseRejection")) {
                    c2 = 6;
                    break;
                }
                break;
            case 561970291:
                if (str.equals("handledException")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return new k0(str, Severity.WARNING, true, str2);
            case 1:
                return new k0(str, severity, false, null);
            case 2:
                return new k0(str, Severity.ERROR, true, null);
            case 3:
                return new k0(str, severity, false, null);
            case 4:
                return new k0(str, Severity.ERROR, true, null);
            case 5:
                return new k0(str, severity, false, str2);
            case 6:
                return new k0(str, Severity.ERROR, true, null);
            case 7:
                return new k0(str, Severity.WARNING, false, null);
            default:
                throw new IllegalArgumentException(String.format("Invalid argument '%s' for severityReason", str));
        }
    }

    String a() {
        return this.f3664c == this.f3665d ? this.a : "userCallbackSetSeverity";
    }

    public boolean b() {
        return this.f3666e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Severity severity) {
        this.f3665d = severity;
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.d().j("type").d0(a());
        if (this.f3663b != null) {
            String str = null;
            String str2 = this.a;
            str2.hashCode();
            if (str2.equals("strictMode")) {
                str = "violationType";
            } else if (str2.equals("log")) {
                str = "level";
            }
            if (str != null) {
                o0Var.j("attributes").d().j(str).d0(this.f3663b).g();
            }
        }
        o0Var.g();
    }
}