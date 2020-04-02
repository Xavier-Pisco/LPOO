package com.aor.refactoring.example6;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Tree {
    public Date plantedAt;
    public Location location;
    private List<Date> appraisalDates;

    public Tree(Date plantedAt, String latitude, String longitude, String name){
        this.plantedAt = plantedAt;
        this.setLocation(latitude, longitude, name);
        this.appraisalDates = new ArrayList<>();
    }

    public void setLocation(String latitude, String longitude, String name){
        this.location = (new Location(latitude,longitude,name));
    }

    public String toString() {
        return "Tree planted at " + this.plantedAt.toString() + " in location " + this.location.toString();
    }

    void addAppraisal(Date appraisalDate) {
        this.appraisalDates.add(appraisalDate);
    }

    public List<Date> getAppraisals(){
        return this.appraisalDates;
    }

    public boolean isNextAppraisalOverdue(){
        Date today = new Date();
        Date latestAppraisalDate = today;

        if (this.appraisalDates.size() > 0) {
            latestAppraisalDate = this.appraisalDates.get(0);
        }

        for(Date appraisalDate : this.appraisalDates) {
            if (latestAppraisalDate.before(appraisalDate)) {
                latestAppraisalDate = appraisalDate;
            }
        }

        Date nextAppraisalDate = nextAppraisalDate(latestAppraisalDate);
        // Appraisal is only overdue if its date is in the past
        return nextAppraisalDate.before(today);
    }


    private Date nextAppraisalDate(Date latestAppraisalDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(latestAppraisalDate);
        calendar.add(Calendar.MONTH, 3);

        if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 1);
        else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
            calendar.add(Calendar.DAY_OF_MONTH, 2);

        return calendar.getTime();
    }
}
