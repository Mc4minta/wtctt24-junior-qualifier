package com.toshi.model.local.room;

import android.os.Parcel;
import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.squareup.moshi.JsonClass;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;
import org.spongycastle.i18n.MessageBundle;

/* compiled from: Prompt.kt */
@JsonClass(generateAdapter = true)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001:\u00017Be\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t\u0012\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b5\u00106J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0018\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJp\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00052\b\b\u0003\u0010\u0013\u001a\u00020\u00052\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t2\n\b\u0003\u0010\u0015\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0016\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0004J\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010\u0007J \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b'\u0010(R\u001b\u0010\u0015\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010\rR\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b,\u0010\u0007R!\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010-\u001a\u0004\b.\u0010\u000bR\u0019\u0010\u0013\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b/\u0010\u0007R\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010)\u001a\u0004\b0\u0010\rR\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010)\u001a\u0004\b1\u0010\rR\u0019\u0010\u0011\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u00102\u001a\u0004\b3\u0010\u0004R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010)\u001a\u0004\b4\u0010\r¨\u00068"}, d2 = {"Lcom/toshi/model/local/room/Prompt;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "", "component2", "()I", "component3", "", "component4", "()[Ljava/lang/String;", "component5", "()Ljava/lang/Integer;", "component6", "component7", "component8", "id", MessageBundle.TITLE_ENTRY, ApiConstants.MESSAGE, "formatArgs", "imageResource", "firstButtonId", "secondButtonId", "thirdButtonId", "copy", "(Ljava/lang/String;II[Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/toshi/model/local/room/Prompt;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "Lkotlin/x;", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/Integer;", "getImageResource", "I", "getTitle", "[Ljava/lang/String;", "getFormatArgs", "getMessage", "getSecondButtonId", "getThirdButtonId", "Ljava/lang/String;", "getId", "getFirstButtonId", "<init>", "(Ljava/lang/String;II[Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Id", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class Prompt implements Parcelable {
    public static final Parcelable.Creator<Prompt> CREATOR = new Creator();
    private final Integer firstButtonId;
    private final String[] formatArgs;
    private final String id;
    private final Integer imageResource;
    private final int message;
    private final Integer secondButtonId;
    private final Integer thirdButtonId;
    private final int title;

    /* compiled from: Prompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Prompt> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Prompt createFromParcel(Parcel parcel) {
            m.g(parcel, "parcel");
            return new Prompt(parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.createStringArray(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Prompt[] newArray(int i2) {
            return new Prompt[i2];
        }
    }

    /* compiled from: Prompt.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/toshi/model/local/room/Prompt$Id;", "", "", "BCH_CASHADDR_LEGACY_ADDRESS", "Ljava/lang/String;", "BTC_SEGWIT_LEGACY_ADDRESS", "BCH_REPLAY_WARNING", "LEND_MIN_COLLATERAL_INFO", "LTC_SEGWIT_LEGACY_ADDRESS", "LEND_ASSETS_UNDER_CUSTODY_INFO", "XLM_RECEIVE_MINIMUM_BALANCE_WARNING", "XRP_RECEIVE_MINIMUM_BALANCE_WARNING", "LEND_UTILIZATION_INFO", "ERC20_ADDRESS_INFO", "<init>", "()V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes2.dex */
    public static final class Id {
        public static final String BCH_CASHADDR_LEGACY_ADDRESS = "bch_cashaddr_legacy_address_info_prompt";
        public static final String BCH_REPLAY_WARNING = "bch_replay_warning_info_prompt";
        public static final String BTC_SEGWIT_LEGACY_ADDRESS = "btc_segwit_legacy_address_info_prompt";
        public static final String ERC20_ADDRESS_INFO = "erc20_address_info_prompt";
        public static final Id INSTANCE = new Id();
        public static final String LEND_ASSETS_UNDER_CUSTODY_INFO = "lend_assets_under_custody_info_prompt";
        public static final String LEND_MIN_COLLATERAL_INFO = "lend_min_collateral_info_prompt";
        public static final String LEND_UTILIZATION_INFO = "lend_utilization_info_prompt";
        public static final String LTC_SEGWIT_LEGACY_ADDRESS = "ltc_segwit_legacy_address_info_prompt";
        public static final String XLM_RECEIVE_MINIMUM_BALANCE_WARNING = "xlm_receive_minimum_balance_warning";
        public static final String XRP_RECEIVE_MINIMUM_BALANCE_WARNING = "xrp_receive_minimum_balance_warning";

        private Id() {
        }
    }

    public Prompt(String id, int i2, int i3, String[] strArr, Integer num, Integer num2, Integer num3, Integer num4) {
        m.g(id, "id");
        this.id = id;
        this.title = i2;
        this.message = i3;
        this.formatArgs = strArr;
        this.imageResource = num;
        this.firstButtonId = num2;
        this.secondButtonId = num3;
        this.thirdButtonId = num4;
    }

    public final String component1() {
        return this.id;
    }

    public final int component2() {
        return this.title;
    }

    public final int component3() {
        return this.message;
    }

    public final String[] component4() {
        return this.formatArgs;
    }

    public final Integer component5() {
        return this.imageResource;
    }

    public final Integer component6() {
        return this.firstButtonId;
    }

    public final Integer component7() {
        return this.secondButtonId;
    }

    public final Integer component8() {
        return this.thirdButtonId;
    }

    public final Prompt copy(String id, int i2, int i3, String[] strArr, Integer num, Integer num2, Integer num3, Integer num4) {
        m.g(id, "id");
        return new Prompt(id, i2, i3, strArr, num, num2, num3, num4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Prompt) {
            Prompt prompt = (Prompt) obj;
            return m.c(this.id, prompt.id) && this.title == prompt.title && this.message == prompt.message && m.c(this.formatArgs, prompt.formatArgs) && m.c(this.imageResource, prompt.imageResource) && m.c(this.firstButtonId, prompt.firstButtonId) && m.c(this.secondButtonId, prompt.secondButtonId) && m.c(this.thirdButtonId, prompt.thirdButtonId);
        }
        return false;
    }

    public final Integer getFirstButtonId() {
        return this.firstButtonId;
    }

    public final String[] getFormatArgs() {
        return this.formatArgs;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getImageResource() {
        return this.imageResource;
    }

    public final int getMessage() {
        return this.message;
    }

    public final Integer getSecondButtonId() {
        return this.secondButtonId;
    }

    public final Integer getThirdButtonId() {
        return this.thirdButtonId;
    }

    public final int getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.title) * 31) + this.message) * 31;
        String[] strArr = this.formatArgs;
        int hashCode2 = (hashCode + (strArr == null ? 0 : Arrays.hashCode(strArr))) * 31;
        Integer num = this.imageResource;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.firstButtonId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.secondButtonId;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.thirdButtonId;
        return hashCode5 + (num4 != null ? num4.hashCode() : 0);
    }

    public String toString() {
        return "Prompt(id=" + this.id + ", title=" + this.title + ", message=" + this.message + ", formatArgs=" + Arrays.toString(this.formatArgs) + ", imageResource=" + this.imageResource + ", firstButtonId=" + this.firstButtonId + ", secondButtonId=" + this.secondButtonId + ", thirdButtonId=" + this.thirdButtonId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel out, int i2) {
        m.g(out, "out");
        out.writeString(this.id);
        out.writeInt(this.title);
        out.writeInt(this.message);
        out.writeStringArray(this.formatArgs);
        Integer num = this.imageResource;
        if (num == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num.intValue());
        }
        Integer num2 = this.firstButtonId;
        if (num2 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num2.intValue());
        }
        Integer num3 = this.secondButtonId;
        if (num3 == null) {
            out.writeInt(0);
        } else {
            out.writeInt(1);
            out.writeInt(num3.intValue());
        }
        Integer num4 = this.thirdButtonId;
        if (num4 == null) {
            out.writeInt(0);
            return;
        }
        out.writeInt(1);
        out.writeInt(num4.intValue());
    }

    public /* synthetic */ Prompt(String str, int i2, int i3, String[] strArr, Integer num, Integer num2, Integer num3, Integer num4, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i2, i3, (i4 & 8) != 0 ? null : strArr, (i4 & 16) != 0 ? null : num, (i4 & 32) != 0 ? null : num2, (i4 & 64) != 0 ? null : num3, (i4 & 128) != 0 ? null : num4);
    }
}