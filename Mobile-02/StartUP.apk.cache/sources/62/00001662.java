package com.coinbase.wallet.consumer.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.m;

/* compiled from: ConsumerAvailablePaymentMethod.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BS\b\u0000\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b:\u0010;BQ\b\u0016\u0012\u0006\u0010,\u001a\u00020+\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030<¢\u0006\u0004\b:\u0010>J\u0010\u0010\u0004\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\b\u0010\u0005J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\t\u0010\u0005J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0005J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJj\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0005J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b!\u0010\u001cJ \u0010&\u001a\u00020%2\u0006\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b&\u0010'R\u001c\u0010\u0010\u001a\u00020\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010(\u001a\u0004\b)\u0010\u0005R\u001c\u0010\u000f\u001a\u00020\u00038\u0016@\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b*\u0010\u0005R\"\u0010,\u001a\u00020+8\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b,\u0010-\u0012\u0004\b0\u00101\u001a\u0004\b.\u0010/R\u0013\u00102\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b2\u0010\u000eR\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010(\u001a\u0004\b3\u0010\u0005R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b4\u0010\u0005R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010(\u001a\u0004\b5\u0010\u0005R\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b6\u0010\u0005R\u001c\u0010\u0016\u001a\u00020\f8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u00107\u001a\u0004\b8\u0010\u000eR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b9\u0010\u0005¨\u0006?"}, d2 = {"Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "Landroid/os/Parcelable;", "Lcom/coinbase/wallet/libraries/databases/interfaces/DatabaseModelObject;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "component7", "", "component8", "()Z", "id", "typeString", ApiConstants.NAME, ApiConstants.DESCRIPTION, "additionalFees", "buyingPower", "buyTime", "supportsBuy", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/coinbase/wallet/consumer/models/ConsumerAvailablePaymentMethod;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getTypeString", "getId", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "type", "Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "getType", "()Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;", "getType$annotations", "()V", "isEnabled", "getBuyingPower", "getBuyTime", "getAdditionalFees", "getDescription", "Z", "getSupportsBuy", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "", "supports", "(Lcom/coinbase/wallet/consumer/models/ConsumerPaymentMethodType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "consumer_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethod implements Parcelable, DatabaseModelObject {
    public static final Parcelable.Creator<ConsumerAvailablePaymentMethod> CREATOR = new Creator();
    private final String additionalFees;
    private final String buyTime;
    private final String buyingPower;
    private final String description;
    private final String id;
    private final String name;
    private final boolean supportsBuy;
    private final ConsumerPaymentMethodType type;
    private final String typeString;

    /* compiled from: ConsumerAvailablePaymentMethod.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Creator implements Parcelable.Creator<ConsumerAvailablePaymentMethod> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerAvailablePaymentMethod createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new ConsumerAvailablePaymentMethod(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final ConsumerAvailablePaymentMethod[] newArray(int i2) {
            return new ConsumerAvailablePaymentMethod[i2];
        }
    }

    public ConsumerAvailablePaymentMethod(String id, String typeString, String str, String str2, String str3, String str4, String str5, boolean z) {
        m.g(id, "id");
        m.g(typeString, "typeString");
        this.id = id;
        this.typeString = typeString;
        this.name = str;
        this.description = str2;
        this.additionalFees = str3;
        this.buyingPower = str4;
        this.buyTime = str5;
        this.supportsBuy = z;
        this.type = ConsumerPaymentMethodType.Companion.fromValue(typeString);
    }

    public static /* synthetic */ void getType$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return this.typeString;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.additionalFees;
    }

    public final String component6() {
        return this.buyingPower;
    }

    public final String component7() {
        return this.buyTime;
    }

    public final boolean component8() {
        return this.supportsBuy;
    }

    public final ConsumerAvailablePaymentMethod copy(String id, String typeString, String str, String str2, String str3, String str4, String str5, boolean z) {
        m.g(id, "id");
        m.g(typeString, "typeString");
        return new ConsumerAvailablePaymentMethod(id, typeString, str, str2, str3, str4, str5, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConsumerAvailablePaymentMethod) {
            ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod = (ConsumerAvailablePaymentMethod) obj;
            return m.c(getId(), consumerAvailablePaymentMethod.getId()) && m.c(this.typeString, consumerAvailablePaymentMethod.typeString) && m.c(this.name, consumerAvailablePaymentMethod.name) && m.c(this.description, consumerAvailablePaymentMethod.description) && m.c(this.additionalFees, consumerAvailablePaymentMethod.additionalFees) && m.c(this.buyingPower, consumerAvailablePaymentMethod.buyingPower) && m.c(this.buyTime, consumerAvailablePaymentMethod.buyTime) && this.supportsBuy == consumerAvailablePaymentMethod.supportsBuy;
        }
        return false;
    }

    public final String getAdditionalFees() {
        return this.additionalFees;
    }

    public final String getBuyTime() {
        return this.buyTime;
    }

    public final String getBuyingPower() {
        return this.buyingPower;
    }

    public final String getDescription() {
        return this.description;
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseModelObject
    public String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getSupportsBuy() {
        return this.supportsBuy;
    }

    public final ConsumerPaymentMethodType getType() {
        return this.type;
    }

    public final String getTypeString() {
        return this.typeString;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((getId().hashCode() * 31) + this.typeString.hashCode()) * 31;
        String str = this.name;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.additionalFees;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.buyingPower;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.buyTime;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.supportsBuy;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode6 + i2;
    }

    public final boolean isEnabled() {
        ConsumerPaymentMethodType consumerPaymentMethodType;
        return this.supportsBuy && ((consumerPaymentMethodType = this.type) == ConsumerPaymentMethodType.WORLDPAY_CARD || consumerPaymentMethodType == ConsumerPaymentMethodType.SECURE3D_CARD);
    }

    public String toString() {
        return "ConsumerAvailablePaymentMethod(id=" + getId() + ", typeString=" + this.typeString + ", name=" + ((Object) this.name) + ", description=" + ((Object) this.description) + ", additionalFees=" + ((Object) this.additionalFees) + ", buyingPower=" + ((Object) this.buyingPower) + ", buyTime=" + ((Object) this.buyTime) + ", supportsBuy=" + this.supportsBuy + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeString(this.typeString);
        out.writeString(this.name);
        out.writeString(this.description);
        out.writeString(this.additionalFees);
        out.writeString(this.buyingPower);
        out.writeString(this.buyTime);
        out.writeInt(this.supportsBuy ? 1 : 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ConsumerAvailablePaymentMethod(ConsumerPaymentMethodType type, String str, String str2, String str3, String str4, String str5, List<String> supports) {
        this(type.name(), type.name(), str, str2, str3, str4, str5, supports.contains(ApiConstants.BUYS));
        m.g(type, "type");
        m.g(supports, "supports");
    }
}