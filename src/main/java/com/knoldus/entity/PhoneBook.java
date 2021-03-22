package com.knoldus.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/***
 * <p>Phone Book Class having a map initialized with Name and Phone Numbers.</p>
 */
public class PhoneBook {
  /***
  *<p>Initializing Map of phone records.</p>
  */
  private static final Map<String, String> PHONE_RECORDS =
        new HashMap<String, String>() {
        {
          put("Nitin", "01111111111");
          put("Sonam", "02222222222");
          put("Ayush", "03333333333");
          put("Rajdeep", "04444444444");
          put("Ankush", "05555555555");
        }
      };
  /***
  * <p>storing phoneRecords to a phoneDirectory map.</p>
  */
  private final Map<String, String> phoneDirectory = PHONE_RECORDS;

  /***
  * <p>default constructor.</p>
  */
  public PhoneBook() { }

  /***
   * <p>method to get phone directory in form of map.</p>
   *
   * @return phoneDirectory complete phone directory.
   */
  public Map<String, String> getPhoneDirectory() {
    return phoneDirectory;
  }

  /***
  * <p>function to find phone number using name of the user.</p>
  *
  * @param name name of the user
  * @return phone phone number of user
  */
  public Optional<String> findPhoneByName(final String name) {
    if (phoneDirectory.containsKey(name)) {
      return Optional.of(phoneDirectory.get(name));
    }
    return Optional.empty();
  }

  /***
  * <p>finds name of the user using it's phone number.</p>
  *
  * @param phoneNumber phone number of an user
  * @return name
  */
  public Optional<String> findNameByPhoneNumber(final String phoneNumber) {
    for (Map.Entry<String, String> entry : phoneDirectory.entrySet()) {
      if (entry.getValue().equals(phoneNumber)) {
        return Optional.of(entry.getKey());
      }
    }
    return Optional.empty();
  }

  /***
   * <p>overridden method, prints Hello message.</p>
   *
   * @return phoneDirectory
   */
  @Override
  public String toString() {
    System.out.println("Hello from Phonebook");
    return "PhoneBook{"
            + "phoneDirectory=" + phoneDirectory
            + '}';
  }
}
