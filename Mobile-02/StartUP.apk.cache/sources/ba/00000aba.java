package com.coinbase.android.apiv3.generated.authed;

import com.coinbase.android.apiv3.V3Error;
import com.coinbase.network.adapter.NetworkResponse;
import h.c.b0;
import kotlin.Metadata;
import retrofit2.z.f;
import retrofit2.z.t;

/* compiled from: BanksService.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\b\u0010\tJ+\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\rJ+\u0010\u0010\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\u0010\u0010\u0011J+\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00070\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0012H'¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/BanksService;", "", "Lcom/coinbase/android/apiv3/generated/authed/ListBankAccountTypesRequest;", "request", "Lh/c/b0;", "Lcom/coinbase/network/adapter/NetworkResponse;", "Lcom/coinbase/android/apiv3/generated/authed/ListBankAccountTypesResponse;", "Lcom/coinbase/android/apiv3/V3Error;", "listAccountTypes", "(Lcom/coinbase/android/apiv3/generated/authed/ListBankAccountTypesRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ListBanksRequest;", "Lcom/coinbase/android/apiv3/generated/authed/ListBanksResponse;", "listBanks", "(Lcom/coinbase/android/apiv3/generated/authed/ListBanksRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest;", "Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesResponse;", "listBranches", "(Lcom/coinbase/android/apiv3/generated/authed/ListBankBranchesRequest;)Lh/c/b0;", "Lcom/coinbase/android/apiv3/generated/authed/ListHighlightedBanksRequest;", "Lcom/coinbase/android/apiv3/generated/authed/ListHighlightedBanksResponse;", "listHighlightedBanks", "(Lcom/coinbase/android/apiv3/generated/authed/ListHighlightedBanksRequest;)Lh/c/b0;", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public interface BanksService {
    @f("coinbase.public_api.authed.BanksService/ListAccountTypes")
    b0<NetworkResponse<ListBankAccountTypesResponse, V3Error>> listAccountTypes(@t("q") ListBankAccountTypesRequest listBankAccountTypesRequest);

    @f("coinbase.public_api.authed.BanksService/ListBanks")
    b0<NetworkResponse<ListBanksResponse, V3Error>> listBanks(@t("q") ListBanksRequest listBanksRequest);

    @f("coinbase.public_api.authed.BanksService/ListBranches")
    b0<NetworkResponse<ListBankBranchesResponse, V3Error>> listBranches(@t("q") ListBankBranchesRequest listBankBranchesRequest);

    @f("coinbase.public_api.authed.BanksService/ListHighlightedBanks")
    b0<NetworkResponse<ListHighlightedBanksResponse, V3Error>> listHighlightedBanks(@t("q") ListHighlightedBanksRequest listHighlightedBanksRequest);
}