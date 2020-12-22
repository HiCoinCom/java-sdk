package com.chainup.waas.request;

/**
 * @author chainup waas
 */
public class SyncDeposit extends CommonParam {

    /**
     * 返回大于id的100条充值记录数据
     */
    private String max_id;

    /**
     * 多个request_id使用逗号隔开，最多100个request_id
     */
    private String ids;

    public String getMax_id() {
        return max_id;
    }

    public void setMax_id(String max_id) {
        this.max_id = max_id;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }


    public static Builder builder() {
        return new Builder();
    }
    public static final class Builder {
        private SyncDeposit syncWithdraw;

        private Builder() {
            syncWithdraw = new SyncDeposit();
        }

        public Builder time(Long time) {
            syncWithdraw.setTime(time);
            return this;
        }

        public Builder max_id(String max_id) {
            syncWithdraw.setMax_id(max_id);
            return this;
        }

        public Builder ids(String ids) {
            syncWithdraw.setIds(ids);
            return this;
        }

        public Builder charset(String charset) {
            syncWithdraw.setCharset(charset);
            return this;
        }

        public Builder version(String version) {
            syncWithdraw.setVersion(version);
            return this;
        }

        public SyncDeposit build() {
            return syncWithdraw;
        }
    }
}
