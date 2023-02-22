package com.panda.parallel.demo.task;

import com.panda.parallel.demo.key.DemoParallelTaskKey;
import com.panda.parallel.demo.parameter.DemoBizParameter;
import com.panda.parallel.demo.parameter.DemoBizResult;
import com.panda.parallel.demo.parameter.DemoParallelResponse;
import com.panda.parallel.key.ParallelTaskKey;
import com.panda.parallel.parameter.BaseParallelRequest;
import com.panda.parallel.parameter.BaseParallelResponse;
import com.panda.parallel.task.IBaseParallelTask;
import org.springframework.stereotype.Component;

@Component
public class DemoSleepParallelTask implements IBaseParallelTask<DemoBizParameter> {
    @Override
    public ParallelTaskKey getParallelTaskKey() {
        return DemoParallelTaskKey.DemoSleepTask;
    }

    @Override
    public BaseParallelResponse taskEntry(BaseParallelRequest<DemoBizParameter> request) throws Exception {
        Thread.sleep(15000);
        DemoBizResult bizResult = DemoBizResult.newInstance().setName(request.getRequest().getRequest())
                .setTitle("gold");
        return DemoParallelResponse.newResponse(getParallelTaskKey(), bizResult);
    }
}