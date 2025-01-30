package com.bugsnag.android;

/* compiled from: BugsnagException.java */
/* loaded from: classes.dex */
public class k extends Throwable {
    private String a;

    /* renamed from: b  reason: collision with root package name */
    private String f3661b;

    /* renamed from: c  reason: collision with root package name */
    private String f3662c;

    public k(String str, String str2, StackTraceElement[] stackTraceElementArr) {
        super(str2);
        this.f3662c = "android";
        setStackTrace(stackTraceElementArr);
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        return this.f3662c;
    }

    public void c(String str) {
        this.f3661b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        this.f3662c = str;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str = this.f3661b;
        return str != null ? str : super.getMessage();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Throwable th) {
        super(th.getMessage());
        this.f3662c = "android";
        if (th instanceof k) {
            k kVar = (k) th;
            this.f3661b = kVar.getMessage();
            this.a = kVar.a();
            this.f3662c = kVar.b();
        } else {
            this.a = th.getClass().getName();
        }
        setStackTrace(th.getStackTrace());
        initCause(th.getCause());
    }
}