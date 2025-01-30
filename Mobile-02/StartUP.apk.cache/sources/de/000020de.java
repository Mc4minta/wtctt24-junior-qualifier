package com.coinbase.wallet.features.send.views.adapters;

import android.text.Editable;
import android.text.TextWatcher;
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
import com.coinbase.wallet.commonui.utilities.Colors;
import com.coinbase.wallet.commonui.utilities.ColorsKt;
import com.coinbase.wallet.core.extensions.Strings;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeCustomViewInfoState;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeViewInfoState;
import com.coinbase.wallet.features.send.models.PresetSpeed;
import com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.textfield.TextInputEditText;
import e.j.f.y;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.a0.r;
import kotlin.e0.c.l;
import kotlin.e0.c.q;
import kotlin.jvm.internal.h0;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: AdjustableMinerFeePresetAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002/0BO\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060#\u0012$\u0010(\u001a \u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00060&\u0012\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*¢\u0006\u0004\b-\u0010.J\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0016¢\u0006\u0004\b\u0013\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\"\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R4\u0010(\u001a \u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0004\u0012\u00020\u00060&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFeePresetAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "minerFeePresetStates", "Lkotlin/x;", "updateMinerFeeInfo", "(Ljava/util/List;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$e0;", "position", "getItemViewType", "(I)I", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$e0;I)V", "", "", "payloads", "(Landroidx/recyclerview/widget/RecyclerView$e0;ILjava/util/List;)V", "getItemCount", "()I", "", "getItemId", "(I)J", "", "customFieldInitialized", "Z", "presetList", "Ljava/util/List;", "Lkotlin/Function1;", "onItemClickListener", "Lkotlin/e0/c/l;", "Lkotlin/Function3;", "", "onCustomValueChangeListener", "Lkotlin/e0/c/q;", "Lkotlin/Function0;", "hideKeyboardCallback", "Lkotlin/e0/c/a;", "<init>", "(Lkotlin/e0/c/l;Lkotlin/e0/c/q;Lkotlin/e0/c/a;)V", "MinerFeeCustomHolder", "MinerFeePresetHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class AdjustableMinerFeePresetAdapter extends RecyclerView.g<RecyclerView.e0> {
    private boolean customFieldInitialized;
    private final kotlin.e0.c.a<x> hideKeyboardCallback;
    private final q<String, String, String, x> onCustomValueChangeListener;
    private final l<AdjustableMinerFeeViewInfoState, x> onItemClickListener;
    private List<? extends AdjustableMinerFeeViewInfoState> presetList;

    /* compiled from: AdjustableMinerFeePresetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020,¢\u0006\u0004\b.\u0010/Je\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042$\u0010\n\u001a \u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001d\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u0013R\u0016\u0010\u001e\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u0013R\u0016\u0010\u001f\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0013R\u0016\u0010 \u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u0013R\u0016\u0010!\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010#\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010\u0013R\u0016\u0010%\u001a\u00020$8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010)R\u0016\u0010+\u001a\u00020'8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010)¨\u00060"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;", "presetInfo", "Lkotlin/Function1;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "Lkotlin/x;", "onItemClickListener", "Lkotlin/Function3;", "", "onCustomValueChangeListener", "Lkotlin/Function0;", "hideKeyboardCallback", "", "initialized", "bind", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeCustomViewInfoState;Lkotlin/e0/c/l;Lkotlin/e0/c/q;Lkotlin/e0/c/a;Z)V", "Landroid/widget/TextView;", "minerFeeCustomWaitTime", "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "minerFeeCustomIcon", "Landroid/widget/ImageView;", "Landroid/widget/Button;", "confirmButton", "Landroid/widget/Button;", "Landroid/widget/LinearLayout;", "rightLabel", "Landroid/widget/LinearLayout;", "cryptoLabel", "minerFeeCustomName", "descriptionLabel", "warningMessageLabel", "showEstimate", "Z", "fiatLabel", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionLayout", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "Landroid/widget/EditText;", "gasLimitField", "Landroid/widget/EditText;", "gasPriceField", "nonceField", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MinerFeeCustomHolder extends RecyclerView.e0 {
        private final Button confirmButton;
        private final TextView cryptoLabel;
        private final TextView descriptionLabel;
        private final TextView fiatLabel;
        private final EditText gasLimitField;
        private final EditText gasPriceField;
        private final ImageView minerFeeCustomIcon;
        private final TextView minerFeeCustomName;
        private final TextView minerFeeCustomWaitTime;
        private final MotionLayout motionLayout;
        private final EditText nonceField;
        private final LinearLayout rightLabel;
        private boolean showEstimate;
        private final TextView warningMessageLabel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MinerFeeCustomHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(e.j.a.customName);
            m.f(textView, "itemView.customName");
            this.minerFeeCustomName = textView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.customWaitTimeLabel);
            m.f(textView2, "itemView.customWaitTimeLabel");
            this.minerFeeCustomWaitTime = textView2;
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.customIcon);
            m.f(imageView, "itemView.customIcon");
            this.minerFeeCustomIcon = imageView;
            int i2 = e.j.a.edit_text;
            TextInputEditText textInputEditText = (TextInputEditText) ((LabelsEditText) itemView.findViewById(e.j.a.gasLimitField)).findViewById(i2);
            m.f(textInputEditText, "itemView.gasLimitField.edit_text");
            this.gasLimitField = textInputEditText;
            int i3 = e.j.a.gasPriceField;
            TextInputEditText textInputEditText2 = (TextInputEditText) ((LabelsEditText) itemView.findViewById(i3)).findViewById(i2);
            m.f(textInputEditText2, "itemView.gasPriceField.edit_text");
            this.gasPriceField = textInputEditText2;
            LinearLayout linearLayout = (LinearLayout) ((LabelsEditText) itemView.findViewById(i3)).findViewById(e.j.a.rightLabelContainer);
            m.f(linearLayout, "itemView.gasPriceField.rightLabelContainer");
            this.rightLabel = linearLayout;
            TextInputEditText textInputEditText3 = (TextInputEditText) ((LabelsEditText) itemView.findViewById(e.j.a.nonceField)).findViewById(i2);
            m.f(textInputEditText3, "itemView.nonceField.edit_text");
            this.nonceField = textInputEditText3;
            TextView textView3 = (TextView) itemView.findViewById(e.j.a.customFiatFeeLabel);
            m.f(textView3, "itemView.customFiatFeeLabel");
            this.fiatLabel = textView3;
            TextView textView4 = (TextView) itemView.findViewById(e.j.a.customCryptoFeeLabel);
            m.f(textView4, "itemView.customCryptoFeeLabel");
            this.cryptoLabel = textView4;
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

        public static final /* synthetic */ EditText access$getGasPriceField$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.gasPriceField;
        }

        public static final /* synthetic */ TextView access$getMinerFeeCustomWaitTime$p(MinerFeeCustomHolder minerFeeCustomHolder) {
            return minerFeeCustomHolder.minerFeeCustomWaitTime;
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

        public final void bind(AdjustableMinerFeeCustomViewInfoState presetInfo, l<? super AdjustableMinerFeeViewInfoState, x> onItemClickListener, final q<? super String, ? super String, ? super String, x> onCustomValueChangeListener, final kotlin.e0.c.a<x> hideKeyboardCallback, boolean z) {
            m.g(presetInfo, "presetInfo");
            m.g(onItemClickListener, "onItemClickListener");
            m.g(onCustomValueChangeListener, "onCustomValueChangeListener");
            m.g(hideKeyboardCallback, "hideKeyboardCallback");
            this.minerFeeCustomName.setText(presetInfo.getName());
            ImageView imageView = this.minerFeeCustomIcon;
            View itemView = this.itemView;
            m.f(itemView, "itemView");
            imageView.setImageDrawable(y.c(itemView, presetInfo.getIcon()));
            this.fiatLabel.setText(presetInfo.getFiatFee());
            this.cryptoLabel.setText(presetInfo.getCryptoFee());
            this.warningMessageLabel.setText(presetInfo.getWarningMessage());
            this.minerFeeCustomWaitTime.setText(presetInfo.getWaitTime());
            this.fiatLabel.setVisibility(this.showEstimate ? 0 : 8);
            this.cryptoLabel.setVisibility(this.showEstimate ? 0 : 8);
            this.minerFeeCustomWaitTime.setVisibility(this.showEstimate ? 0 : 8);
            this.descriptionLabel.setVisibility(this.showEstimate ^ true ? 0 : 8);
            if (presetInfo.getWarningMessage() != null) {
                this.warningMessageLabel.setVisibility(0);
                this.minerFeeCustomWaitTime.setTextColor(ColorsKt.get(Colors.INSTANCE, R.color.warning_yellow));
            } else {
                this.warningMessageLabel.setVisibility(8);
                this.minerFeeCustomWaitTime.setTextColor(ColorsKt.get(Colors.INSTANCE, R.color.grey_30));
            }
            this.confirmButton.setEnabled(presetInfo.isValid());
            if (!z && presetInfo.getDataLoaded()) {
                View_CommonKt.setOnSingleClickListener$default(this.rightLabel, 0L, new AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$1(this), 1, null);
                View_CommonKt.setOnSingleClickListener$default(this.confirmButton, 0L, new AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$2(onItemClickListener, presetInfo), 1, null);
                EditText editText = this.gasPriceField;
                h0 h0Var = h0.a;
                String gasString = presetInfo.getGasString();
                if (gasString == null) {
                    gasString = Strings.zero;
                }
                String format = String.format(gasString, Arrays.copyOf(new Object[0], 0));
                m.f(format, "java.lang.String.format(format, *args)");
                editText.setText(format);
                EditText editText2 = this.gasLimitField;
                String bigInteger = presetInfo.getGasLimit().toString();
                m.f(bigInteger, "presetInfo.gasLimit.toString()");
                String format2 = String.format(bigInteger, Arrays.copyOf(new Object[0], 0));
                m.f(format2, "java.lang.String.format(format, *args)");
                editText2.setText(format2);
                EditText editText3 = this.nonceField;
                String format3 = String.format(String.valueOf(presetInfo.getNonce()), Arrays.copyOf(new Object[0], 0));
                m.f(format3, "java.lang.String.format(format, *args)");
                editText3.setText(format3);
                this.gasPriceField.addTextChangedListener(new TextWatcher() { // from class: com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$$inlined$addTextChangedListener$default$1
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String valueOrZero;
                        q qVar = q.this;
                        valueOrZero = AdjustableMinerFeePresetAdapterKt.valueOrZero(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasPriceField$p(this).getText().toString());
                        qVar.invoke(valueOrZero, null, null);
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }
                });
                this.gasLimitField.addTextChangedListener(new TextWatcher() { // from class: com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$$inlined$addTextChangedListener$default$2
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String valueOrZero;
                        q qVar = q.this;
                        valueOrZero = AdjustableMinerFeePresetAdapterKt.valueOrZero(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasLimitField$p(this).getText().toString());
                        qVar.invoke(null, valueOrZero, null);
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }
                });
                this.nonceField.addTextChangedListener(new TextWatcher() { // from class: com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$$inlined$addTextChangedListener$default$3
                    @Override // android.text.TextWatcher
                    public void afterTextChanged(Editable editable) {
                        String valueOrZero;
                        q qVar = q.this;
                        valueOrZero = AdjustableMinerFeePresetAdapterKt.valueOrZero(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getNonceField$p(this).getText().toString());
                        qVar.invoke(null, null, valueOrZero);
                    }

                    @Override // android.text.TextWatcher
                    public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }

                    @Override // android.text.TextWatcher
                    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                    }
                });
            }
            this.motionLayout.setTransitionListener(new MotionLayout.i() { // from class: com.coinbase.wallet.features.send.views.adapters.AdjustableMinerFeePresetAdapter$MinerFeeCustomHolder$bind$6
                @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
                public void onTransitionChange(MotionLayout motionLayout, int i2, int i3, float f2) {
                    if (!(f2 == 1.0f)) {
                        if (f2 == 0.0f) {
                            AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasPriceField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).clearFocus();
                            AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasLimitField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).clearFocus();
                            AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getNonceField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).clearFocus();
                            hideKeyboardCallback.invoke();
                            return;
                        }
                        return;
                    }
                    AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasPriceField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).requestFocus();
                    AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasPriceField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).setSelection(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getGasPriceField$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).getText().length());
                    if (AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getShowEstimate$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this)) {
                        return;
                    }
                    AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$setShowEstimate$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this, true);
                    TextView access$getMinerFeeCustomWaitTime$p = AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getMinerFeeCustomWaitTime$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this);
                    access$getMinerFeeCustomWaitTime$p.setAlpha(0.0f);
                    access$getMinerFeeCustomWaitTime$p.setVisibility(0);
                    access$getMinerFeeCustomWaitTime$p.animate().alpha(1.0f).setDuration(500L);
                    TextView access$getFiatLabel$p = AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getFiatLabel$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this);
                    access$getFiatLabel$p.setAlpha(0.0f);
                    access$getFiatLabel$p.setVisibility(0);
                    access$getFiatLabel$p.animate().alpha(1.0f).setDuration(500L);
                    TextView access$getCryptoLabel$p = AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getCryptoLabel$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this);
                    access$getCryptoLabel$p.setAlpha(0.0f);
                    access$getCryptoLabel$p.setVisibility(0);
                    access$getCryptoLabel$p.animate().alpha(1.0f).setDuration(500L);
                    AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.access$getDescriptionLabel$p(AdjustableMinerFeePresetAdapter.MinerFeeCustomHolder.this).animate().alpha(0.0f).setDuration(500L);
                }

                @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
                public void onTransitionCompleted(MotionLayout motionLayout, int i2) {
                }

                @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
                public void onTransitionStarted(MotionLayout motionLayout, int i2, int i3) {
                }

                @Override // androidx.constraintlayout.motion.widget.MotionLayout.i
                public void onTransitionTrigger(MotionLayout motionLayout, int i2, boolean z2, float f2) {
                }
            });
        }
    }

    /* compiled from: AdjustableMinerFeePresetAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ)\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\n\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u000bR\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/coinbase/wallet/features/send/views/adapters/AdjustableMinerFeePresetAdapter$MinerFeePresetHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;", "presetInfo", "Lkotlin/Function1;", "Lkotlin/x;", "onItemClickListener", "bind", "(Lcom/coinbase/wallet/features/send/models/AdjustableMinerFeeViewInfoState;Lkotlin/e0/c/l;)V", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "cryptoAmountShimmer", "Lcom/facebook/shimmer/ShimmerFrameLayout;", "Landroid/widget/TextView;", "minerFeePresetName", "Landroid/widget/TextView;", "minerFeeFiatFee", "minerFeeCryptoFee", "Landroid/widget/ImageView;", "minerFeePresetIcon", "Landroid/widget/ImageView;", "minerFeePresetWaitTime", "waitTimeShimmer", "fiatAmountShimmer", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class MinerFeePresetHolder extends RecyclerView.e0 {
        private final ShimmerFrameLayout cryptoAmountShimmer;
        private final ShimmerFrameLayout fiatAmountShimmer;
        private final TextView minerFeeCryptoFee;
        private final TextView minerFeeFiatFee;
        private final ImageView minerFeePresetIcon;
        private final TextView minerFeePresetName;
        private final TextView minerFeePresetWaitTime;
        private final ShimmerFrameLayout waitTimeShimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MinerFeePresetHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
            TextView textView = (TextView) itemView.findViewById(e.j.a.n4);
            m.f(textView, "itemView.name");
            this.minerFeePresetName = textView;
            TextView textView2 = (TextView) itemView.findViewById(e.j.a.waitTimeLabel);
            m.f(textView2, "itemView.waitTimeLabel");
            this.minerFeePresetWaitTime = textView2;
            ImageView imageView = (ImageView) itemView.findViewById(e.j.a.P2);
            m.f(imageView, "itemView.icon");
            this.minerFeePresetIcon = imageView;
            TextView textView3 = (TextView) itemView.findViewById(e.j.a.fiatFeeLabel);
            m.f(textView3, "itemView.fiatFeeLabel");
            this.minerFeeFiatFee = textView3;
            TextView textView4 = (TextView) itemView.findViewById(e.j.a.cryptoFeeLabel);
            m.f(textView4, "itemView.cryptoFeeLabel");
            this.minerFeeCryptoFee = textView4;
            ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) itemView.findViewById(e.j.a.cryptoAmountShimmer);
            m.f(shimmerFrameLayout, "itemView.cryptoAmountShimmer");
            this.cryptoAmountShimmer = shimmerFrameLayout;
            ShimmerFrameLayout shimmerFrameLayout2 = (ShimmerFrameLayout) itemView.findViewById(e.j.a.fiatAmountShimmer);
            m.f(shimmerFrameLayout2, "itemView.fiatAmountShimmer");
            this.fiatAmountShimmer = shimmerFrameLayout2;
            ShimmerFrameLayout shimmerFrameLayout3 = (ShimmerFrameLayout) itemView.findViewById(e.j.a.waitTimeShimmer);
            m.f(shimmerFrameLayout3, "itemView.waitTimeShimmer");
            this.waitTimeShimmer = shimmerFrameLayout3;
        }

        public final void bind(AdjustableMinerFeeViewInfoState presetInfo, l<? super AdjustableMinerFeeViewInfoState, x> onItemClickListener) {
            m.g(presetInfo, "presetInfo");
            m.g(onItemClickListener, "onItemClickListener");
            this.minerFeePresetName.setText(presetInfo.getName());
            this.minerFeePresetWaitTime.setText(presetInfo.getWaitTime());
            ImageView imageView = this.minerFeePresetIcon;
            View itemView = this.itemView;
            m.f(itemView, "itemView");
            imageView.setImageDrawable(y.c(itemView, presetInfo.getIcon()));
            this.minerFeeFiatFee.setText(presetInfo.getFiatFee());
            this.minerFeeCryptoFee.setText(presetInfo.getCryptoFee());
            this.cryptoAmountShimmer.setVisibility(presetInfo.getDataLoaded() ? 8 : 0);
            this.fiatAmountShimmer.setVisibility(presetInfo.getDataLoaded() ? 8 : 0);
            this.waitTimeShimmer.setVisibility(presetInfo.getDataLoaded() ? 8 : 0);
            View itemView2 = this.itemView;
            m.f(itemView2, "itemView");
            View_CommonKt.setOnSingleClickListener$default(itemView2, 0L, new AdjustableMinerFeePresetAdapter$MinerFeePresetHolder$bind$1(onItemClickListener, presetInfo), 1, null);
        }
    }

    /* compiled from: AdjustableMinerFeePresetAdapter.kt */
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
    public AdjustableMinerFeePresetAdapter(l<? super AdjustableMinerFeeViewInfoState, x> onItemClickListener, q<? super String, ? super String, ? super String, x> onCustomValueChangeListener, kotlin.e0.c.a<x> hideKeyboardCallback) {
        List<? extends AdjustableMinerFeeViewInfoState> g2;
        m.g(onItemClickListener, "onItemClickListener");
        m.g(onCustomValueChangeListener, "onCustomValueChangeListener");
        m.g(hideKeyboardCallback, "hideKeyboardCallback");
        this.onItemClickListener = onItemClickListener;
        this.onCustomValueChangeListener = onCustomValueChangeListener;
        this.hideKeyboardCallback = hideKeyboardCallback;
        g2 = r.g();
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
        AdjustableMinerFeeViewInfoState adjustableMinerFeeViewInfoState = this.presetList.get(i2);
        int i3 = WhenMappings.$EnumSwitchMapping$0[adjustableMinerFeeViewInfoState.getPresetSpeed().ordinal()];
        if (i3 == 1 || i3 == 2 || i3 == 3) {
            ((MinerFeePresetHolder) holder).bind(adjustableMinerFeeViewInfoState, this.onItemClickListener);
        } else if (i3 != 4) {
        } else {
            MinerFeeCustomHolder minerFeeCustomHolder = (MinerFeeCustomHolder) holder;
            minerFeeCustomHolder.bind((AdjustableMinerFeeCustomViewInfoState) adjustableMinerFeeViewInfoState, this.onItemClickListener, this.onCustomValueChangeListener, this.hideKeyboardCallback, this.customFieldInitialized);
            if (adjustableMinerFeeViewInfoState.getDataLoaded()) {
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
            View v2 = from.inflate(R.layout.list_item__miner_fee_custom, parent, false);
            m.f(v2, "v");
            return new MinerFeeCustomHolder(v2);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void updateMinerFeeInfo(List<? extends AdjustableMinerFeeViewInfoState> minerFeePresetStates) {
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