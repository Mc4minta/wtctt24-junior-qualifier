package com.coinbase.wallet.libraries.databases.converters;

import java.net.URL;
import kotlin.Metadata;

/* compiled from: UrlConverter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/wallet/libraries/databases/converters/UrlConverter;", "", "", "value", "Ljava/net/URL;", "fromString", "(Ljava/lang/String;)Ljava/net/URL;", "toString", "(Ljava/net/URL;)Ljava/lang/String;", "<init>", "()V", "database_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class UrlConverter {
    public final URL fromString(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return new URL(str);
    }

    public final String toString(URL url) {
        if (url == null) {
            return null;
        }
        return url.toString();
    }
}