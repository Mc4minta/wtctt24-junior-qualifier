package com.coinbase.wallet.wallets.db;

import android.database.Cursor;
import androidx.room.b;
import androidx.room.c;
import androidx.room.j;
import c.r.a.e;
import c.r.a.f;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.wallet.blockchains.dbconverters.AddressTypeConverter;
import com.coinbase.wallet.blockchains.dbconverters.BlockchainConverter;
import com.coinbase.wallet.blockchains.dbconverters.CurrencyCodeConverter;
import com.coinbase.wallet.blockchains.dbconverters.NetworkConverter;
import com.coinbase.wallet.blockchains.models.Address;
import com.coinbase.wallet.blockchains.models.AddressType;
import com.coinbase.wallet.blockchains.models.CurrencyCode;
import com.coinbase.wallet.blockchains.models.Network;
import com.coinbase.wallet.libraries.databases.converters.BigIntegerConverter;
import com.coinbase.wallet.routing.models.RouteActionKey;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class AddressRoomDao_Impl implements AddressRoomDao {
    private final j __db;
    private final b<Address> __deletionAdapterOfAddress;
    private final c<Address> __insertionAdapterOfAddress;
    private final c<Address> __insertionAdapterOfAddress_1;
    private final b<Address> __updateAdapterOfAddress;
    private final BigIntegerConverter __bigIntegerConverter = new BigIntegerConverter();
    private final CurrencyCodeConverter __currencyCodeConverter = new CurrencyCodeConverter();
    private final NetworkConverter __networkConverter = new NetworkConverter();
    private final AddressTypeConverter __addressTypeConverter = new AddressTypeConverter();
    private final BlockchainConverter __blockchainConverter = new BlockchainConverter();

    public AddressRoomDao_Impl(j jVar) {
        this.__db = jVar;
        this.__insertionAdapterOfAddress = new c<Address>(jVar) { // from class: com.coinbase.wallet.wallets.db.AddressRoomDao_Impl.1
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR ABORT INTO `Address` (`id`,`index`,`address`,`balance`,`currencyCode`,`isChangeAddress`,`network`,`type`,`derivationPath`,`isUsed`,`blockchain`,`contractAddress`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Address address) {
                if (address.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, address.getId());
                }
                fVar.b0(2, address.getIndex());
                if (address.getAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, address.getAddress());
                }
                String bigIntegerConverter = AddressRoomDao_Impl.this.__bigIntegerConverter.toString(address.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, bigIntegerConverter);
                }
                String currencyCodeConverter = AddressRoomDao_Impl.this.__currencyCodeConverter.toString(address.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                fVar.b0(6, address.isChangeAddress() ? 1L : 0L);
                String networkConverter = AddressRoomDao_Impl.this.__networkConverter.toString(address.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, networkConverter);
                }
                String addressTypeConverter = AddressRoomDao_Impl.this.__addressTypeConverter.toString(address.getType());
                if (addressTypeConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, addressTypeConverter);
                }
                if (address.getDerivationPath() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, address.getDerivationPath());
                }
                fVar.b0(10, address.isUsed() ? 1L : 0L);
                String blockchainConverter = AddressRoomDao_Impl.this.__blockchainConverter.toString(address.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, blockchainConverter);
                }
                if (address.getContractAddress() == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, address.getContractAddress());
                }
            }
        };
        this.__insertionAdapterOfAddress_1 = new c<Address>(jVar) { // from class: com.coinbase.wallet.wallets.db.AddressRoomDao_Impl.2
            @Override // androidx.room.q
            public String createQuery() {
                return "INSERT OR REPLACE INTO `Address` (`id`,`index`,`address`,`balance`,`currencyCode`,`isChangeAddress`,`network`,`type`,`derivationPath`,`isUsed`,`blockchain`,`contractAddress`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
            }

            @Override // androidx.room.c
            public void bind(f fVar, Address address) {
                if (address.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, address.getId());
                }
                fVar.b0(2, address.getIndex());
                if (address.getAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, address.getAddress());
                }
                String bigIntegerConverter = AddressRoomDao_Impl.this.__bigIntegerConverter.toString(address.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, bigIntegerConverter);
                }
                String currencyCodeConverter = AddressRoomDao_Impl.this.__currencyCodeConverter.toString(address.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                fVar.b0(6, address.isChangeAddress() ? 1L : 0L);
                String networkConverter = AddressRoomDao_Impl.this.__networkConverter.toString(address.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, networkConverter);
                }
                String addressTypeConverter = AddressRoomDao_Impl.this.__addressTypeConverter.toString(address.getType());
                if (addressTypeConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, addressTypeConverter);
                }
                if (address.getDerivationPath() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, address.getDerivationPath());
                }
                fVar.b0(10, address.isUsed() ? 1L : 0L);
                String blockchainConverter = AddressRoomDao_Impl.this.__blockchainConverter.toString(address.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, blockchainConverter);
                }
                if (address.getContractAddress() == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, address.getContractAddress());
                }
            }
        };
        this.__deletionAdapterOfAddress = new b<Address>(jVar) { // from class: com.coinbase.wallet.wallets.db.AddressRoomDao_Impl.3
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "DELETE FROM `Address` WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Address address) {
                if (address.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, address.getId());
                }
            }
        };
        this.__updateAdapterOfAddress = new b<Address>(jVar) { // from class: com.coinbase.wallet.wallets.db.AddressRoomDao_Impl.4
            @Override // androidx.room.b, androidx.room.q
            public String createQuery() {
                return "UPDATE OR ABORT `Address` SET `id` = ?,`index` = ?,`address` = ?,`balance` = ?,`currencyCode` = ?,`isChangeAddress` = ?,`network` = ?,`type` = ?,`derivationPath` = ?,`isUsed` = ?,`blockchain` = ?,`contractAddress` = ? WHERE `id` = ?";
            }

            @Override // androidx.room.b
            public void bind(f fVar, Address address) {
                if (address.getId() == null) {
                    fVar.B0(1);
                } else {
                    fVar.u(1, address.getId());
                }
                fVar.b0(2, address.getIndex());
                if (address.getAddress() == null) {
                    fVar.B0(3);
                } else {
                    fVar.u(3, address.getAddress());
                }
                String bigIntegerConverter = AddressRoomDao_Impl.this.__bigIntegerConverter.toString(address.getBalance());
                if (bigIntegerConverter == null) {
                    fVar.B0(4);
                } else {
                    fVar.u(4, bigIntegerConverter);
                }
                String currencyCodeConverter = AddressRoomDao_Impl.this.__currencyCodeConverter.toString(address.getCurrencyCode());
                if (currencyCodeConverter == null) {
                    fVar.B0(5);
                } else {
                    fVar.u(5, currencyCodeConverter);
                }
                fVar.b0(6, address.isChangeAddress() ? 1L : 0L);
                String networkConverter = AddressRoomDao_Impl.this.__networkConverter.toString(address.getNetwork());
                if (networkConverter == null) {
                    fVar.B0(7);
                } else {
                    fVar.u(7, networkConverter);
                }
                String addressTypeConverter = AddressRoomDao_Impl.this.__addressTypeConverter.toString(address.getType());
                if (addressTypeConverter == null) {
                    fVar.B0(8);
                } else {
                    fVar.u(8, addressTypeConverter);
                }
                if (address.getDerivationPath() == null) {
                    fVar.B0(9);
                } else {
                    fVar.u(9, address.getDerivationPath());
                }
                fVar.b0(10, address.isUsed() ? 1L : 0L);
                String blockchainConverter = AddressRoomDao_Impl.this.__blockchainConverter.toString(address.getBlockchain());
                if (blockchainConverter == null) {
                    fVar.B0(11);
                } else {
                    fVar.u(11, blockchainConverter);
                }
                if (address.getContractAddress() == null) {
                    fVar.B0(12);
                } else {
                    fVar.u(12, address.getContractAddress());
                }
                if (address.getId() == null) {
                    fVar.B0(13);
                } else {
                    fVar.u(13, address.getId());
                }
            }
        };
    }

    private Address __entityCursorConverter_comCoinbaseWalletBlockchainsModelsAddress(Cursor cursor) {
        boolean z;
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("index");
        int columnIndex3 = cursor.getColumnIndex("address");
        int columnIndex4 = cursor.getColumnIndex("balance");
        int columnIndex5 = cursor.getColumnIndex(AppsFlyerProperties.CURRENCY_CODE);
        int columnIndex6 = cursor.getColumnIndex("isChangeAddress");
        int columnIndex7 = cursor.getColumnIndex("network");
        int columnIndex8 = cursor.getColumnIndex("type");
        int columnIndex9 = cursor.getColumnIndex("derivationPath");
        int columnIndex10 = cursor.getColumnIndex("isUsed");
        int columnIndex11 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.BLOCKCHAIN);
        int columnIndex12 = cursor.getColumnIndex(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS);
        String string = columnIndex == -1 ? null : cursor.getString(columnIndex);
        boolean z2 = false;
        int i2 = columnIndex2 == -1 ? 0 : cursor.getInt(columnIndex2);
        String string2 = columnIndex3 == -1 ? null : cursor.getString(columnIndex3);
        BigInteger fromString = columnIndex4 == -1 ? null : this.__bigIntegerConverter.fromString(cursor.getString(columnIndex4));
        CurrencyCode fromString2 = columnIndex5 == -1 ? null : this.__currencyCodeConverter.fromString(cursor.getString(columnIndex5));
        if (columnIndex6 == -1) {
            z = false;
        } else {
            z = cursor.getInt(columnIndex6) != 0;
        }
        Network fromString3 = columnIndex7 == -1 ? null : this.__networkConverter.fromString(cursor.getString(columnIndex7));
        AddressType fromString4 = columnIndex8 == -1 ? null : this.__addressTypeConverter.fromString(cursor.getString(columnIndex8));
        String string3 = columnIndex9 == -1 ? null : cursor.getString(columnIndex9);
        if (columnIndex10 != -1 && cursor.getInt(columnIndex10) != 0) {
            z2 = true;
        }
        return new Address(string, i2, string2, fromString, fromString2, z, fromString3, fromString4, string3, z2, columnIndex11 == -1 ? null : this.__blockchainConverter.fromString(cursor.getString(columnIndex11)), columnIndex12 != -1 ? cursor.getString(columnIndex12) : null);
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void add(List<? extends Address> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAddress.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void addOrUpdate(List<? extends Address> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__insertionAdapterOfAddress_1.insert(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public List<Address> fetch(e eVar) {
        this.__db.assertNotSuspendingTransaction();
        Cursor b2 = androidx.room.t.c.b(this.__db, eVar, false, null);
        try {
            ArrayList arrayList = new ArrayList(b2.getCount());
            while (b2.moveToNext()) {
                arrayList.add(__entityCursorConverter_comCoinbaseWalletBlockchainsModelsAddress(b2));
            }
            return arrayList;
        } finally {
            b2.close();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void update(List<? extends Address> list) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__updateAdapterOfAddress.handleMultiple(list);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }

    @Override // com.coinbase.wallet.libraries.databases.interfaces.DatabaseDaoInterface
    public void delete(Address address) {
        this.__db.assertNotSuspendingTransaction();
        this.__db.beginTransaction();
        try {
            this.__deletionAdapterOfAddress.handle(address);
            this.__db.setTransactionSuccessful();
        } finally {
            this.__db.endTransaction();
        }
    }
}