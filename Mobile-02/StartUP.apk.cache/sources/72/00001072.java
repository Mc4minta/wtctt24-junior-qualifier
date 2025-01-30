package com.coinbase.cipherwebview.util;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.i;
import kotlin.l0.k;
import kotlin.l0.y;

/* compiled from: Regex+CipherWebView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0019\u0010\u0006\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lkotlin/l0/k$a;", "", "jsRegExp", "Lkotlin/l0/k;", "fromJSRegExp", "(Lkotlin/l0/k$a;Ljava/lang/String;)Lkotlin/l0/k;", "jsRegExpPattern", "Lkotlin/l0/k;", "getJsRegExpPattern", "()Lkotlin/l0/k;", "cipher-webview_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class Regex_CipherWebViewKt {
    private static final k jsRegExpPattern = new k("\\A/(.+)/([a-z]*)\\z");

    public static final k fromJSRegExp(k.a aVar, String jsRegExp) {
        boolean V;
        boolean V2;
        boolean V3;
        Set M0;
        m.g(aVar, "<this>");
        m.g(jsRegExp, "jsRegExp");
        i b2 = k.b(jsRegExpPattern, jsRegExp, 0, 2, null);
        if (b2 == null || b2.b().size() != 3) {
            return null;
        }
        String str = b2.b().get(1);
        String str2 = b2.b().get(2);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        V = y.V(str2, "i", false, 2, null);
        if (V) {
            linkedHashSet.add(kotlin.l0.m.IGNORE_CASE);
        }
        V2 = y.V(str2, "m", false, 2, null);
        if (V2) {
            linkedHashSet.add(kotlin.l0.m.MULTILINE);
        }
        V3 = y.V(str2, "s", false, 2, null);
        if (V3) {
            linkedHashSet.add(kotlin.l0.m.DOT_MATCHES_ALL);
        }
        M0 = z.M0(linkedHashSet);
        return new k(str, M0);
    }

    public static final k getJsRegExpPattern() {
        return jsRegExpPattern;
    }
}