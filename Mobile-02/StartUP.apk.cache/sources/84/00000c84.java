package com.coinbase.android.apiv3.generated.authed.loans;

import android.os.Parcelable;
import com.coinbase.ApiConstants;
import com.coinbase.android.apiv3.generated.common.Amount;
import com.coinbase.android.apiv3.generated.resources.Account;
import com.coinbase.android.apiv3.generated.resources.Asset;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.a;
import com.squareup.wire.c;
import com.squareup.wire.g;
import com.squareup.wire.k;
import com.squareup.wire.l;
import com.squareup.wire.p;
import com.squareup.wire.q.b;
import j.i;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a0.r;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: GetEligibleAccountsForCollateralResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001/Bu\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\r\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001a\u001a\u00020\r\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b-\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ{\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00102\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010 \u001a\u0004\b!\u0010\"R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b#\u0010\"R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b%\u0010&R\u001c\u0010\u0018\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010'\u001a\u0004\b(\u0010\u000fR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010$\u001a\u0004\b)\u0010&R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010$\u001a\u0004\b*\u0010&R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b+\u0010&R\u001c\u0010\u001a\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010'\u001a\u0004\b,\u0010\u000f¨\u00060"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralResponse;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "", "Lcom/coinbase/android/apiv3/generated/resources/Account;", ApiConstants.ACCOUNTS, "Lcom/coinbase/android/apiv3/generated/resources/Asset;", "assets", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "outstanding_loan_amount", "existing_collateral", "health_ratio_required", "collateral_required", "health_ratio_recommended", "collateral_recommended", "Lj/i;", "unknownFields", "copy", "(Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralResponse;", "Ljava/util/List;", "getAssets", "()Ljava/util/List;", "getAccounts", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getExisting_collateral", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "Ljava/lang/String;", "getHealth_ratio_required", "getCollateral_recommended", "getOutstanding_loan_amount", "getCollateral_required", "getHealth_ratio_recommended", "<init>", "(Ljava/util/List;Ljava/util/List;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class GetEligibleAccountsForCollateralResponse extends a {
    public static final ProtoAdapter<GetEligibleAccountsForCollateralResponse> ADAPTER;
    public static final Parcelable.Creator<GetEligibleAccountsForCollateralResponse> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Account#ADAPTER", label = p.a.REPEATED, tag = 1)
    private final List<Account> accounts;
    @p(adapter = "com.coinbase.android.apiv3.generated.resources.Asset#ADAPTER", label = p.a.REPEATED, tag = 2)
    private final List<Asset> assets;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "collateralRecommended", tag = 8)
    private final Amount collateral_recommended;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "collateralRequired", tag = 6)
    private final Amount collateral_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "existingCollateral", tag = 4)
    private final Amount existing_collateral;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "healthRatioRecommended", tag = 7)
    private final String health_ratio_recommended;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "healthRatioRequired", tag = 5)
    private final String health_ratio_required;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "outstandingLoanAmount", tag = 3)
    private final Amount outstanding_loan_amount;

    /* compiled from: GetEligibleAccountsForCollateralResponse.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralResponse$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/loans/GetEligibleAccountsForCollateralResponse;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<GetEligibleAccountsForCollateralResponse> protoAdapter = new ProtoAdapter<GetEligibleAccountsForCollateralResponse>(c.LENGTH_DELIMITED, e0.b(GetEligibleAccountsForCollateralResponse.class), "type.googleapis.com/coinbase.public_api.authed.loans.GetEligibleAccountsForCollateralResponse") { // from class: com.coinbase.android.apiv3.generated.authed.loans.GetEligibleAccountsForCollateralResponse$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public GetEligibleAccountsForCollateralResponse decode(k reader) {
                m.h(reader, "reader");
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                long d2 = reader.d();
                Amount amount = null;
                String str = "";
                String str2 = str;
                Amount amount2 = null;
                Amount amount3 = null;
                Amount amount4 = null;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new GetEligibleAccountsForCollateralResponse(arrayList, arrayList2, amount2, amount, str, amount3, str2, amount4, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            arrayList.add(Account.ADAPTER.decode(reader));
                            break;
                        case 2:
                            arrayList2.add(Asset.ADAPTER.decode(reader));
                            break;
                        case 3:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        case 4:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 5:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            amount3 = Amount.ADAPTER.decode(reader);
                            break;
                        case 7:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            amount4 = Amount.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, GetEligibleAccountsForCollateralResponse value) {
                m.h(writer, "writer");
                m.h(value, "value");
                Account.ADAPTER.asRepeated().encodeWithTag(writer, 1, value.getAccounts());
                Asset.ADAPTER.asRepeated().encodeWithTag(writer, 2, value.getAssets());
                if (value.getOutstanding_loan_amount() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 3, value.getOutstanding_loan_amount());
                }
                if (value.getExisting_collateral() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 4, value.getExisting_collateral());
                }
                if (!m.c(value.getHealth_ratio_required(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getHealth_ratio_required());
                }
                if (value.getCollateral_required() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 6, value.getCollateral_required());
                }
                if (!m.c(value.getHealth_ratio_recommended(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getHealth_ratio_recommended());
                }
                if (value.getCollateral_recommended() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 8, value.getCollateral_recommended());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(GetEligibleAccountsForCollateralResponse value) {
                m.h(value, "value");
                int encodedSizeWithTag = Account.ADAPTER.asRepeated().encodedSizeWithTag(1, value.getAccounts()) + Asset.ADAPTER.asRepeated().encodedSizeWithTag(2, value.getAssets());
                if (value.getOutstanding_loan_amount() != null) {
                    ProtoAdapter<Amount> protoAdapter2 = Amount.ADAPTER;
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(3, value.getOutstanding_loan_amount());
                    if (value.getExisting_collateral() != null) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(4, value.getExisting_collateral());
                        if (!m.c(value.getHealth_ratio_required(), "")) {
                            ProtoAdapter<String> protoAdapter3 = ProtoAdapter.STRING;
                            int encodedSizeWithTag4 = protoAdapter3.encodedSizeWithTag(5, value.getHealth_ratio_required());
                            if (value.getCollateral_required() != null) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(6, value.getCollateral_required());
                                if (!m.c(value.getHealth_ratio_recommended(), "")) {
                                    r2 = (value.getCollateral_recommended() != null ? protoAdapter2.encodedSizeWithTag(8, value.getCollateral_recommended()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(7, value.getHealth_ratio_recommended());
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return encodedSizeWithTag + r2;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public GetEligibleAccountsForCollateralResponse redact(GetEligibleAccountsForCollateralResponse value) {
                m.h(value, "value");
                List a = b.a(value.getAccounts(), Account.ADAPTER);
                List a2 = b.a(value.getAssets(), Asset.ADAPTER);
                Amount outstanding_loan_amount = value.getOutstanding_loan_amount();
                Amount redact = outstanding_loan_amount != null ? Amount.ADAPTER.redact(outstanding_loan_amount) : null;
                Amount existing_collateral = value.getExisting_collateral();
                Amount redact2 = existing_collateral != null ? Amount.ADAPTER.redact(existing_collateral) : null;
                Amount collateral_required = value.getCollateral_required();
                Amount redact3 = collateral_required != null ? Amount.ADAPTER.redact(collateral_required) : null;
                Amount collateral_recommended = value.getCollateral_recommended();
                return GetEligibleAccountsForCollateralResponse.copy$default(value, a, a2, redact, redact2, null, redact3, null, collateral_recommended != null ? Amount.ADAPTER.redact(collateral_recommended) : null, i.a, 80, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public GetEligibleAccountsForCollateralResponse() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public /* synthetic */ GetEligibleAccountsForCollateralResponse(List list, List list2, Amount amount, Amount amount2, String str, Amount amount3, String str2, Amount amount4, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? r.g() : list, (i2 & 2) != 0 ? r.g() : list2, (i2 & 4) != 0 ? null : amount, (i2 & 8) != 0 ? null : amount2, (i2 & 16) != 0 ? "" : str, (i2 & 32) != 0 ? null : amount3, (i2 & 64) == 0 ? str2 : "", (i2 & 128) == 0 ? amount4 : null, (i2 & 256) != 0 ? i.a : iVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GetEligibleAccountsForCollateralResponse copy$default(GetEligibleAccountsForCollateralResponse getEligibleAccountsForCollateralResponse, List list, List list2, Amount amount, Amount amount2, String str, Amount amount3, String str2, Amount amount4, i iVar, int i2, Object obj) {
        return getEligibleAccountsForCollateralResponse.copy((i2 & 1) != 0 ? getEligibleAccountsForCollateralResponse.accounts : list, (i2 & 2) != 0 ? getEligibleAccountsForCollateralResponse.assets : list2, (i2 & 4) != 0 ? getEligibleAccountsForCollateralResponse.outstanding_loan_amount : amount, (i2 & 8) != 0 ? getEligibleAccountsForCollateralResponse.existing_collateral : amount2, (i2 & 16) != 0 ? getEligibleAccountsForCollateralResponse.health_ratio_required : str, (i2 & 32) != 0 ? getEligibleAccountsForCollateralResponse.collateral_required : amount3, (i2 & 64) != 0 ? getEligibleAccountsForCollateralResponse.health_ratio_recommended : str2, (i2 & 128) != 0 ? getEligibleAccountsForCollateralResponse.collateral_recommended : amount4, (i2 & 256) != 0 ? getEligibleAccountsForCollateralResponse.unknownFields() : iVar);
    }

    public final GetEligibleAccountsForCollateralResponse copy(List<Account> accounts, List<Asset> assets, Amount amount, Amount amount2, String health_ratio_required, Amount amount3, String health_ratio_recommended, Amount amount4, i unknownFields) {
        m.h(accounts, "accounts");
        m.h(assets, "assets");
        m.h(health_ratio_required, "health_ratio_required");
        m.h(health_ratio_recommended, "health_ratio_recommended");
        m.h(unknownFields, "unknownFields");
        return new GetEligibleAccountsForCollateralResponse(accounts, assets, amount, amount2, health_ratio_required, amount3, health_ratio_recommended, amount4, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GetEligibleAccountsForCollateralResponse) {
            GetEligibleAccountsForCollateralResponse getEligibleAccountsForCollateralResponse = (GetEligibleAccountsForCollateralResponse) obj;
            return m.c(unknownFields(), getEligibleAccountsForCollateralResponse.unknownFields()) && m.c(this.accounts, getEligibleAccountsForCollateralResponse.accounts) && m.c(this.assets, getEligibleAccountsForCollateralResponse.assets) && m.c(this.outstanding_loan_amount, getEligibleAccountsForCollateralResponse.outstanding_loan_amount) && m.c(this.existing_collateral, getEligibleAccountsForCollateralResponse.existing_collateral) && m.c(this.health_ratio_required, getEligibleAccountsForCollateralResponse.health_ratio_required) && m.c(this.collateral_required, getEligibleAccountsForCollateralResponse.collateral_required) && m.c(this.health_ratio_recommended, getEligibleAccountsForCollateralResponse.health_ratio_recommended) && m.c(this.collateral_recommended, getEligibleAccountsForCollateralResponse.collateral_recommended);
        }
        return false;
    }

    public final List<Account> getAccounts() {
        return this.accounts;
    }

    public final List<Asset> getAssets() {
        return this.assets;
    }

    public final Amount getCollateral_recommended() {
        return this.collateral_recommended;
    }

    public final Amount getCollateral_required() {
        return this.collateral_required;
    }

    public final Amount getExisting_collateral() {
        return this.existing_collateral;
    }

    public final String getHealth_ratio_recommended() {
        return this.health_ratio_recommended;
    }

    public final String getHealth_ratio_required() {
        return this.health_ratio_required;
    }

    public final Amount getOutstanding_loan_amount() {
        return this.outstanding_loan_amount;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((unknownFields().hashCode() * 37) + this.accounts.hashCode()) * 37) + this.assets.hashCode()) * 37;
            Amount amount = this.outstanding_loan_amount;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.existing_collateral;
            int hashCode3 = (((hashCode2 + (amount2 != null ? amount2.hashCode() : 0)) * 37) + this.health_ratio_required.hashCode()) * 37;
            Amount amount3 = this.collateral_required;
            int hashCode4 = (((hashCode3 + (amount3 != null ? amount3.hashCode() : 0)) * 37) + this.health_ratio_recommended.hashCode()) * 37;
            Amount amount4 = this.collateral_recommended;
            int hashCode5 = hashCode4 + (amount4 != null ? amount4.hashCode() : 0);
            this.hashCode = hashCode5;
            return hashCode5;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m357newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        if (!this.accounts.isEmpty()) {
            arrayList.add("accounts=" + this.accounts);
        }
        if (!this.assets.isEmpty()) {
            arrayList.add("assets=" + this.assets);
        }
        if (this.outstanding_loan_amount != null) {
            arrayList.add("outstanding_loan_amount=" + this.outstanding_loan_amount);
        }
        if (this.existing_collateral != null) {
            arrayList.add("existing_collateral=" + this.existing_collateral);
        }
        arrayList.add("health_ratio_required=" + b.c(this.health_ratio_required));
        if (this.collateral_required != null) {
            arrayList.add("collateral_required=" + this.collateral_required);
        }
        arrayList.add("health_ratio_recommended=" + b.c(this.health_ratio_recommended));
        if (this.collateral_recommended != null) {
            arrayList.add("collateral_recommended=" + this.collateral_recommended);
        }
        h0 = z.h0(arrayList, ", ", "GetEligibleAccountsForCollateralResponse{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m357newBuilder() {
        throw new AssertionError();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GetEligibleAccountsForCollateralResponse(List<Account> accounts, List<Asset> assets, Amount amount, Amount amount2, String health_ratio_required, Amount amount3, String health_ratio_recommended, Amount amount4, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(accounts, "accounts");
        m.h(assets, "assets");
        m.h(health_ratio_required, "health_ratio_required");
        m.h(health_ratio_recommended, "health_ratio_recommended");
        m.h(unknownFields, "unknownFields");
        this.accounts = accounts;
        this.assets = assets;
        this.outstanding_loan_amount = amount;
        this.existing_collateral = amount2;
        this.health_ratio_required = health_ratio_required;
        this.collateral_required = amount3;
        this.health_ratio_recommended = health_ratio_recommended;
        this.collateral_recommended = amount4;
    }
}