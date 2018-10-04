package controllers;

import constants.SettingsConstant;
import org.jivesoftware.smack.*;
import org.jivesoftware.smack.packet.Message;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;
import org.jivesoftware.smack.tcp.XMPPTCPConnectionConfiguration;
import org.jxmpp.jid.DomainBareJid;
import org.jxmpp.jid.impl.JidCreate;
import org.jxmpp.stringprep.XmppStringprepException;

import java.io.IOException;

/**
 * Coded by Amdadul Bari Imad
 * Created at 4/10/18
 */
public class MsgController implements MessageListener {

    public void init(String userName, String passWord) throws XmppStringprepException {
        XMPPTCPConnectionConfiguration config;
        AbstractXMPPConnection connection;

        //Connection Configurations

        DomainBareJid serviceName = JidCreate.domainBareFrom(SettingsConstant.hostName);
        config = XMPPTCPConnectionConfiguration.builder()
                .setHost(SettingsConstant.hostName)
                .setPort(SettingsConstant.port)
                .setXmppDomain(serviceName)
                .setSecurityMode(ConnectionConfiguration.SecurityMode.disabled)
                .enableDefaultDebugger() //TODO Remove this debugging line before publishing
                .build();


        connection = new XMPPTCPConnection(config);
        try {
            connection.connect();
            System.out.println("Connection established successfully");
            connection.login(userName,passWord);
            System.out.println("Hey! Logged in successfully");

        } catch (SmackException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XMPPException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void processMessage(Message message) {

    }
}
