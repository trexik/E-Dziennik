package pl.coderslab.Group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Repositories.GroupRepository;


public class GroupConverter implements Converter<String, Group> {

    @Autowired
    GroupRepository groupRepository;

    @Override
    public Group convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return groupRepository.findById(id).orElse(null);
    }

}
