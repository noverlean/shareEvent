package hako.shareEvent.telegram;

public enum ChatContext {
    START,

    SELECT_CITY,
    SET_NAME,

    CREATE_EVENT,
    SET_EVENT_CITY,
    SET_EVENT_TITLE,
    SET_EVENT_DESCRIPTION,
    SET_EVENT_LOCATION,
    SET_EVENT_BEGIN_TIME,
    ALERT_EVENT,
    CLOSE_EVENT,

    REGISTER_TO_EVENT,
}