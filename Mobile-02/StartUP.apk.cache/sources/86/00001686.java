package com.coinbase.wallet.consumer.models;

import android.os.Bundle;
import androidx.core.os.b;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: ConsumerSecure3DVerificationArgs.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0006X\u0086D¢\u0006\f\n\u0004\b\u0011\u0010\u000f\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\r8\u0000@\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0015\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerSecure3DVerificationArgs;", "", "Lcom/coinbase/wallet/consumer/models/Secure3DVerification;", "secure3DVerification", "Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;", "selectedTransferMethod", "Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;", "buyOrder", "Ljava/util/UUID;", "uuid", "Landroid/os/Bundle;", "createArgs", "(Lcom/coinbase/wallet/consumer/models/Secure3DVerification;Lcom/coinbase/wallet/consumer/models/AvailableBuyAndSendTransfer;Lcom/coinbase/wallet/consumer/models/ConsumerBuyOrder;Ljava/util/UUID;)Landroid/os/Bundle;", "", "uuidKey", "Ljava/lang/String;", "selectedTransferMethodKey", "resultKey", "getResultKey", "()Ljava/lang/String;", "buyOrderKey", "secure3DVerificationKey", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerSecure3DVerificationArgs {
    public static final String buyOrderKey = "buy_order_key";
    public static final String secure3DVerificationKey = "secure_3d_verification_key";
    public static final String selectedTransferMethodKey = "selected_transfer_method_key";
    public static final String uuidKey = "uuid_key";
    public static final ConsumerSecure3DVerificationArgs INSTANCE = new ConsumerSecure3DVerificationArgs();
    private static final String resultKey = "secure_3d_verification_result_key";

    private ConsumerSecure3DVerificationArgs() {
    }

    public final Bundle createArgs(Secure3DVerification secure3DVerification, AvailableBuyAndSendTransfer selectedTransferMethod, ConsumerBuyOrder buyOrder, UUID uuid) {
        m.g(secure3DVerification, "secure3DVerification");
        m.g(selectedTransferMethod, "selectedTransferMethod");
        m.g(buyOrder, "buyOrder");
        m.g(uuid, "uuid");
        return b.a(u.a(secure3DVerificationKey, secure3DVerification), u.a(selectedTransferMethodKey, selectedTransferMethod), u.a(buyOrderKey, buyOrder), u.a(uuidKey, uuid));
    }

    public final String getResultKey() {
        return resultKey;
    }
}