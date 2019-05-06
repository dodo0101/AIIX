package com.javacore.aiix.profile;

import com.javacore.aiix.common.BaseModel;
import com.javacore.aiix.dbservice.old.Record;
import java.util.Date;

/**
 * Class keeping all parameters of Model
 * */
public class ProfileModel extends BaseModel {

    /**
     * Fields of model
     * */
    private int id;
    private String firstName;
    private String lastName;
    private String nickName;
    private int numberOfCrimes;
    private Date dateOfBirth;
    private boolean deceased;
    private String placeOfBirth;
    private Date dateOfDeath;
    private String placeOfDeath;

    /**
     * Constructor for ProfileModel
     * @param id ID of criminal
     * @param firstName First name
     * @param lastName Last name
     * @param active Is criminal active
     * */
    public ProfileModel(int id, String firstName, String lastName, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.deceased = active;
    }

    /**
     * Simple constructor
     * */
    public ProfileModel() {}

    /**
     * Method creates model from record (table row)
     * @param record Record (table row) object, created from DB table
     * */
    public static ProfileModel modelFromRecord(Record record) {
        ProfileModel model = new ProfileModel();

        try {
            model
                    .setId(record.getInt("id"))
                    .setDeceased(record.getBoolean("deceased"));
        } catch (Exception e) {

        }
        return model;
    }

    public int getId() {
        return id;
    }

    /**
     * Setter with returning object - helps to interact with object method
     * @param id ID from record
     * */
    public ProfileModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return deceased;
    }

    public void setActive(boolean active) {
        this.deceased = active;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getNumberOfCrimes() {
        return numberOfCrimes;
    }

    public void setNumberOfCrimes(int numberOfCrimes) {
        this.numberOfCrimes = numberOfCrimes;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isDeceased() {
        return deceased;
    }

    public ProfileModel setDeceased(boolean deceased) {
        this.deceased = deceased;
        return this;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getPlaceOfDeath() {
        return placeOfDeath;
    }

    public void setPlaceOfDeath(String placeOfDeath) {
        this.placeOfDeath = placeOfDeath;
    }


    /*
     Deprecated methods from practice

     // Returning random model
         public static ProfileModel randomModel() {
        int rId = (int) (10*Math.random());
        boolean rActive = rId%2 == 0;
        String rFirstName = "Steve_" + rId;
        String rLastName = "Balmer_" + rId;
        return new ProfileModel(rId, rFirstName, rLastName, rActive);
    }

     */


}