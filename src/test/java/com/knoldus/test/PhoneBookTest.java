package com.knoldus.test;

import com.knoldus.entity.PhoneBook;
import com.knoldus.entity.PhoneBookCrawler;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    @Test
    public void findPhoneByNameTest()
    {
        Optional<String> phoneByName = phoneBook.findPhoneByName("Ayush");
        Assert.assertEquals(phoneByName,Optional.of("03333333333"));
    }
    @Test
    public void findPhoneByNameTest1()
    {
        Optional<String> phoneByName = phoneBook.findPhoneByName("Ayush");
        Assert.assertFalse(Optional.of("011111111111").equals(phoneByName));
    }
    @Test
    public void findPhoneByNameTest2()
    {
        Optional<String> phoneByName = phoneBook.findPhoneByName("Nitin");
        Assert.assertFalse(Optional.of("03333333333").equals(phoneByName));
    }
    @Test
    public void findNameByPhoneTest()
    {
        Optional<String> nameByPhone = phoneBook.findNameByPhoneNumber("03333333333");
        Assert.assertEquals(nameByPhone,Optional.of("Ayush"));
    }
    @Test
    public void findNameByPhoneTest1()
    {
        Optional<String> nameByPhone = phoneBook.findNameByPhoneNumber("03333333333");
        Assert.assertFalse(Optional.of("Nitin").equals(nameByPhone));
    }
    @Test
    public void findNameByPhoneTest2()
    {
        Optional<String> nameByPhone = phoneBook.findNameByPhoneNumber("03333333111");
        Assert.assertFalse(Optional.of("Ayush").equals(nameByPhone));
    }
}
