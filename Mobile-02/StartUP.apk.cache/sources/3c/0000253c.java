package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import kotlin.Metadata;
import org.spongycastle.i18n.TextBundle;

/* compiled from: QRCodeIntentParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "", TextBundle.TEXT_ENTRY, "Lh/c/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface QRCodeIntentParser {
    b0<QRCodeScanResult> parse(String str);
}