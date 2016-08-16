package com.wt.tools;

import java.util.Calendar;

/**
 * Created by mrz on 16/8/11.
 */
public class FtpFileInfo {
    private String name;
    private float size;
    private Calendar timestamp;
    private Boolean Type;
    private Boolean directory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public Calendar getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Calendar timestamp) {
        this.timestamp = timestamp;
    }

    public Boolean getType() {
        return Type;
    }

    public void setType(Boolean type) {
        Type = type;
    }

}
