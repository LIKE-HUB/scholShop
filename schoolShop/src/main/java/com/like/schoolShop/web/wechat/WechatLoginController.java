package com.like.schoolShop.web.wechat;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.like.schoolShop.dto.UserAccessToken;
import com.like.schoolShop.dto.WechatAuthExecution;
import com.like.schoolShop.dto.WechatUser;
import com.like.schoolShop.entity.PersonInfo;
import com.like.schoolShop.entity.WechatAuth;
import com.like.schoolShop.enums.WechatAuthStateEnum;
import com.like.schoolShop.service.PersonInfoService;
import com.like.schoolShop.service.WechatAuthService;
import com.like.schoolShop.util.wechat.WechatUtil;


@Controller
@RequestMapping("wechatlogin")
/**
 * 获取关注公众号之后的微信用户信息的接口，如果在微信浏览器里访问
 * https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc93c24fd1809e943&redirect_uri=http://119.23.240.132/schoolShop/wechatlogin/logincheck&role_type=1&response_type=code&scope=snsapi_userinfo&state=1#wechat_redirect
 * 则这里将会获取到code,之后再可以通过code获取到access_token 进而获取到用户信息
 * 
 * @author like
 *
 */
public class WechatLoginController {

    private static Logger log = LoggerFactory.getLogger(WechatLoginController.class);
    private static final String FRONTEND="1";
    private static final String SHOPEND="2";
    @Autowired
   private PersonInfoService personInfoService;
    @Autowired
    private WechatAuthService wechatAuthService;
    @RequestMapping(value = "/logincheck", method = { RequestMethod.GET })
    public String doGet(HttpServletRequest request, HttpServletResponse response) {
        log.debug("weixin login get...");
        // 获取微信公众号传输过来的code,通过code可获取access_token,进而获取用户信息
        String code = request.getParameter("code");
        // 这个state可以用来传我们自定义的信息，方便程序调用，这里也可以不用
         String roleType = request.getParameter("state");
        log.debug("weixin login code:" + code);
        WechatUser user = null;
        String openId = null;
        WechatAuth auth=null;
        if (null != code) {
            UserAccessToken token;
            try {
                // 通过code获取access_token
                token = WechatUtil.getUserAccessToken(code);
                log.debug("weixin login token:" + token.toString());
                // 通过token获取accessToken
                String accessToken = token.getAccessToken();
                // 通过token获取openId
                openId = token.getOpenId();
                // 通过access_token和openId获取用户昵称等信息
                user = WechatUtil.getUserInfo(accessToken, openId);
                log.debug("weixin login user:" + user.toString());
                request.getSession().setAttribute("openId", openId);
                auth=wechatAuthService.getWechatAuthByOpenId(openId);
            } catch (IOException e) {
                log.error("error in getUserAccessToken or getUserInfo or findByOpenId: " + e.toString());
                e.printStackTrace();
            }
        }
        // ======todo begin======
        // 前面咱们获取到openId后，可以通过它去数据库判断该微信帐号是否在我们网站里有对应的帐号了，
        // 没有的话这里可以自动创建上，直接实现微信与咱们网站的无缝对接。
        // ======todo end======
        
     // 若微信帐号为空则需要注册微信帐号，同时注册用户信息
     		if (auth == null) {
     			PersonInfo personInfo = WechatUtil.getPersonInfoFromRequest(user);
     			auth = new WechatAuth();
     			auth.setOpenId(openId);
     			if (FRONTEND.equals(roleType)) {
     				personInfo.setUserType(1);
     			} else {
     				personInfo.setUserType(2);
     			}
     			auth.setPersonInfo(personInfo);
     			WechatAuthExecution we = wechatAuthService.register(auth);
     			if (we.getState() != WechatAuthStateEnum.SUCCESS.getState()) {
     				return null;
     			} else {
     				personInfo = personInfoService.getPersonInfoById(auth.getPersonInfo().getUserId());
     				request.getSession().setAttribute("user", personInfo);
     			}
     		} else {
     			request.getSession().setAttribute("user", auth.getPersonInfo());
     		}
     		// 若用户点击的是前端展示系统按钮则进入前端展示系统
     		if (FRONTEND.equals(roleType)) {
     			return "frontend/index";
     		} else {
     			return "shop/shoplist";
     		}
     	}
        
       
    
}
