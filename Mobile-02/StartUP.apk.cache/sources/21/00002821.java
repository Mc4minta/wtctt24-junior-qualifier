package com.coinbase.wallet.user.extensions;

import java.util.List;
import kotlin.Metadata;
import kotlin.a0.p;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;

/* compiled from: Strings+User.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0017\u0010\u0005\u001a\u00020\u0004*\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/l0/k;", "usernameValidationRegex", "Lkotlin/l0/k;", "", "", "isUsernameValid", "(Ljava/lang/String;)Z", "user_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Strings_UserKt {
    private static final k usernameValidationRegex = new k("^[a-zA-Z][a-zA-Z0-9_]{2,20}$");

    public static final boolean isUsernameValid(String str) {
        List<String> b2;
        m.g(str, "<this>");
        String str2 = null;
        i b3 = k.b(usernameValidationRegex, str, 0, 2, null);
        if (b3 != null && (b2 = b3.b()) != null) {
            str2 = (String) p.a0(b2);
        }
        return str2 != null;
    }
}