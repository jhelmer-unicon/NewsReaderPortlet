/**
 * Licensed to Jasig under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Jasig licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jasig.portlet.newsreader.mvc.servlet;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasig.web.service.AjaxPortletSupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Jen Bourey, jbourey@unicon.net
 * @version $Revision$
 */
@Controller
@RequestMapping("/json")
public class JsonResponseController {

    @Autowired(required = true)
    private AjaxPortletSupportService ajaxPortletSupportService;

    public void setAjaxPortletSupportService(
            AjaxPortletSupportService ajaxPortletSupportService) {
        this.ajaxPortletSupportService = ajaxPortletSupportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getJsonResponse(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        Map<String, ?> model = ajaxPortletSupportService.getAjaxModel(request,
                response);
        return new ModelAndView("jsonView", model);
    }
}
