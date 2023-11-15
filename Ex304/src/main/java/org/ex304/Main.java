package org.ex304;

import org.ex304.bank.Account;
import org.ex304.bank.AccountManager;
import org.ex304.bank.CreditAccount;
import org.ex304.bank.SavingAccount;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager=new AccountManager();

        accountManager.addAccount(new CreditAccount("1","nanven",100.0,100.0));
        accountManager.addAccount(new CreditAccount("1","Nanven",100.0,100.0));//失败
        accountManager.addAccount(new CreditAccount("2","Tom",120.0,50.0));
        accountManager.addAccount(new SavingAccount("4","Tim",68.8));
        accountManager.addAccount(new SavingAccount("5","Kim",168.0));

        System.out.println(accountManager.getSize());
        System.out.println(accountManager.getNumberOfCreditAccount());
        System.out.println(accountManager.getTotalBalance());

        Account account=accountManager.getAccount("1");
        System.out.println(account.toString());
        account.withdraw(198.0);
        System.out.println(account.toString());

        accountManager.removeAccount("2");
        System.out.println(accountManager.getSize());
        System.out.println(accountManager.getNumberOfCreditAccount());
        System.out.println(accountManager.getTotalBalance());

    }
}
