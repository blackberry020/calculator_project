package org.blackberry020.core.readers;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderFactory {

        private static final HashMap<String, Reader> readers =
                (HashMap<String, Reader>) Stream.of(new Object[][] {
                        { "txt", new TxtReader() },
                        { "xml", new XmlReader() },
                        { "json", new JsonReader() },
                }).collect(Collectors.toMap(data -> (String) data[0], data -> (Reader) data[1]));

        public static Reader getReader(String extension) {
            extension = extension.toLowerCase();
            return readers.get(extension);
        }
}
