package com.knoldus.entity;

import java.util.Map;
import java.util.stream.Stream;
/***
 * This class uses phonebook and performs various functions.
 */
public class PhoneBookCrawler {
    /***
     *
     */
    private PhoneBook phoneBook;
    /***
     * constructor that takes PhoneBook object as an argument.
     * @param phoneBook1
     */
    public PhoneBookCrawler(final PhoneBook phoneBook1) {
        this.phoneBook = phoneBook1;
    }

    /***
     *
     * @param name
     * @return stringMessage
     */
    public String findPhoneByNameAndPunishIfNothingFound(final String name) {
        try {
            return phoneBook.findPhoneByName(name)
                    .orElseThrow(() -> new IllegalArgumentException("Punish"));
        } catch (IllegalArgumentException illegalArgumentException) {
            return "Punish";
        }
    }
    /***
     *
     * @param name
     * @return phone or phone book
     */
    public String findPhoneByNameAndPrintPhoneBookIfNothingFound(
            final String name) {
        return phoneBook.findPhoneByName(name)
                .orElseGet(() -> String.valueOf(phoneBook.getPhoneDirectory()));
    }
    /***
     *
     * @param name
     * @return phone or punish message
     */
    public String findPhoneByNameAndPunishIfNothingFoundUsingStreams(
            final String name) {
        Map<String, String> phoneBookList = getPhoneBook().getPhoneDirectory();
        return Stream.of(phoneBookList)
                .anyMatch(phoneBookList1 -> phoneBookList
                .containsKey(name)) ? phoneBookList.get(name) : "Punish";
    }

    /***
     *
     * @param name
     * @return phone or phone book
     */
    public String findPhoneByNameAndPrintPhoneBookIfNothingFoundStream(
            final String name) {
        Map<String, String> phoneBookList = getPhoneBook().getPhoneDirectory();
        return Stream.of(phoneBookList)
                .anyMatch(phoneBookList1 -> phoneBookList.containsKey(name))
                ? phoneBookList.get(name) : phoneBookList.toString();
    }

    /***
     *
     * @param name
     * @param phoneNumber
     * @return phone or name
     */
    public String findPhoneNumberByNameOrNameByPhoneNumber(
            final String name, final String phoneNumber) {
        return name.length() == 0 ? phoneBook
                .findNameByPhoneNumber(phoneNumber)
                .get() : phoneBook.findPhoneByName(name).get();
    }

    /***
     *
     * @return phonebook
     */
    public PhoneBook getPhoneBook() {
        return phoneBook;
    }
}
