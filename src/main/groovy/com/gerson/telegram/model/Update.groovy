package com.gerson.telegram.model

import groovy.transform.Canonical

@Canonical
class Update {

    def update_id
    Message message
}
