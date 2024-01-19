package org.blackberry020.core.processor.cmd;

import org.blackberry020.core.processor.entity.CoreEntity;

public interface ManipulationCommand {

    CoreEntity process(CoreEntity entity) throws Exception;
}
