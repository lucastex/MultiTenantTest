package com.yourapp

class TagType {
    String name

    static constraints = {
        name(nullable: false, blank: false, unique: true)
    }
}
