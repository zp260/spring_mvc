package com.wt.auth;

import java.lang.annotation.*;

/**
 * Created by mrz on 16/8/15.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FireAuthority {
    AuthorityType[] authorityTypes();
    ResultTypeEnum resultType() default ResultTypeEnum.page;

}
