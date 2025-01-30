package e.j.f;

import android.text.format.DateUtils;
import com.coinbase.wallet.application.BaseApplication;
import java.util.Date;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: DateExtensions.kt */
/* loaded from: classes2.dex */
public final class j {
    public static final String a(Date date) {
        kotlin.jvm.internal.m.g(date, "<this>");
        return DateUtils.getRelativeDateTimeString(BaseApplication.Companion.getInstance(), date.getTime(), 1000L, 604800000L, PKIFailureInfo.transactionIdInUse).toString();
    }
}