package com.coinbase.wallet.qr.di;

import com.coinbase.wallet.qr.parsers.QRCodeIntentParser;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* compiled from: QrParserMapKey.kt */
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/qr/di/QrParserMapKey;", "", "Lkotlin/j0/d;", "Lcom/coinbase/wallet/qr/parsers/QRCodeIntentParser;", "value", "()Ljava/lang/Class;", "<init>", "(Lkotlin/j0/d;)V", "qr_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public @interface QrParserMapKey {
    Class<? extends QRCodeIntentParser> value();
}