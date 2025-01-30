package com.coinbase.wallet.lending.models;

import com.coinbase.ApiConstants;
import java.net.URL;
import kotlin.Metadata;
import kotlin.h;
import kotlin.jvm.internal.m;
import kotlin.k;

/* compiled from: LendProvider.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u0019\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001f\u0010\u0016\u001a\u0004\u0018\u00010\u00028F@\u0006X\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0006¨\u0006\u0019"}, d2 = {"Lcom/coinbase/wallet/lending/models/LendProvider;", "", "", ApiConstants.NAME, "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "Ljava/net/URL;", "imageURL", "Ljava/net/URL;", "getImageURL", "()Ljava/net/URL;", "websiteURL", "getWebsiteURL", "Lcom/coinbase/wallet/lending/models/LendProviderID;", "id", "Lcom/coinbase/wallet/lending/models/LendProviderID;", "getId", "()Lcom/coinbase/wallet/lending/models/LendProviderID;", "websiteHost$delegate", "Lkotlin/h;", "getWebsiteHost", "websiteHost", "<init>", "(Lcom/coinbase/wallet/lending/models/LendProviderID;Ljava/lang/String;Ljava/net/URL;Ljava/net/URL;)V", "lending_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class LendProvider {
    private final LendProviderID id;
    private final URL imageURL;
    private final String name;
    private final h websiteHost$delegate;
    private final URL websiteURL;

    public LendProvider(LendProviderID id, String name, URL websiteURL, URL imageURL) {
        h b2;
        m.g(id, "id");
        m.g(name, "name");
        m.g(websiteURL, "websiteURL");
        m.g(imageURL, "imageURL");
        this.id = id;
        this.name = name;
        this.websiteURL = websiteURL;
        this.imageURL = imageURL;
        b2 = k.b(new LendProvider$websiteHost$2(this));
        this.websiteHost$delegate = b2;
    }

    public final LendProviderID getId() {
        return this.id;
    }

    public final URL getImageURL() {
        return this.imageURL;
    }

    public final String getName() {
        return this.name;
    }

    public final String getWebsiteHost() {
        return (String) this.websiteHost$delegate.getValue();
    }

    public final URL getWebsiteURL() {
        return this.websiteURL;
    }
}