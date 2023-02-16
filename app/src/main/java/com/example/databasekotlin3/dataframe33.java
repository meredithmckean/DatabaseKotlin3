package com.example.databasekotlin3;

public class dataframe33 {
    double time_33;
    int interval;
    int power;
    int total_cal;
    double split_pace;
    int split_power;
    double split_cal;
    double last_split_time;
    double last_split_dist;

    public dataframe33(double time_33, int interval, int power, int total_cal, double split_pace, int split_power, double split_cal, double last_split_time, double last_split_dist) {
        this.time_33 = time_33;
        this.interval = interval;
        this.power = power;
        this.total_cal = total_cal;
        this.split_pace = split_pace;
        this.split_power = split_power;
        this.split_cal = split_cal;
        this.last_split_time = last_split_time;
        this.last_split_dist = last_split_dist;
    }

    public dataframe33() {
    }

    @Override
    public String toString() {
        return "dataframe33{" +
                "time_33=" + time_33 +
                ", interval=" + interval +
                ", power=" + power +
                ", total_cal=" + total_cal +
                ", split_pace=" + split_pace +
                ", split_power=" + split_power +
                ", split_cal=" + split_cal +
                ", last_split_time=" + last_split_time +
                ", last_split_dist=" + last_split_dist +
                '}';
    }


    public double getTime_33() {
        return time_33;
    }

    public void setTime_33(double time_33) {
        this.time_33 = time_33;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTotal_cal() {
        return total_cal;
    }

    public void setTotal_cal(int total_cal) {
        this.total_cal = total_cal;
    }

    public double getSplit_pace() {
        return split_pace;
    }

    public void setSplit_pace(double split_pace) {
        this.split_pace = split_pace;
    }

    public int getSplit_power() {
        return split_power;
    }

    public void setSplit_power(int split_power) {
        this.split_power = split_power;
    }

    public double getSplit_cal() {
        return split_cal;
    }

    public void setSplit_cal(double split_cal) {
        this.split_cal = split_cal;
    }

    public double getLast_split_time() {
        return last_split_time;
    }

    public void setLast_split_time(double last_split_time) {
        this.last_split_time = last_split_time;
    }

    public double getLast_split_dist() {
        return last_split_dist;
    }

    public void setLast_split_dist(double last_split_dist) {
        this.last_split_dist = last_split_dist;
    }

}

