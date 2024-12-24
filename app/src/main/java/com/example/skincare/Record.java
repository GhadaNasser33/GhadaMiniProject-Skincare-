package com.example.skincare;


public class Record {
     String id;
     String FirstName;

     String LastName;
     String email;
     String phone;

    // Default constructor (Required for Firebase)
    public Record() { }

    // Parameterized constructor
    public Record(String id, String Firstname, String email, String phone, String LastName) {
        this.id = id;
        this.FirstName = Firstname;
        this.LastName=LastName;
        this.email = email;
        this.phone = phone;
    }

    // Getter and Setter Methods

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setName(String Firstname) {
        this.FirstName = Firstname;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.FirstName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
