package com.coinbase.wallet.wallets.db;

import androidx.room.a;
import androidx.room.g;
import androidx.room.j;
import androidx.room.l;
import androidx.room.t.f;
import c.r.a.b;
import c.r.a.c;
import com.appsflyer.AppsFlyerProperties;
import com.coinbase.ApiConstants;
import com.coinbase.wallet.features.send.models.AdjustableMinerFeeArgs;
import com.coinbase.wallet.routing.models.RouteActionKey;
import com.coinbase.wallet.routing.models.SendDestinationPickerArgs;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: classes2.dex */
public final class WalletsDatabase_Impl extends WalletsDatabase {
    private volatile AddressRoomDao _addressRoomDao;
    private volatile BIP44SignedTxRoomDao _bIP44SignedTxRoomDao;
    private volatile CoinRoomDao _coinRoomDao;
    private volatile CompoundTokenRoomDao _compoundTokenRoomDao;
    private volatile CryptoCurrencyRoomDao _cryptoCurrencyRoomDao;
    private volatile ERC20RoomDao _eRC20RoomDao;
    private volatile EthereumSignedTxRoomDao _ethereumSignedTxRoomDao;
    private volatile FiatCurrencyRoomDao _fiatCurrencyRoomDao;
    private volatile FiatExchangeRateRoomDao _fiatExchangeRateRoomDao;
    private volatile StellarSignedTxRoomDao _stellarSignedTxRoomDao;
    private volatile XRPSignedTxRoomDao _xRPSignedTxRoomDao;

    @Override // androidx.room.j
    public void clearAllTables() {
        super.assertNotMainThread();
        b b2 = super.getOpenHelper().b();
        try {
            super.beginTransaction();
            b2.t("DELETE FROM `Wallet`");
            b2.t("DELETE FROM `Address`");
            b2.t("DELETE FROM `EthereumSignedTx`");
            b2.t("DELETE FROM `StellarSignedTx`");
            b2.t("DELETE FROM `XRPSignedTx`");
            b2.t("DELETE FROM `BIP44SignedTx`");
            b2.t("DELETE FROM `ERC20`");
            b2.t("DELETE FROM `CompoundToken`");
            b2.t("DELETE FROM `CryptoCurrency`");
            b2.t("DELETE FROM `FiatCurrency`");
            b2.t("DELETE FROM `ExchangeRate`");
            super.setTransactionSuccessful();
        } finally {
            super.endTransaction();
            b2.i0("PRAGMA wal_checkpoint(FULL)").close();
            if (!b2.F0()) {
                b2.t("VACUUM");
            }
        }
    }

    @Override // androidx.room.j
    protected g createInvalidationTracker() {
        return new g(this, new HashMap(0), new HashMap(0), SendDestinationPickerArgs.WALLET, SendDestinationPickerArgs.ADDRESS, "EthereumSignedTx", "StellarSignedTx", "XRPSignedTx", "BIP44SignedTx", "ERC20", "CompoundToken", "CryptoCurrency", "FiatCurrency", "ExchangeRate");
    }

