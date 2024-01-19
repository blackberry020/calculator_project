package org.blackberry020.core.util;

import lombok.RequiredArgsConstructor;
import org.blackberry020.core.processor.cmd.*;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CommandMapperUtil {

    private final Map<String, ManipulationCommand> commands;

    private ManipulationCommand mapCommand(String command) {
        return commands.get(command);
    }

    public List<ManipulationCommand> mapCommandsToList(List<String> commands) {
        return commands.stream()
                .map(this::mapCommand)
                .collect(Collectors.toList());
    }
}
