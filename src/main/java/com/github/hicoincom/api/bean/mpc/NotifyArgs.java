package com.github.hicoincom.api.bean.mpc;


import com.alibaba.fastjson.annotation.JSONField;
import com.github.hicoincom.api.bean.BaseArgs;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author ChainUp Custody
 * Asynchronous notification interface parameters
 * https://custodydocs-zh.chainup.com/api-references/mpc-apis/notify
 */
public class NotifyArgs extends BaseArgs implements Serializable {

    private static final long serialVersionUID = 986673670307361841L;

    private String side;

    @JSONField(name ="notify_time")
    private Date notifyTime;

    @JSONField(name ="request_id")
    private String requestId;

    private Integer id;

    @JSONField(name ="sub_wallet_id")
    private String subWalletId;

    private String symbol;

    @JSONField(name ="contract_address")
    private String contractAddress;

    private BigDecimal amount;

    @JSONField(name ="fee_symbol")
    private String feeSymbol;

    @JSONField(name ="real_fee")
    private BigDecimal realFee;

    @JSONField(name ="address_from")
    private String addressFrom;

    @JSONField(name ="address_to")
    private String addressTo;

    private String memo;

    @JSONField(name ="created_at")
    private Date createdAt;

    @JSONField(name ="updated_at")
    private Date updatedAt;

    private String txid;

    private Integer confirmations;

    private Integer status;

    @JSONField(name ="tx_height")
    private Long txHeight;

    @JSONField(name ="base_symbol")
    private String baseSymbol;

    @JSONField(name ="withdraw_source")
    private String withdrawSource;

    /**
     * below web3 info
     */
    @JSONField(name ="main_chain_symbol")
    private String mainChainSymbol;

    @JSONField(name ="interactive_contract")
    private String interactiveContract;

    @JSONField(name ="input_data")
    private String inputData;

    @JSONField(name ="trans_type")
    private String transType;

    @JSONField(name ="dapp_img")
    private String dappImg;

    @JSONField(name ="dapp_name")
    private String dappName;

    @JSONField(name ="dapp_url")
    private String dappUrl;

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public Date getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(Date notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubWalletId() {
        return subWalletId;
    }

    public void setSubWalletId(String subWalletId) {
        this.subWalletId = subWalletId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public void setContractAddress(String contractAddress) {
        this.contractAddress = contractAddress;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getFeeSymbol() {
        return feeSymbol;
    }

    public void setFeeSymbol(String feeSymbol) {
        this.feeSymbol = feeSymbol;
    }

    public BigDecimal getRealFee() {
        return realFee;
    }

    public void setRealFee(BigDecimal realFee) {
        this.realFee = realFee;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTxid() {
        return txid;
    }

    public void setTxid(String txid) {
        this.txid = txid;
    }

    public Integer getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(Integer confirmations) {
        this.confirmations = confirmations;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getTxHeight() {
        return txHeight;
    }

    public void setTxHeight(Long txHeight) {
        this.txHeight = txHeight;
    }

    public String getBaseSymbol() {
        return baseSymbol;
    }

    public void setBaseSymbol(String baseSymbol) {
        this.baseSymbol = baseSymbol;
    }

    public String getWithdrawSource() {
        return withdrawSource;
    }

    public void setWithdrawSource(String withdrawSource) {
        this.withdrawSource = withdrawSource;
    }

    public String getMainChainSymbol() {
        return mainChainSymbol;
    }

    public void setMainChainSymbol(String mainChainSymbol) {
        this.mainChainSymbol = mainChainSymbol;
    }

    public String getInteractiveContract() {
        return interactiveContract;
    }

    public void setInteractiveContract(String interactiveContract) {
        this.interactiveContract = interactiveContract;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getDappImg() {
        return dappImg;
    }

    public void setDappImg(String dappImg) {
        this.dappImg = dappImg;
    }

    public String getDappName() {
        return dappName;
    }

    public void setDappName(String dappName) {
        this.dappName = dappName;
    }

    public String getDappUrl() {
        return dappUrl;
    }

    public void setDappUrl(String dappUrl) {
        this.dappUrl = dappUrl;
    }
}
