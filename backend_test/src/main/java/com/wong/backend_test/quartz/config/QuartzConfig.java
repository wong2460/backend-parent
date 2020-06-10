package com.wong.backend_test.quartz.config;

import com.wong.backend_test.quartz.job.MyTestJob1;
import com.wong.backend_test.quartz.job.MyTestJob2;
import com.wong.backend_test.quartz.listener.MyTriggerListener;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig  {

    @Bean
    public JobDetail myJobDetail1() {
        JobDetail myJobDetail = JobBuilder.newJob(MyTestJob1.class)
                .withIdentity("myTestJob1","group1")
                .usingJobData("job_param","job_param1")
                .storeDurably()
                .build();
        return myJobDetail;
    }

    @Bean
    public JobDetail myJobDetail2() {
        JobDetail myJobDetail = JobBuilder.newJob(MyTestJob2.class)
                .withIdentity("myTestJob2","group2")
                .usingJobData("job_param","job_param1")
                .storeDurably()
                .build();
        return myJobDetail;
    }

    @Bean
    public Trigger myTestTrigger1() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withIdentity("myTestTrigger","myTriggerGroup1")
                .forJob(myJobDetail1())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")
                ).build();
        return trigger;
    }
    @Bean
    public Trigger myTestTrigger2() {
        Trigger trigger = TriggerBuilder.newTrigger()
                .startNow()
                .withIdentity("myTestTrigger2","myTriggerGroup2")
                .forJob(myJobDetail2())
                .withSchedule(CronScheduleBuilder.cronSchedule("0/10 * * * * ?")
                ).build();
        return trigger;
    }

}
