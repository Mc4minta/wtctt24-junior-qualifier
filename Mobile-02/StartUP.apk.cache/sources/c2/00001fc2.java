package com.coinbase.wallet.features.send.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.apache.http.HttpHeaders;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: SendDestinationPickerRow.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "", "<init>", "()V", HttpHeaders.DESTINATION, "Spinner", "Title", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Destination;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Spinner;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Title;", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class SendDestinationPickerRow {

    /* compiled from: SendDestinationPickerRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Destination;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "destination", "Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "getDestination", "()Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;", "<init>", "(Lcom/coinbase/wallet/features/send/models/SendDestinationViewInfo;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Destination extends SendDestinationPickerRow {
        private final SendDestinationViewInfo destination;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Destination(SendDestinationViewInfo destination) {
            super(null);
            m.g(destination, "destination");
            this.destination = destination;
        }

        public final SendDestinationViewInfo getDestination() {
            return this.destination;
        }
    }

    /* compiled from: SendDestinationPickerRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Spinner;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Spinner extends SendDestinationPickerRow {
        public static final Spinner INSTANCE = new Spinner();

        private Spinner() {
            super(null);
        }
    }

    /* compiled from: SendDestinationPickerRow.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow$Title;", "Lcom/coinbase/wallet/features/send/models/SendDestinationPickerRow;", "", MessageBundle.TITLE_ENTRY, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Title extends SendDestinationPickerRow {
        private final String title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Title(String title) {
            super(null);
            m.g(title, "title");
            this.title = title;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    private SendDestinationPickerRow() {
    }

    public /* synthetic */ SendDestinationPickerRow(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}