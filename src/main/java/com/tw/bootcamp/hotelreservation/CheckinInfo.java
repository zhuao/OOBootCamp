package com.tw.bootcamp.hotelreservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class CheckinInfo {
    public static final SimpleDateFormat DateFormatter = new SimpleDateFormat("ddMMMyyyy(EEE)");

    private LinkedList<Date> orderedDays = new LinkedList<Date>();
    private boolean isRewards = false;

    public CheckinInfo(String checkInfo) {
        isRewards = isRewards(checkInfo);
        setOrderDays(checkInfo);
    }

    private void setOrderDays(String checkInfo) {
        String[] stayDays = checkInfo.substring(checkInfo.indexOf(":") + 1).split(",");
        for (String stayDay : stayDays) {
            try {
                Date date = DateFormatter.parse(stayDay.trim());
                orderedDays.add(date);
            } catch (ParseException e) {
                System.out.println("stayDay = " + stayDay);
                throw new RuntimeException("input date is invalid.");
            }
        }
    }

    private boolean isRewards(String checkInfo) {

        String rewardsStr = checkInfo.substring(0, checkInfo.indexOf(":"));
        if (rewardsStr.trim().equalsIgnoreCase("Rewards")) {
            return true;
        } else if (rewardsStr.trim().equalsIgnoreCase("Regular")) {
            return false;
        }

        throw new RuntimeException("unknown customer type!");
    }

    public int getWeekDays() {
        int count = 0;
        Calendar instance = Calendar.getInstance();
        for (Date orderedDay : orderedDays) {
            instance.setTime(orderedDay);
            int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
            if (0 < dayOfWeek && dayOfWeek < 6) {
                count ++;
            }
        }
        return count;
    }

    public int getWeekendDays() {
        int count = 0;
        Calendar instance = Calendar.getInstance();
        for (Date orderedDay : orderedDays) {
            instance.setTime(orderedDay);
            int dayOfWeek = instance.get(Calendar.DAY_OF_WEEK);
            if (0 == dayOfWeek || dayOfWeek == 6) {
                count ++;
            }
        }
        return count;
    }

    public boolean isRewardsCustomer() {
        return isRewards;
    }
}
