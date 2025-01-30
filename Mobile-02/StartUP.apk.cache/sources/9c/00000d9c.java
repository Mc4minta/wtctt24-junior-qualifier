package com.coinbase.android.apiv3.generated.authed.new_user_experience;

import android.os.Parcelable;
import com.coinbase.android.apiv3.generated.common.Amount;
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
import kotlin.Metadata;
import kotlin.a0.z;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.e0;
import kotlin.jvm.internal.m;

/* compiled from: SimplifiedBuyReferralMetadata.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 ,2\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,Bo\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\b\b\u0002\u0010\u0011\u001a\u00020\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\r\u0012\b\b\u0002\u0010\u0013\u001a\u00020\r\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\b\u0002\u0010\u0015\u001a\u00020\r\u0012\b\b\u0002\u0010\u0016\u001a\u00020\r\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0003\u001a\u00020\u0002H\u0017¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJu\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u0012\u001a\u00020\r2\b\b\u0002\u0010\u0013\u001a\u00020\r2\b\b\u0002\u0010\u0014\u001a\u00020\r2\b\b\u0002\u0010\u0015\u001a\u00020\r2\b\b\u0002\u0010\u0016\u001a\u00020\r2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0013\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b \u0010\u000fR\u001c\u0010\u0014\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u001e\u001a\u0004\b!\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0016\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u001e\u001a\u0004\b%\u0010\u000fR\u001c\u0010\u0015\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b&\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b'\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\r8\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b(\u0010\u000fR\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b)\u0010$¨\u0006-"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "Lcom/squareup/wire/a;", "", "newBuilder", "()Ljava/lang/Void;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "buy_screen_text", "buy_screen_continue_text", "drop_off_title", "drop_off_body", "reward_amount", "reward_amount_fiat_currency", "reward_amount_crypto_currency", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "reward_amount_and_currency", "threshold_amount_and_currency", "Lj/i;", "unknownFields", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "Ljava/lang/String;", "getDrop_off_body", "getDrop_off_title", "getReward_amount", "Lcom/coinbase/android/apiv3/generated/common/Amount;", "getThreshold_amount_and_currency", "()Lcom/coinbase/android/apiv3/generated/common/Amount;", "getReward_amount_crypto_currency", "getReward_amount_fiat_currency", "getBuy_screen_continue_text", "getBuy_screen_text", "getReward_amount_and_currency", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/coinbase/android/apiv3/generated/common/Amount;Lcom/coinbase/android/apiv3/generated/common/Amount;Lj/i;)V", "Companion", "apiv3"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class SimplifiedBuyReferralMetadata extends a {
    public static final ProtoAdapter<SimplifiedBuyReferralMetadata> ADAPTER;
    public static final Parcelable.Creator<SimplifiedBuyReferralMetadata> CREATOR;
    public static final Companion Companion = new Companion(null);
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "buyScreenContinueText", tag = 2)
    private final String buy_screen_continue_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "buyScreenText", tag = 1)
    private final String buy_screen_text;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "dropOffBody", tag = 4)
    private final String drop_off_body;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "dropOffTitle", tag = 3)
    private final String drop_off_title;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "rewardAmount", tag = 5)
    private final String reward_amount;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "rewardAmountAndCurrency", tag = 8)
    private final Amount reward_amount_and_currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "rewardAmountCryptoCurrency", tag = 7)
    private final String reward_amount_crypto_currency;
    @p(adapter = "com.squareup.wire.ProtoAdapter#STRING", jsonName = "rewardAmountFiatCurrency", tag = 6)
    private final String reward_amount_fiat_currency;
    @p(adapter = "com.coinbase.android.apiv3.generated.common.Amount#ADAPTER", jsonName = "thresholdAmountAndCurrency", tag = 9)
    private final Amount threshold_amount_and_currency;

    /* compiled from: SimplifiedBuyReferralMetadata.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata$Companion;", "", "Lcom/squareup/wire/ProtoAdapter;", "Lcom/coinbase/android/apiv3/generated/authed/new_user_experience/SimplifiedBuyReferralMetadata;", "ADAPTER", "Lcom/squareup/wire/ProtoAdapter;", "Landroid/os/Parcelable$Creator;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "apiv3"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        ProtoAdapter<SimplifiedBuyReferralMetadata> protoAdapter = new ProtoAdapter<SimplifiedBuyReferralMetadata>(c.LENGTH_DELIMITED, e0.b(SimplifiedBuyReferralMetadata.class), "type.googleapis.com/coinbase.public_api.authed.new_user_experience.SimplifiedBuyReferralMetadata") { // from class: com.coinbase.android.apiv3.generated.authed.new_user_experience.SimplifiedBuyReferralMetadata$Companion$ADAPTER$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public SimplifiedBuyReferralMetadata decode(k reader) {
                m.h(reader, "reader");
                long d2 = reader.d();
                Amount amount = null;
                Amount amount2 = null;
                String str = "";
                String str2 = str;
                String str3 = str2;
                String str4 = str3;
                String str5 = str4;
                String str6 = str5;
                String str7 = str6;
                while (true) {
                    int g2 = reader.g();
                    if (g2 == -1) {
                        return new SimplifiedBuyReferralMetadata(str, str2, str3, str4, str5, str6, str7, amount, amount2, reader.e(d2));
                    }
                    switch (g2) {
                        case 1:
                            str = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 2:
                            str2 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 3:
                            str3 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 4:
                            str4 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 5:
                            str5 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 6:
                            str6 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 7:
                            str7 = ProtoAdapter.STRING.decode(reader);
                            break;
                        case 8:
                            amount = Amount.ADAPTER.decode(reader);
                            break;
                        case 9:
                            amount2 = Amount.ADAPTER.decode(reader);
                            break;
                        default:
                            reader.m(g2);
                            break;
                    }
                }
            }

            @Override // com.squareup.wire.ProtoAdapter
            public void encode(l writer, SimplifiedBuyReferralMetadata value) {
                m.h(writer, "writer");
                m.h(value, "value");
                if (!m.c(value.getBuy_screen_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 1, value.getBuy_screen_text());
                }
                if (!m.c(value.getBuy_screen_continue_text(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 2, value.getBuy_screen_continue_text());
                }
                if (!m.c(value.getDrop_off_title(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 3, value.getDrop_off_title());
                }
                if (!m.c(value.getDrop_off_body(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 4, value.getDrop_off_body());
                }
                if (!m.c(value.getReward_amount(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 5, value.getReward_amount());
                }
                if (!m.c(value.getReward_amount_fiat_currency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 6, value.getReward_amount_fiat_currency());
                }
                if (!m.c(value.getReward_amount_crypto_currency(), "")) {
                    ProtoAdapter.STRING.encodeWithTag(writer, 7, value.getReward_amount_crypto_currency());
                }
                if (value.getReward_amount_and_currency() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 8, value.getReward_amount_and_currency());
                }
                if (value.getThreshold_amount_and_currency() != null) {
                    Amount.ADAPTER.encodeWithTag(writer, 9, value.getThreshold_amount_and_currency());
                }
                writer.a(value.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public int encodedSize(SimplifiedBuyReferralMetadata value) {
                m.h(value, "value");
                if (m.c(value.getBuy_screen_text(), "")) {
                    return 0;
                }
                ProtoAdapter<String> protoAdapter2 = ProtoAdapter.STRING;
                int encodedSizeWithTag = protoAdapter2.encodedSizeWithTag(1, value.getBuy_screen_text());
                if (!m.c(value.getBuy_screen_continue_text(), "")) {
                    int encodedSizeWithTag2 = protoAdapter2.encodedSizeWithTag(2, value.getBuy_screen_continue_text());
                    if (!m.c(value.getDrop_off_title(), "")) {
                        int encodedSizeWithTag3 = protoAdapter2.encodedSizeWithTag(3, value.getDrop_off_title());
                        if (!m.c(value.getDrop_off_body(), "")) {
                            int encodedSizeWithTag4 = protoAdapter2.encodedSizeWithTag(4, value.getDrop_off_body());
                            if (!m.c(value.getReward_amount(), "")) {
                                int encodedSizeWithTag5 = protoAdapter2.encodedSizeWithTag(5, value.getReward_amount());
                                if (!m.c(value.getReward_amount_fiat_currency(), "")) {
                                    int encodedSizeWithTag6 = protoAdapter2.encodedSizeWithTag(6, value.getReward_amount_fiat_currency());
                                    if (!m.c(value.getReward_amount_crypto_currency(), "")) {
                                        int encodedSizeWithTag7 = protoAdapter2.encodedSizeWithTag(7, value.getReward_amount_crypto_currency());
                                        if (value.getReward_amount_and_currency() != null) {
                                            ProtoAdapter<Amount> protoAdapter3 = Amount.ADAPTER;
                                            r2 = (value.getThreshold_amount_and_currency() != null ? protoAdapter3.encodedSizeWithTag(9, value.getThreshold_amount_and_currency()) + value.unknownFields().Q() : 0) + protoAdapter3.encodedSizeWithTag(8, value.getReward_amount_and_currency());
                                        }
                                        r2 += encodedSizeWithTag7;
                                    }
                                    r2 += encodedSizeWithTag6;
                                }
                                r2 += encodedSizeWithTag5;
                            }
                            r2 += encodedSizeWithTag4;
                        }
                        r2 += encodedSizeWithTag3;
                    }
                    r2 += encodedSizeWithTag2;
                }
                return r2 + encodedSizeWithTag;
            }

            @Override // com.squareup.wire.ProtoAdapter
            public SimplifiedBuyReferralMetadata redact(SimplifiedBuyReferralMetadata value) {
                m.h(value, "value");
                Amount reward_amount_and_currency = value.getReward_amount_and_currency();
                Amount redact = reward_amount_and_currency != null ? Amount.ADAPTER.redact(reward_amount_and_currency) : null;
                Amount threshold_amount_and_currency = value.getThreshold_amount_and_currency();
                return SimplifiedBuyReferralMetadata.copy$default(value, null, null, null, null, null, null, null, redact, threshold_amount_and_currency != null ? Amount.ADAPTER.redact(threshold_amount_and_currency) : null, i.a, 127, null);
            }
        };
        ADAPTER = protoAdapter;
        CREATOR = a.Companion.a(protoAdapter);
    }

    public SimplifiedBuyReferralMetadata() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public /* synthetic */ SimplifiedBuyReferralMetadata(String str, String str2, String str3, String str4, String str5, String str6, String str7, Amount amount, Amount amount2, i iVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) == 0 ? str7 : "", (i2 & 128) != 0 ? null : amount, (i2 & 256) == 0 ? amount2 : null, (i2 & 512) != 0 ? i.a : iVar);
    }

    public static /* synthetic */ SimplifiedBuyReferralMetadata copy$default(SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata, String str, String str2, String str3, String str4, String str5, String str6, String str7, Amount amount, Amount amount2, i iVar, int i2, Object obj) {
        return simplifiedBuyReferralMetadata.copy((i2 & 1) != 0 ? simplifiedBuyReferralMetadata.buy_screen_text : str, (i2 & 2) != 0 ? simplifiedBuyReferralMetadata.buy_screen_continue_text : str2, (i2 & 4) != 0 ? simplifiedBuyReferralMetadata.drop_off_title : str3, (i2 & 8) != 0 ? simplifiedBuyReferralMetadata.drop_off_body : str4, (i2 & 16) != 0 ? simplifiedBuyReferralMetadata.reward_amount : str5, (i2 & 32) != 0 ? simplifiedBuyReferralMetadata.reward_amount_fiat_currency : str6, (i2 & 64) != 0 ? simplifiedBuyReferralMetadata.reward_amount_crypto_currency : str7, (i2 & 128) != 0 ? simplifiedBuyReferralMetadata.reward_amount_and_currency : amount, (i2 & 256) != 0 ? simplifiedBuyReferralMetadata.threshold_amount_and_currency : amount2, (i2 & 512) != 0 ? simplifiedBuyReferralMetadata.unknownFields() : iVar);
    }

    public final SimplifiedBuyReferralMetadata copy(String buy_screen_text, String buy_screen_continue_text, String drop_off_title, String drop_off_body, String reward_amount, String reward_amount_fiat_currency, String reward_amount_crypto_currency, Amount amount, Amount amount2, i unknownFields) {
        m.h(buy_screen_text, "buy_screen_text");
        m.h(buy_screen_continue_text, "buy_screen_continue_text");
        m.h(drop_off_title, "drop_off_title");
        m.h(drop_off_body, "drop_off_body");
        m.h(reward_amount, "reward_amount");
        m.h(reward_amount_fiat_currency, "reward_amount_fiat_currency");
        m.h(reward_amount_crypto_currency, "reward_amount_crypto_currency");
        m.h(unknownFields, "unknownFields");
        return new SimplifiedBuyReferralMetadata(buy_screen_text, buy_screen_continue_text, drop_off_title, drop_off_body, reward_amount, reward_amount_fiat_currency, reward_amount_crypto_currency, amount, amount2, unknownFields);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof SimplifiedBuyReferralMetadata) {
            SimplifiedBuyReferralMetadata simplifiedBuyReferralMetadata = (SimplifiedBuyReferralMetadata) obj;
            return m.c(unknownFields(), simplifiedBuyReferralMetadata.unknownFields()) && m.c(this.buy_screen_text, simplifiedBuyReferralMetadata.buy_screen_text) && m.c(this.buy_screen_continue_text, simplifiedBuyReferralMetadata.buy_screen_continue_text) && m.c(this.drop_off_title, simplifiedBuyReferralMetadata.drop_off_title) && m.c(this.drop_off_body, simplifiedBuyReferralMetadata.drop_off_body) && m.c(this.reward_amount, simplifiedBuyReferralMetadata.reward_amount) && m.c(this.reward_amount_fiat_currency, simplifiedBuyReferralMetadata.reward_amount_fiat_currency) && m.c(this.reward_amount_crypto_currency, simplifiedBuyReferralMetadata.reward_amount_crypto_currency) && m.c(this.reward_amount_and_currency, simplifiedBuyReferralMetadata.reward_amount_and_currency) && m.c(this.threshold_amount_and_currency, simplifiedBuyReferralMetadata.threshold_amount_and_currency);
        }
        return false;
    }

    public final String getBuy_screen_continue_text() {
        return this.buy_screen_continue_text;
    }

    public final String getBuy_screen_text() {
        return this.buy_screen_text;
    }

    public final String getDrop_off_body() {
        return this.drop_off_body;
    }

    public final String getDrop_off_title() {
        return this.drop_off_title;
    }

    public final String getReward_amount() {
        return this.reward_amount;
    }

    public final Amount getReward_amount_and_currency() {
        return this.reward_amount_and_currency;
    }

    public final String getReward_amount_crypto_currency() {
        return this.reward_amount_crypto_currency;
    }

    public final String getReward_amount_fiat_currency() {
        return this.reward_amount_fiat_currency;
    }

    public final Amount getThreshold_amount_and_currency() {
        return this.threshold_amount_and_currency;
    }

    public int hashCode() {
        int i2 = this.hashCode;
        if (i2 == 0) {
            int hashCode = ((((((((((((((unknownFields().hashCode() * 37) + this.buy_screen_text.hashCode()) * 37) + this.buy_screen_continue_text.hashCode()) * 37) + this.drop_off_title.hashCode()) * 37) + this.drop_off_body.hashCode()) * 37) + this.reward_amount.hashCode()) * 37) + this.reward_amount_fiat_currency.hashCode()) * 37) + this.reward_amount_crypto_currency.hashCode()) * 37;
            Amount amount = this.reward_amount_and_currency;
            int hashCode2 = (hashCode + (amount != null ? amount.hashCode() : 0)) * 37;
            Amount amount2 = this.threshold_amount_and_currency;
            int hashCode3 = hashCode2 + (amount2 != null ? amount2.hashCode() : 0);
            this.hashCode = hashCode3;
            return hashCode3;
        }
        return i2;
    }

    @Override // com.squareup.wire.g
    public /* bridge */ /* synthetic */ g.a newBuilder() {
        return (g.a) m434newBuilder();
    }

    @Override // com.squareup.wire.g
    public String toString() {
        String h0;
        ArrayList arrayList = new ArrayList();
        arrayList.add("buy_screen_text=" + b.c(this.buy_screen_text));
        arrayList.add("buy_screen_continue_text=" + b.c(this.buy_screen_continue_text));
        arrayList.add("drop_off_title=" + b.c(this.drop_off_title));
        arrayList.add("drop_off_body=" + b.c(this.drop_off_body));
        arrayList.add("reward_amount=" + b.c(this.reward_amount));
        arrayList.add("reward_amount_fiat_currency=" + b.c(this.reward_amount_fiat_currency));
        arrayList.add("reward_amount_crypto_currency=" + b.c(this.reward_amount_crypto_currency));
        if (this.reward_amount_and_currency != null) {
            arrayList.add("reward_amount_and_currency=" + this.reward_amount_and_currency);
        }
        if (this.threshold_amount_and_currency != null) {
            arrayList.add("threshold_amount_and_currency=" + this.threshold_amount_and_currency);
        }
        h0 = z.h0(arrayList, ", ", "SimplifiedBuyReferralMetadata{", "}", 0, null, null, 56, null);
        return h0;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimplifiedBuyReferralMetadata(String buy_screen_text, String buy_screen_continue_text, String drop_off_title, String drop_off_body, String reward_amount, String reward_amount_fiat_currency, String reward_amount_crypto_currency, Amount amount, Amount amount2, i unknownFields) {
        super(ADAPTER, unknownFields);
        m.h(buy_screen_text, "buy_screen_text");
        m.h(buy_screen_continue_text, "buy_screen_continue_text");
        m.h(drop_off_title, "drop_off_title");
        m.h(drop_off_body, "drop_off_body");
        m.h(reward_amount, "reward_amount");
        m.h(reward_amount_fiat_currency, "reward_amount_fiat_currency");
        m.h(reward_amount_crypto_currency, "reward_amount_crypto_currency");
        m.h(unknownFields, "unknownFields");
        this.buy_screen_text = buy_screen_text;
        this.buy_screen_continue_text = buy_screen_continue_text;
        this.drop_off_title = drop_off_title;
        this.drop_off_body = drop_off_body;
        this.reward_amount = reward_amount;
        this.reward_amount_fiat_currency = reward_amount_fiat_currency;
        this.reward_amount_crypto_currency = reward_amount_crypto_currency;
        this.reward_amount_and_currency = amount;
        this.threshold_amount_and_currency = amount2;
    }

    /* renamed from: newBuilder */
    public /* synthetic */ Void m434newBuilder() {
        throw new AssertionError();
    }
}