package jp.pinkikki.app.crinor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("crinor")
public class CrinorController {

    private final Story story;

    public CrinorController(Story story) {
        this.story = story;
    }

    @GetMapping("index")
    public String index() {
        story.setId(1);
        story.setName("nanosaki");
        return "crinor/index";
    }

    @GetMapping("story")
    public String story() {
        System.out.printf(String.format("id:%s, name:%s", story.getId(), story.getName()));
        return "crinor/story";
    }
}
