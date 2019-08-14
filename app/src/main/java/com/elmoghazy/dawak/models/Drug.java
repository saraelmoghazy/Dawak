package com.elmoghazy.dawak.models;

public class Drug {

    private String name;
    private String imageURL;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageURL() {
        return imageURL;
    }


}

//public class Drug {
//
//    public static class Builder {
//
//        private String name;
//
//        public Builder setName(String name) {
//            this.name = name;
//            return this;
//        }
//
//        public Drug build() {
//            return new Drug(this);
//        }
//    }
//
//    private final String name;
//
//    private Drug(Builder builder) {
//        name = builder.name;
//    }
//
//    public String getName() {
//        return name;
//    }
//}

//    //Construction example
//    Drug car = new Drug.Builder().setName("Speedy").build();
