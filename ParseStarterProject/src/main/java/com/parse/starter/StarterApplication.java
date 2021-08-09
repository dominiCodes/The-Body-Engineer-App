/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.security.KeyPairGenerator;


public class StarterApplication extends Application {

  //private KeyPairGenerator Parse;

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.u
     Parse.enableLocalDatastore(this);
     //4OTffC4O2qen (Dashboard Password)
    // Add your initialization code here
    Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
            .applicationId("myappID")
            .clientKey("WmsD6mtdkEFZ")
            .server("http://18.222.193.200/parse/")
            .build()
            );

    //ParseUser.enableRevocableSessionInBackground();


//
//
      //ParseUser.enableAutomaticUser();
//
      ParseACL defaultACL = new ParseACL();
      defaultACL.setPublicReadAccess(true);
      defaultACL.setPublicWriteAccess(true);
      ParseACL.setDefaultACL(defaultACL, true);

  }
}




//{
//        "appId": "myappID",
//        "masterKey": "WmsD6mtdkEFZ",
//        "appName": "parse-server",
//        "mountPath": "/parse",
//        "port": "1337",
//        "host": "0.0.0.0",
//        "serverURL": "http://18.222.193.200/parse",
//        "databaseURI": "mongodb://bn_parse:o37NNHqaK7@127.0.0.1:27017/bitnami_parse"


//WmsD6mtdkEFZ-Password
