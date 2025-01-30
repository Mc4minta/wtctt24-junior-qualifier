package com.coinbase.wallet.featureflags.dtos;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetFeatureFlagsResponseDto.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResultDto;", "", "Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;", "component1", "()Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;", "result", "copy", "(Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;)Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResultDto;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;", "getResult", "<init>", "(Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;)V", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetFeatureFlagsResultDto {
    private final GetFeatureFlagsResponseDto result;

    public GetFeatureFlagsResultDto(GetFeatureFlagsResponseDto result) {
        m.g(result, "result");
        this.result = result;
    }

    public static /* synthetic */ GetFeatureFlagsResultDto copy$default(GetFeatureFlagsResultDto getFeatureFlagsResultDto, GetFeatureFlagsResponseDto getFeatureFlagsResponseDto, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            getFeatureFlagsResponseDto = getFeatureFlagsResultDto.result;
        }
        return getFeatureFlagsResultDto.copy(getFeatureFlagsResponseDto);
    }

    public final GetFeatureFlagsResponseDto component1() {
        return this.result;
    }

    public final GetFeatureFlagsResultDto copy(GetFeatureFlagsResponseDto result) {
        m.g(result, "result");
        return new GetFeatureFlagsResultDto(result);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetFeatureFlagsResultDto) && m.c(this.result, ((GetFeatureFlagsResultDto) obj).result);
    }

    public final GetFeatureFlagsResponseDto getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    public String toString() {
        return "GetFeatureFlagsResultDto(result=" + this.result + ')';
    }
}