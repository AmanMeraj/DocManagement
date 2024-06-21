package com.example.docmanagementapp.Model;

import java.io.Serializable;

public class ProductListing  implements Serializable {
    public ProductListing(String heading, String subheading) {
        this.heading = heading;
        this.subheading = subheading;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getSubheading() {
        return subheading;
    }

    public void setSubheading(String subheading) {
        this.subheading = subheading;
    }

    public String heading;
    public  String subheading;
}