    @Override // androidx.room.j
    protected c createOpenHelper(a aVar) {
        return aVar.a.a(c.b.a(aVar.f2221b).c(aVar.f2222c).b(new l(aVar, new l.a(7) { // from class: com.coinbase.wallet.wallets.db.WalletsDatabase_Impl.1
            @Override // androidx.room.l.a
            public void createAllTables(b bVar) {
                bVar.t("CREATE TABLE IF NOT EXISTS `Wallet` (`id` TEXT NOT NULL COLLATE NOCASE, `primaryAddress` TEXT NOT NULL COLLATE NOCASE, `addresses` TEXT NOT NULL, `displayName` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `contractAddress` TEXT COLLATE NOCASE, `imageURL` TEXT, `balance` TEXT NOT NULL, `decimals` INTEGER NOT NULL, `blockchain` TEXT NOT NULL, `minimumBalance` TEXT, `network` TEXT NOT NULL, `selectedIndex` INTEGER, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_Wallet_blockchain_currencyCode_network_contractAddress_selectedIndex` ON `Wallet` (`blockchain`, `currencyCode`, `network`, `contractAddress`, `selectedIndex`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `Address` (`id` TEXT NOT NULL COLLATE NOCASE, `index` INTEGER NOT NULL, `address` TEXT NOT NULL COLLATE NOCASE, `balance` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `isChangeAddress` INTEGER NOT NULL, `network` TEXT NOT NULL, `type` TEXT NOT NULL COLLATE NOCASE, `derivationPath` TEXT NOT NULL, `isUsed` INTEGER NOT NULL, `blockchain` TEXT NOT NULL, `contractAddress` TEXT, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_Address_blockchain_currencyCode_contractAddress_network_type_isChangeAddress_index` ON `Address` (`blockchain`, `currencyCode`, `contractAddress`, `network`, `type`, `isChangeAddress`, `index`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_Address_blockchain_currencyCode_network_type_isChangeAddress_isUsed` ON `Address` (`blockchain`, `currencyCode`, `network`, `type`, `isChangeAddress`, `isUsed`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_Address_blockchain_currencyCode_network_balance` ON `Address` (`blockchain`, `currencyCode`, `network`, `balance`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_Address_blockchain_currencyCode_address_network` ON `Address` (`blockchain`, `currencyCode`, `address`, `network`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_Address_blockchain_address_network` ON `Address` (`blockchain`, `address`, `network`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `EthereumSignedTx` (`id` TEXT NOT NULL COLLATE NOCASE, `fromAddress` TEXT NOT NULL COLLATE NOCASE, `toAddress` TEXT COLLATE NOCASE, `nonce` INTEGER NOT NULL, `chainId` INTEGER NOT NULL, `signedTxData` BLOB NOT NULL, `txHash` TEXT NOT NULL, `weiValue` TEXT NOT NULL, `erc20Value` TEXT, `blockchain` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `state` INTEGER NOT NULL, `notFoundCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_EthereumSignedTx_state_chainId` ON `EthereumSignedTx` (`state`, `chainId`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_EthereumSignedTx_chainId_fromAddress_nonce` ON `EthereumSignedTx` (`chainId`, `fromAddress`, `nonce`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_EthereumSignedTx_chainId_nonce_fromAddress_currencyCode_state` ON `EthereumSignedTx` (`chainId`, `nonce`, `fromAddress`, `currencyCode`, `state`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_EthereumSignedTx_chainId_nonce_fromAddress_toAddress_state` ON `EthereumSignedTx` (`chainId`, `nonce`, `fromAddress`, `toAddress`, `state`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `StellarSignedTx` (`id` TEXT NOT NULL COLLATE NOCASE, `signedTransactionData` BLOB NOT NULL, `txHash` TEXT NOT NULL COLLATE NOCASE, `network` TEXT NOT NULL, `validBefore` INTEGER NOT NULL, `state` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_StellarSignedTx_state_network` ON `StellarSignedTx` (`state`, `network`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_StellarSignedTx_network` ON `StellarSignedTx` (`network`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `XRPSignedTx` (`id` TEXT NOT NULL COLLATE NOCASE, `signedTxData` BLOB NOT NULL, `network` TEXT NOT NULL, `maxLedgerVersion` INTEGER NOT NULL, `state` INTEGER NOT NULL, `transferValue` TEXT NOT NULL, `txHash` TEXT NOT NULL COLLATE NOCASE, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_XRPSignedTx_state_network` ON `XRPSignedTx` (`state`, `network`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_XRPSignedTx_network` ON `XRPSignedTx` (`network`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `BIP44SignedTx` (`id` TEXT NOT NULL COLLATE NOCASE, `signedTxData` BLOB NOT NULL, `txHash` TEXT NOT NULL, `network` TEXT NOT NULL, `currencyCode` TEXT NOT NULL COLLATE NOCASE, `blockchain` TEXT NOT NULL COLLATE NOCASE, `state` INTEGER NOT NULL, `notFoundCount` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_BIP44SignedTx_blockchain_currencyCode_network_state` ON `BIP44SignedTx` (`blockchain`, `currencyCode`, `network`, `state`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `ERC20` (`id` TEXT NOT NULL COLLATE NOCASE, `name` TEXT NOT NULL, `decimals` INTEGER NOT NULL, `contractAddress` TEXT NOT NULL COLLATE NOCASE, `chainId` INTEGER NOT NULL, `currencyCode` TEXT NOT NULL, `blockchain` TEXT NOT NULL, `imageURL` TEXT, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_ERC20_contractAddress_chainId` ON `ERC20` (`contractAddress`, `chainId`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `CompoundToken` (`id` TEXT NOT NULL COLLATE NOCASE, `name` TEXT NOT NULL, `code` TEXT NOT NULL COLLATE NOCASE, `decimals` INTEGER NOT NULL, `contractAddress` TEXT NOT NULL COLLATE NOCASE, `underlyingCode` TEXT NOT NULL COLLATE NOCASE, `underlyingContractAddress` TEXT COLLATE NOCASE, `underlyingDecimals` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE TABLE IF NOT EXISTS `CryptoCurrency` (`id` TEXT NOT NULL, `code` TEXT NOT NULL, `name` TEXT NOT NULL, `imageUrl` TEXT, `decimals` INTEGER NOT NULL, `blockchain` TEXT NOT NULL, `sortIndex` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_CryptoCurrency_blockchain_code` ON `CryptoCurrency` (`blockchain`, `code`)");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_CryptoCurrency_sortIndex` ON `CryptoCurrency` (`sortIndex`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `FiatCurrency` (`id` TEXT NOT NULL, `code` TEXT NOT NULL COLLATE NOCASE, `name` TEXT NOT NULL, `decimals` INTEGER NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE UNIQUE INDEX IF NOT EXISTS `index_FiatCurrency_code` ON `FiatCurrency` (`code`)");
                bVar.t("CREATE TABLE IF NOT EXISTS `ExchangeRate` (`id` TEXT NOT NULL, `currencyCode` TEXT NOT NULL, `rate` TEXT NOT NULL, `contractAddress` TEXT, `chainId` INTEGER, `name` TEXT NOT NULL, PRIMARY KEY(`id`))");
                bVar.t("CREATE INDEX IF NOT EXISTS `index_ExchangeRate_currencyCode` ON `ExchangeRate` (`currencyCode`)");
                bVar.t("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
                bVar.t("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '6bedd8958f6e7d2d2c2c915f3cc0b708')");
            }

            @Override // androidx.room.l.a
            public void dropAllTables(b bVar) {
                bVar.t("DROP TABLE IF EXISTS `Wallet`");
                bVar.t("DROP TABLE IF EXISTS `Address`");
                bVar.t("DROP TABLE IF EXISTS `EthereumSignedTx`");
                bVar.t("DROP TABLE IF EXISTS `StellarSignedTx`");
                bVar.t("DROP TABLE IF EXISTS `XRPSignedTx`");
                bVar.t("DROP TABLE IF EXISTS `BIP44SignedTx`");
                bVar.t("DROP TABLE IF EXISTS `ERC20`");
                bVar.t("DROP TABLE IF EXISTS `CompoundToken`");
                bVar.t("DROP TABLE IF EXISTS `CryptoCurrency`");
                bVar.t("DROP TABLE IF EXISTS `FiatCurrency`");
                bVar.t("DROP TABLE IF EXISTS `ExchangeRate`");
                if (((j) WalletsDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) WalletsDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) WalletsDatabase_Impl.this).mCallbacks.get(i2)).b(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            protected void onCreate(b bVar) {
                if (((j) WalletsDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) WalletsDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) WalletsDatabase_Impl.this).mCallbacks.get(i2)).a(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onOpen(b bVar) {
                ((j) WalletsDatabase_Impl.this).mDatabase = bVar;
                WalletsDatabase_Impl.this.internalInitInvalidationTracker(bVar);
                if (((j) WalletsDatabase_Impl.this).mCallbacks != null) {
                    int size = ((j) WalletsDatabase_Impl.this).mCallbacks.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        ((j.b) ((j) WalletsDatabase_Impl.this).mCallbacks.get(i2)).c(bVar);
                    }
                }
            }

            @Override // androidx.room.l.a
            public void onPostMigrate(b bVar) {
            }

            @Override // androidx.room.l.a
            public void onPreMigrate(b bVar) {
                androidx.room.t.c.a(bVar);
            }

            @Override // androidx.room.l.a
            protected l.b onValidateSchema(b bVar) {
                HashMap hashMap = new HashMap(13);
                hashMap.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap.put("primaryAddress", new f.a("primaryAddress", "TEXT", true, 0, null, 1));
                hashMap.put(ApiConstants.ADDRESSES, new f.a(ApiConstants.ADDRESSES, "TEXT", true, 0, null, 1));
                hashMap.put("displayName", new f.a("displayName", "TEXT", true, 0, null, 1));
                hashMap.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", false, 0, null, 1));
                hashMap.put("imageURL", new f.a("imageURL", "TEXT", false, 0, null, 1));
                hashMap.put("balance", new f.a("balance", "TEXT", true, 0, null, 1));
                hashMap.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap.put("minimumBalance", new f.a("minimumBalance", "TEXT", false, 0, null, 1));
                hashMap.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap.put("selectedIndex", new f.a("selectedIndex", "INTEGER", false, 0, null, 1));
                HashSet hashSet = new HashSet(0);
                HashSet hashSet2 = new HashSet(1);
                hashSet2.add(new f.d("index_Wallet_blockchain_currencyCode_network_contractAddress_selectedIndex", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "selectedIndex")));
                f fVar = new f(SendDestinationPickerArgs.WALLET, hashMap, hashSet, hashSet2);
                f a = f.a(bVar, SendDestinationPickerArgs.WALLET);
                if (!fVar.equals(a)) {
                    return new l.b(false, "Wallet(com.coinbase.wallet.blockchains.models.Wallet).\n Expected:\n" + fVar + "\n Found:\n" + a);
                }
                HashMap hashMap2 = new HashMap(12);
                hashMap2.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap2.put("index", new f.a("index", "INTEGER", true, 0, null, 1));
                hashMap2.put("address", new f.a("address", "TEXT", true, 0, null, 1));
                hashMap2.put("balance", new f.a("balance", "TEXT", true, 0, null, 1));
                hashMap2.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap2.put("isChangeAddress", new f.a("isChangeAddress", "INTEGER", true, 0, null, 1));
                hashMap2.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap2.put("type", new f.a("type", "TEXT", true, 0, null, 1));
                hashMap2.put("derivationPath", new f.a("derivationPath", "TEXT", true, 0, null, 1));
                hashMap2.put("isUsed", new f.a("isUsed", "INTEGER", true, 0, null, 1));
                hashMap2.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap2.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", false, 0, null, 1));
                HashSet hashSet3 = new HashSet(0);
                HashSet hashSet4 = new HashSet(5);
                hashSet4.add(new f.d("index_Address_blockchain_currencyCode_contractAddress_network_type_isChangeAddress_index", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "network", "type", "isChangeAddress", "index")));
                hashSet4.add(new f.d("index_Address_blockchain_currencyCode_network_type_isChangeAddress_isUsed", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "type", "isChangeAddress", "isUsed")));
                hashSet4.add(new f.d("index_Address_blockchain_currencyCode_network_balance", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", "balance")));
                hashSet4.add(new f.d("index_Address_blockchain_currencyCode_address_network", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "address", "network")));
                hashSet4.add(new f.d("index_Address_blockchain_address_network", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "address", "network")));
                f fVar2 = new f(SendDestinationPickerArgs.ADDRESS, hashMap2, hashSet3, hashSet4);
                f a2 = f.a(bVar, SendDestinationPickerArgs.ADDRESS);
                if (!fVar2.equals(a2)) {
                    return new l.b(false, "Address(com.coinbase.wallet.blockchains.models.Address).\n Expected:\n" + fVar2 + "\n Found:\n" + a2);
                }
                HashMap hashMap3 = new HashMap(13);
                hashMap3.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap3.put("fromAddress", new f.a("fromAddress", "TEXT", true, 0, null, 1));
                hashMap3.put("toAddress", new f.a("toAddress", "TEXT", false, 0, null, 1));
                hashMap3.put(AdjustableMinerFeeArgs.NONCE, new f.a(AdjustableMinerFeeArgs.NONCE, "INTEGER", true, 0, null, 1));
                hashMap3.put(RouteActionKey.RouteActionKeys.CHAIN_ID, new f.a(RouteActionKey.RouteActionKeys.CHAIN_ID, "INTEGER", true, 0, null, 1));
                hashMap3.put("signedTxData", new f.a("signedTxData", "BLOB", true, 0, null, 1));
                hashMap3.put("txHash", new f.a("txHash", "TEXT", true, 0, null, 1));
                hashMap3.put("weiValue", new f.a("weiValue", "TEXT", true, 0, null, 1));
                hashMap3.put("erc20Value", new f.a("erc20Value", "TEXT", false, 0, null, 1));
                hashMap3.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap3.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap3.put(ApiConstants.STATE, new f.a(ApiConstants.STATE, "INTEGER", true, 0, null, 1));
                hashMap3.put("notFoundCount", new f.a("notFoundCount", "INTEGER", true, 0, null, 1));
                HashSet hashSet5 = new HashSet(0);
                HashSet hashSet6 = new HashSet(4);
                hashSet6.add(new f.d("index_EthereumSignedTx_state_chainId", false, Arrays.asList(ApiConstants.STATE, RouteActionKey.RouteActionKeys.CHAIN_ID)));
                hashSet6.add(new f.d("index_EthereumSignedTx_chainId_fromAddress_nonce", false, Arrays.asList(RouteActionKey.RouteActionKeys.CHAIN_ID, "fromAddress", AdjustableMinerFeeArgs.NONCE)));
                hashSet6.add(new f.d("index_EthereumSignedTx_chainId_nonce_fromAddress_currencyCode_state", false, Arrays.asList(RouteActionKey.RouteActionKeys.CHAIN_ID, AdjustableMinerFeeArgs.NONCE, "fromAddress", AppsFlyerProperties.CURRENCY_CODE, ApiConstants.STATE)));
                hashSet6.add(new f.d("index_EthereumSignedTx_chainId_nonce_fromAddress_toAddress_state", false, Arrays.asList(RouteActionKey.RouteActionKeys.CHAIN_ID, AdjustableMinerFeeArgs.NONCE, "fromAddress", "toAddress", ApiConstants.STATE)));
                f fVar3 = new f("EthereumSignedTx", hashMap3, hashSet5, hashSet6);
                f a3 = f.a(bVar, "EthereumSignedTx");
                if (!fVar3.equals(a3)) {
                    return new l.b(false, "EthereumSignedTx(com.coinbase.wallet.ethereum.models.EthereumSignedTx).\n Expected:\n" + fVar3 + "\n Found:\n" + a3);
                }
                HashMap hashMap4 = new HashMap(6);
                hashMap4.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap4.put("signedTransactionData", new f.a("signedTransactionData", "BLOB", true, 0, null, 1));
                hashMap4.put("txHash", new f.a("txHash", "TEXT", true, 0, null, 1));
                hashMap4.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap4.put("validBefore", new f.a("validBefore", "INTEGER", true, 0, null, 1));
                hashMap4.put(ApiConstants.STATE, new f.a(ApiConstants.STATE, "INTEGER", true, 0, null, 1));
                HashSet hashSet7 = new HashSet(0);
                HashSet hashSet8 = new HashSet(2);
                hashSet8.add(new f.d("index_StellarSignedTx_state_network", false, Arrays.asList(ApiConstants.STATE, "network")));
                hashSet8.add(new f.d("index_StellarSignedTx_network", false, Arrays.asList("network")));
                f fVar4 = new f("StellarSignedTx", hashMap4, hashSet7, hashSet8);
                f a4 = f.a(bVar, "StellarSignedTx");
                if (!fVar4.equals(a4)) {
                    return new l.b(false, "StellarSignedTx(com.coinbase.wallet.stellar.models.StellarSignedTx).\n Expected:\n" + fVar4 + "\n Found:\n" + a4);
                }
                HashMap hashMap5 = new HashMap(7);
                hashMap5.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap5.put("signedTxData", new f.a("signedTxData", "BLOB", true, 0, null, 1));
                hashMap5.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap5.put("maxLedgerVersion", new f.a("maxLedgerVersion", "INTEGER", true, 0, null, 1));
                hashMap5.put(ApiConstants.STATE, new f.a(ApiConstants.STATE, "INTEGER", true, 0, null, 1));
                hashMap5.put("transferValue", new f.a("transferValue", "TEXT", true, 0, null, 1));
                hashMap5.put("txHash", new f.a("txHash", "TEXT", true, 0, null, 1));
                HashSet hashSet9 = new HashSet(0);
                HashSet hashSet10 = new HashSet(2);
                hashSet10.add(new f.d("index_XRPSignedTx_state_network", false, Arrays.asList(ApiConstants.STATE, "network")));
                hashSet10.add(new f.d("index_XRPSignedTx_network", false, Arrays.asList("network")));
                f fVar5 = new f("XRPSignedTx", hashMap5, hashSet9, hashSet10);
                f a5 = f.a(bVar, "XRPSignedTx");
                if (!fVar5.equals(a5)) {
                    return new l.b(false, "XRPSignedTx(com.coinbase.wallet.ripple.models.XRPSignedTx).\n Expected:\n" + fVar5 + "\n Found:\n" + a5);
                }
                HashMap hashMap6 = new HashMap(8);
                hashMap6.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap6.put("signedTxData", new f.a("signedTxData", "BLOB", true, 0, null, 1));
                hashMap6.put("txHash", new f.a("txHash", "TEXT", true, 0, null, 1));
                hashMap6.put("network", new f.a("network", "TEXT", true, 0, null, 1));
                hashMap6.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap6.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap6.put(ApiConstants.STATE, new f.a(ApiConstants.STATE, "INTEGER", true, 0, null, 1));
                hashMap6.put("notFoundCount", new f.a("notFoundCount", "INTEGER", true, 0, null, 1));
                HashSet hashSet11 = new HashSet(0);
                HashSet hashSet12 = new HashSet(1);
                hashSet12.add(new f.d("index_BIP44SignedTx_blockchain_currencyCode_network_state", false, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, AppsFlyerProperties.CURRENCY_CODE, "network", ApiConstants.STATE)));
                f fVar6 = new f("BIP44SignedTx", hashMap6, hashSet11, hashSet12);
                f a6 = f.a(bVar, "BIP44SignedTx");
                if (!fVar6.equals(a6)) {
                    return new l.b(false, "BIP44SignedTx(com.coinbase.wallet.bip44wallets.models.BIP44SignedTx).\n Expected:\n" + fVar6 + "\n Found:\n" + a6);
                }
                HashMap hashMap7 = new HashMap(8);
                hashMap7.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap7.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap7.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap7.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", true, 0, null, 1));
                hashMap7.put(RouteActionKey.RouteActionKeys.CHAIN_ID, new f.a(RouteActionKey.RouteActionKeys.CHAIN_ID, "INTEGER", true, 0, null, 1));
                hashMap7.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap7.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap7.put("imageURL", new f.a("imageURL", "TEXT", false, 0, null, 1));
                HashSet hashSet13 = new HashSet(0);
                HashSet hashSet14 = new HashSet(1);
                hashSet14.add(new f.d("index_ERC20_contractAddress_chainId", false, Arrays.asList(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, RouteActionKey.RouteActionKeys.CHAIN_ID)));
                f fVar7 = new f("ERC20", hashMap7, hashSet13, hashSet14);
                f a7 = f.a(bVar, "ERC20");
                if (!fVar7.equals(a7)) {
                    return new l.b(false, "ERC20(com.coinbase.wallet.ethereum.models.ERC20).\n Expected:\n" + fVar7 + "\n Found:\n" + a7);
                }
                HashMap hashMap8 = new HashMap(8);
                hashMap8.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap8.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap8.put("code", new f.a("code", "TEXT", true, 0, null, 1));
                hashMap8.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap8.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", true, 0, null, 1));
                hashMap8.put("underlyingCode", new f.a("underlyingCode", "TEXT", true, 0, null, 1));
                hashMap8.put("underlyingContractAddress", new f.a("underlyingContractAddress", "TEXT", false, 0, null, 1));
                hashMap8.put("underlyingDecimals", new f.a("underlyingDecimals", "INTEGER", true, 0, null, 1));
                f fVar8 = new f("CompoundToken", hashMap8, new HashSet(0), new HashSet(0));
                f a8 = f.a(bVar, "CompoundToken");
                if (!fVar8.equals(a8)) {
                    return new l.b(false, "CompoundToken(com.coinbase.wallet.compoundfinance.models.CompoundToken).\n Expected:\n" + fVar8 + "\n Found:\n" + a8);
                }
                HashMap hashMap9 = new HashMap(7);
                hashMap9.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap9.put("code", new f.a("code", "TEXT", true, 0, null, 1));
                hashMap9.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap9.put("imageUrl", new f.a("imageUrl", "TEXT", false, 0, null, 1));
                hashMap9.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                hashMap9.put(RouteActionKey.RouteActionKeys.BLOCKCHAIN, new f.a(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "TEXT", true, 0, null, 1));
                hashMap9.put("sortIndex", new f.a("sortIndex", "INTEGER", true, 0, null, 1));
                HashSet hashSet15 = new HashSet(0);
                HashSet hashSet16 = new HashSet(2);
                hashSet16.add(new f.d("index_CryptoCurrency_blockchain_code", true, Arrays.asList(RouteActionKey.RouteActionKeys.BLOCKCHAIN, "code")));
                hashSet16.add(new f.d("index_CryptoCurrency_sortIndex", false, Arrays.asList("sortIndex")));
                f fVar9 = new f("CryptoCurrency", hashMap9, hashSet15, hashSet16);
                f a9 = f.a(bVar, "CryptoCurrency");
                if (!fVar9.equals(a9)) {
                    return new l.b(false, "CryptoCurrency(com.coinbase.wallet.wallets.models.CryptoCurrency).\n Expected:\n" + fVar9 + "\n Found:\n" + a9);
                }
                HashMap hashMap10 = new HashMap(4);
                hashMap10.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap10.put("code", new f.a("code", "TEXT", true, 0, null, 1));
                hashMap10.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                hashMap10.put("decimals", new f.a("decimals", "INTEGER", true, 0, null, 1));
                HashSet hashSet17 = new HashSet(0);
                HashSet hashSet18 = new HashSet(1);
                hashSet18.add(new f.d("index_FiatCurrency_code", true, Arrays.asList("code")));
                f fVar10 = new f("FiatCurrency", hashMap10, hashSet17, hashSet18);
                f a10 = f.a(bVar, "FiatCurrency");
                if (!fVar10.equals(a10)) {
                    return new l.b(false, "FiatCurrency(com.coinbase.wallet.wallets.models.FiatCurrency).\n Expected:\n" + fVar10 + "\n Found:\n" + a10);
                }
                HashMap hashMap11 = new HashMap(6);
                hashMap11.put("id", new f.a("id", "TEXT", true, 1, null, 1));
                hashMap11.put(AppsFlyerProperties.CURRENCY_CODE, new f.a(AppsFlyerProperties.CURRENCY_CODE, "TEXT", true, 0, null, 1));
                hashMap11.put("rate", new f.a("rate", "TEXT", true, 0, null, 1));
                hashMap11.put(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, new f.a(RouteActionKey.RouteActionKeys.CONTRACT_ADDRESS, "TEXT", false, 0, null, 1));
                hashMap11.put(RouteActionKey.RouteActionKeys.CHAIN_ID, new f.a(RouteActionKey.RouteActionKeys.CHAIN_ID, "INTEGER", false, 0, null, 1));
                hashMap11.put(ApiConstants.NAME, new f.a(ApiConstants.NAME, "TEXT", true, 0, null, 1));
                HashSet hashSet19 = new HashSet(0);
                HashSet hashSet20 = new HashSet(1);
                hashSet20.add(new f.d("index_ExchangeRate_currencyCode", false, Arrays.asList(AppsFlyerProperties.CURRENCY_CODE)));
                f fVar11 = new f("ExchangeRate", hashMap11, hashSet19, hashSet20);
                f a11 = f.a(bVar, "ExchangeRate");
                if (!fVar11.equals(a11)) {
                    return new l.b(false, "ExchangeRate(com.coinbase.wallet.wallets.models.ExchangeRate).\n Expected:\n" + fVar11 + "\n Found:\n" + a11);
                }
                return new l.b(true, null);
            }
        }, "6bedd8958f6e7d2d2c2c915f3cc0b708", "9d0444b55c9b4f23e0b6d8cf78434a78")).a());
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public AddressRoomDao getAddressDao() {
        AddressRoomDao addressRoomDao;
        if (this._addressRoomDao != null) {
            return this._addressRoomDao;
        }
        synchronized (this) {
            if (this._addressRoomDao == null) {
                this._addressRoomDao = new AddressRoomDao_Impl(this);
            }
            addressRoomDao = this._addressRoomDao;
        }
        return addressRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public BIP44SignedTxRoomDao getBip44SignedTxDao() {
        BIP44SignedTxRoomDao bIP44SignedTxRoomDao;
        if (this._bIP44SignedTxRoomDao != null) {
            return this._bIP44SignedTxRoomDao;
        }
        synchronized (this) {
            if (this._bIP44SignedTxRoomDao == null) {
                this._bIP44SignedTxRoomDao = new BIP44SignedTxRoomDao_Impl(this);
            }
            bIP44SignedTxRoomDao = this._bIP44SignedTxRoomDao;
        }
        return bIP44SignedTxRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public CoinRoomDao getCoinDao() {
        CoinRoomDao coinRoomDao;
        if (this._coinRoomDao != null) {
            return this._coinRoomDao;
        }
        synchronized (this) {
            if (this._coinRoomDao == null) {
                this._coinRoomDao = new CoinRoomDao_Impl(this);
            }
            coinRoomDao = this._coinRoomDao;
        }
        return coinRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public CompoundTokenRoomDao getCompoundTokenRoomDao() {
        CompoundTokenRoomDao compoundTokenRoomDao;
        if (this._compoundTokenRoomDao != null) {
            return this._compoundTokenRoomDao;
        }
        synchronized (this) {
            if (this._compoundTokenRoomDao == null) {
                this._compoundTokenRoomDao = new CompoundTokenRoomDao_Impl(this);
            }
            compoundTokenRoomDao = this._compoundTokenRoomDao;
        }
        return compoundTokenRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public CryptoCurrencyRoomDao getCryptoCurrencyRoomDao() {
        CryptoCurrencyRoomDao cryptoCurrencyRoomDao;
        if (this._cryptoCurrencyRoomDao != null) {
            return this._cryptoCurrencyRoomDao;
        }
        synchronized (this) {
            if (this._cryptoCurrencyRoomDao == null) {
                this._cryptoCurrencyRoomDao = new CryptoCurrencyRoomDao_Impl(this);
            }
            cryptoCurrencyRoomDao = this._cryptoCurrencyRoomDao;
        }
        return cryptoCurrencyRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public ERC20RoomDao getErc20RoomDao() {
        ERC20RoomDao eRC20RoomDao;
        if (this._eRC20RoomDao != null) {
            return this._eRC20RoomDao;
        }
        synchronized (this) {
            if (this._eRC20RoomDao == null) {
                this._eRC20RoomDao = new ERC20RoomDao_Impl(this);
            }
            eRC20RoomDao = this._eRC20RoomDao;
        }
        return eRC20RoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public EthereumSignedTxRoomDao getEthereumSignedTxDao() {
        EthereumSignedTxRoomDao ethereumSignedTxRoomDao;
        if (this._ethereumSignedTxRoomDao != null) {
            return this._ethereumSignedTxRoomDao;
        }
        synchronized (this) {
            if (this._ethereumSignedTxRoomDao == null) {
                this._ethereumSignedTxRoomDao = new EthereumSignedTxRoomDao_Impl(this);
            }
            ethereumSignedTxRoomDao = this._ethereumSignedTxRoomDao;
        }
        return ethereumSignedTxRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public FiatCurrencyRoomDao getFiatCurrencyRoomDao() {
        FiatCurrencyRoomDao fiatCurrencyRoomDao;
        if (this._fiatCurrencyRoomDao != null) {
            return this._fiatCurrencyRoomDao;
        }
        synchronized (this) {
            if (this._fiatCurrencyRoomDao == null) {
                this._fiatCurrencyRoomDao = new FiatCurrencyRoomDao_Impl(this);
            }
            fiatCurrencyRoomDao = this._fiatCurrencyRoomDao;
        }
        return fiatCurrencyRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public FiatExchangeRateRoomDao getFiatExchangeRateRoomDao() {
        FiatExchangeRateRoomDao fiatExchangeRateRoomDao;
        if (this._fiatExchangeRateRoomDao != null) {
            return this._fiatExchangeRateRoomDao;
        }
        synchronized (this) {
            if (this._fiatExchangeRateRoomDao == null) {
                this._fiatExchangeRateRoomDao = new FiatExchangeRateRoomDao_Impl(this);
            }
            fiatExchangeRateRoomDao = this._fiatExchangeRateRoomDao;
        }
        return fiatExchangeRateRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public StellarSignedTxRoomDao getStellarSignedTxDao() {
        StellarSignedTxRoomDao stellarSignedTxRoomDao;
        if (this._stellarSignedTxRoomDao != null) {
            return this._stellarSignedTxRoomDao;
        }
        synchronized (this) {
            if (this._stellarSignedTxRoomDao == null) {
                this._stellarSignedTxRoomDao = new StellarSignedTxRoomDao_Impl(this);
            }
            stellarSignedTxRoomDao = this._stellarSignedTxRoomDao;
        }
        return stellarSignedTxRoomDao;
    }

    @Override // com.coinbase.wallet.wallets.db.WalletsDatabase
    public XRPSignedTxRoomDao getXrpSignedTxDao() {
        XRPSignedTxRoomDao xRPSignedTxRoomDao;
        if (this._xRPSignedTxRoomDao != null) {
            return this._xRPSignedTxRoomDao;
        }
        synchronized (this) {
            if (this._xRPSignedTxRoomDao == null) {
                this._xRPSignedTxRoomDao = new XRPSignedTxRoomDao_Impl(this);
            }
            xRPSignedTxRoomDao = this._xRPSignedTxRoomDao;
        }
        return xRPSignedTxRoomDao;
    }
}