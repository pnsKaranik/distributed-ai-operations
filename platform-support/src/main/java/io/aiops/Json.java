package io.aiops;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

public final class Json {

    private static final ObjectMapper M =
            JsonMapper.builder()
                    .enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                    .findAndAddModules()
                    .build();

    private Json() {}

    public static String write(Object x) {
        try {
            return M.writeValueAsString(x);
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON serialization failed", e);
        }
    }

    public static <T> T read(String x, Class<T> type) {
        try {
            return M.readValue(x, type);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public static Map<String, Object> map(String x) {
        try {
            return M.readValue(x, new TypeReference<>() {});
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid JSON", e);
        }
    }

    public static List<TaskSpec> tasks(Object x) {
        return M.convertValue(x, new TypeReference<>() {});
    }
}