package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class CollectionAccountBalance extends CommonParam {

    /**
     * 币种, 是否必填：是
     */
    private String symbol;


    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }



    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private CollectionAccountBalance collectionAccountBalance;

        private Builder() {
            collectionAccountBalance = new CollectionAccountBalance();
        }

        public Builder time(Long time) {
            collectionAccountBalance.setTime(time);
            return this;
        }

        public Builder symbol(String symbol) {
            collectionAccountBalance.setSymbol(symbol);
            return this;
        }

        public Builder charset(String charset) {
            collectionAccountBalance.setCharset(charset);
            return this;
        }

        public Builder version(String version) {
            collectionAccountBalance.setVersion(version);
            return this;
        }

        public CollectionAccountBalance build() {
            return collectionAccountBalance;
        }
    }
}
