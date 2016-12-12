package com.zgf.onepageapplication.dagger;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by zgf on 2016/12/12.
 */

@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
