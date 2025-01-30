package okhttp3.internal.platform.android;

import android.util.Log;
import com.coinbase.ApiConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.y;

/* compiled from: util.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a)\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00008\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"", "level", "", ApiConstants.MESSAGE, "", "t", "Lkotlin/x;", "androidLog", "(ILjava/lang/String;Ljava/lang/Throwable;)V", "MAX_LOG_LENGTH", "I", "okhttp"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class UtilKt {
    private static final int MAX_LOG_LENGTH = 4000;

    public static final void androidLog(int i2, String message, Throwable th) {
        int h0;
        int min;
        m.h(message, "message");
        int i3 = i2 != 5 ? 3 : 5;
        if (th != null) {
            message = message + "\n" + Log.getStackTraceString(th);
        }
        int i4 = 0;
        int length = message.length();
        while (i4 < length) {
            h0 = y.h0(message, '\n', i4, false, 4, null);
            if (h0 == -1) {
                h0 = length;
            }
            while (true) {
                min = Math.min(h0, i4 + MAX_LOG_LENGTH);
                String substring = message.substring(i4, min);
                m.d(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                Log.println(i3, "OkHttp", substring);
                if (min >= h0) {
                    break;
                }
                i4 = min;
            }
            i4 = min + 1;
        }
    }
}