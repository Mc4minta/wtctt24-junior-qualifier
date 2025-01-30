package com.coinbase.wallet.consumer.models;

import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerTransferMethodsEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsPrompt;", "Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsEvent;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "component1", "()Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "properties", "copy", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)Lcom/coinbase/wallet/consumer/models/ConsumerTransferMethodsPrompt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "getProperties", "<init>", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerTransferMethodsPrompt extends ConsumerTransferMethodsEvent {
    private final PromptDialogHelper.Properties properties;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsumerTransferMethodsPrompt(PromptDialogHelper.Properties properties) {
        super(null);
        m.g(properties, "properties");
        this.properties = properties;
    }

    public static /* synthetic */ ConsumerTransferMethodsPrompt copy$default(ConsumerTransferMethodsPrompt consumerTransferMethodsPrompt, PromptDialogHelper.Properties properties, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            properties = consumerTransferMethodsPrompt.properties;
        }
        return consumerTransferMethodsPrompt.copy(properties);
    }

    public final PromptDialogHelper.Properties component1() {
        return this.properties;
    }

    public final ConsumerTransferMethodsPrompt copy(PromptDialogHelper.Properties properties) {
        m.g(properties, "properties");
        return new ConsumerTransferMethodsPrompt(properties);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsumerTransferMethodsPrompt) && m.c(this.properties, ((ConsumerTransferMethodsPrompt) obj).properties);
    }

    public final PromptDialogHelper.Properties getProperties() {
        return this.properties;
    }

    public int hashCode() {
        return this.properties.hashCode();
    }

    public String toString() {
        return "ConsumerTransferMethodsPrompt(properties=" + this.properties + ')';
    }
}