package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.pm.PackageManager;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.0 */
/* loaded from: classes2.dex */
public final class j extends w5 {

    /* renamed from: c  reason: collision with root package name */
    private long f7663c;

    /* renamed from: d  reason: collision with root package name */
    private String f7664d;

    /* renamed from: e  reason: collision with root package name */
    private Boolean f7665e;

    /* renamed from: f  reason: collision with root package name */
    private AccountManager f7666f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f7667g;

    /* renamed from: h  reason: collision with root package name */
    private long f7668h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(b5 b5Var) {
        super(b5Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean A() {
        Account[] result;
        d();
        long a = i().a();
        if (a - this.f7668h > 86400000) {
            this.f7667g = null;
        }
        Boolean bool = this.f7667g;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (androidx.core.content.a.a(h(), "android.permission.GET_ACCOUNTS") != 0) {
            f().L().a("Permission error checking for dasher/unicorn accounts");
            this.f7668h = a;
            this.f7667g = Boolean.FALSE;
            return false;
        }
        if (this.f7666f == null) {
            this.f7666f = AccountManager.get(h());
        }
        try {
            result = this.f7666f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e2) {
            f().I().b("Exception checking account types", e2);
        }
        if (result != null && result.length > 0) {
            this.f7667g = Boolean.TRUE;
            this.f7668h = a;
            return true;
        }
        Account[] result2 = this.f7666f.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
        if (result2 != null && result2.length > 0) {
            this.f7667g = Boolean.TRUE;
            this.f7668h = a;
            return true;
        }
        this.f7668h = a;
        this.f7667g = Boolean.FALSE;
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void a() {
        super.a();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void b() {
        super.b();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ j e() {
        return super.e();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ x3 f() {
        return super.f();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ ja g() {
        return super.g();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ Context h() {
        return super.h();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ com.google.android.gms.common.util.e i() {
        return super.i();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v3 j() {
        return super.j();
    }

    @Override // com.google.android.gms.measurement.internal.x5, com.google.android.gms.measurement.internal.z5
    public final /* bridge */ /* synthetic */ y4 l() {
        return super.l();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ v9 m() {
        return super.m();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ k4 n() {
        return super.n();
    }

    @Override // com.google.android.gms.measurement.internal.x5
    public final /* bridge */ /* synthetic */ ka o() {
        return super.o();
    }

    @Override // com.google.android.gms.measurement.internal.w5
    protected final boolean t() {
        Calendar calendar = Calendar.getInstance();
        this.f7663c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f7664d = sb.toString();
        return false;
    }

    public final boolean v(Context context) {
        if (this.f7665e == null) {
            g();
            this.f7665e = Boolean.FALSE;
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    packageManager.getPackageInfo("com.google.android.gms", 128);
                    this.f7665e = Boolean.TRUE;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return this.f7665e.booleanValue();
    }

    public final long w() {
        q();
        return this.f7663c;
    }

    public final String x() {
        q();
        return this.f7664d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long y() {
        d();
        return this.f7668h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void z() {
        d();
        this.f7667g = null;
        this.f7668h = 0L;
    }
}