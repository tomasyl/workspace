package com.lx.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lx.common.Constants;
import com.lx.common.pagination.Page;
import com.lx.common.web.support.editor.DateEditor;
import com.lx.web.model.Messages;
import com.lx.web.service.MessageService;


@Controller
public class MessageController {

    @Autowired
    @Qualifier("messageService")
    private MessageService messageService;
    

    @RequestMapping(value = "/message", method = {RequestMethod.GET})
    public String list(HttpServletRequest request, Model model) {

        setCommonData(model);
        model.addAttribute(Constants.COMMAND, new Messages());

        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        Integer id = ServletRequestUtils.getIntParameter(request, "id", -1);
        boolean pre = ServletRequestUtils.getBooleanParameter(request, "pre", false);
        Page<Messages> page = null;
        if(id > 0) {
            if(pre) {
                page = messageService.pre(id.longValue(), pn);
            }
            else {
                page = messageService.next(id.longValue(), pn);
            }
        } 
        else {
            page = messageService.listAll(pn);
        }
        request.setAttribute("page", page);
        return "message/list";
    }



    @RequestMapping(value = "/message/query", method = {RequestMethod.GET})
    public String query(HttpServletRequest request, Model model, @ModelAttribute("command") Messages command) {
        setCommonData(model);
        model.addAttribute(Constants.COMMAND, command);
        int pn = ServletRequestUtils.getIntParameter(request, "pn", 1);
        model.addAttribute("page", messageService.query(pn, Constants.DEFAULT_PAGE_SIZE, command));

        return "message/list";
    }


    private void setCommonData(Model model) {
        //设置通用属性
    }

    @RequestMapping(value="/message/{messageId}/view", method = {RequestMethod.GET})
    public String view(@PathVariable Long topicId, HttpServletRequest request) {
        request.setAttribute(Constants.COMMAND, messageService.get(topicId));
        return "message/view";
    }



    
    @RequestMapping(value = "/message/add", method = {RequestMethod.GET})
    public String toAdd(Model model) {
        
        if(!model.containsAttribute(Constants.COMMAND)) {
            model.addAttribute(Constants.COMMAND, new Messages());
        }
        setCommonData(model);
        return "message/add";
    }
    
    @RequestMapping(value = "/message/{id}/update", method = {RequestMethod.GET})
    public String toUpdate(Model model, @PathVariable Long id) {
        if(!model.containsAttribute(Constants.COMMAND)) {
            model.addAttribute(Constants.COMMAND,  messageService.get(id));
        }
        setCommonData(model);
        return "message/update";
    }
    
    @RequestMapping(value = "/message/{id}/delete", method = {RequestMethod.GET})
    public String toDelete(@PathVariable Integer  id) {
        return "message/delete";
    }


    @RequestMapping(value = "/message/add", method = {RequestMethod.POST})
    public String add(Model model, @ModelAttribute("command") @Valid Messages command, BindingResult result) {
        
        //如果有验证错误 返回到form页面
        if(result.hasErrors()) {
            model.addAttribute(Constants.COMMAND, command);
            return toAdd(model);
        }
         messageService.save(command);
        return "redirect:/message/success";
    }
    
    @RequestMapping(value = "/message/{id}/update", method = {RequestMethod.PUT})
    public String update(Model model, @ModelAttribute("command") @Valid Messages command, BindingResult result) {
        if(result.hasErrors()) {
            model.addAttribute(Constants.COMMAND, command);
            return toUpdate(model, command.getId());
        }
        messageService.update(command);
        return "redirect:/message/success";
    }
    
    @RequestMapping(value = "/message/{id}/delete", method = {RequestMethod.DELETE})
    public String delete(@PathVariable Long id) {
        messageService.delete(id);
        return "redirect:/message/success";
    }
    
    @RequestMapping(value = "/message/success", method = {RequestMethod.GET})
    public String success() {
        return "message/success";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new DateEditor());
    }
  
    
}