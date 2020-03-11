/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.thealphalab.education.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.model.Group;
import org.thealphalab.education.others.RespBean;
import org.thealphalab.education.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DatasourceController {

    @Autowired
    private UserService userService;

    /**
      * 映射数据源选择页面
      */
    @SuppressWarnings("Duplicates")
    @RequestMapping("/selectdatasource")
    public String home(HttpServletRequest request, Model model) {
        return "selectdatasource.html";
    }

    @RequestMapping("/datasourcetree")
    @ResponseBody
    public String getDatasourceTree() throws JsonProcessingException {
        Subject subject = SecurityUtils.getSubject();
        RespBean respBean = new RespBean("datasourcetree");
        respBean.setStatus(0);
        respBean.setObj(Group.build(userService.getUserByUsername((String) subject.getPrincipal()).getPermission()));
        return new ObjectMapper().writeValueAsString(respBean);
    }

}
