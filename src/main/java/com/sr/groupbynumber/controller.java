package com.sr.groupbynumber;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class controller {

    @Autowired
    private groupdataService groupdataService;

    @GetMapping("")
    public String getIndex(){
        return "index";
    }

    @PostMapping("/create")
    public String createGroup(@RequestParam Integer NumberIneachGroup, @RequestParam Integer NumberofMembers, RedirectAttributes redirectAttributes ){
       allgroups g = new allgroups();
       Integer groupId = new Random().nextInt(1000);
       g.setgroupID(groupId);
       g.setNumberIneachGroup(NumberIneachGroup);
       g.setNumberofMembers(NumberofMembers);
       g.setCount(0);
       groupdataService.create(g);
       redirectAttributes.addAttribute("groupID", groupId);
       return "redirect:/{groupID}";
    }

    @GetMapping("/{groupID}")
    public String showGroup(@PathVariable("groupID") Integer groupID, Model model){
        String qrcodeurl ="https://api.qrserver.com/v1/create-qr-code/?size=300x300&data=" + "localhost:8080/"+ groupID + "/add";
        model.addAttribute("qrcodeurl", qrcodeurl); 
        model.addAttribute("groupnumber",groupID);
        return "group_info";
    }

    @GetMapping("{groupID}/add")
    public String createGroup(@PathVariable Integer groupID,RedirectAttributes redirectAttributes){
        allgroups g = groupdataService.getgroup(groupID);
        Integer count = g.getCount();
        if(count >= g.getNumberIneachGroup()){
        g.setCount(count - g.getNumberIneachGroup());
        count = 1;
        }else{
         count++;
        }
        groupdataService.updateGroup(count,groupID); 
        redirectAttributes.addFlashAttribute("count", count);
        return "redirect:/myNumber";
    }


    @GetMapping("/myNumber")
    public String showNumber(@ModelAttribute("count") Integer count, Model model){
        model.addAttribute("count", count); 
        return "myNumber";
    }


}
