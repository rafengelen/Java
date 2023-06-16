package fact.it.contactlist.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {
    List<User> userList = new ArrayList<>();

    public UserService() {
        userList.add(new User(
                1,
                "Leanne Graham",
                "Bret",
                "Sincere@april.biz",
                new Address("Kulas Light","Apt. 556","Gwenborough","92998-3874",
                        new Geo("-37.3159", "81.1496")),
                "1-770-736-8031 x56442",
                "hildegard.org",
                new Company("Romaguera-Crona","Multi-layered client-server neural-net","harness real-time e-markets")
        ));
        userList.add(new User(
                2,
                "Ervin Howell",
                "Antonette",
                "Shanna@melissa.tv",
                new Address("Victor Plains","Suite 879","Wisokyburgh","90566-7771",
                        new Geo("-43.9509", "-34.4618")),
                "010-692-6593 x09125",
                "anastasia.net",
                new Company("Deckow-Crist","Proactive didactic contingency","synergize scalable supply-chains")
        ));
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }





    public Optional<User> getOptionalUserById(int userId){
        return getUserList().stream().filter(p-> p.getId()==userId).findFirst();
    }
    public User getUserById(Optional<User> optionalUser){
        return optionalUser.orElse(null);
    }

    public List<User> addUsers(List<User> newUsers) {
        //int size = userList.size();
        for (int i=1; i<= newUsers.size();i++){
             User user = newUsers.get(i-1);
             user.setId(userList.size()+i);

        }
        for (int i=1; i<= newUsers.size();i++){
            User user = newUsers.get(i-1);
            userList.add(user);

        }


        return newUsers;
    }

    public User updateUserById(User updateUser, int userid) {
        Optional<User> userOptional = getOptionalUserById(userid);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            user.setName(updateUser.getName());
            user.setUsername(updateUser.getUsername());
            user.setEmail(updateUser.getEmail());
            user.setAddress(updateUser.getAddress());
            user.setPhone(updateUser.getPhone());
            user.setWebsite(updateUser.getWebsite());
            user.setCompany(updateUser.getCompany());
            return user;
        }
        return null;
    }
}
