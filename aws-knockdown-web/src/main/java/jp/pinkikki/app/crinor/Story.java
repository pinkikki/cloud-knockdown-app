package jp.pinkikki.app.crinor;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.io.Serializable;

@Component
@SessionScope
@Data
public class Story implements Serializable {

    private int id;
    private String name;
}
