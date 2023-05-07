package com.bapi.springbackend.auth.creation;

public class Account {
    private final Long createdAt;
    private final boolean isCreated;
    private final Object accountDetails;

    private Account(Long createdAt, boolean isCreated, Object accountDetails) {
        this.createdAt = createdAt;
        this.isCreated = isCreated;
        this.accountDetails = accountDetails;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public boolean isCreated() {
        return isCreated;
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

        public AccountBuilder setAccountDetails(Object accountDetails) {
            this.accountDetails = accountDetails;
            return this;
        }

        public Account build() {
            return new Account(createdAt, isCreated, accountDetails);
        }
    }
}
