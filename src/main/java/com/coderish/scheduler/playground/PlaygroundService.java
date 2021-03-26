package com.coderish.scheduler.playground;

import com.coderish.scheduler.service.SchedulerService;
import com.coderish.scheduler.info.SchedulerInfo;
import com.coderish.scheduler.jobs.HelloWorldJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        final SchedulerInfo info = new SchedulerInfo();
        info.setTotalFireCount(5);
        info.setRemainingFireCount(info.getTotalFireCount());
        info.setRepeatIntervalMs(5000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }

    public Boolean deleteTimer(final String timerId) {
        return scheduler.deleteTimer(timerId);
    }

    public List<SchedulerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimers();
    }

    public SchedulerInfo getRunningTimer(final String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}
