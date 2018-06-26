//package learn.oauth.server.security;
//
//import learn.oauth.server.constants.AuthoritiesEnum;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//
///**
// * @author flsh
// * @version 1.0
// * @description
// * @date 2018/6/13
// * @since Jdk 1.8
// */
//@Component
//public class DomainUserDetailsService implements UserDetailsService {
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (username.equals("linyuan")) {
//            PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//            String password = passwordEncoder.encode("123456");
//            UserDetails userDetails = new User("linyuan",
//                    password,
//                    AuthorityUtils.commaSeparatedStringToAuthorityList(AuthoritiesEnum.USER.getRole()));
//            return userDetails;
//        }
//        return null;
//    }
//}
