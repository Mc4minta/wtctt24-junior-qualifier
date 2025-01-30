package com.bugsnag.android;

import com.bugsnag.android.o0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* compiled from: Stacktrace.java */
/* loaded from: classes.dex */
class a1 implements o0.a {
    private final List<String> a;

    /* renamed from: b  reason: collision with root package name */
    final StackTraceElement[] f3597b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(StackTraceElement[] stackTraceElementArr, String[] strArr) {
        this.f3597b = stackTraceElementArr;
        this.a = b(strArr);
    }

    private static boolean a(String str, List<String> list) {
        for (String str2 : list) {
            if (str2 != null && str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private static List<String> b(String[] strArr) {
        if (strArr != null) {
            return Arrays.asList(strArr);
        }
        return Collections.emptyList();
    }

    @Override // com.bugsnag.android.o0.a
    public void toStream(o0 o0Var) throws IOException {
        o0Var.c();
        int i2 = 0;
        while (true) {
            StackTraceElement[] stackTraceElementArr = this.f3597b;
            if (i2 >= stackTraceElementArr.length || i2 >= 200) {
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i2];
            try {
                o0Var.d();
                if (stackTraceElement.getClassName().length() > 0) {
                    o0 j2 = o0Var.j("method");
                    j2.d0(stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName());
                } else {
                    o0Var.j("method").d0(stackTraceElement.getMethodName());
                }
                o0Var.j("file").d0(stackTraceElement.getFileName() == null ? "Unknown" : stackTraceElement.getFileName());
                o0Var.j("lineNumber").O(stackTraceElement.getLineNumber());
                if (a(stackTraceElement.getClassName(), this.a)) {
                    o0Var.j("inProject").e0(true);
                }
                o0Var.g();
            } catch (Exception e2) {
                q0.e("Failed to serialize stacktrace", e2);
            }
            i2++;
        }
        o0Var.f();
    }
}