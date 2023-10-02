package com.bapi.auth.creation;

public class Account {
    private final Long createdAt;
    private final boolean isCreated;
    private final Object account;
    private final Object accountDetails;

    private Account(Long createdAt, boolean isCreated, Object account, Object accountDetails) {
        this.createdAt = createdAt;
        this.isCreated = isCreated;
        this.account = account;
        this.accountDetails = accountDetails;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public boolean isCreated() {
        return isCreated;
    }

    public Object getAccount() {
        return account;
    }

    public Object getAccountDetails() {
        return accountDetails;
    }

    public static AccountBuilder builder() {
        return new AccountBuilder();
    }

    public static class AccountBuilder {
        private Long createdAt;
        private boolean isCreated;
        private Object account;
        private Object accountDetails;

        public AccountBuilder() {
        }

        public AccountBuilder setCreatedAt(Long createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder setCreated(boolean created) {
            isCreated = created;
            return this;
        }

        public AccountBuilder setAccount(Object account) {
            this.account = account;
            return this;
        }

        public AccountBuilder setAccountDetails(Object accountDetails) {
            this.accountDetails = accountDetails;
            return this;
        }

        public Account build() {
            return new Account(createdAt, isCreated, account, accountDetails);
        }
    }
}
