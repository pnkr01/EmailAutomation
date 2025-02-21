package com.gchackathon.emailTracking.dto;

public class IsUserExistsDto {
    boolean isUserExists;

    public boolean getIsUserExists() {
        return isUserExists;
    }

    public void setIsUserExists(boolean isUserExists) {
        this.isUserExists = isUserExists;
    }



    public IsUserExistsDto(boolean isUserExists) {
        this.isUserExists = isUserExists;
    }

    @Override
    public String toString() {
        return "IsUserExistsDto{" +
                "isUserExists='" + isUserExists + '\'' +
                '}';
    }
}
