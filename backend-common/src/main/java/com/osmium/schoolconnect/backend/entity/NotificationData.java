package com.osmium.schoolconnect.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * @Author
 * @Date 2023/4/18
 * @Description
 */
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class NotificationData {
    Thing1 thing1;
    Time2 time2;
    Thing3 thing3;
    Time4 time4;
    Thing5 thing5;

    public NotificationData(String campaignName, String now, String campaignLocation, String campaignTime, String s) {


      this.thing1= new Thing1(campaignName);
      this.time2= new Time2(now);
      this.thing3= new Thing3(campaignLocation);
      this.time4= new Time4(String.valueOf(campaignTime));
      this.thing5= new Thing5(s);


    }


    @Data
    @AllArgsConstructor
   static class Thing1 {
        private String value;

    }

    @Data
    @AllArgsConstructor
  static   class Time2 {
        private String value;
    }

    @Data
    @AllArgsConstructor
   static class Thing3 {
        private String value;


    }

    @Data
    @AllArgsConstructor
   static class Time4 {
        private String value;

    }

    @Data
    @AllArgsConstructor
   static class Thing5 {
        private String value;
    }
}
