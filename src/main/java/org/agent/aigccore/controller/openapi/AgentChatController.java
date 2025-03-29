package org.agent.aigccore.controller.openapi;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@RestController 继承 @Controller ,解整合了@Controller和@ResponseBody。
@RequestMapping(value = "/agent")
public class AgentChatController {

}
