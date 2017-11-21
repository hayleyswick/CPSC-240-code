package Users;

import GUIControllers.Main;

public class SysAdmin extends User {


    public SysAdmin(String username, String password, String email,
                    String firstName, String lastName, String phoneNumber) {
        super(username, password, email, firstName, lastName, phoneNumber);

    }

    public SysAdmin(User user) {
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setEmail(user.getEmail());
        this.setFirstName(user.getFirstName());
        this.setLastName(user.getLastName());
        this.setPhoneNumber(user.getPhoneNumber());

    }


    public void createAccount(User user) {

        boolean exists = false;
        for (User u : Main.userList) {
            if (user.getUsername().equals(u.getUsername())) {
                exists = true;
            }
        }
        if (!exists)
            Main.userList.add(user);
    }

    public void addOfficeManager(User user) {

        boolean replaced = false;
        OfficeManager temp = new OfficeManager(user);
        for (User u : Main.userList) {
            if (temp.getUsername().equals(u.getUsername())) {
                u = temp;
                replaced = true;
            }
        }
        if (!replaced) {
            Main.userList.add(temp);
        }

    }

    public void addWHManager(User user) {

        boolean replaced = false;
        //check if username exist, if it does, replace at the index
        WHManager temp = new WHManager(user);
        for (User u : Main.userList) {
            if (temp.getUsername().equals(u.getUsername())) {
                u = temp;
                replaced = true;
            }
        }
        if (!replaced) {
            Main.userList.add(temp);
        }

    }


}
