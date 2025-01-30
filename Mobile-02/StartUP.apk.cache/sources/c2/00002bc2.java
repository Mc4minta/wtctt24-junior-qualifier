package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.util.JSON;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: Web3ResponseDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u00020\u0002\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0080\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;", "", "asJsonString", "(Lcom/coinbase/walletlink/dtos/Web3ResponseDTO;)Ljava/lang/String;", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3ResponseDTOKt {
    public static final /* synthetic */ <T> String asJsonString(Web3ResponseDTO<T> web3ResponseDTO) {
        m.g(web3ResponseDTO, "<this>");
        JSON json = JSON.INSTANCE;
        m.l(4, "T");
        String json2 = json.parameterizedAdapter(Web3ResponseDTO.class, Object.class).toJson(web3ResponseDTO);
        m.f(json2, "adapter.toJson(this)");
        return json2;
    }
}