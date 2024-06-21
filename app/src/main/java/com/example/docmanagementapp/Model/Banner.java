package com.example.docmanagementapp.Model;

import java.io.Serializable;

public class Banner implements Serializable {
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Banner(int image) {
        this.image = image;
    }

    public  int image;
}
