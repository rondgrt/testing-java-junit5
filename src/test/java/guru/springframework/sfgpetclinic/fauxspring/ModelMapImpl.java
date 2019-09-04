package guru.springframework.sfgpetclinic.fauxspring;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {
    private Map<String, Object> attributes = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        attributes.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        // TODO implement
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }
}
