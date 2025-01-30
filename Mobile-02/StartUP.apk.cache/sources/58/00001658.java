package com.coinbase.wallet.consumer.models;

import com.coinbase.ApiConstants;
import com.coinbase.wallet.commonui.utilities.PromptDialogHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAmountPickerEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\u0004\u0005\u0006\u0007\bB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0005\t\n\u000b\f\r¨\u0006\u000e"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "", "<init>", "()V", "ConsumerAmountPickerPrompt", "FetchMaxAmountError", "FetchNextActionError", "HideKeyboard", "KeyboardInputError", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$KeyboardInputError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$FetchMaxAmountError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$FetchNextActionError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$ConsumerAmountPickerPrompt;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$HideKeyboard;", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class ConsumerAmountPickerEvent {

    /* compiled from: ConsumerAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$ConsumerAmountPickerPrompt;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "component1", "()Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "properties", "copy", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$ConsumerAmountPickerPrompt;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;", "getProperties", "<init>", "(Lcom/coinbase/wallet/commonui/utilities/PromptDialogHelper$Properties;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class ConsumerAmountPickerPrompt extends ConsumerAmountPickerEvent {
        private final PromptDialogHelper.Properties properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConsumerAmountPickerPrompt(PromptDialogHelper.Properties properties) {
            super(null);
            m.g(properties, "properties");
            this.properties = properties;
        }

        public static /* synthetic */ ConsumerAmountPickerPrompt copy$default(ConsumerAmountPickerPrompt consumerAmountPickerPrompt, PromptDialogHelper.Properties properties, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                properties = consumerAmountPickerPrompt.properties;
            }
            return consumerAmountPickerPrompt.copy(properties);
        }

        public final PromptDialogHelper.Properties component1() {
            return this.properties;
        }

        public final ConsumerAmountPickerPrompt copy(PromptDialogHelper.Properties properties) {
            m.g(properties, "properties");
            return new ConsumerAmountPickerPrompt(properties);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ConsumerAmountPickerPrompt) && m.c(this.properties, ((ConsumerAmountPickerPrompt) obj).properties);
        }

        public final PromptDialogHelper.Properties getProperties() {
            return this.properties;
        }

        public int hashCode() {
            return this.properties.hashCode();
        }

        public String toString() {
            return "ConsumerAmountPickerPrompt(properties=" + this.properties + ')';
        }
    }

    /* compiled from: ConsumerAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$FetchMaxAmountError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class FetchMaxAmountError extends ConsumerAmountPickerEvent {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchMaxAmountError(String message) {
            super(null);
            m.g(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: ConsumerAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$FetchNextActionError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "", ApiConstants.MESSAGE, "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class FetchNextActionError extends ConsumerAmountPickerEvent {
        private final String message;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FetchNextActionError(String message) {
            super(null);
            m.g(message, "message");
            this.message = message;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    /* compiled from: ConsumerAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$HideKeyboard;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class HideKeyboard extends ConsumerAmountPickerEvent {
        public static final HideKeyboard INSTANCE = new HideKeyboard();

        private HideKeyboard() {
            super(null);
        }
    }

    /* compiled from: ConsumerAmountPickerEvent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent$KeyboardInputError;", "Lcom/coinbase/wallet/consumer/models/ConsumerAmountPickerEvent;", "<init>", "()V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class KeyboardInputError extends ConsumerAmountPickerEvent {
        public static final KeyboardInputError INSTANCE = new KeyboardInputError();

        private KeyboardInputError() {
            super(null);
        }
    }

    private ConsumerAmountPickerEvent() {
    }

    public /* synthetic */ ConsumerAmountPickerEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}