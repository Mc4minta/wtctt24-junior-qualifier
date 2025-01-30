package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.core.extensions.Strings_CoreKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: ConsumerTransferMethodsState.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ4\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0019\u0010\f\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\u0017\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "", "", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodItem;", "component1", "()Ljava/util/List;", "", "component2", "()Ljava/lang/String;", "component3", "transferMethodOptions", MessageBundle.TITLE_ENTRY, ApiConstants.DESCRIPTION, "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsState;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "Ljava/util/List;", "getTransferMethodOptions", "getDescription", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsState {
    private final String description;
    private final String title;
    private final List<ConsumerTransferMethodItem> transferMethodOptions;

    public ConsumerTransferMethodsState() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConsumerTransferMethodsState(List<? extends ConsumerTransferMethodItem> transferMethodOptions, String title, String description) {
        m.g(transferMethodOptions, "transferMethodOptions");
        m.g(title, "title");
        m.g(description, "description");
        this.transferMethodOptions = transferMethodOptions;
        this.title = title;
        this.description = description;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ConsumerTransferMethodsState copy$default(ConsumerTransferMethodsState consumerTransferMethodsState, List list, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = consumerTransferMethodsState.transferMethodOptions;
        }
        if ((i2 & 2) != 0) {
            str = consumerTransferMethodsState.title;
        }
        if ((i2 & 4) != 0) {
            str2 = consumerTransferMethodsState.description;
        }
        return consumerTransferMethodsState.copy(list, str, str2);
    }

    public final List<ConsumerTransferMethodItem> component1() {
        return this.transferMethodOptions;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.description;
    }

    public final ConsumerTransferMethodsState copy(List<? extends ConsumerTransferMethodItem> transferMethodOptions, String title, String description) {
        m.g(transferMethodOptions, "transferMethodOptions");
        m.g(title, "title");
        m.g(description, "description");
        return new ConsumerTransferMethodsState(transferMethodOptions, title, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerTransferMethodsState) {
            ConsumerTransferMethodsState consumerTransferMethodsState = (ConsumerTransferMethodsState) obj;
            return m.c(this.transferMethodOptions, consumerTransferMethodsState.transferMethodOptions) && m.c(this.title, consumerTransferMethodsState.title) && m.c(this.description, consumerTransferMethodsState.description);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getTitle() {
        return this.title;
    }

    public final List<ConsumerTransferMethodItem> getTransferMethodOptions() {
        return this.transferMethodOptions;
    }

    public int hashCode() {
        return (((this.transferMethodOptions.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        return "ConsumerTransferMethodsState(transferMethodOptions=" + this.transferMethodOptions + ", title=" + this.title + ", description=" + this.description + ')';
    }

    public /* synthetic */ ConsumerTransferMethodsState(List list, String str, String str2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str, (i2 & 4) != 0 ? Strings_CoreKt.getEmpty(Strings.INSTANCE) : str2);
    }
}