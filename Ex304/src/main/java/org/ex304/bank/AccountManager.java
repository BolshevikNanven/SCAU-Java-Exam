package org.ex304.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AccountManager {
    private List<Account> accountList;
    private int size;

    public AccountManager() {
        this.accountList=new ArrayList<>();
        this.size=0;
    }

    public Boolean addAccount(Account account){
        if(accountList.stream().anyMatch(a -> a.equals(account))){
            return false;
        }
        accountList.add(account);
        size++;
        return true;
    }
    public Boolean removeAccount(String id){
        if(accountList.stream().anyMatch(a -> Objects.equals(a.getId(), id) &&a.getBalance()==0.0)){
            return false;
        }
        for (Account account : accountList){
            if(Objects.equals(account.getId(), id)){
                accountList.remove(account);
                size--;
                break;
            }
        }

        return true;
    }
    public Account getAccount(String id){
        Account account= accountList.stream().filter(a -> Objects.equals(a.getId(), id)).findAny().orElse(null);
        return account;
    }
    public double getTotalBalance(){
        double totalBalance = 0;
        for (Account account:accountList){
            totalBalance+=account.getBalance();
        }
        return totalBalance;
    }
    public int getNumberOfCreditAccount(){
        int number=0;
        for (Account account:accountList){
            if(account instanceof CreditAccount){
                number++;
            }
        }
        return number;
    }

    public int getSize() {
        return size;
    }
}
