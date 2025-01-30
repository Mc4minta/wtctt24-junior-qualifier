package com.coinbase.wallet.qr.parsers;

import android.net.UrlQuerySanitizer;
import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a0.m0;
import kotlin.a0.z;
import kotlin.l0.x;
import org.spongycastle.i18n.TextBundle;

/* compiled from: WalletLinkQrParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/WalletLinkQrParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", TextBundle.TEXT_ENTRY, "Lh/c/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class WalletLinkQrParser implements QRCodeIntentParser {
    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        String h0;
        int r;
        Map r2;
        boolean D;
        boolean z;
        kotlin.jvm.internal.m.g(text, "text");
        kotlin.l0.i c2 = new kotlin.l0.k("(http|https)(://)(.*?)(/#/)(link\\?.*)").c(text);
        List<String> b2 = c2 == null ? null : c2.b();
        if (b2 == null) {
            b2 = kotlin.a0.r.g();
        }
        if (b2.isEmpty()) {
            b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Invalid QR Code"));
            kotlin.jvm.internal.m.f(error, "error(InvalidQrCode(\"Invalid QR Code\"))");
            return error;
        }
        h0 = z.h0(b2.subList(1, b2.size()), "", null, null, 0, null, WalletLinkQrParser$parse$url$1.INSTANCE, 30, null);
        List<UrlQuerySanitizer.ParameterValuePair> parameterList = new UrlQuerySanitizer(h0).getParameterList();
        kotlin.jvm.internal.m.f(parameterList, "UrlQuerySanitizer(url)\n            .parameterList");
        r = kotlin.a0.s.r(parameterList, 10);
        ArrayList arrayList = new ArrayList(r);
        for (UrlQuerySanitizer.ParameterValuePair parameterValuePair : parameterList) {
            arrayList.add(kotlin.u.a(parameterValuePair.mParameter, parameterValuePair.mValue));
        }
        r2 = m0.r(arrayList);
        String str = (String) r2.get("id");
        if (str == null && (str = (String) r2.get("parent-id")) == null) {
            b0<QRCodeScanResult> error2 = b0.error(new QrException.InvalidQrCode("Session ID Missing"));
            kotlin.jvm.internal.m.f(error2, "error(InvalidQrCode(\"Session ID Missing\"))");
            return error2;
        }
        String str2 = (String) r2.get("secret");
        if (str2 == null) {
            b0<QRCodeScanResult> error3 = b0.error(new QrException.InvalidQrCode("Secret Missing"));
            kotlin.jvm.internal.m.f(error3, "error(InvalidQrCode(\"Secret Missing\"))");
            return error3;
        }
        try {
            URL url = new URL((String) r2.get("server"));
            String str3 = (String) r2.get("v");
            String str4 = (String) r2.get("parent-id");
            if (str4 != null) {
                D = x.D(str4);
                if (!D) {
                    z = true;
                    b0<QRCodeScanResult> just = b0.just(new QRCodeScanResult.WalletLink(str, str2, url, str3, z));
                    kotlin.jvm.internal.m.f(just, "just(QRCodeScanResult.WalletLink(\n            sessionId = sessionId,\n            secret = secret,\n            serverUrl = serverUrl,\n            version = version,\n            isParent = isParent\n        ))");
                    return just;
                }
            }
            z = false;
            b0<QRCodeScanResult> just2 = b0.just(new QRCodeScanResult.WalletLink(str, str2, url, str3, z));
            kotlin.jvm.internal.m.f(just2, "just(QRCodeScanResult.WalletLink(\n            sessionId = sessionId,\n            secret = secret,\n            serverUrl = serverUrl,\n            version = version,\n            isParent = isParent\n        ))");
            return just2;
        } catch (Exception e2) {
            b0<QRCodeScanResult> error4 = b0.error(e2);
            kotlin.jvm.internal.m.f(error4, "error(e)");
            return error4;
        }
    }
}