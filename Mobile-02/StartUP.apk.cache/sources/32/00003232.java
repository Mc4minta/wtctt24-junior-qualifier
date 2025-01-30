package com.google.android.gms.common.util;

import android.content.Context;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* compiled from: com.google.android.gms:play-services-basement@@17.1.1 */
/* loaded from: classes2.dex */
public class d {
    public static boolean a(Context context, String str) {
        "com.google.android.gms".equals(str);
        return (com.google.android.gms.common.n.c.a(context).c(str, 0).flags & PKIFailureInfo.badSenderNonce) != 0;
    }
}