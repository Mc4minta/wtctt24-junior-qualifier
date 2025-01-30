package com.coinbase.wallet.http.models;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: WebIncomingDataType.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/http/models/WebIncomingDataType;", "", "<init>", "()V", "WebIncomingData", "WebIncomingText", "Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingText;", "Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingData;", "http_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class WebIncomingDataType {

    /* compiled from: WebIncomingDataType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingData;", "Lcom/coinbase/wallet/http/models/WebIncomingDataType;", "", "component1", "()[B", "data", "copy", "([B)Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingData;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "[B", "getData", "<init>", "([B)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WebIncomingData extends WebIncomingDataType {
        private final byte[] data;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebIncomingData(byte[] data) {
            super(null);
            m.g(data, "data");
            this.data = data;
        }

        public static /* synthetic */ WebIncomingData copy$default(WebIncomingData webIncomingData, byte[] bArr, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                bArr = webIncomingData.data;
            }
            return webIncomingData.copy(bArr);
        }

        public final byte[] component1() {
            return this.data;
        }

        public final WebIncomingData copy(byte[] data) {
            m.g(data, "data");
            return new WebIncomingData(data);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WebIncomingData) && m.c(this.data, ((WebIncomingData) obj).data);
        }

        public final byte[] getData() {
            return this.data;
        }

        public int hashCode() {
            return Arrays.hashCode(this.data);
        }

        public String toString() {
            return "WebIncomingData(data=" + Arrays.toString(this.data) + ')';
        }
    }

    /* compiled from: WebIncomingDataType.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingText;", "Lcom/coinbase/wallet/http/models/WebIncomingDataType;", "", "component1", "()Ljava/lang/String;", "string", "copy", "(Ljava/lang/String;)Lcom/coinbase/wallet/http/models/WebIncomingDataType$WebIncomingText;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getString", "<init>", "(Ljava/lang/String;)V", "http_release"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class WebIncomingText extends WebIncomingDataType {
        private final String string;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebIncomingText(String string) {
            super(null);
            m.g(string, "string");
            this.string = string;
        }

        public static /* synthetic */ WebIncomingText copy$default(WebIncomingText webIncomingText, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = webIncomingText.string;
            }
            return webIncomingText.copy(str);
        }

        public final String component1() {
            return this.string;
        }

        public final WebIncomingText copy(String string) {
            m.g(string, "string");
            return new WebIncomingText(string);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WebIncomingText) && m.c(this.string, ((WebIncomingText) obj).string);
        }

        public final String getString() {
            return this.string;
        }

        public int hashCode() {
            return this.string.hashCode();
        }

        public String toString() {
            return "WebIncomingText(string=" + this.string + ')';
        }
    }

    private WebIncomingDataType() {
    }

    public /* synthetic */ WebIncomingDataType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}