package com.appsflyer;

import android.util.Log;
import com.appsflyer.internal.ai;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AFLogger {

    /* renamed from: ι  reason: contains not printable characters */
    private static long f36 = System.currentTimeMillis();

    /* loaded from: classes.dex */
    public enum LogLevel {
        NONE(0),
        ERROR(1),
        WARNING(2),
        INFO(3),
        DEBUG(4),
        VERBOSE(5);
        

        /* renamed from: ɩ  reason: contains not printable characters */
        private int f38;

        LogLevel(int i2) {
            this.f38 = i2;
        }

        public final int getLevel() {
            return this.f38;
        }
    }

    public static void afDebugLog(String str) {
        if (m23(LogLevel.DEBUG)) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m18(str, false));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141(null, "D", m18(str, true));
    }

    public static void afErrorLog(String str, Throwable th) {
        m17(str, th, true);
    }

    public static void afInfoLog(String str, boolean z) {
        if (m23(LogLevel.INFO)) {
            Log.i(AppsFlyerLibCore.LOG_TAG, m18(str, false));
        }
        if (z) {
            if (ai.f183 == null) {
                ai.f183 = new ai();
            }
            ai.f183.m141(null, "I", m18(str, true));
        }
    }

    public static void afRDLog(String str) {
        if (m23(LogLevel.VERBOSE)) {
            Log.v(AppsFlyerLibCore.LOG_TAG, m18(str, false));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141(null, "V", m18(str, true));
    }

    public static void afWarnLog(String str) {
        m22(str);
    }

    public static void resetDeltaTime() {
        f36 = System.currentTimeMillis();
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static void m17(String str, Throwable th, boolean z) {
        String[] strArr;
        if (m23(LogLevel.ERROR) && z) {
            Log.e(AppsFlyerLibCore.LOG_TAG, m18(str, false), th);
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai aiVar = ai.f183;
        Throwable cause = th.getCause();
        String simpleName = th.getClass().getSimpleName();
        String message = cause == null ? th.getMessage() : cause.getMessage();
        StackTraceElement[] stackTrace = cause == null ? th.getStackTrace() : cause.getStackTrace();
        if (stackTrace == null) {
            strArr = new String[]{message};
        } else {
            String[] strArr2 = new String[stackTrace.length + 1];
            strArr2[0] = message;
            for (int i2 = 1; i2 < stackTrace.length; i2++) {
                strArr2[i2] = stackTrace[i2].toString();
            }
            strArr = strArr2;
        }
        aiVar.m141("exception", simpleName, strArr);
    }

    /* renamed from: ǃ  reason: contains not printable characters */
    private static String m18(String str, boolean z) {
        if (z || LogLevel.VERBOSE.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel())) {
            StringBuilder sb = new StringBuilder("(");
            sb.append(m21(System.currentTimeMillis() - f36));
            sb.append(") [");
            sb.append(Thread.currentThread().getName());
            sb.append("] ");
            sb.append(str);
            return sb.toString();
        }
        return str;
    }

    /* renamed from: ɩ  reason: contains not printable characters */
    private static boolean m20() {
        return AppsFlyerProperties.getInstance().isLogsDisabledCompletely();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: Ι  reason: contains not printable characters */
    public static void m22(String str) {
        if (m23(LogLevel.WARNING)) {
            Log.w(AppsFlyerLibCore.LOG_TAG, m18(str, false));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141(null, "W", m18(str, true));
    }

    public static void afErrorLog(String str, Throwable th, boolean z) {
        m17(str, th, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ǃ  reason: contains not printable characters */
    public static void m19(String str) {
        if (!m20()) {
            Log.d(AppsFlyerLibCore.LOG_TAG, m18(str, false));
        }
        if (ai.f183 == null) {
            ai.f183 = new ai();
        }
        ai.f183.m141(null, "F", str);
    }

    public static void afInfoLog(String str) {
        afInfoLog(str, true);
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static boolean m23(LogLevel logLevel) {
        return logLevel.getLevel() <= AppsFlyerProperties.getInstance().getInt("logLevel", LogLevel.NONE.getLevel());
    }

    /* renamed from: Ι  reason: contains not printable characters */
    private static String m21(long j2) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        long hours = timeUnit.toHours(j2);
        long millis = j2 - TimeUnit.HOURS.toMillis(hours);
        long minutes = timeUnit.toMinutes(millis);
        long millis2 = millis - TimeUnit.MINUTES.toMillis(minutes);
        long seconds = timeUnit.toSeconds(millis2);
        return String.format(Locale.getDefault(), "%02d:%02d:%02d:%03d", Long.valueOf(hours), Long.valueOf(minutes), Long.valueOf(seconds), Long.valueOf(timeUnit.toMillis(millis2 - TimeUnit.SECONDS.toMillis(seconds))));
    }
}