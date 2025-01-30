package com.coinbase.wallet.features.send.views.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.application.view.custom.LabelsEditText;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559CustomViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState;
import com.coinbase.wallet.features.send.models.PresetSpeed;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.textfield.TextInputEditText;
import e.j.f.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.e0.c.l;
import kotlin.e0.c.r;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0BW\u0012\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060(\u0012,\u0010#\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u00060!\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e¢\u0006\u0004\b-\u0010.J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R<\u0010#\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020\u00060!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010&\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060(8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFee1559PresetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "minerFeePresetStates", "Lkotlin/x;", "updateMinerFeeInfo", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "position", "getItemViewType", "(I)I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "", "", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$e0;ILjava/util/List;)V", "getItemCount", "()I", "", "getItemId", "(I)J", "Lkotlin/Function0;", "hideKeyboardCallback", "Lkotlin/e0/c/a;", "Lkotlin/Function4;", "", "onCustomValueChangeListener", "Lkotlin/e0/c/r;", "", "customFieldInitialized", "Z", "Lkotlin/Function1;", "onItemClickListener", "Lkotlin/e0/c/l;", "presetList", "Ljava/util/List;", "<init>", "(Lkotlin/e0/c/l;Lkotlin/e0/c/r;Lkotlin/e0/c/a;)V", "MinerFeeCustomHolder", "MinerFeePresetHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFee1559PresetAdapter extends RecyclerView.g<RecyclerView.e0> {
    private boolean customFieldInitialized;
    private final kotlin.e0.c.a<x> hideKeyboardCallback;
    private final r<String, String, String, String, x> onCustomValueChangeListener;
    private final l<AdjustableMinerFee1559ViewInfoState, x> onItemClickListener;
    private List<? extends AdjustableMinerFee1559ViewInfoState> presetList;

    /* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103Jo\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042,\u0010\n\u001a(\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\b2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010 \u001a\u00020\u001f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010\u0019R\u0016\u0010&\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010'\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0016R\u0016\u0010(\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001eR\u0016\u0010)\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001eR\u0016\u0010*\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010\u0016R\u0016\u0010+\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010\u001eR\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010\u0019R\u0016\u0010/\u001a\u00020\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u0010\u001e¨\u00064"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFee1559PresetAdapter$MinerFeeCustomHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;", "presetInfo", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "Lkotlin/x;", "onItemClickListener", "Lkotlin/Function4;", "", "onCustomValueChangeListener", "Lkotlin/Function0;", "hideKeyboardCallback", "", "initialized", "bind", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559CustomViewInfoState;Lkotlin/e0/c/l;Lkotlin/e0/c/r;Lkotlin/e0/c/a;Z)V", "Landroid/widget/ImageView;", "minerFeeCustomIcon", "Landroid/widget/ImageView;", "Landroid/widget/EditText;", "gasLimitField", "Landroid/widget/EditText;", "Landroid/widget/LinearLayout;", "nonceClearButton", "Landroid/widget/LinearLayout;", "limitClearButton", "maxPriorityFeeField", "Landroid/widget/TextView;", "maxFeeLabel", "Landroid/widget/TextView;", "Landroid/widget/Button;", "confirmButton", "Landroid/widget/Button;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionLayout", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "baseFeeClearButton", "minerFeeCustomName", "maxBaseFeeField", "cryptoLabel", "warningMessageLabel", "nonceField", "showEstimate", "Z", "descriptionLabel", "priorityFeeClearButton", "fiatLabel", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MinerFeeCustomHolder extends RecyclerView.e0 {
        private final LinearLayout baseFeeClearButton;
        private final Button confirmButton;
        private final TextView cryptoLabel;
        private final TextView descriptionLabel;
        private final TextView fiatLabel;
        private final EditText gasLimitField;
        private final LinearLayout limitClearButton;
        private final EditText maxBaseFeeField;
        private final TextView maxFeeLabel;
        private final EditText maxPriorityFeeField;
        private final ImageView minerFeeCustomIcon;
        private final TextView minerFeeCustomName;
        private final MotionLayout motionLayout;
        private final LinearLayout nonceClearButton;
        private final EditText nonceField;
        private final LinearLayout priorityFeeClearButton;
        private boolean showEstimate;
        private final TextView warningMessageLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MinerFeeCustomHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(e.j.a.customName);
            m.f(textView, "itemView.customName");
            this.minerFeeCustomName = textView;
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.customIcon);
            m.f(imageView, "itemView.customIcon");
            this.minerFeeCustomIcon = imageView;
            int i2 = e.j.a.gasLimitField;
            int i3 = e.j.a.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) ((LabelsEditText) itemView.findViewById(i2)).findViewById(i3);
            m.f(textInputEditText, "itemView.gasLimitField.edit_text");
            this.gasLimitField = textInputEditText;
            int i4 = e.j.a.priorityFeeField;
            TextInputEditText textInputEditText2 = (TextInputEditText) ((LabelsEditText) itemView.findViewById(i4)).findViewById(i3);
            m.f(textInputEditText2, "itemView.priorityFeeField.edit_text");
            this.maxPriorityFeeField = textInputEditText2;
            int i5 = e.j.a.baseFeeField;
            TextInputEditText textInputEditText3 = (TextInputEditText) ((LabelsEditText) itemView.findViewById(i5)).findViewById(i3);
            m.f(textInputEditText3, "itemView.baseFeeField.edit_text");
            this.maxBaseFeeField = textInputEditText3;
            int i6 = e.j.a.rightLabelContainer;
            LinearLayout linearLayout = (LinearLayout) ((LabelsEditText) itemView.findViewById(i4)).findViewById(i6);
            m.f(linearLayout, "itemView.priorityFeeField.rightLabelContainer");
            this.priorityFeeClearButton = linearLayout;
            LinearLayout linearLayout2 = (LinearLayout) ((LabelsEditText) itemView.findViewById(i5)).findViewById(i6);
            m.f(linearLayout2, "itemView.baseFeeField.rightLabelContainer");
            this.baseFeeClearButton = linearLayout2;
            int i7 = e.j.a.nonceField;
            LinearLayout linearLayout3 = (LinearLayout) ((LabelsEditText) itemView.findViewById(i7)).findViewById(i6);
            m.f(linearLayout3, "itemView.nonceField.rightLabelContainer");
            this.nonceClearButton = linearLayout3;
            LinearLayout linearLayout4 = (LinearLayout) ((LabelsEditText) itemView.findViewById(i2)).findViewById(i6);
            m.f(linearLayout4, "itemView.gasLimitField.rightLabelContainer");
            this.limitClearButton = linearLayout4;
            TextInputEditText textInputEditText4 = (TextInputEditText) ((LabelsEditText) itemView.findViewById(i7)).findViewById(i3);
            m.f(textInputEditText4, "itemView.nonceField.edit_text");
            this.nonceField = textInputEditText4;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.customFiatFeeLabel);
            m.f(textView2, "itemView.customFiatFeeLabel");
            this.fiatLabel = textView2;
            TextView textView3 = (TextView) itemView.findViewById(e.j.a.customCryptoFeeLabel);
            m.f(textView3, "itemView.customCryptoFeeLabel");
            this.cryptoLabel = textView3;
            TextView textView4 = (TextView) itemView.findViewById(e.j.a.maxFeeLabel);
            m.f(textView4, "itemView.maxFeeLabel");
            this.maxFeeLabel = textView4;
            Button button = (Button) itemView.findViewById(e.j.a.continueButton);
            m.f(button, "itemView.continueButton");
            this.confirmButton = button;
            TextView textView5 = (TextView) itemView.findViewById(e.j.a.customDescription);
            m.f(textView5, "itemView.customDescription");
            this.descriptionLabel = textView5;
            TextView textView6 = (TextView) itemView.findViewById(e.j.a.warningMessage);
            m.f(textView6, "itemView.warningMessage");
            this.warningMessageLabel = textView6;
            MotionLayout motionLayout = (MotionLayout) itemView.findViewById(e.j.a.adjustableMinerFeeScene);
            m.f(motionLayout, "itemView.adjustableMinerFeeScene");
            this.motionLayout = motionLayout;
        }

        public static final /* synthetic */ TextView access$getCryptoLabel$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.cryptoLabel;
        }

        public static final /* synthetic */ TextView access$getDescriptionLabel$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.descriptionLabel;
        }

        public static final /* synthetic */ TextView access$getFiatLabel$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.fiatLabel;
        }

        public static final /* synthetic */ EditText access$getGasLimitField$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.gasLimitField;
        }

        public static final /* synthetic */ EditText access$getMaxBaseFeeField$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.maxBaseFeeField;
        }

        public static final /* synthetic */ EditText access$getMaxPriorityFeeField$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.maxPriorityFeeField;
        }

        public static final /* synthetic */ EditText access$getNonceField$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.nonceField;
        }

        public static final /* synthetic */ boolean access$getShowEstimate$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.showEstimate;
        }

        public static final /* synthetic */ void access$setShowEstimate$p(MinerFeeCustomHolder minerFeeCustomHolder, boolean z) {
            minerFeeCustomHolder.showEstimate = z;
        }

        /* JADX WARN: Removed duplicated region for block: B:54:0x006a  */
        /* JADX WARN: Removed duplicated region for block: B:55:0x0079  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0091  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x009d  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:67:0x00aa  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00b7  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:80:0x012b  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0147  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void bind(com.coinbase.wallet.features.send.models.AdjustableMinerFee1559CustomViewInfoState r21, kotlin.e0.c.l<? super com.coinbase.wallet.features.send.models.AdjustableMinerFee1559ViewInfoState, kotlin.x> r22, final kotlin.e0.c.r<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.x> r23, final kotlin.e0.c.a<kotlin.x> r24, boolean r25) {
            /*
                Method dump skipped, instructions count: 452
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFee1559PresetAdapter.MinerFeeCustomHolder.bind(com.coinbase.wallet.features.send.models.AdjustableMinerFee1559CustomViewInfoState, kotlin.e0.c.l, kotlin.e0.c.r, kotlin.e0.c.a, boolean):void");
        }
    }

    /* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFee1559PresetAdapter$MinerFeePresetHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;", "presetInfo", "Lkotlin/Function1;", "Lkotlin/x;", "onItemClickListener", "bind", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFee1559ViewInfoState;Lkotlin/e0/c/l;)V", "Landroid/widget/ImageView;", "minerFeePresetIcon", "Landroid/widget/ImageView;", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "fiatAmountShimmer", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "Landroid/widget/TextView;", "cryptoFeeLabel", "Landroid/widget/TextView;", "waitTimeLabel", "minerFeePresetName", "estimatedFeeLabel", "cryptoAmountShimmer", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MinerFeePresetHolder extends RecyclerView.e0 {
        private final ShimmerFrameLayout cryptoAmountShimmer;
        private final TextView cryptoFeeLabel;
        private final TextView estimatedFeeLabel;
        private final ShimmerFrameLayout fiatAmountShimmer;
        private final ImageView minerFeePresetIcon;
        private final TextView minerFeePresetName;
        private final TextView waitTimeLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MinerFeePresetHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(e.j.a.n4);
            m.f(textView, "itemView.name");
            this.minerFeePresetName = textView;
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.P2);
            m.f(imageView, "itemView.icon");
            this.minerFeePresetIcon = imageView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.fiatFeeLabel);
            m.f(textView2, "itemView.fiatFeeLabel");
            this.estimatedFeeLabel = textView2;
            TextView textView3 = (TextView) itemView.findViewById(e.j.a.waitTimeLabel);
            m.f(textView3, "itemView.waitTimeLabel");
            this.waitTimeLabel = textView3;
            TextView textView4 = (TextView) itemView.findViewById(e.j.a.cryptoFeeLabel);
            m.f(textView4, "itemView.cryptoFeeLabel");
            this.cryptoFeeLabel = textView4;
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) itemView.findViewById(e.j.a.cryptoAmountShimmer);
            m.f(shimmerFrameLayout, "itemView.cryptoAmountShimmer");
            this.cryptoAmountShimmer = shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) itemView.findViewById(e.j.a.fiatAmountShimmer);
            m.f(shimmerFrameLayout2, "itemView.fiatAmountShimmer");
            this.fiatAmountShimmer = shimmerFrameLayout2;
        }

        public final void bind(AdjustableMinerFee1559ViewInfoState presetInfo, l<? super AdjustableMinerFee1559ViewInfoState, x> onItemClickListener) {
            m.g(presetInfo, "presetInfo");
            m.g(onItemClickListener, "onItemClickListener");
            this.minerFeePresetName.setText(presetInfo.getName());
            ImageView imageView = this.minerFeePresetIcon;
            View itemView = this.itemView;
            m.f(itemView, "itemView");
            imageView.setImageDrawable(y.c(itemView, presetInfo.getIcon()));
            this.estimatedFeeLabel.setText(presetInfo.getFiatRangeString());
            this.waitTimeLabel.setText(presetInfo.getWaitTime());
            this.cryptoFeeLabel.setText(presetInfo.getCryptoRangeString());
            this.cryptoAmountShimmer.setVisibility(presetInfo.getDataLoaded() ? 8 : 0);
            this.fiatAmountShimmer.setVisibility(presetInfo.getDataLoaded() ? 8 : 0);
            if (presetInfo.getDataLoaded()) {
                View itemView2 = this.itemView;
                m.f(itemView2, "itemView");
                View_CommonKt.setOnSingleClickListener$default(itemView2, 0L, new AdjustableMinerFee1559PresetAdapter$MinerFeePresetHolder$bind$1(onItemClickListener, presetInfo), 1, null);
            }
        }
    }

    /* compiled from: AdjustableMinerFee1559PresetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PresetSpeed.values().length];
            iArr[PresetSpeed.SLOW.ordinal()] = 1;
            iArr[PresetSpeed.NORMAL.ordinal()] = 2;
            iArr[PresetSpeed.FAST.ordinal()] = 3;
            iArr[PresetSpeed.CUSTOM.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdjustableMinerFee1559PresetAdapter(l<? super AdjustableMinerFee1559ViewInfoState, x> onItemClickListener, r<? super String, ? super String, ? super String, ? super String, x> onCustomValueChangeListener, kotlin.e0.c.a<x> hideKeyboardCallback) {
        List<? extends AdjustableMinerFee1559ViewInfoState> g2;
        m.g(onItemClickListener, "onItemClickListener");
        m.g(onCustomValueChangeListener, "onCustomValueChangeListener");
        m.g(hideKeyboardCallback, "hideKeyboardCallback");
        this.onItemClickListener = onItemClickListener;
        this.onCustomValueChangeListener = onCustomValueChangeListener;
        this.hideKeyboardCallback = hideKeyboardCallback;
        g2 = kotlin.a0.r.g();
        this.presetList = g2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.presetList.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public long getItemId(int i2) {
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemViewType(int i2) {
        return this.presetList.get(i2).getPresetSpeed().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2) {
        m.g(holder, "holder");
        AdjustableMinerFee1559ViewInfoState adjustableMinerFee1559ViewInfoState = this.presetList.get(i2);
        int i3 = WhenMappings.$EnumSwitchMapping$0[adjustableMinerFee1559ViewInfoState.getPresetSpeed().ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            ((MinerFeePresetHolder) holder).bind(adjustableMinerFee1559ViewInfoState, this.onItemClickListener);
        } else if (i3 != 4) {
        } else {
            MinerFeeCustomHolder minerFeeCustomHolder = (MinerFeeCustomHolder) holder;
            minerFeeCustomHolder.bind((AdjustableMinerFee1559CustomViewInfoState) adjustableMinerFee1559ViewInfoState, this.onItemClickListener, this.onCustomValueChangeListener, this.hideKeyboardCallback, this.customFieldInitialized);
            if (adjustableMinerFee1559ViewInfoState.getDataLoaded()) {
                this.customFieldInitialized = true;
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public RecyclerView.e0 onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i3 = WhenMappings.$EnumSwitchMapping$0[PresetSpeed.values()[i2].ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            View v = from.inflate(R.layout.list_item__miner_fee_preset, parent, false);
            m.f(v, "v");
            return new MinerFeePresetHolder(v);
        } else if (i3 == 4) {
            View v2 = from.inflate(R.layout.list_item__miner_fee_1559_custom, parent, false);
            m.f(v2, "v");
            return new MinerFeeCustomHolder(v2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void updateMinerFeeInfo(List<? extends AdjustableMinerFee1559ViewInfoState> minerFeePresetStates) {
        m.g(minerFeePresetStates, "minerFeePresetStates");
        this.presetList = minerFeePresetStates;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(RecyclerView.e0 holder, int i2, List<Object> payloads) {
        m.g(holder, "holder");
        m.g(payloads, "payloads");
        onBindViewHolder(holder, i2);
    }
}