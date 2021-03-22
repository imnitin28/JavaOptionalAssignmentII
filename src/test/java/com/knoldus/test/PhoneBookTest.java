package com.knoldus.test;

import com.knoldus.entity.PhoneBook;
import com.knoldus.entity.PhoneBookCrawler;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class PhoneBookTest {
    PhoneBook phoneBook = new PhoneBook();
    PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(phoneBook);
    @Test
    public void findPhoneByNameTest()
    {
        Optional<String> phoneByName = phoneBook.findPhoneByName("Ayush");
        Assert.assertEquals(phoneByName,Optional.of("03333333333"));
    }
    @Test
    public void findNameByPhoneTest()
    {
        Optional<String> nameByPhone = phoneBook.findNameByPhoneNumber("03333333333");
        Assert.assertEquals(nameByPhone,Optional.of("Ayush"));
    }
    @Test
    public void findPhoneByNameAndPunishIfNothingFoundTest()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Nitin");
        Assert.assertEquals(phoneNumberReceived,"01111111111");
    }
    @Test
    public void findPhoneByNameAndPunishIfNothingFoundTest1()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFound("Johnny");
        Assert.assertEquals(phoneNumberReceived,"Punish");
    }
    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundTest()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Sonam");
        Assert.assertEquals(phoneNumberReceived,"02222222222");
    }
    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundTest1()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFound("Amish");
        Assert.assertEquals(phoneNumberReceived,"{Nitin=01111111111, Ankush=05555555555, Sonam=02222222222, Ayush=03333333333, Rajdeep=04444444444}");
    }
    @Test
    public void findPhoneByNameAndPunishIfNothingFoundUsingStreamsTest()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Mike");
        Assert.assertEquals(phoneNumberReceived,"Punish");
    }
    @Test
    public void findPhoneByNameAndPunishIfNothingFoundUsingStreamsTest1()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPunishIfNothingFoundUsingStreams("Johnny");
        Assert.assertEquals(phoneNumberReceived,"Punish");
    }
    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreamsTest()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundStream("Rajdeep");
        Assert.assertEquals(phoneNumberReceived,"04444444444");
    }
    @Test
    public void findPhoneByNameAndPrintPhoneBookIfNothingFoundUsingStreamsTest1()
    {
        String phoneNumberReceived = phoneBookCrawler.findPhoneByNameAndPrintPhoneBookIfNothingFoundStream("Mike");
        Assert.assertEquals(phoneNumberReceived,"{Nitin=01111111111, Ankush=05555555555, Sonam=02222222222, Ayush=03333333333, Rajdeep=04444444444}");
    }
    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumberTest()
    {
        String phoneNumberByName = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("Nitin","");
        Assert.assertEquals(phoneNumberByName,"01111111111");
    }
    @Test
    public void findPhoneNumberByNameOrNameByPhoneNumberTest1()
    {
        String nameByPhoneNumber = phoneBookCrawler.findPhoneNumberByNameOrNameByPhoneNumber("","01111111111");
        Assert.assertEquals(nameByPhoneNumber,"Nitin");
    }
}
