package com.gerson.service

import io.micronaut.context.annotation.Value
import io.micronaut.http.client.RxHttpClient

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageService {

    @Value('${bot.token}')
    String botToken

    @Inject
    RxHttpClient httpClient

    /**
     * It sends a message to a specific telegram chatId
     * @param message to send and chatId
     */
    void sendNotificationToTelegram(String message, String chatId) {
        httpClient.toBlocking().exchange("https://api.telegram.org/bot$botToken/sendMessage?text=$message&chat_id=$chatId")
    }
}