package com.coinbase.wallet.application.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.toshi.R;

/* compiled from: MainTab.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0087\u0001\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0013B\u0019\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u0005R\u0019\u0010\u000f\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\r\u001a\u0004\b\u0010\u0010\u0005j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/application/model/MainTab;", "", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "position", "I", "getPosition", "selectedItemId", "getSelectedItemId", "<init>", "(Ljava/lang/String;III)V", "Companion", "WALLET", "DAPPS", "SETTINGS", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public enum MainTab implements Parcelable {
    WALLET(0, R.id.action_wallet),
    DAPPS(1, R.id.action_dapps),
    SETTINGS(2, R.id.action_settings);
    
    private final int position;
    private final int selectedItemId;
    public static final Companion Companion = new Companion(null);
    public static final Parcelable.Creator<MainTab> CREATOR = new Parcelable.Creator<MainTab>() { // from class: com.coinbase.wallet.application.model.MainTab.Creator
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MainTab createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return MainTab.valueOf(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MainTab[] newArray(int i2) {
            return new MainTab[i2];
        }
    };

    /* compiled from: MainTab.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/application/model/MainTab$Companion;", "", "", "position", "Lcom/coinbase/wallet/application/model/MainTab;", "fromPosition", "(I)Lcom/coinbase/wallet/application/model/MainTab;", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MainTab fromPosition(int i2) {
            MainTab[] values;
            for (MainTab mainTab : MainTab.values()) {
                if (mainTab.getPosition() == i2) {
                    return mainTab;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
    }

    MainTab(int i2, int i3) {
        this.position = i2;
        this.selectedItemId = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getSelectedItemId() {
        return this.selectedItemId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(name());
    }
}