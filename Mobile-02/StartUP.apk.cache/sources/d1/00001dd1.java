package com.coinbase.wallet.features.cloudbackup.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coinbase.wallet.commonui.extensions.View_CommonKt;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import e.j.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.e0.c.l;
import kotlin.jvm.internal.m;
import kotlin.x;
import org.toshi.R;

/* compiled from: BackupPickerAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B)\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$g;", "Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter$BackupPickerViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter$BackupPickerViewHolder;", "getItemCount", "()I", "holder", "position", "Lkotlin/x;", "onBindViewHolder", "(Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter$BackupPickerViewHolder;I)V", "", "Lcom/coinbase/wallet/features/cloudbackup/models/BackupPayload;", "backups", "Ljava/util/List;", "Lkotlin/Function1;", "onBackupClicked", "Lkotlin/e0/c/l;", "<init>", "(Ljava/util/List;Lkotlin/e0/c/l;)V", "BackupPickerViewHolder", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public final class BackupPickerAdapter extends RecyclerView.g<BackupPickerViewHolder> {
    private final List<BackupPayload> backups;
    private final l<BackupPayload, x> onBackupClicked;

    /* compiled from: BackupPickerAdapter.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/coinbase/wallet/features/cloudbackup/view/adapter/BackupPickerAdapter$BackupPickerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$e0;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "app_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes.dex */
    public static final class BackupPickerViewHolder extends RecyclerView.e0 {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BackupPickerViewHolder(View itemView) {
            super(itemView);
            m.g(itemView, "itemView");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BackupPickerAdapter(List<BackupPayload> backups, l<? super BackupPayload, x> onBackupClicked) {
        m.g(backups, "backups");
        m.g(onBackupClicked, "onBackupClicked");
        this.backups = backups;
        this.onBackupClicked = onBackupClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int getItemCount() {
        return this.backups.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public void onBindViewHolder(BackupPickerViewHolder holder, int i2) {
        m.g(holder, "holder");
        BackupPayload backupPayload = this.backups.get(i2);
        String string = holder.itemView.getContext().getString(R.string.prefixed_username, backupPayload.getUsername());
        m.f(string, "holder.itemView.context.getString(R.string.prefixed_username, backup.username)");
        ((TextView) holder.itemView.findViewById(a.backupName)).setText(string);
        View view = holder.itemView;
        m.f(view, "holder.itemView");
        View_CommonKt.setOnSingleClickListener$default(view, 0L, new BackupPickerAdapter$onBindViewHolder$1(this, backupPayload), 1, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public BackupPickerViewHolder onCreateViewHolder(ViewGroup parent, int i2) {
        m.g(parent, "parent");
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item__cloud_backup, parent, false);
        m.f(v, "v");
        return new BackupPickerViewHolder(v);
    }
}