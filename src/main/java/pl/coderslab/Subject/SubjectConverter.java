package pl.coderslab.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.Repositories.SubjectRepository;

public class SubjectConverter implements Converter<String, Subject> {

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public Subject convert(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        Long id = Long.valueOf(s);
        return subjectRepository.findById(id).orElse(null);
    }

}
