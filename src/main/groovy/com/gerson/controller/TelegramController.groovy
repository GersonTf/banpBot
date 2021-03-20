package com.gerson.controller

import com.gerson.service.TelegramHandler
import com.gerson.telegram.model.Update
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Produces
import io.micronaut.security.annotation.Secured
import io.micronaut.security.rules.SecurityRule

import javax.inject.Inject

@Controller
class TelegramController {

    @Inject
    TelegramHandler telegramHandler

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Get("/helloWorld")
    @Produces(MediaType.APPLICATION_JSON)
    Map index() {
        [response: "I am alive!!"]
    }

    /**
     * This endpoint will be the one that receive the messages from your bot trough the webhook that you will configure:
     * https://core.telegram.org/bots/api#setwebhook (the url param that you have to send must point to this endpoint)
     **/
    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/webhook")
    void webhook(@Body Update update) {
        telegramHandler.messageReceiver(update)
    }
}
