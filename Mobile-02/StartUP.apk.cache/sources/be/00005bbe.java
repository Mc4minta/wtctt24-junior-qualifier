package org.apache.commons.lang3.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

/* compiled from: ExceptionUtils.java */
/* loaded from: classes3.dex */
public class c {
    private static final String[] a = {"getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable"};

    public static String a(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter((Writer) stringWriter, true));
        return stringWriter.getBuffer().toString();
    }
}