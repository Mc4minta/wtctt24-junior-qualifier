package com.coinbase.walletlink.dtos;

import com.coinbase.wallet.core.util.JSON;
import com.coinbase.walletlink.dtos.Web3RequestDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.l0.d;

/* compiled from: Web3RequestDTO.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a,\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a,\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0007H\u0080\b¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lcom/coinbase/walletlink/dtos/Web3RequestDTO$Companion;", "", "json", "Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "fromJsonString", "(Lcom/coinbase/walletlink/dtos/Web3RequestDTO$Companion;Ljava/lang/String;)Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "", "fromJson", "(Lcom/coinbase/walletlink/dtos/Web3RequestDTO$Companion;[B)Lcom/coinbase/walletlink/dtos/Web3RequestDTO;", "walletlink_release"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Web3RequestDTOKt {
    public static final /* synthetic */ <T> Web3RequestDTO<T> fromJson(Web3RequestDTO.Companion companion, byte[] json) {
        m.g(companion, "<this>");
        m.g(json, "json");
        String str = new String(json, d.a);
        JSON json2 = JSON.INSTANCE;
        m.l(4, "T");
        return (Web3RequestDTO) json2.parameterizedAdapter(Web3RequestDTO.class, Object.class).fromJson(str);
    }

    public static final /* synthetic */ <T> Web3RequestDTO<T> fromJsonString(Web3RequestDTO.Companion companion, String json) {
        m.g(companion, "<this>");
        m.g(json, "json");
        JSON json2 = JSON.INSTANCE;
        m.l(4, "T");
        return (Web3RequestDTO) json2.parameterizedAdapter(Web3RequestDTO.class, Object.class).fromJson(json);
    }
}