package com.gerson.telegram.model

import groovy.transform.Canonical

@Canonical
class Message {
    def message_id
    User from
    Integer date
    Chat chat
    String text
}