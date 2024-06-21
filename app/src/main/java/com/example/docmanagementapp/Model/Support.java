package com.example.docmanagementapp.Model;

import java.io.Serializable;

public class Support implements Serializable {
    public Support(String heading) {
        this.heading = heading;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String heading;
}
