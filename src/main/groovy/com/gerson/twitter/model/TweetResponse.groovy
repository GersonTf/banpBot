package com.gerson.twitter.model

import groovy.transform.Canonical

@Canonical
class TweetResponse {

    String id
    String url  //retweeted_status.entities.urls.url
}
