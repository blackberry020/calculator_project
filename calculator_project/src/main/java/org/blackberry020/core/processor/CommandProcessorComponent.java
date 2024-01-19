package org.blackberry020.core.processor;

import org.blackberry020.core.processor.entity.CoreEntity;
import org.blackberry020.core.processor.cmd.ManipulationCommand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandProcessorComponent {

    public CoreEntity execute(CoreEntity entity, List<ManipulationCommand> commands) throws Exception {

        CoreEntity resultEntity = entity;

        for (ManipulationCommand s : commands) {
            resultEntity = s.process(resultEntity);
        }
        return resultEntity;
    }
}
