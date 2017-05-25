package com.example.android.contacts2;


import java.io.Serializable;

/**
 * Created by jxc064000 on 5/18/2017.
 */

public class Contact implements Serializable
{
    private static int nextID;
    // Fields that show on the form.
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public void setId(int id)
    {
        this.id = id;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getEmail()
    {
        return email;
    }


    public Contact(String strContact)
    {
        String[] strTemp = strContact.split("\t");
        id = Integer.parseInt(strTemp[0]);
        firstName = strTemp[1];
        lastName = strTemp[2];
        phone = strTemp[3];
        email = strTemp[4];
    }

    public Contact()
    {
    }

    public String toString()
    {
        return Integer.toString(id) + "\t" +
                firstName + "\t" +
                lastName + "\t" +
                phone + "\t" + email;
    }

    public int getNextID()
    {
        nextID++;
        return nextID;
    }

}
