package life.majiang.community.controller;

import life.majiang.community.dto.PaginationDTO;
import life.majiang.community.model.User;
import life.majiang.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController
{
    @Autowired
    private QuestionService questionService;

    @GetMapping("/profile/{action}")
    public String prifile(HttpServletRequest request,
                          @PathVariable(name = "action")String action,
                          Model model,
                          @RequestParam(name = "page",defaultValue = "1")Integer page,
                          @RequestParam(name = "size",defaultValue = "5")Integer size)
    {
        User user = (User) request.getSession().getAttribute("user");

        if(user == null)
        {
            return "redirect:/";
        }

        if(action.equals("questions"))
        {
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }
        else if(action.equals("replies"))
        {
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }

        PaginationDTO PaginationDTO = questionService.list(user.getId(), page, size);

        model.addAttribute("pagination",PaginationDTO);
        return "profile";
    }

}
