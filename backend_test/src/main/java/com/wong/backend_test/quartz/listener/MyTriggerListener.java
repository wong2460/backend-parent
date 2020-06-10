package com.wong.backend_test.quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.listeners.TriggerListenerSupport;

public class MyTriggerListener extends TriggerListenerSupport {
    @Override
    public String getName() {
        return "myTriggerListener";
    }

    @Override
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        super.triggerFired(trigger, context);
        System.out.println("Trigger is fired");
    }
}
