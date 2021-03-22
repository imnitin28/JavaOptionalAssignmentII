package com.knoldus.entity;

import java.util.Map;
import java.util.stream.Stream;
/***
 * <p>This class uses phonebook and performs various functions.</p>
 */

public class PhoneBookCrawler {
  /***
  * <p>private instance of PhoneBook class.</p>
  */

  private final PhoneBook phoneBook;
  /***
   * <p>constructor that takes PhoneBook object as an argument.</p>
   *
   * @param phoneBook1 PhoneBook instance.
   */

  public PhoneBookCrawler(final PhoneBook phoneBook1) {
    this.phoneBook = phoneBook1;
  }

  /***
   * <p>attempts to find phone number using name and punish if not found.</p>
   * @param name name of the user.
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
   * <p>find phone number using name and if not found prints phoneBook.</p>
   * @param name name of the user.
   * @return phone or phone book
   */

  public String findPhoneByNameAndPrintPhoneBookIfNothingFound(
          final String name) {
    try {
      return phoneBook.findPhoneByName(name)
              .orElseGet(() -> String.valueOf(phoneBook.getPhoneDirectory()));
    } catch (IllegalArgumentException argumentException) {
      argumentException.printStackTrace();
      return "No relevant data found";
    }
  }
  /***
   * <p>attempts to find phone number using name and punish if not found.</p>
   * @param name name of the user
   * @return phone or punish message
   */

  public String findPhoneByNameAndPunishIfNothingFoundUsingStreams(
          final String name) {
    Map<String, String> phoneBookList = getPhoneBook().getPhoneDirectory();
    try {
      return Stream.of(phoneBookList)
              .anyMatch(phoneBookList1 -> phoneBookList
                      .containsKey(name)) ? phoneBookList.get(name) : "Punish";
    } catch (IllegalArgumentException argumentException) {
      argumentException.printStackTrace();
      return "No relevant data found";
    }
  }

  /***
   * <p>find phone number using name and if not found prints phoneBook.</p>
   * @param name name of the user.
   * @return phone or phone book
   */

  public String findPhoneByNameAndPrintPhoneBookIfNothingFoundStream(
          final String name) {
    Map<String, String> phoneBookList = getPhoneBook().getPhoneDirectory();
    try {
      return Stream.of(phoneBookList)
              .anyMatch(phoneBookList1 -> phoneBookList.containsKey(name))
              ? phoneBookList.get(name) : phoneBookList.toString();
    } catch (IllegalArgumentException argumentException) {
      argumentException.printStackTrace();
      return "No relevant data found";
    }
  }
  /***
   * <p>attempts to find phone number using name or vice versa..</p>
   * @param name name of the user.
   * @param phoneNumber phone number of the user.
   * @return phone or name of the user as per input.
   */

  public String findPhoneNumberByNameOrNameByPhoneNumber(
          final String name, final String phoneNumber) {
    try {
      return name.length() == 0 ? phoneBook
              .findNameByPhoneNumber(phoneNumber)
              .get() : phoneBook.findPhoneByName(name).get();
    } catch (IllegalArgumentException argumentException) {
      argumentException.printStackTrace();
      return "No relevant data found";
    }
  }

  /***
   * <p>method to get phone book.</p>
   * @return phonebook all phone book records.
   */

  public PhoneBook getPhoneBook() {
    return phoneBook;
  }
}
