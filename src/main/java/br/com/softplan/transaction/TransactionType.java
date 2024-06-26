package br.com.softplan.transaction;

public enum TransactionType {

    D("d"), R("r");

    final String type;

    TransactionType(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
