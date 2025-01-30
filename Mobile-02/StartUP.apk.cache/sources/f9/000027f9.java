package com.coinbase.wallet.user.daos;

import com.coinbase.wallet.user.interfaces.UserDaoInterface;
import com.coinbase.wallet.user.models.LegacyUser;
import h.c.b0;
import h.c.c;
import java.util.List;
import kotlin.Metadata;

/* compiled from: UserDao.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0007\u0010\u0006J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\bH'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/coinbase/wallet/user/daos/UserDao;", "Lcom/coinbase/wallet/user/interfaces/UserDaoInterface;", "Lcom/coinbase/wallet/user/models/LegacyUser;", "legacyUser", "Lh/c/c;", "insert", "(Lcom/coinbase/wallet/user/models/LegacyUser;)Lh/c/c;", "delete", "Lh/c/b0;", "", "get", "()Lh/c/b0;", "user_productionRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public interface UserDao extends UserDaoInterface {
    @Override // com.coinbase.wallet.user.interfaces.UserDaoInterface
    c delete(LegacyUser legacyUser);

    @Override // com.coinbase.wallet.user.interfaces.UserDaoInterface
    b0<List<LegacyUser>> get();

    @Override // com.coinbase.wallet.user.interfaces.UserDaoInterface
    c insert(LegacyUser legacyUser);
}