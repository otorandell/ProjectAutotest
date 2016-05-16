package core.TestDriver;

/**
 * Created by otorandell on 09/02/2016.
 */
public class UserDetails {
    String username = "";
    String password = "";
    boolean DDBBCredentials = false;

    public UserDetails() {
    }

    public boolean isDDBBCredentials() {
        return DDBBCredentials;
    }

    public void setDDBBCredentials(boolean DDBBCredentials) {
        this.DDBBCredentials = DDBBCredentials;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
