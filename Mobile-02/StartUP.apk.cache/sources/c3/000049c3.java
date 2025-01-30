package e.j.i.i2;

import com.coinbase.wallet.core.util.Optional;
import com.coinbase.wallet.features.cloudbackup.models.BackupPayload;
import com.coinbase.wallet.features.cloudbackup.models.BackupStatus;
import com.google.api.services.drive.Drive;
import h.c.b0;
import h.c.s;
import java.util.List;
import kotlin.x;

/* compiled from: MnemonicBackupManaging.kt */
/* loaded from: classes2.dex */
public interface d {
    b0<List<BackupPayload>> a();

    b0<x> b(boolean z);

    h.c.c c(String str);

    boolean d();

    void destroy();

    void e(Drive drive);

    s<Optional<BackupStatus>> f();

    b0<Boolean> g(String str, String str2, String str3);

    b0<String> h(String str, BackupPayload backupPayload);

    void i(String str);

    void start();
}