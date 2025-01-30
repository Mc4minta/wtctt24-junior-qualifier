package com.coinbase.wallet.ethereum.models;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: ContractAction.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0087\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\r\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ContractAction;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "rawValue", "Ljava/lang/String;", "getRawValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "SUPPLY", "WITHDRAW", "ethereum_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum ContractAction implements Parcelable {
    SUPPLY("supply"),
    WITHDRAW("withdraw");
    
    private final String rawValue;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<ContractAction> CREATOR = new Parcelable.Creator<ContractAction>() { // from class: com.coinbase.wallet.ethereum.models.ContractAction.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContractAction createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return ContractAction.valueOf(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ContractAction[] newArray(int i2) {
            return new ContractAction[i2];
        }
    };

    /* compiled from: ContractAction.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/ethereum/models/ContractAction$Companion;", "", "", "rawValue", "Lcom/coinbase/wallet/ethereum/models/ContractAction;", "fromValue", "(Ljava/lang/String;)Lcom/coinbase/wallet/ethereum/models/ContractAction;", "<init>", "()V", "ethereum_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ContractAction fromValue(String rawValue) {
            ContractAction[] values;
            m.g(rawValue, "rawValue");
            for (ContractAction contractAction : ContractAction.values()) {
                if (m.c(contractAction.getRawValue(), rawValue)) {
                    return contractAction;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    ContractAction(String str) {
        this.rawValue = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getRawValue() {
        return this.rawValue;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(name());
    }
}