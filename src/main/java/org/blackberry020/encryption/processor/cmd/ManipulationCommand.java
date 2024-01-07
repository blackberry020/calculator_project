package org.blackberry020.encryption.processor.cmd;

import org.blackberry020.encryption.entity.CoreEntity;

public interface ManipulationCommand {

    CoreEntity process(CoreEntity entity) throws Exception;
}
