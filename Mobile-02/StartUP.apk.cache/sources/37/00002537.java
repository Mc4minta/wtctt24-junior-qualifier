package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import java.math.BigInteger;
import kotlin.Metadata;
import org.spongycastle.i18n.TextBundle;

/* compiled from: HexStringFixedLengthQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/HexStringFixedLengthQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", "", "isHexString", "(Ljava/lang/String;)Z", TextBundle.TEXT_ENTRY, "Lh/c/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "", "fixedLength", "I", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class HexStringFixedLengthQrCodeParser implements QRCodeIntentParser {
    private final int fixedLength = 64;

    private final boolean isHexString(String str) {
        try {
            new BigInteger(str, 16);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        kotlin.jvm.internal.m.g(text, "text");
        if (isHexString(text) && text.length() == this.fixedLength) {
            b0<QRCodeScanResult> just = b0.just(new QRCodeScanResult.HexString(this.fixedLength, text));
            kotlin.jvm.internal.m.f(just, "{\n            Single.just(QRCodeScanResult.HexString(fixedLength, text))\n        }");
            return just;
        }
        b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
        kotlin.jvm.internal.m.f(error, "{\n            Single.error<QRCodeScanResult>(InvalidQrCode(\"Unable to parse scanned text\"))\n        }");
        return error;
    }
}