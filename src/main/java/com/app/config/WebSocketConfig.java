package com.app.config;

//import org.apache.catalina.session.StandardSessionFacade;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.server.standard.ServerEndpointExporter;
//
//import javax.servlet.http.HttpSession;
//import javax.websocket.HandshakeResponse;
//import javax.websocket.server.HandshakeRequest;
//import javax.websocket.server.ServerEndpointConfig;
//import javax.websocket.server.ServerEndpointConfig.Configurator;
//
//@Configuration
//public class WebSocketConfig extends Configurator {
//
//    @Override
//    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
//        /*如果没有监听器,那么这里获取到的HttpSession是null*/
//        StandardSessionFacade ssf = (StandardSessionFacade) request.getHttpSession();
//        if (ssf != null) {
//            HttpSession httpSession = (HttpSession) request.getHttpSession();
//            //关键操作
//            sec.getUserProperties().put("sessionId", httpSession.getId());
//            System.out.println("获取到的SessionID：" + httpSession.getId());
//        }
//    }
//
//
//  /*
//  @Override
//  public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
//    Session shiroSession = ShiroUtils.getSubjct().getSession();
//    sec.getUserProperties().put("sessionId", shiroSession.getId());
//  }
//  */
//
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        //Tomcat配置
//        return new ServerEndpointExporter();
//    }
//}
