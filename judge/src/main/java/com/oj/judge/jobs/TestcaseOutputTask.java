package com.oj.judge.jobs;

import com.oj.judge.common.JudgeStatusEnum;
import com.oj.judge.entity.TestcaseResult;
import com.oj.judge.utils.StreamUtil;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.*;

/**
 * 程序输出
 *
 */
public class TestcaseOutputTask implements Callable<TestcaseResult> {

    private Process process;

    private TestcaseResult testcaseResult;

    public TestcaseOutputTask(Process process, TestcaseResult testcaseResult) {
        this.process = process;
        this.testcaseResult = testcaseResult;
    }

    @Override
    public TestcaseResult call() throws Exception {
        // 统计使用的内容空间，必须再linux环境
//        FutureTask<Long> futureTask = new FutureTask<>(new TestcaseUsedMemoryTask(process));
//        new Thread(futureTask).start();
        Instant startTime = Instant.now();
        //阻塞
        String output = StreamUtil.getOutPut(process.getInputStream());
        Instant endTime = Instant.now();

        testcaseResult.setTime(Duration.between(startTime, endTime).toMillis());
        testcaseResult.setUserOutput(output);

        //等待进程执行结束 0代表正常退出
        int exitValue = process.waitFor();
//        Long usedMemory = futureTask.get();
        Long usedMemory = 0L;
        testcaseResult.setMemory(usedMemory);
        if (exitValue != 0 && testcaseResult.getStatus() == null) {
            testcaseResult.setStatus(JudgeStatusEnum.RUNTIME_ERROR.getStatus());
        }
        return testcaseResult;
    }

}


