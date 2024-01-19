package org.blackberry020.core.processor;

import lombok.NoArgsConstructor;
import org.blackberry020.core.processor.entity.CoreEntity;
import org.blackberry020.core.processor.cmd.ManipulationCommand;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@NoArgsConstructor
public class CommandProcessor {

    public CoreEntity execute(CoreEntity entity, List<ManipulationCommand> commands) throws Exception {

        CoreEntity resultEntity = entity;

        for (ManipulationCommand s : commands) {
            resultEntity = s.process(resultEntity);
        }
        return resultEntity;
    }
}
