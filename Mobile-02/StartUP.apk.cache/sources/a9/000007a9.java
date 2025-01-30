package com.bugsnag.android;

import com.bugsnag.BugsnagReactNative;
import com.bugsnag.android.o0;
import com.coinbase.ApiConstants;
import java.io.IOException;

/* compiled from: JavaScriptException.java */
/* loaded from: classes.dex */
public class n0 extends k implements o0.a {

    /* renamed from: d  reason: collision with root package name */
    private final String f3668d;

    public n0(String str, String str2, String str3) {
        super(str, str2, new StackTraceElement[0]);
        super.d("browserjs");
        this.f3668d = str3;
    }

    private Integer e(String str) {
        try {
            return Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            BugsnagReactNative.logger.info(String.format("Expected an integer, got: '%s'", str));
            return null;
        }
    }

    private void f(o0 o0Var, String str) throws IOException {
        int max = Math.max(str.lastIndexOf(" "), str.lastIndexOf("("));
        int lastIndexOf = str.lastIndexOf(")");
        boolean z = max > -1 && max < lastIndexOf;
        int indexOf = str.indexOf(" (");
        boolean z2 = 3 < indexOf;
        if (z || z2) {
            o0Var.d();
            o0Var.j("method").d0(str.substring(3, indexOf));
            if (z) {
                String substring = str.substring(max + 1, lastIndexOf);
                o0Var.j("file").d0(substring.replaceFirst(":\\d+:\\d+$", ""));
                String[] split = substring.split(":");
                if (split.length >= 2) {
                    Integer e2 = e(split[split.length - 2]);
                    Integer e3 = e(split[split.length - 1]);
                    if (e2 != null) {
                        o0Var.j("lineNumber").a0(e2);
                    }
                    if (e3 != null) {
                        o0Var.j("columnNumber").a0(e3);
                    }
                }
            }
            o0Var.g();
        }
    }

    private void g(o0 o0Var, String str) throws IOException {
        o0Var.d();
        String[] split = str.split("@", 2);
        String str2 = split[0];
        if (split.length == 2) {
            o0Var.j("method").d0(split[0]);
            str2 = split[1];
        }
        int lastIndexOf = str2.lastIndexOf(":");
        if (lastIndexOf != -1) {
            Integer e2 = e(str2.substring(lastIndexOf + 1));
            if (e2 != null) {
                o0Var.j("columnNumber").a0(e2);
            }
            str2 = str2.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str2.lastIndexOf(":");
        if (lastIndexOf2 != -1) {
            Integer e3 = e(str2.substring(lastIndexOf2 + 1));
            if (e3 != null) {
                o0Var.j("lineNumber").a0(e3);
            }
            str2 = str2.substring(0, lastIndexOf2);
        }
        o0Var.j("file").d0(str2);
        o0Var.g();
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        String[] split;
        o0Var.d();
        o0Var.j("errorClass").d0(a());
        o0Var.j(ApiConstants.MESSAGE).d0(getMessage());
        o0Var.j("type").d0(b());
        o0Var.j("stacktrace");
        o0Var.c();
        boolean matches = this.f3668d.matches("(?s).*\\sat .* \\(.*\\d+:\\d+\\)\\s.*");
        for (String str : this.f3668d.split("\\n")) {
            if (matches) {
                f(o0Var, str.trim());
            } else {
                g(o0Var, str.trim());
            }
        }
        o0Var.f();
        o0Var.g();
    }
}