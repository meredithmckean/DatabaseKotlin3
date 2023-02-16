package com.example.databasekotlin3;

public class dataframe35 {
    double time_35;
    double dist;
    double drive_len;
    double drive_time;
    double stroke_rec_time;
    double stroke_dist;
    double peak_drive_force;
    double avg_drive_force;
    double work_per_stroke;
    int stroke_count;

    public dataframe35(double time_35, double dist, double drive_len, double drive_time, double stroke_rec_time, double stroke_dist, double peak_drive_force, double avg_drive_force, double work_per_stroke, int stroke_count) {
        this.time_35 = time_35;
        this.dist = dist;
        this.drive_len = drive_len;
        this.drive_time = drive_time;
        this.stroke_rec_time = stroke_rec_time;
        this.stroke_dist = stroke_dist;
        this.peak_drive_force = peak_drive_force;
        this.avg_drive_force = avg_drive_force;
        this.work_per_stroke = work_per_stroke;
        this.stroke_count = stroke_count;
    }

    public dataframe35() {
    }

    @Override
    public String toString() {
        return "dataframe35{" +
                "time_35=" + time_35 +
                ", dist=" + dist +
                ", drive_len=" + drive_len +
                ", drive_time=" + drive_time +
                ", stroke_rec_time=" + stroke_rec_time +
                ", stroke_dist=" + stroke_dist +
                ", peak_drive_force=" + peak_drive_force +
                ", avg_drive_force=" + avg_drive_force +
                ", work_per_stroke=" + work_per_stroke +
                ", stroke_count=" + stroke_count +
                '}';
    }


    public double getTime_35() {
        return time_35;
    }

    public void setTime_35(double time_35) {
        this.time_35 = time_35;
    }

    public double getDist() {
        return dist;
    }

    public void setDist(double dist) {
        this.dist = dist;
    }

    public double getDrive_len() {
        return drive_len;
    }

    public void setDrive_len(double drive_len) {
        this.drive_len = drive_len;
    }

    public double getDrive_time() {
        return drive_time;
    }

    public void setDrive_time(double drive_time) {
        this.drive_time = drive_time;
    }

    public double getStroke_rec_time() {
        return stroke_rec_time;
    }

    public void setStroke_rec_time(double stroke_rec_time) {
        this.stroke_rec_time = stroke_rec_time;
    }

    public double getStroke_dist() {
        return stroke_dist;
    }

    public void setStroke_dist(double stroke_dist) {
        this.stroke_dist = stroke_dist;
    }

    public double getPeak_drive_force() {
        return peak_drive_force;
    }

    public void setPeak_drive_force(double peak_drive_force) {
        this.peak_drive_force = peak_drive_force;
    }

    public double getAvg_drive_force() {
        return avg_drive_force;
    }

    public void setAvg_drive_force(double avg_drive_force) {
        this.avg_drive_force = avg_drive_force;
    }

    public double getWork_per_stroke() {
        return work_per_stroke;
    }

    public void setWork_per_stroke(double work_per_stroke) {
        this.work_per_stroke = work_per_stroke;
    }

    public int getStroke_count() {
        return stroke_count;
    }

    public void setStroke_count(int stroke_count) {
        this.stroke_count = stroke_count;
    }

}
