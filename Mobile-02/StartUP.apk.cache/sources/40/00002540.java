package com.coinbase.wallet.qr.parsers;

import com.coinbase.wallet.qr.exceptions.QrException;
import com.coinbase.wallet.qr.models.QRCodeScanResult;
import h.c.b0;
import kotlin.Metadata;
import kotlin.UInt;
import org.spongycastle.i18n.TextBundle;

/* compiled from: UnsignedIntegerQrCodeParser.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/qr/parsers/UnsignedIntegerQrCodeParser;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "", TextBundle.TEXT_ENTRY, "Lh/c/b0;", "Lcom/coinbase/wallet/qr/models/QRCodeScanResult;", "parse", "(Ljava/lang/String;)Lh/c/b0;", "<init>", "()V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class UnsignedIntegerQrCodeParser implements QRCodeIntentParser {
    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.isRegister()" because "arg" is null
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: parse$lambda-1  reason: not valid java name */
    public static final com.coinbase.wallet.qr.models.QRCodeScanResult m1640parse$lambda1(com.coinbase.wallet.qr.models.QRCodeScanResult.UnsignedInteger r1) {
        /*
            java.lang.String r0 = "it"
            kotlin.jvm.internal.m.g(r1, r0)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.qr.parsers.UnsignedIntegerQrCodeParser.m1640parse$lambda1(com.coinbase.wallet.qr.models.QRCodeScanResult$UnsignedInteger):com.coinbase.wallet.qr.models.QRCodeScanResult");
    }

    @Override // com.coinbase.wallet.qr.parsers.QRCodeIntentParser
    public b0<QRCodeScanResult> parse(String text) {
        b0 just;
        kotlin.jvm.internal.m.g(text, "text");
        UInt b2 = kotlin.l0.b0.b(text);
        b0<QRCodeScanResult> b0Var = null;
        if (b2 != null && (just = b0.just(new QRCodeScanResult.UnsignedInteger(b2.B(), null))) != null) {
            b0Var = just.map(new h.c.m0.n() { // from class: com.coinbase.wallet.qr.parsers.q
                @Override // h.c.m0.n
                public final Object apply(Object obj) {
                    return UnsignedIntegerQrCodeParser.m1640parse$lambda1((QRCodeScanResult.UnsignedInteger) obj);
                }
            });
        }
        if (b0Var == null) {
            b0<QRCodeScanResult> error = b0.error(new QrException.InvalidQrCode("Unable to parse scanned text"));
            kotlin.jvm.internal.m.f(error, "error<QRCodeScanResult>(InvalidQrCode(\"Unable to parse scanned text\"))");
            return error;
        }
        return b0Var;
    }
}