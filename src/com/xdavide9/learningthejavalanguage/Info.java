package com.xdavide9.learningthejavalanguage;

import java.lang.annotation.*;

//this is a custom annotation written in a class
//declaration is done by @interface and within the body you define some parameters

@Retention(RetentionPolicy.SOURCE)
@Documented
public @interface Info {
    String author();
    String lastModified();
    String lastModifiedBy();
}
