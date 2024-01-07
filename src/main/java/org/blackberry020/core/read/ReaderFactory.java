package org.blackberry020.core.read;

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

        public static Reader getReader(String fileName) throws Exception {
            String extension = fileName.substring(fileName.indexOf('.') + 1);
            if (readers.containsKey(extension)) return readers.get(extension);
            else throw new Exception("there is no such reader for extension " + extension);
        }
}
