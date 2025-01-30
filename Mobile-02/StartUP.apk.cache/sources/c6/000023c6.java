package com.coinbase.wallet.http.extensions;

import java.net.URL;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.m;
import kotlin.l0.x;

/* compiled from: URL+HTTP.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ljava/net/URL;", "", "component", "appendingPathComponent", "(Ljava/net/URL;Ljava/lang/String;)Ljava/net/URL;", "http_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class URL_HTTPKt {
    public static final URL appendingPathComponent(URL url, String component) {
        List m;
        boolean Q;
        boolean z;
        String h0;
        m.g(url, "<this>");
        m.g(component, "component");
        m = r.m(url.getFile());
        Q = x.Q(component, "/", false, 2, null);
        if (Q) {
            component = component.substring(1);
            m.f(component, "(this as java.lang.String).substring(startIndex)");
        }
        String file = url.getFile();
        m.f(file, "file");
        z = x.z(file, "/", false, 2, null);
        if (!z) {
            m.add("/");
        }
        m.add(component);
        String protocol = url.getProtocol();
        String host = url.getHost();
        int port = url.getPort();
        h0 = z.h0(m, "", null, null, 0, null, null, 62, null);
        return new URL(protocol, host, port, h0, null);
    }
}