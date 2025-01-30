package com.coinbase.android.apiv3.generated.authed.sends;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.a;
import retrofit2.z.f;
import retrofit2.z.o;
import retrofit2.z.t;

/* compiled from: Sends.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u000f\u0010\u0010J+\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0015H'¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0019H'¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/sends/Sends;", "", "Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "commitSend", "(Lcom/coinbase/android/apiv3/generated/authed/sends/CommitSendRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendResponse;", "createSend", "(Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest;", "createSendMax", "(Lcom/coinbase/android/apiv3/generated/authed/sends/CreateSendMaxRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest;", "Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountResponse;", "previewSendAmount", "(Lcom/coinbase/android/apiv3/generated/authed/sends/PreviewSendAmountRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientRequest;", "Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientResponse;", "searchRecipient", "(Lcom/coinbase/android/apiv3/generated/authed/sends/SearchRecipientRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/sends/ValidateAmountRequest;", "Lcom/coinbase/android/apiv3/generated/authed/sends/ValidateAmountResponse;", "validateAmount", "(Lcom/coinbase/android/apiv3/generated/authed/sends/ValidateAmountRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface Sends {
    @o("coinbase.public_api.authed.sends.Sends/CommitSend")
    b0<NetworkResponse<CommitSendResponse, V3Error>> commitSend(@a CommitSendRequest commitSendRequest);

    @o("coinbase.public_api.authed.sends.Sends/CreateSend")
    b0<NetworkResponse<CreateSendResponse, V3Error>> createSend(@a CreateSendRequest createSendRequest);

    @o("coinbase.public_api.authed.sends.Sends/CreateSendMax")
    b0<NetworkResponse<CreateSendResponse, V3Error>> createSendMax(@a CreateSendMaxRequest createSendMaxRequest);

    @f("coinbase.public_api.authed.sends.Sends/PreviewSendAmount")
    b0<NetworkResponse<PreviewSendAmountResponse, V3Error>> previewSendAmount(@t("q") PreviewSendAmountRequest previewSendAmountRequest);

    @f("coinbase.public_api.authed.sends.Sends/SearchRecipient")
    b0<NetworkResponse<SearchRecipientResponse, V3Error>> searchRecipient(@t("q") SearchRecipientRequest searchRecipientRequest);

    @f("coinbase.public_api.authed.sends.Sends/ValidateAmount")
    b0<NetworkResponse<ValidateAmountResponse, V3Error>> validateAmount(@t("q") ValidateAmountRequest validateAmountRequest);
}