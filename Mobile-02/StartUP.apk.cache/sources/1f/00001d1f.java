package com.coinbase.wallet.featureflags.dtos;

import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: GetFeatureFlagsResponseDto.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\b\u001a\u00020\u00002\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R%\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;", "", "", "", "", "component1", "()Ljava/util/Map;", "android", "copy", "(Ljava/util/Map;)Lcom/coinbase/wallet/featureflags/dtos/GetFeatureFlagsResponseDto;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Map;", "getAndroid", "<init>", "(Ljava/util/Map;)V", "featureflags_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class GetFeatureFlagsResponseDto {

    /* renamed from: android  reason: collision with root package name */
    private final Map<String, Boolean> f4147android;

    public GetFeatureFlagsResponseDto(Map<String, Boolean> android2) {
        m.g(android2, "android");
        this.f4147android = android2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetFeatureFlagsResponseDto copy$default(GetFeatureFlagsResponseDto getFeatureFlagsResponseDto, Map map, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            map = getFeatureFlagsResponseDto.f4147android;
        }
        return getFeatureFlagsResponseDto.copy(map);
    }

    public final Map<String, Boolean> component1() {
        return this.f4147android;
    }

    public final GetFeatureFlagsResponseDto copy(Map<String, Boolean> android2) {
        m.g(android2, "android");
        return new GetFeatureFlagsResponseDto(android2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GetFeatureFlagsResponseDto) && m.c(this.f4147android, ((GetFeatureFlagsResponseDto) obj).f4147android);
    }

    public final Map<String, Boolean> getAndroid() {
        return this.f4147android;
    }

    public int hashCode() {
        return this.f4147android.hashCode();
    }

    public String toString() {
        return "GetFeatureFlagsResponseDto(android=" + this.f4147android + ')';
    }
}