package learn.oauth.server.constants;

/**
 * @author flsh
 * @version 1.0
 * @description
 * @date 2018/6/13
 * @since Jdk 1.8
 */
public enum AuthoritiesEnum {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER"),
    ANONYMOUS("ROLE_ANONYMOUS");

    private String role;

    AuthoritiesEnum(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }

}
