package hako.shareEvent.exceptions.custom;

import hako.shareEvent.exceptions.CustomException;

public class ChatIdNotFoundException extends CustomException {
    public ChatIdNotFoundException() {
        super("Чат с пользователем не был найден. Попробуйте позже или напишите в поддержку.");
    }
}