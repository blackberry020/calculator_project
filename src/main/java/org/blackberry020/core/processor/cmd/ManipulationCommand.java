package org.blackberry020.core.processor.cmd;

import org.blackberry020.core.encryption.entity.CoreEntity;

public interface ManipulationCommand {

    CoreEntity process(CoreEntity entity) throws Exception;
}
