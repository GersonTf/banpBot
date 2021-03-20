package com.gerson.service

import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageService {

    @Client('https://api.telegram.org/bot${System.getenv(\'BOT_KEY\')}')
    @Inject
    RxHttpClient httpClient

    /**
     * It sends a message to a specific telegram chatId
     * @param message to send and chatId
     */
    void sendNotificationToTelegram(String message, String chatId) {
        httpClient.toBlocking().exchange("/sendMessage?text=$message&chat_id=$chatId")
    }
}