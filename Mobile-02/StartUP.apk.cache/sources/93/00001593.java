package com.coinbase.wallet.consumer.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.consumer.models.ConsumerAvailablePaymentMethod;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class ConsumerAvailablePaymentMethodsRoomDAO_Impl implements ConsumerAvailablePaymentMethodsRoomDAO {
    private final j __db;
    private final b<ConsumerAvailablePaymentMethod> __deletionAdapterOfConsumerAvailablePaymentMethod;
    private final c<ConsumerAvailablePaymentMethod> __insertionAdapterOfConsumerAvailablePaymentMethod;
    private final c<ConsumerAvailablePaymentMethod> __insertionAdapterOfConsumerAvailablePaymentMethod_1;
    private final b<ConsumerAvailablePaymentMethod> __updateAdapterOfConsumerAvailablePaymentMethod;

    public ConsumerAvailablePaymentMethodsRoomDAO_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfConsumerAvailablePaymentMethod = new c<ConsumerAvailablePaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAvailablePaymentMethodsRoomDAO_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `availablePaymentMethods` (`id`,`type`,`name`,`description`,`additionalFees`,`buyingPower`,`buyTime`,`supportsBuy`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
                if (consumerAvailablePaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAvailablePaymentMethod.getId());
                }
                if (consumerAvailablePaymentMethod.getTypeString() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAvailablePaymentMethod.getTypeString());
                }
                if (consumerAvailablePaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerAvailablePaymentMethod.getName());
                }
                if (consumerAvailablePaymentMethod.getDescription() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, consumerAvailablePaymentMethod.getDescription());
                }
                if (consumerAvailablePaymentMethod.getAdditionalFees() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAvailablePaymentMethod.getAdditionalFees());
                }
                if (consumerAvailablePaymentMethod.getBuyingPower() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, consumerAvailablePaymentMethod.getBuyingPower());
                }
                if (consumerAvailablePaymentMethod.getBuyTime() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAvailablePaymentMethod.getBuyTime());
                }
                fVar.b0(8, consumerAvailablePaymentMethod.getSupportsBuy() ? 1L : 0L);
            }
        };
        this.__insertionAdapterOfConsumerAvailablePaymentMethod_1 = new c<ConsumerAvailablePaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAvailablePaymentMethodsRoomDAO_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `availablePaymentMethods` (`id`,`type`,`name`,`description`,`additionalFees`,`buyingPower`,`buyTime`,`supportsBuy`) VALUES (?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
                if (consumerAvailablePaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAvailablePaymentMethod.getId());
                }
                if (consumerAvailablePaymentMethod.getTypeString() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAvailablePaymentMethod.getTypeString());
                }
                if (consumerAvailablePaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerAvailablePaymentMethod.getName());
                }
                if (consumerAvailablePaymentMethod.getDescription() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, consumerAvailablePaymentMethod.getDescription());
                }
                if (consumerAvailablePaymentMethod.getAdditionalFees() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAvailablePaymentMethod.getAdditionalFees());
                }
                if (consumerAvailablePaymentMethod.getBuyingPower() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, consumerAvailablePaymentMethod.getBuyingPower());
                }
                if (consumerAvailablePaymentMethod.getBuyTime() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAvailablePaymentMethod.getBuyTime());
                }
                fVar.b0(8, consumerAvailablePaymentMethod.getSupportsBuy() ? 1L : 0L);
            }
        };
        this.__deletionAdapterOfConsumerAvailablePaymentMethod = new b<ConsumerAvailablePaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAvailablePaymentMethodsRoomDAO_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `availablePaymentMethods` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
                if (consumerAvailablePaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAvailablePaymentMethod.getId());
                }
            }
        };
        this.__updateAdapterOfConsumerAvailablePaymentMethod = new b<ConsumerAvailablePaymentMethod>(jVar) { // from class: com.coinbase.wallet.consumer.db.ConsumerAvailablePaymentMethodsRoomDAO_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `availablePaymentMethods` SET `id` = ?,`type` = ?,`name` = ?,`description` = ?,`additionalFees` = ?,`buyingPower` = ?,`buyTime` = ?,`supportsBuy` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
                if (consumerAvailablePaymentMethod.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, consumerAvailablePaymentMethod.getId());
                }
                if (consumerAvailablePaymentMethod.getTypeString() == null) {
                    fVar.B0(2);
                } else {
                    fVar.u(2, consumerAvailablePaymentMethod.getTypeString());
                }
                if (consumerAvailablePaymentMethod.getName() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, consumerAvailablePaymentMethod.getName());
                }
                if (consumerAvailablePaymentMethod.getDescription() == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, consumerAvailablePaymentMethod.getDescription());
                }
                if (consumerAvailablePaymentMethod.getAdditionalFees() == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, consumerAvailablePaymentMethod.getAdditionalFees());
                }
                if (consumerAvailablePaymentMethod.getBuyingPower() == null) {
                    fVar.B0(6);
                } else {
                    fVar.u(6, consumerAvailablePaymentMethod.getBuyingPower());
                }
                if (consumerAvailablePaymentMethod.getBuyTime() == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, consumerAvailablePaymentMethod.getBuyTime());
                }
                fVar.b0(8, consumerAvailablePaymentMethod.getSupportsBuy() ? 1L : 0L);
                if (consumerAvailablePaymentMethod.getId() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, consumerAvailablePaymentMethod.getId());
                }
            }
        };
    }

    private ConsumerAvailablePaymentMethod __entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerAvailablePaymentMethod(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("type");
        int columnIndex3 = cursor.getColumnIndex(ApiConstants.NAME);
        int columnIndex4 = cursor.getColumnIndex(ApiConstants.DESCRIPTION);
        int columnIndex5 = cursor.getColumnIndex("additionalFees");
        int columnIndex6 = cursor.getColumnIndex("buyingPower");
        int columnIndex7 = cursor.getColumnIndex("buyTime");
        int columnIndex8 = cursor.getColumnIndex("supportsBuy");
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        String string2 = columnIndex2 == -1 ? null : cursor.getString(columnIndex2);
        String string3 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        String string4 = columnIndex4 == -1 ? null : cursor.getString(columnIndex4);
        String string5 = columnIndex5 == -1 ? null : cursor.getString(columnIndex5);
        String string6 = columnIndex6 == -1 ? null : cursor.getString(columnIndex6);
        String string7 = columnIndex7 != -1 ? cursor.getString(columnIndex7) : null;
        boolean z = false;
        if (columnIndex8 != -1 && cursor.getInt(columnIndex8) != 0) {
            z = true;
        }
        return new ConsumerAvailablePaymentMethod(string, string2, string3, string4, string5, string6, string7, z);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends ConsumerAvailablePaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerAvailablePaymentMethod.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends ConsumerAvailablePaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfConsumerAvailablePaymentMethod_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<ConsumerAvailablePaymentMethod> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletConsumerModelsConsumerAvailablePaymentMethod(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends ConsumerAvailablePaymentMethod> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfConsumerAvailablePaymentMethod.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(ConsumerAvailablePaymentMethod consumerAvailablePaymentMethod) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfConsumerAvailablePaymentMethod.handle(consumerAvailablePaymentMethod);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}