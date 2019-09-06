package com.wzx.config;

import com.wzx.job.getDataJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class QuartzConfig {

    //JobDetail是用来描述Job实现类以及相关静态信息
    @Bean
    public JobDetail getDataJobDetail(){
        return JobBuilder.newJob(getDataJob.class)//PrintTimeJob我们的业务类
                .withIdentity("getDataJob")//可以给该JobDetail起一个id
                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据
                .usingJobData("", "")//关联键值对
                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
                .build();
    }

//    @Bean
//    public JobDetail getNewsJobDetail(){
//        return JobBuilder.newJob(getNewsJob.class)//PrintTimeJob我们的业务类
//                .withIdentity("getNewsJob")//可以给该JobDetail起一个id
//                //每个JobDetail内都有一个Map，包含了关联到这个Job的数据
//                .usingJobData("", "")//关联键值对
//                .storeDurably()//即使没有Trigger关联时，也不需要删除该JobDetail
//                .build();
//    }

    //触发Job执行的时间触发规则实现类SimpleTrigger和CronTrigger
    //可以通过crom表达式定义出各种复杂的调度方案
    @Bean
    public Trigger getDataJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("10 24 11 5 9 ?");
        return TriggerBuilder.newTrigger()
                .forJob(getDataJobDetail())//关联上述的JobDetail
                .withIdentity("quartzTaskService")//给Trigger起个名字
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
