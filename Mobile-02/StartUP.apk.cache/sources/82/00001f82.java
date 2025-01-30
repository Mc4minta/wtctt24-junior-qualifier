package com.coinbase.wallet.features.send.dtos;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: SearchUsernamesDTO.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0007\u001a\u00020\u00002\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/features/send/dtos/SearchUsernamesDTO;", "", "", "", "component1", "()Ljava/util/List;", "usernames", "copy", "(Ljava/util/List;)Lcom/coinbase/wallet/features/send/dtos/SearchUsernamesDTO;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getUsernames", "<init>", "(Ljava/util/List;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class SearchUsernamesDTO {
    private final List<String> usernames;

    public SearchUsernamesDTO(List<String> usernames) {
        m.g(usernames, "usernames");
        this.usernames = usernames;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SearchUsernamesDTO copy$default(SearchUsernamesDTO searchUsernamesDTO, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = searchUsernamesDTO.usernames;
        }
        return searchUsernamesDTO.copy(list);
    }

    public final List<String> component1() {
        return this.usernames;
    }

    public final SearchUsernamesDTO copy(List<String> usernames) {
        m.g(usernames, "usernames");
        return new SearchUsernamesDTO(usernames);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof SearchUsernamesDTO) && m.c(this.usernames, ((SearchUsernamesDTO) obj).usernames);
    }

    public final List<String> getUsernames() {
        return this.usernames;
    }

    public int hashCode() {
        return this.usernames.hashCode();
    }

    public String toString() {
        return "SearchUsernamesDTO(usernames=" + this.usernames + ')';
    }
}