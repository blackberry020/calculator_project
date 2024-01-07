package org.blackberry020.core.processor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.blackberry020.core.encryption.entity.CoreEntity;
import org.blackberry020.core.processor.cmd.ManipulationCommand;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CommandProcessor {

    @NonNull
    CoreEntity coreEntity;

    List<ManipulationCommand> strategyList = new ArrayList<>();

    public CommandProcessor addCommand(ManipulationCommand strategy) {
        strategyList.add(strategy);
        return this;
    }

    public CoreEntity execute() throws Exception {
        for (ManipulationCommand s : strategyList) {
            coreEntity = s.process(coreEntity);
        }
        return coreEntity;
    }

}
