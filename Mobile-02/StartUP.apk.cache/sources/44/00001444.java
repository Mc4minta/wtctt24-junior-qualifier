package com.coinbase.wallet.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;

/* compiled from: ScreenshotProtection.kt */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/common/annotations/ScreenshotProtection;", "", "Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "behavior", "()Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "<init>", "(Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;)V", "Behavior", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public @interface ScreenshotProtection {

    /* compiled from: ScreenshotProtection.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/common/annotations/ScreenshotProtection$Behavior;", "", "<init>", "(Ljava/lang/String;I)V", "BLOCK", "ALLOW", "common_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public enum Behavior {
        BLOCK,
        ALLOW
    }

    Behavior behavior();
}