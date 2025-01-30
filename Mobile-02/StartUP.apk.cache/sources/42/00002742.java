package com.coinbase.wallet.txhistory.dtos;

import com.coinbase.wallet.core.util.JSON;
import com.coinbase.wallet.txhistory.dtos.EtherscanApiResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.d;

/* compiled from: EtherscanApiResponseDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO$Companion;", "", "json", "Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "fromJsonString", "(Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO$Companion;Ljava/lang/String;)Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "", "fromJson", "(Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO$Companion;[B)Lcom/coinbase/wallet/txhistory/dtos/EtherscanApiResponseDTO;", "txhistory_productionRelease"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class EtherscanApiResponseDTOKt {
    public static final /* synthetic */ <T> EtherscanApiResponseDTO<T> fromJson(EtherscanApiResponseDTO.Companion companion, byte[] json) {
        m.g(companion, "<this>");
        m.g(json, "json");
        String str = new String(json, d.a);
        JSON json2 = JSON.INSTANCE;
        m.l(4, "T");
        return (EtherscanApiResponseDTO) json2.parameterizedAdapter(EtherscanApiResponseDTO.class, Object.class).fromJson(str);
    }

    public static final /* synthetic */ <T> EtherscanApiResponseDTO<T> fromJsonString(EtherscanApiResponseDTO.Companion companion, String json) {
        m.g(companion, "<this>");
        m.g(json, "json");
        JSON json2 = JSON.INSTANCE;
        m.l(4, "T");
        return (EtherscanApiResponseDTO) json2.parameterizedAdapter(EtherscanApiResponseDTO.class, Object.class).fromJson(json);
    }
}