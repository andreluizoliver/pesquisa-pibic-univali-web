/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.me.my.sts;

import javax.annotation.Resource;
import javax.xml.transform.Source;
import javax.xml.ws.Provider;
import javax.xml.ws.Service.Mode;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

/**
 *
 * @author andre.oliveira
 */
@WebServiceProvider(serviceName = "MySTSService", portName = "IMySTSService_Port", targetNamespace = "http://tempuri.org/", wsdlLocation = "WEB-INF/wsdl/MySTS/MySTSService.wsdl")
@ServiceMode(value = Mode.PAYLOAD)
public class MySTS extends com.sun.xml.ws.security.trust.sts.BaseSTSImpl implements Provider<Source> {
    @Resource
    WebServiceContext context;

    public Source invoke(Source rstElement) {
        return super.invoke(rstElement);
    }

    protected MessageContext getMessageContext() {
        MessageContext msgCtx = context.getMessageContext();
        return msgCtx;
    }

}
