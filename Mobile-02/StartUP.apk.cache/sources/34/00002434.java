package com.coinbase.wallet.lending.dtos;

import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: LendProviderDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/coinbase/wallet/lending/dtos/ProviderDTO;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "websiteURL", "getWebsiteURL", "imageURL", "getImageURL", ApiConstants.NAME, "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ProviderDTO {
    private final String id;
    private final String imageURL;
    private final String name;
    private final String websiteURL;

    public ProviderDTO(String id, String name, String websiteURL, String imageURL) {
        m.g(id, "id");
        m.g(name, "name");
        m.g(websiteURL, "websiteURL");
        m.g(imageURL, "imageURL");
        this.id = id;
        this.name = name;
        this.websiteURL = websiteURL;
        this.imageURL = imageURL;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWebsiteURL() {
        return this.websiteURL;
    }
}