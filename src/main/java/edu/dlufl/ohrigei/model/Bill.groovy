package edu.dlufl.ohrigei.model

class Bill {
    int id
    String delegateName
    int billTypeID
    int billAmount
    String billGenerateDate
    String billPayDate
    String billSerialNumber
    boolean billStatus

    int getId() {
        return id
    }

    void setId(int id) {
        this.id = id
    }

    String getDelegateID() {
        return delegateID
    }

    void setDelegateID(String delegateID) {
        this.delegateID = delegateID
    }

    int getBillTypeID() {
        return billTypeID
    }

    void setBillTypeID(int billTypeID) {
        this.billTypeID = billTypeID
    }

    int getBillAmount() {
        return billAmount
    }

    void setBillAmount(int billAmount) {
        this.billAmount = billAmount
    }

    String getBillGenerateDate() {
        return billGenerateDate
    }

    void setBillGenerateDate(String billGenerateDate) {
        this.billGenerateDate = billGenerateDate
    }

    String getBillPayDate() {
        return billPayDate
    }

    void setBillPayDate(String billPayDate) {
        this.billPayDate = billPayDate
    }

    boolean getBillStatus() {
        return billStatus
    }

    void setBillStatus(boolean billStatus) {
        this.billStatus = billStatus
    }

    String getBillSerialNumber() {
        return billSerialNumber
    }

    void setBillSerialNumber(String billSerialNumber) {
        this.billSerialNumber = billSerialNumber
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", delegateID='" + delegateID + '\'' +
                ", billTypeID=" + billTypeID +
                ", billAmount=" + billAmount +
                ", billGenerateDate='" + billGenerateDate + '\'' +
                ", billPayDate='" + billPayDate + '\'' +
                ", billSerialNumber='" + billSerialNumber + '\'' +
                ", billStatus=" + billStatus +
                '}';
    }
}
