package com.coinbase.wallet.commonui.extensions;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.m;

/* compiled from: NumberKeyboardInputView+Common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "", "<init>", "()V", "Error", "Success", "Lcom/coinbase/wallet/commonui/extensions/RawStringResult$Success;", "Lcom/coinbase/wallet/commonui/extensions/RawStringResult$Error;", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class RawStringResult {

    /* compiled from: NumberKeyboardInputView+Common.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/coinbase/wallet/commonui/extensions/RawStringResult$Error;", "Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "<init>", "()V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Error extends RawStringResult {
        public static final Error INSTANCE = new Error();

        private Error() {
            super(null);
        }
    }

    /* compiled from: NumberKeyboardInputView+Common.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/coinbase/wallet/commonui/extensions/RawStringResult$Success;", "Lcom/coinbase/wallet/commonui/extensions/RawStringResult;", "", "rawString", "Ljava/lang/String;", "getRawString", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "commonui_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class Success extends RawStringResult {
        private final String rawString;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Success(String rawString) {
            super(null);
            m.g(rawString, "rawString");
            this.rawString = rawString;
        }

        public final String getRawString() {
            return this.rawString;
        }
    }

    private RawStringResult() {
    }

    public /* synthetic */ RawStringResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}