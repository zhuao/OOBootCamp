package com.tw.bootcamp.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class CheckinInfo {
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("ddMMMyy(EEE)");
    private LinkedList<Date> stayDates = new LinkedList<Date>();
    private boolean isRewards = false;

    public CheckinInfo(String checkInfo) {
        int rewardsEndIndex = checkInfo.indexOf(":");

        String rewardsStr = checkInfo.substring(0, rewardsEndIndex);
        if (rewardsStr.trim().equalsIgnoreCase("Rewards")) {
            this.isRewards = true;
        }

        String[] stayDays = checkInfo.substring(rewardsEndIndex).split(",");
        for (String stayDay : stayDays) {
            try {
                Date date = DateFormatter.parse(stayDay.trim());
                DateFormatter.getCalendar().get(Calendar.DAY_OF_WEEK);
                if (isWeekend(date)) {

                }
                stayDates.add(date);
            } catch (ParseException e) {
                throw new RuntimeException("input date is invalid.");
            }
        }
    }

    private boolean isWeekend(Date date) {
        return false;
    }
}
