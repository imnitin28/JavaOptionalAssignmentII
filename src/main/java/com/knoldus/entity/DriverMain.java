package com.knoldus.entity;
import java.util.Optional;
class DriverMain {
    protected DriverMain() {
    }
    /***
     *
     * @param args
     */
    public static void main(final String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        PhoneBookCrawler phoneBookCrawler = new PhoneBookCrawler(phoneBook);
        String phoneNumber = phoneBook.findPhoneByName("Nitin").get();
        System.out.println("Nitin's Phone Number -> " + phoneNumber);
        String phoneNumber1 = phoneBookCrawler
                .findPhoneByNameAndPunishIfNothingFound("Nitin");
        System.out.println("Nitin's Phone Number ->" + phoneNumber1);
        String phoneNumber2 = phoneBookCrawler
                .findPhoneByNameAndPunishIfNothingFound("Johnny");
        System.out.println("Johnny's Phone Number ->" + phoneNumber2);
        String phoneNumber3 = phoneBookCrawler
                .findPhoneByNameAndPrintPhoneBookIfNothingFound("John");
        System.out.println("John's Phone Number ->" + phoneNumber3);
        String phoneNumber4 = phoneBookCrawler
                .findPhoneByNameAndPunishIfNothingFoundUsingStreams("Mike");
        System.out.println("Mike's Phone Number -> " + phoneNumber4);
        String phoneNumber5 = phoneBookCrawler
                .findPhoneByNameAndPrintPhoneBookIfNothingFoundStream("Ankush");
        System.out.println("Ankush's Phone number -> " + phoneNumber5);
        String phoneNumber6 = (phoneBook.
                findNameByPhoneNumber("02222222222").isPresent()
                ? phoneBook.findNameByPhoneNumber("02222222222").get()
                : String.valueOf(Optional.empty()));
        System.out.println("02222222222 is associated with -> " + phoneNumber6);
        String phoneNumberORName = phoneBookCrawler
                .findPhoneNumberByNameOrNameByPhoneNumber("Ayush", "");
        System.out.println("Ayush's Phone Number is -> " + phoneNumberORName);
        String phoneNumberORName1 = phoneBookCrawler
                .findPhoneNumberByNameOrNameByPhoneNumber("", "03333333333");
        System.out.println("03333333333 -> " + phoneNumberORName1);
    }
}
