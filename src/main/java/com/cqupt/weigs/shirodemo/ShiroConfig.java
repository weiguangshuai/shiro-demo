package com.cqupt.weigs.shirodemo;

import com.cqupt.weigs.shirodemo.realm.UserRealm;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <b><code>ShiroConfig</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2018/11/13 17:02.
 *
 * @author weigs
 * @since shrio-demo 2.0.0
 */
@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm() {
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
