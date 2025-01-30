package com.coinbase;

/* loaded from: classes.dex */
public interface Scope {

    /* loaded from: classes.dex */
    public interface Wallet {

        /* loaded from: classes.dex */
        public interface Accounts {
            public static final String CREATE = "wallet:accounts:create";
            public static final String DELETE = "wallet:accounts:delete";
            public static final String READ = "wallet:accounts:read";
            public static final String UPDATE = "wallet:accounts:update";
        }

        /* loaded from: classes.dex */
        public interface Addresses {
            public static final String CREATE = "wallet:addresses:create";
            public static final String READ = "wallet:addresses:read";
        }

        /* loaded from: classes.dex */
        public interface Buys {
            public static final String CREATE = "wallet:buys:create";
            public static final String READ = "wallet:buys:read";
        }

        /* loaded from: classes.dex */
        public interface Checkouts {
            public static final String CREATE = "wallet:checkouts:create";
            public static final String READ = "wallet:checkouts:read";
        }

        /* loaded from: classes.dex */
        public interface Deposits {
            public static final String CREATE = "wallet:deposits:create";
            public static final String READ = "wallet:deposits:read";
        }

        /* loaded from: classes.dex */
        public interface Orders {
            public static final String CREATE = "wallet:orders:create";
            public static final String READ = "wallet:orders:read";
            public static final String REFUND = "wallet:orders:refund";
        }

        /* loaded from: classes.dex */
        public interface PaymentMethods {
            public static final String DELETE = "wallet:payment-methods:delete";
            public static final String LIMITS = "wallet:payment-methods:limits";
            public static final String READ = "wallet:payment-methods:read";
        }

        /* loaded from: classes.dex */
        public interface Sells {
            public static final String CREATE = "wallet:sells:create";
            public static final String READ = "wallet:sells:read";
        }

        /* loaded from: classes.dex */
        public interface Transactions {
            public static final String READ = "wallet:transactions:read";
            public static final String REQUEST = "wallet:transactions:request";
            public static final String SEND = "wallet:transactions:send";
            public static final String SEND_BYPASS_2FA = "wallet:transactions:send:bypass-2fa";
            public static final String TRANSFER = "wallet:transactions:transfer";
        }

        /* loaded from: classes.dex */
        public interface User {
            public static final String EMAIL = "wallet:user:email";
            public static final String READ = "wallet:user:read";
            public static final String UPDATE = "wallet:user:update";
        }

        /* loaded from: classes.dex */
        public interface Withdrawals {
            public static final String CREATE = "wallet:withdrawals:create";
            public static final String READ = "wallet:withdrawals:read";
        }
    }
}