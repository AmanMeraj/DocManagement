package com.example.docmanagementapp.Model;

import java.io.Serializable;

public class Product implements Serializable {
    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public Product(String heading) {
        this.heading = heading;
    }

    public String heading;

}
