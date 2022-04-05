package com.basicgrammer.encap;

import org.junit.jupiter.api.Test;

/**
 * @author pi
 * @date 2021/03/22 18:07:44
 **/
public class AccountTest {
    @Test
    public void should_create_account_object() throws Exception {
        Account account = new Account();
    }

    @Test
    public void should_set_account_success() throws Exception {
        Account account = new Account();
        account.setName("12345");
        account.setBalance(11);
        account.setPassWord("123");
        System.out.println("========设置的默认信息==========");
        System.out.println(account.getName() + "," + account.getBalance() + "," + account.getPassWord());
    }
}
