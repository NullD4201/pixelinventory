package com.github.nulld4201.pixelinventory.database;

public class PixelUser {
    private final String nickname;
    private final String prefix;
    private final String uuid;

    public PixelUser(String nickname, String prefix, String uuid) {
        this.nickname = nickname;
        this.prefix = prefix;
        this.uuid = uuid;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getUuid() {
        return uuid;
    }
}
