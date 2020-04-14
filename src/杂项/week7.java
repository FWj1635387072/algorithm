package 杂项;

import java.util.ArrayList;

public class week7 {

    public static void main(String[] args) {
        bank ban1 = new bank("XX银行");
        ban1.addAcoount("u1","123",1000);
        ban1.addAcoount("u2","123",1000);
        ban1.addAcoount("u3","123",1000);
        //找到要操作的账户
        account a1 = ban1.check("u1");
        System.out.println(a1.getBalance());
        //存钱，显示余额
        a1.save(100);
        System.out.println(a1.getBalance());
        //取钱，并显示余额
        a1.getMoney(1000);
        System.out.println(a1.getBalance());
    }
}

class account {
    private String userName;
    private String password;
    private double balance;

    public account() {
    }

    public account(String userName, String password, double balance) {
        this.balance = balance;
        this.password = password;
        this.userName = userName;
    }


    //存钱出现异常，抛异常，返回-1
    public int save(double money) {
        try {
            balance += money;
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    //若余额不足，返回0，成功返回1，异常返回-1
    public int getMoney(double money) {
        try {
            if (money > balance) {
                return 0;
            } else {
                balance -= money;
                return 1;
            }
        } catch (Exception e) {
            return -1;
        }
    }

    public double getBalance() {
        return balance;
    }
    public String getUserName(){
        return userName;
    }
}

class bank {
    private String bankName;
    private ArrayList<account> accounts;

    public bank(String bankName) {
        this.bankName = bankName;
        accounts = new ArrayList<account>();
    }
    //增加用户
    public int addAcoount(String userName, String password, double money) {
        try {
            //如果已有该用户名，返回-1
            for(account a : accounts){
                if(userName.equals(a.getUserName())){
                    return -1;
                }
            }
            account a1 = new account(userName, password, money);
            accounts.add(a1);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
    public account check(String userName){
        for(account a: accounts){
            if (userName.equals(a.getUserName()))
                return a;
        }
        return null;
    }
}