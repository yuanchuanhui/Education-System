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
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thealphalab.education.others.RespBean;

@Controller
public class LoginController {

    /**
      * 映射登陆页面。
      */
    @GetMapping({"/login", "/"})
    public String login() {
        return "login.html";
    }

    /**
      * 进行登陆，并返回登陆结果。
      */
    @PostMapping("/login")
    @ResponseBody
    public String login(String username, String password) throws JsonProcessingException {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        RespBean respBean = new RespBean("login");
        try {
            subject.login(token);
            respBean.setStatus(0);
        }catch (AuthenticationException e){
            respBean.setErrMsg("用户名或密码错误！");
            respBean.setStatus(1);
        }
        return new ObjectMapper().writeValueAsString(respBean);
    }

}
