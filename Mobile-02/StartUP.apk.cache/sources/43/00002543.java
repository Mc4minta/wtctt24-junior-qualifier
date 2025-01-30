package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import kotlin.Metadata;
import org.spongycastle.i18n.TextBundle;

/* compiled from: Utf8StringFixedLengthQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/Utf8StringFixedLengthQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", TextBundle.TEXT_ENTRY, "Lh/c/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "", "maxChars", "I", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Utf8StringFixedLengthQrCodeParser implements QRCodeIntentParser {
    private final int maxChars = 28;

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        kotlin.jvm.internal.m.g(text, "text");
        byte[] bytes = text.getBytes(kotlin.l0.d.a);
        kotlin.jvm.internal.m.f(bytes, "(this as java.lang.String).getBytes(charset)");
        if (bytes.length <= this.maxChars) {
            b0<QRCodeScanResult> just = b0.just(new QRCodeScanResult.Utf8String(this.maxChars, text));
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(QRCodeScanResult.Utf8String(maxChars, text))\n        }");
            return just;
        }
        b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Unable to parse scanned text."));
        kotlin.jvm.internal.m.f(error, "{\n            Single.error<QRCodeScanResult>(InvalidQrCode(\"Unable to parse scanned text.\"))\n        }");
        return error;
    }
}