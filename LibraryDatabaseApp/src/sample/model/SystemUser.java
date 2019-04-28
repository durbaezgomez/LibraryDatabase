package sample.model;

public class SystemUser {

    public int id;
    public String login;
    public String passwd;
    public String name;
    public String surname;
    public int accountTypeId;

    public SystemUser(int Userid, String Userlogin, String Userpasswd, String Username, String Usersurname, int UseraccountTypeId){
        id = Userid;
        login = Userlogin;
        passwd = Userpasswd;
        name = Username;
        surname = Usersurname;
        accountTypeId = UseraccountTypeId;
    }

}